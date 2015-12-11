// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.generic;

import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.io.BinaryData;
import java.util.Arrays;

// Referenced classes of package com.flurry.org.apache.avro.generic:
//            GenericFixed, GenericData

public static class bytes
    implements GenericFixed, Comparable
{

    private byte bytes[];
    private Schema schema;

    public void bytes(byte abyte0[])
    {
        bytes = abyte0;
    }

    public byte[] bytes()
    {
        return bytes;
    }

    public int compareTo(bytes bytes1)
    {
        return BinaryData.compareBytes(bytes, 0, bytes.length, bytes1.bytes, 0, bytes1.bytes.length);
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((compareTo)obj);
    }

    public boolean equals(Object obj)
    {
        while (obj == this || (obj instanceof GenericFixed) && Arrays.equals(bytes, ((GenericFixed)obj).bytes())) 
        {
            return true;
        }
        return false;
    }

    public Schema getSchema()
    {
        return schema;
    }

    public int hashCode()
    {
        return Arrays.hashCode(bytes);
    }

    protected void setSchema(Schema schema1)
    {
        schema = schema1;
        bytes = new byte[schema1.getFixedSize()];
    }

    public String toString()
    {
        return Arrays.toString(bytes);
    }

    protected ()
    {
    }

    public (Schema schema1)
    {
        setSchema(schema1);
    }

    public setSchema(Schema schema1, byte abyte0[])
    {
        schema = schema1;
        bytes = abyte0;
    }
}
