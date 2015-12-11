// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.template;

import com.twinprime.msgpack.MessageTypeException;
import com.twinprime.msgpack.packer.Packer;
import java.io.IOException;

// Referenced classes of package com.twinprime.msgpack.template:
//            AbstractTemplate

public class ShortTemplate extends AbstractTemplate
{

    static final ShortTemplate instance = new ShortTemplate();

    private ShortTemplate()
    {
    }

    public static ShortTemplate getInstance()
    {
        return instance;
    }

    public volatile void write(Packer packer, Object obj, boolean flag)
        throws IOException
    {
        write(packer, (Short)obj, flag);
    }

    public void write(Packer packer, Short short1, boolean flag)
        throws IOException
    {
        if (short1 == null)
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
            packer.write(short1);
            return;
        }
    }

}
