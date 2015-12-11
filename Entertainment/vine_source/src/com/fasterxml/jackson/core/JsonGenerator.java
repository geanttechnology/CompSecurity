// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.util.VersionUtil;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.fasterxml.jackson.core:
//            Versioned, JsonGenerationException, JsonProcessingException, JsonParser, 
//            JsonToken, FormatSchema, Base64Variants, SerializableString, 
//            PrettyPrinter, ObjectCodec, JsonStreamContext, Version, 
//            Base64Variant, TreeNode

public abstract class JsonGenerator
    implements Closeable, Flushable, Versioned
{
    public static final class Feature extends Enum
    {

        private static final Feature $VALUES[];
        public static final Feature AUTO_CLOSE_JSON_CONTENT;
        public static final Feature AUTO_CLOSE_TARGET;
        public static final Feature ESCAPE_NON_ASCII;
        public static final Feature FLUSH_PASSED_TO_STREAM;
        public static final Feature QUOTE_FIELD_NAMES;
        public static final Feature QUOTE_NON_NUMERIC_NUMBERS;
        public static final Feature STRICT_DUPLICATE_DETECTION;
        public static final Feature WRITE_BIGDECIMAL_AS_PLAIN;
        public static final Feature WRITE_NUMBERS_AS_STRINGS;
        private final boolean _defaultState;
        private final int _mask = 1 << ordinal();

        public static int collectDefaults()
        {
            int j = 0;
            Feature afeature[] = values();
            int l = afeature.length;
            for (int i = 0; i < l;)
            {
                Feature feature = afeature[i];
                int k = j;
                if (feature.enabledByDefault())
                {
                    k = j | feature.getMask();
                }
                i++;
                j = k;
            }

            return j;
        }

        public static Feature valueOf(String s)
        {
            return (Feature)Enum.valueOf(com/fasterxml/jackson/core/JsonGenerator$Feature, s);
        }

        public static Feature[] values()
        {
            return (Feature[])$VALUES.clone();
        }

        public boolean enabledByDefault()
        {
            return _defaultState;
        }

        public boolean enabledIn(int i)
        {
            return (_mask & i) != 0;
        }

        public int getMask()
        {
            return _mask;
        }

        static 
        {
            AUTO_CLOSE_TARGET = new Feature("AUTO_CLOSE_TARGET", 0, true);
            AUTO_CLOSE_JSON_CONTENT = new Feature("AUTO_CLOSE_JSON_CONTENT", 1, true);
            QUOTE_FIELD_NAMES = new Feature("QUOTE_FIELD_NAMES", 2, true);
            QUOTE_NON_NUMERIC_NUMBERS = new Feature("QUOTE_NON_NUMERIC_NUMBERS", 3, true);
            WRITE_NUMBERS_AS_STRINGS = new Feature("WRITE_NUMBERS_AS_STRINGS", 4, false);
            WRITE_BIGDECIMAL_AS_PLAIN = new Feature("WRITE_BIGDECIMAL_AS_PLAIN", 5, false);
            FLUSH_PASSED_TO_STREAM = new Feature("FLUSH_PASSED_TO_STREAM", 6, true);
            ESCAPE_NON_ASCII = new Feature("ESCAPE_NON_ASCII", 7, false);
            STRICT_DUPLICATE_DETECTION = new Feature("STRICT_DUPLICATE_DETECTION", 8, false);
            $VALUES = (new Feature[] {
                AUTO_CLOSE_TARGET, AUTO_CLOSE_JSON_CONTENT, QUOTE_FIELD_NAMES, QUOTE_NON_NUMERIC_NUMBERS, WRITE_NUMBERS_AS_STRINGS, WRITE_BIGDECIMAL_AS_PLAIN, FLUSH_PASSED_TO_STREAM, ESCAPE_NON_ASCII, STRICT_DUPLICATE_DETECTION
            });
        }

        private Feature(String s, int i, boolean flag)
        {
            super(s, i);
            _defaultState = flag;
        }
    }


    protected PrettyPrinter _cfgPrettyPrinter;

    protected JsonGenerator()
    {
    }

    protected void _reportError(String s)
        throws JsonGenerationException
    {
        throw new JsonGenerationException(s);
    }

    protected void _reportUnsupportedOperation()
    {
        throw new UnsupportedOperationException((new StringBuilder()).append("Operation not supported by generator of type ").append(getClass().getName()).toString());
    }

    protected final void _throwInternal()
    {
        VersionUtil.throwInternal();
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

    public boolean canOmitFields()
    {
        return true;
    }

    public boolean canUseSchema(FormatSchema formatschema)
    {
        return false;
    }

    public boolean canWriteBinaryNatively()
    {
        return false;
    }

    public boolean canWriteObjectId()
    {
        return false;
    }

    public boolean canWriteTypeId()
    {
        return false;
    }

    public abstract void close()
        throws IOException;

    public final JsonGenerator configure(Feature feature, boolean flag)
    {
        if (flag)
        {
            enable(feature);
            return this;
        } else
        {
            disable(feature);
            return this;
        }
    }

    public void copyCurrentEvent(JsonParser jsonparser)
        throws IOException, JsonProcessingException
    {
        JsonToken jsontoken = jsonparser.getCurrentToken();
        if (jsontoken == null)
        {
            _reportError("No current event to copy");
        }
        switch (jsontoken.id())
        {
        case 0: // '\0'
        default:
            _throwInternal();
            return;

        case -1: 
            _reportError("No current event to copy");
            // fall through

        case 1: // '\001'
            writeStartObject();
            return;

        case 2: // '\002'
            writeEndObject();
            return;

        case 3: // '\003'
            writeStartArray();
            return;

        case 4: // '\004'
            writeEndArray();
            return;

        case 5: // '\005'
            writeFieldName(jsonparser.getCurrentName());
            return;

        case 6: // '\006'
            if (jsonparser.hasTextCharacters())
            {
                writeString(jsonparser.getTextCharacters(), jsonparser.getTextOffset(), jsonparser.getTextLength());
                return;
            } else
            {
                writeString(jsonparser.getText());
                return;
            }

        case 7: // '\007'
            JsonParser.NumberType numbertype = jsonparser.getNumberType();
            if (numbertype == JsonParser.NumberType.INT)
            {
                writeNumber(jsonparser.getIntValue());
                return;
            }
            if (numbertype == JsonParser.NumberType.BIG_INTEGER)
            {
                writeNumber(jsonparser.getBigIntegerValue());
                return;
            } else
            {
                writeNumber(jsonparser.getLongValue());
                return;
            }

        case 8: // '\b'
            JsonParser.NumberType numbertype1 = jsonparser.getNumberType();
            if (numbertype1 == JsonParser.NumberType.BIG_DECIMAL)
            {
                writeNumber(jsonparser.getDecimalValue());
                return;
            }
            if (numbertype1 == JsonParser.NumberType.FLOAT)
            {
                writeNumber(jsonparser.getFloatValue());
                return;
            } else
            {
                writeNumber(jsonparser.getDoubleValue());
                return;
            }

        case 9: // '\t'
            writeBoolean(true);
            return;

        case 10: // '\n'
            writeBoolean(false);
            return;

        case 11: // '\013'
            writeNull();
            return;

        case 12: // '\f'
            writeObject(jsonparser.getEmbeddedObject());
            return;
        }
    }

    public void copyCurrentStructure(JsonParser jsonparser)
        throws IOException, JsonProcessingException
    {
        JsonToken jsontoken = jsonparser.getCurrentToken();
        if (jsontoken == null)
        {
            _reportError("No current event to copy");
        }
        int j = jsontoken.id();
        int i = j;
        if (j == 5)
        {
            writeFieldName(jsonparser.getCurrentName());
            i = jsonparser.nextToken().id();
        }
        switch (i)
        {
        case 2: // '\002'
        default:
            copyCurrentEvent(jsonparser);
            return;

        case 1: // '\001'
            writeStartObject();
            for (; jsonparser.nextToken() != JsonToken.END_OBJECT; copyCurrentStructure(jsonparser)) { }
            writeEndObject();
            return;

        case 3: // '\003'
            writeStartArray();
            break;
        }
        for (; jsonparser.nextToken() != JsonToken.END_ARRAY; copyCurrentStructure(jsonparser)) { }
        writeEndArray();
    }

    public abstract JsonGenerator disable(Feature feature);

    public abstract JsonGenerator enable(Feature feature);

    public abstract void flush()
        throws IOException;

    public CharacterEscapes getCharacterEscapes()
    {
        return null;
    }

    public abstract ObjectCodec getCodec();

    public abstract int getFeatureMask();

    public int getHighestEscapedChar()
    {
        return 0;
    }

    public abstract JsonStreamContext getOutputContext();

    public Object getOutputTarget()
    {
        return null;
    }

    public PrettyPrinter getPrettyPrinter()
    {
        return _cfgPrettyPrinter;
    }

    public FormatSchema getSchema()
    {
        return null;
    }

    public abstract boolean isClosed();

    public abstract boolean isEnabled(Feature feature);

    public JsonGenerator setCharacterEscapes(CharacterEscapes characterescapes)
    {
        return this;
    }

    public abstract JsonGenerator setCodec(ObjectCodec objectcodec);

    public abstract JsonGenerator setFeatureMask(int i);

    public JsonGenerator setHighestNonEscapedChar(int i)
    {
        return this;
    }

    public JsonGenerator setPrettyPrinter(PrettyPrinter prettyprinter)
    {
        _cfgPrettyPrinter = prettyprinter;
        return this;
    }

    public JsonGenerator setRootValueSeparator(SerializableString serializablestring)
    {
        throw new UnsupportedOperationException();
    }

    public void setSchema(FormatSchema formatschema)
    {
        throw new UnsupportedOperationException((new StringBuilder()).append("Generator of type ").append(getClass().getName()).append(" does not support schema of type '").append(formatschema.getSchemaType()).append("'").toString());
    }

    public abstract JsonGenerator useDefaultPrettyPrinter();

    public abstract Version version();

    public final void writeArrayFieldStart(String s)
        throws IOException, JsonGenerationException
    {
        writeFieldName(s);
        writeStartArray();
    }

    public abstract int writeBinary(Base64Variant base64variant, InputStream inputstream, int i)
        throws IOException, JsonGenerationException;

    public int writeBinary(InputStream inputstream, int i)
        throws IOException, JsonGenerationException
    {
        return writeBinary(Base64Variants.getDefaultVariant(), inputstream, i);
    }

    public abstract void writeBinary(Base64Variant base64variant, byte abyte0[], int i, int j)
        throws IOException, JsonGenerationException;

    public void writeBinary(byte abyte0[])
        throws IOException, JsonGenerationException
    {
        writeBinary(Base64Variants.getDefaultVariant(), abyte0, 0, abyte0.length);
    }

    public void writeBinary(byte abyte0[], int i, int j)
        throws IOException, JsonGenerationException
    {
        writeBinary(Base64Variants.getDefaultVariant(), abyte0, i, j);
    }

    public final void writeBinaryField(String s, byte abyte0[])
        throws IOException, JsonGenerationException
    {
        writeFieldName(s);
        writeBinary(abyte0);
    }

    public abstract void writeBoolean(boolean flag)
        throws IOException, JsonGenerationException;

    public final void writeBooleanField(String s, boolean flag)
        throws IOException, JsonGenerationException
    {
        writeFieldName(s);
        writeBoolean(flag);
    }

    public abstract void writeEndArray()
        throws IOException, JsonGenerationException;

    public abstract void writeEndObject()
        throws IOException, JsonGenerationException;

    public abstract void writeFieldName(SerializableString serializablestring)
        throws IOException, JsonGenerationException;

    public abstract void writeFieldName(String s)
        throws IOException, JsonGenerationException;

    public abstract void writeNull()
        throws IOException, JsonGenerationException;

    public final void writeNullField(String s)
        throws IOException, JsonGenerationException
    {
        writeFieldName(s);
        writeNull();
    }

    public abstract void writeNumber(double d)
        throws IOException, JsonGenerationException;

    public abstract void writeNumber(float f)
        throws IOException, JsonGenerationException;

    public abstract void writeNumber(int i)
        throws IOException, JsonGenerationException;

    public abstract void writeNumber(long l)
        throws IOException, JsonGenerationException;

    public abstract void writeNumber(String s)
        throws IOException, JsonGenerationException, UnsupportedOperationException;

    public abstract void writeNumber(BigDecimal bigdecimal)
        throws IOException, JsonGenerationException;

    public abstract void writeNumber(BigInteger biginteger)
        throws IOException, JsonGenerationException;

    public void writeNumber(short word0)
        throws IOException, JsonGenerationException
    {
        writeNumber(word0);
    }

    public final void writeNumberField(String s, double d)
        throws IOException, JsonGenerationException
    {
        writeFieldName(s);
        writeNumber(d);
    }

    public final void writeNumberField(String s, float f)
        throws IOException, JsonGenerationException
    {
        writeFieldName(s);
        writeNumber(f);
    }

    public final void writeNumberField(String s, int i)
        throws IOException, JsonGenerationException
    {
        writeFieldName(s);
        writeNumber(i);
    }

    public final void writeNumberField(String s, long l)
        throws IOException, JsonGenerationException
    {
        writeFieldName(s);
        writeNumber(l);
    }

    public final void writeNumberField(String s, BigDecimal bigdecimal)
        throws IOException, JsonGenerationException
    {
        writeFieldName(s);
        writeNumber(bigdecimal);
    }

    public abstract void writeObject(Object obj)
        throws IOException, JsonProcessingException;

    public final void writeObjectField(String s, Object obj)
        throws IOException, JsonProcessingException
    {
        writeFieldName(s);
        writeObject(obj);
    }

    public final void writeObjectFieldStart(String s)
        throws IOException, JsonGenerationException
    {
        writeFieldName(s);
        writeStartObject();
    }

    public void writeObjectId(Object obj)
        throws IOException, JsonGenerationException
    {
        throw new JsonGenerationException("No native support for writing Object Ids");
    }

    public void writeObjectRef(Object obj)
        throws IOException, JsonGenerationException
    {
        throw new JsonGenerationException("No native support for writing Object Ids");
    }

    public void writeOmittedField(String s)
        throws IOException, JsonGenerationException
    {
    }

    public abstract void writeRaw(char c)
        throws IOException, JsonGenerationException;

    public void writeRaw(SerializableString serializablestring)
        throws IOException, JsonGenerationException
    {
        writeRaw(serializablestring.getValue());
    }

    public abstract void writeRaw(String s)
        throws IOException, JsonGenerationException;

    public abstract void writeRaw(String s, int i, int j)
        throws IOException, JsonGenerationException;

    public abstract void writeRaw(char ac[], int i, int j)
        throws IOException, JsonGenerationException;

    public abstract void writeRawUTF8String(byte abyte0[], int i, int j)
        throws IOException, JsonGenerationException;

    public abstract void writeRawValue(String s)
        throws IOException, JsonGenerationException;

    public abstract void writeRawValue(String s, int i, int j)
        throws IOException, JsonGenerationException;

    public abstract void writeRawValue(char ac[], int i, int j)
        throws IOException, JsonGenerationException;

    public abstract void writeStartArray()
        throws IOException, JsonGenerationException;

    public abstract void writeStartObject()
        throws IOException, JsonGenerationException;

    public abstract void writeString(SerializableString serializablestring)
        throws IOException, JsonGenerationException;

    public abstract void writeString(String s)
        throws IOException, JsonGenerationException;

    public abstract void writeString(char ac[], int i, int j)
        throws IOException, JsonGenerationException;

    public void writeStringField(String s, String s1)
        throws IOException, JsonGenerationException
    {
        writeFieldName(s);
        writeString(s1);
    }

    public abstract void writeTree(TreeNode treenode)
        throws IOException, JsonProcessingException;

    public void writeTypeId(Object obj)
        throws IOException, JsonGenerationException
    {
        throw new JsonGenerationException("No native support for writing Type Ids");
    }

    public abstract void writeUTF8String(byte abyte0[], int i, int j)
        throws IOException, JsonGenerationException;
}
