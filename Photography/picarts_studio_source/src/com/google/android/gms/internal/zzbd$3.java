// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzbd, zziz

class zzrJ
    implements Runnable
{

    final zzbd zzrH;
    final String zzrJ;

    public void run()
    {
        zzbd.zza(zzrH).loadData(zzrJ, "text/html", "UTF-8");
    }

    (zzbd zzbd1, String s)
    {
        zzrH = zzbd1;
        zzrJ = s;
        super();
    }
}
