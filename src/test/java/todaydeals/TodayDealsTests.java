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
}
