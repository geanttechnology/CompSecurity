// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;

import java.io.UnsupportedEncodingException;
import java.util.Stack;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransport;

// Referenced classes of package org.apache.thrift.protocol:
//            TProtocol, TStruct, TField, TList, 
//            TMap, TProtocolException, TMessage, TSet, 
//            TProtocolFactory

public final class TCompactProtocol extends TProtocol
{
    public static class Factory
        implements TProtocolFactory
    {

        public TProtocol getProtocol(TTransport ttransport)
        {
            return new TCompactProtocol(ttransport);
        }

        public Factory()
        {
        }
    }


    private static final TStruct a = new TStruct("");
    private static final TField b = new TField("", (byte)0, (short)0);
    private static final byte c[];
    private Stack d;
    private short e;
    private TField f;
    private Boolean g;
    private byte h[];
    private byte i[];
    private byte j[];
    private byte k[];

    public TCompactProtocol(TTransport ttransport)
    {
        super(ttransport);
        d = new Stack();
        e = 0;
        f = null;
        g = null;
        h = new byte[5];
        i = new byte[10];
        j = new byte[1];
        k = new byte[1];
    }

    private long a()
        throws TException
    {
        int l = 0;
        long l1 = 0L;
        do
        {
            byte byte0 = readByte();
            l1 |= (long)(byte0 & 0x7f) << l;
            if ((byte0 & 0x80) == 128)
            {
                l += 7;
            } else
            {
                return l1;
            }
        } while (true);
    }

    private void a(byte byte0)
        throws TException
    {
        j[0] = byte0;
        trans_.write(j);
    }

    private void a(int l)
        throws TException
    {
        boolean flag = false;
        int i1 = l;
        l = ((flag) ? 1 : 0);
        do
        {
            if ((i1 & 0xffffff80) == 0)
            {
                h[l] = (byte)i1;
                trans_.write(h, 0, l + 1);
                return;
            }
            h[l] = (byte)(i1 & 0x7f | 0x80);
            i1 >>>= 7;
            l++;
        } while (true);
    }

    private void a(TField tfield, byte byte0)
        throws TException
    {
        byte byte1 = byte0;
        if (byte0 == -1)
        {
            byte byte2 = tfield.type;
            byte1 = c[byte2];
        }
        if (tfield.id > e && tfield.id - e <= 15)
        {
            a((byte)(tfield.id - e << 4 | byte1));
        } else
        {
            a(byte1);
            writeI16(tfield.id);
        }
        e = tfield.id;
    }

    private static byte b(byte byte0)
    {
        switch ((byte)(byte0 & 0xf))
        {
        default:
            throw new RuntimeException((new StringBuilder()).append("don't know what type: ").append((byte)(byte0 & 0xf)).toString());

        case 0: // '\0'
            return 0;

        case 1: // '\001'
        case 2: // '\002'
            return 2;

        case 3: // '\003'
            return 3;

        case 4: // '\004'
            return 6;

        case 5: // '\005'
            return 8;

        case 6: // '\006'
            return 10;

        case 7: // '\007'
            return 4;

        case 8: // '\b'
            return 11;

        case 9: // '\t'
            return 15;

        case 10: // '\n'
            return 14;

        case 11: // '\013'
            return 13;

        case 12: // '\f'
            return 12;
        }
    }

    private static int b(int l)
    {
        return l << 1 ^ l >> 31;
    }

    private static int c(int l)
    {
        return l >>> 1 ^ -(l & 1);
    }

    public final byte[] readBinary()
        throws TException
    {
        int l = (int)a();
        if (l == 0)
        {
            return new byte[0];
        } else
        {
            byte abyte0[] = new byte[l];
            trans_.readAll(abyte0, 0, l);
            return abyte0;
        }
    }

    public final boolean readBool()
        throws TException
    {
        boolean flag = true;
        if (g != null)
        {
            flag = g.booleanValue();
            g = null;
        } else
        if (readByte() != 1)
        {
            return false;
        }
        return flag;
    }

    public final byte readByte()
        throws TException
    {
        trans_.readAll(k, 0, 1);
        return k[0];
    }

    public final double readDouble()
        throws TException
    {
        byte abyte0[] = new byte[8];
        trans_.readAll(abyte0, 0, 8);
        long l = abyte0[7];
        long l1 = abyte0[6];
        long l2 = abyte0[5];
        long l3 = abyte0[4];
        long l4 = abyte0[3];
        long l5 = abyte0[2];
        long l6 = abyte0[1];
        return Double.longBitsToDouble((long)abyte0[0] & 255L | ((l & 255L) << 56 | (l1 & 255L) << 48 | (l2 & 255L) << 40 | (l3 & 255L) << 32 | (l4 & 255L) << 24 | (l5 & 255L) << 16 | (l6 & 255L) << 8));
    }

    public final TField readFieldBegin()
        throws TException
    {
        byte byte0 = readByte();
        if ((byte0 & 0xf) == 0)
        {
            return b;
        }
        short word1 = (short)((byte0 & 0xf0) >> 4);
        short word0;
        TField tfield;
        if (word1 == 0)
        {
            word0 = readI16();
        } else
        {
            word0 = (short)(word1 + e);
        }
        tfield = new TField("", b((byte)(byte0 & 0xf)), word0);
        if ((byte0 & 0xf) == 1 || (byte0 & 0xf) == 2)
        {
            word1 = 1;
        } else
        {
            word1 = 0;
        }
        if (word1 != 0)
        {
            Boolean boolean1;
            if ((byte)(byte0 & 0xf) == 1)
            {
                boolean1 = Boolean.TRUE;
            } else
            {
                boolean1 = Boolean.FALSE;
            }
            g = boolean1;
        }
        e = tfield.id;
        return tfield;
    }

    public final void readFieldEnd()
        throws TException
    {
    }

    public final short readI16()
        throws TException
    {
        return (short)c((int)a());
    }

    public final int readI32()
        throws TException
    {
        return c((int)a());
    }

    public final long readI64()
        throws TException
    {
        long l = a();
        return -(l & 1L) ^ l >>> 1;
    }

    public final TList readListBegin()
        throws TException
    {
        byte byte0 = readByte();
        int i1 = byte0 >> 4 & 0xf;
        int l = i1;
        if (i1 == 15)
        {
            l = (int)a();
        }
        return new TList(b(byte0), l);
    }

    public final void readListEnd()
        throws TException
    {
    }

    public final TMap readMapBegin()
        throws TException
    {
        int i1 = (int)a();
        int l;
        if (i1 == 0)
        {
            l = 0;
        } else
        {
            l = readByte();
        }
        return new TMap(b((byte)(l >> 4)), b((byte)(l & 0xf)), i1);
    }

    public final void readMapEnd()
        throws TException
    {
    }

    public final TMessage readMessageBegin()
        throws TException
    {
        int l = readByte();
        if (l != -126)
        {
            throw new TProtocolException((new StringBuilder()).append("Expected protocol id ").append(Integer.toHexString(-126)).append(" but got ").append(Integer.toHexString(l)).toString());
        }
        l = readByte();
        byte byte1 = (byte)(l & 0x1f);
        if (byte1 != 1)
        {
            throw new TProtocolException((new StringBuilder()).append("Expected version 1 but got ").append(byte1).toString());
        } else
        {
            byte byte0 = (byte)(l >> 5 & 3);
            l = (int)a();
            return new TMessage(readString(), byte0, l);
        }
    }

    public final void readMessageEnd()
        throws TException
    {
    }

    public final TSet readSetBegin()
        throws TException
    {
        return new TSet(readListBegin());
    }

    public final void readSetEnd()
        throws TException
    {
    }

    public final String readString()
        throws TException
    {
        String s;
        try
        {
            s = new String(readBinary(), "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new TException("UTF-8 not supported!");
        }
        return s;
    }

    public final TStruct readStructBegin()
        throws TException
    {
        d.push(Short.valueOf(e));
        e = 0;
        return a;
    }

    public final void readStructEnd()
        throws TException
    {
        e = ((Short)d.pop()).shortValue();
    }

    public final void writeBinary(byte abyte0[])
        throws TException
    {
        a(abyte0.length);
        trans_.write(abyte0);
    }

    public final void writeBool(boolean flag)
        throws TException
    {
        boolean flag1 = true;
        byte byte0 = 1;
        if (f != null)
        {
            TField tfield = f;
            if (!flag)
            {
                byte0 = 2;
            }
            a(tfield, byte0);
            f = null;
            return;
        }
        if (flag)
        {
            byte0 = flag1;
        } else
        {
            byte0 = 2;
        }
        a(byte0);
    }

    public final void writeByte(byte byte0)
        throws TException
    {
        a(byte0);
    }

    protected final void writeCollectionBegin(byte byte0, int l)
        throws TException
    {
        if (l <= 14)
        {
            a((byte)(l << 4 | c[byte0]));
            return;
        } else
        {
            a((byte)(c[byte0] | 0xf0));
            a(l);
            return;
        }
    }

    public final void writeDouble(double d1)
        throws TException
    {
        byte abyte0[] = new byte[8];
        byte[] _tmp = abyte0;
        abyte0[0] = 0;
        abyte0[1] = 0;
        abyte0[2] = 0;
        abyte0[3] = 0;
        abyte0[4] = 0;
        abyte0[5] = 0;
        abyte0[6] = 0;
        abyte0[7] = 0;
        long l = Double.doubleToLongBits(d1);
        abyte0[0] = (byte)(int)(l & 255L);
        abyte0[1] = (byte)(int)(l >> 8 & 255L);
        abyte0[2] = (byte)(int)(l >> 16 & 255L);
        abyte0[3] = (byte)(int)(l >> 24 & 255L);
        abyte0[4] = (byte)(int)(l >> 32 & 255L);
        abyte0[5] = (byte)(int)(l >> 40 & 255L);
        abyte0[6] = (byte)(int)(l >> 48 & 255L);
        abyte0[7] = (byte)(int)(l >> 56 & 255L);
        trans_.write(abyte0);
    }

    public final void writeFieldBegin(TField tfield)
        throws TException
    {
        if (tfield.type == 2)
        {
            f = tfield;
            return;
        } else
        {
            a(tfield, (byte)-1);
            return;
        }
    }

    public final void writeFieldEnd()
        throws TException
    {
    }

    public final void writeFieldStop()
        throws TException
    {
        a((byte)0);
    }

    public final void writeI16(short word0)
        throws TException
    {
        a(b(word0));
    }

    public final void writeI32(int l)
        throws TException
    {
        a(b(l));
    }

    public final void writeI64(long l)
        throws TException
    {
        l = l << 1 ^ l >> 63;
        int i1 = 0;
        do
        {
            if ((-128L & l) == 0L)
            {
                i[i1] = (byte)(int)l;
                trans_.write(i, 0, i1 + 1);
                return;
            }
            i[i1] = (byte)(int)(127L & l | 128L);
            l >>>= 7;
            i1++;
        } while (true);
    }

    public final void writeListBegin(TList tlist)
        throws TException
    {
        writeCollectionBegin(tlist.elemType, tlist.size);
    }

    public final void writeListEnd()
        throws TException
    {
    }

    public final void writeMapBegin(TMap tmap)
        throws TException
    {
        if (tmap.size == 0)
        {
            a((byte)0);
            return;
        } else
        {
            a(tmap.size);
            byte byte0 = tmap.keyType;
            byte0 = c[byte0];
            byte byte1 = tmap.valueType;
            a((byte)(byte0 << 4 | c[byte1]));
            return;
        }
    }

    public final void writeMapEnd()
        throws TException
    {
    }

    public final void writeMessageBegin(TMessage tmessage)
        throws TException
    {
        a((byte)-126);
        a((byte)(tmessage.type << 5 & 0xffffffe0 | 1));
        a(tmessage.seqid);
        writeString(tmessage.name);
    }

    public final void writeMessageEnd()
        throws TException
    {
    }

    public final void writeSetBegin(TSet tset)
        throws TException
    {
        writeCollectionBegin(tset.elemType, tset.size);
    }

    public final void writeSetEnd()
        throws TException
    {
    }

    public final void writeString(String s)
        throws TException
    {
        try
        {
            writeBinary(s.getBytes("UTF-8"));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new TException("UTF-8 not supported!");
        }
    }

    public final void writeStructBegin(TStruct tstruct)
        throws TException
    {
        d.push(Short.valueOf(e));
        e = 0;
    }

    public final void writeStructEnd()
        throws TException
    {
        e = ((Short)d.pop()).shortValue();
    }

    static 
    {
        byte abyte0[] = new byte[16];
        c = abyte0;
        abyte0[0] = 0;
        c[2] = 1;
        c[3] = 3;
        c[6] = 4;
        c[8] = 5;
        c[10] = 6;
        c[4] = 7;
        c[11] = 8;
        c[15] = 9;
        c[14] = 10;
        c[13] = 11;
        c[12] = 12;
    }
}
