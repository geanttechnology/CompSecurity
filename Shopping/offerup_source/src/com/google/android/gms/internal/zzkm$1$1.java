// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.auth.api.proxy.ProxyResponse;

// Referenced classes of package com.google.android.gms.internal:
//            zzkh, zzkn

class t> extends zzkh
{

    final xyResponse zzSS;

    public void zza(ProxyResponse proxyresponse)
    {
        zzSS.b(new zzkn(proxyresponse));
    }

    xyResponse(xyResponse xyresponse)
    {
        zzSS = xyresponse;
        super();
    }
}
