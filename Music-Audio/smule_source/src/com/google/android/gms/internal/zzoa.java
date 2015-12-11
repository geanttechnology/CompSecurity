// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Arrays;

// Referenced classes of package com.google.android.gms.internal:
//            zznr

final class zzoa
{

    final int tag;
    final byte zzaNU[];

    zzoa(int i, byte abyte0[])
    {
        tag = i;
        zzaNU = abyte0;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof zzoa))
            {
                return false;
            }
            obj = (zzoa)obj;
            if (tag != ((zzoa) (obj)).tag || !Arrays.equals(zzaNU, ((zzoa) (obj)).zzaNU))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return (tag + 527) * 31 + Arrays.hashCode(zzaNU);
    }

    void zza(zznr zznr1)
    {
        zznr1.zzjy(tag);
        zznr1.zzz(zzaNU);
    }

    int zzc()
    {
        return 0 + zznr.zzjz(tag) + zzaNU.length;
    }
}
