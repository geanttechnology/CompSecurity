// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.event;


// Referenced classes of package com.mopub.common.event:
//            BaseEvent

public static final class mCategory extends Enum
{

    private static final NATIVE_VIDEO $VALUES[];
    public static final NATIVE_VIDEO NATIVE_VIDEO;
    public static final NATIVE_VIDEO REQUESTS;
    private final String mCategory;

    public static mCategory valueOf(String s)
    {
        return (mCategory)Enum.valueOf(com/mopub/common/event/BaseEvent$Category, s);
    }

    public static mCategory[] values()
    {
        return (mCategory[])$VALUES.clone();
    }

    public String getCategory()
    {
        return mCategory;
    }

    static 
    {
        REQUESTS = new <init>("REQUESTS", 0, "requests");
        NATIVE_VIDEO = new <init>("NATIVE_VIDEO", 1, "native_video");
        $VALUES = (new .VALUES[] {
            REQUESTS, NATIVE_VIDEO
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        mCategory = s1;
    }
}
