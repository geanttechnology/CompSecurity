// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;

import java.io.UnsupportedEncodingException;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransport;

// Referenced classes of package org.apache.thrift.protocol:
//            TProtocol, TStruct, TField, TList, 
//            TMap, TProtocolException, TMessage, TSet, 
//            TProtocolFactory

public class TBinaryProtocol extends TProtocol
{
    public static class Factory
        implements TProtocolFactory
    {

        protected boolean strictRead_;
        protected boolean strictWrite_;

        public TProtocol getProtocol(TTransport ttransport)
        {
            return new TBinaryProtocol(ttransport, strictRead_, strictWrite_);
        }

        public Factory()
        {
            this(false, true);
        }

        public Factory(boolean flag, boolean flag1)
        {
            strictRead_ = false;
            strictWrite_ = true;
            strictRead_ = flag;
            strictWrite_ = flag1;
        }
    }


    protected static final int VERSION_1 = 0x80010000;
    protected static final int VERSION_MASK = 0xffff0000;
    private static final TStruct a = new TStruct();
    private byte b[];
    private byte c[];
    protected boolean checkReadLength_;
    private byte d[];
    private byte e[];
    private byte f[];
    private byte g[];
    private byte h[];
    private byte i[];
    protected int readLength_;
    protected boolean strictRead_;
    protected boolean strictWrite_;

    public TBinaryProtocol(TTransport ttransport)
    {
        this(ttransport, false, true);
    }

    public TBinaryProtocol(TTransport ttransport, boolean flag, boolean flag1)
    {
        super(ttransport);
        strictRead_ = false;
        strictWrite_ = true;
        checkReadLength_ = false;
        b = new byte[1];
        c = new byte[2];
        d = new byte[4];
        e = new byte[8];
        f = new byte[1];
        g = new byte[2];
        h = new byte[4];
        i = new byte[8];
        strictRead_ = flag;
        strictWrite_ = flag1;
    }

    private int a(byte abyte0[], int j, int k)
        throws TException
    {
        checkReadLength(k);
        return trans_.readAll(abyte0, 0, k);
    }

    protected void checkReadLength(int j)
        throws TException
    {
        if (checkReadLength_)
        {
            readLength_ = readLength_ - j;
            if (readLength_ < 0)
            {
                throw new TException((new StringBuilder()).append("Message length exceeded: ").append(j).toString());
            }
        }
    }

    public byte[] readBinary()
        throws TException
    {
        int j = readI32();
        checkReadLength(j);
        byte abyte0[] = new byte[j];
        trans_.readAll(abyte0, 0, j);
        return abyte0;
    }

    public boolean readBool()
        throws TException
    {
        return readByte() == 1;
    }

    public byte readByte()
        throws TException
    {
        a(f, 0, 1);
        return f[0];
    }

    public double readDouble()
        throws TException
    {
        return Double.longBitsToDouble(readI64());
    }

    public TField readFieldBegin()
        throws TException
    {
        byte byte0 = readByte();
        short word0;
        if (byte0 == 0)
        {
            word0 = 0;
        } else
        {
            word0 = readI16();
        }
        return new TField("", byte0, word0);
    }

    public void readFieldEnd()
    {
    }

    public short readI16()
        throws TException
    {
        a(g, 0, 2);
        return (short)((g[0] & 0xff) << 8 | g[1] & 0xff);
    }

    public int readI32()
        throws TException
    {
        a(h, 0, 4);
        return (h[0] & 0xff) << 24 | (h[1] & 0xff) << 16 | (h[2] & 0xff) << 8 | h[3] & 0xff;
    }

    public long readI64()
        throws TException
    {
        a(i, 0, 8);
        return (long)(i[0] & 0xff) << 56 | (long)(i[1] & 0xff) << 48 | (long)(i[2] & 0xff) << 40 | (long)(i[3] & 0xff) << 32 | (long)(i[4] & 0xff) << 24 | (long)(i[5] & 0xff) << 16 | (long)(i[6] & 0xff) << 8 | (long)(i[7] & 0xff);
    }

    public TList readListBegin()
        throws TException
    {
        return new TList(readByte(), readI32());
    }

    public void readListEnd()
    {
    }

    public TMap readMapBegin()
        throws TException
    {
        return new TMap(readByte(), readByte(), readI32());
    }

    public void readMapEnd()
    {
    }

    public TMessage readMessageBegin()
        throws TException
    {
        int j = readI32();
        if (j < 0)
        {
            if ((0xffff0000 & j) != 0x80010000)
            {
                throw new TProtocolException(4, "Bad version in readMessageBegin");
            } else
            {
                return new TMessage(readString(), (byte)j, readI32());
            }
        }
        if (strictRead_)
        {
            throw new TProtocolException(4, "Missing version in readMessageBegin, old client?");
        } else
        {
            return new TMessage(readStringBody(j), readByte(), readI32());
        }
    }

    public void readMessageEnd()
    {
    }

    public TSet readSetBegin()
        throws TException
    {
        return new TSet(readByte(), readI32());
    }

    public void readSetEnd()
    {
    }

    public String readString()
        throws TException
    {
        return readStringBody(readI32());
    }

    public String readStringBody(int j)
        throws TException
    {
        String s;
        try
        {
            checkReadLength(j);
            byte abyte0[] = new byte[j];
            trans_.readAll(abyte0, 0, j);
            s = new String(abyte0, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
        return s;
    }

    public TStruct readStructBegin()
    {
        return a;
    }

    public void readStructEnd()
    {
    }

    public void setReadLength(int j)
    {
        readLength_ = j;
        checkReadLength_ = true;
    }

    public void writeBinary(byte abyte0[])
        throws TException
    {
        writeI32(abyte0.length);
        trans_.write(abyte0, 0, abyte0.length);
    }

    public void writeBool(boolean flag)
        throws TException
    {
        byte byte0;
        if (flag)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        writeByte(byte0);
    }

    public void writeByte(byte byte0)
        throws TException
    {
        b[0] = byte0;
        trans_.write(b, 0, 1);
    }

    public void writeDouble(double d1)
        throws TException
    {
        writeI64(Double.doubleToLongBits(d1));
    }

    public void writeFieldBegin(TField tfield)
        throws TException
    {
        writeByte(tfield.type);
        writeI16(tfield.id);
    }

    public void writeFieldEnd()
    {
    }

    public void writeFieldStop()
        throws TException
    {
        writeByte((byte)0);
    }

    public void writeI16(short word0)
        throws TException
    {
        c[0] = (byte)(word0 >> 8 & 0xff);
        c[1] = (byte)(word0 & 0xff);
        trans_.write(c, 0, 2);
    }

    public void writeI32(int j)
        throws TException
    {
        d[0] = (byte)(j >> 24 & 0xff);
        d[1] = (byte)(j >> 16 & 0xff);
        d[2] = (byte)(j >> 8 & 0xff);
        d[3] = (byte)(j & 0xff);
        trans_.write(d, 0, 4);
    }

    public void writeI64(long l)
        throws TException
    {
        e[0] = (byte)(int)(l >> 56 & 255L);
        e[1] = (byte)(int)(l >> 48 & 255L);
        e[2] = (byte)(int)(l >> 40 & 255L);
        e[3] = (byte)(int)(l >> 32 & 255L);
        e[4] = (byte)(int)(l >> 24 & 255L);
        e[5] = (byte)(int)(l >> 16 & 255L);
        e[6] = (byte)(int)(l >> 8 & 255L);
        e[7] = (byte)(int)(255L & l);
        trans_.write(e, 0, 8);
    }

    public void writeListBegin(TList tlist)
        throws TException
    {
        writeByte(tlist.elemType);
        writeI32(tlist.size);
    }

    public void writeListEnd()
    {
    }

    public void writeMapBegin(TMap tmap)
        throws TException
    {
        writeByte(tmap.keyType);
        writeByte(tmap.valueType);
        writeI32(tmap.size);
    }

    public void writeMapEnd()
    {
    }

    public void writeMessageBegin(TMessage tmessage)
        throws TException
    {
        if (strictWrite_)
        {
            writeI32(0x80010000 | tmessage.type);
            writeString(tmessage.name);
            writeI32(tmessage.seqid);
            return;
        } else
        {
            writeString(tmessage.name);
            writeByte(tmessage.type);
            writeI32(tmessage.seqid);
            return;
        }
    }

    public void writeMessageEnd()
    {
    }

    public void writeSetBegin(TSet tset)
        throws TException
    {
        writeByte(tset.elemType);
        writeI32(tset.size);
    }

    public void writeSetEnd()
    {
    }

    public void writeString(String s)
        throws TException
    {
        try
        {
            s = s.getBytes("UTF-8");
            writeI32(s.length);
            trans_.write(s, 0, s.length);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public void writeStructBegin(TStruct tstruct)
    {
    }

    public void writeStructEnd()
    {
    }

}
