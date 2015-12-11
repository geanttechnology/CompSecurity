// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.poshmark.utils.ViewUtils;

public class PMPriceLayout extends LinearLayout
{
    class RenderResult
    {

        int endPoint;
        Point renderStartPoint;
        int renderedFontSize;
        boolean success;
        final PMPriceLayout this$0;

        RenderResult()
        {
            this$0 = PMPriceLayout.this;
            super();
            renderStartPoint = new Point();
            success = false;
        }
    }

    static final class STRING_TYPE extends Enum
    {

        private static final STRING_TYPE $VALUES[];
        public static final STRING_TYPE LISTING_PRICE;
        public static final STRING_TYPE ORIGINAL_STRING;

        public static STRING_TYPE valueOf(String s)
        {
            return (STRING_TYPE)Enum.valueOf(com/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE, s);
        }

        public static STRING_TYPE[] values()
        {
            return (STRING_TYPE[])$VALUES.clone();
        }

        static 
        {
            LISTING_PRICE = new STRING_TYPE("LISTING_PRICE", 0);
            ORIGINAL_STRING = new STRING_TYPE("ORIGINAL_STRING", 1);
            $VALUES = (new STRING_TYPE[] {
                LISTING_PRICE, ORIGINAL_STRING
            });
        }

        private STRING_TYPE(String s, int i)
        {
            super(s, i);
        }
    }


    int defaultListingPriceFontSizeAsDip;
    int leftOffset;
    String listingPrice;
    int minListingPriceFontSizeAsDip;
    int minOriginalPriceFontSizeAsDip;
    String originalPrice;
    Paint paint;
    Bitmap savedBackground;

    public PMPriceLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        defaultListingPriceFontSizeAsDip = 22;
        minListingPriceFontSizeAsDip = 10;
        minOriginalPriceFontSizeAsDip = 6;
        leftOffset = (int)ViewUtils.dipToPixels(getContext(), 10F);
        setWillNotDraw(false);
        paint = new Paint(1);
    }

    private Point getDrawPoint(Canvas canvas, Point point, int i)
    {
        Point point1 = new Point();
        point1.x = i;
        point1.y = canvas.getHeight() / 2 + point.y / 2;
        return point1;
    }

    private int getMinFontSize(STRING_TYPE string_type)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$poshmark$ui$customviews$PMPriceLayout$STRING_TYPE[];

            static 
            {
                $SwitchMap$com$poshmark$ui$customviews$PMPriceLayout$STRING_TYPE = new int[STRING_TYPE.values().length];
                try
                {
                    $SwitchMap$com$poshmark$ui$customviews$PMPriceLayout$STRING_TYPE[STRING_TYPE.LISTING_PRICE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$customviews$PMPriceLayout$STRING_TYPE[STRING_TYPE.ORIGINAL_STRING.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.poshmark.ui.customviews.PMPriceLayout.STRING_TYPE[string_type.ordinal()])
        {
        default:
            return minListingPriceFontSizeAsDip;

        case 1: // '\001'
            return minListingPriceFontSizeAsDip;

        case 2: // '\002'
            return minOriginalPriceFontSizeAsDip;
        }
    }

    private Point getTextBounds(String s)
    {
        Rect rect = new Rect();
        paint.getTextBounds(s, 0, s.length(), rect);
        s = new Rect();
        paint.getTextBounds("a", 0, 1, s);
        return new Point(rect.width(), s.height());
    }

    private void initPaintForPriceString(int i, STRING_TYPE string_type)
    {
        int k;
        switch (_cls1..SwitchMap.com.poshmark.ui.customviews.PMPriceLayout.STRING_TYPE[string_type.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            int j = getResources().getColor(0x7f090040);
            paint.setColor(j);
            float f = ViewUtils.dipToPixels(getContext(), i);
            paint.setTextSize(f);
            paint.setAntiAlias(true);
            paint.setFlags(1);
            return;

        case 2: // '\002'
            k = getResources().getColor(0x7f090039);
            break;
        }
        paint.setColor(k);
        float f1 = ViewUtils.dipToPixels(getContext(), i);
        paint.setTextSize(f1);
        paint.setAntiAlias(true);
        paint.setFlags(17);
    }

    private RenderResult renderScaledString(String s, Canvas canvas, int i, int j, int k, STRING_TYPE string_type)
    {
        Point point;
        RenderResult renderresult;
        renderresult = new RenderResult();
        paint.reset();
        initPaintForPriceString(k, string_type);
        point = getTextBounds(s);
        if (point.x + i >= j) goto _L2; else goto _L1
_L1:
        renderresult.success = true;
        renderresult.renderedFontSize = k;
_L4:
        if (renderresult.success)
        {
            renderresult.renderStartPoint = getDrawPoint(canvas, point, i);
            renderresult.endPoint = renderresult.renderStartPoint.x + point.x;
        }
        return renderresult;
_L2:
        k--;
        Point point1 = point;
        do
        {
            point = point1;
            if (point1.x + i >= j)
            {
                point = point1;
                if (k > getMinFontSize(string_type))
                {
label0:
                    {
                        initPaintForPriceString(k, string_type);
                        point = getTextBounds(s);
                        if (point.x + i >= j)
                        {
                            break label0;
                        }
                        renderresult.success = true;
                        renderresult.renderedFontSize = k;
                    }
                }
            }
            if (true)
            {
                continue;
            }
            k--;
            point1 = point;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private boolean willFit(String s, int i)
    {
        Rect rect = new Rect();
        paint.getTextBounds(s, 0, s.length(), rect);
        return rect.right <= i;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (originalPrice == null || listingPrice == null) goto _L2; else goto _L1
_L1:
        RenderResult renderresult;
        RenderResult renderresult1;
        int i = getWidth() / 2;
        renderresult1 = null;
        renderresult = renderScaledString(listingPrice, canvas, leftOffset, i, defaultListingPriceFontSizeAsDip, STRING_TYPE.LISTING_PRICE);
        if (renderresult.success) goto _L4; else goto _L3
_L3:
        RenderResult renderresult2 = renderScaledString(listingPrice, canvas, leftOffset, getWidth(), defaultListingPriceFontSizeAsDip, STRING_TYPE.LISTING_PRICE);
        renderresult = renderresult2;
        if (renderresult2.success)
        {
            renderresult1 = renderScaledString(originalPrice, canvas, renderresult2.endPoint + leftOffset, getWidth(), renderresult2.renderedFontSize, STRING_TYPE.ORIGINAL_STRING);
            renderresult = renderresult2;
        }
_L6:
        if (renderresult != null && renderresult.success)
        {
            initPaintForPriceString(renderresult.renderedFontSize, STRING_TYPE.LISTING_PRICE);
            canvas.drawText(listingPrice, renderresult.renderStartPoint.x, renderresult.renderStartPoint.y, paint);
        }
        if (renderresult1 != null && renderresult1.success)
        {
            initPaintForPriceString(renderresult1.renderedFontSize, STRING_TYPE.ORIGINAL_STRING);
            canvas.drawText(originalPrice, renderresult1.renderStartPoint.x, renderresult1.renderStartPoint.y, paint);
        }
_L2:
        return;
_L4:
        RenderResult renderresult3 = renderScaledString(originalPrice, canvas, renderresult.endPoint + leftOffset, getWidth(), renderresult.renderedFontSize, STRING_TYPE.ORIGINAL_STRING);
        renderresult1 = renderresult3;
        if (!renderresult3.success)
        {
            renderresult = renderScaledString(listingPrice, canvas, leftOffset, getWidth(), defaultListingPriceFontSizeAsDip, STRING_TYPE.LISTING_PRICE);
            renderresult1 = renderresult3;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void setListingPrices(String s, String s1)
    {
        listingPrice = s;
        originalPrice = s1;
        invalidate();
    }
}
