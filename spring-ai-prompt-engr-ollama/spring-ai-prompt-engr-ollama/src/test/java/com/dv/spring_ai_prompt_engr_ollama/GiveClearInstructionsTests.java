package com.dv.spring_ai_prompt_engr_ollama;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
public class GiveClearInstructionsTests extends  BaseTestClass {

    @Test
    void testGetJson() {
        String prompt = """
                Generate a list 4 made up cars. Provide them in a 
                JSON format with following attributed: make, model, year, and color.
                Return the JSON string 
                """;
        System.out.println(chat(prompt));
    }

    @Test
    void testGetXml() {
        String prompt = """
                Generate a list 4 made up cars. Provide them in a 
                XML format with following attributed: make, model, year, and color.
                Return the XML string 
                """;
        System.out.println(chat(prompt));
    }

    @Test
    void testGetYaml() {
        String prompt = """
                Generate a list 4 made up cars. Provide them in a 
                YAML format with following attributed: make, model, year, and color.
                Return the YAML string 
                """;
        System.out.println(chat(prompt));
    }

    //ask the model to check if conditions are satisfied
    String directionsPrompt = """
            You will be provided with text delimited by triple quotes.
            ONLY IF contains a SEQUENCE OF INSTRUCTIONS,
            re-write those instructions in the following format:
                        
            Step 1 - ...
            Step 2 - ...
            Step N - ...
                        
            If the text does NOT contain a SEQUENCE OF INSTRUCTIONS, then simply write \\"No steps provided.\\"
                        
            \\"\\"\\"{text_1}\\"\\"\\"
            """;

    String cookASteak = """
        Cooking the perfect steak is easy.
        First, remove the steak from the refrigerator and packaging. Let sit at
        room temperature for at least 30 mins.
        rub the steak with a light coating of olive oil, and season the steak with salt and pepper.
        Next, heat a pan over high heat.
        Then, add the steak to the pan and sear for 3 minutes on each side.
        Finally, let the steak rest for 5 minutes before slicing.
        Enjoy!""";

    String bookDescription = """
            Book Elon Musk
            When Elon Musk was a kid in South Africa, he was regularly beaten by bullies. One day a group pushed him down some concrete steps and kicked him until his face was a swollen ball of flesh. He was in the hospital for a week. But the physical scars were minor compared to the emotional ones inflicted by his father, an engineer, rogue, and charismatic fantasist.
                        
            His father’s impact on his psyche would linger. He developed into a tough yet vulnerable man-child, prone to abrupt Jekyll-and-Hyde mood swings, with an exceedingly high tolerance for risk, a craving for drama, an epic sense of mission, and a maniacal intensity that was callous and at times destructive.
                        
            At the beginning of 2022—after a year marked by SpaceX launching thirty-one rockets into orbit, Tesla selling a million cars, and him becoming the richest man on earth—Musk spoke ruefully about his compulsion to stir up dramas. “I need to shift my mindset away from being in crisis mode, which it has been for about fourteen years now, or arguably most of my life,” he said.""";

    @Test
    void testCookSteak() {
        PromptTemplate promptTemplate = new PromptTemplate(directionsPrompt);

        System.out.println(chatmodel.call(promptTemplate.create(Map.of("text_1", cookASteak))).getResult().getOutput().getText());
    }

    //gemma3 fail! it still writes as steps where there are none in the book description
    @Test
    void testBookDescription() {
        PromptTemplate promptTemplate = new PromptTemplate(directionsPrompt);

        System.out.println(chatmodel.call(promptTemplate.create(Map.of("text_1", bookDescription))).getResult().getOutput().getText());
    }

    @Test
    void testCookSteakAsSnoopDog() {
        PromptTemplate promptTemplate = new PromptTemplate(directionsPrompt
                + " Give the directions using the tone of Snoop Dog");

        System.out.println(chatmodel.call(promptTemplate.create(Map.of("text_1", cookASteak))).getResult().getOutput().getText());
    }

    @Test
    void testCookSteakAsHarryPotter() {
        PromptTemplate promptTemplate = new PromptTemplate(directionsPrompt
                + "Give the directions using the tone, tools and imagination of JK Rowling in a Harry Potter book");

        System.out.println(chatmodel.call(promptTemplate.create(Map.of("text_1", cookASteak))).getResult().getOutput().getText());
    }
    /***
     *
     * J K Rowling output
     Right then, let's have a look at this, shall we? A truly magnificent beast of a steak – and one that requires a touch of careful magic, of course.

     Step 1 - First, you must liberate your steak from its chilly prison.  Remove it, with a steady hand and a whispered apology to the chilled depths, from its packaging.  It needs a moment to awaken, to greet the warmth of the room – at least thirty minutes, mind you. Think of it as a brief spell of acclimatization, vital for a truly robust flavour.

     Step 2 - Next, a touch of enchantment – a light coating of olive oil. Rub it across the surface of the steak, as if imbuing it with a shimmering protection against the heat.  Don’t be shy; a generous, though delicate, layer is key.

     Step 3 - Now, the seasoning! A pinch of salt, a whisper of pepper – a simple yet potent charm.  Imagine you’re dusting it with fairy dust, concentrating the flavours within.

     Step 4 - The heat, ah yes. A pan, heated over high flames – imagine a dragon's breath! Add the steak, and sear it for precisely three minutes on each side.  Observe it closely; a truly skilled wizard will notice the changes in colour, the way the juices begin to caramelise.

     Step 5 - Finally, and this is absolutely crucial, allow the steak to rest. Five minutes, precisely. It needs this time to gather its strength, to mend its sizzling wounds. During this time, you can brew a calming tea, perhaps a Lavender Dream, or simply contemplate the magnificent creation you have wrought.

     Enjoy, my dear, and may your appetite be as boundless as the wizarding world itself!
     */

}
