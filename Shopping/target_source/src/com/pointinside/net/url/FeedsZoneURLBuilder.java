// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.net.url;

import com.pointinside.internal.ParameterCheck;

// Referenced classes of package com.pointinside.net.url:
//            FeedsURLBuilder

public class FeedsZoneURLBuilder extends FeedsURLBuilder
{

    public String zoneUUID;

    public FeedsZoneURLBuilder(String s)
    {
        super(s);
        zoneUUID = null;
    }

    public void onPrepareURL()
    {
        super.onPrepareURL();
        ParameterCheck.throwIfNullOrEmpty("venueUUID", venueUUID);
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(venueUUID);
        stringbuilder.append("/zones");
        if (zoneUUID != null)
        {
            stringbuilder.append("/").append(zoneUUID);
        }
        setQualifiers(stringbuilder.toString());
    }
}
