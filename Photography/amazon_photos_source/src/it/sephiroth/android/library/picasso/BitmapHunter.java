// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.picasso;

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

// Referenced classes of package it.sephiroth.android.library.picasso:
//            Action, RequestHandler, Transformation, Picasso, 
//            Request, Utils, Cache, Stats, 
//            Dispatcher, StatsSnapshot

class BitmapHunter
    implements Runnable
{

    private static final Object DECODE_LOCK = new Object();
    private static final RequestHandler ERRORING_HANDLER = new RequestHandler() {

        public boolean canHandleRequest(Request request)
        {
            return true;
        }

        public RequestHandler.Result load(Request request)
            throws IOException
        {
            throw new IllegalStateException((new StringBuilder()).append("Unrecognized type of request: ").append(request).toString());
        }

    };
    private static final ThreadLocal NAME_BUILDER = new ThreadLocal() {

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected StringBuilder initialValue()
        {
            return new StringBuilder("Picasso-");
        }

    };
    private static final AtomicInteger SEQUENCE_GENERATOR = new AtomicInteger();
    Action action;
    List actions;
    final Cache cache;
    final Request data;
    final Cache diskCache;
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

    BitmapHunter(Picasso picasso1, Dispatcher dispatcher1, Cache cache1, Cache cache2, Stats stats1, Action action1, RequestHandler requesthandler)
    {
        sequence = SEQUENCE_GENERATOR.incrementAndGet();
        picasso = picasso1;
        dispatcher = dispatcher1;
        cache = cache1;
        diskCache = cache2;
        stats = stats1;
        key = action1.getKey();
        data = action1.getRequest();
        skipMemoryCache = action1.skipCache;
        requestHandler = requesthandler;
        retryCount = requesthandler.getRetryCount();
        action = action1;
        if (action1 != null)
        {
            picasso1 = action1.getPriority();
        } else
        {
            picasso1 = Picasso.Priority.LOW;
        }
        priority = picasso1;
    }

    static Bitmap applyCustomTransformations(List list, Bitmap bitmap)
    {
        int i = 0;
        int j = list.size();
        do
        {
            Bitmap bitmap1;
            Transformation transformation;
label0:
            {
                bitmap1 = bitmap;
                if (i < j)
                {
                    transformation = (Transformation)list.get(i);
                    bitmap1 = transformation.transform(bitmap);
                    if (bitmap1 != null)
                    {
                        break label0;
                    }
                    bitmap = (new StringBuilder()).append("Transformation ").append(transformation.key()).append(" returned null after ").append(i).append(" previous transformation(s).\n\nTransformation list:\n");
                    for (list = list.iterator(); list.hasNext(); bitmap.append(((Transformation)list.next()).key()).append('\n')) { }
                    Picasso.HANDLER.post(new Runnable(bitmap) {

                        final StringBuilder val$builder;

                        public void run()
                        {
                            throw new NullPointerException(builder.toString());
                        }

            
            {
                builder = stringbuilder;
                super();
            }
                    });
                    bitmap1 = null;
                }
                return bitmap1;
            }
            if (bitmap1 == bitmap && bitmap.isRecycled())
            {
                Picasso.HANDLER.post(new Runnable(transformation) {

                    final Transformation val$transformation;

                    public void run()
                    {
                        throw new IllegalStateException((new StringBuilder()).append("Transformation ").append(transformation.key()).append(" returned input Bitmap but recycled it.").toString());
                    }

            
            {
                transformation = transformation1;
                super();
            }
                });
                return null;
            }
            bitmap = bitmap1;
            i++;
        } while (true);
    }

    private Picasso.Priority computeNewPriority()
    {
        Picasso.Priority priority1 = Picasso.Priority.LOW;
        boolean flag;
        if (actions != null && !actions.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (actions == null && !flag)
        {
            return priority1;
        }
        if (action != null)
        {
            priority1 = action.getPriority();
        }
        Picasso.Priority priority2 = priority1;
        if (flag)
        {
            int i = 0;
            int j = actions.size();
            do
            {
                priority2 = priority1;
                if (i >= j)
                {
                    break;
                }
                Picasso.Priority priority3 = ((Action)actions.get(i)).getPriority();
                priority2 = priority1;
                if (priority3.ordinal() > priority1.ordinal())
                {
                    priority2 = priority3;
                }
                i++;
                priority1 = priority2;
            } while (true);
        }
        return priority2;
    }

    static BitmapHunter forRequest(Picasso picasso1, Dispatcher dispatcher1, Cache cache1, Cache cache2, Stats stats1, Action action1)
    {
        Request request = action1.getRequest();
        List list = picasso1.getRequestHandlers();
        int i = 0;
        for (int j = list.size(); i < j; i++)
        {
            RequestHandler requesthandler = (RequestHandler)list.get(i);
            if (requesthandler.canHandleRequest(request))
            {
                return new BitmapHunter(picasso1, dispatcher1, cache1, cache2, stats1, action1, requesthandler);
            }
        }

        return new BitmapHunter(picasso1, dispatcher1, cache1, cache2, stats1, action1, ERRORING_HANDLER);
    }

    static Bitmap transformResult(Request request, Bitmap bitmap, int i)
    {
        Object obj;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        boolean flag;
        boolean flag1;
        j2 = bitmap.getWidth();
        k2 = bitmap.getHeight();
        i1 = 0;
        flag = false;
        flag1 = false;
        l = 0;
        k = j2;
        j = k2;
        obj = new Matrix();
        j1 = i1;
        k1 = ((flag1) ? 1 : 0);
        l1 = k;
        i2 = j;
        if (!request.needsMatrixTransform()) goto _L2; else goto _L1
_L1:
        float f;
        int l2;
        int i3;
        boolean flag2;
        l2 = request.targetWidth;
        i3 = request.targetHeight;
        flag2 = request.resizeOnlyIfBigger;
        f = request.rotationDegrees;
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
        float f4 = (float)l2 / (float)j2;
        float f7 = (float)i3 / (float)k2;
        if (f4 > f7)
        {
            f = f4;
            j = (int)Math.ceil((float)k2 * (f7 / f4));
            l = (k2 - j) / 2;
            i1 = k;
            k = ((flag) ? 1 : 0);
        } else
        {
            f = f7;
            i1 = (int)Math.ceil((float)j2 * (f4 / f7));
            k = (j2 - i1) / 2;
        }
        if (!flag2) goto _L6; else goto _L5
_L5:
        j1 = k;
        k1 = l;
        l1 = i1;
        i2 = j;
        if (!flag2) goto _L2; else goto _L7
_L7:
        if (j2 > l2) goto _L6; else goto _L8
_L8:
        j1 = k;
        k1 = l;
        l1 = i1;
        i2 = j;
        if (k2 <= i3) goto _L2; else goto _L6
_L6:
        ((Matrix) (obj)).preScale(f, f);
        i2 = j;
        l1 = i1;
        k1 = l;
        j1 = k;
_L2:
        if (i != 0)
        {
            ((Matrix) (obj)).preRotate(i);
        }
        obj = Bitmap.createBitmap(bitmap, j1, k1, l1, i2, ((Matrix) (obj)), true);
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
            float f1 = (float)l2 / (float)j2;
            float f5 = (float)i3 / (float)k2;
            if (f1 >= f5)
            {
                f1 = f5;
            }
            if (flag2)
            {
                j1 = i1;
                k1 = ((flag1) ? 1 : 0);
                l1 = k;
                i2 = j;
                if (!flag2)
                {
                    continue; /* Loop/switch isn't completed */
                }
                if (j2 <= l2)
                {
                    j1 = i1;
                    k1 = ((flag1) ? 1 : 0);
                    l1 = k;
                    i2 = j;
                    if (k2 <= i3)
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                }
            }
            ((Matrix) (obj)).preScale(f1, f1);
            j1 = i1;
            k1 = ((flag1) ? 1 : 0);
            l1 = k;
            i2 = j;
            continue; /* Loop/switch isn't completed */
        }
        if (request.resizeByMaxSide && (l2 != j2 || i3 != k2))
        {
            float f2;
            if (j2 > k2)
            {
                f2 = (float)l2 / (float)j2;
            } else
            {
                f2 = (float)i3 / (float)k2;
            }
            if (flag2)
            {
                j1 = i1;
                k1 = ((flag1) ? 1 : 0);
                l1 = k;
                i2 = j;
                if (!flag2)
                {
                    continue; /* Loop/switch isn't completed */
                }
                j1 = i1;
                k1 = ((flag1) ? 1 : 0);
                l1 = k;
                i2 = j;
                if ((double)f2 >= 1.0D)
                {
                    continue; /* Loop/switch isn't completed */
                }
            }
            ((Matrix) (obj)).preScale(f2, f2);
            j1 = i1;
            k1 = ((flag1) ? 1 : 0);
            l1 = k;
            i2 = j;
            continue; /* Loop/switch isn't completed */
        }
        j1 = i1;
        k1 = ((flag1) ? 1 : 0);
        l1 = k;
        i2 = j;
        if (l2 == 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        j1 = i1;
        k1 = ((flag1) ? 1 : 0);
        l1 = k;
        i2 = j;
        if (i3 == 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (l2 == j2)
        {
            j1 = i1;
            k1 = ((flag1) ? 1 : 0);
            l1 = k;
            i2 = j;
            if (i3 == k2)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        float f3 = (float)l2 / (float)j2;
        float f6 = (float)i3 / (float)k2;
        if (flag2)
        {
            j1 = i1;
            k1 = ((flag1) ? 1 : 0);
            l1 = k;
            i2 = j;
            if (!flag2)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (j2 <= l2)
            {
                j1 = i1;
                k1 = ((flag1) ? 1 : 0);
                l1 = k;
                i2 = j;
                if (k2 <= i3)
                {
                    continue; /* Loop/switch isn't completed */
                }
            }
        }
        ((Matrix) (obj)).preScale(f3, f6);
        j1 = i1;
        k1 = ((flag1) ? 1 : 0);
        l1 = k;
        i2 = j;
        if (true) goto _L2; else goto _L9
_L9:
    }

    static void updateThreadName(Request request)
    {
        request = request.getName();
        StringBuilder stringbuilder = (StringBuilder)NAME_BUILDER.get();
        stringbuilder.ensureCapacity("Picasso-".length() + request.length());
        stringbuilder.replace("Picasso-".length(), stringbuilder.length(), request);
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
        throws IOException
    {
        Bitmap bitmap;
        Object obj;
        bitmap = null;
        if (isCancelled())
        {
            return null;
        }
        if (!skipMemoryCache)
        {
            Bitmap bitmap1 = cache.get(key);
            bitmap = bitmap1;
            if (bitmap1 != null)
            {
                stats.dispatchCacheHit();
                loadedFrom = Picasso.LoadedFrom.MEMORY;
                if (picasso.loggingEnabled)
                {
                    Utils.log("Hunter", "decoded", data.logId(), "from cache");
                }
                return bitmap1;
            }
        }
        if (diskCache != null)
        {
            Bitmap bitmap2 = diskCache.get(key);
            bitmap = bitmap2;
            if (bitmap2 != null)
            {
                stats.dispatchCacheHit();
                loadedFrom = Picasso.LoadedFrom.DISK_CACHE;
                return bitmap2;
            }
        }
        if (isCancelled())
        {
            return null;
        }
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
        if (isCancelled())
        {
            return null;
        }
        obj = bitmap;
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_410;
        }
        if (picasso.loggingEnabled)
        {
            Utils.log("Hunter", "decoded", data.logId());
        }
        stats.dispatchBitmapDecoded(bitmap);
        if (!data.needsTransformation())
        {
            obj = bitmap;
            if (exifRotation == 0)
            {
                break MISSING_BLOCK_LABEL_410;
            }
        }
        Object obj1 = DECODE_LOCK;
        obj1;
        JVM INSTR monitorenter ;
        if (data.needsMatrixTransform())
        {
            break MISSING_BLOCK_LABEL_292;
        }
        obj = bitmap;
        if (exifRotation == 0)
        {
            break MISSING_BLOCK_LABEL_335;
        }
        bitmap = transformResult(data, bitmap, exifRotation);
        obj = bitmap;
        if (!picasso.loggingEnabled)
        {
            break MISSING_BLOCK_LABEL_335;
        }
        Utils.log("Hunter", "transformed", data.logId());
        obj = bitmap;
        bitmap = ((Bitmap) (obj));
        if (!data.hasCustomTransformations())
        {
            break MISSING_BLOCK_LABEL_392;
        }
        obj = applyCustomTransformations(data.transformations, ((Bitmap) (obj)));
        bitmap = ((Bitmap) (obj));
        if (!picasso.loggingEnabled)
        {
            break MISSING_BLOCK_LABEL_392;
        }
        Utils.log("Hunter", "transformed", data.logId(), "from custom transformations");
        bitmap = ((Bitmap) (obj));
        obj1;
        JVM INSTR monitorexit ;
        obj = bitmap;
        if (bitmap != null)
        {
            stats.dispatchBitmapTransformed(bitmap);
            obj = bitmap;
        }
        return ((Bitmap) (obj));
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
        ((Exception) (obj)).printStackTrace();
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

}
