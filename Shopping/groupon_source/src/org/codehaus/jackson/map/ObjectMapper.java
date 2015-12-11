// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.text.DateFormat;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.io.SegmentedStringWriter;
import org.codehaus.jackson.io.SerializedString;
import org.codehaus.jackson.map.deser.StdDeserializationContext;
import org.codehaus.jackson.map.deser.StdDeserializerProvider;
import org.codehaus.jackson.map.deser.ValueInstantiators;
import org.codehaus.jackson.map.introspect.BasicClassIntrospector;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.map.introspect.VisibilityChecker;
import org.codehaus.jackson.map.jsontype.SubtypeResolver;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import org.codehaus.jackson.map.jsontype.impl.StdTypeResolverBuilder;
import org.codehaus.jackson.map.ser.BeanSerializerFactory;
import org.codehaus.jackson.map.ser.StdSerializerProvider;
import org.codehaus.jackson.map.type.SimpleType;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.TreeTraversingParser;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;

// Referenced classes of package org.codehaus.jackson.map:
//            MappingJsonFactory, SerializationConfig, DeserializationConfig, JsonMappingException, 
//            SerializerProvider, JsonDeserializer, DeserializerProvider, DeserializationContext, 
//            Module, AnnotationIntrospector, ClassIntrospector, InjectableValues, 
//            SerializerFactory, BeanProperty, TypeDeserializer, TypeSerializer, 
//            AbstractTypeResolver, Deserializers, KeyDeserializers, Serializers

public class ObjectMapper extends ObjectCodec
{
    public static class DefaultTypeResolverBuilder extends StdTypeResolverBuilder
    {

        protected final DefaultTyping _appliesFor;

        public TypeDeserializer buildTypeDeserializer(DeserializationConfig deserializationconfig, JavaType javatype, Collection collection, BeanProperty beanproperty)
        {
            if (useForType(javatype))
            {
                return super.buildTypeDeserializer(deserializationconfig, javatype, collection, beanproperty);
            } else
            {
                return null;
            }
        }

        public TypeSerializer buildTypeSerializer(SerializationConfig serializationconfig, JavaType javatype, Collection collection, BeanProperty beanproperty)
        {
            if (useForType(javatype))
            {
                return super.buildTypeSerializer(serializationconfig, javatype, collection, beanproperty);
            } else
            {
                return null;
            }
        }

        public boolean useForType(JavaType javatype)
        {
            JavaType javatype1;
            boolean flag;
            flag = false;
            javatype1 = javatype;
            static class _cls2
            {

                static final int $SwitchMap$org$codehaus$jackson$map$ObjectMapper$DefaultTyping[];

                static 
                {
                    $SwitchMap$org$codehaus$jackson$map$ObjectMapper$DefaultTyping = new int[DefaultTyping.values().length];
                    try
                    {
                        $SwitchMap$org$codehaus$jackson$map$ObjectMapper$DefaultTyping[DefaultTyping.NON_CONCRETE_AND_ARRAYS.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$org$codehaus$jackson$map$ObjectMapper$DefaultTyping[DefaultTyping.OBJECT_AND_NON_CONCRETE.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$org$codehaus$jackson$map$ObjectMapper$DefaultTyping[DefaultTyping.NON_FINAL.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            _cls2..SwitchMap.org.codehaus.jackson.map.ObjectMapper.DefaultTyping[_appliesFor.ordinal()];
            JVM INSTR tableswitch 1 3: default 40
        //                       1 51
        //                       2 65
        //                       3 85;
               goto _L1 _L2 _L3 _L4
_L1:
            if (javatype.getRawClass() != java/lang/Object) goto _L6; else goto _L5
_L5:
            return true;
_L2:
            javatype1 = javatype;
            if (javatype.isArrayType())
            {
                javatype1 = javatype.getContentType();
            }
_L3:
            if (javatype1.getRawClass() == java/lang/Object || !javatype1.isConcrete())
            {
                flag = true;
            }
            return flag;
_L4:
            JavaType javatype2 = javatype;
            if (javatype.isArrayType())
            {
                javatype2 = javatype.getContentType();
            }
            if (javatype2.isFinal())
            {
                return false;
            }
            if (true) goto _L5; else goto _L6
_L6:
            return false;
        }

        public DefaultTypeResolverBuilder(DefaultTyping defaulttyping)
        {
            _appliesFor = defaulttyping;
        }
    }

    public static final class DefaultTyping extends Enum
    {

        private static final DefaultTyping $VALUES[];
        public static final DefaultTyping JAVA_LANG_OBJECT;
        public static final DefaultTyping NON_CONCRETE_AND_ARRAYS;
        public static final DefaultTyping NON_FINAL;
        public static final DefaultTyping OBJECT_AND_NON_CONCRETE;

        public static DefaultTyping valueOf(String s)
        {
            return (DefaultTyping)Enum.valueOf(org/codehaus/jackson/map/ObjectMapper$DefaultTyping, s);
        }

        public static DefaultTyping[] values()
        {
            return (DefaultTyping[])$VALUES.clone();
        }

        static 
        {
            JAVA_LANG_OBJECT = new DefaultTyping("JAVA_LANG_OBJECT", 0);
            OBJECT_AND_NON_CONCRETE = new DefaultTyping("OBJECT_AND_NON_CONCRETE", 1);
            NON_CONCRETE_AND_ARRAYS = new DefaultTyping("NON_CONCRETE_AND_ARRAYS", 2);
            NON_FINAL = new DefaultTyping("NON_FINAL", 3);
            $VALUES = (new DefaultTyping[] {
                JAVA_LANG_OBJECT, OBJECT_AND_NON_CONCRETE, NON_CONCRETE_AND_ARRAYS, NON_FINAL
            });
        }

        private DefaultTyping(String s, int i)
        {
            super(s, i);
        }
    }


    protected static final AnnotationIntrospector DEFAULT_ANNOTATION_INTROSPECTOR = new JacksonAnnotationIntrospector();
    protected static final ClassIntrospector DEFAULT_INTROSPECTOR;
    private static final JavaType JSON_NODE_TYPE = SimpleType.constructUnsafe(org/codehaus/jackson/JsonNode);
    protected static final VisibilityChecker STD_VISIBILITY_CHECKER = org.codehaus.jackson.map.introspect.VisibilityChecker.Std.defaultInstance();
    protected DeserializationConfig _deserializationConfig;
    protected DeserializerProvider _deserializerProvider;
    protected InjectableValues _injectableValues;
    protected final JsonFactory _jsonFactory;
    protected final ConcurrentHashMap _rootDeserializers;
    protected SerializationConfig _serializationConfig;
    protected SerializerFactory _serializerFactory;
    protected SerializerProvider _serializerProvider;
    protected SubtypeResolver _subtypeResolver;
    protected TypeFactory _typeFactory;

    public ObjectMapper()
    {
        this(null, null, null);
    }

    public ObjectMapper(JsonFactory jsonfactory)
    {
        this(jsonfactory, null, null);
    }

    public ObjectMapper(JsonFactory jsonfactory, SerializerProvider serializerprovider, DeserializerProvider deserializerprovider)
    {
        this(jsonfactory, serializerprovider, deserializerprovider, null, null);
    }

    public ObjectMapper(JsonFactory jsonfactory, SerializerProvider serializerprovider, DeserializerProvider deserializerprovider, SerializationConfig serializationconfig, DeserializationConfig deserializationconfig)
    {
        _rootDeserializers = new ConcurrentHashMap(64, 0.6F, 2);
        Object obj = jsonfactory;
        if (jsonfactory == null)
        {
            obj = new MappingJsonFactory(this);
        }
        _jsonFactory = ((JsonFactory) (obj));
        _typeFactory = TypeFactory.defaultInstance();
        if (serializationconfig == null)
        {
            serializationconfig = new SerializationConfig(DEFAULT_INTROSPECTOR, DEFAULT_ANNOTATION_INTROSPECTOR, STD_VISIBILITY_CHECKER, null, null, _typeFactory, null);
        }
        _serializationConfig = serializationconfig;
        if (deserializationconfig == null)
        {
            deserializationconfig = new DeserializationConfig(DEFAULT_INTROSPECTOR, DEFAULT_ANNOTATION_INTROSPECTOR, STD_VISIBILITY_CHECKER, null, null, _typeFactory, null);
        }
        _deserializationConfig = deserializationconfig;
        jsonfactory = serializerprovider;
        if (serializerprovider == null)
        {
            jsonfactory = new StdSerializerProvider();
        }
        _serializerProvider = jsonfactory;
        jsonfactory = deserializerprovider;
        if (deserializerprovider == null)
        {
            jsonfactory = new StdDeserializerProvider();
        }
        _deserializerProvider = jsonfactory;
        _serializerFactory = BeanSerializerFactory.instance;
    }

    private final void _configAndWriteCloseable(JsonGenerator jsongenerator, Object obj, SerializationConfig serializationconfig)
        throws IOException, JsonGenerationException, JsonMappingException
    {
        Closeable closeable;
        Object obj1;
        Closeable closeable1;
        closeable1 = (Closeable)obj;
        closeable = closeable1;
        obj1 = jsongenerator;
        _serializerProvider.serializeValue(serializationconfig, jsongenerator, obj, _serializerFactory);
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
            break MISSING_BLOCK_LABEL_77;
        }
        throw new NullPointerException();
        return;
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
        _serializerProvider.serializeValue(serializationconfig, jsongenerator, obj, _serializerFactory);
        closeable = closeable1;
        if (!serializationconfig.isEnabled(SerializationConfig.Feature.FLUSH_AFTER_WRITE_VALUE))
        {
            break MISSING_BLOCK_LABEL_46;
        }
        closeable = closeable1;
        jsongenerator.flush();
        closeable = null;
        closeable1.close();
        if (true)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        throw new NullPointerException();
        return;
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
        SerializationConfig serializationconfig;
        serializationconfig = copySerializationConfig();
        if (serializationconfig.isEnabled(SerializationConfig.Feature.INDENT_OUTPUT))
        {
            jsongenerator.useDefaultPrettyPrinter();
        }
        if (!serializationconfig.isEnabled(SerializationConfig.Feature.CLOSE_CLOSEABLE) || !(obj instanceof Closeable)) goto _L2; else goto _L1
_L1:
        _configAndWriteCloseable(jsongenerator, obj, serializationconfig);
_L4:
        return;
_L2:
        boolean flag = false;
        _serializerProvider.serializeValue(serializationconfig, jsongenerator, obj, _serializerFactory);
        flag = true;
        jsongenerator.close();
        if (true) goto _L4; else goto _L3
_L3:
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
    }

    protected DeserializationContext _createDeserializationContext(JsonParser jsonparser, DeserializationConfig deserializationconfig)
    {
        return new StdDeserializationContext(deserializationconfig, jsonparser, _deserializerProvider, _injectableValues);
    }

    protected JsonDeserializer _findRootDeserializer(DeserializationConfig deserializationconfig, JavaType javatype)
        throws JsonMappingException
    {
        JsonDeserializer jsondeserializer = (JsonDeserializer)_rootDeserializers.get(javatype);
        if (jsondeserializer != null)
        {
            return jsondeserializer;
        }
        deserializationconfig = _deserializerProvider.findTypedValueDeserializer(deserializationconfig, javatype, null);
        if (deserializationconfig == null)
        {
            throw new JsonMappingException((new StringBuilder()).append("Can not find a deserializer for type ").append(javatype).toString());
        } else
        {
            _rootDeserializers.put(javatype, deserializationconfig);
            return deserializationconfig;
        }
    }

    protected JsonToken _initForReading(JsonParser jsonparser)
        throws IOException, JsonParseException, JsonMappingException
    {
        JsonToken jsontoken = jsonparser.getCurrentToken();
        Object obj = jsontoken;
        if (jsontoken == null)
        {
            jsonparser = jsonparser.nextToken();
            obj = jsonparser;
            if (jsonparser == null)
            {
                throw new EOFException("No content to map to Object due to end of input");
            }
        }
        return ((JsonToken) (obj));
    }

    protected Object _readMapAndClose(JsonParser jsonparser, JavaType javatype)
        throws IOException, JsonParseException, JsonMappingException
    {
        Object obj = _initForReading(jsonparser);
        if (obj != JsonToken.VALUE_NULL) goto _L2; else goto _L1
_L1:
        javatype = ((JavaType) (_findRootDeserializer(_deserializationConfig, javatype).getNullValue()));
_L3:
        jsonparser.clearCurrentToken();
        DeserializationContext deserializationcontext;
        JsonDeserializer jsondeserializer;
        try
        {
            jsonparser.close();
        }
        // Misplaced declaration of an exception variable
        catch (JsonParser jsonparser)
        {
            return javatype;
        }
        return javatype;
_L2:
        if (obj == JsonToken.END_ARRAY || obj == JsonToken.END_OBJECT)
        {
            break MISSING_BLOCK_LABEL_124;
        }
label0:
        {
            obj = copyDeserializationConfig();
            deserializationcontext = _createDeserializationContext(jsonparser, ((DeserializationConfig) (obj)));
            jsondeserializer = _findRootDeserializer(((DeserializationConfig) (obj)), javatype);
            if (!((DeserializationConfig) (obj)).isEnabled(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE))
            {
                break label0;
            }
            javatype = ((JavaType) (_unwrapAndDeserialize(jsonparser, javatype, deserializationcontext, jsondeserializer)));
        }
          goto _L3
        javatype = ((JavaType) (jsondeserializer.deserialize(jsonparser, deserializationcontext)));
          goto _L3
        javatype;
        try
        {
            jsonparser.close();
        }
        // Misplaced declaration of an exception variable
        catch (JsonParser jsonparser) { }
        throw javatype;
        javatype = null;
          goto _L3
    }

    protected Object _readValue(DeserializationConfig deserializationconfig, JsonParser jsonparser, JavaType javatype)
        throws IOException, JsonParseException, JsonMappingException
    {
        JsonToken jsontoken = _initForReading(jsonparser);
        if (jsontoken == JsonToken.VALUE_NULL)
        {
            deserializationconfig = ((DeserializationConfig) (_findRootDeserializer(deserializationconfig, javatype).getNullValue()));
        } else
        if (jsontoken == JsonToken.END_ARRAY || jsontoken == JsonToken.END_OBJECT)
        {
            deserializationconfig = null;
        } else
        {
            DeserializationContext deserializationcontext = _createDeserializationContext(jsonparser, deserializationconfig);
            JsonDeserializer jsondeserializer = _findRootDeserializer(deserializationconfig, javatype);
            if (deserializationconfig.isEnabled(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE))
            {
                deserializationconfig = ((DeserializationConfig) (_unwrapAndDeserialize(jsonparser, javatype, deserializationcontext, jsondeserializer)));
            } else
            {
                deserializationconfig = ((DeserializationConfig) (jsondeserializer.deserialize(jsonparser, deserializationcontext)));
            }
        }
        jsonparser.clearCurrentToken();
        return deserializationconfig;
    }

    protected Object _unwrapAndDeserialize(JsonParser jsonparser, JavaType javatype, DeserializationContext deserializationcontext, JsonDeserializer jsondeserializer)
        throws IOException, JsonParseException, JsonMappingException
    {
        SerializedString serializedstring = _deserializerProvider.findExpectedRootName(deserializationcontext.getConfig(), javatype);
        if (jsonparser.getCurrentToken() != JsonToken.START_OBJECT)
        {
            throw JsonMappingException.from(jsonparser, (new StringBuilder()).append("Current token not START_OBJECT (needed to unwrap root name '").append(serializedstring).append("'), but ").append(jsonparser.getCurrentToken()).toString());
        }
        if (jsonparser.nextToken() != JsonToken.FIELD_NAME)
        {
            throw JsonMappingException.from(jsonparser, (new StringBuilder()).append("Current token not FIELD_NAME (to contain expected root name '").append(serializedstring).append("'), but ").append(jsonparser.getCurrentToken()).toString());
        }
        String s = jsonparser.getCurrentName();
        if (!serializedstring.getValue().equals(s))
        {
            throw JsonMappingException.from(jsonparser, (new StringBuilder()).append("Root name '").append(s).append("' does not match expected ('").append(serializedstring).append("') for type ").append(javatype).toString());
        }
        jsonparser.nextToken();
        javatype = ((JavaType) (jsondeserializer.deserialize(jsonparser, deserializationcontext)));
        if (jsonparser.nextToken() != JsonToken.END_OBJECT)
        {
            throw JsonMappingException.from(jsonparser, (new StringBuilder()).append("Current token not END_OBJECT (to match wrapper object with root name '").append(serializedstring).append("'), but ").append(jsonparser.getCurrentToken()).toString());
        } else
        {
            return javatype;
        }
    }

    public DeserializationConfig copyDeserializationConfig()
    {
        return _deserializationConfig.createUnshared(_subtypeResolver).passSerializationFeatures(_serializationConfig._featureFlags);
    }

    public SerializationConfig copySerializationConfig()
    {
        return _serializationConfig.createUnshared(_subtypeResolver);
    }

    public transient ObjectMapper enable(DeserializationConfig.Feature afeature[])
    {
        _deserializationConfig = _deserializationConfig.with(afeature);
        return this;
    }

    public ObjectMapper enableDefaultTyping()
    {
        return enableDefaultTyping(DefaultTyping.OBJECT_AND_NON_CONCRETE);
    }

    public ObjectMapper enableDefaultTyping(DefaultTyping defaulttyping)
    {
        return enableDefaultTyping(defaulttyping, org.codehaus.jackson.annotate.JsonTypeInfo.As.WRAPPER_ARRAY);
    }

    public ObjectMapper enableDefaultTyping(DefaultTyping defaulttyping, org.codehaus.jackson.annotate.JsonTypeInfo.As as)
    {
        return setDefaultTyping((new DefaultTypeResolverBuilder(defaulttyping)).init(org.codehaus.jackson.annotate.JsonTypeInfo.Id.CLASS, null).inclusion(as));
    }

    public JsonNodeFactory getNodeFactory()
    {
        return _deserializationConfig.getNodeFactory();
    }

    public TypeFactory getTypeFactory()
    {
        return _typeFactory;
    }

    public JsonNode readTree(JsonParser jsonparser)
        throws IOException, JsonProcessingException
    {
        Object obj = copyDeserializationConfig();
        if (jsonparser.getCurrentToken() == null && jsonparser.nextToken() == null)
        {
            jsonparser = null;
        } else
        {
            obj = (JsonNode)_readValue(((DeserializationConfig) (obj)), jsonparser, JSON_NODE_TYPE);
            jsonparser = ((JsonParser) (obj));
            if (obj == null)
            {
                return getNodeFactory().nullNode();
            }
        }
        return jsonparser;
    }

    public Object readValue(InputStream inputstream, Class class1)
        throws IOException, JsonParseException, JsonMappingException
    {
        return _readMapAndClose(_jsonFactory.createJsonParser(inputstream), _typeFactory.constructType(class1));
    }

    public Object readValue(InputStream inputstream, TypeReference typereference)
        throws IOException, JsonParseException, JsonMappingException
    {
        return _readMapAndClose(_jsonFactory.createJsonParser(inputstream), _typeFactory.constructType(typereference));
    }

    public Object readValue(Reader reader, Class class1)
        throws IOException, JsonParseException, JsonMappingException
    {
        return _readMapAndClose(_jsonFactory.createJsonParser(reader), _typeFactory.constructType(class1));
    }

    public Object readValue(String s, Class class1)
        throws IOException, JsonParseException, JsonMappingException
    {
        return _readMapAndClose(_jsonFactory.createJsonParser(s), _typeFactory.constructType(class1));
    }

    public Object readValue(String s, JavaType javatype)
        throws IOException, JsonParseException, JsonMappingException
    {
        return _readMapAndClose(_jsonFactory.createJsonParser(s), javatype);
    }

    public Object readValue(String s, TypeReference typereference)
        throws IOException, JsonParseException, JsonMappingException
    {
        return _readMapAndClose(_jsonFactory.createJsonParser(s), _typeFactory.constructType(typereference));
    }

    public Object readValue(JsonNode jsonnode, JavaType javatype)
        throws IOException, JsonParseException, JsonMappingException
    {
        return _readValue(copyDeserializationConfig(), treeAsTokens(jsonnode), javatype);
    }

    public Object readValue(JsonParser jsonparser, Class class1)
        throws IOException, JsonParseException, JsonMappingException
    {
        return _readValue(copyDeserializationConfig(), jsonparser, _typeFactory.constructType(class1));
    }

    public Object readValue(byte abyte0[], TypeReference typereference)
        throws IOException, JsonParseException, JsonMappingException
    {
        return _readMapAndClose(_jsonFactory.createJsonParser(abyte0), _typeFactory.constructType(typereference));
    }

    public void registerModule(Module module)
    {
        if (module.getModuleName() == null)
        {
            throw new IllegalArgumentException("Module without defined name");
        }
        if (module.version() == null)
        {
            throw new IllegalArgumentException("Module without defined version");
        } else
        {
            module.setupModule(new Module.SetupContext() {

                final ObjectMapper this$0;
                final ObjectMapper val$mapper;

                public void addAbstractTypeResolver(AbstractTypeResolver abstracttyperesolver)
                {
                    mapper._deserializerProvider = mapper._deserializerProvider.withAbstractTypeResolver(abstracttyperesolver);
                }

                public void addDeserializers(Deserializers deserializers)
                {
                    mapper._deserializerProvider = mapper._deserializerProvider.withAdditionalDeserializers(deserializers);
                }

                public void addKeyDeserializers(KeyDeserializers keydeserializers)
                {
                    mapper._deserializerProvider = mapper._deserializerProvider.withAdditionalKeyDeserializers(keydeserializers);
                }

                public void addKeySerializers(Serializers serializers)
                {
                    mapper._serializerFactory = mapper._serializerFactory.withAdditionalKeySerializers(serializers);
                }

                public void addSerializers(Serializers serializers)
                {
                    mapper._serializerFactory = mapper._serializerFactory.withAdditionalSerializers(serializers);
                }

                public void addValueInstantiators(ValueInstantiators valueinstantiators)
                {
                    mapper._deserializerProvider = mapper._deserializerProvider.withValueInstantiators(valueinstantiators);
                }

                public void setMixInAnnotations(Class class1, Class class2)
                {
                    mapper._deserializationConfig.addMixInAnnotations(class1, class2);
                    mapper._serializationConfig.addMixInAnnotations(class1, class2);
                }

            
            {
                this$0 = ObjectMapper.this;
                mapper = objectmapper1;
                super();
            }
            });
            return;
        }
    }

    public void setDateFormat(DateFormat dateformat)
    {
        _deserializationConfig = _deserializationConfig.withDateFormat(dateformat);
        _serializationConfig = _serializationConfig.withDateFormat(dateformat);
    }

    public ObjectMapper setDefaultTyping(TypeResolverBuilder typeresolverbuilder)
    {
        _deserializationConfig = _deserializationConfig.withTypeResolverBuilder(typeresolverbuilder);
        _serializationConfig = _serializationConfig.withTypeResolverBuilder(typeresolverbuilder);
        return this;
    }

    public JsonParser treeAsTokens(JsonNode jsonnode)
    {
        return new TreeTraversingParser(jsonnode, this);
    }

    public void writeValue(JsonGenerator jsongenerator, Object obj)
        throws IOException, JsonGenerationException, JsonMappingException
    {
        SerializationConfig serializationconfig = copySerializationConfig();
        if (serializationconfig.isEnabled(SerializationConfig.Feature.CLOSE_CLOSEABLE) && (obj instanceof Closeable))
        {
            _writeCloseableValue(jsongenerator, obj, serializationconfig);
        } else
        {
            _serializerProvider.serializeValue(serializationconfig, jsongenerator, obj, _serializerFactory);
            if (serializationconfig.isEnabled(SerializationConfig.Feature.FLUSH_AFTER_WRITE_VALUE))
            {
                jsongenerator.flush();
                return;
            }
        }
    }

    public String writeValueAsString(Object obj)
        throws IOException, JsonGenerationException, JsonMappingException
    {
        SegmentedStringWriter segmentedstringwriter = new SegmentedStringWriter(_jsonFactory._getBufferRecycler());
        _configAndWriteValue(_jsonFactory.createJsonGenerator(segmentedstringwriter), obj);
        return segmentedstringwriter.getAndClear();
    }

    static 
    {
        DEFAULT_INTROSPECTOR = BasicClassIntrospector.instance;
    }
}
