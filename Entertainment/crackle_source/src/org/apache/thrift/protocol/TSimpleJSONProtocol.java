// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;

import java.io.UnsupportedEncodingException;
import java.util.Stack;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransport;

// Referenced classes of package org.apache.thrift.protocol:
//            TProtocol, TStruct, TField, TMessage, 
//            TSet, TList, TMap, TProtocolFactory

public class TSimpleJSONProtocol extends TProtocol
{
    protected class Context
    {

        protected void write()
            throws TException
        {
        }

        protected Context()
        {
        }
    }

    public static class Factory
        implements TProtocolFactory
    {

        public TProtocol getProtocol(TTransport ttransport)
        {
            return new TSimpleJSONProtocol(ttransport);
        }

        public Factory()
        {
        }
    }

    protected class ListContext extends Context
    {

        private TSimpleJSONProtocol a;
        protected boolean first_;

        protected void write()
            throws TException
        {
            if (first_)
            {
                first_ = false;
                return;
            } else
            {
                a.trans_.write(TSimpleJSONProtocol.COMMA);
                return;
            }
        }

        protected ListContext()
        {
            a = TSimpleJSONProtocol.this;
            super();
            first_ = true;
        }
    }

    protected class StructContext extends Context
    {

        private TSimpleJSONProtocol a;
        protected boolean colon_;
        protected boolean first_;

        protected void write()
            throws TException
        {
            boolean flag;
            if (first_)
            {
                first_ = false;
                flag = true;
            } else
            {
                TTransport ttransport = a.trans_;
                byte abyte0[];
                if (colon_)
                {
                    abyte0 = TSimpleJSONProtocol.COLON;
                } else
                {
                    abyte0 = TSimpleJSONProtocol.COMMA;
                }
                ttransport.write(abyte0);
                if (!colon_)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            }
            colon_ = flag;
        }

        protected StructContext()
        {
            a = TSimpleJSONProtocol.this;
            super();
            first_ = true;
            colon_ = true;
        }
    }


    public static final byte COLON[] = {
        58
    };
    public static final byte COMMA[] = {
        44
    };
    public static final byte LBRACE[] = {
        123
    };
    public static final byte LBRACKET[] = {
        91
    };
    public static final char QUOTE = 34;
    public static final byte RBRACE[] = {
        125
    };
    public static final byte RBRACKET[] = {
        93
    };
    private static final TStruct a = new TStruct();
    private static final TField b = new TField();
    private static final TMessage c = new TMessage();
    private static final TSet d = new TSet();
    private static final TList e = new TList();
    private static final TMap f = new TMap();
    protected final Context BASE_CONTEXT = new Context();
    protected Stack writeContextStack_;
    protected Context writeContext_;

    public TSimpleJSONProtocol(TTransport ttransport)
    {
        super(ttransport);
        writeContextStack_ = new Stack();
        writeContext_ = BASE_CONTEXT;
    }

    public void _writeStringData(String s)
        throws TException
    {
        try
        {
            s = s.getBytes("UTF-8");
            trans_.write(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    protected void popWriteContext()
    {
        writeContext_ = (Context)writeContextStack_.pop();
    }

    protected void pushWriteContext(Context context)
    {
        writeContextStack_.push(writeContext_);
        writeContext_ = context;
    }

    public byte[] readBinary()
        throws TException
    {
        return new byte[0];
    }

    public boolean readBool()
        throws TException
    {
        return readByte() == 1;
    }

    public byte readByte()
        throws TException
    {
        return 0;
    }

    public double readDouble()
        throws TException
    {
        return 0.0D;
    }

    public TField readFieldBegin()
        throws TException
    {
        return b;
    }

    public void readFieldEnd()
    {
    }

    public short readI16()
        throws TException
    {
        return 0;
    }

    public int readI32()
        throws TException
    {
        return 0;
    }

    public long readI64()
        throws TException
    {
        return 0L;
    }

    public TList readListBegin()
        throws TException
    {
        return e;
    }

    public void readListEnd()
    {
    }

    public TMap readMapBegin()
        throws TException
    {
        return f;
    }

    public void readMapEnd()
    {
    }

    public TMessage readMessageBegin()
        throws TException
    {
        return c;
    }

    public void readMessageEnd()
    {
    }

    public TSet readSetBegin()
        throws TException
    {
        return d;
    }

    public void readSetEnd()
    {
    }

    public String readString()
        throws TException
    {
        return "";
    }

    public String readStringBody(int i)
        throws TException
    {
        return "";
    }

    public TStruct readStructBegin()
    {
        return a;
    }

    public void readStructEnd()
    {
    }

    public void writeBinary(byte abyte0[])
        throws TException
    {
        try
        {
            writeString(new String(abyte0, "UTF-8"));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new TException("JVM DOES NOT SUPPORT UTF-8");
        }
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
        writeI32(byte0);
    }

    public void writeDouble(double d1)
        throws TException
    {
        writeContext_.write();
        _writeStringData(Double.toString(d1));
    }

    public void writeFieldBegin(TField tfield)
        throws TException
    {
        writeString(tfield.name);
    }

    public void writeFieldEnd()
    {
    }

    public void writeFieldStop()
    {
    }

    public void writeI16(short word0)
        throws TException
    {
        writeI32(word0);
    }

    public void writeI32(int i)
        throws TException
    {
        writeContext_.write();
        _writeStringData(Integer.toString(i));
    }

    public void writeI64(long l)
        throws TException
    {
        writeContext_.write();
        _writeStringData(Long.toString(l));
    }

    public void writeListBegin(TList tlist)
        throws TException
    {
        writeContext_.write();
        trans_.write(LBRACKET);
        pushWriteContext(new ListContext());
    }

    public void writeListEnd()
        throws TException
    {
        popWriteContext();
        trans_.write(RBRACKET);
    }

    public void writeMapBegin(TMap tmap)
        throws TException
    {
        writeContext_.write();
        trans_.write(LBRACE);
        pushWriteContext(new StructContext());
    }

    public void writeMapEnd()
        throws TException
    {
        popWriteContext();
        trans_.write(RBRACE);
    }

    public void writeMessageBegin(TMessage tmessage)
        throws TException
    {
        trans_.write(LBRACKET);
        pushWriteContext(new ListContext());
        writeString(tmessage.name);
        writeByte(tmessage.type);
        writeI32(tmessage.seqid);
    }

    public void writeMessageEnd()
        throws TException
    {
        popWriteContext();
        trans_.write(RBRACKET);
    }

    public void writeSetBegin(TSet tset)
        throws TException
    {
        writeContext_.write();
        trans_.write(LBRACKET);
        pushWriteContext(new ListContext());
    }

    public void writeSetEnd()
        throws TException
    {
        popWriteContext();
        trans_.write(RBRACKET);
    }

    public void writeString(String s)
        throws TException
    {
        StringBuffer stringbuffer;
        int i;
        int k;
        writeContext_.write();
        k = s.length();
        stringbuffer = new StringBuffer(k + 16);
        stringbuffer.append('"');
        i = 0;
_L9:
        char c1;
        if (i >= k)
        {
            break MISSING_BLOCK_LABEL_297;
        }
        c1 = s.charAt(i);
        c1;
        JVM INSTR lookupswitch 7: default 116
    //                   8: 193
    //                   9: 261
    //                   10: 227
    //                   12: 210
    //                   13: 244
    //                   34: 171
    //                   92: 171;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L7
_L2:
        break; /* Loop/switch isn't completed */
_L7:
        stringbuffer.append('\\');
        stringbuffer.append(c1);
_L10:
        i++;
        if (true) goto _L9; else goto _L8
_L8:
        stringbuffer.append('\\');
        stringbuffer.append('b');
          goto _L10
_L5:
        stringbuffer.append('\\');
        stringbuffer.append('f');
          goto _L10
_L4:
        stringbuffer.append('\\');
        stringbuffer.append('n');
          goto _L10
_L6:
        stringbuffer.append('\\');
        stringbuffer.append('r');
          goto _L10
_L3:
        stringbuffer.append('\\');
        stringbuffer.append('t');
          goto _L10
_L1:
        if (c1 >= ' ')
        {
            break MISSING_BLOCK_LABEL_288;
        }
        String s1 = Integer.toHexString(c1);
        stringbuffer.append('\\');
        stringbuffer.append('u');
        for (int j = 4; j > s1.length(); j--)
        {
            stringbuffer.append('0');
        }

        stringbuffer.append(s1);
        break; /* Loop/switch isn't completed */
        stringbuffer.append(c1);
          goto _L10
        stringbuffer.append('"');
        _writeStringData(stringbuffer.toString());
        return;
    }

    public void writeStructBegin(TStruct tstruct)
        throws TException
    {
        writeContext_.write();
        trans_.write(LBRACE);
        pushWriteContext(new StructContext());
    }

    public void writeStructEnd()
        throws TException
    {
        popWriteContext();
        trans_.write(RBRACE);
    }

}
