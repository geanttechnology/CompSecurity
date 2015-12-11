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

public class FloatTemplate
    implements Template
{

    static final FloatTemplate instance;

    private FloatTemplate()
    {
    }

    public static FloatTemplate getInstance()
    {
        return instance;
    }

    public void pack(Packer packer, Object obj)
        throws IOException
    {
        try
        {
            packer.packFloat(((Float)obj).floatValue());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Packer packer)
        {
            throw new MessageTypeException("target is null.", packer);
        }
    }

    static 
    {
        instance = new FloatTemplate();
        TemplateRegistry.register(java/lang/Float, instance);
        TemplateRegistry.register(Float.TYPE, instance);
    }
}
