// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseRESTCommand

class ParseRESTSessionCommand extends ParseRESTCommand
{

    private ParseRESTSessionCommand(String s, ParseRequest.Method method, JSONObject jsonobject, String s1)
    {
        super(s, method, jsonobject, s1);
    }

    public static ParseRESTSessionCommand getCurrentSessionCommand(String s)
    {
        return new ParseRESTSessionCommand("sessions/me", ParseRequest.Method.GET, null, s);
    }
}
