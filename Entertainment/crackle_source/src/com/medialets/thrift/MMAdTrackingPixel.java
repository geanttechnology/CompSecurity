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
//            t

public class MMAdTrackingPixel
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


    public static final int TRACKINGPIXELURL = 1;
    private static final TStruct a = new TStruct("MMAdTrackingPixel");
    private static final TField b = new TField("trackingPixelURL", (byte)11, (short)1);
    public static final Map metaDataMap;
    private String c;

    public MMAdTrackingPixel()
    {
        new a();
    }

    public MMAdTrackingPixel(MMAdTrackingPixel mmadtrackingpixel)
    {
        new a();
        if (mmadtrackingpixel.isSetTrackingPixelURL())
        {
            c = mmadtrackingpixel.c;
        }
    }

    public MMAdTrackingPixel(String s)
    {
        this();
        c = s;
    }

    public MMAdTrackingPixel clone()
    {
        return new MMAdTrackingPixel(this);
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public boolean equals(MMAdTrackingPixel mmadtrackingpixel)
    {
        if (mmadtrackingpixel != null)
        {
            boolean flag;
            boolean flag1;
            if (isSetTrackingPixelURL())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (mmadtrackingpixel.isSetTrackingPixelURL())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!flag && !flag1 || flag && flag1 && c.equals(mmadtrackingpixel.c))
            {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof MMAdTrackingPixel)) 
        {
            return false;
        }
        return equals((MMAdTrackingPixel)obj);
    }

    public Object getFieldValue(int i)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());

        case 1: // '\001'
            return getTrackingPixelURL();
        }
    }

    public String getTrackingPixelURL()
    {
        return c;
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
            return isSetTrackingPixelURL();
        }
    }

    public boolean isSetTrackingPixelURL()
    {
        return c != null;
    }

    public void read(TProtocol tprotocol)
        throws TException
    {
        tprotocol.readStructBegin();
_L7:
        TField tfield = tprotocol.readFieldBegin();
        if (tfield.type == 0) goto _L2; else goto _L1
_L1:
        tfield.id;
        JVM INSTR tableswitch 1 1: default 40
    //                   1 55;
           goto _L3 _L4
_L3:
        TProtocolUtil.skip(tprotocol, tfield.type);
_L5:
        tprotocol.readFieldEnd();
        continue; /* Loop/switch isn't completed */
_L4:
        if (tfield.type == 11)
        {
            c = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
        if (true) goto _L5; else goto _L2
_L2:
        tprotocol.readStructEnd();
        validate();
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void setFieldValue(int i, Object obj)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());

        case 1: // '\001'
            break;
        }
        if (obj == null)
        {
            unsetTrackingPixelURL();
            return;
        } else
        {
            setTrackingPixelURL((String)obj);
            return;
        }
    }

    public void setTrackingPixelURL(String s)
    {
        c = s;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("MMAdTrackingPixel(");
        stringbuilder.append("trackingPixelURL:");
        if (c == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(c);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetTrackingPixelURL()
    {
        c = null;
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
        if (c != null)
        {
            tprotocol.writeFieldBegin(b);
            tprotocol.writeString(c);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    static 
    {
        metaDataMap = Collections.unmodifiableMap(new t());
        FieldMetaData.addStructMetaDataMap(com/medialets/thrift/MMAdTrackingPixel, metaDataMap);
    }

    // Unreferenced inner class com/medialets/thrift/t
    final class t extends HashMap
    {

            t()
            {
                put(Integer.valueOf(1), new FieldMetaData("trackingPixelURL", (byte)3, new FieldValueMetaData((byte)11)));
            }
    }

}
