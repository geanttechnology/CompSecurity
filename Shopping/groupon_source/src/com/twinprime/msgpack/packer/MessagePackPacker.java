// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.packer;

import com.twinprime.msgpack.MessagePack;
import com.twinprime.msgpack.MessageTypeException;
import com.twinprime.msgpack.io.StreamOutput;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

// Referenced classes of package com.twinprime.msgpack.packer:
//            AbstractPacker, PackerStack, Packer

public class MessagePackPacker extends AbstractPacker
{

    protected final StreamOutput out;
    private PackerStack stack;

    protected MessagePackPacker(MessagePack messagepack, StreamOutput streamoutput)
    {
        super(messagepack);
        stack = new PackerStack();
        out = streamoutput;
    }

    public MessagePackPacker(MessagePack messagepack, OutputStream outputstream)
    {
        this(messagepack, new StreamOutput(outputstream));
    }

    public void close()
        throws IOException
    {
        out.close();
    }

    public void flush()
        throws IOException
    {
        out.flush();
    }

    public Packer writeArrayBegin(int i)
        throws IOException
    {
        if (i < 16)
        {
            out.writeByte((byte)(i | 0x90));
        } else
        if (i < 0x10000)
        {
            out.writeByte((byte)-36);
            out.writeShort((short)i);
        } else
        {
            out.writeByte((byte)-35);
            out.writeInt(i);
        }
        stack.reduceCount();
        stack.pushArray(i);
        return this;
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
                throw new MessageTypeException((new StringBuilder()).append("writeArrayEnd(check=true) is called but the array is not end: ").append(j).toString());
            }
            for (int i = 0; i < j; i++)
            {
                writeNil();
            }

        }
        stack.pop();
        return this;
    }

    protected void writeBigInteger(BigInteger biginteger)
        throws IOException
    {
        if (biginteger.bitLength() <= 63)
        {
            writeLong(biginteger.longValue());
            stack.reduceCount();
            return;
        }
        if (biginteger.bitLength() == 64 && biginteger.signum() == 1)
        {
            out.writeByte((byte)-49);
            out.writeLong(biginteger.longValue());
            stack.reduceCount();
            return;
        } else
        {
            throw new MessageTypeException("MessagePack can't serialize BigInteger larger than (2^64)-1");
        }
    }

    protected void writeByteArray(byte abyte0[], int i, int j)
        throws IOException
    {
        if (j < 32)
        {
            out.writeByte((byte)(j | 0xa0));
        } else
        if (j < 0x10000)
        {
            out.writeByte((byte)-38);
            out.writeShort((short)j);
        } else
        {
            out.writeByte((byte)-37);
            out.writeInt(j);
        }
        out.write(abyte0, i, j);
        stack.reduceCount();
    }

    protected void writeDouble(double d)
        throws IOException
    {
        out.writeByte((byte)-53);
        out.writeDouble(d);
        stack.reduceCount();
    }

    protected void writeFloat(float f)
        throws IOException
    {
        out.writeByte((byte)-54);
        out.writeFloat(f);
        stack.reduceCount();
    }

    protected void writeLong(long l)
        throws IOException
    {
        if (l < -32L)
        {
            if (l < -32768L)
            {
                if (l < 0xffffffff80000000L)
                {
                    out.writeByte((byte)-45);
                    out.writeLong(l);
                } else
                {
                    out.writeByte((byte)-46);
                    out.writeInt((int)l);
                }
            } else
            if (l < -128L)
            {
                out.writeByte((byte)-47);
                out.writeShort((short)(int)l);
            } else
            {
                out.writeByte((byte)-48);
                out.writeByte((byte)(int)l);
            }
        } else
        if (l < 128L)
        {
            out.writeByte((byte)(int)l);
        } else
        if (l < 0x10000L)
        {
            if (l < 256L)
            {
                out.writeByte((byte)-52);
                out.writeByte((byte)(int)l);
            } else
            {
                out.writeByte((byte)-51);
                out.writeShort((short)(int)l);
            }
        } else
        if (l < 0x100000000L)
        {
            out.writeByte((byte)-50);
            out.writeInt((int)l);
        } else
        {
            out.writeByte((byte)-49);
            out.writeLong(l);
        }
        stack.reduceCount();
    }

    public Packer writeMapBegin(int i)
        throws IOException
    {
        if (i < 16)
        {
            out.writeByte((byte)(i | 0x80));
        } else
        if (i < 0x10000)
        {
            out.writeByte((byte)-34);
            out.writeShort((short)i);
        } else
        {
            out.writeByte((byte)-33);
            out.writeInt(i);
        }
        stack.reduceCount();
        stack.pushMap(i);
        return this;
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
                throw new MessageTypeException((new StringBuilder()).append("writeMapEnd(check=true) is called but the map is not end: ").append(j).toString());
            }
            for (int i = 0; i < j; i++)
            {
                writeNil();
            }

        }
        stack.pop();
        return this;
    }

    public Packer writeNil()
        throws IOException
    {
        out.writeByte((byte)-64);
        stack.reduceCount();
        return this;
    }

    protected void writeString(String s)
        throws IOException
    {
        try
        {
            s = s.getBytes("UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new MessageTypeException(s);
        }
        writeByteArray(s, 0, s.length);
        stack.reduceCount();
    }
}
