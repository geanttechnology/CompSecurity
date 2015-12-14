// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.util.Pair;
import com.cyberlink.you.friends.q;

// Referenced classes of package com.cyberlink.you.chat:
//            n, q

class d
    implements q
{

    final String a;
    final String b;
    final boolean c;
    final com.cyberlink.you.chat.q d;
    final n e;

    public void a()
    {
        Pair pair = n.a(e, a, b, c);
        if (((Boolean)pair.first).booleanValue())
        {
            if (d != null)
            {
                d.a();
            }
        } else
        if (d != null)
        {
            d.a((String)pair.second);
            return;
        }
    }

    public void b()
    {
        if (d != null)
        {
            d.a("LoadCommandUrl failed");
        }
    }

    (n n1, String s, String s1, boolean flag, com.cyberlink.you.chat.q q1)
    {
        e = n1;
        a = s;
        b = s1;
        c = flag;
        d = q1;
        super();
    }
}
