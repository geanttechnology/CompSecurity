// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.template;

import java.io.IOException;
import java.lang.reflect.Type;
import org.msgpack.MessageConvertable;
import org.msgpack.MessagePackable;
import org.msgpack.MessageTypeException;
import org.msgpack.MessageUnpackable;
import org.msgpack.Packer;
import org.msgpack.Template;

// Referenced classes of package org.msgpack.template:
//            TemplateRegistry

public class DefaultTemplate
    implements Template
{

    private Type lookupType;
    private boolean messageConvertable;
    private boolean messagePackable;
    private boolean messageUnpackable;
    private Class targetClass;

    public DefaultTemplate(Class class1)
    {
        this(class1, ((Type) (class1)));
    }

    public DefaultTemplate(Class class1, Type type)
    {
        targetClass = class1;
        lookupType = type;
        messagePackable = org/msgpack/MessagePackable.isAssignableFrom(class1);
        messageUnpackable = org/msgpack/MessageUnpackable.isAssignableFrom(class1);
        messageConvertable = org/msgpack/MessageConvertable.isAssignableFrom(class1);
    }

    public void pack(Packer packer, Object obj)
        throws IOException
    {
        if (messagePackable)
        {
            if (obj == null)
            {
                throw new MessageTypeException("target is null.");
            } else
            {
                ((MessagePackable)obj).messagePack(packer);
                return;
            }
        }
        Template template = TemplateRegistry.tryLookup(lookupType);
        if (template == this || template == null)
        {
            throw new MessageTypeException();
        } else
        {
            template.pack(packer, obj);
            return;
        }
    }
}
