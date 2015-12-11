// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.a;

import java.util.Comparator;

// Referenced classes of package com.shazam.android.a:
//            f

public final class a
    implements Comparator
{

    final f a;

    public final volatile int compare(Object obj, Object obj1)
    {
        obj = (a)obj;
        obj1 = (a)obj1;
        if (((a) (obj)).a == ((a) (obj1)).a)
        {
            return 0;
        }
        return ((a) (obj)).a >= ((a) (obj1)).a ? 1 : -1;
    }

    public (f f1)
    {
        a = f1;
        super();
    }
}
