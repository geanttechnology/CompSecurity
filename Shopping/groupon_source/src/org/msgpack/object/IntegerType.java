// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.object;

import java.math.BigInteger;
import org.msgpack.MessagePackObject;

// Referenced classes of package org.msgpack.object:
//            ShortIntegerTypeIMPL, LongIntegerTypeIMPL, BigIntegerTypeIMPL

public abstract class IntegerType extends MessagePackObject
{

    public IntegerType()
    {
    }

    public static IntegerType create(byte byte0)
    {
        return new ShortIntegerTypeIMPL(byte0);
    }

    public static IntegerType create(int i)
    {
        return new ShortIntegerTypeIMPL(i);
    }

    public static IntegerType create(long l)
    {
        return new LongIntegerTypeIMPL(l);
    }

    public static IntegerType create(BigInteger biginteger)
    {
        return new BigIntegerTypeIMPL(biginteger);
    }

    public static IntegerType create(short word0)
    {
        return new ShortIntegerTypeIMPL(word0);
    }
}
