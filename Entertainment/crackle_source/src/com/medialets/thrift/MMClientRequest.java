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
import org.apache.thrift.meta_data.StructMetaData;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.protocol.TStruct;

// Referenced classes of package com.medialets.thrift:
//            o, BroadcastData

public class MMClientRequest
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


    public static final int APP = 9;
    public static final int APPV = 8;
    public static final int B = 3;
    public static final int BROADCASTDATA = 11;
    public static final int DEV = 4;
    public static final int DEVICEID = 2;
    public static final int IPADDRESS = 12;
    public static final int MODEL = 7;
    public static final int REQUESTTIME = 13;
    public static final int SYS = 10;
    public static final int SYSV = 6;
    public static final int TOK = 1;
    public static final int V = 5;
    private static final TStruct a = new TStruct("MMClientRequest");
    private static final TField b = new TField("tok", (byte)11, (short)1);
    private static final TField c = new TField("deviceID", (byte)11, (short)2);
    private static final TField d = new TField("b", (byte)11, (short)3);
    private static final TField e = new TField("dev", (byte)11, (short)4);
    private static final TField f = new TField("v", (byte)11, (short)5);
    private static final TField g = new TField("sysv", (byte)11, (short)6);
    private static final TField h = new TField("model", (byte)11, (short)7);
    private static final TField i = new TField("appv", (byte)11, (short)8);
    private static final TField j = new TField("app", (byte)11, (short)9);
    private static final TField k = new TField("sys", (byte)11, (short)10);
    private static final TField l = new TField("broadcastData", (byte)12, (short)11);
    private static final TField m = new TField("ipAddress", (byte)11, (short)12);
    public static final Map metaDataMap;
    private static final TField n = new TField("requestTime", (byte)11, (short)13);
    private String A;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private BroadcastData y;
    private String z;

    public MMClientRequest()
    {
        new a();
    }

    public MMClientRequest(MMClientRequest mmclientrequest)
    {
        new a();
        if (mmclientrequest.isSetTok())
        {
            o = mmclientrequest.o;
        }
        if (mmclientrequest.isSetDeviceID())
        {
            p = mmclientrequest.p;
        }
        if (mmclientrequest.isSetB())
        {
            q = mmclientrequest.q;
        }
        if (mmclientrequest.isSetDev())
        {
            r = mmclientrequest.r;
        }
        if (mmclientrequest.isSetV())
        {
            s = mmclientrequest.s;
        }
        if (mmclientrequest.isSetSysv())
        {
            t = mmclientrequest.t;
        }
        if (mmclientrequest.isSetModel())
        {
            u = mmclientrequest.u;
        }
        if (mmclientrequest.isSetAppv())
        {
            v = mmclientrequest.v;
        }
        if (mmclientrequest.isSetApp())
        {
            w = mmclientrequest.w;
        }
        if (mmclientrequest.isSetSys())
        {
            x = mmclientrequest.x;
        }
        if (mmclientrequest.isSetBroadcastData())
        {
            y = new BroadcastData(mmclientrequest.y);
        }
        if (mmclientrequest.isSetIpAddress())
        {
            z = mmclientrequest.z;
        }
        if (mmclientrequest.isSetRequestTime())
        {
            A = mmclientrequest.A;
        }
    }

    public MMClientRequest(String s1, String s2, String s3, String s4, String s5, String s6, String s7, 
            String s8, String s9, String s10, BroadcastData broadcastdata, String s11, String s12)
    {
        this();
        o = s1;
        p = s2;
        q = s3;
        r = s4;
        s = s5;
        t = s6;
        u = s7;
        v = s8;
        w = s9;
        x = s10;
        y = broadcastdata;
        z = s11;
        A = s12;
    }

    public MMClientRequest clone()
    {
        return new MMClientRequest(this);
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public boolean equals(MMClientRequest mmclientrequest)
    {
        if (mmclientrequest != null)
        {
            boolean flag;
            boolean flag1;
            if (isSetTok())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (mmclientrequest.isSetTok())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!flag && !flag1 || flag && flag1 && o.equals(mmclientrequest.o))
            {
                if (isSetDeviceID())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (mmclientrequest.isSetDeviceID())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (!flag && !flag1 || flag && flag1 && p.equals(mmclientrequest.p))
                {
                    if (isSetB())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (mmclientrequest.isSetB())
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (!flag && !flag1 || flag && flag1 && q.equals(mmclientrequest.q))
                    {
                        if (isSetDev())
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        if (mmclientrequest.isSetDev())
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        if (!flag && !flag1 || flag && flag1 && r.equals(mmclientrequest.r))
                        {
                            if (isSetV())
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                            if (mmclientrequest.isSetV())
                            {
                                flag1 = true;
                            } else
                            {
                                flag1 = false;
                            }
                            if (!flag && !flag1 || flag && flag1 && s.equals(mmclientrequest.s))
                            {
                                if (isSetSysv())
                                {
                                    flag = true;
                                } else
                                {
                                    flag = false;
                                }
                                if (mmclientrequest.isSetSysv())
                                {
                                    flag1 = true;
                                } else
                                {
                                    flag1 = false;
                                }
                                if (!flag && !flag1 || flag && flag1 && t.equals(mmclientrequest.t))
                                {
                                    if (isSetModel())
                                    {
                                        flag = true;
                                    } else
                                    {
                                        flag = false;
                                    }
                                    if (mmclientrequest.isSetModel())
                                    {
                                        flag1 = true;
                                    } else
                                    {
                                        flag1 = false;
                                    }
                                    if (!flag && !flag1 || flag && flag1 && u.equals(mmclientrequest.u))
                                    {
                                        if (isSetAppv())
                                        {
                                            flag = true;
                                        } else
                                        {
                                            flag = false;
                                        }
                                        if (mmclientrequest.isSetAppv())
                                        {
                                            flag1 = true;
                                        } else
                                        {
                                            flag1 = false;
                                        }
                                        if (!flag && !flag1 || flag && flag1 && v.equals(mmclientrequest.v))
                                        {
                                            if (isSetApp())
                                            {
                                                flag = true;
                                            } else
                                            {
                                                flag = false;
                                            }
                                            if (mmclientrequest.isSetApp())
                                            {
                                                flag1 = true;
                                            } else
                                            {
                                                flag1 = false;
                                            }
                                            if (!flag && !flag1 || flag && flag1 && w.equals(mmclientrequest.w))
                                            {
                                                if (isSetSys())
                                                {
                                                    flag = true;
                                                } else
                                                {
                                                    flag = false;
                                                }
                                                if (mmclientrequest.isSetSys())
                                                {
                                                    flag1 = true;
                                                } else
                                                {
                                                    flag1 = false;
                                                }
                                                if (!flag && !flag1 || flag && flag1 && x.equals(mmclientrequest.x))
                                                {
                                                    if (isSetBroadcastData())
                                                    {
                                                        flag = true;
                                                    } else
                                                    {
                                                        flag = false;
                                                    }
                                                    if (mmclientrequest.isSetBroadcastData())
                                                    {
                                                        flag1 = true;
                                                    } else
                                                    {
                                                        flag1 = false;
                                                    }
                                                    if (!flag && !flag1 || flag && flag1 && y.equals(mmclientrequest.y))
                                                    {
                                                        if (isSetIpAddress())
                                                        {
                                                            flag = true;
                                                        } else
                                                        {
                                                            flag = false;
                                                        }
                                                        if (mmclientrequest.isSetIpAddress())
                                                        {
                                                            flag1 = true;
                                                        } else
                                                        {
                                                            flag1 = false;
                                                        }
                                                        if (!flag && !flag1 || flag && flag1 && z.equals(mmclientrequest.z))
                                                        {
                                                            if (isSetRequestTime())
                                                            {
                                                                flag = true;
                                                            } else
                                                            {
                                                                flag = false;
                                                            }
                                                            if (mmclientrequest.isSetRequestTime())
                                                            {
                                                                flag1 = true;
                                                            } else
                                                            {
                                                                flag1 = false;
                                                            }
                                                            if (!flag && !flag1 || flag && flag1 && A.equals(mmclientrequest.A))
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
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof MMClientRequest)) 
        {
            return false;
        }
        return equals((MMClientRequest)obj);
    }

    public String getApp()
    {
        return w;
    }

    public String getAppv()
    {
        return v;
    }

    public String getB()
    {
        return q;
    }

    public BroadcastData getBroadcastData()
    {
        return y;
    }

    public String getDev()
    {
        return r;
    }

    public String getDeviceID()
    {
        return p;
    }

    public Object getFieldValue(int i1)
    {
        switch (i1)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i1).append(" doesn't exist!").toString());

        case 1: // '\001'
            return getTok();

        case 2: // '\002'
            return getDeviceID();

        case 3: // '\003'
            return getB();

        case 4: // '\004'
            return getDev();

        case 5: // '\005'
            return getV();

        case 6: // '\006'
            return getSysv();

        case 7: // '\007'
            return getModel();

        case 8: // '\b'
            return getAppv();

        case 9: // '\t'
            return getApp();

        case 10: // '\n'
            return getSys();

        case 11: // '\013'
            return getBroadcastData();

        case 12: // '\f'
            return getIpAddress();

        case 13: // '\r'
            return getRequestTime();
        }
    }

    public String getIpAddress()
    {
        return z;
    }

    public String getModel()
    {
        return u;
    }

    public String getRequestTime()
    {
        return A;
    }

    public String getSys()
    {
        return x;
    }

    public String getSysv()
    {
        return t;
    }

    public String getTok()
    {
        return o;
    }

    public String getV()
    {
        return s;
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
            return isSetTok();

        case 2: // '\002'
            return isSetDeviceID();

        case 3: // '\003'
            return isSetB();

        case 4: // '\004'
            return isSetDev();

        case 5: // '\005'
            return isSetV();

        case 6: // '\006'
            return isSetSysv();

        case 7: // '\007'
            return isSetModel();

        case 8: // '\b'
            return isSetAppv();

        case 9: // '\t'
            return isSetApp();

        case 10: // '\n'
            return isSetSys();

        case 11: // '\013'
            return isSetBroadcastData();

        case 12: // '\f'
            return isSetIpAddress();

        case 13: // '\r'
            return isSetRequestTime();
        }
    }

    public boolean isSetApp()
    {
        return w != null;
    }

    public boolean isSetAppv()
    {
        return v != null;
    }

    public boolean isSetB()
    {
        return q != null;
    }

    public boolean isSetBroadcastData()
    {
        return y != null;
    }

    public boolean isSetDev()
    {
        return r != null;
    }

    public boolean isSetDeviceID()
    {
        return p != null;
    }

    public boolean isSetIpAddress()
    {
        return z != null;
    }

    public boolean isSetModel()
    {
        return u != null;
    }

    public boolean isSetRequestTime()
    {
        return A != null;
    }

    public boolean isSetSys()
    {
        return x != null;
    }

    public boolean isSetSysv()
    {
        return t != null;
    }

    public boolean isSetTok()
    {
        return o != null;
    }

    public boolean isSetV()
    {
        return s != null;
    }

    public void read(TProtocol tprotocol)
        throws TException
    {
        tprotocol.readStructBegin();
_L16:
        TField tfield;
        tfield = tprotocol.readFieldBegin();
        if (tfield.type == 0)
        {
            break MISSING_BLOCK_LABEL_517;
        }
        tfield.id;
        JVM INSTR tableswitch 1 13: default 88
    //                   1 103
    //                   2 134
    //                   3 165
    //                   4 196
    //                   5 227
    //                   6 258
    //                   7 289
    //                   8 320
    //                   9 351
    //                   10 382
    //                   11 413
    //                   12 455
    //                   13 486;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L14:
        break MISSING_BLOCK_LABEL_486;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        TProtocolUtil.skip(tprotocol, tfield.type);
_L17:
        tprotocol.readFieldEnd();
        if (true) goto _L16; else goto _L15
_L15:
        if (tfield.type == 11)
        {
            o = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L17
_L3:
        if (tfield.type == 11)
        {
            p = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L17
_L4:
        if (tfield.type == 11)
        {
            q = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L17
_L5:
        if (tfield.type == 11)
        {
            r = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L17
_L6:
        if (tfield.type == 11)
        {
            s = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L17
_L7:
        if (tfield.type == 11)
        {
            t = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L17
_L8:
        if (tfield.type == 11)
        {
            u = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L17
_L9:
        if (tfield.type == 11)
        {
            v = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L17
_L10:
        if (tfield.type == 11)
        {
            w = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L17
_L11:
        if (tfield.type == 11)
        {
            x = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L17
_L12:
        if (tfield.type == 12)
        {
            y = new BroadcastData();
            y.read(tprotocol);
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L17
_L13:
        if (tfield.type == 11)
        {
            z = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L17
        if (tfield.type == 11)
        {
            A = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, tfield.type);
        }
          goto _L17
        tprotocol.readStructEnd();
        validate();
        return;
    }

    public void setApp(String s1)
    {
        w = s1;
    }

    public void setAppv(String s1)
    {
        v = s1;
    }

    public void setB(String s1)
    {
        q = s1;
    }

    public void setBroadcastData(BroadcastData broadcastdata)
    {
        y = broadcastdata;
    }

    public void setDev(String s1)
    {
        r = s1;
    }

    public void setDeviceID(String s1)
    {
        p = s1;
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
                unsetTok();
                return;
            } else
            {
                setTok((String)obj);
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
                unsetB();
                return;
            } else
            {
                setB((String)obj);
                return;
            }

        case 4: // '\004'
            if (obj == null)
            {
                unsetDev();
                return;
            } else
            {
                setDev((String)obj);
                return;
            }

        case 5: // '\005'
            if (obj == null)
            {
                unsetV();
                return;
            } else
            {
                setV((String)obj);
                return;
            }

        case 6: // '\006'
            if (obj == null)
            {
                unsetSysv();
                return;
            } else
            {
                setSysv((String)obj);
                return;
            }

        case 7: // '\007'
            if (obj == null)
            {
                unsetModel();
                return;
            } else
            {
                setModel((String)obj);
                return;
            }

        case 8: // '\b'
            if (obj == null)
            {
                unsetAppv();
                return;
            } else
            {
                setAppv((String)obj);
                return;
            }

        case 9: // '\t'
            if (obj == null)
            {
                unsetApp();
                return;
            } else
            {
                setApp((String)obj);
                return;
            }

        case 10: // '\n'
            if (obj == null)
            {
                unsetSys();
                return;
            } else
            {
                setSys((String)obj);
                return;
            }

        case 11: // '\013'
            if (obj == null)
            {
                unsetBroadcastData();
                return;
            } else
            {
                setBroadcastData((BroadcastData)obj);
                return;
            }

        case 12: // '\f'
            if (obj == null)
            {
                unsetIpAddress();
                return;
            } else
            {
                setIpAddress((String)obj);
                return;
            }

        case 13: // '\r'
            break;
        }
        if (obj == null)
        {
            unsetRequestTime();
            return;
        } else
        {
            setRequestTime((String)obj);
            return;
        }
    }

    public void setIpAddress(String s1)
    {
        z = s1;
    }

    public void setModel(String s1)
    {
        u = s1;
    }

    public void setRequestTime(String s1)
    {
        A = s1;
    }

    public void setSys(String s1)
    {
        x = s1;
    }

    public void setSysv(String s1)
    {
        t = s1;
    }

    public void setTok(String s1)
    {
        o = s1;
    }

    public void setV(String s1)
    {
        s = s1;
    }

    public String toString()
    {
        boolean flag2 = false;
        StringBuilder stringbuilder = new StringBuilder("MMClientRequest(");
        boolean flag1 = true;
        boolean flag;
        if (isSetTok())
        {
            stringbuilder.append("tok:");
            if (o == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(o);
            }
            flag1 = false;
        }
        flag = flag1;
        if (isSetDeviceID())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("deviceID:");
            if (p == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(p);
            }
            flag = false;
        }
        flag1 = flag;
        if (isSetB())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("b:");
            if (q == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(q);
            }
            flag1 = false;
        }
        flag = flag1;
        if (isSetDev())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("dev:");
            if (r == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(r);
            }
            flag = false;
        }
        flag1 = flag;
        if (isSetV())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("v:");
            if (s == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(s);
            }
            flag1 = false;
        }
        flag = flag1;
        if (isSetSysv())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("sysv:");
            if (t == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(t);
            }
            flag = false;
        }
        flag1 = flag;
        if (isSetModel())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("model:");
            if (u == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(u);
            }
            flag1 = false;
        }
        flag = flag1;
        if (isSetAppv())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("appv:");
            if (v == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(v);
            }
            flag = false;
        }
        flag1 = flag;
        if (isSetApp())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("app:");
            if (w == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(w);
            }
            flag1 = false;
        }
        flag = flag1;
        if (isSetSys())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("sys:");
            if (x == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(x);
            }
            flag = false;
        }
        flag1 = flag;
        if (isSetBroadcastData())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("broadcastData:");
            if (y == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(y);
            }
            flag1 = false;
        }
        if (isSetIpAddress())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("ipAddress:");
            if (z == null)
            {
                stringbuilder.append("null");
                flag = flag2;
            } else
            {
                stringbuilder.append(z);
                flag = flag2;
            }
        } else
        {
            flag = flag1;
        }
        if (isSetRequestTime())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("requestTime:");
            if (A == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(A);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetApp()
    {
        w = null;
    }

    public void unsetAppv()
    {
        v = null;
    }

    public void unsetB()
    {
        q = null;
    }

    public void unsetBroadcastData()
    {
        y = null;
    }

    public void unsetDev()
    {
        r = null;
    }

    public void unsetDeviceID()
    {
        p = null;
    }

    public void unsetIpAddress()
    {
        z = null;
    }

    public void unsetModel()
    {
        u = null;
    }

    public void unsetRequestTime()
    {
        A = null;
    }

    public void unsetSys()
    {
        x = null;
    }

    public void unsetSysv()
    {
        t = null;
    }

    public void unsetTok()
    {
        o = null;
    }

    public void unsetV()
    {
        s = null;
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
        if (o != null && isSetTok())
        {
            tprotocol.writeFieldBegin(b);
            tprotocol.writeString(o);
            tprotocol.writeFieldEnd();
        }
        if (p != null && isSetDeviceID())
        {
            tprotocol.writeFieldBegin(c);
            tprotocol.writeString(p);
            tprotocol.writeFieldEnd();
        }
        if (q != null && isSetB())
        {
            tprotocol.writeFieldBegin(d);
            tprotocol.writeString(q);
            tprotocol.writeFieldEnd();
        }
        if (r != null && isSetDev())
        {
            tprotocol.writeFieldBegin(e);
            tprotocol.writeString(r);
            tprotocol.writeFieldEnd();
        }
        if (s != null && isSetV())
        {
            tprotocol.writeFieldBegin(f);
            tprotocol.writeString(s);
            tprotocol.writeFieldEnd();
        }
        if (t != null && isSetSysv())
        {
            tprotocol.writeFieldBegin(g);
            tprotocol.writeString(t);
            tprotocol.writeFieldEnd();
        }
        if (u != null && isSetModel())
        {
            tprotocol.writeFieldBegin(h);
            tprotocol.writeString(u);
            tprotocol.writeFieldEnd();
        }
        if (v != null && isSetAppv())
        {
            tprotocol.writeFieldBegin(i);
            tprotocol.writeString(v);
            tprotocol.writeFieldEnd();
        }
        if (w != null && isSetApp())
        {
            tprotocol.writeFieldBegin(j);
            tprotocol.writeString(w);
            tprotocol.writeFieldEnd();
        }
        if (x != null && isSetSys())
        {
            tprotocol.writeFieldBegin(k);
            tprotocol.writeString(x);
            tprotocol.writeFieldEnd();
        }
        if (y != null && isSetBroadcastData())
        {
            tprotocol.writeFieldBegin(l);
            y.write(tprotocol);
            tprotocol.writeFieldEnd();
        }
        if (z != null && isSetIpAddress())
        {
            tprotocol.writeFieldBegin(m);
            tprotocol.writeString(z);
            tprotocol.writeFieldEnd();
        }
        if (A != null && isSetRequestTime())
        {
            tprotocol.writeFieldBegin(n);
            tprotocol.writeString(A);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
    }

    static 
    {
        metaDataMap = Collections.unmodifiableMap(new o());
        FieldMetaData.addStructMetaDataMap(com/medialets/thrift/MMClientRequest, metaDataMap);
    }

    // Unreferenced inner class com/medialets/thrift/o
    final class o extends HashMap
    {

            o()
            {
                put(Integer.valueOf(1), new FieldMetaData("tok", (byte)2, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(2), new FieldMetaData("deviceID", (byte)2, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(3), new FieldMetaData("b", (byte)2, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(4), new FieldMetaData("dev", (byte)2, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(5), new FieldMetaData("v", (byte)2, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(6), new FieldMetaData("sysv", (byte)2, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(7), new FieldMetaData("model", (byte)2, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(8), new FieldMetaData("appv", (byte)2, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(9), new FieldMetaData("app", (byte)2, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(10), new FieldMetaData("sys", (byte)2, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(11), new FieldMetaData("broadcastData", (byte)2, new StructMetaData((byte)12, com/medialets/thrift/BroadcastData)));
                put(Integer.valueOf(12), new FieldMetaData("ipAddress", (byte)2, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(13), new FieldMetaData("requestTime", (byte)2, new FieldValueMetaData((byte)11)));
            }
    }

}
