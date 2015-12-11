// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.List;

// Referenced classes of package com.parse:
//            ParseObject

class ParsePin extends ParseObject
{

    static final String KEY_NAME = "_name";
    private static final String KEY_OBJECTS = "_objects";

    public ParsePin()
    {
    }

    public String getName()
    {
        return getString("_name");
    }

    public List getObjects()
    {
        return getList("_objects");
    }

    boolean needsDefaultACL()
    {
        return false;
    }

    public void setName(String s)
    {
        put("_name", s);
    }

    public void setObjects(List list)
    {
        put("_objects", list);
    }
}
