// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.net.util;

import android.content.Context;
import com.pointinside.model.Venue;

// Referenced classes of package com.pointinside.net.util:
//            VenueLoaderTask, VenueLoader

class enueLoader extends VenueLoaderTask
{

    final VenueLoader this$0;

    protected void onPostExecute(Venue venue)
    {
        VenueLoader.access$000(VenueLoader.this).onVenueRetrieved(venue);
        super.onPostExecute(venue);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Venue)obj);
    }

    transient mageType(Context context, enueLoader enueloader, com.pointinside.feeds.y.ImageType aimagetype[])
    {
        this$0 = VenueLoader.this;
        super(context, enueloader, aimagetype);
    }
}
