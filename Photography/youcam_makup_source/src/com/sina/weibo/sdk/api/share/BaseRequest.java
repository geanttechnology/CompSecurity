// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;

// Referenced classes of package com.sina.weibo.sdk.api.share:
//            Base, VersionCheckHandler

public abstract class BaseRequest extends Base
{

    public String packageName;

    public BaseRequest()
    {
    }

    abstract boolean check(Context context, com.sina.weibo.sdk.WeiboAppManager.WeiboInfo weiboinfo, VersionCheckHandler versioncheckhandler);

    public void fromBundle(Bundle bundle)
    {
        transaction = bundle.getString("_weibo_transaction");
        packageName = bundle.getString("_weibo_appPackage");
    }

    public void toBundle(Bundle bundle)
    {
        bundle.putInt("_weibo_command_type", getType());
        bundle.putString("_weibo_transaction", transaction);
    }
}
