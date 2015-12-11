// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.services.now.model;

import com.google.api.a.e.b;
import com.google.api.a.g.l;

// Referenced classes of package com.google.api.services.now.model:
//            Location

public final class Map extends b
{

    private Location location;
    private Boolean showRoute;
    private Boolean showUserLocation;

    public Map()
    {
    }

    public final volatile b clone()
    {
        return clone();
    }

    public final volatile l clone()
    {
        return clone();
    }

    public final Map clone()
    {
        return (Map)super.clone();
    }

    public final volatile Object clone()
    {
        return clone();
    }

    public final Location getLocation()
    {
        return location;
    }

    public final Boolean getShowRoute()
    {
        return showRoute;
    }

    public final Boolean getShowUserLocation()
    {
        return showUserLocation;
    }

    public final volatile b set(String s, Object obj)
    {
        return set(s, obj);
    }

    public final volatile l set(String s, Object obj)
    {
        return set(s, obj);
    }

    public final Map set(String s, Object obj)
    {
        return (Map)super.set(s, obj);
    }

    public final Map setLocation(Location location1)
    {
        location = location1;
        return this;
    }

    public final Map setShowRoute(Boolean boolean1)
    {
        showRoute = boolean1;
        return this;
    }

    public final Map setShowUserLocation(Boolean boolean1)
    {
        showUserLocation = boolean1;
        return this;
    }
}
