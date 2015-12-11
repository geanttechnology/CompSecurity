// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.analytics;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.urbanairship.analytics:
//            AssociatedIdentifiers

public class 
{

    private final Map ids = new HashMap();

    public AssociatedIdentifiers create()
    {
        return new AssociatedIdentifiers(this, null);
    }

    public  setAdvertisingId(String s)
    {
        ids.put("com.urbanairship.aaid", s);
        return this;
    }

    public ids setIdentifier(String s, String s1)
    {
        ids.put(s, s1);
        return this;
    }


    public ()
    {
    }
}
