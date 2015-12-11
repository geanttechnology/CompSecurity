// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import android.util.Log;
import com.twinprime.msgpack.MessagePack;
import com.twinprime.msgpack.type.IntegerValue;
import com.twinprime.msgpack.type.MapValue;
import com.twinprime.msgpack.type.Value;
import com.twinprime.msgpack.type.ValueType;
import com.twinprime.msgpack.unpacker.Unpacker;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            XcpMsgDiscRep, JNILibrary, TPLog, XcpMsg

public class XcpMsgUtils
{
    static interface XcpMsgCreator
    {

        public abstract XcpMsg createXcpMsgFromMap(Hashtable hashtable);
    }

    private static class XcpTypeMapElm
    {

        XcpMsgCreator creator;
        int type;

        XcpTypeMapElm(int i, XcpMsgCreator xcpmsgcreator)
        {
            type = i;
            creator = xcpmsgcreator;
        }
    }


    static XcpMsgUtils me = new XcpMsgUtils();
    static ArrayList typeList = new ArrayList();

    private XcpMsgUtils()
    {
    }

    static void addXcpType(int i, XcpMsgCreator xcpmsgcreator)
    {
        typeList.add(new XcpTypeMapElm(i, xcpmsgcreator));
    }

    static void conditionalAdd(Hashtable hashtable, Number number, Object obj)
    {
        if (obj != null)
        {
            hashtable.put(number, obj);
        }
    }

    static XcpMsgUtils getInstance()
    {
        com/twinprime/TwinPrimeSDK/XcpMsgUtils;
        JVM INSTR monitorenter ;
        XcpMsgUtils xcpmsgutils = me;
        com/twinprime/TwinPrimeSDK/XcpMsgUtils;
        JVM INSTR monitorexit ;
        return xcpmsgutils;
        Exception exception;
        exception;
        throw exception;
    }

    static int getIntFromMap(Hashtable hashtable, Long long1)
    {
        hashtable = (Number)(Number)hashtable.get(long1);
        if (hashtable == null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        int i = hashtable.intValue();
        return i;
        hashtable;
        return 0;
    }

    static long getLongFromMap(Hashtable hashtable, Long long1)
    {
        hashtable = (Number)(Number)hashtable.get(long1);
        if (hashtable == null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        long l = hashtable.longValue();
        return l;
        hashtable;
        return 0L;
    }

    static long[] getlongArrayFromMap(Hashtable hashtable, Long long1)
    {
        List list = (List)hashtable.get(long1);
        if (list == null) goto _L2; else goto _L1
_L1:
        long1 = new long[list.size()];
        int i = 0;
_L4:
        hashtable = long1;
        if (i >= list.size())
        {
            break; /* Loop/switch isn't completed */
        }
        long1[i] = ((Long)list.get(i)).longValue();
        i++;
        if (true) goto _L4; else goto _L3
        hashtable;
_L2:
        hashtable = new long[0];
_L3:
        return hashtable;
    }

    XcpMsg getXcpObjForBytes(byte abyte0[])
    {
        abyte0 = new ByteArrayInputStream(abyte0);
        abyte0 = (new MessagePack()).createUnpacker(abyte0);
        Object obj = abyte0.readValue();
        if (((Value) (obj)).getType() == ValueType.MAP)
        {
            return new XcpMsgDiscRep(JNILibrary.mapForMapValue((MapValue)obj));
        }
        if (((Value) (obj)).getType() != ValueType.INTEGER)
        {
            break MISSING_BLOCK_LABEL_243;
        }
        int i = ((IntegerValue)((Value) (obj)).getValue()).getInt();
        int j = ((IntegerValue)abyte0.readValue().getValue()).getInt();
        abyte0 = JNILibrary.mapForMapValue((MapValue)abyte0.readValue());
        if (TPLog.LOG13.isLoggable("XCP"))
        {
            Log.d("XCP", (new StringBuilder()).append("Type: ").append(i).append(" Len: ").append(j).append(" Map: ").append(abyte0).toString());
        }
        obj = typeList.iterator();
        XcpTypeMapElm xcptypemapelm;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_217;
            }
            xcptypemapelm = (XcpTypeMapElm)((Iterator) (obj)).next();
        } while (xcptypemapelm.type != i);
        abyte0 = xcptypemapelm.creator.createXcpMsgFromMap(abyte0);
        return abyte0;
        return null;
        abyte0;
        if (TPLog.LOG10.isLoggable("XCP"))
        {
            Log.e("XCP", "Exception while decoding msgpack: IOException");
            abyte0.printStackTrace();
        }
_L2:
        return null;
        abyte0;
        if (TPLog.LOG10.isLoggable("XCP"))
        {
            Log.e("XCP", "Exception while decoding msgpack: ClassCastException");
            abyte0.printStackTrace();
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

}
