// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.provider.BaseColumns;

class ahm
    implements BaseColumns
{

    protected int a;
    protected int b;
    protected final String c;
    protected final String d;
    protected final aho.a e;

    protected ahm(int i, aho.a a1, String s, String s1, int j)
    {
        a = i;
        e = a1;
        d = s;
        b = j;
        c = s1;
    }

    protected ahm(aho.a a1, String s, String s1)
    {
        this(-1, a1, s, s1, 0);
    }

    public String a()
    {
        return c;
    }

    public String toString()
    {
        return (new StringBuilder()).append("NanigansEvent{id=").append(a).append(", attempts=").append(b).append(", url='").append(c).append('\'').append('}').toString();
    }
}
