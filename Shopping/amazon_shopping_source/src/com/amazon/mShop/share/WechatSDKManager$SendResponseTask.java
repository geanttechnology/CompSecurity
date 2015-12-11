// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.share;

import android.os.AsyncTask;
import com.tencent.mm.sdk.openapi.IWXAPI;

// Referenced classes of package com.amazon.mShop.share:
//            WechatSDKManager

private static class <init> extends AsyncTask
{

    protected transient Boolean doInBackground(ms ams[])
    {
        Object obj = ams[0].getShareContext();
        com.tencent.mm.sdk.modelmsg.WXMediaMessage wxmediamessage = WechatSDKManager.access$200(((android.content.Context) (obj)), ams[0].getShareIntent(), ams[0].isShareToFriend());
        ams = new com.tencent.mm.sdk.modelmsg.ShareToFriend();
        ams.ShareToFriend = WechatSDKManager.access$400();
        ams.ShareToFriend = wxmediamessage;
        obj = WechatSDKManager.getAPIHandle(((android.content.Context) (obj)));
        if (obj == null)
        {
            return Boolean.valueOf(false);
        } else
        {
            return Boolean.valueOf(((IWXAPI) (obj)).sendResp(ams));
        }
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((ms[])aobj);
    }

    private ms()
    {
    }

    ms(ms ms)
    {
        this();
    }
}
