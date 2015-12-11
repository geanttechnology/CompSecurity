// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.template;

import java.io.IOException;
import org.msgpack.Packer;
import org.msgpack.Template;

// Referenced classes of package org.msgpack.template:
//            ReflectionTemplateBuilder

static class template extends try
{

    private Template template;

    public void pack(Object obj, Packer packer)
        throws IOException
    {
        template.pack(packer, obj);
    }

    try(try try1, Template template1)
    {
        super(try1);
        template = template1;
    }
}
