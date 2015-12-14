// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;


class s
{

    String a;
    int b;
    String c;
    boolean d;

    s(String s1, int i)
    {
        a = s1;
        b = i;
        c = "starttls";
        d = true;
    }

    s(String s1, int i, String s2, boolean flag)
    {
        a = s1;
        b = i;
        c = s2;
        d = flag;
    }

    public String toString()
    {
        return (new StringBuilder()).append(a).append(":").append(b).append(" ").append(c).toString();
    }
}
