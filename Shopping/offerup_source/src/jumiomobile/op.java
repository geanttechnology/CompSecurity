// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.util.ArrayList;

public class op
{

    private static ArrayList a = null;

    public static void a()
    {
        if (a == null)
        {
            a = new ArrayList();
            return;
        } else
        {
            a.clear();
            return;
        }
    }

    public static void a(int i)
    {
        if (a == null)
        {
            a = new ArrayList();
        }
        a.add(Integer.valueOf(i));
    }

    public static void a(StringBuilder stringbuilder)
    {
        if (stringbuilder == null || a == null || a.size() == 0)
        {
            return;
        } else
        {
            stringbuilder.append("Line count of the last frames:\r\n");
            stringbuilder.append(a.toString().replace("[", "").replace("]", "")).append("\r\n");
            return;
        }
    }

}
