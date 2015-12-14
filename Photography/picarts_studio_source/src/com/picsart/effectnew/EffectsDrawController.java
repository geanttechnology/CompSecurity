// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effectnew;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.util.Log;
import android.view.View;
import com.socialin.android.photo.imgop.ImageOp;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.c;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import myobfuscated.ay.e;
import myobfuscated.bb.bp;

// Referenced classes of package com.picsart.effectnew:
//            j, t, EffectsDrawHistoryController, MaskBrushNew, 
//            h, o, EffectShapeDrawerNew, i, 
//            s, p, q, r

public final class EffectsDrawController
    implements j, t
{

    public RectF a;
    public RectF b;
    public View c;
    Bitmap d;
    Bitmap e;
    public Bitmap f;
    public Canvas g;
    int h;
    int i;
    Paint j;
    public MaskBrushNew k;
    public h l;
    public EffectsDrawMode m;
    public EffectsDrawHistoryController n;
    public boolean o;
    public boolean p;
    public o q;
    private Rect r;
    private boolean s;
    private boolean t;
    private boolean u;
    private Bitmap v;

    public EffectsDrawController(Context context, Bitmap bitmap, Bitmap bitmap1)
    {
        this(context, bitmap, bitmap1, (byte)0);
    }

    public EffectsDrawController(Context context, Bitmap bitmap, Bitmap bitmap1, byte byte0)
    {
        r = new Rect();
        j = new Paint(2);
        m = EffectsDrawMode.BRUSH;
        n = new EffectsDrawHistoryController();
        o = false;
        p = false;
        s = true;
        t = true;
        u = false;
        v = null;
        d = bitmap;
        e = bitmap1;
        h = bitmap.getWidth();
        i = bitmap.getHeight();
        r.set(0, 0, h, i);
        f = com.socialin.android.util.c.a(h, i, android.graphics.Bitmap.Config.ARGB_8888);
        if (f != null)
        {
            g = new Canvas(f);
            g.drawBitmap(bitmap1, 0.0F, 0.0F, j);
        }
        k = new MaskBrushNew(context);
        k.u = this;
        l = new h(context);
        l.d = this;
        u = false;
    }

    static void a(EffectsDrawController effectsdrawcontroller, boolean flag)
    {
        effectsdrawcontroller.o = flag;
        if (effectsdrawcontroller.q != null)
        {
            effectsdrawcontroller.q.a(flag);
        }
    }

    private boolean s()
    {
        if (o)
        {
            t();
            return false;
        } else
        {
            return true;
        }
    }

    private void t()
    {
        if (!s) goto _L2; else goto _L1
_L1:
        if (m != EffectsDrawMode.BRUSH) goto _L4; else goto _L3
_L3:
        if (!k.l.isEmpty())
        {
            MaskBrushNew maskbrushnew = k;
            if (!maskbrushnew.k.isEmpty())
            {
                Path path = maskbrushnew.k;
                Canvas canvas = maskbrushnew.u.d();
                Bitmap bitmap = maskbrushnew.u.a();
                Bitmap bitmap1 = maskbrushnew.u.b();
                canvas.drawPath(path, maskbrushnew.h);
                maskbrushnew.i.setAlpha(maskbrushnew.b);
                canvas.drawBitmap(bitmap, 0.0F, 0.0F, maskbrushnew.i);
                if (maskbrushnew.b < 255)
                {
                    maskbrushnew.i.setAlpha(255);
                    canvas.drawBitmap(bitmap1, 0.0F, 0.0F, maskbrushnew.i);
                }
                maskbrushnew.u.a(new Path(maskbrushnew.k), maskbrushnew.h.getStrokeWidth(), maskbrushnew.b, maskbrushnew.e);
            }
            maskbrushnew.k.reset();
            maskbrushnew.l.reset();
            maskbrushnew.m.reset();
            maskbrushnew.r.set(0, 0, 0, 0);
            maskbrushnew.q.set(0.0F, 0.0F, 0.0F, 0.0F);
        }
_L2:
        s = false;
        return;
_L4:
        EffectShapeDrawerNew effectshapedrawernew = l.e;
        if (effectshapedrawernew.n != null)
        {
            effectshapedrawernew.c.a = -1;
            effectshapedrawernew.f = false;
            effectshapedrawernew.g = false;
            RectF rectf = effectshapedrawernew.n.a();
            float f1 = effectshapedrawernew.n.b();
            if (effectshapedrawernew.c != null && rectf != null)
            {
                effectshapedrawernew.c.a(f1, rectf);
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public final Bitmap a()
    {
        return d;
    }

    public final void a(float f1)
    {
        MaskBrushNew maskbrushnew = k;
        if (maskbrushnew.p == 0.0F)
        {
            maskbrushnew.p = f1;
        }
        maskbrushnew.a(maskbrushnew.a);
    }

    public final void a(float f1, float f2)
    {
        if (t && m == EffectsDrawMode.SHAPE)
        {
            l.e.a(f1, f2);
            if (c != null)
            {
                c.invalidate();
                return;
            }
        }
    }

    public final void a(Activity activity, ThreadPoolExecutor threadpoolexecutor)
    {
        a(activity, threadpoolexecutor, null, EffectsDrawHistoryController.HistoryTaskAction.HistoryTaskActionRemoveLastItem);
    }

    public final void a(Activity activity, ThreadPoolExecutor threadpoolexecutor, Object obj, EffectsDrawHistoryController.HistoryTaskAction historytaskaction)
    {
        activity = new r(null, activity) {

            final EffectsDrawController a;
            private Object e;
            private Activity f;

            public final void run()
            {
                Object obj4;
                Object obj5;
                Bitmap bitmap;
                obj4 = null;
                obj5 = null;
                bitmap = super.b;
                if (!super.c) goto _L2; else goto _L1
_L1:
                if (e == null) goto _L4; else goto _L3
_L3:
                Object obj1;
                RenderScript renderscript;
                renderscript = (RenderScript)e;
                obj1 = new bp(renderscript);
                Object obj2 = Allocation.createFromBitmap(renderscript, a.d);
                Object obj3 = Allocation.createTyped(renderscript, ((Allocation) (obj2)).getType());
                ((Allocation) (obj3)).copyFrom(a.e);
                obj5 = Allocation.createFromBitmap(renderscript, bitmap);
                obj4 = obj5;
                ((bp) (obj1)).a(((Allocation) (obj3)), ((Allocation) (obj2)), ((Allocation) (obj4)));
                ((bp) (obj1)).a(((Allocation) (obj3)));
                ((bp) (obj1)).destroy();
                if (obj2 != null)
                {
                    ((Allocation) (obj2)).destroy();
                }
                OutOfMemoryError outofmemoryerror;
                Object obj6;
                boolean flag;
                if (obj4 != null)
                {
                    ((Allocation) (obj4)).destroy();
                    flag = true;
                } else
                {
                    flag = true;
                }
                if (!flag) goto _L4; else goto _L5
_L5:
                if (!super.d) goto _L7; else goto _L6
_L6:
                ((Allocation) (obj3)).copyTo(a.f);
                ((Allocation) (obj3)).destroy();
                if (a.c != null)
                {
                    a.c.invalidate();
                }
                EffectsDrawController.a(a, false);
_L2:
                return;
                obj1;
                obj1 = null;
                obj3 = null;
                obj4 = null;
                obj2 = obj5;
_L10:
                if (obj4 != null)
                {
                    ((bp) (obj4)).destroy();
                }
                if (obj3 != null)
                {
                    ((Allocation) (obj3)).destroy();
                }
                if (obj1 != null)
                {
                    ((Allocation) (obj1)).destroy();
                    flag = false;
                    obj3 = obj2;
                } else
                {
                    flag = false;
                    obj3 = obj2;
                }
                break MISSING_BLOCK_LABEL_130;
                obj3;
                obj2 = null;
                obj1 = null;
_L9:
                if (obj1 != null)
                {
                    ((bp) (obj1)).destroy();
                }
                if (obj2 != null)
                {
                    ((Allocation) (obj2)).destroy();
                }
                if (obj4 != null)
                {
                    ((Allocation) (obj4)).destroy();
                }
                throw obj3;
_L7:
                f.runOnUiThread(new Runnable(this, ((Allocation) (obj3))) {

                    private Allocation a;
                    private _cls4 b;

                    public final void run()
                    {
                        a.copyTo(b.a.f);
                        a.destroy();
                        if (b.a.c != null)
                        {
                            b.a.c.invalidate();
                        }
                        EffectsDrawController.a(b.a, false);
                    }

            
            {
                b = _pcls4;
                a = allocation;
                super();
            }
                });
                return;
_L4:
                obj1 = myobfuscated.ay.e.a(a.h * a.i * 4);
                ((ByteBuffer) (obj1)).position(0);
                a.d.copyPixelsToBuffer(((java.nio.Buffer) (obj1)));
                obj2 = myobfuscated.ay.e.a(a.h * a.i * 4);
                ((ByteBuffer) (obj2)).position();
                bitmap.copyPixelsToBuffer(((java.nio.Buffer) (obj2)));
                obj3 = myobfuscated.ay.e.a(a.h * a.i * 4);
                ((ByteBuffer) (obj3)).position(0);
                a.e.copyPixelsToBuffer(((java.nio.Buffer) (obj3)));
                ImageOp.blend4buf(((java.nio.Buffer) (obj1)), ((java.nio.Buffer) (obj3)), ((java.nio.Buffer) (obj2)), 0, a.h, a.i, ((java.nio.Buffer) (obj3)), a.h, a.i);
                myobfuscated.ay.e.a(((ByteBuffer) (obj1)));
                myobfuscated.ay.e.a(((ByteBuffer) (obj2)));
                if (super.d)
                {
                    ((ByteBuffer) (obj3)).position(0);
                    a.f.copyPixelsFromBuffer(((java.nio.Buffer) (obj3)));
                    myobfuscated.ay.e.a(((ByteBuffer) (obj3)));
                    if (a.c != null)
                    {
                        a.c.invalidate();
                    }
                    EffectsDrawController.a(a, false);
                    return;
                } else
                {
                    f.runOnUiThread(new Runnable(this, ((ByteBuffer) (obj3))) {

                        private ByteBuffer a;
                        private _cls4 b;

                        public final void run()
                        {
                            a.position(0);
                            b.a.f.copyPixelsFromBuffer(a);
                            myobfuscated.ay.e.a(a);
                            if (b.a.c != null)
                            {
                                b.a.c.invalidate();
                            }
                            EffectsDrawController.a(b.a, false);
                        }

            
            {
                b = _pcls4;
                a = bytebuffer;
                super();
            }
                    });
                    return;
                }
                obj3;
                obj2 = null;
                continue; /* Loop/switch isn't completed */
                obj3;
                continue; /* Loop/switch isn't completed */
                obj3;
                if (true) goto _L9; else goto _L8
_L8:
                obj2;
                obj2 = null;
                obj3 = null;
                obj4 = obj1;
                obj1 = obj2;
                obj2 = obj5;
                  goto _L10
                obj3;
                obj6 = null;
                obj3 = obj2;
                obj4 = obj1;
                obj1 = obj6;
                obj2 = obj5;
                  goto _L10
                obj4;
                obj6 = null;
                obj4 = obj2;
                obj5 = obj1;
                obj1 = obj6;
                obj2 = obj3;
                obj3 = obj4;
                obj4 = obj5;
                  goto _L10
                outofmemoryerror;
                outofmemoryerror = ((OutOfMemoryError) (obj2));
                obj6 = obj1;
                obj1 = obj4;
                obj2 = obj3;
                obj3 = outofmemoryerror;
                obj4 = obj6;
                  goto _L10
            }

            
            {
                a = EffectsDrawController.this;
                e = obj;
                f = activity;
                super();
            }
        };
        t();
        obj = new Runnable() {

            private EffectsDrawController a;

            public final void run()
            {
                EffectsDrawController.a(a, true);
            }

            
            {
                a = EffectsDrawController.this;
                super();
            }
        };
        activity = new s(n, null, h, i, activity, ((Runnable) (obj)), false);
        activity.a = historytaskaction;
        activity.executeOnExecutor(threadpoolexecutor, new Void[] {
            null
        });
    }

    public final void a(Canvas canvas, Rect rect)
    {
        if (m != EffectsDrawMode.BRUSH) goto _L2; else goto _L1
_L1:
        MaskBrushNew maskbrushnew;
        Bitmap bitmap;
        Bitmap bitmap1;
        Bitmap bitmap2;
        RectF rectf1;
        maskbrushnew = k;
        bitmap = maskbrushnew.u.c();
        bitmap1 = maskbrushnew.u.a();
        bitmap2 = maskbrushnew.u.b();
        rectf1 = maskbrushnew.u.e();
        if (maskbrushnew.l.isEmpty()) goto _L4; else goto _L3
_L3:
        canvas.saveLayer(0.0F, 0.0F, canvas.getWidth(), canvas.getHeight(), maskbrushnew.j, 4);
        canvas.drawBitmap(bitmap, rect, rectf1, maskbrushnew.g);
        canvas.drawPath(maskbrushnew.l, maskbrushnew.f);
        maskbrushnew.i.setAlpha(maskbrushnew.b);
        canvas.drawBitmap(bitmap1, rect, rectf1, maskbrushnew.i);
        if (maskbrushnew.b < 255)
        {
            maskbrushnew.i.setAlpha(255);
            canvas.drawBitmap(bitmap2, rect, rectf1, maskbrushnew.i);
        }
        canvas.restore();
_L6:
        return;
_L4:
        if (rect == null)
        {
            Log.e("ex1", "srcRect == null");
        }
        if (rectf1 == null)
        {
            Log.e("ex1", "drawRect == null");
        }
        canvas.drawBitmap(bitmap, rect, rectf1, maskbrushnew.g);
        return;
_L2:
        h h1 = l;
        rect = j;
        if (h1.d != null)
        {
            RectF rectf = h1.d.e();
            Rect rect1 = h1.d.g();
            Object obj = h1.d.c();
            Bitmap bitmap3 = h1.d.a();
            Bitmap bitmap4 = h1.d.b();
            if (obj != null && !((Bitmap) (obj)).isRecycled() && bitmap4 != null && !bitmap4.isRecycled() && bitmap3 != null && !bitmap3.isRecycled())
            {
                canvas.drawBitmap(((Bitmap) (obj)), rect1, rectf, rect);
                obj = h1.e.c;
                rect = null;
                if ((float)h1.a > 0.0F)
                {
                    rect = new BlurMaskFilter((((i) (obj)).c * (float)h1.a) / 100F, android.graphics.BlurMaskFilter.Blur.NORMAL);
                }
                h1.b.setMaskFilter(rect);
                float f1 = ((i) (obj)).c - (((i) (obj)).c * (float)h1.a) / 100F;
                canvas.save();
                float f5 = rectf.left;
                float f3 = rectf.top;
                canvas.translate(f5, f3);
                canvas.scale(((i) (obj)).e, ((i) (obj)).f);
                f5 = (((i) (obj)).b.x - f5) / ((i) (obj)).e;
                f3 = (((i) (obj)).b.y - f3) / ((i) (obj)).f;
                int i1;
                if (h1.e.m == EffectShapeDrawerNew.ShapeType.Focal)
                {
                    canvas.drawCircle(f5, f3, f1, h1.b);
                } else
                {
                    canvas.drawRect(f5 - f1, f3 - f1, f5 + f1, f3 + f1, h1.b);
                }
                canvas.restore();
                i1 = h1.d.i();
                h1.c.setAlpha(i1);
                canvas.drawBitmap(bitmap3, rect1, rectf, h1.c);
                if (i1 < 255)
                {
                    h1.c.setAlpha(255);
                    canvas.drawBitmap(bitmap4, rect1, rectf, h1.c);
                }
                rect = h1.e;
                if (((EffectShapeDrawerNew) (rect)).l)
                {
                    rect = ((EffectShapeDrawerNew) (rect)).c;
                    ((i) (rect)).i.d.setStrokeWidth(2.0F / (float)Math.sqrt(Math.pow(((i) (rect)).e, 2D) + Math.pow(((i) (rect)).f, 2D)));
                    ((i) (rect)).i.d.setColor(-1);
                    canvas.save();
                    canvas.scale(((i) (rect)).e, ((i) (rect)).f);
                    if (((i) (rect)).i.m == EffectShapeDrawerNew.ShapeType.Focal)
                    {
                        canvas.drawCircle(((i) (rect)).b.x / ((i) (rect)).e, ((i) (rect)).b.y / ((i) (rect)).f, ((i) (rect)).c, ((i) (rect)).i.d);
                    } else
                    {
                        float f2 = ((i) (rect)).b.x / ((i) (rect)).e;
                        float f4 = ((i) (rect)).c;
                        float f6 = ((i) (rect)).b.y / ((i) (rect)).f;
                        float f7 = ((i) (rect)).c;
                        float f8 = ((i) (rect)).b.x / ((i) (rect)).e;
                        float f9 = ((i) (rect)).c;
                        float f10 = ((i) (rect)).b.y / ((i) (rect)).f;
                        canvas.drawRect(f2 - f4, f6 - f7, f9 + f8, ((i) (rect)).c + f10, ((i) (rect)).i.d);
                    }
                    canvas.restore();
                    canvas.drawBitmap(((i) (rect)).i.j, ((i) (rect)).d.x - (float)(((i) (rect)).i.j.getWidth() / 2), ((i) (rect)).d.y - (float)(((i) (rect)).i.j.getHeight() / 2), ((i) (rect)).i.e);
                    canvas.drawBitmap(((i) (rect)).i.k, ((i) (rect)).b.x - ((i) (rect)).i.b - ((i) (rect)).c * ((i) (rect)).e, ((i) (rect)).b.y - ((i) (rect)).i.b, ((i) (rect)).i.e);
                    canvas.drawBitmap(((i) (rect)).i.k, (((i) (rect)).b.x - ((i) (rect)).i.b) + ((i) (rect)).c * ((i) (rect)).e, ((i) (rect)).b.y - ((i) (rect)).i.b, ((i) (rect)).i.e);
                    canvas.drawBitmap(((i) (rect)).i.k, ((i) (rect)).b.x - ((i) (rect)).i.b, ((i) (rect)).b.y - ((i) (rect)).i.b - ((i) (rect)).c * ((i) (rect)).f, ((i) (rect)).i.e);
                    canvas.drawBitmap(((i) (rect)).i.k, ((i) (rect)).b.x - ((i) (rect)).i.b, (((i) (rect)).b.y - ((i) (rect)).i.b) + ((i) (rect)).c * ((i) (rect)).f, ((i) (rect)).i.e);
                    return;
                }
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void a(Path path, float f1, int i1, float f2)
    {
        EffectsDrawHistoryController effectsdrawhistorycontroller = n;
        p p1 = new p();
        p1.b = path;
        p1.c = f1;
        p1.e = 255 - i1;
        p1.d = f2;
        p1.a = EffectsDrawHistoryController.EffectDrawType.DRAW_PATH;
        effectsdrawhistorycontroller.a.add(p1);
        if (effectsdrawhistorycontroller.b != null)
        {
            effectsdrawhistorycontroller.b.a(effectsdrawhistorycontroller, false);
        }
    }

    public final void a(EffectsDrawMode effectsdrawmode, boolean flag)
    {
        boolean flag1;
        if (effectsdrawmode != m)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag1) goto _L2; else goto _L1
_L1:
        if (effectsdrawmode != EffectsDrawMode.SHAPE) goto _L4; else goto _L3
_L3:
        l.c();
_L2:
        m = effectsdrawmode;
        return;
_L4:
        if (flag)
        {
            h h1 = l;
            if (h1.d != null)
            {
                p p1 = h1.a(h1.d.d());
                h1.d.a(p1);
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public final void a(p p1)
    {
        EffectsDrawHistoryController effectsdrawhistorycontroller = n;
        effectsdrawhistorycontroller.a.add(p1);
        if (effectsdrawhistorycontroller.b != null)
        {
            effectsdrawhistorycontroller.b.a(effectsdrawhistorycontroller, false);
        }
    }

    public final void a(ThreadPoolExecutor threadpoolexecutor)
    {
        t();
        (new ModernAsyncTask() {

            private EffectsDrawController a;

            protected final volatile Object doInBackground(Object aobj[])
            {
                return null;
            }

            protected final void onPostExecute(Object obj)
            {
                a.g.drawBitmap(a.d, 0.0F, 0.0F, a.j);
                if (a.c != null)
                {
                    a.c.invalidate();
                }
                EffectsDrawController.a(a, false);
            }

            protected final void onPreExecute()
            {
                EffectsDrawController.a(a, true);
                a.n.b();
            }

            
            {
                a = EffectsDrawController.this;
                super();
            }
        }).executeOnExecutor(threadpoolexecutor, new Void[] {
            null
        });
    }

    public final void a(ThreadPoolExecutor threadpoolexecutor, boolean flag, boolean flag1)
    {
        t();
        boolean flag2 = flag;
        if (flag1)
        {
            flag2 = flag;
            if (!flag)
            {
                flag2 = n.c();
            }
        }
        (new ModernAsyncTask(flag2) {

            private boolean a;
            private EffectsDrawController b;

            protected final volatile Object doInBackground(Object aobj[])
            {
                return null;
            }

            protected final void onPostExecute(Object obj)
            {
                if (a)
                {
                    b.g.drawBitmap(b.d, 0.0F, 0.0F, b.j);
                } else
                {
                    b.g.drawBitmap(b.e, 0.0F, 0.0F, b.j);
                }
                if (b.c != null)
                {
                    b.c.invalidate();
                }
                EffectsDrawController.a(b, false);
            }

            protected final void onPreExecute()
            {
                EffectsDrawController.a(b, true);
                b.n.b();
                if (a)
                {
                    b.n.a();
                }
            }

            
            {
                b = EffectsDrawController.this;
                a = flag;
                super();
            }
        }).executeOnExecutor(threadpoolexecutor, new Void[] {
            null
        });
    }

    public final void a(boolean flag)
    {
        t = flag;
        if (!flag)
        {
            t();
        }
    }

    public final Bitmap b()
    {
        return e;
    }

    public final void b(float f1, float f2)
    {
        while (!t || !s()) 
        {
            return;
        }
        if (m == EffectsDrawMode.BRUSH)
        {
            MaskBrushNew maskbrushnew = k;
            maskbrushnew.a(maskbrushnew.a);
            maskbrushnew.k.reset();
            maskbrushnew.a(f1, f2, maskbrushnew.s);
            maskbrushnew.k.moveTo(maskbrushnew.s.x, maskbrushnew.s.y);
            maskbrushnew.l.reset();
            maskbrushnew.l.moveTo(f1, f2);
            maskbrushnew.m.reset();
            maskbrushnew.m.moveTo(f1, f2);
            maskbrushnew.n = f1;
            maskbrushnew.o = f2;
            maskbrushnew.t.x = maskbrushnew.s.x;
            maskbrushnew.t.y = maskbrushnew.s.y;
        } else
        {
            l.e.a(f1, f2);
        }
        s = true;
    }

    public final void b(Activity activity, ThreadPoolExecutor threadpoolexecutor)
    {
        t();
        if (n.a.size() == 0 || n.a.size() == 1 && n.c())
        {
            (new ModernAsyncTask(n.c()) {

                private boolean a;
                private EffectsDrawController b;

                protected final volatile Object doInBackground(Object aobj[])
                {
                    return null;
                }

                protected final void onPostExecute(Object obj)
                {
                    if (a)
                    {
                        b.g.drawBitmap(b.d, 0.0F, 0.0F, b.j);
                    } else
                    {
                        b.g.drawBitmap(b.e, 0.0F, 0.0F, b.j);
                    }
                    if (b.c != null)
                    {
                        b.c.invalidate();
                    }
                    EffectsDrawController.a(b, false);
                }

                protected final void onPreExecute()
                {
                    EffectsDrawController.a(b, true);
                }

            
            {
                b = EffectsDrawController.this;
                a = flag;
                super();
            }
            }).executeOnExecutor(threadpoolexecutor, new Void[] {
                null
            });
            return;
        } else
        {
            a(activity, threadpoolexecutor, null, EffectsDrawHistoryController.HistoryTaskAction.HistoryTaskActionNone);
            return;
        }
    }

    public final Bitmap c()
    {
        return f;
    }

    public final void c(float f1, float f2)
    {
        boolean flag1 = true;
        if (!s || !s()) goto _L2; else goto _L1
_L1:
        if (m != EffectsDrawMode.BRUSH) goto _L4; else goto _L3
_L3:
        MaskBrushNew maskbrushnew = k;
        maskbrushnew.l.quadTo(maskbrushnew.n, maskbrushnew.o, (maskbrushnew.n + f1) / 2.0F, (maskbrushnew.o + f2) / 2.0F);
        maskbrushnew.m.quadTo(maskbrushnew.n, maskbrushnew.o, (maskbrushnew.n + f1) / 2.0F, (maskbrushnew.o + f2) / 2.0F);
        maskbrushnew.a(f1, f2, maskbrushnew.s);
        float f3 = (maskbrushnew.s.x + maskbrushnew.t.x) / 2.0F;
        float f5 = (maskbrushnew.s.y + maskbrushnew.t.y) / 2.0F;
        maskbrushnew.k.quadTo(maskbrushnew.t.x, maskbrushnew.t.y, f3, f5);
        maskbrushnew.m.computeBounds(maskbrushnew.q, true);
        float f7 = maskbrushnew.f.getStrokeWidth() / 2.0F + maskbrushnew.d + 1.0F;
        RectF rectf = maskbrushnew.q;
        rectf.left = rectf.left - f7;
        rectf = maskbrushnew.q;
        rectf.top = rectf.top - f7;
        rectf = maskbrushnew.q;
        rectf.right = rectf.right + f7;
        rectf = maskbrushnew.q;
        rectf.bottom = f7 + rectf.bottom;
        maskbrushnew.r.set((int)maskbrushnew.q.left, (int)maskbrushnew.q.top, (int)maskbrushnew.q.right, (int)maskbrushnew.q.bottom);
        maskbrushnew.k.moveTo(f3, f5);
        maskbrushnew.m.reset();
        maskbrushnew.m.moveTo((maskbrushnew.n + f1) / 2.0F, (maskbrushnew.o + f2) / 2.0F);
        maskbrushnew.l.moveTo((maskbrushnew.n + f1) / 2.0F, (maskbrushnew.o + f2) / 2.0F);
        maskbrushnew.n = f1;
        maskbrushnew.o = f2;
        maskbrushnew.t.x = maskbrushnew.s.x;
        maskbrushnew.t.y = maskbrushnew.s.y;
        if (c != null)
        {
            c.invalidate(k.r);
        }
_L2:
        return;
_L4:
        EffectShapeDrawerNew effectshapedrawernew = l.e;
        if (effectshapedrawernew.c.a == -1) goto _L6; else goto _L5
_L5:
        float f4;
        float f6;
        i i1;
        f4 = f1 - effectshapedrawernew.h;
        f6 = f2 - effectshapedrawernew.i;
        i1 = effectshapedrawernew.c;
        i1.a;
        JVM INSTR tableswitch 0 3: default 560
    //                   0 612
    //                   1 651
    //                   2 690
    //                   3 731;
           goto _L7 _L8 _L9 _L10 _L11
_L7:
        boolean flag = false;
_L14:
        if (flag)
        {
            effectshapedrawernew.c.a();
            effectshapedrawernew.h = f1;
            effectshapedrawernew.i = f2;
            flag = flag1;
        } else
        {
            flag = false;
        }
_L22:
        if (!flag || c == null) goto _L2; else goto _L12
_L12:
        c.invalidate();
        return;
_L8:
        if (Math.abs(f4) < 2.0F) goto _L7; else goto _L13
_L13:
        i1.e = (i1.e * i1.c - f4) / i1.c;
        flag = true;
          goto _L14
_L9:
        if (Math.abs(f4) < 2.0F) goto _L7; else goto _L15
_L15:
        i1.e = (f4 + i1.e * i1.c) / i1.c;
        flag = true;
          goto _L14
_L10:
        if (Math.abs(f6) < 2.0F) goto _L7; else goto _L16
_L16:
        i1.f = (i1.f * i1.c - f6) / i1.c;
        flag = true;
          goto _L14
_L11:
        if (Math.abs(f6) < 2.0F) goto _L7; else goto _L17
_L17:
        i1.f = (i1.f * i1.c + f6) / i1.c;
        flag = true;
          goto _L14
_L6:
        if (!effectshapedrawernew.f) goto _L19; else goto _L18
_L18:
        f4 = f1 - effectshapedrawernew.h;
        f6 = f2 - effectshapedrawernew.i;
        if (Math.abs(f4) >= 2.0F) goto _L21; else goto _L20
_L20:
        flag = flag1;
        if (Math.abs(f6) <= 2.0F) goto _L22; else goto _L21
_L21:
        effectshapedrawernew.c.a(f4 + effectshapedrawernew.c.b.x, f6 + effectshapedrawernew.c.b.y);
        effectshapedrawernew.h = f1;
        effectshapedrawernew.i = f2;
        flag = flag1;
          goto _L22
_L19:
        if (!effectshapedrawernew.g) goto _L24; else goto _L23
_L23:
        f4 = f1 - effectshapedrawernew.h;
        f6 = f2 - effectshapedrawernew.i;
        if (Math.abs(f4) >= 2.0F) goto _L26; else goto _L25
_L25:
        flag = flag1;
        if (Math.abs(f6) <= 2.0F) goto _L22; else goto _L26
_L26:
        float f8 = Math.abs(effectshapedrawernew.c.e);
        if (f4 >= 0.0F && f6 >= 0.0F)
        {
            i j1 = effectshapedrawernew.c;
            float f9 = effectshapedrawernew.c.c;
            j1.a((Math.max(f4, f6) + f9 * f8) / f8);
            effectshapedrawernew.h = f1;
            effectshapedrawernew.i = f2;
            flag = flag1;
        } else
        {
            flag = flag1;
            if (f4 <= 0.0F)
            {
                flag = flag1;
                if (f6 <= 0.0F)
                {
                    flag = flag1;
                    if (Math.min(Math.abs(effectshapedrawernew.c.c * effectshapedrawernew.c.e) + Math.min(f4, f6), Math.abs(effectshapedrawernew.c.c * effectshapedrawernew.c.f) + Math.min(f4, f6)) >= 30F)
                    {
                        i k1 = effectshapedrawernew.c;
                        float f10 = effectshapedrawernew.c.c;
                        k1.a((Math.min(f4, f6) + f10 * f8) / f8);
                        effectshapedrawernew.h = f1;
                        effectshapedrawernew.i = f2;
                        flag = flag1;
                    }
                }
            }
        }
          goto _L22
_L24:
        flag = false;
          goto _L22
    }

    public final Canvas d()
    {
        return g;
    }

    public final RectF e()
    {
        return a;
    }

    public final RectF f()
    {
        return b;
    }

    public final Rect g()
    {
        return r;
    }

    public final int h()
    {
        return h;
    }

    public final int i()
    {
        return k.b;
    }

    public final boolean j()
    {
        return f != null && !f.isRecycled() && g != null;
    }

    public final void k()
    {
        g = null;
        if (f != null && !f.isRecycled())
        {
            com.socialin.android.util.c.a(f);
        }
        f = null;
        EffectShapeDrawerNew effectshapedrawernew = l.e;
        if (effectshapedrawernew.j != null && !effectshapedrawernew.j.isRecycled())
        {
            effectshapedrawernew.j.recycle();
            effectshapedrawernew.j = null;
        }
        if (effectshapedrawernew.k != null && !effectshapedrawernew.k.isRecycled())
        {
            effectshapedrawernew.k.recycle();
            effectshapedrawernew.k = null;
        }
    }

    public final Bitmap l()
    {
        Bitmap bitmap = com.socialin.android.util.c.a(h, i, android.graphics.Bitmap.Config.ARGB_8888);
        if (bitmap != null && !bitmap.isRecycled())
        {
            Canvas canvas = new Canvas(bitmap);
            canvas.drawBitmap(f, 0.0F, 0.0F, j);
            if (m == EffectsDrawMode.SHAPE && l != null)
            {
                l.a(canvas);
            }
        }
        return bitmap;
    }

    public final ArrayList m()
    {
        ArrayList arraylist = n.d();
        if (m == EffectsDrawMode.SHAPE && l != null)
        {
            p p1 = l.d();
            if (p1 != null)
            {
                arraylist.add(p1);
            }
        }
        return arraylist;
    }

    public final void n()
    {
        if (s && s())
        {
            t();
        }
        s = false;
    }

    public final void o()
    {
        if (s())
        {
            t();
        }
    }

    public final void p()
    {
        if (s())
        {
            t();
        }
    }

    public final void q()
    {
        if (m == EffectsDrawMode.SHAPE)
        {
            EffectShapeDrawerNew effectshapedrawernew = l.e;
            if (effectshapedrawernew.n != null)
            {
                RectF rectf = effectshapedrawernew.n.a();
                float f1 = effectshapedrawernew.n.b();
                if (effectshapedrawernew.c != null && rectf != null)
                {
                    effectshapedrawernew.c.a(f1, rectf);
                }
            }
        }
    }

    public final void r()
    {
        if (m == EffectsDrawMode.SHAPE)
        {
            Object obj = l.e;
            if (((EffectShapeDrawerNew) (obj)).n != null)
            {
                RectF rectf = ((EffectShapeDrawerNew) (obj)).n.a();
                float f1 = ((EffectShapeDrawerNew) (obj)).n.b();
                if (((EffectShapeDrawerNew) (obj)).c != null && rectf != null)
                {
                    obj = ((EffectShapeDrawerNew) (obj)).c;
                    f1 = rectf.width() / f1;
                    float f2 = ((i) (obj)).g.x;
                    float f3 = rectf.left;
                    float f4 = ((i) (obj)).g.y;
                    float f5 = rectf.top;
                    float f6 = ((i) (obj)).h;
                    ((i) (obj)).a(f2 * f1 + f3, f5 + f4 * f1);
                    ((i) (obj)).a(f1 * f6);
                }
            }
        }
    }

    private class EffectsDrawMode extends Enum
    {

        private static final EffectsDrawMode $VALUES[];
        public static final EffectsDrawMode BRUSH;
        public static final EffectsDrawMode SHAPE;

        public static EffectsDrawMode valueOf(String s1)
        {
            return (EffectsDrawMode)Enum.valueOf(com/picsart/effectnew/EffectsDrawController$EffectsDrawMode, s1);
        }

        public static EffectsDrawMode[] values()
        {
            return (EffectsDrawMode[])$VALUES.clone();
        }

        static 
        {
            BRUSH = new EffectsDrawMode("BRUSH", 0);
            SHAPE = new EffectsDrawMode("SHAPE", 1);
            $VALUES = (new EffectsDrawMode[] {
                BRUSH, SHAPE
            });
        }

        private EffectsDrawMode(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
