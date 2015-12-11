// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.search;


// Referenced classes of package com.groupon.getaways.search:
//            DestinationsData

public interface GeoService
{
    public static interface Callback
    {

        public abstract void onDestinationsData(DestinationsData destinationsdata);
    }


    public static final String V2_GETAWAYS_DESTINATIONS = "/getaways/geo/destinations";
    public static final String V2_GETAWAYS_GEO = "/getaways/geo/";

    public abstract void destinations(CharSequence charsequence, Callback callback);
}
