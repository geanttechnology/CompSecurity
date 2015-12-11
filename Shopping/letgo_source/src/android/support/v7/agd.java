// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.support.v7:
//            afl, ago, afm, aeu, 
//            agq, aft

public final class agd extends afl
{

    public static final afm a = new afm() {

        public afl a(aeu aeu1, agq agq1)
        {
            agq1 = agq1.b();
            if (!(agq1 instanceof GenericArrayType) && (!(agq1 instanceof Class) || !((Class)agq1).isArray()))
            {
                return null;
            } else
            {
                agq1 = aft.g(agq1);
                return new agd(aeu1, aeu1.a(agq.a(agq1)), aft.e(agq1));
            }
        }

    };
    private final Class b;
    private final afl c;

    public agd(aeu aeu, afl afl1, Class class1)
    {
        c = new ago(aeu, afl1, class1);
        b = class1;
    }

    public void a(JsonWriter jsonwriter, Object obj)
        throws IOException
    {
        if (obj == null)
        {
            jsonwriter.nullValue();
            return;
        }
        jsonwriter.beginArray();
        int i = 0;
        for (int j = Array.getLength(obj); i < j; i++)
        {
            Object obj1 = Array.get(obj, i);
            c.a(jsonwriter, obj1);
        }

        jsonwriter.endArray();
    }

    public Object b(JsonReader jsonreader)
        throws IOException
    {
        if (jsonreader.peek() == JsonToken.NULL)
        {
            jsonreader.nextNull();
            return null;
        }
        ArrayList arraylist = new ArrayList();
        jsonreader.beginArray();
        for (; jsonreader.hasNext(); arraylist.add(c.b(jsonreader))) { }
        jsonreader.endArray();
        jsonreader = ((JsonReader) (Array.newInstance(b, arraylist.size())));
        for (int i = 0; i < arraylist.size(); i++)
        {
            Array.set(jsonreader, i, arraylist.get(i));
        }

        return jsonreader;
    }

}
