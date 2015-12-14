// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.net;

import android.content.Context;

// Referenced classes of package com.sina.weibo.sdk.net:
//            HttpManager, WeiboParameters, RequestListener

public class NetUtils
{

    public NetUtils()
    {
    }

    public static String internalDownloadFile(Context context, String s, String s1, String s2)
    {
        return HttpManager.downloadFile(context, s, s1, s2);
    }

    public static String internalGetRedirectUri(Context context, String s, String s1, WeiboParameters weiboparameters)
    {
        return HttpManager.openRedirectUrl4LocationUri(context, s, s1, weiboparameters);
    }

    public static String internalHttpRequest(Context context, String s, String s1, WeiboParameters weiboparameters)
    {
        return HttpManager.openUrl(context, s, s1, weiboparameters);
    }

    public static void internalHttpRequest(Context context, String s, WeiboParameters weiboparameters, String s1, RequestListener requestlistener)
    {
        (new AsyncWeiboRunner.RequestRunner(context, s, weiboparameters, s1, requestlistener)).execute(new Void[1]);
    }
}
