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
import java.util.Set;
import org.apache.thrift.IntRangeSet;
import org.apache.thrift.TBase;
import org.apache.thrift.TException;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.meta_data.ListMetaData;
import org.apache.thrift.meta_data.MapMetaData;
import org.apache.thrift.meta_data.StructMetaData;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TList;
import org.apache.thrift.protocol.TMap;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.protocol.TStruct;

// Referenced classes of package com.medialets.thrift:
//            g, MMStringData, MMNumberData, connectionState

public class Event
    implements Serializable, Cloneable, TBase
{
    private static final class a
        implements Serializable
    {

        public boolean alt;
        public boolean conn;
        public boolean countDay;
        public boolean countHr;
        public boolean countMon;
        public boolean direction;
        public boolean directionAccuracy;
        public boolean horizontalAccuracy;
        public boolean lat;
        public boolean lon;
        public boolean uCount;
        public boolean uDur;
        public boolean verticalAccuracy;

        a()
        {
            this((byte)0);
        }

        private a(byte byte0)
        {
            conn = false;
            countHr = false;
            countDay = false;
            countMon = false;
            lat = false;
            lon = false;
            alt = false;
            uCount = false;
            uDur = false;
            horizontalAccuracy = false;
            verticalAccuracy = false;
            direction = false;
            directionAccuracy = false;
        }
    }


    public static final int ALT = 10;
    public static final int CONN = 4;
    public static final int COUNTDAY = 6;
    public static final int COUNTHR = 5;
    public static final int COUNTMON = 7;
    public static final int DIRECTION = 19;
    public static final int DIRECTIONACCURACY = 20;
    public static final int DURATIONVALUES = 18;
    public static final int EVENTID = 1;
    public static final int HORIZONTALACCURACY = 14;
    public static final int KEY = 2;
    public static final int LAT = 8;
    public static final int LON = 9;
    public static final int NUMERICVALUES = 17;
    public static final int STRINGVALUES = 16;
    public static final int TIME = 3;
    public static final int UCOUNT = 11;
    public static final int UDICT = 13;
    public static final int UDUR = 12;
    public static final int VERTICALACCURACY = 15;
    private static final TStruct a = new TStruct("Event");
    private static final TField b = new TField("eventID", (byte)11, (short)1);
    private static final TField c = new TField("key", (byte)11, (short)2);
    private static final TField d = new TField("time", (byte)11, (short)3);
    private static final TField e = new TField("conn", (byte)8, (short)4);
    private static final TField f = new TField("countHr", (byte)6, (short)5);
    private static final TField g = new TField("countDay", (byte)6, (short)6);
    private static final TField h = new TField("countMon", (byte)6, (short)7);
    private static final TField i = new TField("lat", (byte)4, (short)8);
    private static final TField j = new TField("lon", (byte)4, (short)9);
    private static final TField k = new TField("alt", (byte)4, (short)10);
    private static final TField l = new TField("uCount", (byte)6, (short)11);
    private static final TField m = new TField("uDur", (byte)6, (short)12);
    public static final Map metaDataMap;
    private static final TField n = new TField("uDict", (byte)13, (short)13);
    private static final TField o = new TField("horizontalAccuracy", (byte)4, (short)14);
    private static final TField p = new TField("verticalAccuracy", (byte)4, (short)15);
    private static final TField q = new TField("stringValues", (byte)15, (short)16);
    private static final TField r = new TField("numericValues", (byte)15, (short)17);
    private static final TField s = new TField("durationValues", (byte)15, (short)18);
    private static final TField t = new TField("direction", (byte)4, (short)19);
    private static final TField u = new TField("directionAccuracy", (byte)4, (short)20);
    private short A;
    private short B;
    private double C;
    private double D;
    private double E;
    private short F;
    private short G;
    private Map H;
    private double I;
    private double J;
    private List K;
    private List L;
    private List M;
    private double N;
    private double O;
    private final a P;
    private String v;
    private String w;
    private String x;
    private int y;
    private short z;

    public Event()
    {
        P = new a();
    }

    public Event(Event event)
    {
        P = new a();
        if (event.isSetEventID())
        {
            v = event.v;
        }
        if (event.isSetKey())
        {
            w = event.w;
        }
        if (event.isSetTime())
        {
            x = event.x;
        }
        P.conn = event.P.conn;
        y = event.y;
        P.countHr = event.P.countHr;
        z = event.z;
        P.countDay = event.P.countDay;
        A = event.A;
        P.countMon = event.P.countMon;
        B = event.B;
        P.lat = event.P.lat;
        C = event.C;
        P.lon = event.P.lon;
        D = event.D;
        P.alt = event.P.alt;
        E = event.E;
        P.uCount = event.P.uCount;
        F = event.F;
        P.uDur = event.P.uDur;
        G = event.G;
        if (!event.isSetUDict()) goto _L2; else goto _L1
_L1:
        Object obj;
        Iterator iterator;
        obj = new HashMap();
        iterator = event.H.entrySet().iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        H = ((Map) (obj));
_L2:
        P.horizontalAccuracy = event.P.horizontalAccuracy;
        I = event.I;
        P.verticalAccuracy = event.P.verticalAccuracy;
        J = event.J;
        if (event.isSetStringValues())
        {
            obj = new ArrayList();
            java.util.Map.Entry entry;
            for (iterator = event.K.iterator(); iterator.hasNext(); ((List) (obj)).add(new MMStringData((MMStringData)iterator.next())))
            {
                break MISSING_BLOCK_LABEL_549;
            }

            K = ((List) (obj));
        }
        if (event.isSetNumericValues())
        {
            obj = new ArrayList();
            for (iterator = event.L.iterator(); iterator.hasNext(); ((List) (obj)).add(new MMNumberData((MMNumberData)iterator.next())))
            {
                break MISSING_BLOCK_LABEL_575;
            }

            L = ((List) (obj));
        }
        if (event.isSetDurationValues())
        {
            obj = new ArrayList();
            for (iterator = event.M.iterator(); iterator.hasNext(); ((List) (obj)).add(new MMNumberData((MMNumberData)iterator.next())))
            {
                break MISSING_BLOCK_LABEL_601;
            }

            M = ((List) (obj));
        }
        P.direction = event.P.direction;
        N = event.N;
        P.directionAccuracy = event.P.directionAccuracy;
        O = event.O;
        return;
_L4:
        entry = (java.util.Map.Entry)iterator.next();
        ((Map) (obj)).put((String)entry.getKey(), (String)entry.getValue());
        if (true) goto _L6; else goto _L5
_L5:
    }

    public Event(String s1, String s2, String s3, int i1, short word0, short word1, short word2, 
            double d1, double d2, double d3, short word3, 
            short word4, Map map, double d4, double d5, List list, 
            List list1, List list2, double d6, double d7)
    {
        this();
        v = s1;
        w = s2;
        x = s3;
        y = i1;
        P.conn = true;
        z = word0;
        P.countHr = true;
        A = word1;
        P.countDay = true;
        B = word2;
        P.countMon = true;
        C = d1;
        P.lat = true;
        D = d2;
        P.lon = true;
        E = d3;
        P.alt = true;
        F = word3;
        P.uCount = true;
        G = word4;
        P.uDur = true;
        H = map;
        I = d4;
        P.horizontalAccuracy = true;
        J = d5;
        P.verticalAccuracy = true;
        K = list;
        L = list1;
        M = list2;
        N = d6;
        P.direction = true;
        O = d7;
        P.directionAccuracy = true;
    }

    public void addToDurationValues(MMNumberData mmnumberdata)
    {
        if (M == null)
        {
            M = new ArrayList();
        }
        M.add(mmnumberdata);
    }

    public void addToNumericValues(MMNumberData mmnumberdata)
    {
        if (L == null)
        {
            L = new ArrayList();
        }
        L.add(mmnumberdata);
    }

    public void addToStringValues(MMStringData mmstringdata)
    {
        if (K == null)
        {
            K = new ArrayList();
        }
        K.add(mmstringdata);
    }

    public Event clone()
    {
        return new Event(this);
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public boolean equals(Event event)
    {
        if (event != null)
        {
            boolean flag;
            boolean flag1;
            if (isSetEventID())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (event.isSetEventID())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!flag && !flag1 || flag && flag1 && v.equals(event.v))
            {
                if (isSetKey())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (event.isSetKey())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (!flag && !flag1 || flag && flag1 && w.equals(event.w))
                {
                    if (isSetTime())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (event.isSetTime())
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if ((!flag && !flag1 || flag && flag1 && x.equals(event.x)) && y == event.y && z == event.z && A == event.A && B == event.B)
                    {
                        if (isSetLat())
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        if (event.isSetLat())
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        if (!flag && !flag1 || flag && flag1 && C == event.C)
                        {
                            if (isSetLon())
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                            if (event.isSetLon())
                            {
                                flag1 = true;
                            } else
                            {
                                flag1 = false;
                            }
                            if (!flag && !flag1 || flag && flag1 && D == event.D)
                            {
                                if (isSetAlt())
                                {
                                    flag = true;
                                } else
                                {
                                    flag = false;
                                }
                                if (event.isSetAlt())
                                {
                                    flag1 = true;
                                } else
                                {
                                    flag1 = false;
                                }
                                if ((!flag && !flag1 || flag && flag1 && E == event.E) && F == event.F && G == event.G)
                                {
                                    if (isSetUDict())
                                    {
                                        flag = true;
                                    } else
                                    {
                                        flag = false;
                                    }
                                    if (event.isSetUDict())
                                    {
                                        flag1 = true;
                                    } else
                                    {
                                        flag1 = false;
                                    }
                                    if (!flag && !flag1 || flag && flag1 && H.equals(event.H))
                                    {
                                        if (isSetHorizontalAccuracy())
                                        {
                                            flag = true;
                                        } else
                                        {
                                            flag = false;
                                        }
                                        if (event.isSetHorizontalAccuracy())
                                        {
                                            flag1 = true;
                                        } else
                                        {
                                            flag1 = false;
                                        }
                                        if (!flag && !flag1 || flag && flag1 && I == event.I)
                                        {
                                            if (isSetVerticalAccuracy())
                                            {
                                                flag = true;
                                            } else
                                            {
                                                flag = false;
                                            }
                                            if (event.isSetVerticalAccuracy())
                                            {
                                                flag1 = true;
                                            } else
                                            {
                                                flag1 = false;
                                            }
                                            if (!flag && !flag1 || flag && flag1 && J == event.J)
                                            {
                                                if (isSetStringValues())
                                                {
                                                    flag = true;
                                                } else
                                                {
                                                    flag = false;
                                                }
                                                if (event.isSetStringValues())
                                                {
                                                    flag1 = true;
                                                } else
                                                {
                                                    flag1 = false;
                                                }
                                                if (!flag && !flag1 || flag && flag1 && K.equals(event.K))
                                                {
                                                    if (isSetNumericValues())
                                                    {
                                                        flag = true;
                                                    } else
                                                    {
                                                        flag = false;
                                                    }
                                                    if (event.isSetNumericValues())
                                                    {
                                                        flag1 = true;
                                                    } else
                                                    {
                                                        flag1 = false;
                                                    }
                                                    if (!flag && !flag1 || flag && flag1 && L.equals(event.L))
                                                    {
                                                        if (isSetDurationValues())
                                                        {
                                                            flag = true;
                                                        } else
                                                        {
                                                            flag = false;
                                                        }
                                                        if (event.isSetDurationValues())
                                                        {
                                                            flag1 = true;
                                                        } else
                                                        {
                                                            flag1 = false;
                                                        }
                                                        if (!flag && !flag1 || flag && flag1 && M.equals(event.M))
                                                        {
                                                            if (isSetDirection())
                                                            {
                                                                flag = true;
                                                            } else
                                                            {
                                                                flag = false;
                                                            }
                                                            if (event.isSetDirection())
                                                            {
                                                                flag1 = true;
                                                            } else
                                                            {
                                                                flag1 = false;
                                                            }
                                                            if (!flag && !flag1 || flag && flag1 && N == event.N)
                                                            {
                                                                if (isSetDirectionAccuracy())
                                                                {
                                                                    flag = true;
                                                                } else
                                                                {
                                                                    flag = false;
                                                                }
                                                                if (event.isSetDirectionAccuracy())
                                                                {
                                                                    flag1 = true;
                                                                } else
                                                                {
                                                                    flag1 = false;
                                                                }
                                                                if (!flag && !flag1 || flag && flag1 && O == event.O)
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
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof Event)) 
        {
            return false;
        }
        return equals((Event)obj);
    }

    public double getAlt()
    {
        return E;
    }

    public int getConn()
    {
        return y;
    }

    public short getCountDay()
    {
        return A;
    }

    public short getCountHr()
    {
        return z;
    }

    public short getCountMon()
    {
        return B;
    }

    public double getDirection()
    {
        return N;
    }

    public double getDirectionAccuracy()
    {
        return O;
    }

    public List getDurationValues()
    {
        return M;
    }

    public Iterator getDurationValuesIterator()
    {
        if (M == null)
        {
            return null;
        } else
        {
            return M.iterator();
        }
    }

    public int getDurationValuesSize()
    {
        if (M == null)
        {
            return 0;
        } else
        {
            return M.size();
        }
    }

    public String getEventID()
    {
        return v;
    }

    public Object getFieldValue(int i1)
    {
        switch (i1)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i1).append(" doesn't exist!").toString());

        case 1: // '\001'
            return getEventID();

        case 2: // '\002'
            return getKey();

        case 3: // '\003'
            return getTime();

        case 4: // '\004'
            return Integer.valueOf(getConn());

        case 5: // '\005'
            return new Short(getCountHr());

        case 6: // '\006'
            return new Short(getCountDay());

        case 7: // '\007'
            return new Short(getCountMon());

        case 8: // '\b'
            return new Double(getLat());

        case 9: // '\t'
            return new Double(getLon());

        case 10: // '\n'
            return new Double(getAlt());

        case 11: // '\013'
            return new Short(getUCount());

        case 12: // '\f'
            return new Short(getUDur());

        case 13: // '\r'
            return getUDict();

        case 14: // '\016'
            return new Double(getHorizontalAccuracy());

        case 15: // '\017'
            return new Double(getVerticalAccuracy());

        case 16: // '\020'
            return getStringValues();

        case 17: // '\021'
            return getNumericValues();

        case 18: // '\022'
            return getDurationValues();

        case 19: // '\023'
            return new Double(getDirection());

        case 20: // '\024'
            return new Double(getDirectionAccuracy());
        }
    }

    public double getHorizontalAccuracy()
    {
        return I;
    }

    public String getKey()
    {
        return w;
    }

    public double getLat()
    {
        return C;
    }

    public double getLon()
    {
        return D;
    }

    public List getNumericValues()
    {
        return L;
    }

    public Iterator getNumericValuesIterator()
    {
        if (L == null)
        {
            return null;
        } else
        {
            return L.iterator();
        }
    }

    public int getNumericValuesSize()
    {
        if (L == null)
        {
            return 0;
        } else
        {
            return L.size();
        }
    }

    public List getStringValues()
    {
        return K;
    }

    public Iterator getStringValuesIterator()
    {
        if (K == null)
        {
            return null;
        } else
        {
            return K.iterator();
        }
    }

    public int getStringValuesSize()
    {
        if (K == null)
        {
            return 0;
        } else
        {
            return K.size();
        }
    }

    public String getTime()
    {
        return x;
    }

    public short getUCount()
    {
        return F;
    }

    public Map getUDict()
    {
        return H;
    }

    public int getUDictSize()
    {
        if (H == null)
        {
            return 0;
        } else
        {
            return H.size();
        }
    }

    public short getUDur()
    {
        return G;
    }

    public double getVerticalAccuracy()
    {
        return J;
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
            return isSetEventID();

        case 2: // '\002'
            return isSetKey();

        case 3: // '\003'
            return isSetTime();

        case 4: // '\004'
            return isSetConn();

        case 5: // '\005'
            return isSetCountHr();

        case 6: // '\006'
            return isSetCountDay();

        case 7: // '\007'
            return isSetCountMon();

        case 8: // '\b'
            return isSetLat();

        case 9: // '\t'
            return isSetLon();

        case 10: // '\n'
            return isSetAlt();

        case 11: // '\013'
            return isSetUCount();

        case 12: // '\f'
            return isSetUDur();

        case 13: // '\r'
            return isSetUDict();

        case 14: // '\016'
            return isSetHorizontalAccuracy();

        case 15: // '\017'
            return isSetVerticalAccuracy();

        case 16: // '\020'
            return isSetStringValues();

        case 17: // '\021'
            return isSetNumericValues();

        case 18: // '\022'
            return isSetDurationValues();

        case 19: // '\023'
            return isSetDirection();

        case 20: // '\024'
            return isSetDirectionAccuracy();
        }
    }

    public boolean isSetAlt()
    {
        return P.alt;
    }

    public boolean isSetConn()
    {
        return P.conn;
    }

    public boolean isSetCountDay()
    {
        return P.countDay;
    }

    public boolean isSetCountHr()
    {
        return P.countHr;
    }

    public boolean isSetCountMon()
    {
        return P.countMon;
    }

    public boolean isSetDirection()
    {
        return P.direction;
    }

    public boolean isSetDirectionAccuracy()
    {
        return P.directionAccuracy;
    }

    public boolean isSetDurationValues()
    {
        return M != null;
    }

    public boolean isSetEventID()
    {
        return v != null;
    }

    public boolean isSetHorizontalAccuracy()
    {
        return P.horizontalAccuracy;
    }

    public boolean isSetKey()
    {
        return w != null;
    }

    public boolean isSetLat()
    {
        return P.lat;
    }

    public boolean isSetLon()
    {
        return P.lon;
    }

    public boolean isSetNumericValues()
    {
        return L != null;
    }

    public boolean isSetStringValues()
    {
        return K != null;
    }

    public boolean isSetTime()
    {
        return x != null;
    }

    public boolean isSetUCount()
    {
        return P.uCount;
    }

    public boolean isSetUDict()
    {
        return H != null;
    }

    public boolean isSetUDur()
    {
        return P.uDur;
    }

    public boolean isSetVerticalAccuracy()
    {
        return P.verticalAccuracy;
    }

    public void putToUDict(String s1, String s2)
    {
        if (H == null)
        {
            H = new HashMap();
        }
        H.put(s1, s2);
    }

    public void read(TProtocol tprotocol)
        throws TException
    {
        tprotocol.readStructBegin();
_L23:
        Object obj;
        obj = tprotocol.readFieldBegin();
        if (((TField) (obj)).type == 0)
        {
            break MISSING_BLOCK_LABEL_1094;
        }
        ((TField) (obj)).id;
        JVM INSTR tableswitch 1 20: default 116
    //                   1 131
    //                   2 162
    //                   3 193
    //                   4 224
    //                   5 263
    //                   6 302
    //                   7 341
    //                   8 380
    //                   9 418
    //                   10 456
    //                   11 494
    //                   12 533
    //                   13 572
    //                   14 666
    //                   15 704
    //                   16 742
    //                   17 834
    //                   18 926
    //                   19 1018
    //                   20 1056;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21
_L2:
        break; /* Loop/switch isn't completed */
_L21:
        break MISSING_BLOCK_LABEL_1056;
_L1:
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L24:
        tprotocol.readFieldEnd();
        if (true) goto _L23; else goto _L22
_L22:
        if (((TField) (obj)).type == 11)
        {
            v = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L24
_L3:
        if (((TField) (obj)).type == 11)
        {
            w = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L24
_L4:
        if (((TField) (obj)).type == 11)
        {
            x = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L24
_L5:
        if (((TField) (obj)).type == 8)
        {
            y = tprotocol.readI32();
            P.conn = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L24
_L6:
        if (((TField) (obj)).type == 6)
        {
            z = tprotocol.readI16();
            P.countHr = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L24
_L7:
        if (((TField) (obj)).type == 6)
        {
            A = tprotocol.readI16();
            P.countDay = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L24
_L8:
        if (((TField) (obj)).type == 6)
        {
            B = tprotocol.readI16();
            P.countMon = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L24
_L9:
        if (((TField) (obj)).type == 4)
        {
            C = tprotocol.readDouble();
            P.lat = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L24
_L10:
        if (((TField) (obj)).type == 4)
        {
            D = tprotocol.readDouble();
            P.lon = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L24
_L11:
        if (((TField) (obj)).type == 4)
        {
            E = tprotocol.readDouble();
            P.alt = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L24
_L12:
        if (((TField) (obj)).type == 6)
        {
            F = tprotocol.readI16();
            P.uCount = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L24
_L13:
        if (((TField) (obj)).type == 6)
        {
            G = tprotocol.readI16();
            P.uDur = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L24
_L14:
        int i1;
        if (((TField) (obj)).type != 13)
        {
            break MISSING_BLOCK_LABEL_655;
        }
        obj = tprotocol.readMapBegin();
        H = new HashMap(((TMap) (obj)).size * 2);
        i1 = 0;
_L25:
label0:
        {
            if (i1 < ((TMap) (obj)).size)
            {
                break label0;
            }
            tprotocol.readMapEnd();
        }
          goto _L24
        String s1 = tprotocol.readString();
        String s2 = tprotocol.readString();
        H.put(s1, s2);
        i1++;
          goto _L25
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
          goto _L24
_L15:
        if (((TField) (obj)).type == 4)
        {
            I = tprotocol.readDouble();
            P.horizontalAccuracy = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L24
_L16:
        if (((TField) (obj)).type == 4)
        {
            J = tprotocol.readDouble();
            P.verticalAccuracy = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L24
_L17:
        if (((TField) (obj)).type != 15)
        {
            break MISSING_BLOCK_LABEL_823;
        }
        obj = tprotocol.readListBegin();
        K = new ArrayList(((TList) (obj)).size);
        i1 = 0;
_L26:
label1:
        {
            if (i1 < ((TList) (obj)).size)
            {
                break label1;
            }
            tprotocol.readListEnd();
        }
          goto _L24
        MMStringData mmstringdata = new MMStringData();
        mmstringdata.read(tprotocol);
        K.add(mmstringdata);
        i1++;
          goto _L26
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
          goto _L24
_L18:
        if (((TField) (obj)).type != 15)
        {
            break MISSING_BLOCK_LABEL_915;
        }
        obj = tprotocol.readListBegin();
        L = new ArrayList(((TList) (obj)).size);
        i1 = 0;
_L27:
label2:
        {
            if (i1 < ((TList) (obj)).size)
            {
                break label2;
            }
            tprotocol.readListEnd();
        }
          goto _L24
        MMNumberData mmnumberdata = new MMNumberData();
        mmnumberdata.read(tprotocol);
        L.add(mmnumberdata);
        i1++;
          goto _L27
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
          goto _L24
_L19:
        if (((TField) (obj)).type != 15)
        {
            break MISSING_BLOCK_LABEL_1007;
        }
        obj = tprotocol.readListBegin();
        M = new ArrayList(((TList) (obj)).size);
        i1 = 0;
_L28:
label3:
        {
            if (i1 < ((TList) (obj)).size)
            {
                break label3;
            }
            tprotocol.readListEnd();
        }
          goto _L24
        MMNumberData mmnumberdata1 = new MMNumberData();
        mmnumberdata1.read(tprotocol);
        M.add(mmnumberdata1);
        i1++;
          goto _L28
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
          goto _L24
_L20:
        if (((TField) (obj)).type == 4)
        {
            N = tprotocol.readDouble();
            P.direction = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L24
        if (((TField) (obj)).type == 4)
        {
            O = tprotocol.readDouble();
            P.directionAccuracy = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L24
        tprotocol.readStructEnd();
        validate();
        return;
    }

    public void setAlt(double d1)
    {
        E = d1;
        P.alt = true;
    }

    public void setConn(int i1)
    {
        y = i1;
        P.conn = true;
    }

    public void setCountDay(short word0)
    {
        A = word0;
        P.countDay = true;
    }

    public void setCountHr(short word0)
    {
        z = word0;
        P.countHr = true;
    }

    public void setCountMon(short word0)
    {
        B = word0;
        P.countMon = true;
    }

    public void setDirection(double d1)
    {
        N = d1;
        P.direction = true;
    }

    public void setDirectionAccuracy(double d1)
    {
        O = d1;
        P.directionAccuracy = true;
    }

    public void setDurationValues(List list)
    {
        M = list;
    }

    public void setEventID(String s1)
    {
        v = s1;
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
                unsetEventID();
                return;
            } else
            {
                setEventID((String)obj);
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetKey();
                return;
            } else
            {
                setKey((String)obj);
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetTime();
                return;
            } else
            {
                setTime((String)obj);
                return;
            }

        case 4: // '\004'
            if (obj == null)
            {
                unsetConn();
                return;
            } else
            {
                setConn(((Integer)obj).intValue());
                return;
            }

        case 5: // '\005'
            if (obj == null)
            {
                unsetCountHr();
                return;
            } else
            {
                setCountHr(((Short)obj).shortValue());
                return;
            }

        case 6: // '\006'
            if (obj == null)
            {
                unsetCountDay();
                return;
            } else
            {
                setCountDay(((Short)obj).shortValue());
                return;
            }

        case 7: // '\007'
            if (obj == null)
            {
                unsetCountMon();
                return;
            } else
            {
                setCountMon(((Short)obj).shortValue());
                return;
            }

        case 8: // '\b'
            if (obj == null)
            {
                unsetLat();
                return;
            } else
            {
                setLat(((Double)obj).doubleValue());
                return;
            }

        case 9: // '\t'
            if (obj == null)
            {
                unsetLon();
                return;
            } else
            {
                setLon(((Double)obj).doubleValue());
                return;
            }

        case 10: // '\n'
            if (obj == null)
            {
                unsetAlt();
                return;
            } else
            {
                setAlt(((Double)obj).doubleValue());
                return;
            }

        case 11: // '\013'
            if (obj == null)
            {
                unsetUCount();
                return;
            } else
            {
                setUCount(((Short)obj).shortValue());
                return;
            }

        case 12: // '\f'
            if (obj == null)
            {
                unsetUDur();
                return;
            } else
            {
                setUDur(((Short)obj).shortValue());
                return;
            }

        case 13: // '\r'
            if (obj == null)
            {
                unsetUDict();
                return;
            } else
            {
                setUDict((Map)obj);
                return;
            }

        case 14: // '\016'
            if (obj == null)
            {
                unsetHorizontalAccuracy();
                return;
            } else
            {
                setHorizontalAccuracy(((Double)obj).doubleValue());
                return;
            }

        case 15: // '\017'
            if (obj == null)
            {
                unsetVerticalAccuracy();
                return;
            } else
            {
                setVerticalAccuracy(((Double)obj).doubleValue());
                return;
            }

        case 16: // '\020'
            if (obj == null)
            {
                unsetStringValues();
                return;
            } else
            {
                setStringValues((List)obj);
                return;
            }

        case 17: // '\021'
            if (obj == null)
            {
                unsetNumericValues();
                return;
            } else
            {
                setNumericValues((List)obj);
                return;
            }

        case 18: // '\022'
            if (obj == null)
            {
                unsetDurationValues();
                return;
            } else
            {
                setDurationValues((List)obj);
                return;
            }

        case 19: // '\023'
            if (obj == null)
            {
                unsetDirection();
                return;
            } else
            {
                setDirection(((Double)obj).doubleValue());
                return;
            }

        case 20: // '\024'
            break;
        }
        if (obj == null)
        {
            unsetDirectionAccuracy();
            return;
        } else
        {
            setDirectionAccuracy(((Double)obj).doubleValue());
            return;
        }
    }

    public void setHorizontalAccuracy(double d1)
    {
        I = d1;
        P.horizontalAccuracy = true;
    }

    public void setKey(String s1)
    {
        w = s1;
    }

    public void setLat(double d1)
    {
        C = d1;
        P.lat = true;
    }

    public void setLon(double d1)
    {
        D = d1;
        P.lon = true;
    }

    public void setNumericValues(List list)
    {
        L = list;
    }

    public void setStringValues(List list)
    {
        K = list;
    }

    public void setTime(String s1)
    {
        x = s1;
    }

    public void setUCount(short word0)
    {
        F = word0;
        P.uCount = true;
    }

    public void setUDict(Map map)
    {
        H = map;
    }

    public void setUDur(short word0)
    {
        G = word0;
        P.uDur = true;
    }

    public void setVerticalAccuracy(double d1)
    {
        J = d1;
        P.verticalAccuracy = true;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("Event(");
        stringbuilder.append("eventID:");
        String s1;
        if (v == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(v);
        }
        stringbuilder.append(", ");
        stringbuilder.append("key:");
        if (w == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(w);
        }
        stringbuilder.append(", ");
        stringbuilder.append("time:");
        if (x == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(x);
        }
        stringbuilder.append(", ");
        stringbuilder.append("conn:");
        s1 = (String)connectionState.VALUES_TO_NAMES.get(Integer.valueOf(y));
        if (s1 != null)
        {
            stringbuilder.append(s1);
            stringbuilder.append(" (");
        }
        stringbuilder.append(y);
        if (s1 != null)
        {
            stringbuilder.append(")");
        }
        stringbuilder.append(", ");
        stringbuilder.append("countHr:");
        stringbuilder.append(z);
        stringbuilder.append(", ");
        stringbuilder.append("countDay:");
        stringbuilder.append(A);
        stringbuilder.append(", ");
        stringbuilder.append("countMon:");
        stringbuilder.append(B);
        if (isSetLat())
        {
            stringbuilder.append(", ");
            stringbuilder.append("lat:");
            stringbuilder.append(C);
        }
        if (isSetLon())
        {
            stringbuilder.append(", ");
            stringbuilder.append("lon:");
            stringbuilder.append(D);
        }
        if (isSetAlt())
        {
            stringbuilder.append(", ");
            stringbuilder.append("alt:");
            stringbuilder.append(E);
        }
        stringbuilder.append(", ");
        stringbuilder.append("uCount:");
        stringbuilder.append(F);
        stringbuilder.append(", ");
        stringbuilder.append("uDur:");
        stringbuilder.append(G);
        stringbuilder.append(", ");
        stringbuilder.append("uDict:");
        if (H == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(H);
        }
        if (isSetHorizontalAccuracy())
        {
            stringbuilder.append(", ");
            stringbuilder.append("horizontalAccuracy:");
            stringbuilder.append(I);
        }
        if (isSetVerticalAccuracy())
        {
            stringbuilder.append(", ");
            stringbuilder.append("verticalAccuracy:");
            stringbuilder.append(J);
        }
        if (isSetStringValues())
        {
            stringbuilder.append(", ");
            stringbuilder.append("stringValues:");
            if (K == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(K);
            }
        }
        if (isSetNumericValues())
        {
            stringbuilder.append(", ");
            stringbuilder.append("numericValues:");
            if (L == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(L);
            }
        }
        if (isSetDurationValues())
        {
            stringbuilder.append(", ");
            stringbuilder.append("durationValues:");
            if (M == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(M);
            }
        }
        if (isSetDirection())
        {
            stringbuilder.append(", ");
            stringbuilder.append("direction:");
            stringbuilder.append(N);
        }
        if (isSetDirectionAccuracy())
        {
            stringbuilder.append(", ");
            stringbuilder.append("directionAccuracy:");
            stringbuilder.append(O);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetAlt()
    {
        P.alt = false;
    }

    public void unsetConn()
    {
        P.conn = false;
    }

    public void unsetCountDay()
    {
        P.countDay = false;
    }

    public void unsetCountHr()
    {
        P.countHr = false;
    }

    public void unsetCountMon()
    {
        P.countMon = false;
    }

    public void unsetDirection()
    {
        P.direction = false;
    }

    public void unsetDirectionAccuracy()
    {
        P.directionAccuracy = false;
    }

    public void unsetDurationValues()
    {
        M = null;
    }

    public void unsetEventID()
    {
        v = null;
    }

    public void unsetHorizontalAccuracy()
    {
        P.horizontalAccuracy = false;
    }

    public void unsetKey()
    {
        w = null;
    }

    public void unsetLat()
    {
        P.lat = false;
    }

    public void unsetLon()
    {
        P.lon = false;
    }

    public void unsetNumericValues()
    {
        L = null;
    }

    public void unsetStringValues()
    {
        K = null;
    }

    public void unsetTime()
    {
        x = null;
    }

    public void unsetUCount()
    {
        P.uCount = false;
    }

    public void unsetUDict()
    {
        H = null;
    }

    public void unsetUDur()
    {
        P.uDur = false;
    }

    public void unsetVerticalAccuracy()
    {
        P.verticalAccuracy = false;
    }

    public void validate()
        throws TException
    {
        if (isSetConn() && !connectionState.VALID_VALUES.contains(y))
        {
            throw new TProtocolException((new StringBuilder("The field 'conn' has been assigned the invalid value ")).append(y).toString());
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
        if (v != null)
        {
            tprotocol.writeFieldBegin(b);
            tprotocol.writeString(v);
            tprotocol.writeFieldEnd();
        }
        if (w != null)
        {
            tprotocol.writeFieldBegin(c);
            tprotocol.writeString(w);
            tprotocol.writeFieldEnd();
        }
        if (x != null)
        {
            tprotocol.writeFieldBegin(d);
            tprotocol.writeString(x);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldBegin(e);
        tprotocol.writeI32(y);
        tprotocol.writeFieldEnd();
        tprotocol.writeFieldBegin(f);
        tprotocol.writeI16(z);
        tprotocol.writeFieldEnd();
        tprotocol.writeFieldBegin(g);
        tprotocol.writeI16(A);
        tprotocol.writeFieldEnd();
        tprotocol.writeFieldBegin(h);
        tprotocol.writeI16(B);
        tprotocol.writeFieldEnd();
        if (isSetLat())
        {
            tprotocol.writeFieldBegin(i);
            tprotocol.writeDouble(C);
            tprotocol.writeFieldEnd();
        }
        if (isSetLon())
        {
            tprotocol.writeFieldBegin(j);
            tprotocol.writeDouble(D);
            tprotocol.writeFieldEnd();
        }
        if (isSetAlt())
        {
            tprotocol.writeFieldBegin(k);
            tprotocol.writeDouble(E);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldBegin(l);
        tprotocol.writeI16(F);
        tprotocol.writeFieldEnd();
        tprotocol.writeFieldBegin(m);
        tprotocol.writeI16(G);
        tprotocol.writeFieldEnd();
        if (H == null) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        tprotocol.writeFieldBegin(n);
        tprotocol.writeMapBegin(new TMap((byte)11, (byte)11, H.size()));
        iterator = H.entrySet().iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        tprotocol.writeMapEnd();
        tprotocol.writeFieldEnd();
_L2:
        if (isSetHorizontalAccuracy())
        {
            tprotocol.writeFieldBegin(o);
            tprotocol.writeDouble(I);
            tprotocol.writeFieldEnd();
        }
        if (isSetVerticalAccuracy())
        {
            tprotocol.writeFieldBegin(p);
            tprotocol.writeDouble(J);
            tprotocol.writeFieldEnd();
        }
        if (K != null && isSetStringValues())
        {
            tprotocol.writeFieldBegin(q);
            tprotocol.writeListBegin(new TList((byte)12, K.size()));
            java.util.Map.Entry entry;
            for (iterator = K.iterator(); iterator.hasNext(); ((MMStringData)iterator.next()).write(tprotocol))
            {
                break MISSING_BLOCK_LABEL_713;
            }

            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        if (L != null && isSetNumericValues())
        {
            tprotocol.writeFieldBegin(r);
            tprotocol.writeListBegin(new TList((byte)12, L.size()));
            for (iterator = L.iterator(); iterator.hasNext(); ((MMNumberData)iterator.next()).write(tprotocol))
            {
                break MISSING_BLOCK_LABEL_729;
            }

            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        if (M != null && isSetDurationValues())
        {
            tprotocol.writeFieldBegin(s);
            tprotocol.writeListBegin(new TList((byte)12, M.size()));
            for (iterator = M.iterator(); iterator.hasNext(); ((MMNumberData)iterator.next()).write(tprotocol))
            {
                break MISSING_BLOCK_LABEL_745;
            }

            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        if (isSetDirection())
        {
            tprotocol.writeFieldBegin(t);
            tprotocol.writeDouble(N);
            tprotocol.writeFieldEnd();
        }
        if (isSetDirectionAccuracy())
        {
            tprotocol.writeFieldBegin(u);
            tprotocol.writeDouble(O);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
        return;
_L4:
        entry = (java.util.Map.Entry)iterator.next();
        tprotocol.writeString((String)entry.getKey());
        tprotocol.writeString((String)entry.getValue());
        if (true) goto _L6; else goto _L5
_L5:
    }

    static 
    {
        metaDataMap = Collections.unmodifiableMap(new g());
        FieldMetaData.addStructMetaDataMap(com/medialets/thrift/Event, metaDataMap);
    }

    // Unreferenced inner class com/medialets/thrift/g
    final class g extends HashMap
    {

            g()
            {
                put(Integer.valueOf(1), new FieldMetaData("eventID", (byte)3, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(2), new FieldMetaData("key", (byte)3, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(3), new FieldMetaData("time", (byte)3, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(4), new FieldMetaData("conn", (byte)3, new FieldValueMetaData((byte)8)));
                put(Integer.valueOf(5), new FieldMetaData("countHr", (byte)3, new FieldValueMetaData((byte)6)));
                put(Integer.valueOf(6), new FieldMetaData("countDay", (byte)3, new FieldValueMetaData((byte)6)));
                put(Integer.valueOf(7), new FieldMetaData("countMon", (byte)3, new FieldValueMetaData((byte)6)));
                put(Integer.valueOf(8), new FieldMetaData("lat", (byte)2, new FieldValueMetaData((byte)4)));
                put(Integer.valueOf(9), new FieldMetaData("lon", (byte)2, new FieldValueMetaData((byte)4)));
                put(Integer.valueOf(10), new FieldMetaData("alt", (byte)2, new FieldValueMetaData((byte)4)));
                put(Integer.valueOf(11), new FieldMetaData("uCount", (byte)3, new FieldValueMetaData((byte)6)));
                put(Integer.valueOf(12), new FieldMetaData("uDur", (byte)3, new FieldValueMetaData((byte)6)));
                put(Integer.valueOf(13), new FieldMetaData("uDict", (byte)3, new MapMetaData((byte)13, new FieldValueMetaData((byte)11), new FieldValueMetaData((byte)11))));
                put(Integer.valueOf(14), new FieldMetaData("horizontalAccuracy", (byte)2, new FieldValueMetaData((byte)4)));
                put(Integer.valueOf(15), new FieldMetaData("verticalAccuracy", (byte)2, new FieldValueMetaData((byte)4)));
                put(Integer.valueOf(16), new FieldMetaData("stringValues", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/medialets/thrift/MMStringData))));
                put(Integer.valueOf(17), new FieldMetaData("numericValues", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/medialets/thrift/MMNumberData))));
                put(Integer.valueOf(18), new FieldMetaData("durationValues", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/medialets/thrift/MMNumberData))));
                put(Integer.valueOf(19), new FieldMetaData("direction", (byte)2, new FieldValueMetaData((byte)4)));
                put(Integer.valueOf(20), new FieldMetaData("directionAccuracy", (byte)2, new FieldValueMetaData((byte)4)));
            }
    }

}
