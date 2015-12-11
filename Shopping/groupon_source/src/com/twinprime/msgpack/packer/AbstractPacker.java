// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.packer;

import com.twinprime.msgpack.MessagePack;
import com.twinprime.msgpack.template.Template;
import com.twinprime.msgpack.type.Value;
import java.io.IOException;
import java.math.BigInteger;

// Referenced classes of package com.twinprime.msgpack.packer:
//            Packer

public abstract class AbstractPacker
    implements Packer
{

    protected MessagePack msgpack;

    protected AbstractPacker(MessagePack messagepack)
    {
        msgpack = messagepack;
    }

    public void close()
        throws IOException
    {
    }

    public Packer write(double d)
        throws IOException
    {
        writeDouble(d);
        return this;
    }

    public Packer write(float f)
        throws IOException
    {
        writeFloat(f);
        return this;
    }

    public Packer write(long l)
        throws IOException
    {
        writeLong(l);
        return this;
    }

    public Packer write(Value value)
        throws IOException
    {
        if (value == null)
        {
            writeNil();
            return this;
        } else
        {
            value.writeTo(this);
            return this;
        }
    }

    public Packer write(Object obj)
        throws IOException
    {
        if (obj == null)
        {
            writeNil();
            return this;
        }
        if (obj instanceof Byte)
        {
            write(((Byte)obj).byteValue());
            return this;
        }
        if (obj instanceof Short)
        {
            write(((Short)obj).shortValue());
            return this;
        }
        if (obj instanceof Integer)
        {
            write(((Integer)obj).intValue());
            return this;
        }
        if (obj instanceof Long)
        {
            write(((Long)obj).longValue());
            return this;
        }
        if (obj instanceof Float)
        {
            write(((Float)obj).floatValue());
            return this;
        }
        if (obj instanceof Double)
        {
            write(((Double)obj).doubleValue());
            return this;
        }
        if (obj instanceof String)
        {
            write((String)obj);
            return this;
        } else
        {
            msgpack.lookup(obj.getClass()).write(this, obj);
            return this;
        }
    }

    public Packer write(String s)
        throws IOException
    {
        if (s == null)
        {
            writeNil();
            return this;
        } else
        {
            writeString(s);
            return this;
        }
    }

    public Packer write(BigInteger biginteger)
        throws IOException
    {
        if (biginteger == null)
        {
            writeNil();
            return this;
        } else
        {
            writeBigInteger(biginteger);
            return this;
        }
    }

    public Packer write(byte abyte0[])
        throws IOException
    {
        if (abyte0 == null)
        {
            writeNil();
            return this;
        } else
        {
            writeByteArray(abyte0);
            return this;
        }
    }

    public Packer writeArrayEnd()
        throws IOException
    {
        writeArrayEnd(true);
        return this;
    }

    protected abstract void writeBigInteger(BigInteger biginteger)
        throws IOException;

    protected void writeByteArray(byte abyte0[])
        throws IOException
    {
        writeByteArray(abyte0, 0, abyte0.length);
    }

    protected abstract void writeByteArray(byte abyte0[], int i, int j)
        throws IOException;

    protected abstract void writeDouble(double d)
        throws IOException;

    protected abstract void writeFloat(float f)
        throws IOException;

    protected abstract void writeLong(long l)
        throws IOException;

    public Packer writeMapEnd()
        throws IOException
    {
        writeMapEnd(true);
        return this;
    }

    protected abstract void writeString(String s)
        throws IOException;
}
