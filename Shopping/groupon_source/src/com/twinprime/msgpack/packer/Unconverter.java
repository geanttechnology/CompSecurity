// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.packer;

import com.twinprime.msgpack.MessagePack;
import com.twinprime.msgpack.MessageTypeException;
import com.twinprime.msgpack.type.Value;
import com.twinprime.msgpack.type.ValueFactory;
import java.io.IOException;
import java.math.BigInteger;

// Referenced classes of package com.twinprime.msgpack.packer:
//            AbstractPacker, PackerStack, Packer

public class Unconverter extends AbstractPacker
{

    private Value result;
    private PackerStack stack;
    private Object values[];

    public Unconverter()
    {
        this(new MessagePack());
    }

    public Unconverter(MessagePack messagepack)
    {
        super(messagepack);
        stack = new PackerStack();
        values = new Object[128];
    }

    private void put(Value value)
    {
        if (stack.getDepth() <= 0)
        {
            result = value;
            return;
        } else
        {
            stack.checkCount();
            Value avalue[] = (Value[])(Value[])values[stack.getDepth()];
            avalue[avalue.length - stack.getTopCount()] = value;
            stack.reduceCount();
            return;
        }
    }

    private void putContainer(Value value)
    {
        if (stack.getDepth() <= 0)
        {
            values[0] = value;
            return;
        } else
        {
            stack.checkCount();
            Value avalue[] = (Value[])(Value[])values[stack.getDepth()];
            avalue[avalue.length - stack.getTopCount()] = value;
            stack.reduceCount();
            return;
        }
    }

    public void close()
        throws IOException
    {
    }

    public void flush()
        throws IOException
    {
    }

    public Value getResult()
    {
        return result;
    }

    public void resetResult()
    {
        result = null;
    }

    public Packer write(Value value)
        throws IOException
    {
        put(value);
        return this;
    }

    public Packer writeArrayBegin(int i)
        throws IOException
    {
        if (i == 0)
        {
            putContainer(ValueFactory.createArrayValue());
            stack.pushArray(0);
            values[stack.getDepth()] = null;
            return this;
        } else
        {
            Value avalue[] = new Value[i];
            putContainer(ValueFactory.createArrayValue(avalue, true));
            stack.pushArray(i);
            values[stack.getDepth()] = avalue;
            return this;
        }
    }

    public Packer writeArrayEnd(boolean flag)
        throws IOException
    {
        if (!stack.topIsArray())
        {
            throw new MessageTypeException("writeArrayEnd() is called but writeArrayBegin() is not called");
        }
        int j = stack.getTopCount();
        if (j > 0)
        {
            if (flag)
            {
                throw new MessageTypeException("writeArrayEnd(check=true) is called but the array is not end");
            }
            for (int i = 0; i < j; i++)
            {
                writeNil();
            }

        }
        stack.pop();
        if (stack.getDepth() <= 0)
        {
            result = (Value)values[0];
        }
        return this;
    }

    public void writeBigInteger(BigInteger biginteger)
        throws IOException
    {
        put(ValueFactory.createIntegerValue(biginteger));
    }

    public void writeByteArray(byte abyte0[], int i, int j)
        throws IOException
    {
        put(ValueFactory.createRawValue(abyte0, i, j));
    }

    public void writeDouble(double d)
        throws IOException
    {
        put(ValueFactory.createFloatValue(d));
    }

    public void writeFloat(float f)
        throws IOException
    {
        put(ValueFactory.createFloatValue(f));
    }

    public void writeLong(long l)
        throws IOException
    {
        put(ValueFactory.createIntegerValue(l));
    }

    public Packer writeMapBegin(int i)
        throws IOException
    {
        stack.checkCount();
        if (i == 0)
        {
            putContainer(ValueFactory.createMapValue());
            stack.pushMap(0);
            values[stack.getDepth()] = null;
            return this;
        } else
        {
            Value avalue[] = new Value[i * 2];
            putContainer(ValueFactory.createMapValue(avalue, true));
            stack.pushMap(i);
            values[stack.getDepth()] = avalue;
            return this;
        }
    }

    public Packer writeMapEnd(boolean flag)
        throws IOException
    {
        if (!stack.topIsMap())
        {
            throw new MessageTypeException("writeMapEnd() is called but writeMapBegin() is not called");
        }
        int j = stack.getTopCount();
        if (j > 0)
        {
            if (flag)
            {
                throw new MessageTypeException("writeMapEnd(check=true) is called but the map is not end");
            }
            for (int i = 0; i < j; i++)
            {
                writeNil();
            }

        }
        stack.pop();
        if (stack.getDepth() <= 0)
        {
            result = (Value)values[0];
        }
        return this;
    }

    public Packer writeNil()
        throws IOException
    {
        put(ValueFactory.createNilValue());
        return this;
    }

    public void writeString(String s)
        throws IOException
    {
        put(ValueFactory.createRawValue(s));
    }
}
