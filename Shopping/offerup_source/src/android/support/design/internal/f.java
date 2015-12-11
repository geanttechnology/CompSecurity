// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.a;
import android.support.v4.view.bi;
import android.util.AttributeSet;
import android.widget.FrameLayout;

// Referenced classes of package android.support.design.internal:
//            g

public class f extends FrameLayout
{

    private Drawable a;
    private Rect b;
    private Rect c;

    public f(Context context)
    {
        this(context, null);
    }

    public f(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public f(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        c = new Rect();
        context = context.obtainStyledAttributes(attributeset, a.ac, i, 0x7f0c0196);
        a = context.getDrawable(a.ad);
        context.recycle();
        setWillNotDraw(true);
        bi.a(this, new g(this));
    }

    static Rect a(f f1)
    {
        return f1.b;
    }

    static Rect a(f f1, Rect rect)
    {
        f1.b = rect;
        return rect;
    }

    static Drawable b(f f1)
    {
        return f1.a;
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        int i = getWidth();
        int j = getHeight();
        if (b != null && a != null)
        {
            int k = canvas.save();
            canvas.translate(getScrollX(), getScrollY());
            c.set(0, 0, i, b.top);
            a.setBounds(c);
            a.draw(canvas);
            c.set(0, j - b.bottom, i, j);
            a.setBounds(c);
            a.draw(canvas);
            c.set(0, b.top, b.left, j - b.bottom);
            a.setBounds(c);
            a.draw(canvas);
            c.set(i - b.right, b.top, i, j - b.bottom);
            a.setBounds(c);
            a.draw(canvas);
            canvas.restoreToCount(k);
        }
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (a != null)
        {
            a.setCallback(this);
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (a != null)
        {
            a.setCallback(null);
        }
    }
}
