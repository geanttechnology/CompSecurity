// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.amazon.mShop.web.MShopWebActivity;

// Referenced classes of package com.amazon.mShop.util:
//            TextUtils, ActivityUtils

static final class init> extends ClickableSpan
{

    final String val$url;

    public void onClick(View view)
    {
        view = view.getContext();
        view.startActivity(ActivityUtils.getStartWebActivityIntent(view, com/amazon/mShop/web/MShopWebActivity, val$url, -1));
    }

    s(String s)
    {
        val$url = s;
        super();
    }
}
