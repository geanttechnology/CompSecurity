// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.y;

import com.shazam.android.y.d.b;
import com.shazam.b.a.e;
import java.util.Set;

// Referenced classes of package com.shazam.android.y:
//            d

final class a
    implements e
{

    final d a;

    public final boolean apply(Object obj)
    {
        obj = (b)obj;
        return obj != null && !a..contains(((b) (obj)).a);
    }

    (d d1)
    {
        a = d1;
        super();
    }
}
