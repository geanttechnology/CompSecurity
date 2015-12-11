// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.bestbuy.android.activities.appsettings.AppSettingsEnvironmentFragment;
import com.bestbuy.android.activities.appsettings.AppSettingsFragment;
import com.bestbuy.android.activities.appsettings.NotificationsFragment;
import com.bestbuy.android.activities.browseproduct.BrowseCategoryFragment;
import com.bestbuy.android.activities.browseproduct.NoSearchResultFragment;
import com.bestbuy.android.activities.browseproduct.ProductAvailabilityFragment;
import com.bestbuy.android.activities.browseproduct.pdp.EmptyFragment;
import com.bestbuy.android.activities.browseproduct.pdp.PDPAccessoriesFragment;
import com.bestbuy.android.activities.browseproduct.pdp.PDPAvailabilityFragment;
import com.bestbuy.android.activities.browseproduct.pdp.PDPCustomerAlsoBoughtFragment;
import com.bestbuy.android.activities.browseproduct.pdp.PDPCustomerAlsoViewedFragment;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFooterFragment;
import com.bestbuy.android.activities.browseproduct.pdp.PDPImageGalleryFragment;
import com.bestbuy.android.activities.browseproduct.pdp.PDPOptionFragment;
import com.bestbuy.android.activities.browseproduct.pdp.PDPOverviewFragment;
import com.bestbuy.android.activities.browseproduct.pdp.PDPPriceBlockFragment;
import com.bestbuy.android.activities.browseproduct.pdp.PDPRequiredAccessoriesFragment;
import com.bestbuy.android.activities.browseproduct.pdp.PDPReviewAndRatingsFragment;
import com.bestbuy.android.activities.browseproduct.pdp.PDPSkuAndTitleFragment;
import com.bestbuy.android.activities.browseproduct.pdp.PDPSourceDetailFragment;
import com.bestbuy.android.activities.contactdetails.ContactBestBuyFragment;
import com.bestbuy.android.activities.dnm.DNMListFragmentContainer;
import com.bestbuy.android.activities.home.ContactHomeCard;
import com.bestbuy.android.activities.home.DODHomeCard;
import com.bestbuy.android.activities.home.DealsHomeCard;
import com.bestbuy.android.activities.home.GHPBannersHomeCard;
import com.bestbuy.android.activities.home.HomeTabFragment;
import com.bestbuy.android.activities.home.MyBBYHomeCard;
import com.bestbuy.android.activities.home.TrendingHomeCardFragment;
import com.bestbuy.android.activities.home.WeeklyVideoCardFragment;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.activities.privacyandterms.PrivacyTermsFragment;
import com.bestbuy.android.activities.recentlyviewed.RecentlyViewedHomeCard;
import com.bestbuy.android.activities.stores.StoreSearchMapFragment;
import com.bestbuy.android.api.lib.models.dnm.DNMProduct;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.api.lib.models.pdp.PDPOverviewResponse;
import com.bestbuy.android.api.lib.models.store.BBYStore;
import com.bestbuy.android.base.BBYBaseFragment;
import java.util.HashMap;

public class kb
{

    public static BBYBaseFragment a(String s)
    {
        if ("MdotWebFragment".equals(s))
        {
            return new MdotWebFragment();
        }
        if ("BrowseCategoryFragment".equals(s))
        {
            return new BrowseCategoryFragment();
        }
        if ("HomeTabFragment".equals(s))
        {
            return new HomeTabFragment();
        }
        if ("MyBBY".equals(s))
        {
            return new MyBBYHomeCard();
        }
        if ("GHPBanners".equals(s))
        {
            return new GHPBannersHomeCard();
        }
        if ("DOD".equals(s))
        {
            return new DODHomeCard();
        }
        if ("Deals".equals(s))
        {
            return new DealsHomeCard();
        }
        if ("Trending".equals(s))
        {
            return new TrendingHomeCardFragment();
        }
        if ("RecentlyViewed".equals(s))
        {
            return new RecentlyViewedHomeCard();
        }
        if ("Contact".equals(s))
        {
            return new ContactHomeCard("Contact");
        }
        if ("AppSettingsFragment".equals(s))
        {
            return new AppSettingsFragment();
        }
        if ("ContactBestBuyFragment".equals(s))
        {
            return new ContactBestBuyFragment();
        }
        if ("PrivacyTermsFragment".equals(s))
        {
            return new PrivacyTermsFragment();
        }
        if ("WeeklyVideoCardFragment".equals(s))
        {
            return new WeeklyVideoCardFragment();
        }
        if ("StoreSearchMapFragment".equals(s))
        {
            return new StoreSearchMapFragment();
        }
        if ("AppSettingsEnvironmentFragment".equals(s))
        {
            return new AppSettingsEnvironmentFragment();
        }
        if ("NoSearchResultFragment".equals(s))
        {
            return new NoSearchResultFragment();
        }
        if ("NotificationsFragment".equals(s))
        {
            s = new HashMap();
            s.put(lu.bo, "browse,service");
            s.put(lu.bp, "SERV");
            lu.b(lu.q, s);
            return new NotificationsFragment();
        } else
        {
            throw new RuntimeException((new StringBuilder()).append("unknown fragment ").append(s).toString());
        }
    }

    public static BBYBaseFragment a(String s, PDPOverviewResponse pdpoverviewresponse, OverviewResponse overviewresponse, DNMProduct dnmproduct, boolean flag)
    {
        if ("PDPSkuAndTitleFragment".equals(s))
        {
            return new PDPSkuAndTitleFragment(overviewresponse, dnmproduct, flag);
        }
        if ("PDPSourceDetailFragment".equals(s))
        {
            return new PDPSourceDetailFragment(overviewresponse, dnmproduct, pdpoverviewresponse);
        }
        if ("PDPImageGalleryFragment".equals(s))
        {
            return new PDPImageGalleryFragment(overviewresponse);
        }
        if ("PDPPriceBlockFragment".equals(s))
        {
            return new PDPPriceBlockFragment(overviewresponse, dnmproduct, flag, pdpoverviewresponse);
        }
        if ("PDPOptionFragment".equals(s))
        {
            return new PDPOptionFragment(overviewresponse);
        }
        if ("PDPAvailabilityFragment".equals(s))
        {
            return new PDPAvailabilityFragment(overviewresponse, dnmproduct);
        }
        if ("ProductAvailabilityFragment".equals(s))
        {
            return new ProductAvailabilityFragment(overviewresponse);
        }
        if ("PDPReviewAndRatingsFragment".equals(s))
        {
            return new PDPReviewAndRatingsFragment(overviewresponse, dnmproduct, pdpoverviewresponse);
        }
        if ("PDPAccessoriesFragment".equals(s))
        {
            return new PDPAccessoriesFragment(overviewresponse);
        }
        if ("PDPRequiredAccessoriesFragment".equals(s))
        {
            return new PDPRequiredAccessoriesFragment(overviewresponse);
        }
        if ("PDPCustomerAlsoBoughtFragment".equals(s))
        {
            return new PDPCustomerAlsoBoughtFragment(overviewresponse);
        }
        if ("PDPCustomerAlsoViewedFragment".equals(s))
        {
            return new PDPCustomerAlsoViewedFragment(overviewresponse);
        }
        if ("PDPFooterFragment".equals(s))
        {
            return new PDPFooterFragment(overviewresponse);
        }
        if ("EmptyFragment".equals(s))
        {
            return new EmptyFragment(null);
        }
        if ("PDPOverviewFragment".equals(s))
        {
            return new PDPOverviewFragment(overviewresponse);
        } else
        {
            throw new RuntimeException((new StringBuilder()).append("unknown fragment ").append(s).toString());
        }
    }

    public static BBYBaseFragment a(String s, String s1, BBYStore bbystore)
    {
        if ("OpenBoxListFragmentContainer".equals(s))
        {
            return new DNMListFragmentContainer(s1, bbystore);
        } else
        {
            throw new RuntimeException((new StringBuilder()).append("unknown fragment ").append(s).toString());
        }
    }
}
