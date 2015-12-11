// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.reflect;

import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.io.Encoder;
import com.flurry.org.apache.avro.specific.SpecificDatumWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.flurry.org.apache.avro.reflect:
//            ReflectData

public class ReflectDatumWriter extends SpecificDatumWriter
{

    public ReflectDatumWriter()
    {
        this(ReflectData.get());
    }

    public ReflectDatumWriter(Schema schema)
    {
        this(schema, ReflectData.get());
    }

    protected ReflectDatumWriter(Schema schema, ReflectData reflectdata)
    {
        super(schema, reflectdata);
    }

    protected ReflectDatumWriter(ReflectData reflectdata)
    {
        super(reflectdata);
    }

    public ReflectDatumWriter(Class class1)
    {
        this(class1, ReflectData.get());
    }

    public ReflectDatumWriter(Class class1, ReflectData reflectdata)
    {
        this(reflectdata.getSchema(class1), reflectdata);
    }

    protected Iterator getArrayElements(final Object array)
    {
        if (array instanceof Collection)
        {
            return ((Collection)array).iterator();
        } else
        {
            return new Iterator() {

                private int i;
                private final int length;
                final ReflectDatumWriter this$0;
                final Object val$array;

                public boolean hasNext()
                {
                    return i < length;
                }

                public Object next()
                {
                    Object obj = array;
                    int j = i;
                    i = j + 1;
                    return Array.get(obj, j);
                }

                public void remove()
                {
                    throw new UnsupportedOperationException();
                }

            
            {
                this$0 = ReflectDatumWriter.this;
                array = obj;
                super();
                i = 0;
                length = Array.getLength(array);
            }
            };
        }
    }

    protected long getArraySize(Object obj)
    {
        if (obj instanceof Collection)
        {
            return (long)((Collection)obj).size();
        } else
        {
            return (long)Array.getLength(obj);
        }
    }

    protected void write(Schema schema, Object obj, Encoder encoder)
        throws IOException
    {
        Object obj1;
        if (obj instanceof Byte)
        {
            obj1 = Integer.valueOf(((Byte)obj).intValue());
        } else
        {
            obj1 = obj;
            if (obj instanceof Short)
            {
                obj1 = Integer.valueOf(((Short)obj).intValue());
            }
        }
        try
        {
            super.write(schema, obj1, encoder);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            encoder = new NullPointerException((new StringBuilder()).append("in ").append(schema.getFullName()).append(" ").append(((NullPointerException) (obj)).getMessage()).toString());
        }
        if (((NullPointerException) (obj)).getCause() == null)
        {
            schema = ((Schema) (obj));
        } else
        {
            schema = ((NullPointerException) (obj)).getCause();
        }
        encoder.initCause(schema);
        throw encoder;
    }

    protected void writeBytes(Object obj, Encoder encoder)
        throws IOException
    {
        if (obj instanceof byte[])
        {
            encoder.writeBytes((byte[])(byte[])obj);
            return;
        } else
        {
            super.writeBytes(obj, encoder);
            return;
        }
    }

    protected void writeString(Schema schema, Object obj, Encoder encoder)
        throws IOException
    {
        Object obj1 = obj;
        if (schema.getProp("java-class") != null)
        {
            obj1 = obj.toString();
        }
        writeString(obj1, encoder);
    }
}
