// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.picsart.studio.editor.Camera;
import com.picsart.studio.editor.utils.UserSavedState;
import com.socialin.android.photo.motion.MotionDrawer;
import com.socialin.android.photo.motion.MotionLassoDrawable;
import com.socialin.android.photo.view.a;
import com.socialin.android.util.Utils;
import com.socialin.android.util.w;
import java.util.List;

// Referenced classes of package com.picsart.studio.editor.view:
//            MotionLassoCropView, k, l

public class MotionView extends MotionLassoCropView
{

    public MotionDrawer r;
    private float s;
    private boolean t;
    private boolean u;
    private l v;
    private k w;

    public MotionView(Context context)
    {
        super(context);
        t = false;
        u = false;
    }

    public MotionView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        t = false;
        u = false;
    }

    public MotionView(Context context, AttributeSet attributeset, int j)
    {
        super(context, attributeset, j);
        t = false;
        u = false;
    }

    static MotionDrawer a(MotionView motionview)
    {
        return motionview.r;
    }

    private boolean c(float f1, float f2)
    {
        if (com.socialin.android.photo.view.a.a(m, n, f1, f2) >= s && k)
        {
            MotionDrawer motiondrawer = r;
            float f3 = m;
            float f4 = n;
            boolean flag1 = o;
            boolean flag = p;
            if (motiondrawer.c == 0)
            {
                if (flag1)
                {
                    motiondrawer.d.clear();
                    flag = true;
                }
                motiondrawer.g = f1;
                motiondrawer.h = f2;
                motiondrawer.a(motiondrawer.e, motiondrawer.f, motiondrawer.g, motiondrawer.h);
            } else
            {
                if (flag1)
                {
                    motiondrawer.q = motiondrawer.e;
                    motiondrawer.r = motiondrawer.f;
                    MotionLassoDrawable motionlassodrawable = motiondrawer.j;
                    PointF pointf = new PointF();
                    if (motionlassodrawable.a != null)
                    {
                        RectF rectf = new RectF();
                        motionlassodrawable.a.computeBounds(rectf, true);
                        pointf.x = rectf.centerX();
                        pointf.y = rectf.centerY();
                    }
                    motiondrawer.o = pointf.x;
                    motiondrawer.p = pointf.y;
                    motiondrawer.m.clear();
                    motiondrawer.n.reset();
                    motiondrawer.m.add(new PointF(motiondrawer.q, motiondrawer.r));
                    motiondrawer.n.moveTo(motiondrawer.q, motiondrawer.r);
                    flag = true;
                }
                motiondrawer.m.add(new PointF(f3, f4));
                motiondrawer.m.add(new PointF((f1 + f3) / 2.0F, (f2 + f4) / 2.0F));
                motiondrawer.n.quadTo(f3, f4, (f1 + f3) / 2.0F, (f2 + f4) / 2.0F);
            }
            p = flag;
            o = false;
            m = f1;
            n = f2;
            return true;
        } else
        {
            return false;
        }
    }

    protected final void a(float f1, float f2)
    {
        boolean flag1;
        flag1 = false;
        super.a(f1, f2);
        u = false;
        if (l == 0) goto _L2; else goto _L1
_L1:
        if (!t) goto _L4; else goto _L3
_L3:
        boolean flag;
        Object obj = q;
        int j = (int)m;
        int i1 = (int)n;
        Region region1;
        Region region3;
        if (((MotionLassoDrawable) (obj)).a != null)
        {
            Region region = new Region();
            Region region2 = new Region(j - 1, i1 - 1, j + 1, i1 + 1);
            flag = region.setPath(((MotionLassoDrawable) (obj)).a, region2);
        } else
        {
            flag = false;
        }
        if (!flag) goto _L4; else goto _L5
_L5:
        flag = true;
_L7:
        u = flag;
        if (u || !t)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = r;
        j = (int)m;
        i1 = (int)n;
        flag = flag1;
        if (((MotionDrawer) (obj)).c == 0)
        {
            flag = flag1;
            if (!((MotionDrawer) (obj)).i.isEmpty())
            {
                region1 = new Region();
                region3 = new Region(j - 1, i1 - 1, j + 1, i1 + 1);
                flag = region1.setPath(((MotionDrawer) (obj)).i, region3);
            }
        }
        u = flag;
_L2:
        return;
_L4:
        flag = false;
        if (true) goto _L7; else goto _L6
_L6:
        MotionDrawer motiondrawer = r;
        f1 = m;
        f2 = n;
        motiondrawer.e = f1;
        motiondrawer.f = f2;
        return;
    }

    protected final void a(float f1, float f2, boolean flag)
    {
        if (l != 2) goto _L2; else goto _L1
_L1:
        if (p && flag)
        {
            MotionDrawer motiondrawer = r;
            if (motiondrawer.c == 0)
            {
                motiondrawer.i.reset();
                Path path = motiondrawer.j.a;
                for (int j = 0; j < motiondrawer.d.size(); j++)
                {
                    PointF pointf = (PointF)motiondrawer.d.get(j);
                    motiondrawer.i.addPath(path, pointf.x, pointf.y);
                }

            }
        }
        k = false;
        p = false;
_L4:
        u = false;
        return;
_L2:
        boolean flag1;
        if (k && flag && !p && !u)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        super.a(f1, f2, flag);
        if (flag1)
        {
            e();
            invalidate();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected final void a(Context context)
    {
        super.a(context);
        s = (int)Utils.a(4F, context);
        r = new MotionDrawer();
        r.j = q;
        r.a(15, t);
    }

    protected final void a(Canvas canvas)
    {
        c.b(canvas);
        if (l == 2)
        {
            if (e != null && !e.isRecycled())
            {
                canvas.save();
                canvas.clipRect(0, 0, e.getWidth(), e.getHeight());
                canvas.scale((float)e.getWidth() / (float)f.getWidth(), (float)e.getHeight() / (float)f.getHeight());
                canvas.drawBitmap(f, 0.0F, 0.0F, j);
                r.a(canvas, (float)f.getWidth() / (float)e.getWidth(), j, false);
                canvas.restore();
            }
        } else
        {
            super.a(canvas);
        }
        canvas.restore();
        canvas.save();
        canvas.translate(c.a / 2.0F, c.b / 2.0F);
        canvas.translate(-c.c * c.e, -c.d * c.e);
        if (l == 2)
        {
            q.a(canvas, c.e);
        } else
        {
            if (q != null)
            {
                b(canvas);
            }
            d(canvas);
        }
        canvas.restore();
        if (l != 2)
        {
            c(canvas);
        }
    }

    protected final void b(boolean flag)
    {
        t = flag;
        if (t && w != null)
        {
            w.b();
        }
        MotionDrawer motiondrawer = r;
        Bitmap bitmap = e;
        Paint paint = j;
        boolean flag1 = t;
        motiondrawer.b();
        if (flag1)
        {
            motiondrawer.a = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(motiondrawer.a);
            canvas.drawPath(motiondrawer.j.a, motiondrawer.k);
            paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, 0.0F, 0.0F, paint);
            paint.setXfermode(null);
            motiondrawer.b = com.socialin.android.util.w.f(motiondrawer.a, 2048);
        }
        if (v != null)
        {
            l l1 = v;
            if (flag && l == 2)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            l1.b(flag);
        }
    }

    protected final boolean b(float f1, float f2)
    {
        if (!o)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        if (k) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        float f3;
        float f4;
        f3 = Math.abs(f1 - m);
        f4 = Math.abs(f2 - n);
        if (Math.abs(Math.sqrt(f3 * f3 + f4 * f4)) < (double)i) goto _L1; else goto _L3
_L3:
        if (u)
        {
            setTouchMode(2);
            if (v != null)
            {
                v.b(true);
            }
            if (w != null)
            {
                w.a();
            }
            return c(f1, f2);
        }
        if (l == 2)
        {
            setTouchMode(1);
        }
        return super.b(f1, f2);
        if (l == 2)
        {
            return c(f1, f2);
        } else
        {
            return super.b(f1, f2);
        }
    }

    protected final void f()
    {
        if (l == 2)
        {
            invalidate();
            return;
        } else
        {
            super.f();
            return;
        }
    }

    public final Bitmap i()
    {
        Bitmap bitmap = Bitmap.createBitmap(e.getWidth(), e.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawBitmap(e, 0.0F, 0.0F, j);
        r.a(canvas, 1.0F, j, true);
        return bitmap;
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(((UserSavedState) (parcelable)).a);
        r = com.picsart.studio.editor.view.SavedState.a(parcelable);
        r.j = q;
        parcelable = r;
        if (((MotionDrawer) (parcelable)).m.size() > 0)
        {
            PointF pointf = (PointF)((MotionDrawer) (parcelable)).m.get(0);
            ((MotionDrawer) (parcelable)).n.reset();
            ((MotionDrawer) (parcelable)).n.moveTo(pointf.x, pointf.y);
            for (int j = 1; j < ((MotionDrawer) (parcelable)).m.size(); j += 2)
            {
                PointF pointf1 = (PointF)((MotionDrawer) (parcelable)).m.get(j);
                PointF pointf2 = (PointF)((MotionDrawer) (parcelable)).m.get(j + 1);
                ((MotionDrawer) (parcelable)).n.quadTo(pointf1.x, pointf1.y, pointf2.x, pointf2.y);
            }

        }
        r.a();
        v.i();
    }

    protected Parcelable onSaveInstanceState()
    {
        return new SavedState(super.onSaveInstanceState(), this);
    }

    public void setActionListener(k k1)
    {
        w = k1;
    }

    public void setBlendModeXfermode(PorterDuffXfermode porterduffxfermode)
    {
        if (r != null)
        {
            r.l.setXfermode(porterduffxfermode);
        }
    }

    public void setListener(l l1)
    {
        v = l1;
    }

    public void setMotionDrawType(int j)
    {
        if (r.c != j)
        {
            MotionDrawer motiondrawer = r;
            motiondrawer.c = j;
            if (motiondrawer.d != null)
            {
                motiondrawer.d.clear();
            }
            motiondrawer.i.reset();
            motiondrawer.m.clear();
            motiondrawer.n.reset();
            k = false;
            p = false;
        }
    }

    public void setMotionShadowsCount(int j)
    {
        r.a(j, t);
    }

    public void setTouchMode(int j)
    {
        l = j;
    }

    private class SavedState extends MotionLassoCropView.SavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public final Object createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public final volatile Object[] newArray(int j)
            {
                return new SavedState[j];
            }

        };
        private MotionDrawer b;

        static MotionDrawer a(SavedState savedstate)
        {
            return savedstate.b;
        }

        public void writeToParcel(Parcel parcel, int j)
        {
            super.writeToParcel(parcel, j);
            parcel.writeParcelable(b, j);
        }


        public SavedState(Parcel parcel)
        {
            super(parcel);
            b = (MotionDrawer)parcel.readParcelable(com/socialin/android/photo/motion/MotionDrawer.getClassLoader());
        }

        public SavedState(Parcelable parcelable, MotionView motionview)
        {
            super(parcelable, motionview);
            b = com.picsart.studio.editor.view.MotionView.a(motionview);
        }
    }

}
