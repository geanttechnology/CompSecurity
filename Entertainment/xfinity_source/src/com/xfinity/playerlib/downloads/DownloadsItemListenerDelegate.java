// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.downloads;

import android.app.FragmentManager;
import android.content.Context;
import com.comcast.cim.downloads.DownloadServiceException;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.downloads.PlayerDownloadFile;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
import com.xfinity.playerlib.view.common.UpsellDialog;
import com.xfinity.playerlib.view.downloads.DownloadsItemListener;
import com.xfinity.playerlib.view.videoplay.VideoPlayerActivity;
import java.util.Iterator;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DownloadsItemListenerDelegate
    implements DownloadsItemListener
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/downloads/DownloadsItemListenerDelegate);
    private final PlayerDownloadServiceManager downloadsManager;

    public DownloadsItemListenerDelegate(PlayerDownloadServiceManager playerdownloadservicemanager, Context context)
    {
        downloadsManager = playerdownloadservicemanager;
    }

    public void onCancelDownloadPressed(Context context, PlayerDownloadFile playerdownloadfile)
    {
        try
        {
            downloadsManager.deleteFile(playerdownloadfile);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            LOG.error(context.getMessage(), context);
        }
    }

    public void onHotwireDownloadPressed(Context context, PlayerDownloadFile playerdownloadfile)
    {
        try
        {
            downloadsManager.startDownloadImmediately(playerdownloadfile);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            LOG.error(context.getMessage(), context);
        }
    }

    public void onPlayEntitledDownloadPressed(Context context, PlayerDownloadFile playerdownloadfile)
    {
        Watchable watchable = playerdownloadfile.getWatchable();
        Iterator iterator = watchable.getVideos().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            VideoFacade videofacade = (VideoFacade)iterator.next();
            if (videofacade.getVideoId() != playerdownloadfile.getVideoId())
            {
                continue;
            }
            context.startActivity(VideoPlayerActivity.createIntentForPlayer(videofacade, watchable));
            break;
        } while (true);
    }

    public void onPlayUnentitledDownloadPressed(FragmentManager fragmentmanager, VideoFacade videofacade)
    {
        UpsellDialog.newInstance(com.xfinity.playerlib.view.common.UpsellDialog.UpsellType.PLAY_DOWNLOADED, videofacade).show(fragmentmanager, "upsell_dialog");
    }

    public void onRetryDownloadPressed(Context context, PlayerDownloadFile playerdownloadfile)
    {
        try
        {
            downloadsManager.resumeDownloading();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            LOG.error(context.getMessage(), context);
        }
    }

}
