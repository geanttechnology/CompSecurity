// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.lenticular;

import android.content.Context;
import android.content.res.Configuration;
import android.os.AsyncTask;
import com.amazon.boombox.widget.LenticularView;
import com.amazon.boombox.widget.controller.LenticularViewController;
import com.amazon.boombox.widget.controller.LenticularViewControllerFactory;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.gallery.view.android.SingleViewMediaPlayer;
import com.amazon.gallery.framework.model.media.Frame;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.OrderedGroupPhoto;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.gallery.lenticular:
//            GalleryLenticularHelper

public class LenticularViewer extends LenticularView
    implements SingleViewMediaPlayer
{
    private class LenticularFrameListener
        implements com.amazon.boombox.widget.LenticularView.FrameListener
    {

        private MediaItem mediaItem;
        final LenticularViewer this$0;

        public void onFrameChange(int i)
        {
        }

        public void onReady()
        {
            if (playerObserver != null)
            {
                playerObserver.onMediaReady(mediaItem);
            }
        }

        public LenticularFrameListener(MediaItem mediaitem)
        {
            this$0 = LenticularViewer.this;
            super();
            mediaItem = mediaitem;
        }
    }


    public static final String TAG = com/amazon/gallery/framework/gallery/lenticular/LenticularViewer.getName();
    private File files[];
    private com.amazon.boombox.widget.LenticularView.FrameListener frameListener;
    private LenticularViewController lenticularController;
    private GalleryLenticularHelper lenticularHelper;
    private MediaItem mediaItem;
    private com.amazon.gallery.framework.gallery.view.android.SingleViewMediaPlayer.PlayerObserver playerObserver;

    public LenticularViewer(Context context)
    {
        super(context);
        setMaxQuality(0.5D);
        lenticularController = LenticularViewControllerFactory.getDefaultController(context.getApplicationContext());
        lenticularController.setView(this);
        frameListener = new LenticularFrameListener(mediaItem);
        addFrameListener(frameListener);
        if (files != null)
        {
            setFiles(files);
        }
    }

    private void setFrames(List list)
    {
        GLogger.d(TAG, "Lenticular frame count: %d", new Object[] {
            Integer.valueOf(list.size())
        });
        String as[] = new String[list.size()];
        files = new File[as.length];
        for (int i = 0; i < as.length; i++)
        {
            files[i] = new File(((Frame)list.get(i)).getLocalPath());
        }

        setFiles(files);
    }

    public void destroy()
    {
        lenticularController.stop();
    }

    public int getDisplayDelayMS()
    {
        return 0;
    }

    public MediaItem getMediaItem()
    {
        return mediaItem;
    }

    public void loadFramesAsync(final OrderedGroupPhoto lenticular)
    {
        (new AsyncTask() {

            final LenticularViewer this$0;
            final OrderedGroupPhoto val$lenticular;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient List doInBackground(Void avoid[])
            {
                return lenticularHelper.loadFrames(lenticular);
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((List)obj);
            }

            protected void onPostExecute(List list)
            {
                if (list != null)
                {
                    setFrames(list);
                }
            }

            
            {
                this$0 = LenticularViewer.this;
                lenticular = orderedgroupphoto;
                super();
            }
        }).execute(new Void[0]);
    }

    public void onConfigChanged(Configuration configuration)
    {
    }

    public void onPause()
    {
        lenticularController.stop();
    }

    public void onResume()
    {
        lenticularController.start();
    }

    public void setLenticularHelper(GalleryLenticularHelper gallerylenticularhelper)
    {
        lenticularHelper = gallerylenticularhelper;
    }

    public void setMediaItem(MediaItem mediaitem)
    {
        mediaItem = mediaitem;
        mediaitem = (OrderedGroupPhoto)mediaitem;
        ArrayList arraylist = (ArrayList)mediaitem.getFrames();
        if (arraylist != null && arraylist.size() > 0)
        {
            setFrames(arraylist);
            return;
        } else
        {
            loadFramesAsync(mediaitem);
            return;
        }
    }

    public void setPlayerObserver(com.amazon.gallery.framework.gallery.view.android.SingleViewMediaPlayer.PlayerObserver playerobserver)
    {
        playerObserver = playerobserver;
    }

    public void shutDown()
    {
    }




}
