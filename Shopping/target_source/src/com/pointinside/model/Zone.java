// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.model;

import android.graphics.PointF;
import android.location.Location;
import com.pointinside.feeds.PlaceEntity;
import com.pointinside.feeds.ZoneEntity;
import com.pointinside.feeds.ZoneImageEntity;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.pointinside.model:
//            ZoneImage, ZoneUtils, Place, Venue

public class Zone
    implements Comparable
{

    static final float FEET_TO_METERS = 0.3048F;
    private static final com.pointinside.feeds.ZoneImageEntity.ImageType IMG_TYPE;
    private static final com.pointinside.feeds.ZoneImageEntity.MimeType MIME_TYPE;
    private static final String TAG = com/pointinside/model/Zone.getSimpleName();
    private ZoneEntity mEntity;
    private LinkedHashMap mImagesByType;
    private Venue mParent;
    private List mPlaces;

    private transient Zone(Venue venue, ZoneEntity zoneentity, com.pointinside.feeds.ZoneImageEntity.ImageType aimagetype[])
    {
        mEntity = zoneentity;
        mParent = venue;
        mImagesByType = applyTypeFilter(mEntity.zoneImages, aimagetype);
    }

    private static transient LinkedHashMap applyTypeFilter(List list, com.pointinside.feeds.ZoneImageEntity.ImageType aimagetype[])
    {
        int i = 0;
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        list = sortImagesByType(list);
        if (aimagetype.length <= 0)
        {
            aimagetype = new com.pointinside.feeds.ZoneImageEntity.ImageType[1];
            aimagetype[0] = IMG_TYPE;
        }
        for (; i < aimagetype.length; i++)
        {
            if (list.containsKey(aimagetype[i]))
            {
                linkedhashmap.put(aimagetype[i], list.get(aimagetype[i]));
            }
        }

        return linkedhashmap;
    }

    public static transient Zone newFull(Venue venue, ZoneEntity zoneentity, com.pointinside.feeds.ZoneImageEntity.ImageType aimagetype[])
    {
        if (zoneentity == null)
        {
            return null;
        } else
        {
            return new Zone(venue, zoneentity, aimagetype);
        }
    }

    private static HashMap sortImagesByType(List list)
    {
        HashMap hashmap = new HashMap();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            ZoneImageEntity zoneimageentity = (ZoneImageEntity)list.next();
            if (zoneimageentity.mimeType == MIME_TYPE)
            {
                hashmap.put(zoneimageentity.imageType, zoneimageentity);
            }
        } while (true);
        return hashmap;
    }

    public int compareTo(Zone zone)
    {
        if (mEntity.displayOrder > zone.mEntity.displayOrder)
        {
            return 1;
        }
        return mEntity.displayOrder >= zone.mEntity.displayOrder ? 0 : -1;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((Zone)obj);
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof Zone)) 
        {
            return false;
        }
        obj = (Zone)obj;
        return getUUID().equals(((Zone) (obj)).getUUID());
    }

    public PointF getCenter()
    {
        PointF pointf = getImageSizeInMapUnits();
        PointF pointf1 = new PointF();
        pointf1.x = pointf.x / 2.0F;
        pointf1.y = pointf.y / 2.0F;
        return pointf1;
    }

    float getFeetPerPixelX()
    {
        return getImage().getFtPerPxX();
    }

    float getFeetPerPixelY()
    {
        return getImage().getFtPerPxY();
    }

    ZoneImage getImage()
        throws IllegalArgumentException
    {
        Iterator iterator = mImagesByType.entrySet().iterator();
        if (!iterator.hasNext())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Could not find default ImageType in Zone ").append(getUUID()).toString());
        } else
        {
            return ZoneImage.newFull(this, (ZoneImageEntity)((java.util.Map.Entry)iterator.next()).getValue());
        }
    }

    public String getImagePath(File file)
        throws IllegalArgumentException
    {
        return getImage().getCacheFile(file).getAbsolutePath();
    }

    public PointF getImageSizeInMapUnits()
    {
        ZoneImage zoneimage = getImage();
        return new PointF((float)zoneimage.getWidth() / zoneimage.getBaseRatioX(), (float)zoneimage.getHeight() / zoneimage.getBaseRatioY());
    }

    public PointF getImageSizeInMeters()
    {
        ZoneImage zoneimage = getImage();
        return new PointF(zoneimage.getWidthInMeters(), zoneimage.getHeightInMeters());
    }

    public float getImageSizeX()
    {
        ZoneImage zoneimage = getImage();
        return (float)zoneimage.getWidth() / zoneimage.getBaseRatioX();
    }

    public float getImageSizeY()
    {
        ZoneImage zoneimage = getImage();
        return (float)zoneimage.getHeight() / zoneimage.getBaseRatioY();
    }

    transient List getImages(com.pointinside.feeds.ZoneImageEntity.ImageType aimagetype[])
        throws IllegalArgumentException
    {
        ArrayList arraylist = new ArrayList();
        int j;
        if (aimagetype.length <= 0)
        {
            aimagetype = new com.pointinside.feeds.ZoneImageEntity.ImageType[1];
            aimagetype[0] = IMG_TYPE;
        }
        j = aimagetype.length;
        for (int i = 0; i < j; i++)
        {
            com.pointinside.feeds.ZoneImageEntity.ImageType imagetype = aimagetype[i];
            if (!mImagesByType.keySet().contains(imagetype))
            {
                throw new IllegalArgumentException((new StringBuilder()).append("No image of type::").append(imagetype).append("exists for Zone:").append(mEntity.id).toString());
            }
            arraylist.add(ZoneImage.newFull(this, (ZoneImageEntity)mImagesByType.get(imagetype)));
        }

        return arraylist;
    }

    public Location getLatLonOfXY(float f, float f1)
    {
        return ZoneUtils.getLatLonOfXY(this, f, f1);
    }

    public PointF getMetersPerMapUnit()
    {
        ZoneImage zoneimage = getImage();
        float f = zoneimage.getFtPerPxX() / 3.28084F;
        float f1 = zoneimage.getFtPerPxY() / 3.28084F;
        return new PointF(f * zoneimage.getBaseRatioX(), zoneimage.getBaseRatioY() * f1);
    }

    public float getMetersPerMapUnitX()
    {
        ZoneImage zoneimage = getImage();
        float f = zoneimage.getFtPerPxX() / 3.28084F;
        return zoneimage.getBaseRatioX() * f;
    }

    public float getMetersPerMapUnitY()
    {
        ZoneImage zoneimage = getImage();
        float f = zoneimage.getFtPerPxY() / 3.28084F;
        return zoneimage.getBaseRatioY() * f;
    }

    public String getName()
    {
        return mEntity.name;
    }

    public double getPoint1Latitude()
    {
        return mEntity.point1Latitude;
    }

    public double getPoint1Longitude()
    {
        return mEntity.point1Longitude;
    }

    public int getPoint1PixelX()
    {
        return getImage().getPoint1PixelX();
    }

    public int getPoint1PixelY()
    {
        return getImage().getPoint1PixelY();
    }

    public double getPoint2Latitude()
    {
        return mEntity.point2Latitude;
    }

    public double getPoint2Longitude()
    {
        return mEntity.point2Longitude;
    }

    public int getPoint2PixelX()
    {
        return getImage().getPoint2PixelX();
    }

    public int getPoint2PixelY()
    {
        return getImage().getPoint2PixelY();
    }

    public double getPoint3Latitude()
    {
        return mEntity.point3Latitude;
    }

    public double getPoint3Longitude()
    {
        return mEntity.point3Longitude;
    }

    public int getPoint3PixelX()
    {
        return getImage().getPoint3PixelX();
    }

    public int getPoint3PixelY()
    {
        return getImage().getPoint3PixelY();
    }

    public double getPoint4Latitude()
    {
        return mEntity.point4Latitude;
    }

    public double getPoint4Longitude()
    {
        return mEntity.point4Longitude;
    }

    public int getPoint4PixelX()
    {
        return getImage().getPoint4PixelX();
    }

    public int getPoint4PixelY()
    {
        return getImage().getPoint4PixelY();
    }

    public float getScaleX()
    {
        return 1.0F / getImage().getBaseRatioX();
    }

    public float getScaleY()
    {
        return 1.0F / getImage().getBaseRatioY();
    }

    public List getServices()
    {
        if (mPlaces == null)
        {
            mPlaces = new ArrayList();
            PlaceEntity placeentity;
            for (Iterator iterator = mEntity.services.iterator(); iterator.hasNext(); mPlaces.add(new Place(placeentity)))
            {
                placeentity = (PlaceEntity)iterator.next();
            }

        }
        return mPlaces;
    }

    public String getUUID()
    {
        return mEntity.id;
    }

    public String getVenueUUID()
    {
        return mParent.getUUID();
    }

    public com.pointinside.maps.Location getXYOfLatLon(double d, double d1)
    {
        return ZoneUtils.getXYOfLatLon(this, d, d1);
    }

    public int hashCode()
    {
        return getUUID().hashCode();
    }

    public Place placeNear(int i, int j)
    {
        return mParent.placeNear(this, i, j);
    }

    static 
    {
        MIME_TYPE = com.pointinside.feeds.ZoneImageEntity.MimeType.SVG;
        IMG_TYPE = com.pointinside.feeds.ZoneImageEntity.ImageType.DEFAULT4;
    }
}
