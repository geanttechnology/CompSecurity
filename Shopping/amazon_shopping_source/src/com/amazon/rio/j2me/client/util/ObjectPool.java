// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.util;

import java.util.Stack;
import java.util.Vector;

// Referenced classes of package com.amazon.rio.j2me.client.util:
//            LifecycleException, LifecycleManager

public class ObjectPool
{

    private Vector active;
    private boolean closed;
    private int creationCnt;
    private boolean deactivated;
    private Stack free;
    private final int freeSizeLimt;
    private final LifecycleManager lifecycleManager;
    private int maxActiveCnt;
    private final String name;
    private final int totalSizeLimit;

    public ObjectPool(String s, LifecycleManager lifecyclemanager, int i, int j)
    {
        active = new Vector();
        free = new Stack();
        name = s;
        lifecycleManager = lifecyclemanager;
        freeSizeLimt = i;
        totalSizeLimit = j;
    }

    public Object acquireObject()
        throws LifecycleException
    {
        this;
        JVM INSTR monitorenter ;
        if (closed)
        {
            throw new IllegalStateException((new StringBuilder()).append("pool already closed: pool=").append(toString()).toString());
        }
        break MISSING_BLOCK_LABEL_44;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        Object obj;
        if (getFreeCnt() != 0)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        if (getActiveCnt() + getFreeCnt() >= totalSizeLimit)
        {
            throw new LifecycleException((new StringBuilder()).append("max allocation size exceeded: ").append(this).toString());
        }
        obj = lifecycleManager.createInstance();
        creationCnt = creationCnt + 1;
_L1:
        active.addElement(obj);
        if (active.size() > maxActiveCnt)
        {
            maxActiveCnt = active.size();
        }
        this;
        JVM INSTR monitorexit ;
        return obj;
        obj = free.pop();
          goto _L1
    }

    public void destroyObject(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        if (active == null || !active.removeElement(obj))
        {
            throw new IllegalStateException((new StringBuilder()).append("object not member of pool: pool=").append(toString()).append(" obj=").append(obj).toString());
        }
        break MISSING_BLOCK_LABEL_64;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        lifecycleManager.destroyInstance(obj);
        if (closed && active.size() == 0)
        {
            active = null;
        }
        this;
        JVM INSTR monitorexit ;
    }

    public final int getActiveCnt()
    {
        this;
        JVM INSTR monitorenter ;
        int i = active.size();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final int getFreeCnt()
    {
        this;
        JVM INSTR monitorenter ;
        int i = free.size();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final int getFreeSizeLimt()
    {
        this;
        JVM INSTR monitorenter ;
        int i = freeSizeLimt;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final int getTotalSizeLimit()
    {
        this;
        JVM INSTR monitorenter ;
        int i = totalSizeLimit;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public void releaseObject(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        if (!deactivated && !closed && free.size() < freeSizeLimt) goto _L2; else goto _L1
_L1:
        destroyObject(obj);
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!active.removeElement(obj))
        {
            throw new IllegalStateException((new StringBuilder()).append("object not member of pool: pool=").append(toString()).append(" obj=").append(obj).toString());
        }
        break MISSING_BLOCK_LABEL_93;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        free.push(obj);
          goto _L3
    }

    public String toString()
    {
        StringBuffer stringbuffer;
        stringbuffer = new StringBuffer();
        stringbuffer.append('[');
        stringbuffer.append((new StringBuilder()).append("name=").append(name).toString());
        this;
        JVM INSTR monitorenter ;
        stringbuffer.append((new StringBuilder()).append(", closed=").append(closed).toString());
        stringbuffer.append((new StringBuilder()).append(", activeCnt=").append(getActiveCnt()).toString());
        stringbuffer.append((new StringBuilder()).append(", freeCnt=").append(getFreeCnt()).toString());
        stringbuffer.append((new StringBuilder()).append(", maxActiveCnt=").append(maxActiveCnt).toString());
        stringbuffer.append((new StringBuilder()).append(", creationCnt=").append(creationCnt).toString());
        stringbuffer.append((new StringBuilder()).append(", freeSizeLimt=").append(getFreeSizeLimt()).toString());
        stringbuffer.append((new StringBuilder()).append(", totalSizeLimit=").append(getTotalSizeLimit()).toString());
        this;
        JVM INSTR monitorexit ;
        stringbuffer.append('}');
        return stringbuffer.toString();
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
