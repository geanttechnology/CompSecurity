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

    protected final zzl zzWK;
    private final String zzWL;
    private zzn zzWM;

    protected zzd(String s, String s1, String s2)
    {
        zzf.zzbL(s);
        zzWL = s;
        zzWK = new zzl(s1);
        setSessionLabel(s2);
    }

    public final String getNamespace()
    {
        return zzWL;
    }

    public void setSessionLabel(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            zzWK.zzbR(s);
        }
    }

    public final void zza(zzn zzn1)
    {
        zzWM = zzn1;
        if (zzWM == null)
        {
            zzmt();
        }
    }

    protected final void zza(String s, long l, String s1)
        throws IOException
    {
        zzWK.zza("Sending text message: %s to: %s", new Object[] {
            s, s1
        });
        zzWM.zza(zzWL, s, l, s1);
    }

    public void zzb(long l, int i)
    {
    }

    public void zzbJ(String s)
    {
    }

    public void zzmt()
    {
    }

    protected final long zzmu()
    {
        return zzWM.zzme();
    }
}
