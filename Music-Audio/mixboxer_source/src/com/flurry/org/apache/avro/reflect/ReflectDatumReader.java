// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.reflect;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.io.Decoder;
import com.flurry.org.apache.avro.specific.SpecificDatumReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;

// Referenced classes of package com.flurry.org.apache.avro.reflect:
//            ReflectData

public class ReflectDatumReader extends SpecificDatumReader
{

    public ReflectDatumReader()
    {
        this(null, null, ReflectData.get());
    }

    public ReflectDatumReader(Schema schema)
    {
        this(schema, schema, ReflectData.get());
    }

    public ReflectDatumReader(Schema schema, Schema schema1)
    {
        this(schema, schema1, ReflectData.get());
    }

    protected ReflectDatumReader(Schema schema, Schema schema1, ReflectData reflectdata)
    {
        super(schema, schema1, reflectdata);
    }

    public ReflectDatumReader(Class class1)
    {
        this(ReflectData.get().getSchema(class1));
    }

    protected void addToArray(Object obj, long l, Object obj1)
    {
        if (obj instanceof Collection)
        {
            ((Collection)obj).add(obj1);
            return;
        } else
        {
            Array.set(obj, (int)l, obj1);
            return;
        }
    }

    protected Object createString(String s)
    {
        return s;
    }

    protected Object newArray(Object obj, int i, Schema schema)
    {
        ReflectData reflectdata = ReflectData.get();
        Class class1 = ReflectData.getClassProp(schema, "java-class");
        if (class1 != null)
        {
            if (obj instanceof Collection)
            {
                ((Collection)obj).clear();
                return obj;
            }
            if (class1.isAssignableFrom(java/util/ArrayList))
            {
                return new ArrayList();
            } else
            {
                return ReflectData.newInstance(class1, schema);
            }
        }
        class1 = ReflectData.getClassProp(schema, "java-element-class");
        obj = class1;
        if (class1 == null)
        {
            obj = reflectdata.getClass(schema.getElementType());
        }
        return Array.newInstance(((Class) (obj)), i);
    }

    protected Object peekArray(Object obj)
    {
        return null;
    }

    protected Object readBytes(Object obj, Decoder decoder)
        throws IOException
    {
        obj = decoder.readBytes(null);
        decoder = new byte[((ByteBuffer) (obj)).remaining()];
        ((ByteBuffer) (obj)).get(decoder);
        return decoder;
    }

    protected Object readInt(Object obj, Schema schema, Decoder decoder)
        throws IOException
    {
        decoder = Integer.valueOf(decoder.readInt());
        schema = schema.getProp("java-class");
        if (java/lang/Byte.getName().equals(schema))
        {
            obj = Byte.valueOf(((Integer)decoder).byteValue());
        } else
        {
            obj = decoder;
            if (java/lang/Short.getName().equals(schema))
            {
                return Short.valueOf(((Integer)decoder).shortValue());
            }
        }
        return obj;
    }

    protected Object readString(Object obj, Schema schema, Decoder decoder)
        throws IOException
    {
        decoder = (String)readString(null, decoder);
        schema = ReflectData.getClassProp(schema, "java-class");
        obj = decoder;
        if (schema != null)
        {
            try
            {
                obj = schema.getConstructor(new Class[] {
                    java/lang/String
                }).newInstance(new Object[] {
                    decoder
                });
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new AvroRuntimeException(((Throwable) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new AvroRuntimeException(((Throwable) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new AvroRuntimeException(((Throwable) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new AvroRuntimeException(((Throwable) (obj)));
            }
        }
        return obj;
    }

    protected Object readString(Object obj, Decoder decoder)
        throws IOException
    {
        return super.readString(null, decoder).toString();
    }
}
