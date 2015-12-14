// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.uma;

import android.os.Environment;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.cyberlink.uma:
//            UMA

final class l
{

    static String a;

    static int a(String s, Map map)
    {
        int i = 100 + d(s);
        int j;
        if (map != null)
        {
            s = map.entrySet().iterator();
            do
            {
                j = i;
                if (!s.hasNext())
                {
                    break;
                }
                map = (java.util.Map.Entry)s.next();
                j = d((String)map.getKey());
                i = d((String)map.getValue()) + j + 12 + i;
            } while (true);
        } else
        {
            j = i;
        }
        return j;
    }

    static File a()
    {
        if (a == null)
        {
            return Environment.getExternalStorageDirectory();
        } else
        {
            return b(a);
        }
    }

    static File a(String s)
    {
        try
        {
            s = new File(a(), s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    static boolean a(File file)
    {
        boolean flag1;
        if (file.isDirectory())
        {
            File afile[] = file.listFiles();
            int j = afile.length;
            int i = 0;
            boolean flag = true;
            do
            {
                flag1 = flag;
                if (i >= j)
                {
                    break;
                }
                File file1 = afile[i];
                if (flag && a(file1))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                i++;
            } while (true);
        } else
        {
            flag1 = true;
        }
        return flag1 && file.delete();
    }

    static File b(String s)
    {
        s = new File(Environment.getExternalStorageDirectory(), s);
        if (s.exists() && !s.isDirectory())
        {
            throw new AssertionError((new StringBuilder()).append(s).append(" exists but is not a directory.").toString());
        } else
        {
            a(s);
            s.mkdirs();
            return s;
        }
    }

    static String c(String s)
    {
        String s1 = URLEncoder.encode(s, "UTF-8");
        s = s1;
_L2:
        return s;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        if (UMA.a)
        {
            throw new RuntimeException("Must not be happen! UTF-8 is always supported.", unsupportedencodingexception);
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    static int d(String s)
    {
        return c(s).length();
    }
}
