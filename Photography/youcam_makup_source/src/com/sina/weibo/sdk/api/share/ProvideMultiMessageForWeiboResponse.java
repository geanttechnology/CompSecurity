// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.api.WeiboMultiMessage;

// Referenced classes of package com.sina.weibo.sdk.api.share:
//            BaseResponse, VersionCheckHandler

public class ProvideMultiMessageForWeiboResponse extends BaseResponse
{

    public WeiboMultiMessage multiMessage;

    public ProvideMultiMessageForWeiboResponse()
    {
    }

    public ProvideMultiMessageForWeiboResponse(Bundle bundle)
    {
        fromBundle(bundle);
    }

    final boolean check(Context context, VersionCheckHandler versioncheckhandler)
    {
        while (multiMessage == null || versioncheckhandler != null && !versioncheckhandler.checkResponse(context, reqPackageName, multiMessage)) 
        {
            return false;
        }
        return multiMessage.checkArgs();
    }

    public void fromBundle(Bundle bundle)
    {
        super.fromBundle(bundle);
        multiMessage = new WeiboMultiMessage(bundle);
    }

    public int getType()
    {
        return 2;
    }

    public void toBundle(Bundle bundle)
    {
        super.toBundle(bundle);
        bundle.putAll(multiMessage.toBundle(bundle));
    }
}
