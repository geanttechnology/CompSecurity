// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.thrift;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.thrift.IntRangeSet;
import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.protocol.TStruct;

// Referenced classes of package com.medialets.thrift:
//            k, DayModifier

public class MMAdFrequencyCap
    implements Serializable, Cloneable, TBase
{
    private static final class a
        implements Serializable
    {

        public boolean dayModifier;
        public boolean maxImpressions;

        a()
        {
            this((byte)0);
        }

        private a(byte byte0)
        {
            maxImpressions = false;
            dayModifier = false;
        }
    }


    public static final int DAYMODIFIER = 4;
    public static final int ENDTIME = 2;
    public static final int MAXIMPRESSIONS = 3;
    public static final int STARTTIME = 1;
    private static final TStruct a = new TStruct("MMAdFrequencyCap");
    private static final TField b = new TField("startTime", (byte)11, (short)1);
    private static final TField c = new TField("endTime", (byte)11, (short)2);
    private static final TField d = new TField("maxImpressions", (byte)8, (short)3);
    private static final TField e = new TField("dayModifier", (byte)8, (short)4);
    public static final Map metaDataMap;
    private String f;
    private String g;
    private int h;
    private int i;
    private final a j;

    public MMAdFrequencyCap()
    {
        j = new a();
    }

    public MMAdFrequencyCap(MMAdFrequencyCap mmadfrequencycap)
    {
        j = new a();
        if (mmadfrequencycap.isSetStartTime())
        {
            f = mmadfrequencycap.f;
        }
        if (mmadfrequencycap.isSetEndTime())
        {
            g = mmadfrequencycap.g;
        }
        j.maxImpressions = mmadfrequencycap.j.maxImpressions;
        h = mmadfrequencycap.h;
        j.dayModifier = mmadfrequencycap.j.dayModifier;
        i = mmadfrequencycap.i;
    }

    public MMAdFrequencyCap(String s, String s1, int l, int i1)
    {
        this();
        f = s;
        g = s1;
        h = l;
        j.maxImpressions = true;
        i = i1;
        j.dayModifier = true;
    }

    public MMAdFrequencyCap clone()
    {
        return new MMAdFrequencyCap(this);
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public boolean equals(MMAdFrequencyCap mmadfrequencycap)
    {
        if (mmadfrequencycap != null)
        {
            boolean flag;
            boolean flag1;
            if (isSetStartTime())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (mmadfrequencycap.isSetStartTime())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!flag && !flag1 || flag && flag1 && f.equals(mmadfrequencycap.f))
            {
                if (isSetEndTime())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (mmadfrequencycap.isSetEndTime())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if ((!flag && !flag1 || flag && flag1 && g.equals(mmadfrequencycap.g)) && h == mmadfrequencycap.h)
                {
                    if (isSetDayModifier())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (mmadfrequencycap.isSetDayModifier())
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (!flag && !flag1 || flag && flag1 && i == mmadfrequencycap.i)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof MMAdFrequencyCap)) 
        {
            return false;
        }
        return equals((MMAdFrequencyCap)obj);
    }

    public int getDayModifier()
    {
        return i;
    }

    public String getEndTime()
    {
        return g;
    }

    public Object getFieldValue(int l)
    {
        switch (l)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(l).append(" doesn't exist!").toString());

        case 1: // '\001'
            return getStartTime();

        case 2: // '\002'
            return getEndTime();

        case 3: // '\003'
            return new Integer(getMaxImpressions());

        case 4: // '\004'
            return Integer.valueOf(getDayModifier());
        }
    }

    public int getMaxImpressions()
    {
        return h;
    }

    public String getStartTime()
    {
        return f;
    }

    public int hashCode()
    {
        return 0;
    }

    public boolean isSet(int l)
    {
        switch (l)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(l).append(" doesn't exist!").toString());

        case 1: // '\001'
            return isSetStartTime();

        case 2: // '\002'
            return isSetEndTime();

        case 3: // '\003'
            return isSetMaxImpressions();

        case 4: // '\004'
            return isSetDayModifier();
        }
    }

    public boolean isSetDayModifier()
    {
        return j.dayModifier;
    }

    public boolean isSetEndTime()
    {
        return g != null;
    }

    public boolean isSetMaxImpressions()
    {
        return j.maxImpressions;
    }

    public boolean isSetStartTime()
    {
        return f != null;
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
            break MISSING_BLOCK_LABEL_207;
        }
        tfield.id;
        JVM INSTR tableswitch 1 4: default 52
    //                   1 67
    //                   2 98
    //                   3 129
    //                   4 168;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_168;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, tfield.type);
_L8:
        tprotocol.readFieldEnd();
        if (true) goto _L7; else goto _L6
_L6:
        if (tfield.type == 11)
        {
            f = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L8
_L3:
        if (tfield.type == 11)
        {
            g = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L8
_L4:
        if (tfield.type == 8)
        {
            h = tprotocol.readI32();
            j.maxImpressions = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L8
        if (tfield.type == 8)
        {
            i = tprotocol.readI32();
            j.dayModifier = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L8
        tprotocol.readStructEnd();
        validate();
        return;
    }

    public void setDayModifier(int l)
    {
        i = l;
        j.dayModifier = true;
    }

    public void setEndTime(String s)
    {
        g = s;
    }

    public void setFieldValue(int l, Object obj)
    {
        switch (l)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(l).append(" doesn't exist!").toString());

        case 1: // '\001'
            if (obj == null)
            {
                unsetStartTime();
                return;
            } else
            {
                setStartTime((String)obj);
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetEndTime();
                return;
            } else
            {
                setEndTime((String)obj);
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetMaxImpressions();
                return;
            } else
            {
                setMaxImpressions(((Integer)obj).intValue());
                return;
            }

        case 4: // '\004'
            break;
        }
        if (obj == null)
        {
            unsetDayModifier();
            return;
        } else
        {
            setDayModifier(((Integer)obj).intValue());
            return;
        }
    }

    public void setMaxImpressions(int l)
    {
        h = l;
        j.maxImpressions = true;
    }

    public void setStartTime(String s)
    {
        f = s;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("MMAdFrequencyCap(");
        stringbuilder.append("startTime:");
        if (f == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(f);
        }
        stringbuilder.append(", ");
        stringbuilder.append("endTime:");
        if (g == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(g);
        }
        stringbuilder.append(", ");
        stringbuilder.append("maxImpressions:");
        stringbuilder.append(h);
        if (isSetDayModifier())
        {
            stringbuilder.append(", ");
            stringbuilder.append("dayModifier:");
            String s = (String)DayModifier.VALUES_TO_NAMES.get(Integer.valueOf(i));
            if (s != null)
            {
                stringbuilder.append(s);
                stringbuilder.append(" (");
            }
            stringbuilder.append(i);
            if (s != null)
            {
                stringbuilder.append(")");
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetDayModifier()
    {
        j.dayModifier = false;
    }

    public void unsetEndTime()
    {
        g = null;
    }

    public void unsetMaxImpressions()
    {
        j.maxImpressions = false;
    }

    public void unsetStartTime()
    {
        f = null;
    }

    public void validate()
        throws TException
    {
        if (isSetDayModifier() && !DayModifier.VALID_VALUES.contains(i))
        {
            throw new TProtocolException((new StringBuilder("The field 'dayModifier' has been assigned the invalid value ")).append(i).toString());
        } else
        {
            return;
        }
    }

    public void write(TProtocol tprotocol)
        throws TException
    {
        validate();
        tprotocol.writeStructBegin(a);
        if (f != null)
        {
            tprotocol.writeFieldBegin(b);
            tprotocol.writeString(f);
            tprotocol.writeFieldEnd();
        }
        if (g != null)
        {
            tprotocol.writeFieldBegin(c);
            tprotocol.writeString(g);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldBegin(d);
        tprotocol.writeI32(h);
        tprotocol.writeFieldEnd();
        if (isSetDayModifier())
        {
            tprotocol.writeFieldBegin(e);
            tprotocol.writeI32(i);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    static 
    {
        metaDataMap = Collections.unmodifiableMap(new k());
        FieldMetaData.addStructMetaDataMap(com/medialets/thrift/MMAdFrequencyCap, metaDataMap);
    }

    // Unreferenced inner class com/medialets/thrift/k
    final class k extends HashMap
    {

            k()
            {
                put(Integer.valueOf(1), new FieldMetaData("startTime", (byte)3, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(2), new FieldMetaData("endTime", (byte)3, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(3), new FieldMetaData("maxImpressions", (byte)3, new FieldValueMetaData((byte)8)));
                put(Integer.valueOf(4), new FieldMetaData("dayModifier", (byte)2, new FieldValueMetaData((byte)8)));
            }
    }

}
