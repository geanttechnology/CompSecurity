// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson;

import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.io.CharacterEscapes;
import org.codehaus.jackson.io.SerializedString;

// Referenced classes of package org.codehaus.jackson:
//            JsonGenerationException, Base64Variants, SerializableString, JsonProcessingException, 
//            PrettyPrinter, Base64Variant

public abstract class JsonGenerator
    implements Closeable
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
        public static final Feature WRITE_NUMBERS_AS_STRINGS;
        final boolean _defaultState;
        final int _mask = 1 << ordinal();

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
            return (Feature)Enum.valueOf(org/codehaus/jackson/JsonGenerator$Feature, s);
        }

        public static Feature[] values()
        {
            return (Feature[])$VALUES.clone();
        }

        public boolean enabledByDefault()
        {
            return _defaultState;
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
            FLUSH_PASSED_TO_STREAM = new Feature("FLUSH_PASSED_TO_STREAM", 5, true);
            ESCAPE_NON_ASCII = new Feature("ESCAPE_NON_ASCII", 6, false);
            $VALUES = (new Feature[] {
                AUTO_CLOSE_TARGET, AUTO_CLOSE_JSON_CONTENT, QUOTE_FIELD_NAMES, QUOTE_NON_NUMERIC_NUMBERS, WRITE_NUMBERS_AS_STRINGS, FLUSH_PASSED_TO_STREAM, ESCAPE_NON_ASCII
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

    public abstract void close()
        throws IOException;

    public abstract void flush()
        throws IOException;

    public JsonGenerator setCharacterEscapes(CharacterEscapes characterescapes)
    {
        return this;
    }

    public JsonGenerator setHighestNonEscapedChar(int i)
    {
        return this;
    }

    public JsonGenerator setPrettyPrinter(PrettyPrinter prettyprinter)
    {
        _cfgPrettyPrinter = prettyprinter;
        return this;
    }

    public abstract JsonGenerator useDefaultPrettyPrinter();

    public final void writeArrayFieldStart(String s)
        throws IOException, JsonGenerationException
    {
        writeFieldName(s);
        writeStartArray();
    }

    public abstract void writeBinary(Base64Variant base64variant, byte abyte0[], int i, int j)
        throws IOException, JsonGenerationException;

    public void writeBinary(byte abyte0[])
        throws IOException, JsonGenerationException
    {
        writeBinary(Base64Variants.getDefaultVariant(), abyte0, 0, abyte0.length);
    }

    public abstract void writeBoolean(boolean flag)
        throws IOException, JsonGenerationException;

    public abstract void writeEndArray()
        throws IOException, JsonGenerationException;

    public abstract void writeEndObject()
        throws IOException, JsonGenerationException;

    public abstract void writeFieldName(String s)
        throws IOException, JsonGenerationException;

    public void writeFieldName(SerializableString serializablestring)
        throws IOException, JsonGenerationException
    {
        writeFieldName(serializablestring.getValue());
    }

    public void writeFieldName(SerializedString serializedstring)
        throws IOException, JsonGenerationException
    {
        writeFieldName(serializedstring.getValue());
    }

    public abstract void writeNull()
        throws IOException, JsonGenerationException;

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

    public abstract void writeObject(Object obj)
        throws IOException, JsonProcessingException;

    public final void writeObjectFieldStart(String s)
        throws IOException, JsonGenerationException
    {
        writeFieldName(s);
        writeStartObject();
    }

    public abstract void writeRaw(char c)
        throws IOException, JsonGenerationException;

    public abstract void writeRaw(String s)
        throws IOException, JsonGenerationException;

    public abstract void writeRaw(char ac[], int i, int j)
        throws IOException, JsonGenerationException;

    public abstract void writeRawValue(String s)
        throws IOException, JsonGenerationException;

    public abstract void writeStartArray()
        throws IOException, JsonGenerationException;

    public abstract void writeStartObject()
        throws IOException, JsonGenerationException;

    public abstract void writeString(String s)
        throws IOException, JsonGenerationException;

    public void writeString(SerializableString serializablestring)
        throws IOException, JsonGenerationException
    {
        writeString(serializablestring.getValue());
    }

    public abstract void writeString(char ac[], int i, int j)
        throws IOException, JsonGenerationException;

    public void writeStringField(String s, String s1)
        throws IOException, JsonGenerationException
    {
        writeFieldName(s);
        writeString(s1);
    }
}
