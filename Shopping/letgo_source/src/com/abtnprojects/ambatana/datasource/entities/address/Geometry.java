// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.datasource.entities.address;


// Referenced classes of package com.abtnprojects.ambatana.datasource.entities.address:
//            Bounds, Location, Viewport

public class Geometry
{

    private Bounds bounds;
    private Location location;
    private String locationType;
    private Viewport viewport;

    public Geometry()
    {
    }

    public Bounds getBounds()
    {
        return bounds;
    }

    public Location getLocation()
    {
        return location;
    }

    public String getLocationType()
    {
        return locationType;
    }

    public Viewport getViewport()
    {
        return viewport;
    }

    public void setBounds(Bounds bounds1)
    {
        bounds = bounds1;
    }

    public void setLocation(Location location1)
    {
        location = location1;
    }

    public void setLocationType(String s)
    {
        locationType = s;
    }

    public void setViewport(Viewport viewport1)
    {
        viewport = viewport1;
    }
}
