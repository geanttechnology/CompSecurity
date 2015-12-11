// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common;

import android.text.TextUtils;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.nautilus.domain.EbaySite;

// Referenced classes of package com.ebay.common:
//            Preferences

public class DeepLinkUtil
{

    public static final String DEEP_LINK_BASE = "http://pages.ebay.com/link/?nav=";
    private static final String HOMEPAGE = "http://pages.ebay.com/link/?nav=home";
    private static final String ITEM_QUERY_BASE = "http://pages.ebay.com/link/?nav=item.query&keywords=";
    private static final String ITEM_VIEW_BASE = "http://pages.ebay.com/link/?nav=item.view&id=";
    private static final String MOTORS_LINK_BASE = "http://pages.ebay.com/motors/link/?nav=";
    private static final String MOTORS_VIEW_BASE = "http://pages.ebay.com/motors/link/?nav=item.view&id=";
    private static final String NAV_HOME = "home";
    private static final String NAV_ITEM_QUERY = "item.query&";
    private static final String NAV_ITEM_VIEW = "item.view&";
    private static final String PARAMETER_ID = "id=";
    private static final String PARAMETER_KEYWORDS = "keywords=";
    private static final String PARAMETER_PLUS = "+";

    public DeepLinkUtil()
    {
    }

    public static String getItemUrlForNaturalSearch(Item item)
    {
        String s = item.viewItemUrlForNaturalSearch;
        Object obj = s;
        if (TextUtils.isEmpty(s))
        {
            EbaySite ebaysite = EbaySite.getInstanceFromId(item.site);
            obj = ebaysite;
            if (ebaysite == null)
            {
                obj = EbaySite.getInstanceFromId(MyApp.getCurrentSite());
            }
            obj = ((EbaySite) (obj)).getViewItemUrl(item.id);
        }
        return ((String) (obj));
    }

    public static String getStringForHomepageUrl()
    {
        return "http://pages.ebay.com/link/?nav=home";
    }

    public static transient String getStringForItemQueryUrl(String as[])
    {
        StringBuilder stringbuilder = new StringBuilder("http://pages.ebay.com/link/?nav=item.query&keywords=");
        if (as != null && as.length > 1)
        {
            boolean flag = true;
            int j = as.length;
            int i = 0;
            while (i < j) 
            {
                String s1 = as[i];
                String s;
                boolean flag1;
                if (flag)
                {
                    s = "";
                } else
                {
                    s = "+";
                }
                stringbuilder.append(s);
                stringbuilder.append(s1);
                flag1 = flag;
                if (flag)
                {
                    flag1 = false;
                }
                i++;
                flag = flag1;
            }
        } else
        {
            return getStringForHomepageUrl();
        }
        return stringbuilder.toString();
    }

    public static String getStringForItemViewUrl(long l)
    {
        return (new StringBuilder()).append("http://pages.ebay.com/link/?nav=item.view&id=").append(l).toString();
    }

    public static String getStringForItemViewUrl(Item item, boolean flag)
    {
        String s;
        String s1;
        if (item.isMotors)
        {
            s1 = (new StringBuilder()).append("http://pages.ebay.com/motors/link/?nav=item.view&id=").append(item.id).toString();
        } else
        {
            s1 = (new StringBuilder()).append("http://pages.ebay.com/link/?nav=item.view&id=").append(item.id).toString();
        }
        s = s1;
        if (!item.isValidShippingCountry(MyApp.getPrefs().getCurrentSite().localeCountry))
        {
            s = (new StringBuilder()).append(s1).append("&globalID=").append(EbaySite.getInstanceFromId(item.site).idString).toString();
        }
        item = s;
        if (flag)
        {
            item = (new StringBuilder()).append(s).append("&alt=web").toString();
        }
        return item;
    }
}
