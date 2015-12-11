// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.object;

import java.io.IOException;
import java.math.BigInteger;
import org.msgpack.Packer;

// Referenced classes of package org.msgpack.object:
//            IntegerType, LongIntegerTypeIMPL, BigIntegerTypeIMPL

class ShortIntegerTypeIMPL extends IntegerType
{

    private int value;

    ShortIntegerTypeIMPL(int i)
    {
        value = i;
    }

    public BigInteger bigIntegerValue()
    {
        return BigInteger.valueOf(value);
    }

    public Object clone()
    {
        return new ShortIntegerTypeIMPL(value);
    }

    public boolean equals(Object obj)
    {
        if (obj.getClass() == getClass()) goto _L2; else goto _L1
_L1:
        if (obj.getClass() != org/msgpack/object/LongIntegerTypeIMPL) goto _L4; else goto _L3
_L3:
        if ((long)value != ((LongIntegerTypeIMPL)obj).longValue()) goto _L6; else goto _L5
_L5:
        return true;
_L6:
        return false;
_L4:
        if (obj.getClass() == org/msgpack/object/BigIntegerTypeIMPL)
        {
            return ((BigIntegerTypeIMPL)obj).bigIntegerValue().equals(BigInteger.valueOf(value));
        } else
        {
            return false;
        }
_L2:
        if (((ShortIntegerTypeIMPL)obj).value != value)
        {
            return false;
        }
        if (true) goto _L5; else goto _L7
_L7:
    }

    public int hashCode()
    {
        return value;
    }

    public long longValue()
    {
        return (long)value;
    }

    public void messagePack(Packer packer)
        throws IOException
    {
        packer.packInt(value);
    }
}
