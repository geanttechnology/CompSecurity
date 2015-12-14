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

class val.url
    implements Runnable
{

    final val.url this$1;
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
        final MMWebView mmWebView = (MMWebView)JSBridge.access$100(_fld0).get();
        if (mmWebView != null)
        {
            InlineWebVideoView inlinewebvideoview = new InlineWebVideoView(mmWebView.getContext(), val$autoPlay, val$muted, val$showMediaControls, val$showExpandControls, val$timeUpdateInterval, val$callbackId, new com.millennialmedia.internal.video.InlineWebVideoView.InlineWebVideoViewListener() {

                final JSBridge.JSBridgeInlineVideo._cls1 this$2;
                final MMWebView val$mmWebView;

                public void onClicked()
                {
                    mmWebView.onNotifyClicked();
                }

            
            {
                this$2 = JSBridge.JSBridgeInlineVideo._cls1.this;
                mmWebView = mmwebview;
                super();
            }
            });
            cess._mth500(this._cls1.this).put(inlinewebvideoview.getTag(), inlinewebvideoview);
            android.util.DisplayMetrics displaymetrics = mmWebView.getContext().getResources().getDisplayMetrics();
            inlinewebvideoview.setAnchorView(mmWebView, cess._mth600(this._cls1.this, displaymetrics, val$x), cess._mth600(this._cls1.this, displaymetrics, val$y), cess._mth600(this._cls1.this, displaymetrics, val$width), cess._mth600(this._cls1.this, displaymetrics, val$height), new com.millennialmedia.internal.video.InlineWebVideoView.InlineWebVideoViewAttachListener() {

                final JSBridge.JSBridgeInlineVideo._cls1 this$2;

                public void attachFailed(InlineWebVideoView inlinewebvideoview1)
                {
                    JSBridge.JSBridgeInlineVideo.access$500(this$1).remove(inlinewebvideoview1.getTag());
                }

                public void attachSucceeded(InlineWebVideoView inlinewebvideoview1)
                {
                    JSBridge.JSBridgeInlineVideo.access$500(this$1).remove(inlinewebvideoview1.getTag());
                }

            
            {
                this$2 = JSBridge.JSBridgeInlineVideo._cls1.this;
                super();
            }
            });
            if (val$placeholder != null)
            {
                inlinewebvideoview.setPlaceholder(Uri.parse(val$placeholder));
            }
            inlinewebvideoview.setVideoURI(Uri.parse(val$url));
        }
    }

    _cls2.this._cls2()
    {
        this$1 = final__pcls2;
        val$autoPlay = flag;
        val$muted = flag1;
        val$showMediaControls = flag2;
        val$showExpandControls = flag3;
        val$timeUpdateInterval = i;
        val$callbackId = s;
        val$x = j;
        val$y = k;
        val$width = l;
        val$height = i1;
        val$placeholder = s1;
        val$url = String.this;
        super();
    }
}
