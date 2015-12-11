// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.PrettyPrinter;
import org.codehaus.jackson.util.DefaultPrettyPrinter;

// Referenced classes of package org.codehaus.jackson.impl:
//            JsonWriteContext

public abstract class JsonGeneratorBase extends JsonGenerator
{

    protected boolean _cfgNumbersAsStrings;
    protected boolean _closed;
    protected int _features;
    protected ObjectCodec _objectCodec;
    protected JsonWriteContext _writeContext;

    protected JsonGeneratorBase(int i, ObjectCodec objectcodec)
    {
        _features = i;
        _writeContext = JsonWriteContext.createRootContext();
        _objectCodec = objectcodec;
        _cfgNumbersAsStrings = isEnabled(org.codehaus.jackson.JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS);
    }

    protected void _cantHappen()
    {
        throw new RuntimeException("Internal error: should never end up through this code path");
    }

    protected abstract void _releaseBuffers();

    protected void _reportError(String s)
        throws JsonGenerationException
    {
        throw new JsonGenerationException(s);
    }

    protected abstract void _verifyValueWrite(String s)
        throws IOException, JsonGenerationException;

    protected void _writeEndArray()
        throws IOException, JsonGenerationException
    {
    }

    protected void _writeEndObject()
        throws IOException, JsonGenerationException
    {
    }

    protected void _writeSimpleObject(Object obj)
        throws IOException, JsonGenerationException
    {
        if (obj == null)
        {
            writeNull();
            return;
        }
        if (obj instanceof String)
        {
            writeString((String)obj);
            return;
        }
        if (obj instanceof Number)
        {
            Number number = (Number)obj;
            if (number instanceof Integer)
            {
                writeNumber(number.intValue());
                return;
            }
            if (number instanceof Long)
            {
                writeNumber(number.longValue());
                return;
            }
            if (number instanceof Double)
            {
                writeNumber(number.doubleValue());
                return;
            }
            if (number instanceof Float)
            {
                writeNumber(number.floatValue());
                return;
            }
            if (number instanceof Short)
            {
                writeNumber(number.shortValue());
                return;
            }
            if (number instanceof Byte)
            {
                writeNumber(number.byteValue());
                return;
            }
            if (number instanceof BigInteger)
            {
                writeNumber((BigInteger)number);
                return;
            }
            if (number instanceof BigDecimal)
            {
                writeNumber((BigDecimal)number);
                return;
            }
            if (number instanceof AtomicInteger)
            {
                writeNumber(((AtomicInteger)number).get());
                return;
            }
            if (number instanceof AtomicLong)
            {
                writeNumber(((AtomicLong)number).get());
                return;
            }
        } else
        {
            if (obj instanceof byte[])
            {
                writeBinary((byte[])(byte[])obj);
                return;
            }
            if (obj instanceof Boolean)
            {
                writeBoolean(((Boolean)obj).booleanValue());
                return;
            }
            if (obj instanceof AtomicBoolean)
            {
                writeBoolean(((AtomicBoolean)obj).get());
                return;
            }
        }
        throw new IllegalStateException((new StringBuilder()).append("No ObjectCodec defined for the generator, can only serialize simple wrapper types (type passed ").append(obj.getClass().getName()).append(")").toString());
    }

    protected void _writeStartArray()
        throws IOException, JsonGenerationException
    {
    }

    protected void _writeStartObject()
        throws IOException, JsonGenerationException
    {
    }

    public void close()
        throws IOException
    {
        _closed = true;
    }

    public final JsonWriteContext getOutputContext()
    {
        return _writeContext;
    }

    public final boolean isEnabled(org.codehaus.jackson.JsonGenerator.Feature feature)
    {
        return (_features & feature.getMask()) != 0;
    }

    public JsonGenerator useDefaultPrettyPrinter()
    {
        return setPrettyPrinter(new DefaultPrettyPrinter());
    }

    public void writeEndArray()
        throws IOException, JsonGenerationException
    {
        if (!_writeContext.inArray())
        {
            _reportError((new StringBuilder()).append("Current context not an ARRAY but ").append(_writeContext.getTypeDesc()).toString());
        }
        if (_cfgPrettyPrinter != null)
        {
            _cfgPrettyPrinter.writeEndArray(this, _writeContext.getEntryCount());
        } else
        {
            _writeEndArray();
        }
        _writeContext = _writeContext.getParent();
    }

    public void writeEndObject()
        throws IOException, JsonGenerationException
    {
        if (!_writeContext.inObject())
        {
            _reportError((new StringBuilder()).append("Current context not an object but ").append(_writeContext.getTypeDesc()).toString());
        }
        _writeContext = _writeContext.getParent();
        if (_cfgPrettyPrinter != null)
        {
            _cfgPrettyPrinter.writeEndObject(this, _writeContext.getEntryCount());
            return;
        } else
        {
            _writeEndObject();
            return;
        }
    }

    public void writeObject(Object obj)
        throws IOException, JsonProcessingException
    {
        if (obj == null)
        {
            writeNull();
            return;
        }
        if (_objectCodec != null)
        {
            _objectCodec.writeValue(this, obj);
            return;
        } else
        {
            _writeSimpleObject(obj);
            return;
        }
    }

    public void writeRawValue(String s)
        throws IOException, JsonGenerationException
    {
        _verifyValueWrite("write raw value");
        writeRaw(s);
    }

    public void writeStartArray()
        throws IOException, JsonGenerationException
    {
        _verifyValueWrite("start an array");
        _writeContext = _writeContext.createChildArrayContext();
        if (_cfgPrettyPrinter != null)
        {
            _cfgPrettyPrinter.writeStartArray(this);
            return;
        } else
        {
            _writeStartArray();
            return;
        }
    }

    public void writeStartObject()
        throws IOException, JsonGenerationException
    {
        _verifyValueWrite("start an object");
        _writeContext = _writeContext.createChildObjectContext();
        if (_cfgPrettyPrinter != null)
        {
            _cfgPrettyPrinter.writeStartObject(this);
            return;
        } else
        {
            _writeStartObject();
            return;
        }
    }
}
