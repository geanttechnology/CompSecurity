// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;

import java.lang.ref.PhantomReference;

// Referenced classes of package com.googlecode.javacpp:
//            Pointer

private static class deallocator extends PhantomReference
{

    static next head = null;
    next deallocator;
    next next;
    next prev;

    final void add()
    {
        com/googlecode/javacpp/Pointer$DeallocatorReference;
        JVM INSTR monitorenter ;
        if (head != null)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        head = this;
_L2:
        com/googlecode/javacpp/Pointer$DeallocatorReference;
        JVM INSTR monitorexit ;
        return;
        next = head;
        deallocator deallocator1 = next;
        head = this;
        deallocator1.prev = this;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        com/googlecode/javacpp/Pointer$DeallocatorReference;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void clear()
    {
        super.clear();
        deallocator.e();
    }

    final void remove()
    {
        com/googlecode/javacpp/Pointer$DeallocatorReference;
        JVM INSTR monitorenter ;
        if (prev != this || next != this)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        com/googlecode/javacpp/Pointer$DeallocatorReference;
        JVM INSTR monitorexit ;
        return;
        if (prev != null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        head = next;
_L1:
        if (next != null)
        {
            next.prev = prev;
        }
        next = this;
        prev = this;
        com/googlecode/javacpp/Pointer$DeallocatorReference;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        com/googlecode/javacpp/Pointer$DeallocatorReference;
        JVM INSTR monitorexit ;
        throw exception;
        prev.next = next;
          goto _L1
    }


    _cls9(Pointer pointer, _cls9 _pcls9)
    {
        super(pointer, Pointer.access$000());
        prev = null;
        next = null;
        deallocator = _pcls9;
    }
}
