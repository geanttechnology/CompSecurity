// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzbd, zziz

class zzrC
    implements Runnable
{

    final String zzrC;
    final zzbd zzrH;

    public void run()
    {
        zzbd.zza(zzrH).loadUrl(zzrC);
    }

    (zzbd zzbd1, String s)
    {
        zzrH = zzbd1;
        zzrC = s;
        super();
    }
}
