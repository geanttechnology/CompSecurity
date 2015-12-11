// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal.bind;

import shared_presage.com.google.gson.JsonSyntaxException;
import shared_presage.com.google.gson.TypeAdapter;
import shared_presage.com.google.gson.stream.JsonReader;
import shared_presage.com.google.gson.stream.JsonToken;
import shared_presage.com.google.gson.stream.JsonWriter;

final class K extends TypeAdapter
{

    K()
    {
    }

    private static Number a(JsonReader jsonreader)
    {
        if (jsonreader.peek() == JsonToken.NULL)
        {
            jsonreader.nextNull();
            return null;
        }
        byte byte0;
        try
        {
            byte0 = (byte)jsonreader.nextInt();
        }
        // Misplaced declaration of an exception variable
        catch (JsonReader jsonreader)
        {
            throw new JsonSyntaxException(jsonreader);
        }
        return Byte.valueOf(byte0);
    }

    public final Object read(JsonReader jsonreader)
    {
        return a(jsonreader);
    }

    public final void write(JsonWriter jsonwriter, Object obj)
    {
        jsonwriter.value((Number)obj);
    }
}
