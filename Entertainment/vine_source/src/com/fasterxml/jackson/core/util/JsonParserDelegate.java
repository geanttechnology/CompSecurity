// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.FormatSchema;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;

public class JsonParserDelegate extends JsonParser
{

    protected JsonParser _flddelegate;

    public JsonParserDelegate(JsonParser jsonparser)
    {
        _flddelegate = jsonparser;
    }

    public boolean canReadObjectId()
    {
        return _flddelegate.canReadObjectId();
    }

    public boolean canReadTypeId()
    {
        return _flddelegate.canReadTypeId();
    }

    public boolean canUseSchema(FormatSchema formatschema)
    {
        return _flddelegate.canUseSchema(formatschema);
    }

    public void clearCurrentToken()
    {
        _flddelegate.clearCurrentToken();
    }

    public void close()
        throws IOException
    {
        _flddelegate.close();
    }

    public JsonParser configure(com.fasterxml.jackson.core.JsonParser.Feature feature, boolean flag)
    {
        return _flddelegate.configure(feature, flag);
    }

    public JsonParser disable(com.fasterxml.jackson.core.JsonParser.Feature feature)
    {
        _flddelegate.disable(feature);
        return this;
    }

    public JsonParser enable(com.fasterxml.jackson.core.JsonParser.Feature feature)
    {
        _flddelegate.enable(feature);
        return this;
    }

    public BigInteger getBigIntegerValue()
        throws IOException, JsonParseException
    {
        return _flddelegate.getBigIntegerValue();
    }

    public byte[] getBinaryValue()
        throws IOException, JsonParseException
    {
        return _flddelegate.getBinaryValue();
    }

    public byte[] getBinaryValue(Base64Variant base64variant)
        throws IOException, JsonParseException
    {
        return _flddelegate.getBinaryValue(base64variant);
    }

    public boolean getBooleanValue()
        throws IOException, JsonParseException
    {
        return _flddelegate.getBooleanValue();
    }

    public byte getByteValue()
        throws IOException, JsonParseException
    {
        return _flddelegate.getByteValue();
    }

    public ObjectCodec getCodec()
    {
        return _flddelegate.getCodec();
    }

    public JsonLocation getCurrentLocation()
    {
        return _flddelegate.getCurrentLocation();
    }

    public String getCurrentName()
        throws IOException, JsonParseException
    {
        return _flddelegate.getCurrentName();
    }

    public JsonToken getCurrentToken()
    {
        return _flddelegate.getCurrentToken();
    }

    public int getCurrentTokenId()
    {
        return _flddelegate.getCurrentTokenId();
    }

    public BigDecimal getDecimalValue()
        throws IOException, JsonParseException
    {
        return _flddelegate.getDecimalValue();
    }

    public double getDoubleValue()
        throws IOException, JsonParseException
    {
        return _flddelegate.getDoubleValue();
    }

    public Object getEmbeddedObject()
        throws IOException, JsonParseException
    {
        return _flddelegate.getEmbeddedObject();
    }

    public int getFeatureMask()
    {
        return _flddelegate.getFeatureMask();
    }

    public float getFloatValue()
        throws IOException, JsonParseException
    {
        return _flddelegate.getFloatValue();
    }

    public Object getInputSource()
    {
        return _flddelegate.getInputSource();
    }

    public int getIntValue()
        throws IOException, JsonParseException
    {
        return _flddelegate.getIntValue();
    }

    public JsonToken getLastClearedToken()
    {
        return _flddelegate.getLastClearedToken();
    }

    public long getLongValue()
        throws IOException, JsonParseException
    {
        return _flddelegate.getLongValue();
    }

    public com.fasterxml.jackson.core.JsonParser.NumberType getNumberType()
        throws IOException, JsonParseException
    {
        return _flddelegate.getNumberType();
    }

    public Number getNumberValue()
        throws IOException, JsonParseException
    {
        return _flddelegate.getNumberValue();
    }

    public Object getObjectId()
        throws IOException, JsonGenerationException
    {
        return _flddelegate.getObjectId();
    }

    public JsonStreamContext getParsingContext()
    {
        return _flddelegate.getParsingContext();
    }

    public FormatSchema getSchema()
    {
        return _flddelegate.getSchema();
    }

    public short getShortValue()
        throws IOException, JsonParseException
    {
        return _flddelegate.getShortValue();
    }

    public String getText()
        throws IOException, JsonParseException
    {
        return _flddelegate.getText();
    }

    public char[] getTextCharacters()
        throws IOException, JsonParseException
    {
        return _flddelegate.getTextCharacters();
    }

    public int getTextLength()
        throws IOException, JsonParseException
    {
        return _flddelegate.getTextLength();
    }

    public int getTextOffset()
        throws IOException, JsonParseException
    {
        return _flddelegate.getTextOffset();
    }

    public JsonLocation getTokenLocation()
    {
        return _flddelegate.getTokenLocation();
    }

    public Object getTypeId()
        throws IOException, JsonGenerationException
    {
        return _flddelegate.getTypeId();
    }

    public boolean getValueAsBoolean()
        throws IOException, JsonParseException
    {
        return _flddelegate.getValueAsBoolean();
    }

    public boolean getValueAsBoolean(boolean flag)
        throws IOException, JsonParseException
    {
        return _flddelegate.getValueAsBoolean(flag);
    }

    public double getValueAsDouble()
        throws IOException, JsonParseException
    {
        return _flddelegate.getValueAsDouble();
    }

    public double getValueAsDouble(double d)
        throws IOException, JsonParseException
    {
        return _flddelegate.getValueAsDouble(d);
    }

    public int getValueAsInt()
        throws IOException, JsonParseException
    {
        return _flddelegate.getValueAsInt();
    }

    public int getValueAsInt(int i)
        throws IOException, JsonParseException
    {
        return _flddelegate.getValueAsInt(i);
    }

    public long getValueAsLong()
        throws IOException, JsonParseException
    {
        return _flddelegate.getValueAsLong();
    }

    public long getValueAsLong(long l)
        throws IOException, JsonParseException
    {
        return _flddelegate.getValueAsLong(l);
    }

    public String getValueAsString()
        throws IOException, JsonParseException
    {
        return _flddelegate.getValueAsString();
    }

    public String getValueAsString(String s)
        throws IOException, JsonParseException
    {
        return _flddelegate.getValueAsString(s);
    }

    public boolean hasCurrentToken()
    {
        return _flddelegate.hasCurrentToken();
    }

    public boolean hasTextCharacters()
    {
        return _flddelegate.hasTextCharacters();
    }

    public boolean isClosed()
    {
        return _flddelegate.isClosed();
    }

    public boolean isEnabled(com.fasterxml.jackson.core.JsonParser.Feature feature)
    {
        return _flddelegate.isEnabled(feature);
    }

    public boolean isExpectedStartArrayToken()
    {
        return _flddelegate.isExpectedStartArrayToken();
    }

    public Boolean nextBooleanValue()
        throws IOException, JsonParseException
    {
        return _flddelegate.nextBooleanValue();
    }

    public boolean nextFieldName(SerializableString serializablestring)
        throws IOException, JsonParseException
    {
        return _flddelegate.nextFieldName(serializablestring);
    }

    public int nextIntValue(int i)
        throws IOException, JsonParseException
    {
        return _flddelegate.nextIntValue(i);
    }

    public long nextLongValue(long l)
        throws IOException, JsonParseException
    {
        return _flddelegate.nextLongValue(l);
    }

    public String nextTextValue()
        throws IOException, JsonParseException
    {
        return _flddelegate.nextTextValue();
    }

    public JsonToken nextToken()
        throws IOException, JsonParseException
    {
        return _flddelegate.nextToken();
    }

    public JsonToken nextValue()
        throws IOException, JsonParseException
    {
        return _flddelegate.nextValue();
    }

    public void overrideCurrentName(String s)
    {
        _flddelegate.overrideCurrentName(s);
    }

    public int readBinaryValue(Base64Variant base64variant, OutputStream outputstream)
        throws IOException, JsonParseException
    {
        return _flddelegate.readBinaryValue(base64variant, outputstream);
    }

    public int readBinaryValue(OutputStream outputstream)
        throws IOException, JsonParseException
    {
        return _flddelegate.readBinaryValue(outputstream);
    }

    public Object readValueAs(TypeReference typereference)
        throws IOException, JsonProcessingException
    {
        return _flddelegate.readValueAs(typereference);
    }

    public Object readValueAs(Class class1)
        throws IOException, JsonProcessingException
    {
        return _flddelegate.readValueAs(class1);
    }

    public TreeNode readValueAsTree()
        throws IOException, JsonProcessingException
    {
        return _flddelegate.readValueAsTree();
    }

    public Iterator readValuesAs(TypeReference typereference)
        throws IOException, JsonProcessingException
    {
        return _flddelegate.readValuesAs(typereference);
    }

    public Iterator readValuesAs(Class class1)
        throws IOException, JsonProcessingException
    {
        return _flddelegate.readValuesAs(class1);
    }

    public int releaseBuffered(OutputStream outputstream)
        throws IOException
    {
        return _flddelegate.releaseBuffered(outputstream);
    }

    public int releaseBuffered(Writer writer)
        throws IOException
    {
        return _flddelegate.releaseBuffered(writer);
    }

    public boolean requiresCustomCodec()
    {
        return _flddelegate.requiresCustomCodec();
    }

    public void setCodec(ObjectCodec objectcodec)
    {
        _flddelegate.setCodec(objectcodec);
    }

    public JsonParser setFeatureMask(int i)
    {
        _flddelegate.setFeatureMask(i);
        return this;
    }

    public void setSchema(FormatSchema formatschema)
    {
        _flddelegate.setSchema(formatschema);
    }

    public JsonParser skipChildren()
        throws IOException, JsonParseException
    {
        _flddelegate.skipChildren();
        return this;
    }

    public Version version()
    {
        return _flddelegate.version();
    }
}
