// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adcontrollers;

import android.content.Context;
import com.millennialmedia.internal.AdMetadata;
import com.millennialmedia.internal.MMWebView;

// Referenced classes of package com.millennialmedia.internal.adcontrollers:
//            WebController

class val.adContent
    implements Runnable
{

    final WebController this$0;
    final String val$adContent;
    final AdMetadata val$adMetadata;
    final Context val$context;
    final boolean val$isInterstitial;
    final bControllerListener val$webControllerListener;

    public void run()
    {
        WebController.access$002(WebController.this, createWebView(val$context, val$isInterstitial, false, val$adMetadata, val$webControllerListener));
        WebController.access$000(WebController.this).setContent(val$adContent);
    }

    bControllerListener()
    {
        this$0 = final_webcontroller;
        val$context = context1;
        val$isInterstitial = flag;
        val$adMetadata = admetadata;
        val$webControllerListener = bcontrollerlistener;
        val$adContent = String.this;
        super();
    }
}
