// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.template;

import java.io.IOException;
import org.msgpack.MessagePackObject;
import org.msgpack.Packer;
import org.msgpack.Template;

// Referenced classes of package org.msgpack.template:
//            TemplateRegistry

public class AnyTemplate
    implements Template
{

    static final AnyTemplate instance;

    private AnyTemplate()
    {
    }

    public static AnyTemplate getInstance()
    {
        return instance;
    }

    public void pack(Packer packer, Object obj)
        throws IOException
    {
        if (obj instanceof MessagePackObject)
        {
            packer.pack((MessagePackObject)obj);
            return;
        }
        if (obj == null)
        {
            packer.packNil();
            return;
        } else
        {
            TemplateRegistry.lookup(obj.getClass()).pack(packer, obj);
            return;
        }
    }

    static 
    {
        instance = new AnyTemplate();
        TemplateRegistry.register(org/msgpack/MessagePackObject, instance);
    }
}
