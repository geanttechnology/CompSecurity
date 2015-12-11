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
//            j, Run

public class BroadcastData
    implements Serializable, Cloneable, TBase
{
    private static final class a
        implements Serializable
    {

        public boolean alt;
        public boolean horizontalAccuracy;
        public boolean lat;
        public boolean locSrvOn;
        public boolean locTrOn;
        public boolean lon;
        public boolean verticalAccuracy;

        a()
        {
            this((byte)0);
        }

        private a(byte byte0)
        {
            locTrOn = false;
            locSrvOn = false;
            lat = false;
            lon = false;
            alt = false;
            horizontalAccuracy = false;
            verticalAccuracy = false;
        }
    }


    public static final int ALT = 6;
    public static final int HORIZONTALACCURACY = 7;
    public static final int LAT = 4;
    public static final int LOCSRVON = 3;
    public static final int LOCTRON = 2;
    public static final int LON = 5;
    public static final int REV = 10;
    public static final int RUNS = 9;
    public static final int TIME = 1;
    public static final int VERTICALACCURACY = 8;
    private static final TStruct a = new TStruct("BroadcastData");
    private static final TField b = new TField("time", (byte)11, (short)1);
    private static final TField c = new TField("locTrOn", (byte)2, (short)2);
    private static final TField d = new TField("locSrvOn", (byte)2, (short)3);
    private static final TField e = new TField("lat", (byte)4, (short)4);
    private static final TField f = new TField("lon", (byte)4, (short)5);
    private static final TField g = new TField("alt", (byte)4, (short)6);
    private static final TField h = new TField("horizontalAccuracy", (byte)4, (short)7);
    private static final TField i = new TField("verticalAccuracy", (byte)4, (short)8);
    private static final TField j = new TField("runs", (byte)15, (short)9);
    private static final TField k = new TField("rev", (byte)11, (short)10);
    public static final Map metaDataMap;
    private String l;
    private boolean m;
    private boolean n;
    private double o;
    private double p;
    private double q;
    private double r;
    private double s;
    private List t;
    private String u;
    private final a v;

    public BroadcastData()
    {
        v = new a();
    }

    public BroadcastData(BroadcastData broadcastdata)
    {
        v = new a();
        if (broadcastdata.isSetTime())
        {
            l = broadcastdata.l;
        }
        v.locTrOn = broadcastdata.v.locTrOn;
        m = broadcastdata.m;
        v.locSrvOn = broadcastdata.v.locSrvOn;
        n = broadcastdata.n;
        v.lat = broadcastdata.v.lat;
        o = broadcastdata.o;
        v.lon = broadcastdata.v.lon;
        p = broadcastdata.p;
        v.alt = broadcastdata.v.alt;
        q = broadcastdata.q;
        v.horizontalAccuracy = broadcastdata.v.horizontalAccuracy;
        r = broadcastdata.r;
        v.verticalAccuracy = broadcastdata.v.verticalAccuracy;
        s = broadcastdata.s;
        if (!broadcastdata.isSetRuns()) goto _L2; else goto _L1
_L1:
        ArrayList arraylist;
        Iterator iterator;
        arraylist = new ArrayList();
        iterator = broadcastdata.t.iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        t = arraylist;
_L2:
        if (broadcastdata.isSetRev())
        {
            u = broadcastdata.u;
        }
        return;
_L4:
        arraylist.add(new Run((Run)iterator.next()));
        if (true) goto _L6; else goto _L5
_L5:
    }

    public BroadcastData(String s1, boolean flag, boolean flag1, double d1, double d2, 
            double d3, double d4, double d5, List list, 
            String s2)
    {
        this();
        l = s1;
        m = flag;
        v.locTrOn = true;
        n = flag1;
        v.locSrvOn = true;
        o = d1;
        v.lat = true;
        p = d2;
        v.lon = true;
        q = d3;
        v.alt = true;
        r = d4;
        v.horizontalAccuracy = true;
        s = d5;
        v.verticalAccuracy = true;
        t = list;
        u = s2;
    }

    public void addToRuns(Run run)
    {
        if (t == null)
        {
            t = new ArrayList();
        }
        t.add(run);
    }

    public BroadcastData clone()
    {
        return new BroadcastData(this);
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public boolean equals(BroadcastData broadcastdata)
    {
        if (broadcastdata != null)
        {
            boolean flag;
            boolean flag1;
            if (isSetTime())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (broadcastdata.isSetTime())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if ((!flag && !flag1 || flag && flag1 && l.equals(broadcastdata.l)) && m == broadcastdata.m && n == broadcastdata.n)
            {
                if (isSetLat())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (broadcastdata.isSetLat())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (!flag && !flag1 || flag && flag1 && o == broadcastdata.o)
                {
                    if (isSetLon())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (broadcastdata.isSetLon())
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (!flag && !flag1 || flag && flag1 && p == broadcastdata.p)
                    {
                        if (isSetAlt())
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        if (broadcastdata.isSetAlt())
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        if (!flag && !flag1 || flag && flag1 && q == broadcastdata.q)
                        {
                            if (isSetHorizontalAccuracy())
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                            if (broadcastdata.isSetHorizontalAccuracy())
                            {
                                flag1 = true;
                            } else
                            {
                                flag1 = false;
                            }
                            if (!flag && !flag1 || flag && flag1 && r == broadcastdata.r)
                            {
                                if (isSetVerticalAccuracy())
                                {
                                    flag = true;
                                } else
                                {
                                    flag = false;
                                }
                                if (broadcastdata.isSetVerticalAccuracy())
                                {
                                    flag1 = true;
                                } else
                                {
                                    flag1 = false;
                                }
                                if (!flag && !flag1 || flag && flag1 && s == broadcastdata.s)
                                {
                                    if (isSetRuns())
                                    {
                                        flag = true;
                                    } else
                                    {
                                        flag = false;
                                    }
                                    if (broadcastdata.isSetRuns())
                                    {
                                        flag1 = true;
                                    } else
                                    {
                                        flag1 = false;
                                    }
                                    if (!flag && !flag1 || flag && flag1 && t.equals(broadcastdata.t))
                                    {
                                        if (isSetRev())
                                        {
                                            flag = true;
                                        } else
                                        {
                                            flag = false;
                                        }
                                        if (broadcastdata.isSetRev())
                                        {
                                            flag1 = true;
                                        } else
                                        {
                                            flag1 = false;
                                        }
                                        if (!flag && !flag1 || flag && flag1 && u.equals(broadcastdata.u))
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
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof BroadcastData)) 
        {
            return false;
        }
        return equals((BroadcastData)obj);
    }

    public double getAlt()
    {
        return q;
    }

    public Object getFieldValue(int i1)
    {
        switch (i1)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i1).append(" doesn't exist!").toString());

        case 1: // '\001'
            return getTime();

        case 2: // '\002'
            return new Boolean(isLocTrOn());

        case 3: // '\003'
            return new Boolean(isLocSrvOn());

        case 4: // '\004'
            return new Double(getLat());

        case 5: // '\005'
            return new Double(getLon());

        case 6: // '\006'
            return new Double(getAlt());

        case 7: // '\007'
            return new Double(getHorizontalAccuracy());

        case 8: // '\b'
            return new Double(getVerticalAccuracy());

        case 9: // '\t'
            return getRuns();

        case 10: // '\n'
            return getRev();
        }
    }

    public double getHorizontalAccuracy()
    {
        return r;
    }

    public double getLat()
    {
        return o;
    }

    public double getLon()
    {
        return p;
    }

    public String getRev()
    {
        return u;
    }

    public List getRuns()
    {
        return t;
    }

    public Iterator getRunsIterator()
    {
        if (t == null)
        {
            return null;
        } else
        {
            return t.iterator();
        }
    }

    public int getRunsSize()
    {
        if (t == null)
        {
            return 0;
        } else
        {
            return t.size();
        }
    }

    public String getTime()
    {
        return l;
    }

    public double getVerticalAccuracy()
    {
        return s;
    }

    public int hashCode()
    {
        return 0;
    }

    public boolean isLocSrvOn()
    {
        return n;
    }

    public boolean isLocTrOn()
    {
        return m;
    }

    public boolean isSet(int i1)
    {
        switch (i1)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i1).append(" doesn't exist!").toString());

        case 1: // '\001'
            return isSetTime();

        case 2: // '\002'
            return isSetLocTrOn();

        case 3: // '\003'
            return isSetLocSrvOn();

        case 4: // '\004'
            return isSetLat();

        case 5: // '\005'
            return isSetLon();

        case 6: // '\006'
            return isSetAlt();

        case 7: // '\007'
            return isSetHorizontalAccuracy();

        case 8: // '\b'
            return isSetVerticalAccuracy();

        case 9: // '\t'
            return isSetRuns();

        case 10: // '\n'
            return isSetRev();
        }
    }

    public boolean isSetAlt()
    {
        return v.alt;
    }

    public boolean isSetHorizontalAccuracy()
    {
        return v.horizontalAccuracy;
    }

    public boolean isSetLat()
    {
        return v.lat;
    }

    public boolean isSetLocSrvOn()
    {
        return v.locSrvOn;
    }

    public boolean isSetLocTrOn()
    {
        return v.locTrOn;
    }

    public boolean isSetLon()
    {
        return v.lon;
    }

    public boolean isSetRev()
    {
        return u != null;
    }

    public boolean isSetRuns()
    {
        return t != null;
    }

    public boolean isSetTime()
    {
        return l != null;
    }

    public boolean isSetVerticalAccuracy()
    {
        return v.verticalAccuracy;
    }

    public void read(TProtocol tprotocol)
        throws TException
    {
        tprotocol.readStructBegin();
_L13:
        Object obj;
        obj = tprotocol.readFieldBegin();
        if (((TField) (obj)).type == 0)
        {
            break MISSING_BLOCK_LABEL_511;
        }
        ((TField) (obj)).id;
        JVM INSTR tableswitch 1 10: default 76
    //                   1 91
    //                   2 122
    //                   3 160
    //                   4 198
    //                   5 236
    //                   6 274
    //                   7 312
    //                   8 350
    //                   9 388
    //                   10 480;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L2:
        break; /* Loop/switch isn't completed */
_L11:
        break MISSING_BLOCK_LABEL_480;
_L1:
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L14:
        tprotocol.readFieldEnd();
        if (true) goto _L13; else goto _L12
_L12:
        if (((TField) (obj)).type == 11)
        {
            l = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L14
_L3:
        if (((TField) (obj)).type == 2)
        {
            m = tprotocol.readBool();
            v.locTrOn = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L14
_L4:
        if (((TField) (obj)).type == 2)
        {
            n = tprotocol.readBool();
            v.locSrvOn = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L14
_L5:
        if (((TField) (obj)).type == 4)
        {
            o = tprotocol.readDouble();
            v.lat = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L14
_L6:
        if (((TField) (obj)).type == 4)
        {
            p = tprotocol.readDouble();
            v.lon = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L14
_L7:
        if (((TField) (obj)).type == 4)
        {
            q = tprotocol.readDouble();
            v.alt = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L14
_L8:
        if (((TField) (obj)).type == 4)
        {
            r = tprotocol.readDouble();
            v.horizontalAccuracy = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L14
_L9:
        if (((TField) (obj)).type == 4)
        {
            s = tprotocol.readDouble();
            v.verticalAccuracy = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L14
_L10:
        int i1;
        if (((TField) (obj)).type != 15)
        {
            break MISSING_BLOCK_LABEL_469;
        }
        obj = tprotocol.readListBegin();
        t = new ArrayList(((TList) (obj)).size);
        i1 = 0;
_L15:
label0:
        {
            if (i1 < ((TList) (obj)).size)
            {
                break label0;
            }
            tprotocol.readListEnd();
        }
          goto _L14
        Run run = new Run();
        run.read(tprotocol);
        t.add(run);
        i1++;
          goto _L15
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
          goto _L14
        if (((TField) (obj)).type == 11)
        {
            u = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L14
        tprotocol.readStructEnd();
        validate();
        return;
    }

    public void setAlt(double d1)
    {
        q = d1;
        v.alt = true;
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
                unsetTime();
                return;
            } else
            {
                setTime((String)obj);
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetLocTrOn();
                return;
            } else
            {
                setLocTrOn(((Boolean)obj).booleanValue());
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetLocSrvOn();
                return;
            } else
            {
                setLocSrvOn(((Boolean)obj).booleanValue());
                return;
            }

        case 4: // '\004'
            if (obj == null)
            {
                unsetLat();
                return;
            } else
            {
                setLat(((Double)obj).doubleValue());
                return;
            }

        case 5: // '\005'
            if (obj == null)
            {
                unsetLon();
                return;
            } else
            {
                setLon(((Double)obj).doubleValue());
                return;
            }

        case 6: // '\006'
            if (obj == null)
            {
                unsetAlt();
                return;
            } else
            {
                setAlt(((Double)obj).doubleValue());
                return;
            }

        case 7: // '\007'
            if (obj == null)
            {
                unsetHorizontalAccuracy();
                return;
            } else
            {
                setHorizontalAccuracy(((Double)obj).doubleValue());
                return;
            }

        case 8: // '\b'
            if (obj == null)
            {
                unsetVerticalAccuracy();
                return;
            } else
            {
                setVerticalAccuracy(((Double)obj).doubleValue());
                return;
            }

        case 9: // '\t'
            if (obj == null)
            {
                unsetRuns();
                return;
            } else
            {
                setRuns((List)obj);
                return;
            }

        case 10: // '\n'
            break;
        }
        if (obj == null)
        {
            unsetRev();
            return;
        } else
        {
            setRev((String)obj);
            return;
        }
    }

    public void setHorizontalAccuracy(double d1)
    {
        r = d1;
        v.horizontalAccuracy = true;
    }

    public void setLat(double d1)
    {
        o = d1;
        v.lat = true;
    }

    public void setLocSrvOn(boolean flag)
    {
        n = flag;
        v.locSrvOn = true;
    }

    public void setLocTrOn(boolean flag)
    {
        m = flag;
        v.locTrOn = true;
    }

    public void setLon(double d1)
    {
        p = d1;
        v.lon = true;
    }

    public void setRev(String s1)
    {
        u = s1;
    }

    public void setRuns(List list)
    {
        t = list;
    }

    public void setTime(String s1)
    {
        l = s1;
    }

    public void setVerticalAccuracy(double d1)
    {
        s = d1;
        v.verticalAccuracy = true;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("BroadcastData(");
        stringbuilder.append("time:");
        if (l == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(l);
        }
        stringbuilder.append(", ");
        stringbuilder.append("locTrOn:");
        stringbuilder.append(m);
        stringbuilder.append(", ");
        stringbuilder.append("locSrvOn:");
        stringbuilder.append(n);
        if (isSetLat())
        {
            stringbuilder.append(", ");
            stringbuilder.append("lat:");
            stringbuilder.append(o);
        }
        if (isSetLon())
        {
            stringbuilder.append(", ");
            stringbuilder.append("lon:");
            stringbuilder.append(p);
        }
        if (isSetAlt())
        {
            stringbuilder.append(", ");
            stringbuilder.append("alt:");
            stringbuilder.append(q);
        }
        if (isSetHorizontalAccuracy())
        {
            stringbuilder.append(", ");
            stringbuilder.append("horizontalAccuracy:");
            stringbuilder.append(r);
        }
        if (isSetVerticalAccuracy())
        {
            stringbuilder.append(", ");
            stringbuilder.append("verticalAccuracy:");
            stringbuilder.append(s);
        }
        stringbuilder.append(", ");
        stringbuilder.append("runs:");
        if (t == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(t);
        }
        stringbuilder.append(", ");
        stringbuilder.append("rev:");
        if (u == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(u);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetAlt()
    {
        v.alt = false;
    }

    public void unsetHorizontalAccuracy()
    {
        v.horizontalAccuracy = false;
    }

    public void unsetLat()
    {
        v.lat = false;
    }

    public void unsetLocSrvOn()
    {
        v.locSrvOn = false;
    }

    public void unsetLocTrOn()
    {
        v.locTrOn = false;
    }

    public void unsetLon()
    {
        v.lon = false;
    }

    public void unsetRev()
    {
        u = null;
    }

    public void unsetRuns()
    {
        t = null;
    }

    public void unsetTime()
    {
        l = null;
    }

    public void unsetVerticalAccuracy()
    {
        v.verticalAccuracy = false;
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
        if (l != null)
        {
            tprotocol.writeFieldBegin(b);
            tprotocol.writeString(l);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldBegin(c);
        tprotocol.writeBool(m);
        tprotocol.writeFieldEnd();
        tprotocol.writeFieldBegin(d);
        tprotocol.writeBool(n);
        tprotocol.writeFieldEnd();
        if (isSetLat())
        {
            tprotocol.writeFieldBegin(e);
            tprotocol.writeDouble(o);
            tprotocol.writeFieldEnd();
        }
        if (isSetLon())
        {
            tprotocol.writeFieldBegin(f);
            tprotocol.writeDouble(p);
            tprotocol.writeFieldEnd();
        }
        if (isSetAlt())
        {
            tprotocol.writeFieldBegin(g);
            tprotocol.writeDouble(q);
            tprotocol.writeFieldEnd();
        }
        if (isSetHorizontalAccuracy())
        {
            tprotocol.writeFieldBegin(h);
            tprotocol.writeDouble(r);
            tprotocol.writeFieldEnd();
        }
        if (isSetVerticalAccuracy())
        {
            tprotocol.writeFieldBegin(i);
            tprotocol.writeDouble(s);
            tprotocol.writeFieldEnd();
        }
        if (t == null) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        tprotocol.writeFieldBegin(j);
        tprotocol.writeListBegin(new TList((byte)12, t.size()));
        iterator = t.iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        tprotocol.writeListEnd();
        tprotocol.writeFieldEnd();
_L2:
        if (u != null)
        {
            tprotocol.writeFieldBegin(k);
            tprotocol.writeString(u);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
        return;
_L4:
        ((Run)iterator.next()).write(tprotocol);
        if (true) goto _L6; else goto _L5
_L5:
    }

    static 
    {
        metaDataMap = Collections.unmodifiableMap(new j());
        FieldMetaData.addStructMetaDataMap(com/medialets/thrift/BroadcastData, metaDataMap);
    }

    // Unreferenced inner class com/medialets/thrift/j
    final class j extends HashMap
    {

            j()
            {
                put(Integer.valueOf(1), new FieldMetaData("time", (byte)3, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(2), new FieldMetaData("locTrOn", (byte)3, new FieldValueMetaData((byte)2)));
                put(Integer.valueOf(3), new FieldMetaData("locSrvOn", (byte)3, new FieldValueMetaData((byte)2)));
                put(Integer.valueOf(4), new FieldMetaData("lat", (byte)2, new FieldValueMetaData((byte)4)));
                put(Integer.valueOf(5), new FieldMetaData("lon", (byte)2, new FieldValueMetaData((byte)4)));
                put(Integer.valueOf(6), new FieldMetaData("alt", (byte)2, new FieldValueMetaData((byte)4)));
                put(Integer.valueOf(7), new FieldMetaData("horizontalAccuracy", (byte)2, new FieldValueMetaData((byte)4)));
                put(Integer.valueOf(8), new FieldMetaData("verticalAccuracy", (byte)2, new FieldValueMetaData((byte)4)));
                put(Integer.valueOf(9), new FieldMetaData("runs", (byte)3, new ListMetaData((byte)15, new StructMetaData((byte)12, com/medialets/thrift/Run))));
                put(Integer.valueOf(10), new FieldMetaData("rev", (byte)3, new FieldValueMetaData((byte)11)));
            }
    }

}
