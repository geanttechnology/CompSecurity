// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.thrift;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.protocol.TStruct;

// Referenced classes of package com.medialets.thrift:
//            i

public class MMNumberData
    implements Serializable, Cloneable, TBase
{
    private static final class a
        implements Serializable
    {

        public boolean value;

        a()
        {
            this((byte)0);
        }

        private a(byte byte0)
        {
            value = false;
        }
    }


    public static final int KEY = 1;
    public static final int VALUE = 2;
    private static final TStruct a = new TStruct("MMNumberData");
    private static final TField b = new TField("key", (byte)11, (short)1);
    private static final TField c = new TField("value", (byte)4, (short)2);
    public static final Map metaDataMap;
    private String d;
    private double e;
    private final a f;

    public MMNumberData()
    {
        f = new a();
    }

    public MMNumberData(MMNumberData mmnumberdata)
    {
        f = new a();
        if (mmnumberdata.isSetKey())
        {
            d = mmnumberdata.d;
        }
        f.value = mmnumberdata.f.value;
        e = mmnumberdata.e;
    }

    public MMNumberData(String s, double d1)
    {
        this();
        d = s;
        e = d1;
        f.value = true;
    }

    public MMNumberData clone()
    {
        return new MMNumberData(this);
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public boolean equals(MMNumberData mmnumberdata)
    {
        if (mmnumberdata != null)
        {
            boolean flag;
            boolean flag1;
            if (isSetKey())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (mmnumberdata.isSetKey())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if ((!flag && !flag1 || flag && flag1 && d.equals(mmnumberdata.d)) && e == mmnumberdata.e)
            {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof MMNumberData)) 
        {
            return false;
        }
        return equals((MMNumberData)obj);
    }

    public Object getFieldValue(int j)
    {
        switch (j)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(j).append(" doesn't exist!").toString());

        case 1: // '\001'
            return getKey();

        case 2: // '\002'
            return new Double(getValue());
        }
    }

    public String getKey()
    {
        return d;
    }

    public double getValue()
    {
        return e;
    }

    public int hashCode()
    {
        return 0;
    }

    public boolean isSet(int j)
    {
        switch (j)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(j).append(" doesn't exist!").toString());

        case 1: // '\001'
            return isSetKey();

        case 2: // '\002'
            return isSetValue();
        }
    }

    public boolean isSetKey()
    {
        return d != null;
    }

    public boolean isSetValue()
    {
        return f.value;
    }

    public void read(TProtocol tprotocol)
        throws TException
    {
        tprotocol.readStructBegin();
_L2:
        TField tfield;
        tfield = tprotocol.readFieldBegin();
        if (tfield.type == 0)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        switch (tfield.id)
        {
        default:
            TProtocolUtil.skip(tprotocol, tfield.type);
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 2: // '\002'
            break MISSING_BLOCK_LABEL_90;
        }
_L3:
        tprotocol.readFieldEnd();
        if (true) goto _L2; else goto _L1
_L1:
        if (tfield.type == 11)
        {
            d = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L3
        if (tfield.type == 4)
        {
            e = tprotocol.readDouble();
            f.value = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L3
        tprotocol.readStructEnd();
        validate();
        return;
    }

    public void setFieldValue(int j, Object obj)
    {
        switch (j)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(j).append(" doesn't exist!").toString());

        case 1: // '\001'
            if (obj == null)
            {
                unsetKey();
                return;
            } else
            {
                setKey((String)obj);
                return;
            }

        case 2: // '\002'
            break;
        }
        if (obj == null)
        {
            unsetValue();
            return;
        } else
        {
            setValue(((Double)obj).doubleValue());
            return;
        }
    }

    public void setKey(String s)
    {
        d = s;
    }

    public void setValue(double d1)
    {
        e = d1;
        f.value = true;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("MMNumberData(");
        stringbuilder.append("key:");
        if (d == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(d);
        }
        stringbuilder.append(", ");
        stringbuilder.append("value:");
        stringbuilder.append(e);
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetKey()
    {
        d = null;
    }

    public void unsetValue()
    {
        f.value = false;
    }

    public void validate()
        throws TException
    {
    }

    public void write(TProtocol tprotocol)
        throws TException
    {
        validate();
        tprotocol.writeStructBegin(a);
        if (d != null)
        {
            tprotocol.writeFieldBegin(b);
            tprotocol.writeString(d);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldBegin(c);
        tprotocol.writeDouble(e);
        tprotocol.writeFieldEnd();
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    static 
    {
        metaDataMap = Collections.unmodifiableMap(new i());
        FieldMetaData.addStructMetaDataMap(com/medialets/thrift/MMNumberData, metaDataMap);
    }

    // Unreferenced inner class com/medialets/thrift/i
    final class i extends HashMap
    {

            i()
            {
                put(Integer.valueOf(1), new FieldMetaData("key", (byte)3, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(2), new FieldMetaData("value", (byte)3, new FieldValueMetaData((byte)4)));
            }
    }

}
