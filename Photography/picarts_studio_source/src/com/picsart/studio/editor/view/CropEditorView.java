// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.activity.EditorActivity;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.helper.f;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.brushlib.input.gesture.a;
import com.socialin.android.brushlib.input.gesture.d;
import com.socialin.android.brushlib.input.gesture.g;
import com.socialin.android.brushlib.input.gesture.i;
import com.socialin.android.util.Geom;
import com.socialin.android.util.ag;
import com.socialin.android.util.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.picsart.studio.editor.view:
//            a, c, e, b, 
//            d, RulerView, r

public class CropEditorView extends View
{

    private Drawable A;
    private Drawable B;
    private final float C;
    private Bitmap D;
    private Bitmap E;
    private RectF F;
    private float G[];
    private RectF H;
    private RectF I;
    private final float J[];
    private RectF K;
    private Matrix L;
    private float M;
    private float N;
    private float O;
    private float P;
    private b Q;
    private boolean R;
    private float S;
    private List T;
    private com.picsart.studio.editor.view.d U;
    private RectF V;
    private RectF W;
    public boolean a;
    private Matrix aa;
    public ValueAnimator b;
    public float c;
    public float d;
    public RectF e;
    public float f;
    public int g;
    public float h;
    public RectF i;
    public boolean j;
    public float k;
    public boolean l;
    public RectF m;
    public RectF n;
    public int o;
    public int p;
    public RulerView q;
    public boolean r;
    public int s;
    private d t;
    private boolean u;
    private Paint v;
    private Paint w;
    private int x;
    private Paint y;
    private float z;

    public CropEditorView(Context context)
    {
        this(context, null);
    }

    public CropEditorView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public CropEditorView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        C = getResources().getDimension(0x7f0b00fb);
        m = new RectF();
        F = new RectF();
        new PointF();
        G = new float[16];
        J = new float[2];
        K = new RectF();
        L = new Matrix();
        s = 0;
        new RectF();
        V = new RectF();
        W = new RectF();
        aa = new Matrix();
        setSaveEnabled(true);
        o = -1;
        p = -1;
        e = new RectF();
        i = new RectF();
        v = new Paint();
        v.setStyle(android.graphics.Paint.Style.STROKE);
        v.setStrokeJoin(android.graphics.Paint.Join.MITER);
        v.setStrokeCap(android.graphics.Paint.Cap.BUTT);
        w = new Paint();
        w.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
        y = new Paint(2);
        context = new com.picsart.studio.editor.view.a(this, (byte)0);
        attributeset = new g(context);
        attributeset.a = 0.0F;
        a a1 = new a(context);
        t = new d();
        t.a(attributeset);
        t.a(a1);
        t.a(new i(context));
        T = new ArrayList();
        T.add(new c(this, this));
        T.add(new com.picsart.studio.editor.view.e(this));
        setCornerHandleDrawable(getResources().getDrawable(0x7f020191));
        setSideHandleDrawable(getResources().getDrawable(0x7f020192));
        setDimColor(getResources().getColor(0x7f0f000e));
        setTouchPrecision(getResources().getDimension(0x7f0b0132));
        M = 4F;
        N = 2.0F;
        O = 3F;
        P = 1.0F;
        TypedValue.applyDimension(1, 40F, getResources().getDisplayMetrics());
        I = new RectF();
    }

    static boolean A(CropEditorView cropeditorview)
    {
        return cropeditorview.j;
    }

    static float a(CropEditorView cropeditorview)
    {
        return cropeditorview.f();
    }

    static float a(CropEditorView cropeditorview, float f1)
    {
        cropeditorview.f = f1;
        return f1;
    }

    static float a(CropEditorView cropeditorview, boolean flag, boolean flag1)
    {
        return cropeditorview.a(flag, flag1);
    }

    static int a(CropEditorView cropeditorview, int i1)
    {
        cropeditorview.g = i1;
        return i1;
    }

    static ValueAnimator a(CropEditorView cropeditorview, ValueAnimator valueanimator)
    {
        cropeditorview.b = valueanimator;
        return valueanimator;
    }

    private void a(RectF rectf)
    {
        float f5 = h;
        L.setRotate(-f5, e.centerX(), e.centerY());
        L.mapRect(m, i);
        m.sort();
        float f1;
        float f2;
        float f3;
        float f4;
        float f6;
        if (e.left > m.left)
        {
            f1 = Geom.a((e.left - m.left) / (m.width() / 4F), 0.0F, 1.0F);
        } else
        {
            f1 = 0.0F;
        }
        if (e.right < m.right)
        {
            f2 = Geom.a((m.right - e.right) / (m.width() / 4F), 0.0F, 1.0F);
        } else
        {
            f2 = 0.0F;
        }
        if (e.top > m.top)
        {
            f3 = Geom.a((e.top - m.top) / (m.height() / 4F), 0.0F, 1.0F);
        } else
        {
            f3 = 0.0F;
        }
        if (e.bottom < m.bottom)
        {
            f4 = Geom.a((m.bottom - e.bottom) / (m.height() / 4F), 0.0F, 1.0F);
        } else
        {
            f4 = 0.0F;
        }
        f6 = (float)Math.cos(Math.toRadians(f5));
        f5 = (float)Math.sin(Math.toRadians(f5));
        if (f6 >= 0.0F)
        {
            rectf.top = f3 * f6;
            rectf.left = f1 * f6;
            rectf.right = f2 * f6;
            rectf.bottom = f6 * f4;
        } else
        {
            rectf.bottom = -f3 * f6;
            rectf.right = -f1 * f6;
            rectf.left = -f2 * f6;
            rectf.top = f6 * -f4;
        }
        if (f5 >= 0.0F)
        {
            rectf.right = rectf.right + f3 * f5;
            rectf.top = f1 * f5 + rectf.top;
            rectf.bottom = rectf.bottom + f2 * f5;
            rectf.left = rectf.left + f4 * f5;
            return;
        } else
        {
            rectf.left = rectf.left - f3 * f5;
            rectf.bottom = rectf.bottom - f1 * f5;
            rectf.top = rectf.top - f2 * f5;
            rectf.right = rectf.right - f4 * f5;
            return;
        }
    }

    private void a(RectF rectf, RectF rectf1, Runnable runnable, long l1, android.animation.ValueAnimator.AnimatorUpdateListener animatorupdatelistener)
    {
        if (b != null)
        {
            b.removeAllListeners();
            b.removeAllUpdateListeners();
            b.cancel();
            a = false;
        }
        b = ValueAnimator.ofObject(new f(), new Object[] {
            rectf, rectf1
        });
        b.addUpdateListener(animatorupdatelistener);
        b.addListener(new ag(runnable) {

            private Runnable a;
            private CropEditorView b;

            public final void onAnimationCancel(Animator animator)
            {
                super.onAnimationCancel(animator);
                com.picsart.studio.editor.view.CropEditorView.a(b, false);
            }

            public final void onAnimationEnd(Animator animator)
            {
                com.picsart.studio.editor.view.CropEditorView.a(b, false);
                com.picsart.studio.editor.view.CropEditorView.a(b, null);
                if (a != null)
                {
                    a.run();
                }
            }

            public final void onAnimationStart(Animator animator)
            {
                super.onAnimationStart(animator);
                com.picsart.studio.editor.view.CropEditorView.a(b, true);
            }

            
            {
                b = CropEditorView.this;
                a = runnable;
                super();
            }
        });
        b.setDuration(l1);
        b.start();
    }

    static void a(CropEditorView cropeditorview, float f1, float f2)
    {
        cropeditorview.a(cropeditorview.K);
        if (f1 >= 0.0F)
        {
            f1 = (1.0F - cropeditorview.K.left) * f1;
        } else
        {
            f1 = (1.0F - cropeditorview.K.right) * f1;
        }
        if (f2 >= 0.0F)
        {
            f2 = (1.0F - cropeditorview.K.top) * f2;
        } else
        {
            f2 = (1.0F - cropeditorview.K.bottom) * f2;
        }
        cropeditorview.e.offset(f1, f2);
        cropeditorview.invalidate();
    }

    static void a(CropEditorView cropeditorview, float f1, float f2, float f3)
    {
        cropeditorview.a(cropeditorview.K);
        if (f1 >= 1.0F) goto _L2; else goto _L1
_L1:
        float f4 = Math.max(Math.max(Math.max(cropeditorview.K.left, cropeditorview.K.top), cropeditorview.K.right), cropeditorview.K.bottom);
        f1 = (1.0F - f4) * f1 + f4;
_L4:
        Geom.c(cropeditorview.e, f2, f3, f1);
        cropeditorview.f = cropeditorview.e.width() / cropeditorview.c;
        cropeditorview.g();
        cropeditorview.invalidate();
        return;
_L2:
        float f6 = (cropeditorview.e.width() * f1) / cropeditorview.c;
        float f5 = cropeditorview.i.width() / f6;
        f6 = cropeditorview.i.height() / f6;
        if (f5 < 30F || f6 < 30F)
        {
            f1 = 1.0F;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static void a(CropEditorView cropeditorview, float f1, float f2, float f3, boolean flag)
    {
        cropeditorview.J[0] = cropeditorview.e.centerX();
        cropeditorview.J[1] = cropeditorview.e.centerY();
        Geom.a(cropeditorview.J, f1, f2, f3);
        Geom.a(cropeditorview.e, cropeditorview.J[0], cropeditorview.J[1]);
        cropeditorview.h = cropeditorview.h + f1;
        f1 = cropeditorview.h;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        if (cropeditorview.r)
        {
            cropeditorview.L.setRotate(cropeditorview.S, cropeditorview.i.centerX(), cropeditorview.i.centerY());
            cropeditorview.L.postRotate(-f1, cropeditorview.e.centerX(), cropeditorview.e.centerY());
        } else
        {
            cropeditorview.L.setRotate(-f1, cropeditorview.e.centerX(), cropeditorview.e.centerY());
        }
        cropeditorview.L.mapRect(cropeditorview.m, cropeditorview.i);
        cropeditorview.m.sort();
        cropeditorview.F.set(cropeditorview.e);
        f1 = cropeditorview.m.width() / 2.0F;
        f4 = cropeditorview.m.height() / 2.0F;
        f2 = cropeditorview.m.centerX() - cropeditorview.F.left;
        f9 = cropeditorview.m.centerY();
        f10 = cropeditorview.F.top;
        f7 = cropeditorview.F.right;
        f8 = cropeditorview.m.centerX();
        f5 = cropeditorview.F.bottom;
        f6 = cropeditorview.m.centerY();
        f3 = f1 / f2;
        f9 = f4 / (f9 - f10);
        f7 = f1 / (f7 - f8);
        f4 /= f5 - f6;
        f3 = Math.max(Math.max(Math.max(f3, f9), f7), f4);
        (new StringBuilder("maxScale : ")).append(f3).append(", deltaLeft ").append(f2).append(", halfSelectionWidth : ").append(f1);
        if (f3 > 1.0F)
        {
            Geom.c(cropeditorview.F, cropeditorview.i.centerX(), cropeditorview.i.centerY(), f3);
        } else
        {
            f1 = cropeditorview.e.width() / cropeditorview.c;
            if (f1 * f3 > cropeditorview.f)
            {
                Geom.c(cropeditorview.F, cropeditorview.i.centerX(), cropeditorview.i.centerY(), f3);
            } else
            {
                Geom.c(cropeditorview.F, cropeditorview.i.centerX(), cropeditorview.i.centerY(), cropeditorview.f / f1);
            }
        }
        cropeditorview.e.set(cropeditorview.F);
        cropeditorview.invalidate();
        if (flag)
        {
            cropeditorview.g();
        }
        cropeditorview.invalidate();
    }

    static void a(CropEditorView cropeditorview, com.socialin.android.util.Geom.VerticalSide verticalside, com.socialin.android.util.Geom.HorizontalSide horizontalside, float f1, float f2)
    {
        float f3;
        float f4;
        float f5;
        f3 = cropeditorview.e.width() / cropeditorview.c;
        f4 = Math.max(30F * f3, cropeditorview.C);
        f5 = Math.max(f3 * 30F, cropeditorview.C);
        cropeditorview.I.set(cropeditorview.H);
        RectF rectf = cropeditorview.I;
        cropeditorview.G[0] = cropeditorview.e.left;
        cropeditorview.G[1] = cropeditorview.e.top;
        cropeditorview.G[2] = cropeditorview.e.right;
        cropeditorview.G[3] = cropeditorview.e.top;
        cropeditorview.G[4] = cropeditorview.e.right;
        cropeditorview.G[5] = cropeditorview.e.top;
        cropeditorview.G[6] = cropeditorview.e.right;
        cropeditorview.G[7] = cropeditorview.e.bottom;
        cropeditorview.G[8] = cropeditorview.e.right;
        cropeditorview.G[9] = cropeditorview.e.bottom;
        cropeditorview.G[10] = cropeditorview.e.left;
        cropeditorview.G[11] = cropeditorview.e.bottom;
        cropeditorview.G[12] = cropeditorview.e.left;
        cropeditorview.G[13] = cropeditorview.e.bottom;
        cropeditorview.G[14] = cropeditorview.e.left;
        cropeditorview.G[15] = cropeditorview.e.top;
        cropeditorview.L.setRotate(cropeditorview.h, cropeditorview.e.centerX(), cropeditorview.e.centerY());
        cropeditorview.L.mapPoints(cropeditorview.G);
        for (int i1 = 0; i1 < 4; i1++)
        {
            float f8 = cropeditorview.G[i1 * 4];
            float f9 = cropeditorview.G[i1 * 4 + 1];
            float f10 = cropeditorview.G[i1 * 4 + 2];
            float f11 = cropeditorview.G[i1 * 4 + 3];
            f3 = Geom.a(f8, f9, f10, f11, cropeditorview.i.top);
            float f6 = Geom.a(f8, f9, f10, f11, cropeditorview.i.bottom);
            float f7 = Geom.b(f8, f9, f10, f11, cropeditorview.i.left);
            f8 = Geom.b(f8, f9, f10, f11, cropeditorview.i.right);
            if (f7 <= cropeditorview.i.top + 0.1F && f7 > rectf.top)
            {
                rectf.top = f7;
            }
            if (f8 <= cropeditorview.i.top + 0.1F && f8 > rectf.top)
            {
                rectf.top = f8;
            }
            if (f3 <= cropeditorview.i.left + 0.1F && f3 > rectf.left)
            {
                rectf.left = f3;
            }
            if (f6 <= cropeditorview.i.left + 0.1F && f6 > rectf.left)
            {
                rectf.left = f6;
            }
            if (f3 >= cropeditorview.i.right - 0.1F && f3 < rectf.right)
            {
                rectf.right = f3;
            }
            if (f6 >= cropeditorview.i.right - 0.1F && f6 < rectf.right)
            {
                rectf.right = f6;
            }
            if (f7 >= cropeditorview.i.bottom - 0.1F && f7 < rectf.bottom)
            {
                rectf.bottom = f7;
            }
            if (f8 >= cropeditorview.i.bottom - 0.1F && f8 < rectf.bottom)
            {
                rectf.bottom = f8;
            }
        }

        f3 = f1;
        if (verticalside == null) goto _L2; else goto _L1
_L1:
        final class _cls6
        {

            static final int a[];
            static final int b[];

            static 
            {
                b = new int[com.socialin.android.util.Geom.HorizontalSide.values().length];
                try
                {
                    b[com.socialin.android.util.Geom.HorizontalSide.TOP.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    b[com.socialin.android.util.Geom.HorizontalSide.BOTTOM.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                a = new int[com.socialin.android.util.Geom.VerticalSide.values().length];
                try
                {
                    a[com.socialin.android.util.Geom.VerticalSide.LEFT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.socialin.android.util.Geom.VerticalSide.RIGHT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        com.picsart.studio.editor.view._cls6.a[verticalside.ordinal()];
        JVM INSTR tableswitch 1 2: default 780
    //                   1 1271
    //                   2 1302;
           goto _L3 _L4 _L5
_L3:
        f3 = f1;
_L2:
        f1 = f2;
        if (horizontalside == null) goto _L7; else goto _L6
_L6:
        _cls6.b[horizontalside.ordinal()];
        JVM INSTR tableswitch 1 2: default 820
    //                   1 1333
    //                   2 1364;
           goto _L8 _L9 _L10
_L10:
        break MISSING_BLOCK_LABEL_1364;
_L8:
        f1 = f2;
_L7:
        if (verticalside != null)
        {
            Geom.a(cropeditorview.i, verticalside, f3);
        }
        if (horizontalside != null)
        {
            Geom.a(cropeditorview.i, horizontalside, f1);
        }
        if (cropeditorview.j)
        {
            if (verticalside == null)
            {
                Geom.b(cropeditorview.i, cropeditorview.k, true, false, true, false);
                Geom.a(cropeditorview.i, cropeditorview.k, true, false, true, false);
            } else
            if (horizontalside == null)
            {
                Geom.b(cropeditorview.i, cropeditorview.k, false, true, false, true);
                Geom.a(cropeditorview.i, cropeditorview.k, false, true, false, true);
            } else
            {
                Geom.b(cropeditorview.i, cropeditorview.k, verticalside, horizontalside);
                Geom.a(cropeditorview.i, cropeditorview.k, verticalside, horizontalside);
            }
            f1 = cropeditorview.i.centerX();
            f2 = cropeditorview.i.centerY();
            if (verticalside == com.socialin.android.util.Geom.VerticalSide.LEFT)
            {
                f1 = cropeditorview.i.right;
            } else
            if (verticalside == com.socialin.android.util.Geom.VerticalSide.RIGHT)
            {
                f1 = cropeditorview.i.left;
            }
            if (horizontalside == com.socialin.android.util.Geom.HorizontalSide.TOP)
            {
                f2 = cropeditorview.i.bottom;
            } else
            if (horizontalside == com.socialin.android.util.Geom.HorizontalSide.BOTTOM)
            {
                f2 = cropeditorview.i.top;
            }
            if (cropeditorview.i.width() < f4)
            {
                f3 = f4 / Math.max(cropeditorview.i.width(), 1.0F);
                Geom.c(cropeditorview.i, f1, f2, f3);
            }
            if (cropeditorview.i.height() < f5)
            {
                f3 = f5 / Math.max(cropeditorview.i.height(), 1.0F);
                Geom.c(cropeditorview.i, f1, f2, f3);
            }
            if (cropeditorview.i.left < cropeditorview.I.left)
            {
                f3 = ((cropeditorview.I.left - cropeditorview.i.left) * 2.0F) / cropeditorview.i.width();
                Geom.c(cropeditorview.i, f1, f2, 1.0F - f3);
            }
            if (cropeditorview.i.right > cropeditorview.I.right)
            {
                f3 = ((cropeditorview.i.right - cropeditorview.I.right) * 2.0F) / cropeditorview.i.width();
                Geom.c(cropeditorview.i, f1, f2, 1.0F - f3);
            }
            if (cropeditorview.i.top < cropeditorview.I.top)
            {
                f3 = ((cropeditorview.I.top - cropeditorview.i.top) * 2.0F) / cropeditorview.i.height();
                Geom.c(cropeditorview.i, f1, f2, 1.0F - f3);
            }
            if (cropeditorview.i.bottom > cropeditorview.I.bottom)
            {
                f3 = ((cropeditorview.i.bottom - cropeditorview.I.bottom) * 2.0F) / cropeditorview.i.height();
                Geom.c(cropeditorview.i, f1, f2, 1.0F - f3);
            }
        }
        cropeditorview.a(false, false);
        cropeditorview.invalidate();
        return;
_L4:
        f1 = Math.min(cropeditorview.i.right - f4, f1);
        f3 = Math.max(cropeditorview.I.left, f1);
          goto _L2
_L5:
        f1 = Math.max(cropeditorview.i.left + f4, f1);
        f3 = Math.min(cropeditorview.I.right, f1);
          goto _L2
_L9:
        f1 = Math.min(cropeditorview.i.bottom - f5, f2);
        f1 = Math.max(cropeditorview.I.top, f1);
          goto _L7
        f1 = Math.max(cropeditorview.i.top + f5, f2);
        f1 = Math.min(cropeditorview.I.bottom, f1);
          goto _L7
    }

    static boolean a(CropEditorView cropeditorview, boolean flag)
    {
        cropeditorview.a = flag;
        return flag;
    }

    static float b(CropEditorView cropeditorview, float f1)
    {
        cropeditorview.h = f1;
        return f1;
    }

    static RectF b(CropEditorView cropeditorview)
    {
        return cropeditorview.i;
    }

    static boolean b(CropEditorView cropeditorview, boolean flag)
    {
        cropeditorview.r = flag;
        return flag;
    }

    static float c(CropEditorView cropeditorview, float f1)
    {
        cropeditorview.S = f1;
        return f1;
    }

    static void c(CropEditorView cropeditorview)
    {
        cropeditorview.h();
    }

    static boolean c(CropEditorView cropeditorview, boolean flag)
    {
        cropeditorview.u = flag;
        return flag;
    }

    public static int d()
    {
        return 30;
    }

    static String d(CropEditorView cropeditorview)
    {
        if (com.picsart.studio.editor.e.a().b() && (cropeditorview.getContext() instanceof EditorActivity))
        {
            return com.picsart.studio.editor.e.a().e.a;
        } else
        {
            return "";
        }
    }

    public static int e()
    {
        return 30;
    }

    static boolean e(CropEditorView cropeditorview)
    {
        return cropeditorview.l;
    }

    static Bitmap f(CropEditorView cropeditorview)
    {
        return cropeditorview.D;
    }

    static void g(CropEditorView cropeditorview)
    {
        cropeditorview.g();
    }

    static float h(CropEditorView cropeditorview)
    {
        return cropeditorview.h;
    }

    static RulerView i(CropEditorView cropeditorview)
    {
        return cropeditorview.q;
    }

    static ValueAnimator j(CropEditorView cropeditorview)
    {
        return cropeditorview.b;
    }

    private boolean j()
    {
        boolean flag;
        if (D != null && !D.isRecycled())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            if (n != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                return true;
            }
        }
        return false;
    }

    static RectF k(CropEditorView cropeditorview)
    {
        return cropeditorview.e;
    }

    static float l(CropEditorView cropeditorview)
    {
        return cropeditorview.k;
    }

    static RectF m(CropEditorView cropeditorview)
    {
        return cropeditorview.n;
    }

    static float n(CropEditorView cropeditorview)
    {
        return cropeditorview.c;
    }

    static float o(CropEditorView cropeditorview)
    {
        return cropeditorview.d;
    }

    static boolean p(CropEditorView cropeditorview)
    {
        cropeditorview.j = false;
        return false;
    }

    static int q(CropEditorView cropeditorview)
    {
        int i1 = cropeditorview.g % 4;
        cropeditorview.g = i1;
        return i1;
    }

    static int r(CropEditorView cropeditorview)
    {
        return cropeditorview.g;
    }

    static void s(CropEditorView cropeditorview)
    {
        cropeditorview.i();
    }

    static com.picsart.studio.editor.view.d t(CropEditorView cropeditorview)
    {
        return cropeditorview.U;
    }

    static d u(CropEditorView cropeditorview)
    {
        return cropeditorview.t;
    }

    static float v(CropEditorView cropeditorview)
    {
        return cropeditorview.z;
    }

    static boolean w(CropEditorView cropeditorview)
    {
        return cropeditorview.a(((Runnable) (null)), true);
    }

    static Matrix x(CropEditorView cropeditorview)
    {
        return cropeditorview.aa;
    }

    static boolean y(CropEditorView cropeditorview)
    {
        return cropeditorview.u;
    }

    static float z(CropEditorView cropeditorview)
    {
        return cropeditorview.f;
    }

    public final float a(float f1)
    {
        return (float)g * 90F + f1;
    }

    public final float a(boolean flag, boolean flag1)
    {
        float f2 = 0.0F;
        a(m, -h);
        F.set(e);
        float f3 = Math.max(m.width() / F.width(), m.height() / F.height());
        float f1;
        float f4;
        float f5;
        if (f3 > 1.0F)
        {
            Geom.a(F, f3);
        } else
        if (flag)
        {
            f1 = e.width() / c;
            if (f1 * f3 > f)
            {
                Geom.a(F, f3);
            } else
            {
                Geom.a(F, f / f1);
            }
        }
        f4 = (float)Math.cos(Math.toRadians(h));
        f5 = (float)Math.sin(Math.toRadians(h));
        if (F.left > m.left)
        {
            f1 = m.left - F.left;
        } else
        if (F.right < m.right)
        {
            f1 = m.right - F.right;
        } else
        {
            f1 = 0.0F;
        }
        if (F.top > m.top)
        {
            f2 = m.top - F.top;
        } else
        if (F.bottom < m.bottom)
        {
            f2 = m.bottom - F.bottom;
        }
        F.offset(f1 * f4 - f2 * f5, f1 * f5 + f2 * f4);
        if (flag1) goto _L2; else goto _L1
_L1:
        e.set(F);
        if (!flag && f3 < 1.0F)
        {
            f = e.width() / c;
        }
        g();
        invalidate();
_L4:
        return f3;
_L2:
        if (e.left == F.left && e.right == F.right && e.bottom == F.bottom && e.top == F.top) goto _L4; else goto _L3
_L3:
        f1 = Geom.b(e, F);
        a(e, F, new Runnable() {

            private CropEditorView a;

            public final void run()
            {
                com.picsart.studio.editor.view.CropEditorView.g(a);
            }

            
            {
                a = CropEditorView.this;
                super();
            }
        }, (long)(f1 / 2.0F), new android.animation.ValueAnimator.AnimatorUpdateListener(flag) {

            private boolean a;
            private CropEditorView b;

            public final void onAnimationUpdate(ValueAnimator valueanimator)
            {
                CropEditorView.k(b).set((RectF)valueanimator.getAnimatedValue());
                if (!a)
                {
                    com.picsart.studio.editor.view.CropEditorView.a(b, CropEditorView.k(b).width() / CropEditorView.n(b));
                }
                b.invalidate();
            }

            
            {
                b = CropEditorView.this;
                a = flag;
                super();
            }
        });
        return f3;
        if (true) goto _L6; else goto _L5
_L6:
        break MISSING_BLOCK_LABEL_175;
_L5:
    }

    public final void a(RectF rectf, float f1)
    {
        L.setRotate(f1, e.centerX(), e.centerY());
        L.mapRect(rectf, i);
        rectf.sort();
    }

    public final boolean a()
    {
        return b != null || a;
    }

    public final boolean a(Runnable runnable)
    {
        if (b == null && !a)
        {
            b = ValueAnimator.ofFloat(new float[] {
                h, (float)g * 90F
            });
            b.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {

                private CropEditorView a;

                public final void onAnimationUpdate(ValueAnimator valueanimator)
                {
                    com.picsart.studio.editor.view.CropEditorView.a(a, ((Float)valueanimator.getAnimatedValue()).floatValue() - CropEditorView.h(a), CropEditorView.b(a).centerX(), CropEditorView.b(a).centerY(), true);
                    com.picsart.studio.editor.view.CropEditorView.i(a).setProgress(com.picsart.studio.editor.view.CropEditorView.a(a));
                }

            
            {
                a = CropEditorView.this;
                super();
            }
            });
            b.addListener(new ag(runnable) {

                private Runnable a;
                private CropEditorView b;

                public final void onAnimationCancel(Animator animator)
                {
                    super.onAnimationCancel(animator);
                    com.picsart.studio.editor.view.CropEditorView.a(b, false);
                }

                public final void onAnimationEnd(Animator animator)
                {
                    com.picsart.studio.editor.view.CropEditorView.a(b, false);
                    CropEditorView.j(b).removeAllListeners();
                    CropEditorView.j(b).removeAllUpdateListeners();
                    com.picsart.studio.editor.view.CropEditorView.a(b, null);
                    if (a != null)
                    {
                        a.run();
                    }
                }

                public final void onAnimationStart(Animator animator)
                {
                    super.onAnimationStart(animator);
                    com.picsart.studio.editor.view.CropEditorView.a(b, true);
                }

            
            {
                b = CropEditorView.this;
                a = runnable;
                super();
            }
            });
            b.setDuration((long)((500F * Math.abs(f())) / 45F));
            b.start();
            return true;
        } else
        {
            return false;
        }
    }

    public final boolean a(Runnable runnable, boolean flag)
    {
        V.set(i);
        W.set(i);
        Geom.a(W, n, com.socialin.android.util.Geom.Fit.CENTER);
        float f1 = W.width() / V.width();
        if (!Geom.c(V, W))
        {
            f = f1 * f;
            if (flag)
            {
                a(V, W, ((Runnable) (null)), 300L, new android.animation.ValueAnimator.AnimatorUpdateListener() {

                    private CropEditorView a;

                    public final void onAnimationUpdate(ValueAnimator valueanimator)
                    {
                        valueanimator = (RectF)valueanimator.getAnimatedValue();
                        CropEditorView.x(a).setRectToRect(CropEditorView.b(a), valueanimator, android.graphics.Matrix.ScaleToFit.CENTER);
                        CropEditorView.x(a).mapRect(CropEditorView.k(a));
                        CropEditorView.b(a).set(valueanimator);
                        com.picsart.studio.editor.view.CropEditorView.g(a);
                        a.invalidate();
                    }

            
            {
                a = CropEditorView.this;
                super();
            }
                });
            } else
            {
                aa.setRectToRect(i, W, android.graphics.Matrix.ScaleToFit.CENTER);
                aa.mapRect(e);
                i.set(W);
                g();
                invalidate();
            }
            return true;
        } else
        {
            return false;
        }
    }

    public final int b()
    {
        float f1 = e.width() / c;
        return (int)Math.floor(i.width() / f1 + 0.5F);
    }

    public final int c()
    {
        float f1 = e.width() / c;
        return (int)Math.floor(i.height() / f1 + 0.5F);
    }

    public final float f()
    {
        return h - (float)g * 90F;
    }

    public final void g()
    {
        if (Q != null)
        {
            Q.a(b(), c());
        }
    }

    public float getRotation()
    {
        return h;
    }

    public final void h()
    {
        if (Q != null)
        {
            Q.a(f());
        }
    }

    public final void i()
    {
        if (Q != null)
        {
            Q.a();
        }
    }

    public boolean isOpaque()
    {
        return true;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (E != null && E != D)
        {
            E.recycle();
            E = null;
        }
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (j())
        {
            Object obj = y;
            float f1;
            float f2;
            int i1;
            boolean flag;
            if (h % 90F != 0.0F)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ((Paint) (obj)).setAntiAlias(flag);
            canvas.save();
            canvas.rotate(h, e.centerX(), e.centerY());
            canvas.save();
            canvas.drawBitmap(E, null, e, y);
            canvas.restore();
            canvas.restore();
            obj = i;
            canvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
            canvas.drawColor(x);
            if (r)
            {
                canvas.rotate(S, i.centerX(), i.centerY());
            }
            canvas.drawRect(i, w);
            canvas.restore();
            canvas.save();
            if (r)
            {
                canvas.rotate(S, i.centerX(), i.centerY());
            }
            if (u)
            {
                i1 = 5;
            } else
            {
                i1 = 2;
            }
            f1 = ((RectF) (obj)).width() / ((float)i1 + 1.0F);
            f2 = ((RectF) (obj)).height() / ((float)i1 + 1.0F);
            v.setColor(0x80000000);
            v.setStrokeWidth(O);
            for (int j1 = 1; j1 <= i1; j1++)
            {
                float f3 = ((RectF) (obj)).left;
                float f5 = ((RectF) (obj)).top;
                float f7 = j1;
                float f9 = ((RectF) (obj)).right;
                float f11 = ((RectF) (obj)).top;
                canvas.drawLine(f3, f7 * f2 + f5, f9, (float)j1 * f2 + f11, v);
                f3 = ((RectF) (obj)).left;
                f5 = j1;
                f7 = ((RectF) (obj)).top;
                f9 = ((RectF) (obj)).left;
                canvas.drawLine(f5 * f1 + f3, f7, (float)j1 * f1 + f9, ((RectF) (obj)).bottom, v);
            }

            v.setColor(-1);
            v.setStrokeWidth(P);
            for (int k1 = 1; k1 <= i1; k1++)
            {
                float f4 = ((RectF) (obj)).left;
                float f6 = ((RectF) (obj)).top;
                float f8 = k1;
                float f10 = ((RectF) (obj)).right;
                float f12 = ((RectF) (obj)).top;
                canvas.drawLine(f4, f8 * f2 + f6, f10, (float)k1 * f2 + f12, v);
                f4 = ((RectF) (obj)).left;
                f6 = k1;
                f8 = ((RectF) (obj)).top;
                f10 = ((RectF) (obj)).left;
                canvas.drawLine(f6 * f1 + f4, f8, (float)k1 * f1 + f10, ((RectF) (obj)).bottom, v);
            }

            v.setColor(0x80000000);
            v.setStrokeWidth(M);
            canvas.drawRect(i, v);
            v.setColor(-1);
            v.setStrokeWidth(N);
            canvas.drawRect(i, v);
            f1 = -N / 2.0F;
            if (A != null)
            {
                myobfuscated.b.a.drawWithIntrinsicSize(canvas, A, ((RectF) (obj)).left + f1, ((RectF) (obj)).top + f1, 85, 180F);
                myobfuscated.b.a.drawWithIntrinsicSize(canvas, A, ((RectF) (obj)).right - f1, ((RectF) (obj)).top + f1, 85, 270F);
                myobfuscated.b.a.drawWithIntrinsicSize(canvas, A, ((RectF) (obj)).right - f1, ((RectF) (obj)).bottom - f1, 85, 0.0F);
                myobfuscated.b.a.drawWithIntrinsicSize(canvas, A, ((RectF) (obj)).left + f1, ((RectF) (obj)).bottom - f1, 85, 90F);
            }
            if (B != null)
            {
                myobfuscated.b.a.drawWithIntrinsicSize(canvas, B, ((RectF) (obj)).centerX(), ((RectF) (obj)).top + f1, 21, 270F);
                myobfuscated.b.a.drawWithIntrinsicSize(canvas, B, ((RectF) (obj)).right - f1, ((RectF) (obj)).centerY(), 21, 0.0F);
                myobfuscated.b.a.drawWithIntrinsicSize(canvas, B, ((RectF) (obj)).centerX(), ((RectF) (obj)).bottom - f1, 21, 90F);
                myobfuscated.b.a.drawWithIntrinsicSize(canvas, B, ((RectF) (obj)).left + f1, ((RectF) (obj)).centerY(), 21, 180F);
            }
            canvas.restore();
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        i = com.picsart.studio.editor.view.SavedState.a(parcelable);
        e = SavedState.b(parcelable);
        h = SavedState.c(parcelable);
        g = com.picsart.studio.editor.view.SavedState.d(parcelable);
        f = com.picsart.studio.editor.view.SavedState.e(parcelable);
        j = com.picsart.studio.editor.view.SavedState.f(parcelable);
        k = com.picsart.studio.editor.view.SavedState.g(parcelable);
        u = SavedState.h(parcelable);
        s = com.picsart.studio.editor.view.SavedState.i(parcelable);
        R = true;
    }

    protected Parcelable onSaveInstanceState()
    {
        return new SavedState(super.onSaveInstanceState(), this);
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        n = new RectF(getPaddingLeft(), getPaddingTop(), (float)i1 - (float)getPaddingRight(), (float)j1 - (float)getPaddingBottom());
        if (R)
        {
            a(((Runnable) (null)), true);
            return;
        }
        if (j)
        {
            RectF rectf = new RectF(0.0F, 0.0F, 1.0F, k);
            Geom.a(rectf, n, com.socialin.android.util.Geom.Fit.CENTER);
            i.set(rectf);
            e.set(0.0F, 0.0F, c, d);
            Geom.a(e, i.centerX(), i.centerY());
            float f1 = Math.max(i.width() / e.width(), i.height() / e.height());
            Geom.a(e, f1);
        } else
        {
            e.set(0.0F, 0.0F, c, d);
            Geom.a(e, n, com.socialin.android.util.Geom.Fit.CENTER);
            i.set(e);
        }
        h = 0.0F;
        f = e.width() / c;
        g();
        i();
        R = true;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (a || !j())
        {
            return false;
        }
        if (motionevent.getActionMasked() == 0)
        {
            U = null;
        }
        if (U == null) goto _L2; else goto _L1
_L1:
        if (U.a(motionevent) == Response.REJECT)
        {
            U = null;
        }
_L4:
        return true;
_L2:
        Iterator iterator = T.iterator();
        com.picsart.studio.editor.view.d d1;
        do
        {
            if (!iterator.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            d1 = (com.picsart.studio.editor.view.d)iterator.next();
        } while (d1.a(motionevent) != Response.ACCEPT);
        U = d1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setAspectRatio(float f1)
    {
        if (f1 > 0.0F)
        {
            j = true;
            k = 1.0F / f1;
        }
    }

    public void setAspectRatioFixed(boolean flag)
    {
        l = flag;
    }

    public void setCornerHandleDrawable(Drawable drawable)
    {
        A = drawable;
        invalidate();
    }

    public void setDimColor(int i1)
    {
        x = i1;
        invalidate();
    }

    public void setImage(Bitmap bitmap)
    {
        D = bitmap;
        if (bitmap != null)
        {
            c = bitmap.getWidth();
            d = bitmap.getHeight();
            E = com.socialin.android.util.w.f(bitmap, 2048);
            invalidate();
        }
    }

    public void setOnSelectionChangedListener(b b1)
    {
        Q = b1;
    }

    public void setOutputSize(int i1, int j1)
    {
        o = i1;
        p = j1;
        if (o > 0 && p > 0)
        {
            j = true;
            k = (float)j1 / (float)i1;
        }
    }

    public void setRulerView(RulerView rulerview)
    {
        q = rulerview;
        rulerview.setOnProgressChangedListener(new r() {

            private CropEditorView a;

            public final void a()
            {
                AnalyticUtils analyticutils = AnalyticUtils.getInstance(a.getContext());
                String s1 = com.picsart.studio.editor.view.CropEditorView.d(a);
                CropEditorView cropeditorview = a;
                int i1 = cropeditorview.s + 1;
                cropeditorview.s = i1;
                analyticutils.track(new com.socialin.android.apiv3.events.EventsFactory.ToolCropTryEvent(s1, i1, a.getRotation(), "", com.picsart.studio.editor.view.CropEditorView.e(a), com.picsart.studio.editor.view.CropEditorView.f(a).getWidth(), com.picsart.studio.editor.view.CropEditorView.f(a).getHeight(), a.b(), a.c(), "strengthen"));
            }

            public final void a(float f1)
            {
                com.picsart.studio.editor.view.CropEditorView.a(a, f1 - com.picsart.studio.editor.view.CropEditorView.a(a), CropEditorView.b(a).centerX(), CropEditorView.b(a).centerY(), true);
                CropEditorView.c(a);
            }

            
            {
                a = CropEditorView.this;
                super();
            }
        });
    }

    public void setScreenRectF(RectF rectf)
    {
        H = rectf;
    }

    public void setSelectionProportion(float f1)
    {
        boolean flag = j;
        j = true;
        if (k != f1 || !flag)
        {
            k = f1;
            RectF rectf = new RectF(0.0F, 0.0F, 1.0F, f1);
            Geom.a(rectf, new RectF(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom()), com.socialin.android.util.Geom.Fit.CENTER);
            a(i, rectf, ((Runnable) (null)), 300L, new android.animation.ValueAnimator.AnimatorUpdateListener() {

                private CropEditorView a;

                public final void onAnimationUpdate(ValueAnimator valueanimator)
                {
                    CropEditorView.b(a).set((RectF)valueanimator.getAnimatedValue());
                    com.picsart.studio.editor.view.CropEditorView.a(a, true, false);
                    com.picsart.studio.editor.view.CropEditorView.g(a);
                }

            
            {
                a = CropEditorView.this;
                super();
            }
            });
        }
    }

    public void setSideHandleDrawable(Drawable drawable)
    {
        B = drawable;
        invalidate();
    }

    public void setTouchPrecision(float f1)
    {
        z = f1;
    }

    static 
    {
        com/picsart/studio/editor/view/CropEditorView.getSimpleName();
    }

    // Unreferenced inner class com/picsart/studio/editor/view/CropEditorView$10

/* anonymous class */
    public final class _cls10
        implements Runnable
    {

        final CropEditorView a;

        public final void run()
        {
            RectF rectf = new RectF(CropEditorView.k(a));
            RectF rectf1 = new RectF();
            RectF rectf2 = new RectF(CropEditorView.b(a));
            RectF rectf3 = new RectF();
            int i1;
            if (com.picsart.studio.editor.view.CropEditorView.e(a))
            {
                rectf3.set(0.0F, 0.0F, 1.0F, CropEditorView.l(a));
                Geom.a(rectf3, CropEditorView.m(a), com.socialin.android.util.Geom.Fit.CENTER);
                rectf1.set(0.0F, 0.0F, CropEditorView.n(a), CropEditorView.o(a));
                Geom.a(rectf1, rectf3.centerX(), rectf3.centerY());
                Geom.a(rectf1, Math.max(rectf3.width() / rectf1.width(), rectf3.height() / rectf1.height()));
            } else
            {
                CropEditorView.p(a);
                rectf1.set(0.0F, 0.0F, CropEditorView.n(a), CropEditorView.o(a));
                Geom.a(rectf1, CropEditorView.m(a), com.socialin.android.util.Geom.Fit.CENTER);
                rectf3.set(rectf1);
            }
            com.picsart.studio.editor.view.CropEditorView.a(a, rectf1.width() / CropEditorView.n(a));
            CropEditorView.q(a);
            if (CropEditorView.r(a) <= 2)
            {
                i1 = 0;
            } else
            {
                i1 = 4;
            }
            com.picsart.studio.editor.view.CropEditorView.a(a, ValueAnimator.ofFloat(new float[] {
                (float)CropEditorView.r(a), (float)i1
            }));
            CropEditorView.j(a).addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener(this, rectf, rectf1, rectf2, rectf3) {

                private RectF a;
                private RectF b;
                private RectF c;
                private RectF d;
                private _cls10 e;

                public final void onAnimationUpdate(ValueAnimator valueanimator)
                {
                    float f1 = valueanimator.getAnimatedFraction();
                    float f2 = ((Float)valueanimator.getAnimatedValue()).floatValue();
    public final class _cls10
        implements Runnable
    {
                    com.picsart.studio.editor.view.CropEditorView.a(e.a, (int)f2);
                    CropEditorView.b(e.a, f2 * 90F);
                    Geom.a(CropEditorView.k(e.a), a, b, f1);
                    Geom.a(CropEditorView.b(e.a), c, d, f1);
                    e.a.invalidate();
                    com.picsart.studio.editor.view.CropEditorView.g(e.a);
                }

            
            {
                e = _pcls10;
                a = rectf;
                b = rectf1;
                c = rectf2;
                d = rectf3;
                super();
            }
            });
            CropEditorView.j(a).addListener(new ag(this) {

                private _cls10 a;

                public final void onAnimationCancel(Animator animator)
                {
                    super.onAnimationCancel(animator);
                    com.picsart.studio.editor.view.CropEditorView.a(a.a, false);
                }

                public final void onAnimationEnd(Animator animator)
                {
                    com.picsart.studio.editor.view.CropEditorView.a(a.a, false);
                    CropEditorView.j(a.a).removeAllListeners();
                    CropEditorView.j(a.a).removeAllUpdateListeners();
                    com.picsart.studio.editor.view.CropEditorView.a(a.a, null);
                    com.picsart.studio.editor.view.CropEditorView.a(a.a, 0);
                    CropEditorView.b(a.a, 0.0F);
                }

                public final void onAnimationStart(Animator animator)
                {
                    super.onAnimationStart(animator);
                    com.picsart.studio.editor.view.CropEditorView.a(a.a, true);
                }

            
            {
                a = _pcls10;
                super();
            }
            });
            CropEditorView.j(a).setDuration(300L);
            CropEditorView.j(a).start();
        }

            public 
            {
                a = CropEditorView.this;
                super();
            }
    }


    // Unreferenced inner class com/picsart/studio/editor/view/CropEditorView$13

/* anonymous class */
    public final class _cls13
        implements android.animation.ValueAnimator.AnimatorUpdateListener
    {

        private RectF a;
        private RectF b;
        private float c;
        private float d;
        private float e;
        private float f;
        private float g;
        private CropEditorView h;

        public final void onAnimationUpdate(ValueAnimator valueanimator)
        {
            float f1 = ((Float)valueanimator.getAnimatedValue()).floatValue();
            float f2 = valueanimator.getAnimatedFraction();
            Geom.a(CropEditorView.b(h), a, b, f2);
            float f3 = (c + (d - c) * f2) / CropEditorView.k(h).width();
            Geom.c(CropEditorView.k(h), CropEditorView.b(h).centerX(), CropEditorView.b(h).centerY(), f3);
            CropEditorView.c(h, 90F * f2);
            com.picsart.studio.editor.view.CropEditorView.a(h, Geom.b(e, f, f2));
            com.picsart.studio.editor.view.CropEditorView.a(h, f1 - CropEditorView.h(h), CropEditorView.b(h).centerX(), CropEditorView.b(h).centerY(), false);
            com.picsart.studio.editor.view.CropEditorView.i(h).setProgress((1.0F - f2) * g);
            h.invalidate();
        }

            public 
            {
                h = CropEditorView.this;
                a = rectf;
                b = rectf1;
                c = f1;
                d = f2;
                e = f3;
                f = f4;
                g = f5;
                super();
            }
    }


    // Unreferenced inner class com/picsart/studio/editor/view/CropEditorView$14

/* anonymous class */
    public final class _cls14 extends ag
    {

        private RectF a;
        private CropEditorView b;

        public final void onAnimationCancel(Animator animator)
        {
            super.onAnimationCancel(animator);
            com.picsart.studio.editor.view.CropEditorView.a(b, false);
            CropEditorView.b(b, false);
            CropEditorView.s(b);
        }

        public final void onAnimationEnd(Animator animator)
        {
            com.picsart.studio.editor.view.CropEditorView.a(b, false);
            CropEditorView.j(b).removeAllListeners();
            CropEditorView.j(b).removeAllUpdateListeners();
            com.picsart.studio.editor.view.CropEditorView.a(b, null);
            CropEditorView.b(b, false);
            CropEditorView.b(b).set(a);
            CropEditorView.c(b, 0.0F);
            com.picsart.studio.editor.view.CropEditorView.g(b);
            CropEditorView.s(b);
        }

        public final void onAnimationStart(Animator animator)
        {
            super.onAnimationStart(animator);
            com.picsart.studio.editor.view.CropEditorView.a(b, true);
            CropEditorView.b(b, true);
            CropEditorView.c(b, 0.0F);
        }

            public 
            {
                b = CropEditorView.this;
                a = rectf;
                super();
            }
    }


    // Unreferenced inner class com/picsart/studio/editor/view/CropEditorView$2

/* anonymous class */
    public final class _cls2
        implements android.animation.ValueAnimator.AnimatorUpdateListener
    {

        private float a;
        private CropEditorView b;

        public final void onAnimationUpdate(ValueAnimator valueanimator)
        {
            float f1 = ((Float)valueanimator.getAnimatedValue()).floatValue();
            float f2 = valueanimator.getAnimatedFraction();
            com.picsart.studio.editor.view.CropEditorView.a(b, f1 - CropEditorView.h(b), CropEditorView.b(b).centerX(), CropEditorView.b(b).centerY(), false);
            com.picsart.studio.editor.view.CropEditorView.i(b).setProgress((1.0F - f2) * a);
            b.invalidate();
        }

            public 
            {
                b = CropEditorView.this;
                a = f1;
                super();
            }
    }


    // Unreferenced inner class com/picsart/studio/editor/view/CropEditorView$3

/* anonymous class */
    public final class _cls3 extends ag
    {

        private Runnable a;
        private CropEditorView b;

        public final void onAnimationCancel(Animator animator)
        {
            super.onAnimationCancel(animator);
            com.picsart.studio.editor.view.CropEditorView.a(b, false);
            CropEditorView.b(b, false);
            CropEditorView.s(b);
        }

        public final void onAnimationEnd(Animator animator)
        {
            com.picsart.studio.editor.view.CropEditorView.a(b, false);
            CropEditorView.j(b).removeAllListeners();
            CropEditorView.j(b).removeAllUpdateListeners();
            com.picsart.studio.editor.view.CropEditorView.a(b, null);
            CropEditorView.b(b, false);
            if (a != null)
            {
                a.run();
            }
            com.picsart.studio.editor.view.CropEditorView.g(b);
            CropEditorView.s(b);
        }

        public final void onAnimationStart(Animator animator)
        {
            super.onAnimationStart(animator);
            com.picsart.studio.editor.view.CropEditorView.a(b, true);
        }

            public 
            {
                b = CropEditorView.this;
                a = null;
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
        private RectF a;
        private RectF b;
        private float c;
        private int d;
        private float e;
        private boolean f;
        private float g;
        private boolean h;
        private int i;

        static RectF a(SavedState savedstate)
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

        static float e(SavedState savedstate)
        {
            return savedstate.e;
        }

        static boolean f(SavedState savedstate)
        {
            return savedstate.f;
        }

        static float g(SavedState savedstate)
        {
            return savedstate.g;
        }

        static boolean h(SavedState savedstate)
        {
            return savedstate.h;
        }

        static int i(SavedState savedstate)
        {
            return savedstate.i;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            boolean flag = true;
            super.writeToParcel(parcel, i1);
            parcel.writeParcelable(a, i1);
            parcel.writeParcelable(b, i1);
            parcel.writeFloat(c);
            parcel.writeInt(d);
            parcel.writeFloat(e);
            if (f)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            parcel.writeFloat(g);
            if (h)
            {
                i1 = ((flag) ? 1 : 0);
            } else
            {
                i1 = 0;
            }
            parcel.writeInt(i1);
            parcel.writeInt(i);
        }


        public SavedState(Parcel parcel)
        {
            boolean flag1 = true;
            super(parcel);
            a = (RectF)parcel.readParcelable(android/graphics/RectF.getClassLoader());
            b = (RectF)parcel.readParcelable(android/graphics/RectF.getClassLoader());
            c = parcel.readFloat();
            d = parcel.readInt();
            e = parcel.readFloat();
            boolean flag;
            if (parcel.readInt() == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            f = flag;
            g = parcel.readFloat();
            if (parcel.readInt() == 1)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            h = flag;
            i = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, CropEditorView cropeditorview)
        {
            super(parcelable);
            a = CropEditorView.b(cropeditorview);
            b = CropEditorView.k(cropeditorview);
            c = CropEditorView.h(cropeditorview);
            d = CropEditorView.r(cropeditorview);
            e = CropEditorView.z(cropeditorview);
            f = CropEditorView.A(cropeditorview);
            g = CropEditorView.l(cropeditorview);
            h = CropEditorView.y(cropeditorview);
            i = cropeditorview.s;
        }
    }


    private class Response extends Enum
    {

        private static final Response $VALUES[];
        public static final Response ACCEPT;
        public static final Response REJECT;

        public static Response valueOf(String s1)
        {
            return (Response)Enum.valueOf(com/picsart/studio/editor/view/CropEditorView$Response, s1);
        }

        public static Response[] values()
        {
            return (Response[])$VALUES.clone();
        }

        static 
        {
            ACCEPT = new Response("ACCEPT", 0);
            REJECT = new Response("REJECT", 1);
            $VALUES = (new Response[] {
                ACCEPT, REJECT
            });
        }

        private Response(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
