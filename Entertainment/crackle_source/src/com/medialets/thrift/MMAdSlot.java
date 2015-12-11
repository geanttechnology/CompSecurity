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
//            q

public class MMAdSlot
    implements Serializable, Cloneable, TBase
{
    private static final class a
        implements Serializable
    {

        public boolean adSlotID;
        public boolean height;
        public boolean width;

        a()
        {
            this((byte)0);
        }

        private a(byte byte0)
        {
            adSlotID = false;
            width = false;
            height = false;
        }
    }


    public static final int ADSLOTID = 1;
    public static final int HEIGHT = 3;
    public static final int SLOTNAME = 4;
    public static final int WIDTH = 2;
    private static final TStruct a = new TStruct("MMAdSlot");
    private static final TField b = new TField("adSlotID", (byte)8, (short)1);
    private static final TField c = new TField("width", (byte)6, (short)2);
    private static final TField d = new TField("height", (byte)6, (short)3);
    private static final TField e = new TField("slotName", (byte)11, (short)4);
    public static final Map metaDataMap;
    private int f;
    private short g;
    private short h;
    private String i;
    private final a j;

    public MMAdSlot()
    {
        j = new a();
    }

    public MMAdSlot(int k, short word0, short word1, String s)
    {
        this();
        f = k;
        j.adSlotID = true;
        g = word0;
        j.width = true;
        h = word1;
        j.height = true;
        i = s;
    }

    public MMAdSlot(MMAdSlot mmadslot)
    {
        j = new a();
        j.adSlotID = mmadslot.j.adSlotID;
        f = mmadslot.f;
        j.width = mmadslot.j.width;
        g = mmadslot.g;
        j.height = mmadslot.j.height;
        h = mmadslot.h;
        if (mmadslot.isSetSlotName())
        {
            i = mmadslot.i;
        }
    }

    public MMAdSlot clone()
    {
        return new MMAdSlot(this);
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public boolean equals(MMAdSlot mmadslot)
    {
        if (mmadslot != null)
        {
            boolean flag;
            boolean flag1;
            if (isSetAdSlotID())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (mmadslot.isSetAdSlotID())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!flag && !flag1 || flag && flag1 && f == mmadslot.f)
            {
                if (isSetWidth())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (mmadslot.isSetWidth())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (!flag && !flag1 || flag && flag1 && g == mmadslot.g)
                {
                    if (isSetHeight())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (mmadslot.isSetHeight())
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (!flag && !flag1 || flag && flag1 && h == mmadslot.h)
                    {
                        if (isSetSlotName())
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        if (mmadslot.isSetSlotName())
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        if (!flag && !flag1 || flag && flag1 && i.equals(mmadslot.i))
                        {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof MMAdSlot)) 
        {
            return false;
        }
        return equals((MMAdSlot)obj);
    }

    public int getAdSlotID()
    {
        return f;
    }

    public Object getFieldValue(int k)
    {
        switch (k)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(k).append(" doesn't exist!").toString());

        case 1: // '\001'
            return new Integer(getAdSlotID());

        case 2: // '\002'
            return new Short(getWidth());

        case 3: // '\003'
            return new Short(getHeight());

        case 4: // '\004'
            return getSlotName();
        }
    }

    public short getHeight()
    {
        return h;
    }

    public String getSlotName()
    {
        return i;
    }

    public short getWidth()
    {
        return g;
    }

    public int hashCode()
    {
        return 0;
    }

    public boolean isSet(int k)
    {
        switch (k)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(k).append(" doesn't exist!").toString());

        case 1: // '\001'
            return isSetAdSlotID();

        case 2: // '\002'
            return isSetWidth();

        case 3: // '\003'
            return isSetHeight();

        case 4: // '\004'
            return isSetSlotName();
        }
    }

    public boolean isSetAdSlotID()
    {
        return j.adSlotID;
    }

    public boolean isSetHeight()
    {
        return j.height;
    }

    public boolean isSetSlotName()
    {
        return i != null;
    }

    public boolean isSetWidth()
    {
        return j.width;
    }

    public void read(TProtocol tprotocol)
        throws TException
    {
        tprotocol.readStructBegin();
_L7:
        TField tfield;
        tfield = tprotocol.readFieldBegin();
        if (tfield.type == 0)
        {
            break MISSING_BLOCK_LABEL_215;
        }
        tfield.id;
        JVM INSTR tableswitch 1 4: default 52
    //                   1 67
    //                   2 106
    //                   3 145
    //                   4 184;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_184;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, tfield.type);
_L8:
        tprotocol.readFieldEnd();
        if (true) goto _L7; else goto _L6
_L6:
        if (tfield.type == 8)
        {
            f = tprotocol.readI32();
            j.adSlotID = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L8
_L3:
        if (tfield.type == 6)
        {
            g = tprotocol.readI16();
            j.width = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L8
_L4:
        if (tfield.type == 6)
        {
            h = tprotocol.readI16();
            j.height = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L8
        if (tfield.type == 11)
        {
            i = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L8
        tprotocol.readStructEnd();
        validate();
        return;
    }

    public void setAdSlotID(int k)
    {
        f = k;
        j.adSlotID = true;
    }

    public void setFieldValue(int k, Object obj)
    {
        switch (k)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(k).append(" doesn't exist!").toString());

        case 1: // '\001'
            if (obj == null)
            {
                unsetAdSlotID();
                return;
            } else
            {
                setAdSlotID(((Integer)obj).intValue());
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetWidth();
                return;
            } else
            {
                setWidth(((Short)obj).shortValue());
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetHeight();
                return;
            } else
            {
                setHeight(((Short)obj).shortValue());
                return;
            }

        case 4: // '\004'
            break;
        }
        if (obj == null)
        {
            unsetSlotName();
            return;
        } else
        {
            setSlotName((String)obj);
            return;
        }
    }

    public void setHeight(short word0)
    {
        h = word0;
        j.height = true;
    }

    public void setSlotName(String s)
    {
        i = s;
    }

    public void setWidth(short word0)
    {
        g = word0;
        j.width = true;
    }

    public String toString()
    {
        boolean flag2 = false;
        StringBuilder stringbuilder = new StringBuilder("MMAdSlot(");
        boolean flag = true;
        if (isSetAdSlotID())
        {
            stringbuilder.append("adSlotID:");
            stringbuilder.append(f);
            flag = false;
        }
        boolean flag1 = flag;
        if (isSetWidth())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("width:");
            stringbuilder.append(g);
            flag1 = false;
        }
        if (isSetHeight())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("height:");
            stringbuilder.append(h);
            flag = flag2;
        } else
        {
            flag = flag1;
        }
        if (!flag)
        {
            stringbuilder.append(", ");
        }
        stringbuilder.append("slotName:");
        if (i == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(i);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetAdSlotID()
    {
        j.adSlotID = false;
    }

    public void unsetHeight()
    {
        j.height = false;
    }

    public void unsetSlotName()
    {
        i = null;
    }

    public void unsetWidth()
    {
        j.width = false;
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
        if (isSetAdSlotID())
        {
            tprotocol.writeFieldBegin(b);
            tprotocol.writeI32(f);
            tprotocol.writeFieldEnd();
        }
        if (isSetWidth())
        {
            tprotocol.writeFieldBegin(c);
            tprotocol.writeI16(g);
            tprotocol.writeFieldEnd();
        }
        if (isSetHeight())
        {
            tprotocol.writeFieldBegin(d);
            tprotocol.writeI16(h);
            tprotocol.writeFieldEnd();
        }
        if (i != null)
        {
            tprotocol.writeFieldBegin(e);
            tprotocol.writeString(i);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    static 
    {
        metaDataMap = Collections.unmodifiableMap(new q());
        FieldMetaData.addStructMetaDataMap(com/medialets/thrift/MMAdSlot, metaDataMap);
    }

    // Unreferenced inner class com/medialets/thrift/q
    final class q extends HashMap
    {

            q()
            {
                put(Integer.valueOf(1), new FieldMetaData("adSlotID", (byte)2, new FieldValueMetaData((byte)8)));
                put(Integer.valueOf(2), new FieldMetaData("width", (byte)2, new FieldValueMetaData((byte)6)));
                put(Integer.valueOf(3), new FieldMetaData("height", (byte)2, new FieldValueMetaData((byte)6)));
                put(Integer.valueOf(4), new FieldMetaData("slotName", (byte)3, new FieldValueMetaData((byte)11)));
            }
    }

}
