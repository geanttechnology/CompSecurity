// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.download;


// Referenced classes of package com.penthera.virtuososdk.download:
//            Downloader

public static final class  extends Enum
{

    public static final EFileExpired EBlocked;
    public static final EFileExpired EFileExpired;
    public static final EFileExpired EFileRemoved;
    private static final EFileExpired ENUM$VALUES[];
    public static final EFileExpired ENone;
    public static final EFileExpired EPriorityChange;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/penthera/virtuososdk/download/Downloader$EStopReason, s);
    }

    public static [] values()
    {
         a[] = ENUM$VALUES;
        int i = a.length;
         a1[] = new ENUM.VALUES[i];
        System.arraycopy(a, 0, a1, 0, i);
        return a1;
    }

    static 
    {
        ENone = new <init>("ENone", 0);
        EBlocked = new <init>("EBlocked", 1);
        EPriorityChange = new <init>("EPriorityChange", 2);
        EFileRemoved = new <init>("EFileRemoved", 3);
        EFileExpired = new <init>("EFileExpired", 4);
        ENUM$VALUES = (new ENUM.VALUES[] {
            ENone, EBlocked, EPriorityChange, EFileRemoved, EFileExpired
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
