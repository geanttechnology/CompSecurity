// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.net.util;

import com.pointinside.model.Venue;

// Referenced classes of package com.pointinside.net.util:
//            VenueLoader

public static interface 
{

    public abstract void onVenueCacheRefresh(Venue venue);

    public abstract void onVenueLoadError(Exception exception);

    public abstract void onVenueRetrieved(Venue venue);
}
