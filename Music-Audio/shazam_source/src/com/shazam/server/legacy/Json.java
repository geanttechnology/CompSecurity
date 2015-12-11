// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.legacy;


public class Json
{

    private String jsonString;

    public Json()
    {
    }

    public Json(String s)
    {
        jsonString = s;
    }

    public String getJsonString()
    {
        return jsonString;
    }

    public String toString()
    {
        return (new StringBuilder("Json{jsonString='")).append(jsonString).append('\'').append('}').toString();
    }
}
