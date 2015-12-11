// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.d.a;

import com.google.api.a.f.a.a.a.a.c;
import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

final class e extends HttpEntityEnclosingRequestBase
{

    private final String a;

    public e(String s, String s1)
    {
        a = (String)c.a(s);
        setURI(URI.create(s1));
    }

    public final String getMethod()
    {
        return a;
    }
}
