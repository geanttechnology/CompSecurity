// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.android.ui.results.RetailSearchResultStyles;
import java.util.Arrays;

public class StyleAttributesReader
{

    private static final int STYLE_ATTRIBUTES[];
    private Integer backgroundResource;
    private Context context;
    private Integer imageAlign;
    private Float imageHeight;
    private Boolean isBold;
    private Boolean isLink;
    private Boolean isStrikethrough;
    private Resources res;
    private String shortText;
    private String text;
    private Integer textColor;
    private Float textSize;
    private Integer textSizePixels;

    public StyleAttributesReader(Context context1)
    {
        context = context1;
        res = context1.getResources();
    }

    public Integer getBackgroundResource()
    {
        return backgroundResource;
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

    public String getShortText()
    {
        return shortText;
    }

    public String getText()
    {
        return text;
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

    public void readStyle(int i, ResultLayoutType resultlayouttype)
    {
        i = RetailSearchResultStyles.getStyleId(i, resultlayouttype, res).intValue();
        resultlayouttype = context.obtainStyledAttributes(i, STYLE_ATTRIBUTES);
        i = 0;
        while (i < resultlayouttype.length()) 
        {
            if (resultlayouttype.hasValue(i))
            {
                int j = STYLE_ATTRIBUTES[i];
                if (j == 0x10100d4)
                {
                    backgroundResource = Integer.valueOf(resultlayouttype.getResourceId(i, 0));
                } else
                if (j == 0x101014f)
                {
                    text = resultlayouttype.getString(i);
                } else
                if (j == 0x1010098)
                {
                    textColor = Integer.valueOf(resultlayouttype.getColor(i, 0));
                } else
                if (j == 0x1010095)
                {
                    textSize = Float.valueOf(resultlayouttype.getDimension(i, -1F));
                    textSizePixels = Integer.valueOf(resultlayouttype.getDimensionPixelSize(i, -1));
                } else
                if (j == com.amazon.retailsearch.R.attr.Rs_ImageHeight)
                {
                    imageHeight = Float.valueOf(resultlayouttype.getDimension(i, -1F));
                } else
                if (j == com.amazon.retailsearch.R.attr.Rs_ImageAlign)
                {
                    imageAlign = Integer.valueOf(resultlayouttype.getInteger(i, 0));
                } else
                if (j == com.amazon.retailsearch.R.attr.Rs_IsStrikethroughSpan)
                {
                    isStrikethrough = Boolean.valueOf(resultlayouttype.getBoolean(i, false));
                } else
                if (j == com.amazon.retailsearch.R.attr.Rs_IsBoldSpan)
                {
                    isBold = Boolean.valueOf(resultlayouttype.getBoolean(i, false));
                } else
                if (j == com.amazon.retailsearch.R.attr.Rs_IsLinkSpan)
                {
                    isLink = Boolean.valueOf(resultlayouttype.getBoolean(i, false));
                } else
                if (j == com.amazon.retailsearch.R.attr.Rs_ShortText)
                {
                    shortText = resultlayouttype.getString(i);
                }
            }
            i++;
        }
        resultlayouttype.recycle();
    }

    static 
    {
        STYLE_ATTRIBUTES = (new int[] {
            0x10100d4, 0x101014f, 0x1010098, 0x1010095, com.amazon.retailsearch.R.attr.Rs_ImageHeight, com.amazon.retailsearch.R.attr.Rs_ImageAlign, com.amazon.retailsearch.R.attr.Rs_IsStrikethroughSpan, com.amazon.retailsearch.R.attr.Rs_IsBoldSpan, com.amazon.retailsearch.R.attr.Rs_IsLinkSpan, com.amazon.retailsearch.R.attr.Rs_ShortText
        });
        Arrays.sort(STYLE_ATTRIBUTES);
    }
}
