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

    protected transient Boolean doInBackground(ams aams[])
    {
        Object obj = aams[0].getShareContext();
        android.content.Intent intent = aams[0].getShareIntent();
        boolean flag = aams[0].isShareToFriend();
        com.tencent.mm.sdk.modelmsg.WXMediaMessage wxmediamessage = WechatSDKManager.access$200(((android.content.Context) (obj)), intent, flag);
        aams = new com.tencent.mm.sdk.modelmsg.sShareToFriend();
        aams.sShareToFriend = WechatSDKManager.access$300(intent);
        aams.sShareToFriend = wxmediamessage;
        if (flag)
        {
            aams.sShareToFriend = 0;
        } else
        {
            aams.sShareToFriend = 1;
        }
        obj = WechatSDKManager.getAPIHandle(((android.content.Context) (obj)));
        if (obj == null)
        {
            return Boolean.valueOf(false);
        } else
        {
            return Boolean.valueOf(((IWXAPI) (obj)).sendReq(aams));
        }
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((ams[])aobj);
    }

    private ams()
    {
    }

    ams(ams ams)
    {
        this();
    }
}
