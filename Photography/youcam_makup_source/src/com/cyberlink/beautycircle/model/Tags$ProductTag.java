// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import android.net.Uri;
import com.perfectcorp.model.Model;

public class brandName extends Model
{

    public String brandName;
    public long productId;
    public String productName;
    public Uri productThumbnail;
    public String tagPoint;

    public void a(TagPoint tagpoint)
    {
        class TagPoint extends Model
        {

            public double xRatio;
            public double yRatio;

            public TagPoint()
            {
            }
        }

        if (tagpoint != null)
        {
            tagPoint = tagpoint.toString();
        }
    }

    public TagPoint b()
    {
        return (TagPoint)Model.a(com/cyberlink/beautycircle/model/Tags$ProductTag$TagPoint, tagPoint);
    }

    public TagPoint()
    {
        productId = -1L;
        productName = null;
        productThumbnail = null;
        tagPoint = null;
        brandName = null;
    }
}
