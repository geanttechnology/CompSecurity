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
//            p

public class MMAdEventBreadcrumb
    implements Serializable, Cloneable, TBase
{
    private static final class a
        implements Serializable
    {

        public boolean duration;
        public boolean urlID;

        a()
        {
            this((byte)0);
        }

        private a(byte byte0)
        {
            urlID = false;
            duration = false;
        }
    }


    public static final int DURATION = 2;
    public static final int URLID = 1;
    public static final int VIEWSTART = 3;
    private static final TStruct a = new TStruct("MMAdEventBreadcrumb");
    private static final TField b = new TField("urlID", (byte)6, (short)1);
    private static final TField c = new TField("duration", (byte)4, (short)2);
    private static final TField d = new TField("viewStart", (byte)11, (short)3);
    public static final Map metaDataMap;
    private short e;
    private double f;
    private String g;
    private final a h;

    public MMAdEventBreadcrumb()
    {
        h = new a();
    }

    public MMAdEventBreadcrumb(MMAdEventBreadcrumb mmadeventbreadcrumb)
    {
        h = new a();
        h.urlID = mmadeventbreadcrumb.h.urlID;
        e = mmadeventbreadcrumb.e;
        h.duration = mmadeventbreadcrumb.h.duration;
        f = mmadeventbreadcrumb.f;
        if (mmadeventbreadcrumb.isSetViewStart())
        {
            g = mmadeventbreadcrumb.g;
        }
    }

    public MMAdEventBreadcrumb(short word0, double d1, String s)
    {
        this();
        e = word0;
        h.urlID = true;
        f = d1;
        h.duration = true;
        g = s;
    }

    public MMAdEventBreadcrumb clone()
    {
        return new MMAdEventBreadcrumb(this);
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public boolean equals(MMAdEventBreadcrumb mmadeventbreadcrumb)
    {
        if (mmadeventbreadcrumb != null && e == mmadeventbreadcrumb.e && f == mmadeventbreadcrumb.f)
        {
            boolean flag;
            boolean flag1;
            if (isSetViewStart())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (mmadeventbreadcrumb.isSetViewStart())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!flag && !flag1 || flag && flag1 && g.equals(mmadeventbreadcrumb.g))
            {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof MMAdEventBreadcrumb)) 
        {
            return false;
        }
        return equals((MMAdEventBreadcrumb)obj);
    }

    public double getDuration()
    {
        return f;
    }

    public Object getFieldValue(int i)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());

        case 1: // '\001'
            return new Short(getUrlID());

        case 2: // '\002'
            return new Double(getDuration());

        case 3: // '\003'
            return getViewStart();
        }
    }

    public short getUrlID()
    {
        return e;
    }

    public String getViewStart()
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
            return isSetUrlID();

        case 2: // '\002'
            return isSetDuration();

        case 3: // '\003'
            return isSetViewStart();
        }
    }

    public boolean isSetDuration()
    {
        return h.duration;
    }

    public boolean isSetUrlID()
    {
        return h.urlID;
    }

    public boolean isSetViewStart()
    {
        return g != null;
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
            break MISSING_BLOCK_LABEL_171;
        }
        tfield.id;
        JVM INSTR tableswitch 1 3: default 48
    //                   1 63
    //                   2 102
    //                   3 140;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_140;
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
            h.urlID = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L7
_L3:
        if (tfield.type == 4)
        {
            f = tprotocol.readDouble();
            h.duration = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L7
        if (tfield.type == 11)
        {
            g = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L7
        tprotocol.readStructEnd();
        validate();
        return;
    }

    public void setDuration(double d1)
    {
        f = d1;
        h.duration = true;
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
                unsetUrlID();
                return;
            } else
            {
                setUrlID(((Short)obj).shortValue());
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetDuration();
                return;
            } else
            {
                setDuration(((Double)obj).doubleValue());
                return;
            }

        case 3: // '\003'
            break;
        }
        if (obj == null)
        {
            unsetViewStart();
            return;
        } else
        {
            setViewStart((String)obj);
            return;
        }
    }

    public void setUrlID(short word0)
    {
        e = word0;
        h.urlID = true;
    }

    public void setViewStart(String s)
    {
        g = s;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("MMAdEventBreadcrumb(");
        stringbuilder.append("urlID:");
        stringbuilder.append(e);
        stringbuilder.append(", ");
        stringbuilder.append("duration:");
        stringbuilder.append(f);
        stringbuilder.append(", ");
        stringbuilder.append("viewStart:");
        if (g == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(g);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetDuration()
    {
        h.duration = false;
    }

    public void unsetUrlID()
    {
        h.urlID = false;
    }

    public void unsetViewStart()
    {
        g = null;
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
        tprotocol.writeFieldBegin(c);
        tprotocol.writeDouble(f);
        tprotocol.writeFieldEnd();
        if (g != null)
        {
            tprotocol.writeFieldBegin(d);
            tprotocol.writeString(g);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    static 
    {
        metaDataMap = Collections.unmodifiableMap(new p());
        FieldMetaData.addStructMetaDataMap(com/medialets/thrift/MMAdEventBreadcrumb, metaDataMap);
    }

    // Unreferenced inner class com/medialets/thrift/p
    final class p extends HashMap
    {

            p()
            {
                put(Integer.valueOf(1), new FieldMetaData("urlID", (byte)3, new FieldValueMetaData((byte)6)));
                put(Integer.valueOf(2), new FieldMetaData("duration", (byte)3, new FieldValueMetaData((byte)4)));
                put(Integer.valueOf(3), new FieldMetaData("viewStart", (byte)3, new FieldValueMetaData((byte)11)));
            }
    }

}
