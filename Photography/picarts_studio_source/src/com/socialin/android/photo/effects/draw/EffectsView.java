// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.effects.draw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.picsart.effectnew.EffectsDrawController;
import com.picsart.effectnew.MaskBrushNew;
import com.picsart.effectnew.RectangleF;
import com.picsart.studio.EditingData;
import myobfuscated.ay.c;
import myobfuscated.bw.a;
import myobfuscated.bw.d;
import myobfuscated.bw.e;
import myobfuscated.dc.b;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.photo.effects.draw:
//            a, b

public class EffectsView extends View
{

    private RectF a;
    private RectangleF b;
    private Rect c;
    private Bitmap d;
    private boolean e;
    private int f;
    private int g;
    private float h;
    private float i;
    private Paint j;
    private a k;
    private com.socialin.android.photo.effects.draw.a l;
    private EditingData m;

    public EffectsView(Context context)
    {
        super(context);
        a = new RectF();
        b = new RectangleF();
        c = new Rect();
        e = false;
        f = 0;
        g = 0;
        h = 0.7F;
        i = 5F;
        j = new Paint(2);
    }

    public EffectsView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = new RectF();
        b = new RectangleF();
        c = new Rect();
        e = false;
        f = 0;
        g = 0;
        h = 0.7F;
        i = 5F;
        j = new Paint(2);
    }

    public EffectsView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        a = new RectF();
        b = new RectangleF();
        c = new Rect();
        e = false;
        f = 0;
        g = 0;
        h = 0.7F;
        i = 5F;
        j = new Paint(2);
    }

    static com.socialin.android.photo.effects.draw.a a(EffectsView effectsview)
    {
        return effectsview.l;
    }

    public final boolean a(MotionEvent motionevent)
    {
        int i1 = 0;
        if (!e) goto _L2; else goto _L1
_L1:
        float f1;
        if (l != null)
        {
            l.c.q();
        }
        f1 = h;
        if (l == null);
        if (!myobfuscated.dc.b.a().a(motionevent, b, a, i, f1)) goto _L4; else goto _L3
_L3:
        if (l != null)
        {
            com.socialin.android.photo.effects.draw.a a1 = l;
            a1.c(false);
            if (a1.d)
            {
                a1.c.o();
                a1.d = false;
                a1.e = false;
            }
            if (a1.o != null)
            {
                a1.o.o = myobfuscated.ay.b.n;
                a1.o.c(a1.l);
            }
            i1 = motionevent.getAction() & 0xff;
            if ((i1 == 6 || i1 == 1) && motionevent.getPointerCount() == 1 && a1.n.a() != null && a1.o != null && a1.o.e)
            {
                a1.o.a(a1.l);
            }
            l.c.r();
        }
        invalidate();
_L2:
        return true;
_L4:
        com.socialin.android.photo.effects.draw.a a2;
        if (3 == motionevent.getAction() || 1 == motionevent.getAction())
        {
            EditingData editingdata = m;
            editingdata.d = editingdata.d + 1;
        }
        if (l == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        a2 = l;
        if (!a2.i)
        {
            break; /* Loop/switch isn't completed */
        }
        float f2 = motionevent.getX();
        float f7 = motionevent.getY();
        float f12;
        switch (motionevent.getAction())
        {
        case 1: // '\001'
        default:
            return true;

        case 0: // '\0'
            a2.b.set(f2, f7);
            return true;

        case 2: // '\002'
            f12 = f2 - a2.b.x;
            break;
        }
        float f15 = f7 - a2.b.y;
        a2.c.q();
        if (Math.sqrt(f12 * f12 + f15 * f15) >= (double)a2.g)
        {
            motionevent = a2.l;
            motionevent.left = ((RectangleF) (motionevent)).left + f12;
            motionevent = a2.l;
            motionevent.right = f12 + ((RectangleF) (motionevent)).right;
            motionevent = a2.l;
            motionevent.top = ((RectangleF) (motionevent)).top + f15;
            motionevent = a2.l;
            motionevent.bottom = f15 + ((RectangleF) (motionevent)).bottom;
            a2.b.set(f2, f7);
            a2.c.r();
            a2.e();
            return true;
        }
        if (true) goto _L2; else goto _L5
_L5:
        if (a2.t)
        {
            a2.v.x = motionevent.getX();
            a2.v.y = motionevent.getY();
            a2.u = true;
        }
        switch (motionevent.getAction())
        {
        default:
            return true;

        case 0: // '\0'
            a2.c.a(motionevent.getX(), motionevent.getY());
            float f3 = motionevent.getX();
            float f8 = motionevent.getY();
            a2.b.set(f3, f8);
            a2.d = true;
            a2.e = false;
            if (a2.o != null && a2.o.e)
            {
                myobfuscated.ay.b b1 = a2.o;
                float f4 = motionevent.getX();
                float f9 = motionevent.getY();
                if (Math.sqrt(Math.pow(b1.g - f4, 2D) + Math.pow(b1.h - f9, 2D)) <= (double)b1.o)
                {
                    b1.d = true;
                    b1.b = f4;
                    b1.c = f9;
                    i1 = 1;
                }
                if (i1 != 0)
                {
                    a2.b(true);
                    return true;
                }
            }
            break;

        case 2: // '\002'
            if (a2.d)
            {
                if (a2.o != null && a2.o.e)
                {
                    myobfuscated.ay.b b2 = a2.o;
                    float f16 = motionevent.getX();
                    float f18 = motionevent.getY();
                    RectangleF rectanglef = a2.l;
                    boolean flag;
                    if (b2.d)
                    {
                        float f10 = f16 - b2.b;
                        float f5 = f18 - b2.c;
                        if (Math.abs(f10) >= 3F || Math.abs(f5) > 3F)
                        {
                            f10 += b2.g;
                            float f13 = f5 + b2.h;
                            if (f10 < ((RectF) (rectanglef)).left)
                            {
                                f5 = ((RectF) (rectanglef)).left;
                            } else
                            {
                                f5 = f10;
                                if (f10 > ((RectF) (rectanglef)).right)
                                {
                                    f5 = ((RectF) (rectanglef)).right;
                                }
                            }
                            if (f13 < ((RectF) (rectanglef)).top)
                            {
                                f10 = ((RectF) (rectanglef)).top;
                            } else
                            {
                                f10 = f13;
                                if (f13 > ((RectF) (rectanglef)).bottom)
                                {
                                    f10 = ((RectF) (rectanglef)).bottom;
                                }
                            }
                            b2.g = f5;
                            b2.h = f10;
                            b2.b(rectanglef);
                            f5 = b2.i / b2.k;
                            f10 = b2.j / b2.l;
                            if (b2.a != null)
                            {
                                b2.a.b((int)(f5 * 100F), (int)(f10 * 100F));
                            }
                            b2.b = f16;
                            b2.c = f18;
                        }
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (flag)
                    {
                        a2.e();
                        return true;
                    }
                }
                float f6 = motionevent.getX();
                float f11 = motionevent.getY();
                float f14 = f6 - a2.b.x;
                float f17 = f11 - a2.b.y;
                if (!a2.e && Math.abs(Math.sqrt(f14 * f14 + f17 * f17)) >= (double)a2.f)
                {
                    a2.c.b(a2.b.x, a2.b.y);
                    a2.e = true;
                }
                if (a2.e && Math.abs(Math.sqrt(f14 * f14 + f17 * f17)) >= (double)a2.g)
                {
                    a2.c.c(f6, f11);
                    a2.e = true;
                    a2.b.set(f6, f11);
                    return true;
                }
            }
            break;

        case 1: // '\001'
        case 3: // '\003'
            a2.d();
            return true;
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    protected void onDraw(Canvas canvas)
    {
        Object obj;
        Object obj1;
        super.onDraw(canvas);
        obj = d;
        boolean flag;
        if (obj != null && !((Bitmap) (obj)).isRecycled())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        if (l == null)
        {
            break MISSING_BLOCK_LABEL_308;
        }
        obj = l;
        obj1 = c;
        if (((com.socialin.android.photo.effects.draw.a) (obj)).n == null) goto _L2; else goto _L3
_L3:
        if (!((com.socialin.android.photo.effects.draw.a) (obj)).y) goto _L5; else goto _L4
_L4:
        canvas.drawBitmap(((com.socialin.android.photo.effects.draw.a) (obj)).h, ((com.socialin.android.photo.effects.draw.a) (obj)).j, ((com.socialin.android.photo.effects.draw.a) (obj)).l, ((com.socialin.android.photo.effects.draw.a) (obj)).s);
_L2:
        return;
_L5:
        myobfuscated.au.b b1 = ((com.socialin.android.photo.effects.draw.a) (obj)).n.a();
        if (b1 == null || ((com.socialin.android.photo.effects.draw.a) (obj)).n.c() || !((com.socialin.android.photo.effects.draw.a) (obj)).o.d && !((com.socialin.android.photo.effects.draw.a) (obj)).c.o && !((com.socialin.android.photo.effects.draw.a) (obj)).n.d() && !b1.f)
        {
            break; /* Loop/switch isn't completed */
        }
        b1.a(canvas, ((com.socialin.android.photo.effects.draw.a) (obj)).h, ((com.socialin.android.photo.effects.draw.a) (obj)).l, ((com.socialin.android.photo.effects.draw.a) (obj)).k);
        if (((com.socialin.android.photo.effects.draw.a) (obj)).o.e)
        {
            ((com.socialin.android.photo.effects.draw.a) (obj)).o.a(canvas);
            return;
        }
        if (true) goto _L2; else goto _L6
_L6:
        ((com.socialin.android.photo.effects.draw.a) (obj)).c.a(canvas, ((Rect) (obj1)));
        if (((com.socialin.android.photo.effects.draw.a) (obj)).o != null && ((com.socialin.android.photo.effects.draw.a) (obj)).o.e)
        {
            ((com.socialin.android.photo.effects.draw.a) (obj)).o.a(canvas);
        }
        if (!((com.socialin.android.photo.effects.draw.a) (obj)).u || ((com.socialin.android.photo.effects.draw.a) (obj)).c.m != com.picsart.effectnew.EffectsDrawController.EffectsDrawMode.BRUSH) goto _L2; else goto _L7
_L7:
        obj1 = ((com.socialin.android.photo.effects.draw.a) (obj)).b();
        if (((MaskBrushNew) (obj1)).v != com.picsart.effectnew.MaskBrushNew.BrushDrawMode.ERASE) goto _L2; else goto _L8
_L8:
        float f1 = ((MaskBrushNew) (obj1)).f.getStrokeWidth();
        f1 = (((MaskBrushNew) (obj1)).d + f1) / 2.0F;
        canvas.drawCircle(((com.socialin.android.photo.effects.draw.a) (obj)).v.x, ((com.socialin.android.photo.effects.draw.a) (obj)).v.y, f1, ((com.socialin.android.photo.effects.draw.a) (obj)).w);
        return;
        canvas.drawBitmap(d, c, b, j);
        return;
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        if (l != null)
        {
            com.socialin.android.photo.effects.draw.a a1 = l;
            if (a1.d)
            {
                a1.c.p();
                a1.d = false;
                a1.e = false;
            }
        }
        setWithOrientationDefaultSize(i1, j1);
    }

    public void setDrawController(com.socialin.android.photo.effects.draw.a a1)
    {
        l = a1;
        a1.a = this;
        a1.c.c = this;
    }

    public void setEditingData(EditingData editingdata)
    {
        m = editingdata;
    }

    public void setOrigBitmap(Bitmap bitmap)
    {
        d = bitmap;
        if (d != null && !d.isRecycled())
        {
            f = bitmap.getWidth();
            g = bitmap.getHeight();
            setWithOrientationDefaultSize(getWidth(), getHeight());
        }
    }

    public void setWithOrientationDefaultSize(int i1, int j1)
    {
        if (d != null && !d.isRecycled() && i1 > 0 && j1 > 0)
        {
            float f1;
            int k1;
            int l1;
            int i2;
            int j2;
            boolean flag;
            if (l != null)
            {
                boolean flag1 = l.m;
                flag = flag1;
                if (flag1)
                {
                    l.c.q();
                    flag = flag1;
                }
            } else
            {
                flag = false;
            }
            f1 = Math.min((float)i1 / (float)f, (float)j1 / (float)g);
            k1 = Math.round((float)f * f1);
            l1 = Math.round(f1 * (float)g);
            i2 = (i1 - k1) / 2;
            j2 = (j1 - l1) / 2;
            c.set(0, 0, f, g);
            b.set(i2, j2, i2 + k1, j2 + l1);
            a.set(b);
            e = true;
            i = Math.max((float)i1 / (float)k1, (float)j1 / (float)l1) * 1.2F;
            i = Math.max(i, 5F);
            if (l != null)
            {
                Object obj1 = l;
                Object obj = b;
                obj1.l = ((RectangleF) (obj));
                ((com.socialin.android.photo.effects.draw.a) (obj1)).c.a = ((RectF) (obj));
                obj1.m = true;
                if (((com.socialin.android.photo.effects.draw.a) (obj1)).o != null)
                {
                    obj1 = ((com.socialin.android.photo.effects.draw.a) (obj1)).o;
                    if (((myobfuscated.ay.b) (obj1)).p != null && !((myobfuscated.ay.b) (obj1)).d)
                    {
                        ((myobfuscated.ay.b) (obj1)).b(((myobfuscated.ay.b) (obj1)).p);
                    }
                    obj1.d = false;
                    obj1.p = ((RectF) (obj));
                    if (((myobfuscated.ay.b) (obj1)).p != null)
                    {
                        ((myobfuscated.ay.b) (obj1)).c(((myobfuscated.ay.b) (obj1)).p);
                    }
                }
                obj = l;
                obj1 = a;
                ((com.socialin.android.photo.effects.draw.a) (obj)).c.b = ((RectF) (obj1));
                l.q = i;
                obj = l.c;
                if (obj != null)
                {
                    ((EffectsDrawController) (obj)).a(a.width());
                }
                if (flag)
                {
                    l.c.r();
                }
            }
            invalidate();
        }
    }

    public void setupSpenTouch()
    {
        k = myobfuscated.f.m.f();
        k.a(this, new e() {

            private EffectsView a;

            public final boolean a(MotionEvent motionevent)
            {
                if (com.socialin.android.photo.effects.draw.EffectsView.a(a) != null)
                {
                    com.socialin.android.photo.effects.draw.EffectsView.a(a).t = false;
                }
                a.a(motionevent);
                return true;
            }

            public final boolean b(MotionEvent motionevent)
            {
                if (com.socialin.android.photo.effects.draw.EffectsView.a(a) != null)
                {
                    com.socialin.android.photo.effects.draw.EffectsView.a(a).t = true;
                }
                return a.a(motionevent);
            }

            public final boolean c(MotionEvent motionevent)
            {
                com.socialin.android.photo.effects.draw.a a1;
                if (com.socialin.android.photo.effects.draw.EffectsView.a(a) != null)
                {
                    com.socialin.android.photo.effects.draw.EffectsView.a(a).t = true;
                    if (com.socialin.android.photo.effects.draw.EffectsView.a(a).b().v == com.picsart.effectnew.MaskBrushNew.BrushDrawMode.DRAW)
                    {
                        a1 = com.socialin.android.photo.effects.draw.EffectsView.a(a);
                        break MISSING_BLOCK_LABEL_48;
                    }
                }
_L1:
                return a.a(motionevent);
                if ((a1.n == null || !a1.e && !a1.n.e() && !a1.i && (!a1.n.e() || !a1.n.f()) && a1.c.m == com.picsart.effectnew.EffectsDrawController.EffectsDrawMode.BRUSH) && a1.c.m == com.picsart.effectnew.EffectsDrawController.EffectsDrawMode.BRUSH && a1.n != null)
                {
                    a1.n.h();
                }
                  goto _L1
            }

            public final void d(MotionEvent motionevent)
            {
                if (com.socialin.android.photo.effects.draw.EffectsView.a(a) != null)
                {
                    com.socialin.android.photo.effects.draw.EffectsView.a(a).f();
                }
            }

            
            {
                a = EffectsView.this;
                super();
            }
        });
        if (myobfuscated.bw.a.a())
        {
            k.a(this, new d() {

                private EffectsView a;

                public final void a()
                {
                    if (com.socialin.android.photo.effects.draw.EffectsView.a(a) != null)
                    {
                        com.socialin.android.photo.effects.draw.EffectsView.a(a).f();
                    }
                }

                public final boolean a(View view, MotionEvent motionevent)
                {
                    if (com.socialin.android.photo.effects.draw.EffectsView.a(a) == null)
                    {
                        return false;
                    }
                    view = com.socialin.android.photo.effects.draw.EffectsView.a(a);
                    if (motionevent.getAction() != 10 && !((com.socialin.android.photo.effects.draw.a) (view)).n.e() && !((com.socialin.android.photo.effects.draw.a) (view)).i && (!((com.socialin.android.photo.effects.draw.a) (view)).n.e() || !((com.socialin.android.photo.effects.draw.a) (view)).n.f()) && ((com.socialin.android.photo.effects.draw.a) (view)).c.m == com.picsart.effectnew.EffectsDrawController.EffectsDrawMode.BRUSH)
                    {
                        view.t = true;
                        view.c(true);
                        float f1 = motionevent.getX();
                        float f2 = motionevent.getY();
                        ((com.socialin.android.photo.effects.draw.a) (view)).v.x = f1;
                        ((com.socialin.android.photo.effects.draw.a) (view)).v.y = f2;
                    } else
                    {
                        view.t = true;
                        view.c(false);
                    }
                    view.e();
                    return false;
                }

            
            {
                a = EffectsView.this;
                super();
            }
            });
        }
    }
}
