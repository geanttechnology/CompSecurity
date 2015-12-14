// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.content.DialogInterface;
import android.os.Handler;
import android.view.View;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.pages.editview.savemylook.LookItemPopupMenu;
import com.cyberlink.youcammakeup.pages.editview.savemylook.a;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.SoftInputUtils;
import com.cyberlink.youcammakeup.utility.as;
import com.cyberlink.youcammakeup.utility.av;
import com.cyberlink.youcammakeup.utility.bl;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.AdapterView;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.HorizontalGridView;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.q;
import com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.LooksGridItem;
import com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.LooksImageAdapter;
import com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.f;
import com.pf.common.utility.m;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            MakeupLooksBottomToolbar

class d
    implements bl
{

    final String a;
    final as b;
    final LooksGridItem c;
    final List d;
    final c e;

    public com.cyberlink.youcammakeup.utility.lbar._cls3._cls2._cls1 a(String s)
    {
        if (s.equals(""))
        {
            return com.cyberlink.youcammakeup.utility.lbar._cls3._cls2._fld1;
        }
        if (d != null && d.contains(s))
        {
            return com.cyberlink.youcammakeup.utility.lbar._cls3._cls2._cls1.d;
        } else
        {
            return com.cyberlink.youcammakeup.utility.lbar._cls3._cls2._cls1.d;
        }
    }

    public String a()
    {
        return e.e.e.getString(0x7f070601);
    }

    public void a(Exception exception)
    {
        m.e("MakeupLooksBottomToolbar", exception.toString());
    }

    public void a(Object obj)
    {
        b((String)obj);
    }

    public String b()
    {
        return e.e.e.getString(0x7f0705fe);
    }

    public void b(String s)
    {
        PanelDataCenter.a().a(a, s);
        av av1 = new av();
        av1.b(s);
        b.a(av1);
        c.setName(s);
    }

    public String c()
    {
        return null;
    }

    a(a a1, String s, as as1, LooksGridItem looksgriditem, List list)
    {
        e = a1;
        a = s;
        b = as1;
        c = looksgriditem;
        d = list;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/toolbar/MakeupLooksBottomToolbar$3

/* anonymous class */
    class MakeupLooksBottomToolbar._cls3
        implements q
    {

        final MakeupLooksBottomToolbar a;
        private final android.content.DialogInterface.OnDismissListener b = new MakeupLooksBottomToolbar._cls3._cls1();
        private final a c = new MakeupLooksBottomToolbar._cls3._cls2(this);

        public boolean a(AdapterView adapterview, View view, int i, long l)
        {
            boolean flag = false;
            if (MakeupLooksBottomToolbar.b(a) != null && !MakeupLooksBottomToolbar.b(a).c() && !MakeupLooksBottomToolbar.b(a).d() && i != 0 && i != 1)
            {
                if (!(adapterview = MakeupLooksBottomToolbar.b(a).a(i)).h().booleanValue() || adapterview.i().booleanValue())
                {
                    MakeupLooksBottomToolbar.b(a).c(true);
                    adapterview = new LookItemPopupMenu();
                    adapterview.a(view);
                    adapterview.a(MakeupLooksBottomToolbar.b(a).f(i));
                    if (!MakeupLooksBottomToolbar.b(a).e(i))
                    {
                        flag = true;
                    }
                    adapterview.b(flag);
                    adapterview.a(b);
                    adapterview.a(c);
                    o.a(a.getFragmentManager(), adapterview, "LookItemPopupMenu");
                    return true;
                }
            }
            return false;
        }

            
            {
                a = makeuplooksbottomtoolbar;
                super();
            }

        // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/toolbar/MakeupLooksBottomToolbar$3$1

/* anonymous class */
        class MakeupLooksBottomToolbar._cls3._cls1
            implements android.content.DialogInterface.OnDismissListener
        {

            final MakeupLooksBottomToolbar._cls3 a;

            public void onDismiss(DialogInterface dialoginterface)
            {
                MakeupLooksBottomToolbar.b(a.a).b(false);
                MakeupLooksBottomToolbar.b(a.a).c(false);
            }

                    
                    {
                        a = MakeupLooksBottomToolbar._cls3.this;
                        super();
                    }
        }

    }


    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/toolbar/MakeupLooksBottomToolbar$3$2

/* anonymous class */
    class MakeupLooksBottomToolbar._cls3._cls2
        implements a
    {

        final MakeupLooksBottomToolbar._cls3 a;

        public void a(View view, com.cyberlink.youcammakeup.pages.editview.savemylook.LookItemPopupMenu.Action action)
        {
            LooksGridItem looksgriditem = (LooksGridItem)view;
            String s = ((f)looksgriditem.getTag()).a;
            int i = com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.a(a.a, s);
            List list = PanelDataCenter.a().a(com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c);
            list.remove(MakeupLooksBottomToolbar.b(a.a).a(i).b());
            if (action == com.cyberlink.youcammakeup.pages.editview.savemylook.LookItemPopupMenu.Action.a)
            {
                action = MakeupLooksBottomToolbar.b(a.a).a(i);
                if (action.h().booleanValue())
                {
                    action.a(Boolean.valueOf(false));
                    looksgriditem.d(true);
                }
                MakeupLooksBottomToolbar.p(a.a).onClick(view);
                a.a.c(true);
            } else
            {
                if (action == com.cyberlink.youcammakeup.pages.editview.savemylook.LookItemPopupMenu.Action.b)
                {
                    action = MakeupLooksBottomToolbar.b(a.a).a(i);
                    view.post(new MakeupLooksBottomToolbar._cls3._cls2._cls2(action, new MakeupLooksBottomToolbar._cls3._cls2._cls1(this, s, action, looksgriditem, list)));
                    return;
                }
                if (action == com.cyberlink.youcammakeup.pages.editview.savemylook.LookItemPopupMenu.Action.c)
                {
                    view = a.a.getActivity();
                    if (view instanceof EditViewActivity)
                    {
                        view = (EditViewActivity)view;
                        if (MakeupLooksBottomToolbar.b(a.a).f() == i)
                        {
                            (new Handler()).post(new MakeupLooksBottomToolbar._cls3._cls2._cls3(view));
                            return;
                        } else
                        {
                            view.a(MakeupLooksBottomToolbar.k(a.a));
                            MakeupLooksBottomToolbar.c(a.a).a(MakeupLooksBottomToolbar.b(a.a).getView(i, null, MakeupLooksBottomToolbar.c(a.a)), i, -1L);
                            return;
                        }
                    }
                }
            }
        }

            
            {
                a = _pcls3;
                super();
            }

        // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/toolbar/MakeupLooksBottomToolbar$3$2$2

/* anonymous class */
        class MakeupLooksBottomToolbar._cls3._cls2._cls2
            implements Runnable
        {

            final as a;
            final bl b;
            final MakeupLooksBottomToolbar._cls3._cls2 c;

            public void run()
            {
                SoftInputUtils.b(null, c.a.a.getFragmentManager(), a.b(), b);
            }

                    
                    {
                        c = MakeupLooksBottomToolbar._cls3._cls2.this;
                        a = as1;
                        b = bl1;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/toolbar/MakeupLooksBottomToolbar$3$2$3

/* anonymous class */
        class MakeupLooksBottomToolbar._cls3._cls2._cls3
            implements Runnable
        {

            final EditViewActivity a;
            final MakeupLooksBottomToolbar._cls3._cls2 b;

            public void run()
            {
                a.b(false, false);
                b.a.a.c(true);
            }

                    
                    {
                        b = MakeupLooksBottomToolbar._cls3._cls2.this;
                        a = editviewactivity;
                        super();
                    }
        }

    }

}
