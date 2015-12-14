// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.editor.helper.SimpleTransform;
import com.socialin.android.brushlib.input.gesture.a;
import com.socialin.android.brushlib.input.gesture.d;
import com.socialin.android.brushlib.input.gesture.g;
import com.socialin.android.util.Geom;
import com.socialin.android.util.ag;
import com.socialin.android.util.w;

// Referenced classes of package com.picsart.studio.editor.view:
//            s

public class SquareFitEditorView extends View
{

    private Rect A;
    private RectF B;
    private RectF C;
    private float D;
    public Bitmap a;
    public Paint b;
    public int c;
    public float d;
    public boolean e;
    public boolean f;
    public ValueAnimator g;
    public ValueAnimator h;
    public RectF i;
    public RectF j;
    public RectF k;
    public int l;
    private d m;
    private Bitmap n;
    private Bitmap o;
    private Paint p;
    private Paint q;
    private SimpleTransform r;
    private com.picsart.studio.editor.fragment.SquareFitFragment.SquareFitMode s;
    private int t;
    private Bitmap u;
    private final float v[];
    private boolean w;
    private float x;
    private RectF y;
    private RectF z;

    public SquareFitEditorView(Context context)
    {
        this(context, null);
    }

    public SquareFitEditorView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public SquareFitEditorView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        s = com.picsart.studio.editor.fragment.SquareFitFragment.SquareFitMode.BLUR;
        t = -1;
        v = new float[2];
        w = false;
        x = 0.0F;
        e = false;
        f = false;
        D = 1.0F;
        l = 0;
        b = new Paint(2);
        p = new Paint(3);
        q = new Paint();
        attributeset = new s(this, (byte)0);
        context = new g(attributeset);
        context.a = 0.0F;
        attributeset = new a(attributeset);
        m = new d();
        m.a(context);
        m.a(attributeset);
        i = new RectF();
        k = new RectF();
        z = new RectF();
        A = new Rect();
        B = new RectF();
        C = new RectF();
        j = new RectF();
        r = SimpleTransform.a();
    }

    static float a(SquareFitEditorView squarefiteditorview)
    {
        return squarefiteditorview.d;
    }

    static float a(SquareFitEditorView squarefiteditorview, float f1)
    {
        squarefiteditorview.d = f1;
        return f1;
    }

    private void a(Bitmap bitmap)
    {
        int i1 = Math.min(bitmap.getWidth(), bitmap.getHeight());
        A.set((bitmap.getWidth() - i1) / 2, (bitmap.getHeight() - i1) / 2, (bitmap.getWidth() + i1) / 2, (i1 + bitmap.getHeight()) / 2);
    }

    static void a(SquareFitEditorView squarefiteditorview, float f1, float f2)
    {
        RectF rectf = squarefiteditorview.C;
        Geom.a(squarefiteditorview.i, squarefiteditorview.B, squarefiteditorview.d);
        rectf.left = (squarefiteditorview.k.left + 10F) - squarefiteditorview.B.width() / 2.0F;
        rectf.right = (squarefiteditorview.k.right - 10F) + squarefiteditorview.B.width() / 2.0F;
        rectf.top = (squarefiteditorview.k.top + 10F) - squarefiteditorview.B.height() / 2.0F;
        rectf.bottom = (squarefiteditorview.k.bottom - 10F) + squarefiteditorview.B.height() / 2.0F;
        float f3;
        if (f1 > 0.0F)
        {
            f3 = f1 * Math.min(1.0F, (squarefiteditorview.C.right - squarefiteditorview.i.centerX()) / f1);
        } else
        {
            f3 = f1;
            if (f1 < 0.0F)
            {
                f3 = f1 * Math.min(1.0F, (squarefiteditorview.C.left - squarefiteditorview.i.centerX()) / f1);
            }
        }
        if (f2 > 0.0F)
        {
            f1 = f2 * Math.min(1.0F, (squarefiteditorview.C.bottom - squarefiteditorview.i.centerY()) / f2);
        } else
        {
            f1 = f2;
            if (f2 < 0.0F)
            {
                f1 = f2 * Math.min(1.0F, (squarefiteditorview.C.top - squarefiteditorview.i.centerY()) / f2);
            }
        }
        squarefiteditorview.i.offset(f3, f1);
        squarefiteditorview.invalidate();
    }

    static void a(SquareFitEditorView squarefiteditorview, float f1, float f2, float f3)
    {
        squarefiteditorview.v[0] = squarefiteditorview.i.centerX();
        squarefiteditorview.v[1] = squarefiteditorview.i.centerY();
        Geom.a(squarefiteditorview.v, f1, f2, f3);
        Geom.a(squarefiteditorview.i, squarefiteditorview.v[0], squarefiteditorview.v[1]);
        squarefiteditorview.x = squarefiteditorview.x + f1;
        if (Math.abs(squarefiteditorview.x) > 8F)
        {
            squarefiteditorview.x = 1000F;
            squarefiteditorview.d = squarefiteditorview.d + f1;
        }
        squarefiteditorview.d = squarefiteditorview.d % 360F;
        if (Math.abs(squarefiteditorview.d) > 180F)
        {
            squarefiteditorview.d = squarefiteditorview.d - (squarefiteditorview.d * 360F) / Math.abs(squarefiteditorview.d);
        }
        f1 = squarefiteditorview.e();
        if (Math.abs(f1) >= 8F)
        {
            squarefiteditorview.w = true;
        }
        if (squarefiteditorview.d != squarefiteditorview.d())
        {
            squarefiteditorview.d = squarefiteditorview.d();
            squarefiteditorview.w = false;
            squarefiteditorview.x = (4F * Math.abs(f1)) / f1;
        }
        squarefiteditorview.invalidate();
    }

    static boolean a(SquareFitEditorView squarefiteditorview, boolean flag)
    {
        squarefiteditorview.e = flag;
        return flag;
    }

    static RectF b(SquareFitEditorView squarefiteditorview)
    {
        return squarefiteditorview.i;
    }

    private void b()
    {
        z.set(0.0F, 0.0F, c, c);
        Geom.a(z, y, com.socialin.android.util.Geom.Fit.CENTER);
        SimpleTransform simpletransform = r;
        simpletransform.c = z.width() / (float)c;
        simpletransform.d = z.width() / (float)c;
        simpletransform = r;
        simpletransform.a = z.left;
        simpletransform.b = z.top;
    }

    static void b(SquareFitEditorView squarefiteditorview, float f1, float f2, float f3)
    {
        float f5 = Math.max(squarefiteditorview.i.width(), squarefiteditorview.i.height());
        if (f1 <= 1.0F) goto _L2; else goto _L1
_L1:
        float f4;
        f4 = f1;
        if ((f1 * f5) / squarefiteditorview.k.width() > 3F)
        {
            if (f5 < squarefiteditorview.k.width() * 3F)
            {
                f4 = (squarefiteditorview.k.width() * 3F) / f5;
            } else
            {
                f4 = 1.0F;
            }
        }
_L4:
        squarefiteditorview.D = squarefiteditorview.D * f4;
        Geom.c(squarefiteditorview.i, f2, f3, f4);
        squarefiteditorview.invalidate();
        return;
_L2:
        f4 = f1;
        if (squarefiteditorview.k.width() / (f1 * f5) > 3F)
        {
            if (f5 * 3F > squarefiteditorview.k.width())
            {
                f4 = squarefiteditorview.k.width() / (f5 * 3F);
            } else
            {
                f4 = 1.0F;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static boolean b(SquareFitEditorView squarefiteditorview, boolean flag)
    {
        squarefiteditorview.f = flag;
        return flag;
    }

    static ValueAnimator c(SquareFitEditorView squarefiteditorview)
    {
        return squarefiteditorview.g;
    }

    private boolean c()
    {
        return n != null && !n.isRecycled() || a != null && !a.isRecycled();
    }

    private float d()
    {
        float f1 = e();
        if (w && Math.abs(f1) < 8F)
        {
            return d - f1;
        } else
        {
            return d;
        }
    }

    static ValueAnimator d(SquareFitEditorView squarefiteditorview)
    {
        squarefiteditorview.g = null;
        return null;
    }

    private float e()
    {
        return d - (float)(Math.round(d / 90F) * 90);
    }

    static ValueAnimator e(SquareFitEditorView squarefiteditorview)
    {
        return squarefiteditorview.h;
    }

    static ValueAnimator f(SquareFitEditorView squarefiteditorview)
    {
        squarefiteditorview.h = null;
        return null;
    }

    static SimpleTransform g(SquareFitEditorView squarefiteditorview)
    {
        return squarefiteditorview.r;
    }

    static boolean h(SquareFitEditorView squarefiteditorview)
    {
        squarefiteditorview.w = false;
        return false;
    }

    static float i(SquareFitEditorView squarefiteditorview)
    {
        squarefiteditorview.x = 0.0F;
        return 0.0F;
    }

    static boolean j(SquareFitEditorView squarefiteditorview)
    {
        return squarefiteditorview.w;
    }

    static Bitmap k(SquareFitEditorView squarefiteditorview)
    {
        return squarefiteditorview.a;
    }

    static float l(SquareFitEditorView squarefiteditorview)
    {
        return squarefiteditorview.D;
    }

    static float m(SquareFitEditorView squarefiteditorview)
    {
        squarefiteditorview.D = 1.0F;
        return 1.0F;
    }

    static float n(SquareFitEditorView squarefiteditorview)
    {
        return squarefiteditorview.d();
    }

    static com.picsart.studio.editor.fragment.SquareFitFragment.SquareFitMode o(SquareFitEditorView squarefiteditorview)
    {
        return squarefiteditorview.s;
    }

    static int p(SquareFitEditorView squarefiteditorview)
    {
        return squarefiteditorview.t;
    }

    static Bitmap q(SquareFitEditorView squarefiteditorview)
    {
        return squarefiteditorview.u;
    }

    public final void a()
    {
        if (n != null && !n.isRecycled())
        {
            n.recycle();
            n = null;
        }
    }

    public final void a(Canvas canvas)
    {
        final class _cls5
        {

            static final int a[];

            static 
            {
                a = new int[com.picsart.studio.editor.fragment.SquareFitFragment.SquareFitMode.values().length];
                try
                {
                    a[com.picsart.studio.editor.fragment.SquareFitFragment.SquareFitMode.BLUR.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.picsart.studio.editor.fragment.SquareFitFragment.SquareFitMode.COLOR.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.picsart.studio.editor.fragment.SquareFitFragment.SquareFitMode.PATTERN.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        com.picsart.studio.editor.view._cls5.a[s.ordinal()];
        JVM INSTR tableswitch 1 3: default 36
    //                   1 37
    //                   2 118
    //                   3 142;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        if (o != null && !o.isRecycled())
        {
            if (o.getWidth() == o.getHeight())
            {
                canvas.drawBitmap(o, null, k, p);
                return;
            } else
            {
                a(o);
                canvas.drawBitmap(o, A, k, p);
                return;
            }
        }
          goto _L1
_L3:
        q.setColor(t);
        canvas.drawRect(k, q);
        return;
_L4:
        if (u != null && !u.isRecycled())
        {
            a(u);
            canvas.drawBitmap(u, A, k, null);
            return;
        } else
        {
            q.setColor(-1);
            canvas.drawRect(k, q);
            return;
        }
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (c())
        {
            Object obj = r;
            canvas.translate(((SimpleTransform) (obj)).a, ((SimpleTransform) (obj)).b);
            canvas.rotate(((SimpleTransform) (obj)).e);
            canvas.scale(((SimpleTransform) (obj)).c, ((SimpleTransform) (obj)).d);
            canvas.clipRect(k);
            a(canvas);
            canvas.save();
            canvas.rotate(d, i.centerX(), i.centerY());
            obj = b;
            boolean flag;
            if (d % 90F != 0.0F)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ((Paint) (obj)).setAntiAlias(flag);
            if (n != null && !n.isRecycled())
            {
                canvas.save();
                canvas.scale(a.getWidth() / n.getWidth(), a.getHeight() / n.getHeight());
                canvas.drawBitmap(n, null, i, b);
                canvas.restore();
            } else
            {
                canvas.drawBitmap(a, null, i, b);
            }
            canvas.restore();
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        s = com.picsart.studio.editor.view.SavedState.a(parcelable);
        i = SavedState.b(parcelable);
        d = SavedState.c(parcelable);
        t = com.picsart.studio.editor.view.SavedState.d(parcelable);
        u = SavedState.e(parcelable);
        l = SavedState.f(parcelable);
    }

    protected Parcelable onSaveInstanceState()
    {
        return new SavedState(super.onSaveInstanceState(), this);
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        y = new RectF(0.0F, 0.0F, i1, j1);
        b();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (e || f || !c())
        {
            return false;
        } else
        {
            m.a(motionevent);
            return true;
        }
    }

    public void setBgPattern(Bitmap bitmap)
    {
        if (u != null && !u.isRecycled())
        {
            u.recycle();
        }
        u = bitmap;
    }

    public void setBlurredImage(Bitmap bitmap)
    {
        o = bitmap;
    }

    public void setColor(int i1)
    {
        t = i1;
    }

    public void setImage(Bitmap bitmap)
    {
        a = bitmap;
        if (bitmap != null)
        {
            c = Math.max(bitmap.getWidth(), bitmap.getHeight());
            if (c * c > PicsartContext.a.getMaxImageSizePixel())
            {
                c = (int)Math.sqrt(PicsartContext.a.getMaxImageSizePixel());
            }
            int i1 = Math.min(2048, c);
            if (i1 < (Math.max(bitmap.getWidth(), bitmap.getHeight()) * 3) / 4 && (n == null || n.isRecycled()))
            {
                n = com.socialin.android.util.w.f(bitmap, i1);
            }
            k.set(0.0F, 0.0F, c, c);
            if (i.isEmpty())
            {
                i.set(0.0F, 0.0F, a.getWidth(), a.getHeight());
                Geom.a(i, k, com.socialin.android.util.Geom.Fit.CENTER);
            }
            j.set(0.0F, 0.0F, a.getWidth(), a.getHeight());
            Geom.a(j, k, com.socialin.android.util.Geom.Fit.CENTER);
            if (getWidth() > 0 && getHeight() > 0)
            {
                y = new RectF(0.0F, 0.0F, getWidth(), getHeight());
                b();
            }
        }
    }

    public void setMode(com.picsart.studio.editor.fragment.SquareFitFragment.SquareFitMode squarefitmode)
    {
        s = squarefitmode;
        invalidate();
    }

    // Unreferenced inner class com/picsart/studio/editor/view/SquareFitEditorView$1

/* anonymous class */
    public final class _cls1
        implements android.animation.ValueAnimator.AnimatorUpdateListener
    {

        private SquareFitEditorView a;

        public final void onAnimationUpdate(ValueAnimator valueanimator)
        {
            com.picsart.studio.editor.view.SquareFitEditorView.a(a, ((Float)valueanimator.getAnimatedValue()).floatValue() - com.picsart.studio.editor.view.SquareFitEditorView.a(a), SquareFitEditorView.b(a).centerX(), SquareFitEditorView.b(a).centerY());
        }

            public 
            {
                a = SquareFitEditorView.this;
                super();
            }
    }


    // Unreferenced inner class com/picsart/studio/editor/view/SquareFitEditorView$2

/* anonymous class */
    public final class _cls2 extends ag
    {

        private SquareFitEditorView a;

        public final void onAnimationCancel(Animator animator)
        {
            super.onAnimationCancel(animator);
            com.picsart.studio.editor.view.SquareFitEditorView.a(a, false);
        }

        public final void onAnimationEnd(Animator animator)
        {
            com.picsart.studio.editor.view.SquareFitEditorView.a(a, false);
            SquareFitEditorView.c(a).removeAllListeners();
            SquareFitEditorView.c(a).removeAllUpdateListeners();
            com.picsart.studio.editor.view.SquareFitEditorView.d(a);
        }

        public final void onAnimationStart(Animator animator)
        {
            super.onAnimationStart(animator);
            com.picsart.studio.editor.view.SquareFitEditorView.a(a, true);
        }

            public 
            {
                a = SquareFitEditorView.this;
                super();
            }
    }


    // Unreferenced inner class com/picsart/studio/editor/view/SquareFitEditorView$3

/* anonymous class */
    public final class _cls3
        implements android.animation.ValueAnimator.AnimatorUpdateListener
    {

        private SquareFitEditorView a;

        public final void onAnimationUpdate(ValueAnimator valueanimator)
        {
            SquareFitEditorView.b(a).set((RectF)valueanimator.getAnimatedValue());
            a.invalidate();
        }

            public 
            {
                a = SquareFitEditorView.this;
                super();
            }
    }


    // Unreferenced inner class com/picsart/studio/editor/view/SquareFitEditorView$4

/* anonymous class */
    public final class _cls4 extends ag
    {

        private SquareFitEditorView a;

        public final void onAnimationCancel(Animator animator)
        {
            super.onAnimationCancel(animator);
            SquareFitEditorView.b(a, false);
        }

        public final void onAnimationEnd(Animator animator)
        {
            SquareFitEditorView.b(a, false);
            SquareFitEditorView.e(a).removeAllListeners();
            SquareFitEditorView.e(a).removeAllUpdateListeners();
            SquareFitEditorView.f(a);
        }

        public final void onAnimationStart(Animator animator)
        {
            super.onAnimationStart(animator);
            SquareFitEditorView.b(a, true);
        }

            public 
            {
                a = SquareFitEditorView.this;
                super();
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
        private com.picsart.studio.editor.fragment.SquareFitFragment.SquareFitMode a;
        private RectF b;
        private float c;
        private int d;
        private Bitmap e;
        private int f;

        static com.picsart.studio.editor.fragment.SquareFitFragment.SquareFitMode a(SavedState savedstate)
        {
            return savedstate.a;
        }

        static RectF b(SavedState savedstate)
        {
            return savedstate.b;
        }

        static float c(SavedState savedstate)
        {
            return savedstate.c;
        }

        static int d(SavedState savedstate)
        {
            return savedstate.d;
        }

        static Bitmap e(SavedState savedstate)
        {
            return savedstate.e;
        }

        static int f(SavedState savedstate)
        {
            return savedstate.f;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            parcel.writeString(a.name());
            parcel.writeParcelable(b, i1);
            parcel.writeFloat(c);
            parcel.writeInt(d);
            parcel.writeParcelable(e, i1);
            parcel.writeInt(f);
        }


        public SavedState(Parcel parcel)
        {
            super(parcel);
            a = com.picsart.studio.editor.fragment.SquareFitFragment.SquareFitMode.valueOf(parcel.readString());
            b = (RectF)parcel.readParcelable(android/graphics/RectF.getClassLoader());
            c = parcel.readFloat();
            d = parcel.readInt();
            e = (Bitmap)parcel.readParcelable(android/graphics/Bitmap.getClassLoader());
            f = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, SquareFitEditorView squarefiteditorview)
        {
            super(parcelable);
            a = SquareFitEditorView.o(squarefiteditorview);
            b = SquareFitEditorView.b(squarefiteditorview);
            c = com.picsart.studio.editor.view.SquareFitEditorView.a(squarefiteditorview);
            d = SquareFitEditorView.p(squarefiteditorview);
            e = SquareFitEditorView.q(squarefiteditorview);
            f = squarefiteditorview.l;
        }
    }

}
