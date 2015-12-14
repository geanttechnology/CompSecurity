// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;

// Referenced classes of package com.squareup.picasso:
//            Action, Transformation, Picasso, Request, 
//            ResourceBitmapHunter, ContactsPhotoBitmapHunter, MediaStoreBitmapHunter, ContentStreamBitmapHunter, 
//            AssetBitmapHunter, FileBitmapHunter, NetworkBitmapHunter, Utils, 
//            Cache, Stats, Dispatcher, StatsSnapshot, 
//            Downloader

abstract class BitmapHunter
    implements Runnable
{

    private static final Object DECODE_LOCK = new Object();
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
    Bitmap result;
    final boolean skipMemoryCache;
    final Stats stats;

    BitmapHunter(Picasso picasso1, Dispatcher dispatcher1, Cache cache1, Stats stats1, Action action1)
    {
        picasso = picasso1;
        dispatcher = dispatcher1;
        cache = cache1;
        stats = stats1;
        key = action1.getKey();
        data = action1.getRequest();
        skipMemoryCache = action1.skipCache;
        action = action1;
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
            if (bitmap1 != bitmap && !bitmap.isRecycled())
            {
                Picasso.HANDLER.post(new Runnable(transformation) {

                    final Transformation val$transformation;

                    public void run()
                    {
                        throw new IllegalStateException((new StringBuilder()).append("Transformation ").append(transformation.key()).append(" mutated input Bitmap but failed to recycle the original.").toString());
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

    static void calculateInSampleSize(int i, int j, int k, int l, android.graphics.BitmapFactory.Options options)
    {
        int i1 = 1;
        if (l > j || k > i)
        {
            i1 = Math.round((float)l / (float)j);
            i = Math.round((float)k / (float)i);
            if (i1 >= i)
            {
                i1 = i;
            }
        }
        options.inSampleSize = i1;
        options.inJustDecodeBounds = false;
    }

    static void calculateInSampleSize(int i, int j, android.graphics.BitmapFactory.Options options)
    {
        calculateInSampleSize(i, j, options.outWidth, options.outHeight, options);
    }

    static android.graphics.BitmapFactory.Options createBitmapOptions(Request request)
    {
        boolean flag1 = request.hasSize();
        android.graphics.BitmapFactory.Options options;
        boolean flag;
        if (request.config != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        options = null;
        if (flag1 || flag)
        {
            android.graphics.BitmapFactory.Options options1 = new android.graphics.BitmapFactory.Options();
            options1.inJustDecodeBounds = flag1;
            options = options1;
            if (flag)
            {
                options1.inPreferredConfig = request.config;
                options = options1;
            }
        }
        return options;
    }

    static BitmapHunter forRequest(Context context, Picasso picasso1, Dispatcher dispatcher1, Cache cache1, Stats stats1, Action action1, Downloader downloader)
    {
        if (action1.getRequest().resourceId != 0)
        {
            return new ResourceBitmapHunter(context, picasso1, dispatcher1, cache1, stats1, action1);
        }
        Uri uri = action1.getRequest().uri;
        String s = uri.getScheme();
        if ("content".equals(s))
        {
            if (android.provider.ContactsContract.Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && !uri.getPathSegments().contains("photo"))
            {
                return new ContactsPhotoBitmapHunter(context, picasso1, dispatcher1, cache1, stats1, action1);
            }
            if ("media".equals(uri.getAuthority()))
            {
                return new MediaStoreBitmapHunter(context, picasso1, dispatcher1, cache1, stats1, action1);
            } else
            {
                return new ContentStreamBitmapHunter(context, picasso1, dispatcher1, cache1, stats1, action1);
            }
        }
        if ("file".equals(s))
        {
            if (!uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0)))
            {
                return new AssetBitmapHunter(context, picasso1, dispatcher1, cache1, stats1, action1);
            } else
            {
                return new FileBitmapHunter(context, picasso1, dispatcher1, cache1, stats1, action1);
            }
        }
        if ("android.resource".equals(s))
        {
            return new ResourceBitmapHunter(context, picasso1, dispatcher1, cache1, stats1, action1);
        } else
        {
            return new NetworkBitmapHunter(picasso1, dispatcher1, cache1, stats1, action1, downloader);
        }
    }

    static boolean requiresInSampleSize(android.graphics.BitmapFactory.Options options)
    {
        return options != null && options.inJustDecodeBounds;
    }

    static Bitmap transformResult(Request request, Bitmap bitmap, int i)
    {
        float f;
        Object obj;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        int j2;
        int k2;
        boolean flag;
        if (i == 90 || i == 270)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (j != 0)
        {
            k = bitmap.getHeight();
        } else
        {
            k = bitmap.getWidth();
        }
        if (j != 0)
        {
            i1 = bitmap.getWidth();
        } else
        {
            i1 = bitmap.getHeight();
        }
        flag2 = false;
        flag = false;
        flag3 = false;
        flag1 = false;
        l = k;
        j = i1;
        obj = new Matrix();
        i2 = ((flag2) ? 1 : 0);
        l1 = ((flag3) ? 1 : 0);
        k1 = l;
        j1 = j;
        if (!request.needsMatrixTransform()) goto _L2; else goto _L1
_L1:
        j2 = request.targetWidth;
        k2 = request.targetHeight;
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
        float f2 = (float)j2 / (float)k;
        float f4 = (float)k2 / (float)i1;
        if (f2 > f4)
        {
            f = f2;
            j = (int)Math.ceil((float)i1 * (f4 / f2));
            k = (i1 - j) / 2;
            i1 = l;
            l = k;
            k = ((flag) ? 1 : 0);
        } else
        {
            f = f4;
            i1 = (int)Math.ceil((float)k * (f2 / f4));
            k = (k - i1) / 2;
            l = ((flag1) ? 1 : 0);
        }
        ((Matrix) (obj)).preScale(f, f);
        j1 = j;
        k1 = i1;
        l1 = l;
        i2 = k;
_L2:
        if (i != 0)
        {
            ((Matrix) (obj)).preRotate(i);
        }
        obj = Bitmap.createBitmap(bitmap, i2, l1, k1, j1, ((Matrix) (obj)), true);
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
            float f1 = (float)j2 / (float)k;
            float f3 = (float)k2 / (float)i1;
            if (f1 >= f3)
            {
                f1 = f3;
            }
            ((Matrix) (obj)).preScale(f1, f1);
            i2 = ((flag2) ? 1 : 0);
            l1 = ((flag3) ? 1 : 0);
            k1 = l;
            j1 = j;
            continue; /* Loop/switch isn't completed */
        }
        i2 = ((flag2) ? 1 : 0);
        l1 = ((flag3) ? 1 : 0);
        k1 = l;
        j1 = j;
        if (j2 == 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        i2 = ((flag2) ? 1 : 0);
        l1 = ((flag3) ? 1 : 0);
        k1 = l;
        j1 = j;
        if (k2 == 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (j2 == k)
        {
            i2 = ((flag2) ? 1 : 0);
            l1 = ((flag3) ? 1 : 0);
            k1 = l;
            j1 = j;
            if (k2 == i1)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        ((Matrix) (obj)).preScale((float)j2 / (float)k, (float)k2 / (float)i1);
        i2 = ((flag2) ? 1 : 0);
        l1 = ((flag3) ? 1 : 0);
        k1 = l;
        j1 = j;
        if (true) goto _L2; else goto _L5
_L5:
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

    abstract Bitmap decode(Request request)
        throws IOException;

    void detach(Action action1)
    {
        if (action != action1) goto _L2; else goto _L1
_L1:
        action = null;
_L4:
        if (picasso.loggingEnabled)
        {
            Utils.log("Hunter", "removed", action1.request.logId(), Utils.getLogIdsForHunter(this, "from "));
        }
        return;
_L2:
        if (actions != null)
        {
            actions.remove(action1);
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

    Bitmap getResult()
    {
        return result;
    }

    Bitmap hunt()
        throws IOException
    {
        Bitmap bitmap1;
        Bitmap bitmap2;
        if (!skipMemoryCache)
        {
            Bitmap bitmap = cache.get(key);
            if (bitmap != null)
            {
                stats.dispatchCacheHit();
                loadedFrom = Picasso.LoadedFrom.MEMORY;
                if (picasso.loggingEnabled)
                {
                    Utils.log("Hunter", "decoded", data.logId(), "from cache");
                }
                return bitmap;
            }
        }
        bitmap2 = decode(data);
        bitmap1 = bitmap2;
        if (bitmap2 == null)
        {
            break MISSING_BLOCK_LABEL_281;
        }
        if (picasso.loggingEnabled)
        {
            Utils.log("Hunter", "decoded", data.logId());
        }
        stats.dispatchBitmapDecoded(bitmap2);
        if (!data.needsTransformation())
        {
            bitmap1 = bitmap2;
            if (exifRotation == 0)
            {
                break MISSING_BLOCK_LABEL_281;
            }
        }
        Object obj = DECODE_LOCK;
        obj;
        JVM INSTR monitorenter ;
        if (data.needsMatrixTransform())
        {
            break MISSING_BLOCK_LABEL_163;
        }
        bitmap1 = bitmap2;
        if (exifRotation == 0)
        {
            break MISSING_BLOCK_LABEL_206;
        }
        bitmap2 = transformResult(data, bitmap2, exifRotation);
        bitmap1 = bitmap2;
        if (!picasso.loggingEnabled)
        {
            break MISSING_BLOCK_LABEL_206;
        }
        Utils.log("Hunter", "transformed", data.logId());
        bitmap1 = bitmap2;
        bitmap2 = bitmap1;
        if (!data.hasCustomTransformations())
        {
            break MISSING_BLOCK_LABEL_263;
        }
        bitmap1 = applyCustomTransformations(data.transformations, bitmap1);
        bitmap2 = bitmap1;
        if (!picasso.loggingEnabled)
        {
            break MISSING_BLOCK_LABEL_263;
        }
        Utils.log("Hunter", "transformed", data.logId(), "from custom transformations");
        bitmap2 = bitmap1;
        obj;
        JVM INSTR monitorexit ;
        bitmap1 = bitmap2;
        if (bitmap2 != null)
        {
            stats.dispatchBitmapTransformed(bitmap2);
            bitmap1 = bitmap2;
        }
        return bitmap1;
        Exception exception1;
        exception1;
        obj;
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

    protected void setExifRotation(int i)
    {
        exifRotation = i;
    }

    boolean shouldRetry(boolean flag, NetworkInfo networkinfo)
    {
        return false;
    }

    boolean shouldSkipMemoryCache()
    {
        return skipMemoryCache;
    }

    boolean supportsReplay()
    {
        return false;
    }

}
