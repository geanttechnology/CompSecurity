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
//            j, PostCommentActivity

class a
    implements android.view.em.OnMenuItemClickListener
{

    final a a;

    public boolean onMenuItemClick(MenuItem menuitem)
    {
        ((ClipboardManager)a.a.a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, a.a.comment));
        return true;
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/j$5

/* anonymous class */
    class j._cls5
        implements android.view.View.OnLongClickListener
    {

        final Comment a;
        final long b;
        final j c;

        public boolean onLongClick(View view)
        {
            boolean flag1 = false;
            PopupMenu popupmenu = new PopupMenu(c.a, view);
            Menu menu = popupmenu.getMenu();
            if (e.a)
            {
                menu.add(m.bc_post_comment_menu_copy).setOnMenuItemClickListener(new j._cls5._cls1(this));
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
                menu.add(m.bc_post_comment_menu_delete).setOnMenuItemClickListener(new j._cls5._cls2(view));
            }
            if (userinfo != null && userinfo.id == a.creator.userId)
            {
                menu.add(m.bc_post_comment_menu_edit).setOnMenuItemClickListener(new j._cls5._cls3());
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
                menu.add(m.bc_post_comment_menu_report).setOnMenuItemClickListener(new j._cls5._cls4(view));
            }
            menu.add(m.bc_post_comment_menu_cancel);
            popupmenu.show();
            return true;
        }

            
            {
                c = j1;
                a = comment;
                b = l;
                super();
            }

        // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/j$5$2

/* anonymous class */
        class j._cls5._cls2
            implements android.view.MenuItem.OnMenuItemClickListener
        {

            final View a;
            final j._cls5 b;

            public boolean onMenuItemClick(MenuItem menuitem)
            {
                j.a(b.c, b.a.commentId, a);
                return true;
            }

                    
                    {
                        b = j._cls5.this;
                        a = view;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/j$5$3

/* anonymous class */
        class j._cls5._cls3
            implements android.view.MenuItem.OnMenuItemClickListener
        {

            final j._cls5 a;

            public boolean onMenuItemClick(MenuItem menuitem)
            {
                PostCommentActivity.a(a.c.a, a.a);
                return true;
            }

                    
                    {
                        a = j._cls5.this;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/j$5$4

/* anonymous class */
        class j._cls5._cls4
            implements android.view.MenuItem.OnMenuItemClickListener
        {

            final View a;
            final j._cls5 b;

            public boolean onMenuItemClick(MenuItem menuitem)
            {
                j.b(b.c, b.a.commentId, a);
                return true;
            }

                    
                    {
                        b = j._cls5.this;
                        a = view;
                        super();
                    }
        }

    }

}
