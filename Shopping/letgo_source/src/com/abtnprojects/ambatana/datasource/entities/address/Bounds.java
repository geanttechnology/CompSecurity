// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.datasource.entities.address;


// Referenced classes of package com.abtnprojects.ambatana.datasource.entities.address:
//            Northeast, Southwest

public class Bounds
{

    private Northeast northeast;
    private Southwest southwest;

    public Bounds()
    {
    }

    public Northeast getNortheast()
    {
        return northeast;
    }

    public Southwest getSouthwest()
    {
        return southwest;
    }

    public void setNortheast(Northeast northeast1)
    {
        northeast = northeast1;
    }

    public void setSouthwest(Southwest southwest1)
    {
        southwest = southwest1;
    }
}
