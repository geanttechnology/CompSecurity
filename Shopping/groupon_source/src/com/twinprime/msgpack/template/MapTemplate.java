// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.template;

import com.twinprime.msgpack.MessageTypeException;
import com.twinprime.msgpack.packer.Packer;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.twinprime.msgpack.template:
//            AbstractTemplate, Template

public class MapTemplate extends AbstractTemplate
{

    private Template keyTemplate;
    private Template valueTemplate;

    public MapTemplate(Template template, Template template1)
    {
        keyTemplate = template;
        valueTemplate = template1;
    }

    public volatile void write(Packer packer, Object obj, boolean flag)
        throws IOException
    {
        write(packer, (Map)obj, flag);
    }

    public void write(Packer packer, Map map, boolean flag)
        throws IOException
    {
        if (!(map instanceof Map))
        {
            if (map == null)
            {
                if (flag)
                {
                    throw new MessageTypeException("Attempted to write null");
                } else
                {
                    packer.writeNil();
                    return;
                }
            } else
            {
                throw new MessageTypeException((new StringBuilder()).append("Target is not a Map but ").append(map.getClass()).toString());
            }
        }
        packer.writeMapBegin(map.size());
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); valueTemplate.write(packer, entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
            keyTemplate.write(packer, entry.getKey());
        }

        packer.writeMapEnd();
    }
}
