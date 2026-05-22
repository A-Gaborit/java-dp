package org.sebsy.factory;

import junit.framework.TestCase;
import org.junit.Test;

public class FactoryTest extends TestCase {

    @Test
    public void testCreateIngredient() {
        Element element = ElementFactory.createElement(ElementType.INGREDIENT, "Farine", 50.0, Unite.MILLI_GRAMMES);
        assertNotNull(element);
        assertTrue(element instanceof Ingredient);
    }

    @Test
    public void testIngredientAttributes() {
        Element element = ElementFactory.createElement(ElementType.INGREDIENT, "Sucre", 10.5, Unite.MICRO_GRAMMES);
        assertEquals("Sucre", element.getNom());
        assertEquals(10.5, element.getValeur());
        assertEquals(Unite.MICRO_GRAMMES, element.getUnite());
    }

    @Test
    public void testCreateAllergene() {
        Element element = ElementFactory.createElement(ElementType.ALLERGENE, "Gluten", 5.0, Unite.MILLI_GRAMMES);
        assertNotNull(element);
        assertTrue(element instanceof Allergene);
    }

    @Test
    public void testAllergeneAttributes() {
        Element element = ElementFactory.createElement(ElementType.ALLERGENE, "Lactose", 2.0, Unite.MICRO_GRAMMES);
        assertEquals("Lactose", element.getNom());
        assertEquals(2.0, element.getValeur());
        assertEquals(Unite.MICRO_GRAMMES, element.getUnite());
    }

    @Test
    public void testCreateAdditif() {
        Element element = ElementFactory.createElement(ElementType.ADDITIF, "E250", 0.5, Unite.MICRO_GRAMMES);
        assertNotNull(element);
        assertTrue(element instanceof Additif);
    }

    @Test
    public void testAdditifAttributes() {
        Element element = ElementFactory.createElement(ElementType.ADDITIF, "E471", 1.2, Unite.MILLI_GRAMMES);
        assertEquals("E471", element.getNom());
        assertEquals(1.2, element.getValeur());
        assertEquals(Unite.MILLI_GRAMMES, element.getUnite());
    }

    @Test
    public void testIngredientIsNotAllergene() {
        Element element = ElementFactory.createElement(ElementType.INGREDIENT, "Poivre", 1.0, Unite.MILLI_GRAMMES);
        assertFalse(element instanceof Allergene);
    }

    @Test
    public void testAllergeneIsNotAdditif() {
        Element element = ElementFactory.createElement(ElementType.ALLERGENE, "Noix", 0.5, Unite.MICRO_GRAMMES);
        assertFalse(element instanceof Additif);
    }
}