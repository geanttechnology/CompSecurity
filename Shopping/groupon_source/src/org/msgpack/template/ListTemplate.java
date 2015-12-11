// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.template;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.msgpack.MessageTypeException;
import org.msgpack.Packer;
import org.msgpack.Template;

// Referenced classes of package org.msgpack.template:
//            GenericTemplate1, TemplateRegistry, AnyTemplate

public class ListTemplate
    implements Template
{

    private Template elementTemplate;

    public ListTemplate(Template template)
    {
        elementTemplate = template;
    }

    static void load()
    {
    }

    public void pack(Packer packer, Object obj)
        throws IOException
    {
        if (!(obj instanceof List))
        {
            if (obj == null)
            {
                throw new MessageTypeException(new NullPointerException("target is null."));
            } else
            {
                throw new MessageTypeException((new StringBuilder()).append("target is not List type: ").append(obj.getClass()).toString());
            }
        }
        obj = (List)obj;
        packer.packArray(((List) (obj)).size());
        Object obj1;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); elementTemplate.pack(packer, obj1))
        {
            obj1 = ((Iterator) (obj)).next();
        }

    }

    static 
    {
        TemplateRegistry.registerGeneric(java/util/List, new GenericTemplate1(org/msgpack/template/ListTemplate));
        TemplateRegistry.register(java/util/List, new ListTemplate(AnyTemplate.getInstance()));
    }
}
