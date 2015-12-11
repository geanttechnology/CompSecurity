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
import org.apache.thrift.meta_data.ListMetaData;
import org.apache.thrift.meta_data.StructMetaData;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TList;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.protocol.TStruct;

// Referenced classes of package com.medialets.thrift:
//            r, MMAdDownload

public class MMSlotZeroResponse
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


    public static final int ADDOWNLOADS = 1;
    private static final TStruct a = new TStruct("MMSlotZeroResponse");
    private static final TField b = new TField("adDownloads", (byte)15, (short)1);
    public static final Map metaDataMap;
    private List c;

    public MMSlotZeroResponse()
    {
        new a();
    }

    public MMSlotZeroResponse(MMSlotZeroResponse mmslotzeroresponse)
    {
        new a();
        if (!mmslotzeroresponse.isSetAdDownloads()) goto _L2; else goto _L1
_L1:
        ArrayList arraylist;
        arraylist = new ArrayList();
        mmslotzeroresponse = mmslotzeroresponse.c.iterator();
_L6:
        if (mmslotzeroresponse.hasNext()) goto _L4; else goto _L3
_L3:
        c = arraylist;
_L2:
        return;
_L4:
        arraylist.add(new MMAdDownload((MMAdDownload)mmslotzeroresponse.next()));
        if (true) goto _L6; else goto _L5
_L5:
    }

    public MMSlotZeroResponse(List list)
    {
        this();
        c = list;
    }

    public void addToAdDownloads(MMAdDownload mmaddownload)
    {
        if (c == null)
        {
            c = new ArrayList();
        }
        c.add(mmaddownload);
    }

    public MMSlotZeroResponse clone()
    {
        return new MMSlotZeroResponse(this);
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public boolean equals(MMSlotZeroResponse mmslotzeroresponse)
    {
        if (mmslotzeroresponse != null)
        {
            boolean flag;
            boolean flag1;
            if (isSetAdDownloads())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (mmslotzeroresponse.isSetAdDownloads())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!flag && !flag1 || flag && flag1 && c.equals(mmslotzeroresponse.c))
            {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof MMSlotZeroResponse)) 
        {
            return false;
        }
        return equals((MMSlotZeroResponse)obj);
    }

    public List getAdDownloads()
    {
        return c;
    }

    public Iterator getAdDownloadsIterator()
    {
        if (c == null)
        {
            return null;
        } else
        {
            return c.iterator();
        }
    }

    public int getAdDownloadsSize()
    {
        if (c == null)
        {
            return 0;
        } else
        {
            return c.size();
        }
    }

    public Object getFieldValue(int i)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());

        case 1: // '\001'
            return getAdDownloads();
        }
    }

    public int hashCode()
    {
        return 0;
    }

    public boolean isSet(int i)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());

        case 1: // '\001'
            return isSetAdDownloads();
        }
    }

    public boolean isSetAdDownloads()
    {
        return c != null;
    }

    public void read(TProtocol tprotocol)
        throws TException
    {
        tprotocol.readStructBegin();
_L5:
        Object obj = tprotocol.readFieldBegin();
        if (((TField) (obj)).type == 0) goto _L2; else goto _L1
_L1:
        ((TField) (obj)).id;
        JVM INSTR tableswitch 1 1: default 40
    //                   1 55;
           goto _L3 _L4
_L3:
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
_L10:
        tprotocol.readFieldEnd();
          goto _L5
_L4:
        if (((TField) (obj)).type != 15) goto _L7; else goto _L6
_L6:
        int i;
        obj = tprotocol.readListBegin();
        c = new ArrayList(((TList) (obj)).size);
        i = 0;
_L11:
        if (i < ((TList) (obj)).size) goto _L9; else goto _L8
_L8:
        tprotocol.readListEnd();
          goto _L10
_L9:
        MMAdDownload mmaddownload = new MMAdDownload();
        mmaddownload.read(tprotocol);
        c.add(mmaddownload);
        i++;
          goto _L11
_L7:
        TProtocolUtil.skip(tprotocol, ((TField) (obj)).type);
          goto _L10
_L2:
        tprotocol.readStructEnd();
        validate();
        return;
    }

    public void setAdDownloads(List list)
    {
        c = list;
    }

    public void setFieldValue(int i, Object obj)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder("Field ")).append(i).append(" doesn't exist!").toString());

        case 1: // '\001'
            break;
        }
        if (obj == null)
        {
            unsetAdDownloads();
            return;
        } else
        {
            setAdDownloads((List)obj);
            return;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("MMSlotZeroResponse(");
        stringbuilder.append("adDownloads:");
        if (c == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(c);
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public void unsetAdDownloads()
    {
        c = null;
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
        if (c == null) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        tprotocol.writeFieldBegin(b);
        tprotocol.writeListBegin(new TList((byte)12, c.size()));
        iterator = c.iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        tprotocol.writeListEnd();
        tprotocol.writeFieldEnd();
_L2:
        tprotocol.writeFieldStop();
        tprotocol.writeStructEnd();
        return;
_L4:
        ((MMAdDownload)iterator.next()).write(tprotocol);
        if (true) goto _L6; else goto _L5
_L5:
    }

    static 
    {
        metaDataMap = Collections.unmodifiableMap(new r());
        FieldMetaData.addStructMetaDataMap(com/medialets/thrift/MMSlotZeroResponse, metaDataMap);
    }

    // Unreferenced inner class com/medialets/thrift/r
    final class r extends HashMap
    {

            r()
            {
                put(Integer.valueOf(1), new FieldMetaData("adDownloads", (byte)3, new ListMetaData((byte)15, new StructMetaData((byte)12, com/medialets/thrift/MMAdDownload))));
            }
    }

}
