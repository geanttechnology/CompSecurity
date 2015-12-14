// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.store;


// Referenced classes of package com.amazon.gallery.framework.data.store:
//            CloudDriveAssetDiskEvictor

static class utilization
{

    private final int CLOUD_INDEX = 1;
    private final int DEVICE_INDEX = 0;
    private final int totalIndex = 2;
    private final long utilization[];

    public void decrement(boolean flag, long l)
    {
        this;
        JVM INSTR monitorenter ;
        if (!initialized(flag))
        {
            break MISSING_BLOCK_LABEL_85;
        }
        long al[];
        int i;
        long l1;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        l1 = l;
        if (utilization[i] < l)
        {
            l1 = utilization[i];
        }
        al = utilization;
        al[i] = al[i] - l1;
        al = utilization;
        i = totalIndex;
        al[i] = al[i] - l1;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public long get(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        long al[] = utilization;
        int i;
        long l;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        l = al[i];
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public void increment(boolean flag, long l)
    {
        this;
        JVM INSTR monitorenter ;
        long al[];
        if (!initialized(flag))
        {
            break MISSING_BLOCK_LABEL_59;
        }
        al = utilization;
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        al[i] = al[i] + l;
        al = utilization;
        i = totalIndex;
        al[i] = al[i] + l;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean initialized(boolean flag)
    {
        boolean flag1 = true;
        this;
        JVM INSTR monitorenter ;
        long al[] = utilization;
        int i;
        long l;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        l = al[i];
        if (l >= 0L)
        {
            flag = flag1;
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

    public void set(boolean flag, long l)
    {
        this;
        JVM INSTR monitorenter ;
        long al[];
        int i;
        long l1;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        l1 = utilization[i];
        utilization[i] = l;
        al = utilization;
        i = totalIndex;
        al[i] = al[i] + (l - l1);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public ()
    {
        utilization = new long[totalIndex + 1];
        for (int i = 0; i < utilization.length; i++)
        {
            utilization[i] = -1L;
        }

    }
}
