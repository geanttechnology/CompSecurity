// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;

import android.text.TextUtils;
import com.ebay.nautilus.domain.net.image.ZoomImageId;

// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class ize
{

    public ncodingEnum encoding;
    public String hostingPlatform;
    public String imageURL;
    public RLElements imageURLElements;
    public String imageURLType;
    public String origin;
    public ize originalSize;
    public ize size;
    public String uploadMethod;

    public ZoomImageId getZoomImageId()
    {
        while (imageURLElements == null || TextUtils.isEmpty(imageURLElements.zoomGuid) && TextUtils.isEmpty(imageURLElements.md5Hash)) 
        {
            return null;
        }
        return new ZoomImageId(imageURLElements.zoomGuid, imageURLElements.md5Hash);
    }

    public ize()
    {
    }
}
