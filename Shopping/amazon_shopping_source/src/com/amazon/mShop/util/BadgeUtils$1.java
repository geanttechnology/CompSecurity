// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonBrandedWebView;
import com.amazon.rio.j2me.client.services.mShop.HyperText;
import com.amazon.rio.j2me.client.services.mShop.RichMessage;
import java.util.List;

// Referenced classes of package com.amazon.mShop.util:
//            BadgeUtils

static final class val.linkUrl
    implements android.view.istener
{

    final AmazonActivity val$activity;
    final String val$linkUrl;
    final RichMessage val$richMessage;

    public void onClick(View view)
    {
        view = (HyperText)val$richMessage.getMessages().get(0);
        if (view != null)
        {
            val$activity.pushView(new AmazonBrandedWebView(val$activity, val$linkUrl, view.getText()));
            return;
        } else
        {
            val$activity.pushView(new AmazonBrandedWebView(val$activity, val$linkUrl, null));
            return;
        }
    }

    .mShop.RichMessage(RichMessage richmessage, AmazonActivity amazonactivity, String s)
    {
        val$richMessage = richmessage;
        val$activity = amazonactivity;
        val$linkUrl = s;
        super();
    }
}
