// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.f;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smule.android.c.aa;
import java.io.IOException;
import java.util.Map;

public class e
{

    public static final String a = com/smule/android/f/e.getName();
    private static ObjectMapper b;

    public e()
    {
    }

    public static ObjectMapper a()
    {
        return b;
    }

    public static Object a(JsonNode jsonnode, Class class1)
    {
        try
        {
            jsonnode = ((JsonNode) (a().treeToValue(jsonnode, class1)));
        }
        // Misplaced declaration of an exception variable
        catch (JsonNode jsonnode)
        {
            aa.b(a, (new StringBuilder()).append("Failed to parse JSON entity ").append(class1.getSimpleName()).toString(), jsonnode);
            throw new RuntimeException(jsonnode);
        }
        return jsonnode;
    }

    public static String a(Object obj)
    {
        try
        {
            obj = b.writeValueAsString(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            aa.b(a, "Error serializing object to JSON", ((Throwable) (obj)));
            return null;
        }
        return ((String) (obj));
    }

    public static Map a(JsonNode jsonnode, TypeReference typereference)
    {
        try
        {
            jsonnode = (Map)a().readValue(jsonnode.traverse(), typereference);
        }
        // Misplaced declaration of an exception variable
        catch (JsonNode jsonnode)
        {
            aa.b(a, (new StringBuilder()).append("Failed to parse JSON map ").append(typereference.getType()).toString(), jsonnode);
            throw new RuntimeException(jsonnode);
        }
        return jsonnode;
    }

    static 
    {
        b = new ObjectMapper();
        b.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
    }
}
