// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana;


// Referenced classes of package com.abtnprojects.ambatana:
//            a

public static final class b extends Enum
{

    public static final a a;
    private static final a c[];
    private String b;

    public static b valueOf(String s)
    {
        return (b)Enum.valueOf(com/abtnprojects/ambatana/a$b, s);
    }

    public static b[] values()
    {
        return (b[])c.clone();
    }

    public String toString()
    {
        return b;
    }

    static 
    {
        a = new <init>("UNREAD_MESSAGES_COUNT", 0, "UNREAD_MESSAGES_COUNT");
        c = (new c[] {
            a
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        b = s1;
    }
}
