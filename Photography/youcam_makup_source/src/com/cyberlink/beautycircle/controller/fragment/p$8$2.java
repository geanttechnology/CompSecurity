// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import com.cyberlink.beautycircle.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            p

class a
    implements android.view.em.OnMenuItemClickListener
{

    final a a;

    public boolean onMenuItemClick(MenuItem menuitem)
    {
        a.a.k();
        return true;
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/fragment/p$8

/* anonymous class */
    class p._cls8
        implements android.view.View.OnClickListener
    {

        final p a;

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
                ((Menu) (obj)).add(m.bc_me_create_circle).setOnMenuItemClickListener(new p._cls8._cls1());
                ((Menu) (obj)).add(m.bc_me_create_post).setOnMenuItemClickListener(new p._cls8._cls2(this));
                view.show();
                return;
            }
        }

            
            {
                a = p1;
                super();
            }

        // Unreferenced inner class com/cyberlink/beautycircle/controller/fragment/p$8$1

/* anonymous class */
        class p._cls8._cls1
            implements android.view.MenuItem.OnMenuItemClickListener
        {

            final p._cls8 a;

            public boolean onMenuItemClick(MenuItem menuitem)
            {
                a.a.l();
                return true;
            }

                    
                    {
                        a = p._cls8.this;
                        super();
                    }
        }

    }

}
