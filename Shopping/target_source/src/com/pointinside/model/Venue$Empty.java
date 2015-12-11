// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.model;

import android.location.Location;
import com.pointinside.internal.utils.LogUtils;
import java.io.File;
import java.io.FilenameFilter;

// Referenced classes of package com.pointinside.model:
//            Venue, Zone, Place

private static class id extends id
{

    private final String id;

    public File getCacheFile(File file)
    {
        String as[] = file.list(new FilenameFilter() {

            final Venue.Empty this$0;

            public boolean accept(File file1, String s)
            {
                file1 = getUUID().toLowerCase();
                if (s.length() > 32)
                {
                    String s1 = s.substring(0, 32);
                    s = s.substring(32, s.length());
                    if (s1.equals(file1) || s.equals(file1))
                    {
                        return true;
                    }
                }
                return false;
            }

            
            {
                this$0 = Venue.Empty.this;
                super();
            }
        });
        if (as != null && as.length > 0)
        {
            return new File(file, as[0]);
        } else
        {
            return null;
        }
    }

    public Zone getCurrentZone()
    {
        LogUtils.logE(Venue.access$500(), "Venue.Empty#getCurrentZone not implemented");
        return null;
    }

    public Location getLocation()
    {
        LogUtils.logW(Venue.access$500(), "Venue.Empty#getLocation not implemented");
        return null;
    }

    public String getUUID()
    {
        return id;
    }

    public Zone nextZone()
    {
        LogUtils.logE(Venue.access$500(), "Venue.Empty#nextZone not implemented");
        return null;
    }

    Place placeNear(Zone zone, int i, int j)
    {
        LogUtils.logE(Venue.access$500(), "Venue.Empty#placeNear not implemented");
        return null;
    }

    public Zone previousZone()
    {
        LogUtils.logE(Venue.access$500(), "Venue.Empty#previousZone not implemented");
        return null;
    }

    public Zone setZoneByUUID(String s)
    {
        LogUtils.logE(Venue.access$500(), "Venue.Empty#getZoneByUUID not implemented");
        return null;
    }

    protected e(String s)
    {
        super(null, new com.pointinside.feeds.ity.ImageType[0]);
        id = s;
    }
}
