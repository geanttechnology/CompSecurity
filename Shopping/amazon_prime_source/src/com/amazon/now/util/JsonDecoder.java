// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.util;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class JsonDecoder
{

    public JsonDecoder()
    {
    }

    private static ArrayList readArray(JsonReader jsonreader)
        throws IOException
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        jsonreader.beginArray();
_L5:
        if (!jsonreader.hasNext()) goto _L2; else goto _L1
_L1:
        JsonToken jsontoken = jsonreader.peek();
        static class _cls1
        {

            static final int $SwitchMap$android$util$JsonToken[];

            static 
            {
                $SwitchMap$android$util$JsonToken = new int[JsonToken.values().length];
                try
                {
                    $SwitchMap$android$util$JsonToken[JsonToken.BOOLEAN.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$android$util$JsonToken[JsonToken.NULL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$android$util$JsonToken[JsonToken.NUMBER.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$android$util$JsonToken[JsonToken.STRING.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$android$util$JsonToken[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$android$util$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$android$util$JsonToken[JsonToken.NAME.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$android$util$JsonToken[JsonToken.END_ARRAY.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$android$util$JsonToken[JsonToken.END_DOCUMENT.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$android$util$JsonToken[JsonToken.END_OBJECT.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.android.util.JsonToken[jsontoken.ordinal()];
        JVM INSTR tableswitch 1 6: default 72
    //                   1 78
    //                   2 78
    //                   3 78
    //                   4 78
    //                   5 78
    //                   6 78;
           goto _L2 _L3 _L3 _L3 _L3 _L3 _L3
_L2:
        jsonreader.endArray();
        return arraylist;
_L3:
        arraylist.add(readValue(jsonreader));
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static HashMap readObject(JsonReader jsonreader)
        throws IOException
    {
        String s;
        HashMap hashmap;
        hashmap = new HashMap();
        jsonreader.beginObject();
        s = null;
_L6:
        if (!jsonreader.hasNext()) goto _L2; else goto _L1
_L1:
        JsonToken jsontoken = jsonreader.peek();
        _cls1..SwitchMap.android.util.JsonToken[jsontoken.ordinal()];
        JVM INSTR tableswitch 1 7: default 76
    //                   1 90
    //                   2 90
    //                   3 90
    //                   4 90
    //                   5 90
    //                   6 90
    //                   7 82;
           goto _L2 _L3 _L3 _L3 _L3 _L3 _L3 _L4
_L2:
        jsonreader.endObject();
        return hashmap;
_L4:
        s = jsonreader.nextName();
        continue; /* Loop/switch isn't completed */
_L3:
        hashmap.put(s, readValue(jsonreader));
        s = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private static Serializable readValue(JsonReader jsonreader)
        throws IOException
    {
        JsonToken jsontoken = jsonreader.peek();
        switch (_cls1..SwitchMap.android.util.JsonToken[jsontoken.ordinal()])
        {
        default:
            jsonreader.skipValue();
            return null;

        case 1: // '\001'
            return Boolean.valueOf(jsonreader.nextBoolean());

        case 2: // '\002'
            jsonreader.nextNull();
            return null;

        case 3: // '\003'
            return Double.valueOf(jsonreader.nextDouble());

        case 4: // '\004'
            return jsonreader.nextString();

        case 5: // '\005'
            return readArray(jsonreader);

        case 6: // '\006'
            return readObject(jsonreader);
        }
    }
}
