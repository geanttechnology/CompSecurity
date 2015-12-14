// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.ch;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.d.a;
import com.cyberlink.youcammakeup.widgetpool.d.c;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            BeautyToolPanel, b

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        int i;
        boolean flag1;
        flag1 = true;
        if (com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.o(a.a) != null && com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.o(a.a).getChildCount() <= 0)
        {
            return;
        }
        if (a.a.o == null || a.a.v == null)
        {
            break MISSING_BLOCK_LABEL_355;
        }
        i = 0;
_L3:
        Object obj;
        if (i >= a.a.v.size())
        {
            break MISSING_BLOCK_LABEL_355;
        }
        obj = (d)a.a.v.get(i);
        if (obj == null || a.a.o.longValue() != ((d) (obj)).a()) goto _L2; else goto _L1
_L1:
        obj = a.a.o;
_L4:
        if (obj == null && a.a.v != null && a.a.v.size() > 0)
        {
            obj = Long.valueOf(((d)a.a.v.get(0)).a());
        }
        BeautyMode beautymode = StatusManager.j().s();
        boolean flag;
        if (a.a.c != null && (a.a.c instanceof b) && !BeautyMode.d(beautymode) && beautymode != BeautyMode.x)
        {
            Object obj1 = (b)a.a.c;
            if (obj != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ((b) (obj1)).d(flag);
        }
        a.a.b(((Long) (obj)));
        obj1 = a.a;
        if (obj != null && obj != a.a.o)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        ((BeautyToolPanel) (obj1)).b(flag);
        a.a.c(((Long) (obj)));
        return;
_L2:
        i++;
          goto _L3
        obj = null;
          goto _L4
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/beautytoolpanel/BeautyToolPanel$19

/* anonymous class */
    class BeautyToolPanel._cls19
        implements android.widget.AdapterView.OnItemClickListener
    {

        final a a;
        final BeautyToolPanel b;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            adapterview = a.a(i);
            if (b.b != null && (b.u == null || !b.u.equals(adapterview.a())))
            {
                Globals.d().i().b(b.b);
            }
            view = new BeautyToolPanel._cls19._cls1(this);
            ch ch = new BeautyToolPanel._cls19._cls2(view);
            BeautyToolPanel.p(b).setItemChecked(i, true);
            b.u = adapterview.a();
            b.a(false, true);
            if (b.x.containsKey(adapterview))
            {
                b.x.put(adapterview, Integer.valueOf(((Integer)b.x.get(adapterview)).intValue() + 1));
            } else
            {
                b.x.put(adapterview, Integer.valueOf(1));
            }
            b.a(StatusManager.j().s());
            if (b.v != null && b.v.size() > 1 && !BeautyMode.d(StatusManager.j().s()))
            {
                b.a(true, ch);
            }
            view.run();
        }

            
            {
                b = beautytoolpanel;
                a = a1;
                super();
            }

        // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/beautytoolpanel/BeautyToolPanel$19$2

/* anonymous class */
        class BeautyToolPanel._cls19._cls2 extends ch
        {

            final Runnable a;
            final BeautyToolPanel._cls19 b;

            public void onAnimationEnd(Animator animator)
            {
                a.run();
            }

                    
                    {
                        b = BeautyToolPanel._cls19.this;
                        a = runnable;
                        super();
                    }
        }

    }

}
