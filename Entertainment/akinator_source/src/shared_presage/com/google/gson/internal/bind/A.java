// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal.bind;

import java.util.Locale;
import java.util.StringTokenizer;
import shared_presage.com.google.gson.TypeAdapter;
import shared_presage.com.google.gson.stream.JsonReader;
import shared_presage.com.google.gson.stream.JsonToken;
import shared_presage.com.google.gson.stream.JsonWriter;

final class A extends TypeAdapter
{

    A()
    {
    }

    public final Object read(JsonReader jsonreader)
    {
        if (jsonreader.peek() == JsonToken.NULL)
        {
            jsonreader.nextNull();
            return null;
        }
        Object obj = new StringTokenizer(jsonreader.nextString(), "_");
        String s;
        if (((StringTokenizer) (obj)).hasMoreElements())
        {
            jsonreader = ((StringTokenizer) (obj)).nextToken();
        } else
        {
            jsonreader = null;
        }
        if (((StringTokenizer) (obj)).hasMoreElements())
        {
            s = ((StringTokenizer) (obj)).nextToken();
        } else
        {
            s = null;
        }
        if (((StringTokenizer) (obj)).hasMoreElements())
        {
            obj = ((StringTokenizer) (obj)).nextToken();
        } else
        {
            obj = null;
        }
        if (s == null && obj == null)
        {
            return new Locale(jsonreader);
        }
        if (obj == null)
        {
            return new Locale(jsonreader, s);
        } else
        {
            return new Locale(jsonreader, s, ((String) (obj)));
        }
    }

    public final void write(JsonWriter jsonwriter, Object obj)
    {
        obj = (Locale)obj;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = ((Locale) (obj)).toString();
        }
        jsonwriter.value(((String) (obj)));
    }
}
