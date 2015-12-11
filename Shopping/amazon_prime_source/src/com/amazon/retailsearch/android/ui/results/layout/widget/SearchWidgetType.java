// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.widget;

import android.text.TextUtils;
import com.amazon.searchapp.retailsearch.model.BrandStrip;
import com.amazon.searchapp.retailsearch.model.ImageSparkle;
import com.amazon.searchapp.retailsearch.model.PastPurchases;
import com.amazon.searchapp.retailsearch.model.Sparkle;
import com.amazon.searchapp.retailsearch.model.TextSparkle;
import com.amazon.searchapp.retailsearch.model.Widget;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout.widget:
//            SparkleWidget, PastPurchasesWidget, ImageSparkleWidget, TextSparkleWidget, 
//            BrandstripWidget

public final class SearchWidgetType extends Enum
{

    private static final SearchWidgetType $VALUES[];
    public static final SearchWidgetType BRAND_STRIP;
    public static final SearchWidgetType IMAGE_SPARKLE;
    public static final SearchWidgetType PAST_PURCHASES;
    public static final SearchWidgetType SPARKLE;
    public static final SearchWidgetType TEXT_SPARKLE;
    private int position;
    private int section;
    private String srdsId;
    private Class viewClass;
    private int viewType;

    private SearchWidgetType(String s, int i, String s1, int j, Class class1, int k, int l)
    {
        super(s, i);
        srdsId = s1;
        viewType = j;
        viewClass = class1;
        section = k;
        position = l;
    }

    public static SearchWidgetType valueOf(Widget widget)
    {
        if (widget != null && !TextUtils.isEmpty(widget.getId())) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if (!SPARKLE.getSrdsId().equals(widget.getId()))
        {
            break; /* Loop/switch isn't completed */
        }
        if (widget instanceof Sparkle)
        {
            return SPARKLE;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (!PAST_PURCHASES.getSrdsId().equals(widget.getId()))
        {
            break; /* Loop/switch isn't completed */
        }
        if (widget instanceof PastPurchases)
        {
            return PAST_PURCHASES;
        }
        if (true) goto _L1; else goto _L4
_L4:
        if (!IMAGE_SPARKLE.getSrdsId().equals(widget.getId()))
        {
            break; /* Loop/switch isn't completed */
        }
        if (widget instanceof ImageSparkle)
        {
            return IMAGE_SPARKLE;
        }
        if (true) goto _L1; else goto _L5
_L5:
        if (!BRAND_STRIP.getSrdsId().equals(widget.getId()))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!(widget instanceof BrandStrip)) goto _L1; else goto _L6
_L6:
        return BRAND_STRIP;
        if (!TEXT_SPARKLE.getSrdsId().equals(widget.getId()) || !(widget instanceof TextSparkle)) goto _L1; else goto _L7
_L7:
        return TEXT_SPARKLE;
    }

    public static SearchWidgetType valueOf(String s)
    {
        return (SearchWidgetType)Enum.valueOf(com/amazon/retailsearch/android/ui/results/layout/widget/SearchWidgetType, s);
    }

    public static SearchWidgetType[] values()
    {
        return (SearchWidgetType[])$VALUES.clone();
    }

    public int getPosition()
    {
        return position;
    }

    public int getSection()
    {
        return section;
    }

    public String getSrdsId()
    {
        return srdsId;
    }

    public Class getViewClass()
    {
        return viewClass;
    }

    public int getViewType()
    {
        return viewType;
    }

    static 
    {
        SPARKLE = new SearchWidgetType("SPARKLE", 0, "sparkle", 17, com/amazon/retailsearch/android/ui/results/layout/widget/SparkleWidget, 0, 0);
        PAST_PURCHASES = new SearchWidgetType("PAST_PURCHASES", 1, "pastPurchases", 18, com/amazon/retailsearch/android/ui/results/layout/widget/PastPurchasesWidget, 0, 0);
        IMAGE_SPARKLE = new SearchWidgetType("IMAGE_SPARKLE", 2, "imageSparkle", 19, com/amazon/retailsearch/android/ui/results/layout/widget/ImageSparkleWidget, 0, 0);
        TEXT_SPARKLE = new SearchWidgetType("TEXT_SPARKLE", 3, "textSparkle", 21, com/amazon/retailsearch/android/ui/results/layout/widget/TextSparkleWidget, 0, 0);
        BRAND_STRIP = new SearchWidgetType("BRAND_STRIP", 4, "brandStrip", 20, com/amazon/retailsearch/android/ui/results/layout/widget/BrandstripWidget, 0, 0);
        $VALUES = (new SearchWidgetType[] {
            SPARKLE, PAST_PURCHASES, IMAGE_SPARKLE, TEXT_SPARKLE, BRAND_STRIP
        });
    }
}
