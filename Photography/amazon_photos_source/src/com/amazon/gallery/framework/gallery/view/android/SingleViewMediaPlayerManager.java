// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.view.android;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.thor.app.activity.ThorViewActivity;

// Referenced classes of package com.amazon.gallery.framework.gallery.view.android:
//            SingleViewMediaPlayer, SingleViewMediaPlayerFactory

public class SingleViewMediaPlayerManager extends RelativeLayout
    implements SingleViewMediaPlayer.PlayerObserver
{

    public static final String TAG = com/amazon/gallery/framework/gallery/view/android/SingleViewMediaPlayerManager.getName();
    private final int CROSS_FADE_DURATION_MS;
    private Runnable loadAndShow;
    private SingleViewMediaPlayer player;
    private SingleViewMediaPlayerFactory playerFactory;
    private int position;

    public SingleViewMediaPlayerManager(Context context, int i)
    {
        super(context);
        CROSS_FADE_DURATION_MS = 200;
        position = i;
    }

    public SingleViewMediaPlayerManager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        CROSS_FADE_DURATION_MS = 200;
    }

    public SingleViewMediaPlayerManager(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        CROSS_FADE_DURATION_MS = 200;
    }

    private void removePlayer(boolean flag)
    {
        if (loadAndShow != null)
        {
            removeCallbacks(loadAndShow);
        }
        setVisibility(4);
        if (player != null)
        {
            player.setPlayerObserver(null);
            player.destroy();
            if (flag)
            {
                if (player instanceof View)
                {
                    removeView((View)player);
                }
                removeAllViews();
                player = null;
            }
        }
    }

    public int getPostion()
    {
        return position;
    }

    public void init()
    {
    }

    public void onConfigChanged(Configuration configuration)
    {
        if (player != null)
        {
            player.onConfigChanged(configuration);
        }
    }

    public void onFocusedGained(final MediaItem mediaItem)
    {
        if ((player == null || player.getMediaItem() != null) && (player == null || !player.getMediaItem().equals(mediaItem)))
        {
            removePlayer(true);
            final SingleViewMediaPlayer newPlayer = playerFactory.getPlayerForMediaItem(mediaItem, getContext());
            if (newPlayer != null)
            {
                newPlayer.setPlayerObserver(this);
                loadAndShow = new Runnable() {

                    final SingleViewMediaPlayerManager this$0;
                    final MediaItem val$mediaItem;
                    final SingleViewMediaPlayer val$newPlayer;

                    public void run()
                    {
                        if (newPlayer instanceof View)
                        {
                            addView((View)newPlayer, new android.widget.RelativeLayout.LayoutParams(-1, -1));
                        }
                        newPlayer.setMediaItem(mediaItem);
                    }

            
            {
                this$0 = SingleViewMediaPlayerManager.this;
                newPlayer = singleviewmediaplayer;
                mediaItem = mediaitem;
                super();
            }
                };
                postDelayed(loadAndShow, newPlayer.getDisplayDelayMS());
                player = newPlayer;
                return;
            }
        }
    }

    public void onFocusedLost()
    {
        removePlayer(true);
    }

    public void onMediaReady(MediaItem mediaitem)
    {
        showPlayer();
    }

    public void onPause()
    {
        if (player != null)
        {
            player.onPause();
        }
    }

    public void onResume()
    {
        init();
        if (player != null)
        {
            player.onResume();
        }
    }

    public void onVideoCompletion()
    {
        if (getContext() instanceof ThorViewActivity)
        {
            return;
        } else
        {
            removePlayer(true);
            return;
        }
    }

    public void onVideoError()
    {
        removePlayer(false);
    }

    public void setSingleViewMediaPlayerFactory(SingleViewMediaPlayerFactory singleviewmediaplayerfactory)
    {
        playerFactory = singleviewmediaplayerfactory;
    }

    public void showPlayer()
    {
        setAlpha(0.0F);
        setVisibility(0);
        animate().alpha(1.0F).setDuration(200L).start();
    }

    public void shutDown()
    {
        if (player != null)
        {
            player.shutDown();
        }
    }

}
