// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal.bind;

import shared_presage.com.google.gson.JsonSyntaxException;
import shared_presage.com.google.gson.TypeAdapter;
import shared_presage.com.google.gson.internal.LazilyParsedNumber;
import shared_presage.com.google.gson.stream.JsonReader;
import shared_presage.com.google.gson.stream.JsonToken;
import shared_presage.com.google.gson.stream.JsonWriter;

final class l extends TypeAdapter
{

    l()
    {
    }

    public final Object read(JsonReader jsonreader)
    {
        JsonToken jsontoken = jsonreader.peek();
        switch (TypeAdapters._cls1.a[jsontoken.ordinal()])
        {
        case 2: // '\002'
        case 3: // '\003'
        default:
            throw new JsonSyntaxException((new StringBuilder("Expecting number, got: ")).append(jsontoken).toString());

        case 4: // '\004'
            jsonreader.nextNull();
            return null;

        case 1: // '\001'
            return new LazilyParsedNumber(jsonreader.nextString());
        }
    }

    public final void write(JsonWriter jsonwriter, Object obj)
    {
        jsonwriter.value((Number)obj);
    }
}
