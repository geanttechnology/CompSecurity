// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import java.util.Comparator;

// Referenced classes of package com.google.android.gms.d:
//            iw, iy

final class a
    implements Comparator
{

    final iw a;

    public final int compare(Object obj, Object obj1)
    {
        obj = (iy)obj;
        obj1 = (iy)obj1;
        return obj.getClass().getCanonicalName().compareTo(obj1.getClass().getCanonicalName());
    }

    (iw iw1)
    {
        a = iw1;
        super();
    }
}
