// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import java.util.Map;

// Referenced classes of package com.google.android.gms.d:
//            ce, ci, he

public final class ch
    implements ce
{

    private final ci a;

    public ch(ci ci1)
    {
        a = ci1;
    }

    public final void a(he he, Map map)
    {
        boolean flag = "1".equals(map.get("transparentBackground"));
        a.b(flag);
    }
}
