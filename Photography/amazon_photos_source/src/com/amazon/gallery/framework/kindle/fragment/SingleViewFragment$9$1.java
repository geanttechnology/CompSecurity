// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.content.Context;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.framework.data.store.DiskStore;
import com.amazon.gallery.framework.gallery.lenticular.GalleryLenticularHelper;
import com.amazon.gallery.framework.gallery.lenticular.LenticularViewer;
import com.amazon.gallery.framework.gallery.video.GalleryVideoViewer;
import com.amazon.gallery.framework.gallery.video.GalleryVideoViewerFactory;
import com.amazon.gallery.framework.gallery.view.android.GifPlayerWebView;
import com.amazon.gallery.framework.gallery.view.android.SingleViewMediaPlayer;
import com.amazon.gallery.framework.gallery.view.android.SingleViewMediaPlayerFactory;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.amazon.ScreenModeManager;
import com.amazon.gallery.framework.model.media.GroupType;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.network.disk.NetworkStore;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.thor.app.FeatureChecker;
import com.amazon.gallery.thor.di.AppKeys;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            SingleViewFragment

class this._cls1
    implements Runnable
{

    final rFullScreen this$1;

    public void run()
    {
        if (SingleViewFragment.access$300(_fld0))
        {
            return;
        }
        if (mScreenModeManager.isFullScreen())
        {
            exitFullScreen();
            return;
        } else
        {
            enterFullScreen();
            return;
        }
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/framework/kindle/fragment/SingleViewFragment$9

/* anonymous class */
    class SingleViewFragment._cls9
        implements SingleViewMediaPlayerFactory
    {

        final SingleViewFragment this$0;

        public SingleViewMediaPlayer getPlayerForMediaItem(MediaItem mediaitem, Context context)
        {
            GifPlayerWebView gifplayerwebview = null;
            if ("image/gif".equals(mediaitem.getMIMEType()))
            {
                gifplayerwebview = new GifPlayerWebView(context);
                gifplayerwebview.setDiskStore((DiskStore)getApplicationBean(Keys.DISK_STORE));
                gifplayerwebview.setNetworkStore((NetworkStore)getApplicationBean(Keys.NETWORK_STORE));
                gifplayerwebview.resumeTimers();
            } else
            {
                if (GroupType.LENTICULAR.equals(mediaitem.getGroupType()))
                {
                    mediaitem = new LenticularViewer(context);
                    ((LenticularViewer)mediaitem).setLenticularHelper((GalleryLenticularHelper)getApplicationBean(Keys.LENTICULAR_HELPER));
                    mediaitem.onResume();
                    return mediaitem;
                }
                if (mediaitem.getType() == MediaType.VIDEO)
                {
                    mediaitem = GalleryVideoViewerFactory.createGalleryVideoViewer(context);
                    mediaitem.setRestClient((RestClient)getApplicationBean(Keys.REST_CLIENT));
                    mediaitem.setProfiler((Profiler)getApplicationBean(Keys.PROFILER));
                    mediaitem.setFeatureChecker((FeatureChecker)getApplicationBean(AppKeys.FEATURE_CHECKER));
                    mediaitem.setScreenModeManager((ScreenModeManager)getApplicationBean(Keys.SCREEN_MODE_MANAGER));
                    mediaitem.setToggleScreenModeRunnable(new SingleViewFragment._cls9._cls1());
                    return mediaitem;
                }
            }
            return gifplayerwebview;
        }

            
            {
                this$0 = SingleViewFragment.this;
                super();
            }
    }

}
