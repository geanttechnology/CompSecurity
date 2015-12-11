// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import com.amazon.retailsearch.android.ui.results.RetailSearchResultStyles;
import com.amazon.retailsearch.android.ui.results.ViewType;
import java.util.Arrays;

public class StyleAttributesReader
{

    private static final int STYLE_ATTRIBUTES[];
    private Context context;
    private Integer imageAlign;
    private Float imageHeight;
    private Boolean isBold;
    private Boolean isLink;
    private Boolean isStrikethrough;
    private Resources res;
    private Integer textColor;
    private Float textSize;
    private Integer textSizePixels;

    public StyleAttributesReader(Context context1)
    {
        context = context1;
        res = context1.getResources();
    }

    public Integer getImageAlign()
    {
        return imageAlign;
    }

    public Float getImageHeight()
    {
        return imageHeight;
    }

    public Boolean getIsBold()
    {
        return isBold;
    }

    public Boolean getIsLink()
    {
        return isLink;
    }

    public Boolean getIsStrikethrough()
    {
        return isStrikethrough;
    }

    public Integer getTextColor()
    {
        return textColor;
    }

    public Float getTextSize()
    {
        return textSize;
    }

    public Integer getTextSizePixels()
    {
        return textSizePixels;
    }

    public void readStyle(int i, ViewType viewtype)
    {
        i = RetailSearchResultStyles.getStyleId(i, viewtype, res).intValue();
        viewtype = context.obtainStyledAttributes(i, STYLE_ATTRIBUTES);
        i = 0;
        while (i < viewtype.length()) 
        {
            if (viewtype.hasValue(i))
            {
                int j = STYLE_ATTRIBUTES[i];
                if (j == 0x1010098)
                {
                    textColor = Integer.valueOf(viewtype.getColor(i, 0));
                } else
                if (j == 0x1010095)
                {
                    textSize = Float.valueOf(viewtype.getDimension(i, -1F));
                    textSizePixels = Integer.valueOf(viewtype.getDimensionPixelSize(i, -1));
                } else
                if (j == com.amazon.retailsearch.R.attr.Rs_ImageHeight)
                {
                    imageHeight = Float.valueOf(viewtype.getDimension(i, -1F));
                } else
                if (j == com.amazon.retailsearch.R.attr.Rs_ImageAlign)
                {
                    imageAlign = Integer.valueOf(viewtype.getInteger(i, 0));
                } else
                if (j == com.amazon.retailsearch.R.attr.Rs_IsStrikethroughSpan)
                {
                    isStrikethrough = Boolean.valueOf(viewtype.getBoolean(i, false));
                } else
                if (j == com.amazon.retailsearch.R.attr.Rs_IsBoldSpan)
                {
                    isBold = Boolean.valueOf(viewtype.getBoolean(i, false));
                } else
                if (j == com.amazon.retailsearch.R.attr.Rs_IsLinkSpan)
                {
                    isLink = Boolean.valueOf(viewtype.getBoolean(i, false));
                }
            }
            i++;
        }
        viewtype.recycle();
    }

    static 
    {
        STYLE_ATTRIBUTES = (new int[] {
            0x1010098, 0x1010095, com.amazon.retailsearch.R.attr.Rs_ImageHeight, com.amazon.retailsearch.R.attr.Rs_ImageAlign, com.amazon.retailsearch.R.attr.Rs_IsStrikethroughSpan, com.amazon.retailsearch.R.attr.Rs_IsBoldSpan, com.amazon.retailsearch.R.attr.Rs_IsLinkSpan
        });
        Arrays.sort(STYLE_ATTRIBUTES);
    }
}
