// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.downloads;

import android.app.FragmentManager;
import android.content.Context;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.downloads.PlayerDownloadFile;

public interface DownloadsItemListener
{

    public abstract void onCancelDownloadPressed(Context context, PlayerDownloadFile playerdownloadfile);

    public abstract void onHotwireDownloadPressed(Context context, PlayerDownloadFile playerdownloadfile);

    public abstract void onPlayEntitledDownloadPressed(Context context, PlayerDownloadFile playerdownloadfile);

    public abstract void onPlayUnentitledDownloadPressed(FragmentManager fragmentmanager, VideoFacade videofacade);

    public abstract void onRetryDownloadPressed(Context context, PlayerDownloadFile playerdownloadfile);
}
