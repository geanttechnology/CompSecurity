// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l;

import com.shazam.b.a.a;

public final class d
    implements a
{

    private final String a;

    public d(String s)
    {
        a = s;
    }

    public final Object a(Object obj)
    {
        obj = (Integer)obj;
        return (new StringBuilder("android.resource://")).append(a).append("/").append(obj).toString();
    }
}
