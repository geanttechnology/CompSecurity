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
//            s

public class MMStringData
    implements Serializable, Cloneable, TBase
{
    private static final class a
        implements Serializable
    {

        a()
        {
            this((byte)0);
        }

        private a(byte byte0)
        {
        }
    }


    public static final int KEY = 1;
    public static final int VALUE = 2;
    private static final TStruct a = new TStruct("MMStringData");
    private static final TField b = new TField("key", (byte)11, (short)1);
    private static final TField c = new TField("value", (byte)11, (short)2);
    public static final Map metaDataMap;
    private String d;
    private String e;

    public MMStringData()
    {
        new a();
    }

    public MMStringData(MMStringData mmstringdata)
    {
        new a();
        if (mmstringdata.isSetKey())
        {
            d = mmstringdata.d;
        }
        if (mmstringdata.isSetValue())
        {
            e = mmstringdata.e;
        }
    }

    public MMStringData(String s1, String s2)
    {
        this();
        d = s1;
        e = s2;
    }

    public MMStringData clone()
    {
        return new MMStringData(this);
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public boolean equals(MMStringData mmstringdata)
    {
        if (mmstringdata != null)
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
            if (mmstringdata.isSetKey())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!flag && !flag1 || flag && flag1 && d.equals(mmstringdata.d))
            {
                if (isSetValue())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (mmstringdata.isSetValue())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (!flag && !flag1 || flag && flag1 && e.equals(mmstringdata.e))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof MMStringData)) 
        {
            return false;
        }
        return equals((MMStringData)obj);
    }

    public Object getFieldValue(int i)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());

        case 1: // '\001'
            return getKey();

        case 2: // '\002'
            return getValue();
        }
    }

    public String getKey()
    {
        return d;
    }

    public String getValue()
    {
        return e;
    }

    public int hashCode()
    {
        return 0;
    }

    public boolean isSet(int i)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());

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
        return e != null;
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
            break MISSING_BLOCK_LABEL_121;
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
        if (tfield.type == 11)
        {
            e = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L3
        tprotocol.readStructEnd();
        validate();
        return;
    }

    public void setFieldValue(int i, Object obj)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());

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
            setValue((String)obj);
            return;
        }
    }

    public void setKey(String s1)
    {
        d = s1;
    }

    public void setValue(String s1)
    {
        e = s1;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("MMStringData(");
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
        if (e == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(e);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetKey()
    {
        d = null;
    }

    public void unsetValue()
    {
        e = null;
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
        if (e != null)
        {
            tprotocol.writeFieldBegin(c);
            tprotocol.writeString(e);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    static 
    {
        metaDataMap = Collections.unmodifiableMap(new s());
        FieldMetaData.addStructMetaDataMap(com/medialets/thrift/MMStringData, metaDataMap);
    }

    // Unreferenced inner class com/medialets/thrift/s
    final class s extends HashMap
    {

            s()
            {
                put(Integer.valueOf(1), new FieldMetaData("key", (byte)3, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(2), new FieldMetaData("value", (byte)3, new FieldValueMetaData((byte)11)));
            }
    }

}
