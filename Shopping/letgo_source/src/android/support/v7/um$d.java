// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Map;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            ox, um, ul

private class <init>
    implements ox
{

    final um a;

    public void zza(ul ul, Map map)
    {
        if (map.keySet().contains("start"))
        {
            um.a(a);
        } else
        {
            if (map.keySet().contains("stop"))
            {
                um.b(a);
                return;
            }
            if (map.keySet().contains("cancel"))
            {
                um.c(a);
                return;
            }
        }
    }

    private (um um1)
    {
        a = um1;
        super();
    }

    a(um um1, a a1)
    {
        this(um1);
    }
}
