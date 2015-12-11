// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.InetAddress;

// Referenced classes of package android.support.v7:
//            afl, agp

static final class nReader extends afl
{

    public InetAddress a(JsonReader jsonreader)
        throws IOException
    {
        if (jsonreader.peek() == JsonToken.NULL)
        {
            jsonreader.nextNull();
            return null;
        } else
        {
            return InetAddress.getByName(jsonreader.nextString());
        }
    }

    public volatile void a(JsonWriter jsonwriter, Object obj)
        throws IOException
    {
        a(jsonwriter, (InetAddress)obj);
    }

    public void a(JsonWriter jsonwriter, InetAddress inetaddress)
        throws IOException
    {
        if (inetaddress == null)
        {
            inetaddress = null;
        } else
        {
            inetaddress = inetaddress.getHostAddress();
        }
        jsonwriter.value(inetaddress);
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
