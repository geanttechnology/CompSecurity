// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package jumiomobile:
//            bm

public class bl
    implements Serializable
{

    private static final bl a = new bl();
    private final bm b = new bm("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");

    public bl()
    {
    }

    public static bl a()
    {
        return a;
    }

    public boolean a(String s)
    {
        return b(s) || c(s);
    }

    public boolean b(String s)
    {
        s = b.b(s);
        if (s != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int i = 0;
_L5:
        String s1;
        if (i > 3)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        s1 = s[i];
        if (s1 == null || s1.length() == 0) goto _L1; else goto _L3
_L3:
        int j;
        try
        {
            j = Integer.parseInt(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        if (j > 255 || s1.length() > 1 && s1.startsWith("0")) goto _L1; else goto _L4
_L4:
        i++;
          goto _L5
        return true;
    }

    public boolean c(String s)
    {
        boolean flag;
        if (s.indexOf("::") >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        break MISSING_BLOCK_LABEL_12;
_L4:
        Object obj;
        String s1;
        int i;
        int j;
        int k;
        do
        {
            do
            {
                return false;
            } while (flag && s.indexOf("::") != s.lastIndexOf("::") || s.startsWith(":") && !s.startsWith("::") || s.endsWith(":") && !s.endsWith("::"));
            obj = s.split(":");
            if (!flag)
            {
                continue;
            }
            obj = new ArrayList(Arrays.asList(((Object []) (obj))));
            int l;
            if (s.endsWith("::"))
            {
                ((List) (obj)).add("");
            } else
            if (s.startsWith("::") && !((List) (obj)).isEmpty())
            {
                ((List) (obj)).remove(0);
            }
            obj = ((Object) (((List) (obj)).toArray()));
        } while (obj.length > 8);
        k = 0;
        l = 0;
        j = 0;
_L5:
        if (k >= obj.length)
        {
            continue; /* Loop/switch isn't completed */
        }
        s1 = (String)obj[k];
        if (s1.length() != 0) goto _L2; else goto _L1
_L1:
        i = l + 1;
        if (i > 1) goto _L4; else goto _L3
_L3:
        l = j + 1;
        j = i;
        i = l;
_L7:
        k++;
        l = j;
        j = i;
          goto _L5
_L2:
        if (s1.indexOf(".") < 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!s.endsWith(s1) || k > obj.length - 1 || k > 6 || !b(s1)) goto _L4; else goto _L6
_L6:
        i = j + 2;
        j = 0;
          goto _L7
        if (s1.length() > 4) goto _L4; else goto _L8
_L8:
        try
        {
            i = Integer.valueOf(s1, 16).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        if (i < 0 || i > 65535) goto _L4; else goto _L9
_L9:
        i = 0;
          goto _L3
        if (j < 8 && !flag) goto _L4; else goto _L10
_L10:
        return true;
    }

}
