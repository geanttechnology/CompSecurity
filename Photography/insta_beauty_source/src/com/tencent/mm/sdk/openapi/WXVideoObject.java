// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.Log;

public class WXVideoObject
    implements WXMediaMessage.IMediaObject
{

    public String videoLowBandUrl;
    public String videoUrl;

    public WXVideoObject()
    {
    }

    public boolean checkArgs()
    {
        if ((videoUrl == null || videoUrl.length() == 0) && (videoLowBandUrl == null || videoLowBandUrl.length() == 0))
        {
            Log.e("MicroMsg.SDK.WXVideoObject", "both arguments are null");
            return false;
        }
        if (videoUrl != null && videoUrl.length() > 10240)
        {
            Log.e("MicroMsg.SDK.WXVideoObject", "checkArgs fail, videoUrl is too long");
            return false;
        }
        if (videoLowBandUrl != null && videoLowBandUrl.length() > 10240)
        {
            Log.e("MicroMsg.SDK.WXVideoObject", "checkArgs fail, videoLowBandUrl is too long");
            return false;
        } else
        {
            return true;
        }
    }

    public void serialize(Bundle bundle)
    {
        bundle.putString("_wxvideoobject_videoUrl", videoUrl);
        bundle.putString("_wxvideoobject_videoLowBandUrl", videoLowBandUrl);
    }

    public int type()
    {
        return 4;
    }

    public void unserialize(Bundle bundle)
    {
        videoUrl = bundle.getString("_wxvideoobject_videoUrl");
        videoLowBandUrl = bundle.getString("_wxvideoobject_videoLowBandUrl");
    }
}
