// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.util.Log;
import org.jivesoftware.smack.packet.e;

// Referenced classes of package com.cyberlink.you.chat:
//            q, n, r

class b
    implements q
{

    final e a;
    final r b;
    final n c;

    public void a()
    {
        if (n.a(c, a))
        {
            Log.d("XMPPManager", "connect and send success.");
            if (b != null)
            {
                b.a();
            }
        } else
        {
            Log.d("XMPPManager", "connect success and send fail.");
            if (b != null)
            {
                b.b();
                return;
            }
        }
    }

    public void a(String s)
    {
        Log.d("XMPPManager", (new StringBuilder()).append("connect fail. ").append(s).toString());
        if (b != null)
        {
            b.b();
        }
    }

    t.e(n n1, e e, r r1)
    {
        c = n1;
        a = e;
        b = r1;
        super();
    }
}
