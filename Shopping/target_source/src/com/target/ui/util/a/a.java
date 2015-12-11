// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.a;

import com.target.mothership.model.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{

    private Object mKey;
    private boolean mLocked;
    private List mWaitingReceivers;

    public a()
    {
        mLocked = false;
        mKey = null;
    }

    private void c(Object obj)
        throws IllegalStateException
    {
        if (!mLocked)
        {
            throw new IllegalStateException("Cannot unlock because this is already unlocked.");
        }
        if (obj == null)
        {
            throw new IllegalStateException("null keys are not allowed");
        }
        if (mKey != obj)
        {
            throw new IllegalStateException((new StringBuilder()).append("Key rejected, object ").append(obj.toString()).append("is not equal to ").append(mKey.toString()).toString());
        } else
        {
            return;
        }
    }

    public void a(d d1)
        throws IllegalStateException
    {
        if (d1 == null)
        {
            throw new IllegalArgumentException("receiver must not be null");
        }
        if (d1.a() == null)
        {
            throw new IllegalArgumentException("receiver must have a non-null tag.  Did you remember to override getTag()?");
        }
        if (mLocked)
        {
            mWaitingReceivers.add(d1);
            return;
        } else
        {
            throw new IllegalStateException("Cannot wait for an unlocked RequestLock");
        }
    }

    public void a(Object obj)
        throws IllegalStateException
    {
        this;
        JVM INSTR monitorenter ;
        if (mLocked)
        {
            throw new IllegalStateException("Requests have already been locked.");
        }
        break MISSING_BLOCK_LABEL_24;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        throw new IllegalStateException("key may not be null");
        mWaitingReceivers = new ArrayList();
        mKey = obj;
        mLocked = true;
        this;
        JVM INSTR monitorexit ;
    }

    public void a(String s)
    {
        if (!mLocked)
        {
            throw new IllegalStateException("cannot cancel requests while unlocked");
        }
        Iterator iterator = mWaitingReceivers.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (((d)iterator.next()).a().equals(s))
            {
                iterator.remove();
            }
        } while (true);
    }

    public boolean a()
    {
        return mLocked;
    }

    public List b(Object obj)
        throws IllegalStateException
    {
        this;
        JVM INSTR monitorenter ;
        c(obj);
        mKey = null;
        mLocked = false;
        obj = mWaitingReceivers;
        mWaitingReceivers = null;
        this;
        JVM INSTR monitorexit ;
        return ((List) (obj));
        obj;
        throw obj;
    }
}
