// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.poi;

import com.pointinside.json.JSONResponse;
import com.pointinside.net.requestor.WebserviceRequestor;

// Referenced classes of package com.pointinside.location.poi:
//            PointOfInterestURLBuilder

public class BeaconPointOfInterestRequester extends WebserviceRequestor
{
    public static final class Builder
    {

        public Builder()
        {
        }
    }


    public BeaconPointOfInterestRequester(PointOfInterestURLBuilder pointofinteresturlbuilder, JSONResponse jsonresponse)
    {
        super(pointofinteresturlbuilder, jsonresponse);
    }
}
