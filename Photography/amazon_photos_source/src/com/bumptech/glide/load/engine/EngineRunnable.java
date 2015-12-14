// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.executor.Prioritized;
import com.bumptech.glide.request.ResourceCallback;

// Referenced classes of package com.bumptech.glide.load.engine:
//            DecodeJob, Resource

class EngineRunnable
    implements Prioritized, Runnable
{
    static interface EngineRunnableManager
        extends ResourceCallback
    {

        public abstract void submitForSource(EngineRunnable enginerunnable);
    }

    private static final class Stage extends Enum
    {

        private static final Stage $VALUES[];
        public static final Stage CACHE;
        public static final Stage SOURCE;

        public static Stage valueOf(String s)
        {
            return (Stage)Enum.valueOf(com/bumptech/glide/load/engine/EngineRunnable$Stage, s);
        }

        public static Stage[] values()
        {
            return (Stage[])$VALUES.clone();
        }

        static 
        {
            CACHE = new Stage("CACHE", 0);
            SOURCE = new Stage("SOURCE", 1);
            $VALUES = (new Stage[] {
                CACHE, SOURCE
            });
        }

        private Stage(String s, int i)
        {
            super(s, i);
        }
    }


    private final DecodeJob decodeJob;
    private volatile boolean isCancelled;
    private final EngineRunnableManager manager;
    private final Priority priority;
    private Stage stage;

    public EngineRunnable(EngineRunnableManager enginerunnablemanager, DecodeJob decodejob, Priority priority1)
    {
        manager = enginerunnablemanager;
        decodeJob = decodejob;
        stage = Stage.CACHE;
        priority = priority1;
    }

    private Resource decode()
        throws Exception
    {
        if (isDecodingFromCache())
        {
            return decodeFromCache();
        } else
        {
            return decodeFromSource();
        }
    }

    private Resource decodeFromCache()
        throws Exception
    {
        Resource resource1 = null;
        Resource resource = decodeJob.decodeResultFromCache();
_L2:
        resource1 = resource;
        if (resource == null)
        {
            resource1 = decodeJob.decodeSourceFromCache();
        }
        return resource1;
        Exception exception;
        exception;
        resource = resource1;
        if (Log.isLoggable("EngineRunnable", 3))
        {
            Log.d("EngineRunnable", (new StringBuilder()).append("Exception decoding result from cache: ").append(exception).toString());
            resource = resource1;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    private Resource decodeFromSource()
        throws Exception
    {
        return decodeJob.decodeFromSource();
    }

    private boolean isDecodingFromCache()
    {
        return stage == Stage.CACHE;
    }

    private void onLoadComplete(Resource resource)
    {
        manager.onResourceReady(resource);
    }

    private void onLoadFailed(Exception exception)
    {
        if (isDecodingFromCache())
        {
            stage = Stage.SOURCE;
            manager.submitForSource(this);
            return;
        } else
        {
            manager.onException(exception);
            return;
        }
    }

    public void cancel()
    {
        isCancelled = true;
        decodeJob.cancel();
    }

    public int getPriority()
    {
        return priority.ordinal();
    }

    public void run()
    {
        if (!isCancelled) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Exception exception;
        Resource resource;
        exception = null;
        resource = null;
        Resource resource1 = decode();
        resource = resource1;
_L4:
        if (isCancelled)
        {
            if (resource != null)
            {
                resource.recycle();
                return;
            }
        } else
        if (resource == null)
        {
            onLoadFailed(exception);
            return;
        } else
        {
            onLoadComplete(resource);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        exception;
        if (Log.isLoggable("EngineRunnable", 2))
        {
            Log.v("EngineRunnable", "Exception decoding", exception);
        }
          goto _L4
    }
}
