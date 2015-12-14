// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.aviary;

import android.content.Context;
import com.amazon.gallery.framework.network.cloudfront.CloudFrontConfig;

// Referenced classes of package com.amazon.gallery.foundation.utils.aviary:
//            ContentLoader

public class StickerContentLoader extends ContentLoader
{

    public StickerContentLoader(Context context, CloudFrontConfig cloudfrontconfig)
    {
        super(context, cloudfrontconfig);
    }

    protected int getDisplayDescriptionResource()
    {
        return 0x7f0e02b1;
    }

    protected int getDisplayNameResource()
    {
        return 0x7f0e02b2;
    }

    protected String getJsonName()
    {
        return "stickers.json";
    }

    public String getPackIdentifier()
    {
        return "com.amazon.sticker";
    }

    protected String getPath()
    {
        return "photos/aviary/latest/stickers.json";
    }
}
