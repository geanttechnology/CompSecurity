// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.AccountManager;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            a

class b
    implements android.view..OnClickListener
{

    final UserInfo a;
    final View b;
    final a c;

    public void onClick(View view)
    {
        boolean flag1 = false;
        view = new PopupMenu(c.c, view);
        Menu menu = view.getMenu();
        boolean flag = flag1;
        if (AccountManager.c() != null)
        {
            flag = flag1;
            if (AccountManager.c().longValue() == a.id)
            {
                flag = true;
            }
        }
        if (AccountManager.c() == null || AccountManager.c() != null && !flag && !"CL".equals(a.userType))
        {
            menu.add(m.bc_post_comment_menu_report).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener() {

                final a._cls6 a;

                public boolean onMenuItemClick(MenuItem menuitem)
                {
                    a.c.a(a.b);
                    return true;
                }

            
            {
                a = a._cls6.this;
                super();
            }
            });
        }
        if (flag)
        {
            menu.add(m.bc_post_delete).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener() {

                final a._cls6 a;

                public boolean onMenuItemClick(MenuItem menuitem)
                {
                    a.c.b(a.b);
                    return true;
                }

            
            {
                a = a._cls6.this;
                super();
            }
            });
        }
        view.show();
    }

    _cls2.a(a a1, UserInfo userinfo, View view)
    {
        c = a1;
        a = userinfo;
        b = view;
        super();
    }
}
