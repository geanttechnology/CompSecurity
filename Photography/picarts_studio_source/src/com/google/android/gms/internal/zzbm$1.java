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

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((String)obj, (String)obj1);
    }

    public int compare(String s, String s1)
    {
        return s1.length() - s.length();
    }

    (zzbm zzbm1)
    {
        zzst = zzbm1;
        super();
    }
}
