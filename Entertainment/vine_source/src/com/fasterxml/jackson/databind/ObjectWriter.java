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
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.SegmentedStringWriter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.cfg.PackageVersion;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
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
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.fasterxml.jackson.databind:
//            SerializationFeature, SerializationConfig, ObjectMapper, JavaType, 
//            MapperFeature, JsonMappingException, JsonSerializer

public class ObjectWriter
    implements Versioned, Serializable
{

    protected static final PrettyPrinter NULL_PRETTY_PRINTER = new MinimalPrettyPrinter();
    private static final long serialVersionUID = 0x9e4a868e1a7967a4L;
    protected final boolean _cfgBigDecimalAsPlain;
    protected final CharacterEscapes _characterEscapes;
    protected final SerializationConfig _config;
    protected final JsonFactory _generatorFactory;
    protected final PrettyPrinter _prettyPrinter;
    protected final JsonSerializer _rootSerializer;
    protected final JavaType _rootType;
    protected final FormatSchema _schema;
    protected final SerializerFactory _serializerFactory;
    protected final DefaultSerializerProvider _serializerProvider;

    protected ObjectWriter(ObjectMapper objectmapper, SerializationConfig serializationconfig)
    {
        _config = serializationconfig;
        _cfgBigDecimalAsPlain = _config.isEnabled(SerializationFeature.WRITE_BIGDECIMAL_AS_PLAIN);
        _serializerProvider = objectmapper._serializerProvider;
        _serializerFactory = objectmapper._serializerFactory;
        _generatorFactory = objectmapper._jsonFactory;
        _rootType = null;
        _rootSerializer = null;
        _prettyPrinter = null;
        _schema = null;
        _characterEscapes = null;
    }

    protected ObjectWriter(ObjectMapper objectmapper, SerializationConfig serializationconfig, FormatSchema formatschema)
    {
        _config = serializationconfig;
        _cfgBigDecimalAsPlain = _config.isEnabled(SerializationFeature.WRITE_BIGDECIMAL_AS_PLAIN);
        _serializerProvider = objectmapper._serializerProvider;
        _serializerFactory = objectmapper._serializerFactory;
        _generatorFactory = objectmapper._jsonFactory;
        _rootType = null;
        _rootSerializer = null;
        _prettyPrinter = null;
        _schema = formatschema;
        _characterEscapes = null;
    }

    protected ObjectWriter(ObjectMapper objectmapper, SerializationConfig serializationconfig, JavaType javatype, PrettyPrinter prettyprinter)
    {
        _config = serializationconfig;
        _cfgBigDecimalAsPlain = _config.isEnabled(SerializationFeature.WRITE_BIGDECIMAL_AS_PLAIN);
        _serializerProvider = objectmapper._serializerProvider;
        _serializerFactory = objectmapper._serializerFactory;
        _generatorFactory = objectmapper._jsonFactory;
        objectmapper = javatype;
        if (javatype != null)
        {
            objectmapper = javatype.withStaticTyping();
        }
        _prettyPrinter = prettyprinter;
        _schema = null;
        _characterEscapes = null;
        if (objectmapper == null || objectmapper.hasRawClass(java/lang/Object))
        {
            _rootType = null;
            _rootSerializer = null;
            return;
        } else
        {
            _rootType = objectmapper;
            _rootSerializer = _prefetchRootSerializer(serializationconfig, objectmapper);
            return;
        }
    }

    protected ObjectWriter(ObjectWriter objectwriter, JsonFactory jsonfactory)
    {
        _config = objectwriter._config.with(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, jsonfactory.requiresPropertyOrdering());
        _cfgBigDecimalAsPlain = objectwriter._cfgBigDecimalAsPlain;
        _serializerProvider = objectwriter._serializerProvider;
        _serializerFactory = objectwriter._serializerFactory;
        _generatorFactory = objectwriter._generatorFactory;
        _schema = objectwriter._schema;
        _characterEscapes = objectwriter._characterEscapes;
        _rootType = objectwriter._rootType;
        _rootSerializer = objectwriter._rootSerializer;
        _prettyPrinter = objectwriter._prettyPrinter;
    }

    protected ObjectWriter(ObjectWriter objectwriter, SerializationConfig serializationconfig)
    {
        _config = serializationconfig;
        _cfgBigDecimalAsPlain = _config.isEnabled(SerializationFeature.WRITE_BIGDECIMAL_AS_PLAIN);
        _serializerProvider = objectwriter._serializerProvider;
        _serializerFactory = objectwriter._serializerFactory;
        _generatorFactory = objectwriter._generatorFactory;
        _schema = objectwriter._schema;
        _characterEscapes = objectwriter._characterEscapes;
        _rootType = objectwriter._rootType;
        _rootSerializer = objectwriter._rootSerializer;
        _prettyPrinter = objectwriter._prettyPrinter;
    }

    protected ObjectWriter(ObjectWriter objectwriter, SerializationConfig serializationconfig, JavaType javatype, JsonSerializer jsonserializer, PrettyPrinter prettyprinter, FormatSchema formatschema, CharacterEscapes characterescapes)
    {
        _config = serializationconfig;
        _cfgBigDecimalAsPlain = _config.isEnabled(SerializationFeature.WRITE_BIGDECIMAL_AS_PLAIN);
        _serializerProvider = objectwriter._serializerProvider;
        _serializerFactory = objectwriter._serializerFactory;
        _generatorFactory = objectwriter._generatorFactory;
        _rootType = javatype;
        _rootSerializer = jsonserializer;
        _prettyPrinter = prettyprinter;
        _schema = formatschema;
        _characterEscapes = characterescapes;
    }

    private void _configureJsonGenerator(JsonGenerator jsongenerator)
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
        if (_characterEscapes != null)
        {
            jsongenerator.setCharacterEscapes(_characterEscapes);
        }
        if (_schema != null)
        {
            jsongenerator.setSchema(_schema);
        }
        if (_cfgBigDecimalAsPlain)
        {
            jsongenerator.enable(com.fasterxml.jackson.core.JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN);
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
        Object obj1 = (Closeable)obj;
        if (_rootType != null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        _serializerProvider(serializationconfig).serializeValue(jsongenerator, obj);
_L1:
        jsongenerator.close();
        ((Closeable) (obj1)).close();
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
            break MISSING_BLOCK_LABEL_58;
        }
        throw new NullPointerException();
        return;
        _serializerProvider(serializationconfig).serializeValue(jsongenerator, obj, _rootType, _rootSerializer);
          goto _L1
        serializationconfig;
        obj = obj1;
        obj1 = serializationconfig;
        serializationconfig = jsongenerator;
        jsongenerator = ((JsonGenerator) (obj1));
_L3:
        if (serializationconfig != null)
        {
            try
            {
                serializationconfig.close();
            }
            // Misplaced declaration of an exception variable
            catch (SerializationConfig serializationconfig) { }
        }
        if (obj != null)
        {
            try
            {
                ((Closeable) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        throw jsongenerator;
        jsongenerator;
        return;
        jsongenerator;
        serializationconfig = null;
        obj = obj1;
        continue; /* Loop/switch isn't completed */
        jsongenerator;
        obj = null;
        serializationconfig = null;
        if (true) goto _L3; else goto _L2
_L2:
    }

    private final void _writeCloseableValue(JsonGenerator jsongenerator, Object obj, SerializationConfig serializationconfig)
        throws IOException, JsonGenerationException, JsonMappingException
    {
        Closeable closeable = (Closeable)obj;
        if (_rootType != null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        _serializerProvider(serializationconfig).serializeValue(jsongenerator, obj);
_L1:
        if (_config.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE))
        {
            jsongenerator.flush();
        }
        obj = null;
        closeable.close();
        if (true)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        throw new NullPointerException();
        return;
        _serializerProvider(serializationconfig).serializeValue(jsongenerator, obj, _rootType, _rootSerializer);
          goto _L1
        jsongenerator;
        obj = closeable;
_L3:
        if (obj != null)
        {
            try
            {
                ((Closeable) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        throw jsongenerator;
        jsongenerator;
        return;
        jsongenerator;
        if (true) goto _L3; else goto _L2
_L2:
    }

    protected final void _configAndWriteValue(JsonGenerator jsongenerator, Object obj)
        throws IOException, JsonGenerationException, JsonMappingException
    {
        boolean flag;
        boolean flag1;
        _configureJsonGenerator(jsongenerator);
        if (_config.isEnabled(SerializationFeature.CLOSE_CLOSEABLE) && (obj instanceof Closeable))
        {
            _writeCloseable(jsongenerator, obj, _config);
            return;
        }
        flag1 = false;
        flag = flag1;
        if (_rootType != null) goto _L2; else goto _L1
_L1:
        flag = flag1;
        _serializerProvider(_config).serializeValue(jsongenerator, obj);
_L3:
        flag = true;
        jsongenerator.close();
        return;
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
_L2:
        flag = flag1;
        _serializerProvider(_config).serializeValue(jsongenerator, obj, _rootType, _rootSerializer);
          goto _L3
    }

    protected JsonSerializer _prefetchRootSerializer(SerializationConfig serializationconfig, JavaType javatype)
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

    protected void _verifySchemaType(FormatSchema formatschema)
    {
        if (formatschema != null && !_generatorFactory.canUseSchema(formatschema))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Can not use FormatSchema of type ").append(formatschema.getClass().getName()).append(" for format ").append(_generatorFactory.getFormatName()).toString());
        } else
        {
            return;
        }
    }

    public void acceptJsonFormatVisitor(JavaType javatype, JsonFormatVisitorWrapper jsonformatvisitorwrapper)
        throws JsonMappingException
    {
        if (javatype == null)
        {
            throw new IllegalArgumentException("type must be provided");
        } else
        {
            _serializerProvider(_config).acceptJsonFormatVisitor(javatype, jsonformatvisitorwrapper);
            return;
        }
    }

    public boolean canSerialize(Class class1)
    {
        return _serializerProvider(_config).hasSerializerFor(class1, null);
    }

    public boolean canSerialize(Class class1, AtomicReference atomicreference)
    {
        return _serializerProvider(_config).hasSerializerFor(class1, atomicreference);
    }

    public ContextAttributes getAttributes()
    {
        return _config.getAttributes();
    }

    public SerializationConfig getConfig()
    {
        return _config;
    }

    public JsonFactory getFactory()
    {
        return _generatorFactory;
    }

    public JsonFactory getJsonFactory()
    {
        return _generatorFactory;
    }

    public TypeFactory getTypeFactory()
    {
        return _config.getTypeFactory();
    }

    public boolean hasPrefetchedSerializer()
    {
        return _rootSerializer != null;
    }

    public boolean isEnabled(com.fasterxml.jackson.core.JsonParser.Feature feature)
    {
        return _generatorFactory.isEnabled(feature);
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
        return PackageVersion.VERSION;
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

    public ObjectWriter with(JsonFactory jsonfactory)
    {
        if (jsonfactory == _generatorFactory)
        {
            return this;
        } else
        {
            return new ObjectWriter(this, jsonfactory);
        }
    }

    public ObjectWriter with(PrettyPrinter prettyprinter)
    {
        if (prettyprinter == _prettyPrinter)
        {
            return this;
        }
        if (prettyprinter == null)
        {
            prettyprinter = NULL_PRETTY_PRINTER;
        }
        return new ObjectWriter(this, _config, _rootType, _rootSerializer, prettyprinter, _schema, _characterEscapes);
    }

    public ObjectWriter with(CharacterEscapes characterescapes)
    {
        if (_characterEscapes == characterescapes)
        {
            return this;
        } else
        {
            return new ObjectWriter(this, _config, _rootType, _rootSerializer, _prettyPrinter, _schema, characterescapes);
        }
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

    public ObjectWriter with(ContextAttributes contextattributes)
    {
        contextattributes = _config.with(contextattributes);
        if (contextattributes == _config)
        {
            return this;
        } else
        {
            return new ObjectWriter(this, contextattributes);
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

    public ObjectWriter withAttribute(Object obj, Object obj1)
    {
        obj = (SerializationConfig)_config.withAttribute(obj, obj1);
        if (obj == _config)
        {
            return this;
        } else
        {
            return new ObjectWriter(this, ((SerializationConfig) (obj)));
        }
    }

    public ObjectWriter withAttributes(Map map)
    {
        map = (SerializationConfig)_config.withAttributes(map);
        if (map == _config)
        {
            return this;
        } else
        {
            return new ObjectWriter(this, map);
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
            _verifySchemaType(formatschema);
            return new ObjectWriter(this, _config, _rootType, _rootSerializer, _prettyPrinter, formatschema, _characterEscapes);
        }
    }

    public ObjectWriter withType(TypeReference typereference)
    {
        return withType(_config.getTypeFactory().constructType(typereference.getType()));
    }

    public ObjectWriter withType(JavaType javatype)
    {
        JsonSerializer jsonserializer = null;
        if (javatype != null && javatype.hasRawClass(java/lang/Object))
        {
            javatype = null;
        }
        if (javatype != null)
        {
            javatype = javatype.withStaticTyping();
            jsonserializer = _prefetchRootSerializer(_config, javatype);
        }
        return new ObjectWriter(this, _config, javatype, jsonserializer, _prettyPrinter, _schema, _characterEscapes);
    }

    public ObjectWriter withType(Class class1)
    {
        if (class1 == java/lang/Object)
        {
            return withType((JavaType)null);
        } else
        {
            return withType(_config.constructType(class1));
        }
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

    public ObjectWriter withoutAttribute(Object obj)
    {
        obj = (SerializationConfig)_config.withoutAttribute(obj);
        if (obj == _config)
        {
            return this;
        } else
        {
            return new ObjectWriter(this, ((SerializationConfig) (obj)));
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
        _configAndWriteValue(_generatorFactory.createGenerator(file, JsonEncoding.UTF8), obj);
    }

    public void writeValue(OutputStream outputstream, Object obj)
        throws IOException, JsonGenerationException, JsonMappingException
    {
        _configAndWriteValue(_generatorFactory.createGenerator(outputstream, JsonEncoding.UTF8), obj);
    }

    public void writeValue(Writer writer, Object obj)
        throws IOException, JsonGenerationException, JsonMappingException
    {
        _configAndWriteValue(_generatorFactory.createGenerator(writer), obj);
    }

    public byte[] writeValueAsBytes(Object obj)
        throws JsonProcessingException
    {
        ByteArrayBuilder bytearraybuilder = new ByteArrayBuilder(_generatorFactory._getBufferRecycler());
        try
        {
            _configAndWriteValue(_generatorFactory.createGenerator(bytearraybuilder, JsonEncoding.UTF8), obj);
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
        SegmentedStringWriter segmentedstringwriter = new SegmentedStringWriter(_generatorFactory._getBufferRecycler());
        try
        {
            _configAndWriteValue(_generatorFactory.createGenerator(segmentedstringwriter), obj);
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
