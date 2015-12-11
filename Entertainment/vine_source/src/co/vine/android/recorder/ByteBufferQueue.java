// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import co.vine.android.util.CrashUtil;
import com.edisonwang.android.slog.SLog;
import com.googlecode.javacpp.BytePointer;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public class ByteBufferQueue
{
    public static interface MemoryResponder
    {

        public abstract void requestForMoreMemory();
    }

    public static class QueueItem
    {

        final byte bytes[];
        final Object tag;

        public QueueItem(byte abyte0[], Object obj)
        {
            bytes = abyte0;
            tag = obj;
        }
    }


    private static final ArrayList sQueues = new ArrayList();
    private final int LOCK[] = new int[0];
    private ByteBuffer mBuffer;
    private BytePointer mBufferPointer;
    private byte mGetBuffer[];
    private int mInitialCount;
    private boolean mPutHasEnded;
    private int mSpaceLeft;
    private int mStartIndex;
    private ArrayList mStarts;
    private ArrayList mTags;

    public ByteBufferQueue(int i, int j, MemoryResponder memoryresponder)
    {
        if (sQueues.size() > 20)
        {
            sQueues.clear();
        }
        sQueues.add(new WeakReference(this));
        int k = 0;
        Iterator iterator = sQueues.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (((WeakReference)iterator.next()).get() != null)
            {
                k++;
            }
        } while (true);
        CrashUtil.log("[mem] Current byte buffer queue count: {}.", new Object[] {
            Integer.valueOf(k)
        });
        if (SLog.sLogsOn)
        {
            Runtime runtime = Runtime.getRuntime();
            long l = (runtime.totalMemory() - runtime.freeMemory()) / 0x100000L;
            long l1 = runtime.maxMemory() / 0x100000L;
            SLog.d("[mem] Allocating: {}.", Long.valueOf((long)(j * i) / 0x100000L));
            SLog.d("[mem] Free: {}.", Long.valueOf(runtime.freeMemory() / 0x100000L));
            SLog.d("[mem] Used mem: {}.", Long.valueOf(l));
            SLog.d("[mem] Max mem: {}.", Long.valueOf(l1));
        }
        try
        {
            reset(i, j);
            return;
        }
        catch (OutOfMemoryError outofmemoryerror) { }
        if (memoryresponder != null)
        {
            memoryresponder.requestForMoreMemory();
        }
        System.gc();
        reset(i, j);
    }

    public void endOfPut()
    {
        mPutHasEnded = true;
    }

    protected void finalize()
        throws Throwable
    {
        super.finalize();
        release();
    }

    public QueueItem get()
    {
label0:
        {
            synchronized (LOCK)
            {
                if (mStartIndex != mStarts.size())
                {
                    break label0;
                }
            }
            return null;
        }
        Object obj;
        obj = (Integer)mStarts.get(mStartIndex);
        Object obj1 = ((WeakReference)mTags.get(mStartIndex)).get();
        mStartIndex = mStartIndex + 1;
        mSpaceLeft = mSpaceLeft + 1;
        int i = mBuffer.position();
        mBuffer.position(((Integer) (obj)).intValue());
        mBuffer.get(mGetBuffer);
        mBuffer.position(i);
        obj = new QueueItem(mGetBuffer, obj1);
        ai;
        JVM INSTR monitorexit ;
        return ((QueueItem) (obj));
        exception;
        ai;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isEndOfPut()
    {
        return mPutHasEnded;
    }

    public boolean isFresh()
    {
        return mStarts.size() == 0;
    }

    public boolean put(QueueItem queueitem)
    {
label0:
        {
            synchronized (LOCK)
            {
                mSpaceLeft = mSpaceLeft - 1;
                if (mSpaceLeft >= 0)
                {
                    break label0;
                }
            }
            return false;
        }
        mStarts.add(Integer.valueOf(mBuffer.position()));
        mTags.add(new WeakReference(queueitem.tag));
        mBuffer.put(queueitem.bytes);
        if (mBuffer.position() == mBuffer.limit())
        {
            mBuffer.position(0);
        }
        ai;
        JVM INSTR monitorexit ;
        return true;
        queueitem;
        ai;
        JVM INSTR monitorexit ;
        throw queueitem;
    }

    public void release()
    {
        mBuffer = null;
        if (mBufferPointer != null)
        {
            if (!mBufferPointer.isNull())
            {
                mBufferPointer.deallocate();
            }
            mBufferPointer = null;
        }
    }

    public void reset(int i, int j)
    {
        synchronized (LOCK)
        {
            mSpaceLeft = i;
            mInitialCount = i;
            if (mBuffer == null || mBuffer.capacity() < j * i)
            {
                release();
                mBufferPointer = new BytePointer(j * i);
                mBuffer = mBufferPointer.asByteBuffer();
                if (mBuffer == null)
                {
                    mBuffer = ByteBuffer.allocate(j * i);
                }
            }
            if (mGetBuffer == null || mGetBuffer.length != j)
            {
                mGetBuffer = new byte[j];
            }
            mBuffer.position(0);
            mStarts = new ArrayList();
            mTags = new ArrayList();
            mPutHasEnded = false;
            mStartIndex = 0;
        }
        return;
        exception;
        ai;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int size()
    {
        return mInitialCount - mSpaceLeft;
    }

}
