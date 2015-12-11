// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EllipsizingTextView extends TextView
{
    public static interface EllipsizeListener
    {

        public abstract void ellipsizeStateChanged(boolean flag);
    }


    private static final Pattern DEFAULT_END_PUNCTUATION = Pattern.compile("[\\.,\u2026;\\:\\s]*$", 32);
    private static final String ELLIPSIS = "\u2026";
    private final List ellipsizeListeners;
    private Pattern endPunctuationPattern;
    private String fullText;
    private boolean isEllipsized;
    private boolean isStale;
    private float lineAdditionalVerticalPadding;
    private float lineSpacingMultiplier;
    private int maxLines;
    private boolean programmaticChange;

    public EllipsizingTextView(Context context)
    {
        this(context, null);
    }

    public EllipsizingTextView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public EllipsizingTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        ellipsizeListeners = new ArrayList();
        lineSpacingMultiplier = 1.0F;
        lineAdditionalVerticalPadding = 0.0F;
        super.setEllipsize(null);
        context = context.obtainStyledAttributes(attributeset, new int[] {
            0x1010153
        });
        setMaxLines(context.getInt(0, 0x7fffffff));
        setEndPunctuationPattern(DEFAULT_END_PUNCTUATION);
        context.recycle();
    }

    private Layout createWorkingLayout(String s)
    {
        return new StaticLayout(s, getPaint(), getWidth() - getPaddingLeft() - getPaddingRight(), android.text.Layout.Alignment.ALIGN_NORMAL, lineSpacingMultiplier, lineAdditionalVerticalPadding, false);
    }

    private int getFullyVisibleLinesCount()
    {
        Layout layout = createWorkingLayout("");
        return (getHeight() - getPaddingTop() - getPaddingBottom()) / layout.getLineBottom(0);
    }

    private void resetText()
    {
        Object obj;
        Layout layout;
        int i;
        boolean flag;
        obj = fullText;
        flag = false;
        layout = createWorkingLayout(((String) (obj)));
        i = getLinesCount();
        if (layout.getLineCount() <= i) goto _L2; else goto _L1
_L1:
        obj = fullText.substring(0, layout.getLineEnd(i - 1)).trim();
_L7:
        if (createWorkingLayout((new StringBuilder()).append(((String) (obj))).append("\u2026").toString()).getLineCount() <= i) goto _L4; else goto _L3
_L3:
        int j = ((String) (obj)).lastIndexOf(' ');
        if (j != -1) goto _L5; else goto _L4
_L4:
        obj = endPunctuationPattern.matcher(((CharSequence) (obj))).replaceFirst("");
        obj = (new StringBuilder()).append(((String) (obj))).append("\u2026").toString();
        flag = true;
_L2:
        if (((String) (obj)).equals(getText()))
        {
            break MISSING_BLOCK_LABEL_153;
        }
        programmaticChange = true;
        setText(((CharSequence) (obj)));
        programmaticChange = false;
        isStale = false;
        if (flag != isEllipsized)
        {
            isEllipsized = flag;
            for (obj = ellipsizeListeners.iterator(); ((Iterator) (obj)).hasNext(); ((EllipsizeListener)((Iterator) (obj)).next()).ellipsizeStateChanged(flag)) { }
        }
        break; /* Loop/switch isn't completed */
_L5:
        obj = ((String) (obj)).substring(0, j);
        if (true) goto _L7; else goto _L6
        Exception exception;
        exception;
        programmaticChange = false;
        throw exception;
_L6:
    }

    public void addEllipsizeListener(EllipsizeListener ellipsizelistener)
    {
        if (ellipsizelistener == null)
        {
            throw new NullPointerException();
        } else
        {
            ellipsizeListeners.add(ellipsizelistener);
            return;
        }
    }

    public boolean ellipsizingLastFullyVisibleLine()
    {
        return maxLines == 0x7fffffff;
    }

    protected int getLinesCount()
    {
        if (ellipsizingLastFullyVisibleLine())
        {
            int j = getFullyVisibleLinesCount();
            int i = j;
            if (j == -1)
            {
                i = 1;
            }
            return i;
        } else
        {
            return maxLines;
        }
    }

    public int getMaxLines()
    {
        return maxLines;
    }

    public boolean isEllipsized()
    {
        return isEllipsized;
    }

    protected void onDraw(Canvas canvas)
    {
        if (isStale)
        {
            resetText();
        }
        super.onDraw(canvas);
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        if (ellipsizingLastFullyVisibleLine())
        {
            isStale = true;
        }
    }

    protected void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        super.onTextChanged(charsequence, i, j, k);
        if (!programmaticChange)
        {
            fullText = charsequence.toString();
            isStale = true;
        }
    }

    public void removeEllipsizeListener(EllipsizeListener ellipsizelistener)
    {
        ellipsizeListeners.remove(ellipsizelistener);
    }

    public void setEllipsize(android.text.TextUtils.TruncateAt truncateat)
    {
    }

    public void setEndPunctuationPattern(Pattern pattern)
    {
        endPunctuationPattern = pattern;
    }

    public void setLineSpacing(float f, float f1)
    {
        lineAdditionalVerticalPadding = f;
        lineSpacingMultiplier = f1;
        super.setLineSpacing(f, f1);
    }

    public void setMaxLines(int i)
    {
        super.setMaxLines(i);
        maxLines = i;
        isStale = true;
    }

    public void setPadding(int i, int j, int k, int l)
    {
        super.setPadding(i, j, k, l);
        if (ellipsizingLastFullyVisibleLine())
        {
            isStale = true;
        }
    }

}
