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
    implements android.view..OnClickListener
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
            ((Menu) (obj)).add(m.bc_me_create_circle).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener() {

                final g._cls4 a;

                public boolean onMenuItemClick(MenuItem menuitem)
                {
                    aq.c = "create_circle";
                    a.a.l();
                    return true;
                }

            
            {
                a = g._cls4.this;
                super();
            }
            });
            ((Menu) (obj)).add(m.bc_me_create_post).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener() {

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
            });
            view.show();
            return;
        }
    }

    _cls2.a(g g1)
    {
        a = g1;
        super();
    }
}
