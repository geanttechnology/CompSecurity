// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.internal.gu;
import java.util.Map;

class lang.Object
    implements vd
{

    final sp a;

    public void a(gu gu, Map map)
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

    >(sp sp1)
    {
        a = sp1;
        super();
    }
}
