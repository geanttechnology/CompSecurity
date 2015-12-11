// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.a;

import com.shazam.android.an.b;
import com.shazam.android.an.c;
import com.shazam.model.rdio.RdioCallback;
import com.shazam.model.rdio.RdioConnectionState;
import com.shazam.model.rdio.RdioPlaylistInfo;

// Referenced classes of package com.shazam.android.an.a:
//            o

public final class g
    implements b, RdioCallback
{

    private final o a;
    private final RdioConnectionState b;
    private final String c;
    private final String d;
    private c e;

    public g(o o1, RdioConnectionState rdioconnectionstate, String s, String s1)
    {
        e = c.a;
        a = o1;
        b = rdioconnectionstate;
        c = s;
        d = s1;
    }

    public final void a(c c1)
    {
        e = c1;
        a.a(c, d, this);
    }

    public final void a(Object obj)
    {
        obj = (RdioPlaylistInfo)obj;
        b.a(((RdioPlaylistInfo) (obj)));
        e.d();
    }

    public final void a(String s)
    {
        e.b(s);
    }
}
