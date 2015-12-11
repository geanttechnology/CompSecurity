// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal.bind;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import shared_presage.com.google.gson.TypeAdapter;
import shared_presage.com.google.gson.annotations.SerializedName;
import shared_presage.com.google.gson.stream.JsonReader;
import shared_presage.com.google.gson.stream.JsonToken;
import shared_presage.com.google.gson.stream.JsonWriter;

// Referenced classes of package shared_presage.com.google.gson.internal.bind:
//            TypeAdapters

private static final class b extends TypeAdapter
{

    private final Map a;
    private final Map b;

    public final Object read(JsonReader jsonreader)
    {
        if (jsonreader.peek() == JsonToken.NULL)
        {
            jsonreader.nextNull();
            return null;
        } else
        {
            return (Enum)a.get(jsonreader.nextString());
        }
    }

    public final void write(JsonWriter jsonwriter, Object obj)
    {
        obj = (Enum)obj;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = (String)b.get(obj);
        }
        jsonwriter.value(((String) (obj)));
    }

    public A(Class class1)
    {
        a = new HashMap();
        b = new HashMap();
        String s;
        Enum aenum[];
        Enum enum;
        SerializedName serializedname;
        int i;
        int j;
        try
        {
            aenum = (Enum[])class1.getEnumConstants();
            j = aenum.length;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new AssertionError();
        }
        i = 0;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        enum = aenum[i];
        s = enum.name();
        serializedname = (SerializedName)class1.getField(s).getAnnotation(shared_presage/com/google/gson/annotations/SerializedName);
        if (serializedname == null)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        s = serializedname.value();
        a.put(s, enum);
        b.put(enum, s);
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_41;
_L1:
    }
}
