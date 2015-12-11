// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.object;

import java.io.IOException;
import java.util.Arrays;
import org.msgpack.MessagePackObject;
import org.msgpack.Packer;

public class RawType extends MessagePackObject
{

    private byte bytes[];

    RawType(byte abyte0[])
    {
        bytes = abyte0;
    }

    public static RawType create(byte abyte0[])
    {
        return new RawType(abyte0);
    }

    public Object clone()
    {
        return new RawType((byte[])(byte[])bytes.clone());
    }

    public boolean equals(Object obj)
    {
        if (obj.getClass() != getClass())
        {
            return false;
        } else
        {
            return Arrays.equals(((RawType)obj).bytes, bytes);
        }
    }

    public int hashCode()
    {
        return bytes.hashCode();
    }

    public void messagePack(Packer packer)
        throws IOException
    {
        packer.packRaw(bytes.length);
        packer.packRawBody(bytes);
    }
}
