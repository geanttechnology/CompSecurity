// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            afl, aeu, afy, afm, 
//            agq

public final class agk extends afl
{

    public static final afm a = new afm() {

        public afl a(aeu aeu1, agq agq1)
        {
            if (agq1.a() == java/lang/Object)
            {
                return new agk(aeu1);
            } else
            {
                return null;
            }
        }

    };
    private final aeu b;

    private agk(aeu aeu1)
    {
        b = aeu1;
    }


    public void a(JsonWriter jsonwriter, Object obj)
        throws IOException
    {
        if (obj == null)
        {
            jsonwriter.nullValue();
            return;
        }
        afl afl1 = b.a(obj.getClass());
        if (afl1 instanceof agk)
        {
            jsonwriter.beginObject();
            jsonwriter.endObject();
            return;
        } else
        {
            afl1.a(jsonwriter, obj);
            return;
        }
    }

    public Object b(JsonReader jsonreader)
        throws IOException
    {
        JsonToken jsontoken = jsonreader.peek();
        static class _cls2
        {

            static final int a[];

            static 
            {
                a = new int[JsonToken.values().length];
                try
                {
                    a[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[JsonToken.STRING.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[JsonToken.NUMBER.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[JsonToken.BOOLEAN.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[JsonToken.NULL.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2.a[jsontoken.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            ArrayList arraylist = new ArrayList();
            jsonreader.beginArray();
            for (; jsonreader.hasNext(); arraylist.add(b(jsonreader))) { }
            jsonreader.endArray();
            return arraylist;

        case 2: // '\002'
            afy afy1 = new afy();
            jsonreader.beginObject();
            for (; jsonreader.hasNext(); afy1.put(jsonreader.nextName(), b(jsonreader))) { }
            jsonreader.endObject();
            return afy1;

        case 3: // '\003'
            return jsonreader.nextString();

        case 4: // '\004'
            return Double.valueOf(jsonreader.nextDouble());

        case 5: // '\005'
            return Boolean.valueOf(jsonreader.nextBoolean());

        case 6: // '\006'
            jsonreader.nextNull();
            return null;
        }
    }

}
