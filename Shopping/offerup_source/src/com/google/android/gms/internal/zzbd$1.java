// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzbd, zziz

class zzrG
    implements Runnable
{

    final String zzrF;
    final JSONObject zzrG;
    final zzbd zzrH;

    public void run()
    {
        zzbd.zza(zzrH).zza(zzrF, zzrG);
    }

    (zzbd zzbd1, String s, JSONObject jsonobject)
    {
        zzrH = zzbd1;
        zzrF = s;
        zzrG = jsonobject;
        super();
    }
}
