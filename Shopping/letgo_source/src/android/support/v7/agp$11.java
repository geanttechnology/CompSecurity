// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

// Referenced classes of package android.support.v7:
//            afl, agp, afb

static final class nReader extends afl
{

    public URI a(JsonReader jsonreader)
        throws IOException
    {
        if (jsonreader.peek() != JsonToken.NULL) goto _L2; else goto _L1
_L1:
        jsonreader.nextNull();
_L4:
        return null;
_L2:
        jsonreader = jsonreader.nextString();
        if ("null".equals(jsonreader)) goto _L4; else goto _L3
_L3:
        jsonreader = new URI(jsonreader);
        return jsonreader;
        jsonreader;
        throw new afb(jsonreader);
    }

    public volatile void a(JsonWriter jsonwriter, Object obj)
        throws IOException
    {
        a(jsonwriter, (URI)obj);
    }

    public void a(JsonWriter jsonwriter, URI uri)
        throws IOException
    {
        if (uri == null)
        {
            uri = null;
        } else
        {
            uri = uri.toASCIIString();
        }
        jsonwriter.value(uri);
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
