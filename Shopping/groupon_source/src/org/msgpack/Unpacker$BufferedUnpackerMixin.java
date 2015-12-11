// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package org.msgpack:
//            BufferedUnpackerImpl, Unpacker

final class this._cls0 extends BufferedUnpackerImpl
{

    final Unpacker this$0;

    boolean fill()
        throws IOException
    {
        if (stream != null)
        {
            reserveBuffer(bufferReserveSize);
            int i = stream.read(buffer, filled, buffer.length - filled);
            if (i > 0)
            {
                bufferConsumed(i);
                return true;
            }
        }
        return false;
    }

    ()
    {
        this$0 = Unpacker.this;
        super();
    }
}
