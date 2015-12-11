// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.net.url;

import com.pointinside.internal.ParameterCheck;
import java.util.HashMap;

// Referenced classes of package com.pointinside.net.url:
//            FeedsURLBuilder

public class FeedsZoneImagesURLBuilder extends FeedsURLBuilder
{

    public static final String KEY_IMAGE_TYPE = "imageType".intern();
    public com.pointinside.feeds.ZoneImageEntity.ImageType imageType;
    public String zoneImageId;

    public FeedsZoneImagesURLBuilder(String s)
    {
        this(s, null, com.pointinside.feeds.ZoneImageEntity.ImageType.DEFAULT);
    }

    public FeedsZoneImagesURLBuilder(String s, String s1, com.pointinside.feeds.ZoneImageEntity.ImageType imagetype)
    {
        super(s);
        zoneImageId = null;
        imageType = com.pointinside.feeds.ZoneImageEntity.ImageType.DEFAULT;
        zoneImageId = s1;
        imageType = imagetype;
    }

    public void onPrepareURL()
    {
        super.onPrepareURL();
        parameters.put(KEY_IMAGE_TYPE, imageType.name());
        ParameterCheck.throwIfNullOrEmpty("venueUUID", venueUUID);
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(venueUUID);
        stringbuilder.append("/zoneImages");
        if (zoneImageId != null)
        {
            stringbuilder.append("/").append(zoneImageId);
        }
        setQualifiers(stringbuilder.toString());
    }

}
