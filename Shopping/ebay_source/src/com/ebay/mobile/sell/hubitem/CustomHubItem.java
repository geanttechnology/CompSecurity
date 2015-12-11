// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.hubitem;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.ebay.mobile.sell.HubDisplayState;
import com.ebay.mobile.util.ThemeUtil;

public class CustomHubItem extends View
{

    private static final int ELEMENT_PADDING = 10;
    private static final int MINIMUM_PADDING = 10;
    private static final float STANDARD_MEDIUM_SP = 18F;
    private static final float STANDARD_SMALL_SP = 14F;
    private static final float STANDARD_TINY_SP = 12F;
    private static final int SUBTEXT_PADDING = 1;
    private static final int TEXT_PADDING = 2;
    private int availableContentWidth;
    private final int emptyTextColor;
    private final int goodStateIndicator = 0x7f020277;
    private final int greyTextColor;
    private final float guidancePadding = dipToPixels(getContext(), 10F);
    private final float guidancePaddingTop = dipToPixels(getContext(), 15F);
    private String hubExtraSubValue;
    private String hubExtraValue;
    private String hubSubValue;
    private String hubValue;
    private StaticLayout hubValueLayout;
    private boolean isSelected;
    private boolean isSuggestion;
    private final String label = getResources().getString(getLabelResource());
    private int labelTextColor;
    private Typeface labelTypeface;
    private final int lightBlueTextColor;
    private final float minHeight;
    private final TextPaint paint = new TextPaint();
    private final Drawable shadow = getResources().getDrawable(0x7f0202ca);
    private final float standardTextSize = (float)(int)TypedValue.applyDimension(2, 18F, getResources().getDisplayMetrics());
    private float startingHeight;
    private boolean status;
    private final float subValueTextSize = (float)(int)TypedValue.applyDimension(2, 12F, getResources().getDisplayMetrics());
    private final Typeface subValueTypeface;
    private final String suggestion = getResources().getString(getBubbleTextResource());
    private final Drawable suggestionBubble = getResources().getDrawable(0x7f0202df);
    private final Rect swapRect = new Rect();
    private final int unvisitedIndicator = 0x7f020278;
    private int valueTextColor;
    private final float valueTextSize = (float)(int)TypedValue.applyDimension(2, 14F, getResources().getDisplayMetrics());
    private final Typeface valueTypeface;
    private final int whiteTextColor = getResources().getColor(0x106000b);

    public CustomHubItem(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        status = false;
        isSuggestion = false;
        isSelected = false;
        hubValueLayout = null;
        attributeset = new TypedValue();
        context.getTheme().resolveAttribute(0x101004d, attributeset, true);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        minHeight = attributeset.getDimension(displaymetrics);
        paint.setAntiAlias(true);
        lightBlueTextColor = ThemeUtil.resolveThemeColor(getResources(), context.getTheme(), 0x1010212);
        greyTextColor = ThemeUtil.resolveThemeColor(getResources(), context.getTheme(), 0x1010036);
        labelTextColor = greyTextColor;
        valueTextColor = lightBlueTextColor;
        emptyTextColor = ThemeUtil.resolveThemeColor(getResources(), context.getTheme(), 0x1010038);
        labelTypeface = Typeface.DEFAULT;
        valueTypeface = Typeface.DEFAULT;
        subValueTypeface = Typeface.DEFAULT;
    }

    private void adjustHubValueLayout()
    {
        if (hubValueLayout.getLineCount() > maximumAllowedContentLines())
        {
            String s = "";
            int i = 0;
            for (int j = 0; j < maximumAllowedContentLines() - 1; j++)
            {
                int l = hubValueLayout.getLineEnd(j) - 1;
                String s1 = hubValue.subSequence(i, l).toString();
                s = (new StringBuilder()).append(s).append(s1).append("\n").toString();
                i = l + 1;
            }

            String s2 = s;
            if (hubValue.length() > i)
            {
                int k = hubValueLayout.getLineEnd(maximumAllowedContentLines() - 1);
                String s3 = hubValue.subSequence(i, k).toString().trim();
                s2 = s3;
                if (s3.length() + s.length() < hubValue.length())
                {
                    s2 = (new StringBuilder()).append(s3).append(getResources().getString(0x7f0703a6)).toString();
                }
                s2 = TextUtils.ellipsize(s2, paint, availableContentWidth, android.text.TextUtils.TruncateAt.END).toString();
                s2 = (new StringBuilder()).append(s).append(s2).toString();
            }
            hubValueLayout = new StaticLayout(s2, paint, availableContentWidth, android.text.Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
        }
    }

    private static float dipToPixels(Context context, float f)
    {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    private void drawGuidanceBubbleLeftAlign(Canvas canvas, int i, float f)
    {
        String s;
        int j;
        int k;
        int l;
        if (getDynamicBubbleText() == null)
        {
            s = suggestion;
        } else
        {
            s = getDynamicBubbleText();
        }
        paint.getTextBounds(s, 0, s.length(), swapRect);
        k = swapRect.width();
        j = swapRect.height();
        k = (int)((float)(i + k) + guidancePadding * 2.0F);
        l = (int)(f - (float)j - guidancePaddingTop - guidancePadding);
        j = (int)((float)(l + j) + guidancePadding + guidancePaddingTop);
        swapRect.set(i, l, k, j);
        suggestionBubble.setBounds(swapRect);
        suggestionBubble.draw(canvas);
        canvas.drawText(s, (float)i + guidancePadding, f - guidancePadding, paint);
    }

    private void drawShadow(Canvas canvas)
    {
        if (!isSelected && getResources().getBoolean(0x7f0b0006))
        {
            swapRect.set((int)((float)getWidth() - dipToPixels(getContext(), 4F)), 0, getWidth(), getHeight());
            shadow.setBounds(swapRect);
            shadow.draw(canvas);
        }
    }

    private void myDrawTextLeftAlign(Canvas canvas, int i, float f, CharSequence charsequence)
    {
        if (!TextUtils.isEmpty(charsequence))
        {
            canvas.drawText(charsequence.toString(), i, f, paint);
        }
    }

    private void setupPaintForEmptyValue()
    {
        paint.setColor(emptyTextColor);
        paint.setTypeface(valueTypeface);
        paint.setTextSize(valueTextSize);
    }

    private void setupPaintForExtraValue()
    {
        paint.setColor(labelTextColor);
        paint.setTypeface(subValueTypeface);
        paint.setTextSize(subValueTextSize);
    }

    private void setupPaintForGuidance()
    {
        paint.setColor(greyTextColor);
        paint.setTextSize(valueTextSize);
    }

    private void setupPaintForLabel()
    {
        paint.setColor(labelTextColor);
        paint.setTypeface(labelTypeface);
        paint.setTextSize(standardTextSize);
    }

    private void setupPaintForSubValue()
    {
        paint.setColor(valueTextColor);
        paint.setTypeface(subValueTypeface);
        paint.setTextSize(subValueTextSize);
    }

    private void setupPaintForValue()
    {
        paint.setColor(valueTextColor);
        paint.setTypeface(valueTypeface);
        paint.setTextSize(valueTextSize);
    }

    public int getBubbleTextResource()
    {
        return 0x104000f;
    }

    public String getDynamicBubbleText()
    {
        return null;
    }

    public int getEmptyResource()
    {
        return 0x7f07099b;
    }

    public int getLabelResource()
    {
        return 0x104000f;
    }

    public boolean isSuggestion()
    {
        return isSuggestion;
    }

    protected int maximumAllowedContentLines()
    {
        return 1;
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        hubValueLayout = null;
        requestLayout();
        super.onConfigurationChanged(configuration);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int k = (int)Math.max(dipToPixels(getContext(), 10F), getPaddingLeft());
        int j = (int)Math.max(dipToPixels(getContext(), 10F), getPaddingRight());
        int i = getHeight() / 2;
        Object obj = getResources();
        float f;
        float f1;
        int l;
        if (status)
        {
            i = 0x7f020277;
        } else
        {
            i = 0x7f020278;
        }
        obj = ((Resources) (obj)).getDrawable(i);
        i = ((Drawable) (obj)).getIntrinsicWidth();
        l = ((Drawable) (obj)).getIntrinsicHeight();
        setupPaintForLabel();
        f = (startingHeight + paint.descent()) - paint.getFontSpacing() / 2.0F;
        ((Drawable) (obj)).setBounds(k, (int)f - l / 2, k + i, (int)f + l / 2);
        ((Drawable) (obj)).draw(canvas);
        i = k + (int)((float)i + dipToPixels(getContext(), 10F));
        j = getWidth() - j - i;
        if (getResources().getBoolean(0x7f0b0006))
        {
            drawShadow(canvas);
        }
        f = startingHeight;
        myDrawTextLeftAlign(canvas, i, f, TextUtils.ellipsize(label, paint, j, android.text.TextUtils.TruncateAt.END));
        if (!TextUtils.isEmpty(hubValue))
        {
            f += paint.descent();
            setupPaintForValue();
            canvas.save();
            canvas.translate(i, 2.0F + f);
            if (hubValueLayout == null)
            {
                hubValueLayout = new StaticLayout(hubValue, paint, availableContentWidth, android.text.Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
            }
            hubValueLayout.draw(canvas);
            canvas.restore();
            f1 = f + (float)hubValueLayout.getHeight();
        } else
        {
            setupPaintForEmptyValue();
            f1 = f + (paint.getFontSpacing() + 2.0F);
            myDrawTextLeftAlign(canvas, i, f1, TextUtils.ellipsize(getResources().getString(getEmptyResource()), paint, j, android.text.TextUtils.TruncateAt.END));
        }
        f = f1;
        if (!TextUtils.isEmpty(hubSubValue))
        {
            setupPaintForSubValue();
            f = f1 + (paint.getFontSpacing() + 1.0F);
            myDrawTextLeftAlign(canvas, i, f, TextUtils.ellipsize(hubSubValue, paint, j, android.text.TextUtils.TruncateAt.END));
        }
        f1 = f;
        if (!TextUtils.isEmpty(hubExtraValue))
        {
            setupPaintForExtraValue();
            f1 = f + (paint.getFontSpacing() + 1.0F);
            myDrawTextLeftAlign(canvas, i, f1, TextUtils.ellipsize(hubExtraValue, paint, j, android.text.TextUtils.TruncateAt.END));
        }
        f = f1;
        if (!TextUtils.isEmpty(hubExtraSubValue))
        {
            setupPaintForSubValue();
            f = f1 + (paint.getFontSpacing() + 1.0F);
            myDrawTextLeftAlign(canvas, i, f, TextUtils.ellipsize(hubExtraSubValue, paint, j, android.text.TextUtils.TruncateAt.END));
        }
        if (isSuggestion)
        {
            setupPaintForGuidance();
            drawGuidanceBubbleLeftAlign(canvas, i, f + (paint.getFontSpacing() + guidancePadding + guidancePaddingTop));
        }
    }

    protected void onMeasure(int i, int j)
    {
        int k = android.view.View.MeasureSpec.getSize(i);
        if (k <= 0)
        {
            setMeasuredDimension(k, 0);
            return;
        }
        setupPaintForLabel();
        float f = 0.0F + paint.getFontSpacing();
        float f2 = paint.ascent();
        j = 0;
        float f1;
        float f3;
        float f4;
        if (!TextUtils.isEmpty(hubValue))
        {
            setupPaintForValue();
            Drawable drawable = getResources().getDrawable(0x7f020277);
            i = (int)Math.max(dipToPixels(getContext(), 10F), getPaddingLeft());
            j = (int)dipToPixels(getContext(), 10F);
            availableContentWidth = k - i * 2 - drawable.getIntrinsicWidth() - j * 2;
            if (hubValueLayout == null)
            {
                hubValueLayout = new StaticLayout(hubValue, paint, availableContentWidth, android.text.Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
            }
            adjustHubValueLayout();
            f1 = f + (float)hubValueLayout.getHeight();
            j = 0 + 2;
        } else
        {
            setupPaintForEmptyValue();
            f1 = f + paint.getFontSpacing();
        }
        f = f1;
        i = j;
        if (!TextUtils.isEmpty(hubSubValue))
        {
            setupPaintForSubValue();
            f = f1 + paint.getFontSpacing();
            i = j + 2;
        }
        f1 = f;
        j = i;
        if (!TextUtils.isEmpty(hubExtraValue))
        {
            setupPaintForExtraValue();
            f1 = f + paint.getFontSpacing();
            j = i + 1;
        }
        f = f1;
        i = j;
        if (!TextUtils.isEmpty(hubExtraSubValue))
        {
            setupPaintForSubValue();
            f = f1 + paint.getFontSpacing();
            i = j + 1;
        }
        f1 = f;
        if (isSuggestion)
        {
            setupPaintForGuidance();
            f1 = f + (paint.getFontSpacing() + guidancePadding + guidancePaddingTop);
        }
        f = (int)Math.max(dipToPixels(getContext(), 10F), getPaddingTop());
        f3 = f + (float)(int)Math.max(dipToPixels(getContext(), 10F), getPaddingBottom());
        f1 += i;
        f4 = Math.max(minHeight, f3 + f1);
        if (f4 - f1 > f3)
        {
            startingHeight = ((f4 - f1 - f3) / 2.0F + f) - f2;
        } else
        {
            startingHeight = f - f2;
        }
        setMeasuredDimension(k, (int)f4);
    }

    public void requestLayout()
    {
        hubValueLayout = null;
        super.requestLayout();
    }

    public void resetSelectedBackground()
    {
        int i = 0x1080062;
        TypedValue typedvalue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(0x10102f0, typedvalue, true))
        {
            i = typedvalue.resourceId;
        }
        setBackgroundResource(i);
        isSelected = false;
        labelTextColor = greyTextColor;
        labelTypeface = Typeface.DEFAULT;
        valueTextColor = lightBlueTextColor;
        invalidate();
    }

    public void setCellValue(String s)
    {
        setCellValue(s, null, false, null, null);
    }

    public void setCellValue(String s, String s1, boolean flag)
    {
        setCellValue(s, s1, flag, null, null);
    }

    public void setCellValue(String s, String s1, boolean flag, String s2, String s3)
    {
        boolean flag1 = false;
        if (isSuggestion != flag || !TextUtils.equals(hubSubValue, s1) || !TextUtils.equals(hubValue, s) || !TextUtils.equals(hubExtraValue, s2) || !TextUtils.equals(hubExtraSubValue, s3))
        {
            flag1 = true;
        }
        hubValue = s;
        hubSubValue = s1;
        hubExtraValue = s2;
        hubExtraSubValue = s3;
        isSuggestion = flag;
        if (flag1)
        {
            requestLayout();
            return;
        } else
        {
            invalidate();
            return;
        }
    }

    public void setDisplayFromState(HubDisplayState hubdisplaystate, boolean flag)
    {
    }

    public void setDisplayFromState(HubDisplayState hubdisplaystate, boolean flag, boolean flag1)
    {
    }

    public void setSelected()
    {
        setBackgroundResource(0x7f020274);
        labelTextColor = whiteTextColor;
        labelTypeface = Typeface.DEFAULT_BOLD;
        valueTextColor = greyTextColor;
        isSelected = true;
    }

    public void setStatus(boolean flag)
    {
        status = flag;
        invalidate();
    }

    public void setStatusIndicator(boolean flag)
    {
        setStatus(flag);
    }

    public void setSuggestion(boolean flag)
    {
        isSuggestion = flag;
        requestLayout();
    }
}
