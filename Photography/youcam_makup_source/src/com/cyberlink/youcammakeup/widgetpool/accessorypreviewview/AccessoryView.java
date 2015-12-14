// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.accessorypreviewview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.jniproxy.bi;
import com.cyberlink.youcammakeup.kernelctrl.VenusHelper;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.t;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.aa;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel;
import com.cyberlink.youcammakeup.widgetpool.wigpreviewview.a;
import com.cyberlink.youcammakeup.widgetpool.wigpreviewview.b;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.accessorypreviewview:
//            d, AccessoryDrawingCtrl

public class AccessoryView extends View
    implements android.view.View.OnTouchListener
{

    public static final int a;
    private RectF b;
    private RectF c;
    private Bitmap d;
    private Bitmap e;
    private Bitmap f;
    private Map g;
    private d h;
    private List i;
    private ImageViewer j;
    private BeautyToolPanel k;
    private t l;
    private a m;
    private Animator n;
    private boolean o;

    public AccessoryView(Context context)
    {
        super(context);
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        n = null;
        o = false;
        e();
    }

    public AccessoryView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        n = null;
        o = false;
        e();
    }

    private void a(Canvas canvas)
    {
        canvas.save();
        canvas.clipRect(b);
        canvas.translate(b.left, b.top);
        for (Iterator iterator = g.entrySet().iterator(); iterator.hasNext(); ((d)((java.util.Map.Entry)iterator.next()).getValue()).a(canvas)) { }
        canvas.restore();
    }

    private void a(MotionEvent motionevent)
    {
        com.pf.common.utility.m.b("AccessoryView", "onSingleTapConfirmed");
        float f1 = motionevent.getX() - b.left;
        float f2 = motionevent.getY() - b.top;
        if (StatusManager.j().s() == BeautyMode.C)
        {
            Iterator iterator;
            boolean flag;
            boolean flag1;
            if (i == null)
            {
                a(false);
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            motionevent = new HashMap();
            iterator = i.iterator();
            flag = false;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                d d1 = (d)iterator.next();
                if (d1 != null)
                {
                    motionevent.put(d1.d(), Boolean.valueOf(false));
                    if (d1.f(f1, f2) && d1.b())
                    {
                        motionevent.put(d1.d(), Boolean.valueOf(true));
                        a(d1);
                    } else
                    if (d1.g(f1, f2) && d1.b())
                    {
                        motionevent.put(d1.d(), Boolean.valueOf(true));
                        b(d1);
                        flag = true;
                    } else
                    if (d1.d(f1, f2) && !f(d1.d()))
                    {
                        motionevent.put(d1.d(), Boolean.valueOf(true));
                    }
                }
            } while (true);
            if (motionevent.containsValue(Boolean.valueOf(true)))
            {
                Iterator iterator1 = motionevent.keySet().iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    AccessoryDrawingCtrl.AccessoryType accessorytype = (AccessoryDrawingCtrl.AccessoryType)iterator1.next();
                    if (!((Boolean)motionevent.get(accessorytype)).booleanValue())
                    {
                        if (!flag)
                        {
                            a(accessorytype);
                        }
                    } else
                    if (!f(accessorytype))
                    {
                        b(accessorytype);
                    }
                } while (true);
            } else
            if (!flag1)
            {
                b();
            }
            return;
        }
        if (h == null)
        {
            a(false);
            return;
        }
        if (h.f(f1, f2))
        {
            a(h);
            return;
        }
        if (h.g(f1, f2))
        {
            b(h);
            return;
        } else
        {
            b();
            return;
        }
    }

    private void a(t t1, d d1)
    {
        Object obj = d1.d();
        Bitmap bitmap = c(((AccessoryDrawingCtrl.AccessoryType) (obj)));
        if (!aa.b(bitmap))
        {
            com.pf.common.utility.m.d("updateRenderer(CurViewInfo, AccessoryRenderer)", "accessoryBitmap is invalid.");
        } else
        {
            bi bi1 = d(((AccessoryDrawingCtrl.AccessoryType) (obj)));
            if (bi1 == null)
            {
                com.pf.common.utility.m.d("updateRenderer(CurViewInfo, AccessoryRenderer)", "transform is null.");
                return;
            }
            obj = com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.a(((AccessoryDrawingCtrl.AccessoryType) (obj)));
            ((AccessoryDrawingCtrl) (obj)).a(t1, bitmap, bi1);
            t1 = ((AccessoryDrawingCtrl) (obj)).a((float)getWidth() / 2.0F, (float)getHeight() / 2.0F);
            float f1 = ((RectF) (t1)).left;
            float f2 = ((RectF) (t1)).top;
            float f3 = t1.width();
            float f4 = t1.height();
            float f5 = (float)Math.toDegrees(bi1.c());
            d1.a(f1, f2);
            d1.b(f3, f4);
            d1.c(f3, f4);
            d1.a(((AccessoryDrawingCtrl) (obj)).k() + f5);
            d1.b(f5);
            o = true;
            if (!t1.equals(((AccessoryDrawingCtrl) (obj)).p()) || f5 != ((AccessoryDrawingCtrl) (obj)).q())
            {
                ((AccessoryDrawingCtrl) (obj)).a(t1);
                ((AccessoryDrawingCtrl) (obj)).c(f5);
                invalidate();
                return;
            }
        }
    }

    private void a(AccessoryDrawingCtrl.AccessoryType accessorytype, String s, boolean flag)
    {
        class _cls2
        {

            static final int a[];

            static 
            {
                a = new int[AccessoryDrawingCtrl.AccessoryType.values().length];
                try
                {
                    a[com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[AccessoryDrawingCtrl.AccessoryType.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[AccessoryDrawingCtrl.AccessoryType.d.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[AccessoryDrawingCtrl.AccessoryType.e.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (com.cyberlink.youcammakeup.widgetpool.accessorypreviewview._cls2.a[accessorytype.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            VenusHelper.a().n();
            MotionControlHelper.e().d(s, flag);
            return;

        case 2: // '\002'
            VenusHelper.a().r();
            MotionControlHelper.e().e(s, flag);
            return;

        case 3: // '\003'
            VenusHelper.a().v();
            MotionControlHelper.e().h(flag);
            return;

        case 4: // '\004'
            VenusHelper.a().z();
            accessorytype = MotionControlHelper.z(s);
            MotionControlHelper.e().f(accessorytype, flag);
            return;

        case 5: // '\005'
            VenusHelper.a().A();
            break;
        }
        accessorytype = MotionControlHelper.z(s);
        MotionControlHelper.e().g(accessorytype, flag);
    }

    static void a(AccessoryView accessoryview, MotionEvent motionevent)
    {
        accessoryview.a(motionevent);
    }

    private void a(d d1)
    {
        String s;
        for (s = StatusManager.j().e(); s == null || d1 == null;)
        {
            return;
        }

        d1 = d1.d();
        boolean flag;
        if (!a(((AccessoryDrawingCtrl.AccessoryType) (d1)), s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a(((AccessoryDrawingCtrl.AccessoryType) (d1)), s, flag);
    }

    private boolean a(AccessoryDrawingCtrl.AccessoryType accessorytype, String s)
    {
        switch (com.cyberlink.youcammakeup.widgetpool.accessorypreviewview._cls2.a[accessorytype.ordinal()])
        {
        default:
            return false;

        case 1: // '\001'
            return MotionControlHelper.e().q(s);

        case 2: // '\002'
            return MotionControlHelper.e().r(s);

        case 3: // '\003'
            return MotionControlHelper.e().ai();

        case 4: // '\004'
            return MotionControlHelper.e().s(s);

        case 5: // '\005'
            return MotionControlHelper.e().t(s);
        }
    }

    private void b(Canvas canvas, t t1)
    {
        canvas.save();
        canvas.translate((float)getWidth() / 2.0F, (float)getHeight() / 2.0F);
        if (h == null || !h.b())
        {
            canvas.clipRect(t1.g);
        }
        canvas.save();
        Object obj = VenusHelper.a().b;
        obj;
        JVM INSTR monitorenter ;
        Bitmap bitmap = VenusHelper.a().m();
        if (aa.b(bitmap)) goto _L2; else goto _L1
_L1:
        com.pf.common.utility.m.b("renderEyeWear(Canvas)", "eyeWearBitmap is invalid.");
_L11:
        canvas.restore();
        canvas.save();
        obj = VenusHelper.a().c;
        obj;
        JVM INSTR monitorenter ;
        bitmap = VenusHelper.a().q();
        if (aa.b(bitmap)) goto _L4; else goto _L3
_L3:
        com.pf.common.utility.m.b("renderHairBand(Canvas)", "hairBandBitmap is invalid.");
_L14:
        canvas.restore();
        canvas.save();
        obj = VenusHelper.a().d;
        obj;
        JVM INSTR monitorenter ;
        bitmap = VenusHelper.a().u();
        if (aa.b(bitmap)) goto _L6; else goto _L5
_L5:
        com.pf.common.utility.m.b("renderNecklace(Canvas)", "necklaceBitmap is invalid.");
_L17:
        canvas.restore();
        canvas.save();
        obj = VenusHelper.a().e;
        obj;
        JVM INSTR monitorenter ;
        bitmap = VenusHelper.a().x();
        if (aa.b(bitmap)) goto _L8; else goto _L7
_L7:
        com.pf.common.utility.m.b("renderEarrings(Canvas)", "earringsBitmap is invalid.");
_L20:
        canvas.restore();
        canvas.save();
        obj = VenusHelper.a().f;
        obj;
        JVM INSTR monitorenter ;
        bitmap = VenusHelper.a().y();
        if (aa.b(bitmap)) goto _L10; else goto _L9
_L9:
        com.pf.common.utility.m.b("renderEarrings(Canvas)", "earringsBitmap is invalid.");
_L23:
        canvas.restore();
        canvas.restore();
        return;
_L2:
        if (aa.b(bitmap))
        {
            break MISSING_BLOCK_LABEL_312;
        }
        com.pf.common.utility.m.b("renderEyeWear(Canvas)", "eyeWearBitmap is invalid.");
        obj;
        JVM INSTR monitorexit ;
          goto _L11
        canvas;
        obj;
        JVM INSTR monitorexit ;
        throw canvas;
        bi bi1 = VenusHelper.a().l();
        if (bi1 != null) goto _L13; else goto _L12
_L12:
        com.pf.common.utility.m.b("renderEyeWear(Canvas)", "transform is null.");
        obj;
        JVM INSTR monitorexit ;
          goto _L11
_L13:
        AccessoryDrawingCtrl accessorydrawingctrl = com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.b(BeautyMode.z);
        accessorydrawingctrl.a(t1, bitmap, bi1);
        canvas.translate(accessorydrawingctrl.a(), accessorydrawingctrl.b());
        canvas.scale(accessorydrawingctrl.c(), accessorydrawingctrl.c());
        canvas.rotate((float)accessorydrawingctrl.d());
        canvas.drawBitmap(bitmap, null, accessorydrawingctrl.e(), accessorydrawingctrl.a);
        obj;
        JVM INSTR monitorexit ;
          goto _L11
_L4:
        if (aa.b(bitmap))
        {
            break MISSING_BLOCK_LABEL_446;
        }
        com.pf.common.utility.m.b("renderHairBand(Canvas)", "hairBandBitmap is invalid.");
        obj;
        JVM INSTR monitorexit ;
          goto _L14
        canvas;
        obj;
        JVM INSTR monitorexit ;
        throw canvas;
        bi1 = VenusHelper.a().p();
        if (bi1 != null) goto _L16; else goto _L15
_L15:
        com.pf.common.utility.m.b("renderHairBand(Canvas)", "hairBandBitmap is null.");
        obj;
        JVM INSTR monitorexit ;
          goto _L14
_L16:
        AccessoryDrawingCtrl accessorydrawingctrl1 = com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.b(BeautyMode.A);
        accessorydrawingctrl1.a(t1, bitmap, bi1);
        canvas.translate(accessorydrawingctrl1.a(), accessorydrawingctrl1.b());
        canvas.scale(accessorydrawingctrl1.c(), accessorydrawingctrl1.c());
        canvas.rotate((float)accessorydrawingctrl1.d());
        canvas.drawBitmap(bitmap, null, accessorydrawingctrl1.e(), accessorydrawingctrl1.a);
        obj;
        JVM INSTR monitorexit ;
          goto _L14
_L6:
        if (aa.b(bitmap))
        {
            break MISSING_BLOCK_LABEL_580;
        }
        com.pf.common.utility.m.b("renderNecklace(Canvas)", "necklaceBitmap is invalid.");
        obj;
        JVM INSTR monitorexit ;
          goto _L17
        canvas;
        obj;
        JVM INSTR monitorexit ;
        throw canvas;
        bi1 = VenusHelper.a().t();
        if (bi1 != null) goto _L19; else goto _L18
_L18:
        com.pf.common.utility.m.b("renderNecklace(Canvas)", "necklaceBitmap is null.");
        obj;
        JVM INSTR monitorexit ;
          goto _L17
_L19:
        AccessoryDrawingCtrl accessorydrawingctrl2 = com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.b(BeautyMode.B);
        accessorydrawingctrl2.a(t1, bitmap, bi1);
        canvas.translate(accessorydrawingctrl2.a(), accessorydrawingctrl2.b());
        canvas.scale(accessorydrawingctrl2.c(), accessorydrawingctrl2.c());
        canvas.rotate((float)accessorydrawingctrl2.d());
        canvas.drawBitmap(bitmap, null, accessorydrawingctrl2.e(), accessorydrawingctrl2.a);
        obj;
        JVM INSTR monitorexit ;
          goto _L17
_L8:
        if (aa.b(bitmap))
        {
            break MISSING_BLOCK_LABEL_714;
        }
        com.pf.common.utility.m.b("renderEarrings(Canvas)", "earringsBitmap is invalid.");
        obj;
        JVM INSTR monitorexit ;
          goto _L20
        canvas;
        obj;
        JVM INSTR monitorexit ;
        throw canvas;
        Object obj1;
        obj1 = AccessoryDrawingCtrl.AccessoryType.d;
        bi1 = VenusHelper.a().a(((AccessoryDrawingCtrl.AccessoryType) (obj1)));
        if (bi1 != null) goto _L22; else goto _L21
_L21:
        com.pf.common.utility.m.b("renderEarrings(Canvas)", "transform is null.");
        obj;
        JVM INSTR monitorexit ;
          goto _L20
_L22:
        obj1 = com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.a(((AccessoryDrawingCtrl.AccessoryType) (obj1)));
        ((AccessoryDrawingCtrl) (obj1)).a(t1, bitmap, bi1);
        canvas.translate(((AccessoryDrawingCtrl) (obj1)).a(), ((AccessoryDrawingCtrl) (obj1)).b());
        canvas.scale(((AccessoryDrawingCtrl) (obj1)).c(), ((AccessoryDrawingCtrl) (obj1)).c());
        canvas.rotate((float)((AccessoryDrawingCtrl) (obj1)).d());
        canvas.drawBitmap(bitmap, null, ((AccessoryDrawingCtrl) (obj1)).e(), ((AccessoryDrawingCtrl) (obj1)).a);
        obj;
        JVM INSTR monitorexit ;
          goto _L20
_L10:
        if (aa.b(bitmap))
        {
            break MISSING_BLOCK_LABEL_854;
        }
        com.pf.common.utility.m.b("renderEarrings(Canvas)", "earringsBitmap is invalid.");
        obj;
        JVM INSTR monitorexit ;
          goto _L23
        canvas;
        obj;
        JVM INSTR monitorexit ;
        throw canvas;
        obj1 = AccessoryDrawingCtrl.AccessoryType.e;
        bi1 = VenusHelper.a().a(((AccessoryDrawingCtrl.AccessoryType) (obj1)));
        if (bi1 != null) goto _L25; else goto _L24
_L24:
        com.pf.common.utility.m.b("renderEarrings(Canvas)", "transform is null.");
        obj;
        JVM INSTR monitorexit ;
          goto _L23
_L25:
        obj1 = com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.a(((AccessoryDrawingCtrl.AccessoryType) (obj1)));
        ((AccessoryDrawingCtrl) (obj1)).a(t1, bitmap, bi1);
        canvas.translate(((AccessoryDrawingCtrl) (obj1)).a(), ((AccessoryDrawingCtrl) (obj1)).b());
        canvas.scale(((AccessoryDrawingCtrl) (obj1)).c(), ((AccessoryDrawingCtrl) (obj1)).c());
        canvas.rotate((float)((AccessoryDrawingCtrl) (obj1)).d());
        canvas.drawBitmap(bitmap, null, ((AccessoryDrawingCtrl) (obj1)).e(), ((AccessoryDrawingCtrl) (obj1)).a);
        obj;
        JVM INSTR monitorexit ;
          goto _L23
    }

    private void b(d d1)
    {
        if (d1 != null)
        {
            d1 = d1.d();
            e(d1);
            if (k != null)
            {
                if (d1 != AccessoryDrawingCtrl.AccessoryType.d && d1 != AccessoryDrawingCtrl.AccessoryType.e)
                {
                    k.n();
                    return;
                }
                if ((d1 == AccessoryDrawingCtrl.AccessoryType.d || d1 == AccessoryDrawingCtrl.AccessoryType.e) && VenusHelper.a().D() && VenusHelper.a().E())
                {
                    k.n();
                    return;
                }
            }
        }
    }

    private Bitmap c(AccessoryDrawingCtrl.AccessoryType accessorytype)
    {
        switch (com.cyberlink.youcammakeup.widgetpool.accessorypreviewview._cls2.a[accessorytype.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return VenusHelper.a().m();

        case 2: // '\002'
            return VenusHelper.a().q();

        case 3: // '\003'
            return VenusHelper.a().u();

        case 4: // '\004'
            return VenusHelper.a().x();

        case 5: // '\005'
            return VenusHelper.a().y();
        }
    }

    private bi d(AccessoryDrawingCtrl.AccessoryType accessorytype)
    {
        switch (com.cyberlink.youcammakeup.widgetpool.accessorypreviewview._cls2.a[accessorytype.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return VenusHelper.a().l();

        case 2: // '\002'
            return VenusHelper.a().p();

        case 3: // '\003'
            return VenusHelper.a().t();

        case 4: // '\004'
            return VenusHelper.a().a(AccessoryDrawingCtrl.AccessoryType.d);

        case 5: // '\005'
            return VenusHelper.a().a(AccessoryDrawingCtrl.AccessoryType.e);
        }
    }

    private void e()
    {
        if (isInEditMode())
        {
            return;
        } else
        {
            b = new RectF();
            c = new RectF();
            g = new LinkedHashMap();
            d = aa.a(getResources(), 0x7f020727);
            e = aa.a(getResources(), 0x7f020702);
            f = aa.a(getResources(), 0x7f0206f6);
            m = new a(getResources());
            m.a(new b() {

                final AccessoryView a;

                public void a(MotionEvent motionevent)
                {
                    com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryView.a(a, motionevent);
                }

            
            {
                a = AccessoryView.this;
                super();
            }
            });
            setOnTouchListener(this);
            return;
        }
    }

    private void e(AccessoryDrawingCtrl.AccessoryType accessorytype)
    {
        switch (com.cyberlink.youcammakeup.widgetpool.accessorypreviewview._cls2.a[accessorytype.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            VenusHelper.a().o();
            StatusManager.j().a("default_original_eye_wear", false, new Float[0]);
            return;

        case 2: // '\002'
            VenusHelper.a().s();
            StatusManager.j().a("default_original_hair_band", false, new Float[0]);
            return;

        case 3: // '\003'
            VenusHelper.a().w();
            StatusManager.j().a("default_original_necklace", false, new Float[0]);
            return;

        case 4: // '\004'
            MotionControlHelper.e().h(MotionControlHelper.z(StatusManager.j().e()), false);
            VenusHelper.a().B();
            if (VenusHelper.a().D() && VenusHelper.a().E())
            {
                StatusManager.j().a("default_original_earrings", false, new Float[0]);
                return;
            } else
            {
                a(accessorytype);
                return;
            }

        case 5: // '\005'
            MotionControlHelper.e().i(MotionControlHelper.z(StatusManager.j().e()), false);
            VenusHelper.a().C();
            break;
        }
        if (VenusHelper.a().D() && VenusHelper.a().E())
        {
            StatusManager.j().a("default_original_earrings", false, new Float[0]);
            return;
        } else
        {
            a(accessorytype);
            return;
        }
    }

    private void f()
    {
        com.pf.common.utility.m.b("AccessoryView", "AccessoryView calculateContentPosition");
        if (getWidth() <= 0 || getHeight() <= 0)
        {
            com.pf.common.utility.m.e("AccessoryView", "calculateContentPosition() some parameter is <= 0.");
            return;
        } else
        {
            float f1 = ((float)getWidth() * 128F) / 1080F;
            b.set(0.0F, 0.0F, getWidth(), getHeight());
            c.set(a, a, b.width() - (float)a, b.height() - (float)a - f1);
            c.sort();
            invalidate();
            return;
        }
    }

    private boolean f(AccessoryDrawingCtrl.AccessoryType accessorytype)
    {
        switch (com.cyberlink.youcammakeup.widgetpool.accessorypreviewview._cls2.a[accessorytype.ordinal()])
        {
        default:
            return false;

        case 4: // '\004'
            return VenusHelper.a().D();

        case 5: // '\005'
            return VenusHelper.a().E();
        }
    }

    private d getCurrentAccessory()
    {
        AccessoryDrawingCtrl.AccessoryType accessorytype = (AccessoryDrawingCtrl.AccessoryType)com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.a(StatusManager.j().s()).get(0);
        return (d)g.get(accessorytype);
    }

    private List getCurrentAccessoryList()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.a(StatusManager.j().s()).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            AccessoryDrawingCtrl.AccessoryType accessorytype = (AccessoryDrawingCtrl.AccessoryType)iterator.next();
            if (g.containsKey(accessorytype))
            {
                arraylist.add(g.get(accessorytype));
            }
        } while (true);
        return arraylist;
    }

    public void a()
    {
        if (i == null) goto _L2; else goto _L1
_L1:
        Iterator iterator = i.iterator();
_L5:
        if (!iterator.hasNext()) goto _L2; else goto _L3
_L3:
        d d1 = (d)iterator.next();
        if (d1 == null || !d1.b()) goto _L5; else goto _L4
_L4:
        boolean flag = true;
_L7:
        if (flag)
        {
            a(true);
        }
        return;
_L2:
        flag = false;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void a(Canvas canvas, t t1)
    {
        if (isInEditMode() || t1 == null || t1.g == null)
        {
            return;
        } else
        {
            b(canvas, t1);
            a(canvas);
            return;
        }
    }

    public void a(t t1)
    {
        if (b.width() == 0.0F || b.height() == 0.0F)
        {
            return;
        }
        com.pf.common.utility.m.b("AccessoryView", "updateRenderer()");
        if (g.isEmpty())
        {
            g.put(com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType.a, new d(d, null, f, com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType.a));
            g.put(com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType.b, new d(d, e, f, com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType.b));
            g.put(AccessoryDrawingCtrl.AccessoryType.c, new d(d, e, f, AccessoryDrawingCtrl.AccessoryType.c));
            g.put(AccessoryDrawingCtrl.AccessoryType.d, new d(d, null, f, AccessoryDrawingCtrl.AccessoryType.d));
            g.put(AccessoryDrawingCtrl.AccessoryType.e, new d(d, null, f, AccessoryDrawingCtrl.AccessoryType.e));
        }
        synchronized (VenusHelper.a().b)
        {
            a(t1, (d)g.get(com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType.a));
        }
        synchronized (VenusHelper.a().c)
        {
            a(t1, (d)g.get(com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType.b));
        }
        synchronized (VenusHelper.a().d)
        {
            a(t1, (d)g.get(AccessoryDrawingCtrl.AccessoryType.c));
        }
        synchronized (VenusHelper.a().e)
        {
            a(t1, (d)g.get(AccessoryDrawingCtrl.AccessoryType.d));
        }
        synchronized (VenusHelper.a().f)
        {
            a(t1, (d)g.get(AccessoryDrawingCtrl.AccessoryType.e));
        }
        return;
        t1;
        obj;
        JVM INSTR monitorexit ;
        throw t1;
        t1;
        obj;
        JVM INSTR monitorexit ;
        throw t1;
        t1;
        obj;
        JVM INSTR monitorexit ;
        throw t1;
        t1;
        obj;
        JVM INSTR monitorexit ;
        throw t1;
        t1;
        obj;
        JVM INSTR monitorexit ;
        throw t1;
    }

    public void a(AccessoryDrawingCtrl.AccessoryType accessorytype)
    {
        if (h == null || h.d() != accessorytype) goto _L2; else goto _L1
_L1:
        accessorytype = h;
_L4:
        if (accessorytype != null)
        {
            accessorytype.a(false);
            invalidate();
        }
        return;
_L2:
label0:
        {
            if (i == null)
            {
                break label0;
            }
            Iterator iterator = i.iterator();
            d d1;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                d1 = (d)iterator.next();
            } while (d1 == null || d1.d() != accessorytype);
            accessorytype = d1;
            continue; /* Loop/switch isn't completed */
        }
        accessorytype = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(boolean flag)
    {
        if (StatusManager.j().s() == BeautyMode.C)
        {
            i = getCurrentAccessoryList();
            if (i != null)
            {
                Iterator iterator = i.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    d d1 = (d)iterator.next();
                    if (d1 != null && (flag || d1.d() == AccessoryDrawingCtrl.AccessoryType.d && !VenusHelper.a().D() || d1.d() == AccessoryDrawingCtrl.AccessoryType.e && !VenusHelper.a().E()))
                    {
                        d1.a(true);
                    }
                } while (true);
                invalidate();
            }
        } else
        {
            h = getCurrentAccessory();
            if (h != null && VenusHelper.a().b(h.d()))
            {
                h.a(true);
                invalidate();
                return;
            }
        }
    }

    public void b()
    {
        if (i != null)
        {
            Iterator iterator = i.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                d d1 = (d)iterator.next();
                if (d1 != null)
                {
                    d1.a(false);
                }
            } while (true);
            i.clear();
            i = null;
            invalidate();
        } else
        if (h != null)
        {
            h.a(false);
            h = null;
            invalidate();
            return;
        }
    }

    public void b(t t1)
    {
        l = t1;
        invalidate();
    }

    public void b(AccessoryDrawingCtrl.AccessoryType accessorytype)
    {
        if (h == null || h.d() != accessorytype) goto _L2; else goto _L1
_L1:
        accessorytype = h;
_L4:
        if (accessorytype != null)
        {
            accessorytype.a(true);
            invalidate();
        }
        return;
_L2:
label0:
        {
            if (i == null)
            {
                break label0;
            }
            Iterator iterator = i.iterator();
            d d1;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                d1 = (d)iterator.next();
            } while (d1 == null || d1.d() != accessorytype);
            accessorytype = d1;
            continue; /* Loop/switch isn't completed */
        }
        accessorytype = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void c()
    {
        for (Iterator iterator = g.entrySet().iterator(); iterator.hasNext(); ((d)((java.util.Map.Entry)iterator.next()).getValue()).c()) { }
        g.clear();
        aa.a(d);
        d = null;
        aa.a(e);
        e = null;
        aa.a(f);
        f = null;
        j = null;
        l = null;
        k = null;
        m.c();
    }

    public void d()
    {
        if (n != null)
        {
            n.cancel();
            n = null;
        }
        ValueAnimator valueanimator = ValueAnimator.ofFloat(new float[] {
            1.0F, 0.0F
        });
        valueanimator.setDuration(200L);
        valueanimator.setInterpolator(new LinearInterpolator());
        class a
            implements android.animation.Animator.AnimatorListener, android.animation.ValueAnimator.AnimatorUpdateListener
        {

            final AccessoryView a;

            public void onAnimationCancel(Animator animator)
            {
            }

            public void onAnimationEnd(Animator animator)
            {
                a.setAlpha(255F);
                a.setVisibility(4);
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
            }

            public void onAnimationUpdate(ValueAnimator valueanimator1)
            {
                float f1 = ((Float)valueanimator1.getAnimatedValue()).floatValue();
                a.setAlpha((int)(f1 * 255F));
                a.invalidate();
            }

            a()
            {
                a = AccessoryView.this;
                super();
            }
        }

        a a1 = new a();
        valueanimator.addUpdateListener(a1);
        valueanimator.addListener(a1);
        valueanimator.start();
        n = valueanimator;
    }

    public int getAccessoryRendererCount()
    {
        return g.size();
    }

    public void invalidate()
    {
        if (j != null)
        {
            j.invalidate();
        }
    }

    protected void onDraw(Canvas canvas)
    {
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        com.pf.common.utility.m.b("AccessoryView", "AccessoryView onSizeChanged");
        super.onSizeChanged(i1, j1, k1, l1);
        f();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        Iterator iterator;
        com.pf.common.utility.m.b("AccessoryView", "AccessoryView onTouch");
        view = new HashMap();
        iterator = com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.a(StatusManager.j().s()).iterator();
_L4:
        AccessoryDrawingCtrl.AccessoryType accessorytype;
        boolean flag;
        if (iterator.hasNext())
        {
            accessorytype = (AccessoryDrawingCtrl.AccessoryType)iterator.next();
            if (aa.b(c(accessorytype)))
            {
                continue; /* Loop/switch isn't completed */
            }
            com.pf.common.utility.m.d("onTouch", "accessoryBitmap is invalid.");
            view.put(accessorytype, Boolean.valueOf(true));
            flag = false;
        } else
        {
            Object obj = StatusManager.j().e();
            AccessoryDrawingCtrl.AccessoryType accessorytype1;
            if (obj == null || "default_original_eye_wear".equalsIgnoreCase(((String) (obj))) || "default_original_hair_band".equalsIgnoreCase(((String) (obj))) || "default_original_necklace".equalsIgnoreCase(((String) (obj))) || "default_original_earrings".equalsIgnoreCase(((String) (obj))))
            {
                com.pf.common.utility.m.d("onTouch", "patternGuid is invalid.");
                flag = true;
            } else
            {
                flag = false;
            }
        }
_L5:
        if (o && !flag) goto _L2; else goto _L1
_L1:
        b();
_L7:
        return false;
        if (d(accessorytype) != null) goto _L4; else goto _L3
_L3:
        com.pf.common.utility.m.d("onTouch", "transform is null.");
        view.put(accessorytype, Boolean.valueOf(true));
        flag = false;
          goto _L5
_L2:
        if (!view.containsValue(Boolean.valueOf(true)))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = view.keySet().iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            accessorytype1 = (AccessoryDrawingCtrl.AccessoryType)((Iterator) (obj)).next();
            if (((Boolean)view.get(accessorytype1)).booleanValue())
            {
                a(accessorytype1);
            }
        } while (true);
        if (h != null) goto _L7; else goto _L6
_L6:
        if (h != null)
        {
            h.c(com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.a(h.d()).c());
            h.a(this, motionevent, b.left, b.top, c);
        } else
        if (i != null)
        {
            view = i.iterator();
            while (view.hasNext()) 
            {
                obj = (d)view.next();
                if (obj != null && ((d) (obj)).b())
                {
                    ((d) (obj)).c(com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.a(((d) (obj)).d()).c());
                    ((d) (obj)).a(this, motionevent, b.left, b.top, c);
                }
            }
        }
        m.a(motionevent);
        if (!m.a() && h == null && i == null && j != null)
        {
            view = m.b();
            if (view != null)
            {
                com.pf.common.utility.m.b("AccessoryView#onTouch", "Pass touch down event.");
                j.onTouchEvent(view);
                m.c();
            }
            j.onTouchEvent(motionevent);
        }
        return true;
          goto _L5
    }

    public void setImageViewer(ImageViewer imageviewer)
    {
        j = imageviewer;
    }

    public void setToolPanel(Fragment fragment)
    {
        k = (BeautyToolPanel)fragment;
    }

    static 
    {
        int i1 = 30;
        int j1 = Globals.d().getResources().getDimensionPixelSize(0x7f080289);
        i1 = j1;
_L2:
        a = i1;
        return;
        Exception exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
