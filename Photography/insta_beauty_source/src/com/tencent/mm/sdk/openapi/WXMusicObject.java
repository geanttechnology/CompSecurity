// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.Log;

public class WXMusicObject
    implements WXMediaMessage.IMediaObject
{

    public String musicLowBandUrl;
    public String musicUrl;

    public WXMusicObject()
    {
    }

    public boolean checkArgs()
    {
        if ((musicUrl == null || musicUrl.length() == 0) && (musicLowBandUrl == null || musicLowBandUrl.length() == 0))
        {
            Log.e("MicroMsg.SDK.WXMusicObject", "both arguments are null");
            return false;
        }
        if (musicUrl != null && musicUrl.length() > 10240)
        {
            Log.e("MicroMsg.SDK.WXMusicObject", "checkArgs fail, musicUrl is too long");
            return false;
        }
        if (musicLowBandUrl != null && musicLowBandUrl.length() > 10240)
        {
            Log.e("MicroMsg.SDK.WXMusicObject", "checkArgs fail, musicLowBandUrl is too long");
            return false;
        } else
        {
            return true;
        }
    }

    public void serialize(Bundle bundle)
    {
        bundle.putString("_wxmusicobject_musicUrl", musicUrl);
        bundle.putString("_wxmusicobject_musicLowBandUrl", musicLowBandUrl);
    }

    public int type()
    {
        return 3;
    }

    public void unserialize(Bundle bundle)
    {
        musicUrl = bundle.getString("_wxmusicobject_musicUrl");
        musicLowBandUrl = bundle.getString("_wxmusicobject_musicLowBandUrl");
    }
}
