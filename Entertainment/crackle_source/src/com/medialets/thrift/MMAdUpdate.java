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
//            m

public class MMAdUpdate
    implements Serializable, Cloneable, TBase
{
    private static final class a
        implements Serializable
    {

        public boolean adVersion;

        a()
        {
            this((byte)0);
        }

        private a(byte byte0)
        {
            adVersion = false;
        }
    }


    public static final int ADVERSION = 1;
    public static final int UPDATEBUNDLEURL = 2;
    private static final TStruct a = new TStruct("MMAdUpdate");
    private static final TField b = new TField("adVersion", (byte)6, (short)1);
    private static final TField c = new TField("updateBundleURL", (byte)11, (short)2);
    public static final Map metaDataMap;
    private short d;
    private String e;
    private final a f;

    public MMAdUpdate()
    {
        f = new a();
    }

    public MMAdUpdate(MMAdUpdate mmadupdate)
    {
        f = new a();
        f.adVersion = mmadupdate.f.adVersion;
        d = mmadupdate.d;
        if (mmadupdate.isSetUpdateBundleURL())
        {
            e = mmadupdate.e;
        }
    }

    public MMAdUpdate(short word0, String s)
    {
        this();
        d = word0;
        f.adVersion = true;
        e = s;
    }

    public MMAdUpdate clone()
    {
        return new MMAdUpdate(this);
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public boolean equals(MMAdUpdate mmadupdate)
    {
        if (mmadupdate != null && d == mmadupdate.d)
        {
            boolean flag;
            boolean flag1;
            if (isSetUpdateBundleURL())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (mmadupdate.isSetUpdateBundleURL())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!flag && !flag1 || flag && flag1 && e.equals(mmadupdate.e))
            {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof MMAdUpdate)) 
        {
            return false;
        }
        return equals((MMAdUpdate)obj);
    }

    public short getAdVersion()
    {
        return d;
    }

    public Object getFieldValue(int i)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());

        case 1: // '\001'
            return new Short(getAdVersion());

        case 2: // '\002'
            return getUpdateBundleURL();
        }
    }

    public String getUpdateBundleURL()
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
            return isSetAdVersion();

        case 2: // '\002'
            return isSetUpdateBundleURL();
        }
    }

    public boolean isSetAdVersion()
    {
        return f.adVersion;
    }

    public boolean isSetUpdateBundleURL()
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
            break MISSING_BLOCK_LABEL_129;
        }
        switch (tfield.id)
        {
        default:
            TProtocolUtil.skip(tprotocol, tfield.type);
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 2: // '\002'
            break MISSING_BLOCK_LABEL_98;
        }
_L3:
        tprotocol.readFieldEnd();
        if (true) goto _L2; else goto _L1
_L1:
        if (tfield.type == 6)
        {
            d = tprotocol.readI16();
            f.adVersion = true;
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

    public void setAdVersion(short word0)
    {
        d = word0;
        f.adVersion = true;
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
                unsetAdVersion();
                return;
            } else
            {
                setAdVersion(((Short)obj).shortValue());
                return;
            }

        case 2: // '\002'
            break;
        }
        if (obj == null)
        {
            unsetUpdateBundleURL();
            return;
        } else
        {
            setUpdateBundleURL((String)obj);
            return;
        }
    }

    public void setUpdateBundleURL(String s)
    {
        e = s;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("MMAdUpdate(");
        stringbuilder.append("adVersion:");
        stringbuilder.append(d);
        stringbuilder.append(", ");
        stringbuilder.append("updateBundleURL:");
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

    public void unsetAdVersion()
    {
        f.adVersion = false;
    }

    public void unsetUpdateBundleURL()
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
        tprotocol.writeFieldBegin(b);
        tprotocol.writeI16(d);
        tprotocol.writeFieldEnd();
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
        metaDataMap = Collections.unmodifiableMap(new m());
        FieldMetaData.addStructMetaDataMap(com/medialets/thrift/MMAdUpdate, metaDataMap);
    }

    // Unreferenced inner class com/medialets/thrift/m
    final class m extends HashMap
    {

            m()
            {
                put(Integer.valueOf(1), new FieldMetaData("adVersion", (byte)3, new FieldValueMetaData((byte)6)));
                put(Integer.valueOf(2), new FieldMetaData("updateBundleURL", (byte)3, new FieldValueMetaData((byte)11)));
            }
    }

}
