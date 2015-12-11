// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.util.Log;
import com.helpshift.g.b.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;

public final class x
{

    private static LinkedList a = new LinkedList();

    public static int a(String s, String s1)
    {
        a(Integer.valueOf(3), s, s1);
        return Log.d(s, s1);
    }

    public static int a(String s, String s1, Throwable throwable)
    {
        a(Integer.valueOf(2), s, s1, throwable);
        return Log.v(s, s1, throwable);
    }

    public static String a(Throwable throwable)
    {
        return Log.getStackTraceString(throwable);
    }

    public static ArrayList a(int i)
    {
        ArrayList arraylist = new ArrayList();
        int k = a.size();
        int j = 0;
        while (j < k && j < i) 
        {
            try
            {
                arraylist.add(a.removeFirst());
            }
            catch (NoSuchElementException nosuchelementexception)
            {
                Log.d("HelpShiftDebug", "Exception No Such Element", nosuchelementexception);
            }
            j++;
        }
        a.clear();
        return arraylist;
    }

    private static void a(Integer integer, String s, String s1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("message", s1);
        hashmap.put("level", integer);
        hashmap.put("tag", s);
        a(hashmap);
    }

    private static void a(Integer integer, String s, String s1, Throwable throwable)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("message", s1);
        hashmap.put("level", integer);
        hashmap.put("tag", s);
        hashmap.put("exception", a(throwable));
        a(hashmap);
    }

    private static void a(HashMap hashmap)
    {
        Integer integer = (Integer)a.b.get("dbgl");
        if (a.size() > 100)
        {
            try
            {
                a.removeLast();
            }
            catch (NoSuchElementException nosuchelementexception)
            {
                Log.d("HelpShiftDebug", "Exception No Such Element", nosuchelementexception);
            }
        }
        if (integer.intValue() != 0)
        {
            a.addFirst(hashmap);
        }
    }

    public static int b(String s, String s1, Throwable throwable)
    {
        a(Integer.valueOf(3), s, s1, throwable);
        return Log.d(s, s1, throwable);
    }

}
