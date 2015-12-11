// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import com.crittercism.error.CRXMLHttpRequestException;

public final class dc extends Enum
{

    public static final dc a;
    public static final dc b;
    public static final dc c;
    public static final dc d;
    public static final dc e;
    private static final dc f[];

    private dc(String s, int i)
    {
        super(s, i);
    }

    public static int a(Throwable throwable)
    {
        int i = d.ordinal();
        if (throwable instanceof CRXMLHttpRequestException)
        {
            i = e.ordinal();
        }
        return i;
    }

    public static dc valueOf(String s)
    {
        return (dc)Enum.valueOf(a/a/dc, s);
    }

    public static dc[] values()
    {
        return (dc[])f.clone();
    }

    static 
    {
        a = new dc("Generic", 0);
        b = new dc("NSURLConnection", 1);
        c = new dc("ASI", 2);
        d = new dc("Android", 3);
        e = new dc("XMLHttpRequest", 4);
        f = (new dc[] {
            a, b, c, d, e
        });
    }
}
