// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.downloads;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.downloads.PlayerDownloadFile;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;

// Referenced classes of package com.xfinity.playerlib.view.downloads:
//            DownloadsArrayAdapter, DownloadsItemListener

class playerDownloadFile
    implements android.view.ayButtonOnClickListener
{

    final PlayerDownloadFile playerDownloadFile;
    final DownloadsArrayAdapter this$0;
    final VideoFacade videoFacade;

    public void onClick(View view)
    {
        view = view.getContext();
        if (DownloadsArrayAdapter.access$000(DownloadsArrayAdapter.this).isEntitled(videoFacade.getProviderCode()))
        {
            listener.onPlayEntitledDownloadPressed(view, playerDownloadFile);
        } else
        if (view instanceof FragmentActivity)
        {
            view = ((FragmentActivity)view).getFragmentManager();
            listener.onPlayUnentitledDownloadPressed(view, videoFacade);
            return;
        }
    }

    public (VideoFacade videofacade, PlayerDownloadFile playerdownloadfile)
    {
        this$0 = DownloadsArrayAdapter.this;
        super();
        videoFacade = videofacade;
        playerDownloadFile = playerdownloadfile;
    }
}
