// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.type;

import com.twinprime.msgpack.packer.Packer;
import java.io.IOException;

// Referenced classes of package com.twinprime.msgpack.type:
//            Value, ValueType

public class NilValue
    implements Value
{

    private static NilValue instance = new NilValue();

    private NilValue()
    {
    }

    static NilValue getInstance()
    {
        return instance;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof Value))
            {
                return false;
            }
            if (((Value)obj).getType() != ValueType.NIL)
            {
                return false;
            }
        }
        return true;
    }

    public ValueType getType()
    {
        return ValueType.NIL;
    }

    public NilValue getValue()
    {
        return this;
    }

    public volatile Value getValue()
    {
        return getValue();
    }

    public int hashCode()
    {
        return 0;
    }

    public String toString()
    {
        return "null";
    }

    public StringBuilder toString(StringBuilder stringbuilder)
    {
        return stringbuilder.append("null");
    }

    public void writeTo(Packer packer)
        throws IOException
    {
        packer.writeNil();
    }

}
