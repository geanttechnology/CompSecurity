// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import android.support.v4.app.Fragment;
import com.target.ui.fragment.account.AccountCreateFragment;
import com.target.ui.fragment.account.AccountLoginFragment;
import com.target.ui.fragment.account.AccountManagementFragment;
import com.target.ui.fragment.account.AccountProfileFragment;
import com.target.ui.fragment.list.ListDetailFragment;
import com.target.ui.fragment.map.StoreMapFragment;
import com.target.ui.fragment.mcoupons.CouponDetailFragment;
import com.target.ui.fragment.mcoupons.CouponListFragment;
import com.target.ui.fragment.mcoupons.CouponsEntryFragment;
import com.target.ui.fragment.mcoupons.CouponsVerificationFragment;
import com.target.ui.fragment.navigation.NavigationDrawerFragment;
import com.target.ui.fragment.product.clp.CollectionsListPageFragment;
import com.target.ui.fragment.product.dialog.ProductFiatsDialogFragment;
import com.target.ui.fragment.product.dialog.ProductPickUpDialogFragment;
import com.target.ui.fragment.product.dialog.ProductShipItDialogFragment;
import com.target.ui.fragment.product.pdp.ProductDetailsPageFragment;
import com.target.ui.fragment.product.plp.ProductSummaryPageFragment;
import com.target.ui.fragment.product.reviews.ProductReadReviewFragment;
import com.target.ui.fragment.registry.RegistryAdvancedSearchPageFragment;
import com.target.ui.fragment.registry.RegistryLandingPageFragment;
import com.target.ui.fragment.registry.RegistrySearchSummaryPageFragment;
import com.target.ui.fragment.scan.ScanGiftCardFragment;
import com.target.ui.fragment.shop.CategoriesPageItemFragment;
import com.target.ui.fragment.shop.ChildPageItemFragment;
import com.target.ui.fragment.shop.DealsFragment;
import com.target.ui.fragment.shop.DealsPageItemFragment;
import com.target.ui.fragment.shop.FeaturedPageItemFragment;
import com.target.ui.fragment.shop.PageItemCustomActionDialogFragment;
import com.target.ui.fragment.shop.ShopHomeFragment;
import com.target.ui.fragment.store.StoreChooserDialogFragment;
import com.target.ui.fragment.weekly_ad.WeeklyAdFragment;
import com.target.ui.util.q;

// Referenced classes of package com.target.ui.analytics.a:
//            s

final class t extends Enum
{

    private static final t $VALUES[];
    public static final t AccountLogin;
    public static final t AccountView;
    public static final t AddToCartDialog;
    public static final t Categories;
    public static final t Deals;
    public static final t Featured;
    public static final t FeaturedDeals;
    public static final t FeaturedMiscDialog;
    public static final t FindAStore;
    public static final t FindInAnotherTargetStore;
    public static final t GiftCards;
    public static final t LeftNav;
    public static final t List;
    public static final t MobileCouponEntry;
    public static final t MobileCouponHome;
    public static final t MobileCouponList;
    public static final t MobileCouponSignUp;
    public static final t ProductDetails;
    public static final t ProductListing;
    public static final t Profile;
    public static final t RegistryAdvancedSearch;
    public static final t RegistryHome;
    public static final t RegistrySearch;
    public static final t Reviews;
    public static final t StoreMap;
    private static final String TAG = com/target/ui/analytics/a/t.getName();
    public static final t Unknown;
    public static final t WeeklyAd;
    private Class mClass[];
    private s mScreen;

    private transient t(String s1, int i, s s2, Class aclass[])
    {
        super(s1, i);
        mScreen = s2;
        mClass = aclass;
    }

    public static s a(Class class1)
    {
        t at[] = values();
        int k = at.length;
        for (int i = 0; i < k; i++)
        {
            t t1 = at[i];
            Class aclass[] = t1.mClass;
            int l = aclass.length;
            for (int j = 0; j < l; j++)
            {
                if (aclass[j] == class1)
                {
                    return t1.mScreen;
                }
            }

        }

        q.c(TAG, (new StringBuilder()).append("unable to identify Screen from fragment class ").append(class1.getSimpleName()).toString());
        return s.Unknown;
    }

    public static t valueOf(String s1)
    {
        return (t)Enum.valueOf(com/target/ui/analytics/a/t, s1);
    }

    public static t[] values()
    {
        return (t[])$VALUES.clone();
    }

    static 
    {
        AccountLogin = new t("AccountLogin", 0, s.AccountLogin, new Class[] {
            com/target/ui/fragment/account/AccountLoginFragment, com/target/ui/fragment/account/AccountCreateFragment
        });
        AccountView = new t("AccountView", 1, s.AccountEdit, new Class[] {
            com/target/ui/fragment/account/AccountManagementFragment
        });
        AddToCartDialog = new t("AddToCartDialog", 2, s.AddToCartDialog, new Class[] {
            com/target/ui/fragment/product/dialog/ProductPickUpDialogFragment, com/target/ui/fragment/product/dialog/ProductShipItDialogFragment
        });
        Categories = new t("Categories", 3, s.Categories, new Class[] {
            com/target/ui/fragment/shop/CategoriesPageItemFragment, com/target/ui/fragment/shop/ChildPageItemFragment
        });
        Deals = new t("Deals", 4, s.Deals, new Class[] {
            com/target/ui/fragment/shop/DealsFragment
        });
        Featured = new t("Featured", 5, s.Featured, new Class[] {
            com/target/ui/fragment/shop/FeaturedPageItemFragment, com/target/ui/fragment/shop/ShopHomeFragment
        });
        FeaturedDeals = new t("FeaturedDeals", 6, s.GetLocalDeals, new Class[] {
            com/target/ui/fragment/shop/DealsPageItemFragment
        });
        FeaturedMiscDialog = new t("FeaturedMiscDialog", 7, s.FeaturedMiscDialog, new Class[] {
            com/target/ui/fragment/shop/PageItemCustomActionDialogFragment
        });
        FindAStore = new t("FindAStore", 8, s.FindAStore, new Class[] {
            com/target/ui/fragment/store/StoreChooserDialogFragment
        });
        FindInAnotherTargetStore = new t("FindInAnotherTargetStore", 9, s.FindInAnotherTargetStore, new Class[] {
            com/target/ui/fragment/product/dialog/ProductFiatsDialogFragment
        });
        LeftNav = new t("LeftNav", 10, s.LeftNav, new Class[] {
            com/target/ui/fragment/navigation/NavigationDrawerFragment
        });
        List = new t("List", 11, s.List, new Class[] {
            com/target/ui/fragment/list/ListDetailFragment
        });
        MobileCouponEntry = new t("MobileCouponEntry", 12, s.MobileCouponEntry, new Class[] {
            com/target/ui/fragment/mcoupons/CouponsEntryFragment
        });
        MobileCouponSignUp = new t("MobileCouponSignUp", 13, s.MobileCouponSignUp, new Class[] {
            com/target/ui/fragment/mcoupons/CouponsVerificationFragment
        });
        MobileCouponHome = new t("MobileCouponHome", 14, s.MobileCouponHome, new Class[] {
            com/target/ui/fragment/mcoupons/CouponDetailFragment
        });
        MobileCouponList = new t("MobileCouponList", 15, s.MobileCouponList, new Class[] {
            com/target/ui/fragment/mcoupons/CouponListFragment
        });
        ProductDetails = new t("ProductDetails", 16, s.ProductDetails, new Class[] {
            com/target/ui/fragment/product/pdp/ProductDetailsPageFragment
        });
        ProductListing = new t("ProductListing", 17, s.ProductListing, new Class[] {
            com/target/ui/fragment/product/plp/ProductSummaryPageFragment, com/target/ui/fragment/product/clp/CollectionsListPageFragment
        });
        Reviews = new t("Reviews", 18, s.Reviews, new Class[] {
            com/target/ui/fragment/product/reviews/ProductReadReviewFragment
        });
        StoreMap = new t("StoreMap", 19, s.StoreMap, new Class[] {
            com/target/ui/fragment/map/StoreMapFragment
        });
        WeeklyAd = new t("WeeklyAd", 20, s.WeeklyAd, new Class[] {
            com/target/ui/fragment/weekly_ad/WeeklyAdFragment
        });
        Profile = new t("Profile", 21, s.Profile, new Class[] {
            com/target/ui/fragment/account/AccountProfileFragment
        });
        GiftCards = new t("GiftCards", 22, s.AccountGiftCards, new Class[] {
            com/target/ui/fragment/scan/ScanGiftCardFragment
        });
        RegistryHome = new t("RegistryHome", 23, s.RegistryHome, new Class[] {
            com/target/ui/fragment/registry/RegistrySearchSummaryPageFragment
        });
        RegistryAdvancedSearch = new t("RegistryAdvancedSearch", 24, s.RegistryAdvancedSearch, new Class[] {
            com/target/ui/fragment/registry/RegistryAdvancedSearchPageFragment
        });
        RegistrySearch = new t("RegistrySearch", 25, s.RegistrySearch, new Class[] {
            com/target/ui/fragment/registry/RegistryLandingPageFragment
        });
        Unknown = new t("Unknown", 26, s.Unknown, new Class[] {
            android/support/v4/app/Fragment
        });
        $VALUES = (new t[] {
            AccountLogin, AccountView, AddToCartDialog, Categories, Deals, Featured, FeaturedDeals, FeaturedMiscDialog, FindAStore, FindInAnotherTargetStore, 
            LeftNav, List, MobileCouponEntry, MobileCouponSignUp, MobileCouponHome, MobileCouponList, ProductDetails, ProductListing, Reviews, StoreMap, 
            WeeklyAd, Profile, GiftCards, RegistryHome, RegistryAdvancedSearch, RegistrySearch, Unknown
        });
    }
}
