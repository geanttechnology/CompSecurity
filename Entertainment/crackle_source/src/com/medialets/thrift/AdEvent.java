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
//            a, MMStringData, MMNumberData, MMAdEventBreadcrumb, 
//            MMAdEventURL, connectionState, adExitEnum

public class AdEvent
    implements Serializable, Cloneable, TBase
{
    private static final class a
        implements Serializable
    {

        public boolean adExit;
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
            lat = false;
            lon = false;
            alt = false;
            uCount = false;
            uDur = false;
            horizontalAccuracy = false;
            verticalAccuracy = false;
            adExit = false;
            countHr = false;
            countDay = false;
            countMon = false;
            direction = false;
            directionAccuracy = false;
        }
    }


    private static final TField A = new TField("adSlotName", (byte)11, (short)26);
    public static final int ADEXIT = 15;
    public static final int ADID = 4;
    public static final int ADSLOTNAME = 26;
    public static final int ADVERSION = 27;
    public static final int ALT = 8;
    private static final TField B = new TField("adVersion", (byte)11, (short)27);
    public static final int BREADCRUMBS = 21;
    public static final int CONN = 5;
    public static final int COUNTDAY = 17;
    public static final int COUNTHR = 16;
    public static final int COUNTMON = 18;
    public static final int DIRECTION = 24;
    public static final int DIRECTIONACCURACY = 25;
    public static final int DURATIONVALUES = 23;
    public static final int EVENTID = 1;
    public static final int HORIZONTALACCURACY = 12;
    public static final int KEY = 2;
    public static final int LAT = 6;
    public static final int LON = 7;
    public static final int NUMERICVALUES = 20;
    public static final int STRINGVALUES = 19;
    public static final int TIME = 3;
    public static final int UCOUNT = 9;
    public static final int UDICT = 11;
    public static final int UDUR = 10;
    public static final int URLCOUNTS = 14;
    public static final int VERTICALACCURACY = 13;
    public static final int VISITEDADEVENTLINKS = 22;
    private static final TStruct a = new TStruct("AdEvent");
    private static final TField b = new TField("eventID", (byte)11, (short)1);
    private static final TField c = new TField("key", (byte)11, (short)2);
    private static final TField d = new TField("time", (byte)11, (short)3);
    private static final TField e = new TField("adID", (byte)11, (short)4);
    private static final TField f = new TField("conn", (byte)8, (short)5);
    private static final TField g = new TField("lat", (byte)4, (short)6);
    private static final TField h = new TField("lon", (byte)4, (short)7);
    private static final TField i = new TField("alt", (byte)4, (short)8);
    private static final TField j = new TField("uCount", (byte)6, (short)9);
    private static final TField k = new TField("uDur", (byte)6, (short)10);
    private static final TField l = new TField("uDict", (byte)13, (short)11);
    private static final TField m = new TField("horizontalAccuracy", (byte)4, (short)12);
    public static final Map metaDataMap;
    private static final TField n = new TField("verticalAccuracy", (byte)4, (short)13);
    private static final TField o = new TField("urlCounts", (byte)13, (short)14);
    private static final TField p = new TField("adExit", (byte)8, (short)15);
    private static final TField q = new TField("countHr", (byte)6, (short)16);
    private static final TField r = new TField("countDay", (byte)6, (short)17);
    private static final TField s = new TField("countMon", (byte)6, (short)18);
    private static final TField t = new TField("stringValues", (byte)15, (short)19);
    private static final TField u = new TField("numericValues", (byte)15, (short)20);
    private static final TField v = new TField("breadcrumbs", (byte)15, (short)21);
    private static final TField w = new TField("visitedAdEventLinks", (byte)15, (short)22);
    private static final TField x = new TField("durationValues", (byte)15, (short)23);
    private static final TField y = new TField("direction", (byte)4, (short)24);
    private static final TField z = new TField("directionAccuracy", (byte)4, (short)25);
    private String C;
    private String D;
    private String E;
    private String F;
    private int G;
    private double H;
    private double I;
    private double J;
    private short K;
    private short L;
    private Map M;
    private double N;
    private double O;
    private Map P;
    private int Q;
    private short R;
    private short S;
    private short T;
    private List U;
    private List V;
    private List W;
    private List X;
    private List Y;
    private double Z;
    private double aa;
    private String ab;
    private String ac;
    private final a ad;

    public AdEvent()
    {
        ad = new a();
    }

    public AdEvent(AdEvent adevent)
    {
        ad = new a();
        if (adevent.isSetEventID())
        {
            C = adevent.C;
        }
        if (adevent.isSetKey())
        {
            D = adevent.D;
        }
        if (adevent.isSetTime())
        {
            E = adevent.E;
        }
        if (adevent.isSetAdID())
        {
            F = adevent.F;
        }
        ad.conn = adevent.ad.conn;
        G = adevent.G;
        ad.lat = adevent.ad.lat;
        H = adevent.H;
        ad.lon = adevent.ad.lon;
        I = adevent.I;
        ad.alt = adevent.ad.alt;
        J = adevent.J;
        ad.uCount = adevent.ad.uCount;
        K = adevent.K;
        ad.uDur = adevent.ad.uDur;
        L = adevent.L;
        if (!adevent.isSetUDict()) goto _L2; else goto _L1
_L1:
        Object obj;
        Iterator iterator;
        obj = new HashMap();
        iterator = adevent.M.entrySet().iterator();
_L7:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        M = ((Map) (obj));
_L2:
        ad.horizontalAccuracy = adevent.ad.horizontalAccuracy;
        N = adevent.N;
        ad.verticalAccuracy = adevent.ad.verticalAccuracy;
        O = adevent.O;
        if (!adevent.isSetUrlCounts()) goto _L6; else goto _L5
_L5:
        obj = new HashMap();
        iterator = adevent.P.entrySet().iterator();
_L8:
        if (iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_738;
        }
        P = ((Map) (obj));
_L6:
        ad.adExit = adevent.ad.adExit;
        Q = adevent.Q;
        ad.countHr = adevent.ad.countHr;
        R = adevent.R;
        ad.countDay = adevent.ad.countDay;
        S = adevent.S;
        ad.countMon = adevent.ad.countMon;
        T = adevent.T;
        if (adevent.isSetStringValues())
        {
            obj = new ArrayList();
            java.util.Map.Entry entry;
            for (iterator = adevent.U.iterator(); iterator.hasNext(); ((List) (obj)).add(new MMStringData((MMStringData)iterator.next())))
            {
                break MISSING_BLOCK_LABEL_779;
            }

            U = ((List) (obj));
        }
        if (adevent.isSetNumericValues())
        {
            obj = new ArrayList();
            for (iterator = adevent.V.iterator(); iterator.hasNext(); ((List) (obj)).add(new MMNumberData((MMNumberData)iterator.next())))
            {
                break MISSING_BLOCK_LABEL_805;
            }

            V = ((List) (obj));
        }
        if (adevent.isSetBreadcrumbs())
        {
            obj = new ArrayList();
            for (iterator = adevent.W.iterator(); iterator.hasNext(); ((List) (obj)).add(new MMAdEventBreadcrumb((MMAdEventBreadcrumb)iterator.next())))
            {
                break MISSING_BLOCK_LABEL_831;
            }

            W = ((List) (obj));
        }
        if (adevent.isSetVisitedAdEventLinks())
        {
            obj = new ArrayList();
            for (iterator = adevent.X.iterator(); iterator.hasNext(); ((List) (obj)).add(new MMAdEventURL((MMAdEventURL)iterator.next())))
            {
                break MISSING_BLOCK_LABEL_857;
            }

            X = ((List) (obj));
        }
        if (adevent.isSetDurationValues())
        {
            obj = new ArrayList();
            for (iterator = adevent.Y.iterator(); iterator.hasNext(); ((List) (obj)).add(new MMNumberData((MMNumberData)iterator.next())))
            {
                break MISSING_BLOCK_LABEL_883;
            }

            Y = ((List) (obj));
        }
        ad.direction = adevent.ad.direction;
        Z = adevent.Z;
        ad.directionAccuracy = adevent.ad.directionAccuracy;
        aa = adevent.aa;
        if (adevent.isSetAdSlotName())
        {
            ab = adevent.ab;
        }
        if (adevent.isSetAdVersion())
        {
            ac = adevent.ac;
        }
        return;
_L4:
        entry = (java.util.Map.Entry)iterator.next();
        ((Map) (obj)).put((String)entry.getKey(), (String)entry.getValue());
          goto _L7
        entry = (java.util.Map.Entry)iterator.next();
        ((Map) (obj)).put((String)entry.getKey(), (Short)entry.getValue());
          goto _L8
    }

    public AdEvent(String s1, String s2, String s3, String s4, int i1, double d1, 
            double d2, double d3, short word0, short word1, Map map, 
            double d4, double d5, Map map1, int j1, short word2, 
            short word3, short word4, List list, List list1, List list2, List list3, List list4, 
            double d6, double d7, String s5, String s6)
    {
        this();
        C = s1;
        D = s2;
        E = s3;
        F = s4;
        G = i1;
        ad.conn = true;
        H = d1;
        ad.lat = true;
        I = d2;
        ad.lon = true;
        J = d3;
        ad.alt = true;
        K = word0;
        ad.uCount = true;
        L = word1;
        ad.uDur = true;
        M = map;
        N = d4;
        ad.horizontalAccuracy = true;
        O = d5;
        ad.verticalAccuracy = true;
        P = map1;
        Q = j1;
        ad.adExit = true;
        R = word2;
        ad.countHr = true;
        S = word3;
        ad.countDay = true;
        T = word4;
        ad.countMon = true;
        U = list;
        V = list1;
        W = list2;
        X = list3;
        Y = list4;
        Z = d6;
        ad.direction = true;
        aa = d7;
        ad.directionAccuracy = true;
        ab = s5;
        ac = s6;
    }

    public void addToBreadcrumbs(MMAdEventBreadcrumb mmadeventbreadcrumb)
    {
        if (W == null)
        {
            W = new ArrayList();
        }
        W.add(mmadeventbreadcrumb);
    }

    public void addToDurationValues(MMNumberData mmnumberdata)
    {
        if (Y == null)
        {
            Y = new ArrayList();
        }
        Y.add(mmnumberdata);
    }

    public void addToNumericValues(MMNumberData mmnumberdata)
    {
        if (V == null)
        {
            V = new ArrayList();
        }
        V.add(mmnumberdata);
    }

    public void addToStringValues(MMStringData mmstringdata)
    {
        if (U == null)
        {
            U = new ArrayList();
        }
        U.add(mmstringdata);
    }

    public void addToVisitedAdEventLinks(MMAdEventURL mmadeventurl)
    {
        if (X == null)
        {
            X = new ArrayList();
        }
        X.add(mmadeventurl);
    }

    public AdEvent clone()
    {
        return new AdEvent(this);
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public boolean equals(AdEvent adevent)
    {
        if (adevent != null)
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
            if (adevent.isSetEventID())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!flag && !flag1 || flag && flag1 && C.equals(adevent.C))
            {
                if (isSetKey())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (adevent.isSetKey())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (!flag && !flag1 || flag && flag1 && D.equals(adevent.D))
                {
                    if (isSetTime())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (adevent.isSetTime())
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (!flag && !flag1 || flag && flag1 && E.equals(adevent.E))
                    {
                        if (isSetAdID())
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        if (adevent.isSetAdID())
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        if ((!flag && !flag1 || flag && flag1 && F.equals(adevent.F)) && G == adevent.G)
                        {
                            if (isSetLat())
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                            if (adevent.isSetLat())
                            {
                                flag1 = true;
                            } else
                            {
                                flag1 = false;
                            }
                            if (!flag && !flag1 || flag && flag1 && H == adevent.H)
                            {
                                if (isSetLon())
                                {
                                    flag = true;
                                } else
                                {
                                    flag = false;
                                }
                                if (adevent.isSetLon())
                                {
                                    flag1 = true;
                                } else
                                {
                                    flag1 = false;
                                }
                                if (!flag && !flag1 || flag && flag1 && I == adevent.I)
                                {
                                    if (isSetAlt())
                                    {
                                        flag = true;
                                    } else
                                    {
                                        flag = false;
                                    }
                                    if (adevent.isSetAlt())
                                    {
                                        flag1 = true;
                                    } else
                                    {
                                        flag1 = false;
                                    }
                                    if (!flag && !flag1 || flag && flag1 && J == adevent.J)
                                    {
                                        if (isSetUCount())
                                        {
                                            flag = true;
                                        } else
                                        {
                                            flag = false;
                                        }
                                        if (adevent.isSetUCount())
                                        {
                                            flag1 = true;
                                        } else
                                        {
                                            flag1 = false;
                                        }
                                        if (!flag && !flag1 || flag && flag1 && K == adevent.K)
                                        {
                                            if (isSetUDur())
                                            {
                                                flag = true;
                                            } else
                                            {
                                                flag = false;
                                            }
                                            if (adevent.isSetUDur())
                                            {
                                                flag1 = true;
                                            } else
                                            {
                                                flag1 = false;
                                            }
                                            if (!flag && !flag1 || flag && flag1 && L == adevent.L)
                                            {
                                                if (isSetUDict())
                                                {
                                                    flag = true;
                                                } else
                                                {
                                                    flag = false;
                                                }
                                                if (adevent.isSetUDict())
                                                {
                                                    flag1 = true;
                                                } else
                                                {
                                                    flag1 = false;
                                                }
                                                if (!flag && !flag1 || flag && flag1 && M.equals(adevent.M))
                                                {
                                                    if (isSetHorizontalAccuracy())
                                                    {
                                                        flag = true;
                                                    } else
                                                    {
                                                        flag = false;
                                                    }
                                                    if (adevent.isSetHorizontalAccuracy())
                                                    {
                                                        flag1 = true;
                                                    } else
                                                    {
                                                        flag1 = false;
                                                    }
                                                    if (!flag && !flag1 || flag && flag1 && N == adevent.N)
                                                    {
                                                        if (isSetVerticalAccuracy())
                                                        {
                                                            flag = true;
                                                        } else
                                                        {
                                                            flag = false;
                                                        }
                                                        if (adevent.isSetVerticalAccuracy())
                                                        {
                                                            flag1 = true;
                                                        } else
                                                        {
                                                            flag1 = false;
                                                        }
                                                        if (!flag && !flag1 || flag && flag1 && O == adevent.O)
                                                        {
                                                            if (isSetUrlCounts())
                                                            {
                                                                flag = true;
                                                            } else
                                                            {
                                                                flag = false;
                                                            }
                                                            if (adevent.isSetUrlCounts())
                                                            {
                                                                flag1 = true;
                                                            } else
                                                            {
                                                                flag1 = false;
                                                            }
                                                            if (!flag && !flag1 || flag && flag1 && P.equals(adevent.P))
                                                            {
                                                                if (isSetAdExit())
                                                                {
                                                                    flag = true;
                                                                } else
                                                                {
                                                                    flag = false;
                                                                }
                                                                if (adevent.isSetAdExit())
                                                                {
                                                                    flag1 = true;
                                                                } else
                                                                {
                                                                    flag1 = false;
                                                                }
                                                                if (!flag && !flag1 || flag && flag1 && Q == adevent.Q)
                                                                {
                                                                    if (isSetCountHr())
                                                                    {
                                                                        flag = true;
                                                                    } else
                                                                    {
                                                                        flag = false;
                                                                    }
                                                                    if (adevent.isSetCountHr())
                                                                    {
                                                                        flag1 = true;
                                                                    } else
                                                                    {
                                                                        flag1 = false;
                                                                    }
                                                                    if (!flag && !flag1 || flag && flag1 && R == adevent.R)
                                                                    {
                                                                        if (isSetCountDay())
                                                                        {
                                                                            flag = true;
                                                                        } else
                                                                        {
                                                                            flag = false;
                                                                        }
                                                                        if (adevent.isSetCountDay())
                                                                        {
                                                                            flag1 = true;
                                                                        } else
                                                                        {
                                                                            flag1 = false;
                                                                        }
                                                                        if (!flag && !flag1 || flag && flag1 && S == adevent.S)
                                                                        {
                                                                            if (isSetCountMon())
                                                                            {
                                                                                flag = true;
                                                                            } else
                                                                            {
                                                                                flag = false;
                                                                            }
                                                                            if (adevent.isSetCountMon())
                                                                            {
                                                                                flag1 = true;
                                                                            } else
                                                                            {
                                                                                flag1 = false;
                                                                            }
                                                                            if (!flag && !flag1 || flag && flag1 && T == adevent.T)
                                                                            {
                                                                                if (isSetStringValues())
                                                                                {
                                                                                    flag = true;
                                                                                } else
                                                                                {
                                                                                    flag = false;
                                                                                }
                                                                                if (adevent.isSetStringValues())
                                                                                {
                                                                                    flag1 = true;
                                                                                } else
                                                                                {
                                                                                    flag1 = false;
                                                                                }
                                                                                if (!flag && !flag1 || flag && flag1 && U.equals(adevent.U))
                                                                                {
                                                                                    if (isSetNumericValues())
                                                                                    {
                                                                                        flag = true;
                                                                                    } else
                                                                                    {
                                                                                        flag = false;
                                                                                    }
                                                                                    if (adevent.isSetNumericValues())
                                                                                    {
                                                                                        flag1 = true;
                                                                                    } else
                                                                                    {
                                                                                        flag1 = false;
                                                                                    }
                                                                                    if (!flag && !flag1 || flag && flag1 && V.equals(adevent.V))
                                                                                    {
                                                                                        if (isSetBreadcrumbs())
                                                                                        {
                                                                                            flag = true;
                                                                                        } else
                                                                                        {
                                                                                            flag = false;
                                                                                        }
                                                                                        if (adevent.isSetBreadcrumbs())
                                                                                        {
                                                                                            flag1 = true;
                                                                                        } else
                                                                                        {
                                                                                            flag1 = false;
                                                                                        }
                                                                                        if (!flag && !flag1 || flag && flag1 && W.equals(adevent.W))
                                                                                        {
                                                                                            if (isSetVisitedAdEventLinks())
                                                                                            {
                                                                                                flag = true;
                                                                                            } else
                                                                                            {
                                                                                                flag = false;
                                                                                            }
                                                                                            if (adevent.isSetVisitedAdEventLinks())
                                                                                            {
                                                                                                flag1 = true;
                                                                                            } else
                                                                                            {
                                                                                                flag1 = false;
                                                                                            }
                                                                                            if (!flag && !flag1 || flag && flag1 && X.equals(adevent.X))
                                                                                            {
                                                                                                if (isSetDurationValues())
                                                                                                {
                                                                                                    flag = true;
                                                                                                } else
                                                                                                {
                                                                                                    flag = false;
                                                                                                }
                                                                                                if (adevent.isSetDurationValues())
                                                                                                {
                                                                                                    flag1 = true;
                                                                                                } else
                                                                                                {
                                                                                                    flag1 = false;
                                                                                                }
                                                                                                if (!flag && !flag1 || flag && flag1 && Y.equals(adevent.Y))
                                                                                                {
                                                                                                    if (isSetDirection())
                                                                                                    {
                                                                                                        flag = true;
                                                                                                    } else
                                                                                                    {
                                                                                                        flag = false;
                                                                                                    }
                                                                                                    if (adevent.isSetDirection())
                                                                                                    {
                                                                                                        flag1 = true;
                                                                                                    } else
                                                                                                    {
                                                                                                        flag1 = false;
                                                                                                    }
                                                                                                    if (!flag && !flag1 || flag && flag1 && Z == adevent.Z)
                                                                                                    {
                                                                                                        if (isSetDirectionAccuracy())
                                                                                                        {
                                                                                                            flag = true;
                                                                                                        } else
                                                                                                        {
                                                                                                            flag = false;
                                                                                                        }
                                                                                                        if (adevent.isSetDirectionAccuracy())
                                                                                                        {
                                                                                                            flag1 = true;
                                                                                                        } else
                                                                                                        {
                                                                                                            flag1 = false;
                                                                                                        }
                                                                                                        if (!flag && !flag1 || flag && flag1 && aa == adevent.aa)
                                                                                                        {
                                                                                                            if (isSetAdSlotName())
                                                                                                            {
                                                                                                                flag = true;
                                                                                                            } else
                                                                                                            {
                                                                                                                flag = false;
                                                                                                            }
                                                                                                            if (adevent.isSetAdSlotName())
                                                                                                            {
                                                                                                                flag1 = true;
                                                                                                            } else
                                                                                                            {
                                                                                                                flag1 = false;
                                                                                                            }
                                                                                                            if (!flag && !flag1 || flag && flag1 && ab.equals(adevent.ab))
                                                                                                            {
                                                                                                                if (isSetAdVersion())
                                                                                                                {
                                                                                                                    flag = true;
                                                                                                                } else
                                                                                                                {
                                                                                                                    flag = false;
                                                                                                                }
                                                                                                                if (adevent.isSetAdVersion())
                                                                                                                {
                                                                                                                    flag1 = true;
                                                                                                                } else
                                                                                                                {
                                                                                                                    flag1 = false;
                                                                                                                }
                                                                                                                if (!flag && !flag1 || flag && flag1 && ac.equals(adevent.ac))
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
        while (obj == null || !(obj instanceof AdEvent)) 
        {
            return false;
        }
        return equals((AdEvent)obj);
    }

    public int getAdExit()
    {
        return Q;
    }

    public String getAdID()
    {
        return F;
    }

    public String getAdSlotName()
    {
        return ab;
    }

    public String getAdVersion()
    {
        return ac;
    }

    public double getAlt()
    {
        return J;
    }

    public List getBreadcrumbs()
    {
        return W;
    }

    public Iterator getBreadcrumbsIterator()
    {
        if (W == null)
        {
            return null;
        } else
        {
            return W.iterator();
        }
    }

    public int getBreadcrumbsSize()
    {
        if (W == null)
        {
            return 0;
        } else
        {
            return W.size();
        }
    }

    public int getConn()
    {
        return G;
    }

    public short getCountDay()
    {
        return S;
    }

    public short getCountHr()
    {
        return R;
    }

    public short getCountMon()
    {
        return T;
    }

    public double getDirection()
    {
        return Z;
    }

    public double getDirectionAccuracy()
    {
        return aa;
    }

    public List getDurationValues()
    {
        return Y;
    }

    public Iterator getDurationValuesIterator()
    {
        if (Y == null)
        {
            return null;
        } else
        {
            return Y.iterator();
        }
    }

    public int getDurationValuesSize()
    {
        if (Y == null)
        {
            return 0;
        } else
        {
            return Y.size();
        }
    }

    public String getEventID()
    {
        return C;
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
            return getAdID();

        case 5: // '\005'
            return Integer.valueOf(getConn());

        case 6: // '\006'
            return new Double(getLat());

        case 7: // '\007'
            return new Double(getLon());

        case 8: // '\b'
            return new Double(getAlt());

        case 9: // '\t'
            return new Short(getUCount());

        case 10: // '\n'
            return new Short(getUDur());

        case 11: // '\013'
            return getUDict();

        case 12: // '\f'
            return new Double(getHorizontalAccuracy());

        case 13: // '\r'
            return new Double(getVerticalAccuracy());

        case 14: // '\016'
            return getUrlCounts();

        case 15: // '\017'
            return Integer.valueOf(getAdExit());

        case 16: // '\020'
            return new Short(getCountHr());

        case 17: // '\021'
            return new Short(getCountDay());

        case 18: // '\022'
            return new Short(getCountMon());

        case 19: // '\023'
            return getStringValues();

        case 20: // '\024'
            return getNumericValues();

        case 21: // '\025'
            return getBreadcrumbs();

        case 22: // '\026'
            return getVisitedAdEventLinks();

        case 23: // '\027'
            return getDurationValues();

        case 24: // '\030'
            return new Double(getDirection());

        case 25: // '\031'
            return new Double(getDirectionAccuracy());

        case 26: // '\032'
            return getAdSlotName();

        case 27: // '\033'
            return getAdVersion();
        }
    }

    public double getHorizontalAccuracy()
    {
        return N;
    }

    public String getKey()
    {
        return D;
    }

    public double getLat()
    {
        return H;
    }

    public double getLon()
    {
        return I;
    }

    public List getNumericValues()
    {
        return V;
    }

    public Iterator getNumericValuesIterator()
    {
        if (V == null)
        {
            return null;
        } else
        {
            return V.iterator();
        }
    }

    public int getNumericValuesSize()
    {
        if (V == null)
        {
            return 0;
        } else
        {
            return V.size();
        }
    }

    public List getStringValues()
    {
        return U;
    }

    public Iterator getStringValuesIterator()
    {
        if (U == null)
        {
            return null;
        } else
        {
            return U.iterator();
        }
    }

    public int getStringValuesSize()
    {
        if (U == null)
        {
            return 0;
        } else
        {
            return U.size();
        }
    }

    public String getTime()
    {
        return E;
    }

    public short getUCount()
    {
        return K;
    }

    public Map getUDict()
    {
        return M;
    }

    public int getUDictSize()
    {
        if (M == null)
        {
            return 0;
        } else
        {
            return M.size();
        }
    }

    public short getUDur()
    {
        return L;
    }

    public Map getUrlCounts()
    {
        return P;
    }

    public int getUrlCountsSize()
    {
        if (P == null)
        {
            return 0;
        } else
        {
            return P.size();
        }
    }

    public double getVerticalAccuracy()
    {
        return O;
    }

    public List getVisitedAdEventLinks()
    {
        return X;
    }

    public Iterator getVisitedAdEventLinksIterator()
    {
        if (X == null)
        {
            return null;
        } else
        {
            return X.iterator();
        }
    }

    public int getVisitedAdEventLinksSize()
    {
        if (X == null)
        {
            return 0;
        } else
        {
            return X.size();
        }
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
            return isSetAdID();

        case 5: // '\005'
            return isSetConn();

        case 6: // '\006'
            return isSetLat();

        case 7: // '\007'
            return isSetLon();

        case 8: // '\b'
            return isSetAlt();

        case 9: // '\t'
            return isSetUCount();

        case 10: // '\n'
            return isSetUDur();

        case 11: // '\013'
            return isSetUDict();

        case 12: // '\f'
            return isSetHorizontalAccuracy();

        case 13: // '\r'
            return isSetVerticalAccuracy();

        case 14: // '\016'
            return isSetUrlCounts();

        case 15: // '\017'
            return isSetAdExit();

        case 16: // '\020'
            return isSetCountHr();

        case 17: // '\021'
            return isSetCountDay();

        case 18: // '\022'
            return isSetCountMon();

        case 19: // '\023'
            return isSetStringValues();

        case 20: // '\024'
            return isSetNumericValues();

        case 21: // '\025'
            return isSetBreadcrumbs();

        case 22: // '\026'
            return isSetVisitedAdEventLinks();

        case 23: // '\027'
            return isSetDurationValues();

        case 24: // '\030'
            return isSetDirection();

        case 25: // '\031'
            return isSetDirectionAccuracy();

        case 26: // '\032'
            return isSetAdSlotName();

        case 27: // '\033'
            return isSetAdVersion();
        }
    }

    public boolean isSetAdExit()
    {
        return ad.adExit;
    }

    public boolean isSetAdID()
    {
        return F != null;
    }

    public boolean isSetAdSlotName()
    {
        return ab != null;
    }

    public boolean isSetAdVersion()
    {
        return ac != null;
    }

    public boolean isSetAlt()
    {
        return ad.alt;
    }

    public boolean isSetBreadcrumbs()
    {
        return W != null;
    }

    public boolean isSetConn()
    {
        return ad.conn;
    }

    public boolean isSetCountDay()
    {
        return ad.countDay;
    }

    public boolean isSetCountHr()
    {
        return ad.countHr;
    }

    public boolean isSetCountMon()
    {
        return ad.countMon;
    }

    public boolean isSetDirection()
    {
        return ad.direction;
    }

    public boolean isSetDirectionAccuracy()
    {
        return ad.directionAccuracy;
    }

    public boolean isSetDurationValues()
    {
        return Y != null;
    }

    public boolean isSetEventID()
    {
        return C != null;
    }

    public boolean isSetHorizontalAccuracy()
    {
        return ad.horizontalAccuracy;
    }

    public boolean isSetKey()
    {
        return D != null;
    }

    public boolean isSetLat()
    {
        return ad.lat;
    }

    public boolean isSetLon()
    {
        return ad.lon;
    }

    public boolean isSetNumericValues()
    {
        return V != null;
    }

    public boolean isSetStringValues()
    {
        return U != null;
    }

    public boolean isSetTime()
    {
        return E != null;
    }

    public boolean isSetUCount()
    {
        return ad.uCount;
    }

    public boolean isSetUDict()
    {
        return M != null;
    }

    public boolean isSetUDur()
    {
        return ad.uDur;
    }

    public boolean isSetUrlCounts()
    {
        return P != null;
    }

    public boolean isSetVerticalAccuracy()
    {
        return ad.verticalAccuracy;
    }

    public boolean isSetVisitedAdEventLinks()
    {
        return X != null;
    }

    public void putToUDict(String s1, String s2)
    {
        if (M == null)
        {
            M = new HashMap();
        }
        M.put(s1, s2);
    }

    public void putToUrlCounts(String s1, short word0)
    {
        if (P == null)
        {
            P = new HashMap();
        }
        P.put(s1, Short.valueOf(word0));
    }

    public void read(TProtocol tprotocol)
        throws TException
    {
        tprotocol.readStructBegin();
_L30:
        Object obj;
        obj = tprotocol.readFieldBegin();
        if (((TField) (obj)).type == 0)
        {
            break MISSING_BLOCK_LABEL_1552;
        }
        ((TField) (obj)).id;
        JVM INSTR tableswitch 1 27: default 144
    //                   1 159
    //                   2 190
    //                   3 221
    //                   4 252
    //                   5 283
    //                   6 322
    //                   7 360
    //                   8 398
    //                   9 436
    //                   10 475
    //                   11 514
    //                   12 610
    //                   13 648
    //                   14 686
    //                   15 783
    //                   16 822
    //                   17 861
    //                   18 900
    //                   19 939
    //                   20 1034
    //                   21 1129
    //                   22 1224
    //                   23 1319
    //                   24 1414
    //                   25 1452
    //                   26 1490
    //                   27 1521;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28
_L2:
        break; /* Loop/switch isn't completed */
_L28:
        break MISSING_BLOCK_LABEL_1521;
_L1:
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L31:
        tprotocol.readFieldEnd();
        if (true) goto _L30; else goto _L29
_L29:
        if (((TField) (obj)).type == 11)
        {
            C = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L31
_L3:
        if (((TField) (obj)).type == 11)
        {
            D = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L31
_L4:
        if (((TField) (obj)).type == 11)
        {
            E = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L31
_L5:
        if (((TField) (obj)).type == 11)
        {
            F = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L31
_L6:
        if (((TField) (obj)).type == 8)
        {
            G = tprotocol.readI32();
            ad.conn = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L31
_L7:
        if (((TField) (obj)).type == 4)
        {
            H = tprotocol.readDouble();
            ad.lat = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L31
_L8:
        if (((TField) (obj)).type == 4)
        {
            I = tprotocol.readDouble();
            ad.lon = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L31
_L9:
        if (((TField) (obj)).type == 4)
        {
            J = tprotocol.readDouble();
            ad.alt = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L31
_L10:
        if (((TField) (obj)).type == 6)
        {
            K = tprotocol.readI16();
            ad.uCount = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L31
_L11:
        if (((TField) (obj)).type == 6)
        {
            L = tprotocol.readI16();
            ad.uDur = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L31
_L12:
        int i1;
        if (((TField) (obj)).type != 13)
        {
            break MISSING_BLOCK_LABEL_599;
        }
        obj = tprotocol.readMapBegin();
        M = new HashMap(((TMap) (obj)).size * 2);
        i1 = 0;
_L32:
label0:
        {
            if (i1 < ((TMap) (obj)).size)
            {
                break label0;
            }
            tprotocol.readMapEnd();
        }
          goto _L31
        String s1 = tprotocol.readString();
        String s3 = tprotocol.readString();
        M.put(s1, s3);
        i1++;
          goto _L32
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
          goto _L31
_L13:
        if (((TField) (obj)).type == 4)
        {
            N = tprotocol.readDouble();
            ad.horizontalAccuracy = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L31
_L14:
        if (((TField) (obj)).type == 4)
        {
            O = tprotocol.readDouble();
            ad.verticalAccuracy = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L31
_L15:
        if (((TField) (obj)).type != 13)
        {
            break MISSING_BLOCK_LABEL_772;
        }
        obj = tprotocol.readMapBegin();
        P = new HashMap(((TMap) (obj)).size * 2);
        i1 = 0;
_L33:
label1:
        {
            if (i1 < ((TMap) (obj)).size)
            {
                break label1;
            }
            tprotocol.readMapEnd();
        }
          goto _L31
        String s2 = tprotocol.readString();
        short word0 = tprotocol.readI16();
        P.put(s2, Short.valueOf(word0));
        i1++;
          goto _L33
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
          goto _L31
_L16:
        if (((TField) (obj)).type == 8)
        {
            Q = tprotocol.readI32();
            ad.adExit = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L31
_L17:
        if (((TField) (obj)).type == 6)
        {
            R = tprotocol.readI16();
            ad.countHr = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L31
_L18:
        if (((TField) (obj)).type == 6)
        {
            S = tprotocol.readI16();
            ad.countDay = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L31
_L19:
        if (((TField) (obj)).type == 6)
        {
            T = tprotocol.readI16();
            ad.countMon = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L31
_L20:
        if (((TField) (obj)).type != 15)
        {
            break MISSING_BLOCK_LABEL_1023;
        }
        obj = tprotocol.readListBegin();
        U = new ArrayList(((TList) (obj)).size);
        i1 = 0;
_L34:
label2:
        {
            if (i1 < ((TList) (obj)).size)
            {
                break label2;
            }
            tprotocol.readListEnd();
        }
          goto _L31
        MMStringData mmstringdata = new MMStringData();
        mmstringdata.read(tprotocol);
        U.add(mmstringdata);
        i1++;
          goto _L34
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
          goto _L31
_L21:
        if (((TField) (obj)).type != 15)
        {
            break MISSING_BLOCK_LABEL_1118;
        }
        obj = tprotocol.readListBegin();
        V = new ArrayList(((TList) (obj)).size);
        i1 = 0;
_L35:
label3:
        {
            if (i1 < ((TList) (obj)).size)
            {
                break label3;
            }
            tprotocol.readListEnd();
        }
          goto _L31
        MMNumberData mmnumberdata = new MMNumberData();
        mmnumberdata.read(tprotocol);
        V.add(mmnumberdata);
        i1++;
          goto _L35
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
          goto _L31
_L22:
        if (((TField) (obj)).type != 15)
        {
            break MISSING_BLOCK_LABEL_1213;
        }
        obj = tprotocol.readListBegin();
        W = new ArrayList(((TList) (obj)).size);
        i1 = 0;
_L36:
label4:
        {
            if (i1 < ((TList) (obj)).size)
            {
                break label4;
            }
            tprotocol.readListEnd();
        }
          goto _L31
        MMAdEventBreadcrumb mmadeventbreadcrumb = new MMAdEventBreadcrumb();
        mmadeventbreadcrumb.read(tprotocol);
        W.add(mmadeventbreadcrumb);
        i1++;
          goto _L36
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
          goto _L31
_L23:
        if (((TField) (obj)).type != 15)
        {
            break MISSING_BLOCK_LABEL_1308;
        }
        obj = tprotocol.readListBegin();
        X = new ArrayList(((TList) (obj)).size);
        i1 = 0;
_L37:
label5:
        {
            if (i1 < ((TList) (obj)).size)
            {
                break label5;
            }
            tprotocol.readListEnd();
        }
          goto _L31
        MMAdEventURL mmadeventurl = new MMAdEventURL();
        mmadeventurl.read(tprotocol);
        X.add(mmadeventurl);
        i1++;
          goto _L37
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
          goto _L31
_L24:
        if (((TField) (obj)).type != 15)
        {
            break MISSING_BLOCK_LABEL_1403;
        }
        obj = tprotocol.readListBegin();
        Y = new ArrayList(((TList) (obj)).size);
        i1 = 0;
_L38:
label6:
        {
            if (i1 < ((TList) (obj)).size)
            {
                break label6;
            }
            tprotocol.readListEnd();
        }
          goto _L31
        MMNumberData mmnumberdata1 = new MMNumberData();
        mmnumberdata1.read(tprotocol);
        Y.add(mmnumberdata1);
        i1++;
          goto _L38
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
          goto _L31
_L25:
        if (((TField) (obj)).type == 4)
        {
            Z = tprotocol.readDouble();
            ad.direction = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L31
_L26:
        if (((TField) (obj)).type == 4)
        {
            aa = tprotocol.readDouble();
            ad.directionAccuracy = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L31
_L27:
        if (((TField) (obj)).type == 11)
        {
            ab = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L31
        if (((TField) (obj)).type == 11)
        {
            ac = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L31
        tprotocol.readStructEnd();
        validate();
        return;
    }

    public void setAdExit(int i1)
    {
        Q = i1;
        ad.adExit = true;
    }

    public void setAdID(String s1)
    {
        F = s1;
    }

    public void setAdSlotName(String s1)
    {
        ab = s1;
    }

    public void setAdVersion(String s1)
    {
        ac = s1;
    }

    public void setAlt(double d1)
    {
        J = d1;
        ad.alt = true;
    }

    public void setBreadcrumbs(List list)
    {
        W = list;
    }

    public void setConn(int i1)
    {
        G = i1;
        ad.conn = true;
    }

    public void setCountDay(short word0)
    {
        S = word0;
        ad.countDay = true;
    }

    public void setCountHr(short word0)
    {
        R = word0;
        ad.countHr = true;
    }

    public void setCountMon(short word0)
    {
        T = word0;
        ad.countMon = true;
    }

    public void setDirection(double d1)
    {
        Z = d1;
        ad.direction = true;
    }

    public void setDirectionAccuracy(double d1)
    {
        aa = d1;
        ad.directionAccuracy = true;
    }

    public void setDurationValues(List list)
    {
        Y = list;
    }

    public void setEventID(String s1)
    {
        C = s1;
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
                unsetAdID();
                return;
            } else
            {
                setAdID((String)obj);
                return;
            }

        case 5: // '\005'
            if (obj == null)
            {
                unsetConn();
                return;
            } else
            {
                setConn(((Integer)obj).intValue());
                return;
            }

        case 6: // '\006'
            if (obj == null)
            {
                unsetLat();
                return;
            } else
            {
                setLat(((Double)obj).doubleValue());
                return;
            }

        case 7: // '\007'
            if (obj == null)
            {
                unsetLon();
                return;
            } else
            {
                setLon(((Double)obj).doubleValue());
                return;
            }

        case 8: // '\b'
            if (obj == null)
            {
                unsetAlt();
                return;
            } else
            {
                setAlt(((Double)obj).doubleValue());
                return;
            }

        case 9: // '\t'
            if (obj == null)
            {
                unsetUCount();
                return;
            } else
            {
                setUCount(((Short)obj).shortValue());
                return;
            }

        case 10: // '\n'
            if (obj == null)
            {
                unsetUDur();
                return;
            } else
            {
                setUDur(((Short)obj).shortValue());
                return;
            }

        case 11: // '\013'
            if (obj == null)
            {
                unsetUDict();
                return;
            } else
            {
                setUDict((Map)obj);
                return;
            }

        case 12: // '\f'
            if (obj == null)
            {
                unsetHorizontalAccuracy();
                return;
            } else
            {
                setHorizontalAccuracy(((Double)obj).doubleValue());
                return;
            }

        case 13: // '\r'
            if (obj == null)
            {
                unsetVerticalAccuracy();
                return;
            } else
            {
                setVerticalAccuracy(((Double)obj).doubleValue());
                return;
            }

        case 14: // '\016'
            if (obj == null)
            {
                unsetUrlCounts();
                return;
            } else
            {
                setUrlCounts((Map)obj);
                return;
            }

        case 15: // '\017'
            if (obj == null)
            {
                unsetAdExit();
                return;
            } else
            {
                setAdExit(((Integer)obj).intValue());
                return;
            }

        case 16: // '\020'
            if (obj == null)
            {
                unsetCountHr();
                return;
            } else
            {
                setCountHr(((Short)obj).shortValue());
                return;
            }

        case 17: // '\021'
            if (obj == null)
            {
                unsetCountDay();
                return;
            } else
            {
                setCountDay(((Short)obj).shortValue());
                return;
            }

        case 18: // '\022'
            if (obj == null)
            {
                unsetCountMon();
                return;
            } else
            {
                setCountMon(((Short)obj).shortValue());
                return;
            }

        case 19: // '\023'
            if (obj == null)
            {
                unsetStringValues();
                return;
            } else
            {
                setStringValues((List)obj);
                return;
            }

        case 20: // '\024'
            if (obj == null)
            {
                unsetNumericValues();
                return;
            } else
            {
                setNumericValues((List)obj);
                return;
            }

        case 21: // '\025'
            if (obj == null)
            {
                unsetBreadcrumbs();
                return;
            } else
            {
                setBreadcrumbs((List)obj);
                return;
            }

        case 22: // '\026'
            if (obj == null)
            {
                unsetVisitedAdEventLinks();
                return;
            } else
            {
                setVisitedAdEventLinks((List)obj);
                return;
            }

        case 23: // '\027'
            if (obj == null)
            {
                unsetDurationValues();
                return;
            } else
            {
                setDurationValues((List)obj);
                return;
            }

        case 24: // '\030'
            if (obj == null)
            {
                unsetDirection();
                return;
            } else
            {
                setDirection(((Double)obj).doubleValue());
                return;
            }

        case 25: // '\031'
            if (obj == null)
            {
                unsetDirectionAccuracy();
                return;
            } else
            {
                setDirectionAccuracy(((Double)obj).doubleValue());
                return;
            }

        case 26: // '\032'
            if (obj == null)
            {
                unsetAdSlotName();
                return;
            } else
            {
                setAdSlotName((String)obj);
                return;
            }

        case 27: // '\033'
            break;
        }
        if (obj == null)
        {
            unsetAdVersion();
            return;
        } else
        {
            setAdVersion((String)obj);
            return;
        }
    }

    public void setHorizontalAccuracy(double d1)
    {
        N = d1;
        ad.horizontalAccuracy = true;
    }

    public void setKey(String s1)
    {
        D = s1;
    }

    public void setLat(double d1)
    {
        H = d1;
        ad.lat = true;
    }

    public void setLon(double d1)
    {
        I = d1;
        ad.lon = true;
    }

    public void setNumericValues(List list)
    {
        V = list;
    }

    public void setStringValues(List list)
    {
        U = list;
    }

    public void setTime(String s1)
    {
        E = s1;
    }

    public void setUCount(short word0)
    {
        K = word0;
        ad.uCount = true;
    }

    public void setUDict(Map map)
    {
        M = map;
    }

    public void setUDur(short word0)
    {
        L = word0;
        ad.uDur = true;
    }

    public void setUrlCounts(Map map)
    {
        P = map;
    }

    public void setVerticalAccuracy(double d1)
    {
        O = d1;
        ad.verticalAccuracy = true;
    }

    public void setVisitedAdEventLinks(List list)
    {
        X = list;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("AdEvent(");
        stringbuilder.append("eventID:");
        String s1;
        if (C == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(C);
        }
        stringbuilder.append(", ");
        stringbuilder.append("key:");
        if (D == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(D);
        }
        stringbuilder.append(", ");
        stringbuilder.append("time:");
        if (E == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(E);
        }
        stringbuilder.append(", ");
        stringbuilder.append("adID:");
        if (F == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(F);
        }
        stringbuilder.append(", ");
        stringbuilder.append("conn:");
        s1 = (String)connectionState.VALUES_TO_NAMES.get(Integer.valueOf(G));
        if (s1 != null)
        {
            stringbuilder.append(s1);
            stringbuilder.append(" (");
        }
        stringbuilder.append(G);
        if (s1 != null)
        {
            stringbuilder.append(")");
        }
        if (isSetLat())
        {
            stringbuilder.append(", ");
            stringbuilder.append("lat:");
            stringbuilder.append(H);
        }
        if (isSetLon())
        {
            stringbuilder.append(", ");
            stringbuilder.append("lon:");
            stringbuilder.append(I);
        }
        if (isSetAlt())
        {
            stringbuilder.append(", ");
            stringbuilder.append("alt:");
            stringbuilder.append(J);
        }
        if (isSetUCount())
        {
            stringbuilder.append(", ");
            stringbuilder.append("uCount:");
            stringbuilder.append(K);
        }
        if (isSetUDur())
        {
            stringbuilder.append(", ");
            stringbuilder.append("uDur:");
            stringbuilder.append(L);
        }
        if (isSetUDict())
        {
            stringbuilder.append(", ");
            stringbuilder.append("uDict:");
            String s2;
            if (M == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(M);
            }
        }
        if (isSetHorizontalAccuracy())
        {
            stringbuilder.append(", ");
            stringbuilder.append("horizontalAccuracy:");
            stringbuilder.append(N);
        }
        if (isSetVerticalAccuracy())
        {
            stringbuilder.append(", ");
            stringbuilder.append("verticalAccuracy:");
            stringbuilder.append(O);
        }
        if (isSetUrlCounts())
        {
            stringbuilder.append(", ");
            stringbuilder.append("urlCounts:");
            if (P == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(P);
            }
        }
        if (isSetAdExit())
        {
            stringbuilder.append(", ");
            stringbuilder.append("adExit:");
            s2 = (String)adExitEnum.VALUES_TO_NAMES.get(Integer.valueOf(Q));
            if (s2 != null)
            {
                stringbuilder.append(s2);
                stringbuilder.append(" (");
            }
            stringbuilder.append(Q);
            if (s2 != null)
            {
                stringbuilder.append(")");
            }
        }
        if (isSetCountHr())
        {
            stringbuilder.append(", ");
            stringbuilder.append("countHr:");
            stringbuilder.append(R);
        }
        if (isSetCountDay())
        {
            stringbuilder.append(", ");
            stringbuilder.append("countDay:");
            stringbuilder.append(S);
        }
        if (isSetCountMon())
        {
            stringbuilder.append(", ");
            stringbuilder.append("countMon:");
            stringbuilder.append(T);
        }
        if (isSetStringValues())
        {
            stringbuilder.append(", ");
            stringbuilder.append("stringValues:");
            if (U == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(U);
            }
        }
        if (isSetNumericValues())
        {
            stringbuilder.append(", ");
            stringbuilder.append("numericValues:");
            if (V == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(V);
            }
        }
        if (isSetBreadcrumbs())
        {
            stringbuilder.append(", ");
            stringbuilder.append("breadcrumbs:");
            if (W == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(W);
            }
        }
        if (isSetVisitedAdEventLinks())
        {
            stringbuilder.append(", ");
            stringbuilder.append("visitedAdEventLinks:");
            if (X == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(X);
            }
        }
        if (isSetDurationValues())
        {
            stringbuilder.append(", ");
            stringbuilder.append("durationValues:");
            if (Y == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(Y);
            }
        }
        if (isSetDirection())
        {
            stringbuilder.append(", ");
            stringbuilder.append("direction:");
            stringbuilder.append(Z);
        }
        if (isSetDirectionAccuracy())
        {
            stringbuilder.append(", ");
            stringbuilder.append("directionAccuracy:");
            stringbuilder.append(aa);
        }
        stringbuilder.append(", ");
        stringbuilder.append("adSlotName:");
        if (ab == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(ab);
        }
        stringbuilder.append(", ");
        stringbuilder.append("adVersion:");
        if (ac == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(ac);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetAdExit()
    {
        ad.adExit = false;
    }

    public void unsetAdID()
    {
        F = null;
    }

    public void unsetAdSlotName()
    {
        ab = null;
    }

    public void unsetAdVersion()
    {
        ac = null;
    }

    public void unsetAlt()
    {
        ad.alt = false;
    }

    public void unsetBreadcrumbs()
    {
        W = null;
    }

    public void unsetConn()
    {
        ad.conn = false;
    }

    public void unsetCountDay()
    {
        ad.countDay = false;
    }

    public void unsetCountHr()
    {
        ad.countHr = false;
    }

    public void unsetCountMon()
    {
        ad.countMon = false;
    }

    public void unsetDirection()
    {
        ad.direction = false;
    }

    public void unsetDirectionAccuracy()
    {
        ad.directionAccuracy = false;
    }

    public void unsetDurationValues()
    {
        Y = null;
    }

    public void unsetEventID()
    {
        C = null;
    }

    public void unsetHorizontalAccuracy()
    {
        ad.horizontalAccuracy = false;
    }

    public void unsetKey()
    {
        D = null;
    }

    public void unsetLat()
    {
        ad.lat = false;
    }

    public void unsetLon()
    {
        ad.lon = false;
    }

    public void unsetNumericValues()
    {
        V = null;
    }

    public void unsetStringValues()
    {
        U = null;
    }

    public void unsetTime()
    {
        E = null;
    }

    public void unsetUCount()
    {
        ad.uCount = false;
    }

    public void unsetUDict()
    {
        M = null;
    }

    public void unsetUDur()
    {
        ad.uDur = false;
    }

    public void unsetUrlCounts()
    {
        P = null;
    }

    public void unsetVerticalAccuracy()
    {
        ad.verticalAccuracy = false;
    }

    public void unsetVisitedAdEventLinks()
    {
        X = null;
    }

    public void validate()
        throws TException
    {
        if (isSetConn() && !connectionState.VALID_VALUES.contains(G))
        {
            throw new TProtocolException((new StringBuilder("The field 'conn' has been assigned the invalid value ")).append(G).toString());
        }
        if (isSetAdExit() && !adExitEnum.VALID_VALUES.contains(Q))
        {
            throw new TProtocolException((new StringBuilder("The field 'adExit' has been assigned the invalid value ")).append(Q).toString());
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
        if (C != null)
        {
            tprotocol.writeFieldBegin(b);
            tprotocol.writeString(C);
            tprotocol.writeFieldEnd();
        }
        if (D != null)
        {
            tprotocol.writeFieldBegin(c);
            tprotocol.writeString(D);
            tprotocol.writeFieldEnd();
        }
        if (E != null)
        {
            tprotocol.writeFieldBegin(d);
            tprotocol.writeString(E);
            tprotocol.writeFieldEnd();
        }
        if (F != null)
        {
            tprotocol.writeFieldBegin(e);
            tprotocol.writeString(F);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldBegin(f);
        tprotocol.writeI32(G);
        tprotocol.writeFieldEnd();
        if (isSetLat())
        {
            tprotocol.writeFieldBegin(g);
            tprotocol.writeDouble(H);
            tprotocol.writeFieldEnd();
        }
        if (isSetLon())
        {
            tprotocol.writeFieldBegin(h);
            tprotocol.writeDouble(I);
            tprotocol.writeFieldEnd();
        }
        if (isSetAlt())
        {
            tprotocol.writeFieldBegin(i);
            tprotocol.writeDouble(J);
            tprotocol.writeFieldEnd();
        }
        if (isSetUCount())
        {
            tprotocol.writeFieldBegin(j);
            tprotocol.writeI16(K);
            tprotocol.writeFieldEnd();
        }
        if (isSetUDur())
        {
            tprotocol.writeFieldBegin(k);
            tprotocol.writeI16(L);
            tprotocol.writeFieldEnd();
        }
        if (M == null || !isSetUDict()) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        tprotocol.writeFieldBegin(l);
        tprotocol.writeMapBegin(new TMap((byte)11, (byte)11, M.size()));
        iterator = M.entrySet().iterator();
_L7:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        tprotocol.writeMapEnd();
        tprotocol.writeFieldEnd();
_L2:
        if (isSetHorizontalAccuracy())
        {
            tprotocol.writeFieldBegin(m);
            tprotocol.writeDouble(N);
            tprotocol.writeFieldEnd();
        }
        if (isSetVerticalAccuracy())
        {
            tprotocol.writeFieldBegin(n);
            tprotocol.writeDouble(O);
            tprotocol.writeFieldEnd();
        }
        if (P == null || !isSetUrlCounts()) goto _L6; else goto _L5
_L5:
        tprotocol.writeFieldBegin(o);
        tprotocol.writeMapBegin(new TMap((byte)11, (byte)6, P.size()));
        iterator = P.entrySet().iterator();
_L8:
        if (iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_1076;
        }
        tprotocol.writeMapEnd();
        tprotocol.writeFieldEnd();
_L6:
        if (isSetAdExit())
        {
            tprotocol.writeFieldBegin(p);
            tprotocol.writeI32(Q);
            tprotocol.writeFieldEnd();
        }
        if (isSetCountHr())
        {
            tprotocol.writeFieldBegin(q);
            tprotocol.writeI16(R);
            tprotocol.writeFieldEnd();
        }
        if (isSetCountDay())
        {
            tprotocol.writeFieldBegin(r);
            tprotocol.writeI16(S);
            tprotocol.writeFieldEnd();
        }
        if (isSetCountMon())
        {
            tprotocol.writeFieldBegin(s);
            tprotocol.writeI16(T);
            tprotocol.writeFieldEnd();
        }
        if (U != null && isSetStringValues())
        {
            tprotocol.writeFieldBegin(t);
            tprotocol.writeListBegin(new TList((byte)12, U.size()));
            java.util.Map.Entry entry;
            for (iterator = U.iterator(); iterator.hasNext(); ((MMStringData)iterator.next()).write(tprotocol))
            {
                break MISSING_BLOCK_LABEL_1118;
            }

            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        if (V != null && isSetNumericValues())
        {
            tprotocol.writeFieldBegin(u);
            tprotocol.writeListBegin(new TList((byte)12, V.size()));
            for (iterator = V.iterator(); iterator.hasNext(); ((MMNumberData)iterator.next()).write(tprotocol))
            {
                break MISSING_BLOCK_LABEL_1134;
            }

            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        if (W != null && isSetBreadcrumbs())
        {
            tprotocol.writeFieldBegin(v);
            tprotocol.writeListBegin(new TList((byte)12, W.size()));
            for (iterator = W.iterator(); iterator.hasNext(); ((MMAdEventBreadcrumb)iterator.next()).write(tprotocol))
            {
                break MISSING_BLOCK_LABEL_1150;
            }

            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        if (X != null && isSetVisitedAdEventLinks())
        {
            tprotocol.writeFieldBegin(w);
            tprotocol.writeListBegin(new TList((byte)12, X.size()));
            for (iterator = X.iterator(); iterator.hasNext(); ((MMAdEventURL)iterator.next()).write(tprotocol))
            {
                break MISSING_BLOCK_LABEL_1166;
            }

            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        if (Y != null && isSetDurationValues())
        {
            tprotocol.writeFieldBegin(x);
            tprotocol.writeListBegin(new TList((byte)12, Y.size()));
            for (iterator = Y.iterator(); iterator.hasNext(); ((MMNumberData)iterator.next()).write(tprotocol))
            {
                break MISSING_BLOCK_LABEL_1182;
            }

            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        if (isSetDirection())
        {
            tprotocol.writeFieldBegin(y);
            tprotocol.writeDouble(Z);
            tprotocol.writeFieldEnd();
        }
        if (isSetDirectionAccuracy())
        {
            tprotocol.writeFieldBegin(z);
            tprotocol.writeDouble(aa);
            tprotocol.writeFieldEnd();
        }
        if (ab != null)
        {
            tprotocol.writeFieldBegin(A);
            tprotocol.writeString(ab);
            tprotocol.writeFieldEnd();
        }
        if (ac != null)
        {
            tprotocol.writeFieldBegin(B);
            tprotocol.writeString(ac);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
        return;
_L4:
        entry = (java.util.Map.Entry)iterator.next();
        tprotocol.writeString((String)entry.getKey());
        tprotocol.writeString((String)entry.getValue());
          goto _L7
        entry = (java.util.Map.Entry)iterator.next();
        tprotocol.writeString((String)entry.getKey());
        tprotocol.writeI16(((Short)entry.getValue()).shortValue());
          goto _L8
    }

    static 
    {
        metaDataMap = Collections.unmodifiableMap(new com.medialets.thrift.a());
        FieldMetaData.addStructMetaDataMap(com/medialets/thrift/AdEvent, metaDataMap);
    }

    // Unreferenced inner class com/medialets/thrift/a
    final class com.medialets.thrift.a extends HashMap
    {

            com.medialets.thrift.a()
            {
                put(Integer.valueOf(1), new FieldMetaData("eventID", (byte)3, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(2), new FieldMetaData("key", (byte)3, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(3), new FieldMetaData("time", (byte)3, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(4), new FieldMetaData("adID", (byte)3, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(5), new FieldMetaData("conn", (byte)3, new FieldValueMetaData((byte)8)));
                put(Integer.valueOf(6), new FieldMetaData("lat", (byte)2, new FieldValueMetaData((byte)4)));
                put(Integer.valueOf(7), new FieldMetaData("lon", (byte)2, new FieldValueMetaData((byte)4)));
                put(Integer.valueOf(8), new FieldMetaData("alt", (byte)2, new FieldValueMetaData((byte)4)));
                put(Integer.valueOf(9), new FieldMetaData("uCount", (byte)2, new FieldValueMetaData((byte)6)));
                put(Integer.valueOf(10), new FieldMetaData("uDur", (byte)2, new FieldValueMetaData((byte)6)));
                put(Integer.valueOf(11), new FieldMetaData("uDict", (byte)2, new MapMetaData((byte)13, new FieldValueMetaData((byte)11), new FieldValueMetaData((byte)11))));
                put(Integer.valueOf(12), new FieldMetaData("horizontalAccuracy", (byte)2, new FieldValueMetaData((byte)4)));
                put(Integer.valueOf(13), new FieldMetaData("verticalAccuracy", (byte)2, new FieldValueMetaData((byte)4)));
                put(Integer.valueOf(14), new FieldMetaData("urlCounts", (byte)2, new MapMetaData((byte)13, new FieldValueMetaData((byte)11), new FieldValueMetaData((byte)6))));
                put(Integer.valueOf(15), new FieldMetaData("adExit", (byte)2, new FieldValueMetaData((byte)8)));
                put(Integer.valueOf(16), new FieldMetaData("countHr", (byte)2, new FieldValueMetaData((byte)6)));
                put(Integer.valueOf(17), new FieldMetaData("countDay", (byte)2, new FieldValueMetaData((byte)6)));
                put(Integer.valueOf(18), new FieldMetaData("countMon", (byte)2, new FieldValueMetaData((byte)6)));
                put(Integer.valueOf(19), new FieldMetaData("stringValues", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/medialets/thrift/MMStringData))));
                put(Integer.valueOf(20), new FieldMetaData("numericValues", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/medialets/thrift/MMNumberData))));
                put(Integer.valueOf(21), new FieldMetaData("breadcrumbs", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/medialets/thrift/MMAdEventBreadcrumb))));
                put(Integer.valueOf(22), new FieldMetaData("visitedAdEventLinks", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/medialets/thrift/MMAdEventURL))));
                put(Integer.valueOf(23), new FieldMetaData("durationValues", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/medialets/thrift/MMNumberData))));
                put(Integer.valueOf(24), new FieldMetaData("direction", (byte)2, new FieldValueMetaData((byte)4)));
                put(Integer.valueOf(25), new FieldMetaData("directionAccuracy", (byte)2, new FieldValueMetaData((byte)4)));
                put(Integer.valueOf(26), new FieldMetaData("adSlotName", (byte)3, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(27), new FieldMetaData("adVersion", (byte)3, new FieldValueMetaData((byte)11)));
            }
    }

}
