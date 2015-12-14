// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.playlistserver;

import com.millennialmedia.MMLog;
import com.millennialmedia.internal.Handshake;
import com.millennialmedia.internal.PlayList;
import com.millennialmedia.internal.utils.EnvironmentUtils;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.millennialmedia.internal.playlistserver:
//            PlayListServerAdapter

public class PlayListServer
{
    public static interface PlayListLoadListener
    {

        public abstract void onLoadFailed(Throwable throwable);

        public abstract void onLoaded(PlayList playlist);
    }


    private static final String TAG = com/millennialmedia/internal/playlistserver/PlayListServer.getSimpleName();
    private static Class activePlayListServerAdapterClass;
    public static final List supportedAdFormats = Arrays.asList(new String[] {
        "web", "native"
    });

    public PlayListServer()
    {
    }

    private static PlayListServerAdapter getActivePlayListServerAdapter()
        throws Exception
    {
        Class class2 = activePlayListServerAdapterClass;
        Class class1 = class2;
        if (class2 == null)
        {
            class1 = Handshake.getActivePlayListServerAdapterClass();
        }
        return PlayListServerAdapter.getAdapter(class1);
    }

    public static void loadPlayList(Map map, PlayListLoadListener playlistloadlistener)
    {
        if (!Handshake.getSdkEnabled())
        {
            MMLog.e(TAG, "Unable to request ad, SDK is disabled.  Please contact Millennial Media.");
            playlistloadlistener.onLoadFailed(new RuntimeException("SDK disabled"));
            return;
        }
        if (!EnvironmentUtils.isNetworkAvailable())
        {
            MMLog.e(TAG, "Unable to request ad, no network connection found");
            playlistloadlistener.onLoadFailed(new RuntimeException("Network not available"));
            return;
        }
        PlayListServerAdapter playlistserveradapter;
        try
        {
            playlistserveradapter = getActivePlayListServerAdapter();
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            playlistloadlistener.onLoadFailed(map);
            return;
        }
        playlistserveradapter.loadPlayList(map, new PlayListServerAdapter.AdapterLoadListener(playlistloadlistener) {

            final PlayListLoadListener val$playListLoadListener;

            public void loadFailed(Throwable throwable)
            {
                playListLoadListener.onLoadFailed(throwable);
            }

            public void loadSucceeded(PlayList playlist)
            {
                if (playlist != null)
                {
                    playListLoadListener.onLoaded(playlist);
                    return;
                } else
                {
                    playListLoadListener.onLoadFailed(new RuntimeException("Playlist provided by adapter is null"));
                    return;
                }
            }

            
            {
                playListLoadListener = playlistloadlistener;
                super();
            }
        });
    }

    public static void setActivePlayListServerAdapter(Class class1)
    {
        activePlayListServerAdapterClass = class1;
    }

}
