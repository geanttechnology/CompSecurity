// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.text.TextUtils;
import java.util.List;

public class it
{

    public static String a(String s)
    {
        if (s != null && s.length() != 0)
        {
            boolean flag = s.substring(0, 1).equals(" ");
            String s1 = s;
            if (flag)
            {
                s1 = b(s);
            }
            s1 = c(s1);
            s = s1;
            if (flag)
            {
                return (new StringBuilder()).append(" ").append(s1).toString();
            }
        }
        return s;
    }

    public static String a(List list, String s, String s1, String s2)
    {
        if (TextUtils.isEmpty(s2))
        {
            return s2;
        }
        String as[] = s2.split(s);
        if (as == null || as.length == 0)
        {
            list = a(s2);
        } else
        {
            StringBuffer stringbuffer = new StringBuffer();
            int j = as.length;
            int i = 0;
            while (i < j) 
            {
                s2 = as[i];
                if (list != null)
                {
                    s = s2;
                    if (!list.contains(s2))
                    {
                        s = a(s2);
                    }
                } else
                {
                    s = a(s2);
                }
                stringbuffer.append(s);
                stringbuffer.append(s1);
                i++;
            }
            list = stringbuffer.toString();
        }
        return list;
    }

    public static String b(String s)
    {
        return s.replaceAll("^\\s+", "");
    }

    public static String c(String s)
    {
        if (s.length() == 0)
        {
            return s;
        } else
        {
            return (new StringBuilder()).append(s.substring(0, 1).toUpperCase()).append(s.substring(1)).toString();
        }
    }
}
