// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import com.flurry.android.impl.ads.protocol.v13.Location;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class e
{

    private Location a;
    private final Map b = new HashMap();
    private Map c;
    private Integer d;
    private Integer e;
    private boolean f;
    private String g;

    public e()
    {
    }

    private Location a(Location location)
    {
        if (location == null)
        {
            return null;
        } else
        {
            Location location1 = new Location();
            location1.lat = Math.round(location.lat * 10F);
            location1.lon = Math.round(location.lon * 10F);
            return location1;
        }
    }

    private boolean a(Location location, Location location1)
    {
        if ((location != null || location1 == null) && (location == null || location1 != null))
        {
            location = a(location);
            location1 = a(location1);
            if (location.lat == location1.lat && location.lon == location1.lon)
            {
                return true;
            }
        }
        return false;
    }

    public void clearAge()
    {
        d = null;
    }

    public void clearFixedAdId()
    {
        g = null;
    }

    public void clearGender()
    {
        e = null;
    }

    public void clearKeywords()
    {
        c = null;
    }

    public void clearLocation()
    {
        a = null;
    }

    public void clearUserCookies()
    {
        b.clear();
    }

    public e copy()
    {
        e e1 = new e();
        if (a != null)
        {
            e1.setLocation(a.lat, a.lon);
        }
        if (b != null)
        {
            e1.setUserCookies(new HashMap(b));
        }
        if (c != null)
        {
            e1.setKeywords(new HashMap(c));
        }
        if (d != null)
        {
            e1.setAge(d.intValue());
        }
        if (e != null)
        {
            e1.setGender(e.intValue());
        }
        e1.setEnableTestAds(f);
        return e1;
    }

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof e))
        {
            if ((a == ((e) (obj = (e)obj)).a || a == null || a(a, ((e) (obj)).a)) && (c == ((e) (obj)).c || c == null || c.equals(((e) (obj)).c)) && (d == ((e) (obj)).d || d == null || d.equals(((e) (obj)).d)) && (e == ((e) (obj)).e || e == null || e.equals(((e) (obj)).e)) && (g == ((e) (obj)).g || g == null || g.equals(((e) (obj)).g)))
            {
                return true;
            }
        }
        return false;
    }

    public Integer getAge()
    {
        return d;
    }

    public boolean getEnableTestAds()
    {
        return f;
    }

    public String getFixedAdId()
    {
        return g;
    }

    public Integer getGender()
    {
        return e;
    }

    public Map getKeywords()
    {
        return c;
    }

    public Location getLocation()
    {
        return a;
    }

    public Map getUserCookies()
    {
        return b;
    }

    public int hashCode()
    {
        int j = 17;
        if (a != null)
        {
            j = 0x11 ^ a(a).hashCode();
        }
        int i = j;
        if (c != null)
        {
            i = j ^ c.hashCode();
        }
        j = i;
        if (d != null)
        {
            j = i ^ d.hashCode();
        }
        i = j;
        if (e != null)
        {
            i = j ^ e.hashCode();
        }
        j = i;
        if (g != null)
        {
            j = i ^ g.hashCode();
        }
        return j;
    }

    public void setAge(int i)
    {
        d = Integer.valueOf(i);
    }

    public void setEnableTestAds(boolean flag)
    {
        f = flag;
    }

    public void setFixedAdId(String s)
    {
        g = s;
    }

    public void setGender(int i)
    {
        e = Integer.valueOf(i);
    }

    public void setKeywords(Map map)
    {
        c = map;
    }

    public void setLocation(float f1, float f2)
    {
        a = new Location();
        a.lat = f1;
        a.lon = f2;
    }

    public void setUserCookies(Map map)
    {
        if (map != null && !map.isEmpty())
        {
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                if (entry.getKey() != null && entry.getValue() != null)
                {
                    map.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }
}
