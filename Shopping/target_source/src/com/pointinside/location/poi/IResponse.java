// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.poi;

import java.util.List;

// Referenced classes of package com.pointinside.location.poi:
//            PIPointOfInterest

public class IResponse
{
    public static interface PointOfInterest
    {

        public abstract void onPointOfInterestRetrieved(PIPointOfInterest pipointofinterest);
    }

    public static interface PointsOfInterest
    {

        public abstract void onPointsOfInterestRetrieved(List list);
    }


    public IResponse()
    {
    }
}
