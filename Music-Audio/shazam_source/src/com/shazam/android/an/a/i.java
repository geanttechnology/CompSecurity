// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.a;

import com.shazam.android.an.g;
import com.shazam.android.an.h;
import com.shazam.model.rdio.RdioCallback;
import com.shazam.model.rdio.RdioConnectionState;
import java.util.List;

// Referenced classes of package com.shazam.android.an.a:
//            o

public final class i
    implements g, RdioCallback
{

    private final o a;
    private final RdioConnectionState b;
    private h c;

    public i(o o1, RdioConnectionState rdioconnectionstate)
    {
        a = o1;
        b = rdioconnectionstate;
    }

    public final volatile void a(Object obj)
    {
        c.a();
    }

    public final void a(String s)
    {
        if ("Playlist does not exist.".equals(s))
        {
            c.b();
            return;
        } else
        {
            c.a(s);
            return;
        }
    }

    public final void a(String s, List list, h h1)
    {
        c = h1;
        a.a(s, list, this);
    }

    public final void a(List list, h h1)
    {
        a(b.f(), list, h1);
    }
}
