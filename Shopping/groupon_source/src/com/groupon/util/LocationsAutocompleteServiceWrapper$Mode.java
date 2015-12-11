// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;


// Referenced classes of package com.groupon.util:
//            LocationsAutocompleteServiceWrapper

public static final class searchOrigin extends Enum
{

    private static final Place $VALUES[];
    public static final Place GPS;
    public static final Place Place;
    public static final Place TypedEntry;
    public String searchOrigin;

    public static searchOrigin valueOf(String s)
    {
        return (searchOrigin)Enum.valueOf(com/groupon/util/LocationsAutocompleteServiceWrapper$Mode, s);
    }

    public static searchOrigin[] values()
    {
        return (searchOrigin[])$VALUES.clone();
    }

    static 
    {
        GPS = new <init>("GPS", 0, "gps-search");
        TypedEntry = new <init>("TypedEntry", 1, "location-query-search");
        Place = new <init>("Place", 2, "location-query-search");
        $VALUES = (new .VALUES[] {
            GPS, TypedEntry, Place
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        searchOrigin = s1;
    }
}
