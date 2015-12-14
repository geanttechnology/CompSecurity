// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Throwables;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.facebook.imagepipeline.memory:
//            PooledByteBuffer

public abstract class PooledByteBufferOutputStream extends OutputStream
{

    public PooledByteBufferOutputStream()
    {
    }

    public void close()
    {
        try
        {
            super.close();
            return;
        }
        catch (IOException ioexception)
        {
            Throwables.propagate(ioexception);
        }
    }

    public abstract int size();

    public abstract PooledByteBuffer toByteBuffer();
}
