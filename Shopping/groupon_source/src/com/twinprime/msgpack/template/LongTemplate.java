// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.template;

import com.twinprime.msgpack.MessageTypeException;
import com.twinprime.msgpack.packer.Packer;
import java.io.IOException;

// Referenced classes of package com.twinprime.msgpack.template:
//            AbstractTemplate

public class LongTemplate extends AbstractTemplate
{

    static final LongTemplate instance = new LongTemplate();

    private LongTemplate()
    {
    }

    public static LongTemplate getInstance()
    {
        return instance;
    }

    public void write(Packer packer, Long long1, boolean flag)
        throws IOException
    {
        if (long1 == null)
        {
            if (flag)
            {
                throw new MessageTypeException("Attempted to write null");
            } else
            {
                packer.writeNil();
                return;
            }
        } else
        {
            packer.write(long1.longValue());
            return;
        }
    }

    public volatile void write(Packer packer, Object obj, boolean flag)
        throws IOException
    {
        write(packer, (Long)obj, flag);
    }

}
