// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api.common.io.protocol;

import com.google.userfeedback.android.api.common.io.BoundInputStream;
import com.google.userfeedback.android.api.common.io.Gunzipper;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.google.userfeedback.android.api.common.io.protocol:
//            ProtoBuf, ProtoBufType

public final class ProtoBufUtil
{

    public static boolean isGzipResponseSeen = false;

    public ProtoBufUtil()
    {
    }

    public static ProtoBuf addProtoBuf(ProtoBuf protobuf, int i)
    {
        ProtoBuf protobuf1 = protobuf.createGroup(i);
        protobuf.addProtoBuf(i, protobuf1);
        return protobuf1;
    }

    public static ProtoBuf cloneProtoBuf(ProtoBuf protobuf)
    {
        ProtoBuf protobuf1 = new ProtoBuf(protobuf.getType());
        protobuf1.parse(protobuf.toByteArray());
        return protobuf1;
    }

    public static ProtoBuf createProtoBuf(ProtoBuf protobuf, int i)
    {
        ProtoBuf protobuf1 = protobuf.createGroup(i);
        protobuf.setProtoBuf(i, protobuf1);
        return protobuf1;
    }

    public static InputStream getInputStreamForProtoBufResponse(DataInput datainput)
    {
        int i = datainput.readInt();
        BoundInputStream boundinputstream = new BoundInputStream((InputStream)datainput, Math.abs(i));
        datainput = boundinputstream;
        if (i < 0)
        {
            isGzipResponseSeen = true;
            datainput = Gunzipper.gunzip(boundinputstream);
        }
        return datainput;
    }

    public static long getProtoLongValueOrDefault(ProtoBuf protobuf, int i, long l)
    {
        long l1 = l;
        if (protobuf != null)
        {
            l1 = l;
            try
            {
                if (protobuf.has(i))
                {
                    l1 = protobuf.getLong(i);
                }
            }
            // Misplaced declaration of an exception variable
            catch (ProtoBuf protobuf)
            {
                return l;
            }
            // Misplaced declaration of an exception variable
            catch (ProtoBuf protobuf)
            {
                return l;
            }
        }
        return l1;
    }

    public static long getProtoLongValueOrZero(ProtoBuf protobuf, int i)
    {
        long l1 = 0L;
        long l = l1;
        if (protobuf != null)
        {
            l = l1;
            try
            {
                if (protobuf.has(i))
                {
                    l = protobuf.getLong(i);
                }
            }
            // Misplaced declaration of an exception variable
            catch (ProtoBuf protobuf)
            {
                return 0L;
            }
            // Misplaced declaration of an exception variable
            catch (ProtoBuf protobuf)
            {
                return 0L;
            }
        }
        return l;
    }

    public static int getProtoValueOrDefault(ProtoBuf protobuf, int i, int j)
    {
        int k = j;
        if (protobuf != null)
        {
            k = j;
            try
            {
                if (protobuf.has(i))
                {
                    k = protobuf.getInt(i);
                }
            }
            // Misplaced declaration of an exception variable
            catch (ProtoBuf protobuf)
            {
                return j;
            }
            // Misplaced declaration of an exception variable
            catch (ProtoBuf protobuf)
            {
                return j;
            }
        }
        return k;
    }

    public static String getProtoValueOrEmpty(ProtoBuf protobuf, int i)
    {
        if (protobuf != null)
        {
            try
            {
                if (protobuf.has(i))
                {
                    return protobuf.getString(i);
                }
            }
            // Misplaced declaration of an exception variable
            catch (ProtoBuf protobuf)
            {
                return "";
            }
        }
        return "";
    }

    public static boolean getProtoValueOrFalse(ProtoBuf protobuf, int i)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (protobuf != null)
        {
            flag = flag1;
            try
            {
                if (protobuf.has(i))
                {
                    flag = protobuf.getBool(i);
                }
            }
            // Misplaced declaration of an exception variable
            catch (ProtoBuf protobuf)
            {
                return false;
            }
            // Misplaced declaration of an exception variable
            catch (ProtoBuf protobuf)
            {
                return false;
            }
        }
        return flag;
    }

    public static long getProtoValueOrNegativeOne(ProtoBuf protobuf, int i)
    {
        long l1 = -1L;
        long l = l1;
        if (protobuf != null)
        {
            l = l1;
            try
            {
                if (protobuf.has(i))
                {
                    l = protobuf.getLong(i);
                }
            }
            // Misplaced declaration of an exception variable
            catch (ProtoBuf protobuf)
            {
                return -1L;
            }
            // Misplaced declaration of an exception variable
            catch (ProtoBuf protobuf)
            {
                return -1L;
            }
        }
        return l;
    }

    public static String getProtoValueOrNull(ProtoBuf protobuf, int i)
    {
        Object obj = null;
        String s = obj;
        if (protobuf != null)
        {
            s = obj;
            try
            {
                if (protobuf.has(i))
                {
                    s = protobuf.getString(i);
                }
            }
            // Misplaced declaration of an exception variable
            catch (ProtoBuf protobuf)
            {
                return null;
            }
        }
        return s;
    }

    public static String getProtoValueOrNull(ProtoBuf protobuf, int i, int j)
    {
        String s;
        Object obj;
        obj = null;
        s = obj;
        if (protobuf == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        s = obj;
        if (protobuf.has(i))
        {
            s = obj;
            try
            {
                if (protobuf.getCount(i) > j)
                {
                    s = protobuf.getString(i, j);
                }
            }
            // Misplaced declaration of an exception variable
            catch (ProtoBuf protobuf)
            {
                return null;
            }
        }
        return s;
    }

    public static int getProtoValueOrZero(ProtoBuf protobuf, int i)
    {
        return getProtoValueOrDefault(protobuf, i, 0);
    }

    public static ProtoBuf getSubProtoOrNull(ProtoBuf protobuf, int i)
    {
        if (protobuf != null && protobuf.has(i))
        {
            return protobuf.getProtoBuf(i);
        } else
        {
            return null;
        }
    }

    public static int getSubProtoValueOrDefault(ProtoBuf protobuf, int i, int j, int k)
    {
        try
        {
            i = getProtoValueOrDefault(getSubProtoOrNull(protobuf, i), j, k);
        }
        // Misplaced declaration of an exception variable
        catch (ProtoBuf protobuf)
        {
            return k;
        }
        // Misplaced declaration of an exception variable
        catch (ProtoBuf protobuf)
        {
            return k;
        }
        return i;
    }

    public static String getSubProtoValueOrEmpty(ProtoBuf protobuf, int i, int j)
    {
        try
        {
            protobuf = getProtoValueOrEmpty(getSubProtoOrNull(protobuf, i), j);
        }
        // Misplaced declaration of an exception variable
        catch (ProtoBuf protobuf)
        {
            return "";
        }
        return protobuf;
    }

    public static long getSubProtoValueOrNegativeOne(ProtoBuf protobuf, int i, int j)
    {
        long l;
        try
        {
            l = getProtoValueOrNegativeOne(getSubProtoOrNull(protobuf, i), j);
        }
        // Misplaced declaration of an exception variable
        catch (ProtoBuf protobuf)
        {
            return -1L;
        }
        // Misplaced declaration of an exception variable
        catch (ProtoBuf protobuf)
        {
            return -1L;
        }
        return l;
    }

    public static int readNextProtoBuf(ProtoBufType protobuftype, InputStream inputstream, ProtoBuf protobuf)
    {
        long l = ProtoBuf.readVarInt(inputstream, true);
        if (l == -1L)
        {
            return -1;
        }
        if ((7L & l) != 2L)
        {
            throw new IOException("Message expected");
        } else
        {
            int i = (int)(l >>> 3);
            protobuf.setType((ProtoBufType)protobuftype.getData(i));
            protobuf.parse(inputstream, (int)ProtoBuf.readVarInt(inputstream, false));
            return i;
        }
    }

    public static ProtoBuf readProtoBufResponse(ProtoBufType protobuftype, DataInput datainput)
    {
        protobuftype = new ProtoBuf(protobuftype);
        datainput = getInputStreamForProtoBufResponse(datainput);
        protobuftype.parse(datainput);
        if (datainput.read() != -1)
        {
            throw new IOException();
        } else
        {
            return protobuftype;
        }
    }

    public static void writeProtoBufToOutput(DataOutput dataoutput, ProtoBuf protobuf)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        protobuf.outputTo(bytearrayoutputstream);
        protobuf = bytearrayoutputstream.toByteArray();
        dataoutput.writeInt(protobuf.length);
        dataoutput.write(protobuf);
    }

}
