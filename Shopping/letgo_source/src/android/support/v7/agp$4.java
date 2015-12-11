// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

// Referenced classes of package android.support.v7:
//            afl, agp, afi

static final class onReader extends afl
{

    public Character a(JsonReader jsonreader)
        throws IOException
    {
        if (jsonreader.peek() == JsonToken.NULL)
        {
            jsonreader.nextNull();
            return null;
        }
        jsonreader = jsonreader.nextString();
        if (jsonreader.length() != 1)
        {
            throw new afi((new StringBuilder()).append("Expecting character, got: ").append(jsonreader).toString());
        } else
        {
            return Character.valueOf(jsonreader.charAt(0));
        }
    }

    public void a(JsonWriter jsonwriter, Character character)
        throws IOException
    {
        if (character == null)
        {
            character = null;
        } else
        {
            character = String.valueOf(character);
        }
        jsonwriter.value(character);
    }

    public volatile void a(JsonWriter jsonwriter, Object obj)
        throws IOException
    {
        a(jsonwriter, (Character)obj);
    }

    public Object b(JsonReader jsonreader)
        throws IOException
    {
        return a(jsonreader);
    }

    onReader()
    {
    }
}
