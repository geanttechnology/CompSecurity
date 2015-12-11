// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.type;

import com.twinprime.msgpack.MessageTypeException;
import com.twinprime.msgpack.packer.Packer;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

// Referenced classes of package com.twinprime.msgpack.type:
//            AbstractRawValue, Value, ValueType, RawValue

class StringRawValueImpl extends AbstractRawValue
{

    private String string;

    StringRawValueImpl(String s)
    {
        string = s;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag;
        if (this == obj)
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (obj instanceof Value)
            {
                obj = (Value)obj;
                flag = flag1;
                if (((Value) (obj)).getType() == ValueType.RAW)
                {
                    if (obj.getClass() == com/twinprime/msgpack/type/StringRawValueImpl)
                    {
                        return string.equals(((StringRawValueImpl)obj).string);
                    } else
                    {
                        return Arrays.equals(getByteArray(), ((RawValue)((Value) (obj)).getValue()).getByteArray());
                    }
                }
            }
        }
        return flag;
    }

    public byte[] getByteArray()
    {
        byte abyte0[];
        try
        {
            abyte0 = string.getBytes("UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new MessageTypeException(unsupportedencodingexception);
        }
        return abyte0;
    }

    public String getString()
    {
        return string;
    }

    public void writeTo(Packer packer)
        throws IOException
    {
        packer.write(string);
    }
}
