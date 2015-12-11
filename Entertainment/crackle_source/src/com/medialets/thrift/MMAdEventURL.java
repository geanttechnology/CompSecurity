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
//            h

public class MMAdEventURL
    implements Serializable, Cloneable, TBase
{
    private static final class a
        implements Serializable
    {

        public boolean id;
        public boolean visitCount;

        a()
        {
            this((byte)0);
        }

        private a(byte byte0)
        {
            id = false;
            visitCount = false;
        }
    }


    public static final int ID = 1;
    public static final int URL = 2;
    public static final int VISITCOUNT = 3;
    private static final TStruct a = new TStruct("MMAdEventURL");
    private static final TField b = new TField("id", (byte)6, (short)1);
    private static final TField c = new TField("url", (byte)11, (short)2);
    private static final TField d = new TField("visitCount", (byte)6, (short)3);
    public static final Map metaDataMap;
    private short e;
    private String f;
    private short g;
    private final a h;

    public MMAdEventURL()
    {
        h = new a();
    }

    public MMAdEventURL(MMAdEventURL mmadeventurl)
    {
        h = new a();
        h.id = mmadeventurl.h.id;
        e = mmadeventurl.e;
        if (mmadeventurl.isSetUrl())
        {
            f = mmadeventurl.f;
        }
        h.visitCount = mmadeventurl.h.visitCount;
        g = mmadeventurl.g;
    }

    public MMAdEventURL(short word0, String s, short word1)
    {
        this();
        e = word0;
        h.id = true;
        f = s;
        g = word1;
        h.visitCount = true;
    }

    public MMAdEventURL clone()
    {
        return new MMAdEventURL(this);
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public boolean equals(MMAdEventURL mmadeventurl)
    {
        if (mmadeventurl != null && e == mmadeventurl.e)
        {
            boolean flag;
            boolean flag1;
            if (isSetUrl())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (mmadeventurl.isSetUrl())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if ((!flag && !flag1 || flag && flag1 && f.equals(mmadeventurl.f)) && g == mmadeventurl.g)
            {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof MMAdEventURL)) 
        {
            return false;
        }
        return equals((MMAdEventURL)obj);
    }

    public Object getFieldValue(int i)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());

        case 1: // '\001'
            return new Short(getId());

        case 2: // '\002'
            return getUrl();

        case 3: // '\003'
            return new Short(getVisitCount());
        }
    }

    public short getId()
    {
        return e;
    }

    public String getUrl()
    {
        return f;
    }

    public short getVisitCount()
    {
        return g;
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
            return isSetId();

        case 2: // '\002'
            return isSetUrl();

        case 3: // '\003'
            return isSetVisitCount();
        }
    }

    public boolean isSetId()
    {
        return h.id;
    }

    public boolean isSetUrl()
    {
        return f != null;
    }

    public boolean isSetVisitCount()
    {
        return h.visitCount;
    }

    public void read(TProtocol tprotocol)
        throws TException
    {
        tprotocol.readStructBegin();
_L6:
        TField tfield;
        tfield = tprotocol.readFieldBegin();
        if (tfield.type == 0)
        {
            break MISSING_BLOCK_LABEL_172;
        }
        tfield.id;
        JVM INSTR tableswitch 1 3: default 48
    //                   1 63
    //                   2 102
    //                   3 133;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_133;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, tfield.type);
_L7:
        tprotocol.readFieldEnd();
        if (true) goto _L6; else goto _L5
_L5:
        if (tfield.type == 6)
        {
            e = tprotocol.readI16();
            h.id = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L7
_L3:
        if (tfield.type == 11)
        {
            f = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L7
        if (tfield.type == 6)
        {
            g = tprotocol.readI16();
            h.visitCount = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L7
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
                unsetId();
                return;
            } else
            {
                setId(((Short)obj).shortValue());
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetUrl();
                return;
            } else
            {
                setUrl((String)obj);
                return;
            }

        case 3: // '\003'
            break;
        }
        if (obj == null)
        {
            unsetVisitCount();
            return;
        } else
        {
            setVisitCount(((Short)obj).shortValue());
            return;
        }
    }

    public void setId(short word0)
    {
        e = word0;
        h.id = true;
    }

    public void setUrl(String s)
    {
        f = s;
    }

    public void setVisitCount(short word0)
    {
        g = word0;
        h.visitCount = true;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("MMAdEventURL(");
        stringbuilder.append("id:");
        stringbuilder.append(e);
        stringbuilder.append(", ");
        stringbuilder.append("url:");
        if (f == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(f);
        }
        stringbuilder.append(", ");
        stringbuilder.append("visitCount:");
        stringbuilder.append(g);
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetId()
    {
        h.id = false;
    }

    public void unsetUrl()
    {
        f = null;
    }

    public void unsetVisitCount()
    {
        h.visitCount = false;
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
        tprotocol.writeI16(e);
        tprotocol.writeFieldEnd();
        if (f != null)
        {
            tprotocol.writeFieldBegin(c);
            tprotocol.writeString(f);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldBegin(d);
        tprotocol.writeI16(g);
        tprotocol.writeFieldEnd();
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    static 
    {
        metaDataMap = Collections.unmodifiableMap(new h());
        FieldMetaData.addStructMetaDataMap(com/medialets/thrift/MMAdEventURL, metaDataMap);
    }

    // Unreferenced inner class com/medialets/thrift/h
    final class h extends HashMap
    {

            h()
            {
                put(Integer.valueOf(1), new FieldMetaData("id", (byte)3, new FieldValueMetaData((byte)6)));
                put(Integer.valueOf(2), new FieldMetaData("url", (byte)3, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(3), new FieldMetaData("visitCount", (byte)3, new FieldValueMetaData((byte)6)));
            }
    }

}
