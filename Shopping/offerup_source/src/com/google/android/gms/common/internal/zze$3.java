// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import java.util.Arrays;

// Referenced classes of package com.google.android.gms.common.internal:
//            zze

final class nit> extends zze
{

    final char zzafc[];

    public final boolean zzd(char c)
    {
        return Arrays.binarySearch(zzafc, c) >= 0;
    }

    (char ac[])
    {
        zzafc = ac;
        super();
    }
}
