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

static final class nReader extends afl
{

    public Number a(JsonReader jsonreader)
        throws IOException
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
            throw new afi(jsonreader);
        }
        return Byte.valueOf(byte0);
    }

    public void a(JsonWriter jsonwriter, Number number)
        throws IOException
    {
        jsonwriter.value(number);
    }

    public volatile void a(JsonWriter jsonwriter, Object obj)
        throws IOException
    {
        a(jsonwriter, (Number)obj);
    }

    public Object b(JsonReader jsonreader)
        throws IOException
    {
        return a(jsonreader);
    }

    nReader()
    {
    }
}
