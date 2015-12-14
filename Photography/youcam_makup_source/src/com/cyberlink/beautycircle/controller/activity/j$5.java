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

class b
    implements android.view..OnLongClickListener
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
            menu.add(m.bc_post_comment_menu_copy).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener() {

                final j._cls5 a;

                public boolean onMenuItemClick(MenuItem menuitem)
                {
                    ((ClipboardManager)a.c.a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, a.a.comment));
                    return true;
                }

            
            {
                a = j._cls5.this;
                super();
            }
            });
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
            menu.add(m.bc_post_comment_menu_delete).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener(view) {

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
            });
        }
        if (userinfo != null && userinfo.id == a.creator.userId)
        {
            menu.add(m.bc_post_comment_menu_edit).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener() {

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
            });
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
            menu.add(m.bc_post_comment_menu_report).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener(view) {

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
            });
        }
        menu.add(m.bc_post_comment_menu_cancel);
        popupmenu.show();
        return true;
    }

    _cls4.a(j j1, Comment comment, long l)
    {
        c = j1;
        a = comment;
        b = l;
        super();
    }
}
