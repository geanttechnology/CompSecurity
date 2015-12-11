// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.template;

import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package org.msgpack.template:
//            ReflectionTemplateBuilder

static class dEntry extends dEntry
{

    public void pack(Object obj, Packer packer)
        throws IOException
    {
        packer.pack(((Integer)obj).intValue());
    }

    dEntry(dEntry dentry)
    {
        super(dentry);
    }
}
