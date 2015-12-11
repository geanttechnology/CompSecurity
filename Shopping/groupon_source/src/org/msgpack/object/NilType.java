// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.object;

import java.io.IOException;
import org.msgpack.MessagePackObject;
import org.msgpack.Packer;

public class NilType extends MessagePackObject
{

    private static final NilType INSTANCE = new NilType();

    private NilType()
    {
    }

    public static NilType create()
    {
        return INSTANCE;
    }

    public Object clone()
    {
        return INSTANCE;
    }

    public boolean equals(Object obj)
    {
        return obj.getClass() == getClass();
    }

    public int hashCode()
    {
        return 0;
    }

    public void messagePack(Packer packer)
        throws IOException
    {
        packer.packNil();
    }

}
