// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Arrays;

// Referenced classes of package com.google.android.gms.internal:
//            zzrx

final class zzsg
{

    final int tag;
    final byte zzbiw[];

    zzsg(int i, byte abyte0[])
    {
        tag = i;
        zzbiw = abyte0;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof zzsg))
            {
                return false;
            }
            obj = (zzsg)obj;
            if (tag != ((zzsg) (obj)).tag || !Arrays.equals(zzbiw, ((zzsg) (obj)).zzbiw))
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        return (tag + 527) * 31 + Arrays.hashCode(zzbiw);
    }

    final int zzB()
    {
        return zzrx.zzlO(tag) + 0 + zzbiw.length;
    }

    final void zza(zzrx zzrx1)
    {
        zzrx1.zzlN(tag);
        zzrx1.zzF(zzbiw);
    }
}
