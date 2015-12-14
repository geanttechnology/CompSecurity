// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.deserializer;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

public class SimpleDeserializers
{

    public static Boolean deserializeBoolean(JsonParser jsonparser)
        throws IOException
    {
        if (jsonparser.getCurrentToken() == JsonToken.VALUE_NULL)
        {
            return null;
        } else
        {
            return Boolean.valueOf(jsonparser.getBooleanValue());
        }
    }

    public static Double deserializeDouble(JsonParser jsonparser)
        throws IOException
    {
        if (jsonparser.getCurrentToken() == JsonToken.VALUE_NULL)
        {
            return null;
        } else
        {
            return Double.valueOf(jsonparser.getDoubleValue());
        }
    }

    public static Integer deserializeInteger(JsonParser jsonparser)
        throws IOException
    {
        if (jsonparser.getCurrentToken() == JsonToken.VALUE_NULL)
        {
            return null;
        } else
        {
            return Integer.valueOf(jsonparser.getIntValue());
        }
    }

    public static Long deserializeLong(JsonParser jsonparser)
        throws IOException
    {
        if (jsonparser.getCurrentToken() == JsonToken.VALUE_NULL)
        {
            return null;
        } else
        {
            return Long.valueOf(jsonparser.getLongValue());
        }
    }

    public static boolean deserializePrimitiveBoolean(JsonParser jsonparser)
        throws IOException
    {
        return jsonparser.getBooleanValue();
    }

    public static long deserializePrimitiveLong(JsonParser jsonparser)
        throws IOException
    {
        return jsonparser.getLongValue();
    }

    public static String deserializeString(JsonParser jsonparser)
        throws IOException
    {
        if (jsonparser.getCurrentToken() == JsonToken.VALUE_NULL)
        {
            return null;
        } else
        {
            return jsonparser.getText();
        }
    }
}
