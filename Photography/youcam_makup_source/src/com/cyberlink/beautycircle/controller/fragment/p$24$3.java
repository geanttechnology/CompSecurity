// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.widget.TextView;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.view.widgetpool.common.MeTabScrollView;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            p, h

class a
    implements Runnable
{

    final int a;
    final a b;

    public void run()
    {
        p.f(b.b, a);
    }

    >(> >, int i)
    {
        b = >;
        a = i;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/fragment/p$24

/* anonymous class */
    class p._cls24 extends h
    {

        final com.cyberlink.beautycircle.model.network.NetworkUser.UserListType b;
        final p c;

        public void a(int i)
        {
            if (b.equals(com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.a))
            {
                if (p.D(c) != null)
                {
                    p.D(c).post(new p._cls24._cls2(i));
                }
                if (p.e(c) != null)
                {
                    p.e(c).followerCount = Integer.valueOf(i);
                }
                if (p.h(c))
                {
                    AccountManager.a(Integer.valueOf(i), null);
                }
            } else
            if (b.equals(com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.b))
            {
                if (p.D(c) != null)
                {
                    p.D(c).post(new p._cls24._cls3(this, i));
                }
                if (p.e(c) != null)
                {
                    p.e(c).followingCount = Integer.valueOf(i);
                }
                if (p.h(c))
                {
                    AccountManager.a(null, Integer.valueOf(i));
                    return;
                }
            }
        }

        public void a(boolean flag)
        {
            if (p.G(c) == null)
            {
                return;
            } else
            {
                p.G(c).post(new p._cls24._cls1(flag));
                return;
            }
        }

            
            {
                c = p1;
                b = userlisttype;
                super(p1);
            }

        // Unreferenced inner class com/cyberlink/beautycircle/controller/fragment/p$24$1

/* anonymous class */
        class p._cls24._cls1
            implements Runnable
        {

            final boolean a;
            final p._cls24 b;

            public void run()
            {
                boolean flag = false;
                int i = 0;
                if (b.b == com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.a)
                {
                    p p1 = b.c;
                    if (!a)
                    {
                        i = 1;
                    }
                    p.h(p1, i);
                } else
                if (b.b == com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.b)
                {
                    p p2 = b.c;
                    int j;
                    if (a)
                    {
                        j = ((flag) ? 1 : 0);
                    } else
                    {
                        j = 1;
                    }
                    p.i(p2, j);
                    return;
                }
            }

                    
                    {
                        b = p._cls24.this;
                        a = flag;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/beautycircle/controller/fragment/p$24$2

/* anonymous class */
        class p._cls24._cls2
            implements Runnable
        {

            final int a;
            final p._cls24 b;

            public void run()
            {
                p.g(b.c, a);
            }

                    
                    {
                        b = p._cls24.this;
                        a = i;
                        super();
                    }
        }

    }

}
