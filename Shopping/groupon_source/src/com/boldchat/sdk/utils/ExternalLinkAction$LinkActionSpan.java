// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.style.ClickableSpan;
import android.view.View;

// Referenced classes of package com.boldchat.sdk.utils:
//            ExternalLinkAction

public static class mContext extends ClickableSpan
{

    private final Context mContext;
    private String mUrl;

    public void onClick(View view)
    {
        view = new Intent("android.intent.action.VIEW");
        view.setData(Uri.parse(mUrl));
        mContext.startActivity(view);
    }

    public (String s, Context context)
    {
        mUrl = s;
        mContext = context;
    }
}
