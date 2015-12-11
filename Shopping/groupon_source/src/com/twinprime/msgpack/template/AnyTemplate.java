// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.template;

import com.twinprime.msgpack.MessageTypeException;
import com.twinprime.msgpack.packer.Packer;
import java.io.IOException;

// Referenced classes of package com.twinprime.msgpack.template:
//            AbstractTemplate, TemplateRegistry, Template

public class AnyTemplate extends AbstractTemplate
{

    private TemplateRegistry registry;

    public AnyTemplate(TemplateRegistry templateregistry)
    {
        registry = templateregistry;
    }

    public void write(Packer packer, Object obj, boolean flag)
        throws IOException
    {
        if (obj == null)
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
            registry.lookup(obj.getClass()).write(packer, obj);
            return;
        }
    }
}
