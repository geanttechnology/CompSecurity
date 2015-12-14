// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tokaracamara.android.verticalslidevar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import myobfuscated.be.a;

// Referenced classes of package com.tokaracamara.android.verticalslidevar:
//            VerticalProgressBar

public class AbsVerticalSeekBar extends VerticalProgressBar
{

    private Drawable g;
    private int h;
    private boolean i;
    private int j;
    private float k;

    public AbsVerticalSeekBar(Context context)
    {
        super(context);
        i = true;
        j = 1;
    }

    public AbsVerticalSeekBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        i = true;
        j = 1;
    }

    public AbsVerticalSeekBar(Context context, AttributeSet attributeset, int l)
    {
        super(context, attributeset, l);
        i = true;
        j = 1;
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, a.SeekBar, l, 0);
        setThumb(typedarray.getDrawable(a.SeekBar_android_thumb));
        setThumbOffset(typedarray.getDimensionPixelOffset(a.SeekBar_android_thumbOffset, h));
        typedarray.recycle();
        context = context.obtainStyledAttributes(attributeset, a.ThemeDisabledAlpha, 0, 0);
        k = context.getFloat(a.ThemeDisabledAlpha_android_disabledAlpha, 0.5F);
        context.recycle();
    }

    private void a(int l, Drawable drawable, float f, int i1)
    {
        int l1 = drawable.getIntrinsicWidth();
        int j1 = drawable.getIntrinsicHeight();
        int k1 = (int)((float)(((l + 0 + 0) - j1) + h * 2) * (1.0F - f));
        if (i1 == 0x80000000)
        {
            Rect rect = drawable.getBounds();
            i1 = rect.left;
            l = rect.right;
        } else
        {
            l = i1 + l1;
        }
        drawable.setBounds(i1, k1, l, k1 + j1);
    }

    private void a(MotionEvent motionevent)
    {
        int l = getHeight();
        int i1 = l - (int)motionevent.getY();
        float f;
        if (i1 < 0)
        {
            f = 0.0F;
        } else
        if (i1 > l + 0)
        {
            f = 1.0F;
        } else
        {
            f = (float)(i1 + 0) / (float)(l + 0 + 0);
        }
        a((int)(f * (float)b() + 0.0F), true);
    }

    void a(float f, boolean flag)
    {
        Drawable drawable = g;
        if (drawable != null)
        {
            a(getHeight(), drawable, f, 0x80000000);
            invalidate();
        }
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        Drawable drawable = super.e;
        if (drawable != null)
        {
            int ai[];
            int l;
            if (isEnabled())
            {
                l = 255;
            } else
            {
                l = (int)(255F * k);
            }
            drawable.setAlpha(l);
        }
        if (g != null && g.isStateful())
        {
            ai = getDrawableState();
            g.setState(ai);
        }
    }

    protected void onDraw(Canvas canvas)
    {
        this;
        JVM INSTR monitorenter ;
        super.onDraw(canvas);
        if (g != null)
        {
            canvas.save();
            canvas.translate(0.0F, 0 - h);
            g.draw(canvas);
            canvas.restore();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        canvas;
        throw canvas;
    }

    public boolean onKeyDown(int l, KeyEvent keyevent)
    {
        int i1 = a();
        l;
        JVM INSTR tableswitch 19 20: default 28
    //                   19 52
    //                   20 35;
           goto _L1 _L2 _L3
_L1:
        return super.onKeyDown(l, keyevent);
_L3:
        if (i1 > 0)
        {
            a(i1 - j, true);
            return true;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (i1 < b())
        {
            a(i1 + j, true);
            return true;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void onMeasure(int l, int i1)
    {
        int k1 = 0;
        this;
        JVM INSTR monitorenter ;
        Drawable drawable = super.f;
        if (g != null) goto _L2; else goto _L1
_L1:
        int j1 = 0;
_L3:
        if (drawable == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        Math.max(a, Math.min(b, drawable.getIntrinsicWidth()));
        k1 = Math.max(j1, 0);
        j1 = Math.max(c, Math.min(d, drawable.getIntrinsicHeight()));
_L4:
        setMeasuredDimension(resolveSize(k1 + 0, l), resolveSize(j1 + 0, i1));
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        j1 = g.getIntrinsicWidth();
          goto _L3
        Exception exception;
        exception;
        throw exception;
        boolean flag = false;
        j1 = k1;
        k1 = ((flag) ? 1 : 0);
          goto _L4
    }

    protected void onSizeChanged(int l, int i1, int j1, int k1)
    {
        Drawable drawable = super.f;
        Drawable drawable1 = g;
        float f;
        int l1;
        if (drawable1 == null)
        {
            j1 = 0;
        } else
        {
            j1 = drawable1.getIntrinsicWidth();
        }
        k1 = Math.min(b, l + 0 + 0);
        l1 = b();
        if (l1 > 0)
        {
            f = (float)a() / (float)l1;
        } else
        {
            f = 0.0F;
        }
        if (j1 > k1)
        {
            j1 = (j1 - k1) / 2;
            if (drawable1 != null)
            {
                a(i1, drawable1, f, j1 * -1);
            }
            if (drawable != null)
            {
                drawable.setBounds(j1, 0, (l + 0 + 0) - j1, i1 + 0 + 0);
            }
        } else
        {
            if (drawable != null)
            {
                drawable.setBounds(0, 0, l + 0 + 0, i1 + 0 + 0);
            }
            l = (k1 - j1) / 2;
            if (drawable1 != null)
            {
                a(i1, drawable1, f, l);
                return;
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (!i || !isEnabled())
        {
            return false;
        }
        switch (motionevent.getAction())
        {
        default:
            return true;

        case 0: // '\0'
            setPressed(true);
            a(motionevent);
            return true;

        case 2: // '\002'
            a(motionevent);
            return true;

        case 1: // '\001'
            a(motionevent);
            // fall through

        case 3: // '\003'
            setPressed(false);
            break;
        }
        invalidate();
        return true;
    }

    public void setKeyProgressIncrement(int l)
    {
        int i1 = l;
        if (l < 0)
        {
            i1 = -l;
        }
        j = i1;
    }

    public void setMax(int l)
    {
        this;
        JVM INSTR monitorenter ;
        super.setMax(l);
        if (j == 0 || b() / j > 20)
        {
            setKeyProgressIncrement(Math.max(1, Math.round((float)b() / 20F)));
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setThumb(Drawable drawable)
    {
        if (drawable != null)
        {
            drawable.setCallback(this);
            h = drawable.getIntrinsicHeight() / 2;
        }
        g = drawable;
        invalidate();
    }

    public void setThumbOffset(int l)
    {
        h = l;
        invalidate();
    }

    protected boolean verifyDrawable(Drawable drawable)
    {
        return drawable == g || super.verifyDrawable(drawable);
    }
}
