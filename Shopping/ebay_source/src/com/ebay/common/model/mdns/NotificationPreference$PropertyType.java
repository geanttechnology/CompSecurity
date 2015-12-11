// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.mdns;


// Referenced classes of package com.ebay.common.model.mdns:
//            NotificationPreference

public static final class  extends Enum
{

    private static final DisabledSavedSearchIds $VALUES[];
    public static final DisabledSavedSearchIds DisabledSavedSearchIds;
    public static final DisabledSavedSearchIds EnableSavedSearches;
    public static final DisabledSavedSearchIds EnabledSavedSearchIds;
    public static final DisabledSavedSearchIds TimeLeft;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/common/model/mdns/NotificationPreference$PropertyType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TimeLeft = new <init>("TimeLeft", 0);
        EnableSavedSearches = new <init>("EnableSavedSearches", 1);
        EnabledSavedSearchIds = new <init>("EnabledSavedSearchIds", 2);
        DisabledSavedSearchIds = new <init>("DisabledSavedSearchIds", 3);
        $VALUES = (new .VALUES[] {
            TimeLeft, EnableSavedSearches, EnabledSavedSearchIds, DisabledSavedSearchIds
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
