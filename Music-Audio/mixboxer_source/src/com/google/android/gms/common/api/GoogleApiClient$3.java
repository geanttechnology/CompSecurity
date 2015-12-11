// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Bundle;

// Referenced classes of package com.google.android.gms.common.api:
//            GoogleApiClient

class nq
    implements com.google.android.gms.internal._cls3
{

    final GoogleApiClient nq;

    public Bundle aU()
    {
        return null;
    }

    public boolean bp()
    {
        return GoogleApiClient.g(nq);
    }

    public boolean isConnected()
    {
        return nq.isConnected();
    }

    _cls9(GoogleApiClient googleapiclient)
    {
        nq = googleapiclient;
        super();
    }
}
