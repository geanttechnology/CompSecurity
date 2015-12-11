// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.travelinventory;

import roboguice.util.Strings;

// Referenced classes of package com.groupon.models.travelinventory:
//            ByOptions, Options

public class TravelInventory
{

    public ByOptions byOptions[];
    public Options options[];

    public TravelInventory()
    {
    }

    public String toString()
    {
        return (new StringBuilder()).append("ClassPojo [byOptions = ").append(Strings.join(",", byOptions)).append("]").toString();
    }
}
