// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import com.cyberlink.beautycircle.controller.a.aq;
import com.cyberlink.beautycircle.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            g

class a
    implements android.view.em.OnMenuItemClickListener
{

    final a a;

    public boolean onMenuItemClick(MenuItem menuitem)
    {
        aq.c = "create_circle";
        a.a.l();
        return true;
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/fragment/g$4

/* anonymous class */
    class g._cls4
        implements android.view.View.OnClickListener
    {

        final g a;

        public void onClick(View view)
        {
            Object obj = a.getActivity();
            if (obj == null)
            {
                return;
            } else
            {
                view = new PopupMenu(((android.content.Context) (obj)), view);
                obj = view.getMenu();
                ((Menu) (obj)).add(m.bc_me_create_circle).setOnMenuItemClickListener(new g._cls4._cls1(this));
                ((Menu) (obj)).add(m.bc_me_create_post).setOnMenuItemClickListener(new g._cls4._cls2());
                view.show();
                return;
            }
        }

            
            {
                a = g1;
                super();
            }

        // Unreferenced inner class com/cyberlink/beautycircle/controller/fragment/g$4$2

/* anonymous class */
        class g._cls4._cls2
            implements android.view.MenuItem.OnMenuItemClickListener
        {

            final g._cls4 a;

            public boolean onMenuItemClick(MenuItem menuitem)
            {
                aq.c = "create_post";
                a.a.k();
                return true;
            }

                    
                    {
                        a = g._cls4.this;
                        super();
                    }
        }

    }

}
