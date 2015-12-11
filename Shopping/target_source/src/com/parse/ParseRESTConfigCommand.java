// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.parse:
//            ParseRESTCommand

class ParseRESTConfigCommand extends ParseRESTCommand
{

    public ParseRESTConfigCommand(String s, com.parse.http.ParseHttpRequest.Method method, Map map, String s1)
    {
        super(s, method, map, s1);
    }

    public static ParseRESTConfigCommand fetchConfigCommand(String s)
    {
        return new ParseRESTConfigCommand("config", com.parse.http.ParseHttpRequest.Method.GET, null, s);
    }

    public static ParseRESTConfigCommand updateConfigCommand(Map map, String s)
    {
        HashMap hashmap = null;
        if (map != null)
        {
            hashmap = new HashMap();
            hashmap.put("params", map);
        }
        return new ParseRESTConfigCommand("config", com.parse.http.ParseHttpRequest.Method.PUT, hashmap, s);
    }
}
