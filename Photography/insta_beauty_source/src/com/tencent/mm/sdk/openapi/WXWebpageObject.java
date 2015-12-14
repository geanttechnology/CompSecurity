// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.Log;

public class WXWebpageObject
    implements WXMediaMessage.IMediaObject
{

    public String webpageUrl;

    public WXWebpageObject()
    {
    }

    public WXWebpageObject(String s)
    {
        webpageUrl = s;
    }

    public boolean checkArgs()
    {
        if (webpageUrl == null || webpageUrl.length() == 0 || webpageUrl.length() > 10240)
        {
            Log.e("MicroMsg.SDK.WXWebpageObject", "checkArgs fail, webpageUrl is invalid");
            return false;
        } else
        {
            return true;
        }
    }

    public void serialize(Bundle bundle)
    {
        bundle.putString("_wxwebpageobject_webpageUrl", webpageUrl);
    }

    public int type()
    {
        return 5;
    }

    public void unserialize(Bundle bundle)
    {
        webpageUrl = bundle.getString("_wxwebpageobject_webpageUrl");
    }
}
