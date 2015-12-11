// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;


// Referenced classes of package com.google.android.gms.common.internal:
//            zze

final class it> extends zze
{

    final char zzaff;

    public final zze zza(zze zze1)
    {
        if (zze1.zzd(zzaff))
        {
            return zze1;
        } else
        {
            return super.zza(zze1);
        }
    }

    public final boolean zzd(char c)
    {
        return c == zzaff;
    }

    (char c)
    {
        zzaff = c;
        super();
    }
}
