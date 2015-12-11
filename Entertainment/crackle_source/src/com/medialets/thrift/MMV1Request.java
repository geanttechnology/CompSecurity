// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.thrift;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.meta_data.ListMetaData;
import org.apache.thrift.meta_data.StructMetaData;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TList;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.protocol.TStruct;

// Referenced classes of package com.medialets.thrift:
//            c, Event

public class MMV1Request
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


    public static final int APPID = 6;
    public static final int APPVERSION = 7;
    public static final int DEVICEID = 2;
    public static final int DEVICEMODEL = 3;
    public static final int DEVICESYSTEMNAME = 4;
    public static final int DEVICESYSTEMVERSION = 5;
    public static final int EVENTS = 8;
    public static final int IPADDRESS = 9;
    public static final int REQUESTTIME = 1;
    private static final TStruct a = new TStruct("MMV1Request");
    private static final TField b = new TField("requestTime", (byte)11, (short)1);
    private static final TField c = new TField("deviceID", (byte)11, (short)2);
    private static final TField d = new TField("deviceModel", (byte)11, (short)3);
    private static final TField e = new TField("deviceSystemName", (byte)11, (short)4);
    private static final TField f = new TField("deviceSystemVersion", (byte)11, (short)5);
    private static final TField g = new TField("appID", (byte)11, (short)6);
    private static final TField h = new TField("appVersion", (byte)11, (short)7);
    private static final TField i = new TField("events", (byte)15, (short)8);
    private static final TField j = new TField("ipAddress", (byte)11, (short)9);
    public static final Map metaDataMap;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private List r;
    private String s;

    public MMV1Request()
    {
        new a();
    }

    public MMV1Request(MMV1Request mmv1request)
    {
        new a();
        if (mmv1request.isSetRequestTime())
        {
            k = mmv1request.k;
        }
        if (mmv1request.isSetDeviceID())
        {
            l = mmv1request.l;
        }
        if (mmv1request.isSetDeviceModel())
        {
            m = mmv1request.m;
        }
        if (mmv1request.isSetDeviceSystemName())
        {
            n = mmv1request.n;
        }
        if (mmv1request.isSetDeviceSystemVersion())
        {
            o = mmv1request.o;
        }
        if (mmv1request.isSetAppID())
        {
            p = mmv1request.p;
        }
        if (mmv1request.isSetAppVersion())
        {
            q = mmv1request.q;
        }
        if (!mmv1request.isSetEvents()) goto _L2; else goto _L1
_L1:
        ArrayList arraylist;
        Iterator iterator;
        arraylist = new ArrayList();
        iterator = mmv1request.r.iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        r = arraylist;
_L2:
        if (mmv1request.isSetIpAddress())
        {
            s = mmv1request.s;
        }
        return;
_L4:
        arraylist.add(new Event((Event)iterator.next()));
        if (true) goto _L6; else goto _L5
_L5:
    }

    public MMV1Request(String s1, String s2, String s3, String s4, String s5, String s6, String s7, 
            List list, String s8)
    {
        this();
        k = s1;
        l = s2;
        m = s3;
        n = s4;
        o = s5;
        p = s6;
        q = s7;
        r = list;
        s = s8;
    }

    public void addToEvents(Event event)
    {
        if (r == null)
        {
            r = new ArrayList();
        }
        r.add(event);
    }

    public MMV1Request clone()
    {
        return new MMV1Request(this);
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public boolean equals(MMV1Request mmv1request)
    {
        if (mmv1request != null)
        {
            boolean flag;
            boolean flag1;
            if (isSetRequestTime())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (mmv1request.isSetRequestTime())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!flag && !flag1 || flag && flag1 && k.equals(mmv1request.k))
            {
                if (isSetDeviceID())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (mmv1request.isSetDeviceID())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (!flag && !flag1 || flag && flag1 && l.equals(mmv1request.l))
                {
                    if (isSetDeviceModel())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (mmv1request.isSetDeviceModel())
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (!flag && !flag1 || flag && flag1 && m.equals(mmv1request.m))
                    {
                        if (isSetDeviceSystemName())
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        if (mmv1request.isSetDeviceSystemName())
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        if (!flag && !flag1 || flag && flag1 && n.equals(mmv1request.n))
                        {
                            if (isSetDeviceSystemVersion())
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                            if (mmv1request.isSetDeviceSystemVersion())
                            {
                                flag1 = true;
                            } else
                            {
                                flag1 = false;
                            }
                            if (!flag && !flag1 || flag && flag1 && o.equals(mmv1request.o))
                            {
                                if (isSetAppID())
                                {
                                    flag = true;
                                } else
                                {
                                    flag = false;
                                }
                                if (mmv1request.isSetAppID())
                                {
                                    flag1 = true;
                                } else
                                {
                                    flag1 = false;
                                }
                                if (!flag && !flag1 || flag && flag1 && p.equals(mmv1request.p))
                                {
                                    if (isSetAppVersion())
                                    {
                                        flag = true;
                                    } else
                                    {
                                        flag = false;
                                    }
                                    if (mmv1request.isSetAppVersion())
                                    {
                                        flag1 = true;
                                    } else
                                    {
                                        flag1 = false;
                                    }
                                    if (!flag && !flag1 || flag && flag1 && q.equals(mmv1request.q))
                                    {
                                        if (isSetEvents())
                                        {
                                            flag = true;
                                        } else
                                        {
                                            flag = false;
                                        }
                                        if (mmv1request.isSetEvents())
                                        {
                                            flag1 = true;
                                        } else
                                        {
                                            flag1 = false;
                                        }
                                        if (!flag && !flag1 || flag && flag1 && r.equals(mmv1request.r))
                                        {
                                            if (isSetIpAddress())
                                            {
                                                flag = true;
                                            } else
                                            {
                                                flag = false;
                                            }
                                            if (mmv1request.isSetIpAddress())
                                            {
                                                flag1 = true;
                                            } else
                                            {
                                                flag1 = false;
                                            }
                                            if (!flag && !flag1 || flag && flag1 && s.equals(mmv1request.s))
                                            {
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof MMV1Request)) 
        {
            return false;
        }
        return equals((MMV1Request)obj);
    }

    public String getAppID()
    {
        return p;
    }

    public String getAppVersion()
    {
        return q;
    }

    public String getDeviceID()
    {
        return l;
    }

    public String getDeviceModel()
    {
        return m;
    }

    public String getDeviceSystemName()
    {
        return n;
    }

    public String getDeviceSystemVersion()
    {
        return o;
    }

    public List getEvents()
    {
        return r;
    }

    public Iterator getEventsIterator()
    {
        if (r == null)
        {
            return null;
        } else
        {
            return r.iterator();
        }
    }

    public int getEventsSize()
    {
        if (r == null)
        {
            return 0;
        } else
        {
            return r.size();
        }
    }

    public Object getFieldValue(int i1)
    {
        switch (i1)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i1).append(" doesn't exist!").toString());

        case 1: // '\001'
            return getRequestTime();

        case 2: // '\002'
            return getDeviceID();

        case 3: // '\003'
            return getDeviceModel();

        case 4: // '\004'
            return getDeviceSystemName();

        case 5: // '\005'
            return getDeviceSystemVersion();

        case 6: // '\006'
            return getAppID();

        case 7: // '\007'
            return getAppVersion();

        case 8: // '\b'
            return getEvents();

        case 9: // '\t'
            return getIpAddress();
        }
    }

    public String getIpAddress()
    {
        return s;
    }

    public String getRequestTime()
    {
        return k;
    }

    public int hashCode()
    {
        return 0;
    }

    public boolean isSet(int i1)
    {
        switch (i1)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i1).append(" doesn't exist!").toString());

        case 1: // '\001'
            return isSetRequestTime();

        case 2: // '\002'
            return isSetDeviceID();

        case 3: // '\003'
            return isSetDeviceModel();

        case 4: // '\004'
            return isSetDeviceSystemName();

        case 5: // '\005'
            return isSetDeviceSystemVersion();

        case 6: // '\006'
            return isSetAppID();

        case 7: // '\007'
            return isSetAppVersion();

        case 8: // '\b'
            return isSetEvents();

        case 9: // '\t'
            return isSetIpAddress();
        }
    }

    public boolean isSetAppID()
    {
        return p != null;
    }

    public boolean isSetAppVersion()
    {
        return q != null;
    }

    public boolean isSetDeviceID()
    {
        return l != null;
    }

    public boolean isSetDeviceModel()
    {
        return m != null;
    }

    public boolean isSetDeviceSystemName()
    {
        return n != null;
    }

    public boolean isSetDeviceSystemVersion()
    {
        return o != null;
    }

    public boolean isSetEvents()
    {
        return r != null;
    }

    public boolean isSetIpAddress()
    {
        return s != null;
    }

    public boolean isSetRequestTime()
    {
        return k != null;
    }

    public void read(TProtocol tprotocol)
        throws TException
    {
        tprotocol.readStructBegin();
_L12:
        Object obj;
        obj = tprotocol.readFieldBegin();
        if (((TField) (obj)).type == 0)
        {
            break MISSING_BLOCK_LABEL_427;
        }
        ((TField) (obj)).id;
        JVM INSTR tableswitch 1 9: default 72
    //                   1 87
    //                   2 118
    //                   3 149
    //                   4 180
    //                   5 211
    //                   6 242
    //                   7 273
    //                   8 304
    //                   9 396;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L2:
        break; /* Loop/switch isn't completed */
_L10:
        break MISSING_BLOCK_LABEL_396;
_L1:
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L13:
        tprotocol.readFieldEnd();
        if (true) goto _L12; else goto _L11
_L11:
        if (((TField) (obj)).type == 11)
        {
            k = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L13
_L3:
        if (((TField) (obj)).type == 11)
        {
            l = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L13
_L4:
        if (((TField) (obj)).type == 11)
        {
            m = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L13
_L5:
        if (((TField) (obj)).type == 11)
        {
            n = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L13
_L6:
        if (((TField) (obj)).type == 11)
        {
            o = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L13
_L7:
        if (((TField) (obj)).type == 11)
        {
            p = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L13
_L8:
        if (((TField) (obj)).type == 11)
        {
            q = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L13
_L9:
        int i1;
        if (((TField) (obj)).type != 15)
        {
            break MISSING_BLOCK_LABEL_385;
        }
        obj = tprotocol.readListBegin();
        r = new ArrayList(((TList) (obj)).size);
        i1 = 0;
_L14:
label0:
        {
            if (i1 < ((TList) (obj)).size)
            {
                break label0;
            }
            tprotocol.readListEnd();
        }
          goto _L13
        Event event = new Event();
        event.read(tprotocol);
        r.add(event);
        i1++;
          goto _L14
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
          goto _L13
        if (((TField) (obj)).type == 11)
        {
            s = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L13
        tprotocol.readStructEnd();
        validate();
        return;
    }

    public void setAppID(String s1)
    {
        p = s1;
    }

    public void setAppVersion(String s1)
    {
        q = s1;
    }

    public void setDeviceID(String s1)
    {
        l = s1;
    }

    public void setDeviceModel(String s1)
    {
        m = s1;
    }

    public void setDeviceSystemName(String s1)
    {
        n = s1;
    }

    public void setDeviceSystemVersion(String s1)
    {
        o = s1;
    }

    public void setEvents(List list)
    {
        r = list;
    }

    public void setFieldValue(int i1, Object obj)
    {
        switch (i1)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i1).append(" doesn't exist!").toString());

        case 1: // '\001'
            if (obj == null)
            {
                unsetRequestTime();
                return;
            } else
            {
                setRequestTime((String)obj);
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetDeviceID();
                return;
            } else
            {
                setDeviceID((String)obj);
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetDeviceModel();
                return;
            } else
            {
                setDeviceModel((String)obj);
                return;
            }

        case 4: // '\004'
            if (obj == null)
            {
                unsetDeviceSystemName();
                return;
            } else
            {
                setDeviceSystemName((String)obj);
                return;
            }

        case 5: // '\005'
            if (obj == null)
            {
                unsetDeviceSystemVersion();
                return;
            } else
            {
                setDeviceSystemVersion((String)obj);
                return;
            }

        case 6: // '\006'
            if (obj == null)
            {
                unsetAppID();
                return;
            } else
            {
                setAppID((String)obj);
                return;
            }

        case 7: // '\007'
            if (obj == null)
            {
                unsetAppVersion();
                return;
            } else
            {
                setAppVersion((String)obj);
                return;
            }

        case 8: // '\b'
            if (obj == null)
            {
                unsetEvents();
                return;
            } else
            {
                setEvents((List)obj);
                return;
            }

        case 9: // '\t'
            break;
        }
        if (obj == null)
        {
            unsetIpAddress();
            return;
        } else
        {
            setIpAddress((String)obj);
            return;
        }
    }

    public void setIpAddress(String s1)
    {
        s = s1;
    }

    public void setRequestTime(String s1)
    {
        k = s1;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("MMV1Request(");
        stringbuilder.append("requestTime:");
        if (k == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(k);
        }
        stringbuilder.append(", ");
        stringbuilder.append("deviceID:");
        if (l == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(l);
        }
        stringbuilder.append(", ");
        stringbuilder.append("deviceModel:");
        if (m == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(m);
        }
        stringbuilder.append(", ");
        stringbuilder.append("deviceSystemName:");
        if (n == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(n);
        }
        stringbuilder.append(", ");
        stringbuilder.append("deviceSystemVersion:");
        if (o == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(o);
        }
        stringbuilder.append(", ");
        stringbuilder.append("appID:");
        if (p == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(p);
        }
        stringbuilder.append(", ");
        stringbuilder.append("appVersion:");
        if (q == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(q);
        }
        if (isSetEvents())
        {
            stringbuilder.append(", ");
            stringbuilder.append("events:");
            if (r == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(r);
            }
        }
        if (isSetIpAddress())
        {
            stringbuilder.append(", ");
            stringbuilder.append("ipAddress:");
            if (s == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(s);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetAppID()
    {
        p = null;
    }

    public void unsetAppVersion()
    {
        q = null;
    }

    public void unsetDeviceID()
    {
        l = null;
    }

    public void unsetDeviceModel()
    {
        m = null;
    }

    public void unsetDeviceSystemName()
    {
        n = null;
    }

    public void unsetDeviceSystemVersion()
    {
        o = null;
    }

    public void unsetEvents()
    {
        r = null;
    }

    public void unsetIpAddress()
    {
        s = null;
    }

    public void unsetRequestTime()
    {
        k = null;
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
        if (k != null)
        {
            tprotocol.writeFieldBegin(b);
            tprotocol.writeString(k);
            tprotocol.writeFieldEnd();
        }
        if (l != null)
        {
            tprotocol.writeFieldBegin(c);
            tprotocol.writeString(l);
            tprotocol.writeFieldEnd();
        }
        if (m != null)
        {
            tprotocol.writeFieldBegin(d);
            tprotocol.writeString(m);
            tprotocol.writeFieldEnd();
        }
        if (n != null)
        {
            tprotocol.writeFieldBegin(e);
            tprotocol.writeString(n);
            tprotocol.writeFieldEnd();
        }
        if (o != null)
        {
            tprotocol.writeFieldBegin(f);
            tprotocol.writeString(o);
            tprotocol.writeFieldEnd();
        }
        if (p != null)
        {
            tprotocol.writeFieldBegin(g);
            tprotocol.writeString(p);
            tprotocol.writeFieldEnd();
        }
        if (q != null)
        {
            tprotocol.writeFieldBegin(h);
            tprotocol.writeString(q);
            tprotocol.writeFieldEnd();
        }
        if (r == null || !isSetEvents()) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        tprotocol.writeFieldBegin(i);
        tprotocol.writeListBegin(new TList((byte)12, r.size()));
        iterator = r.iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        tprotocol.writeListEnd();
        tprotocol.writeFieldEnd();
_L2:
        if (s != null && isSetIpAddress())
        {
            tprotocol.writeFieldBegin(j);
            tprotocol.writeString(s);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
        return;
_L4:
        ((Event)iterator.next()).write(tprotocol);
        if (true) goto _L6; else goto _L5
_L5:
    }

    static 
    {
        metaDataMap = Collections.unmodifiableMap(new c());
        FieldMetaData.addStructMetaDataMap(com/medialets/thrift/MMV1Request, metaDataMap);
    }

    // Unreferenced inner class com/medialets/thrift/c
    final class c extends HashMap
    {

            c()
            {
                put(Integer.valueOf(1), new FieldMetaData("requestTime", (byte)3, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(2), new FieldMetaData("deviceID", (byte)3, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(3), new FieldMetaData("deviceModel", (byte)3, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(4), new FieldMetaData("deviceSystemName", (byte)3, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(5), new FieldMetaData("deviceSystemVersion", (byte)3, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(6), new FieldMetaData("appID", (byte)3, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(7), new FieldMetaData("appVersion", (byte)3, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(8), new FieldMetaData("events", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/medialets/thrift/Event))));
                put(Integer.valueOf(9), new FieldMetaData("ipAddress", (byte)2, new FieldValueMetaData((byte)11)));
            }
    }

}
