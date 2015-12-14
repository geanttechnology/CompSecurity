// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.filters;


final class  extends Enum
{

    private static final ApplyOrigSizeAndSave $VALUES[];
    public static final ApplyOrigSizeAndSave ApplyFilter;
    public static final ApplyOrigSizeAndSave ApplyOrigSizeAndSave;
    public static final ApplyOrigSizeAndSave Free;
    public static final ApplyOrigSizeAndSave Init;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/picsart/filters/FilterAsyncTask$TaskMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Init = new <init>("Init", 0);
        ApplyFilter = new <init>("ApplyFilter", 1);
        Free = new <init>("Free", 2);
        ApplyOrigSizeAndSave = new <init>("ApplyOrigSizeAndSave", 3);
        $VALUES = (new .VALUES[] {
            Init, ApplyFilter, Free, ApplyOrigSizeAndSave
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
