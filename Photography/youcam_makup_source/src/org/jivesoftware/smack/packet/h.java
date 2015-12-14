// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack.packet;


public class h
{

    private String a;
    private String b;

    public h(String s)
    {
        a = s;
    }

    public h(String s, String s1)
    {
        this(s);
        b = s1;
    }

    public String a()
    {
        return a;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("stream:error (").append(a).append(")");
        if (b != null)
        {
            stringbuilder.append(" text: ").append(b);
        }
        return stringbuilder.toString();
    }
}
