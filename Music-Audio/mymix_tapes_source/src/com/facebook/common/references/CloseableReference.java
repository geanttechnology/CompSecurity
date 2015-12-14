// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.common.references;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.facebook.common.references:
//            SharedReference, ResourceReleaser

public final class CloseableReference
    implements Cloneable, Closeable
{

    private static final ResourceReleaser DEFAULT_CLOSEABLE_RELEASER = new _cls1();
    private static Class TAG = com/facebook/common/references/CloseableReference;
    private boolean mIsClosed;
    private final SharedReference mSharedReference;

    private CloseableReference(SharedReference sharedreference)
    {
        mIsClosed = false;
        mSharedReference = (SharedReference)Preconditions.checkNotNull(sharedreference);
        sharedreference.addReference();
    }

    private CloseableReference(Object obj, ResourceReleaser resourcereleaser)
    {
        mIsClosed = false;
        mSharedReference = new SharedReference(obj, resourcereleaser);
    }

    public static CloseableReference cloneOrNull(CloseableReference closeablereference)
    {
        if (closeablereference != null)
        {
            return closeablereference.cloneOrNull();
        } else
        {
            return null;
        }
    }

    public static List cloneOrNull(Collection collection)
    {
        if (collection != null) goto _L2; else goto _L1
_L1:
        collection = null;
_L4:
        return collection;
_L2:
        ArrayList arraylist = new ArrayList(collection.size());
        Iterator iterator = collection.iterator();
        do
        {
            collection = arraylist;
            if (!iterator.hasNext())
            {
                continue;
            }
            arraylist.add(cloneOrNull((CloseableReference)iterator.next()));
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void closeSafely(CloseableReference closeablereference)
    {
        if (closeablereference != null)
        {
            closeablereference.close();
        }
    }

    public static void closeSafely(Iterable iterable)
    {
        if (iterable != null)
        {
            for (iterable = iterable.iterator(); iterable.hasNext(); closeSafely((CloseableReference)iterable.next())) { }
        }
    }

    public static boolean isValid(CloseableReference closeablereference)
    {
        return closeablereference != null && closeablereference.isValid();
    }

    public static CloseableReference of(Closeable closeable)
    {
        if (closeable == null)
        {
            return null;
        } else
        {
            return new CloseableReference(closeable, DEFAULT_CLOSEABLE_RELEASER);
        }
    }

    public static CloseableReference of(Object obj, ResourceReleaser resourcereleaser)
    {
        if (obj == null)
        {
            return null;
        } else
        {
            return new CloseableReference(obj, resourcereleaser);
        }
    }

    public CloseableReference clone()
    {
        this;
        JVM INSTR monitorenter ;
        CloseableReference closeablereference;
        Preconditions.checkState(isValid());
        closeablereference = new CloseableReference(mSharedReference);
        this;
        JVM INSTR monitorexit ;
        return closeablereference;
        Exception exception;
        exception;
        throw exception;
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public CloseableReference cloneOrNull()
    {
        this;
        JVM INSTR monitorenter ;
        if (!isValid()) goto _L2; else goto _L1
_L1:
        CloseableReference closeablereference = new CloseableReference(mSharedReference);
_L4:
        this;
        JVM INSTR monitorexit ;
        return closeablereference;
_L2:
        closeablereference = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void close()
    {
        this;
        JVM INSTR monitorenter ;
        if (!mIsClosed)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        mIsClosed = true;
        this;
        JVM INSTR monitorexit ;
        mSharedReference.deleteReference();
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void finalize()
        throws Throwable
    {
        this;
        JVM INSTR monitorenter ;
        if (!mIsClosed)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        this;
        JVM INSTR monitorexit ;
        super.finalize();
        return;
        this;
        JVM INSTR monitorexit ;
        FLog.w(TAG, "Finalized without closing: %x %x (type = %s)", new Object[] {
            Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(mSharedReference)), mSharedReference.get().getClass().getSimpleName()
        });
        close();
        super.finalize();
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        exception;
        super.finalize();
        throw exception;
    }

    public Object get()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        boolean flag;
        if (!mIsClosed)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag);
        obj = mSharedReference.get();
        this;
        JVM INSTR monitorexit ;
        return obj;
        Exception exception;
        exception;
        throw exception;
    }

    public SharedReference getUnderlyingReferenceTestOnly()
    {
        this;
        JVM INSTR monitorenter ;
        SharedReference sharedreference = mSharedReference;
        this;
        JVM INSTR monitorexit ;
        return sharedreference;
        Exception exception;
        exception;
        throw exception;
    }

    public int getValueHash()
    {
        this;
        JVM INSTR monitorenter ;
        if (!isValid()) goto _L2; else goto _L1
_L1:
        int i = System.identityHashCode(mSharedReference.get());
_L4:
        this;
        JVM INSTR monitorexit ;
        return i;
_L2:
        i = 0;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isValid()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mIsClosed;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }


    /* member class not found */
    class _cls1 {}

}
