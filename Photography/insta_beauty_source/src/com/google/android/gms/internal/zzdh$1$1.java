// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzid

class zzwj
    implements Runnable
{

    final JSONObject zzwj;
    final client.zzb.zzay zzwk;

    public void run()
    {
        zzwk.wh.zzb("fetchHttpRequestCompleted", zzwj);
        zzb.zzay("Dispatched http response.");
    }

    client.zzb(client.zzb zzb1, JSONObject jsonobject)
    {
        zzwk = zzb1;
        zzwj = jsonobject;
        super();
    }
}
