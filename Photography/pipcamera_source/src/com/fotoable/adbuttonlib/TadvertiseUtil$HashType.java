// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;


public final class  extends Enum
{

    private static final SHA1 $VALUES[];
    public static final SHA1 MD5;
    public static final SHA1 SHA1;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/fotoable/adbuttonlib/TadvertiseUtil$HashType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        MD5 = new <init>("MD5", 0);
        SHA1 = new <init>("SHA1", 1);
        $VALUES = (new .VALUES[] {
            MD5, SHA1
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
