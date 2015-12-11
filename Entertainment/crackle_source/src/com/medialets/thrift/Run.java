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
//            l, AdEvent, Event

public class Run
    implements Serializable, Cloneable, TBase
{
    private static final class a
        implements Serializable
    {

        public boolean abEnd;
        public boolean countDay;
        public boolean countHr;
        public boolean countMon;
        public boolean dur;
        public boolean first;
        public boolean firstDay;
        public boolean firstHr;
        public boolean firstMon;
        public boolean interval;

        a()
        {
            this((byte)0);
        }

        private a(byte byte0)
        {
            interval = false;
            dur = false;
            abEnd = false;
            first = false;
            firstHr = false;
            firstDay = false;
            firstMon = false;
            countHr = false;
            countDay = false;
            countMon = false;
        }
    }


    public static final int ABEND = 6;
    public static final int ADEVENTS = 14;
    public static final int APPVERSION = 2;
    public static final int COUNTDAY = 12;
    public static final int COUNTHR = 11;
    public static final int COUNTMON = 13;
    public static final int DUR = 5;
    public static final int EVENTS = 15;
    public static final int FIRST = 7;
    public static final int FIRSTDAY = 9;
    public static final int FIRSTHR = 8;
    public static final int FIRSTMON = 10;
    public static final int ID = 1;
    public static final int INTERVAL = 3;
    public static final int REV = 17;
    public static final int START = 4;
    public static final int SYSTEMVERSION = 16;
    private static final TStruct a = new TStruct("Run");
    private static final TField b = new TField("id", (byte)11, (short)1);
    private static final TField c = new TField("appVersion", (byte)11, (short)2);
    private static final TField d = new TField("interval", (byte)10, (short)3);
    private static final TField e = new TField("start", (byte)11, (short)4);
    private static final TField f = new TField("dur", (byte)6, (short)5);
    private static final TField g = new TField("abEnd", (byte)2, (short)6);
    private static final TField h = new TField("first", (byte)2, (short)7);
    private static final TField i = new TField("firstHr", (byte)2, (short)8);
    private static final TField j = new TField("firstDay", (byte)2, (short)9);
    private static final TField k = new TField("firstMon", (byte)2, (short)10);
    private static final TField l = new TField("countHr", (byte)6, (short)11);
    private static final TField m = new TField("countDay", (byte)6, (short)12);
    public static final Map metaDataMap;
    private static final TField n = new TField("countMon", (byte)6, (short)13);
    private static final TField o = new TField("adEvents", (byte)15, (short)14);
    private static final TField p = new TField("events", (byte)15, (short)15);
    private static final TField q = new TField("systemVersion", (byte)11, (short)16);
    private static final TField r = new TField("rev", (byte)11, (short)17);
    private boolean A;
    private boolean B;
    private short C;
    private short D;
    private short E;
    private List F;
    private List G;
    private String H;
    private String I;
    private final a J;
    private String s;
    private String t;
    private long u;
    private String v;
    private short w;
    private boolean x;
    private boolean y;
    private boolean z;

    public Run()
    {
        J = new a();
    }

    public Run(Run run)
    {
        J = new a();
        if (run.isSetId())
        {
            s = run.s;
        }
        if (run.isSetAppVersion())
        {
            t = run.t;
        }
        J.interval = run.J.interval;
        u = run.u;
        if (run.isSetStart())
        {
            v = run.v;
        }
        J.dur = run.J.dur;
        w = run.w;
        J.abEnd = run.J.abEnd;
        x = run.x;
        J.first = run.J.first;
        y = run.y;
        J.firstHr = run.J.firstHr;
        z = run.z;
        J.firstDay = run.J.firstDay;
        A = run.A;
        J.firstMon = run.J.firstMon;
        B = run.B;
        J.countHr = run.J.countHr;
        C = run.C;
        J.countDay = run.J.countDay;
        D = run.D;
        J.countMon = run.J.countMon;
        E = run.E;
        if (!run.isSetAdEvents()) goto _L2; else goto _L1
_L1:
        ArrayList arraylist;
        Iterator iterator;
        arraylist = new ArrayList();
        iterator = run.F.iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        F = arraylist;
_L2:
        if (run.isSetEvents())
        {
            arraylist = new ArrayList();
            for (iterator = run.G.iterator(); iterator.hasNext(); arraylist.add(new Event((Event)iterator.next())))
            {
                break MISSING_BLOCK_LABEL_415;
            }

            G = arraylist;
        }
        if (run.isSetSystemVersion())
        {
            H = run.H;
        }
        if (run.isSetRev())
        {
            I = run.I;
        }
        return;
_L4:
        arraylist.add(new AdEvent((AdEvent)iterator.next()));
        if (true) goto _L6; else goto _L5
_L5:
    }

    public Run(String s1, String s2, long l1, String s3, short word0, boolean flag, 
            boolean flag1, boolean flag2, boolean flag3, boolean flag4, short word1, short word2, short word3, 
            List list, List list1, String s4, String s5)
    {
        this();
        s = s1;
        t = s2;
        u = l1;
        J.interval = true;
        v = s3;
        w = word0;
        J.dur = true;
        x = flag;
        J.abEnd = true;
        y = flag1;
        J.first = true;
        z = flag2;
        J.firstHr = true;
        A = flag3;
        J.firstDay = true;
        B = flag4;
        J.firstMon = true;
        C = word1;
        J.countHr = true;
        D = word2;
        J.countDay = true;
        E = word3;
        J.countMon = true;
        F = list;
        G = list1;
        H = s4;
        I = s5;
    }

    public void addToAdEvents(AdEvent adevent)
    {
        if (F == null)
        {
            F = new ArrayList();
        }
        F.add(adevent);
    }

    public void addToEvents(Event event)
    {
        if (G == null)
        {
            G = new ArrayList();
        }
        G.add(event);
    }

    public Run clone()
    {
        return new Run(this);
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public boolean equals(Run run)
    {
        if (run != null)
        {
            boolean flag;
            boolean flag1;
            if (isSetId())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (run.isSetId())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!flag && !flag1 || flag && flag1 && s.equals(run.s))
            {
                if (isSetAppVersion())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (run.isSetAppVersion())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if ((!flag && !flag1 || flag && flag1 && t.equals(run.t)) && u == run.u)
                {
                    if (isSetStart())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (run.isSetStart())
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if ((!flag && !flag1 || flag && flag1 && v.equals(run.v)) && w == run.w)
                    {
                        if (isSetAbEnd())
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        if (run.isSetAbEnd())
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        if (!flag && !flag1 || flag && flag1 && x == run.x)
                        {
                            if (isSetFirst())
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                            if (run.isSetFirst())
                            {
                                flag1 = true;
                            } else
                            {
                                flag1 = false;
                            }
                            if (!flag && !flag1 || flag && flag1 && y == run.y)
                            {
                                if (isSetFirstHr())
                                {
                                    flag = true;
                                } else
                                {
                                    flag = false;
                                }
                                if (run.isSetFirstHr())
                                {
                                    flag1 = true;
                                } else
                                {
                                    flag1 = false;
                                }
                                if (!flag && !flag1 || flag && flag1 && z == run.z)
                                {
                                    if (isSetFirstDay())
                                    {
                                        flag = true;
                                    } else
                                    {
                                        flag = false;
                                    }
                                    if (run.isSetFirstDay())
                                    {
                                        flag1 = true;
                                    } else
                                    {
                                        flag1 = false;
                                    }
                                    if (!flag && !flag1 || flag && flag1 && A == run.A)
                                    {
                                        if (isSetFirstMon())
                                        {
                                            flag = true;
                                        } else
                                        {
                                            flag = false;
                                        }
                                        if (run.isSetFirstMon())
                                        {
                                            flag1 = true;
                                        } else
                                        {
                                            flag1 = false;
                                        }
                                        if ((!flag && !flag1 || flag && flag1 && B == run.B) && C == run.C && D == run.D && E == run.E)
                                        {
                                            if (isSetAdEvents())
                                            {
                                                flag = true;
                                            } else
                                            {
                                                flag = false;
                                            }
                                            if (run.isSetAdEvents())
                                            {
                                                flag1 = true;
                                            } else
                                            {
                                                flag1 = false;
                                            }
                                            if (!flag && !flag1 || flag && flag1 && F.equals(run.F))
                                            {
                                                if (isSetEvents())
                                                {
                                                    flag = true;
                                                } else
                                                {
                                                    flag = false;
                                                }
                                                if (run.isSetEvents())
                                                {
                                                    flag1 = true;
                                                } else
                                                {
                                                    flag1 = false;
                                                }
                                                if (!flag && !flag1 || flag && flag1 && G.equals(run.G))
                                                {
                                                    if (isSetSystemVersion())
                                                    {
                                                        flag = true;
                                                    } else
                                                    {
                                                        flag = false;
                                                    }
                                                    if (run.isSetSystemVersion())
                                                    {
                                                        flag1 = true;
                                                    } else
                                                    {
                                                        flag1 = false;
                                                    }
                                                    if (!flag && !flag1 || flag && flag1 && H.equals(run.H))
                                                    {
                                                        if (isSetRev())
                                                        {
                                                            flag = true;
                                                        } else
                                                        {
                                                            flag = false;
                                                        }
                                                        if (run.isSetRev())
                                                        {
                                                            flag1 = true;
                                                        } else
                                                        {
                                                            flag1 = false;
                                                        }
                                                        if (!flag && !flag1 || flag && flag1 && I.equals(run.I))
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
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof Run)) 
        {
            return false;
        }
        return equals((Run)obj);
    }

    public List getAdEvents()
    {
        return F;
    }

    public Iterator getAdEventsIterator()
    {
        if (F == null)
        {
            return null;
        } else
        {
            return F.iterator();
        }
    }

    public int getAdEventsSize()
    {
        if (F == null)
        {
            return 0;
        } else
        {
            return F.size();
        }
    }

    public String getAppVersion()
    {
        return t;
    }

    public short getCountDay()
    {
        return D;
    }

    public short getCountHr()
    {
        return C;
    }

    public short getCountMon()
    {
        return E;
    }

    public short getDur()
    {
        return w;
    }

    public List getEvents()
    {
        return G;
    }

    public Iterator getEventsIterator()
    {
        if (G == null)
        {
            return null;
        } else
        {
            return G.iterator();
        }
    }

    public int getEventsSize()
    {
        if (G == null)
        {
            return 0;
        } else
        {
            return G.size();
        }
    }

    public Object getFieldValue(int i1)
    {
        switch (i1)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i1).append(" doesn't exist!").toString());

        case 1: // '\001'
            return getId();

        case 2: // '\002'
            return getAppVersion();

        case 3: // '\003'
            return new Long(getInterval());

        case 4: // '\004'
            return getStart();

        case 5: // '\005'
            return new Short(getDur());

        case 6: // '\006'
            return new Boolean(isAbEnd());

        case 7: // '\007'
            return new Boolean(isFirst());

        case 8: // '\b'
            return new Boolean(isFirstHr());

        case 9: // '\t'
            return new Boolean(isFirstDay());

        case 10: // '\n'
            return new Boolean(isFirstMon());

        case 11: // '\013'
            return new Short(getCountHr());

        case 12: // '\f'
            return new Short(getCountDay());

        case 13: // '\r'
            return new Short(getCountMon());

        case 14: // '\016'
            return getAdEvents();

        case 15: // '\017'
            return getEvents();

        case 16: // '\020'
            return getSystemVersion();

        case 17: // '\021'
            return getRev();
        }
    }

    public String getId()
    {
        return s;
    }

    public long getInterval()
    {
        return u;
    }

    public String getRev()
    {
        return I;
    }

    public String getStart()
    {
        return v;
    }

    public String getSystemVersion()
    {
        return H;
    }

    public int hashCode()
    {
        return 0;
    }

    public boolean isAbEnd()
    {
        return x;
    }

    public boolean isFirst()
    {
        return y;
    }

    public boolean isFirstDay()
    {
        return A;
    }

    public boolean isFirstHr()
    {
        return z;
    }

    public boolean isFirstMon()
    {
        return B;
    }

    public boolean isSet(int i1)
    {
        switch (i1)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i1).append(" doesn't exist!").toString());

        case 1: // '\001'
            return isSetId();

        case 2: // '\002'
            return isSetAppVersion();

        case 3: // '\003'
            return isSetInterval();

        case 4: // '\004'
            return isSetStart();

        case 5: // '\005'
            return isSetDur();

        case 6: // '\006'
            return isSetAbEnd();

        case 7: // '\007'
            return isSetFirst();

        case 8: // '\b'
            return isSetFirstHr();

        case 9: // '\t'
            return isSetFirstDay();

        case 10: // '\n'
            return isSetFirstMon();

        case 11: // '\013'
            return isSetCountHr();

        case 12: // '\f'
            return isSetCountDay();

        case 13: // '\r'
            return isSetCountMon();

        case 14: // '\016'
            return isSetAdEvents();

        case 15: // '\017'
            return isSetEvents();

        case 16: // '\020'
            return isSetSystemVersion();

        case 17: // '\021'
            return isSetRev();
        }
    }

    public boolean isSetAbEnd()
    {
        return J.abEnd;
    }

    public boolean isSetAdEvents()
    {
        return F != null;
    }

    public boolean isSetAppVersion()
    {
        return t != null;
    }

    public boolean isSetCountDay()
    {
        return J.countDay;
    }

    public boolean isSetCountHr()
    {
        return J.countHr;
    }

    public boolean isSetCountMon()
    {
        return J.countMon;
    }

    public boolean isSetDur()
    {
        return J.dur;
    }

    public boolean isSetEvents()
    {
        return G != null;
    }

    public boolean isSetFirst()
    {
        return J.first;
    }

    public boolean isSetFirstDay()
    {
        return J.firstDay;
    }

    public boolean isSetFirstHr()
    {
        return J.firstHr;
    }

    public boolean isSetFirstMon()
    {
        return J.firstMon;
    }

    public boolean isSetId()
    {
        return s != null;
    }

    public boolean isSetInterval()
    {
        return J.interval;
    }

    public boolean isSetRev()
    {
        return I != null;
    }

    public boolean isSetStart()
    {
        return v != null;
    }

    public boolean isSetSystemVersion()
    {
        return H != null;
    }

    public void read(TProtocol tprotocol)
        throws TException
    {
        tprotocol.readStructBegin();
_L20:
        Object obj;
        obj = tprotocol.readFieldBegin();
        if (((TField) (obj)).type == 0)
        {
            break MISSING_BLOCK_LABEL_843;
        }
        ((TField) (obj)).id;
        JVM INSTR tableswitch 1 17: default 104
    //                   1 119
    //                   2 150
    //                   3 181
    //                   4 220
    //                   5 251
    //                   6 290
    //                   7 328
    //                   8 366
    //                   9 404
    //                   10 442
    //                   11 480
    //                   12 519
    //                   13 558
    //                   14 597
    //                   15 689
    //                   16 781
    //                   17 812;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18
_L2:
        break; /* Loop/switch isn't completed */
_L18:
        break MISSING_BLOCK_LABEL_812;
_L1:
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L21:
        tprotocol.readFieldEnd();
        if (true) goto _L20; else goto _L19
_L19:
        if (((TField) (obj)).type == 11)
        {
            s = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L21
_L3:
        if (((TField) (obj)).type == 11)
        {
            t = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L21
_L4:
        if (((TField) (obj)).type == 10)
        {
            u = tprotocol.readI64();
            J.interval = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L21
_L5:
        if (((TField) (obj)).type == 11)
        {
            v = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L21
_L6:
        if (((TField) (obj)).type == 6)
        {
            w = tprotocol.readI16();
            J.dur = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L21
_L7:
        if (((TField) (obj)).type == 2)
        {
            x = tprotocol.readBool();
            J.abEnd = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L21
_L8:
        if (((TField) (obj)).type == 2)
        {
            y = tprotocol.readBool();
            J.first = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L21
_L9:
        if (((TField) (obj)).type == 2)
        {
            z = tprotocol.readBool();
            J.firstHr = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L21
_L10:
        if (((TField) (obj)).type == 2)
        {
            A = tprotocol.readBool();
            J.firstDay = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L21
_L11:
        if (((TField) (obj)).type == 2)
        {
            B = tprotocol.readBool();
            J.firstMon = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L21
_L12:
        if (((TField) (obj)).type == 6)
        {
            C = tprotocol.readI16();
            J.countHr = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L21
_L13:
        if (((TField) (obj)).type == 6)
        {
            D = tprotocol.readI16();
            J.countDay = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L21
_L14:
        if (((TField) (obj)).type == 6)
        {
            E = tprotocol.readI16();
            J.countMon = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L21
_L15:
        int i1;
        if (((TField) (obj)).type != 15)
        {
            break MISSING_BLOCK_LABEL_678;
        }
        obj = tprotocol.readListBegin();
        F = new ArrayList(((TList) (obj)).size);
        i1 = 0;
_L22:
label0:
        {
            if (i1 < ((TList) (obj)).size)
            {
                break label0;
            }
            tprotocol.readListEnd();
        }
          goto _L21
        AdEvent adevent = new AdEvent();
        adevent.read(tprotocol);
        F.add(adevent);
        i1++;
          goto _L22
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
          goto _L21
_L16:
        if (((TField) (obj)).type != 15)
        {
            break MISSING_BLOCK_LABEL_770;
        }
        obj = tprotocol.readListBegin();
        G = new ArrayList(((TList) (obj)).size);
        i1 = 0;
_L23:
label1:
        {
            if (i1 < ((TList) (obj)).size)
            {
                break label1;
            }
            tprotocol.readListEnd();
        }
          goto _L21
        Event event = new Event();
        event.read(tprotocol);
        G.add(event);
        i1++;
          goto _L23
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
          goto _L21
_L17:
        if (((TField) (obj)).type == 11)
        {
            H = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L21
        if (((TField) (obj)).type == 11)
        {
            I = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L21
        tprotocol.readStructEnd();
        validate();
        return;
    }

    public void setAbEnd(boolean flag)
    {
        x = flag;
        J.abEnd = true;
    }

    public void setAdEvents(List list)
    {
        F = list;
    }

    public void setAppVersion(String s1)
    {
        t = s1;
    }

    public void setCountDay(short word0)
    {
        D = word0;
        J.countDay = true;
    }

    public void setCountHr(short word0)
    {
        C = word0;
        J.countHr = true;
    }

    public void setCountMon(short word0)
    {
        E = word0;
        J.countMon = true;
    }

    public void setDur(short word0)
    {
        w = word0;
        J.dur = true;
    }

    public void setEvents(List list)
    {
        G = list;
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
                unsetId();
                return;
            } else
            {
                setId((String)obj);
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetAppVersion();
                return;
            } else
            {
                setAppVersion((String)obj);
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetInterval();
                return;
            } else
            {
                setInterval(((Long)obj).longValue());
                return;
            }

        case 4: // '\004'
            if (obj == null)
            {
                unsetStart();
                return;
            } else
            {
                setStart((String)obj);
                return;
            }

        case 5: // '\005'
            if (obj == null)
            {
                unsetDur();
                return;
            } else
            {
                setDur(((Short)obj).shortValue());
                return;
            }

        case 6: // '\006'
            if (obj == null)
            {
                unsetAbEnd();
                return;
            } else
            {
                setAbEnd(((Boolean)obj).booleanValue());
                return;
            }

        case 7: // '\007'
            if (obj == null)
            {
                unsetFirst();
                return;
            } else
            {
                setFirst(((Boolean)obj).booleanValue());
                return;
            }

        case 8: // '\b'
            if (obj == null)
            {
                unsetFirstHr();
                return;
            } else
            {
                setFirstHr(((Boolean)obj).booleanValue());
                return;
            }

        case 9: // '\t'
            if (obj == null)
            {
                unsetFirstDay();
                return;
            } else
            {
                setFirstDay(((Boolean)obj).booleanValue());
                return;
            }

        case 10: // '\n'
            if (obj == null)
            {
                unsetFirstMon();
                return;
            } else
            {
                setFirstMon(((Boolean)obj).booleanValue());
                return;
            }

        case 11: // '\013'
            if (obj == null)
            {
                unsetCountHr();
                return;
            } else
            {
                setCountHr(((Short)obj).shortValue());
                return;
            }

        case 12: // '\f'
            if (obj == null)
            {
                unsetCountDay();
                return;
            } else
            {
                setCountDay(((Short)obj).shortValue());
                return;
            }

        case 13: // '\r'
            if (obj == null)
            {
                unsetCountMon();
                return;
            } else
            {
                setCountMon(((Short)obj).shortValue());
                return;
            }

        case 14: // '\016'
            if (obj == null)
            {
                unsetAdEvents();
                return;
            } else
            {
                setAdEvents((List)obj);
                return;
            }

        case 15: // '\017'
            if (obj == null)
            {
                unsetEvents();
                return;
            } else
            {
                setEvents((List)obj);
                return;
            }

        case 16: // '\020'
            if (obj == null)
            {
                unsetSystemVersion();
                return;
            } else
            {
                setSystemVersion((String)obj);
                return;
            }

        case 17: // '\021'
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

    public void setFirst(boolean flag)
    {
        y = flag;
        J.first = true;
    }

    public void setFirstDay(boolean flag)
    {
        A = flag;
        J.firstDay = true;
    }

    public void setFirstHr(boolean flag)
    {
        z = flag;
        J.firstHr = true;
    }

    public void setFirstMon(boolean flag)
    {
        B = flag;
        J.firstMon = true;
    }

    public void setId(String s1)
    {
        s = s1;
    }

    public void setInterval(long l1)
    {
        u = l1;
        J.interval = true;
    }

    public void setRev(String s1)
    {
        I = s1;
    }

    public void setStart(String s1)
    {
        v = s1;
    }

    public void setSystemVersion(String s1)
    {
        H = s1;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("Run(");
        stringbuilder.append("id:");
        if (s == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(s);
        }
        stringbuilder.append(", ");
        stringbuilder.append("appVersion:");
        if (t == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(t);
        }
        stringbuilder.append(", ");
        stringbuilder.append("interval:");
        stringbuilder.append(u);
        stringbuilder.append(", ");
        stringbuilder.append("start:");
        if (v == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(v);
        }
        stringbuilder.append(", ");
        stringbuilder.append("dur:");
        stringbuilder.append(w);
        if (isSetAbEnd())
        {
            stringbuilder.append(", ");
            stringbuilder.append("abEnd:");
            stringbuilder.append(x);
        }
        if (isSetFirst())
        {
            stringbuilder.append(", ");
            stringbuilder.append("first:");
            stringbuilder.append(y);
        }
        if (isSetFirstHr())
        {
            stringbuilder.append(", ");
            stringbuilder.append("firstHr:");
            stringbuilder.append(z);
        }
        if (isSetFirstDay())
        {
            stringbuilder.append(", ");
            stringbuilder.append("firstDay:");
            stringbuilder.append(A);
        }
        if (isSetFirstMon())
        {
            stringbuilder.append(", ");
            stringbuilder.append("firstMon:");
            stringbuilder.append(B);
        }
        stringbuilder.append(", ");
        stringbuilder.append("countHr:");
        stringbuilder.append(C);
        stringbuilder.append(", ");
        stringbuilder.append("countDay:");
        stringbuilder.append(D);
        stringbuilder.append(", ");
        stringbuilder.append("countMon:");
        stringbuilder.append(E);
        if (isSetAdEvents())
        {
            stringbuilder.append(", ");
            stringbuilder.append("adEvents:");
            if (F == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(F);
            }
        }
        if (isSetEvents())
        {
            stringbuilder.append(", ");
            stringbuilder.append("events:");
            if (G == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(G);
            }
        }
        stringbuilder.append(", ");
        stringbuilder.append("systemVersion:");
        if (H == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(H);
        }
        stringbuilder.append(", ");
        stringbuilder.append("rev:");
        if (I == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(I);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetAbEnd()
    {
        J.abEnd = false;
    }

    public void unsetAdEvents()
    {
        F = null;
    }

    public void unsetAppVersion()
    {
        t = null;
    }

    public void unsetCountDay()
    {
        J.countDay = false;
    }

    public void unsetCountHr()
    {
        J.countHr = false;
    }

    public void unsetCountMon()
    {
        J.countMon = false;
    }

    public void unsetDur()
    {
        J.dur = false;
    }

    public void unsetEvents()
    {
        G = null;
    }

    public void unsetFirst()
    {
        J.first = false;
    }

    public void unsetFirstDay()
    {
        J.firstDay = false;
    }

    public void unsetFirstHr()
    {
        J.firstHr = false;
    }

    public void unsetFirstMon()
    {
        J.firstMon = false;
    }

    public void unsetId()
    {
        s = null;
    }

    public void unsetInterval()
    {
        J.interval = false;
    }

    public void unsetRev()
    {
        I = null;
    }

    public void unsetStart()
    {
        v = null;
    }

    public void unsetSystemVersion()
    {
        H = null;
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
        if (s != null)
        {
            tprotocol.writeFieldBegin(b);
            tprotocol.writeString(s);
            tprotocol.writeFieldEnd();
        }
        if (t != null)
        {
            tprotocol.writeFieldBegin(c);
            tprotocol.writeString(t);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldBegin(d);
        tprotocol.writeI64(u);
        tprotocol.writeFieldEnd();
        if (v != null)
        {
            tprotocol.writeFieldBegin(e);
            tprotocol.writeString(v);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldBegin(f);
        tprotocol.writeI16(w);
        tprotocol.writeFieldEnd();
        if (isSetAbEnd())
        {
            tprotocol.writeFieldBegin(g);
            tprotocol.writeBool(x);
            tprotocol.writeFieldEnd();
        }
        if (isSetFirst())
        {
            tprotocol.writeFieldBegin(h);
            tprotocol.writeBool(y);
            tprotocol.writeFieldEnd();
        }
        if (isSetFirstHr())
        {
            tprotocol.writeFieldBegin(i);
            tprotocol.writeBool(z);
            tprotocol.writeFieldEnd();
        }
        if (isSetFirstDay())
        {
            tprotocol.writeFieldBegin(j);
            tprotocol.writeBool(A);
            tprotocol.writeFieldEnd();
        }
        if (isSetFirstMon())
        {
            tprotocol.writeFieldBegin(k);
            tprotocol.writeBool(B);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldBegin(l);
        tprotocol.writeI16(C);
        tprotocol.writeFieldEnd();
        tprotocol.writeFieldBegin(m);
        tprotocol.writeI16(D);
        tprotocol.writeFieldEnd();
        tprotocol.writeFieldBegin(n);
        tprotocol.writeI16(E);
        tprotocol.writeFieldEnd();
        if (F == null || !isSetAdEvents()) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        tprotocol.writeFieldBegin(o);
        tprotocol.writeListBegin(new TList((byte)12, F.size()));
        iterator = F.iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        tprotocol.writeListEnd();
        tprotocol.writeFieldEnd();
_L2:
        if (G != null && isSetEvents())
        {
            tprotocol.writeFieldBegin(p);
            tprotocol.writeListBegin(new TList((byte)12, G.size()));
            for (iterator = G.iterator(); iterator.hasNext(); ((Event)iterator.next()).write(tprotocol))
            {
                break MISSING_BLOCK_LABEL_531;
            }

            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        if (H != null)
        {
            tprotocol.writeFieldBegin(q);
            tprotocol.writeString(H);
            tprotocol.writeFieldEnd();
        }
        if (I != null)
        {
            tprotocol.writeFieldBegin(r);
            tprotocol.writeString(I);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
        return;
_L4:
        ((AdEvent)iterator.next()).write(tprotocol);
        if (true) goto _L6; else goto _L5
_L5:
    }

    static 
    {
        metaDataMap = Collections.unmodifiableMap(new l());
        FieldMetaData.addStructMetaDataMap(com/medialets/thrift/Run, metaDataMap);
    }

    // Unreferenced inner class com/medialets/thrift/l
    final class l extends HashMap
    {

            l()
            {
                put(Integer.valueOf(1), new FieldMetaData("id", (byte)3, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(2), new FieldMetaData("appVersion", (byte)3, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(3), new FieldMetaData("interval", (byte)3, new FieldValueMetaData((byte)10)));
                put(Integer.valueOf(4), new FieldMetaData("start", (byte)3, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(5), new FieldMetaData("dur", (byte)3, new FieldValueMetaData((byte)6)));
                put(Integer.valueOf(6), new FieldMetaData("abEnd", (byte)2, new FieldValueMetaData((byte)2)));
                put(Integer.valueOf(7), new FieldMetaData("first", (byte)2, new FieldValueMetaData((byte)2)));
                put(Integer.valueOf(8), new FieldMetaData("firstHr", (byte)2, new FieldValueMetaData((byte)2)));
                put(Integer.valueOf(9), new FieldMetaData("firstDay", (byte)2, new FieldValueMetaData((byte)2)));
                put(Integer.valueOf(10), new FieldMetaData("firstMon", (byte)2, new FieldValueMetaData((byte)2)));
                put(Integer.valueOf(11), new FieldMetaData("countHr", (byte)3, new FieldValueMetaData((byte)6)));
                put(Integer.valueOf(12), new FieldMetaData("countDay", (byte)3, new FieldValueMetaData((byte)6)));
                put(Integer.valueOf(13), new FieldMetaData("countMon", (byte)3, new FieldValueMetaData((byte)6)));
                put(Integer.valueOf(14), new FieldMetaData("adEvents", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/medialets/thrift/AdEvent))));
                put(Integer.valueOf(15), new FieldMetaData("events", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/medialets/thrift/Event))));
                put(Integer.valueOf(16), new FieldMetaData("systemVersion", (byte)3, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(17), new FieldMetaData("rev", (byte)3, new FieldValueMetaData((byte)11)));
            }
    }

}
