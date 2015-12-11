// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.org.codehaus.jackson.util;

import com.amazon.org.codehaus.jackson.Base64Variant;
import com.amazon.org.codehaus.jackson.FormatSchema;
import com.amazon.org.codehaus.jackson.JsonGenerationException;
import com.amazon.org.codehaus.jackson.JsonGenerator;
import com.amazon.org.codehaus.jackson.JsonNode;
import com.amazon.org.codehaus.jackson.JsonParser;
import com.amazon.org.codehaus.jackson.JsonProcessingException;
import com.amazon.org.codehaus.jackson.JsonStreamContext;
import com.amazon.org.codehaus.jackson.ObjectCodec;
import com.amazon.org.codehaus.jackson.SerializableString;
import com.amazon.org.codehaus.jackson.Version;
import com.amazon.org.codehaus.jackson.io.SerializedString;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class JsonGeneratorDelegate extends JsonGenerator
{

    protected JsonGenerator _flddelegate;

    public JsonGeneratorDelegate(JsonGenerator jsongenerator)
    {
        _flddelegate = jsongenerator;
    }

    public boolean canUseSchema(FormatSchema formatschema)
    {
        return _flddelegate.canUseSchema(formatschema);
    }

    public void close()
        throws IOException
    {
        _flddelegate.close();
    }

    public void copyCurrentEvent(JsonParser jsonparser)
        throws IOException, JsonProcessingException
    {
        _flddelegate.copyCurrentEvent(jsonparser);
    }

    public void copyCurrentStructure(JsonParser jsonparser)
        throws IOException, JsonProcessingException
    {
        _flddelegate.copyCurrentStructure(jsonparser);
    }

    public JsonGenerator disable(com.amazon.org.codehaus.jackson.JsonGenerator.Feature feature)
    {
        return _flddelegate.disable(feature);
    }

    public JsonGenerator enable(com.amazon.org.codehaus.jackson.JsonGenerator.Feature feature)
    {
        return _flddelegate.enable(feature);
    }

    public void flush()
        throws IOException
    {
        _flddelegate.flush();
    }

    public ObjectCodec getCodec()
    {
        return _flddelegate.getCodec();
    }

    public JsonStreamContext getOutputContext()
    {
        return _flddelegate.getOutputContext();
    }

    public Object getOutputTarget()
    {
        return _flddelegate.getOutputTarget();
    }

    public boolean isClosed()
    {
        return _flddelegate.isClosed();
    }

    public boolean isEnabled(com.amazon.org.codehaus.jackson.JsonGenerator.Feature feature)
    {
        return _flddelegate.isEnabled(feature);
    }

    public JsonGenerator setCodec(ObjectCodec objectcodec)
    {
        _flddelegate.setCodec(objectcodec);
        return this;
    }

    public void setSchema(FormatSchema formatschema)
    {
        _flddelegate.setSchema(formatschema);
    }

    public JsonGenerator useDefaultPrettyPrinter()
    {
        _flddelegate.useDefaultPrettyPrinter();
        return this;
    }

    public Version version()
    {
        return _flddelegate.version();
    }

    public void writeBinary(Base64Variant base64variant, byte abyte0[], int i, int j)
        throws IOException, JsonGenerationException
    {
        _flddelegate.writeBinary(base64variant, abyte0, i, j);
    }

    public void writeBoolean(boolean flag)
        throws IOException, JsonGenerationException
    {
        _flddelegate.writeBoolean(flag);
    }

    public void writeEndArray()
        throws IOException, JsonGenerationException
    {
        _flddelegate.writeEndArray();
    }

    public void writeEndObject()
        throws IOException, JsonGenerationException
    {
        _flddelegate.writeEndObject();
    }

    public void writeFieldName(SerializableString serializablestring)
        throws IOException, JsonGenerationException
    {
        _flddelegate.writeFieldName(serializablestring);
    }

    public void writeFieldName(SerializedString serializedstring)
        throws IOException, JsonGenerationException
    {
        _flddelegate.writeFieldName(serializedstring);
    }

    public void writeFieldName(String s)
        throws IOException, JsonGenerationException
    {
        _flddelegate.writeFieldName(s);
    }

    public void writeNull()
        throws IOException, JsonGenerationException
    {
        _flddelegate.writeNull();
    }

    public void writeNumber(double d)
        throws IOException, JsonGenerationException
    {
        _flddelegate.writeNumber(d);
    }

    public void writeNumber(float f)
        throws IOException, JsonGenerationException
    {
        _flddelegate.writeNumber(f);
    }

    public void writeNumber(int i)
        throws IOException, JsonGenerationException
    {
        _flddelegate.writeNumber(i);
    }

    public void writeNumber(long l)
        throws IOException, JsonGenerationException
    {
        _flddelegate.writeNumber(l);
    }

    public void writeNumber(String s)
        throws IOException, JsonGenerationException, UnsupportedOperationException
    {
        _flddelegate.writeNumber(s);
    }

    public void writeNumber(BigDecimal bigdecimal)
        throws IOException, JsonGenerationException
    {
        _flddelegate.writeNumber(bigdecimal);
    }

    public void writeNumber(BigInteger biginteger)
        throws IOException, JsonGenerationException
    {
        _flddelegate.writeNumber(biginteger);
    }

    public void writeObject(Object obj)
        throws IOException, JsonProcessingException
    {
        _flddelegate.writeObject(obj);
    }

    public void writeRaw(char c)
        throws IOException, JsonGenerationException
    {
        _flddelegate.writeRaw(c);
    }

    public void writeRaw(String s)
        throws IOException, JsonGenerationException
    {
        _flddelegate.writeRaw(s);
    }

    public void writeRaw(String s, int i, int j)
        throws IOException, JsonGenerationException
    {
        _flddelegate.writeRaw(s, i, j);
    }

    public void writeRaw(char ac[], int i, int j)
        throws IOException, JsonGenerationException
    {
        _flddelegate.writeRaw(ac, i, j);
    }

    public void writeRawUTF8String(byte abyte0[], int i, int j)
        throws IOException, JsonGenerationException
    {
        _flddelegate.writeRawUTF8String(abyte0, i, j);
    }

    public void writeRawValue(String s)
        throws IOException, JsonGenerationException
    {
        _flddelegate.writeRawValue(s);
    }

    public void writeRawValue(String s, int i, int j)
        throws IOException, JsonGenerationException
    {
        _flddelegate.writeRawValue(s, i, j);
    }

    public void writeRawValue(char ac[], int i, int j)
        throws IOException, JsonGenerationException
    {
        _flddelegate.writeRawValue(ac, i, j);
    }

    public void writeStartArray()
        throws IOException, JsonGenerationException
    {
        _flddelegate.writeStartArray();
    }

    public void writeStartObject()
        throws IOException, JsonGenerationException
    {
        _flddelegate.writeStartObject();
    }

    public void writeString(SerializableString serializablestring)
        throws IOException, JsonGenerationException
    {
        _flddelegate.writeString(serializablestring);
    }

    public void writeString(String s)
        throws IOException, JsonGenerationException
    {
        _flddelegate.writeString(s);
    }

    public void writeString(char ac[], int i, int j)
        throws IOException, JsonGenerationException
    {
        _flddelegate.writeString(ac, i, j);
    }

    public void writeTree(JsonNode jsonnode)
        throws IOException, JsonProcessingException
    {
        _flddelegate.writeTree(jsonnode);
    }

    public void writeUTF8String(byte abyte0[], int i, int j)
        throws IOException, JsonGenerationException
    {
        _flddelegate.writeUTF8String(abyte0, i, j);
    }
}
