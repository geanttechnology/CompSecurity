// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.picsart.studio.editor.Camera;
import com.picsart.studio.editor.utils.HandleDrawable;
import com.picsart.studio.editor.utils.UserSavedState;
import com.socialin.android.brushlib.input.gesture.d;
import com.socialin.android.brushlib.input.gesture.g;
import com.socialin.android.brushlib.input.gesture.i;
import com.socialin.android.photo.motion.MotionLassoDrawable;
import com.socialin.android.photo.view.a;
import com.socialin.android.util.Geom;
import com.socialin.android.util.Utils;
import java.util.List;
import myobfuscated.cn.b;
import myobfuscated.cn.c;

// Referenced classes of package com.picsart.studio.editor.view:
//            EditorView, i, j

public abstract class MotionLassoCropView extends EditorView
    implements c
{

    private int A;
    private float B;
    private float C;
    private HandleDrawable D;
    private HandleDrawable E;
    private b F;
    private j G;
    private d H;
    protected float i;
    protected Paint j;
    protected boolean k;
    protected int l;
    protected float m;
    protected float n;
    protected boolean o;
    protected boolean p;
    protected MotionLassoDrawable q;
    private int r;
    private int s;
    private float t;
    private float u;
    private float v;
    private float w;
    private com.picsart.studio.editor.utils.c x;
    private boolean y;
    private boolean z;

    public MotionLassoCropView(Context context)
    {
        this(context, null);
    }

    public MotionLassoCropView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public MotionLassoCropView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        i = 2.0F;
        k = false;
        l = 0;
        o = false;
        p = false;
        y = false;
        z = false;
        A = 0;
        C = 0.0F;
        a(context);
        attributeset = new com.picsart.studio.editor.view.i(this, (byte)0);
        context = new g(attributeset);
        context.a = 30F;
        attributeset = new i(attributeset);
        attributeset.b = 30F;
        attributeset.a = 230L;
        H = new d();
        H.a(context);
        H.a(attributeset);
    }

    static boolean a(MotionLassoCropView motionlassocropview)
    {
        return motionlassocropview.y;
    }

    static HandleDrawable b(MotionLassoCropView motionlassocropview)
    {
        return motionlassocropview.D;
    }

    static HandleDrawable c(MotionLassoCropView motionlassocropview)
    {
        return motionlassocropview.E;
    }

    private void c(float f1, float f2)
    {
        MotionLassoDrawable motionlassodrawable = q;
        float f3 = m;
        float f4 = n;
        Camera camera = c;
        motionlassodrawable.f.quadTo(camera.b(f3), camera.c(f4), camera.b((f1 + f3) / 2.0F), camera.c((f2 + f4) / 2.0F));
        motionlassodrawable.f.computeBounds(motionlassodrawable.g, true);
        float f5 = motionlassodrawable.i / 2.0F + 1.0F;
        RectF rectf = motionlassodrawable.g;
        rectf.left = rectf.left - f5;
        rectf = motionlassodrawable.g;
        rectf.top = rectf.top - f5;
        rectf = motionlassodrawable.g;
        rectf.right = rectf.right + f5;
        rectf = motionlassodrawable.g;
        rectf.bottom = f5 + rectf.bottom;
        motionlassodrawable.h.set((int)motionlassodrawable.g.left, (int)motionlassodrawable.g.top, (int)motionlassodrawable.g.right, (int)motionlassodrawable.g.bottom);
        motionlassodrawable.a.quadTo(f3, f4, (f1 + f3) / 2.0F, (f2 + f4) / 2.0F);
        motionlassodrawable.f.reset();
        motionlassodrawable.f.moveTo(camera.b((f3 + f1) / 2.0F), camera.c((f4 + f2) / 2.0F));
        motionlassodrawable.j.add(new PointF(f1, f2));
        m = f1;
        n = f2;
        if (x != null)
        {
            if (x.a(c.b(f1), c.c(f2)))
            {
                invalidate(x.b);
            }
            invalidate(x.a);
        }
    }

    private void i()
    {
        y = false;
        z = false;
        b(false);
    }

    private void j()
    {
        k();
        F = new b(this);
        F.start();
    }

    private void k()
    {
        if (F != null)
        {
            F.b = false;
            F = null;
        }
    }

    protected void a(float f1, float f2)
    {
        if (l == 0)
        {
            k = true;
            v = f1;
            w = f2;
            return;
        } else
        {
            m = f1;
            n = f2;
            o = true;
            k = true;
            k();
            return;
        }
    }

    protected void a(float f1, float f2, boolean flag)
    {
        if (l == 0)
        {
            k = false;
            return;
        }
        boolean flag1;
        if (flag && y)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (p)
        {
            if (!o)
            {
                c(f1, f2);
            }
            if (x != null)
            {
                x.d = false;
                if (G != null)
                {
                    G.a(false);
                }
                com.picsart.studio.editor.utils.c c1 = x;
                getWidth();
                getHeight();
                c1.a();
            }
            if (D != null)
            {
                D.c = com.socialin.android.photo.view.a.a(t, u);
                D.a(m, n);
                if (flag1)
                {
                    D.b = false;
                    q.a(E.d, E.e);
                    A = 150;
                    b(true);
                } else
                {
                    i();
                    D.b = true;
                }
            }
            invalidate();
            p = false;
        }
        if (flag)
        {
            j();
        }
        k = false;
    }

    protected void a(Context context)
    {
        i = Utils.a(3F, context);
        Utils.a(5F, context);
        j = new Paint();
        j.setFilterBitmap(true);
        r = (int)Utils.a(70F, context);
        s = (int)Utils.a(10F, context);
        float f1 = (Utils.a(1.0F, context) * 2.0F) / 3F;
        B = Utils.a(120F, context);
        D = new HandleDrawable(context, 0, 0x7f020334);
        E = new HandleDrawable(context, 25, 0x7f020249);
        q = new MotionLassoDrawable(f1);
    }

    protected void a(Canvas canvas)
    {
        if (e != null && !e.isRecycled())
        {
            canvas.save();
            canvas.scale((float)e.getWidth() / (float)f.getWidth(), (float)e.getHeight() / (float)f.getHeight());
            canvas.drawBitmap(f, 0.0F, 0.0F, j);
            canvas.restore();
            if (y)
            {
                j.setAlpha(A);
                canvas.drawPaint(j);
                j.setAlpha(255);
                MotionLassoDrawable motionlassodrawable = q;
                float f1 = (float)e.getWidth() / (float)f.getWidth();
                Bitmap bitmap = f;
                Paint paint = j;
                canvas.drawPath(motionlassodrawable.a, motionlassodrawable.k);
                canvas.save();
                canvas.scale(f1, f1);
                paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OVER));
                canvas.drawBitmap(bitmap, 0.0F, 0.0F, paint);
                paint.setXfermode(null);
                canvas.restore();
            }
        }
    }

    protected final void b(Canvas canvas)
    {
        if (F != null)
        {
            q.a(F.a);
        }
        q.a(canvas, c.e);
    }

    protected void b(boolean flag)
    {
    }

    protected boolean b(float f1, float f2)
    {
        if (l == 0)
        {
            if (k)
            {
                float f3 = f1 - v;
                float f6 = f2 - w;
                if (Math.sqrt(f3 * f3 + f6 * f6) >= (double)i)
                {
                    v = f1;
                    w = f2;
                    return true;
                }
            }
            return false;
        }
        if (k)
        {
            float f4 = Math.abs(f1 - m);
            float f7 = Math.abs(f2 - n);
            if (Math.abs(Math.sqrt(f4 * f4 + f7 * f7)) >= (double)(i / c.e))
            {
                if (o)
                {
                    Object obj = D;
                    float f5 = m;
                    float f8 = n;
                    float f10 = c.e;
                    Geom.c(((HandleDrawable) (obj)).a, ((HandleDrawable) (obj)).a.centerX(), ((HandleDrawable) (obj)).a.centerY(), 1.0F / f10);
                    boolean flag;
                    if (((HandleDrawable) (obj)).a != null && ((HandleDrawable) (obj)).a.contains(f5, f8))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (!flag || q.a.isEmpty())
                    {
                        obj = q;
                        f5 = m;
                        float f9 = n;
                        Camera camera = c;
                        ((MotionLassoDrawable) (obj)).a();
                        ((MotionLassoDrawable) (obj)).a.moveTo(f5, f9);
                        ((MotionLassoDrawable) (obj)).f.reset();
                        ((MotionLassoDrawable) (obj)).f.moveTo(camera.b(f5), camera.c(f9));
                        ((MotionLassoDrawable) (obj)).j.add(new PointF(f5, f9));
                        E.a(m, n);
                        E.b = true;
                    }
                    if (x != null)
                    {
                        x.d = true;
                        if (G != null)
                        {
                            G.a(true);
                        }
                        x.a(c.b(m), c.c(n));
                    }
                    o = false;
                    i();
                    D.b = false;
                    invalidate();
                }
                t = f1 - m;
                u = f2 - n;
                c(f1, f2);
                C = com.socialin.android.photo.view.a.a(E.d, E.e, m, n) * c.e;
                f1 = C / 2.0F;
                obj = q;
                ((MotionLassoDrawable) (obj)).c.setPath(((MotionLassoDrawable) (obj)).a, false);
                f2 = ((MotionLassoDrawable) (obj)).c.getLength();
                f5 = c.e;
                if (C <= B && (double)(f2 * f5) >= (double)f1 * 3.1415926535897931D)
                {
                    y = true;
                    A = (int)(150F * (1.0F - C / B));
                } else
                {
                    if (y)
                    {
                        z = true;
                    }
                    y = false;
                }
                p = true;
                return true;
            }
        }
        return false;
    }

    protected final void c(Canvas canvas)
    {
        boolean flag = false;
        int i1 = 0;
        if (x != null)
        {
            float f1 = (float)e.getWidth() / (float)f.getWidth();
            com.picsart.studio.editor.utils.c c1 = x;
            Camera camera = c;
            Bitmap bitmap = f;
            Object obj;
            Paint apaint[];
            if (android.os.Build.VERSION.SDK_INT <= 16)
            {
                obj = q;
                float f2 = c.e;
                ((MotionLassoDrawable) (obj)).a(((MotionLassoDrawable) (obj)).b, f2);
                obj = ((MotionLassoDrawable) (obj)).b;
            } else
            {
                obj = q.a;
            }
            apaint = new Paint[2];
            apaint[0] = q.d;
            apaint[1] = q.e;
            if (c1.d)
            {
                canvas.save();
                canvas.clipRect(c1.a);
                canvas.translate(camera.a / 2.0F, camera.b / 2.0F);
                canvas.translate(-camera.c * camera.e, -camera.d * camera.e);
                canvas.translate(c1.e, c1.f);
                canvas.scale(camera.e, camera.e);
                canvas.scale(f1, f1);
                canvas.drawBitmap(bitmap, 0.0F, 0.0F, c1.c);
                canvas.scale(1.0F / f1, 1.0F / f1);
                if (android.os.Build.VERSION.SDK_INT <= 16)
                {
                    canvas.scale(1.0F / camera.e, 1.0F / camera.e);
                    for (; i1 < 2; i1++)
                    {
                        canvas.drawPath(((Path) (obj)), apaint[i1]);
                    }

                } else
                {
                    c1.g.reset();
                    c1.g.setScale(camera.e, camera.e);
                    ((Path) (obj)).transform(c1.g);
                    canvas.scale(1.0F / camera.e, 1.0F / camera.e);
                    for (int j1 = ((flag) ? 1 : 0); j1 < 2; j1++)
                    {
                        canvas.drawPath(((Path) (obj)), apaint[j1]);
                    }

                    c1.g.reset();
                    c1.g.setScale(1.0F / camera.e, 1.0F / camera.e);
                    ((Path) (obj)).transform(c1.g);
                }
                canvas.restore();
            }
        }
    }

    protected final void d(Canvas canvas)
    {
        if (D != null)
        {
            canvas.save();
            canvas.translate(D.d * c.e, D.e * c.e);
            D.a(canvas, j);
            canvas.restore();
        }
        if (E != null)
        {
            canvas.save();
            canvas.translate(E.d * c.e, E.e * c.e);
            E.a(canvas, j);
            canvas.restore();
        }
    }

    protected final void e()
    {
        q.a();
        E.b = false;
        D.b = false;
        y = false;
        z = false;
        k();
    }

    protected void f()
    {
        if (l == 0)
        {
            invalidate();
            return;
        }
        if (y)
        {
            invalidate();
            return;
        }
        if (z)
        {
            invalidate();
            z = false;
            return;
        } else
        {
            invalidate(q.h);
            return;
        }
    }

    public final void g()
    {
        k();
        if (D != null)
        {
            D.a();
        }
        if (E != null)
        {
            E.a();
        }
        if (f != null && f != e)
        {
            f.recycle();
        }
    }

    public final void h()
    {
        postInvalidate();
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(((UserSavedState) (parcelable)).a);
        l = com.picsart.studio.editor.view.SavedState.a(parcelable);
        o = com.picsart.studio.editor.view.SavedState.b(parcelable);
        q = com.picsart.studio.editor.view.SavedState.c(parcelable);
        MotionLassoDrawable motionlassodrawable = q;
        if (motionlassodrawable.j.size() > 0)
        {
            motionlassodrawable.a(motionlassodrawable.a, 1.0F);
        }
        D = com.picsart.studio.editor.view.SavedState.d(parcelable);
        D.a(getContext());
        E = SavedState.e(parcelable);
        E.a(getContext());
        y = SavedState.f(parcelable);
        if (y)
        {
            q.a(((PointF)q.j.get(0)).x, ((PointF)q.j.get(0)).y);
            A = 150;
            b(true);
        }
        if (l == 1)
        {
            j();
        }
    }

    protected Parcelable onSaveInstanceState()
    {
        return new SavedState(super.onSaveInstanceState(), this);
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        if (D != null && p)
        {
            D.a(m, n);
        }
        myobfuscated.dc.b.a().a = 0;
        super.onSizeChanged(i1, j1, k1, l1);
        if (x == null)
        {
            x = new com.picsart.studio.editor.utils.c(this, r, s);
        }
        x.a();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (!H.a(motionevent))
        {
            super.onTouchEvent(motionevent);
        }
        return true;
    }

    public void setLassoViewListener(j j1)
    {
        G = j1;
    }

    public void setTouchMode(int i1)
    {
        l = i1;
        invalidate();
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
        private boolean c;
        private boolean d;
        private MotionLassoDrawable e;
        private HandleDrawable f;
        private HandleDrawable g;

        static int a(SavedState savedstate)
        {
            return savedstate.b;
        }

        static boolean b(SavedState savedstate)
        {
            return savedstate.c;
        }

        static MotionLassoDrawable c(SavedState savedstate)
        {
            return savedstate.e;
        }

        static HandleDrawable d(SavedState savedstate)
        {
            return savedstate.f;
        }

        static HandleDrawable e(SavedState savedstate)
        {
            return savedstate.g;
        }

        static boolean f(SavedState savedstate)
        {
            return savedstate.d;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            boolean flag = true;
            super.writeToParcel(parcel, i1);
            parcel.writeInt(b);
            int j1;
            if (c)
            {
                j1 = 1;
            } else
            {
                j1 = 0;
            }
            parcel.writeInt(j1);
            if (d)
            {
                j1 = ((flag) ? 1 : 0);
            } else
            {
                j1 = 0;
            }
            parcel.writeInt(j1);
            parcel.writeParcelable(e, i1);
            parcel.writeParcelable(f, i1);
            parcel.writeParcelable(g, i1);
        }


        public SavedState(Parcel parcel)
        {
            boolean flag1 = true;
            super(parcel);
            b = parcel.readInt();
            boolean flag;
            if (parcel.readInt() == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            c = flag;
            if (parcel.readInt() == 1)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            d = flag;
            e = (MotionLassoDrawable)parcel.readParcelable(myobfuscated/cn/a.getClassLoader());
            f = (HandleDrawable)parcel.readParcelable(com/picsart/studio/editor/utils/HandleDrawable.getClassLoader());
            g = (HandleDrawable)parcel.readParcelable(com/picsart/studio/editor/utils/HandleDrawable.getClassLoader());
        }

        public SavedState(Parcelable parcelable, MotionLassoCropView motionlassocropview)
        {
            super(parcelable);
            b = motionlassocropview.l;
            c = motionlassocropview.o;
            d = com.picsart.studio.editor.view.MotionLassoCropView.a(motionlassocropview);
            e = motionlassocropview.q;
            f = com.picsart.studio.editor.view.MotionLassoCropView.b(motionlassocropview);
            g = com.picsart.studio.editor.view.MotionLassoCropView.c(motionlassocropview);
        }
    }

}
