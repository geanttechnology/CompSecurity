// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.collage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import com.socialin.android.brushlib.layer.BlendMode;
import com.socialin.android.photo.svg.b;
import com.socialin.android.util.ScaleRotateGestureDetector;
import com.socialin.android.util.ad;
import com.socialin.android.util.c;
import com.socialin.android.util.l;

// Referenced classes of package com.socialin.android.photo.collage:
//            ShapeCropView, c

public class ShapeCropHelper
    implements Parcelable, ad
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new ShapeCropHelper(parcel);
        }

        public final volatile Object[] newArray(int i1)
        {
            return new ShapeCropHelper[i1];
        }

    };
    private static final Paint w;
    private Paint A;
    private Paint B;
    private Paint C;
    private RectF D;
    private Path E;
    private Bitmap F;
    private Matrix G;
    private Bitmap H;
    private Rect I;
    private RectF J;
    private RectF K;
    double a;
    double b;
    com.socialin.android.photo.collage.c c;
    Action d;
    RectF e;
    RectF f;
    RectF g;
    RectF h;
    final RectF i;
    RectF j;
    Path k;
    boolean l;
    ScaleRotateGestureDetector m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    boolean s;
    BlendMode t;
    PointF u;
    private Paint v;
    private Paint x;
    private Paint y;
    private Paint z;

    public ShapeCropHelper(Parcel parcel)
    {
        boolean flag = true;
        super();
        v = new Paint(2);
        d = Action.NONE;
        y = new Paint();
        z = new Paint(1);
        A = new Paint(1);
        B = new Paint();
        C = new Paint(1);
        e = new RectF();
        D = new RectF();
        f = new RectF();
        g = new RectF();
        h = new RectF();
        i = new RectF();
        j = new RectF();
        k = new Path();
        E = new Path();
        l = true;
        G = new Matrix();
        t = BlendMode.NORMAL;
        u = new PointF();
        J = new RectF();
        K = new RectF();
        n = parcel.readInt();
        o = parcel.readInt();
        p = parcel.readInt();
        q = parcel.readInt();
        r = parcel.readInt();
        if (parcel.readInt() != 1)
        {
            flag = false;
        }
        s = flag;
        t = (BlendMode)parcel.readSerializable();
    }

    public ShapeCropHelper(ShapeCropView shapecropview, int i1)
    {
        v = new Paint(2);
        d = Action.NONE;
        y = new Paint();
        z = new Paint(1);
        A = new Paint(1);
        B = new Paint();
        C = new Paint(1);
        e = new RectF();
        D = new RectF();
        f = new RectF();
        g = new RectF();
        h = new RectF();
        i = new RectF();
        j = new RectF();
        k = new Path();
        E = new Path();
        l = true;
        G = new Matrix();
        t = BlendMode.NORMAL;
        u = new PointF();
        J = new RectF();
        K = new RectF();
        n = i1;
        r = 2;
        o = -1;
        q = 200;
        a(-1);
        a(shapecropview);
    }

    private float e()
    {
        return Math.abs(f.width() / f.height());
    }

    final void a()
    {
        boolean flag1 = true;
        boolean flag;
        if (f.width() < 0.0F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (f.height() >= 0.0F)
        {
            flag1 = false;
        }
        f.sort();
        if (f.width() < 10F)
        {
            f.inset((f.width() - 10F) / 2.0F, 0.0F);
        }
        if (f.height() < 10F)
        {
            f.inset(0.0F, (f.height() - 10F) / 2.0F);
        }
        if (flag)
        {
            float f1 = f.left;
            f.left = f.right;
            f.right = f1;
        }
        if (flag1)
        {
            float f2 = f.top;
            f.top = f.bottom;
            f.bottom = f2;
        }
    }

    public final void a(float f1)
    {
        float f2;
        float f3;
        boolean flag;
        boolean flag1;
        if (f.width() < 0.0F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (f.height() < 0.0F)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        K.set(f);
        K.sort();
        f2 = (K.width() * (f1 - 1.0F)) / 2.0F;
        f3 = (K.height() * (f1 - 1.0F)) / 2.0F;
        if ((K.width() > 10F || f2 >= 0.0F) && (K.height() > 10F || f3 >= 0.0F))
        {
            float f4 = f2 / f3;
            f2 = Math.min(Math.min(f2, j.right - K.right), K.left - j.left);
            float f5;
            if (f3 == 0.0F)
            {
                f1 = 0.0F;
            } else
            {
                f1 = f2 / f4;
            }
            f5 = Math.min(Math.min(f1, K.top - j.top), j.bottom - K.bottom);
            if (f3 != 0.0F)
            {
                f1 = f5 * f4;
            } else
            {
                f1 = f2;
            }
            K.inset(-f1, -f5);
            f.set(K);
            if (flag)
            {
                f1 = f.left;
                f.left = f.right;
                f.right = f1;
            }
            if (flag1)
            {
                f1 = f.top;
                f.top = f.bottom;
                f.bottom = f1;
            }
            a(true);
            a();
        }
    }

    final void a(float f1, float f2)
    {
        u.set(f1, f2);
    }

    public final void a(float f1, float f2, float f3, float f4)
    {
        d = Action.PINCH_ZOOM;
    }

    public final void a(int i1)
    {
        p = i1;
        a(((Bitmap) (null)));
    }

    final void a(Context context)
    {
        b b1 = new b();
        b1.a(context.getResources().openRawResource(n));
        k.set(b1.a);
        e.set(0.0F, 0.0F, b1.b, b1.c);
        f.set(e);
        if (n == 0x7f070003)
        {
            k.reset();
            k.addRoundRect(e, e.width() / 10F, e.width() / 10F, android.graphics.Path.Direction.CW);
        }
    }

    public final void a(Bitmap bitmap)
    {
        if (H != null)
        {
            H.recycle();
            H = null;
        }
        H = bitmap;
        if (H != null)
        {
            I = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
    }

    public final void a(Canvas canvas, boolean flag)
    {
        y.setColor(p);
        B.setAlpha(q);
        if (t != null && t != BlendMode.MULTIPLY)
        {
            B.setXfermode(t.getXfermode());
        } else
        {
            B.setXfermode(null);
        }
        if (r > 0)
        {
            x.setStrokeWidth(r);
            x.setColor(o);
        }
        if (t == BlendMode.MULTIPLY)
        {
            canvas.saveLayer(j, C, 31);
            canvas.drawColor(-1);
        }
        canvas.saveLayer(j, B, 31);
        if (H != null)
        {
            canvas.drawBitmap(H, I, j, v);
        } else
        {
            canvas.drawRect(j, y);
        }
        G.setScale(f.width() / e.width(), f.height() / e.height());
        G.postTranslate(f.left, f.top);
        if (n == 0x7f070003)
        {
            E.reset();
            h.set(f);
            h.sort();
            E.addRoundRect(h, 20F, 20F, android.graphics.Path.Direction.CW);
        } else
        {
            k.transform(G, E);
        }
        if (s)
        {
            canvas.saveLayer(j, A, 31);
            canvas.drawPath(E, w);
            canvas.restore();
        } else
        {
            canvas.drawPath(E, z);
        }
        if (r > 0)
        {
            canvas.drawPath(E, x);
        }
        canvas.restore();
        if (t == BlendMode.MULTIPLY)
        {
            canvas.restore();
        }
        if (l && flag)
        {
            canvas.drawBitmap(F, f.right - i.width() / 2.0F, f.bottom - i.height() / 2.0F, ShapeCropView.a);
        }
    }

    public final void a(RectF rectf)
    {
        f.set(e);
        com.socialin.android.util.l.a(f, rectf);
        D.set(f);
        a = f.height();
        b = f.width();
    }

    public final void a(ShapeCropView shapecropview)
    {
        shapecropview.setShapeCropHelper(this);
        x = new Paint();
        x.setStyle(android.graphics.Paint.Style.STROKE);
        x.setStrokeWidth(2.0F);
        x.setAntiAlias(true);
        x.setColor(-1);
        y.setStyle(android.graphics.Paint.Style.FILL);
        y.setAntiAlias(true);
        z.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OUT));
        z.setStyle(android.graphics.Paint.Style.FILL);
        A.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_IN));
        A.setStyle(android.graphics.Paint.Style.FILL);
        C.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.MULTIPLY));
        a(shapecropview.getContext());
        F = com.socialin.android.util.c.a(shapecropview.getContext().getResources(), 0x7f02024d);
        i.set(0.0F, 0.0F, F.getWidth(), F.getHeight());
        m = new ScaleRotateGestureDetector(shapecropview.getContext().getResources());
        m.a = false;
        m.d = false;
        m.g = this;
    }

    public final void a(boolean flag)
    {
        boolean flag4 = true;
        boolean flag1 = false;
        float f1 = e();
        RectF rectf;
        RectF rectf1;
        boolean flag2;
        boolean flag3;
        if (f.width() < 0.0F)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (f.height() < 0.0F)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        f.sort();
        rectf = d();
        rectf1 = f;
        rectf1.left = rectf1.left - rectf.left;
        rectf1 = f;
        rectf1.top = rectf1.top - rectf.top;
        rectf1 = f;
        rectf1.right = rectf1.right + rectf.right;
        rectf1 = f;
        rectf1.bottom = rectf1.bottom + rectf.bottom;
        if (f.left < j.left)
        {
            float f2 = j.left;
            float f7 = f.left;
            f.left = j.left;
            rectf1 = f;
            rectf1.right = (f2 - f7) + rectf1.right;
            if (f.right > j.right)
            {
                f.right = j.right;
            }
        }
        if (f.right > j.right)
        {
            float f3 = j.right;
            float f8 = f.right;
            f.right = j.right;
            rectf1 = f;
            rectf1.left = (f3 - f8) + rectf1.left;
            if (f.left < j.left)
            {
                f.left = j.left;
            }
        }
        if (f.top < j.top)
        {
            float f4 = j.top;
            float f9 = f.top;
            f.top = j.top;
            rectf1 = f;
            rectf1.bottom = (f4 - f9) + rectf1.bottom;
            if (f.bottom > j.bottom)
            {
                f.bottom = j.bottom;
            }
            flag1 = true;
        }
        if (f.bottom > j.bottom)
        {
            float f5 = j.bottom;
            float f10 = f.bottom;
            f.bottom = j.bottom;
            rectf1 = f;
            rectf1.top = (f5 - f10) + rectf1.top;
            flag1 = flag4;
            if (f.top < j.top)
            {
                f.top = j.top;
                flag1 = flag4;
            }
        }
        rectf1 = f;
        rectf1.left = rectf1.left + rectf.left;
        rectf1 = f;
        rectf1.top = rectf1.top + rectf.top;
        rectf1 = f;
        rectf1.right = rectf1.right - rectf.right;
        rectf1 = f;
        rectf1.bottom = rectf1.bottom - rectf.bottom;
        if (flag)
        {
            float f6 = e();
            K.set(f);
            K.sort();
            if (f6 != f1)
            {
                if (flag1)
                {
                    f1 = (K.height() * f1 - K.width()) / 2.0F;
                    K.inset(-f1, 0.0F);
                } else
                {
                    f1 = (K.width() / f1 - K.height()) / 2.0F;
                    K.inset(0.0F, -f1);
                }
            }
            f.set(K);
        }
        if (flag2)
        {
            f1 = f.left;
            f.left = f.right;
            f.right = f1;
        }
        if (flag3)
        {
            f1 = f.top;
            f.top = f.bottom;
            f.bottom = f1;
        }
    }

    public final void b()
    {
    }

    public final void c()
    {
    }

    public final RectF d()
    {
        if (f == null || e == null || x == null)
        {
            J.set(0.0F, 0.0F, 0.0F, 0.0F);
            return J;
        } else
        {
            K.set(f);
            K.sort();
            G.setScale(K.width() / e.width(), K.height() / e.height());
            G.postTranslate(K.left, K.top);
            k.transform(G, E);
            x.getFillPath(E, E);
            E.computeBounds(h, true);
            J.left = Math.abs(h.left - K.left);
            J.top = Math.abs(h.top - K.top);
            J.right = Math.abs(h.right - K.right);
            J.bottom = Math.abs(h.bottom - K.bottom);
            return J;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        parcel.writeInt(n);
        parcel.writeInt(o);
        parcel.writeInt(p);
        parcel.writeInt(q);
        parcel.writeInt(r);
        if (s)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        parcel.writeInt(i1);
        parcel.writeSerializable(t);
    }

    static 
    {
        com/socialin/android/photo/collage/ShapeCropHelper.getSimpleName();
        Paint paint = new Paint(1);
        w = paint;
        paint.setStyle(android.graphics.Paint.Style.FILL);
        w.setColor(0xff000000);
    }

    // Unreferenced inner class com/socialin/android/photo/collage/ShapeCropHelper$2

/* anonymous class */
    final class _cls2
    {

        static final int a[];

        static 
        {
            a = new int[Action.values().length];
            try
            {
                a[Action.DRAG.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                a[Action.HANDLE_ZOOM.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class Action extends Enum
    {

        private static final Action $VALUES[];
        public static final Action DRAG;
        public static final Action HANDLE_ZOOM;
        public static final Action NONE;
        public static final Action PINCH_ZOOM;

        public static Action valueOf(String s1)
        {
            return (Action)Enum.valueOf(com/socialin/android/photo/collage/ShapeCropHelper$Action, s1);
        }

        public static Action[] values()
        {
            return (Action[])$VALUES.clone();
        }

        static 
        {
            HANDLE_ZOOM = new Action("HANDLE_ZOOM", 0);
            DRAG = new Action("DRAG", 1);
            NONE = new Action("NONE", 2);
            PINCH_ZOOM = new Action("PINCH_ZOOM", 3);
            $VALUES = (new Action[] {
                HANDLE_ZOOM, DRAG, NONE, PINCH_ZOOM
            });
        }

        private Action(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
