// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;

// Referenced classes of package android.support.v7:
//            afl, agp, afi

static final class onReader extends afl
{

    public BigDecimal a(JsonReader jsonreader)
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
            throw new afi(jsonreader);
        }
        return jsonreader;
    }

    public volatile void a(JsonWriter jsonwriter, Object obj)
        throws IOException
    {
        a(jsonwriter, (BigDecimal)obj);
    }

    public void a(JsonWriter jsonwriter, BigDecimal bigdecimal)
        throws IOException
    {
        jsonwriter.value(bigdecimal);
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
