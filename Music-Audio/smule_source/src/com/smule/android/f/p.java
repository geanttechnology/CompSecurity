// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.f;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class p
{

    private static final Method a = a();

    private static Method a()
    {
        Method method;
        try
        {
            method = android/content/SharedPreferences$Editor.getMethod("apply", new Class[0]);
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            return null;
        }
        return method;
    }

    public static void a(android.content.SharedPreferences.Editor editor)
    {
        if (a != null)
        {
            try
            {
                a.invoke(editor, new Object[0]);
                return;
            }
            catch (InvocationTargetException invocationtargetexception) { }
            catch (IllegalAccessException illegalaccessexception) { }
        }
        editor.commit();
    }

}
