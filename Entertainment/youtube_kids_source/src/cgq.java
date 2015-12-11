// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cgq
{

    public final String a;
    public final String b;

    public cgq(String s, String s1)
    {
        a = (String)b.a(s);
        b = s1;
    }

    public final String toString()
    {
        String s = a;
        String s1 = b;
        return (new StringBuilder(String.valueOf(s).length() + 2 + String.valueOf(s1).length())).append(s).append(": ").append(s1).toString();
    }
}
