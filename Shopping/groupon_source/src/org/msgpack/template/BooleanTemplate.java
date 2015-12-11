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

public class BooleanTemplate
    implements Template
{

    static final BooleanTemplate instance;

    private BooleanTemplate()
    {
    }

    public static BooleanTemplate getInstance()
    {
        return instance;
    }

    public void pack(Packer packer, Object obj)
        throws IOException
    {
        try
        {
            packer.packBoolean(((Boolean)obj).booleanValue());
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
        instance = new BooleanTemplate();
        TemplateRegistry.register(java/lang/Boolean, instance);
        TemplateRegistry.register(Boolean.TYPE, instance);
    }
}
