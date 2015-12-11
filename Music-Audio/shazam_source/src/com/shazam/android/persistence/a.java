// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence;

import android.net.Uri;
import java.util.LinkedHashMap;
import java.util.Map;

public final class com.shazam.android.persistence.a
{
    static final class a
    {

        final String a;
        final int b;
        final String c;

        public final String toString()
        {
            return (new StringBuilder("PathInfo{path='")).append(a).append('\'').append(", code=").append(b).append(", contentType='").append(c).append('\'').append('}').toString();
        }

        a(String s, int i, String s1)
        {
            a = s;
            b = i;
            c = s1;
        }
    }


    final String a;
    Uri b;
    final Map c;

    private com.shazam.android.persistence.a(String s)
    {
        c = new LinkedHashMap();
        a = s;
    }

    public com.shazam.android.persistence.a(String s, Integer integer, String s1)
    {
        this(s);
        a("", integer, s1);
    }

    public final com.shazam.android.persistence.a a(String s, Integer integer, String s1)
    {
        s = new a((new StringBuilder()).append(a).append(s).toString(), integer.intValue(), s1);
        c.put(((a) (s)).a, s);
        return this;
    }

    public final String toString()
    {
        return (new StringBuilder("ContentCategory: '")).append(a).append("', pathToInfoMap: ").append(c).toString();
    }
}
