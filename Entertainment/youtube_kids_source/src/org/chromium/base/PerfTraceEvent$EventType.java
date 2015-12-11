// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.base;


final class d extends Enum
{

    private static c a;
    private static c b;
    private static c c;
    private static final c e[];
    private final String d;

    public static d valueOf(String s)
    {
        return (d)Enum.valueOf(org/chromium/base/PerfTraceEvent$EventType, s);
    }

    public static d[] values()
    {
        return (d[])e.clone();
    }

    public final String toString()
    {
        return d;
    }

    static 
    {
        a = new <init>("START", 0, "S");
        b = new <init>("FINISH", 1, "F");
        c = new <init>("INSTANT", 2, "I");
        e = (new e[] {
            a, b, c
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        d = s1;
    }
}
