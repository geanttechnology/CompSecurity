// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.countryanddivision;

import com.groupon.models.division.Division;
import com.groupon.util.GeoPoint;

// Referenced classes of package com.groupon.service.countryanddivision:
//            CurrentDivisionDao

static final class lngE6 extends Division
{

    A()
    {
        latE6 = CurrentDivisionDao.access$000().getLatitudeE6();
        lngE6 = CurrentDivisionDao.access$000().getLongitudeE6();
        geoPoint = new GeoPoint((int)latE6, (int)lngE6);
    }
}
