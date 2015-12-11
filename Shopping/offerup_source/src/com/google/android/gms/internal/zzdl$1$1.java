// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zziz

class zzxD
    implements Runnable
{

    final JSONObject zzxD;
    final client.zzb.zzaF zzxE;

    public void run()
    {
        zzxE.xB.zzb("fetchHttpRequestCompleted", zzxD);
        zzb.zzaF("Dispatched http response.");
    }

    client.zzb(client.zzb zzb1, JSONObject jsonobject)
    {
        zzxE = zzb1;
        zzxD = jsonobject;
        super();
    }
}
