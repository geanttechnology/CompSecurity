// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            afl, agj, ago, afa, 
//            aff, afz, afi, afw, 
//            agb, aeu

private final class d extends afl
{

    final agj a;
    private final afl b;
    private final afl c;
    private final afz d;

    private String a(afa afa1)
    {
        if (afa1.i())
        {
            afa1 = afa1.m();
            if (afa1.p())
            {
                return String.valueOf(afa1.a());
            }
            if (afa1.o())
            {
                return Boolean.toString(afa1.f());
            }
            if (afa1.q())
            {
                return afa1.b();
            } else
            {
                throw new AssertionError();
            }
        }
        if (afa1.j())
        {
            return "null";
        } else
        {
            throw new AssertionError();
        }
    }

    public Map a(JsonReader jsonreader)
        throws IOException
    {
        JsonToken jsontoken = jsonreader.peek();
        if (jsontoken == JsonToken.NULL)
        {
            jsonreader.nextNull();
            return null;
        }
        Map map = (Map)d.a();
        if (jsontoken == JsonToken.BEGIN_ARRAY)
        {
            jsonreader.beginArray();
            for (; jsonreader.hasNext(); jsonreader.endArray())
            {
                jsonreader.beginArray();
                Object obj = b.b(jsonreader);
                if (map.put(obj, c.b(jsonreader)) != null)
                {
                    throw new afi((new StringBuilder()).append("duplicate key: ").append(obj).toString());
                }
            }

            jsonreader.endArray();
            return map;
        }
        jsonreader.beginObject();
        while (jsonreader.hasNext()) 
        {
            afw.INSTANCE.promoteNameToValue(jsonreader);
            Object obj1 = b.b(jsonreader);
            if (map.put(obj1, c.b(jsonreader)) != null)
            {
                throw new afi((new StringBuilder()).append("duplicate key: ").append(obj1).toString());
            }
        }
        jsonreader.endObject();
        return map;
    }

    public volatile void a(JsonWriter jsonwriter, Object obj)
        throws IOException
    {
        a(jsonwriter, (Map)obj);
    }

    public void a(JsonWriter jsonwriter, Map map)
        throws IOException
    {
        boolean flag3 = false;
        boolean flag2 = false;
        if (map == null)
        {
            jsonwriter.nullValue();
            return;
        }
        if (!agj.a(a))
        {
            jsonwriter.beginObject();
            java.util.try try1;
            for (map = map.entrySet().iterator(); map.hasNext(); c.a(jsonwriter, try1.getValue()))
            {
                try1 = (java.util.try)map.next();
                jsonwriter.name(String.valueOf(try1.getKey()));
            }

            jsonwriter.endObject();
            return;
        }
        ArrayList arraylist = new ArrayList(map.size());
        ArrayList arraylist1 = new ArrayList(map.size());
        map = map.entrySet().iterator();
        boolean flag = false;
        while (map.hasNext()) 
        {
            java.util.try try2 = (java.util.try)map.next();
            afa afa1 = b.a(try2.getKey());
            arraylist.add(afa1);
            arraylist1.add(try2.getValue());
            boolean flag1;
            if (afa1.g() || afa1.h())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag = flag1 | flag;
        }
        if (flag)
        {
            jsonwriter.beginArray();
            for (int i = ((flag2) ? 1 : 0); i < arraylist.size(); i++)
            {
                jsonwriter.beginArray();
                agb.a((afa)arraylist.get(i), jsonwriter);
                c.a(jsonwriter, arraylist1.get(i));
                jsonwriter.endArray();
            }

            jsonwriter.endArray();
            return;
        }
        jsonwriter.beginObject();
        for (int j = ((flag3) ? 1 : 0); j < arraylist.size(); j++)
        {
            jsonwriter.name(a((afa)arraylist.get(j)));
            c.a(jsonwriter, arraylist1.get(j));
        }

        jsonwriter.endObject();
    }

    public Object b(JsonReader jsonreader)
        throws IOException
    {
        return a(jsonreader);
    }

    public onReader(agj agj1, aeu aeu, Type type, afl afl1, Type type1, afl afl2, afz afz1)
    {
        a = agj1;
        super();
        b = new ago(aeu, afl1, type);
        c = new ago(aeu, afl2, type1);
        d = afz1;
    }
}
