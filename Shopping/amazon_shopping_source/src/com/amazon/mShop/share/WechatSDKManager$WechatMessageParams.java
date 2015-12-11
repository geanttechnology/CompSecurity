// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.share;

import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.amazon.mShop.share:
//            WechatSDKManager

private static class shareToFriend
{

    private final Context context;
    private final Intent intent;
    private boolean shareToFriend;

    public Context getShareContext()
    {
        return context;
    }

    public Intent getShareIntent()
    {
        return intent;
    }

    public boolean isShareToFriend()
    {
        return shareToFriend;
    }

    public A(Context context1, Intent intent1, boolean flag)
    {
        context = context1;
        intent = intent1;
        shareToFriend = flag;
    }
}
