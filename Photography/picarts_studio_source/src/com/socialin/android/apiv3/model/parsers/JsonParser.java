// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model.parsers;

import com.socialin.android.util.e;
import com.socialin.gson.stream.JsonReader;
import com.socialin.gson.stream.JsonToken;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.apiv3.model.parsers:
//            IStreamParser

public class JsonParser
    implements IStreamParser
{

    private static JsonParser instance = null;

    private JsonParser()
    {
    }

    public static JsonParser getInstance()
    {
        if (instance == null)
        {
            instance = new JsonParser();
        }
        return instance;
    }

    private Object readLocal(JsonReader jsonreader)
    {
        class _cls1
        {

            static final int $SwitchMap$com$socialin$gson$stream$JsonToken[];

            static 
            {
                $SwitchMap$com$socialin$gson$stream$JsonToken = new int[JsonToken.values().length];
                try
                {
                    $SwitchMap$com$socialin$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$socialin$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$socialin$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$socialin$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$socialin$gson$stream$JsonToken[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$socialin$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$socialin$gson$stream$JsonToken[JsonToken.END_DOCUMENT.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$socialin$gson$stream$JsonToken[JsonToken.NAME.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$socialin$gson$stream$JsonToken[JsonToken.END_OBJECT.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$socialin$gson$stream$JsonToken[JsonToken.END_ARRAY.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        JSONObject jsonobject;
        switch (_cls1..SwitchMap.com.socialin.gson.stream.JsonToken[jsonreader.peek().ordinal()])
        {
        default:
            throw new IllegalArgumentException();

        case 1: // '\001'
            return jsonreader.nextString();

        case 2: // '\002'
            return Float.valueOf(Float.parseFloat(jsonreader.nextString()));

        case 3: // '\003'
            return Boolean.valueOf(jsonreader.nextBoolean());

        case 4: // '\004'
            jsonreader.nextNull();
            return "";

        case 5: // '\005'
            JSONArray jsonarray = new JSONArray();
            jsonreader.beginArray();
            for (; jsonreader.hasNext(); jsonarray.put(readLocal(jsonreader))) { }
            jsonreader.endArray();
            return jsonarray;

        case 6: // '\006'
            jsonobject = new JSONObject();
            jsonreader.beginObject();
            break;
        }
        for (; jsonreader.hasNext(); jsonobject.put(jsonreader.nextName(), readLocal(jsonreader))) { }
        jsonreader.endObject();
        return jsonobject;
    }

    public Object parse(InputStream inputstream)
    {
        inputstream = new JsonReader(new InputStreamReader(inputstream, e.a));
        Object obj = readLocal(inputstream);
        inputstream.close();
        return obj;
    }

}
