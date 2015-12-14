// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.memory;

import android.util.Log;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.soloader.SoLoaderShim;
import java.io.Closeable;

public class NativeMemoryChunk
    implements Closeable
{

    private static final String TAG = "NativeMemoryChunk";
    private boolean mClosed;
    private final long mNativePtr;
    private final int mSize;

    public NativeMemoryChunk()
    {
        mSize = 0;
        mNativePtr = 0L;
        mClosed = true;
    }

    public NativeMemoryChunk(int i)
    {
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        mSize = i;
        mNativePtr = nativeAllocate(mSize);
        mClosed = false;
    }

    private int adjustByteCount(int i, int j)
    {
        return Math.min(Math.max(0, mSize - i), j);
    }

    private void checkBounds(int i, int j, int k, int l)
    {
        boolean flag1 = true;
        boolean flag;
        if (l >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        if (i >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        if (k >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        if (i + l <= mSize)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        if (k + l <= j)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
    }

    private void doCopy(int i, NativeMemoryChunk nativememorychunk, int j, int k)
    {
        boolean flag1 = true;
        boolean flag;
        if (!isClosed())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag);
        if (!nativememorychunk.isClosed())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag);
        checkBounds(i, nativememorychunk.mSize, j, k);
        nativeMemcpy(nativememorychunk.mNativePtr + (long)j, mNativePtr + (long)i, k);
    }

    private static native long nativeAllocate(int i);

    private static native void nativeCopyFromByteArray(long l, byte abyte0[], int i, int j);

    private static native void nativeCopyToByteArray(long l, byte abyte0[], int i, int j);

    private static native void nativeFree(long l);

    private static native void nativeMemcpy(long l, long l1, int i);

    private static native byte nativeReadByte(long l);

    public void close()
    {
        this;
        JVM INSTR monitorenter ;
        if (!mClosed)
        {
            mClosed = true;
            nativeFree(mNativePtr);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void copy(int i, NativeMemoryChunk nativememorychunk, int j, int k)
    {
        Preconditions.checkNotNull(nativememorychunk);
        if (nativememorychunk.mNativePtr == mNativePtr)
        {
            Log.w("NativeMemoryChunk", (new StringBuilder()).append("Copying from NativeMemoryChunk ").append(Integer.toHexString(System.identityHashCode(this))).append(" to NativeMemoryChunk ").append(Integer.toHexString(System.identityHashCode(nativememorychunk))).append(" which share the same address ").append(Long.toHexString(mNativePtr)).toString());
            Preconditions.checkArgument(false);
        }
        if (nativememorychunk.mNativePtr >= mNativePtr)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        nativememorychunk;
        JVM INSTR monitorenter ;
        this;
        JVM INSTR monitorenter ;
        doCopy(i, nativememorychunk, j, k);
        this;
        JVM INSTR monitorexit ;
        nativememorychunk;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        exception;
        nativememorychunk;
        JVM INSTR monitorexit ;
        throw exception;
        this;
        JVM INSTR monitorenter ;
        nativememorychunk;
        JVM INSTR monitorenter ;
        doCopy(i, nativememorychunk, j, k);
        nativememorychunk;
        JVM INSTR monitorexit ;
        this;
        JVM INSTR monitorexit ;
        return;
        nativememorychunk;
        this;
        JVM INSTR monitorexit ;
        throw nativememorychunk;
        exception;
        nativememorychunk;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void finalize()
        throws Throwable
    {
        if (isClosed())
        {
            return;
        }
        Log.w("NativeMemoryChunk", (new StringBuilder()).append("finalize: Chunk ").append(Integer.toHexString(System.identityHashCode(this))).append(" still active. Underlying address = ").append(Long.toHexString(mNativePtr)).toString());
        close();
        super.finalize();
        return;
        Exception exception;
        exception;
        super.finalize();
        throw exception;
    }

    public long getNativePtr()
    {
        return mNativePtr;
    }

    public int getSize()
    {
        return mSize;
    }

    public boolean isClosed()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mClosed;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public byte read(int i)
    {
        boolean flag1 = true;
        this;
        JVM INSTR monitorenter ;
        byte byte0;
        boolean flag;
        if (!isClosed())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag);
        if (i >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        if (i < mSize)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        byte0 = nativeReadByte(mNativePtr + (long)i);
        this;
        JVM INSTR monitorexit ;
        return byte0;
        Exception exception;
        exception;
        throw exception;
    }

    public int read(int i, byte abyte0[], int j, int k)
    {
        this;
        JVM INSTR monitorenter ;
        Preconditions.checkNotNull(abyte0);
        boolean flag;
        if (!isClosed())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag);
        k = adjustByteCount(i, k);
        checkBounds(i, abyte0.length, j, k);
        nativeCopyToByteArray(mNativePtr + (long)i, abyte0, j, k);
        this;
        JVM INSTR monitorexit ;
        return k;
        abyte0;
        throw abyte0;
    }

    public int write(int i, byte abyte0[], int j, int k)
    {
        this;
        JVM INSTR monitorenter ;
        Preconditions.checkNotNull(abyte0);
        boolean flag;
        if (!isClosed())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag);
        k = adjustByteCount(i, k);
        checkBounds(i, abyte0.length, j, k);
        nativeCopyFromByteArray(mNativePtr + (long)i, abyte0, j, k);
        this;
        JVM INSTR monitorexit ;
        return k;
        abyte0;
        throw abyte0;
    }

    static 
    {
        SoLoaderShim.loadLibrary("memchunk");
    }
}
