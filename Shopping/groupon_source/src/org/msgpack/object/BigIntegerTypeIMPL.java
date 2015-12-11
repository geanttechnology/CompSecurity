// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.object;

import java.io.IOException;
import java.math.BigInteger;
import org.msgpack.Packer;

// Referenced classes of package org.msgpack.object:
//            IntegerType, ShortIntegerTypeIMPL, LongIntegerTypeIMPL

class BigIntegerTypeIMPL extends IntegerType
{

    private BigInteger value;

    BigIntegerTypeIMPL(BigInteger biginteger)
    {
        value = biginteger;
    }

    public BigInteger bigIntegerValue()
    {
        return value;
    }

    public Object clone()
    {
        return new BigIntegerTypeIMPL(value);
    }

    public boolean equals(Object obj)
    {
        if (obj.getClass() != getClass())
        {
            if (obj.getClass() == org/msgpack/object/ShortIntegerTypeIMPL)
            {
                return BigInteger.valueOf(((ShortIntegerTypeIMPL)obj).longValue()).equals(value);
            }
            if (obj.getClass() == org/msgpack/object/LongIntegerTypeIMPL)
            {
                return BigInteger.valueOf(((LongIntegerTypeIMPL)obj).longValue()).equals(value);
            } else
            {
                return false;
            }
        } else
        {
            return ((BigIntegerTypeIMPL)obj).value.equals(value);
        }
    }

    public int hashCode()
    {
        return value.hashCode();
    }

    public long longValue()
    {
        return value.longValue();
    }

    public void messagePack(Packer packer)
        throws IOException
    {
        packer.packBigInteger(value);
    }
}
