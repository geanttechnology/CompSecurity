// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.template;

import java.io.IOException;
import org.msgpack.AbstractTemplate;
import org.msgpack.Packer;
import org.msgpack.Template;

// Referenced classes of package org.msgpack.template:
//            ReflectionTemplateBuilder

static class componentTemplate extends AbstractTemplate
{

    private Class componentClass;
    private Template componentTemplate;

    Class getComponentClass()
    {
        return componentClass;
    }

    public void pack(Packer packer, Object obj)
        throws IOException
    {
        obj = ((Object) ((Object[])(Object[])obj));
        int j = obj.length;
        packer.packArray(j);
        for (int i = 0; i < j; i++)
        {
            componentTemplate.pack(packer, obj[i]);
        }

    }

    public (Class class1, Template template)
    {
        componentClass = class1;
        componentTemplate = template;
    }
}
