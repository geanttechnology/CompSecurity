// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.template;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import org.msgpack.MessageTypeException;
import org.msgpack.Packer;
import org.msgpack.Template;

// Referenced classes of package org.msgpack.template:
//            GenericTemplate1, TemplateRegistry, AnyTemplate

public class CollectionTemplate
    implements Template
{

    private Template elementTemplate;

    public CollectionTemplate(Template template)
    {
        elementTemplate = template;
    }

    public static void load()
    {
    }

    public void pack(Packer packer, Object obj)
        throws IOException
    {
        if (!(obj instanceof Collection))
        {
            if (obj == null)
            {
                throw new MessageTypeException(new NullPointerException("target is null."));
            } else
            {
                throw new MessageTypeException((new StringBuilder()).append("target is not Collection type: ").append(obj.getClass()).toString());
            }
        }
        obj = (Collection)obj;
        packer.packArray(((Collection) (obj)).size());
        Object obj1;
        for (obj = ((Collection) (obj)).iterator(); ((Iterator) (obj)).hasNext(); elementTemplate.pack(packer, obj1))
        {
            obj1 = ((Iterator) (obj)).next();
        }

    }

    static 
    {
        TemplateRegistry.registerGeneric(java/util/Collection, new GenericTemplate1(org/msgpack/template/CollectionTemplate));
        TemplateRegistry.register(java/util/Collection, new CollectionTemplate(AnyTemplate.getInstance()));
    }
}
