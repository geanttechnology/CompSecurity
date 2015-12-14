// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.Comment;
import com.cyberlink.beautycircle.model.Creator;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            g, PostActivity

class a
    implements android.view.m.OnMenuItemClickListener
{

    final a a;

    public boolean onMenuItemClick(MenuItem menuitem)
    {
        PostActivity.a(a.a.b, a.a);
        return true;
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/g$27

/* anonymous class */
    class g._cls27
        implements android.view.View.OnLongClickListener
    {

        final Comment a;
        final long b;
        final g c;

        public boolean onLongClick(View view)
        {
            boolean flag1 = false;
            PopupMenu popupmenu = new PopupMenu(c.b, view);
            Menu menu = popupmenu.getMenu();
            if (e.a)
            {
                menu.add(m.bc_post_comment_menu_copy).setOnMenuItemClickListener(new g._cls27._cls1());
            }
            UserInfo userinfo = AccountManager.d();
            if (a.creator != null)
            {
                e.b(new Object[] {
                    "Creator userId:", Long.valueOf(a.creator.userId)
                });
            }
            if (userinfo != null)
            {
                e.b(new Object[] {
                    "Account userId:", Long.valueOf(userinfo.id)
                });
            }
            e.b(new Object[] {
                "creatorId:", Long.valueOf(b)
            });
            if (userinfo != null && (userinfo.id == a.creator.userId || userinfo.id == b))
            {
                menu.add(m.bc_post_comment_menu_delete).setOnMenuItemClickListener(new g._cls27._cls2(view));
            }
            if (userinfo != null && userinfo.id == a.creator.userId)
            {
                menu.add(m.bc_post_comment_menu_edit).setOnMenuItemClickListener(new g._cls27._cls3(this));
            }
            boolean flag = flag1;
            if (a.creator != null)
            {
                flag = flag1;
                if (a.creator.b().c())
                {
                    flag = true;
                }
            }
            if ((userinfo == null || userinfo.id != a.creator.userId) && !flag && !"CL".equals(a.creator.userType))
            {
                menu.add(m.bc_post_comment_menu_report).setOnMenuItemClickListener(new g._cls27._cls4(view));
            }
            menu.add(m.bc_post_comment_menu_cancel);
            popupmenu.show();
            return true;
        }

            
            {
                c = g1;
                a = comment;
                b = l;
                super();
            }

        // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/g$27$1

/* anonymous class */
        class g._cls27._cls1
            implements android.view.MenuItem.OnMenuItemClickListener
        {

            final g._cls27 a;

            public boolean onMenuItemClick(MenuItem menuitem)
            {
                ((ClipboardManager)a.c.b.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, a.a.comment));
                return true;
            }

                    
                    {
                        a = g._cls27.this;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/g$27$2

/* anonymous class */
        class g._cls27._cls2
            implements android.view.MenuItem.OnMenuItemClickListener
        {

            final View a;
            final g._cls27 b;

            public boolean onMenuItemClick(MenuItem menuitem)
            {
                g.a(b.c, b.a.commentId, a);
                return true;
            }

                    
                    {
                        b = g._cls27.this;
                        a = view;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/g$27$4

/* anonymous class */
        class g._cls27._cls4
            implements android.view.MenuItem.OnMenuItemClickListener
        {

            final View a;
            final g._cls27 b;

            public boolean onMenuItemClick(MenuItem menuitem)
            {
                g.b(b.c, b.a.commentId, a);
                return true;
            }

                    
                    {
                        b = g._cls27.this;
                        a = view;
                        super();
                    }
        }

    }

}
