// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.FormatSchema;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.io.SegmentedStringWriter;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;

// Referenced classes of package com.fasterxml.jackson.databind:
//            ObjectMapper, SerializationFeature, SerializationConfig, JsonMappingException, 
//            JsonSerializer, JavaType

public class ObjectWriter
    implements Serializable
{

    protected static final PrettyPrinter NULL_PRETTY_PRINTER = new MinimalPrettyPrinter();
    protected final SerializationConfig _config;
    protected final JsonFactory _jsonFactory;
    protected final PrettyPrinter _prettyPrinter;
    protected final JsonSerializer _rootSerializer;
    protected final JavaType _rootType;
    protected final FormatSchema _schema = null;
    protected final SerializerFactory _serializerFactory;
    protected final DefaultSerializerProvider _serializerProvider;

    protected ObjectWriter(ObjectMapper objectmapper, SerializationConfig serializationconfig, JavaType javatype, PrettyPrinter prettyprinter)
    {
        _config = serializationconfig;
        _serializerProvider = objectmapper._serializerProvider;
        _serializerFactory = objectmapper._serializerFactory;
        _jsonFactory = objectmapper._jsonFactory;
        _rootType = javatype;
        _prettyPrinter = prettyprinter;
        _rootSerializer = _prefetchRootSerializer(serializationconfig, javatype);
    }

    private final void _configureJsonGenerator(JsonGenerator jsongenerator)
    {
        if (_prettyPrinter == null) goto _L2; else goto _L1
_L1:
        PrettyPrinter prettyprinter1 = _prettyPrinter;
        if (prettyprinter1 == NULL_PRETTY_PRINTER)
        {
            jsongenerator.setPrettyPrinter(null);
        } else
        {
            PrettyPrinter prettyprinter = prettyprinter1;
            if (prettyprinter1 instanceof Instantiatable)
            {
                prettyprinter = (PrettyPrinter)((Instantiatable)prettyprinter1).createInstance();
            }
            jsongenerator.setPrettyPrinter(prettyprinter);
        }
_L4:
        if (_schema != null)
        {
            jsongenerator.setSchema(_schema);
        }
        return;
_L2:
        if (_config.isEnabled(SerializationFeature.INDENT_OUTPUT))
        {
            jsongenerator.useDefaultPrettyPrinter();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private final void _writeCloseable(JsonGenerator jsongenerator, Object obj, SerializationConfig serializationconfig)
        throws IOException, JsonGenerationException, JsonMappingException
    {
        Closeable closeable;
        Object obj1;
        Closeable closeable1;
        closeable1 = (Closeable)obj;
        closeable = closeable1;
        obj1 = jsongenerator;
        if (_rootType != null) goto _L2; else goto _L1
_L1:
        closeable = closeable1;
        obj1 = jsongenerator;
        _serializerProvider(serializationconfig).serializeValue(jsongenerator, obj);
_L4:
        obj = null;
        closeable = closeable1;
        obj1 = obj;
        jsongenerator.close();
        closeable = null;
        obj1 = obj;
        closeable1.close();
        if (false)
        {
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (JsonGenerator jsongenerator) { }
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        throw new NullPointerException();
        return;
_L2:
        closeable = closeable1;
        obj1 = jsongenerator;
        _serializerProvider(serializationconfig).serializeValue(jsongenerator, obj, _rootType, _rootSerializer);
        if (true) goto _L4; else goto _L3
_L3:
        jsongenerator;
        if (obj1 != null)
        {
            try
            {
                ((JsonGenerator) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        if (closeable != null)
        {
            try
            {
                closeable.close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        throw jsongenerator;
        jsongenerator;
    }

    protected final void _configAndWriteValue(JsonGenerator jsongenerator, Object obj)
        throws IOException, JsonGenerationException, JsonMappingException
    {
        _configureJsonGenerator(jsongenerator);
        if (!_config.isEnabled(SerializationFeature.CLOSE_CLOSEABLE) || !(obj instanceof Closeable)) goto _L2; else goto _L1
_L1:
        _writeCloseable(jsongenerator, obj, _config);
_L8:
        return;
_L2:
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (_rootType != null) goto _L4; else goto _L3
_L3:
        flag = flag1;
        _serializerProvider(_config).serializeValue(jsongenerator, obj);
_L6:
        flag = true;
        jsongenerator.close();
        if (false)
        {
            try
            {
                jsongenerator.close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (JsonGenerator jsongenerator)
            {
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        flag = flag1;
        _serializerProvider(_config).serializeValue(jsongenerator, obj, _rootType, _rootSerializer);
        if (true) goto _L6; else goto _L5
_L5:
        obj;
        if (!flag)
        {
            try
            {
                jsongenerator.close();
            }
            // Misplaced declaration of an exception variable
            catch (JsonGenerator jsongenerator) { }
        }
        throw obj;
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected final JsonSerializer _prefetchRootSerializer(SerializationConfig serializationconfig, JavaType javatype)
    {
        if (javatype == null || !_config.isEnabled(SerializationFeature.EAGER_SERIALIZER_FETCH))
        {
            return null;
        }
        try
        {
            serializationconfig = _serializerProvider(serializationconfig).findTypedValueSerializer(javatype, true, null);
        }
        // Misplaced declaration of an exception variable
        catch (SerializationConfig serializationconfig)
        {
            return null;
        }
        return serializationconfig;
    }

    protected DefaultSerializerProvider _serializerProvider(SerializationConfig serializationconfig)
    {
        return _serializerProvider.createInstance(serializationconfig, _serializerFactory);
    }

    public String writeValueAsString(Object obj)
        throws JsonProcessingException
    {
        SegmentedStringWriter segmentedstringwriter = new SegmentedStringWriter(_jsonFactory._getBufferRecycler());
        try
        {
            _configAndWriteValue(_jsonFactory.createJsonGenerator(segmentedstringwriter), obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw JsonMappingException.fromUnexpectedIOE(((IOException) (obj)));
        }
        return segmentedstringwriter.getAndClear();
    }

}
