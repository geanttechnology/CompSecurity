// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson;


// Referenced classes of package org.codehaus.jackson:
//            JsonProcessingException, JsonLocation

public class JsonParseException extends JsonProcessingException
{

    public JsonParseException(String s, JsonLocation jsonlocation)
    {
        super(s, jsonlocation);
    }

    public JsonParseException(String s, JsonLocation jsonlocation, Throwable throwable)
    {
        super(s, jsonlocation, throwable);
    }
}
