// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.division.json;

import android.util.Pair;

// Referenced classes of package com.groupon.models.division.json:
//            Area, Division

public class DivisionAreaPair extends Pair
{

    public DivisionAreaPair(Division division, Area area)
    {
        super(division, area);
    }

    public Area getArea()
    {
        return (Area)second;
    }

    public Division getDivision()
    {
        return (Division)first;
    }

    public String getDivisionId()
    {
        return getDivision().id;
    }
}
