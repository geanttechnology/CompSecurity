// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Comparator;

// Referenced classes of package com.google.android.gms.internal:
//            zzbm

class zzst
    implements Comparator
{

    final zzbm zzst;

    public int compare(Object obj, Object obj1)
    {
        return zza((a)obj, (a)obj1);
    }

    public int zza(a a, a a1)
    {
        return (int)(a.value - a1.value);
    }

    a(zzbm zzbm)
    {
        zzst = zzbm;
        super();
    }
}
