// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.datasource.entities.mapper;

import com.abtnprojects.ambatana.datasource.entities.PointEntity;
import com.abtnprojects.ambatana.models.LatitudeLongitude;
import java.util.Date;

public class PointMapper
{

    public PointMapper()
    {
    }

    public LatitudeLongitude fromEntity(PointEntity pointentity)
    {
        return new LatitudeLongitude(pointentity.getLatitude(), pointentity.getLongitude());
    }

    public PointEntity toEntity(LatitudeLongitude latitudelongitude)
    {
        return new PointEntity(latitudelongitude.getLatitude(), latitudelongitude.getLongitude(), (new Date()).getTime());
    }
}
