// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.event;


// Referenced classes of package com.mopub.common.event:
//            BaseEvent

public static final class mName extends Enum
{

    private static final CLICK_REQUEST $VALUES[];
    public static final CLICK_REQUEST AD_REQUEST;
    public static final CLICK_REQUEST CLICK_REQUEST;
    public static final CLICK_REQUEST IMPRESSION_REQUEST;
    private final String mName;

    public static mName valueOf(String s)
    {
        return (mName)Enum.valueOf(com/mopub/common/event/BaseEvent$Name, s);
    }

    public static mName[] values()
    {
        return (mName[])$VALUES.clone();
    }

    public String getName()
    {
        return mName;
    }

    static 
    {
        AD_REQUEST = new <init>("AD_REQUEST", 0, "ad_request");
        IMPRESSION_REQUEST = new <init>("IMPRESSION_REQUEST", 1, "impression_request");
        CLICK_REQUEST = new <init>("CLICK_REQUEST", 2, "click_request");
        $VALUES = (new .VALUES[] {
            AD_REQUEST, IMPRESSION_REQUEST, CLICK_REQUEST
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        mName = s1;
    }
}
