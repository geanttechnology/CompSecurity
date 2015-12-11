// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.model;

import android.content.Context;
import android.net.Uri;
import com.pointinside.PIMapsAccessor;
import com.pointinside.feeds.ZoneImageEntity;
import com.pointinside.internal.utils.LogUtils;
import com.pointinside.net.url.URLBuilder;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Referenced classes of package com.pointinside.model:
//            Cachable, VenueFactory, Zone

class ZoneImage
    implements Cachable
{

    static final float METERS_TO_FEET = 3.28084F;
    private static final String TAG = com/pointinside/model/ZoneImage.getSimpleName();
    protected ZoneImageEntity mEntity;
    private Zone mParent;
    private boolean needsUpdate;

    private ZoneImage(Zone zone, ZoneImageEntity zoneimageentity)
    {
        mEntity = zoneimageentity;
        mParent = zone;
    }

    static ZoneImage newFull(Zone zone, ZoneImageEntity zoneimageentity)
    {
        return new ZoneImage(zone, zoneimageentity);
    }

    public int cacheSize()
    {
        return 7;
    }

    public float getBaseRatioX()
    {
        return mEntity.baseRatioX;
    }

    public float getBaseRatioY()
    {
        return mEntity.baseRatioY;
    }

    public File getCacheFile(File file)
    {
        String s = VenueFactory.getSvgGuid(mEntity.zoneId);
        if ("PI".equals(file.getName()))
        {
            return new File(file, (new StringBuilder()).append("/").append(getParent().getVenueUUID()).append("/").append(getParent().getUUID()).append("/").append(mEntity.id).append("_").append(s).append(".svg").toString());
        } else
        {
            return new File(file, (new StringBuilder()).append("/PI/").append(getParent().getVenueUUID()).append("/").append(getParent().getUUID()).append("/").append(mEntity.id).append("_").append(s).append(".svg").toString());
        }
    }

    public InputStream getContentAsStream(Context context)
    {
        Object obj = Uri.parse(mEntity.imageUrl).buildUpon().appendQueryParameter(URLBuilder.KEY_API_KEY, PIMapsAccessor.getInstance().getApiKey()).appendQueryParameter(URLBuilder.KEY_DEV_ID, URLBuilder.devId).build();
        context = new ByteArrayInputStream(new byte[0]);
        try
        {
            obj = new BufferedInputStream((new URL(((Uri) (obj)).toString())).openStream());
        }
        catch (Exception exception)
        {
            LogUtils.logD(TAG, (new StringBuilder()).append("No cache found for ").append(getCacheFile(new File(""))).toString(), exception);
            return context;
        }
        return ((InputStream) (obj));
    }

    public float getFtPerPxX()
    {
        return mEntity.feetWidth / (float)mEntity.width;
    }

    public float getFtPerPxY()
    {
        return mEntity.feetHeight / (float)mEntity.height;
    }

    public String getGuid()
    {
        String s = String.valueOf(UUID.randomUUID());
        VenueFactory.saveSvgFileGuid(mEntity.zoneId, s);
        return s;
    }

    public int getHeight()
    {
        return mEntity.height;
    }

    public float getHeightInMeters()
    {
        return mEntity.feetHeight / 3.28084F;
    }

    public File getNewCacheFile(File file)
    {
        String s = getGuid();
        return new File(file, (new StringBuilder()).append("/").append(getParent().getVenueUUID()).append("/").append(getParent().getUUID()).append("/").append(mEntity.id).append("_").append(s).append(".svg").toString());
    }

    Zone getParent()
    {
        return mParent;
    }

    public int getPoint1PixelX()
    {
        return mEntity.point1PixelX;
    }

    public int getPoint1PixelY()
    {
        return mEntity.point1PixelY;
    }

    public int getPoint2PixelX()
    {
        return mEntity.point2PixelX;
    }

    public int getPoint2PixelY()
    {
        return mEntity.point2PixelY;
    }

    public int getPoint3PixelX()
    {
        return mEntity.point3PixelX;
    }

    public int getPoint3PixelY()
    {
        return mEntity.point3PixelY;
    }

    public int getPoint4PixelX()
    {
        return mEntity.point4PixelX;
    }

    public int getPoint4PixelY()
    {
        return mEntity.point4PixelY;
    }

    String getVenueUUID()
    {
        return getParent().getVenueUUID();
    }

    public int getWidth()
    {
        return mEntity.width;
    }

    public float getWidthInMeters()
    {
        return mEntity.feetWidth / 3.28084F;
    }

    public File read(File file)
    {
        file = getCacheFile(file);
        if (file.exists())
        {
            return file;
        } else
        {
            return null;
        }
    }

    public volatile Object read(File file)
        throws IOException
    {
        return read(file);
    }

    public List tryUpdate(File file)
        throws IOException
    {
        file = new ArrayList();
        file.add(this);
        return file;
    }

}
