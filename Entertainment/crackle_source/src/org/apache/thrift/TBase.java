// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;

import java.io.Serializable;
import org.apache.thrift.protocol.TProtocol;

// Referenced classes of package org.apache.thrift:
//            TException

public interface TBase
    extends Serializable
{

    public abstract TBase deepCopy();

    public abstract Object getFieldValue(int i);

    public abstract boolean isSet(int i);

    public abstract void read(TProtocol tprotocol)
        throws TException;

    public abstract void setFieldValue(int i, Object obj);

    public abstract void write(TProtocol tprotocol)
        throws TException;
}
