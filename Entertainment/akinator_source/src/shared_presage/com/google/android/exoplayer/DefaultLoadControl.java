// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer;

import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import shared_presage.com.google.android.exoplayer.upstream.Allocator;
import shared_presage.com.google.android.exoplayer.upstream.NetworkLock;

// Referenced classes of package shared_presage.com.google.android.exoplayer:
//            LoadControl, a

public final class DefaultLoadControl
    implements LoadControl
{
    public static interface EventListener
    {

        public abstract void onLoadingChanged(boolean flag);
    }

    private static final class a
    {

        public final int a;
        public int b;
        public boolean c;
        public long d;

        public a(int i)
        {
            a = i;
            b = 0;
            c = false;
            d = -1L;
        }
    }


    private static final int ABOVE_HIGH_WATERMARK = 0;
    private static final int BELOW_LOW_WATERMARK = 2;
    private static final int BETWEEN_WATERMARKS = 1;
    public static final float DEFAULT_HIGH_BUFFER_LOAD = 0.8F;
    public static final int DEFAULT_HIGH_WATERMARK_MS = 30000;
    public static final float DEFAULT_LOW_BUFFER_LOAD = 0.2F;
    public static final int DEFAULT_LOW_WATERMARK_MS = 15000;
    private final Allocator allocator;
    private int bufferState;
    private final Handler eventHandler;
    private final EventListener eventListener;
    private boolean fillingBuffers;
    private final float highBufferLoad;
    private final long highWatermarkUs;
    private final HashMap loaderStates;
    private final List loaders;
    private final float lowBufferLoad;
    private final long lowWatermarkUs;
    private long maxLoadStartPositionUs;
    private boolean streamingPrioritySet;
    private int targetBufferSize;

    public DefaultLoadControl(Allocator allocator1)
    {
        this(allocator1, null, null);
    }

    public DefaultLoadControl(Allocator allocator1, Handler handler, EventListener eventlistener)
    {
        this(allocator1, handler, eventlistener, 15000, 30000, 0.2F, 0.8F);
    }

    public DefaultLoadControl(Allocator allocator1, Handler handler, EventListener eventlistener, int i, int j, float f, float f1)
    {
        allocator = allocator1;
        eventHandler = handler;
        eventListener = eventlistener;
        loaders = new ArrayList();
        loaderStates = new HashMap();
        lowWatermarkUs = (long)i * 1000L;
        highWatermarkUs = (long)j * 1000L;
        lowBufferLoad = f;
        highBufferLoad = f1;
    }

    private int getBufferState(int i)
    {
        float f = (float)i / (float)targetBufferSize;
        if (f > highBufferLoad)
        {
            return 0;
        }
        return f >= lowBufferLoad ? 1 : 2;
    }

    private int getLoaderBufferState(long l, long l1)
    {
        if (l1 != -1L)
        {
            if ((l = l1 - l) <= highWatermarkUs)
            {
                return l >= lowWatermarkUs ? 1 : 2;
            }
        }
        return 0;
    }

    private void notifyLoadingChanged(boolean flag)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new shared_presage.com.google.android.exoplayer.a(this, flag));
        }
    }

    private void updateControlState()
    {
        boolean flag1;
        boolean flag2 = false;
        int j = bufferState;
        int i = 0;
        boolean flag = false;
        flag1 = false;
        while (i < loaders.size()) 
        {
            a a1 = (a)loaderStates.get(loaders.get(i));
            boolean flag3 = flag1 | a1.c;
            if (a1.d != -1L)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag |= flag1;
            j = Math.max(j, a1.b);
            i++;
            flag1 = flag3;
        }
        Object obj;
        long l;
        boolean flag4;
        if (!loaders.isEmpty() && (flag1 || flag) && (j == 2 || j == 1 && fillingBuffers))
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
        fillingBuffers = flag4;
        if (!fillingBuffers || streamingPrioritySet) goto _L2; else goto _L1
_L1:
        NetworkLock.instance.add(0);
        streamingPrioritySet = true;
        notifyLoadingChanged(true);
_L4:
        maxLoadStartPositionUs = -1L;
        if (fillingBuffers)
        {
            for (i = ((flag2) ? 1 : 0); i < loaders.size(); i++)
            {
                obj = loaders.get(i);
                l = ((a)loaderStates.get(obj)).d;
                if (l != -1L && (maxLoadStartPositionUs == -1L || l < maxLoadStartPositionUs))
                {
                    maxLoadStartPositionUs = l;
                }
            }

        }
        break; /* Loop/switch isn't completed */
_L2:
        if (!fillingBuffers && streamingPrioritySet && !flag1)
        {
            NetworkLock.instance.remove(0);
            streamingPrioritySet = false;
            notifyLoadingChanged(false);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final Allocator getAllocator()
    {
        return allocator;
    }

    public final void register(Object obj, int i)
    {
        loaders.add(obj);
        loaderStates.put(obj, new a(i));
        targetBufferSize = targetBufferSize + i;
    }

    public final void trimAllocator()
    {
        allocator.trim(targetBufferSize);
    }

    public final void unregister(Object obj)
    {
        loaders.remove(obj);
        obj = (a)loaderStates.remove(obj);
        targetBufferSize = targetBufferSize - ((a) (obj)).a;
        updateControlState();
    }

    public final boolean update(Object obj, long l, long l1, boolean flag)
    {
        int i = getLoaderBufferState(l, l1);
        obj = (a)loaderStates.get(obj);
        boolean flag1;
        boolean flag2;
        int j;
        int k;
        if (((a) (obj)).b != i || ((a) (obj)).d != l1 || ((a) (obj)).c != flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            obj.b = i;
            obj.d = l1;
            obj.c = flag;
        }
        j = allocator.getTotalBytesAllocated();
        k = getBufferState(j);
        if (bufferState != k)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag2)
        {
            bufferState = k;
        }
        if (flag1 || flag2)
        {
            updateControlState();
        }
        return j < targetBufferSize && l1 != -1L && l1 <= maxLoadStartPositionUs;
    }

}
