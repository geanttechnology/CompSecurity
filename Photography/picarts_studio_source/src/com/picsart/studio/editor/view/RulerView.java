// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.picsart.studio.editor.view:
//            r

public class RulerView extends View
{

    private static final Orientation a;
    private Orientation b;
    private float c;
    private float d;
    private r e;
    private RectF f;
    private Drawable g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private Paint s;
    private Paint t;

    public RulerView(Context context)
    {
        this(context, null);
    }

    public RulerView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public RulerView(Context context, AttributeSet attributeset, int i1)
    {
        int j1;
        super(context, attributeset, i1);
        setSaveEnabled(true);
        b = a;
        q = -45F;
        r = 45F;
        f = new RectF();
        g = context.getResources().getDrawable(0x7f020072);
        if (g != null)
        {
            g.setBounds(-g.getIntrinsicWidth() / 2, -g.getIntrinsicHeight() / 2, g.getIntrinsicWidth() / 2, g.getIntrinsicHeight() / 2);
        }
        s = new Paint();
        s.setStyle(android.graphics.Paint.Style.STROKE);
        s.setColor(0xff7c7c7c);
        t = new TextPaint();
        t.setTextSize(getResources().getDimension(0x7f0b00c3));
        t.setTextAlign(android.graphics.Paint.Align.CENTER);
        t.setColor(0xff7c7c7c);
        h = getResources().getDimension(0x7f0b00bf);
        i = getResources().getDimension(0x7f0b00bc);
        j = getResources().getDimension(0x7f0b00c1);
        k = getResources().getDimension(0x7f0b00be);
        l = getResources().getDimension(0x7f0b00c0);
        m = getResources().getDimension(0x7f0b00bd);
        p = getResources().getDimension(0x7f0b00c2);
        if (attributeset == null)
        {
            break MISSING_BLOCK_LABEL_428;
        }
        context = context.obtainStyledAttributes(attributeset, com.picsart.studio.R.styleable.AngleRuler);
        j1 = context.getIndexCount();
        i1 = 0;
_L7:
        if (i1 >= j1)
        {
            break MISSING_BLOCK_LABEL_424;
        }
        context.getIndex(i1);
        JVM INSTR tableswitch 0 3: default 336
    //                   0 343
    //                   1 382
    //                   2 396
    //                   3 410;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_410;
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break; /* Loop/switch isn't completed */
_L8:
        i1++;
        if (true) goto _L7; else goto _L6
_L6:
        int k1 = context.getInteger(i1, 0);
        if (k1 == 0)
        {
            b = Orientation.HORIZONTAL;
        } else
        if (k1 == 1)
        {
            b = Orientation.VERTICAL;
        }
          goto _L8
_L3:
        n = context.getDimension(i1, 10F);
          goto _L8
_L4:
        q = context.getFloat(i1, -45F);
          goto _L8
        r = context.getFloat(i1, 45F);
          goto _L8
        context.recycle();
    }

    private void a(float f1, boolean flag)
    {
        o = f1;
        if (flag && e != null)
        {
            e.a(f1);
        }
        invalidate();
    }

    private boolean a()
    {
        return b == Orientation.HORIZONTAL;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (a())
        {
            t.setTextAlign(android.graphics.Paint.Align.CENTER);
            float f1 = f.centerX();
            float f3 = f.bottom - m / 2.0F;
            float f5 = f.width();
            int i1 = (int)(o - f5 / 2.0F / n);
            do
            {
                float f7 = ((float)i1 - o) * n + f1;
                if (f7 <= f5)
                {
                    if ((float)(i1 % 10) == 0.0F)
                    {
                        if ((float)i1 >= q && (float)i1 <= r)
                        {
                            canvas.drawText(String.valueOf(i1), f7, f3 - m / 2.0F - p, t);
                        }
                        s.setStrokeWidth(l);
                        canvas.drawLine(f7, f3 + m / 2.0F, f7, f3 - m / 2.0F, s);
                    } else
                    if (i1 % 5 == 0)
                    {
                        s.setStrokeWidth(j);
                        canvas.drawLine(f7, f3 + k / 2.0F, f7, f3 - k / 2.0F, s);
                    } else
                    {
                        s.setStrokeWidth(h);
                        canvas.drawLine(f7, f3 + i / 2.0F, f7, f3 - i / 2.0F, s);
                    }
                    i1++;
                } else
                {
                    canvas.save();
                    canvas.translate(f1, f3);
                    g.draw(canvas);
                    canvas.restore();
                    return;
                }
            } while (true);
        }
        t.setTextAlign(android.graphics.Paint.Align.RIGHT);
        float f2 = f.right - m / 2.0F;
        float f4 = f.centerY();
        float f6 = f.height();
        int j1 = (int)(o + f6 / 2.0F / n);
        do
        {
            float f8 = (o - (float)j1) * n + f4;
            if (f8 <= f6)
            {
                if (j1 % 10 == 0)
                {
                    if ((float)j1 >= q && (float)j1 <= r)
                    {
                        canvas.drawText(String.valueOf(j1), f2 - m / 2.0F - p, f8, t);
                    }
                    s.setStrokeWidth(l);
                    canvas.drawLine(f2 + m / 2.0F, f8, f2 - m / 2.0F, f8, s);
                } else
                if (j1 % 5 == 0)
                {
                    s.setStrokeWidth(j);
                    canvas.drawLine(f2 + k / 2.0F, f8, f2 - k / 2.0F, f8, s);
                } else
                {
                    s.setStrokeWidth(h);
                    canvas.drawLine(f2 + i / 2.0F, f8, f2 - i / 2.0F, f8, s);
                }
                j1--;
            } else
            {
                canvas.save();
                canvas.translate(f2, f4);
                canvas.rotate(270F);
                g.draw(canvas);
                canvas.restore();
                return;
            }
        } while (true);
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        o = SavedState.a(parcelable);
    }

    protected Parcelable onSaveInstanceState()
    {
        return new SavedState(super.onSaveInstanceState(), o);
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        f.set(getPaddingLeft(), getPaddingTop(), i1 - getPaddingRight(), j1 - getPaddingBottom());
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        float f2;
        float f3;
        f2 = motionevent.getX();
        f3 = motionevent.getY();
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 2: default 40
    //                   0 42
    //                   1 158
    //                   2 71;
           goto _L1 _L2 _L3 _L4
_L1:
        return true;
_L2:
        c = f2;
        d = f3;
        if (e != null)
        {
            e.a();
            return true;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (e != null)
        {
            float f1 = c;
            float f4 = d;
            if (a())
            {
                f1 = (f2 - f1) / n;
            } else
            {
                f1 = -(f3 - f4) / n;
            }
            a(Math.min(Math.max(o - f1, q), r), true);
            c = f2;
            d = f3;
            return true;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (e != null)
        {
            e.a();
            return true;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void setOnProgressChangedListener(r r1)
    {
        e = r1;
    }

    public void setProgress(float f1)
    {
        a(f1, false);
    }

    static 
    {
        a = Orientation.HORIZONTAL;
    }

    private class Orientation extends Enum
    {

        private static final Orientation $VALUES[];
        public static final Orientation HORIZONTAL;
        public static final Orientation VERTICAL;

        public static Orientation valueOf(String s1)
        {
            return (Orientation)Enum.valueOf(com/picsart/studio/editor/view/RulerView$Orientation, s1);
        }

        public static Orientation[] values()
        {
            return (Orientation[])$VALUES.clone();
        }

        static 
        {
            HORIZONTAL = new Orientation("HORIZONTAL", 0);
            VERTICAL = new Orientation("VERTICAL", 1);
            $VALUES = (new Orientation[] {
                HORIZONTAL, VERTICAL
            });
        }

        private Orientation(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public final Object createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public final volatile Object[] newArray(int i1)
            {
                return new SavedState[i1];
            }

        };
        private float a;

        static float a(SavedState savedstate)
        {
            return savedstate.a;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            parcel.writeFloat(a);
        }


        public SavedState(Parcel parcel)
        {
            super(parcel);
            a = parcel.readFloat();
        }

        public SavedState(Parcelable parcelable, float f1)
        {
            super(parcelable);
            a = f1;
        }
    }

}
