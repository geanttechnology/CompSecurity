// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.h.d;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.shazam.h.d:
//            b

public final class c
{

    private static String a(String s, String s1)
    {
        if (s1 == null)
        {
            s1 = "ISO-8859-1";
        }
        try
        {
            return URLEncoder.encode(s, s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalArgumentException(s);
        }
    }

    public static String a(List list, String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) 
        {
            list = (b)iterator.next();
            String s1 = a(list.a(), s);
            list = list.b();
            if (list != null)
            {
                list = a(((String) (list)), s);
            } else
            {
                list = "";
            }
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("&");
            }
            stringbuilder.append(s1);
            stringbuilder.append("=");
            stringbuilder.append(list);
        }
        return stringbuilder.toString();
    }
}
