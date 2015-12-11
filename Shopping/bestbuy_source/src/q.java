// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class q
{

    private static Map a;

    public static Map a()
    {
        return a;
    }

    static 
    {
        HashMap hashmap = new HashMap(2);
        a = hashmap;
        hashmap.put("ADRUM", Collections.singletonList("isAjax:true"));
        a.put("ADRUM_1", Collections.singletonList("isMobile:true"));
        a = Collections.unmodifiableMap(a);
    }
}
