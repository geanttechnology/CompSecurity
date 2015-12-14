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

class a
    implements android.view.em.OnMenuItemClickListener
{

    final a a;

    public boolean onMenuItemClick(MenuItem menuitem)
    {
        a.a.b(a.a);
        return true;
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/adapter/a$6

/* anonymous class */
    class a._cls6
        implements android.view.View.OnClickListener
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
                menu.add(m.bc_post_comment_menu_report).setOnMenuItemClickListener(new a._cls6._cls1());
            }
            if (flag)
            {
                menu.add(m.bc_post_delete).setOnMenuItemClickListener(new a._cls6._cls2(this));
            }
            view.show();
        }

            
            {
                c = a1;
                a = userinfo;
                b = view;
                super();
            }

        // Unreferenced inner class com/cyberlink/beautycircle/controller/adapter/a$6$1

/* anonymous class */
        class a._cls6._cls1
            implements android.view.MenuItem.OnMenuItemClickListener
        {

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
        }

    }

}
