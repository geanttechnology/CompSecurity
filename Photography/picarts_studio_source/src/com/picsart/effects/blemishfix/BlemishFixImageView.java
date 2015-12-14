// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.blemishfix;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.socialin.android.apiv3.util.Inventory;
import com.socialin.android.photo.imgop.ImageOp;
import com.socialin.android.util.Utils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import myobfuscated.bc.a;
import myobfuscated.bc.b;
import myobfuscated.bc.c;

// Referenced classes of package com.picsart.effects.blemishfix:
//            BlemishFixActivity, a

public class BlemishFixImageView extends View
{

    Bitmap a;
    ByteBuffer b;
    ByteBuffer c;
    c d;
    int e;
    int f;
    Activity g;
    ArrayList h;
    boolean i;
    boolean j;
    private Context k;
    private int l;
    private int m;
    private int n;
    private RectF o;
    private RectF p;
    private RectF q;
    private Paint r;
    private boolean s;
    private boolean t;
    private boolean u;
    private Matrix v;
    private Paint w;

    public BlemishFixImageView(Context context)
    {
        super(context);
        l = 0;
        m = 0;
        n = 0;
        o = new RectF();
        p = new RectF();
        q = new RectF();
        r = new Paint();
        a = null;
        b = null;
        c = null;
        d = null;
        e = 70;
        f = 1;
        g = null;
        i = false;
        s = false;
        t = false;
        u = false;
        j = false;
        v = new Matrix();
        a(context);
    }

    public BlemishFixImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        l = 0;
        m = 0;
        n = 0;
        o = new RectF();
        p = new RectF();
        q = new RectF();
        r = new Paint();
        a = null;
        b = null;
        c = null;
        d = null;
        e = 70;
        f = 1;
        g = null;
        i = false;
        s = false;
        t = false;
        u = false;
        j = false;
        v = new Matrix();
        a(context);
    }

    private void a(Context context)
    {
        super.setClickable(true);
        k = context;
        if (getContext().getResources().getConfiguration().orientation == 1)
        {
            l = (int)TypedValue.applyDimension(1, 50F, getResources().getDisplayMetrics());
        }
        r.setColor(0xff000000);
        h = new ArrayList();
        w = new Paint();
        w.setFilterBitmap(true);
    }

    static void a(BlemishFixImageView blemishfiximageview, Point point, int i1, int j1, int k1)
    {
        blemishfiximageview.a(point, i1, j1, k1);
    }

    static boolean a(BlemishFixImageView blemishfiximageview)
    {
        return blemishfiximageview.u;
    }

    static c b(BlemishFixImageView blemishfiximageview)
    {
        return blemishfiximageview.d;
    }

    static Activity c(BlemishFixImageView blemishfiximageview)
    {
        return blemishfiximageview.g;
    }

    static int d(BlemishFixImageView blemishfiximageview)
    {
        return blemishfiximageview.e;
    }

    static int e(BlemishFixImageView blemishfiximageview)
    {
        return blemishfiximageview.f;
    }

    static boolean f(BlemishFixImageView blemishfiximageview)
    {
        blemishfiximageview.i = false;
        return false;
    }

    final void a(Point point, int i1, int j1, int k1)
    {
        ByteBuffer bytebuffer;
label0:
        {
            if (!g.isFinishing())
            {
                c.position(0);
                bytebuffer = ImageOp.a(c.capacity());
                bytebuffer.position(0);
                ImageOp.blemishfix4buf(c, bytebuffer, a.getWidth(), a.getHeight(), a.getWidth(), a.getHeight(), point.x, point.y, i1, j1, k1, false, -1);
                if (g.isFinishing())
                {
                    break label0;
                }
                ImageOp.a(c);
                c = bytebuffer;
                c.position(0);
                a.copyPixelsFromBuffer(c);
                c.position(0);
            }
            return;
        }
        ImageOp.a(bytebuffer);
    }

    protected void onDraw(Canvas canvas)
    {
        if (a != null && !a.isRecycled())
        {
            if (o != null && s)
            {
                v.setRectToRect(q, o, android.graphics.Matrix.ScaleToFit.START);
                s = false;
            }
            canvas.drawBitmap(a, null, o, w);
            if (d != null)
            {
                if (t)
                {
                    d.a();
                    t = false;
                }
                c c1 = d;
                if (c1.n)
                {
                    if (c1.b)
                    {
                        canvas.drawCircle(c1.k, c1.l, c1.d, c1.g);
                    }
                    if (c1.m && c1.h != null && !c1.h.isRecycled())
                    {
                        canvas.drawRect(c1.j, c1.f);
                        canvas.drawBitmap(c1.h, c1.i, c1.j, c1.e);
                        canvas.drawCircle(c1.j.left + c1.j.width() / 2.0F, c1.j.top + c1.j.height() / 2.0F, (c1.c * c1.j.width()) / (float)c1.i.width(), c1.g);
                        return;
                    }
                }
            }
        }
    }

    protected void onMeasure(int i1, int j1)
    {
        s = true;
        super.onMeasure(i1, j1);
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        float f1 = 0.0F;
        if (Inventory.isAdsEnabled())
        {
            f1 = (int)TypedValue.applyDimension(1, 50F, getResources().getDisplayMetrics());
        }
        int l2 = (int)((float)j1 - f1);
        f1 = Math.min((float)i1 / (float)m, (float)l2 / (float)n);
        int i2 = Math.round((float)m * f1);
        int j2 = Math.round(f1 * (float)n);
        int k2 = (i1 - i2) / 2;
        l2 = (l2 - j2) / 2;
        o.set(k2, l2, i2 + k2, l2 + j2);
        p.set(o);
        if (d != null)
        {
            d.a = i1;
            t = true;
        }
        super.onSizeChanged(i1, j1, k1, l1);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (myobfuscated.bc.a.a().a && myobfuscated.bc.b.a().a(motionevent, o, p, 8F, 0.7F))
        {
            v.setRectToRect(q, o, android.graphics.Matrix.ScaleToFit.START);
            if (d != null)
            {
                d.m = false;
                d.a();
            }
            invalidate();
            u = true;
            return false;
        }
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 116
    //                   0 118
    //                   1 197
    //                   2 163;
           goto _L1 _L2 _L3 _L4
_L1:
        return true;
_L2:
        float f1 = motionevent.getX();
        float f2 = motionevent.getY();
        if (d != null)
        {
            u = false;
            (new Thread(new Runnable(f1, f2) {

                final float a;
                final float b;
                final BlemishFixImageView c;

                public final void run()
                {
                    try
                    {
                        Thread.sleep(300L);
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        interruptedexception.printStackTrace();
                    }
                    com.picsart.effects.blemishfix.BlemishFixImageView.c(c).runOnUiThread(new Runnable(this) {

                        private _cls1 a;

                        public final void run()
                        {
                            if (!com.picsart.effects.blemishfix.BlemishFixImageView.a(a.c))
                            {
                                com.picsart.effects.blemishfix.BlemishFixImageView.b(a.c).a(a.a, a.b);
                                a.c.invalidate();
                            }
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                }

            
            {
                c = BlemishFixImageView.this;
                a = f1;
                b = f2;
                super();
            }
            })).start();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        u = true;
        if (d != null)
        {
            d.a(motionevent.getX(), motionevent.getY());
            invalidate();
        }
        if (true) goto _L1; else goto _L3
_L3:
        u = true;
        if (d != null)
        {
            if (!i)
            {
                i = true;
                d.m = false;
                motionevent = d;
                int i1 = ((c) (motionevent)).i.left;
                int j1 = ((c) (motionevent)).i.width() / 2;
                int k1 = ((c) (motionevent)).i.top;
                (new Thread(new Runnable(new Point(new Point(i1 + j1, ((c) (motionevent)).i.height() / 2 + k1))) {

                    final BlemishFixImageView a;
                    private Point b;

                    public final void run()
                    {
                        com.picsart.effects.blemishfix.BlemishFixImageView.a(a, b, (int)com.picsart.effects.blemishfix.BlemishFixImageView.b(a).c, BlemishFixImageView.d(a), BlemishFixImageView.e(a));
                        com.picsart.effects.blemishfix.a a1 = new com.picsart.effects.blemishfix.a(b, (int)com.picsart.effects.blemishfix.BlemishFixImageView.b(a).c, BlemishFixImageView.d(a), BlemishFixImageView.e(a));
                        com.picsart.effects.blemishfix.BlemishFixImageView.c(a).runOnUiThread(new Runnable(this, a1) {

                            private com.picsart.effects.blemishfix.a a;
                            private _cls2 b;

                            public final void run()
                            {
                                ((BlemishFixActivity)com.picsart.effects.blemishfix.BlemishFixImageView.c(b.a)).b();
                                b.a.h.add(a);
                                ((BlemishFixActivity)com.picsart.effects.blemishfix.BlemishFixImageView.c(b.a)).a(true);
                                b.a.invalidate();
                                BlemishFixImageView.f(b.a);
                            }

            
            {
                b = _pcls2;
                a = a1;
                super();
            }
                        });
                    }

            
            {
                a = BlemishFixImageView.this;
                b = point;
                super();
            }
                })).start();
                ((BlemishFixActivity)g).a();
            } else
            {
                d.m = false;
                invalidate();
                Utils.b(g, 0x7f080405);
            }
        }
        return false;
    }

    public void setBlemishFixAmount(int i1)
    {
        e = i1;
    }

    public void setBlemishfixMethod(int i1)
    {
        f = i1;
    }

    public void setImageFitCenter(Bitmap bitmap, Activity activity)
    {
        g = activity;
        a = bitmap;
        int i1 = (int)Utils.a(50F, k);
        d = new c(getContext(), v, i1);
        d.h = a;
        m = bitmap.getWidth();
        n = bitmap.getHeight();
        if (b != null)
        {
            ImageOp.a(b);
            b = null;
        }
        if (c != null)
        {
            ImageOp.a(c);
            c = null;
        }
        b = ImageOp.a(m * n * 4);
        b.position(0);
        bitmap.copyPixelsToBuffer(b);
        c = ImageOp.a(m * n * 4);
        c.position(0);
        bitmap.copyPixelsToBuffer(c);
        float f2 = getWidth();
        float f1 = f2;
        if (f2 == 0.0F)
        {
            f1 = (float)getContext().getResources().getDisplayMetrics().widthPixels - 0.0F;
        }
        float f3 = getHeight();
        f2 = f3;
        if (f3 == 0.0F)
        {
            f2 = (float)getContext().getResources().getDisplayMetrics().heightPixels - (float)l;
        }
        d.a = f1;
        f3 = Math.min(f1 / (float)m, f2 / (float)n);
        i1 = Math.round((float)m * f3);
        int j1 = Math.round(f3 * (float)n);
        int k1 = (int)((f1 - (float)i1) / 2.0F);
        int l1 = (int)((f2 - (float)j1) / 2.0F);
        o.set(k1, l1, k1 + i1, l1 + j1);
        p.set(o);
        q.set(0.0F, 0.0F, m, n);
        v.setRectToRect(q, o, android.graphics.Matrix.ScaleToFit.START);
        invalidate();
    }

    public void setProcessRuning(boolean flag)
    {
        i = flag;
    }

    public void setSaving(boolean flag)
    {
        j = flag;
    }
}
