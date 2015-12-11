// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.NetworkInfo;
import android.os.Handler;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.squareup.picasso:
//            Action, RequestHandler, Transformation, Picasso, 
//            Request, Utils, Cache, Stats, 
//            Dispatcher, StatsSnapshot

class BitmapHunter
    implements Runnable
{

    private static final Object DECODE_LOCK = new Object();
    private static final RequestHandler ERRORING_HANDLER = new _cls2();
    private static final ThreadLocal NAME_BUILDER = new _cls1();
    private static final AtomicInteger SEQUENCE_GENERATOR = new AtomicInteger();
    Action action;
    List actions;
    final Cache cache;
    final Request data;
    final Dispatcher dispatcher;
    Exception exception;
    int exifRotation;
    Future future;
    final String key;
    Picasso.LoadedFrom loadedFrom;
    final Picasso picasso;
    Picasso.Priority priority;
    final RequestHandler requestHandler;
    Bitmap result;
    int retryCount;
    final int sequence;
    final boolean skipMemoryCache;
    final Stats stats;

    BitmapHunter(Picasso picasso1, Dispatcher dispatcher1, Cache cache1, Stats stats1, Action action1, RequestHandler requesthandler)
    {
        sequence = SEQUENCE_GENERATOR.incrementAndGet();
        picasso = picasso1;
        dispatcher = dispatcher1;
        cache = cache1;
        stats = stats1;
        action = action1;
        key = action1.getKey();
        data = action1.getRequest();
        priority = action1.getPriority();
        skipMemoryCache = action1.skipCache;
        requestHandler = requesthandler;
        retryCount = requesthandler.getRetryCount();
    }

    static Bitmap applyCustomTransformations(final List e, final Bitmap builder)
    {
        int j = e.size();
        for (int i = 0; i < j;)
        {
            final Transformation transformation = (Transformation)e.get(i);
            Bitmap bitmap;
            try
            {
                bitmap = transformation.transform(builder);
            }
            // Misplaced declaration of an exception variable
            catch (final List e)
            {
                Picasso.HANDLER.post(new _cls3());
                return null;
            }
            if (bitmap == null)
            {
                builder = (new StringBuilder("Transformation ")).append(transformation.key()).append(" returned null after ").append(i).append(" previous transformation(s).\n\nTransformation list:\n");
                for (e = e.iterator(); e.hasNext(); builder.append(((Transformation)e.next()).key()).append('\n')) { }
                Picasso.HANDLER.post(new _cls4());
                return null;
            }
            if (bitmap == builder && builder.isRecycled())
            {
                Picasso.HANDLER.post(new _cls5());
                return null;
            }
            if (bitmap != builder && !builder.isRecycled())
            {
                Picasso.HANDLER.post(new _cls6());
                return null;
            }
            i++;
            builder = bitmap;
        }

        return builder;
    }

    private Picasso.Priority computeNewPriority()
    {
        Picasso.Priority priority1;
        Picasso.Priority priority2;
        boolean flag;
        boolean flag2;
        boolean flag3 = true;
        flag2 = false;
        priority1 = Picasso.Priority.LOW;
        boolean flag1;
        if (actions != null && !actions.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag3;
        if (action == null)
        {
            if (flag)
            {
                flag1 = flag3;
            } else
            {
                flag1 = false;
            }
        }
        if (flag1) goto _L2; else goto _L1
_L1:
        priority2 = priority1;
_L4:
        return priority2;
_L2:
        if (action != null)
        {
            priority1 = action.getPriority();
        }
        priority2 = priority1;
        if (!flag)
        {
            continue;
        }
        int j = actions.size();
        int i = ((flag2) ? 1 : 0);
        do
        {
            priority2 = priority1;
            if (i >= j)
            {
                continue;
            }
            priority2 = ((Action)actions.get(i)).getPriority();
            if (priority2.ordinal() > priority1.ordinal())
            {
                priority1 = priority2;
            }
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    static BitmapHunter forRequest(Picasso picasso1, Dispatcher dispatcher1, Cache cache1, Stats stats1, Action action1)
    {
        Request request = action1.getRequest();
        List list = picasso1.getRequestHandlers();
        int i = 0;
        for (int j = list.size(); i < j; i++)
        {
            RequestHandler requesthandler = (RequestHandler)list.get(i);
            if (requesthandler.canHandleRequest(request))
            {
                return new BitmapHunter(picasso1, dispatcher1, cache1, stats1, action1, requesthandler);
            }
        }

        return new BitmapHunter(picasso1, dispatcher1, cache1, stats1, action1, ERRORING_HANDLER);
    }

    static Bitmap transformResult(Request request, Bitmap bitmap, int i)
    {
        Object obj;
        int j;
        int l;
        int i1;
        i1 = 0;
        l = bitmap.getWidth();
        j = bitmap.getHeight();
        obj = new Matrix();
        if (!request.needsMatrixTransform()) goto _L2; else goto _L1
_L1:
        float f;
        int k;
        int l1;
        k = request.targetWidth;
        l1 = request.targetHeight;
        f = request.rotationDegrees;
        float f6;
        if (f != 0.0F)
        {
            if (request.hasRotationPivot)
            {
                ((Matrix) (obj)).setRotate(f, request.rotationPivotX, request.rotationPivotY);
            } else
            {
                ((Matrix) (obj)).setRotate(f);
            }
        }
        if (!request.centerCrop) goto _L4; else goto _L3
_L3:
        f = (float)k / (float)l;
        float f3 = (float)l1 / (float)j;
        if (f > f3)
        {
            f6 = j;
            l1 = (int)Math.ceil((f3 / f) * f6);
            j = (j - l1) / 2;
            k = l;
            l = l1;
        } else
        {
            float f7 = l;
            k = (int)Math.ceil((f / f3) * f7);
            i1 = (l - k) / 2;
            f = f3;
            l1 = 0;
            l = j;
            j = l1;
        }
        ((Matrix) (obj)).preScale(f, f);
        l1 = k;
        k = j;
        j = i1;
_L6:
        if (i != 0)
        {
            ((Matrix) (obj)).preRotate(i);
        }
        obj = Bitmap.createBitmap(bitmap, j, k, l1, l, ((Matrix) (obj)), true);
        request = bitmap;
        if (obj != bitmap)
        {
            bitmap.recycle();
            request = ((Request) (obj));
        }
        return request;
_L4:
        if (request.centerInside)
        {
            float f1 = (float)k / (float)l;
            float f4 = (float)l1 / (float)j;
            int j1;
            if (f1 >= f4)
            {
                f1 = f4;
            }
            ((Matrix) (obj)).preScale(f1, f1);
            k = 0;
            j1 = j;
            l1 = 0;
            j = k;
            k = l1;
            l1 = l;
            l = j1;
            continue; /* Loop/switch isn't completed */
        }
        if ((k != 0 || l1 != 0) && (k != l || l1 != j))
        {
            float f2;
            float f5;
            int k1;
            if (k != 0)
            {
                f2 = (float)k / (float)l;
            } else
            {
                f2 = (float)l1 / (float)j;
            }
            if (l1 != 0)
            {
                f5 = (float)l1 / (float)j;
            } else
            {
                f5 = (float)k / (float)l;
            }
            ((Matrix) (obj)).preScale(f2, f5);
        }
_L2:
        k = 0;
        k1 = j;
        l1 = 0;
        j = k;
        k = l1;
        l1 = l;
        l = k1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    static void updateThreadName(Request request)
    {
        request = request.getName();
        StringBuilder stringbuilder = (StringBuilder)NAME_BUILDER.get();
        stringbuilder.ensureCapacity(request.length() + 8);
        stringbuilder.replace(8, stringbuilder.length(), request);
        Thread.currentThread().setName(stringbuilder.toString());
    }

    void attach(Action action1)
    {
        Request request;
        boolean flag;
        flag = picasso.loggingEnabled;
        request = action1.request;
        if (action != null) goto _L2; else goto _L1
_L1:
        action = action1;
        if (!flag) goto _L4; else goto _L3
_L3:
        if (actions != null && !actions.isEmpty()) goto _L6; else goto _L5
_L5:
        Utils.log("Hunter", "joined", request.logId(), "to empty hunter");
_L4:
        return;
_L6:
        Utils.log("Hunter", "joined", request.logId(), Utils.getLogIdsForHunter(this, "to "));
        return;
_L2:
        if (actions == null)
        {
            actions = new ArrayList(3);
        }
        actions.add(action1);
        if (flag)
        {
            Utils.log("Hunter", "joined", request.logId(), Utils.getLogIdsForHunter(this, "to "));
        }
        action1 = action1.getPriority();
        if (action1.ordinal() > priority.ordinal())
        {
            priority = action1;
            return;
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    boolean cancel()
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (action != null)
            {
                break label0;
            }
            if (actions != null)
            {
                flag = flag1;
                if (!actions.isEmpty())
                {
                    break label0;
                }
            }
            flag = flag1;
            if (future != null)
            {
                flag = flag1;
                if (future.cancel(false))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    void detach(Action action1)
    {
        boolean flag = false;
        if (action != action1) goto _L2; else goto _L1
_L1:
        action = null;
        flag = true;
_L4:
        if (flag && action1.getPriority() == priority)
        {
            priority = computeNewPriority();
        }
        if (picasso.loggingEnabled)
        {
            Utils.log("Hunter", "removed", action1.request.logId(), Utils.getLogIdsForHunter(this, "from "));
        }
        return;
_L2:
        if (actions != null)
        {
            flag = actions.remove(action1);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    Action getAction()
    {
        return action;
    }

    List getActions()
    {
        return actions;
    }

    Request getData()
    {
        return data;
    }

    Exception getException()
    {
        return exception;
    }

    String getKey()
    {
        return key;
    }

    Picasso.LoadedFrom getLoadedFrom()
    {
        return loadedFrom;
    }

    Picasso getPicasso()
    {
        return picasso;
    }

    Picasso.Priority getPriority()
    {
        return priority;
    }

    Bitmap getResult()
    {
        return result;
    }

    Bitmap hunt()
    {
        Bitmap bitmap = null;
        if (skipMemoryCache) goto _L2; else goto _L1
_L1:
        Object obj1;
        obj1 = cache.get(key);
        bitmap = ((Bitmap) (obj1));
        if (obj1 == null) goto _L2; else goto _L3
_L3:
        Object obj;
        stats.dispatchCacheHit();
        loadedFrom = Picasso.LoadedFrom.MEMORY;
        obj = obj1;
        if (picasso.loggingEnabled)
        {
            Utils.log("Hunter", "decoded", data.logId(), "from cache");
            obj = obj1;
        }
_L5:
        return ((Bitmap) (obj));
_L2:
        obj = data;
        boolean flag;
        if (retryCount == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj.loadFromLocalCacheOnly = flag;
        obj = requestHandler.load(data);
        if (obj != null)
        {
            bitmap = ((RequestHandler.Result) (obj)).getBitmap();
            loadedFrom = ((RequestHandler.Result) (obj)).getLoadedFrom();
            exifRotation = ((RequestHandler.Result) (obj)).getExifOrientation();
        }
        obj = bitmap;
        if (bitmap == null) goto _L5; else goto _L4
_L4:
        if (picasso.loggingEnabled)
        {
            Utils.log("Hunter", "decoded", data.logId());
        }
        stats.dispatchBitmapDecoded(bitmap);
        if (data.needsTransformation())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = bitmap;
        if (exifRotation == 0) goto _L5; else goto _L6
_L6:
        obj1 = DECODE_LOCK;
        obj1;
        JVM INSTR monitorenter ;
        if (data.needsMatrixTransform())
        {
            break MISSING_BLOCK_LABEL_220;
        }
        obj = bitmap;
        if (exifRotation == 0)
        {
            break MISSING_BLOCK_LABEL_263;
        }
        bitmap = transformResult(data, bitmap, exifRotation);
        obj = bitmap;
        if (!picasso.loggingEnabled)
        {
            break MISSING_BLOCK_LABEL_263;
        }
        Utils.log("Hunter", "transformed", data.logId());
        obj = bitmap;
        bitmap = ((Bitmap) (obj));
        if (!data.hasCustomTransformations())
        {
            break MISSING_BLOCK_LABEL_320;
        }
        obj = applyCustomTransformations(data.transformations, ((Bitmap) (obj)));
        bitmap = ((Bitmap) (obj));
        if (!picasso.loggingEnabled)
        {
            break MISSING_BLOCK_LABEL_320;
        }
        Utils.log("Hunter", "transformed", data.logId(), "from custom transformations");
        bitmap = ((Bitmap) (obj));
        obj1;
        JVM INSTR monitorexit ;
        obj = bitmap;
        if (bitmap == null) goto _L5; else goto _L7
_L7:
        stats.dispatchBitmapTransformed(bitmap);
        return bitmap;
        Exception exception1;
        exception1;
        obj1;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    boolean isCancelled()
    {
        return future != null && future.isCancelled();
    }

    public void run()
    {
        updateThreadName(data);
        if (picasso.loggingEnabled)
        {
            Utils.log("Hunter", "executing", Utils.getLogIdsForHunter(this));
        }
        result = hunt();
        if (result != null) goto _L2; else goto _L1
_L1:
        dispatcher.dispatchFailed(this);
_L4:
        Thread.currentThread().setName("Picasso-Idle");
        return;
_L2:
        dispatcher.dispatchComplete(this);
        if (true) goto _L4; else goto _L3
_L3:
        Object obj;
        obj;
        exception = ((Exception) (obj));
        dispatcher.dispatchFailed(this);
        Thread.currentThread().setName("Picasso-Idle");
        return;
        obj;
        exception = ((Exception) (obj));
        dispatcher.dispatchRetry(this);
        Thread.currentThread().setName("Picasso-Idle");
        return;
        obj;
        StringWriter stringwriter = new StringWriter();
        stats.createSnapshot().dump(new PrintWriter(stringwriter));
        exception = new RuntimeException(stringwriter.toString(), ((Throwable) (obj)));
        dispatcher.dispatchFailed(this);
        Thread.currentThread().setName("Picasso-Idle");
        return;
        obj;
        exception = ((Exception) (obj));
        dispatcher.dispatchFailed(this);
        Thread.currentThread().setName("Picasso-Idle");
        return;
        obj;
        Thread.currentThread().setName("Picasso-Idle");
        throw obj;
    }

    boolean shouldRetry(boolean flag, NetworkInfo networkinfo)
    {
        boolean flag1;
        if (retryCount > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag1)
        {
            return false;
        } else
        {
            retryCount = retryCount - 1;
            return requestHandler.shouldRetry(flag, networkinfo);
        }
    }

    boolean shouldSkipMemoryCache()
    {
        return skipMemoryCache;
    }

    boolean supportsReplay()
    {
        return requestHandler.supportsReplay();
    }


    private class _cls3
        implements Runnable
    {

        final RuntimeException val$e;
        final Transformation val$transformation;

        public final void run()
        {
            throw new RuntimeException((new StringBuilder("Transformation ")).append(transformation.key()).append(" crashed with exception.").toString(), e);
        }

        _cls3()
        {
            transformation = transformation1;
            e = runtimeexception;
            super();
        }
    }


    private class _cls4
        implements Runnable
    {

        final StringBuilder val$builder;

        public final void run()
        {
            throw new NullPointerException(builder.toString());
        }

        _cls4()
        {
            builder = stringbuilder;
            super();
        }
    }


    private class _cls5
        implements Runnable
    {

        final Transformation val$transformation;

        public final void run()
        {
            throw new IllegalStateException((new StringBuilder("Transformation ")).append(transformation.key()).append(" returned input Bitmap but recycled it.").toString());
        }

        _cls5()
        {
            transformation = transformation1;
            super();
        }
    }


    private class _cls6
        implements Runnable
    {

        final Transformation val$transformation;

        public final void run()
        {
            throw new IllegalStateException((new StringBuilder("Transformation ")).append(transformation.key()).append(" mutated input Bitmap but failed to recycle the original.").toString());
        }

        _cls6()
        {
            transformation = transformation1;
            super();
        }
    }


    private class _cls1 extends ThreadLocal
    {

        protected final volatile Object initialValue()
        {
            return initialValue();
        }

        protected final StringBuilder initialValue()
        {
            return new StringBuilder("Picasso-");
        }

        _cls1()
        {
        }
    }


    private class _cls2 extends RequestHandler
    {

        public final boolean canHandleRequest(Request request)
        {
            return true;
        }

        public final RequestHandler.Result load(Request request)
        {
            throw new IllegalStateException((new StringBuilder("Unrecognized type of request: ")).append(request).toString());
        }

        _cls2()
        {
        }
    }

}
