// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.object;

import java.io.IOException;
import org.msgpack.MessagePackObject;
import org.msgpack.Packer;

public class BooleanType extends MessagePackObject
{

    private boolean value;

    BooleanType(boolean flag)
    {
        value = flag;
    }

    public static BooleanType create(boolean flag)
    {
        return new BooleanType(flag);
    }

    public Object clone()
    {
        return new BooleanType(value);
    }

    public boolean equals(Object obj)
    {
        while (obj.getClass() != getClass() || ((BooleanType)obj).value != value) 
        {
            return false;
        }
        return true;
    }

    public int hashCode()
    {
        return !value ? 1237 : 1231;
    }

    public void messagePack(Packer packer)
        throws IOException
    {
        packer.packBoolean(value);
    }
}
