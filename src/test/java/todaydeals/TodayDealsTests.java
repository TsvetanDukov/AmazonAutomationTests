package todaydeals;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TodayDealsPage;

import static org.testng.Assert.*;

public class TodayDealsTests extends BaseTest {

    @Test
    public void verifyPageTitle() {
        assertTrue(homePage.isTodayDealsLinkDisplayed(), "Today's deals link is not displayed!");
        TodayDealsPage dealsPage = homePage.clickTodayDealsLink();
        assertEquals(dealsPage.getPageTitle(), "International Shopping: Shop special offers" +
                " and deals that ship internationally", "Page title is incorrect");
    }

    /**
     * Five tests with all available 'Sort by' options.
     */

    @Test (dataProvider = "sortByOptions")
    public void chooseDifferentSortOrder(String option) {
        TodayDealsPage dealsPage = homePage.clickTodayDealsLink();
        assertTrue(dealsPage.isSortByDisplayed(), "Sort by dropdown menu is not displayed!");
        dealsPage.selectSortByOrder(option);
    }

    @DataProvider
    public Object [] sortByOptions() {
        Object [] options = new Object[5];
        options [0] = "Featured";
        options [1] = "Price - Low to High";
        options [2] = "Price - High to Low";
        options [3] = "Discount - Low to High";
        options [4] = "Discount - High to Low";
        return options;
    }

    @Test
    public void verifyPageHeader() {
        TodayDealsPage dealsPage = homePage.clickTodayDealsLink();
        assertEquals(dealsPage.getPageHeader(), "Deals and Promotions", "Page Header is incorrect!");
    }

    @Test
    public void extendAndCollapseDepartmentMenuExpandLink() {
        TodayDealsPage dealsPage = homePage.clickTodayDealsLink();
        assertTrue(dealsPage.isExtendDepartmentLinkDisplayed(), "Extend department link is missing!");
        dealsPage.clickExtendDepartmentLink();
        assertEquals(dealsPage.departmentLinkIsExtended(), "See less Department",
                "Department link is not extended!");
        dealsPage.clickExtendDepartmentLink();
        assertEquals(dealsPage.departmentLinkIsFolded(), "See more Department",
                "Department link is not folded!");

    }

    @Test
    public void testAvailabilityCheckboxes() {
        TodayDealsPage dealsPage = homePage.clickTodayDealsLink();
        assertEquals(dealsPage.availabilityHeader(), "Availability",
                "Availability header is incorrect");
        assertTrue(dealsPage.isActiveCheckboxDisplayed(), "Active checkbox is not displayed!");
        assertTrue(dealsPage.isUpcomingCheckboxDisplayed(), "Upcoming checkbox is not displayed!");
        assertTrue(dealsPage.isMissedCheckboxDisplayed(), "Missed checkbox is not displayed!");
        //By default all check boxes are selected!
        dealsPage.clickActiveCheckbox();
        dealsPage.clickUpcomingCheckbox();
        dealsPage.clickMissedCheckbox();
        //Check that all checkboxes are unselected!
        assertFalse(dealsPage.isActiveCheckboxUnselected(), "Active checkbox is selected!");
        assertFalse(dealsPage.isUpcomingCheckboxUnselected(), "Upcoming checkbox is selected!");
        assertFalse(dealsPage.isMissedCheckboxUnselected(), "Missed checkbox is selected!");
    }
    @Test
    public void testAvailabilityClearButton() {
        TodayDealsPage dealsPage = homePage.clickTodayDealsLink();
        assertTrue(dealsPage.isClearButtonDisplayed(), "Clear button is not displayed!");
        dealsPage.clickAvailabilityClearButton();
        //Verify all checkboxes are unselected!
        assertFalse(dealsPage.isActiveCheckboxUnselected(), "Active checkbox is selected!");
        assertFalse(dealsPage.isUpcomingCheckboxUnselected(), "Upcoming checkbox is selected!");
        assertFalse(dealsPage.isMissedCheckboxUnselected(), "Missed checkbox is selected!");
    }

    @Test
    public void testRandomProductWithoutRegistration() {
        TodayDealsPage dealsPage = homePage.clickTodayDealsLink();
        dealsPage.clickRandomProduct();
    }
}
