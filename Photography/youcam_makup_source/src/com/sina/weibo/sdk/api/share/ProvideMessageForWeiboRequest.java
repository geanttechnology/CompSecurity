// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;

// Referenced classes of package com.sina.weibo.sdk.api.share:
//            BaseRequest, VersionCheckHandler

public class ProvideMessageForWeiboRequest extends BaseRequest
{

    public ProvideMessageForWeiboRequest()
    {
    }

    public ProvideMessageForWeiboRequest(Bundle bundle)
    {
        fromBundle(bundle);
    }

    final boolean check(Context context, com.sina.weibo.sdk.WeiboAppManager.WeiboInfo weiboinfo, VersionCheckHandler versioncheckhandler)
    {
        return true;
    }

    public int getType()
    {
        return 2;
    }
}
