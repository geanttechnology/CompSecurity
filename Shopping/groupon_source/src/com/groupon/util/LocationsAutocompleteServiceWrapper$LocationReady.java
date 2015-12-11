// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.location.Location;

// Referenced classes of package com.groupon.util:
//            Function1, LocationsAutocompleteServiceWrapper

protected class this._cls0
    implements Function1
{

    final LocationsAutocompleteServiceWrapper this$0;

    public void execute(Location location)
    {
        locationReady(location);
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((Location)obj);
    }

    protected ()
    {
        this$0 = LocationsAutocompleteServiceWrapper.this;
        super();
    }
}
