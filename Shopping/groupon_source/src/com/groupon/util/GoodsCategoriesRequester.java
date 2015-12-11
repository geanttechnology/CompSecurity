// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import com.groupon.models.division.Division;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            CategoriesRequester, DeviceInfoUtil

public class GoodsCategoriesRequester extends CategoriesRequester
{

    private CurrentDivisionManager currentDivisionManager;
    private DeviceInfoUtil deviceInfoUtil;

    public GoodsCategoriesRequester(Context context, Class class1, String s)
    {
        super(context, class1, s);
    }

    protected Collection getSpecificParams()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(Arrays.asList(new String[] {
            "division_id", currentDivisionManager.getCurrentDivision().getIdOrParentId()
        }));
        arraylist.addAll(Arrays.asList(new String[] {
            "lang", deviceInfoUtil.getLanguageFromLocale()
        }));
        if (Strings.notEmpty(referrer))
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "referrer", referrer
            }));
        }
        arraylist.addAll(Arrays.asList(new String[] {
            "facets", getCriteria()
        }));
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "offset", Integer.valueOf(0), "limit", Integer.valueOf(0)
        }));
        arraylist.addAll(Arrays.asList(new String[] {
            "relevance_context", "mobile_goods", "facet_filters", "category0:goods"
        }));
        return arraylist;
    }
}
