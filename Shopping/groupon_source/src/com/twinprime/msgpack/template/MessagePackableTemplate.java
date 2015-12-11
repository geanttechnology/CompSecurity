// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.template;

import com.twinprime.msgpack.MessagePackable;
import com.twinprime.msgpack.MessageTypeException;
import com.twinprime.msgpack.packer.Packer;
import java.io.IOException;

// Referenced classes of package com.twinprime.msgpack.template:
//            AbstractTemplate

public class MessagePackableTemplate extends AbstractTemplate
{

    private Class targetClass;

    MessagePackableTemplate(Class class1)
    {
        targetClass = class1;
    }

    public void write(Packer packer, MessagePackable messagepackable, boolean flag)
        throws IOException
    {
        if (messagepackable == null)
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
            messagepackable.writeTo(packer);
            return;
        }
    }

    public volatile void write(Packer packer, Object obj, boolean flag)
        throws IOException
    {
        write(packer, (MessagePackable)obj, flag);
    }
}
