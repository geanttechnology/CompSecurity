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
//            n, MMAdControl, MMAdUpdate

public class MMAdDownload
    implements Serializable, Cloneable, TBase
{
    private static final class a
        implements Serializable
    {

        public boolean adVersion;

        a()
        {
            this((byte)0);
        }

        private a(byte byte0)
        {
            adVersion = false;
        }
    }


    public static final int ADCONTROL = 6;
    public static final int ADCONTROLPLIST = 5;
    public static final int ADID = 1;
    public static final int ADVERSION = 2;
    public static final int BUNDLEURL = 3;
    public static final int UPDATES = 4;
    private static final TStruct a = new TStruct("MMAdDownload");
    private static final TField b = new TField("adID", (byte)11, (short)1);
    private static final TField c = new TField("adVersion", (byte)6, (short)2);
    private static final TField d = new TField("bundleURL", (byte)11, (short)3);
    private static final TField e = new TField("updates", (byte)15, (short)4);
    private static final TField f = new TField("adControlPlist", (byte)11, (short)5);
    private static final TField g = new TField("adControl", (byte)12, (short)6);
    public static final Map metaDataMap;
    private String h;
    private short i;
    private String j;
    private List k;
    private String l;
    private MMAdControl m;
    private final a n;

    public MMAdDownload()
    {
        n = new a();
    }

    public MMAdDownload(MMAdDownload mmaddownload)
    {
        n = new a();
        if (mmaddownload.isSetAdID())
        {
            h = mmaddownload.h;
        }
        n.adVersion = mmaddownload.n.adVersion;
        i = mmaddownload.i;
        if (mmaddownload.isSetBundleURL())
        {
            j = mmaddownload.j;
        }
        if (!mmaddownload.isSetUpdates()) goto _L2; else goto _L1
_L1:
        ArrayList arraylist;
        Iterator iterator;
        arraylist = new ArrayList();
        iterator = mmaddownload.k.iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        k = arraylist;
_L2:
        if (mmaddownload.isSetAdControlPlist())
        {
            l = mmaddownload.l;
        }
        if (mmaddownload.isSetAdControl())
        {
            m = new MMAdControl(mmaddownload.m);
        }
        return;
_L4:
        arraylist.add(new MMAdUpdate((MMAdUpdate)iterator.next()));
        if (true) goto _L6; else goto _L5
_L5:
    }

    public MMAdDownload(String s, short word0, String s1, List list, String s2, MMAdControl mmadcontrol)
    {
        this();
        h = s;
        i = word0;
        n.adVersion = true;
        j = s1;
        k = list;
        l = s2;
        m = mmadcontrol;
    }

    public void addToUpdates(MMAdUpdate mmadupdate)
    {
        if (k == null)
        {
            k = new ArrayList();
        }
        k.add(mmadupdate);
    }

    public MMAdDownload clone()
    {
        return new MMAdDownload(this);
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public boolean equals(MMAdDownload mmaddownload)
    {
        if (mmaddownload != null)
        {
            boolean flag;
            boolean flag1;
            if (isSetAdID())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (mmaddownload.isSetAdID())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if ((!flag && !flag1 || flag && flag1 && h.equals(mmaddownload.h)) && i == mmaddownload.i)
            {
                if (isSetBundleURL())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (mmaddownload.isSetBundleURL())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (!flag && !flag1 || flag && flag1 && j.equals(mmaddownload.j))
                {
                    if (isSetUpdates())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (mmaddownload.isSetUpdates())
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (!flag && !flag1 || flag && flag1 && k.equals(mmaddownload.k))
                    {
                        if (isSetAdControlPlist())
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        if (mmaddownload.isSetAdControlPlist())
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        if (!flag && !flag1 || flag && flag1 && l.equals(mmaddownload.l))
                        {
                            if (isSetAdControl())
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                            if (mmaddownload.isSetAdControl())
                            {
                                flag1 = true;
                            } else
                            {
                                flag1 = false;
                            }
                            if (!flag && !flag1 || flag && flag1 && m.equals(mmaddownload.m))
                            {
                                return true;
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
        while (obj == null || !(obj instanceof MMAdDownload)) 
        {
            return false;
        }
        return equals((MMAdDownload)obj);
    }

    public MMAdControl getAdControl()
    {
        return m;
    }

    public String getAdControlPlist()
    {
        return l;
    }

    public String getAdID()
    {
        return h;
    }

    public short getAdVersion()
    {
        return i;
    }

    public String getBundleURL()
    {
        return j;
    }

    public Object getFieldValue(int i1)
    {
        switch (i1)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i1).append(" doesn't exist!").toString());

        case 1: // '\001'
            return getAdID();

        case 2: // '\002'
            return new Short(getAdVersion());

        case 3: // '\003'
            return getBundleURL();

        case 4: // '\004'
            return getUpdates();

        case 5: // '\005'
            return getAdControlPlist();

        case 6: // '\006'
            return getAdControl();
        }
    }

    public List getUpdates()
    {
        return k;
    }

    public Iterator getUpdatesIterator()
    {
        if (k == null)
        {
            return null;
        } else
        {
            return k.iterator();
        }
    }

    public int getUpdatesSize()
    {
        if (k == null)
        {
            return 0;
        } else
        {
            return k.size();
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
            return isSetAdID();

        case 2: // '\002'
            return isSetAdVersion();

        case 3: // '\003'
            return isSetBundleURL();

        case 4: // '\004'
            return isSetUpdates();

        case 5: // '\005'
            return isSetAdControlPlist();

        case 6: // '\006'
            return isSetAdControl();
        }
    }

    public boolean isSetAdControl()
    {
        return m != null;
    }

    public boolean isSetAdControlPlist()
    {
        return l != null;
    }

    public boolean isSetAdID()
    {
        return h != null;
    }

    public boolean isSetAdVersion()
    {
        return n.adVersion;
    }

    public boolean isSetBundleURL()
    {
        return j != null;
    }

    public boolean isSetUpdates()
    {
        return k != null;
    }

    public void read(TProtocol tprotocol)
        throws TException
    {
        tprotocol.readStructBegin();
_L9:
        Object obj;
        obj = tprotocol.readFieldBegin();
        if (((TField) (obj)).type == 0)
        {
            break MISSING_BLOCK_LABEL_341;
        }
        ((TField) (obj)).id;
        JVM INSTR tableswitch 1 6: default 60
    //                   1 75
    //                   2 106
    //                   3 145
    //                   4 176
    //                   5 268
    //                   6 299;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L2:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_299;
_L1:
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L10:
        tprotocol.readFieldEnd();
        if (true) goto _L9; else goto _L8
_L8:
        if (((TField) (obj)).type == 11)
        {
            h = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L10
_L3:
        if (((TField) (obj)).type == 6)
        {
            i = tprotocol.readI16();
            n.adVersion = true;
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L10
_L4:
        if (((TField) (obj)).type == 11)
        {
            j = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L10
_L5:
        int i1;
        if (((TField) (obj)).type != 15)
        {
            break MISSING_BLOCK_LABEL_257;
        }
        obj = tprotocol.readListBegin();
        k = new ArrayList(((TList) (obj)).size);
        i1 = 0;
_L11:
label0:
        {
            if (i1 < ((TList) (obj)).size)
            {
                break label0;
            }
            tprotocol.readListEnd();
        }
          goto _L10
        MMAdUpdate mmadupdate = new MMAdUpdate();
        mmadupdate.read(tprotocol);
        k.add(mmadupdate);
        i1++;
          goto _L11
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
          goto _L10
_L6:
        if (((TField) (obj)).type == 11)
        {
            l = tprotocol.readString();
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L10
        if (((TField) (obj)).type == 12)
        {
            m = new MMAdControl();
            m.read(tprotocol);
        } else
        {
            TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
        }
          goto _L10
        tprotocol.readStructEnd();
        validate();
        return;
    }

    public void setAdControl(MMAdControl mmadcontrol)
    {
        m = mmadcontrol;
    }

    public void setAdControlPlist(String s)
    {
        l = s;
    }

    public void setAdID(String s)
    {
        h = s;
    }

    public void setAdVersion(short word0)
    {
        i = word0;
        n.adVersion = true;
    }

    public void setBundleURL(String s)
    {
        j = s;
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
                unsetAdID();
                return;
            } else
            {
                setAdID((String)obj);
                return;
            }

        case 2: // '\002'
            if (obj == null)
            {
                unsetAdVersion();
                return;
            } else
            {
                setAdVersion(((Short)obj).shortValue());
                return;
            }

        case 3: // '\003'
            if (obj == null)
            {
                unsetBundleURL();
                return;
            } else
            {
                setBundleURL((String)obj);
                return;
            }

        case 4: // '\004'
            if (obj == null)
            {
                unsetUpdates();
                return;
            } else
            {
                setUpdates((List)obj);
                return;
            }

        case 5: // '\005'
            if (obj == null)
            {
                unsetAdControlPlist();
                return;
            } else
            {
                setAdControlPlist((String)obj);
                return;
            }

        case 6: // '\006'
            break;
        }
        if (obj == null)
        {
            unsetAdControl();
            return;
        } else
        {
            setAdControl((MMAdControl)obj);
            return;
        }
    }

    public void setUpdates(List list)
    {
        k = list;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("MMAdDownload(");
        stringbuilder.append("adID:");
        if (h == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(h);
        }
        stringbuilder.append(", ");
        stringbuilder.append("adVersion:");
        stringbuilder.append(i);
        stringbuilder.append(", ");
        stringbuilder.append("bundleURL:");
        if (j == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(j);
        }
        if (isSetUpdates())
        {
            stringbuilder.append(", ");
            stringbuilder.append("updates:");
            if (k == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(k);
            }
        }
        stringbuilder.append(", ");
        stringbuilder.append("adControlPlist:");
        if (l == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(l);
        }
        if (isSetAdControl())
        {
            stringbuilder.append(", ");
            stringbuilder.append("adControl:");
            if (m == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(m);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetAdControl()
    {
        m = null;
    }

    public void unsetAdControlPlist()
    {
        l = null;
    }

    public void unsetAdID()
    {
        h = null;
    }

    public void unsetAdVersion()
    {
        n.adVersion = false;
    }

    public void unsetBundleURL()
    {
        j = null;
    }

    public void unsetUpdates()
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
        if (h != null)
        {
            tprotocol.writeFieldBegin(b);
            tprotocol.writeString(h);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldBegin(c);
        tprotocol.writeI16(i);
        tprotocol.writeFieldEnd();
        if (j != null)
        {
            tprotocol.writeFieldBegin(d);
            tprotocol.writeString(j);
            tprotocol.writeFieldEnd();
        }
        if (k == null || !isSetUpdates()) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        tprotocol.writeFieldBegin(e);
        tprotocol.writeListBegin(new TList((byte)12, k.size()));
        iterator = k.iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        tprotocol.writeListEnd();
        tprotocol.writeFieldEnd();
_L2:
        if (l != null)
        {
            tprotocol.writeFieldBegin(f);
            tprotocol.writeString(l);
            tprotocol.writeFieldEnd();
        }
        if (m != null && isSetAdControl())
        {
            tprotocol.writeFieldBegin(g);
            m.write(tprotocol);
            tprotocol.writeFieldEnd();
        }
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
        return;
_L4:
        ((MMAdUpdate)iterator.next()).write(tprotocol);
        if (true) goto _L6; else goto _L5
_L5:
    }

    static 
    {
        metaDataMap = Collections.unmodifiableMap(new n());
        FieldMetaData.addStructMetaDataMap(com/medialets/thrift/MMAdDownload, metaDataMap);
    }

    // Unreferenced inner class com/medialets/thrift/n
    final class n extends HashMap
    {

            n()
            {
                put(Integer.valueOf(1), new FieldMetaData("adID", (byte)3, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(2), new FieldMetaData("adVersion", (byte)3, new FieldValueMetaData((byte)6)));
                put(Integer.valueOf(3), new FieldMetaData("bundleURL", (byte)3, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(4), new FieldMetaData("updates", (byte)2, new ListMetaData((byte)15, new StructMetaData((byte)12, com/medialets/thrift/MMAdUpdate))));
                put(Integer.valueOf(5), new FieldMetaData("adControlPlist", (byte)3, new FieldValueMetaData((byte)11)));
                put(Integer.valueOf(6), new FieldMetaData("adControl", (byte)2, new StructMetaData((byte)12, com/medialets/thrift/MMAdControl)));
            }
    }

}
