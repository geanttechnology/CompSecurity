// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.weibo.other.tencent.beans.QParameter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class bsg
{

    public static List a(String s)
    {
        String s1 = s;
        if (s.startsWith("?"))
        {
            s1 = s.substring(1);
        }
        s = new ArrayList();
        if (s1 != null && !s1.equals(""))
        {
            String as[] = s1.split("&");
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                String s2 = as[i];
                if (s2 == null || s2.equals("") || s2.indexOf('=') <= -1)
                {
                    continue;
                }
                String as1[] = s2.split("=");
                if (as1.length > 1)
                {
                    s.add(new QParameter(as1[0], as1[1]));
                }
            }

        }
        return s;
    }

    public static String b(String s)
    {
        boolean flag = false;
        int i = 0;
        int j = 0;
        int k;
        for (; i < s.length(); i = k + 1)
        {
            k = i;
            if (s.charAt(i) == '%')
            {
                k = i + 2;
            }
            j++;
        }

        byte abyte0[] = new byte[j];
        i = 0;
        j = ((flag) ? 1 : 0);
        while (i < s.length()) 
        {
            if (s.charAt(i) != '%')
            {
                abyte0[j] = (byte)s.charAt(i);
                j++;
            } else
            {
                StringBuilder stringbuilder = new StringBuilder();
                stringbuilder.append(s.charAt(i + 1));
                stringbuilder.append(s.charAt(i + 2));
                abyte0[j] = Integer.valueOf(stringbuilder.toString(), 16).byteValue();
                i += 2;
                j++;
            }
            i++;
        }
        try
        {
            s = new String(abyte0, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return "";
        }
        return s;
    }
}
