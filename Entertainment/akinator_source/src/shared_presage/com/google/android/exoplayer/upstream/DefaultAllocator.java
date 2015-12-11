// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.upstream;

import java.util.Arrays;
import shared_presage.com.google.android.exoplayer.util.Assertions;
import shared_presage.com.google.android.exoplayer.util.Util;

// Referenced classes of package shared_presage.com.google.android.exoplayer.upstream:
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
        int k = 0;
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
            for (; k < j; k++)
            {
                availableAllocations[k] = new Allocation(initialAllocationBlock, k * i);
            }

        } else
        {
            initialAllocationBlock = null;
        }
    }

    public final Allocation allocate()
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

    public final void blockWhileTotalBytesAllocatedExceeds(int i)
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

    public final int getIndividualAllocationLength()
    {
        return individualAllocationSize;
    }

    public final int getTotalBytesAllocated()
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

    public final void release(Allocation allocation)
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

    public final void trim(int i)
    {
        int j = 0;
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
        int l;
        if (initialAllocationBlock == null)
        {
            break MISSING_BLOCK_LABEL_164;
        }
        l = availableCount - 1;
        i = j;
        j = l;
_L4:
        if (i > j)
        {
            break; /* Loop/switch isn't completed */
        }
        Allocation allocation = availableAllocations[i];
        if (allocation.data == initialAllocationBlock)
        {
            i++;
            continue; /* Loop/switch isn't completed */
        }
        Allocation allocation1 = availableAllocations[i];
        if (allocation1.data != initialAllocationBlock)
        {
            j--;
            continue; /* Loop/switch isn't completed */
        }
        availableAllocations[i] = allocation1;
        availableAllocations[j] = allocation;
        j--;
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        i = Math.max(k, i);
        if (i >= availableCount)
        {
            continue; /* Loop/switch isn't completed */
        }
        Arrays.fill(availableAllocations, i, availableCount, null);
        availableCount = i;
        if (true) goto _L1; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }
}
