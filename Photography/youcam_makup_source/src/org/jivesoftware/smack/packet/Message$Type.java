// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack.packet;


public final class  extends Enum
{

    public static final e a;
    public static final e b;
    public static final e c;
    public static final e d;
    public static final e e;
    private static final e f[];

    public static  a(String s)
    {
        try
        {
            s = valueOf(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return a;
        }
        return s;
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(org/jivesoftware/smack/packet/Message$Type, s);
    }

    public static a[] values()
    {
        return (a[])f.clone();
    }

    static 
    {
        a = new <init>("normal", 0);
        b = new <init>("chat", 1);
        c = new <init>("groupchat", 2);
        d = new <init>("headline", 3);
        e = new <init>("error", 4);
        f = (new f[] {
            a, b, c, d, e
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
