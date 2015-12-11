// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;


// Referenced classes of package com.googlecode.javacpp:
//            Pointer

class val.p
    implements allocator
{

    final Pointer this$0;
    final Pointer val$p;

    public void deallocate()
    {
        val$p.deallocate();
    }

    allocator()
    {
        this$0 = final_pointer;
        val$p = Pointer.this;
        super();
    }
}
