// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.template;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.msgpack.MessageTypeException;
import org.msgpack.Packer;
import org.msgpack.Template;

// Referenced classes of package org.msgpack.template:
//            TemplateRegistry

public class ByteBufferTemplate
    implements Template
{

    static final ByteBufferTemplate instance;

    private ByteBufferTemplate()
    {
    }

    public static ByteBufferTemplate getInstance()
    {
        return instance;
    }

    public void pack(Packer packer, Object obj)
        throws IOException
    {
        try
        {
            packer.packByteBuffer((ByteBuffer)obj);
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
        instance = new ByteBufferTemplate();
        TemplateRegistry.register(java/nio/ByteBuffer, instance);
    }
}
