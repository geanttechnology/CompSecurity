// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzbd, zziz

class zzrI
    implements Runnable
{

    final String zzrF;
    final zzbd zzrH;
    final String zzrI;

    public void run()
    {
        zzbd.zza(zzrH).zza(zzrF, zzrI);
    }

    (zzbd zzbd1, String s, String s1)
    {
        zzrH = zzbd1;
        zzrF = s;
        zzrI = s1;
        super();
    }
}
