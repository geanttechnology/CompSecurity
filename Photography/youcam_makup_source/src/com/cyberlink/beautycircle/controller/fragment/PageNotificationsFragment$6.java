// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import com.cyberlink.beautycircle.model.NotificationList;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.o;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;
import java.util.Date;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            PageNotificationsFragment

class b extends j
{

    final String a;
    final Date b;
    final PageNotificationsFragment c;

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    protected String a(Void void1)
    {
        void1 = NotificationList.a(a);
        if (void1 != null && void1.longValue() != b.getTime())
        {
            if ((void1 = AccountManager.b()) != null && !void1.isEmpty())
            {
                try
                {
                    o.a(AccountManager.d().id, b.getTime(), a).a(new m() {

                        final PageNotificationsFragment._cls6 a;

                        protected void a(Void void2)
                        {
                            NotificationList.a(a.a, a.b.getTime());
                        }

                        protected void b(Object obj)
                        {
                            a((Void)obj);
                        }

            
            {
                a = PageNotificationsFragment._cls6.this;
                super();
            }
                    });
                }
                // Misplaced declaration of an exception variable
                catch (Void void1)
                {
                    void1.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return null;
    }

    _cls1.a(PageNotificationsFragment pagenotificationsfragment, String s, Date date)
    {
        c = pagenotificationsfragment;
        a = s;
        b = date;
        super();
    }
}
