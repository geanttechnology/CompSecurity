// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;

import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransport;

// Referenced classes of package org.apache.thrift.protocol:
//            TField, TList, TMap, TMessage, 
//            TSet, TStruct

public abstract class TProtocol
{

    protected TTransport trans_;

    private TProtocol()
    {
    }

    protected TProtocol(TTransport ttransport)
    {
        trans_ = ttransport;
    }

    public TTransport getTransport()
    {
        return trans_;
    }

    public abstract byte[] readBinary()
        throws TException;

    public abstract boolean readBool()
        throws TException;

    public abstract byte readByte()
        throws TException;

    public abstract double readDouble()
        throws TException;

    public abstract TField readFieldBegin()
        throws TException;

    public abstract void readFieldEnd()
        throws TException;

    public abstract short readI16()
        throws TException;

    public abstract int readI32()
        throws TException;

    public abstract long readI64()
        throws TException;

    public abstract TList readListBegin()
        throws TException;

    public abstract void readListEnd()
        throws TException;

    public abstract TMap readMapBegin()
        throws TException;

    public abstract void readMapEnd()
        throws TException;

    public abstract TMessage readMessageBegin()
        throws TException;

    public abstract void readMessageEnd()
        throws TException;

    public abstract TSet readSetBegin()
        throws TException;

    public abstract void readSetEnd()
        throws TException;

    public abstract String readString()
        throws TException;

    public abstract TStruct readStructBegin()
        throws TException;

    public abstract void readStructEnd()
        throws TException;

    public abstract void writeBinary(byte abyte0[])
        throws TException;

    public abstract void writeBool(boolean flag)
        throws TException;

    public abstract void writeByte(byte byte0)
        throws TException;

    public abstract void writeDouble(double d)
        throws TException;

    public abstract void writeFieldBegin(TField tfield)
        throws TException;

    public abstract void writeFieldEnd()
        throws TException;

    public abstract void writeFieldStop()
        throws TException;

    public abstract void writeI16(short word0)
        throws TException;

    public abstract void writeI32(int i)
        throws TException;

    public abstract void writeI64(long l)
        throws TException;

    public abstract void writeListBegin(TList tlist)
        throws TException;

    public abstract void writeListEnd()
        throws TException;

    public abstract void writeMapBegin(TMap tmap)
        throws TException;

    public abstract void writeMapEnd()
        throws TException;

    public abstract void writeMessageBegin(TMessage tmessage)
        throws TException;

    public abstract void writeMessageEnd()
        throws TException;

    public abstract void writeSetBegin(TSet tset)
        throws TException;

    public abstract void writeSetEnd()
        throws TException;

    public abstract void writeString(String s)
        throws TException;

    public abstract void writeStructBegin(TStruct tstruct)
        throws TException;

    public abstract void writeStructEnd()
        throws TException;
}
