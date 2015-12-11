// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import shared_presage.com.google.gson.internal.Streams;
import shared_presage.com.google.gson.stream.JsonReader;
import shared_presage.com.google.gson.stream.JsonToken;
import shared_presage.com.google.gson.stream.MalformedJsonException;

// Referenced classes of package shared_presage.com.google.gson:
//            JsonElement, JsonSyntaxException, JsonIOException, JsonParseException

public final class JsonParser
{

    public JsonParser()
    {
    }

    public final JsonElement parse(Reader reader)
    {
        JsonElement jsonelement;
        try
        {
            reader = new JsonReader(reader);
            jsonelement = parse(((JsonReader) (reader)));
            if (!jsonelement.isJsonNull() && reader.peek() != JsonToken.END_DOCUMENT)
            {
                throw new JsonSyntaxException("Did not consume the entire document.");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Reader reader)
        {
            throw new JsonSyntaxException(reader);
        }
        // Misplaced declaration of an exception variable
        catch (Reader reader)
        {
            throw new JsonIOException(reader);
        }
        // Misplaced declaration of an exception variable
        catch (Reader reader)
        {
            throw new JsonSyntaxException(reader);
        }
        return jsonelement;
    }

    public final JsonElement parse(String s)
    {
        return parse(((Reader) (new StringReader(s))));
    }

    public final JsonElement parse(JsonReader jsonreader)
    {
        boolean flag;
        flag = jsonreader.isLenient();
        jsonreader.setLenient(true);
        JsonElement jsonelement = Streams.parse(jsonreader);
        jsonreader.setLenient(flag);
        return jsonelement;
        Object obj;
        obj;
        throw new JsonParseException((new StringBuilder("Failed parsing JSON source: ")).append(jsonreader).append(" to Json").toString(), ((Throwable) (obj)));
        obj;
        jsonreader.setLenient(flag);
        throw obj;
        obj;
        throw new JsonParseException((new StringBuilder("Failed parsing JSON source: ")).append(jsonreader).append(" to Json").toString(), ((Throwable) (obj)));
    }
}
