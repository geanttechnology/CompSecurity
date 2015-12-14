// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            n

public class DynamicEllipsisTextView extends TextView
{

    private final List a;
    private boolean b;
    private String c;
    private int d;
    private boolean e;
    private boolean f;
    private float g;
    private float h;

    public DynamicEllipsisTextView(Context context)
    {
        super(context);
        a = new ArrayList();
        d = -1;
        g = 1.0F;
        h = 0.0F;
    }

    public DynamicEllipsisTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = new ArrayList();
        d = -1;
        g = 1.0F;
        h = 0.0F;
    }

    public DynamicEllipsisTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = new ArrayList();
        d = -1;
        g = 1.0F;
        h = 0.0F;
    }

    private Layout a(String s)
    {
        return new StaticLayout(s, getPaint(), getWidth() - getPaddingLeft() - getPaddingRight(), android.text.Layout.Alignment.ALIGN_NORMAL, g, h, false);
    }

    private void a()
    {
        Object obj;
        int i;
        i = getMaxLines();
        obj = c;
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_219;
        }
        Layout layout = a(((String) (obj)));
        if (layout.getLineCount() <= i)
        {
            break MISSING_BLOCK_LABEL_219;
        }
        obj = c.substring(0, layout.getLineEnd(i - 1)).trim();
_L2:
        int j;
        if (a((new StringBuilder()).append(((String) (obj))).append("...").toString()).getLineCount() > i)
        {
            j = ((String) (obj)).lastIndexOf(' ');
            if (j != -1)
            {
                break MISSING_BLOCK_LABEL_199;
            }
        }
        obj = (new StringBuilder()).append(((String) (obj))).append("...").toString();
        Exception exception;
        for (boolean flag = true; ((String) (obj)).equals(getText()); flag = false)
        {
            break MISSING_BLOCK_LABEL_141;
        }

        f = true;
        setText(((CharSequence) (obj)));
        f = false;
        e = false;
        if (flag != b)
        {
            b = flag;
            for (obj = a.iterator(); ((Iterator) (obj)).hasNext(); ((n)((Iterator) (obj)).next()).a(flag)) { }
        }
        break; /* Loop/switch isn't completed */
        obj = ((String) (obj)).substring(0, j);
        if (true) goto _L2; else goto _L1
        exception;
        f = false;
        throw exception;
_L1:
    }

    public int getMaxLines()
    {
        return d;
    }

    protected void onDraw(Canvas canvas)
    {
        if (e)
        {
            super.setEllipsize(null);
            a();
        }
        super.onDraw(canvas);
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        setMaxLines(getHeight() / getLineHeight());
    }

    protected void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        super.onTextChanged(charsequence, i, j, k);
        if (!f)
        {
            c = charsequence.toString();
            e = true;
        }
    }

    public void setEllipsize(android.text.TextUtils.TruncateAt truncateat)
    {
    }

    public void setLineSpacing(float f1, float f2)
    {
        h = f1;
        g = f2;
        super.setLineSpacing(f1, f2);
    }

    public void setMaxLines(int i)
    {
        super.setMaxLines(i);
        d = i;
        e = true;
    }
}
