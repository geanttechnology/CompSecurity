// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;

import java.nio.Buffer;

// Referenced classes of package com.googlecode.javacpp:
//            Pointer

class val.b
    implements allocator
{

    Buffer bb;
    final Pointer this$0;
    final Buffer val$b;

    public void deallocate()
    {
        bb = null;
    }

    allocator()
    {
        this$0 = final_pointer;
        val$b = Buffer.this;
        super();
        bb = val$b;
    }
}
