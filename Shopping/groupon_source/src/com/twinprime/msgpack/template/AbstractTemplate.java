// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.template;

import com.twinprime.msgpack.packer.Packer;
import java.io.IOException;

// Referenced classes of package com.twinprime.msgpack.template:
//            Template

public abstract class AbstractTemplate
    implements Template
{

    public AbstractTemplate()
    {
    }

    public void write(Packer packer, Object obj)
        throws IOException
    {
        write(packer, obj, false);
    }
}
