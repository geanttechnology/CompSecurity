// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.abtest;

import com.groupon.models.Place;
import com.groupon.models.country.Country;
import com.groupon.models.division.Division;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.DivisionUtil;
import com.groupon.util.GeoPoint;
import com.groupon.util.SecurityUtil;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.abtest:
//            SearchAbTestHelper

public class RapiAbTestHelper
{

    public static final String BEAUTY_AND_SPAS_BOOKABLE_TYPE = "beauty-and-spas";
    private static final String FOOD_AND_DRINK_AND_BEAUTY_AND_SPAS_BOOKABLE_TYPE = Strings.join(",", new String[] {
        "food-and-drink", "beauty-and-spas"
    });
    public static final String FOOD_AND_DRINK_BOOKABLE_TYPE = "food-and-drink";
    private AbTestService abTestService;
    private CurrentCountryManager currentCountryManager;
    private DivisionUtil divisionUtil;
    private SearchAbTestHelper searchAbTestHelper;

    public RapiAbTestHelper()
    {
    }

    private boolean isDTFEnabledDivisionsFD1510USCA(Place place)
    {
        return isDTFEnabledDivisionsFD1510USCA(divisionUtil.getDivisionFrom(new GeoPoint((int)(place.lat * 1000000D), (int)(place.lng * 1000000D))));
    }

    private boolean isDTFEnabledDivisionsFD1510USCA(Division division)
    {
        return abTestService.isVariantEnabled("DTFEnabledDivisionsFD1510USCA", "All") || abTestService.isVariantListEnabled("DTFEnabledDivisionsFD1510USCA", SecurityUtil.getMD5ForString(division.id));
    }

    private boolean isDTFEnabledDivisionsHBW1510USCA(Place place)
    {
        return isDTFEnabledDivisionsHBW1510USCA(divisionUtil.getDivisionFrom(new GeoPoint((int)(place.lat * 1000000D), (int)(place.lng * 1000000D))));
    }

    private boolean isDTFEnabledDivisionsHBW1510USCA(Division division)
    {
        return abTestService.isVariantEnabled("DTFEnabledDivisionsHBW1510USCA", "All") || abTestService.isVariantListEnabled("DTFEnabledDivisionsHBW1510USCA", SecurityUtil.getMD5ForString(division.id));
    }

    private boolean isDTFforFD1510USCA()
    {
        return abTestService.isVariantEnabled("DTFforFD1510USCA", "on");
    }

    private boolean isDTFforHBW1510USCA()
    {
        return abTestService.isVariantEnabled("DTFforHBW1510USCA", "on");
    }

    public String findBookableType(Place place)
    {
        boolean flag = isShowFinderCardFD1510USCA(place);
        boolean flag1 = isShowFinderCardHBW1510USCA(place);
        if (flag && flag1)
        {
            return FOOD_AND_DRINK_AND_BEAUTY_AND_SPAS_BOOKABLE_TYPE;
        }
        if (flag)
        {
            return "food-and-drink";
        }
        if (flag1)
        {
            return "beauty-and-spas";
        } else
        {
            return null;
        }
    }

    public String getCollectionCardsDeckId()
    {
        return abTestService.getVariant("showCollectionCards1510USCA");
    }

    public boolean isCategoryAttributesFilter1510USCAEnabled()
    {
        return abTestService.isVariantEnabledAndUSCA("categoryAttributesFilter1510USCA", "on");
    }

    public boolean isDTFforEitherHBWOrFDEnabled(Place place)
    {
        return isDTFforHBWEnabled(place) || isDTFforFDEnabled(place);
    }

    public boolean isDTFforEitherHBWOrFDEnabled(Division division)
    {
        return isDTFforHBWEnabled(division) || isDTFforFDEnabled(division);
    }

    public boolean isDTFforFDEnabled(Place place)
    {
        return isDTFforFD1510USCA() && isDTFEnabledDivisionsFD1510USCA(place) && currentCountryManager.getCurrentCountry().isUSACompatible();
    }

    public boolean isDTFforFDEnabled(Division division)
    {
        return isDTFforFD1510USCA() && isDTFEnabledDivisionsFD1510USCA(division) && currentCountryManager.getCurrentCountry().isUSACompatible();
    }

    public boolean isDTFforHBWEnabled(Place place)
    {
        return isDTFforHBW1510USCA() && isDTFEnabledDivisionsHBW1510USCA(place) && currentCountryManager.getCurrentCountry().isUSACompatible();
    }

    public boolean isDTFforHBWEnabled(Division division)
    {
        return isDTFforHBW1510USCA() && isDTFEnabledDivisionsHBW1510USCA(division) && currentCountryManager.getCurrentCountry().isUSACompatible();
    }

    public boolean isFeaturedUsingRAPI1511USCAEnabled()
    {
        return android.os.Build.VERSION.SDK_INT >= 17 && abTestService.isVariantEnabledAndUSCA("featuredUsingRAPI1511USCA", "on");
    }

    public boolean isGoodsBrandFilter1510USCAEnabled()
    {
        return abTestService.isVariantEnabledAndUSCA("goodsBrandFilter1510USCA", "on");
    }

    public boolean isPostSearchFiltersRAPI1510Enabled()
    {
        return abTestService.isVariantEnabled("postSearchFilters1510USCA", "on");
    }

    public boolean isShowCollectionCards1510USCAEnabled()
    {
        String s = abTestService.getVariant("showCollectionCards1510USCA");
        boolean flag;
        boolean flag1;
        if (Strings.notEmpty(s) && !Strings.equals(s, "Original"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = currentCountryManager.getCurrentCountry().isUSACompatible();
        return flag && flag1 && searchAbTestHelper.isRapiSearch1511Enabled();
    }

    public boolean isShowFinderCardFD1510USCA(Place place)
    {
        return abTestService.isVariantEnabledAndUSCA("showFinderCardFD1510USCA", "on") && isDTFforFDEnabled(place);
    }

    public boolean isShowFinderCardForEitherHBWOrFD1510USCA(Place place)
    {
        return isShowFinderCardHBW1510USCA(place) || isShowFinderCardFD1510USCA(place);
    }

    public boolean isShowFinderCardHBW1510USCA(Place place)
    {
        return abTestService.isVariantEnabledAndUSCA("showFinderCardHBW1510USCA", "on") && isDTFforHBWEnabled(place);
    }

}
