// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.c.a;

import android.support.v4.f.a;
import com.target.mothership.services.f.a.c;
import com.target.mothership.services.f.a.e;
import java.util.Map;

// Referenced classes of package com.target.mothership.services.e.c.a:
//            a

public class b extends e
{

    public static final String AUTH_CODE = "authCode";
    private static final c GOOGLE_NOW_SEND_CARD;
    private static final c GOOGLE_NOW_SEND_CARD_DELAY;
    private static final c GOOGLE_REVOKE_TOKEN;
    public static final String REVOKE_TOKEN = "token";

    public b(com.target.mothership.services.f.b.a a1)
    {
        super(a1);
    }

    public com.target.mothership.services.f.a.b a(com.target.mothership.services.e.c.a.a a1)
    {
        return a(GOOGLE_NOW_SEND_CARD, ((com.target.mothership.services.n) (a1)), null, null, null);
    }

    public com.target.mothership.services.f.a.b a(com.target.mothership.services.e.c.a.a a1, String s)
    {
        c c1 = GOOGLE_NOW_SEND_CARD;
        a a2 = new a();
        if (s != null)
        {
            a2.put("authCode", s);
        }
        return a(c1, ((com.target.mothership.services.n) (a1)), null, ((Map) (a2)), null);
    }

    public com.target.mothership.services.f.a.b a(String s)
    {
        c c1 = GOOGLE_REVOKE_TOKEN;
        a a1 = new a();
        if (s != null)
        {
            a1.put("token", s);
        }
        return a(c1, null, null, ((Map) (a1)), null);
    }

    static 
    {
        GOOGLE_NOW_SEND_CARD = new c(com.target.mothership.services.f.a.d.a.POST, com.target.mothership.services.f.b.a.a.TGTAppDataSecure, "/v1/google-now/send-card");
        GOOGLE_REVOKE_TOKEN = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.TGTAppDataSecure, "/v1/google-now/revoke");
        GOOGLE_NOW_SEND_CARD_DELAY = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.TGTAppData, "/v1/config/android");
    }
}
