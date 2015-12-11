// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.msgpack.template.TemplateRegistry;

// Referenced classes of package org.msgpack:
//            Template, MessagePackable, MessageTypeException

public class Packer
{

    protected byte castBytes[];
    protected OutputStream out;

    public Packer(OutputStream outputstream)
    {
        castBytes = new byte[9];
        out = outputstream;
    }

    public Packer pack(byte byte0)
        throws IOException
    {
        return packByte(byte0);
    }

    public Packer pack(double d)
        throws IOException
    {
        return packDouble(d);
    }

    public Packer pack(float f)
        throws IOException
    {
        return packFloat(f);
    }

    public Packer pack(int i)
        throws IOException
    {
        return packInt(i);
    }

    public Packer pack(long l)
        throws IOException
    {
        return packLong(l);
    }

    public Packer pack(Object obj)
        throws IOException
    {
        if (obj == null)
        {
            return packNil();
        } else
        {
            TemplateRegistry.lookup(obj.getClass()).pack(this, obj);
            return this;
        }
    }

    public Packer pack(String s)
        throws IOException
    {
        if (s == null)
        {
            return packNil();
        } else
        {
            return packString(s);
        }
    }

    public Packer pack(Map map)
        throws IOException
    {
        if (map != null) goto _L2; else goto _L1
_L1:
        map = packNil();
_L4:
        return map;
_L2:
        packMap(map.size());
        Iterator iterator = map.entrySet().iterator();
        do
        {
            map = this;
            if (!iterator.hasNext())
            {
                continue;
            }
            map = (java.util.Map.Entry)iterator.next();
            pack(map.getKey());
            pack(map.getValue());
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Packer pack(MessagePackable messagepackable)
        throws IOException
    {
        if (messagepackable == null)
        {
            return packNil();
        } else
        {
            messagepackable.messagePack(this);
            return this;
        }
    }

    public Packer pack(short word0)
        throws IOException
    {
        return packShort(word0);
    }

    public Packer pack(boolean flag)
        throws IOException
    {
        if (flag)
        {
            return packTrue();
        } else
        {
            return packFalse();
        }
    }

    public Packer packArray(int i)
        throws IOException
    {
        if (i < 16)
        {
            out.write((byte)(i | 0x90));
            return this;
        }
        if (i < 0x10000)
        {
            castBytes[0] = -36;
            castBytes[1] = (byte)(i >> 8);
            castBytes[2] = (byte)(i >> 0);
            out.write(castBytes, 0, 3);
            return this;
        } else
        {
            castBytes[0] = -35;
            castBytes[1] = (byte)(i >> 24);
            castBytes[2] = (byte)(i >> 16);
            castBytes[3] = (byte)(i >> 8);
            castBytes[4] = (byte)(i >> 0);
            out.write(castBytes, 0, 5);
            return this;
        }
    }

    public Packer packBigInteger(BigInteger biginteger)
        throws IOException
    {
        if (biginteger.bitLength() <= 63)
        {
            return packLong(biginteger.longValue());
        }
        if (biginteger.bitLength() <= 64 && biginteger.signum() >= 0)
        {
            castBytes[0] = -49;
            biginteger = biginteger.toByteArray();
            castBytes[1] = biginteger[biginteger.length - 8];
            castBytes[2] = biginteger[biginteger.length - 7];
            castBytes[3] = biginteger[biginteger.length - 6];
            castBytes[4] = biginteger[biginteger.length - 5];
            castBytes[5] = biginteger[biginteger.length - 4];
            castBytes[6] = biginteger[biginteger.length - 3];
            castBytes[7] = biginteger[biginteger.length - 2];
            castBytes[8] = biginteger[biginteger.length - 1];
            out.write(castBytes, 0, 9);
            return this;
        } else
        {
            throw new MessageTypeException("can't pack BigInteger larger than 0xffffffffffffffff");
        }
    }

    public Packer packBoolean(boolean flag)
        throws IOException
    {
        if (flag)
        {
            return packTrue();
        } else
        {
            return packFalse();
        }
    }

    public Packer packByte(byte byte0)
        throws IOException
    {
        if (byte0 < -32)
        {
            castBytes[0] = -48;
            castBytes[1] = byte0;
            out.write(castBytes, 0, 2);
            return this;
        } else
        {
            out.write(byte0);
            return this;
        }
    }

    public Packer packByteArray(byte abyte0[])
        throws IOException
    {
        packRaw(abyte0.length);
        return packRawBody(abyte0, 0, abyte0.length);
    }

    public Packer packByteBuffer(ByteBuffer bytebuffer)
        throws IOException
    {
        packRaw(bytebuffer.remaining());
        return packRawBody(bytebuffer.array(), bytebuffer.arrayOffset() + bytebuffer.position(), bytebuffer.remaining());
    }

    public Packer packDouble(double d)
        throws IOException
    {
        castBytes[0] = -53;
        long l = Double.doubleToRawLongBits(d);
        castBytes[1] = (byte)(int)(l >> 56);
        castBytes[2] = (byte)(int)(l >> 48);
        castBytes[3] = (byte)(int)(l >> 40);
        castBytes[4] = (byte)(int)(l >> 32);
        castBytes[5] = (byte)(int)(l >> 24);
        castBytes[6] = (byte)(int)(l >> 16);
        castBytes[7] = (byte)(int)(l >> 8);
        castBytes[8] = (byte)(int)(l >> 0);
        out.write(castBytes, 0, 9);
        return this;
    }

    public Packer packFalse()
        throws IOException
    {
        out.write(-62);
        return this;
    }

    public Packer packFloat(float f)
        throws IOException
    {
        castBytes[0] = -54;
        int i = Float.floatToRawIntBits(f);
        castBytes[1] = (byte)(i >> 24);
        castBytes[2] = (byte)(i >> 16);
        castBytes[3] = (byte)(i >> 8);
        castBytes[4] = (byte)(i >> 0);
        out.write(castBytes, 0, 5);
        return this;
    }

    public Packer packInt(int i)
        throws IOException
    {
        if (i < -32)
        {
            if (i < -32768)
            {
                castBytes[0] = -46;
                castBytes[1] = (byte)(i >> 24);
                castBytes[2] = (byte)(i >> 16);
                castBytes[3] = (byte)(i >> 8);
                castBytes[4] = (byte)(i >> 0);
                out.write(castBytes, 0, 5);
                return this;
            }
            if (i < -128)
            {
                castBytes[0] = -47;
                castBytes[1] = (byte)(i >> 8);
                castBytes[2] = (byte)(i >> 0);
                out.write(castBytes, 0, 3);
                return this;
            } else
            {
                castBytes[0] = -48;
                castBytes[1] = (byte)i;
                out.write(castBytes, 0, 2);
                return this;
            }
        }
        if (i < 128)
        {
            out.write((byte)i);
            return this;
        }
        if (i < 256)
        {
            castBytes[0] = -52;
            castBytes[1] = (byte)i;
            out.write(castBytes, 0, 2);
            return this;
        }
        if (i < 0x10000)
        {
            castBytes[0] = -51;
            castBytes[1] = (byte)(i >> 8);
            castBytes[2] = (byte)(i >> 0);
            out.write(castBytes, 0, 3);
            return this;
        } else
        {
            castBytes[0] = -50;
            castBytes[1] = (byte)(i >> 24);
            castBytes[2] = (byte)(i >> 16);
            castBytes[3] = (byte)(i >> 8);
            castBytes[4] = (byte)(i >> 0);
            out.write(castBytes, 0, 5);
            return this;
        }
    }

    public Packer packLong(long l)
        throws IOException
    {
        if (l < -32L)
        {
            if (l < -32768L)
            {
                if (l < 0xffffffff80000000L)
                {
                    castBytes[0] = -45;
                    castBytes[1] = (byte)(int)(l >> 56);
                    castBytes[2] = (byte)(int)(l >> 48);
                    castBytes[3] = (byte)(int)(l >> 40);
                    castBytes[4] = (byte)(int)(l >> 32);
                    castBytes[5] = (byte)(int)(l >> 24);
                    castBytes[6] = (byte)(int)(l >> 16);
                    castBytes[7] = (byte)(int)(l >> 8);
                    castBytes[8] = (byte)(int)(l >> 0);
                    out.write(castBytes, 0, 9);
                    return this;
                } else
                {
                    castBytes[0] = -46;
                    castBytes[1] = (byte)(int)(l >> 24);
                    castBytes[2] = (byte)(int)(l >> 16);
                    castBytes[3] = (byte)(int)(l >> 8);
                    castBytes[4] = (byte)(int)(l >> 0);
                    out.write(castBytes, 0, 5);
                    return this;
                }
            }
            if (l < -128L)
            {
                castBytes[0] = -47;
                castBytes[1] = (byte)(int)(l >> 8);
                castBytes[2] = (byte)(int)(l >> 0);
                out.write(castBytes, 0, 3);
                return this;
            } else
            {
                castBytes[0] = -48;
                castBytes[1] = (byte)(int)l;
                out.write(castBytes, 0, 2);
                return this;
            }
        }
        if (l < 128L)
        {
            out.write((byte)(int)l);
            return this;
        }
        if (l < 0x10000L)
        {
            if (l < 256L)
            {
                castBytes[0] = -52;
                castBytes[1] = (byte)(int)l;
                out.write(castBytes, 0, 2);
                return this;
            } else
            {
                castBytes[0] = -51;
                castBytes[1] = (byte)(int)((65280L & l) >> 8);
                castBytes[2] = (byte)(int)((255L & l) >> 0);
                out.write(castBytes, 0, 3);
                return this;
            }
        }
        if (l < 0x100000000L)
        {
            castBytes[0] = -50;
            castBytes[1] = (byte)(int)((0xffffffffff000000L & l) >> 24);
            castBytes[2] = (byte)(int)((0xff0000L & l) >> 16);
            castBytes[3] = (byte)(int)((65280L & l) >> 8);
            castBytes[4] = (byte)(int)((255L & l) >> 0);
            out.write(castBytes, 0, 5);
            return this;
        } else
        {
            castBytes[0] = -49;
            castBytes[1] = (byte)(int)(l >> 56);
            castBytes[2] = (byte)(int)(l >> 48);
            castBytes[3] = (byte)(int)(l >> 40);
            castBytes[4] = (byte)(int)(l >> 32);
            castBytes[5] = (byte)(int)(l >> 24);
            castBytes[6] = (byte)(int)(l >> 16);
            castBytes[7] = (byte)(int)(l >> 8);
            castBytes[8] = (byte)(int)(l >> 0);
            out.write(castBytes, 0, 9);
            return this;
        }
    }

    public Packer packMap(int i)
        throws IOException
    {
        if (i < 16)
        {
            out.write((byte)(i | 0x80));
            return this;
        }
        if (i < 0x10000)
        {
            castBytes[0] = -34;
            castBytes[1] = (byte)(i >> 8);
            castBytes[2] = (byte)(i >> 0);
            out.write(castBytes, 0, 3);
            return this;
        } else
        {
            castBytes[0] = -33;
            castBytes[1] = (byte)(i >> 24);
            castBytes[2] = (byte)(i >> 16);
            castBytes[3] = (byte)(i >> 8);
            castBytes[4] = (byte)(i >> 0);
            out.write(castBytes, 0, 5);
            return this;
        }
    }

    public Packer packNil()
        throws IOException
    {
        out.write(-64);
        return this;
    }

    public Packer packRaw(int i)
        throws IOException
    {
        if (i < 32)
        {
            out.write((byte)(i | 0xa0));
            return this;
        }
        if (i < 0x10000)
        {
            castBytes[0] = -38;
            castBytes[1] = (byte)(i >> 8);
            castBytes[2] = (byte)(i >> 0);
            out.write(castBytes, 0, 3);
            return this;
        } else
        {
            castBytes[0] = -37;
            castBytes[1] = (byte)(i >> 24);
            castBytes[2] = (byte)(i >> 16);
            castBytes[3] = (byte)(i >> 8);
            castBytes[4] = (byte)(i >> 0);
            out.write(castBytes, 0, 5);
            return this;
        }
    }

    public Packer packRawBody(byte abyte0[])
        throws IOException
    {
        out.write(abyte0);
        return this;
    }

    public Packer packRawBody(byte abyte0[], int i, int j)
        throws IOException
    {
        out.write(abyte0, i, j);
        return this;
    }

    public Packer packShort(short word0)
        throws IOException
    {
        if (word0 < -32)
        {
            if (word0 < -128)
            {
                castBytes[0] = -47;
                castBytes[1] = (byte)(word0 >> 8);
                castBytes[2] = (byte)(word0 >> 0);
                out.write(castBytes, 0, 3);
                return this;
            } else
            {
                castBytes[0] = -48;
                castBytes[1] = (byte)word0;
                out.write(castBytes, 0, 2);
                return this;
            }
        }
        if (word0 < 128)
        {
            out.write((byte)word0);
            return this;
        }
        if (word0 < 256)
        {
            castBytes[0] = -52;
            castBytes[1] = (byte)word0;
            out.write(castBytes, 0, 2);
            return this;
        } else
        {
            castBytes[0] = -51;
            castBytes[1] = (byte)(word0 >> 8);
            castBytes[2] = (byte)(word0 >> 0);
            out.write(castBytes, 0, 3);
            return this;
        }
    }

    public Packer packString(String s)
        throws IOException
    {
        s = s.getBytes("UTF-8");
        packRaw(s.length);
        return packRawBody(s);
    }

    public Packer packTrue()
        throws IOException
    {
        out.write(-61);
        return this;
    }
}
