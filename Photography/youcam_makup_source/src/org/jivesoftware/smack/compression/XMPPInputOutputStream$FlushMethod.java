// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack.compression;


public final class  extends Enum
{

    public static final b a;
    public static final b b;
    private static final b c[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(org/jivesoftware/smack/compression/XMPPInputOutputStream$FlushMethod, s);
    }

    public static [] values()
    {
        return ([])c.clone();
    }

    static 
    {
        a = new <init>("FULL_FLUSH", 0);
        b = new <init>("SYNC_FLUSH", 1);
        c = (new c[] {
            a, b
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
