// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.provider.LoadProvider;
import com.bumptech.glide.request.animation.GlideAnimationFactory;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.util.Queue;

// Referenced classes of package com.bumptech.glide.request:
//            Request, ResourceCallback, RequestCoordinator, RequestListener

public final class GenericRequest
    implements Request, ResourceCallback, SizeReadyCallback
{
    private static final class Status extends Enum
    {

        private static final Status $VALUES[];
        public static final Status CANCELLED;
        public static final Status CLEARED;
        public static final Status COMPLETE;
        public static final Status FAILED;
        public static final Status PAUSED;
        public static final Status PENDING;
        public static final Status RUNNING;
        public static final Status WAITING_FOR_SIZE;

        public static Status valueOf(String s)
        {
            return (Status)Enum.valueOf(com/bumptech/glide/request/GenericRequest$Status, s);
        }

        public static Status[] values()
        {
            return (Status[])$VALUES.clone();
        }

        static 
        {
            PENDING = new Status("PENDING", 0);
            RUNNING = new Status("RUNNING", 1);
            WAITING_FOR_SIZE = new Status("WAITING_FOR_SIZE", 2);
            COMPLETE = new Status("COMPLETE", 3);
            FAILED = new Status("FAILED", 4);
            CANCELLED = new Status("CANCELLED", 5);
            CLEARED = new Status("CLEARED", 6);
            PAUSED = new Status("PAUSED", 7);
            $VALUES = (new Status[] {
                PENDING, RUNNING, WAITING_FOR_SIZE, COMPLETE, FAILED, CANCELLED, CLEARED, PAUSED
            });
        }

        private Status(String s, int i)
        {
            super(s, i);
        }
    }


    private static final Queue REQUEST_POOL = Util.createQueue(0);
    private GlideAnimationFactory animationFactory;
    private Context context;
    private DiskCacheStrategy diskCacheStrategy;
    private Engine engine;
    private Drawable errorDrawable;
    private int errorResourceId;
    private boolean isMemoryCacheable;
    private LoadProvider loadProvider;
    private com.bumptech.glide.load.engine.Engine.LoadStatus loadStatus;
    private boolean loadedFromMemoryCache;
    private Object model;
    private int overrideHeight;
    private int overrideWidth;
    private Drawable placeholderDrawable;
    private int placeholderResourceId;
    private Priority priority;
    private RequestCoordinator requestCoordinator;
    private RequestListener requestListener;
    private Resource resource;
    private Key signature;
    private float sizeMultiplier;
    private long startTime;
    private Status status;
    private final String tag = String.valueOf(hashCode());
    private Target target;
    private Class transcodeClass;
    private Transformation transformation;

    private GenericRequest()
    {
    }

    private boolean canNotifyStatusChanged()
    {
        return requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this);
    }

    private boolean canSetResource()
    {
        return requestCoordinator == null || requestCoordinator.canSetImage(this);
    }

    private static void check(String s, Object obj, String s1)
    {
        if (obj == null)
        {
            s = new StringBuilder(s);
            s.append(" must not be null");
            if (s1 != null)
            {
                s.append(", ");
                s.append(s1);
            }
            throw new NullPointerException(s.toString());
        } else
        {
            return;
        }
    }

    private Drawable getErrorDrawable()
    {
        if (errorDrawable == null && errorResourceId > 0)
        {
            errorDrawable = context.getResources().getDrawable(errorResourceId);
        }
        return errorDrawable;
    }

    private Drawable getPlaceholderDrawable()
    {
        if (placeholderDrawable == null && placeholderResourceId > 0)
        {
            placeholderDrawable = context.getResources().getDrawable(placeholderResourceId);
        }
        return placeholderDrawable;
    }

    private void init(LoadProvider loadprovider, Object obj, Key key, Context context1, Priority priority1, Target target1, float f, 
            Drawable drawable, int i, Drawable drawable1, int j, RequestListener requestlistener, RequestCoordinator requestcoordinator, Engine engine1, 
            Transformation transformation1, Class class1, boolean flag, GlideAnimationFactory glideanimationfactory, int k, int l, DiskCacheStrategy diskcachestrategy)
    {
        loadProvider = loadprovider;
        model = obj;
        signature = key;
        context = context1.getApplicationContext();
        priority = priority1;
        target = target1;
        sizeMultiplier = f;
        placeholderDrawable = drawable;
        placeholderResourceId = i;
        errorDrawable = drawable1;
        errorResourceId = j;
        requestListener = requestlistener;
        requestCoordinator = requestcoordinator;
        engine = engine1;
        transformation = transformation1;
        transcodeClass = class1;
        isMemoryCacheable = flag;
        animationFactory = glideanimationfactory;
        overrideWidth = k;
        overrideHeight = l;
        diskCacheStrategy = diskcachestrategy;
        status = Status.PENDING;
        if (obj != null)
        {
            check("ModelLoader", loadprovider.getModelLoader(), "try .using(ModelLoader)");
            check("Transcoder", loadprovider.getTranscoder(), "try .as*(Class).transcode(ResourceTranscoder)");
            check("Transformation", transformation1, "try .transform(UnitTransformation.get())");
            if (diskcachestrategy.cacheSource())
            {
                check("SourceEncoder", loadprovider.getSourceEncoder(), "try .sourceEncoder(Encoder) or .diskCacheStrategy(NONE/RESULT)");
            } else
            {
                check("SourceDecoder", loadprovider.getSourceDecoder(), "try .decoder/.imageDecoder/.videoDecoder(ResourceDecoder) or .diskCacheStrategy(ALL/SOURCE)");
            }
            if (diskcachestrategy.cacheSource() || diskcachestrategy.cacheResult())
            {
                check("CacheDecoder", loadprovider.getCacheDecoder(), "try .cacheDecoder(ResouceDecoder) or .diskCacheStrategy(NONE)");
            }
            if (diskcachestrategy.cacheResult())
            {
                check("Encoder", loadprovider.getEncoder(), "try .encode(ResourceEncoder) or .diskCacheStrategy(NONE/SOURCE)");
            }
        }
    }

    private boolean isFirstReadyResource()
    {
        return requestCoordinator == null || !requestCoordinator.isAnyResourceSet();
    }

    private void logV(String s)
    {
        Log.v("GenericRequest", (new StringBuilder()).append(s).append(" this: ").append(tag).toString());
    }

    private void notifyLoadSuccess()
    {
        if (requestCoordinator != null)
        {
            requestCoordinator.onRequestSuccess(this);
        }
    }

    public static GenericRequest obtain(LoadProvider loadprovider, Object obj, Key key, Context context1, Priority priority1, Target target1, float f, Drawable drawable, 
            int i, Drawable drawable1, int j, RequestListener requestlistener, RequestCoordinator requestcoordinator, Engine engine1, Transformation transformation1, 
            Class class1, boolean flag, GlideAnimationFactory glideanimationfactory, int k, int l, DiskCacheStrategy diskcachestrategy)
    {
        GenericRequest genericrequest1 = (GenericRequest)REQUEST_POOL.poll();
        GenericRequest genericrequest = genericrequest1;
        if (genericrequest1 == null)
        {
            genericrequest = new GenericRequest();
        }
        genericrequest.init(loadprovider, obj, key, context1, priority1, target1, f, drawable, i, drawable1, j, requestlistener, requestcoordinator, engine1, transformation1, class1, flag, glideanimationfactory, k, l, diskcachestrategy);
        return genericrequest;
    }

    private void onResourceReady(Resource resource1, Object obj)
    {
        if (requestListener == null || !requestListener.onResourceReady(obj, model, target, loadedFromMemoryCache, isFirstReadyResource()))
        {
            com.bumptech.glide.request.animation.GlideAnimation glideanimation = animationFactory.build(loadedFromMemoryCache, isFirstReadyResource());
            target.onResourceReady(obj, glideanimation);
        }
        status = Status.COMPLETE;
        resource = resource1;
        notifyLoadSuccess();
        if (Log.isLoggable("GenericRequest", 2))
        {
            logV((new StringBuilder()).append("Resource ready in ").append(LogTime.getElapsedMillis(startTime)).append(" size: ").append((double)resource1.getSize() * 9.5367431640625E-07D).append(" fromCache: ").append(loadedFromMemoryCache).toString());
        }
    }

    private void releaseResource(Resource resource1)
    {
        engine.release(resource1);
        resource = null;
    }

    private void setErrorPlaceholder(Exception exception)
    {
        if (!canNotifyStatusChanged())
        {
            return;
        }
        Drawable drawable1 = getErrorDrawable();
        Drawable drawable = drawable1;
        if (drawable1 == null)
        {
            drawable = getPlaceholderDrawable();
        }
        target.onLoadFailed(exception, drawable);
    }

    public void begin()
    {
        startTime = LogTime.getLogTime();
        if (model == null)
        {
            onException(null);
        } else
        {
            status = Status.WAITING_FOR_SIZE;
            if (Util.isValidDimensions(overrideWidth, overrideHeight))
            {
                onSizeReady(overrideWidth, overrideHeight);
            } else
            {
                target.getSize(this);
            }
            if (!isComplete() && !isFailed() && canNotifyStatusChanged())
            {
                target.onLoadStarted(getPlaceholderDrawable());
            }
            if (Log.isLoggable("GenericRequest", 2))
            {
                logV((new StringBuilder()).append("finished run method in ").append(LogTime.getElapsedMillis(startTime)).toString());
                return;
            }
        }
    }

    void cancel()
    {
        status = Status.CANCELLED;
        if (loadStatus != null)
        {
            loadStatus.cancel();
            loadStatus = null;
        }
    }

    public void clear()
    {
        Util.assertMainThread();
        if (status == Status.CLEARED)
        {
            return;
        }
        cancel();
        if (resource != null)
        {
            releaseResource(resource);
        }
        if (canNotifyStatusChanged())
        {
            target.onLoadCleared(getPlaceholderDrawable());
        }
        status = Status.CLEARED;
    }

    public boolean isCancelled()
    {
        return status == Status.CANCELLED || status == Status.CLEARED;
    }

    public boolean isComplete()
    {
        return status == Status.COMPLETE;
    }

    public boolean isFailed()
    {
        return status == Status.FAILED;
    }

    public boolean isResourceSet()
    {
        return isComplete();
    }

    public boolean isRunning()
    {
        return status == Status.RUNNING || status == Status.WAITING_FOR_SIZE;
    }

    public void onException(Exception exception)
    {
        if (Log.isLoggable("GenericRequest", 3))
        {
            Log.d("GenericRequest", "load failed", exception);
        }
        status = Status.FAILED;
        if (requestListener == null || !requestListener.onException(exception, model, target, isFirstReadyResource()))
        {
            setErrorPlaceholder(exception);
        }
    }

    public void onResourceReady(Resource resource1)
    {
        if (resource1 == null)
        {
            onException(new Exception((new StringBuilder()).append("Expected to receive a Resource<R> with an object of ").append(transcodeClass).append(" inside, but instead got null.").toString()));
            return;
        }
        Object obj1 = resource1.get();
        if (obj1 == null || !transcodeClass.isAssignableFrom(obj1.getClass()))
        {
            releaseResource(resource1);
            StringBuilder stringbuilder = (new StringBuilder()).append("Expected to receive an object of ").append(transcodeClass).append(" but instead got ");
            Object obj;
            if (obj1 != null)
            {
                obj = obj1.getClass();
            } else
            {
                obj = "";
            }
            obj = stringbuilder.append(obj).append("{").append(obj1).append("}").append(" inside Resource{").append(resource1).append("}.");
            if (obj1 != null)
            {
                resource1 = "";
            } else
            {
                resource1 = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
            }
            onException(new Exception(((StringBuilder) (obj)).append(resource1).toString()));
            return;
        }
        if (!canSetResource())
        {
            releaseResource(resource1);
            status = Status.COMPLETE;
            return;
        } else
        {
            onResourceReady(resource1, obj1);
            return;
        }
    }

    public void onSizeReady(int i, int j)
    {
        if (Log.isLoggable("GenericRequest", 2))
        {
            logV((new StringBuilder()).append("Got onSizeReady in ").append(LogTime.getElapsedMillis(startTime)).toString());
        }
        if (status == Status.WAITING_FOR_SIZE)
        {
            status = Status.RUNNING;
            i = Math.round(sizeMultiplier * (float)i);
            j = Math.round(sizeMultiplier * (float)j);
            com.bumptech.glide.load.data.DataFetcher datafetcher = loadProvider.getModelLoader().getResourceFetcher(model, i, j);
            if (datafetcher == null)
            {
                onException(new Exception("Got null fetcher from model loader"));
                return;
            }
            com.bumptech.glide.load.resource.transcode.ResourceTranscoder resourcetranscoder = loadProvider.getTranscoder();
            if (Log.isLoggable("GenericRequest", 2))
            {
                logV((new StringBuilder()).append("finished setup for calling load in ").append(LogTime.getElapsedMillis(startTime)).toString());
            }
            loadedFromMemoryCache = true;
            loadStatus = engine.load(signature, i, j, datafetcher, loadProvider, transformation, resourcetranscoder, priority, isMemoryCacheable, diskCacheStrategy, this);
            boolean flag;
            if (resource != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            loadedFromMemoryCache = flag;
            if (Log.isLoggable("GenericRequest", 2))
            {
                logV((new StringBuilder()).append("finished onSizeReady in ").append(LogTime.getElapsedMillis(startTime)).toString());
                return;
            }
        }
    }

    public void pause()
    {
        clear();
        status = Status.PAUSED;
    }

    public void recycle()
    {
        loadProvider = null;
        model = null;
        context = null;
        target = null;
        placeholderDrawable = null;
        errorDrawable = null;
        requestListener = null;
        requestCoordinator = null;
        transformation = null;
        animationFactory = null;
        loadedFromMemoryCache = false;
        loadStatus = null;
        REQUEST_POOL.offer(this);
    }

}
