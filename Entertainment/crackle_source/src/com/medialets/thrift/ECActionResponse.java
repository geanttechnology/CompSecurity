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
//            b, MMAdControl

public class ECActionResponse
    implements Serializable, Cloneable, TBase
{
    private static final class a
        implements Serializable
    {

        public boolean dcEnabled;
        public boolean kill;
        public boolean minBroadcastInterval;
        public boolean shutdown;

        a()
        {
            this((byte)0);
        }

        private a(byte byte0)
        {
            minBroadcastInterval = false;
            shutdown = false;
            kill = false;
            dcEnabled = false;
        }
    }


    public static final int ADCONTROLS = 16;
    public static final int ADINSTRUCTIONS = 15;
    public static final int APPTOK = 6;
    public static final int BROADCASTURL = 4;
    public static final int CLIENTTOKEN = 5;
    public static final int DCENABLED = 13;
    public static final int DEBUGMESSAGE = 8;
    public static final int DEVTOK = 7;
    public static final int KILL = 12;
    public static final int MINBROADCASTINTERVAL = 3;
    public static final int RECEIVEDADEVENTS = 2;
    public static final int RECEIVEDEVENTS = 1;
    public static final int RECEIVEDRUNS = 14;
    public static final int SHUTDOWN = 11;
    public static final int USERMESSAGE = 9;
    public static final int USERMESSAGEURL = 10;
    private static final TStruct a = new TStruct("ECActionResponse");
    private static final TField b = new TField("receivedEvents", (byte)15, (short)1);
    private static final TField c = new TField("receivedAdEvents", (byte)15, (short)2);
    private static final TField d = new TField("minBroadcastInterval", (byte)8, (short)3);
    private static final TField e = new TField("broadcastURL", (byte)11, (short)4);
    private static final TField f = new TField("clientToken", (byte)11, (short)5);
    private static final TField g = new TField("appTok", (byte)11, (short)6);
    private static final TField h = new TField("devTok", (byte)11, (short)7);
    private static final TField i = new TField("debugMessage", (byte)11, (short)8);
    private static final TField j = new TField("userMessage", (byte)11, (short)9);
    private static final TField k = new TField("userMessageURL", (byte)11, (short)10);
    private static final TField l = new TField("shutdown", (byte)2, (short)11);
    private static final TField m = new TField("kill", (byte)2, (short)12);
    public static final Map metaDataMap;
    private static final TField n = new TField("dcEnabled", (byte)2, (short)13);
    private static final TField o = new TField("receivedRuns", (byte)15, (short)14);
    private static final TField p = new TField("adInstructions", (byte)15, (short)15);
    private static final TField q = new TField("adControls", (byte)15, (short)16);
    private String A;
    private boolean B;
    private boolean C;
    private boolean D;
    private List E;
    private List F;
    private List G;
    private final a H;
    private List r;
    private List s;
    private int t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;

    public ECActionResponse()
    {
        H = new a();
    }

    public ECActionResponse(ECActionResponse ecactionresponse)
    {
        H = new a();
        if (!ecactionresponse.isSetReceivedEvents()) goto _L2; else goto _L1
_L1:
        ArrayList arraylist;
        Iterator iterator;
        arraylist = new ArrayList();
        iterator = ecactionresponse.r.iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        r = arraylist;
_L2:
        if (ecactionresponse.isSetReceivedAdEvents())
        {
            arraylist = new ArrayList();
            for (iterator = ecactionresponse.s.iterator(); iterator.hasNext(); arraylist.add((String)iterator.next()))
            {
                break MISSING_BLOCK_LABEL_423;
            }

            s = arraylist;
        }
        H.minBroadcastInterval = ecactionresponse.H.minBroadcastInterval;
        t = ecactionresponse.t;
        if (ecactionresponse.isSetBroadcastURL())
        {
            u = ecactionresponse.u;
        }
        if (ecactionresponse.isSetClientToken())
        {
            v = ecactionresponse.v;
        }
        if (ecactionresponse.isSetAppTok())
        {
            w = ecactionresponse.w;
        }
        if (ecactionresponse.isSetDevTok())
        {
            x = ecactionresponse.x;
        }
        if (ecactionresponse.isSetDebugMessage())
        {
            y = ecactionresponse.y;
        }
        if (ecactionresponse.isSetUserMessage())
        {
            z = ecactionresponse.z;
        }
        if (ecactionresponse.isSetUserMessageURL())
        {
            A = ecactionresponse.A;
        }
        H.shutdown = ecactionresponse.H.shutdown;
        B = ecactionresponse.B;
        H.kill = ecactionresponse.H.kill;
        C = ecactionresponse.C;
        H.dcEnabled = ecactionresponse.H.dcEnabled;
        D = ecactionresponse.D;
        if (ecactionresponse.isSetReceivedRuns())
        {
            arraylist = new ArrayList();
            for (iterator = ecactionresponse.E.iterator(); iterator.hasNext(); arraylist.add((String)iterator.next()))
            {
                break MISSING_BLOCK_LABEL_442;
            }

            E = arraylist;
        }
        if (ecactionresponse.isSetAdInstructions())
        {
            arraylist = new ArrayList();
            for (iterator = ecactionresponse.F.iterator(); iterator.hasNext(); arraylist.add((String)iterator.next()))
            {
                break MISSING_BLOCK_LABEL_461;
            }

            F = arraylist;
        }
        if (ecactionresponse.isSetAdControls())
        {
            arraylist = new ArrayList();
            for (ecactionresponse = ecactionresponse.G.iterator(); ecactionresponse.hasNext(); arraylist.add(new MMAdControl((MMAdControl)ecactionresponse.next())))
            {
                break MISSING_BLOCK_LABEL_480;
            }

            G = arraylist;
        }
        return;
_L4:
        arraylist.add((String)iterator.next());
        if (true) goto _L6; else goto _L5
_L5:
    }

    public ECActionResponse(List list, List list1, int i1, String s1, String s2, String s3, String s4, 
            String s5, String s6, String s7, boolean flag, boolean flag1, boolean flag2, List list2, 
            List list3, List list4)
    {
        this();
        r = list;
        s = list1;
        t = i1;
        H.minBroadcastInterval = true;
        u = s1;
        v = s2;
        w = s3;
        x = s4;
        y = s5;
        z = s6;
        A = s7;
        B = flag;
        H.shutdown = true;
        C = flag1;
        H.kill = true;
        D = flag2;
        H.dcEnabled = true;
        E = list2;
        F = list3;
        G = list4;
    }

    public void addToAdControls(MMAdControl mmadcontrol)
    {
        if (G == null)
        {
            G = new ArrayList();
        }
        G.add(mmadcontrol);
    }

    public void addToAdInstructions(String s1)
    {
        if (F == null)
        {
            F = new ArrayList();
        }
        F.add(s1);
    }

    public void addToReceivedAdEvents(String s1)
    {
        if (s == null)
        {
            s = new ArrayList();
        }
        s.add(s1);
    }

    public void addToReceivedEvents(String s1)
    {
        if (r == null)
        {
            r = new ArrayList();
        }
        r.add(s1);
    }

    public void addToReceivedRuns(String s1)
    {
        if (E == null)
        {
            E = new ArrayList();
        }
        E.add(s1);
    }

    public ECActionResponse clone()
    {
        return new ECActionResponse(this);
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public boolean equals(ECActionResponse ecactionresponse)
    {
        if (ecactionresponse != null)
        {
            boolean flag;
            boolean flag1;
            if (isSetReceivedEvents())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (ecactionresponse.isSetReceivedEvents())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!flag && !flag1 || flag && flag1 && r.equals(ecactionresponse.r))
            {
                if (isSetReceivedAdEvents())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (ecactionresponse.isSetReceivedAdEvents())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if ((!flag && !flag1 || flag && flag1 && s.equals(ecactionresponse.s)) && t == ecactionresponse.t)
                {
                    if (isSetBroadcastURL())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (ecactionresponse.isSetBroadcastURL())
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (!flag && !flag1 || flag && flag1 && u.equals(ecactionresponse.u))
                    {
                        if (isSetClientToken())
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        if (ecactionresponse.isSetClientToken())
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        if (!flag && !flag1 || flag && flag1 && v.equals(ecactionresponse.v))
                        {
                            if (isSetAppTok())
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                            if (ecactionresponse.isSetAppTok())
                            {
                                flag1 = true;
                            } else
                            {
                                flag1 = false;
                            }
                            if (!flag && !flag1 || flag && flag1 && w.equals(ecactionresponse.w))
                            {
                                if (isSetDevTok())
                                {
                                    flag = true;
                                } else
                                {
                                    flag = false;
                                }
                                if (ecactionresponse.isSetDevTok())
                                {
                                    flag1 = true;
                                } else
                                {
                                    flag1 = false;
                                }
                                if (!flag && !flag1 || flag && flag1 && x.equals(ecactionresponse.x))
                                {
                                    if (isSetDebugMessage())
                                    {
                                        flag = true;
                                    } else
                                    {
                                        flag = false;
                                    }
                                    if (ecactionresponse.isSetDebugMessage())
                                    {
                                        flag1 = true;
                                    } else
                                    {
                                        flag1 = false;
                                    }
                                    if (!flag && !flag1 || flag && flag1 && y.equals(ecactionresponse.y))
                                    {
                                        if (isSetUserMessage())
                                        {
                                            flag = true;
                                        } else
                                        {
                                            flag = false;
                                        }
                                        if (ecactionresponse.isSetUserMessage())
                                        {
                                            flag1 = true;
                                        } else
                                        {
                                            flag1 = false;
                                        }
                                        if (!flag && !flag1 || flag && flag1 && z.equals(ecactionresponse.z))
                                        {
                                            if (isSetUserMessageURL())
                                            {
                                                flag = true;
                                            } else
                                            {
                                                flag = false;
                                            }
                                            if (ecactionresponse.isSetUserMessageURL())
                                            {
                                                flag1 = true;
                                            } else
                                            {
                                                flag1 = false;
                                            }
                                            if (!flag && !flag1 || flag && flag1 && A.equals(ecactionresponse.A))
                                            {
                                                if (isSetShutdown())
                                                {
                                                    flag = true;
                                                } else
                                                {
                                                    flag = false;
                                                }
                                                if (ecactionresponse.isSetShutdown())
                                                {
                                                    flag1 = true;
                                                } else
                                                {
                                                    flag1 = false;
                                                }
                                                if (!flag && !flag1 || flag && flag1 && B == ecactionresponse.B)
                                                {
                                                    if (isSetKill())
                                                    {
                                                        flag = true;
                                                    } else
                                                    {
                                                        flag = false;
                                                    }
                                                    if (ecactionresponse.isSetKill())
                                                    {
                                                        flag1 = true;
                                                    } else
                                                    {
                                                        flag1 = false;
                                                    }
                                                    if (!flag && !flag1 || flag && flag1 && C == ecactionresponse.C)
                                                    {
                                                        if (isSetDcEnabled())
                                                        {
                                                            flag = true;
                                                        } else
                                                        {
                                                            flag = false;
                                                        }
                                                        if (ecactionresponse.isSetDcEnabled())
                                                        {
                                                            flag1 = true;
                                                        } else
                                                        {
                                                            flag1 = false;
                                                        }
                                                        if (!flag && !flag1 || flag && flag1 && D == ecactionresponse.D)
                                                        {
                                                            if (isSetReceivedRuns())
                                                            {
                                                                flag = true;
                                                            } else
                                                            {
                                                                flag = false;
                                                            }
                                                            if (ecactionresponse.isSetReceivedRuns())
                                                            {
                                                                flag1 = true;
                                                            } else
                                                            {
                                                                flag1 = false;
                                                            }
                                                            if (!flag && !flag1 || flag && flag1 && E.equals(ecactionresponse.E))
                                                            {
                                                                if (isSetAdInstructions())
                                                                {
                                                                    flag = true;
                                                                } else
                                                                {
                                                                    flag = false;
                                                                }
                                                                if (ecactionresponse.isSetAdInstructions())
                                                                {
                                                                    flag1 = true;
                                                                } else
                                                                {
                                                                    flag1 = false;
                                                                }
                                                                if (!flag && !flag1 || flag && flag1 && F.equals(ecactionresponse.F))
                                                                {
                                                                    if (isSetAdControls())
                                                                    {
                                                                        flag = true;
                                                                    } else
                                                                    {
                                                                        flag = false;
                                                                    }
                                                                    if (ecactionresponse.isSetAdControls())
                                                                    {
                                                                        flag1 = true;
                                                                    } else
                                                                    {
                                                                        flag1 = false;
                                                                    }
                                                                    if (!flag && !flag1 || flag && flag1 && G.equals(ecactionresponse.G))
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
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof ECActionResponse)) 
        {
            return false;
        }
        return equals((ECActionResponse)obj);
    }

    public List getAdControls()
    {
        return G;
    }

    public Iterator getAdControlsIterator()
    {
        if (G == null)
        {
            return null;
        } else
        {
            return G.iterator();
        }
    }

    public int getAdControlsSize()
    {
        if (G == null)
        {
            return 0;
        } else
        {
            return G.size();
        }
    }

    public List getAdInstructions()
    {
        return F;
    }

    public Iterator getAdInstructionsIterator()
    {
        if (F == null)
        {
            return null;
        } else
        {
            return F.iterator();
        }
    }

    public int getAdInstructionsSize()
    {
        if (F == null)
        {
            return 0;
        } else
        {
            return F.size();
        }
    }

    public String getAppTok()
    {
        return w;
    }

    public String getBroadcastURL()
    {
        return u;
    }

    public String getClientToken()
    {
        return v;
    }

    public String getDebugMessage()
    {
        return y;
    }

    public String getDevTok()
    {
        return x;
    }

    public Object getFieldValue(int i1)
    {
        switch (i1)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i1).append(" doesn't exist!").toString());

        case 1: // '\001'
            return getReceivedEvents();

        case 2: // '\002'
            return getReceivedAdEvents();

        case 3: // '\003'
            return new Integer(getMinBroadcastInterval());

        case 4: // '\004'
            return getBroadcastURL();

        case 5: // '\005'
            return getClientToken();

        case 6: // '\006'
            return getAppTok();

        case 7: // '\007'
            return getDevTok();

        case 8: // '\b'
            return getDebugMessage();

        case 9: // '\t'
            return getUserMessage();

        case 10: // '\n'
            return getUserMessageURL();

        case 11: // '\013'
            return new Boolean(isShutdown());

        case 12: // '\f'
            return new Boolean(isKill());

        case 13: // '\r'
            return new Boolean(isDcEnabled());

        case 14: // '\016'
            return getReceivedRuns();

        case 15: // '\017'
            return getAdInstructions();

        case 16: // '\020'
            return getAdControls();
        }
    }

    public int getMinBroadcastInterval()
    {
        return t;
    }

    public List getReceivedAdEvents()
    {
        return s;
    }

    public Iterator getReceivedAdEventsIterator()
    {
        if (s == null)
        {
            return null;
        } else
        {
            return s.iterator();
        }
    }

    public int getReceivedAdEventsSize()
    {
        if (s == null)
        {
            return 0;
        } else
        {
            return s.size();
        }
    }

    public List getReceivedEvents()
    {
        return r;
    }

    public Iterator getReceivedEventsIterator()
    {
        if (r == null)
        {
            return null;
        } else
        {
            return r.iterator();
        }
    }

    public int getReceivedEventsSize()
    {
        if (r == null)
        {
            return 0;
        } else
        {
            return r.size();
        }
    }

    public List getReceivedRuns()
    {
        return E;
    }

    public Iterator getReceivedRunsIterator()
    {
        if (E == null)
        {
            return null;
        } else
        {
            return E.iterator();
        }
    }

    public int getReceivedRunsSize()
    {
        if (E == null)
        {
            return 0;
        } else
        {
            return E.size();
        }
    }

    public String getUserMessage()
    {
        return z;
    }

    public String getUserMessageURL()
    {
        return A;
    }

    public int hashCode()
    {
        return 0;
    }

    public boolean isDcEnabled()
    {
        return D;
    }

    public boolean isKill()
    {
        return C;
    }

    public boolean isSet(int i1)
    {
        switch (i1)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i1).append(" doesn't exist!").toString());

        case 1: // '\001'
            return isSetReceivedEvents();

        case 2: // '\002'
            return isSetReceivedAdEvents();

        case 3: // '\003'
            return isSetMinBroadcastInterval();

        case 4: // '\004'
            return isSetBroadcastURL();

        case 5: // '\005'
            return isSetClientToken();

        case 6: // '\006'
            return isSetAppTok();

        case 7: // '\007'
            return isSetDevTok();

        case 8: // '\b'
            return isSetDebugMessage();

        case 9: // '\t'
            return isSetUserMessage();

        case 10: // '\n'
            return isSetUserMessageURL();

        case 11: // '\013'
            return isSetShutdown();

        case 12: // '\f'
            return isSetKill();

        case 13: // '\r'
            return isSetDcEnabled();

        case 14: // '\016'
            return isSetReceivedRuns();

        case 15: // '\017'
            return isSetAdInstructions();

        case 16: // '\020'
            return isSetAdControls();
        }
    }

    public boolean isSetAdControls()
    {
        return G != null;
    }

    public boolean isSetAdInstructions()
    {
        return F != null;
    }

    public boolean isSetAppTok()
    {
        return w != null;
    }

    public boolean isSetBroadcastURL()
    {
        return u != null;
    }

    public boolean isSetClientToken()
    {
        return v != null;
    }

    public boolean isSetDcEnabled()
    {
        return H.dcEnabled;
    }

    public boolean isSetDebugMessage()
    {
        return y != null;
    }

    public boolean isSetDevTok()
    {
        return x != null;
    }

    public boolean isSetKill()
    {
        return H.kill;
    }

    public boolean isSetMinBroadcastInterval()
    {
        return H.minBroadcastInterval;
    }

    public boolean isSetReceivedAdEvents()
    {
        return s != null;
    }

    public boolean isSetReceivedEvents()
    {
        return r != null;
    }

    public boolean isSetReceivedRuns()
    {
        return E != null;
    }

    public boolean isSetShutdown()
    {
        return H.shutdown;
    }

    public boolean isSetUserMessage()
    {
        return z != null;
    }

    public boolean isSetUserMessageURL()
    {
        return A != null;
    }

    public boolean isShutdown()
    {
        return B;
    }

    public void read(TProtocol tprotocol)
        throws TException
    {
        tprotocol.readStructBegin();
_L19:
        Object obj;
        obj = tprotocol.readFieldBegin();
        if (((TField) (obj)).type == 0)
        {
            break MISSING_BLOCK_LABEL_913;
        }
        ((TField) (obj)).id;
        JVM INSTR tableswitch 1 16: default 100
    //                   1 115
    //                   2 199
    //                   3 283
    //                   4 322
    //                   5 353
    //                   6 384
    //                   7 415
    //                   8 446
    //                   9 477
    //                   10 508
    //                   11 539
    //                   12 577
    //                   13 615
    //                   14 653
    //                   15 737
    //                   16 821;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L20:
        tprotocol.readFieldEnd();
        if (true) goto _L19; else goto _L18
_L18:
        int i1;
        if (((TField) (obj)).type != 15)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        obj = tprotocol.readListBegin();
        r = new ArrayList(((TList) (obj)).size);
        i1 = 0;
_L21:
label0:
        {
            if (i1 < ((TList) (obj)).size)
            {
                break label0;
            }
            tprotocol.readListEnd();
        }
          goto _L20
        String s1 = tprotocol.readString();
        r.add(s1);
        i1++;
          goto _L21
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
          goto _L20
_L3:
        if (((TField) (obj)).type != 15)
        {
            break MISSING_BLOCK_LABEL_272;
        }
        obj = tprotocol.readListBegin();
        s = new ArrayList(((TList) (obj)).size);
        i1 = 0;
_L22:
label1:
        {
            if (i1 < ((TList) (obj)).size)
            {
                break label1;
            }
            tprotocol.readListEnd();
        }
          goto _L20
        String s2 = tprotocol.readString();
        s.add(s2);
        i1++;
          goto _L22
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
          goto _L20
_L4:
        if (((TField) (obj)).type == 8)
        {
            t = tprotocol.readI32();
            H.minBroadcastInterval = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L20
_L5:
        if (((TField) (obj)).type == 11)
        {
            u = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L20
_L6:
        if (((TField) (obj)).type == 11)
        {
            v = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L20
_L7:
        if (((TField) (obj)).type == 11)
        {
            w = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L20
_L8:
        if (((TField) (obj)).type == 11)
        {
            x = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L20
_L9:
        if (((TField) (obj)).type == 11)
        {
            y = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L20
_L10:
        if (((TField) (obj)).type == 11)
        {
            z = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L20
_L11:
        if (((TField) (obj)).type == 11)
        {
            A = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L20
_L12:
        if (((TField) (obj)).type == 2)
        {
            B = tprotocol.readBool();
            H.shutdown = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L20
_L13:
        if (((TField) (obj)).type == 2)
        {
            C = tprotocol.readBool();
            H.kill = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L20
_L14:
        if (((TField) (obj)).type == 2)
        {
            D = tprotocol.readBool();
            H.dcEnabled = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L20
_L15:
        if (((TField) (obj)).type != 15)
        {
            break MISSING_BLOCK_LABEL_726;
        }
        obj = tprotocol.readListBegin();
        E = new ArrayList(((TList) (obj)).size);
        i1 = 0;
_L23:
label2:
        {
            if (i1 < ((TList) (obj)).size)
            {
                break label2;
            }
            tprotocol.readListEnd();
        }
          goto _L20
        String s3 = tprotocol.readString();
        E.add(s3);
        i1++;
          goto _L23
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
          goto _L20
_L16:
        if (((TField) (obj)).type != 15)
        {
            break MISSING_BLOCK_LABEL_810;
        }
        obj = tprotocol.readListBegin();
        F = new ArrayList(((TList) (obj)).size);
        i1 = 0;
_L24:
label3:
        {
            if (i1 < ((TList) (obj)).size)
            {
                break label3;
            }
            tprotocol.readListEnd();
        }
          goto _L20
        String s4 = tprotocol.readString();
        F.add(s4);
        i1++;
          goto _L24
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
          goto _L20
_L17:
        if (((TField) (obj)).type != 15)
        {
            break MISSING_BLOCK_LABEL_902;
        }
        obj = tprotocol.readListBegin();
        G = new ArrayList(((TList) (obj)).size);
        i1 = 0;
_L25:
label4:
        {
            if (i1 < ((TList) (obj)).size)
            {
                break label4;
            }
            tprotocol.readListEnd();
        }
          goto _L20
        MMAdControl mmadcontrol = new MMAdControl();
        mmadcontrol.read(tprotocol);
        G.add(mmadcontrol);
        i1++;
          goto _L25
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
          goto _L20
        tprotocol.readStructEnd();
        validate();
        return;
    }

    public void setAdControls(List list)
    {
        G = list;
    }

    public void setAdInstructions(List list)
    {
        F = list;
    }

    public void setAppTok(String s1)
    {
        w = s1;
    }

    public void setBroadcastURL(String s1)
    {
        u = s1;
    }

    public void setClientToken(String s1)
    {
        v = s1;
    }

    public void setDcEnabled(boolean flag)
    {
        D = flag;
        H.dcEnabled = true;
    }

    public void setDebugMessage(String s1)
    {
        y = s1;
    }

    public void setDevTok(String s1)
    {
        x = s1;
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
                unsetReceivedEvents();
                return;
            } else
            {
                setReceivedEvents((List)obj);
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetReceivedAdEvents();
                return;
            } else
            {
                setReceivedAdEvents((List)obj);
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetMinBroadcastInterval();
                return;
            } else
            {
                setMinBroadcastInterval(((Integer)obj).intValue());
                return;
            }

        case 4: // '\004'
            if (obj == null)
            {
                unsetBroadcastURL();
                return;
            } else
            {
                setBroadcastURL((String)obj);
                return;
            }

        case 5: // '\005'
            if (obj == null)
            {
                unsetClientToken();
                return;
            } else
            {
                setClientToken((String)obj);
                return;
            }

        case 6: // '\006'
            if (obj == null)
            {
                unsetAppTok();
                return;
            } else
            {
                setAppTok((String)obj);
                return;
            }

        case 7: // '\007'
            if (obj == null)
            {
                unsetDevTok();
                return;
            } else
            {
                setDevTok((String)obj);
                return;
            }

        case 8: // '\b'
            if (obj == null)
            {
                unsetDebugMessage();
                return;
            } else
            {
                setDebugMessage((String)obj);
                return;
            }

        case 9: // '\t'
            if (obj == null)
            {
                unsetUserMessage();
                return;
            } else
            {
                setUserMessage((String)obj);
                return;
            }

        case 10: // '\n'
            if (obj == null)
            {
                unsetUserMessageURL();
                return;
            } else
            {
                setUserMessageURL((String)obj);
                return;
            }

        case 11: // '\013'
            if (obj == null)
            {
                unsetShutdown();
                return;
            } else
            {
                setShutdown(((Boolean)obj).booleanValue());
                return;
            }

        case 12: // '\f'
            if (obj == null)
            {
                unsetKill();
                return;
            } else
            {
                setKill(((Boolean)obj).booleanValue());
                return;
            }

        case 13: // '\r'
            if (obj == null)
            {
                unsetDcEnabled();
                return;
            } else
            {
                setDcEnabled(((Boolean)obj).booleanValue());
                return;
            }

        case 14: // '\016'
            if (obj == null)
            {
                unsetReceivedRuns();
                return;
            } else
            {
                setReceivedRuns((List)obj);
                return;
            }

        case 15: // '\017'
            if (obj == null)
            {
                unsetAdInstructions();
                return;
            } else
            {
                setAdInstructions((List)obj);
                return;
            }

        case 16: // '\020'
            break;
        }
        if (obj == null)
        {
            unsetAdControls();
            return;
        } else
        {
            setAdControls((List)obj);
            return;
        }
    }

    public void setKill(boolean flag)
    {
        C = flag;
        H.kill = true;
    }

    public void setMinBroadcastInterval(int i1)
    {
        t = i1;
        H.minBroadcastInterval = true;
    }

    public void setReceivedAdEvents(List list)
    {
        s = list;
    }

    public void setReceivedEvents(List list)
    {
        r = list;
    }

    public void setReceivedRuns(List list)
    {
        E = list;
    }

    public void setShutdown(boolean flag)
    {
        B = flag;
        H.shutdown = true;
    }

    public void setUserMessage(String s1)
    {
        z = s1;
    }

    public void setUserMessageURL(String s1)
    {
        A = s1;
    }

    public String toString()
    {
        boolean flag1 = false;
        StringBuilder stringbuilder = new StringBuilder("ECActionResponse(");
        boolean flag = true;
        if (isSetReceivedEvents())
        {
            stringbuilder.append("receivedEvents:");
            if (r == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(r);
            }
            flag = false;
        }
        if (isSetReceivedAdEvents())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("receivedAdEvents:");
            if (s == null)
            {
                stringbuilder.append("null");
                flag = flag1;
            } else
            {
                stringbuilder.append(s);
                flag = flag1;
            }
        }
        if (!flag)
        {
            stringbuilder.append(", ");
        }
        stringbuilder.append("minBroadcastInterval:");
        stringbuilder.append(t);
        stringbuilder.append(", ");
        stringbuilder.append("broadcastURL:");
        if (u == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(u);
        }
        stringbuilder.append(", ");
        stringbuilder.append("clientToken:");
        if (v == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(v);
        }
        if (isSetAppTok())
        {
            stringbuilder.append(", ");
            stringbuilder.append("appTok:");
            if (w == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(w);
            }
        }
        if (isSetDevTok())
        {
            stringbuilder.append(", ");
            stringbuilder.append("devTok:");
            if (x == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(x);
            }
        }
        if (isSetDebugMessage())
        {
            stringbuilder.append(", ");
            stringbuilder.append("debugMessage:");
            if (y == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(y);
            }
        }
        if (isSetUserMessage())
        {
            stringbuilder.append(", ");
            stringbuilder.append("userMessage:");
            if (z == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(z);
            }
        }
        if (isSetUserMessageURL())
        {
            stringbuilder.append(", ");
            stringbuilder.append("userMessageURL:");
            if (A == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(A);
            }
        }
        if (isSetShutdown())
        {
            stringbuilder.append(", ");
            stringbuilder.append("shutdown:");
            stringbuilder.append(B);
        }
        if (isSetKill())
        {
            stringbuilder.append(", ");
            stringbuilder.append("kill:");
            stringbuilder.append(C);
        }
        if (isSetDcEnabled())
        {
            stringbuilder.append(", ");
            stringbuilder.append("dcEnabled:");
            stringbuilder.append(D);
        }
        if (isSetReceivedRuns())
        {
            stringbuilder.append(", ");
            stringbuilder.append("receivedRuns:");
            if (E == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(E);
            }
        }
        if (isSetAdInstructions())
        {
            stringbuilder.append(", ");
            stringbuilder.append("adInstructions:");
            if (F == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(F);
            }
        }
        if (isSetAdControls())
        {
            stringbuilder.append(", ");
            stringbuilder.append("adControls:");
            if (G == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(G);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetAdControls()
    {
        G = null;
    }

    public void unsetAdInstructions()
    {
        F = null;
    }

    public void unsetAppTok()
    {
        w = null;
    }

    public void unsetBroadcastURL()
    {
        u = null;
    }

    public void unsetClientToken()
    {
        v = null;
    }

    public void unsetDcEnabled()
    {
        H.dcEnabled = false;
    }

    public void unsetDebugMessage()
    {
        y = null;
    }

    public void unsetDevTok()
    {
        x = null;
    }

    public void unsetKill()
    {
        H.kill = false;
    }

    public void unsetMinBroadcastInterval()
    {
        H.minBroadcastInterval = false;
    }

    public void unsetReceivedAdEvents()
    {
        s = null;
    }

    public void unsetReceivedEvents()
    {
        r = null;
    }

    public void unsetReceivedRuns()
    {
        E = null;
    }

    public void unsetShutdown()
    {
        H.shutdown = false;
    }

    public void unsetUserMessage()
    {
        z = null;
    }

    public void unsetUserMessageURL()
    {
        A = null;
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
        if (r == null || !isSetReceivedEvents()) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        tprotocol.writeFieldBegin(b);
        tprotocol.writeListBegin(new TList((byte)11, r.size()));
        iterator = r.iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        tprotocol.writeListEnd();
        tprotocol.writeFieldEnd();
_L2:
        if (s != null && isSetReceivedAdEvents())
        {
            tprotocol.writeFieldBegin(c);
            tprotocol.writeListBegin(new TList((byte)11, s.size()));
            for (iterator = s.iterator(); iterator.hasNext(); tprotocol.writeString((String)iterator.next()))
            {
                break MISSING_BLOCK_LABEL_700;
            }

            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldBegin(d);
        tprotocol.writeI32(t);
        tprotocol.writeFieldEnd();
        if (u != null)
        {
            tprotocol.writeFieldBegin(e);
            tprotocol.writeString(u);
            tprotocol.writeFieldEnd();
        }
        if (v != null)
        {
            tprotocol.writeFieldBegin(f);
            tprotocol.writeString(v);
            tprotocol.writeFieldEnd();
        }
        if (w != null && isSetAppTok())
        {
            tprotocol.writeFieldBegin(g);
            tprotocol.writeString(w);
            tprotocol.writeFieldEnd();
        }
        if (x != null && isSetDevTok())
        {
            tprotocol.writeFieldBegin(h);
            tprotocol.writeString(x);
            tprotocol.writeFieldEnd();
        }
        if (y != null && isSetDebugMessage())
        {
            tprotocol.writeFieldBegin(i);
            tprotocol.writeString(y);
            tprotocol.writeFieldEnd();
        }
        if (z != null && isSetUserMessage())
        {
            tprotocol.writeFieldBegin(j);
            tprotocol.writeString(z);
            tprotocol.writeFieldEnd();
        }
        if (A != null && isSetUserMessageURL())
        {
            tprotocol.writeFieldBegin(k);
            tprotocol.writeString(A);
            tprotocol.writeFieldEnd();
        }
        if (isSetShutdown())
        {
            tprotocol.writeFieldBegin(l);
            tprotocol.writeBool(B);
            tprotocol.writeFieldEnd();
        }
        if (isSetKill())
        {
            tprotocol.writeFieldBegin(m);
            tprotocol.writeBool(C);
            tprotocol.writeFieldEnd();
        }
        if (isSetDcEnabled())
        {
            tprotocol.writeFieldBegin(n);
            tprotocol.writeBool(D);
            tprotocol.writeFieldEnd();
        }
        if (E != null && isSetReceivedRuns())
        {
            tprotocol.writeFieldBegin(o);
            tprotocol.writeListBegin(new TList((byte)11, E.size()));
            for (iterator = E.iterator(); iterator.hasNext(); tprotocol.writeString((String)iterator.next()))
            {
                break MISSING_BLOCK_LABEL_716;
            }

            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        if (F != null && isSetAdInstructions())
        {
            tprotocol.writeFieldBegin(p);
            tprotocol.writeListBegin(new TList((byte)11, F.size()));
            for (iterator = F.iterator(); iterator.hasNext(); tprotocol.writeString((String)iterator.next()))
            {
                break MISSING_BLOCK_LABEL_732;
            }

            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        if (G != null && isSetAdControls())
        {
            tprotocol.writeFieldBegin(q);
            tprotocol.writeListBegin(new TList((byte)12, G.size()));
            for (iterator = G.iterator(); iterator.hasNext(); ((MMAdControl)iterator.next()).write(tprotocol))
            {
                break MISSING_BLOCK_LABEL_748;
            }

            tprotocol.writeListEnd();
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
        return;
_L4:
        tprotocol.writeString((String)iterator.next());
        if (true) goto _L6; else goto _L5
_L5:
    }

    static 
    {
        metaDataMap = Collections.unmodifiableMap(new b());
        FieldMetaData.addStructMetaDataMap(com/medialets/thrift/ECActionResponse, metaDataMap);
    }

    // Unreferenced inner class com/medialets/thrift/b
    final class b extends HashMap
    {

            b()
            {
                put(Integer.valueOf(1), new FieldMetaData("receivedEvents", (byte)2, new ListMetaData((byte)15, new FieldValueMetaData((byte)11))));
                put(Integer.valueOf(2), new FieldMetaData("receivedAdEvents", (byte)2, new ListMetaData((byte)15, new FieldValueMetaData((byte)11))));
                put(Integer.valueOf(3), new FieldMetaData("minBroadcastInterval", (byte)3, new FieldValueMetaData((byte)8)));
                put(Integer.valueOf(4), new FieldMetaData("broadcastURL", (byte)3, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(5), new FieldMetaData("clientToken", (byte)3, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(6), new FieldMetaData("appTok", (byte)2, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(7), new FieldMetaData("devTok", (byte)2, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(8), new FieldMetaData("debugMessage", (byte)2, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(9), new FieldMetaData("userMessage", (byte)2, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(10), new FieldMetaData("userMessageURL", (byte)2, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(11), new FieldMetaData("shutdown", (byte)2, new FieldValueMetaData((byte)2)));
                put(Integer.valueOf(12), new FieldMetaData("kill", (byte)2, new FieldValueMetaData((byte)2)));
                put(Integer.valueOf(13), new FieldMetaData("dcEnabled", (byte)2, new FieldValueMetaData((byte)2)));
                put(Integer.valueOf(14), new FieldMetaData("receivedRuns", (byte)2, new ListMetaData((byte)15, new FieldValueMetaData((byte)11))));
                put(Integer.valueOf(15), new FieldMetaData("adInstructions", (byte)2, new ListMetaData((byte)15, new FieldValueMetaData((byte)11))));
                put(Integer.valueOf(16), new FieldMetaData("adControls", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/medialets/thrift/MMAdControl))));
            }
    }

}
