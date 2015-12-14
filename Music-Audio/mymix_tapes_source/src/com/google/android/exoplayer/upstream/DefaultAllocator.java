// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.upstream;

import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.Util;
import java.util.Arrays;

// Referenced classes of package com.google.android.exoplayer.upstream:
//            Allocator, Allocation

public final class DefaultAllocator
    implements Allocator
{

    private static final int AVAILABLE_EXTRA_CAPACITY = 100;
    private int allocatedCount;
    private Allocation availableAllocations[];
    private int availableCount;
    private final int individualAllocationSize;
    private final byte initialAllocationBlock[];

    public DefaultAllocator(int i)
    {
        this(i, 0);
    }

    public DefaultAllocator(int i, int j)
    {
        boolean flag1 = true;
        super();
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        if (j >= 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Assertions.checkArgument(flag);
        individualAllocationSize = i;
        availableCount = j;
        availableAllocations = new Allocation[j + 100];
        if (j > 0)
        {
            initialAllocationBlock = new byte[j * i];
            for (int k = 0; k < j; k++)
            {
                availableAllocations[k] = new Allocation(initialAllocationBlock, k * i);
            }

        } else
        {
            initialAllocationBlock = null;
        }
    }

    public Allocation allocate()
    {
        this;
        JVM INSTR monitorenter ;
        allocatedCount = allocatedCount + 1;
        if (availableCount <= 0) goto _L2; else goto _L1
_L1:
        Allocation aallocation[];
        int i;
        aallocation = availableAllocations;
        i = availableCount - 1;
        availableCount = i;
        Allocation allocation = aallocation[i];
        availableAllocations[availableCount] = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return allocation;
_L2:
        allocation = new Allocation(new byte[individualAllocationSize], 0);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void blockWhileTotalBytesAllocatedExceeds(int i)
        throws InterruptedException
    {
        this;
        JVM INSTR monitorenter ;
        for (; getTotalBytesAllocated() > i; wait()) { }
        break MISSING_BLOCK_LABEL_22;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    public int getIndividualAllocationLength()
    {
        return individualAllocationSize;
    }

    public int getTotalBytesAllocated()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        int j;
        i = allocatedCount;
        j = individualAllocationSize;
        this;
        JVM INSTR monitorexit ;
        return i * j;
        Exception exception;
        exception;
        throw exception;
    }

    public void release(Allocation allocation)
    {
        this;
        JVM INSTR monitorenter ;
        Allocation aallocation[];
        int i;
        boolean flag;
        if (allocation.data != initialAllocationBlock && allocation.data.length != individualAllocationSize)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        Assertions.checkArgument(flag);
        allocatedCount = allocatedCount - 1;
        if (availableCount == availableAllocations.length)
        {
            availableAllocations = (Allocation[])Arrays.copyOf(availableAllocations, availableAllocations.length * 2);
        }
        aallocation = availableAllocations;
        i = availableCount;
        availableCount = i + 1;
        aallocation[i] = allocation;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        allocation;
        throw allocation;
    }

    public void trim(int i)
    {
        this;
        JVM INSTR monitorenter ;
        int k;
        k = Math.max(0, Util.ceilDivide(i, individualAllocationSize) - allocatedCount);
        i = availableCount;
        if (k < i) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        i = k;
        if (initialAllocationBlock == null) goto _L4; else goto _L3
_L3:
        i = availableCount - 1;
        int j = 0;
_L5:
        if (j > i)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        Allocation allocation;
        allocation = availableAllocations[j];
        if (allocation.data != initialAllocationBlock)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        j++;
          goto _L5
        Allocation allocation1;
        allocation1 = availableAllocations[j];
        if (allocation1.data == initialAllocationBlock)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        i--;
          goto _L5
        Allocation aallocation1[] = availableAllocations;
        int l;
        l = j + 1;
        aallocation1[j] = allocation1;
        Allocation aallocation[] = availableAllocations;
        j = i - 1;
        aallocation[i] = allocation;
        i = j;
        j = l;
          goto _L5
        Exception exception;
        exception;
        throw exception;
        i = Math.max(k, j);
        if (i >= availableCount) goto _L1; else goto _L4
_L4:
        Arrays.fill(availableAllocations, i, availableCount, null);
        availableCount = i;
          goto _L1
    }
}
