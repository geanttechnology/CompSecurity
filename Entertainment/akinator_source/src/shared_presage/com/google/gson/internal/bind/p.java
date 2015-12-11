// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal.bind;

import java.math.BigInteger;
import shared_presage.com.google.gson.JsonSyntaxException;
import shared_presage.com.google.gson.TypeAdapter;
import shared_presage.com.google.gson.stream.JsonReader;
import shared_presage.com.google.gson.stream.JsonToken;
import shared_presage.com.google.gson.stream.JsonWriter;

final class p extends TypeAdapter
{

    p()
    {
    }

    private static BigInteger a(JsonReader jsonreader)
    {
        if (jsonreader.peek() == JsonToken.NULL)
        {
            jsonreader.nextNull();
            return null;
        }
        try
        {
            jsonreader = new BigInteger(jsonreader.nextString());
        }
        // Misplaced declaration of an exception variable
        catch (JsonReader jsonreader)
        {
            throw new JsonSyntaxException(jsonreader);
        }
        return jsonreader;
    }

    public final Object read(JsonReader jsonreader)
    {
        return a(jsonreader);
    }

    public final void write(JsonWriter jsonwriter, Object obj)
    {
        jsonwriter.value((BigInteger)obj);
    }
}
