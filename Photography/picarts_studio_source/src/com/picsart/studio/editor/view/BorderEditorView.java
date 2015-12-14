// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.picsart.studio.editor.Camera;
import com.picsart.studio.editor.utils.UserSavedState;
import com.socialin.android.util.c;
import com.socialin.android.util.w;
import myobfuscated.bq.a;
import myobfuscated.bq.b;

public class BorderEditorView extends View
{

    public int a;
    public int b;
    public int c;
    public int d;
    public Mode e;
    public float f;
    public boolean g;
    public Bitmap h;
    private int i;
    private float j;
    private Paint k;
    private Paint l;
    private Paint m;
    private Paint n;
    private Paint o;
    private RectF p;
    private RectF q;
    private RectF r;
    private RectF s;
    private Camera t;
    private a u;
    private com.socialin.android.colorpicker.c v;
    private boolean w;
    private Bitmap x;
    private Bitmap y;

    public BorderEditorView(Context context)
    {
        this(context, null);
    }

    public BorderEditorView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public BorderEditorView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        w = false;
        g = false;
        new RectF();
        t = Camera.a();
        k = new Paint(2);
        n = new Paint(1);
        l = new Paint();
        l.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC));
        m = new Paint();
        e = Mode.OUTER;
        p = new RectF();
        q = new RectF();
        r = new RectF();
        s = new RectF();
        o = new Paint();
        o.setShader(new BitmapShader(BitmapFactory.decodeResource(getResources(), 0x7f020120), android.graphics.Shader.TileMode.REPEAT, android.graphics.Shader.TileMode.REPEAT));
        u = new a(getResources(), new b() {

            private BorderEditorView a;

            public final int a(int j1, int k1)
            {
                return com.picsart.studio.editor.view.BorderEditorView.a(a).getPixel(Math.min(Math.max(j1 / 2, 0), com.picsart.studio.editor.view.BorderEditorView.a(a).getWidth() - 1), Math.min(Math.max(k1 / 2, 0), com.picsart.studio.editor.view.BorderEditorView.a(a).getHeight() - 1));
            }

            
            {
                a = BorderEditorView.this;
                super();
            }
        });
        setLayerType(1, null);
    }

    static Bitmap a(BorderEditorView bordereditorview)
    {
        return bordereditorview.x;
    }

    private void a(boolean flag)
    {
        float f1 = getWidth();
        float f3 = getHeight();
        RectF rectf = new RectF(getPaddingLeft(), getPaddingTop(), f1 - (float)getPaddingRight(), f3 - (float)getPaddingBottom());
        t.a(getWidth(), getHeight());
        if (flag)
        {
            s.set(p);
            if (h != null)
            {
                t.a(s, rectf, com.picsart.studio.editor.Camera.ScaleToFit.CENTER);
            }
            f = t.e;
        }
        if (h != null)
        {
            RectF rectf1 = s;
            if (h != null)
            {
                rectf1.set(p);
                float f4 = (float)a / f;
                float f5 = (float)c / f;
                float f2 = f4;
                if (e == Mode.OUTER)
                {
                    f2 = f4 + f5;
                }
                rectf1.inset(-f2, -f2);
            }
            t.a(s, rectf, com.picsart.studio.editor.Camera.ScaleToFit.CENTER);
        }
    }

    public final void a()
    {
        w = true;
        x = com.socialin.android.util.c.a(getWidth() / 2, getHeight() / 2, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(x);
        canvas.scale(0.5F, 0.5F);
        draw(canvas);
        w = false;
        g = true;
        u.a(x.getWidth(), x.getHeight());
        u.a = x.getPixel(x.getWidth() / 2, x.getHeight() / 2);
    }

    public final void a(Canvas canvas)
    {
        if (h != null)
        {
            float f1;
            float f2;
            if (h != null)
            {
                if (y != null)
                {
                    canvas.save();
                    canvas.scale(h.getWidth() / y.getWidth(), h.getHeight() / y.getHeight());
                    canvas.drawBitmap(y, null, p, k);
                    canvas.restore();
                } else
                {
                    canvas.drawBitmap(h, null, p, k);
                }
            }
            f1 = (float)a / f;
            f2 = (float)c / f;
            if (a > 0)
            {
                n.setColor(b);
                n.setStrokeWidth(f1);
                n.setStyle(android.graphics.Paint.Style.STROKE);
                canvas.drawRect(-f1 / 2.0F, -f1 / 2.0F, (float)h.getWidth() + f1 / 2.0F, (float)h.getHeight() + f1 / 2.0F, n);
            }
            if (c > 0)
            {
                n.setColor(d);
                n.setStrokeWidth(f2);
                n.setStyle(android.graphics.Paint.Style.STROKE);
                canvas.drawRect(f2 / 2.0F, f2 / 2.0F, (float)h.getWidth() - f2 / 2.0F, (float)h.getHeight() - f2 / 2.0F, n);
                return;
            }
        }
    }

    public final void b(Canvas canvas)
    {
        if (h != null)
        {
            float f3 = (float)h.getWidth() / (float)y.getWidth();
            float f4 = (float)a / f;
            float f1 = (float)c / f;
            f4 += f1;
            n.setColor(b);
            n.setStyle(android.graphics.Paint.Style.FILL);
            canvas.drawRect((float)Math.ceil(-f4), (float)Math.ceil(-f4), (float)Math.floor((float)h.getWidth() + f4), (float)Math.floor(f4 + (float)h.getHeight()), n);
            canvas.save();
            canvas.scale(f3, f3);
            f3 = Math.max((float)i * j - f1 / 2.0F, 0.0F) / f3;
            canvas.drawRoundRect(q, f3, f3, l);
            canvas.restore();
            n.setColor(d);
            n.setAlpha(255);
            n.setStrokeWidth(f1);
            n.setStyle(android.graphics.Paint.Style.STROKE);
            r.set((float)Math.ceil(-f1 / 2.0F), (float)Math.ceil(-f1 / 2.0F), (float)Math.floor((float)h.getWidth() + f1 / 2.0F), (float)Math.floor((float)h.getHeight() + f1 / 2.0F));
            if (f1 > 0.0F)
            {
                if (i != 0)
                {
                    float f2 = j * (float)i;
                    canvas.drawRoundRect(r, f2, f2, n);
                    return;
                } else
                {
                    canvas.drawRect(r, n);
                    return;
                }
            }
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (y != null && y != h)
        {
            y.recycle();
            y = null;
        }
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (!isInEditMode()) goto _L2; else goto _L1
_L1:
        canvas.drawColor(0xffff0000);
_L4:
        if (!w && g)
        {
            u.a(canvas);
        }
        return;
_L2:
        if (h != null)
        {
            t.b(canvas);
            if (e == Mode.OUTER)
            {
                b(canvas);
            } else
            {
                a(canvas);
            }
            canvas.restore();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(((UserSavedState) (parcelable)).a);
        a = com.picsart.studio.editor.view.SavedState.a(parcelable);
        b = com.picsart.studio.editor.view.SavedState.b(parcelable);
        c = com.picsart.studio.editor.view.SavedState.c(parcelable);
        d = SavedState.d(parcelable);
        i = SavedState.e(parcelable);
        e = SavedState.f(parcelable);
        f = SavedState.g(parcelable);
    }

    protected Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        com.picsart.studio.editor.view.SavedState.a(savedstate, a);
        com.picsart.studio.editor.view.SavedState.b(savedstate, b);
        com.picsart.studio.editor.view.SavedState.c(savedstate, c);
        SavedState.d(savedstate, d);
        SavedState.e(savedstate, i);
        com.picsart.studio.editor.view.SavedState.a(savedstate, e);
        com.picsart.studio.editor.view.SavedState.a(savedstate, f);
        return savedstate;
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        if (h != null && i1 != 0 && j1 != 0)
        {
            a(true);
            if (g)
            {
                a();
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (g)
        {
            if (motionevent.getActionMasked() == 1)
            {
                v.a(u.a);
                x.recycle();
                g = false;
            } else
            {
                float f1 = motionevent.getX();
                float f2 = motionevent.getY();
                u.a(motionevent.getActionMasked(), f1, f2);
            }
            invalidate();
        }
        return true;
    }

    public void setColorSelectedListener(com.socialin.android.colorpicker.c c1)
    {
        v = c1;
    }

    public void setCornerRadius(int i1)
    {
        i = i1;
        invalidate();
    }

    public void setEyeDropperActive(boolean flag)
    {
        g = flag;
        if (!g && x != null && !x.isRecycled())
        {
            x.recycle();
        }
    }

    public void setImage(Bitmap bitmap)
    {
        h = bitmap;
        if (bitmap != null)
        {
            y = com.socialin.android.util.w.f(bitmap, 2048);
            p.set(0.0F, 0.0F, bitmap.getWidth(), bitmap.getHeight());
            q.set(0.0F, 0.0F, y.getWidth(), y.getHeight());
            l.setShader(new BitmapShader(y, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP));
            m.setShader(new BitmapShader(y, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP));
            if (getWidth() != 0 && getHeight() != 0)
            {
                a(false);
            }
            j = (float)Math.min(bitmap.getWidth(), bitmap.getHeight()) / 180F;
        }
    }

    public void setInnerBorderColor(int i1)
    {
        int j1 = Color.alpha(d);
        d = 0xffffff & i1;
        d = j1 << 24 | d;
        invalidate();
    }

    public void setInnerBorderOpacity(int i1)
    {
        d = d & 0xffffff;
        d = d | i1 << 24;
        invalidate();
    }

    public void setInnerBorderSize(int i1)
    {
        c = i1;
        a(false);
        invalidate();
    }

    public void setMode(Mode mode)
    {
        e = mode;
        a(false);
        invalidate();
    }

    public void setOuterBorderColor(int i1)
    {
        b = i1;
        invalidate();
    }

    public void setOuterBorderSize(int i1)
    {
        a = i1;
        a(false);
        invalidate();
    }

    private class Mode extends Enum
    {

        private static final Mode $VALUES[];
        public static final Mode INNER;
        public static final Mode OUTER;

        public static Mode valueOf(String s1)
        {
            return (Mode)Enum.valueOf(com/picsart/studio/editor/view/BorderEditorView$Mode, s1);
        }

        public static Mode[] values()
        {
            return (Mode[])$VALUES.clone();
        }

        static 
        {
            INNER = new Mode("INNER", 0);
            OUTER = new Mode("OUTER", 1);
            $VALUES = (new Mode[] {
                INNER, OUTER
            });
        }

        private Mode(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    private class SavedState extends UserSavedState
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
        private int b;
        private int c;
        private int d;
        private int e;
        private int f;
        private Mode g;
        private float h;

        static float a(SavedState savedstate, float f1)
        {
            savedstate.h = f1;
            return f1;
        }

        static int a(SavedState savedstate)
        {
            return savedstate.b;
        }

        static int a(SavedState savedstate, int i1)
        {
            savedstate.b = i1;
            return i1;
        }

        static Mode a(SavedState savedstate, Mode mode)
        {
            savedstate.g = mode;
            return mode;
        }

        static int b(SavedState savedstate)
        {
            return savedstate.c;
        }

        static int b(SavedState savedstate, int i1)
        {
            savedstate.c = i1;
            return i1;
        }

        static int c(SavedState savedstate)
        {
            return savedstate.d;
        }

        static int c(SavedState savedstate, int i1)
        {
            savedstate.d = i1;
            return i1;
        }

        static int d(SavedState savedstate)
        {
            return savedstate.e;
        }

        static int d(SavedState savedstate, int i1)
        {
            savedstate.e = i1;
            return i1;
        }

        static int e(SavedState savedstate)
        {
            return savedstate.f;
        }

        static int e(SavedState savedstate, int i1)
        {
            savedstate.f = i1;
            return i1;
        }

        static Mode f(SavedState savedstate)
        {
            return savedstate.g;
        }

        static float g(SavedState savedstate)
        {
            return savedstate.h;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            parcel.writeInt(b);
            parcel.writeInt(c);
            parcel.writeInt(d);
            parcel.writeInt(e);
            parcel.writeInt(f);
            parcel.writeSerializable(g);
            parcel.writeFloat(h);
        }


        public SavedState(Parcel parcel)
        {
            super(parcel);
            b = parcel.readInt();
            c = parcel.readInt();
            d = parcel.readInt();
            e = parcel.readInt();
            f = parcel.readInt();
            g = (Mode)parcel.readSerializable();
            h = parcel.readFloat();
        }

        public SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

}
