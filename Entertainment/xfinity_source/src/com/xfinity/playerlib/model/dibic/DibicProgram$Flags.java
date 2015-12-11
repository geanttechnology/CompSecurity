// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.dibic;


// Referenced classes of package com.xfinity.playerlib.model.dibic:
//            DibicProgram

public static final class bitMask extends Enum
{

    private static final KIDS $VALUES[];
    public static final KIDS ADULT;
    public static final KIDS DOWNLOADABLE;
    public static final KIDS HD;
    public static final KIDS IN_STORE;
    public static final KIDS IN_THEATER;
    public static final KIDS IN_TVLISTING;
    public static final KIDS KIDS;
    public static final KIDS NEW;
    public static final KIDS ON_DVD;
    public static final KIDS ON_VOD;
    public static final KIDS PROTECTED;
    public static final KIDS THUMBNAIL;
    public int bitMask;

    public static bitMask valueOf(String s)
    {
        return (bitMask)Enum.valueOf(com/xfinity/playerlib/model/dibic/DibicProgram$Flags, s);
    }

    public static bitMask[] values()
    {
        return (bitMask[])$VALUES.clone();
    }

    static 
    {
        THUMBNAIL = new <init>("THUMBNAIL", 0, 0x80000000);
        PROTECTED = new <init>("PROTECTED", 1, 0x40000000);
        ADULT = new <init>("ADULT", 2, 0x20000000);
        IN_TVLISTING = new <init>("IN_TVLISTING", 3, 0x10000000);
        ON_DVD = new <init>("ON_DVD", 4, 0x8000000);
        IN_THEATER = new <init>("IN_THEATER", 5, 0x4000000);
        ON_VOD = new <init>("ON_VOD", 6, 0x2000000);
        IN_STORE = new <init>("IN_STORE", 7, 0x1000000);
        HD = new <init>("HD", 8, 0x800000);
        NEW = new <init>("NEW", 9, 0x400000);
        DOWNLOADABLE = new <init>("DOWNLOADABLE", 10, 0x200000);
        KIDS = new <init>("KIDS", 11, 0x100000);
        $VALUES = (new .VALUES[] {
            THUMBNAIL, PROTECTED, ADULT, IN_TVLISTING, ON_DVD, IN_THEATER, ON_VOD, IN_STORE, HD, NEW, 
            DOWNLOADABLE, KIDS
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        bitMask = j;
    }
}
