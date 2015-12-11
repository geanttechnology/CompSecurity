// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.abtest;

import com.groupon.Channel;
import com.groupon.models.country.Country;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import java.util.Arrays;
import java.util.List;
import roboguice.util.Strings;

public class TabOrderAbTestHelper
{
    public static class TabOrderVariant
    {

        private final String defaultTab;
        private final String tabs[];

        public String getDefaultChannel()
        {
            return defaultTab;
        }

        public String[] getTabs()
        {
            return tabs;
        }

        public boolean isDefaultChannelInTabs()
        {
            return Arrays.asList(tabs).contains(defaultTab);
        }

        private TabOrderVariant(String s, String as[])
        {
            defaultTab = s;
            tabs = as;
        }

    }


    private static final String TAB_ORDER_CODE_INT = "INT";
    private static final String TAB_ORDER_CODE_USCA = "USCA";
    private AbTestService abTestService;
    private CurrentCountryManager currentCountryManager;

    public TabOrderAbTestHelper()
    {
    }

    private TabOrderVariant getTabOrderVariant(String s, String s1, boolean flag)
    {
        s1 = abTestService.getVariant(String.format(s, new Object[] {
            s1
        }));
        if (Strings.notEmpty(s1))
        {
            return parseTabOrderVariant(s1);
        }
        s1 = abTestService.getVariant(String.format(s, new Object[] {
            "USCA"
        }));
        if (flag && Strings.notEmpty(s1))
        {
            return parseTabOrderVariant(s1);
        }
        s = abTestService.getVariant(String.format(s, new Object[] {
            "INT"
        }));
        if (!flag && Strings.notEmpty(s))
        {
            return parseTabOrderVariant(s);
        } else
        {
            return null;
        }
    }

    private TabOrderVariant parseTabOrderVariant(String s)
    {
        String as[] = s.split(":");
        if (as.length != 2)
        {
            return null;
        }
        s = as[0];
        as = as[1].split(",");
        if (validateTabs(s, as))
        {
            s = new TabOrderVariant(s, as);
        } else
        {
            s = null;
        }
        return s;
    }

    private boolean validateTabs(String s, String as[])
    {
        if (!Strings.isEmpty(s) && (!Strings.notEmpty(s) || Channel.safeValueOf(s) != null)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int j = as.length;
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= j)
                {
                    break label1;
                }
                s = as[i];
                if (Strings.isEmpty(s) || Strings.notEmpty(s) && !Channel.isChannelNavigableTo(s))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    public TabOrderVariant getTabOrderVariant()
    {
        return getTabOrderVariant("tabOrderCompressed%s1505", currentCountryManager.getCurrentCountry().shortName.toUpperCase(), currentCountryManager.getCurrentCountry().isUSACompatible());
    }
}
