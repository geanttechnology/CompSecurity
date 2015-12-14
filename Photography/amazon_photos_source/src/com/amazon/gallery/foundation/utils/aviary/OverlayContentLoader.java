// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.aviary;

import android.content.Context;
import com.amazon.gallery.framework.network.cloudfront.CloudFrontConfig;

// Referenced classes of package com.amazon.gallery.foundation.utils.aviary:
//            ContentLoader

public class OverlayContentLoader extends ContentLoader
{

    public OverlayContentLoader(Context context, CloudFrontConfig cloudfrontconfig)
    {
        super(context, cloudfrontconfig);
    }

    protected int getDisplayDescriptionResource()
    {
        return 0x7f0e02af;
    }

    protected int getDisplayNameResource()
    {
        return 0x7f0e02b0;
    }

    protected String getJsonName()
    {
        return "overlays.json";
    }

    public String getPackIdentifier()
    {
        return "com.amazon.overlay";
    }

    protected String getPath()
    {
        return "photos/aviary/latest/overlays.json";
    }
}
