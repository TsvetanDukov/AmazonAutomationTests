package giftcards;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.GiftCardsPage;

import static org.testng.Assert.*;

public class GiftCardsTests extends BaseTest {

    @Test
    public void testEventsAndCelebrationSection() {
        GiftCardsPage cardsPage = homePage.clickGiftCardsLink();
        assertTrue(cardsPage.isEventsAndCelebrationSectionDisplayed(),
                "Events & Celebration section is not displayed!");
        //Th is section is expanded by default, so we will shrink it with our action
        cardsPage.expandEventsSection();
        //Expand it again to check what links are present in this section
        cardsPage.expandEventsSection();
        cardsPage.openEventsSectionLinksInNewTab();
        //Iterate through all windows and verify page titles
        cardsPage.getLinksPageTitles();
    }

    @Test
    public void testSpecialFeaturesSection() {
        GiftCardsPage cardsPage = homePage.clickGiftCardsLink();
        assertTrue(cardsPage.isSpecialFeaturesSectionDisplayed(),
                "Special features section is not displayed!");
        cardsPage.expandEventsSection();
        cardsPage.expandSpecialFeaturesSection();
        cardsPage.openSpecialFeaturesLinksInNewTab();
        //Not finished
    }
}
