// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.location;

import android.text.TextUtils;
import com.amazon.geo.mapsv2.model.LatLng;
import com.amazon.now.cookie.NowAppContextCookie;
import com.amazon.now.util.DataStore;

// Referenced classes of package com.amazon.now.location:
//            LocaleManager

public class Location
{

    private static String sDomain;
    private static String sImageUrl;
    private static LatLng sMapCenter;
    private static String sMarketplace;
    private static String sName;
    private static String sStores;
    private static String sZipcode;

    public Location()
    {
    }

    public static String getDomain()
    {
        com/amazon/now/location/Location;
        JVM INSTR monitorenter ;
        String s;
        if (sDomain == null)
        {
            sDomain = DataStore.getString("nowLocationDomain");
        }
        if (TextUtils.isEmpty(sDomain))
        {
            sDomain = LocaleManager.getInstance().getDefaultDomain();
        }
        s = sDomain;
        com/amazon/now/location/Location;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public static String getImageUrl()
    {
        com/amazon/now/location/Location;
        JVM INSTR monitorenter ;
        String s;
        if (sImageUrl == null)
        {
            sImageUrl = DataStore.getString("nowLocationImageUrl");
        }
        s = sImageUrl;
        com/amazon/now/location/Location;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public static LatLng getMapCenter()
    {
        com/amazon/now/location/Location;
        JVM INSTR monitorenter ;
        LatLng latlng;
        if (sMapCenter == null)
        {
            String s = DataStore.getString("nowLocationMapCenterLat");
            String s1 = DataStore.getString("nowLocationMapCenterLon");
            if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1))
            {
                sMapCenter = new LatLng(Double.parseDouble(s), Double.parseDouble(s1));
            }
        }
        latlng = sMapCenter;
        com/amazon/now/location/Location;
        JVM INSTR monitorexit ;
        return latlng;
        Exception exception;
        exception;
        throw exception;
    }

    public static String getMarketplace()
    {
        com/amazon/now/location/Location;
        JVM INSTR monitorenter ;
        String s;
        if (sMarketplace == null)
        {
            sMarketplace = DataStore.getString("nowLocationMarketplace");
        }
        s = sMarketplace;
        com/amazon/now/location/Location;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public static String getName()
    {
        com/amazon/now/location/Location;
        JVM INSTR monitorenter ;
        String s;
        if (sName == null)
        {
            sName = DataStore.getString("nowLocationName");
        }
        s = sName;
        com/amazon/now/location/Location;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public static String getStores()
    {
        com/amazon/now/location/Location;
        JVM INSTR monitorenter ;
        String s;
        if (sStores == null)
        {
            sStores = DataStore.getString("nowLocationsStores");
        }
        s = sStores;
        com/amazon/now/location/Location;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public static String getZipcode()
    {
        com/amazon/now/location/Location;
        JVM INSTR monitorenter ;
        String s;
        if (sZipcode == null)
        {
            sZipcode = DataStore.getString("nowLocationZipcode");
        }
        s = sZipcode;
        com/amazon/now/location/Location;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public static boolean isSet()
    {
        com/amazon/now/location/Location;
        JVM INSTR monitorenter ;
        boolean flag = TextUtils.isEmpty(DataStore.getString("nowLocationMarketplace"));
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        com/amazon/now/location/Location;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public static boolean isStoreSet()
    {
        return !TextUtils.isEmpty(DataStore.getString("nowLocationsStores"));
    }

    public static int locationHash()
    {
        return (new StringBuilder()).append(sMarketplace).append(sStores).append(sZipcode).toString().hashCode();
    }

    public static void resetLocation()
    {
        sName = null;
        sDomain = null;
        sMarketplace = null;
        sZipcode = null;
        sImageUrl = null;
        sMapCenter = null;
        DataStore.removeKey("nowLocationName");
        DataStore.removeKey("nowLocationDomain");
        DataStore.removeKey("nowLocationMarketplace");
        DataStore.removeKey("nowLocationZipcode");
        DataStore.removeKey("nowLocationImageUrl");
        DataStore.removeKey("nowLocationMapCenterLat");
        DataStore.removeKey("nowLocationMapCenterLon");
        NowAppContextCookie.updateCookie("marketplaceId", "");
        NowAppContextCookie.syncCookie();
    }

    public static void saveLocation(String s, String s1, String s2, String s3, String s4, double d, double d1)
    {
        sName = s;
        sDomain = s1;
        sMarketplace = s2;
        sZipcode = s3;
        sImageUrl = s4;
        sMapCenter = new LatLng(d, d1);
        sStores = null;
        DataStore.putString("nowLocationName", s);
        DataStore.putString("nowLocationDomain", s1);
        DataStore.putString("nowLocationMarketplace", s2);
        DataStore.putString("nowLocationZipcode", s3);
        DataStore.putString("nowLocationImageUrl", s4);
        DataStore.putString("nowLocationMapCenterLat", Double.toString(d));
        DataStore.putString("nowLocationMapCenterLon", Double.toString(d1));
        DataStore.removeKey("nowLocationsStores");
        NowAppContextCookie.updateCookie("marketplaceId", s2);
        NowAppContextCookie.syncCookie();
    }

    public static boolean saveStores(String s)
    {
        boolean flag;
        if (!TextUtils.equals(s, sStores))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        sStores = s;
        DataStore.putString("nowLocationsStores", s);
        return flag;
    }
}
