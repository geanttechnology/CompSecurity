// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.picasso;

import android.app.Notification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.RemoteViews;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package it.sephiroth.android.library.picasso:
//            Picasso, Request, Utils, RemoteViewsAction, 
//            FetchAction, GetAction, BitmapHunter, PicassoDrawable, 
//            DeferredRequestCreator, Callback, ImageViewAction, Target, 
//            TargetAction, Transformation, Cache

public class RequestCreator
{

    private static int nextId = 0;
    private final Request.Builder data;
    private boolean deferred;
    private long delayMillis;
    private Drawable errorDrawable;
    private int errorResId;
    private long fadeTime;
    private final Picasso picasso;
    private Drawable placeholderDrawable;
    private int placeholderResId;
    private boolean skipMemoryCache;
    private Object tag;
    private boolean targetIsHidden;

    RequestCreator()
    {
        fadeTime = 200L;
        picasso = null;
        data = new Request.Builder(null, 0);
        data.setCache(picasso.getCache());
    }

    RequestCreator(Picasso picasso1, Uri uri, int i)
    {
        fadeTime = 200L;
        if (picasso1.shutdown)
        {
            throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
        }
        Uri uri1 = uri;
        if (uri != null)
        {
            uri1 = uri;
            if (uri.getScheme() == null)
            {
                uri1 = Uri.fromFile(new File(uri.getPath()));
            }
        }
        picasso = picasso1;
        data = new Request.Builder(uri1, i);
        data.setCache(picasso1.getCache());
    }

    private Request createRequest(long l)
    {
        int i = getRequestId();
        Request request = data.build();
        request.id = i;
        request.started = l;
        boolean flag = picasso.loggingEnabled;
        if (flag)
        {
            Utils.log("Main", "created", request.plainId(), request.toString());
        }
        Request request1 = picasso.transformRequest(request);
        if (request1 != request)
        {
            request1.id = i;
            request1.started = l;
            if (flag)
            {
                Utils.log("Main", "changed", request1.logId(), (new StringBuilder()).append("into ").append(request1).toString());
            }
        }
        return request1;
    }

    private static int getRequestId()
    {
        if (Utils.isMain())
        {
            int i = nextId;
            nextId = i + 1;
            return i;
        }
        CountDownLatch countdownlatch = new CountDownLatch(1);
        AtomicInteger atomicinteger = new AtomicInteger();
        Picasso.HANDLER.post(new Runnable(atomicinteger, countdownlatch) {

            final AtomicInteger val$id;
            final CountDownLatch val$latch;

            public void run()
            {
                id.set(RequestCreator.getRequestId());
                latch.countDown();
            }

            
            {
                id = atomicinteger;
                latch = countdownlatch;
                super();
            }
        });
        try
        {
            countdownlatch.await();
        }
        catch (InterruptedException interruptedexception)
        {
            Picasso.HANDLER.post(new Runnable(interruptedexception) {

                final InterruptedException val$e;

                public void run()
                {
                    throw new RuntimeException(e);
                }

            
            {
                e = interruptedexception;
                super();
            }
            });
        }
        return atomicinteger.get();
    }

    private void performRemoteViewInto(RemoteViewsAction remoteviewsaction)
    {
        if (!skipMemoryCache)
        {
            Bitmap bitmap = picasso.quickMemoryCacheCheck(data.getCache(), remoteviewsaction.getKey());
            if (bitmap != null)
            {
                remoteviewsaction.complete(bitmap, Picasso.LoadedFrom.MEMORY);
                return;
            }
        }
        if (placeholderResId != 0)
        {
            remoteviewsaction.setImageResource(placeholderResId);
        }
        picasso.enqueueAndSubmit(remoteviewsaction, delayMillis);
    }

    public RequestCreator centerCrop()
    {
        data.centerCrop();
        return this;
    }

    public RequestCreator centerInside()
    {
        data.centerInside();
        return this;
    }

    public RequestCreator config(android.graphics.Bitmap.Config config1)
    {
        data.config(config1);
        return this;
    }

    public RequestCreator error(int i)
    {
        if (i == 0)
        {
            throw new IllegalArgumentException("Error image resource invalid.");
        }
        if (errorDrawable != null)
        {
            throw new IllegalStateException("Error image already set.");
        } else
        {
            errorResId = i;
            return this;
        }
    }

    public RequestCreator error(Drawable drawable)
    {
        if (drawable == null)
        {
            throw new IllegalArgumentException("Error image may not be null.");
        }
        if (errorResId != 0)
        {
            throw new IllegalStateException("Error image already set.");
        } else
        {
            errorDrawable = drawable;
            return this;
        }
    }

    public RequestCreator fade(long l)
    {
        fadeTime = l;
        return this;
    }

    public void fetch()
    {
        long l = System.nanoTime();
        if (deferred)
        {
            throw new IllegalStateException("Fit cannot be used with fetch.");
        }
        if (data.hasImage())
        {
            if (!data.hasPriority())
            {
                data.priority(Picasso.Priority.LOW);
            }
            Object obj = createRequest(l);
            String s = Utils.createKey(((Request) (obj)), new StringBuilder());
            obj = new FetchAction(picasso, ((Request) (obj)), skipMemoryCache, s, tag, fadeTime);
            picasso.submit(((Action) (obj)), delayMillis);
        }
    }

    public RequestCreator fit()
    {
        return fit(false);
    }

    public RequestCreator fit(boolean flag)
    {
        deferred = true;
        targetIsHidden = flag;
        return this;
    }

    public Bitmap get()
        throws IOException
    {
        long l = System.nanoTime();
        Utils.checkNotMain();
        if (deferred)
        {
            throw new IllegalStateException("Fit cannot be used with get.");
        }
        if (!data.hasImage())
        {
            return null;
        } else
        {
            Object obj = createRequest(l);
            String s = Utils.createKey(((Request) (obj)), new StringBuilder());
            obj = new GetAction(picasso, ((Request) (obj)), skipMemoryCache, s, tag, fadeTime);
            return BitmapHunter.forRequest(picasso, picasso.dispatcher, data.getCache(), data.getDiskCache(), picasso.stats, ((Action) (obj))).hunt();
        }
    }

    public void into(ImageView imageview)
    {
        into(imageview, null);
    }

    public void into(ImageView imageview, Callback callback)
    {
        long l;
        l = System.nanoTime();
        Utils.checkMain();
        if (imageview == null)
        {
            throw new IllegalArgumentException("Target must not be null.");
        }
        if (data.hasImage()) goto _L2; else goto _L1
_L1:
        picasso.cancelRequest(imageview);
        PicassoDrawable.setPlaceholder(imageview, placeholderResId, placeholderDrawable);
_L4:
        return;
_L2:
        Request request;
        String s;
        if (deferred)
        {
            if (data.hasSize())
            {
                throw new IllegalStateException("Fit cannot be used with resize.");
            }
            int i;
            int j;
            if (imageview.getVisibility() == 8 || targetIsHidden)
            {
                j = imageview.getMeasuredWidth();
                i = imageview.getMeasuredHeight();
            } else
            {
                j = imageview.getWidth();
                i = imageview.getHeight();
            }
            if (j <= 0 || i <= 0)
            {
                PicassoDrawable.setPlaceholder(imageview, placeholderResId, placeholderDrawable);
                picasso.defer(imageview, new DeferredRequestCreator(this, imageview, targetIsHidden, callback));
                return;
            }
            data.resize(j, i);
        }
        request = createRequest(l);
        s = Utils.createKey(request);
        if (skipMemoryCache)
        {
            break; /* Loop/switch isn't completed */
        }
        Bitmap bitmap = picasso.quickMemoryCacheCheck(data.getCache(), s);
        if (bitmap == null)
        {
            break; /* Loop/switch isn't completed */
        }
        picasso.cancelRequest(imageview);
        PicassoDrawable.setBitmap(imageview, picasso.context, bitmap, Picasso.LoadedFrom.MEMORY, fadeTime, picasso.indicatorsEnabled);
        if (picasso.loggingEnabled)
        {
            Utils.log("Main", "completed", request.plainId(), (new StringBuilder()).append("from ").append(Picasso.LoadedFrom.MEMORY).toString());
        }
        if (callback != null)
        {
            callback.onSuccess();
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        PicassoDrawable.setPlaceholder(imageview, placeholderResId, placeholderDrawable);
        imageview = new ImageViewAction(picasso, imageview, request, skipMemoryCache, fadeTime, errorResId, errorDrawable, s, tag, callback);
        picasso.enqueueAndSubmit(imageview, delayMillis);
        return;
    }

    public void into(RemoteViews remoteviews, int i, int j, Notification notification)
    {
        long l = System.nanoTime();
        Utils.checkMain();
        if (remoteviews == null)
        {
            throw new IllegalArgumentException("RemoteViews must not be null.");
        }
        if (notification == null)
        {
            throw new IllegalArgumentException("Notification must not be null.");
        }
        if (deferred)
        {
            throw new IllegalStateException("Fit cannot be used with RemoteViews.");
        }
        if (placeholderDrawable != null || errorDrawable != null)
        {
            throw new IllegalArgumentException("Cannot use placeholder or error drawables with remote views.");
        } else
        {
            Request request = createRequest(l);
            String s = Utils.createKey(request);
            performRemoteViewInto(new RemoteViewsAction.NotificationAction(picasso, request, remoteviews, i, j, notification, skipMemoryCache, errorResId, s, tag, fadeTime));
            return;
        }
    }

    public void into(RemoteViews remoteviews, int i, int ai[])
    {
        long l = System.nanoTime();
        Utils.checkMain();
        if (remoteviews == null)
        {
            throw new IllegalArgumentException("remoteViews must not be null.");
        }
        if (ai == null)
        {
            throw new IllegalArgumentException("appWidgetIds must not be null.");
        }
        if (deferred)
        {
            throw new IllegalStateException("Fit cannot be used with remote views.");
        }
        if (placeholderDrawable != null || errorDrawable != null)
        {
            throw new IllegalArgumentException("Cannot use placeholder or error drawables with remote views.");
        } else
        {
            Request request = createRequest(l);
            String s = Utils.createKey(request);
            performRemoteViewInto(new RemoteViewsAction.AppWidgetAction(picasso, request, remoteviews, i, ai, skipMemoryCache, errorResId, s, tag, fadeTime));
            return;
        }
    }

    public void into(Target target)
    {
        long l = System.nanoTime();
        Utils.checkMain();
        if (target == null)
        {
            throw new IllegalArgumentException("Target must not be null.");
        }
        if (deferred)
        {
            throw new IllegalStateException("Fit cannot be used with a Target.");
        }
        Drawable drawable;
        if (placeholderResId != 0)
        {
            drawable = picasso.context.getResources().getDrawable(placeholderResId);
        } else
        {
            drawable = placeholderDrawable;
        }
        if (!data.hasImage())
        {
            picasso.cancelRequest(target);
            target.onPrepareLoad(drawable);
            return;
        }
        Request request = createRequest(l);
        String s = Utils.createKey(request);
        if (!skipMemoryCache)
        {
            Bitmap bitmap = picasso.quickMemoryCacheCheck(data.getCache(), s);
            if (bitmap != null)
            {
                picasso.cancelRequest(target);
                target.onBitmapLoaded(bitmap, Picasso.LoadedFrom.MEMORY);
                return;
            }
        }
        target.onPrepareLoad(drawable);
        target = new TargetAction(picasso, target, request, skipMemoryCache, errorResId, errorDrawable, s, tag, fadeTime);
        picasso.enqueueAndSubmit(target, delayMillis);
    }

    public RequestCreator noFade()
    {
        fadeTime = 0L;
        return this;
    }

    public RequestCreator placeholder(int i)
    {
        if (i == 0)
        {
            throw new IllegalArgumentException("Placeholder image resource invalid.");
        }
        if (placeholderDrawable != null)
        {
            throw new IllegalStateException("Placeholder image already set.");
        } else
        {
            placeholderResId = i;
            return this;
        }
    }

    public RequestCreator placeholder(Drawable drawable)
    {
        if (placeholderResId != 0)
        {
            throw new IllegalStateException("Placeholder image already set.");
        } else
        {
            placeholderDrawable = drawable;
            return this;
        }
    }

    public RequestCreator priority(Picasso.Priority priority1)
    {
        data.priority(priority1);
        return this;
    }

    public RequestCreator resize(int i, int j)
    {
        return resize(i, j, false);
    }

    public RequestCreator resize(int i, int j, boolean flag)
    {
        data.resize(i, j, flag);
        return this;
    }

    public RequestCreator resizeByMaxSide()
    {
        data.resizeByMaxSide();
        return this;
    }

    public RequestCreator resizeDimen(int i, int j)
    {
        return resizeDimen(i, j, false);
    }

    public RequestCreator resizeDimen(int i, int j, boolean flag)
    {
        Resources resources = picasso.context.getResources();
        return resize(resources.getDimensionPixelSize(i), resources.getDimensionPixelSize(j), flag);
    }

    public RequestCreator rotate(float f)
    {
        data.rotate(f);
        return this;
    }

    public RequestCreator rotate(float f, float f1, float f2)
    {
        data.rotate(f, f1, f2);
        return this;
    }

    public RequestCreator skipMemoryCache()
    {
        skipMemoryCache = true;
        return this;
    }

    public RequestCreator tag(Object obj)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException("Tag invalid.");
        }
        if (tag != null)
        {
            throw new IllegalStateException("Tag already set.");
        } else
        {
            tag = obj;
            return this;
        }
    }

    public RequestCreator transform(Transformation transformation)
    {
        data.transform(transformation);
        return this;
    }

    RequestCreator unfit()
    {
        deferred = false;
        return this;
    }

    public RequestCreator withCache(Cache cache)
    {
        data.setCache(cache);
        return this;
    }

    public RequestCreator withDelay(long l)
    {
        delayMillis = l;
        return this;
    }

    public RequestCreator withDiskCache(Cache cache)
    {
        data.setDiskCache(cache);
        return this;
    }


}
