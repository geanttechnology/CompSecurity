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

public class ShortArrayTemplate
    implements Template
{

    static final ShortArrayTemplate instance;

    private ShortArrayTemplate()
    {
    }

    public static ShortArrayTemplate getInstance()
    {
        return instance;
    }

    public void pack(Packer packer, Object obj)
        throws IOException
    {
        if (!(obj instanceof short[]))
        {
            throw new MessageTypeException();
        }
        obj = (short[])(short[])obj;
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
        instance = new ShortArrayTemplate();
        TemplateRegistry.register([S, instance);
    }
}
