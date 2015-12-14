// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api.share;

import android.app.Activity;
import android.content.Intent;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WeiboAuthListener;

// Referenced classes of package com.sina.weibo.sdk.api.share:
//            BaseRequest, BaseResponse

public interface IWeiboShareAPI
{

    public abstract int getWeiboAppSupportAPI();

    public abstract boolean handleWeiboRequest(Intent intent, IWeiboHandler.Request request);

    public abstract boolean handleWeiboResponse(Intent intent, IWeiboHandler.Response response);

    public abstract boolean isSupportWeiboPay();

    public abstract boolean isWeiboAppInstalled();

    public abstract boolean isWeiboAppSupportAPI();

    public abstract boolean launchWeibo(Activity activity);

    public abstract boolean launchWeiboPay(Activity activity, String s);

    public abstract boolean registerApp();

    public abstract boolean sendRequest(Activity activity, BaseRequest baserequest);

    public abstract boolean sendRequest(Activity activity, BaseRequest baserequest, AuthInfo authinfo, String s, WeiboAuthListener weiboauthlistener);

    public abstract boolean sendResponse(BaseResponse baseresponse);
}
