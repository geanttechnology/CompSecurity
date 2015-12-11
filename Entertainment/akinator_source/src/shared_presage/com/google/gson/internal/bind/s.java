// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal.bind;

import java.net.URL;
import shared_presage.com.google.gson.TypeAdapter;
import shared_presage.com.google.gson.stream.JsonReader;
import shared_presage.com.google.gson.stream.JsonToken;
import shared_presage.com.google.gson.stream.JsonWriter;

final class s extends TypeAdapter
{

    s()
    {
    }

    public final Object read(JsonReader jsonreader)
    {
        if (jsonreader.peek() == JsonToken.NULL)
        {
            jsonreader.nextNull();
        } else
        {
            jsonreader = jsonreader.nextString();
            if (!"null".equals(jsonreader))
            {
                return new URL(jsonreader);
            }
        }
        return null;
    }

    public final void write(JsonWriter jsonwriter, Object obj)
    {
        obj = (URL)obj;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = ((URL) (obj)).toExternalForm();
        }
        jsonwriter.value(((String) (obj)));
    }
}
