// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.link.model;

import aan;
import android.content.Context;
import android.net.Uri;
import java.util.HashMap;

public class TMetaInfo
{

    private static final long serialVersionUID = 0xd05865ea13bee513L;
    private String dateTime;
    private float height;
    private double latitude;
    private double longitude;
    private float width;

    public TMetaInfo(Context context, Uri uri)
    {
        try
        {
            context = aan.a(context, uri);
            dateTime = (String)context.get("TAG_DATETIME");
            latitude = Float.parseFloat((String)context.get("TAG_GPS_LATITUDE"));
            longitude = Float.parseFloat((String)context.get("TAG_GPS_LONGITUDE"));
            uri = (String)context.get("TAG_IMAGE_WIDTH");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        if (uri == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        if (uri.length() > 0)
        {
            width = Float.parseFloat(uri);
        }
        context = (String)context.get("TAG_IMAGE_LENGTH");
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        if (context.length() > 0)
        {
            height = Float.parseFloat(context);
        }
    }

    public String getDateTime()
    {
        return dateTime;
    }

    public float getHeight()
    {
        return height;
    }

    public double getLatitude()
    {
        return latitude;
    }

    public double getLongtitude()
    {
        return longitude;
    }

    public float getWidth()
    {
        return width;
    }
}
