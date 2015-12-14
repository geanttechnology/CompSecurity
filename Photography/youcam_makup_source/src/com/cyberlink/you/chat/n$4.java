// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.util.Log;
import android.util.Pair;
import com.cyberlink.you.g;
import java.util.List;
import java.util.concurrent.Callable;
import org.jivesoftware.smack.sasl.SASLErrorException;
import org.jivesoftware.smack.tcp.c;
import org.jivesoftware.smack.util.a.b;

// Referenced classes of package com.cyberlink.you.chat:
//            n, j

class d
    implements Callable
{

    final String a;
    final String b;
    final c c;
    final String d;
    final n e;

    public Pair a()
    {
        Thread.currentThread().setName("XMPP Auth Callable");
        String s;
        com.cyberlink.you.chat.n.b((new StringBuilder()).append("Connect to (").append(n.m()).append(") ").append(a).append(" by ").append(b).toString());
        n.a(System.currentTimeMillis());
        c.h();
        n.a(e, c);
        com.cyberlink.you.chat.n.b("Connected");
        s = com.cyberlink.you.chat.n.c(e);
        c.d(s);
        if (s != null) goto _L2; else goto _L1
_L1:
        c.a(b, d, g.a().i());
        com.cyberlink.you.chat.n.b((new StringBuilder()).append("Login as ").append(c.e()).toString());
_L3:
        g.a().c(c.e());
        e.a(c);
        e.a(b);
        e.g();
        j.a();
        com.cyberlink.you.chat.j.b();
        g.a().e(false);
        com.cyberlink.you.chat.n.c(true);
        com.cyberlink.you.chat.n.b("Auth complete");
        Object obj;
        s = "Success";
        obj = Boolean.valueOf(true);
_L4:
        return new Pair(obj, s);
_L2:
        c.c(b, d, g.a().i());
        com.cyberlink.you.chat.n.b((new StringBuilder()).append("Resume as ").append(c.e()).toString());
          goto _L3
        Object obj1;
        obj1;
        Log.w("XMPPManager", (new StringBuilder()).append("Connect Fail, spent ").append(System.currentTimeMillis() - n.n()).append(" ms").toString());
        com.cyberlink.you.chat.n.b(((Exception) (obj1)).toString());
        s = ((Exception) (obj1)).toString();
        if (obj1 instanceof org.jivesoftware.smack.kException.ConnectionException)
        {
            obj1 = (org.jivesoftware.smack.kException.ConnectionException)obj1;
            com.cyberlink.you.chat.n.b(((org.jivesoftware.smack.kException.ConnectionException) (obj1)).a().toString());
            for (int i = 0; i < ((org.jivesoftware.smack.kException.ConnectionException) (obj1)).a().size(); i++)
            {
                com.cyberlink.you.chat.n.b(((b)((org.jivesoftware.smack.kException.ConnectionException) (obj1)).a().get(i)).c().toString());
            }

        } else
        if (obj1 instanceof SASLErrorException)
        {
            Object obj2 = ((SASLErrorException)obj1).a();
            if (obj2 != null)
            {
                obj2 = ((org.jivesoftware.smack.sasl.Mechanism.SASLFailure) (obj2)).a();
                if (obj2 != null && ((String) (obj2)).contains("not-authorized") && n.d(e))
                {
                    com.cyberlink.you.chat.n.c(false);
                    com.cyberlink.you.chat.n.b("Log out");
                    s = "Force Logout";
                }
            }
        }
        n.o();
        n.a().a(null);
        n.a().a("");
        obj1 = Boolean.valueOf(false);
          goto _L4
    }

    public Object call()
    {
        return a();
    }

    c(n n1, String s, String s1, c c1, String s2)
    {
        e = n1;
        a = s;
        b = s1;
        c = c1;
        d = s2;
        super();
    }
}
