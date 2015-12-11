// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import java.util.ArrayList;
import java.util.Arrays;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            ApiGenerateShowParamBuilder, ShowPropertyParam

public class ApiRequestUtil
{

    private static final String DEAL_OPTION = "dealOption";
    private static final String REVIEWS = "reviews";

    public ApiRequestUtil()
    {
    }

    public static ArrayList generateGETGrouponsParameters(boolean flag, boolean flag1)
    {
        ArrayList arraylist = new ArrayList();
        String s = Strings.join(",", new String[] {
            Strings.join(",", new String[] {
                Strings.join(",", new String[] {
                    "default", "ticket"
                }), String.format("%1$s(%2$s)", new Object[] {
                    "dealOption", "schedulerOptions"
                })
            }), "isEditable"
        });
        if (flag)
        {
            s = "all";
        }
        arraylist.addAll(new ArrayList(Arrays.asList(new String[] {
            "show", s
        })));
        if (flag1)
        {
            arraylist.addAll(new ArrayList(Arrays.asList(new String[] {
                "include_market_rate", "true"
            })));
            arraylist.addAll(new ArrayList(Arrays.asList(new String[] {
                "system_id", "US"
            })));
        }
        return arraylist;
    }

    public static ArrayList generateHotelShowParameters(boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        if (flag)
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "show", "reviews"
            }));
        }
        return arraylist;
    }

    public static ArrayList generatePUTGrouponsParameters()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(new ArrayList(Arrays.asList(new String[] {
            "show", Strings.join(",", new String[] {
                "default", "ticket"
            })
        })));
        return arraylist;
    }

    public static ArrayList generateSearchShowParameter(boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(Arrays.asList(new String[] {
            "show", getSearchShowParams(flag, flag1, flag2, flag3)
        }));
        return arraylist;
    }

    public static ShowPropertyParam getRapiFeaturedShowParams(boolean flag, boolean flag1)
    {
        return (new ApiGenerateShowParamBuilder("deals")).dealOptionGiftWrappingCharge(true).bookingUpdatesSchedulerOptions(true).incentives(flag).categorizations(flag1).images(true).buildParams();
    }

    public static ShowPropertyParam getRapiSearchShowParams(String s, boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4)
    {
        return (new ApiGenerateShowParamBuilder(s)).dealSpecificAttributes(true).dealOptionGiftWrappingCharge(true).bookingUpdatesSchedulerOptions(true).incentives(flag).inventoryService(flag1).connectedMarketPlace(flag2).badges(flag3).channels(true).includeOldValues(true).categorizations(flag4).buildParams();
    }

    public static String getSearchShowParams(boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        return getRapiSearchShowParams("", flag, flag1, flag2, flag3, false).fieldsAsString();
    }
}
