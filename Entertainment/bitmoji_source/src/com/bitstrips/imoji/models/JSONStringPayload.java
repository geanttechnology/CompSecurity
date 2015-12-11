// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.models;

import retrofit.mime.TypedString;

public class JSONStringPayload extends TypedString
{

    public JSONStringPayload(String s)
    {
        super(s);
    }

    public String mimeType()
    {
        return "application/json";
    }
}
