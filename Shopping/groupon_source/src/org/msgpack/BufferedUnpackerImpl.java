// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack;

import java.io.IOException;
import java.nio.ByteBuffer;

// Referenced classes of package org.msgpack:
//            UnpackerImpl, UnpackException, UnpackResult

abstract class BufferedUnpackerImpl extends UnpackerImpl
{

    byte buffer[];
    boolean bufferReferenced;
    private ByteBuffer castBuffer;
    int filled;
    int offset;

    BufferedUnpackerImpl()
    {
        offset = 0;
        filled = 0;
        buffer = null;
        bufferReferenced = false;
        castBuffer = ByteBuffer.allocate(8);
    }

    abstract boolean fill()
        throws IOException;

    final boolean next(UnpackResult unpackresult)
        throws IOException, UnpackException
    {
        if (filled != 0 || fill()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int i;
        i = super.execute(buffer, offset, filled);
        if (i > offset)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        if (!fill()) goto _L1; else goto _L3
_L3:
        if (super.isFinished())
        {
            MessagePackObject messagepackobject = super.getData();
            super.reset();
            unpackresult.done(messagepackobject);
            return true;
        }
          goto _L2
        offset = i;
          goto _L3
    }
}
