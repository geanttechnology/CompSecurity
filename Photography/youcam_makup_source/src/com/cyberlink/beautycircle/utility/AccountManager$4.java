// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import com.cyberlink.beautycircle.model.BCTileImage;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkManager;
import com.perfectcorp.utility.j;
import java.util.Locale;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            AccountManager

final class c extends j
{

    final boolean a;
    final String b;
    final boolean c;

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    protected Void a(Void void1)
    {
        AccountManager.p();
        if (a)
        {
            AccountManager.b(b, AccountManager.o().b);
        }
        AccountManager.o().b = null;
        BCTileImage.a();
        UserInfo userinfo = new UserInfo();
        String s1 = Locale.getDefault().toString();
        String s = s1;
        void1 = userinfo;
        if (c)
        {
            s = s1;
            void1 = userinfo;
            if (AccountManager.l())
            {
                s = s1;
                void1 = userinfo;
                if (AccountManager.o().b != null)
                {
                    s = AccountManager.a();
                    void1 = AccountManager.d();
                }
            }
        }
        NetworkManager.a(s);
        AccountManager.o().a(void1);
        return null;
    }

    ger(boolean flag, String s, boolean flag1)
    {
        a = flag;
        b = s;
        c = flag1;
        super();
    }
}
