// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api.share;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.exception.WeiboException;

public interface IWeiboShareListener
{

    public abstract void onAuthorizeCancel();

    public abstract void onAuthorizeComplete(Oauth2AccessToken oauth2accesstoken);

    public abstract void onAuthorizeException(WeiboException weiboexception);

    public abstract void onTokenError(String s);
}
