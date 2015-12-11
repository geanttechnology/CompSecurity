// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import java.io.Serializable;
import java.util.regex.Pattern;

public class cy
    implements Serializable
{

    private String a;
    private String b;
    private String c;
    private int d;
    private Pattern e;

    public cy(String s, String s1, String s2, int i, Pattern pattern)
    {
        a = "";
        b = "";
        c = "";
        d = -1;
        e = null;
        a = s;
        b = s1;
        c = s2;
        d = i;
        e = pattern;
    }

    public String a()
    {
        return a;
    }

    public String b()
    {
        return b;
    }

    public String c()
    {
        return c;
    }

    public Pattern d()
    {
        return e;
    }

    public int e()
    {
        return d;
    }
}
