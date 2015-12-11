// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.type;

import com.twinprime.msgpack.MessageTypeException;
import com.twinprime.msgpack.packer.Packer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

// Referenced classes of package com.twinprime.msgpack.type:
//            AbstractRawValue, Value, ValueType, RawValue

class ByteArrayRawValueImpl extends AbstractRawValue
{

    private static final ThreadLocal decoderStore = new ThreadLocal() {

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected CharsetDecoder initialValue()
        {
            return Charset.forName("UTF-8").newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);
        }

    };
    private static ByteArrayRawValueImpl emptyInstance = new ByteArrayRawValueImpl(new byte[0], true);
    private byte bytes[];

    ByteArrayRawValueImpl(byte abyte0[], int i, int j)
    {
        bytes = new byte[j];
        System.arraycopy(abyte0, i, bytes, 0, j);
    }

    ByteArrayRawValueImpl(byte abyte0[], boolean flag)
    {
        if (flag)
        {
            bytes = abyte0;
            return;
        } else
        {
            bytes = new byte[abyte0.length];
            System.arraycopy(abyte0, 0, bytes, 0, abyte0.length);
            return;
        }
    }

    public static RawValue getEmptyInstance()
    {
        return emptyInstance;
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
                    return Arrays.equals(bytes, ((RawValue)((Value) (obj)).getValue()).getByteArray());
                }
            }
        }
        return flag;
    }

    public byte[] getByteArray()
    {
        return bytes;
    }

    public String getString()
    {
        Object obj = (CharsetDecoder)decoderStore.get();
        try
        {
            obj = ((CharsetDecoder) (obj)).decode(ByteBuffer.wrap(bytes)).toString();
        }
        catch (CharacterCodingException charactercodingexception)
        {
            throw new MessageTypeException(charactercodingexception);
        }
        return ((String) (obj));
    }

    public int hashCode()
    {
        return Arrays.hashCode(bytes);
    }

    public void writeTo(Packer packer)
        throws IOException
    {
        packer.write(bytes);
    }

}
