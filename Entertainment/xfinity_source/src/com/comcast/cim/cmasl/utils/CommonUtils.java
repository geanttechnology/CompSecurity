// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.utils;


public class CommonUtils
{

    public CommonUtils()
    {
    }

    public static Object getNewInstanceOfOverrideableClass(Class class1)
    {
        Class class2 = (Class)uncheckedCast(Class.forName((new StringBuilder()).append(class1.getName()).append("Override").toString()));
        class1 = class2;
_L2:
        return newInstance(class1);
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static Object newInstance(Class class1)
    {
        try
        {
            class1 = ((Class) (class1.newInstance()));
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new RuntimeException(class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new RuntimeException(class1);
        }
        return class1;
    }

    public static Object uncheckedCast(Object obj)
    {
        return obj;
    }
}
