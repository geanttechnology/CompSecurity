// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.template;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.msgpack.AbstractTemplate;
import org.msgpack.MessageTypeException;
import org.msgpack.Packer;

// Referenced classes of package org.msgpack.template:
//            ReflectionTemplateBuilder

static class reverse extends AbstractTemplate
{

    protected Enum entries[];
    protected Map reverse;

    public void pack(Packer packer, Object obj)
        throws IOException
    {
        obj = (Integer)reverse.get(obj);
        if (obj == null)
        {
            throw new MessageTypeException();
        } else
        {
            packer.pack(((Integer) (obj)).intValue());
            return;
        }
    }

    (Enum aenum[])
    {
        entries = aenum;
        reverse = new HashMap();
        for (int i = 0; i < aenum.length; i++)
        {
            reverse.put(aenum[i], Integer.valueOf(i));
        }

    }
}
