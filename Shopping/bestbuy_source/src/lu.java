// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Context;
import com.adobe.mobile.Analytics;
import com.adobe.mobile.Config;
import java.util.HashMap;

public class lu
{

    public static String A = "LifeEvents: List Landing Page";
    public static String B = "Add to Wish List";
    public static String C = "Add to Registry";
    public static String D = "Products";
    public static String E = "Store Locator";
    public static String F = "Checkout: Cart \u2013 Empty";
    public static String G = "Checkout: Cart \u2013 Empty";
    public static String H = "Checkout: Guest: Checkout - Thank You";
    public static String I = "Checkout: Registered: Checkout - Thank You";
    public static String J = "Add to Cart";
    public static String K = "LifeEvents: List Creation";
    public static String L = "LifeEvents: Full List - ";
    public static String M = "LifeEvents: Name List - ";
    public static String N = "LifeEvents: Public/Private List - ";
    public static String O = "LifeEvents: Personalize List - ";
    public static String P = "LifeEvents: Add an Address - ";
    public static String Q = "LifeEvents: Delete List";
    public static String R = "LifeEvents: Search Product";
    public static String S = "LifeEvents: Browse Product";
    public static String T = "LifeEvents: Product Scan";
    public static String U = "LifeEvents: Scan History";
    public static String V = "LifeEvents: Best Buy Gift Ideas";
    public static String W = "LifeEvents: WishList: Search Using ListID";
    public static String X = "LifeEvents: WishList: Search Using First/Last Name";
    public static String Y = "HomeSearchCriteria";
    public static String Z = "MoreDealsTappedOn";
    public static String a = "Best Buy";
    public static String aA = "LifeEvents: Wedding Registry: Need Inspiration";
    public static String aB = "LifeEvents: Wedding Registry: Search Product";
    public static String aC = "LifeEvents: Wedding Registry: Browse Product";
    public static String aD = "LifeEvents: Wedding Registry: Product Scan";
    public static String aE = "LifeEvents: Wedding Registry: Scan History";
    public static String aF = "LifeEvents: Wedding Registry: Search Using ListID";
    public static String aG = "LifeEvents: Wedding Registry: Search Using First/Last Name";
    public static String aH = "LifeEvents: Wedding Registry: List Creation: Full List";
    public static String aI = "Blue Assist: Something Else";
    public static String aJ = "Blue Assist: Something Else: Call";
    public static String aK = "Blue Assist: Something Else: Email";
    public static String aL = "Blue Assist: Make Appt \u2013 Select Department";
    public static String aM = "Blue Assist: Make Appt - Store List";
    public static String aN = "Blue Assist: Make Appt - Error";
    public static String aO = "Blue Assist: Make Appt - Map";
    public static String aP = "Blue Assist: Make Appt - Date/Time";
    public static String aQ = "Blue Assist: Make Appt - Contact Info";
    public static String aR = "Make Appt - Confirmation";
    public static String aS = "Make Appt - Cancel";
    public static String aT = "Blue Assist";
    public static String aU = "Blue Assist: Chat";
    public static String aV = "Blue Assist: Purchasing a Product";
    public static String aW = "Blue Assist: Purchasing a Product: Call";
    public static String aX = "Blue Assist: Purchasing a Product: Chat";
    public static String aY = "Blue Assist: Purchasing a Product: Make Appt";
    public static String aZ = "Blue Assist: Existing Order";
    public static String aa = "StoresSearchTerm";
    public static String ab = "MyBBYProductsInViewReceipt";
    public static String ac = "ProductsFilterSortSelection";
    public static String ad = "StoreSelectionTapped";
    public static String ae = "StoresListViewTapped";
    public static String af = "StoresMapViewTapped";
    public static String ag = "StoresMapMarkersTapped";
    public static String ah = "GeoLocationClicked";
    public static String ai = "MyBBYBenefitsButtonTapped";
    public static String aj = "MyBBYSignOutTapped";
    public static String ak = "MyBBYRewardsTapped";
    public static String al = "MyBBYPurchasesTapped";
    public static String am = "PDPReviewsLinkTapped";
    public static String an = "PDPColorTabTapped";
    public static String ao = "ProductAccessoriesTapped";
    public static String ap = "AddToCartTapped";
    public static String aq = "PDPCardHolderOffersTapped";
    public static String ar = "PDPSpecialOffersTapped";
    public static String as = "Best Buy: Primary Message";
    public static String at = "LifeEvents: Wedding Registry: Delete Registry";
    public static String au = "LifeEvents: Wedding Registry: List Creation: Name";
    public static String av = "LifeEvents: Wedding Registry: List Creation: Add a Date";
    public static String aw = "LifeEvents: Wedding Registry: List Creation: Shipping Address";
    public static String ax = "LifeEvents: Wedding Registry: List Creation: Public/Private List";
    public static String ay = "LifeEvents: Wedding Registry: List Creation: Personalize Your Registry";
    public static String az = "LifeEvents: Wedding Registry: List Creation: Manage List";
    public static String b = "HomeSearch";
    public static String ba = "Blue Assist: Existing Order: All Other Categories: Chat";
    public static String bb = "Blue Assist: Existing Order: ";
    public static String bc = "Create Wish List";
    public static String bd = "Create a Registry";
    public static String be = "Add To > Create Wish List";
    public static String bf = "Add To > Create a Registry";
    public static String bg = "Best Buy: Deals_Panel ";
    public static String bh = "Best Buy: Deals Hub";
    public static String bi = "Best Buy: PM_Panel ";
    public static String bj = "Store Availability: Store Details";
    public static String bk = "Store Availability: Change Store";
    public static String bl = ": ";
    public static String bm = "Store Availability";
    public static String bn = ": Faceted";
    public static String bo = "bb.pageType";
    public static String bp = "bb.templateName";
    public static String bq = "bb.prevPageLink";
    public static String br = "bb.storeAvail";
    public static String c = "Best Buy";
    public static String d = "Search Results: No Results";
    public static String e = "Search Results";
    public static String f = "Search Results: Faceted";
    public static String g = "More";
    public static String h = "Order Status";
    public static String i = "Phone Upgrade";
    public static String j = "Trade-In Center";
    public static String k = "Product Recalls";
    public static String l = "Product Scan";
    public static String m = "Gift Card Balance";
    public static String n = "Best Buy Credit Card";
    public static String o = "Contact";
    public static String p = "Store Locator";
    public static String q = "Notifications";
    public static String r = "App Settings";
    public static String s = "PrivacyTerms&Conditions";
    public static String t = "Mobile Devices";
    public static String u = "Submit Feedback";
    public static String v = "My Account: Sign In";
    public static String w = "My Account: Guest: Create an Account";
    public static String x = "My Account: Sign In Forgot Password";
    public static String y = "LifeEvents: Manage List \u2013";
    public static String z = "LifeEvents: My Lists Dashboard";

    public static void a()
    {
        Config.pauseCollectingLifecycleData();
    }

    public static void a(Activity activity)
    {
        Config.collectLifecycleData();
    }

    public static void a(Context context)
    {
        Config.setContext(context);
        Config.setDebugLogging(Boolean.valueOf(true));
    }

    public static void a(String s1)
    {
        Analytics.trackState(s1, null);
    }

    public static void a(String s1, HashMap hashmap)
    {
        Analytics.trackAction(s1, hashmap);
    }

    public static void b(String s1, HashMap hashmap)
    {
        Analytics.trackState(s1, hashmap);
    }

}
