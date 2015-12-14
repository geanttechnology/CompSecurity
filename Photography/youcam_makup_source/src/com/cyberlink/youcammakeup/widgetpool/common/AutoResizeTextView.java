// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.widget.TextView;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            a

public class AutoResizeTextView extends TextView
{

    private final RectF a;
    private final SparseIntArray b;
    private final a c;
    private float d;
    private float e;
    private float f;
    private float g;
    private int h;
    private int i;
    private boolean j;
    private boolean k;

    public AutoResizeTextView(Context context)
    {
        this(context, null, 0);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeset, int l)
    {
        super(context, attributeset, l);
        a = new RectF();
        b = new SparseIntArray();
        e = 1.0F;
        f = 0.0F;
        j = true;
        k = false;
        g = TypedValue.applyDimension(2, 4F, getResources().getDisplayMetrics());
        d = getTextSize();
        if (i == 0)
        {
            i = -1;
        }
        c = new a(new TextPaint(getPaint())) {

            final RectF a = new RectF();
            final TextPaint b;
            final AutoResizeTextView c;

            public int a(int i1, RectF rectf)
            {
                Object obj;
                boolean flag;
                flag = true;
                b.setTextSize(i1);
                obj = c.getText().toString();
                if (c.getMaxLines() == 1)
                {
                    i1 = 1;
                } else
                {
                    i1 = 0;
                }
                if (i1 == 0) goto _L2; else goto _L1
_L1:
                a.bottom = b.getFontSpacing();
                a.right = b.measureText(((String) (obj)));
_L6:
                a.offsetTo(0.0F, 0.0F);
                i1 = ((flag) ? 1 : 0);
                if (rectf.contains(a))
                {
                    i1 = -1;
                }
_L4:
                return i1;
_L2:
                obj = new StaticLayout(((CharSequence) (obj)), b, AutoResizeTextView.a(c), android.text.Layout.Alignment.ALIGN_NORMAL, AutoResizeTextView.b(c), AutoResizeTextView.c(c), true);
                if (c.getMaxLines() == -1)
                {
                    break; /* Loop/switch isn't completed */
                }
                i1 = ((flag) ? 1 : 0);
                if (((StaticLayout) (obj)).getLineCount() > c.getMaxLines()) goto _L4; else goto _L3
_L3:
                a.bottom = ((StaticLayout) (obj)).getHeight();
                i1 = 0;
                int j1;
                int k1;
                for (j1 = -1; i1 < ((StaticLayout) (obj)).getLineCount(); j1 = k1)
                {
                    k1 = j1;
                    if ((float)j1 < ((StaticLayout) (obj)).getLineWidth(i1))
                    {
                        k1 = (int)((StaticLayout) (obj)).getLineWidth(i1);
                    }
                    i1++;
                }

                a.right = j1;
                if (true) goto _L6; else goto _L5
_L5:
            }

            
            {
                c = AutoResizeTextView.this;
                b = textpaint;
                super();
            }
        };
        k = true;
    }

    private int a(int l, int i1, a a1, RectF rectf)
    {
        if (!j)
        {
            return b(l, i1, a1, rectf);
        }
        String s = getText().toString();
        int j1;
        int k1;
        if (s == null)
        {
            j1 = 0;
        } else
        {
            j1 = s.length();
        }
        k1 = b.get(j1);
        if (k1 != 0)
        {
            return k1;
        } else
        {
            l = b(l, i1, a1, rectf);
            b.put(j1, l);
            return l;
        }
    }

    static int a(AutoResizeTextView autoresizetextview)
    {
        return autoresizetextview.h;
    }

    private void a()
    {
        b();
    }

    static float b(AutoResizeTextView autoresizetextview)
    {
        return autoresizetextview.e;
    }

    private int b(int l, int i1, a a1, RectF rectf)
    {
        int l1 = i1 - 1;
        i1 = l;
        int j1 = l;
        l = i1;
        i1 = j1;
        for (int k1 = l1; l <= k1;)
        {
            i1 = l + k1 >>> 1;
            int i2 = a1.a(i1, rectf);
            if (i2 < 0)
            {
                i2 = i1 + 1;
                i1 = l;
                l = i2;
            } else
            if (i2 > 0)
            {
                k1 = i1 - 1;
                i1 = k1;
            } else
            {
                return i1;
            }
        }

        return i1;
    }

    private void b()
    {
        if (!k)
        {
            return;
        } else
        {
            int l = (int)g;
            int i1 = getMeasuredHeight();
            int j1 = getCompoundPaddingBottom();
            int k1 = getCompoundPaddingTop();
            h = getMeasuredWidth() - getCompoundPaddingLeft() - getCompoundPaddingRight();
            a.right = h;
            a.bottom = i1 - j1 - k1;
            super.setTextSize(0, a(l, (int)d, c, a));
            return;
        }
    }

    static float c(AutoResizeTextView autoresizetextview)
    {
        return autoresizetextview.f;
    }

    public int getMaxLines()
    {
        return i;
    }

    protected void onSizeChanged(int l, int i1, int j1, int k1)
    {
        b.clear();
        super.onSizeChanged(l, i1, j1, k1);
        if (l != j1 || i1 != k1)
        {
            a();
        }
    }

    protected void onTextChanged(CharSequence charsequence, int l, int i1, int j1)
    {
        super.onTextChanged(charsequence, l, i1, j1);
        a();
    }

    public void setEnableSizeCache(boolean flag)
    {
        j = flag;
        b.clear();
        b();
    }

    public void setLineSpacing(float f1, float f2)
    {
        super.setLineSpacing(f1, f2);
        e = f2;
        f = f1;
    }

    public void setLines(int l)
    {
        super.setLines(l);
        i = l;
        a();
    }

    public void setMaxLines(int l)
    {
        super.setMaxLines(l);
        i = l;
        a();
    }

    public void setMinTextSize(float f1)
    {
        g = f1;
        a();
    }

    public void setSingleLine()
    {
        super.setSingleLine();
        i = 1;
        a();
    }

    public void setSingleLine(boolean flag)
    {
        super.setSingleLine(flag);
        if (flag)
        {
            i = 1;
        } else
        {
            i = -1;
        }
        a();
    }

    public void setTextSize(float f1)
    {
        d = f1;
        b.clear();
        b();
    }

    public void setTextSize(int l, float f1)
    {
        Object obj = getContext();
        if (obj == null)
        {
            obj = Resources.getSystem();
        } else
        {
            obj = ((Context) (obj)).getResources();
        }
        d = TypedValue.applyDimension(l, f1, ((Resources) (obj)).getDisplayMetrics());
        b.clear();
        b();
    }
}
