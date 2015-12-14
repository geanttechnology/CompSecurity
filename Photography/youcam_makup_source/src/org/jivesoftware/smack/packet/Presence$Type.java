// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack.packet;


public final class  extends Enum
{

    public static final g a;
    public static final g b;
    public static final g c;
    public static final g d;
    public static final g e;
    public static final g f;
    public static final g g;
    private static final g h[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(org/jivesoftware/smack/packet/Presence$Type, s);
    }

    public static [] values()
    {
        return ([])h.clone();
    }

    static 
    {
        a = new <init>("available", 0);
        b = new <init>("unavailable", 1);
        c = new <init>("subscribe", 2);
        d = new <init>("subscribed", 3);
        e = new <init>("unsubscribe", 4);
        f = new <init>("unsubscribed", 5);
        g = new <init>("error", 6);
        h = (new h[] {
            a, b, c, d, e, f, g
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
