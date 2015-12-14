// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.colorsplash;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SlidingDrawer;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.android.util.c;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import myobfuscated.bc.b;

// Referenced classes of package com.picsart.effects.colorsplash:
//            MyGLSurfaceView, a, ColorSplashActivity, b, 
//            c, f

public class ColorSplashForegroundView extends View
{

    private static float n;
    private static int o;
    private static int p;
    private static int q;
    private static float r;
    private static float s;
    private static final int t = Color.argb(128, 0, 0, 0);
    private RectF A;
    private RectF B;
    private Rect C;
    private RectF D;
    private float E;
    private ByteBuffer F;
    private ByteBuffer G;
    private boolean H;
    private Handler I;
    private Bitmap J;
    private Paint K;
    private Paint L;
    private boolean M;
    private RectF N;
    private Rect O;
    private Path P;
    private Path Q;
    private float R;
    private float S;
    private int T;
    private int U[] = {
        60, 48, 36, 24, 12
    };
    private Paint V;
    private a W;
    int a;
    private boolean aa;
    PickerState b;
    Bitmap c;
    Canvas d;
    public ArrayList e;
    ArrayList f;
    ArrayList g;
    int h;
    Paint i;
    float j;
    int k;
    boolean l;
    boolean m;
    private PointF u;
    private Paint v;
    private Paint w;
    private MyGLSurfaceView x;
    private float y;
    private float z;

    public ColorSplashForegroundView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        u = new PointF();
        v = new Paint();
        w = new Paint();
        A = new RectF();
        C = new Rect();
        D = new RectF();
        E = 1.0F;
        H = false;
        b = PickerState.CLOSED;
        I = new Handler(Looper.getMainLooper());
        e = new ArrayList();
        f = new ArrayList();
        g = new ArrayList();
        M = false;
        N = new RectF();
        O = new Rect();
        P = new Path();
        Q = new Path();
        T = 30;
        h = 2;
        j = 25F;
        k = 255;
        l = false;
        m = false;
        aa = true;
        v.setStyle(android.graphics.Paint.Style.STROKE);
        v.setAntiAlias(true);
        n = (int)TypedValue.applyDimension(1, 75F, context.getResources().getDisplayMetrics());
        o = (int)TypedValue.applyDimension(1, 15F, context.getResources().getDisplayMetrics());
        p = (int)TypedValue.applyDimension(1, 20F, context.getResources().getDisplayMetrics());
        q = (int)TypedValue.applyDimension(1, 22F, context.getResources().getDisplayMetrics());
        r = (int)TypedValue.applyDimension(1, 2.0F, context.getResources().getDisplayMetrics());
        s = n + (float)q;
        B = new RectF(A);
    }

    static Rect a(ColorSplashForegroundView colorsplashforegroundview)
    {
        return colorsplashforegroundview.C;
    }

    static PickerState a(ColorSplashForegroundView colorsplashforegroundview, PickerState pickerstate)
    {
        colorsplashforegroundview.b = pickerstate;
        return pickerstate;
    }

    private void a(float f1, float f2)
    {
        RectF rectf1 = x.a.h;
        RectF rectf = rectf1;
        if (rectf1 == null)
        {
            rectf = new RectF(0.0F, 0.0F, getResources().getDisplayMetrics().widthPixels / 2, getResources().getDisplayMetrics().heightPixels / 2);
        }
        float f3;
        if (f1 < rectf.left + 2.0F)
        {
            f3 = rectf.left + 2.0F;
        } else
        {
            f3 = f1;
            if (f1 > rectf.right - 2.0F)
            {
                f3 = rectf.right - 2.0F;
            }
        }
        if (f2 < rectf.top + 2.0F)
        {
            f1 = rectf.top + 2.0F;
        } else
        {
            f1 = f2;
            if (f2 > rectf.bottom - 2.0F)
            {
                f1 = rectf.bottom - 2.0F;
            }
        }
        u.set(f3, f1);
    }

    static float b(ColorSplashForegroundView colorsplashforegroundview)
    {
        float f1 = colorsplashforegroundview.E / 2.0F;
        colorsplashforegroundview.E = f1;
        return f1;
    }

    static float c(ColorSplashForegroundView colorsplashforegroundview)
    {
        return colorsplashforegroundview.E;
    }

    private void c()
    {
        if (c == null || c.isRecycled())
        {
            return;
        }
        Path path = P;
        if (d != null && c != null && !c.isRecycled())
        {
            Object obj = x.a.h;
            path = new Path(path);
            Object obj1 = new Matrix();
            ((Matrix) (obj1)).setTranslate(-((RectF) (obj)).left, -((RectF) (obj)).top);
            path.transform(((Matrix) (obj1)));
            float f1 = (float)c.getWidth() / ((RectF) (obj)).width();
            ((Matrix) (obj1)).setScale(f1, f1);
            path.transform(((Matrix) (obj1)));
            e.add(new Path(path));
            obj1 = new Paint(V);
            ((Paint) (obj1)).setStrokeWidth(((float)T * (float)c.getWidth()) / ((RectF) (obj)).width());
            obj = null;
            if (j > 0.0F)
            {
                obj = new BlurMaskFilter((((Paint) (obj1)).getStrokeWidth() * j) / 100F, android.graphics.BlurMaskFilter.Blur.NORMAL);
            }
            ((Paint) (obj1)).setMaskFilter(((android.graphics.MaskFilter) (obj)));
            if (M)
            {
                ((Paint) (obj1)).setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
            }
            f.add(obj1);
            g.add(Float.valueOf(j));
            d.drawPath(path, ((Paint) (obj1)));
        }
        P.reset();
        Q.reset();
        O.set(0, 0, 0, 0);
        N.set(0.0F, 0.0F, 0.0F, 0.0F);
        H = false;
        invalidate();
        ((ColorSplashActivity)getContext()).b(true);
    }

    static PointF d(ColorSplashForegroundView colorsplashforegroundview)
    {
        return colorsplashforegroundview.u;
    }

    static Handler e(ColorSplashForegroundView colorsplashforegroundview)
    {
        return colorsplashforegroundview.I;
    }

    public final void a()
    {
        if (d != null && c != null && !c.isRecycled())
        {
            d.drawRect(new Rect(0, 0, c.getWidth(), c.getHeight()), i);
        }
        e = new ArrayList();
        f = new ArrayList();
        g = new ArrayList();
        invalidate();
    }

    public final void a(boolean flag)
    {
        if (aa || flag || b == PickerState.OPEN)
        {
            b = PickerState.OPEN;
            E = 1.0F;
            a(y / 2.0F, z / 2.0F);
            B.set(u.x - s - 1.0F, u.y - s - 1.0F, u.x + s + 1.0F, u.y + s + 1.0F);
            postInvalidate();
        }
        aa = false;
    }

    public final void b()
    {
        if (J != null && !J.isRecycled())
        {
            J.recycle();
        }
        J = null;
    }

    protected void onDraw(Canvas canvas)
    {
        if (W == null) goto _L2; else goto _L1
_L1:
        if (W.s != 0) goto _L4; else goto _L3
_L3:
        canvas.scale(E, E, u.x, u.y);
        Object obj = x;
        float f1 = u.x;
        float f2 = u.y;
        int i1 = (int)f1;
        int j1 = (int)f2;
        obj = ((MyGLSurfaceView) (obj)).a;
        float f3;
        float f4;
        float f5;
        if (((a) (obj)).p != null)
        {
            ByteBuffer bytebuffer = ((a) (obj)).p;
            int k1 = ((a) (obj)).j;
            i1 = ImageOpCommon.getPixel(bytebuffer, ((a) (obj)).i * (k1 - j1) + i1);
            i1 = Color.argb(Color.alpha(i1), Color.blue(i1), Color.green(i1), Color.red(i1));
        } else
        {
            i1 = 0xff000000;
        }
        a = i1;
        v.setStrokeWidth(q);
        v.setColor(t);
        canvas.drawCircle(u.x, u.y, n, v);
        v.setStrokeWidth(p);
        v.setColor(-1);
        canvas.drawCircle(u.x, u.y, n, v);
        v.setStrokeWidth(o);
        v.setColor(a);
        canvas.drawCircle(u.x, u.y, n, v);
        v.setStrokeWidth(r);
        v.setColor(t);
        f1 = u.x;
        f2 = n / 6F;
        f3 = u.y;
        f4 = u.x;
        canvas.drawLine(f1 - f2, f3, n / 6F + f4, u.y, v);
        f1 = u.x;
        f2 = u.y;
        f3 = n / 6F;
        f4 = u.x;
        f5 = u.y;
        canvas.drawLine(f1, f2 - f3, f4, n / 6F + f5, v);
_L2:
        return;
_L4:
        if (x == null || c == null || c.isRecycled() || J == null || J.isRecycled())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!m)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!l && x != null)
        {
            x.a();
            l = true;
            return;
        }
        if (true) goto _L2; else goto _L5
_L5:
        canvas.saveLayer(0.0F, 0.0F, canvas.getWidth(), canvas.getHeight(), w, 4);
        RectF rectf = x.a.h;
        if (rectf != null)
        {
            canvas.drawBitmap(J, null, rectf, L);
            canvas.drawPath(P, V);
            canvas.drawBitmap(c, null, rectf, K);
            return;
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        y = i1;
        z = j1;
        if (b == PickerState.OPEN)
        {
            a(false);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag2;
label0:
        {
            flag2 = false;
            if (x != null)
            {
                MyGLSurfaceView myglsurfaceview = x;
                boolean flag;
                if (myglsurfaceview.a != null && myglsurfaceview.a.u)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    break label0;
                }
            }
            return false;
        }
        if (x != null && myobfuscated.bc.b.a().a(motionevent, x.a.h, x.a.g, 5F, 1.0F))
        {
            if (W.s == 0)
            {
                x.a();
                l = false;
                m = false;
                return false;
            }
            if (H)
            {
                c();
            }
            int i1;
            if (l)
            {
                x.a();
            } else
            {
                m = true;
                invalidate();
            }
            i1 = motionevent.getAction() & 0xff;
            if ((i1 == 6 || i1 == 1) && motionevent.getPointerCount() <= 1)
            {
                l = false;
                m = false;
                x.a();
            }
            return false;
        }
        l = false;
        m = false;
        if (W == null) goto _L2; else goto _L1
_L1:
        if (W.s != 0) goto _L4; else goto _L3
_L3:
        PickerState pickerstate = PickerState.CLOSING;
        if (motionevent.getAction() == 1)
        {
            b = PickerState.CLOSING;
            A.set(u.x - s - 1.0F, u.y - s - 1.0F, u.x + s + 1.0F, u.y + s + 1.0F);
            D.set(A);
            D.union(B);
            B.set(A);
            D.roundOut(C);
            I.post(new Runnable() {

                private ColorSplashForegroundView a;

                public final void run()
                {
                    a.invalidate(ColorSplashForegroundView.a(a));
                    com.picsart.effects.colorsplash.ColorSplashForegroundView.b(a);
                    if (com.picsart.effects.colorsplash.ColorSplashForegroundView.c(a) > 0.01F) goto _L2; else goto _L1
_L1:
                    ColorSplashActivity colorsplashactivity;
                    int j1;
                    int k1;
                    int l1;
                    ColorSplashForegroundView.a(a, PickerState.CLOSED);
                    colorsplashactivity = (ColorSplashActivity)a.getContext();
                    k1 = a.a;
                    j1 = (int)ColorSplashForegroundView.d(a).x;
                    l1 = (int)ColorSplashForegroundView.d(a).y;
                    if (colorsplashactivity.c.s != 0) goto _L4; else goto _L3
_L3:
                    Object obj;
                    obj = colorsplashactivity.c;
                    if (((a) (obj)).p != null)
                    {
                        j1 = ImageOpCommon.getPixel(((a) (obj)).p, j1 + (((a) (obj)).j - l1) * ((a) (obj)).i);
                        if (((a) (obj)).s == 0 && ((a) (obj)).r != null && ((a) (obj)).r.b != null)
                        {
                            obj = ((a) (obj)).r.b;
                            float f6 = (float)ImageOpCommon.RGBTOHCL(Color.blue(j1), Color.green(j1), Color.red(j1));
                            ((com.picsart.effects.colorsplash.c) (obj)).h[((com.picsart.effects.colorsplash.c) (obj)).l] = f6;
                            obj.g = f6;
                            ((com.picsart.effects.colorsplash.c) (obj)).a.a((new StringBuilder("selectedHue")).append(((com.picsart.effects.colorsplash.c) (obj)).l + 1).toString(), Float.valueOf(((com.picsart.effects.colorsplash.c) (obj)).g));
                            ((com.picsart.effects.colorsplash.c) (obj)).b(30F);
                            ((com.picsart.effects.colorsplash.c) (obj)).c(30F);
                            ((SeekBar)((com.picsart.effects.colorsplash.c) (obj)).e.findViewById(0x7f1002cb)).setProgress(30);
                            ((SeekBar)((com.picsart.effects.colorsplash.c) (obj)).e.findViewById(0x7f1002ce)).setProgress(30);
                            if (((com.picsart.effects.colorsplash.c) (obj)).e != null)
                            {
                                ((com.picsart.effects.colorsplash.c) (obj)).a(f6);
                                ((Button)((com.picsart.effects.colorsplash.c) (obj)).e.findViewById(0x7f1002c4)).setText((new StringBuilder()).append(((com.picsart.effects.colorsplash.c) (obj)).m.a.getResources().getString(0x7f08007c)).append(((com.picsart.effects.colorsplash.c) (obj)).l + 1).toString());
                            }
                        }
                        Color.argb(Color.alpha(j1), Color.blue(j1), Color.green(j1), Color.red(j1));
                        j1 = 1;
                    } else
                    {
                        j1 = 0;
                    }
                    if (j1 == 0) goto _L4; else goto _L5
_L5:
                    if (colorsplashactivity.d == null || colorsplashactivity.d.b == null) goto _L7; else goto _L6
_L6:
                    colorsplashactivity.d.b.l;
                    JVM INSTR tableswitch 0 2: default 436
                //                               0 594
                //                               1 607
                //                               2 622;
                       goto _L7 _L8 _L9 _L10
_L7:
                    obj = Integer.valueOf(0x7f1002b5);
                    j1 = 0;
_L11:
                    colorsplashactivity.a(j1);
                    colorsplashactivity.findViewById(0x7f1002b4).setSelected(true);
                    ((ImageView)colorsplashactivity.findViewById(((Integer) (obj)).intValue())).setBackgroundColor(k1);
                    colorsplashactivity.c.s = 1;
                    colorsplashactivity.a.removeAllViews();
                    colorsplashactivity.a.addView(colorsplashactivity.d.b.e);
                    obj = (SlidingDrawer)colorsplashactivity.findViewById(0x7f10057c);
                    colorsplashactivity.findViewById(0x7f1001ab).setVisibility(0);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        colorsplashactivity.findViewById(0x7f1001ab).setBackgroundColor(0);
                    }
                    ((SlidingDrawer) (obj)).open();
                    colorsplashactivity.findViewById(0x7f1001a8).setEnabled(true);
                    colorsplashactivity.findViewById(0x7f1002bb).setEnabled(true);
                    colorsplashactivity.b.requestRender();
                    colorsplashactivity.a(true);
_L4:
                    return;
_L8:
                    obj = Integer.valueOf(0x7f1002b5);
                    j1 = 0x7f1002b4;
                    continue; /* Loop/switch isn't completed */
_L9:
                    obj = Integer.valueOf(0x7f1002b7);
                    j1 = 0x7f1002b6;
                    continue; /* Loop/switch isn't completed */
_L10:
                    obj = Integer.valueOf(0x7f1002b9);
                    j1 = 0x7f1002b8;
                    if (true) goto _L11; else goto _L2
_L2:
                    ColorSplashForegroundView.e(a).postDelayed(this, 50L);
                    return;
                }

            
            {
                a = ColorSplashForegroundView.this;
                super();
            }
            });
        } else
        if (motionevent.getAction() == 2)
        {
            a(motionevent.getX(), motionevent.getY());
        }
        A.set(u.x - s - 1.0F, u.y - s - 1.0F, u.x + s + 1.0F, u.y + s + 1.0F);
        D.set(A);
        D.union(B);
        B.set(A);
        D.roundOut(C);
        invalidate(C);
_L2:
        return true;
_L4:
        float f1 = motionevent.getX();
        float f2 = motionevent.getY();
        switch (motionevent.getAction())
        {
        case 0: // '\0'
            P.reset();
            P.moveTo(f1, f2);
            Q.moveTo(f1, f2);
            R = f1;
            S = f2;
            H = true;
            break;

        case 2: // '\002'
            float f3 = Math.abs(f1 - R);
            float f5 = Math.abs(f2 - S);
            boolean flag1 = flag2;
            if (Math.abs(Math.sqrt(f3 * f3 + f5 * f5)) >= 4D)
            {
                Q.quadTo(R, S, (R + f1) / 2.0F, (S + f2) / 2.0F);
                Q.computeBounds(N, true);
                float f4 = ((float)T * (j / 100F + 1.0F)) / 2.0F + 1.0F;
                motionevent = N;
                motionevent.left = ((RectF) (motionevent)).left - f4;
                motionevent = N;
                motionevent.top = ((RectF) (motionevent)).top - f4;
                motionevent = N;
                motionevent.right = ((RectF) (motionevent)).right + f4;
                motionevent = N;
                motionevent.bottom = f4 + ((RectF) (motionevent)).bottom;
                O.set((int)N.left, (int)N.top, (int)N.right, (int)N.bottom);
                P.quadTo(R, S, (R + f1) / 2.0F, (S + f2) / 2.0F);
                Q.reset();
                Q.moveTo((R + f1) / 2.0F, (S + f2) / 2.0F);
                R = f1;
                S = f2;
                flag1 = true;
            }
            if (flag1)
            {
                invalidate(O);
            }
            break;

        case 1: // '\001'
        case 3: // '\003'
            c();
            break;
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void setBrushSizeIndex(int i1)
    {
        h = i1;
        T = U[h];
        V.setStrokeWidth(T);
    }

    public void setBuffers(ByteBuffer bytebuffer, ByteBuffer bytebuffer1)
    {
        F = bytebuffer;
        G = bytebuffer1;
    }

    public void setDrawMode(boolean flag)
    {
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        M = flag;
        if (M)
        {
            V.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
            return;
        } else
        {
            V.setXfermode(null);
            return;
        }
    }

    public void setGlSurfaceView(MyGLSurfaceView myglsurfaceview)
    {
        x = myglsurfaceview;
    }

    public void setHardness(float f1)
    {
        BlurMaskFilter blurmaskfilter = null;
        f1 = 100F - f1;
        if (f1 > 0.0F)
        {
            blurmaskfilter = new BlurMaskFilter((V.getStrokeWidth() * f1) / 100F, android.graphics.BlurMaskFilter.Blur.NORMAL);
        }
        V.setMaskFilter(blurmaskfilter);
        j = f1;
    }

    public void setOrigBitmap(Bitmap bitmap, ByteBuffer bytebuffer, ByteBuffer bytebuffer1)
    {
        c = bitmap;
        T = U[h];
        K = new Paint();
        K.setFilterBitmap(true);
        K.setDither(true);
        K.setAntiAlias(true);
        K.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_ATOP));
        L = new Paint();
        L.setFilterBitmap(true);
        L.setDither(true);
        L.setAntiAlias(true);
        V = new Paint();
        V.setAntiAlias(true);
        V.setDither(true);
        V.setFilterBitmap(true);
        V.setStyle(android.graphics.Paint.Style.STROKE);
        V.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        V.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        V.setStrokeWidth(T);
        V.setColor(0xff000000);
        V.setAlpha(k);
        V.setMaskFilter(new BlurMaskFilter((V.getStrokeWidth() * j) / 100F, android.graphics.BlurMaskFilter.Blur.NORMAL));
        i = new Paint();
        i.setAntiAlias(true);
        i.setDither(true);
        i.setFilterBitmap(true);
        i.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
        F = bytebuffer;
        G = bytebuffer1;
        J = com.socialin.android.util.c.a(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        d = new Canvas(J);
        d.drawRect(new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), i);
        invalidate();
    }

    public void setOrigBitmapAndCanvas(Bitmap bitmap, Canvas canvas)
    {
        c = bitmap;
        d = canvas;
    }

    public void setRenderer(a a1)
    {
        W = a1;
    }

    public void setSplashMode(int i1)
    {
        i1;
        JVM INSTR tableswitch 0 1: default 24
    //                   0 25
    //                   1 74;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        if (F != null && c != null && !c.isRecycled())
        {
            F.position(0);
            c.copyPixelsFromBuffer(F);
            invalidate();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (G != null && c != null && !c.isRecycled())
        {
            G.position(0);
            c.copyPixelsFromBuffer(G);
            invalidate();
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }


    private class PickerState extends Enum
    {

        private static final PickerState $VALUES[];
        public static final PickerState CLOSED;
        public static final PickerState CLOSING;
        public static final PickerState OPEN;

        public static PickerState valueOf(String s1)
        {
            return (PickerState)Enum.valueOf(com/picsart/effects/colorsplash/ColorSplashForegroundView$PickerState, s1);
        }

        public static PickerState[] values()
        {
            return (PickerState[])$VALUES.clone();
        }

        static 
        {
            OPEN = new PickerState("OPEN", 0);
            CLOSED = new PickerState("CLOSED", 1);
            CLOSING = new PickerState("CLOSING", 2);
            $VALUES = (new PickerState[] {
                OPEN, CLOSED, CLOSING
            });
        }

        private PickerState(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
