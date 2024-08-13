import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//public class TestJerkSONParser {
//
//    private JerkSONParser itemParser;
//
//    @BeforeEach
//    void setUp() {
//        itemParser = new JerkSONParser();
//    }
//
//    @Test
//    public void testStringSplitter() throws Exception {
//        // Given
//
//        // When
//        String[] actualParts = itemParser.splitData(rawData);
//
//        // Then
//        assertEquals(expectedParts[0], actualParts[0]);
//    }
//
//    @Test
//    public void testItemCounter() throws Exception {
            //Given
//
//        // When
//        String actual = itemParser.itemCounter("Milk");
//
//        // Then
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testNameCleanup() throws Exception {
//        // Given
//        itemParser.createItem(rawData);
//        String expectedName = "Milk";
//
//        // When
//        String actualName = itemParser.getListOfItems().get(0).getName();
//
//        // Then
//        assertEquals(expectedName, actualName);
//    }
//
//    @Test
//    public void testFindItemFieldException() {
//        // Given
//
//        // When & Then
//        assertThrows(Exception.class, () -> itemParser.findItemField(rawData, 1));
//    }
//
//
//    @Test
//    public void testAddItemToList() throws Exception {
//        // Given
//        int expectedLength = 1;
//
//        // When
//        itemParser.addItemToList("Milk", 1.23, "Food", "1/25/2016");
//        int actualLength = itemParser.getListOfItems().size();
//
//        // Then
//        assertEquals(expectedLength, actualLength);
//    }
//
//    @Test
//    public void testFindItemField() throws Exception {
//        // Given
//        String expected = "Bread";
//
//        // When
//        String actual = itemParser.findItemField(rawData, 1);
//
//        // Then
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testGroceryListConstructor() throws Exception {
//        // Given
//
//        // When
//        itemParser.createItem(rawData);
//        String actual = itemParser.groceryListConstructor();
//
//        // Then
//        assertEquals(expected, actual);
//    }
//}
//
//
