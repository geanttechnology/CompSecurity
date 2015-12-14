// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.viewengine;

import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.DevelopSetting;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class k
{

    static double a(double d, int i)
    {
        if (i <= 0 || i > 10)
        {
            throw new IllegalArgumentException("Digit should be 1~10");
        } else
        {
            double d1 = Math.pow(10D, i);
            return (double)Math.round(d * d1) / d1;
        }
    }

    static int a(double d)
    {
        return (int)Math.floor(d);
    }

    static String a(ViewEngine.Argd argd)
    {
        if (argd == null)
        {
            return "null";
        }
        StringBuilder stringbuilder = null;
        for (Iterator iterator = argd.keySet().iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            Object obj = argd.get(s);
            if (stringbuilder == null)
            {
                stringbuilder = new StringBuilder("{");
            } else
            {
                stringbuilder.append(", ");
            }
            if (s.equals("developSetting"))
            {
                obj = (DevelopSetting)obj;
                stringbuilder.append(s).append(":");
                if (((DevelopSetting) (obj)).d())
                {
                    stringbuilder.append("emptyDevelopSetting");
                } else
                {
                    stringbuilder.append("editedDevelopSetting");
                }
            } else
            {
                stringbuilder.append(s).append(":").append(obj.toString());
            }
        }

        if (stringbuilder != null)
        {
            stringbuilder.append("}");
            return stringbuilder.toString();
        } else
        {
            return "{}";
        }
    }

    static String a(HashMap hashmap)
    {
        if (hashmap == null)
        {
            throw new IllegalArgumentException("Invalid paramObject: paramObject should not be null");
        }
        StringBuilder stringbuilder = null;
        for (Iterator iterator = hashmap.keySet().iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            Object obj = hashmap.get(s);
            if (stringbuilder == null)
            {
                stringbuilder = new StringBuilder("{");
            } else
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append(s).append(":");
            if (s.equals("argd"))
            {
                stringbuilder.append(a((ViewEngine.Argd)obj));
            } else
            if (s.equals("developSetting"))
            {
                if (((DevelopSetting)obj).d())
                {
                    stringbuilder.append("emptyDevelopSetting");
                } else
                {
                    stringbuilder.append("editedDevelopSetting");
                }
            } else
            {
                stringbuilder.append(obj);
            }
        }

        if (stringbuilder != null)
        {
            stringbuilder.append("}");
            return stringbuilder.toString();
        } else
        {
            return "{}";
        }
    }

    static boolean a(String s)
    {
        return s == null || s.trim().length() == 0;
    }
}
