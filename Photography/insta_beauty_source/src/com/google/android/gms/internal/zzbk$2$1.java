// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.webkit.ValueCallback;

// Referenced classes of package com.google.android.gms.internal:
//            zzbk

class zzrH
    implements ValueCallback
{

    final rG zzrH;

    public void onReceiveValue(Object obj)
    {
        zzx((String)obj);
    }

    public void zzx(String s)
    {
        zzrH.rD.zza(zzrH.rF, zzrH.rG, s);
    }

    ( )
    {
        zzrH = ;
        super();
    }
}
