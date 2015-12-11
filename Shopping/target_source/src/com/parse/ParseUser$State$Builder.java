// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseUser

static class isNew extends isNew
{

    private boolean isNew;

    public volatile isNew apply(isNew isnew)
    {
        return apply(isnew);
    }

    public apply apply(apply apply1)
    {
        isNew(((isNew)apply1).isNew());
        return (isNew)super.pply(apply1);
    }

    public pply authData(Map map)
    {
        return (pply)put("authData", map);
    }

    public volatile put build()
    {
        return build();
    }

    public build build()
    {
        return new build(this, null);
    }

    public build isNew(boolean flag)
    {
        isNew = flag;
        return this;
    }

    public isNew putAuthData(String s, Map map)
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


    public ()
    {
        super("_User");
    }

    init>(init> init>)
    {
        super(init>);
        isNew = init>.isNew();
    }
}
