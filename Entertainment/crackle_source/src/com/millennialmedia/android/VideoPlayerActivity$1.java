// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.net.Uri;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            VideoPlayerActivity, AdProperties, OverlaySettings

class ctionListenerImpl extends ctionListenerImpl
{

    final VideoPlayerActivity this$0;

    public JSONObject getAdProperties()
    {
        if (adProperties != null)
        {
            return adProperties.getAdProperties();
        } else
        {
            return null;
        }
    }

    public OverlaySettings getOverlaySettings()
    {
        OverlaySettings overlaysettings = null;
        if (lastOverlayOrientation != null)
        {
            overlaysettings = new OverlaySettings();
            overlaysettings.orientation = lastOverlayOrientation;
        }
        return overlaysettings;
    }

    public boolean isHandlingMMVideo(Uri uri)
    {
        runOnUiThread(new Runnable() {

            final VideoPlayerActivity._cls1 this$1;

            public void run()
            {
                enableButtons();
            }

            
            {
                this$1 = VideoPlayerActivity._cls1.this;
                super();
            }
        });
        if (uri != null && VideoPlayerActivity.access$000(VideoPlayerActivity.this, uri))
        {
            processVideoPlayerUri(uri.getHost());
            return true;
        } else
        {
            return false;
        }
    }

    _cls1.this._cls1()
    {
        this$0 = VideoPlayerActivity.this;
        super();
    }
}
