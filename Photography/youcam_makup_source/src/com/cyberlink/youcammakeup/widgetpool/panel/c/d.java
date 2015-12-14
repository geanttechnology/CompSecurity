// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.cyberlink.clgpuimage.CLMakeupLiveFilter;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.camera.CameraCtrl;
import com.cyberlink.youcammakeup.camera.y;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.aa;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.widgetpool.ICameraPanel;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.AdapterView;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.HorizontalGridView;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.panel.a;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.TemplateButton;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.c:
//            e, f, g, l, 
//            n, p, m

public class d extends Fragment
    implements ICameraPanel, a
{

    private View a;
    private HorizontalGridView b;
    private HorizontalGridView c;
    private n d;
    private f e;
    private CameraCtrl f;
    private View g;
    private View h;
    private View i;
    private com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.p j;
    private com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.p k;

    public d(CameraCtrl cameractrl)
    {
        g = null;
        j = new com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.p() {

            final d a;

            public void a(AdapterView adapterview, View view, int i1, long l1)
            {
                if (i1 == d.g(a).b())
                {
                    return;
                } else
                {
                    d.g(a).b(i1);
                    view.post(new Runnable(this, view, i1) {

                        final View a;
                        final int b;
                        final _cls4 c;

                        public void run()
                        {
                            ((TemplateButton)a).a(false);
                            d.g(c.a).a(b, false);
                        }

            
            {
                c = _pcls4;
                a = view;
                b = i1;
                super();
            }
                    });
                    d.h(a);
                    return;
                }
            }

            
            {
                a = d.this;
                super();
            }
        };
        k = new com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.p() {

            final d a;

            public void a(AdapterView adapterview, View view, int i1, long l1)
            {
                com.cyberlink.youcammakeup.widgetpool.panel.c.d.a(a, view, i1);
                if (i1 == d.i(a).a())
                {
                    return;
                }
                d.i(a).b(i1);
                if (i1 == 0)
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.c.d.a(a, new l(view.getContext(), BeautyMode.n, null));
                    d.j(a).setAdapter(d.g(a));
                } else
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.c.d.a(a, new l(view.getContext(), BeautyMode.n, d.i(a).a(i1).a));
                    i1 = a.e();
                    d.j(a).setAdapter(d.g(a));
                    d.g(a).b(i1);
                    d.j(a).a(i1, true);
                }
                d.h(a);
            }

            
            {
                a = d.this;
                super();
            }
        };
        f = cameractrl;
    }

    static View a(d d1)
    {
        return d1.a;
    }

    public static e a(String s)
    {
        boolean flag = false;
        e e1 = new e();
        List list = PanelDataCenter.a().a(s);
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        e1.d = 450;
        e1.e = 300;
        int i1 = 0;
        while (i1 < list.size()) 
        {
            Object obj;
label0:
            {
                com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask mask = (com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)list.get(i1);
                obj = MotionControlHelper.i(mask.b());
                if (obj == null)
                {
                    continue;
                }
                if (((Bitmap) (obj)).getWidth() == 900)
                {
                    s = ((String) (obj));
                    if (((Bitmap) (obj)).getHeight() == 600)
                    {
                        break label0;
                    }
                }
                if (((Bitmap) (obj)).getHeight() == 650)
                {
                    s = Bitmap.createBitmap(((Bitmap) (obj)), 0, 50, 900, 600);
                } else
                {
                    s = Bitmap.createBitmap(((Bitmap) (obj)), 0, 0, 900, 600);
                }
            }
            obj = Bitmap.createScaledBitmap(s, e1.d, e1.e, true);
            s = a(((Bitmap) (obj)));
            aa.a(((Bitmap) (obj)));
            obj = mask.k();
            if (obj == com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.EyeShadowSide.b)
            {
                arraylist.add(s);
                e1.c = true;
            } else
            if (obj == com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.EyeShadowSide.c)
            {
                arraylist1.add(s);
                e1.c = true;
            } else
            {
                arraylist.add(s);
                arraylist1.add(s);
            }
            i1++;
        }
        e1.a = new byte[arraylist.size()][];
        for (byte byte0 = 0; byte0 < arraylist.size(); byte0++)
        {
            e1.a[byte0] = (byte[])arraylist.get(byte0);
        }

        e1.b = new byte[arraylist1.size()][];
        for (int j1 = ((flag) ? 1 : 0); j1 < arraylist1.size(); j1++)
        {
            e1.b[j1] = (byte[])arraylist1.get(j1);
        }

        return e1;
    }

    static n a(d d1, n n1)
    {
        d1.d = n1;
        return n1;
    }

    private Boolean a(List list)
    {
        int i1;
        if (list.size() == 0)
        {
            return null;
        }
        i1 = 0;
_L3:
        if (i1 >= list.size())
        {
            break MISSING_BLOCK_LABEL_104;
        }
        if (i1 + 1 >= list.size() || ((at)list.get(i1)).k() == ((at)list.get(i1 + 1)).k()) goto _L2; else goto _L1
_L1:
        Boolean boolean1 = Boolean.valueOf(false);
_L4:
        if (boolean1.booleanValue())
        {
            return Boolean.valueOf(((at)list.get(0)).k());
        } else
        {
            return null;
        }
_L2:
        i1++;
          goto _L3
        boolean1 = Boolean.valueOf(true);
          goto _L4
    }

    private void a(View view, int i1)
    {
        if (i1 > 0 && e.getCount() > i1)
        {
            g g1 = e.a(i1);
            if (g1 != null)
            {
                a(a(g1.b), false);
            }
            if (view != null)
            {
                view.post(new Runnable(view, i1) {

                    final View a;
                    final int b;
                    final d c;

                    public void run()
                    {
                        ((m)a).a(false);
                        d.i(c).a(b, false);
                    }

            
            {
                c = d.this;
                a = view;
                b = i1;
                super();
            }
                });
                return;
            }
        }
    }

    static void a(d d1, View view, int i1)
    {
        d1.a(view, i1);
    }

    static void a(d d1, Boolean boolean1, boolean flag)
    {
        d1.a(boolean1, flag);
    }

    private void a(Boolean boolean1, boolean flag)
    {
        if (boolean1 == null)
        {
            i.setSelected(false);
        } else
        if (boolean1.booleanValue())
        {
            i.setSelected(true);
        } else
        {
            i.setSelected(false);
        }
        if (boolean1 != null && flag)
        {
            int i1 = e.a();
            if (i1 >= 0 && i1 < e.getCount())
            {
                for (int j1 = 0; j1 < e.getCount(); j1++)
                {
                    Object obj = e.a(j1);
                    if (obj == null)
                    {
                        continue;
                    }
                    for (obj = ((g) (obj)).b.iterator(); ((Iterator) (obj)).hasNext(); ((at)((Iterator) (obj)).next()).a(boolean1.booleanValue())) { }
                }

            }
            e.notifyDataSetChanged();
            j();
        }
    }

    public static byte[] a(Bitmap bitmap)
    {
        int i1 = 0;
        int j1 = bitmap.getWidth();
        int k1 = bitmap.getHeight();
        int ai[] = new int[j1 * k1];
        byte abyte0[] = new byte[j1 * k1];
        bitmap.getPixels(ai, 0, j1, 0, 0, j1, k1);
        for (; i1 < j1 * k1; i1++)
        {
            abyte0[i1] = (byte)(ai[i1] >>> 24);
        }

        return abyte0;
    }

    static void b(d d1)
    {
        d1.g();
    }

    static void c(d d1)
    {
        d1.h();
    }

    static View d(d d1)
    {
        return d1.h;
    }

    static CameraCtrl e(d d1)
    {
        return d1.f;
    }

    static View f(d d1)
    {
        return d1.i;
    }

    static n g(d d1)
    {
        return d1.d;
    }

    private void g()
    {
        b = (HorizontalGridView)a.findViewById(0x7f0c069e);
        b.setChoiceMode(1);
        c = (HorizontalGridView)a.findViewById(0x7f0c069a);
        c.setChoiceMode(1);
        Activity activity = getActivity();
        if (d == null)
        {
            d = new l(activity, BeautyMode.n, null);
        }
        if (e == null)
        {
            e = new f(activity);
        }
        if (getActivity() == null)
        {
            Globals.d();
        }
        int i1 = e();
        int j1 = f();
        b.setAdapter(e);
        c.setAdapter(d);
        b.setSelection(j1);
        c.setSelection(i1);
        c.a(i1, true);
        g = a.findViewById(0x7f0c0697);
        i = a.findViewById(0x7f0c069d);
        h = a.findViewById(0x7f0c0107);
    }

    private void h()
    {
        int i1 = f();
        c.setOnItemClickListener(j);
        b.setOnItemClickListener(k);
        if (i1 > -1)
        {
            b.a(e.getView(i1, null, null), i1, 0L);
        }
        if (g != null)
        {
            g.setOnTouchListener(new android.view.View.OnTouchListener() {

                final d a;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    boolean flag = d.d(a).dispatchTouchEvent(motionevent);
                    if (d.e(a) != null)
                    {
                        if (motionevent.getAction() == 0 || motionevent.getAction() == 5)
                        {
                            if (!flag);
                        } else
                        if (motionevent.getAction() != 1 && motionevent.getAction() == 6)
                        {
                            return true;
                        }
                    }
                    return true;
                }

            
            {
                a = d.this;
                super();
            }
            });
        }
        i.setOnClickListener(new android.view.View.OnClickListener() {

            final d a;

            public void onClick(View view)
            {
                if (d.f(a).isSelected())
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.c.d.a(a, Boolean.valueOf(false), true);
                    return;
                } else
                {
                    com.cyberlink.youcammakeup.widgetpool.panel.c.d.a(a, Boolean.valueOf(true), true);
                    return;
                }
            }

            
            {
                a = d.this;
                super();
            }
        });
    }

    static void h(d d1)
    {
        d1.j();
    }

    static f i(d d1)
    {
        return d1.e;
    }

    private void i()
    {
        if (g != null)
        {
            g.setOnTouchListener(null);
        }
        i.setOnClickListener(null);
    }

    static HorizontalGridView j(d d1)
    {
        return d1.c;
    }

    private void j()
    {
        Object obj;
        BeautifierManager beautifiermanager;
        CLMakeupLiveFilter clmakeuplivefilter;
        byte abyte0[];
        int ai[];
        int ai1[];
        int ai2[];
        byte abyte1[][];
        int ai3[];
        byte abyte2[];
        Bitmap bitmap;
        int i1;
        int l1;
        int i2;
        int j2;
        int k2;
        obj = f.j();
        beautifiermanager = f.k().j();
        if (!(obj instanceof CLMakeupLiveFilter))
        {
            break MISSING_BLOCK_LABEL_703;
        }
        clmakeuplivefilter = (CLMakeupLiveFilter)obj;
        i1 = e.a();
        g g1 = e.a(i1);
        i1 = d.b();
        Object obj1 = d.a(i1);
        com.cyberlink.youcammakeup.widgetpool.panel.c.p p1 = com.cyberlink.youcammakeup.widgetpool.panel.c.p.a();
        BeautyMode beautymode = BeautyMode.n;
        android.hardware.Camera.Size size;
        if (obj1 == null)
        {
            obj = null;
        } else
        {
            obj = ((p) (obj1)).c;
        }
        p1.a(beautymode, ((String) (obj)));
        p1.a(g1);
        size = f.k().k();
        if (obj1 == null || g1 == null || size == null)
        {
            break MISSING_BLOCK_LABEL_714;
        }
        obj = a(((p) (obj1)).c);
        abyte1 = ((e) (obj)).a;
        i2 = abyte1.length;
        ai = new int[((e) (obj)).d * ((e) (obj)).e];
        ai1 = new int[g1.b.size()];
        ai2 = new int[g1.b.size()];
        obj1 = PanelDataCenter.a().b(((p) (obj1)).c, g1.a);
        i1 = 0;
        while (i1 < g1.b.size()) 
        {
            ai1[i1] = ((at)g1.b.get(i1)).e();
            int j1;
            if (i1 < ((List) (obj1)).size())
            {
                j1 = ((Integer)((List) (obj1)).get(i1)).intValue();
            } else
            {
                j1 = 70;
            }
            ai2[i1] = j1;
            ((at)g1.b.get(i1)).a(ai2[i1]);
            i1++;
        }
        MotionControlHelper.e().b(g1.b);
        j2 = Math.min(size.height, size.width) / 2;
        k2 = (j2 * 2) / 3;
        ai3 = new int[i2];
        i1 = 0;
        while (i1 < i2) 
        {
            if (i1 >= g1.b.size())
            {
                ai3[i1] = 0;
            } else
            {
                int k1;
                if (((at)g1.b.get(i1)).k())
                {
                    k1 = ((at)g1.b.get(i1)).j();
                } else
                {
                    k1 = 0;
                }
                ai3[i1] = k1;
            }
            i1++;
        }
        l1 = 0;
        for (i1 = 0; i1 < 2; i1++)
        {
            l1 += (j2 >> i1) * (k2 >> i1);
        }

        abyte0 = new byte[l1];
        abyte2 = new byte[l1];
        bitmap = f.k().a("makeup/eyeshadow/bright.png");
        i1 = bitmap.getWidth();
        l1 = bitmap.getHeight();
        byte abyte3[] = f.k().a(bitmap);
        beautifiermanager;
        JVM INSTR monitorenter ;
        beautifiermanager.a(ai, abyte1, ai1, ai2, i2, ((e) (obj)).d, ((e) (obj)).e, j2, k2, ai3, 2, i1, l1, abyte3, abyte0, abyte2);
        beautifiermanager;
        JVM INSTR monitorexit ;
        clmakeuplivefilter.a(true, ai, abyte0, abyte2);
        if (!((e) (obj)).c) goto _L2; else goto _L1
_L1:
        abyte1 = ((e) (obj)).b;
        i2 = abyte1.length;
        beautifiermanager;
        JVM INSTR monitorenter ;
        beautifiermanager.a(ai, abyte1, ai1, ai2, i2, ((e) (obj)).d, ((e) (obj)).e, j2, k2, ai3, 2, i1, l1, abyte3, abyte0, abyte2);
        beautifiermanager;
        JVM INSTR monitorexit ;
_L2:
        clmakeuplivefilter.a(false, ai, abyte0, abyte2);
        clmakeuplivefilter.a(com.cyberlink.clgpuimage.CLMakeupLiveFilter.MakeupLiveFeatures.b, true);
        return;
        Exception exception;
        exception;
        beautifiermanager;
        JVM INSTR monitorexit ;
        throw exception;
        exception;
        beautifiermanager;
        JVM INSTR monitorexit ;
        throw exception;
        clmakeuplivefilter.a(com.cyberlink.clgpuimage.CLMakeupLiveFilter.MakeupLiveFeatures.b, false);
        return;
    }

    public void a()
    {
    }

    public void a(Fragment fragment)
    {
    }

    public void a(com.cyberlink.youcammakeup.widgetpool.ICameraPanel.FlingDirection flingdirection)
    {
    }

    public void a(Long long1, boolean flag)
    {
    }

    public void b()
    {
    }

    public void c()
    {
        getActivity().finish();
    }

    public Long d()
    {
        return null;
    }

    protected int e()
    {
        boolean flag = false;
        if (com.cyberlink.youcammakeup.widgetpool.panel.c.p.a().c() != null || e.a() != 0) goto _L2; else goto _L1
_L1:
        byte byte0 = -1;
_L4:
        return byte0;
_L2:
        String s = com.cyberlink.youcammakeup.widgetpool.panel.c.p.a().a(BeautyMode.n);
        byte0 = flag;
        if (s == null)
        {
            continue;
        }
        int i1 = 0;
        do
        {
            byte0 = flag;
            if (i1 >= d.getCount())
            {
                continue;
            }
            if (d.a(i1) != null && d.a(i1).c.equals(s))
            {
                return i1;
            }
            i1++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected int f()
    {
        g g1 = com.cyberlink.youcammakeup.widgetpool.panel.c.p.a().c();
        if (g1 != null) goto _L2; else goto _L1
_L1:
        int j1 = -1;
_L6:
        return j1;
_L2:
        int i1 = 0;
_L7:
        if (i1 >= e.getCount()) goto _L4; else goto _L3
_L3:
        if (e.a(i1) == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        j1 = i1;
        if (e.a(i1).a.equals(g1.a)) goto _L6; else goto _L5
_L5:
        i1++;
          goto _L7
_L4:
        return -1;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        a.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final d a;

            public void onGlobalLayout()
            {
                com.cyberlink.youcammakeup.widgetpool.panel.c.d.a(a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
                d.b(a);
                d.c(a);
            }

            
            {
                a = d.this;
                super();
            }
        });
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        a = layoutinflater.inflate(0x7f030180, viewgroup, false);
        return a;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        i();
    }
}
