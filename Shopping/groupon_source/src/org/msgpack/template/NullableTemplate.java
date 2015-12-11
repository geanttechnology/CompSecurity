// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.template;

import java.io.IOException;
import org.msgpack.Packer;
import org.msgpack.Template;

public class NullableTemplate
    implements Template
{

    private Template elementTemplate;

    static void load()
    {
    }

    public void pack(Packer packer, Object obj)
        throws IOException
    {
        if (obj == null)
        {
            packer.packNil();
            return;
        } else
        {
            elementTemplate.pack(packer, obj);
            return;
        }
    }
}
