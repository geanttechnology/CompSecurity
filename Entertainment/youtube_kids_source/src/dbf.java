// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.nio.charset.Charset;
import java.util.regex.Pattern;

public final class dbf
{

    static final transient int a(int ai[])
    {
        boolean flag1 = false;
        int k;
        if (ai != null)
        {
            int l = ai.length;
            int j = 0;
            int i = 0;
            do
            {
                k = i;
                if (j >= l)
                {
                    break;
                }
                k = ai[j];
                j++;
                i = k | i;
            } while (true);
        } else
        {
            k = 0;
        }
        boolean flag = flag1;
        if (k >= 0)
        {
            flag = flag1;
            if (k < 4)
            {
                flag = true;
            }
        }
        f.a(flag);
        return k;
    }

    static final String a(Object obj, String s, String s1)
    {
        Object obj1;
        Class class1;
        obj1 = s;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        class1 = obj.getClass();
        s = class1;
_L5:
        obj = s.getEnclosingClass();
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = s.getSimpleName();
        obj1 = obj;
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        obj1 = obj;
        if (class1 == s)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        s1 = class1.getSimpleName();
        if (s1.isEmpty()) goto _L4; else goto _L3
_L3:
        if (s1 == null)
        {
            return ((String) (obj));
        } else
        {
            return (new StringBuilder()).append(((String) (obj))).append("[").append(s1).append("]").toString();
        }
_L2:
        s = ((String) (obj));
          goto _L5
_L4:
        s1 = class1.getName();
        s = s1.substring(s1.lastIndexOf('$'));
        s1 = s;
          goto _L3
        s;
          goto _L3
        obj = obj1;
          goto _L3
    }

    static 
    {
        Pattern.compile("(?i)((?:http|https):\\/\\/|(?:.*:.*@))(.*)");
        int i = android.os.Build.VERSION.SDK_INT;
        Charset.forName("UTF-8");
    }
}
