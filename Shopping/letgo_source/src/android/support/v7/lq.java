// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.UnsupportedEncodingException;

// Referenced classes of package android.support.v7:
//            ve, tv, yj, vw

public class lq extends ve
{

    private final vw.b a;

    public lq(int i, String s, vw.b b, vw.a a1)
    {
        super(i, s, a1);
        a = b;
    }

    public lq(String s, vw.b b, vw.a a1)
    {
        this(0, s, b, a1);
    }

    protected vw a(tv tv1)
    {
        String s;
        try
        {
            s = new String(tv1.b, yj.a(tv1.c));
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            unsupportedencodingexception = new String(tv1.b);
        }
        return vw.a(s, yj.a(tv1));
    }

    protected void a(Object obj)
    {
        a((String)obj);
    }

    protected void a(String s)
    {
        a.a(s);
    }
}
