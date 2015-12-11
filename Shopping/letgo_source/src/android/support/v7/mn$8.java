// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Map;

// Referenced classes of package android.support.v7:
//            ox, mn, ul

class a
    implements ox
{

    final mn a;

    public void zza(ul ul, Map map)
    {
        while (!a.a(map) || !map.containsKey("isVisible")) 
        {
            return;
        }
        boolean flag;
        if ("1".equals(map.get("isVisible")) || "true".equals(map.get("isVisible")))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.a(Boolean.valueOf(flag).booleanValue());
    }

    (mn mn1)
    {
        a = mn1;
        super();
    }
}
