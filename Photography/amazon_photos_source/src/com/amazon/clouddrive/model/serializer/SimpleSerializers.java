// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.serializer;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

public class SimpleSerializers
{

    public static void serializeBoolean(Boolean boolean1, JsonGenerator jsongenerator)
        throws IOException
    {
        if (boolean1 == null)
        {
            jsongenerator.writeNull();
            return;
        } else
        {
            jsongenerator.writeBoolean(boolean1.booleanValue());
            return;
        }
    }

    public static void serializeDouble(Double double1, JsonGenerator jsongenerator)
        throws IOException
    {
        if (double1 == null)
        {
            jsongenerator.writeNull();
            return;
        } else
        {
            jsongenerator.writeNumber(double1.doubleValue());
            return;
        }
    }

    public static void serializeInteger(Integer integer, JsonGenerator jsongenerator)
        throws IOException
    {
        if (integer == null)
        {
            jsongenerator.writeNull();
            return;
        } else
        {
            jsongenerator.writeNumber(integer.intValue());
            return;
        }
    }

    public static void serializeLong(Long long1, JsonGenerator jsongenerator)
        throws IOException
    {
        if (long1 == null)
        {
            jsongenerator.writeNull();
            return;
        } else
        {
            jsongenerator.writeNumber(long1.longValue());
            return;
        }
    }

    public static void serializePrimitiveBoolean(boolean flag, JsonGenerator jsongenerator)
        throws IOException
    {
        jsongenerator.writeBoolean(flag);
    }

    public static void serializePrimitiveLong(long l, JsonGenerator jsongenerator)
        throws IOException
    {
        jsongenerator.writeNumber(l);
    }

    public static void serializeString(String s, JsonGenerator jsongenerator)
        throws IOException
    {
        if (s == null)
        {
            jsongenerator.writeNull();
            return;
        } else
        {
            jsongenerator.writeString(s);
            return;
        }
    }
}
