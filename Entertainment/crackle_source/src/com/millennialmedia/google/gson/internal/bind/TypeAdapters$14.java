// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal.bind;

import com.millennialmedia.google.gson.JsonSyntaxException;
import com.millennialmedia.google.gson.TypeAdapter;
import com.millennialmedia.google.gson.stream.JsonReader;
import com.millennialmedia.google.gson.stream.JsonToken;
import com.millennialmedia.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;

// Referenced classes of package com.millennialmedia.google.gson.internal.bind:
//            TypeAdapters

static final class  extends TypeAdapter
{

    public volatile Object read(JsonReader jsonreader)
        throws IOException
    {
        return read(jsonreader);
    }

    public BigDecimal read(JsonReader jsonreader)
        throws IOException
    {
        if (jsonreader.peek() == JsonToken.NULL)
        {
            jsonreader.nextNull();
            return null;
        }
        try
        {
            jsonreader = new BigDecimal(jsonreader.nextString());
        }
        // Misplaced declaration of an exception variable
        catch (JsonReader jsonreader)
        {
            throw new JsonSyntaxException(jsonreader);
        }
        return jsonreader;
    }

    public volatile void write(JsonWriter jsonwriter, Object obj)
        throws IOException
    {
        write(jsonwriter, (BigDecimal)obj);
    }

    public void write(JsonWriter jsonwriter, BigDecimal bigdecimal)
        throws IOException
    {
        jsonwriter.value(bigdecimal);
    }

    ()
    {
    }
}
