// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseUser

static class init> extends init>
{

    public init> authData(Map map)
    {
        return (init>)put("authData", map);
    }

    public volatile put build()
    {
        return build();
    }

    public build build()
    {
        return new build(this, null);
    }

    public build putAuthData(String s, Map map)
    {
        Map map1 = (Map)serverData.get("authData");
        Object obj = map1;
        if (map1 == null)
        {
            obj = new HashMap();
        }
        ((Map) (obj)).put(s, map);
        serverData.put("authData", obj);
        return this;
    }

    volatile serverData self()
    {
        return self();
    }

    self self()
    {
        return this;
    }

    public self sessionToken(String s)
    {
        return (self)put("sessionToken", s);
    }

    ( )
    {
        super();
    }

    public init>(String s)
    {
        super(s);
    }
}
