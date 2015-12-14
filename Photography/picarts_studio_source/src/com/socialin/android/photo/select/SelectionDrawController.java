// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.select;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.view.View;
import com.picsart.studio.editor.fragment.SelectionFragment;
import com.socialin.android.photo.freecrop.FreeCropDrawController;
import com.socialin.android.photo.freecrop.b;
import com.socialin.android.photo.freecrop.d;
import com.socialin.android.photo.freecrop.f;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.android.photo.view.a;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;
import com.socialin.android.util.l;
import java.nio.ByteBuffer;
import java.util.ArrayList;

// Referenced classes of package com.socialin.android.photo.select:
//            d, f, k, p, 
//            j, m, SelectionShapeDrawController, e, 
//            i, c, o

public final class SelectionDrawController
    implements f, com.socialin.android.photo.select.d, com.socialin.android.photo.select.f, k, p
{

    PointF A;
    float B;
    private boolean C;
    private boolean D;
    public Bitmap a;
    public Bitmap b;
    public Canvas c;
    Paint d;
    Rect e;
    public RectF f;
    Rect g;
    RectF h;
    public Context i;
    Paint j;
    Paint k;
    public b l;
    public DRAW_MODE m;
    public FILL_TYPE n;
    public i o;
    public m p;
    public j q;
    public SelectionShapeDrawController r;
    e s;
    public View t;
    public com.socialin.android.photo.select.c u;
    public boolean v;
    boolean w;
    PointF x;
    PointF y;
    public boolean z;

    public SelectionDrawController(Context context, Bitmap bitmap)
    {
        e = new Rect();
        f = new RectF();
        g = new Rect();
        h = new RectF();
        j = new Paint();
        l = new b();
        m = DRAW_MODE.SHAPE;
        n = FILL_TYPE.DEFAULT;
        C = false;
        v = true;
        D = false;
        w = false;
        x = new PointF();
        y = new PointF();
        z = false;
        A = new PointF();
        B = 0.0F;
        i = context;
        a = bitmap;
        float f1 = Utils.a(3F, context);
        float f2 = Utils.a(5F, context);
        k = com.socialin.android.photo.select.j.a();
        d = com.socialin.android.photo.select.j.a();
        d.setAlpha(80);
        r();
        p = new m(context, f, g, f1, f2);
        p.y = this;
        q = new j(context, f1, f2, f, g, bitmap);
        q.t = this;
        q.s = C;
        r = new SelectionShapeDrawController(context, f2, f, g);
        r.a(SelectionShapeDrawController.SelectionShapeType.RECTANGLE);
        r.t = this;
        s = new e(context);
        s.a = this;
    }

    private void a(Path path, boolean flag)
    {
        float f1 = (float)a.getWidth() / f.width();
        Paint paint = q.m;
        Paint paint1 = q.o;
        float f2 = q.l;
        float f3 = (float)b.getWidth() / f.width();
        float f4 = (float)b.getWidth() / (float)a.getWidth();
        if (flag)
        {
            Path path2 = new Path(path);
            paint.setStrokeWidth(f3 * f2);
            paint1.setStrokeWidth(f3 * f2);
            Path path3 = new Path();
            Matrix matrix1 = new Matrix();
            matrix1.postScale(f4, f4);
            path.transform(matrix1, path3);
            if (C)
            {
                c.drawPath(path3, paint);
            } else
            {
                Paint paint3 = new Paint();
                paint3.setAntiAlias(true);
                paint3.setStyle(android.graphics.Paint.Style.STROKE);
                paint3.setStrokeJoin(android.graphics.Paint.Join.ROUND);
                paint3.setStrokeCap(android.graphics.Paint.Cap.ROUND);
                paint3.setFilterBitmap(true);
                paint3.setStrokeWidth(paint.getStrokeWidth());
                paint3.setColor(0xff000000);
                c.drawPath(path3, paint3);
            }
            s();
            q.a(f2);
            l.a(path2, f1 * paint1.getStrokeWidth(), C);
            path.reset();
        } else
        {
            Matrix matrix = new Matrix();
            matrix.postTranslate(-f.left, -f.top);
            matrix.postScale(f1, f1);
            Path path1 = new Path();
            path.transform(matrix, path1);
            Paint paint2 = new Paint();
            paint2.setAntiAlias(true);
            paint2.setStyle(android.graphics.Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint2.setFilterBitmap(true);
            Path path4 = new Path();
            matrix.reset();
            matrix.postTranslate(-f.left, -f.top);
            matrix.postScale(f3, f3);
            path.transform(matrix, path4);
            paint2.setColor(0xff000000);
            if (C)
            {
                paint2.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
            } else
            {
                paint2.setXfermode(null);
            }
            c.drawPath(path4, paint2);
            s();
            l.a(path1, C);
        }
        if (o != null)
        {
            o.e();
        }
    }

    private void c(boolean flag)
    {
        C = flag;
        q.s = flag;
    }

    private void r()
    {
        if (b == null)
        {
            b = Bitmap.createBitmap(a.getWidth(), a.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            b.eraseColor(0);
            e.set(0, 0, b.getWidth(), b.getHeight());
            c = null;
        } else
        {
            b.eraseColor(0);
        }
        if (b != null && c == null)
        {
            c = new Canvas(b);
        }
    }

    private void s()
    {
        Paint paint = com.socialin.android.photo.select.j.b();
        paint.setColor(0xffff0000);
        c.drawRect(new Rect(0, 0, b.getWidth(), b.getHeight()), paint);
    }

    public final int a(Bitmap bitmap)
    {
        int i1 = a.getWidth();
        int j1 = a.getHeight();
        ByteBuffer bytebuffer = SelectionFragment.a(i1 * j1 * 4);
        bytebuffer.position(0);
        a.copyPixelsToBuffer(bytebuffer);
        ByteBuffer bytebuffer1 = SelectionFragment.a(i1 * j1 * 4);
        bytebuffer1.position(0);
        bitmap.copyPixelsToBuffer(bytebuffer1);
        bitmap = SelectionFragment.a(i1 * j1 * 4);
        bitmap.position(0);
        a.copyPixelsToBuffer(bitmap);
        i1 = ImageOpCommon.clearWithMask(bytebuffer, bitmap, bytebuffer1, i1, j1);
        bitmap.position(0);
        a.copyPixelsFromBuffer(bitmap);
        SelectionFragment.a(bitmap);
        SelectionFragment.a(bytebuffer);
        SelectionFragment.a(bytebuffer1);
        return i1;
    }

    public final void a()
    {
        if (t != null)
        {
            t.invalidate();
        }
    }

    public final void a(float f1)
    {
        if (m == DRAW_MODE.ADD_DRAWABLE && u != null && u.s)
        {
            u.n = f1;
            return;
        } else
        {
            B = f1;
            return;
        }
    }

    public final void a(Path path)
    {
        a(path, false);
    }

    public final void a(PointF pointf)
    {
        float f1;
        float f2;
        boolean flag2;
label0:
        {
label1:
            {
                flag2 = false;
                if (m != DRAW_MODE.ADD_DRAWABLE)
                {
                    f2 = pointf.x;
                    f1 = pointf.y;
                    if (v)
                    {
                        if (n != FILL_TYPE.DEFAULT)
                        {
                            break label0;
                        }
                        boolean flag;
                        if (b == null || b.isRecycled())
                        {
                            flag = false;
                        } else
                        {
                            int i1 = b.getWidth();
                            int k1 = b.getHeight();
                            float f3 = f.left;
                            float f4 = f.top;
                            float f5 = (float)i1 / f.width();
                            int i2 = (int)((f2 - f3) * f5);
                            int j2 = (int)((f1 - f4) * f5);
                            if (i2 >= 0 && i2 < i1 && j2 >= 0 && j2 < k1)
                            {
                                if (Color.red(b.getPixel(i2, j2)) > 20)
                                {
                                    flag = true;
                                } else
                                {
                                    flag = false;
                                }
                            } else
                            {
                                flag = false;
                            }
                        }
                        D = flag;
                        if (!D)
                        {
                            break label1;
                        }
                        x.x = f2;
                        x.y = f1;
                    }
                }
                return;
            }
            q();
            a();
        }
        final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[DRAW_MODE.values().length];
                try
                {
                    a[DRAW_MODE.FREE_CROP.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[DRAW_MODE.LASSO.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[DRAW_MODE.SHAPE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[DRAW_MODE.ADD_DRAWABLE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (com.socialin.android.photo.select._cls1.a[m.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            pointf = q;
            pointf.f = f2;
            pointf.g = f1;
            pointf.j = true;
            pointf.k = false;
            return;

        case 2: // '\002'
            pointf = p;
            f2 = pointf.a(f2);
            f1 = pointf.b(f1);
            pointf.g = f2;
            pointf.h = f1;
            pointf.i = true;
            pointf.j = true;
            return;

        case 3: // '\003'
            pointf = r;
            break;
        }
        pointf.l = f2;
        pointf.m = f1;
        pointf.n = f2;
        pointf.o = f1;
        pointf.i = true;
        pointf.j = false;
        boolean flag1 = flag2;
        if (((SelectionShapeDrawController) (pointf)).e != null)
        {
            int j1 = (int)f2;
            int l1 = (int)f1;
            Region region = new Region();
            Region region1 = new Region(j1 - 1, l1 - 1, j1 + 1, l1 + 1);
            flag1 = region.setPath(((SelectionShapeDrawController) (pointf)).e, region1);
        }
        pointf.k = flag1;
    }

    public final void a(PointF pointf, PointF pointf1)
    {
        if (m == DRAW_MODE.ADD_DRAWABLE)
        {
            if (u.a(pointf) && u.a(pointf1) || u.s && (u.a(pointf) || u.a(pointf1)))
            {
                u.s = true;
            } else
            {
                u.s = false;
            }
            if (!u.s)
            {
                u.a(f);
            }
            return;
        } else
        {
            a(((PointF) (null)), false);
            return;
        }
    }

    public final void a(PointF pointf, boolean flag)
    {
        if (!v)
        {
            return;
        }
        if (D)
        {
            if (w)
            {
                float f4 = y.x;
                float f5 = x.x;
                float f1 = y.y;
                float f2 = x.y;
                int i1 = b.getWidth();
                int j1 = b.getHeight();
                float f3 = (float)b.getWidth() / f.width();
                f4 = (f4 - f5) * f3;
                f1 = (f1 - f2) * f3;
                pointf = Bitmap.createBitmap(i1, j1, android.graphics.Bitmap.Config.ARGB_8888);
                Object obj = new Canvas(pointf);
                pointf.eraseColor(0);
                ((Canvas) (obj)).save();
                ((Canvas) (obj)).translate(f4, f1);
                ((Canvas) (obj)).drawBitmap(b, 0.0F, 0.0F, k);
                ((Canvas) (obj)).restore();
                c = ((Canvas) (obj));
                com.socialin.android.util.c.a(b);
                b = pointf;
                f2 = (float)a.getWidth() / (float)b.getWidth();
                pointf = l;
                obj = new com.socialin.android.photo.freecrop.c(pointf);
                obj.d = 2;
                obj.e = f4 * f2;
                obj.f = f1 * f2;
                ((b) (pointf)).a.add(obj);
                if (o != null)
                {
                    o.e();
                }
            }
            w = false;
            D = false;
            return;
        }
        switch (com.socialin.android.photo.select._cls1.a[m.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            pointf = q;
            if (((j) (pointf)).k)
            {
                if (((j) (pointf)).t != null)
                {
                    ((j) (pointf)).t.b(((j) (pointf)).d);
                }
                ((j) (pointf)).c.reset();
                ((j) (pointf)).d.reset();
            }
            pointf.k = false;
            pointf.j = false;
            return;

        case 2: // '\002'
            m m1 = p;
            if (m1.j)
            {
                boolean flag1;
                if (flag && m1.u)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                m1.s = flag1;
                flag1 = m1.s;
                if (m1.k)
                {
                    if (pointf != null && !m1.i)
                    {
                        m1.a(m1.a(pointf.x), m1.b(pointf.y));
                    }
                    if (m1.p != null)
                    {
                        m1.p.e = false;
                        if (m1.q != null)
                        {
                            pointf = m1.p;
                            m1.q.getWidth();
                            m1.q.getHeight();
                            pointf.a();
                        }
                    }
                    if (m1.c != null)
                    {
                        m1.c.b = com.socialin.android.photo.view.a.a(m1.n, m1.o);
                        m1.c.b(m1.g, m1.h);
                        if (flag1)
                        {
                            pointf = m1.v.a;
                            pointf.lineTo(m1.d.c, m1.d.d);
                            if (m1.y != null)
                            {
                                m1.y.a(pointf);
                            }
                            m1.a();
                        } else
                        {
                            m1.b();
                            m1.c.a = true;
                        }
                    }
                    m1.k = false;
                } else
                if (flag && !m1.c.c(m1.g, m1.h))
                {
                    m1.a();
                    if (m1.q != null)
                    {
                        m1.q.invalidate();
                    }
                }
                if (flag && !m1.s && !m1.v.a.isEmpty())
                {
                    m1.c();
                }
            }
            m1.j = false;
            return;

        case 3: // '\003'
            pointf = r;
            if (((SelectionShapeDrawController) (pointf)).i)
            {
                if (((SelectionShapeDrawController) (pointf)).t != null)
                {
                    ((SelectionShapeDrawController) (pointf)).t.c(((SelectionShapeDrawController) (pointf)).e);
                }
                pointf.e = null;
            }
            pointf.i = false;
            pointf.j = false;
            pointf.k = false;
            return;
        }
    }

    public final void a(DRAW_MODE draw_mode)
    {
        m = draw_mode;
        if (draw_mode != DRAW_MODE.ADD_DRAWABLE && u != null)
        {
            u.a();
            u = null;
        }
        if (p != null)
        {
            p.a();
        }
        if (t != null)
        {
            t.invalidate();
        }
    }

    public final void a(FILL_TYPE fill_type)
    {
        n = fill_type;
        if (fill_type == FILL_TYPE.ADD || fill_type == FILL_TYPE.DEFAULT)
        {
            c(false);
            return;
        } else
        {
            c(true);
            return;
        }
    }

    public final void a(boolean flag)
    {
        com.socialin.android.photo.select._cls1.a[m.ordinal()];
        JVM INSTR tableswitch 2 4: default 36
    //                   2 37
    //                   3 36
    //                   4 127;
           goto _L1 _L2 _L1 _L3
_L1:
        m m1;
        return;
_L2:
        if ((m1 = p).e != null && !m1.v.a.isEmpty())
        {
            m1.x = m1.e.width();
            m1.v.a(m1.e);
            m1.c.a(m1.e.left, m1.e.top);
            m1.d.a(m1.e.left, m1.e.top);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (flag && u != null)
        {
            u.a(f);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public final void b(Path path)
    {
        a(path, true);
    }

    public final void b(PointF pointf)
    {
        boolean flag;
        boolean flag2;
        flag2 = false;
        flag = true;
        if (m != DRAW_MODE.ADD_DRAWABLE) goto _L2; else goto _L1
_L1:
        if (u == null) goto _L4; else goto _L3
_L3:
        float f1;
        float f7;
        com.socialin.android.photo.select.c c1;
        c1 = u;
        f7 = pointf.x;
        f1 = pointf.y;
        if (!c1.s) goto _L4; else goto _L5
_L5:
        float f18;
        float f23;
        f18 = c1.l.centerX();
        f23 = c1.l.centerY();
        if (c1.t != 2) goto _L7; else goto _L6
_L6:
        float f8 = -c1.n;
        pointf = com.socialin.android.photo.view.a.b(new float[] {
            f7, f1
        }, f18, f23, f8);
        f1 = pointf[0];
        f7 = pointf[1];
        c1.w.intValue();
        JVM INSTR tableswitch 3 7: default 156
    //                   3 319
    //                   4 593
    //                   5 697
    //                   6 645
    //                   7 749;
           goto _L8 _L9 _L10 _L11 _L12 _L13
_L8:
        float f9 = f7;
        f7 = f1;
        f1 = f9;
_L7:
        if (c1.t == 1)
        {
            float f10 = c1.v.x;
            float f25 = c1.v.y;
            c1.l.offset(f7 - f10, f1 - f25);
            c1.v.x = f7;
            c1.v.y = f1;
        }
        if (c1.t == 3)
        {
            float f11 = c1.u;
            c1.n = com.socialin.android.util.l.a(new PointF(f18, f23), new PointF(100F + f18, f23), new PointF(f18, f23), new PointF(f7, f1)) + f11;
        }
        if (c1.I != null)
        {
            c1.I.a();
        }
_L4:
        return;
_L9:
        float f12 = ((f1 - c1.z.centerX()) * 2.0F) / c1.z.width();
        c1.C = f12;
        c1.D = f12;
        f12 = c1.z.width();
        float f26 = c1.z.height();
        f12 *= Math.abs(c1.C);
        f26 *= Math.abs(c1.D);
        c1.l.left = c1.z.centerX() - f12 / 2.0F;
        pointf = c1.l;
        float f28 = c1.z.centerX();
        pointf.right = f12 / 2.0F + f28;
        c1.l.top = c1.z.centerY() - f26 / 2.0F;
        pointf = c1.l;
        f12 = c1.z.centerY();
        pointf.bottom = f26 / 2.0F + f12;
        if (c1.C * c1.A < 0.0F)
        {
            float f13;
            boolean flag1;
            if (!c1.x)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            c1.x = flag1;
            flag1 = flag2;
            if (!c1.y)
            {
                flag1 = true;
            }
            c1.y = flag1;
            c1.A = -c1.A;
            c1.B = -c1.B;
        }
        f13 = f1;
        f1 = f7;
        f7 = f13;
          goto _L7
_L10:
        c1.D = ((c1.z.centerY() - f7) * 2.0F) / c1.z.height();
        c1.a(c1.C, c1.D);
        float f14 = f1;
        f1 = f7;
        f7 = f14;
          goto _L7
_L12:
        c1.D = ((f7 - c1.z.centerY()) * 2.0F) / c1.z.height();
        c1.a(c1.C, c1.D);
        float f15 = f1;
        f1 = f7;
        f7 = f15;
          goto _L7
_L11:
        c1.C = ((f1 - c1.z.centerX()) * 2.0F) / c1.z.width();
        c1.a(c1.C, c1.D);
        float f16 = f1;
        f1 = f7;
        f7 = f16;
          goto _L7
_L13:
        c1.C = ((c1.z.centerX() - f1) * 2.0F) / c1.z.width();
        c1.a(c1.C, c1.D);
          goto _L8
_L2:
        float f17;
        f17 = pointf.x;
        f7 = pointf.y;
        if (!v) goto _L15; else goto _L14
_L14:
        if (!D) goto _L17; else goto _L16
_L16:
        y.x = f17;
        y.y = f7;
        w = true;
_L27:
        if (!flag) goto _L4; else goto _L18
_L18:
        if (D) goto _L20; else goto _L19
_L19:
        com.socialin.android.photo.select._cls1.a[m.ordinal()];
        JVM INSTR tableswitch 1 2: default 884
    //                   1 1980
    //                   2 2003;
           goto _L20 _L21 _L22
_L20:
        pointf = null;
          goto _L23
_L17:
        com.socialin.android.photo.select._cls1.a[m.ordinal()];
        JVM INSTR tableswitch 1 3: default 936
    //                   1 942
    //                   2 1348
    //                   3 1710;
           goto _L15 _L24 _L25 _L26
_L15:
        flag = false;
          goto _L27
_L24:
        pointf = q;
        if (!((j) (pointf)).j) goto _L29; else goto _L28
_L28:
        f2 = ((j) (pointf)).b;
        if (((j) (pointf)).k)
        {
            f2 = ((j) (pointf)).a;
        }
        if (com.socialin.android.util.l.b(((j) (pointf)).f, ((j) (pointf)).g, f17, f7) < f2) goto _L29; else goto _L30
_L30:
        if (((j) (pointf)).k)
        {
            float f3 = (((j) (pointf)).f + f17) / 2.0F;
            float f19 = (((j) (pointf)).g + f7) / 2.0F;
            ((j) (pointf)).e.quadTo(((j) (pointf)).f, ((j) (pointf)).g, f3, f19);
            ((j) (pointf)).e.computeBounds(((j) (pointf)).h, true);
            float f24 = ((j) (pointf)).l / 2.0F + 1.0F;
            RectF rectf = ((j) (pointf)).h;
            rectf.left = rectf.left - f24;
            rectf = ((j) (pointf)).h;
            rectf.top = rectf.top - f24;
            rectf = ((j) (pointf)).h;
            rectf.right = rectf.right + f24;
            rectf = ((j) (pointf)).h;
            rectf.bottom = f24 + rectf.bottom;
            ((j) (pointf)).i.set((int)((j) (pointf)).h.left, (int)((j) (pointf)).h.top, (int)((j) (pointf)).h.right, (int)((j) (pointf)).h.bottom);
            ((j) (pointf)).c.quadTo(((j) (pointf)).f, ((j) (pointf)).g, f3, f19);
            f24 = pointf.b(((j) (pointf)).f);
            float f27 = pointf.c(((j) (pointf)).g);
            float f29 = pointf.b(f3);
            float f30 = pointf.c(f19);
            ((j) (pointf)).d.quadTo(f24, f27, f29, f30);
            ((j) (pointf)).e.reset();
            ((j) (pointf)).e.moveTo(f3, f19);
        } else
        {
            float f4 = ((j) (pointf)).f;
            float f20 = ((j) (pointf)).g;
            ((j) (pointf)).c.reset();
            ((j) (pointf)).c.moveTo(f4, f20);
            ((j) (pointf)).d.reset();
            ((j) (pointf)).d.moveTo(pointf.b(f4), pointf.c(f20));
            ((j) (pointf)).e.moveTo(f4, f20);
        }
        pointf.f = f17;
        pointf.g = f7;
        pointf.k = true;
          goto _L27
_L29:
        flag = false;
          goto _L27
_L25:
        pointf = p;
        if (!((m) (pointf)).j) goto _L32; else goto _L31
_L31:
        f17 = pointf.a(f17);
        f7 = pointf.b(f7);
        float f21 = com.socialin.android.util.l.b(f17, f7, ((m) (pointf)).g, ((m) (pointf)).h);
        float f5;
        if (((m) (pointf)).i)
        {
            f5 = ((m) (pointf)).m;
        } else
        {
            f5 = ((m) (pointf)).l;
        }
        if (f21 < f5) goto _L32; else goto _L33
_L33:
        if (((m) (pointf)).i)
        {
            if (!((m) (pointf)).c.c(((m) (pointf)).g, ((m) (pointf)).h) || ((m) (pointf)).v.a.isEmpty())
            {
                ((m) (pointf)).v.a(((m) (pointf)).g, ((m) (pointf)).h);
                ((m) (pointf)).d.b(((m) (pointf)).g, ((m) (pointf)).h);
                ((m) (pointf)).d.a = true;
            }
            if (((m) (pointf)).p != null)
            {
                ((m) (pointf)).p.e = true;
                ((m) (pointf)).p.a(((m) (pointf)).g, ((m) (pointf)).h);
            }
            pointf.i = false;
            pointf.b();
            ((m) (pointf)).c.a = false;
            if (((m) (pointf)).q != null)
            {
                ((m) (pointf)).q.invalidate();
            }
        }
        pointf.n = f17 - ((m) (pointf)).g;
        pointf.o = f7 - ((m) (pointf)).h;
        pointf.a(f17, f7);
        pointf.b = com.socialin.android.photo.view.a.a(((m) (pointf)).d.c, ((m) (pointf)).d.d, ((m) (pointf)).g, ((m) (pointf)).h);
        f5 = ((m) (pointf)).b / 2.0F;
        f7 = ((m) (pointf)).v.a();
        if (((m) (pointf)).b <= ((m) (pointf)).a && (double)f7 >= 3.1415926535897931D * (double)f5)
        {
            pointf.u = true;
            pointf.t = (int)(150F * (1.0F - ((m) (pointf)).b / ((m) (pointf)).a));
        } else
        {
            if (((m) (pointf)).u)
            {
                pointf.r = true;
            }
            pointf.u = false;
        }
        pointf.k = true;
          goto _L27
_L32:
        flag = false;
          goto _L27
_L26:
        pointf = r;
        if (!((SelectionShapeDrawController) (pointf)).i) goto _L35; else goto _L34
_L34:
        if (!((SelectionShapeDrawController) (pointf)).j && com.socialin.android.util.l.b(((SelectionShapeDrawController) (pointf)).l, ((SelectionShapeDrawController) (pointf)).m, f17, f7) >= ((SelectionShapeDrawController) (pointf)).a)
        {
            pointf.j = true;
            if (!((SelectionShapeDrawController) (pointf)).k)
            {
                pointf.e = new Path();
            }
        }
        if (!((SelectionShapeDrawController) (pointf)).j) goto _L35; else goto _L36
_L36:
        if (((SelectionShapeDrawController) (pointf)).k)
        {
            float f6 = ((SelectionShapeDrawController) (pointf)).n;
            float f22 = ((SelectionShapeDrawController) (pointf)).o;
            ((SelectionShapeDrawController) (pointf)).r.offset(f17 - f6, f7 - f22);
            pointf.n = f17;
            pointf.o = f7;
        } else
        {
            pointf.n = f17;
            pointf.o = f7;
            ((SelectionShapeDrawController) (pointf)).r.set(Math.min(((SelectionShapeDrawController) (pointf)).n, ((SelectionShapeDrawController) (pointf)).l), Math.min(((SelectionShapeDrawController) (pointf)).m, ((SelectionShapeDrawController) (pointf)).o), Math.max(((SelectionShapeDrawController) (pointf)).n, ((SelectionShapeDrawController) (pointf)).l), Math.max(((SelectionShapeDrawController) (pointf)).m, ((SelectionShapeDrawController) (pointf)).o));
        }
        ((SelectionShapeDrawController) (pointf)).p.reset();
        ((SelectionShapeDrawController) (pointf)).p.setScale(((SelectionShapeDrawController) (pointf)).r.width() / ((SelectionShapeDrawController) (pointf)).q.width(), ((SelectionShapeDrawController) (pointf)).r.height() / ((SelectionShapeDrawController) (pointf)).q.height());
        ((SelectionShapeDrawController) (pointf)).p.postTranslate(((SelectionShapeDrawController) (pointf)).r.left, ((SelectionShapeDrawController) (pointf)).r.top);
        ((SelectionShapeDrawController) (pointf)).d.transform(((SelectionShapeDrawController) (pointf)).p, ((SelectionShapeDrawController) (pointf)).e);
          goto _L27
_L35:
        flag = false;
          goto _L27
_L21:
        pointf = q;
        if (((j) (pointf)).c.isEmpty()) goto _L20; else goto _L37
_L37:
        pointf = ((j) (pointf)).i;
          goto _L23
_L22:
        pointf = p;
        if (((m) (pointf)).u) goto _L20; else goto _L38
_L38:
        if (!((m) (pointf)).r) goto _L40; else goto _L39
_L39:
        pointf.r = false;
          goto _L20
_L40:
        pointf = ((m) (pointf)).v.d;
_L23:
        float f2;
        if (pointf == null)
        {
            t.invalidate();
            return;
        }
        t.invalidate(pointf);
        return;
          goto _L7
    }

    public final void b(boolean flag)
    {
        com.socialin.android.photo.select._cls1.a[m.ordinal()];
        JVM INSTR tableswitch 2 4: default 36
    //                   2 37
    //                   3 36
    //                   4 149;
           goto _L1 _L2 _L1 _L3
_L1:
        m m1;
        return;
_L2:
        if ((m1 = p).x > 0.0F && !m1.v.a.isEmpty())
        {
            float f1 = m1.e.width() / m1.x;
            m1.v.a(m1.e, f1);
            m1.c.a(m1.e.left, m1.e.top, f1);
            m1.d.a(m1.e.left, m1.e.top, f1);
            if (flag && !m1.s)
            {
                m1.c();
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (flag && u != null)
        {
            u.b(f);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public final boolean b()
    {
        return t != null;
    }

    public final void c()
    {
        t.invalidate();
    }

    public final void c(Path path)
    {
        a(path, false);
    }

    public final void c(PointF pointf)
    {
        if (m == DRAW_MODE.ADD_DRAWABLE)
        {
            if (u != null)
            {
                pointf = u;
                pointf.w = null;
                pointf.t = 1;
            }
        } else
        {
            a(pointf, true);
        }
        t.invalidate();
    }

    public final RectF d()
    {
        if (m == DRAW_MODE.ADD_DRAWABLE && u != null && u.s)
        {
            return u.l;
        } else
        {
            return f;
        }
    }

    public final void d(PointF pointf)
    {
label0:
        {
            if (m != DRAW_MODE.ADD_DRAWABLE || u == null)
            {
                break label0;
            }
            com.socialin.android.photo.select.c c1 = u;
            float f9 = pointf.x;
            float f10 = pointf.y;
            c1.t = 1;
            c1.v.x = f9;
            c1.v.y = f10;
            float f3 = c1.l.left;
            float f7 = c1.l.top;
            float f1 = c1.l.right;
            float f5 = c1.l.bottom;
            if (c1.x)
            {
                f3 = c1.l.right;
                f1 = c1.l.left;
            }
            if (c1.y)
            {
                f7 = c1.l.bottom;
                f5 = c1.l.top;
            }
            c1.E.set(f3, f7, f1, f5);
            c1.w = com.socialin.android.photo.view.a.a(c1.E, f9, f10, -c1.n, c1.d, c1.d, c1.e, c1.e);
            if (c1.w != null || !com.socialin.android.photo.view.a.a(c1.l, f9, f10, -c1.n))
            {
                boolean flag;
                if (c1.w == null)
                {
                    flag = false;
                } else
                {
                    flag = true;
                }
                if (flag)
                {
                    c1.s = true;
                    c1.t = 2;
                    float f2;
                    float f4;
                    float f6;
                    float f8;
                    float f11;
                    boolean flag1;
                    if (c1.x)
                    {
                        f2 = -1F;
                    } else
                    {
                        f2 = 1.0F;
                    }
                    c1.A = f2;
                    if (c1.y)
                    {
                        f2 = -1F;
                    } else
                    {
                        f2 = 1.0F;
                    }
                    c1.B = f2;
                    c1.C = c1.A;
                    c1.D = c1.B;
                    c1.z.set(c1.l);
                }
                flag1 = com.socialin.android.photo.view.a.b(c1.E, f9, f10, -c1.n, c1.d, c1.d, c1.f, c1.f);
                if (flag1)
                {
                    c1.s = true;
                    c1.t = 3;
                }
                if (!flag1 && !flag)
                {
                    c1.s = false;
                }
                if (c1.I != null)
                {
                    c1.I.a();
                }
                if (c1.t == 1)
                {
                    break label0;
                }
            }
            if (c1.t == 1)
            {
                c1.s = true;
                if (c1.I != null)
                {
                    c1.I.a();
                }
            }
            if (c1.t == 3)
            {
                f2 = c1.l.centerX();
                f4 = c1.l.centerY();
                f6 = c1.l.centerX();
                f8 = c1.l.centerY();
                f11 = -c1.n;
                pointf = com.socialin.android.photo.view.a.b(new float[] {
                    f9, f10
                }, f6, f8, f11);
                c1.u = com.socialin.android.util.l.a(new PointF(f2, f4), new PointF(pointf[0], pointf[1]), new PointF(f2, f4), new PointF(f2 + 100F, f4));
            }
        }
    }

    public final RectF e()
    {
        if (m == DRAW_MODE.ADD_DRAWABLE && u != null && u.s)
        {
            return u.k;
        } else
        {
            return h;
        }
    }

    public final boolean f()
    {
        return m == DRAW_MODE.ADD_DRAWABLE && u != null && u.s;
    }

    public final float g()
    {
        if (m == DRAW_MODE.ADD_DRAWABLE && u != null && u.s)
        {
            return u.n;
        } else
        {
            return B;
        }
    }

    public final PointF h()
    {
        if (m == DRAW_MODE.ADD_DRAWABLE && u != null && u.s)
        {
            return u.o;
        } else
        {
            return A;
        }
    }

    public final float i()
    {
        return m != DRAW_MODE.ADD_DRAWABLE || u == null || !u.s ? 0.7F : 0.2F;
    }

    public final float j()
    {
        return m != DRAW_MODE.ADD_DRAWABLE || u == null || !u.s ? 20F : 6F;
    }

    public final void k()
    {
        if (m == DRAW_MODE.ADD_DRAWABLE && !u.s)
        {
            u.b(f);
        }
    }

    public final void l()
    {
        a(false);
    }

    public final void m()
    {
        b(false);
    }

    public final boolean n()
    {
        return b == null || a == null || b.getWidth() == a.getWidth();
    }

    public final boolean o()
    {
        if (l != null)
        {
            return l.a();
        } else
        {
            return false;
        }
    }

    public final d p()
    {
        float f1;
        Bitmap bitmap;
        Canvas canvas;
        b b1;
        Paint paint;
        Paint paint1;
        Paint paint2;
        int i1;
        int j1;
        int k1;
        b1 = l;
        j1 = b.getWidth();
        k1 = b.getHeight();
        i1 = a.getWidth();
        a.getHeight();
        bitmap = com.socialin.android.util.c.a(j1, k1, android.graphics.Bitmap.Config.ARGB_8888);
        if (bitmap == null)
        {
            return null;
        }
        bitmap.eraseColor(0);
        canvas = new Canvas(bitmap);
        paint = FreeCropDrawController.e();
        paint1 = new Paint();
        paint1.setAntiAlias(true);
        paint1.setStyle(android.graphics.Paint.Style.FILL);
        paint1.setFilterBitmap(true);
        paint2 = com.socialin.android.photo.select.j.a();
        f1 = (float)j1 / (float)i1;
        i1 = 0;
_L6:
        com.socialin.android.photo.freecrop.c c1;
        if (i1 >= b1.a.size())
        {
            break MISSING_BLOCK_LABEL_373;
        }
        c1 = (com.socialin.android.photo.freecrop.c)b1.a.get(i1);
        c1.d;
        JVM INSTR tableswitch 0 3: default 192
    //                   0 301
    //                   1 301
    //                   2 201
    //                   3 316;
           goto _L1 _L2 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_316;
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break; /* Loop/switch isn't completed */
_L7:
        i1++;
        if (true) goto _L6; else goto _L5
_L5:
        Bitmap bitmap1 = com.socialin.android.util.c.a(j1, k1, android.graphics.Bitmap.Config.ARGB_8888);
        if (bitmap1 == null)
        {
            com.socialin.android.util.c.a(bitmap);
            return null;
        }
        canvas = new Canvas(bitmap1);
        bitmap1.eraseColor(0);
        float f2 = c1.e;
        float f3 = c1.f;
        canvas.save();
        canvas.translate(f2 * f1, f3 * f1);
        canvas.drawBitmap(bitmap, 0.0F, 0.0F, paint2);
        canvas.restore();
        com.socialin.android.util.c.a(bitmap);
        bitmap = bitmap1;
          goto _L7
_L2:
        c1.a(canvas, paint, paint1, f1);
          goto _L7
        ByteBuffer bytebuffer = SelectionFragment.a(j1 * k1 * 4);
        bytebuffer.position(0);
        bitmap.copyPixelsToBuffer(bytebuffer);
        ImageOpCommon.invertAlphaChannel(bytebuffer, j1, k1);
        bytebuffer.position(0);
        bitmap.copyPixelsFromBuffer(bytebuffer);
        SelectionFragment.a(bytebuffer);
          goto _L7
        Object obj = com.socialin.android.photo.select.j.b();
        ((Paint) (obj)).setColor(0xffff0000);
        canvas.drawRect(new Rect(0, 0, j1, k1), ((Paint) (obj)));
        obj = new d();
        obj.a = canvas;
        obj.b = bitmap;
        b1.a.size();
        return ((d) (obj));
    }

    public final ArrayList q()
    {
        b b1 = l;
        ArrayList arraylist = b1.a;
        b1.a = new ArrayList();
        r();
        return arraylist;
    }

    private class DRAW_MODE extends Enum
    {

        private static final DRAW_MODE $VALUES[];
        public static final DRAW_MODE ADD_DRAWABLE;
        public static final DRAW_MODE FREE_CROP;
        public static final DRAW_MODE LASSO;
        public static final DRAW_MODE SHAPE;

        public static DRAW_MODE valueOf(String s1)
        {
            return (DRAW_MODE)Enum.valueOf(com/socialin/android/photo/select/SelectionDrawController$DRAW_MODE, s1);
        }

        public static DRAW_MODE[] values()
        {
            return (DRAW_MODE[])$VALUES.clone();
        }

        static 
        {
            FREE_CROP = new DRAW_MODE("FREE_CROP", 0);
            LASSO = new DRAW_MODE("LASSO", 1);
            SHAPE = new DRAW_MODE("SHAPE", 2);
            ADD_DRAWABLE = new DRAW_MODE("ADD_DRAWABLE", 3);
            $VALUES = (new DRAW_MODE[] {
                FREE_CROP, LASSO, SHAPE, ADD_DRAWABLE
            });
        }

        private DRAW_MODE(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    private class FILL_TYPE extends Enum
    {

        private static final FILL_TYPE $VALUES[];
        public static final FILL_TYPE ADD;
        public static final FILL_TYPE CLEAR;
        public static final FILL_TYPE DEFAULT;

        public static FILL_TYPE valueOf(String s1)
        {
            return (FILL_TYPE)Enum.valueOf(com/socialin/android/photo/select/SelectionDrawController$FILL_TYPE, s1);
        }

        public static FILL_TYPE[] values()
        {
            return (FILL_TYPE[])$VALUES.clone();
        }

        static 
        {
            ADD = new FILL_TYPE("ADD", 0);
            CLEAR = new FILL_TYPE("CLEAR", 1);
            DEFAULT = new FILL_TYPE("DEFAULT", 2);
            $VALUES = (new FILL_TYPE[] {
                ADD, CLEAR, DEFAULT
            });
        }

        private FILL_TYPE(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
