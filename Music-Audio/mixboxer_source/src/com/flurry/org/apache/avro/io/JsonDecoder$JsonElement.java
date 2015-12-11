// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;

import com.flurry.org.codehaus.jackson.JsonToken;

// Referenced classes of package com.flurry.org.apache.avro.io:
//            JsonDecoder

private static class value
{

    public final JsonToken token;
    public final String value;

    public (JsonToken jsontoken)
    {
        this(jsontoken, null);
    }

    public <init>(JsonToken jsontoken, String s)
    {
        token = jsontoken;
        value = s;
    }
}
