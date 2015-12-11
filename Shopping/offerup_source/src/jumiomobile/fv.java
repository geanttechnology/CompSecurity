// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.util.regex.Pattern;

// Referenced classes of package jumiomobile:
//            fu

public class fv extends fu
{

    protected Pattern d;
    private int e;

    public fv(String s, String s1, String s2, int i, Pattern pattern)
    {
        super(s, s1, s2);
        e = -1;
        d = null;
        e = i;
        d = pattern;
    }

    public int d()
    {
        return e;
    }

    public Pattern e()
    {
        return d;
    }
}
