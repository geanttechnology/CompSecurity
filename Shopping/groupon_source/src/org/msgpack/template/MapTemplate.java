// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.template;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.msgpack.MessageTypeException;
import org.msgpack.Packer;
import org.msgpack.Template;

// Referenced classes of package org.msgpack.template:
//            GenericTemplate2, TemplateRegistry, AnyTemplate

public class MapTemplate
    implements Template
{

    private Template keyTemplate;
    private Template valueTemplate;

    public MapTemplate(Template template, Template template1)
    {
        keyTemplate = template;
        valueTemplate = template1;
    }

    static void load()
    {
    }

    public void pack(Packer packer, Object obj)
        throws IOException
    {
        if (!(obj instanceof Map))
        {
            if (obj == null)
            {
                throw new MessageTypeException(new NullPointerException("target is null."));
            } else
            {
                throw new MessageTypeException((new StringBuilder()).append("target is not Map type: ").append(obj.getClass()).toString());
            }
        }
        obj = (Map)obj;
        packer.packMap(((Map) (obj)).size());
        java.util.Map.Entry entry;
        for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); valueTemplate.pack(packer, entry.getValue()))
        {
            entry = (java.util.Map.Entry)((Iterator) (obj)).next();
            keyTemplate.pack(packer, entry.getKey());
        }

    }

    static 
    {
        TemplateRegistry.registerGeneric(java/util/Map, new GenericTemplate2(org/msgpack/template/MapTemplate));
        TemplateRegistry.register(java/util/Map, new MapTemplate(AnyTemplate.getInstance(), AnyTemplate.getInstance()));
    }
}
