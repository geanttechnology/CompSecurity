// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.datasource.entities.address;


// Referenced classes of package com.abtnprojects.ambatana.datasource.entities.address:
//            Northeast_, Southwest_

public class Viewport
{

    private Northeast_ northeast;
    private Southwest_ southwest;

    public Viewport()
    {
    }

    public Northeast_ getNortheast()
    {
        return northeast;
    }

    public Southwest_ getSouthwest()
    {
        return southwest;
    }

    public void setNortheast(Northeast_ northeast_)
    {
        northeast = northeast_;
    }

    public void setSouthwest(Southwest_ southwest_)
    {
        southwest = southwest_;
    }
}
