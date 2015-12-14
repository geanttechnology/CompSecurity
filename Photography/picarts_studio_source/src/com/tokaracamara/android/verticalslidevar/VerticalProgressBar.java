// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tokaracamara.android.verticalslidevar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import myobfuscated.be.a;

// Referenced classes of package com.tokaracamara.android.verticalslidevar:
//            a

public class VerticalProgressBar extends View
{

    int a;
    int b;
    int c;
    int d;
    Drawable e;
    Drawable f;
    private int g;
    private int h;
    private int i;
    private Bitmap j;
    private boolean k;
    private com.tokaracamara.android.verticalslidevar.a l;
    private long m;

    public VerticalProgressBar(Context context)
    {
        this(context, null);
    }

    public VerticalProgressBar(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x1010077);
    }

    public VerticalProgressBar(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        m = Thread.currentThread().getId();
        i = 100;
        g = 0;
        h = 0;
        a = 24;
        b = 48;
        c = 24;
        d = 48;
        context = context.obtainStyledAttributes(attributeset, a.ProgressBar, i1, 0);
        k = true;
        attributeset = context.getDrawable(a.ProgressBar_android_progressDrawable);
        if (attributeset != null)
        {
            setProgressDrawable(a(attributeset, false));
        }
        a = context.getDimensionPixelSize(a.ProgressBar_android_minWidth, a);
        b = context.getDimensionPixelSize(a.ProgressBar_android_maxWidth, b);
        c = context.getDimensionPixelSize(a.ProgressBar_android_minHeight, c);
        d = context.getDimensionPixelSize(a.ProgressBar_android_maxHeight, d);
        setMax(context.getInt(a.ProgressBar_android_max, i));
        setProgress(context.getInt(a.ProgressBar_android_progress, g));
        setSecondaryProgress(context.getInt(a.ProgressBar_android_secondaryProgress, h));
        k = false;
        context.recycle();
    }

    private Drawable a(Drawable drawable, boolean flag)
    {
        boolean flag1 = false;
        Object obj;
        if (drawable instanceof LayerDrawable)
        {
            drawable = (LayerDrawable)drawable;
            int k1 = drawable.getNumberOfLayers();
            Drawable adrawable[] = new Drawable[k1];
            int i1 = 0;
            while (i1 < k1) 
            {
                int l1 = drawable.getId(i1);
                Drawable drawable1 = drawable.getDrawable(i1);
                if (l1 == 0x102000d || l1 == 0x102000f)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                adrawable[i1] = a(drawable1, flag);
                i1++;
            }
            obj = new LayerDrawable(adrawable);
            for (int j1 = ((flag1) ? 1 : 0); j1 < k1; j1++)
            {
                ((LayerDrawable) (obj)).setId(j1, drawable.getId(j1));
            }

        } else
        {
            if (drawable instanceof StateListDrawable)
            {
                return new StateListDrawable();
            }
            obj = drawable;
            if (drawable instanceof myobfuscated.cd.a)
            {
                drawable = ((myobfuscated.cd.a)drawable).getBitmap();
                if (j == null)
                {
                    j = drawable;
                }
                drawable = new ShapeDrawable(new RoundRectShape(new float[] {
                    5F, 5F, 5F, 5F, 5F, 5F, 5F, 5F
                }, null, null));
                if (flag)
                {
                    return new ClipDrawable(drawable, 3, 1);
                } else
                {
                    return drawable;
                }
            }
        }
        return ((Drawable) (obj));
    }

    static com.tokaracamara.android.verticalslidevar.a a(VerticalProgressBar verticalprogressbar, com.tokaracamara.android.verticalslidevar.a a1)
    {
        verticalprogressbar.l = a1;
        return a1;
    }

    private void a(int i1, int j1, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (i <= 0) goto _L2; else goto _L1
_L1:
        float f1 = (float)j1 / (float)i;
_L5:
        Object obj1 = f;
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        Object obj = null;
        if (obj1 instanceof LayerDrawable)
        {
            obj = ((LayerDrawable)obj1).findDrawableByLayerId(i1);
        }
        break MISSING_BLOCK_LABEL_98;
_L7:
        ((Drawable) (obj1)).setLevel(j1);
_L6:
        if (i1 != 0x102000d)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        a(f1, flag);
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        f1 = 0.0F;
          goto _L5
_L4:
        invalidate();
          goto _L6
        obj;
        throw obj;
        j1 = (int)(10000F * f1);
        if (obj != null)
        {
            obj1 = obj;
        }
          goto _L7
    }

    static void a(VerticalProgressBar verticalprogressbar, int i1, int j1, boolean flag)
    {
        verticalprogressbar.a(i1, j1, flag);
    }

    private void b(int i1, int j1, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (m != Thread.currentThread().getId()) goto _L2; else goto _L1
_L1:
        a(i1, j1, flag);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Object obj;
        if (l == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = l;
        l = null;
        obj.a = i1;
        obj.b = j1;
        obj.c = flag;
_L5:
        post(((Runnable) (obj)));
        if (true) goto _L4; else goto _L3
        obj;
        throw obj;
_L3:
        obj = new com.tokaracamara.android.verticalslidevar.a(this, i1, j1, flag);
          goto _L5
    }

    public final int a()
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = g;
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    void a(float f1, boolean flag)
    {
    }

    final void a(int i1, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        int j1;
        if (i1 < 0)
        {
            i1 = 0;
        }
        j1 = i1;
        if (i1 > i)
        {
            j1 = i;
        }
        if (j1 != g)
        {
            g = j1;
            b(0x102000d, g, flag);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final int b()
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = i;
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        int ai[] = getDrawableState();
        if (e != null && e.isStateful())
        {
            e.setState(ai);
        }
    }

    public void invalidateDrawable(Drawable drawable)
    {
        if (verifyDrawable(drawable))
        {
            drawable = drawable.getBounds();
            invalidate(((Rect) (drawable)).left + 0, ((Rect) (drawable)).top + 0, ((Rect) (drawable)).right + 0, ((Rect) (drawable)).bottom + 0);
            return;
        } else
        {
            super.invalidateDrawable(drawable);
            return;
        }
    }

    protected void onDraw(Canvas canvas)
    {
        this;
        JVM INSTR monitorenter ;
        Drawable drawable;
        super.onDraw(canvas);
        drawable = f;
        if (drawable == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        canvas.save();
        canvas.translate(0.0F, 0.0F);
        drawable.draw(canvas);
        canvas.restore();
        this;
        JVM INSTR monitorexit ;
        return;
        canvas;
        throw canvas;
    }

    protected void onMeasure(int i1, int j1)
    {
        int k1 = 0;
        this;
        JVM INSTR monitorenter ;
        Drawable drawable = f;
        if (drawable == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        int l1;
        l1 = Math.max(a, Math.min(b, drawable.getIntrinsicWidth()));
        k1 = Math.max(c, Math.min(d, drawable.getIntrinsicHeight()));
_L1:
        setMeasuredDimension(resolveSize(l1 + 0, i1), resolveSize(k1 + 0, j1));
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
        l1 = 0;
          goto _L1
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        setProgress(((SavedState) (parcelable)).a);
        setSecondaryProgress(((SavedState) (parcelable)).b);
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.a = g;
        savedstate.b = h;
        return savedstate;
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        if (e != null)
        {
            e.setBounds(0, 0, i1 + 0 + 0, j1 + 0 + 0);
        }
    }

    public void postInvalidate()
    {
        if (!k)
        {
            super.postInvalidate();
        }
    }

    public void setMax(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        int j1;
        j1 = i1;
        if (i1 < 0)
        {
            j1 = 0;
        }
        if (j1 != i)
        {
            i = j1;
            postInvalidate();
            if (g > j1)
            {
                g = j1;
                b(0x102000d, g, false);
            }
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setProgress(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        a(i1, false);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setProgressDrawable(Drawable drawable)
    {
        if (drawable != null)
        {
            drawable.setCallback(this);
            int i1 = drawable.getMinimumHeight();
            if (d < i1)
            {
                d = i1;
                requestLayout();
            }
        }
        e = drawable;
        f = drawable;
        postInvalidate();
    }

    public void setSecondaryProgress(int i1)
    {
        int j1 = 0;
        this;
        JVM INSTR monitorenter ;
        if (i1 < 0)
        {
            i1 = j1;
        }
        j1 = i1;
        if (i1 > i)
        {
            j1 = i;
        }
        if (j1 != h)
        {
            h = j1;
            b(0x102000f, h, false);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setVisibility(int i1)
    {
        if (getVisibility() != i1)
        {
            super.setVisibility(i1);
        }
    }

    protected boolean verifyDrawable(Drawable drawable)
    {
        return drawable == e || super.verifyDrawable(drawable);
    }

    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public final Object createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel, (byte)0);
            }

            public final volatile Object[] newArray(int i1)
            {
                return new SavedState[i1];
            }

        };
        int a;
        int b;

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            parcel.writeInt(a);
            parcel.writeInt(b);
        }


        private SavedState(Parcel parcel)
        {
            super(parcel);
            a = parcel.readInt();
            b = parcel.readInt();
        }

        SavedState(Parcel parcel, byte byte0)
        {
            this(parcel);
        }

        SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

}
