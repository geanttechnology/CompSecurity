// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.message;

import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package org.apache.james.mime4j.message:
//            Body, Entity

public abstract class SingleBody
    implements Body
{

    private Entity parent;

    protected SingleBody()
    {
        parent = null;
    }

    public void setParent(Entity entity)
    {
        parent = entity;
    }

    public abstract void writeTo(OutputStream outputstream)
        throws IOException;
}
