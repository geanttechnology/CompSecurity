// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast.internal;

import android.text.TextUtils;
import java.io.IOException;

// Referenced classes of package com.google.android.gms.cast.internal:
//            zzf, zzl, zzn

public abstract class zzd
{

    protected final zzl zzYC;
    private final String zzYD;
    private zzn zzYE;

    protected zzd(String s, String s1, String s2)
    {
        zzf.zzbM(s);
        zzYD = s;
        zzYC = new zzl(s1);
        setSessionLabel(s2);
    }

    public final String getNamespace()
    {
        return zzYD;
    }

    public void setSessionLabel(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            zzYC.zzbS(s);
        }
    }

    public final void zza(zzn zzn1)
    {
        zzYE = zzn1;
        if (zzYE == null)
        {
            zzmP();
        }
    }

    protected final void zza(String s, long l, String s1)
        throws IOException
    {
        zzYC.zza("Sending text message: %s to: %s", new Object[] {
            s, s1
        });
        zzYE.zza(zzYD, s, l, s1);
    }

    public void zzb(long l, int i)
    {
    }

    public void zzbK(String s)
    {
    }

    public void zzmP()
    {
    }

    protected final long zzmQ()
    {
        return zzYE.zzmA();
    }
}
