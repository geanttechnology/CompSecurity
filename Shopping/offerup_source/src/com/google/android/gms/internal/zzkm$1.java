// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.internal:
//            zzkl, zzkk, zzkm

class eApiClient extends zzkl
{

    final ProxyRequest zzSQ;
    final zzkm zzSR;

    protected void zza(Context context, zzkk zzkk1)
    {
        class _cls1 extends zzkh
        {

            final zzkm._cls1 zzSS;

            public void zza(ProxyResponse proxyresponse)
            {
                zzSS.zzb(new zzkn(proxyresponse));
            }

            _cls1()
            {
                zzSS = zzkm._cls1.this;
                super();
            }
        }

        zzkk1.zza(new _cls1(), zzSQ);
    }

    eApiClient(zzkm zzkm, GoogleApiClient googleapiclient, ProxyRequest proxyrequest)
    {
        zzSR = zzkm;
        zzSQ = proxyrequest;
        super(googleapiclient);
    }
}
