// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.event;


public final class mCategory extends Enum
{

    private static final REQUESTS $VALUES[];
    public static final REQUESTS REQUESTS;
    private final String mCategory;

    public static mCategory valueOf(String s)
    {
        return (mCategory)Enum.valueOf(com/mopub/common/event/BaseEvent$Category, s);
    }

    public static mCategory[] values()
    {
        return (mCategory[])$VALUES.clone();
    }

    public final String getCategory()
    {
        return mCategory;
    }

    static 
    {
        REQUESTS = new <init>("REQUESTS", 0, "requests");
        $VALUES = (new .VALUES[] {
            REQUESTS
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        mCategory = s1;
    }
}
