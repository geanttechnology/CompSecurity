// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.picsart.studio.editor.utils.UserSavedState;
import com.socialin.android.brushlib.input.gesture.d;
import com.socialin.android.brushlib.input.gesture.i;
import com.socialin.android.util.Geom;
import com.socialin.android.util.ag;
import com.socialin.android.util.w;

// Referenced classes of package com.picsart.studio.editor.view:
//            m, n, RulerView

public class PerspectiveView extends View
{

    private RectF A;
    private RectF B;
    private RectF C;
    private Matrix D;
    private n E;
    public Bitmap a;
    public Paint b;
    public float c;
    public float d;
    public RectF e;
    public Matrix f;
    public PerspectiveMode g;
    public boolean h;
    public ValueAnimator i;
    private Bitmap j;
    private d k;
    private RulerView l;
    private final int m;
    private float n;
    private float o;
    private float p;
    private float q;
    private Paint r;
    private Paint s;
    private boolean t;
    private boolean u;
    private float v[];
    private float w[];
    private RectF x;
    private Camera y;
    private RectF z;

    public PerspectiveView(Context context)
    {
        this(context, null);
    }

    public PerspectiveView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public PerspectiveView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        v = new float[8];
        w = new float[8];
        x = new RectF();
        A = new RectF();
        B = new RectF();
        e = new RectF();
        new Matrix();
        f = new Matrix();
        D = new Matrix();
        m = context.getResources().getColor(0x7f0f000e);
        g = PerspectiveMode.HORIZONTAL;
        y = new Camera();
        r = new Paint();
        r.setStyle(android.graphics.Paint.Style.STROKE);
        r.setStrokeJoin(android.graphics.Paint.Join.MITER);
        r.setStrokeCap(android.graphics.Paint.Cap.BUTT);
        s = new Paint();
        s.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
        b = new Paint(2);
        n = 4F;
        o = 2.0F;
        p = 3F;
        q = 1.0F;
        context = new m(this, (byte)0);
        k = new d();
        k.a(new i(context));
    }

    static PerspectiveMode a(PerspectiveView perspectiveview)
    {
        return perspectiveview.g;
    }

    private void a()
    {
        if (a != null && j != null)
        {
            C = new RectF(0.0F, 0.0F, j.getWidth(), j.getHeight());
            A.set(C);
            Geom.a(A, z, com.socialin.android.util.Geom.Fit.CENTER);
            float f1 = e.width() / 2.0F;
            float f2 = e.height() / 2.0F;
            B.set(0.0F, 0.0F, A.width(), A.height());
            w[0] = -f1;
            w[1] = -f2;
            w[2] = f1;
            w[3] = -f2;
            w[4] = f1;
            w[5] = f2;
            w[6] = -f1;
            w[7] = f2;
        }
    }

    static boolean a(PerspectiveView perspectiveview, boolean flag)
    {
        perspectiveview.h = flag;
        return flag;
    }

    static float b(PerspectiveView perspectiveview)
    {
        return perspectiveview.d;
    }

    private void b()
    {
        if (E != null)
        {
            E.b();
        }
    }

    static boolean b(PerspectiveView perspectiveview, boolean flag)
    {
        perspectiveview.t = flag;
        return flag;
    }

    static RulerView c(PerspectiveView perspectiveview)
    {
        return perspectiveview.l;
    }

    static float d(PerspectiveView perspectiveview)
    {
        return perspectiveview.c;
    }

    static ValueAnimator e(PerspectiveView perspectiveview)
    {
        return perspectiveview.i;
    }

    static ValueAnimator f(PerspectiveView perspectiveview)
    {
        perspectiveview.i = null;
        return null;
    }

    static boolean g(PerspectiveView perspectiveview)
    {
        return perspectiveview.t;
    }

    public final void a(RectF rectf)
    {
        y.save();
        y.setLocation(0.0F, 0.0F, -8F);
        y.rotate(-c, -d, 0.0F);
        y.getMatrix(f);
        y.restore();
        Matrix matrix = f;
        float af[] = w;
        if (a != null)
        {
            float f1 = (float)a.getWidth() / (float)a.getHeight();
            matrix.mapPoints(v, af);
            af = v;
            if (af[0] > 0.0F)
            {
                af[0] = -af[0];
            }
            if (af[1] > 0.0F)
            {
                af[1] = -af[1];
            }
            if (af[2] < 0.0F)
            {
                af[2] = -af[2];
            }
            if (af[3] > 0.0F)
            {
                af[3] = -af[3];
            }
            if (af[4] < 0.0F)
            {
                af[4] = -af[4];
            }
            if (af[5] < 0.0F)
            {
                af[5] = -af[5];
            }
            if (af[6] > 0.0F)
            {
                af[6] = -af[6];
            }
            if (af[7] < 0.0F)
            {
                af[7] = -af[7];
            }
            Geom.a(x, v, f1);
            D.setRectToRect(x, rectf, android.graphics.Matrix.ScaleToFit.CENTER);
            matrix.postConcat(D);
        }
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (j != null && a != null)
        {
            a(A);
            canvas.save();
            canvas.concat(f);
            canvas.scale(e.width() / (float)j.getWidth(), e.height() / (float)j.getHeight());
            canvas.drawBitmap(j, (float)(-j.getWidth()) / 2.0F, (float)(-j.getHeight()) / 2.0F, null);
            canvas.restore();
        }
        canvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
        canvas.drawColor(m);
        canvas.drawRect(A, s);
        canvas.restore();
        canvas.save();
        float f1;
        float f2;
        int i1;
        if (t || u)
        {
            i1 = 8;
        } else
        {
            i1 = 2;
        }
        f1 = A.width() / ((float)i1 + 1.0F);
        f2 = A.height() / ((float)i1 + 1.0F);
        r.setColor(0x80000000);
        r.setStrokeWidth(p);
        for (int j1 = 1; j1 <= i1; j1++)
        {
            float f3 = A.left;
            float f5 = A.top;
            float f7 = j1;
            float f9 = A.right;
            float f11 = A.top;
            canvas.drawLine(f3, f7 * f2 + f5, f9, (float)j1 * f2 + f11, r);
            f3 = A.left;
            f5 = j1;
            f7 = A.top;
            f9 = A.left;
            canvas.drawLine(f5 * f1 + f3, f7, (float)j1 * f1 + f9, A.bottom, r);
        }

        r.setColor(-1);
        r.setStrokeWidth(q);
        for (int k1 = 1; k1 <= i1; k1++)
        {
            float f4 = A.left;
            float f6 = A.top;
            float f8 = k1;
            float f10 = A.right;
            float f12 = A.top;
            canvas.drawLine(f4, f8 * f2 + f6, f10, (float)k1 * f2 + f12, r);
            f4 = A.left;
            f6 = k1;
            f8 = A.top;
            f10 = A.left;
            canvas.drawLine(f6 * f1 + f4, f8, (float)k1 * f1 + f10, A.bottom, r);
        }

        r.setColor(0x80000000);
        r.setStrokeWidth(n);
        canvas.drawRect(A, r);
        r.setColor(-1);
        r.setStrokeWidth(o);
        canvas.drawRect(A, r);
        canvas.restore();
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(((UserSavedState) (parcelable)).a);
        c = SavedState.a(parcelable);
        d = SavedState.b(parcelable);
        g = SavedState.c(parcelable);
        t = com.picsart.studio.editor.view.SavedState.d(parcelable);
    }

    protected Parcelable onSaveInstanceState()
    {
        return new SavedState(super.onSaveInstanceState(), this);
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        z = new RectF(getPaddingLeft(), getPaddingTop(), (float)i1 - (float)getPaddingRight(), (float)j1 - (float)getPaddingBottom());
        a();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        k.a(motionevent);
        return true;
    }

    public void setHorizontalPerspective(float f1)
    {
        d = Geom.a(f1, -45F, 45F);
        b();
        invalidate();
    }

    public void setImage(Bitmap bitmap)
    {
        a = bitmap;
        j = com.socialin.android.util.w.f(bitmap, 2048);
        if (j.getWidth() < j.getHeight())
        {
            float f1 = ((float)j.getWidth() * 1024F) / (float)j.getHeight();
            e.set(0.0F, 0.0F, f1, 1024F);
        } else
        {
            float f2 = ((float)j.getHeight() * 1024F) / (float)j.getWidth();
            e.set(0.0F, 0.0F, 1024F, f2);
        }
        if (getWidth() > 0 && getHeight() > 0)
        {
            a();
        }
        invalidate();
    }

    public void setMode(PerspectiveMode perspectivemode)
    {
        g = perspectivemode;
        if (E != null)
        {
            E.a();
        }
    }

    public void setOnPerspectiveChangedListener(n n1)
    {
        E = n1;
    }

    public void setRulerView(RulerView rulerview)
    {
        l = rulerview;
    }

    public void setSliderTouched(boolean flag)
    {
        u = flag;
        invalidate();
    }

    public void setVerticalPerspective(float f1)
    {
        c = Geom.a(f1, -45F, 45F);
        b();
        invalidate();
    }

    // Unreferenced inner class com/picsart/studio/editor/view/PerspectiveView$1

/* anonymous class */
    public final class _cls1
        implements android.animation.ValueAnimator.AnimatorUpdateListener
    {

        private PerspectiveView a;

        public final void onAnimationUpdate(ValueAnimator valueanimator)
        {
            if (PerspectiveView.a(a) == PerspectiveMode.HORIZONTAL)
            {
                a.setHorizontalPerspective(((Float)valueanimator.getAnimatedValue()).floatValue());
                PerspectiveView.c(a).setProgress(PerspectiveView.b(a));
                return;
            } else
            {
                a.setVerticalPerspective(((Float)valueanimator.getAnimatedValue()).floatValue());
                PerspectiveView.c(a).setProgress(com.picsart.studio.editor.view.PerspectiveView.d(a));
                return;
            }
        }

            public 
            {
                a = PerspectiveView.this;
                super();
            }
    }


    // Unreferenced inner class com/picsart/studio/editor/view/PerspectiveView$2

/* anonymous class */
    public final class _cls2 extends ag
    {

        private Runnable a;
        private PerspectiveView b;

        public final void onAnimationCancel(Animator animator)
        {
            super.onAnimationCancel(animator);
            PerspectiveView.a(b, false);
        }

        public final void onAnimationEnd(Animator animator)
        {
            PerspectiveView.a(b, false);
            PerspectiveView.e(b).removeAllListeners();
            PerspectiveView.e(b).removeAllUpdateListeners();
            PerspectiveView.f(b);
            if (a != null)
            {
                a.run();
            }
        }

        public final void onAnimationStart(Animator animator)
        {
            super.onAnimationStart(animator);
            PerspectiveView.a(b, true);
        }

            public 
            {
                b = PerspectiveView.this;
                a = null;
                super();
            }
    }


    private class PerspectiveMode extends Enum
    {

        private static final PerspectiveMode $VALUES[];
        public static final PerspectiveMode HORIZONTAL;
        public static final PerspectiveMode VERTICAL;

        public static PerspectiveMode valueOf(String s1)
        {
            return (PerspectiveMode)Enum.valueOf(com/picsart/studio/editor/view/PerspectiveView$PerspectiveMode, s1);
        }

        public static PerspectiveMode[] values()
        {
            return (PerspectiveMode[])$VALUES.clone();
        }

        static 
        {
            HORIZONTAL = new PerspectiveMode("HORIZONTAL", 0);
            VERTICAL = new PerspectiveMode("VERTICAL", 1);
            $VALUES = (new PerspectiveMode[] {
                HORIZONTAL, VERTICAL
            });
        }

        private PerspectiveMode(String s1, int i1)
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
        private float b;
        private float c;
        private PerspectiveMode d;
        private boolean e;

        static float a(SavedState savedstate)
        {
            return savedstate.b;
        }

        static float b(SavedState savedstate)
        {
            return savedstate.c;
        }

        static PerspectiveMode c(SavedState savedstate)
        {
            return savedstate.d;
        }

        static boolean d(SavedState savedstate)
        {
            return savedstate.e;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            parcel.writeFloat(b);
            parcel.writeFloat(c);
            parcel.writeSerializable(d);
            if (e)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
        }


        protected SavedState(Parcel parcel)
        {
            super(parcel);
            b = parcel.readFloat();
            c = parcel.readFloat();
            d = (PerspectiveMode)parcel.readSerializable();
            boolean flag;
            if (parcel.readInt() == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            e = flag;
        }

        protected SavedState(Parcelable parcelable, PerspectiveView perspectiveview)
        {
            super(parcelable);
            b = com.picsart.studio.editor.view.PerspectiveView.d(perspectiveview);
            c = PerspectiveView.b(perspectiveview);
            d = PerspectiveView.a(perspectiveview);
        }
    }

}
