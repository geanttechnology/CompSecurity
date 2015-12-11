// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.spotify.sdk.android.player;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.spotify.sdk.android.player:
//            Player, PlayerInitializationException, PlayerNotificationCallback, ConnectionStateCallback, 
//            Config

public final class Spotify
{

    private static final int SLEEP_TIMEOUT_MS = 10;
    private static final int WAIT_COUNTER = 300;
    private static Player sPlayer;
    private static final Object sPlayerMutex = new Object();
    private static final Set sPlayerReferences = Collections.newSetFromMap(new IdentityHashMap());

    private Spotify()
    {
    }

    public static boolean awaitDestroyPlayer(Object obj, long l, TimeUnit timeunit)
    {
        Object obj1 = sPlayerMutex;
        obj1;
        JVM INSTR monitorenter ;
        boolean flag;
        removePlayerReference(obj);
        if (!sPlayerReferences.isEmpty())
        {
            break MISSING_BLOCK_LABEL_71;
        }
        if (sPlayer == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        sPlayer.shutdown();
        flag = sPlayer.awaitTermination(l, timeunit);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        sPlayer = null;
        obj1;
        JVM INSTR monitorexit ;
        return flag;
        obj1;
        JVM INSTR monitorexit ;
        return true;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        obj1;
        JVM INSTR monitorexit ;
        return false;
    }

    public static void destroyPlayer(Object obj)
    {
        synchronized (sPlayerMutex)
        {
            removePlayerReference(obj);
            if (sPlayerReferences.isEmpty() && sPlayer != null)
            {
                sPlayer.shutdown();
                sPlayer = null;
            }
        }
        return;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public static Player getPlayer(Config config, Object obj, Player.InitializationObserver initializationobserver)
    {
        if (config == null)
        {
            throw new IllegalArgumentException("Config can't be null");
        } else
        {
            return getPlayer(new Player.Builder(config), obj, initializationobserver);
        }
    }

    public static Player getPlayer(Player.Builder builder, Object obj, Player.InitializationObserver initializationobserver)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException("Player cannot have a null owner");
        }
        if (builder == null)
        {
            throw new IllegalArgumentException("Builder can't be null");
        }
        Object obj1 = sPlayerMutex;
        obj1;
        JVM INSTR monitorenter ;
        if (sPlayer != null) goto _L2; else goto _L1
_L1:
        sPlayer = builder.build(initializationobserver);
_L8:
        sPlayerReferences.add(obj);
        builder = sPlayer;
        return builder;
_L2:
        if (sPlayer.isShutdown()) goto _L4; else goto _L3
_L3:
        int i = 300;
_L6:
        boolean flag = sPlayer.isInitialized();
        if (flag || i <= 0) goto _L4; else goto _L5
_L5:
        i--;
        Thread.sleep(10L);
          goto _L6
        builder;
        Thread.currentThread().interrupt();
          goto _L6
        builder;
        obj1;
        JVM INSTR monitorexit ;
        throw builder;
_L4:
        if (initializationobserver == null) goto _L8; else goto _L7
_L7:
label0:
        {
            if (!sPlayer.isInitialized())
            {
                break label0;
            }
            initializationobserver.onInitialized(sPlayer);
        }
          goto _L8
label1:
        {
            if (!sPlayer.isShutdown())
            {
                break label1;
            }
            initializationobserver.onError(new PlayerInitializationException("Player already shut down"));
        }
          goto _L8
        initializationobserver.onError(new PlayerInitializationException("Player initialization failed"));
          goto _L8
    }

    public static int getReferenceCount()
    {
        int i;
        synchronized (sPlayerMutex)
        {
            i = sPlayerReferences.size();
        }
        return i;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static void removePlayerReference(Object obj)
    {
        synchronized (sPlayerMutex)
        {
            if (sPlayer != null)
            {
                if (obj instanceof PlayerNotificationCallback)
                {
                    sPlayer.removePlayerNotificationCallback((PlayerNotificationCallback)obj);
                }
                if (obj instanceof ConnectionStateCallback)
                {
                    sPlayer.removeConnectionStateCallback((ConnectionStateCallback)obj);
                }
            }
            if (sPlayerReferences.contains(obj))
            {
                sPlayerReferences.remove(obj);
            }
        }
        return;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
    }

}
