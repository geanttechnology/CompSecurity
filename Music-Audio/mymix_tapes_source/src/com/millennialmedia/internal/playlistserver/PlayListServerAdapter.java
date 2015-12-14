// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.playlistserver;

import com.millennialmedia.MMLog;
import com.millennialmedia.internal.PlayList;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.millennialmedia.internal.playlistserver:
//            GreenServerAdapter, OrangeServerAdapter

public abstract class PlayListServerAdapter
{
    public static interface AdapterLoadListener
    {

        public abstract void loadFailed(Throwable throwable);

        public abstract void loadSucceeded(PlayList playlist);
    }


    private static final String TAG = com/millennialmedia/internal/playlistserver/PlayListServerAdapter.getSimpleName();
    private static Map registeredAdapters = new HashMap();

    public PlayListServerAdapter()
    {
    }

    static PlayListServerAdapter getAdapter(Class class1)
        throws Exception
    {
        Object obj = registeredAdapters.get(class1);
        if (obj == null)
        {
            throw new Exception((new StringBuilder()).append("Unable to find specified PlayListServerAdapter for class ").append(class1).toString());
        } else
        {
            return (PlayListServerAdapter)obj;
        }
    }

    public static void registerAdapter(PlayListServerAdapter playlistserveradapter)
    {
        if (playlistserveradapter == null)
        {
            throw new IllegalArgumentException("PlayListServerAdapter cannot be null");
        }
        Class class1 = playlistserveradapter.getClass();
        if (registeredAdapters.containsKey(class1))
        {
            MMLog.w(TAG, (new StringBuilder()).append("PlayListServerAdapter <").append(class1).append("> already registered").toString());
            return;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Registering PlayListServerAdapter <").append(class1).append(">").toString());
        }
        registeredAdapters.put(class1, playlistserveradapter);
    }

    public static void registerPackagedAdapters()
    {
        registerAdapter(new GreenServerAdapter());
        registerAdapter(new OrangeServerAdapter());
    }

    public abstract void loadPlayList(Map map, AdapterLoadListener adapterloadlistener);

}
