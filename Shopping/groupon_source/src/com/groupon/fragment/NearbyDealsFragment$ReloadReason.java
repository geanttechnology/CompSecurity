// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;


// Referenced classes of package com.groupon.fragment:
//            NearbyDealsFragment

public static final class searchOrigin extends Enum
{

    private static final isDeepLinked $VALUES[];
    public static final isDeepLinked filterModified;
    public static final isDeepLinked isDeepLinked;
    public static final isDeepLinked locationSet;
    public static final isDeepLinked periodicReload;
    public static final isDeepLinked reload;
    public static final isDeepLinked signInSignOut;
    public static final isDeepLinked userInitiated;
    public String searchOrigin;
    public boolean spanLocations;

    public static boolean isFilterModified(searchOrigin searchorigin)
    {
        return searchorigin == filterModified || searchorigin == locationSet;
    }

    public static boolean useMapCenter(locationSet locationset)
    {
        return locationset != reload && locationset != locationSet;
    }

    public static locationSet valueOf(String s)
    {
        return (locationSet)Enum.valueOf(com/groupon/fragment/NearbyDealsFragment$ReloadReason, s);
    }

    public static locationSet[] values()
    {
        return (locationSet[])$VALUES.clone();
    }

    static 
    {
        userInitiated = new <init>("userInitiated", 0, "refresh-user-initiated");
        periodicReload = new <init>("periodicReload", 1, "refresh-auto");
        signInSignOut = new <init>("signInSignOut", 2, "refresh-auto");
        reload = new <init>("reload", 3, "refresh-reload-activity");
        locationSet = new <init>("locationSet", 4, null);
        filterModified = new <init>("filterModified", 5, null);
        isDeepLinked = new <init>("isDeepLinked", 6, null);
        $VALUES = (new .VALUES[] {
            userInitiated, periodicReload, signInSignOut, reload, locationSet, filterModified, isDeepLinked
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        spanLocations = true;
        searchOrigin = s1;
    }
}
