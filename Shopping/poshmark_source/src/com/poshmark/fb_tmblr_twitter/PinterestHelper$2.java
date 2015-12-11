// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.fb_tmblr_twitter;

import android.content.Intent;
import android.os.Bundle;
import com.pinterest.android.pdk.PDKClient;
import com.poshmark.notifications.PMNotificationListener;

// Referenced classes of package com.poshmark.fb_tmblr_twitter:
//            PinterestHelper

static final class r
    implements PMNotificationListener
{

    public void handleNotification(Intent intent)
    {
        intent.putExtra("PDKCLIENT_EXTRA_RESULT", intent.getBundleExtra("RESULT").getString("PDKCLIENT_EXTRA_RESULT"));
        PDKClient.getInstance().onOauthResponse(8772, -1, intent);
    }

    r()
    {
    }
}
