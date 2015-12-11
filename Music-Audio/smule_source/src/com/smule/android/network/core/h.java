// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.core;

import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpParams;

// Referenced classes of package com.smule.android.network.core:
//            f

class h extends ThreadSafeClientConnManager
{

    public h(HttpParams httpparams, SchemeRegistry schemeregistry)
    {
        super(httpparams, schemeregistry);
    }

    public ClientConnectionRequest requestConnection(HttpRoute httproute, Object obj)
    {
        f.a(this, 20, 5);
        return super.requestConnection(httproute, obj);
    }
}
