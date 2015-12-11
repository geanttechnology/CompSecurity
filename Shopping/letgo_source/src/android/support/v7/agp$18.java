// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            afl, agp, aff, afx, 
//            afc, aex, afd, afa

static final class nReader extends afl
{

    public afa a(JsonReader jsonreader)
        throws IOException
    {
        afd afd1;
        switch (a[jsonreader.peek().ordinal()])
        {
        default:
            throw new IllegalArgumentException();

        case 3: // '\003'
            return new aff(jsonreader.nextString());

        case 1: // '\001'
            return new aff(new afx(jsonreader.nextString()));

        case 2: // '\002'
            return new aff(Boolean.valueOf(jsonreader.nextBoolean()));

        case 4: // '\004'
            jsonreader.nextNull();
            return afc.a;

        case 5: // '\005'
            aex aex1 = new aex();
            jsonreader.beginArray();
            for (; jsonreader.hasNext(); aex1.a(a(jsonreader))) { }
            jsonreader.endArray();
            return aex1;

        case 6: // '\006'
            afd1 = new afd();
            jsonreader.beginObject();
            break;
        }
        for (; jsonreader.hasNext(); afd1.a(jsonreader.nextName(), a(jsonreader))) { }
        jsonreader.endObject();
        return afd1;
    }

    public void a(JsonWriter jsonwriter, afa afa1)
        throws IOException
    {
        if (afa1 == null || afa1.j())
        {
            jsonwriter.nullValue();
            return;
        }
        if (afa1.i())
        {
            afa1 = afa1.m();
            if (afa1.p())
            {
                jsonwriter.value(afa1.a());
                return;
            }
            if (afa1.o())
            {
                jsonwriter.value(afa1.f());
                return;
            } else
            {
                jsonwriter.value(afa1.b());
                return;
            }
        }
        if (afa1.g())
        {
            jsonwriter.beginArray();
            for (afa1 = afa1.l().iterator(); afa1.hasNext(); a(jsonwriter, (afa)afa1.next())) { }
            jsonwriter.endArray();
            return;
        }
        if (afa1.h())
        {
            jsonwriter.beginObject();
            java.util.ry ry;
            for (afa1 = afa1.k().o().iterator(); afa1.hasNext(); a(jsonwriter, (afa)ry.getValue()))
            {
                ry = (java.util.ry)afa1.next();
                jsonwriter.name((String)ry.getKey());
            }

            jsonwriter.endObject();
            return;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Couldn't write ").append(afa1.getClass()).toString());
        }
    }

    public volatile void a(JsonWriter jsonwriter, Object obj)
        throws IOException
    {
        a(jsonwriter, (afa)obj);
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
