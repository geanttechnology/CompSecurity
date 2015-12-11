// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;

import java.io.UnsupportedEncodingException;
import java.util.Stack;
import org.apache.thrift.TByteArrayOutputStream;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransport;

// Referenced classes of package org.apache.thrift.protocol:
//            TProtocol, TStruct, TProtocolException, a, 
//            TField, TList, TMap, TMessage, 
//            TSet, TProtocolFactory

public class TJSONProtocol extends TProtocol
{
    public static class Factory
        implements TProtocolFactory
    {

        public TProtocol getProtocol(TTransport ttransport)
        {
            return new TJSONProtocol(ttransport);
        }

        public Factory()
        {
        }
    }

    protected class JSONBaseContext
    {

        protected boolean escapeNum()
        {
            return false;
        }

        protected void read()
            throws TException
        {
        }

        protected void write()
            throws TException
        {
        }

        protected JSONBaseContext()
        {
        }
    }

    protected class JSONListContext extends JSONBaseContext
    {

        private boolean a;
        private TJSONProtocol b;

        protected void read()
            throws TException
        {
            if (a)
            {
                a = false;
                return;
            } else
            {
                b.readJSONSyntaxChar(TJSONProtocol.a());
                return;
            }
        }

        protected void write()
            throws TException
        {
            if (a)
            {
                a = false;
                return;
            } else
            {
                b.trans_.write(TJSONProtocol.a());
                return;
            }
        }

        protected JSONListContext()
        {
            b = TJSONProtocol.this;
            super();
            a = true;
        }
    }

    protected class JSONPairContext extends JSONBaseContext
    {

        private boolean a;
        private boolean b;
        private TJSONProtocol c;

        protected boolean escapeNum()
        {
            return b;
        }

        protected void read()
            throws TException
        {
            boolean flag;
            if (a)
            {
                a = false;
                flag = true;
            } else
            {
                TJSONProtocol tjsonprotocol = c;
                byte abyte0[];
                if (b)
                {
                    abyte0 = TJSONProtocol.b();
                } else
                {
                    abyte0 = TJSONProtocol.a();
                }
                tjsonprotocol.readJSONSyntaxChar(abyte0);
                if (!b)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            }
            b = flag;
        }

        protected void write()
            throws TException
        {
            boolean flag;
            if (a)
            {
                a = false;
                flag = true;
            } else
            {
                TTransport ttransport = c.trans_;
                byte abyte0[];
                if (b)
                {
                    abyte0 = TJSONProtocol.b();
                } else
                {
                    abyte0 = TJSONProtocol.a();
                }
                ttransport.write(abyte0);
                if (!b)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            }
            b = flag;
        }

        protected JSONPairContext()
        {
            c = TJSONProtocol.this;
            super();
            a = true;
            b = true;
        }
    }

    protected class LookaheadReader
    {

        private boolean a;
        private byte b[];
        private TJSONProtocol c;

        protected byte peek()
            throws TException
        {
            if (!a)
            {
                c.trans_.readAll(b, 0, 1);
            }
            a = true;
            return b[0];
        }

        protected byte read()
            throws TException
        {
            if (a)
            {
                a = false;
            } else
            {
                c.trans_.readAll(b, 0, 1);
            }
            return b[0];
        }

        protected LookaheadReader()
        {
            c = TJSONProtocol.this;
            super();
            b = new byte[1];
        }
    }


    private static final byte a[] = {
        44
    };
    private static final byte b[] = {
        58
    };
    private static final byte c[] = {
        123
    };
    private static final byte d[] = {
        125
    };
    private static final byte e[] = {
        91
    };
    private static final byte f[] = {
        93
    };
    private static final byte g[] = {
        34
    };
    private static final byte h[] = {
        92
    };
    private static final byte i[] = {
        48
    };
    private static final byte j[] = {
        92, 117, 48, 48
    };
    private static final byte k[] = {
        0, 0, 0, 0, 0, 0, 0, 0, 98, 116, 
        110, 0, 102, 114, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 1, 1, 34, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 1, 1, 1, 1
    };
    private static final byte l[] = {
        34, 92, 8, 12, 10, 13, 9
    };
    private static final byte m[] = {
        116, 102
    };
    private static final byte n[] = {
        105, 56
    };
    private static final byte o[] = {
        105, 49, 54
    };
    private static final byte p[] = {
        105, 51, 50
    };
    private static final byte q[] = {
        105, 54, 52
    };
    private static final byte r[] = {
        100, 98, 108
    };
    private static final byte s[] = {
        114, 101, 99
    };
    private static final byte t[] = {
        115, 116, 114
    };
    private static final byte u[] = {
        109, 97, 112
    };
    private static final byte v[] = {
        108, 115, 116
    };
    private static final byte w[] = {
        115, 101, 116
    };
    private static final TStruct x = new TStruct();
    private LookaheadReader A;
    private byte B[];
    private Stack y;
    private JSONBaseContext z;

    public TJSONProtocol(TTransport ttransport)
    {
        super(ttransport);
        y = new Stack();
        z = new JSONBaseContext();
        A = new LookaheadReader();
        B = new byte[4];
    }

    private static final byte a(byte abyte0[])
        throws TException
    {
        byte byte0;
        boolean flag;
        flag = false;
        byte0 = flag;
        if (abyte0.length <= 1) goto _L2; else goto _L1
_L1:
        abyte0[0];
        JVM INSTR lookupswitch 7: default 80
    //                   100: 97
    //                   105: 102
    //                   108: 180
    //                   109: 186
    //                   114: 192
    //                   115: 198
    //                   116: 228;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L10:
        break MISSING_BLOCK_LABEL_228;
_L3:
        byte0 = flag;
_L2:
        if (byte0 == 0)
        {
            throw new TProtocolException(5, "Unrecognized type");
        } else
        {
            return byte0;
        }
_L4:
        byte0 = 4;
          goto _L2
_L5:
        switch (abyte0[1])
        {
        case 50: // '2'
        case 52: // '4'
        case 53: // '5'
        case 55: // '7'
        default:
            byte0 = flag;
            break;

        case 49: // '1'
            byte0 = 6;
            break;

        case 56: // '8'
            byte0 = 3;
            break;

        case 51: // '3'
            byte0 = 8;
            break;

        case 54: // '6'
            byte0 = 10;
            break;
        }
        if (true) goto _L2; else goto _L11
_L11:
_L6:
        byte0 = 15;
          goto _L2
_L7:
        byte0 = 13;
          goto _L2
_L8:
        byte0 = 12;
          goto _L2
_L9:
        if (abyte0[1] == 116)
        {
            byte0 = 11;
        } else
        {
            byte0 = flag;
            if (abyte0[1] == 101)
            {
                byte0 = 14;
            }
        }
          goto _L2
        byte0 = 2;
          goto _L2
    }

    private TByteArrayOutputStream a(boolean flag)
        throws TException
    {
        TByteArrayOutputStream tbytearrayoutputstream = new TByteArrayOutputStream(16);
        if (!flag)
        {
            z.read();
        }
        readJSONSyntaxChar(g);
        do
        {
            byte byte0 = A.read();
            if (byte0 != g[0])
            {
                int i1 = byte0;
                if (byte0 == j[0])
                {
                    i1 = A.read();
                    if (i1 == j[1])
                    {
                        readJSONSyntaxChar(i);
                        readJSONSyntaxChar(i);
                        trans_.readAll(B, 0, 2);
                        i1 = (byte)((b(B[0]) << 4) + b(B[1]));
                    } else
                    {
                        i1 = "\"\\bfnrt".indexOf(i1);
                        if (i1 == -1)
                        {
                            throw new TProtocolException(1, "Expected control char");
                        }
                        i1 = l[i1];
                    }
                }
                tbytearrayoutputstream.write(i1);
            } else
            {
                return tbytearrayoutputstream;
            }
        } while (true);
    }

    private void a(long l1)
        throws TException
    {
        z.write();
        String s1 = Long.toString(l1);
        boolean flag = z.escapeNum();
        if (flag)
        {
            trans_.write(g);
        }
        try
        {
            byte abyte0[] = s1.getBytes("UTF-8");
            trans_.write(abyte0);
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
        if (flag)
        {
            trans_.write(g);
        }
    }

    private void a(JSONBaseContext jsonbasecontext)
    {
        y.push(z);
        z = jsonbasecontext;
    }

    static byte[] a()
    {
        return a;
    }

    private static final byte[] a(byte byte0)
        throws TException
    {
        switch (byte0)
        {
        case 5: // '\005'
        case 7: // '\007'
        case 9: // '\t'
        default:
            throw new TProtocolException(5, "Unrecognized type");

        case 2: // '\002'
            return m;

        case 3: // '\003'
            return n;

        case 6: // '\006'
            return o;

        case 8: // '\b'
            return p;

        case 10: // '\n'
            return q;

        case 4: // '\004'
            return r;

        case 11: // '\013'
            return t;

        case 12: // '\f'
            return s;

        case 13: // '\r'
            return u;

        case 14: // '\016'
            return w;

        case 15: // '\017'
            return v;
        }
    }

    private static final byte b(byte byte0)
        throws TException
    {
        if (byte0 >= 48 && byte0 <= 57)
        {
            return (byte)((char)byte0 - 48);
        }
        if (byte0 >= 97 && byte0 <= 102)
        {
            return (byte)((char)byte0 - 97);
        } else
        {
            throw new TProtocolException(1, "Expected hex character");
        }
    }

    private void b(byte abyte0[])
        throws TException
    {
        z.write();
        trans_.write(g);
        int j1 = abyte0.length;
        int i1 = 0;
        while (i1 < j1) 
        {
            if ((abyte0[i1] & 0xff) >= 48)
            {
                if (abyte0[i1] == h[0])
                {
                    trans_.write(h);
                    trans_.write(h);
                } else
                {
                    trans_.write(abyte0, i1, 1);
                }
            } else
            {
                B[0] = k[abyte0[i1]];
                if (B[0] == 1)
                {
                    trans_.write(abyte0, i1, 1);
                } else
                if (B[0] > 1)
                {
                    trans_.write(h);
                    trans_.write(B, 0, 1);
                } else
                {
                    trans_.write(j);
                    B[0] = c((byte)(abyte0[i1] >> 4));
                    B[1] = c(abyte0[i1]);
                    trans_.write(B, 0, 2);
                }
            }
            i1++;
        }
        trans_.write(g);
    }

    static byte[] b()
    {
        return b;
    }

    private static final byte c(byte byte0)
    {
        byte0 &= 0xf;
        if (byte0 < 10)
        {
            return (byte)((char)byte0 + 48);
        } else
        {
            return (byte)((char)byte0 + 97);
        }
    }

    private void c()
    {
        z = (JSONBaseContext)y.pop();
    }

    private void d()
        throws TException
    {
        z.write();
        trans_.write(c);
        a(new JSONPairContext());
    }

    private void e()
        throws TException
    {
        c();
        trans_.write(d);
    }

    private void f()
        throws TException
    {
        z.write();
        trans_.write(e);
        a(new JSONListContext());
    }

    private void g()
        throws TException
    {
        c();
        trans_.write(f);
    }

    private String h()
        throws TException
    {
        StringBuilder stringbuilder = new StringBuilder();
_L3:
        A.peek();
        JVM INSTR lookupswitch 15: default 144
    //                   43: 166
    //                   45: 166
    //                   46: 166
    //                   48: 166
    //                   49: 166
    //                   50: 166
    //                   51: 166
    //                   52: 166
    //                   53: 166
    //                   54: 166
    //                   55: 166
    //                   56: 166
    //                   57: 166
    //                   69: 166
    //                   101: 166;
           goto _L1 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2
_L1:
        boolean flag = false;
_L4:
        if (flag)
        {
            stringbuilder.append((char)A.read());
        } else
        {
            return stringbuilder.toString();
        }
        if (true) goto _L3; else goto _L2
_L2:
        flag = true;
          goto _L4
    }

    private long i()
        throws TException
    {
        z.read();
        if (z.escapeNum())
        {
            readJSONSyntaxChar(g);
        }
        String s1 = h();
        if (z.escapeNum())
        {
            readJSONSyntaxChar(g);
        }
        long l1;
        try
        {
            l1 = Long.valueOf(s1).longValue();
        }
        catch (NumberFormatException numberformatexception)
        {
            throw new TProtocolException(1, "Bad data encounted in numeric data");
        }
        return l1;
    }

    private double j()
        throws TException
    {
        double d1;
        z.read();
        if (A.peek() != g[0])
        {
            break MISSING_BLOCK_LABEL_97;
        }
        TByteArrayOutputStream tbytearrayoutputstream = a(true);
        double d2;
        try
        {
            d2 = Double.valueOf(tbytearrayoutputstream.toString("UTF-8")).doubleValue();
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
        d1 = d2;
        if (z.escapeNum())
        {
            break MISSING_BLOCK_LABEL_125;
        }
        d1 = d2;
        if (Double.isNaN(d2))
        {
            break MISSING_BLOCK_LABEL_125;
        }
        d1 = d2;
        if (!Double.isInfinite(d2))
        {
            throw new TProtocolException(1, "Numeric data unexpectedly quoted");
        }
        break MISSING_BLOCK_LABEL_125;
        if (z.escapeNum())
        {
            readJSONSyntaxChar(g);
        }
        try
        {
            d1 = Double.valueOf(h()).doubleValue();
        }
        catch (NumberFormatException numberformatexception)
        {
            throw new TProtocolException(1, "Bad data encounted in numeric data");
        }
        return d1;
    }

    private void k()
        throws TException
    {
        z.read();
        readJSONSyntaxChar(c);
        a(new JSONPairContext());
    }

    private void l()
        throws TException
    {
        readJSONSyntaxChar(d);
        c();
    }

    private void m()
        throws TException
    {
        z.read();
        readJSONSyntaxChar(e);
        a(new JSONListContext());
    }

    private void n()
        throws TException
    {
        readJSONSyntaxChar(f);
        c();
    }

    public byte[] readBinary()
        throws TException
    {
        TByteArrayOutputStream tbytearrayoutputstream = a(false);
        byte abyte0[] = tbytearrayoutputstream.get();
        int j1 = tbytearrayoutputstream.len();
        int k1 = 0;
        int i1;
        for (i1 = 0; j1 >= 4; i1 += 3)
        {
            org.apache.thrift.protocol.a.b(abyte0, k1, 4, abyte0, i1);
            k1 += 4;
            j1 -= 4;
        }

        int l1 = i1;
        if (j1 > 1)
        {
            org.apache.thrift.protocol.a.b(abyte0, k1, j1, abyte0, i1);
            l1 = i1 + (j1 - 1);
        }
        byte abyte1[] = new byte[l1];
        System.arraycopy(abyte0, 0, abyte1, 0, l1);
        return abyte1;
    }

    public boolean readBool()
        throws TException
    {
        return i() != 0L;
    }

    public byte readByte()
        throws TException
    {
        return (byte)(int)i();
    }

    public double readDouble()
        throws TException
    {
        return j();
    }

    public TField readFieldBegin()
        throws TException
    {
        short word0 = 0;
        byte byte0;
        if (A.peek() == d[0])
        {
            byte0 = 0;
        } else
        {
            word0 = (short)(int)i();
            k();
            byte0 = a(a(false).get());
        }
        return new TField("", byte0, word0);
    }

    public void readFieldEnd()
        throws TException
    {
        l();
    }

    public short readI16()
        throws TException
    {
        return (short)(int)i();
    }

    public int readI32()
        throws TException
    {
        return (int)i();
    }

    public long readI64()
        throws TException
    {
        return i();
    }

    protected void readJSONSyntaxChar(byte abyte0[])
        throws TException
    {
        byte byte0 = A.read();
        if (byte0 != abyte0[0])
        {
            throw new TProtocolException(1, (new StringBuilder()).append("Unexpected character:").append((char)byte0).toString());
        } else
        {
            return;
        }
    }

    public TList readListBegin()
        throws TException
    {
        m();
        return new TList(a(a(false).get()), (int)i());
    }

    public void readListEnd()
        throws TException
    {
        n();
    }

    public TMap readMapBegin()
        throws TException
    {
        m();
        byte byte0 = a(a(false).get());
        byte byte1 = a(a(false).get());
        int i1 = (int)i();
        k();
        return new TMap(byte0, byte1, i1);
    }

    public void readMapEnd()
        throws TException
    {
        l();
        n();
    }

    public TMessage readMessageBegin()
        throws TException
    {
        m();
        if (i() != 1L)
        {
            throw new TProtocolException(4, "Message contained bad version.");
        }
        String s1;
        try
        {
            s1 = a(false).toString("UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
        return new TMessage(s1, (byte)(int)i(), (int)i());
    }

    public void readMessageEnd()
        throws TException
    {
        n();
    }

    public TSet readSetBegin()
        throws TException
    {
        m();
        return new TSet(a(a(false).get()), (int)i());
    }

    public void readSetEnd()
        throws TException
    {
        n();
    }

    public String readString()
        throws TException
    {
        String s1;
        try
        {
            s1 = a(false).toString("UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
        return s1;
    }

    public TStruct readStructBegin()
        throws TException
    {
        k();
        return x;
    }

    public void readStructEnd()
        throws TException
    {
        l();
    }

    public void writeBinary(byte abyte0[])
        throws TException
    {
        z.write();
        trans_.write(g);
        int i1 = abyte0.length;
        int j1 = 0;
        for (; i1 >= 3; i1 -= 3)
        {
            org.apache.thrift.protocol.a.a(abyte0, j1, 3, B, 0);
            trans_.write(B, 0, 4);
            j1 += 3;
        }

        if (i1 > 0)
        {
            org.apache.thrift.protocol.a.a(abyte0, j1, i1, B, 0);
            trans_.write(B, 0, i1 + 1);
        }
        trans_.write(g);
    }

    public void writeBool(boolean flag)
        throws TException
    {
        long l1;
        if (flag)
        {
            l1 = 1L;
        } else
        {
            l1 = 0L;
        }
        a(l1);
    }

    public void writeByte(byte byte0)
        throws TException
    {
        a(byte0);
    }

    public void writeDouble(double d1)
        throws TException
    {
        byte abyte0[];
        boolean flag1;
        flag1 = false;
        z.write();
        abyte0 = Double.toString(d1);
        abyte0.charAt(0);
        JVM INSTR lookupswitch 3: default 56
    //                   45: 136
    //                   73: 130
    //                   78: 130;
           goto _L1 _L2 _L3 _L3
_L1:
        boolean flag = false;
_L8:
        if (flag) goto _L5; else goto _L4
_L4:
        flag = flag1;
        if (!z.escapeNum()) goto _L6; else goto _L5
_L5:
        flag = true;
_L6:
        if (flag)
        {
            trans_.write(g);
        }
        try
        {
            abyte0 = abyte0.getBytes("UTF-8");
            trans_.write(abyte0, 0, abyte0.length);
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
        if (flag)
        {
            trans_.write(g);
        }
        return;
_L3:
        flag = true;
        break; /* Loop/switch isn't completed */
_L2:
        if (abyte0.charAt(1) != 'I')
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = true;
        if (true) goto _L8; else goto _L7
_L7:
        if (true) goto _L1; else goto _L9
_L9:
    }

    public void writeFieldBegin(TField tfield)
        throws TException
    {
        a(tfield.id);
        d();
        b(a(tfield.type));
    }

    public void writeFieldEnd()
        throws TException
    {
        e();
    }

    public void writeFieldStop()
    {
    }

    public void writeI16(short word0)
        throws TException
    {
        a(word0);
    }

    public void writeI32(int i1)
        throws TException
    {
        a(i1);
    }

    public void writeI64(long l1)
        throws TException
    {
        a(l1);
    }

    public void writeListBegin(TList tlist)
        throws TException
    {
        f();
        b(a(tlist.elemType));
        a(tlist.size);
    }

    public void writeListEnd()
        throws TException
    {
        g();
    }

    public void writeMapBegin(TMap tmap)
        throws TException
    {
        f();
        b(a(tmap.keyType));
        b(a(tmap.valueType));
        a(tmap.size);
        d();
    }

    public void writeMapEnd()
        throws TException
    {
        e();
        g();
    }

    public void writeMessageBegin(TMessage tmessage)
        throws TException
    {
        f();
        a(1L);
        try
        {
            b(tmessage.name.getBytes("UTF-8"));
        }
        // Misplaced declaration of an exception variable
        catch (TMessage tmessage)
        {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
        a(tmessage.type);
        a(tmessage.seqid);
    }

    public void writeMessageEnd()
        throws TException
    {
        g();
    }

    public void writeSetBegin(TSet tset)
        throws TException
    {
        f();
        b(a(tset.elemType));
        a(tset.size);
    }

    public void writeSetEnd()
        throws TException
    {
        g();
    }

    public void writeString(String s1)
        throws TException
    {
        try
        {
            b(s1.getBytes("UTF-8"));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public void writeStructBegin(TStruct tstruct)
        throws TException
    {
        d();
    }

    public void writeStructEnd()
        throws TException
    {
        e();
    }

}
