// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.net.url;

import com.pointinside.internal.ParameterCheck;

// Referenced classes of package com.pointinside.net.url:
//            FeedsURLBuilder

public class FeedsPlacesURLBuilder extends FeedsURLBuilder
{

    public String placeType;
    public String placeUUID;

    public FeedsPlacesURLBuilder(String s)
    {
        super(s);
        placeUUID = null;
        placeType = null;
    }

    public void onPrepareURL()
    {
        super.onPrepareURL();
        ParameterCheck.throwIfNullOrEmpty("venueUUID", venueUUID);
        setParameterOrClear("placeType", placeType);
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(venueUUID);
        stringbuilder.append("/places");
        if (placeUUID != null)
        {
            stringbuilder.append("/").append(placeUUID);
        }
        setQualifiers(stringbuilder.toString());
    }
}
