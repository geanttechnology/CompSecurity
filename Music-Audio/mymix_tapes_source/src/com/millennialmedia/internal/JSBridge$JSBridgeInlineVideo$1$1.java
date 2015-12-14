// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import com.millennialmedia.internal.video.InlineWebVideoView;
import java.lang.ref.WeakReference;
import java.util.Map;

// Referenced classes of package com.millennialmedia.internal:
//            JSBridge, MMWebView

class val.mmWebView
    implements com.millennialmedia.internal.video.ViewListener
{

    final val.mmWebView this$2;
    final MMWebView val$mmWebView;

    public void onClicked()
    {
        val$mmWebView.onNotifyClicked();
    }

    l.url()
    {
        this$2 = final_url;
        val$mmWebView = MMWebView.this;
        super();
    }

    // Unreferenced inner class com/millennialmedia/internal/JSBridge$JSBridgeInlineVideo$1

/* anonymous class */
    class JSBridge.JSBridgeInlineVideo._cls1
        implements Runnable
    {

        final JSBridge.JSBridgeInlineVideo this$1;
        final boolean val$autoPlay;
        final String val$callbackId;
        final int val$height;
        final boolean val$muted;
        final String val$placeholder;
        final boolean val$showExpandControls;
        final boolean val$showMediaControls;
        final int val$timeUpdateInterval;
        final String val$url;
        final int val$width;
        final int val$x;
        final int val$y;

        public void run()
        {
            MMWebView mmwebview = (MMWebView)JSBridge.access$100(this$0).get();
            if (mmwebview != null)
            {
                InlineWebVideoView inlinewebvideoview = new InlineWebVideoView(mmwebview.getContext(), autoPlay, muted, showMediaControls, showExpandControls, timeUpdateInterval, callbackId, mmwebview. new JSBridge.JSBridgeInlineVideo._cls1._cls1());
                JSBridge.JSBridgeInlineVideo.access$500(JSBridge.JSBridgeInlineVideo.this).put(inlinewebvideoview.getTag(), inlinewebvideoview);
                android.util.DisplayMetrics displaymetrics = mmwebview.getContext().getResources().getDisplayMetrics();
                inlinewebvideoview.setAnchorView(mmwebview, JSBridge.JSBridgeInlineVideo.access$600(JSBridge.JSBridgeInlineVideo.this, displaymetrics, x), JSBridge.JSBridgeInlineVideo.access$600(JSBridge.JSBridgeInlineVideo.this, displaymetrics, y), JSBridge.JSBridgeInlineVideo.access$600(JSBridge.JSBridgeInlineVideo.this, displaymetrics, width), JSBridge.JSBridgeInlineVideo.access$600(JSBridge.JSBridgeInlineVideo.this, displaymetrics, height), new JSBridge.JSBridgeInlineVideo._cls1._cls2());
                if (placeholder != null)
                {
                    inlinewebvideoview.setPlaceholder(Uri.parse(placeholder));
                }
                inlinewebvideoview.setVideoURI(Uri.parse(url));
            }
        }

            
            {
                this$1 = final_jsbridgeinlinevideo;
                autoPlay = flag;
                muted = flag1;
                showMediaControls = flag2;
                showExpandControls = flag3;
                timeUpdateInterval = i;
                callbackId = s;
                x = j;
                y = k;
                width = l;
                height = i1;
                placeholder = s1;
                url = String.this;
                super();
            }

        // Unreferenced inner class com/millennialmedia/internal/JSBridge$JSBridgeInlineVideo$1$2

/* anonymous class */
        class JSBridge.JSBridgeInlineVideo._cls1._cls2
            implements com.millennialmedia.internal.video.InlineWebVideoView.InlineWebVideoViewAttachListener
        {

            final JSBridge.JSBridgeInlineVideo._cls1 this$2;

            public void attachFailed(InlineWebVideoView inlinewebvideoview)
            {
                JSBridge.JSBridgeInlineVideo.access$500(this$1).remove(inlinewebvideoview.getTag());
            }

            public void attachSucceeded(InlineWebVideoView inlinewebvideoview)
            {
                JSBridge.JSBridgeInlineVideo.access$500(this$1).remove(inlinewebvideoview.getTag());
            }

                    
                    {
                        this$2 = JSBridge.JSBridgeInlineVideo._cls1.this;
                        super();
                    }
        }

    }

}
