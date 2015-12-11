// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzx;

public class zzkm
    implements ProxyApi
{

    public zzkm()
    {
    }

    public PendingResult performProxyRequest(GoogleApiClient googleapiclient, ProxyRequest proxyrequest)
    {
        zzx.zzw(googleapiclient);
        zzx.zzw(proxyrequest);
        return googleapiclient.zzb(new _cls1(googleapiclient, proxyrequest));
    }

    private class _cls1 extends zzkl
    {

        final ProxyRequest zzSQ;
        final zzkm zzSR;

        protected void zza(Context context, zzkk zzkk1)
        {
            class _cls1 extends zzkh
            {

                final _cls1 zzSS;

                public void zza(ProxyResponse proxyresponse)
                {
                    zzSS.zzb(new zzkn(proxyresponse));
                }

                _cls1()
                {
                    zzSS = _cls1.this;
                    super();
                }
            }

            zzkk1.zza(new _cls1(), zzSQ);
        }

        _cls1(GoogleApiClient googleapiclient, ProxyRequest proxyrequest)
        {
            zzSR = zzkm.this;
            zzSQ = proxyrequest;
            super(googleapiclient);
        }
    }

}
