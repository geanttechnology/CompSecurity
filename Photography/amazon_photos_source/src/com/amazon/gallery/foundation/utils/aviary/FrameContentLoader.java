// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.aviary;

import android.content.Context;
import com.amazon.gallery.framework.network.cloudfront.CloudFrontConfig;

// Referenced classes of package com.amazon.gallery.foundation.utils.aviary:
//            ContentLoader

public class FrameContentLoader extends ContentLoader
{

    public FrameContentLoader(Context context, CloudFrontConfig cloudfrontconfig)
    {
        super(context, cloudfrontconfig);
    }

    protected int getDisplayDescriptionResource()
    {
        return 0x7f0e02ad;
    }

    protected int getDisplayNameResource()
    {
        return 0x7f0e02ae;
    }

    protected String getJsonName()
    {
        return "frames.json";
    }

    public String getPackIdentifier()
    {
        return "com.amazon.frame";
    }

    protected String getPath()
    {
        return "photos/aviary/latest/frames.json";
    }
}
