// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import com.amazon.geo.mapsv2.model.IndoorBuilding;
import com.amazon.geo.mapsv2.model.internal.IIndoorBuildingDelegate;
import com.amazon.geo.mapsv2.pvt.PrimitiveBase;
import com.amazon.geo.mapsv2.pvt.Wrappers;

// Referenced classes of package com.amazon.geo.mapsv2:
//            AmazonMap

private static class enerDelegate extends PrimitiveBase
    implements com.amazon.geo.mapsv2.internal.ate
{

    private static com.amazon.geo.mapsv2.internal.ate create(enerDelegate enerdelegate)
    {
        if (enerdelegate == null)
        {
            return null;
        } else
        {
            return new <init>(enerdelegate);
        }
    }

    public void onIndoorBuildingsFocused()
    {
        ((<init>)get()).BuildingsFocused();
    }

    public void onIndoorLevelActivated(IIndoorBuildingDelegate iindoorbuildingdelegate)
    {
        ((BuildingsFocused)get()).LevelActivated((IndoorBuilding)Wrappers.unwrapAs(iindoorbuildingdelegate, com/amazon/geo/mapsv2/model/IndoorBuilding));
    }


    enerDelegate(enerDelegate enerdelegate)
    {
        super(enerdelegate);
    }
}
