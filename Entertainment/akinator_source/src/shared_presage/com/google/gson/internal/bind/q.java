// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal.bind;

import shared_presage.com.google.gson.TypeAdapter;
import shared_presage.com.google.gson.stream.JsonReader;
import shared_presage.com.google.gson.stream.JsonToken;
import shared_presage.com.google.gson.stream.JsonWriter;

final class q extends TypeAdapter
{

    q()
    {
    }

    public final Object read(JsonReader jsonreader)
    {
        if (jsonreader.peek() == JsonToken.NULL)
        {
            jsonreader.nextNull();
            return null;
        } else
        {
            return new StringBuilder(jsonreader.nextString());
        }
    }

    public final void write(JsonWriter jsonwriter, Object obj)
    {
        obj = (StringBuilder)obj;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = ((StringBuilder) (obj)).toString();
        }
        jsonwriter.value(((String) (obj)));
    }
}
