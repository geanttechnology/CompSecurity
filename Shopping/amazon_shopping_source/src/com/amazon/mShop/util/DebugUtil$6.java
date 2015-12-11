// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.DialogInterface;
import android.view.View;
import android.webkit.HttpAuthHandler;
import android.webkit.WebView;
import android.widget.EditText;

// Referenced classes of package com.amazon.mShop.util:
//            DebugUtil, Util

static final class val.handler
    implements android.content.ace.OnClickListener
{

    final View val$dialogView;
    final HttpAuthHandler val$handler;
    final String val$host;
    final String val$realm;
    final WebView val$view;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        String s = ((EditText)val$dialogView.findViewById(com.amazon.mShop.android.lib.ername)).getText().toString().trim();
        String s1 = ((EditText)val$dialogView.findViewById(com.amazon.mShop.android.lib.ssword)).getText().toString().trim();
        if (!Util.isEmpty(s) && !Util.isEmpty(s1))
        {
            val$view.setHttpAuthUsernamePassword(val$host, val$realm, s, s1);
            val$handler.proceed(s, s1);
        }
        dialoginterface.dismiss();
    }

    ClickListener(View view1, WebView webview, String s, String s1, HttpAuthHandler httpauthhandler)
    {
        val$dialogView = view1;
        val$view = webview;
        val$host = s;
        val$realm = s1;
        val$handler = httpauthhandler;
        super();
    }
}
