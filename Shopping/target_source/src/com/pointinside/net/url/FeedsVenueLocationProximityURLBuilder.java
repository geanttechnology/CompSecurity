// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.net.url;


// Referenced classes of package com.pointinside.net.url:
//            FeedsVenueLocationURLBuilder

public class FeedsVenueLocationProximityURLBuilder extends FeedsVenueLocationURLBuilder
{

    public static final String KEY_ACCURACY = "accuracy".intern();
    public static final String KEY_STORE_ID = "storeId".intern();
    public static final String KEY_VENUE_ID = "venue".intern();
    public Double accuracy;
    public String storeID;
    public String venueUUID;

    public FeedsVenueLocationProximityURLBuilder()
    {
        venueUUID = null;
        storeID = null;
        accuracy = null;
    }

    public void onPrepareURL()
    {
        super.onPrepareURL();
        setQualifiers("proximity");
        setParameterOrClear(KEY_VENUE_ID, venueUUID);
        setParameterOrClear(KEY_STORE_ID, storeID);
        setParameterOrClear(KEY_ACCURACY, accuracy);
    }

}
