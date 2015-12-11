// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

// Referenced classes of package android.support.v7:
//            afl, agp

static final class onReader extends afl
{

    public StringBuffer a(JsonReader jsonreader)
        throws IOException
    {
        if (jsonreader.peek() == JsonToken.NULL)
        {
            jsonreader.nextNull();
            return null;
        } else
        {
            return new StringBuffer(jsonreader.nextString());
        }
    }

    public volatile void a(JsonWriter jsonwriter, Object obj)
        throws IOException
    {
        a(jsonwriter, (StringBuffer)obj);
    }

    public void a(JsonWriter jsonwriter, StringBuffer stringbuffer)
        throws IOException
    {
        if (stringbuffer == null)
        {
            stringbuffer = null;
        } else
        {
            stringbuffer = stringbuffer.toString();
        }
        jsonwriter.value(stringbuffer);
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
