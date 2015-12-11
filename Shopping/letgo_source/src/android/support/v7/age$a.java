// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package android.support.v7:
//            afl, age, ago, afz, 
//            aeu

private static final class b extends afl
{

    private final afl a;
    private final afz b;

    public Collection a(JsonReader jsonreader)
        throws IOException
    {
        if (jsonreader.peek() == JsonToken.NULL)
        {
            jsonreader.nextNull();
            return null;
        }
        Collection collection = (Collection)b.a();
        jsonreader.beginArray();
        for (; jsonreader.hasNext(); collection.add(a.b(jsonreader))) { }
        jsonreader.endArray();
        return collection;
    }

    public volatile void a(JsonWriter jsonwriter, Object obj)
        throws IOException
    {
        a(jsonwriter, (Collection)obj);
    }

    public void a(JsonWriter jsonwriter, Collection collection)
        throws IOException
    {
        if (collection == null)
        {
            jsonwriter.nullValue();
            return;
        }
        jsonwriter.beginArray();
        Object obj;
        for (collection = collection.iterator(); collection.hasNext(); a.a(jsonwriter, obj))
        {
            obj = collection.next();
        }

        jsonwriter.endArray();
    }

    public Object b(JsonReader jsonreader)
        throws IOException
    {
        return a(jsonreader);
    }

    public onReader(aeu aeu, Type type, afl afl1, afz afz1)
    {
        a = new ago(aeu, afl1, type);
        b = afz1;
    }
}
