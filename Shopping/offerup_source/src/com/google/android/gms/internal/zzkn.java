// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;

class zzkn
    implements com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult
{

    private Status zzSC;
    private ProxyResponse zzST;

    public zzkn(ProxyResponse proxyresponse)
    {
        zzST = proxyresponse;
        zzSC = Status.zzabb;
    }

    public zzkn(Status status)
    {
        zzSC = status;
    }

    public ProxyResponse getResponse()
    {
        return zzST;
    }

    public Status getStatus()
    {
        return zzSC;
    }
}
