// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.template;

import java.io.IOException;
import org.msgpack.MessageTypeException;
import org.msgpack.Packer;
import org.msgpack.Template;

// Referenced classes of package org.msgpack.template:
//            TemplateRegistry

public class BooleanArrayTemplate
    implements Template
{

    static final BooleanArrayTemplate instance;

    private BooleanArrayTemplate()
    {
    }

    public static BooleanArrayTemplate getInstance()
    {
        return instance;
    }

    public void pack(Packer packer, Object obj)
        throws IOException
    {
        if (!(obj instanceof boolean[]))
        {
            throw new MessageTypeException();
        }
        obj = (boolean[])(boolean[])obj;
        int j;
        try
        {
            packer.packArray(obj.length);
        }
        // Misplaced declaration of an exception variable
        catch (Packer packer)
        {
            throw new MessageTypeException("target is null.", packer);
        }
        j = obj.length;
        for (int i = 0; i < j; i++)
        {
            packer.pack(obj[i]);
        }

    }

    static 
    {
        instance = new BooleanArrayTemplate();
        TemplateRegistry.register([Z, instance);
    }
}
