// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common.a;

import android.app.Activity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.database.more.i.e;
import com.cyberlink.youcammakeup.kernelctrl.VenusHelper;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.r;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.utility.az;
import com.cyberlink.youcammakeup.utility.bo;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.HorizontalGridView;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common.a:
//            d, i, f

public class j extends com.cyberlink.youcammakeup.widgetpool.common.a.d
{

    protected HorizontalGridView j;
    protected i k;
    protected List l;
    protected aw m;

    public j()
    {
        l = null;
        m = null;
    }

    static void a(j j1)
    {
        j1.g();
    }

    private void g()
    {
        (new AsyncTask() {

            BeautyMode a;
            final j b;

            protected transient Void a(Void avoid[])
            {
                avoid = b.f();
                b.d(a);
                if (b.g != null)
                {
                    d d1 = h.b().a(b.g.b(), b.g.a());
                    b.k = new i(b.getActivity(), avoid, b.l, d1);
                    return null;
                } else
                {
                    b.k = new i(b.getActivity(), avoid, b.l, null);
                    return null;
                }
            }

            protected void a(Void void1)
            {
                b.j.setAlpha(0.0F);
                b.j.setVisibility(0);
                b.j.setAdapter(b.k);
                b.j.animate().alpha(1.0F);
                if (b.m != null)
                {
                    b.a(b.m, true);
                }
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            protected void onPostExecute(Object obj)
            {
                a((Void)obj);
            }

            protected void onPreExecute()
            {
                a = StatusManager.j().s();
                b.j.setVisibility(8);
                if (a == null || a == BeautyMode.D)
                {
                    return;
                }
                if (a == BeautyMode.s || a == BeautyMode.x)
                {
                    b.a.setBackgroundColor(0);
                    return;
                } else
                {
                    b.a.setBackgroundColor(Color.parseColor("#FFE1E1E1"));
                    return;
                }
            }

            
            {
                b = j.this;
                super();
            }
        }).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    public void a()
    {
        l = null;
        m = null;
        j.post(new Runnable() {

            final j a;

            public void run()
            {
                j.a(a);
            }

            
            {
                a = j.this;
                super();
            }
        });
    }

    public void a(View view, int i1)
    {
        while (l == null || i1 >= l.size()) 
        {
            return;
        }
        d();
        if (j != null)
        {
            j.a(i1, true);
        }
        view = (aw)l.get(i1);
        if (c != null)
        {
            c.a(view.a(), new Float[0]);
        }
        view = (ImageViewer)getActivity().findViewById(0x7f0c0720);
        e = i1;
    }

    public void a(aw aw1, boolean flag)
    {
        int j1;
        j1 = 0;
        m = aw1;
        if (l != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i1 = 0;
_L10:
        if (i1 >= l.size())
        {
            break MISSING_BLOCK_LABEL_210;
        }
        if (!aw1.a().equals(((aw)l.get(i1)).a())) goto _L4; else goto _L3
_L3:
        if (i1 != -1) goto _L6; else goto _L5
_L5:
        if (j1 >= l.size()) goto _L6; else goto _L7
_L7:
        if (!a(aw1, (aw)l.get(j1))) goto _L9; else goto _L8
_L8:
        if (j1 != -1)
        {
            d();
            e = j1;
            if (j != null)
            {
                j.a(e, true);
                if (flag)
                {
                    i1 = j.getFirstVisiblePosition();
                    j1 = j.getLastVisiblePosition();
                    if (e < i1 || e > j1)
                    {
                        j.post(new Runnable() {

                            final j a;

                            public void run()
                            {
                                a.j.setSelection(a.e);
                            }

            
            {
                a = j.this;
                super();
            }
                        });
                        return;
                    }
                }
            }
        }
          goto _L1
_L4:
        i1++;
          goto _L10
_L9:
        j1++;
          goto _L5
_L6:
        j1 = i1;
          goto _L8
        i1 = -1;
          goto _L3
    }

    public void a(String s)
    {
        if (k != null)
        {
            k.a(s);
            k.notifyDataSetChanged();
        }
    }

    public void a(boolean flag)
    {
        if (k != null)
        {
            k.a(false);
        }
    }

    public boolean a(aw aw1, aw aw2)
    {
_L2:
        return false;
        if (aw1.b() != aw2.b() || aw1.i().size() != aw2.i().size() || aw1.b() <= 0 || aw2.b() <= 0 || aw1.i().size() <= 0 || aw2.i().size() <= 0) goto _L2; else goto _L1
_L1:
        int i1 = 0;
label0:
        do
        {
label1:
            {
                if (i1 >= aw1.b())
                {
                    break label1;
                }
                if (!((at)aw1.i().get(i1)).equals(aw2.i().get(i1)))
                {
                    break label0;
                }
                i1++;
            }
        } while (true);
        if (true) goto _L2; else goto _L3
_L3:
        return true;
    }

    protected void b()
    {
        d = (EditViewActivity)getActivity();
        j = (HorizontalGridView)a.findViewById(0x7f0c054b);
        g();
        if (j != null)
        {
            j.setOnItemClickListener(i);
        }
    }

    public void d()
    {
        for (int i1 = 0; i1 < j.getChildCount(); i1++)
        {
            ((f)j.getChildAt(i1)).setChecked(false);
        }

        e = -1;
    }

    public void d(BeautyMode beautymode)
    {
        if (g == null) goto _L2; else goto _L1
_L1:
        Object obj = h.b().a(g.b(), g.a());
        if (beautymode != BeautyMode.s && beautymode != BeautyMode.x) goto _L4; else goto _L3
_L3:
        String s = StatusManager.j().e();
        if (s != null || obj == null) goto _L6; else goto _L5
_L5:
        if (((d) (obj)).l() != null && ((d) (obj)).l().size() > 0)
        {
            obj = (e)((d) (obj)).l().get(0);
        } else
        {
            obj = null;
        }
        if (obj == null || ((e) (obj)).a() == null) goto _L6; else goto _L7
_L7:
        obj = ((e) (obj)).a();
_L10:
        l = PanelDataCenter.a().m(((String) (obj)));
        if (l == null)
        {
            l = PanelDataCenter.a().a(beautymode, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a, 1);
            l.addAll(PanelDataCenter.a().a(beautymode, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a, 2));
        }
_L8:
        if (StatusManager.j().s() == BeautyMode.y)
        {
            VenusHelper.a().b(l);
        }
        return;
_L4:
        l = PanelDataCenter.a().k(((d) (obj)).d());
        continue; /* Loop/switch isn't completed */
_L2:
        obj = Arrays.asList(new String[] {
            com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a.toString(), com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b.toString()
        });
        l = PanelDataCenter.a().a(((List) (obj)), beautymode);
        e(beautymode);
        obj = PanelDataCenter.a().j(MotionControlHelper.e().J().c());
        if (obj != null && com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.d.equals(((aw) (obj)).g()) && h.b().m(((aw) (obj)).k(), bo.a(beautymode)))
        {
            l.add(0, obj);
        }
        if (StatusManager.j().s() == BeautyMode.y)
        {
            l.add(0, bo.t());
        }
        if (d != null && MotionControlHelper.e().M() != null)
        {
            d.a(this);
            d.runOnUiThread(new Runnable() {

                final j a;

                public void run()
                {
                    a.d.a(PanelDataCenter.a().i(MotionControlHelper.e().M().c()), true);
                }

            
            {
                a = j.this;
                super();
            }
            });
        }
        if (true) goto _L8; else goto _L6
_L6:
        obj = s;
        if (true) goto _L10; else goto _L9
_L9:
    }

    protected void e(BeautyMode beautymode)
    {
        beautymode = new ArrayList();
        Iterator iterator = l.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            aw aw1 = (aw)iterator.next();
            if (aw1 != null && aw1.k() == null)
            {
                beautymode.add(aw1);
            }
        } while (true);
        l = beautymode;
    }

    public String f()
    {
        if (StatusManager.j().s() == BeautyMode.y)
        {
            return "assets://makeup/wig/texture_haircolor_frame.png";
        } else
        {
            return "assets://makeup/texture_color_general.png";
        }
    }

    public void onDestroyView()
    {
        if (k != null)
        {
            k.a();
        }
        j = null;
        k = null;
        super.onDestroyView();
    }
}
