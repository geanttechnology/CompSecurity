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
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.SoftInputUtils;
import com.cyberlink.youcammakeup.utility.aq;
import com.cyberlink.youcammakeup.utility.as;
import com.cyberlink.youcammakeup.utility.bl;
import com.pf.common.utility.m;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            ah

class a
    implements aq
{

    final a a;

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
        a.a.getActivity().runOnUiThread(new Runnable() {

            final ah._cls3._cls1 a;

            public void run()
            {
                com.cyberlink.youcammakeup.widgetpool.dialogs.ah.i(a.a.a).setEnabled(true);
                com.cyberlink.youcammakeup.widgetpool.dialogs.ah.i(a.a.a).setVisibility(0);
                ah.e(a.a.a).setVisibility(8);
                ah.a(a.a.a, true);
            }

            
            {
                a = ah._cls3._cls1.this;
                super();
            }
        });
    }

    c(c c)
    {
        a = c;
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
            b.a(new YMKClicksSaveMyLookEvent(com.cyberlink.youcammakeup.clflurry.YMKClicksSaveMyLookEvent.ButtonName.b));
            b.a(new YMKSavingPageEvent(0L, 0L, com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Operation.d, false, false));
            int i = z.b("KEY_SAVE_COUNT", 1, a.getActivity());
            as as1;
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
                    int j;
                    if (i < 10)
                    {
                        view = (new StringBuilder()).append('0').append(String.valueOf(i)).toString();
                    } else
                    {
                        view = String.valueOf(i);
                    }
                    j = i + 1;
                    i = j;
                } while (((List) (obj)).contains(view));
                i = j;
            } else
            {
                view = null;
            }
            obj = new ah._cls3._cls2(i, new ah._cls3._cls1(this), ((List) (obj)));
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

        // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/dialogs/ah$3$2

/* anonymous class */
        class ah._cls3._cls2
            implements bl
        {

            final int a;
            final aq b;
            final List c;
            final ah._cls3 d;

            public com.cyberlink.youcammakeup.utility.SoftInputUtils.CheckResult a(String s)
            {
                if (s.equals(""))
                {
                    return com.cyberlink.youcammakeup.utility.SoftInputUtils.CheckResult.a;
                }
                if (c != null && c.contains(s))
                {
                    return com.cyberlink.youcammakeup.utility.SoftInputUtils.CheckResult.b;
                } else
                {
                    return com.cyberlink.youcammakeup.utility.SoftInputUtils.CheckResult.c;
                }
            }

            public String a()
            {
                return d.a.getString(0x7f070601);
            }

            public void a(Exception exception)
            {
                m.e("SaveMyLookDialog", exception.toString());
                ah.a(d.a, true);
            }

            public void a(Object obj)
            {
                b((String)obj);
            }

            public String b()
            {
                return d.a.getString(0x7f0705fe);
            }

            public void b(String s)
            {
                ah.e(d.a).setEnabled(false);
                z.a("KEY_SAVE_COUNT", a, d.a.getActivity());
                i j = ah.k(d.a).a();
                PanelDataCenter.a().a(ah.j(d.a), s, ah.l(d.a), j, b);
                s = StatusManager.j().d();
                if (s != null)
                {
                    s.a(new com.cyberlink.youcammakeup.clflurry.as());
                }
            }

            public String c()
            {
                return null;
            }

                    
                    {
                        d = ah._cls3.this;
                        a = j;
                        b = aq1;
                        c = list;
                        super();
                    }
        }

    }

}
