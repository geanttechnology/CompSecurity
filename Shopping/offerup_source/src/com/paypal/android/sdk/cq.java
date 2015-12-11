// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.UUID;

// Referenced classes of package com.paypal.android.sdk:
//            eg, ez, eb, ed, 
//            dj

public final class cq
{

    public ez a;
    public eb b;
    public String c;
    public ed d;
    public dj e;
    public eb f;
    public boolean g;
    public String h;

    public cq()
    {
        new eg();
        a = new ez();
        UUID.randomUUID().toString();
    }

    public final boolean a()
    {
        return b != null && b.b();
    }

    public final String toString()
    {
        return (new StringBuilder("BackendState(accessTokenState:")).append(b).append(" loginAccessToken:").append(f).append(")").toString();
    }
}
