// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import java.io.UnsupportedEncodingException;

// Referenced classes of package com.google.android.gms.d:
//            hx, gs, ll, is

public class c extends hx
{

    private final is.b a;

    private c(String s, is.b b, is.a a1)
    {
        super(s, a1);
        a = b;
    }

    public c(String s, is.b b, is.a a1, byte byte0)
    {
        this(s, b, a1);
    }

    protected final is a(gs gs1)
    {
        String s;
        try
        {
            s = new String(gs1.b, ll.a(gs1.c, "ISO-8859-1"));
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            unsupportedencodingexception = new String(gs1.b);
        }
        return is.a(s, ll.a(gs1));
    }

    protected final void a(Object obj)
    {
        obj = (String)obj;
        a.a(obj);
    }
}
