// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import com.a.a.j;
import com.a.a.m;
import com.a.a.o;
import java.io.UnsupportedEncodingException;

// Referenced classes of package com.a.a.a:
//            e

public class l extends m
{

    private final com.a.a.o.b mListener;

    public l(int i, String s, com.a.a.o.b b, com.a.a.o.a a)
    {
        super(i, s, a);
        mListener = b;
    }

    public l(String s, com.a.a.o.b b, com.a.a.o.a a)
    {
        this(0, s, b, a);
    }

    protected volatile void deliverResponse(Object obj)
    {
        deliverResponse((String)obj);
    }

    protected void deliverResponse(String s)
    {
        mListener.onResponse(s);
    }

    protected o parseNetworkResponse(j j1)
    {
        String s;
        try
        {
            s = new String(j1.data, e.a(j1.headers));
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            unsupportedencodingexception = new String(j1.data);
        }
        return o.a(s, e.a(j1));
    }
}
