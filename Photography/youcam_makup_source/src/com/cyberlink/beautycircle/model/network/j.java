// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import android.net.Uri;
import com.cyberlink.beautycircle.Globals;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.u;
import com.perfectcorp.utility.x;

public class j
{

    private static int d = 0;
    private final long a = System.currentTimeMillis();
    private long b;
    private final Uri c;

    public j(String s)
    {
        c = Uri.parse(s);
        d++;
        if (e.a)
        {
            Globals.b((new StringBuilder()).append("[REQUEST] #").append(d).append("; [").append(u.i.a).append("]; ").append(c.getPath()).toString());
        }
    }

    public long a()
    {
        b = System.currentTimeMillis();
        long l = b - a;
        if (l > 1000L && e.a)
        {
            Globals.b((new StringBuilder()).append("[RESPONSE SLOW] ").append((float)l / 1000F).append("sec; ").append(c.getPath()).toString());
        }
        return l;
    }

    public void b()
    {
        long l = System.currentTimeMillis() - b;
        if (l > 1000L && e.a)
        {
            Globals.b((new StringBuilder()).append("[STREAMING SLOW] response: ").append((float)(b - a) / 1000F).append("sec; streaming: ").append((float)l / 1000F).append("sec; ").append(c.getPath()).toString());
        }
    }

}
