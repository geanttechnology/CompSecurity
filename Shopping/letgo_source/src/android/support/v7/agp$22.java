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

static final class nReader extends afl
{

    public Boolean a(JsonReader jsonreader)
        throws IOException
    {
        if (jsonreader.peek() == JsonToken.NULL)
        {
            jsonreader.nextNull();
            return null;
        }
        if (jsonreader.peek() == JsonToken.STRING)
        {
            return Boolean.valueOf(Boolean.parseBoolean(jsonreader.nextString()));
        } else
        {
            return Boolean.valueOf(jsonreader.nextBoolean());
        }
    }

    public void a(JsonWriter jsonwriter, Boolean boolean1)
        throws IOException
    {
        if (boolean1 == null)
        {
            jsonwriter.nullValue();
            return;
        } else
        {
            jsonwriter.value(boolean1.booleanValue());
            return;
        }
    }

    public volatile void a(JsonWriter jsonwriter, Object obj)
        throws IOException
    {
        a(jsonwriter, (Boolean)obj);
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
