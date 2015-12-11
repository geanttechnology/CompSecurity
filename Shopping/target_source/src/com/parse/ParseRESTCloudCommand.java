// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.Map;

// Referenced classes of package com.parse:
//            ParseRESTCommand

class ParseRESTCloudCommand extends ParseRESTCommand
{

    private ParseRESTCloudCommand(String s, com.parse.http.ParseHttpRequest.Method method, Map map, String s1)
    {
        super(s, method, map, s1);
    }

    public static ParseRESTCloudCommand callFunctionCommand(String s, Map map, String s1)
    {
        return new ParseRESTCloudCommand(String.format("functions/%s", new Object[] {
            s
        }), com.parse.http.ParseHttpRequest.Method.POST, map, s1);
    }
}
