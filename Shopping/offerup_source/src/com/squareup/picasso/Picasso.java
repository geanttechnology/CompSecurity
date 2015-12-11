// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.RemoteViews;
import java.io.File;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

// Referenced classes of package com.squareup.picasso:
//            ResourceRequestHandler, ContactsPhotoRequestHandler, MediaStoreRequestHandler, ContentStreamRequestHandler, 
//            AssetRequestHandler, FileRequestHandler, NetworkRequestHandler, Dispatcher, 
//            Utils, Action, DeferredRequestCreator, Request, 
//            BitmapHunter, Stats, RequestCreator, Cache, 
//            Target, StatsSnapshot

public class Picasso
{

    static final Handler HANDLER = new _cls1(Looper.getMainLooper());
    static final String TAG = "Picasso";
    static Picasso singleton = null;
    final Cache cache;
    private final CleanupThread cleanupThread;
    final Context context;
    final Dispatcher dispatcher;
    boolean indicatorsEnabled;
    private final Listener listener;
    volatile boolean loggingEnabled;
    final ReferenceQueue referenceQueue = new ReferenceQueue();
    private final List requestHandlers;
    private final RequestTransformer requestTransformer;
    boolean shutdown;
    final Stats stats;
    final Map targetToAction = new WeakHashMap();
    final Map targetToDeferredRequestCreator = new WeakHashMap();

    Picasso(Context context1, Dispatcher dispatcher1, Cache cache1, Listener listener1, RequestTransformer requesttransformer, List list, Stats stats1, 
            boolean flag, boolean flag1)
    {
        context = context1;
        dispatcher = dispatcher1;
        cache = cache1;
        listener = listener1;
        requestTransformer = requesttransformer;
        int i;
        if (list != null)
        {
            i = list.size();
        } else
        {
            i = 0;
        }
        cache1 = new ArrayList(i + 7);
        cache1.add(new ResourceRequestHandler(context1));
        if (list != null)
        {
            cache1.addAll(list);
        }
        cache1.add(new ContactsPhotoRequestHandler(context1));
        cache1.add(new MediaStoreRequestHandler(context1));
        cache1.add(new ContentStreamRequestHandler(context1));
        cache1.add(new AssetRequestHandler(context1));
        cache1.add(new FileRequestHandler(context1));
        cache1.add(new NetworkRequestHandler(dispatcher1.downloader, stats1));
        requestHandlers = Collections.unmodifiableList(cache1);
        stats = stats1;
        indicatorsEnabled = flag;
        loggingEnabled = flag1;
        cleanupThread = new CleanupThread(referenceQueue, HANDLER);
        cleanupThread.start();
    }

    private void cancelExistingRequest(Object obj)
    {
        Utils.checkMain();
        Action action = (Action)targetToAction.remove(obj);
        if (action != null)
        {
            action.cancel();
            dispatcher.dispatchCancel(action);
        }
        if (obj instanceof ImageView)
        {
            obj = (ImageView)obj;
            obj = (DeferredRequestCreator)targetToDeferredRequestCreator.remove(obj);
            if (obj != null)
            {
                ((DeferredRequestCreator) (obj)).cancel();
            }
        }
    }

    private void deliverAction(Bitmap bitmap, LoadedFrom loadedfrom, Action action)
    {
        if (!action.isCancelled()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!action.willReplay())
        {
            targetToAction.remove(action.getTarget());
        }
        if (bitmap == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (loadedfrom == null)
        {
            throw new AssertionError("LoadedFrom cannot be null.");
        }
        action.complete(bitmap, loadedfrom);
        if (loggingEnabled)
        {
            Utils.log("Main", "completed", action.request.logId(), (new StringBuilder("from ")).append(loadedfrom).toString());
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        action.error();
        if (loggingEnabled)
        {
            Utils.log("Main", "errored", action.request.logId());
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public static void setSingletonInstance(Picasso picasso)
    {
        com/squareup/picasso/Picasso;
        JVM INSTR monitorenter ;
        if (singleton != null)
        {
            throw new IllegalStateException("Singleton instance already exists.");
        }
        break MISSING_BLOCK_LABEL_26;
        picasso;
        com/squareup/picasso/Picasso;
        JVM INSTR monitorexit ;
        throw picasso;
        singleton = picasso;
        com/squareup/picasso/Picasso;
        JVM INSTR monitorexit ;
    }

    public static Picasso with(Context context1)
    {
        if (singleton != null) goto _L2; else goto _L1
_L1:
        com/squareup/picasso/Picasso;
        JVM INSTR monitorenter ;
        if (singleton == null)
        {
            singleton = (new Builder(context1)).build();
        }
        com/squareup/picasso/Picasso;
        JVM INSTR monitorexit ;
_L2:
        return singleton;
        context1;
        com/squareup/picasso/Picasso;
        JVM INSTR monitorexit ;
        throw context1;
    }

    public boolean areIndicatorsEnabled()
    {
        return indicatorsEnabled;
    }

    public void cancelRequest(ImageView imageview)
    {
        cancelExistingRequest(imageview);
    }

    public void cancelRequest(RemoteViews remoteviews, int i)
    {
        cancelExistingRequest(new RemoteViewsAction.RemoteViewsTarget(remoteviews, i));
    }

    public void cancelRequest(Target target)
    {
        cancelExistingRequest(target);
    }

    public void cancelTag(Object obj)
    {
        Utils.checkMain();
        ArrayList arraylist = new ArrayList(targetToAction.values());
        int j = arraylist.size();
        for (int i = 0; i < j; i++)
        {
            Action action = (Action)arraylist.get(i);
            if (action.getTag().equals(obj))
            {
                cancelExistingRequest(action.getTarget());
            }
        }

    }

    void complete(BitmapHunter bitmaphunter)
    {
        boolean flag2 = true;
        Action action = bitmaphunter.getAction();
        List list = bitmaphunter.getActions();
        boolean flag;
        boolean flag1;
        if (list != null && !list.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag2;
        if (action == null)
        {
            if (flag)
            {
                flag1 = flag2;
            } else
            {
                flag1 = false;
            }
        }
        if (flag1)
        {
            Uri uri = bitmaphunter.getData().uri;
            Exception exception = bitmaphunter.getException();
            Bitmap bitmap = bitmaphunter.getResult();
            bitmaphunter = bitmaphunter.getLoadedFrom();
            if (action != null)
            {
                deliverAction(bitmap, bitmaphunter, action);
            }
            if (flag)
            {
                int j = list.size();
                for (int i = 0; i < j; i++)
                {
                    deliverAction(bitmap, bitmaphunter, (Action)list.get(i));
                }

            }
            if (listener != null && exception != null)
            {
                listener.onImageLoadFailed(this, uri, exception);
                return;
            }
        }
    }

    void defer(ImageView imageview, DeferredRequestCreator deferredrequestcreator)
    {
        targetToDeferredRequestCreator.put(imageview, deferredrequestcreator);
    }

    void enqueueAndSubmit(Action action)
    {
        Object obj = action.getTarget();
        if (obj != null && targetToAction.get(obj) != action)
        {
            cancelExistingRequest(obj);
            targetToAction.put(obj, action);
        }
        submit(action);
    }

    List getRequestHandlers()
    {
        return requestHandlers;
    }

    public StatsSnapshot getSnapshot()
    {
        return stats.createSnapshot();
    }

    public boolean isDebugging()
    {
        return areIndicatorsEnabled() && isLoggingEnabled();
    }

    public boolean isLoggingEnabled()
    {
        return loggingEnabled;
    }

    public RequestCreator load(int i)
    {
        if (i == 0)
        {
            throw new IllegalArgumentException("Resource ID must not be zero.");
        } else
        {
            return new RequestCreator(this, null, i);
        }
    }

    public RequestCreator load(Uri uri)
    {
        return new RequestCreator(this, uri, 0);
    }

    public RequestCreator load(File file)
    {
        if (file == null)
        {
            return new RequestCreator(this, null, 0);
        } else
        {
            return load(Uri.fromFile(file));
        }
    }

    public RequestCreator load(String s)
    {
        if (s == null)
        {
            return new RequestCreator(this, null, 0);
        }
        if (s.trim().length() == 0)
        {
            throw new IllegalArgumentException("Path must not be empty.");
        } else
        {
            return load(Uri.parse(s));
        }
    }

    public void pauseTag(Object obj)
    {
        dispatcher.dispatchPauseTag(obj);
    }

    Bitmap quickMemoryCacheCheck(String s)
    {
        s = cache.get(s);
        if (s != null)
        {
            stats.dispatchCacheHit();
            return s;
        } else
        {
            stats.dispatchCacheMiss();
            return s;
        }
    }

    void resumeAction(Action action)
    {
        Bitmap bitmap = null;
        if (!action.skipCache)
        {
            bitmap = quickMemoryCacheCheck(action.getKey());
        }
        if (bitmap != null)
        {
            deliverAction(bitmap, LoadedFrom.MEMORY, action);
            if (loggingEnabled)
            {
                Utils.log("Main", "completed", action.request.logId(), (new StringBuilder("from ")).append(LoadedFrom.MEMORY).toString());
            }
        } else
        {
            enqueueAndSubmit(action);
            if (loggingEnabled)
            {
                Utils.log("Main", "resumed", action.request.logId());
                return;
            }
        }
    }

    public void resumeTag(Object obj)
    {
        dispatcher.dispatchResumeTag(obj);
    }

    public void setDebugging(boolean flag)
    {
        setIndicatorsEnabled(flag);
    }

    public void setIndicatorsEnabled(boolean flag)
    {
        indicatorsEnabled = flag;
    }

    public void setLoggingEnabled(boolean flag)
    {
        loggingEnabled = flag;
    }

    public void shutdown()
    {
        if (this == singleton)
        {
            throw new UnsupportedOperationException("Default singleton instance cannot be shutdown.");
        }
        if (shutdown)
        {
            return;
        }
        cache.clear();
        cleanupThread.shutdown();
        stats.shutdown();
        dispatcher.shutdown();
        for (Iterator iterator = targetToDeferredRequestCreator.values().iterator(); iterator.hasNext(); ((DeferredRequestCreator)iterator.next()).cancel()) { }
        targetToDeferredRequestCreator.clear();
        shutdown = true;
    }

    void submit(Action action)
    {
        dispatcher.dispatchSubmit(action);
    }

    Request transformRequest(Request request)
    {
        Request request1 = requestTransformer.transformRequest(request);
        if (request1 == null)
        {
            throw new IllegalStateException((new StringBuilder("Request transformer ")).append(requestTransformer.getClass().getCanonicalName()).append(" returned null for ").append(request).toString());
        } else
        {
            return request1;
        }
    }



    private class CleanupThread extends Thread
    {

        private final Handler handler;
        private final ReferenceQueue referenceQueue;

        public void run()
        {
            Process.setThreadPriority(10);
            class _cls1
                implements Runnable
            {

                final CleanupThread this$0;
                final Exception val$e;

                public void run()
                {
                    throw new RuntimeException(e);
                }

                _cls1()
                {
                    this$0 = CleanupThread.this;
                    e = exception;
                    super();
                }
            }

            try
            {
                do
                {
                    Action.RequestWeakReference requestweakreference = (Action.RequestWeakReference)referenceQueue.remove();
                    handler.sendMessage(handler.obtainMessage(3, requestweakreference.action));
                } while (true);
            }
            catch (InterruptedException interruptedexception)
            {
                return;
            }
            catch (final Exception e)
            {
                handler.post(new _cls1());
            }
        }

        void shutdown()
        {
            interrupt();
        }

        CleanupThread(ReferenceQueue referencequeue, Handler handler1)
        {
            referenceQueue = referencequeue;
            handler = handler1;
            setDaemon(true);
            setName("Picasso-refQueue");
        }
    }


    private class Builder
    {

        private Cache cache;
        private final Context context;
        private Downloader downloader;
        private boolean indicatorsEnabled;
        private Listener listener;
        private boolean loggingEnabled;
        private List requestHandlers;
        private ExecutorService service;
        private RequestTransformer transformer;

        public Builder addRequestHandler(RequestHandler requesthandler)
        {
            if (requesthandler == null)
            {
                throw new IllegalArgumentException("RequestHandler must not be null.");
            }
            if (requestHandlers == null)
            {
                requestHandlers = new ArrayList();
            }
            if (requestHandlers.contains(requesthandler))
            {
                throw new IllegalStateException("RequestHandler already registered.");
            } else
            {
                requestHandlers.add(requesthandler);
                return this;
            }
        }

        public Picasso build()
        {
            Context context1 = context;
            if (downloader == null)
            {
                downloader = Utils.createDefaultDownloader(context1);
            }
            if (cache == null)
            {
                cache = new LruCache(context1);
            }
            if (service == null)
            {
                service = new PicassoExecutorService();
            }
            if (transformer == null)
            {
                transformer = RequestTransformer.IDENTITY;
            }
            Stats stats1 = new Stats(cache);
            return new Picasso(context1, new Dispatcher(context1, service, Picasso.HANDLER, downloader, cache, stats1), cache, listener, transformer, requestHandlers, stats1, indicatorsEnabled, loggingEnabled);
        }

        public Builder debugging(boolean flag)
        {
            return indicatorsEnabled(flag);
        }

        public Builder downloader(Downloader downloader1)
        {
            if (downloader1 == null)
            {
                throw new IllegalArgumentException("Downloader must not be null.");
            }
            if (downloader != null)
            {
                throw new IllegalStateException("Downloader already set.");
            } else
            {
                downloader = downloader1;
                return this;
            }
        }

        public Builder executor(ExecutorService executorservice)
        {
            if (executorservice == null)
            {
                throw new IllegalArgumentException("Executor service must not be null.");
            }
            if (service != null)
            {
                throw new IllegalStateException("Executor service already set.");
            } else
            {
                service = executorservice;
                return this;
            }
        }

        public Builder indicatorsEnabled(boolean flag)
        {
            indicatorsEnabled = flag;
            return this;
        }

        public Builder listener(Listener listener1)
        {
            if (listener1 == null)
            {
                throw new IllegalArgumentException("Listener must not be null.");
            }
            if (listener != null)
            {
                throw new IllegalStateException("Listener already set.");
            } else
            {
                listener = listener1;
                return this;
            }
        }

        public Builder loggingEnabled(boolean flag)
        {
            loggingEnabled = flag;
            return this;
        }

        public Builder memoryCache(Cache cache1)
        {
            if (cache1 == null)
            {
                throw new IllegalArgumentException("Memory cache must not be null.");
            }
            if (cache != null)
            {
                throw new IllegalStateException("Memory cache already set.");
            } else
            {
                cache = cache1;
                return this;
            }
        }

        public Builder requestTransformer(RequestTransformer requesttransformer)
        {
            if (requesttransformer == null)
            {
                throw new IllegalArgumentException("Transformer must not be null.");
            }
            if (transformer != null)
            {
                throw new IllegalStateException("Transformer already set.");
            } else
            {
                transformer = requesttransformer;
                return this;
            }
        }

        public Builder(Context context1)
        {
            if (context1 == null)
            {
                throw new IllegalArgumentException("Context must not be null.");
            } else
            {
                context = context1.getApplicationContext();
                return;
            }
        }
    }


    private class Listener
    {

        public abstract void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception);
    }


    private class LoadedFrom extends Enum
    {

        private static final LoadedFrom $VALUES[];
        public static final LoadedFrom DISK;
        public static final LoadedFrom MEMORY;
        public static final LoadedFrom NETWORK;
        final int debugColor;

        public static LoadedFrom valueOf(String s)
        {
            return (LoadedFrom)Enum.valueOf(com/squareup/picasso/Picasso$LoadedFrom, s);
        }

        public static LoadedFrom[] values()
        {
            return (LoadedFrom[])$VALUES.clone();
        }

        static 
        {
            MEMORY = new LoadedFrom("MEMORY", 0, 0xff00ff00);
            DISK = new LoadedFrom("DISK", 1, -256);
            NETWORK = new LoadedFrom("NETWORK", 2, 0xffff0000);
            $VALUES = (new LoadedFrom[] {
                MEMORY, DISK, NETWORK
            });
        }

        private LoadedFrom(String s, int i, int j)
        {
            super(s, i);
            debugColor = j;
        }
    }


    private class RequestTransformer
    {

        public static final RequestTransformer IDENTITY = new _cls1();

        public abstract Request transformRequest(Request request);


        class _cls1
            implements RequestTransformer
        {

            public final Request transformRequest(Request request)
            {
                return request;
            }

                _cls1()
                {
                }
        }

    }


    private class _cls1 extends Handler
    {

        public final void handleMessage(Message message)
        {
            message.what;
            JVM INSTR lookupswitch 3: default 40
        //                       3: 117
        //                       8: 67
        //                       13: 163;
               goto _L1 _L2 _L3 _L4
_L1:
            throw new AssertionError((new StringBuilder("Unknown handler message received: ")).append(message.what).toString());
_L3:
            message = (List)message.obj;
            int k = message.size();
            for (int i = 0; i < k; i++)
            {
                BitmapHunter bitmaphunter = (BitmapHunter)message.get(i);
                bitmaphunter.picasso.complete(bitmaphunter);
            }

            break; /* Loop/switch isn't completed */
_L2:
            message = (Action)message.obj;
            if (message.getPicasso().loggingEnabled)
            {
                Utils.log("Main", "canceled", ((Action) (message)).request.logId(), "target got garbage collected");
            }
            ((Action) (message)).picasso.cancelExistingRequest(message.getTarget());
_L6:
            return;
_L4:
            message = (List)message.obj;
            int l = message.size();
            int j = 0;
            while (j < l) 
            {
                Action action = (Action)message.get(j);
                action.picasso.resumeAction(action);
                j++;
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

        _cls1(Looper looper)
        {
            super(looper);
        }
    }

}
