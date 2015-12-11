// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.console;

import com.smule.android.h;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.smule.android.console:
//            n, a, p, c, 
//            b

public class o
{

    public static String a(n n1)
    {
        try
        {
            n1 = com.smule.android.console.a.a(com/smule/android/h.getField((new StringBuilder()).append("usage_").append(n1.a()).toString()).getInt(null));
        }
        // Misplaced declaration of an exception variable
        catch (n n1)
        {
            return com.smule.android.console.a.a(h.cmd_unknown);
        }
        return n1;
    }

    public static void a(p p1)
    {
        p1.b(com.smule.android.console.a.a(h.help_prompt));
    }

    public static void a(p p1, c c1)
    {
        try
        {
            p1.b(com.smule.android.console.a.a(com/smule/android/h.getField((new StringBuilder()).append("usage_").append(c1.name()).toString()).getInt(null)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (c c1)
        {
            p1.b(com.smule.android.console.a.a(h.cmd_unknown));
        }
    }

    public static void a(p p1, String s)
    {
        try
        {
            p1.b(com.smule.android.console.a.a(com/smule/android/h.getField((new StringBuilder()).append("cmd_").append(s).toString()).getInt(null)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            p1.b(com.smule.android.console.a.a(h.cmd_unknown));
        }
    }

    public static void b(p p1)
    {
        p1.b(com.smule.android.console.a.a(h.help_commands));
        p1.b("");
        c ac[] = c.values();
        int j = ac.length;
        for (int i = 0; i < j; i++)
        {
            c c1 = ac[i];
            if (!com.smule.android.console.b.a(c1))
            {
                p1.b(c1.name());
            }
        }

        for (Iterator iterator = b.a.keySet().iterator(); iterator.hasNext(); p1.b((String)iterator.next())) { }
        p1.b("");
        p1.b(com.smule.android.console.a.a(h.cmd_help));
    }
}
