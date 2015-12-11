// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import java.util.Map;

// Referenced classes of package com.google.android.gms.b:
//            ai, al, cj

public class ak
    implements ai
{

    private final al a;

    public ak(al al1)
    {
        a = al1;
    }

    public void a(cj cj, Map map)
    {
        boolean flag = "1".equals(map.get("transparentBackground"));
        a.a(flag);
    }
}
