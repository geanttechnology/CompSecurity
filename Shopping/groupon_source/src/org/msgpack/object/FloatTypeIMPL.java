// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.object;

import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package org.msgpack.object:
//            FloatType

class FloatTypeIMPL extends FloatType
{

    private float value;

    public FloatTypeIMPL(float f)
    {
        value = f;
    }

    public Object clone()
    {
        return new FloatTypeIMPL(value);
    }

    public boolean equals(Object obj)
    {
        while (obj.getClass() != getClass() || ((FloatTypeIMPL)obj).value != value) 
        {
            return false;
        }
        return true;
    }

    public int hashCode()
    {
        return Float.floatToIntBits(value);
    }

    public long longValue()
    {
        return (long)value;
    }

    public void messagePack(Packer packer)
        throws IOException
    {
        packer.packFloat(value);
    }
}
