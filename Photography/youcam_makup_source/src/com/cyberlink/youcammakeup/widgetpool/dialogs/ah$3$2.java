// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.clflurry.YMKClicksSaveMyLookEvent;
import com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent;
import com.cyberlink.youcammakeup.clflurry.as;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.pages.editview.savemylook.b;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.SoftInputUtils;
import com.cyberlink.youcammakeup.utility.aq;
import com.cyberlink.youcammakeup.utility.bl;
import com.pf.common.utility.m;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            ah

class c
    implements bl
{

    final int a;
    final aq b;
    final List c;
    final i.a d;

    public com.cyberlink.youcammakeup.utility.utUtils.CheckResult a(String s)
    {
        if (s.equals(""))
        {
            return com.cyberlink.youcammakeup.utility.utUtils.CheckResult.a;
        }
        if (c != null && c.contains(s))
        {
            return com.cyberlink.youcammakeup.utility.utUtils.CheckResult.b;
        } else
        {
            return com.cyberlink.youcammakeup.utility.utUtils.CheckResult.c;
        }
    }

    public String a()
    {
        return d.d.getString(0x7f070601);
    }

    public void a(Exception exception)
    {
        m.e("SaveMyLookDialog", exception.toString());
        ah.a(d.d, true);
    }

    public void a(Object obj)
    {
        b((String)obj);
    }

    public String b()
    {
        return d.d.getString(0x7f0705fe);
    }

    public void b(String s)
    {
        ah.e(d.d).setEnabled(false);
        z.a("KEY_SAVE_COUNT", a, d.d.getActivity());
        i j = ah.k(d.d).a();
        PanelDataCenter.a().a(ah.j(d.d), s, ah.l(d.d), j, b);
        s = StatusManager.j().d();
        if (s != null)
        {
            s.a(new as());
        }
    }

    public String c()
    {
        return null;
    }

    a(a a1, int j, aq aq, List list)
    {
        d = a1;
        a = j;
        b = aq;
        c = list;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/dialogs/ah$3

/* anonymous class */
    class ah._cls3
        implements android.view.View.OnClickListener
    {

        final ah a;

        public void onClick(View view)
        {
            Object obj = null;
            if (!ah.g(a))
            {
                return;
            }
            ah.a(a, false);
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKClicksSaveMyLookEvent(com.cyberlink.youcammakeup.clflurry.YMKClicksSaveMyLookEvent.ButtonName.b));
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(0L, 0L, com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Operation.d, false, false));
            int j = z.b("KEY_SAVE_COUNT", 1, a.getActivity());
            com.cyberlink.youcammakeup.utility.as as1;
            if (ah.j(a) != null)
            {
                as1 = PanelDataCenter.a().o(ah.j(a));
            } else
            {
                as1 = null;
            }
            if (as1 == null || as1.f() != com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c)
            {
                ah.a(a, null);
                obj = PanelDataCenter.a().a(com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c);
                do
                {
                    int k;
                    if (j < 10)
                    {
                        view = (new StringBuilder()).append('0').append(String.valueOf(j)).toString();
                    } else
                    {
                        view = String.valueOf(j);
                    }
                    k = j + 1;
                    j = k;
                } while (((List) (obj)).contains(view));
                j = k;
            } else
            {
                view = null;
            }
            obj = new ah._cls3._cls2(this, j, new ah._cls3._cls1(), ((List) (obj)));
            if (as1 == null || as1.f() != com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c)
            {
                SoftInputUtils.a(a.getActivity(), a.getFragmentManager(), view, ((bl) (obj)));
                return;
            } else
            {
                PanelDataCenter.a().c(ah.j(a), false);
                ((bl) (obj)).a(as1.b());
                Toast.makeText(Globals.d(), a.getString(0x7f070601), 0).show();
                return;
            }
        }

            
            {
                a = ah1;
                super();
            }

        // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/dialogs/ah$3$1

/* anonymous class */
        class ah._cls3._cls1
            implements aq
        {

            final ah._cls3 a;

            public void a(Exception exception)
            {
                m.e("SaveMyLookDialog", exception.toString());
            }

            public volatile void a(Object obj)
            {
                a((String)obj);
            }

            public void a(String s)
            {
                com.cyberlink.youcammakeup.widgetpool.dialogs.ah.b(a.a, s);
                a.a.getActivity().runOnUiThread(new ah._cls3._cls1._cls1(this));
            }

                    
                    {
                        a = ah._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/dialogs/ah$3$1$1

/* anonymous class */
        class ah._cls3._cls1._cls1
            implements Runnable
        {

            final ah._cls3._cls1 a;

            public void run()
            {
                com.cyberlink.youcammakeup.widgetpool.dialogs.ah.i(a.a.a).setEnabled(true);
                com.cyberlink.youcammakeup.widgetpool.dialogs.ah.i(a.a.a).setVisibility(0);
                ah.e(a.a.a).setVisibility(8);
                ah.a(a.a.a, true);
            }

                    
                    {
                        a = _pcls1;
                        super();
                    }
        }

    }

}
