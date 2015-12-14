// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.content.SharedPreferences;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.cyberlink.you.u;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;
import java.util.Date;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            AccountManager, c

final class d extends j
{

    final UserInfo a;
    final String b;
    final c c;
    final boolean d;

    protected Boolean a(Void void1)
    {
        if (a == null || b == null || b.isEmpty())
        {
            return Boolean.valueOf(false);
        }
        boolean flag;
        if (AccountManager.b(a.region) && a.region != null)
        {
            void1 = a.region;
            NetworkUser.a(b, null, null, null, null, null, void1, null, null, null, null, null, null, null).a(new m(void1) {

                final String a;
                final AccountManager._cls2 b;

                protected void a(int i)
                {
                    e.e(new Object[] {
                        "Set default locale fail: ", Integer.valueOf(i)
                    });
                    Globals.b((new StringBuilder()).append("Set default locale fail: ").append(i).toString());
                    if (b.c != null && i == 420)
                    {
                        b.c.b();
                    }
                }

                protected void a(com.cyberlink.beautycircle.model.UserInfo.UpdateUserResponse updateuserresponse)
                {
                    e.c(new Object[] {
                        "Set default locale to: ", a
                    });
                    Globals.b((new StringBuilder()).append("Set default locale to: ").append(a).toString());
                    if (b.c != null)
                    {
                        b.c.a();
                    }
                }

                protected void b(Object obj)
                {
                    a((com.cyberlink.beautycircle.model.UserInfo.UpdateUserResponse)obj);
                }

            
            {
                b = AccountManager._cls2.this;
                a = s;
                super();
            }
            });
            flag = true;
        } else
        {
            void1 = AccountManager.d();
            Date date;
            if (void1 != null)
            {
                void1 = ((UserInfo) (void1)).lastModified;
            } else
            {
                void1 = null;
            }
            if (a != null)
            {
                date = a.lastModified;
            } else
            {
                date = null;
            }
            if (void1 != null && date != null && void1.getTime() != date.getTime() || void1 == null && date != null || void1 != null && date == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }
        if (d)
        {
            AccountManager.a(b, a);
        } else
        {
            AccountManager.b(a);
        }
        AccountManager.o().b = b;
        if (Globals.m())
        {
            u.a(Globals.n(), b);
        }
        Globals.D().edit().putString("AccountToken", b).putString("UserInfo", a.toString()).commit();
        if (!AccountManager.a)
        {
            AccountManager.d(b);
        }
        if (flag)
        {
            e.b(new Object[] {
                "dispatchAccountInfoChangeEvent"
            });
            AccountManager.o().a(a);
        }
        return Boolean.valueOf(true);
    }

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    _cls1.a(UserInfo userinfo, String s, c c1, boolean flag)
    {
        a = userinfo;
        b = s;
        c = c1;
        d = flag;
        super();
    }
}
