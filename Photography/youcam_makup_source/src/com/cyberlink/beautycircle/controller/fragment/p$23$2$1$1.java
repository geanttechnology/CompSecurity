// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.app.Activity;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.aq;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.b;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            p

class a
    implements Runnable
{

    final String a;
    final _cls2.a b;

    public void run()
    {
        if (com.cyberlink.beautycircle.controller.fragment.p.e(b.b.b.b).isBlocked.booleanValue())
        {
            NetworkUser.b(a, Long.valueOf(p.a(b.b.b.b))).a(new com.perfectcorp.utility.m() {

                final p._cls23._cls2._cls1._cls1 a;

                public void a()
                {
                    a(0x80000005);
                }

                public void a(int i)
                {
                }

                public void a(Void void1)
                {
                    void1 = com.cyberlink.beautycircle.controller.fragment.p.e(a.b.a.b.a);
                    boolean flag;
                    if (!com.cyberlink.beautycircle.controller.fragment.p.e(a.b.a.b.a).isBlocked.booleanValue())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    void1.isBlocked = Boolean.valueOf(flag);
                    void1 = a.b.a.b.a.getResources().getString(m.bc_post_more_menu_unblock_toast);
                    e.a(a.b.a.b.a.getActivity(), void1);
                }

                public void b(Object obj)
                {
                    a((Void)obj);
                }

            
            {
                a = p._cls23._cls2._cls1._cls1.this;
                super();
            }
            });
            return;
        } else
        {
            NetworkUser.a(a, Long.valueOf(p.a(b.b.b.b))).a(new com.perfectcorp.utility.m() {

                final p._cls23._cls2._cls1._cls1 a;

                public void a()
                {
                    a(0x80000005);
                }

                public void a(int i)
                {
                }

                public void a(Void void1)
                {
                    void1 = com.cyberlink.beautycircle.controller.fragment.p.e(a.b.a.b.a);
                    boolean flag;
                    if (!com.cyberlink.beautycircle.controller.fragment.p.e(a.b.a.b.a).isBlocked.booleanValue())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    void1.isBlocked = Boolean.valueOf(flag);
                    void1 = a.b.a.b.a.getResources().getString(m.bc_post_more_menu_block_toast);
                    e.a(a.b.a.b.a.getActivity(), void1);
                }

                public void b(Object obj)
                {
                    a((Void)obj);
                }

            
            {
                a = p._cls23._cls2._cls1._cls1.this;
                super();
            }
            });
            return;
        }
    }

    _cls2.a(_cls2.a a1, String s)
    {
        b = a1;
        a = s;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/fragment/p$23

/* anonymous class */
    class p._cls23
        implements android.view.View.OnClickListener
    {

        final p a;

        public void onClick(View view)
        {
            android.support.v4.app.FragmentActivity fragmentactivity = a.getActivity();
            view = new PopupMenu(fragmentactivity, view);
            Menu menu = view.getMenu();
            menu.add(m.bc_post_comment_menu_report).setOnMenuItemClickListener(new p._cls23._cls1(fragmentactivity));
            int i = m.bc_post_more_menu_block;
            if (com.cyberlink.beautycircle.controller.fragment.p.e(a).isBlocked.booleanValue())
            {
                i = m.bc_post_more_menu_unblock;
            }
            menu.add(i).setOnMenuItemClickListener(new p._cls23._cls2(this, fragmentactivity));
            view.show();
        }

            
            {
                a = p1;
                super();
            }

        // Unreferenced inner class com/cyberlink/beautycircle/controller/fragment/p$23$1

/* anonymous class */
        class p._cls23._cls1
            implements android.view.MenuItem.OnMenuItemClickListener
        {

            final Activity a;
            final p._cls23 b;

            public boolean onMenuItemClick(MenuItem menuitem)
            {
                aq.c = "report_user";
                AccountManager.a(a, new p._cls23._cls1._cls1(this));
                return true;
            }

                    
                    {
                        b = p._cls23.this;
                        a = activity;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/beautycircle/controller/fragment/p$23$1$1

/* anonymous class */
        class p._cls23._cls1._cls1
            implements b
        {

            final p._cls23._cls1 a;

            public void a()
            {
                Globals.b("Get AccountToken Fail");
            }

            public void a(String s)
            {
                if (a.a != null)
                {
                    c.a(a.a, p.a(a.b.a), p.d(a.b.a));
                }
            }

            public void b()
            {
                Globals.b("Get AccountToken Cancel");
            }

                    
                    {
                        a = _pcls1;
                        super();
                    }
        }

    }


    // Unreferenced inner class com/cyberlink/beautycircle/controller/fragment/p$23$2

/* anonymous class */
    class p._cls23._cls2
        implements android.view.MenuItem.OnMenuItemClickListener
    {

        final Activity a;
        final p._cls23 b;

        public boolean onMenuItemClick(MenuItem menuitem)
        {
            aq.c = "block_user";
            AccountManager.a(a, new p._cls23._cls2._cls1(this));
            return true;
        }

            
            {
                b = _pcls23;
                a = activity;
                super();
            }
    }


    // Unreferenced inner class com/cyberlink/beautycircle/controller/fragment/p$23$2$1

/* anonymous class */
    class p._cls23._cls2._cls1
        implements b
    {

        final p._cls23._cls2 a;

        public void a()
        {
            Globals.b("Get AccountToken Fail");
        }

        public void a(String s)
        {
            if (s == null)
            {
                return;
            }
            int i = m.bc_post_more_menu_block_msg;
            int k = m.bc_post_more_menu_block_btn;
            if (com.cyberlink.beautycircle.controller.fragment.p.e(a.b.a).isBlocked.booleanValue())
            {
                i = m.bc_post_more_menu_unblock_msg;
                k = m.bc_post_more_menu_unblock_btn;
            }
            DialogUtils.a(a.a, null, a.b.a.getResources().getString(i), a.b.a.getResources().getString(m.bc_dialog_button_cancel), null, a.b.a.getResources().getString(k), new p._cls23._cls2._cls1._cls1(this, s));
        }

        public void b()
        {
            Globals.b("Get AccountToken Cancel");
        }

            
            {
                a = _pcls2;
                super();
            }
    }

}
