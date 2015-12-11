// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.object;

import java.io.IOException;
import java.math.BigInteger;
import org.msgpack.Packer;

// Referenced classes of package org.msgpack.object:
//            IntegerType, ShortIntegerTypeIMPL, BigIntegerTypeIMPL

class LongIntegerTypeIMPL extends IntegerType
{

    private long value;

    LongIntegerTypeIMPL(long l)
    {
        value = l;
    }

    public BigInteger bigIntegerValue()
    {
        return BigInteger.valueOf(value);
    }

    public Object clone()
    {
        return new LongIntegerTypeIMPL(value);
    }

    public boolean equals(Object obj)
    {
        if (obj.getClass() == getClass()) goto _L2; else goto _L1
_L1:
        if (obj.getClass() != org/msgpack/object/ShortIntegerTypeIMPL) goto _L4; else goto _L3
_L3:
        if (value != ((ShortIntegerTypeIMPL)obj).longValue()) goto _L6; else goto _L5
_L5:
        return true;
_L6:
        return false;
_L4:
        if (obj.getClass() == org/msgpack/object/BigIntegerTypeIMPL)
        {
            return BigInteger.valueOf(value).equals(((BigIntegerTypeIMPL)obj).bigIntegerValue());
        } else
        {
            return false;
        }
_L2:
        if (((LongIntegerTypeIMPL)obj).value != value)
        {
            return false;
        }
        if (true) goto _L5; else goto _L7
_L7:
    }

    public int hashCode()
    {
        return (int)(value ^ value >>> 32);
    }

    public long longValue()
    {
        return value;
    }

    public void messagePack(Packer packer)
        throws IOException
    {
        packer.packLong(value);
    }
}
