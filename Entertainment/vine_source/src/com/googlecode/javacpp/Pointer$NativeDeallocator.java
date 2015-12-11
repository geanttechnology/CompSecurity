// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;


// Referenced classes of package com.googlecode.javacpp:
//            Pointer

protected static class deallocatorAddress extends ce
    implements ce
{

    private long allocatedAddress;
    private long deallocatorAddress;

    private native void deallocate(long l, long l1);

    public void deallocate()
    {
        if (allocatedAddress != 0L && deallocatorAddress != 0L)
        {
            deallocate(allocatedAddress, deallocatorAddress);
            deallocatorAddress = 0L;
            allocatedAddress = 0L;
        }
    }

    ce(Pointer pointer, long l)
    {
        super(pointer, null);
        deallocator = this;
        allocatedAddress = pointer.address;
        deallocatorAddress = l;
    }
}
