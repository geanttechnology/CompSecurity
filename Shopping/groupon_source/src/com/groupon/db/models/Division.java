// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;


// Referenced classes of package com.groupon.db.models:
//            Deal

public class Division
{

    public String id;
    public double lat;
    public double lng;
    public String name;
    public Deal parentDeal;
    public Long primaryKey;
    public String timezone;
    public String timezoneIdentifier;
    public int timezoneOffsetInSeconds;

    public Division()
    {
        timezone = "";
        timezoneIdentifier = "";
        timezoneOffsetInSeconds = 0;
        id = "";
        name = "";
        lng = 0.0D;
        lat = 0.0D;
    }
}
