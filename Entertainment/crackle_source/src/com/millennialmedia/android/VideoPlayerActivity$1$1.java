// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.net.Uri;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.android:
//            VideoPlayerActivity, AdProperties, OverlaySettings

class this._cls1
    implements Runnable
{

    final leButtons this$1;

    public void run()
    {
        enableButtons();
    }

    ionListenerImpl()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/millennialmedia/android/VideoPlayerActivity$1

/* anonymous class */
    class VideoPlayerActivity._cls1 extends HttpRedirection.RedirectionListenerImpl
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
            runOnUiThread(new VideoPlayerActivity._cls1._cls1());
            if (uri != null && VideoPlayerActivity.access$000(VideoPlayerActivity.this, uri))
            {
                processVideoPlayerUri(uri.getHost());
                return true;
            } else
            {
                return false;
            }
        }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
    }

}
