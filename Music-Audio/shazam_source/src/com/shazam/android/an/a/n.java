// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.a;

import com.shazam.android.an.u;
import com.shazam.android.an.v;
import com.shazam.model.rdio.RdioCallback;
import com.shazam.model.rdio.RdioConnectionState;
import com.shazam.model.rdio.RdioUser;

// Referenced classes of package com.shazam.android.an.a:
//            o

public final class n
    implements u, RdioCallback
{

    private final o a;
    private final RdioConnectionState b;
    private v c;

    public n(o o1, RdioConnectionState rdioconnectionstate)
    {
        c = new com.shazam.android.an.v.a();
        a = o1;
        b = rdioconnectionstate;
    }

    public final void a(v v1)
    {
        c = v1;
        a.b(this);
    }

    public final volatile void a(Object obj)
    {
        obj = (RdioUser)obj;
        c.a(obj);
        b.a(((RdioUser) (obj)).subscriptionType);
    }

    public final void a(String s)
    {
        c.c();
    }
}
