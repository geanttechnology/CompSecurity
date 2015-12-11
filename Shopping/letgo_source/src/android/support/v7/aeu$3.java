// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

// Referenced classes of package android.support.v7:
//            afl, aeu

class nit> extends afl
{

    final aeu a;

    public Double a(JsonReader jsonreader)
        throws IOException
    {
        if (jsonreader.peek() == JsonToken.NULL)
        {
            jsonreader.nextNull();
            return null;
        } else
        {
            return Double.valueOf(jsonreader.nextDouble());
        }
    }

    public void a(JsonWriter jsonwriter, Number number)
        throws IOException
    {
        if (number == null)
        {
            jsonwriter.nullValue();
            return;
        } else
        {
            double d = number.doubleValue();
            aeu.a(a, d);
            jsonwriter.value(number);
            return;
        }
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

    onReader(aeu aeu1)
    {
        a = aeu1;
        super();
    }
}
