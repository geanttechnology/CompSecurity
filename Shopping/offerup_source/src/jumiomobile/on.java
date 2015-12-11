// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package jumiomobile:
//            bn, bl

public class on extends bn
{

    private static final String a[] = {
        "https", "http"
    };
    private static final Pattern b = Pattern.compile("^(([-\\w:@&?=+,.!~*'$_;]|(%[0-9a-fA-F]{2}))*)?$");
    private static final Pattern c = Pattern.compile("^(([-/\\w:@&?=+,.!~*'$_;]|(%[0-9a-fA-F]{2}))*)?$");
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;

    public on()
    {
        this(a, true, true, true, true);
    }

    public on(String as[], boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        super(as, 4L);
        d = true;
        e = true;
        f = true;
        g = true;
        f = flag;
        e = flag1;
        d = flag2;
        g = flag3;
    }

    private static boolean g(String s)
    {
        boolean flag1 = false;
        if (s != null) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= s.length())
                {
                    break label1;
                }
                flag = flag1;
                if (s.charAt(i) > '\177')
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        return true;
    }

    protected boolean c(String s)
    {
        while (!e && bl.a().a(s) || !f && !g(s) || !super.c(s) || !d && s.split(":").length >= 2) 
        {
            return false;
        }
        return true;
    }

    protected boolean d(String s)
    {
        return s == null || super.d(s) && c.matcher(s).matches();
    }

    protected boolean e(String s)
    {
        return s == null || g && super.e(s) && b.matcher(s).matches();
    }

}
