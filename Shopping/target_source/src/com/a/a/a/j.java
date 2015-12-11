// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import com.a.a.m;
import com.a.a.o;
import com.a.a.u;
import java.io.UnsupportedEncodingException;

public abstract class j extends m
{

    private static final String a = String.format("application/json; charset=%s", new Object[] {
        "utf-8"
    });
    private final com.a.a.o.b b;
    private final String c;

    public j(int i, String s, String s1, com.a.a.o.b b1, com.a.a.o.a a1)
    {
        super(i, s, a1);
        b = b1;
        c = s1;
    }

    protected void deliverResponse(Object obj)
    {
        b.onResponse(obj);
    }

    public byte[] getBody()
    {
        if (c == null)
        {
            return null;
        }
        byte abyte0[];
        try
        {
            abyte0 = c.getBytes("utf-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            u.d("Unsupported Encoding while trying to get the bytes of %s using %s", new Object[] {
                c, "utf-8"
            });
            return null;
        }
        return abyte0;
    }

    public String getBodyContentType()
    {
        return a;
    }

    public byte[] getPostBody()
    {
        return getBody();
    }

    public String getPostBodyContentType()
    {
        return getBodyContentType();
    }

    protected abstract o parseNetworkResponse(com.a.a.j j1);

}
