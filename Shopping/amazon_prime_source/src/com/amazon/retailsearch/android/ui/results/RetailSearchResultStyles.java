// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;

import android.content.res.Resources;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.retailsearch.android.ui.results:
//            ResultLayoutType

public class RetailSearchResultStyles
{

    private static Map STYLED_TEXT_STYLES;
    public static String STYLE_DATE_BY;
    public static String STYLE_HIGHLIGHT = "HIGHLIGHT";
    public static String STYLE_HIGHLIGHT2 = "HIGHLIGHT2";
    public static String STYLE_LINK;
    public static String STYLE_PLAIN = "PLAIN";
    public static String STYLE_STRIKETHROUGH;
    public static String STYLE_TIME_LEFT;
    private static Map styles;

    public RetailSearchResultStyles()
    {
    }

    public static Integer getStyleId(int i, ResultLayoutType resultlayouttype, Resources resources)
    {
        if (styles == null)
        {
            initStyles(resources);
        }
        if (resultlayouttype == null || resources == null)
        {
            return Integer.valueOf(i);
        }
        resources = resources.getResourceName(i);
        if (resources == null)
        {
            return Integer.valueOf(i);
        }
        resultlayouttype = (new StringBuilder()).append(resources).append(".").append(resultlayouttype.getName()).toString();
        if (styles.get(resultlayouttype) != null)
        {
            i = ((Integer)styles.get(resultlayouttype)).intValue();
        }
        return Integer.valueOf(i);
    }

    public static Integer getStyledTextStyleId(String s)
    {
        return (Integer)STYLED_TEXT_STYLES.get(s);
    }

    private static void initStyles(Resources resources)
    {
        styles = new HashMap();
        if (resources != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Field afield[];
        com.amazon.retailsearch.R.style style;
        int i;
        int j;
        afield = com/amazon/retailsearch/R$style.getDeclaredFields();
        style = new com.amazon.retailsearch.R.style();
        i = 0;
        j = afield.length;
_L4:
        if (i >= j) goto _L1; else goto _L3
_L3:
        String s;
        int k;
        k = afield[i].getInt(style);
        s = resources.getResourceName(k);
        styles.put(s, Integer.valueOf(k));
_L5:
        i++;
          goto _L4
          goto _L1
        Exception exception;
        exception;
          goto _L5
    }

    static 
    {
        STYLE_DATE_BY = "DATE_BY";
        STYLE_TIME_LEFT = "TIME_LEFT";
        STYLE_STRIKETHROUGH = "STRIKETHROUGH";
        STYLE_LINK = "LINK";
        STYLED_TEXT_STYLES = new HashMap(4);
        STYLED_TEXT_STYLES.put(STYLE_DATE_BY, Integer.valueOf(com.amazon.retailsearch.R.style.Results_StyledTextSpan_DATE_BY));
        STYLED_TEXT_STYLES.put(STYLE_TIME_LEFT, Integer.valueOf(com.amazon.retailsearch.R.style.Results_StyledTextSpan_TIME_LEFT));
        STYLED_TEXT_STYLES.put(STYLE_STRIKETHROUGH, Integer.valueOf(com.amazon.retailsearch.R.style.Results_StyledTextSpan_STRIKETHROUGH));
        STYLED_TEXT_STYLES.put(STYLE_LINK, Integer.valueOf(com.amazon.retailsearch.R.style.Results_StyledTextSpan_LINK));
    }
}
