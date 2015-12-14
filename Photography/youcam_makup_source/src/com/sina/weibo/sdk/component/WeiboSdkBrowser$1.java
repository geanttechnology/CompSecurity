// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.component;

import android.text.TextUtils;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.utils.LogUtil;

// Referenced classes of package com.sina.weibo.sdk.component:
//            WeiboSdkBrowser, ShareRequestParam

class val.req
    implements RequestListener
{

    final WeiboSdkBrowser this$0;
    private final ShareRequestParam val$req;

    public void onComplete(String s)
    {
        LogUtil.d(WeiboSdkBrowser.access$8(), (new StringBuilder("post onComplete : ")).append(s).toString());
        s = UploadPicResult.parse(s);
        if (s != null && s.getCode() == 1 && !TextUtils.isEmpty(s.getPicId()))
        {
            WeiboSdkBrowser.access$9(WeiboSdkBrowser.this, val$req.buildUrl(s.getPicId()));
            return;
        } else
        {
            val$req.sendSdkErrorResponse(WeiboSdkBrowser.this, "upload pic faild");
            finish();
            return;
        }
    }

    public void onWeiboException(WeiboException weiboexception)
    {
        LogUtil.d(WeiboSdkBrowser.access$8(), (new StringBuilder("post onWeiboException ")).append(weiboexception.getMessage()).toString());
        val$req.sendSdkErrorResponse(WeiboSdkBrowser.this, weiboexception.getMessage());
        finish();
    }

    UploadPicResult()
    {
        this$0 = final_weibosdkbrowser;
        val$req = ShareRequestParam.this;
        super();
    }
}
