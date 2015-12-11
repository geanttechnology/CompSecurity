// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.util;

import com.newrelic.com.google.gson.JsonPrimitive;

public class SafeJsonPrimitive
{

    public static final Boolean NULL_BOOL;
    public static final char NULL_CHAR = 32;
    public static final Number NULL_NUMBER = Float.valueOf((0.0F / 0.0F));
    public static final String NULL_STRING = "null";

    public SafeJsonPrimitive()
    {
    }

    public static Boolean checkNull(Boolean boolean1)
    {
        Boolean boolean2 = boolean1;
        if (boolean1 == null)
        {
            boolean2 = NULL_BOOL;
        }
        return boolean2;
    }

    public static Character checkNull(Character character)
    {
        char c;
        if (character == null)
        {
            c = ' ';
        } else
        {
            c = character.charValue();
        }
        return Character.valueOf(c);
    }

    public static Number checkNull(Number number)
    {
        Number number1 = number;
        if (number == null)
        {
            number1 = NULL_NUMBER;
        }
        return number1;
    }

    public static String checkNull(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "null";
        }
        return s1;
    }

    public static JsonPrimitive factory(Boolean boolean1)
    {
        return new JsonPrimitive(checkNull(boolean1));
    }

    public static JsonPrimitive factory(Character character)
    {
        return new JsonPrimitive(checkNull(character));
    }

    public static JsonPrimitive factory(Number number)
    {
        return new JsonPrimitive(checkNull(number));
    }

    public static JsonPrimitive factory(String s)
    {
        return new JsonPrimitive(checkNull(s));
    }

    static 
    {
        NULL_BOOL = Boolean.FALSE;
    }
}
