// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle;

import com.cyberlink.beautycircle.controller.gcm.a;
import com.cyberlink.beautycircle.controller.gcm.b;
import com.cyberlink.beautycircle.model.network.NetworkManager;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle:
//            Globals

final class _cls1.a extends j
{

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    protected Void a(Void void1)
    {
        if (Globals.l())
        {
            if (!com.cyberlink.beautycircle.controller.gcm.a.a(Globals.n()))
            {
                e.e(new Object[] {
                    "No Google Play Services"
                });
            } else
            {
                void1 = com.cyberlink.beautycircle.controller.gcm.a.c(Globals.n());
                com.cyberlink.beautycircle.controller.gcm.a.b(Globals.n()).a(new m(void1) {

                    final String a;
                    final Globals._cls8 b;

                    protected void a(b b1)
                    {
                        if (b1 == null || b1.a != 1)
                        {
                            com.cyberlink.beautycircle.Globals.b("GCM register failed");
                        } else
                        {
                            com.cyberlink.beautycircle.Globals.b("GCM register successfully");
                            if (b1.b != null && !b1.b.isEmpty() && (a == null || !b1.b.equals(a)))
                            {
                                NetworkManager.a(AccountManager.a());
                                return;
                            }
                        }
                    }

                    protected void b(Object obj)
                    {
                        a((b)obj);
                    }

            
            {
                b = Globals._cls8.this;
                a = s;
                super();
            }
                });
            }
        }
        return null;
    }

    _cls1.a()
    {
    }
}
