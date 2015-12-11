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

public class FloatArrayTemplate
    implements Template
{

    static final FloatArrayTemplate instance;

    private FloatArrayTemplate()
    {
    }

    public static FloatArrayTemplate getInstance()
    {
        return instance;
    }

    public void pack(Packer packer, Object obj)
        throws IOException
    {
        if (!(obj instanceof float[]))
        {
            throw new MessageTypeException();
        }
        obj = (float[])(float[])obj;
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
        instance = new FloatArrayTemplate();
        TemplateRegistry.register([F, instance);
    }
}
