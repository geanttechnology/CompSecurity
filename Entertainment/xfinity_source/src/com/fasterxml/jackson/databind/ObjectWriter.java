// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.FormatSchema;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.Versioned;
import com.fasterxml.jackson.core.io.SegmentedStringWriter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fasterxml.jackson.databind.cfg.DatabindVersion;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

// Referenced classes of package com.fasterxml.jackson.databind:
//            ObjectMapper, SerializationFeature, SerializationConfig, JsonMappingException, 
//            JsonSerializer, JavaType, MapperFeature

public class ObjectWriter
    implements Versioned, Serializable
{

    protected static final PrettyPrinter NULL_PRETTY_PRINTER = new MinimalPrettyPrinter();
    private static final long serialVersionUID = 0x9e82ca574efec4f4L;
    protected final SerializationConfig _config;
    protected final JsonFactory _jsonFactory;
    protected final PrettyPrinter _prettyPrinter;
    protected final JsonSerializer _rootSerializer;
    protected final JavaType _rootType;
    protected final FormatSchema _schema;
    protected final SerializerFactory _serializerFactory;
    protected final DefaultSerializerProvider _serializerProvider;

    protected ObjectWriter(ObjectMapper objectmapper, SerializationConfig serializationconfig)
    {
        _config = serializationconfig;
        _serializerProvider = objectmapper._serializerProvider;
        _serializerFactory = objectmapper._serializerFactory;
        _jsonFactory = objectmapper._jsonFactory;
        _rootType = null;
        _rootSerializer = null;
        _prettyPrinter = null;
        _schema = null;
    }

    protected ObjectWriter(ObjectMapper objectmapper, SerializationConfig serializationconfig, FormatSchema formatschema)
    {
        _config = serializationconfig;
        _serializerProvider = objectmapper._serializerProvider;
        _serializerFactory = objectmapper._serializerFactory;
        _jsonFactory = objectmapper._jsonFactory;
        _rootType = null;
        _rootSerializer = null;
        _prettyPrinter = null;
        _schema = formatschema;
    }

    protected ObjectWriter(ObjectMapper objectmapper, SerializationConfig serializationconfig, JavaType javatype, PrettyPrinter prettyprinter)
    {
        _config = serializationconfig;
        _serializerProvider = objectmapper._serializerProvider;
        _serializerFactory = objectmapper._serializerFactory;
        _jsonFactory = objectmapper._jsonFactory;
        _rootType = javatype;
        _prettyPrinter = prettyprinter;
        _schema = null;
        _rootSerializer = _prefetchRootSerializer(serializationconfig, javatype);
    }

    protected ObjectWriter(ObjectWriter objectwriter, SerializationConfig serializationconfig)
    {
        _config = serializationconfig;
        _serializerProvider = objectwriter._serializerProvider;
        _serializerFactory = objectwriter._serializerFactory;
        _jsonFactory = objectwriter._jsonFactory;
        _schema = objectwriter._schema;
        _rootType = objectwriter._rootType;
        _rootSerializer = objectwriter._rootSerializer;
        _prettyPrinter = objectwriter._prettyPrinter;
    }

    protected ObjectWriter(ObjectWriter objectwriter, SerializationConfig serializationconfig, JavaType javatype, JsonSerializer jsonserializer, PrettyPrinter prettyprinter, FormatSchema formatschema)
    {
        _config = serializationconfig;
        _serializerProvider = objectwriter._serializerProvider;
        _serializerFactory = objectwriter._serializerFactory;
        _jsonFactory = objectwriter._jsonFactory;
        _rootType = javatype;
        _rootSerializer = jsonserializer;
        _prettyPrinter = prettyprinter;
        _schema = formatschema;
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

    private final void _writeCloseableValue(JsonGenerator jsongenerator, Object obj, SerializationConfig serializationconfig)
        throws IOException, JsonGenerationException, JsonMappingException
    {
        Closeable closeable;
        Closeable closeable1;
        closeable1 = (Closeable)obj;
        closeable = closeable1;
        if (_rootType != null) goto _L2; else goto _L1
_L1:
        closeable = closeable1;
        _serializerProvider(serializationconfig).serializeValue(jsongenerator, obj);
_L4:
        closeable = closeable1;
        if (!_config.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE))
        {
            break MISSING_BLOCK_LABEL_56;
        }
        closeable = closeable1;
        jsongenerator.flush();
        closeable = null;
        closeable1.close();
        if (true)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        throw new NullPointerException();
        return;
_L2:
        closeable = closeable1;
        _serializerProvider(serializationconfig).serializeValue(jsongenerator, obj, _rootType, _rootSerializer);
        if (true) goto _L4; else goto _L3
_L3:
        jsongenerator;
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

    public boolean canSerialize(Class class1)
    {
        return _serializerProvider(_config).hasSerializerFor(class1);
    }

    public JsonFactory getJsonFactory()
    {
        return _jsonFactory;
    }

    public TypeFactory getTypeFactory()
    {
        return _config.getTypeFactory();
    }

    public boolean isEnabled(com.fasterxml.jackson.core.JsonParser.Feature feature)
    {
        return _jsonFactory.isEnabled(feature);
    }

    public boolean isEnabled(MapperFeature mapperfeature)
    {
        return _config.isEnabled(mapperfeature);
    }

    public boolean isEnabled(SerializationFeature serializationfeature)
    {
        return _config.isEnabled(serializationfeature);
    }

    public Version version()
    {
        return DatabindVersion.instance.version();
    }

    public ObjectWriter with(Base64Variant base64variant)
    {
        base64variant = _config.with(base64variant);
        if (base64variant == _config)
        {
            return this;
        } else
        {
            return new ObjectWriter(this, base64variant);
        }
    }

    public ObjectWriter with(PrettyPrinter prettyprinter)
    {
        if (prettyprinter == _prettyPrinter)
        {
            return this;
        }
        PrettyPrinter prettyprinter1 = prettyprinter;
        if (prettyprinter == null)
        {
            prettyprinter1 = NULL_PRETTY_PRINTER;
        }
        return new ObjectWriter(this, _config, _rootType, _rootSerializer, prettyprinter1, _schema);
    }

    public ObjectWriter with(SerializationFeature serializationfeature)
    {
        serializationfeature = _config.with(serializationfeature);
        if (serializationfeature == _config)
        {
            return this;
        } else
        {
            return new ObjectWriter(this, serializationfeature);
        }
    }

    public transient ObjectWriter with(SerializationFeature serializationfeature, SerializationFeature aserializationfeature[])
    {
        serializationfeature = _config.with(serializationfeature, aserializationfeature);
        if (serializationfeature == _config)
        {
            return this;
        } else
        {
            return new ObjectWriter(this, serializationfeature);
        }
    }

    public ObjectWriter with(FilterProvider filterprovider)
    {
        if (filterprovider == _config.getFilterProvider())
        {
            return this;
        } else
        {
            return new ObjectWriter(this, _config.withFilters(filterprovider));
        }
    }

    public ObjectWriter with(DateFormat dateformat)
    {
        dateformat = _config.with(dateformat);
        if (dateformat == _config)
        {
            return this;
        } else
        {
            return new ObjectWriter(this, dateformat);
        }
    }

    public ObjectWriter with(Locale locale)
    {
        locale = _config.with(locale);
        if (locale == _config)
        {
            return this;
        } else
        {
            return new ObjectWriter(this, locale);
        }
    }

    public ObjectWriter with(TimeZone timezone)
    {
        timezone = _config.with(timezone);
        if (timezone == _config)
        {
            return this;
        } else
        {
            return new ObjectWriter(this, timezone);
        }
    }

    public ObjectWriter withDefaultPrettyPrinter()
    {
        return with(new DefaultPrettyPrinter());
    }

    public transient ObjectWriter withFeatures(SerializationFeature aserializationfeature[])
    {
        aserializationfeature = _config.withFeatures(aserializationfeature);
        if (aserializationfeature == _config)
        {
            return this;
        } else
        {
            return new ObjectWriter(this, aserializationfeature);
        }
    }

    public ObjectWriter withRootName(String s)
    {
        s = _config.withRootName(s);
        if (s == _config)
        {
            return this;
        } else
        {
            return new ObjectWriter(this, s);
        }
    }

    public ObjectWriter withSchema(FormatSchema formatschema)
    {
        if (_schema == formatschema)
        {
            return this;
        } else
        {
            return new ObjectWriter(this, _config, _rootType, _rootSerializer, _prettyPrinter, formatschema);
        }
    }

    public ObjectWriter withType(TypeReference typereference)
    {
        return withType(_config.getTypeFactory().constructType(typereference.getType()));
    }

    public ObjectWriter withType(JavaType javatype)
    {
        JsonSerializer jsonserializer = _prefetchRootSerializer(_config, javatype);
        if (javatype == _rootType)
        {
            return this;
        } else
        {
            return new ObjectWriter(this, _config, javatype, jsonserializer, _prettyPrinter, _schema);
        }
    }

    public ObjectWriter withType(Class class1)
    {
        return withType(_config.constructType(class1));
    }

    public ObjectWriter withView(Class class1)
    {
        class1 = _config.withView(class1);
        if (class1 == _config)
        {
            return this;
        } else
        {
            return new ObjectWriter(this, class1);
        }
    }

    public ObjectWriter without(SerializationFeature serializationfeature)
    {
        serializationfeature = _config.without(serializationfeature);
        if (serializationfeature == _config)
        {
            return this;
        } else
        {
            return new ObjectWriter(this, serializationfeature);
        }
    }

    public transient ObjectWriter without(SerializationFeature serializationfeature, SerializationFeature aserializationfeature[])
    {
        serializationfeature = _config.without(serializationfeature, aserializationfeature);
        if (serializationfeature == _config)
        {
            return this;
        } else
        {
            return new ObjectWriter(this, serializationfeature);
        }
    }

    public transient ObjectWriter withoutFeatures(SerializationFeature aserializationfeature[])
    {
        aserializationfeature = _config.withoutFeatures(aserializationfeature);
        if (aserializationfeature == _config)
        {
            return this;
        } else
        {
            return new ObjectWriter(this, aserializationfeature);
        }
    }

    public void writeValue(JsonGenerator jsongenerator, Object obj)
        throws IOException, JsonGenerationException, JsonMappingException
    {
        _configureJsonGenerator(jsongenerator);
        if (_config.isEnabled(SerializationFeature.CLOSE_CLOSEABLE) && (obj instanceof Closeable))
        {
            _writeCloseableValue(jsongenerator, obj, _config);
        } else
        {
            if (_rootType == null)
            {
                _serializerProvider(_config).serializeValue(jsongenerator, obj);
            } else
            {
                _serializerProvider(_config).serializeValue(jsongenerator, obj, _rootType, _rootSerializer);
            }
            if (_config.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE))
            {
                jsongenerator.flush();
                return;
            }
        }
    }

    public void writeValue(File file, Object obj)
        throws IOException, JsonGenerationException, JsonMappingException
    {
        _configAndWriteValue(_jsonFactory.createJsonGenerator(file, JsonEncoding.UTF8), obj);
    }

    public void writeValue(OutputStream outputstream, Object obj)
        throws IOException, JsonGenerationException, JsonMappingException
    {
        _configAndWriteValue(_jsonFactory.createJsonGenerator(outputstream, JsonEncoding.UTF8), obj);
    }

    public void writeValue(Writer writer, Object obj)
        throws IOException, JsonGenerationException, JsonMappingException
    {
        _configAndWriteValue(_jsonFactory.createJsonGenerator(writer), obj);
    }

    public byte[] writeValueAsBytes(Object obj)
        throws JsonProcessingException
    {
        ByteArrayBuilder bytearraybuilder = new ByteArrayBuilder(_jsonFactory._getBufferRecycler());
        try
        {
            _configAndWriteValue(_jsonFactory.createJsonGenerator(bytearraybuilder, JsonEncoding.UTF8), obj);
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
        obj = bytearraybuilder.toByteArray();
        bytearraybuilder.release();
        return ((byte []) (obj));
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
