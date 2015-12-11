// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler;
import com.fasterxml.jackson.databind.deser.impl.InnerClassProperty;
import com.fasterxml.jackson.databind.deser.impl.ManagedReferenceProperty;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdValueProperty;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.fasterxml.jackson.databind.deser.impl.UnwrappedPropertyHandler;
import com.fasterxml.jackson.databind.deser.impl.ValueInjector;
import com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.exc.IgnoredPropertyException;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Annotations;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.Converter;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.fasterxml.jackson.databind.deser:
//            ContextualDeserializer, ResolvableDeserializer, BeanDeserializerBuilder, ValueInstantiator, 
//            SettableBeanProperty, SettableAnyProperty

public abstract class BeanDeserializerBase extends StdDeserializer
    implements ContextualDeserializer, ResolvableDeserializer, Serializable
{

    protected static final PropertyName TEMP_PROPERTY_NAME = new PropertyName("#temporary-name");
    private static final long serialVersionUID = 0x291476536acb2fd2L;
    protected SettableAnyProperty _anySetter;
    protected final Map _backRefs;
    protected final BeanPropertyMap _beanProperties;
    protected final JavaType _beanType;
    private final transient Annotations _classAnnotations;
    protected JsonDeserializer _delegateDeserializer;
    protected ExternalTypeHandler _externalTypeIdHandler;
    protected final HashSet _ignorableProps;
    protected final boolean _ignoreAllUnknown;
    protected final ValueInjector _injectables[];
    protected final boolean _needViewProcesing;
    protected boolean _nonStandardCreation;
    protected final ObjectIdReader _objectIdReader;
    protected PropertyBasedCreator _propertyBasedCreator;
    protected final com.fasterxml.jackson.annotation.JsonFormat.Shape _serializationShape;
    protected transient HashMap _subDeserializers;
    protected UnwrappedPropertyHandler _unwrappedPropertyHandler;
    protected final ValueInstantiator _valueInstantiator;
    protected boolean _vanillaProcessing;

    protected BeanDeserializerBase(BeanDeserializerBase beandeserializerbase)
    {
        this(beandeserializerbase, beandeserializerbase._ignoreAllUnknown);
    }

    public BeanDeserializerBase(BeanDeserializerBase beandeserializerbase, ObjectIdReader objectidreader)
    {
        super(beandeserializerbase._beanType);
        _classAnnotations = beandeserializerbase._classAnnotations;
        _beanType = beandeserializerbase._beanType;
        _valueInstantiator = beandeserializerbase._valueInstantiator;
        _delegateDeserializer = beandeserializerbase._delegateDeserializer;
        _propertyBasedCreator = beandeserializerbase._propertyBasedCreator;
        _backRefs = beandeserializerbase._backRefs;
        _ignorableProps = beandeserializerbase._ignorableProps;
        _ignoreAllUnknown = beandeserializerbase._ignoreAllUnknown;
        _anySetter = beandeserializerbase._anySetter;
        _injectables = beandeserializerbase._injectables;
        _nonStandardCreation = beandeserializerbase._nonStandardCreation;
        _unwrappedPropertyHandler = beandeserializerbase._unwrappedPropertyHandler;
        _needViewProcesing = beandeserializerbase._needViewProcesing;
        _serializationShape = beandeserializerbase._serializationShape;
        _objectIdReader = objectidreader;
        if (objectidreader == null)
        {
            _beanProperties = beandeserializerbase._beanProperties;
            _vanillaProcessing = beandeserializerbase._vanillaProcessing;
            return;
        } else
        {
            objectidreader = new ObjectIdValueProperty(objectidreader, PropertyMetadata.STD_REQUIRED);
            _beanProperties = beandeserializerbase._beanProperties.withProperty(objectidreader);
            _vanillaProcessing = false;
            return;
        }
    }

    protected BeanDeserializerBase(BeanDeserializerBase beandeserializerbase, NameTransformer nametransformer)
    {
        super(beandeserializerbase._beanType);
        _classAnnotations = beandeserializerbase._classAnnotations;
        _beanType = beandeserializerbase._beanType;
        _valueInstantiator = beandeserializerbase._valueInstantiator;
        _delegateDeserializer = beandeserializerbase._delegateDeserializer;
        _propertyBasedCreator = beandeserializerbase._propertyBasedCreator;
        _backRefs = beandeserializerbase._backRefs;
        _ignorableProps = beandeserializerbase._ignorableProps;
        UnwrappedPropertyHandler unwrappedpropertyhandler;
        UnwrappedPropertyHandler unwrappedpropertyhandler1;
        boolean flag;
        if (nametransformer != null || beandeserializerbase._ignoreAllUnknown)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        _ignoreAllUnknown = flag;
        _anySetter = beandeserializerbase._anySetter;
        _injectables = beandeserializerbase._injectables;
        _objectIdReader = beandeserializerbase._objectIdReader;
        _nonStandardCreation = beandeserializerbase._nonStandardCreation;
        unwrappedpropertyhandler1 = beandeserializerbase._unwrappedPropertyHandler;
        if (nametransformer != null)
        {
            unwrappedpropertyhandler = unwrappedpropertyhandler1;
            if (unwrappedpropertyhandler1 != null)
            {
                unwrappedpropertyhandler = unwrappedpropertyhandler1.renameAll(nametransformer);
            }
            _beanProperties = beandeserializerbase._beanProperties.renameAll(nametransformer);
        } else
        {
            _beanProperties = beandeserializerbase._beanProperties;
            unwrappedpropertyhandler = unwrappedpropertyhandler1;
        }
        _unwrappedPropertyHandler = unwrappedpropertyhandler;
        _needViewProcesing = beandeserializerbase._needViewProcesing;
        _serializationShape = beandeserializerbase._serializationShape;
        _vanillaProcessing = false;
    }

    public BeanDeserializerBase(BeanDeserializerBase beandeserializerbase, HashSet hashset)
    {
        super(beandeserializerbase._beanType);
        _classAnnotations = beandeserializerbase._classAnnotations;
        _beanType = beandeserializerbase._beanType;
        _valueInstantiator = beandeserializerbase._valueInstantiator;
        _delegateDeserializer = beandeserializerbase._delegateDeserializer;
        _propertyBasedCreator = beandeserializerbase._propertyBasedCreator;
        _backRefs = beandeserializerbase._backRefs;
        _ignorableProps = hashset;
        _ignoreAllUnknown = beandeserializerbase._ignoreAllUnknown;
        _anySetter = beandeserializerbase._anySetter;
        _injectables = beandeserializerbase._injectables;
        _nonStandardCreation = beandeserializerbase._nonStandardCreation;
        _unwrappedPropertyHandler = beandeserializerbase._unwrappedPropertyHandler;
        _needViewProcesing = beandeserializerbase._needViewProcesing;
        _serializationShape = beandeserializerbase._serializationShape;
        _vanillaProcessing = beandeserializerbase._vanillaProcessing;
        _objectIdReader = beandeserializerbase._objectIdReader;
        _beanProperties = beandeserializerbase._beanProperties;
    }

    protected BeanDeserializerBase(BeanDeserializerBase beandeserializerbase, boolean flag)
    {
        super(beandeserializerbase._beanType);
        _classAnnotations = beandeserializerbase._classAnnotations;
        _beanType = beandeserializerbase._beanType;
        _valueInstantiator = beandeserializerbase._valueInstantiator;
        _delegateDeserializer = beandeserializerbase._delegateDeserializer;
        _propertyBasedCreator = beandeserializerbase._propertyBasedCreator;
        _beanProperties = beandeserializerbase._beanProperties;
        _backRefs = beandeserializerbase._backRefs;
        _ignorableProps = beandeserializerbase._ignorableProps;
        _ignoreAllUnknown = flag;
        _anySetter = beandeserializerbase._anySetter;
        _injectables = beandeserializerbase._injectables;
        _objectIdReader = beandeserializerbase._objectIdReader;
        _nonStandardCreation = beandeserializerbase._nonStandardCreation;
        _unwrappedPropertyHandler = beandeserializerbase._unwrappedPropertyHandler;
        _needViewProcesing = beandeserializerbase._needViewProcesing;
        _serializationShape = beandeserializerbase._serializationShape;
        _vanillaProcessing = beandeserializerbase._vanillaProcessing;
    }

    protected BeanDeserializerBase(BeanDeserializerBuilder beandeserializerbuilder, BeanDescription beandescription, BeanPropertyMap beanpropertymap, Map map, HashSet hashset, boolean flag, boolean flag1)
    {
        boolean flag2 = true;
        Object obj = null;
        super(beandescription.getType());
        _classAnnotations = beandescription.getClassInfo().getAnnotations();
        _beanType = beandescription.getType();
        _valueInstantiator = beandeserializerbuilder.getValueInstantiator();
        _beanProperties = beanpropertymap;
        _backRefs = map;
        _ignorableProps = hashset;
        _ignoreAllUnknown = flag;
        _anySetter = beandeserializerbuilder.getAnySetter();
        beanpropertymap = beandeserializerbuilder.getInjectables();
        if (beanpropertymap == null || beanpropertymap.isEmpty())
        {
            beanpropertymap = null;
        } else
        {
            beanpropertymap = (ValueInjector[])beanpropertymap.toArray(new ValueInjector[beanpropertymap.size()]);
        }
        _injectables = beanpropertymap;
        _objectIdReader = beandeserializerbuilder.getObjectIdReader();
        if (_unwrappedPropertyHandler != null || _valueInstantiator.canCreateUsingDelegate() || _valueInstantiator.canCreateFromObjectWith() || !_valueInstantiator.canCreateUsingDefault())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        _nonStandardCreation = flag;
        beandeserializerbuilder = beandescription.findExpectedFormat(null);
        if (beandeserializerbuilder == null)
        {
            beandeserializerbuilder = obj;
        } else
        {
            beandeserializerbuilder = beandeserializerbuilder.getShape();
        }
        _serializationShape = beandeserializerbuilder;
        _needViewProcesing = flag1;
        if (!_nonStandardCreation && _injectables == null && !_needViewProcesing && _objectIdReader == null)
        {
            flag = flag2;
        } else
        {
            flag = false;
        }
        _vanillaProcessing = flag;
    }

    private Throwable throwOrReturnThrowable(Throwable throwable, DeserializationContext deserializationcontext)
        throws IOException
    {
        for (; (throwable instanceof InvocationTargetException) && throwable.getCause() != null; throwable = throwable.getCause()) { }
        if (throwable instanceof Error)
        {
            throw (Error)throwable;
        }
        boolean flag;
        if (deserializationcontext == null || deserializationcontext.isEnabled(DeserializationFeature.WRAP_EXCEPTIONS))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (throwable instanceof IOException)
        {
            if (!flag || !(throwable instanceof JsonProcessingException))
            {
                throw (IOException)throwable;
            }
        } else
        if (!flag && (throwable instanceof RuntimeException))
        {
            throw (RuntimeException)throwable;
        }
        return throwable;
    }

    protected Object _convertObjectId(JsonParser jsonparser, DeserializationContext deserializationcontext, Object obj, JsonDeserializer jsondeserializer)
        throws IOException, JsonProcessingException
    {
        jsonparser = new TokenBuffer(jsonparser);
        if (obj instanceof String)
        {
            jsonparser.writeString((String)obj);
        } else
        if (obj instanceof Long)
        {
            jsonparser.writeNumber(((Long)obj).longValue());
        } else
        if (obj instanceof Integer)
        {
            jsonparser.writeNumber(((Integer)obj).intValue());
        } else
        {
            jsonparser.writeObject(obj);
        }
        jsonparser = jsonparser.asParser();
        jsonparser.nextToken();
        return jsondeserializer.deserialize(jsonparser, deserializationcontext);
    }

    protected abstract Object _deserializeUsingPropertyBased(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException;

    protected JsonDeserializer _findSubclassDeserializer(DeserializationContext deserializationcontext, Object obj, TokenBuffer tokenbuffer)
        throws IOException, JsonProcessingException
    {
        this;
        JVM INSTR monitorenter ;
        if (_subDeserializers != null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        tokenbuffer = null;
_L1:
        this;
        JVM INSTR monitorexit ;
        if (tokenbuffer != null)
        {
            return tokenbuffer;
        }
        break MISSING_BLOCK_LABEL_49;
        tokenbuffer = (JsonDeserializer)_subDeserializers.get(new ClassKey(obj.getClass()));
          goto _L1
        deserializationcontext;
        this;
        JVM INSTR monitorexit ;
        throw deserializationcontext;
        deserializationcontext = deserializationcontext.findRootValueDeserializer(deserializationcontext.constructType(obj.getClass()));
        if (deserializationcontext == null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        this;
        JVM INSTR monitorenter ;
        if (_subDeserializers == null)
        {
            _subDeserializers = new HashMap();
        }
        _subDeserializers.put(new ClassKey(obj.getClass()), deserializationcontext);
        this;
        JVM INSTR monitorexit ;
        return deserializationcontext;
        deserializationcontext;
        this;
        JVM INSTR monitorexit ;
        throw deserializationcontext;
        return deserializationcontext;
    }

    protected Object _handleTypedObjectId(JsonParser jsonparser, DeserializationContext deserializationcontext, Object obj, Object obj1)
        throws IOException, JsonProcessingException
    {
        JsonDeserializer jsondeserializer = _objectIdReader.getDeserializer();
        if (jsondeserializer.handledType() != obj1.getClass())
        {
            obj1 = _convertObjectId(jsonparser, deserializationcontext, obj1, jsondeserializer);
        }
        deserializationcontext.findObjectId(obj1, _objectIdReader.generator).bindItem(obj);
        deserializationcontext = _objectIdReader.idProperty;
        jsonparser = ((JsonParser) (obj));
        if (deserializationcontext != null)
        {
            jsonparser = ((JsonParser) (deserializationcontext.setAndReturn(obj, obj1)));
        }
        return jsonparser;
    }

    protected SettableBeanProperty _resolveInnerClassValuedProperty(DeserializationContext deserializationcontext, SettableBeanProperty settablebeanproperty)
    {
        Object obj;
        Object obj1;
        obj1 = settablebeanproperty.getValueDeserializer();
        obj = settablebeanproperty;
        if (!(obj1 instanceof BeanDeserializerBase)) goto _L2; else goto _L1
_L1:
        obj = settablebeanproperty;
        if (((BeanDeserializerBase)obj1).getValueInstantiator().canCreateUsingDefault()) goto _L2; else goto _L3
_L3:
        Class class1;
        class1 = settablebeanproperty.getType().getRawClass();
        obj1 = ClassUtil.getOuterClass(class1);
        obj = settablebeanproperty;
        if (obj1 == null) goto _L2; else goto _L4
_L4:
        obj = settablebeanproperty;
        if (obj1 != _beanType.getRawClass()) goto _L2; else goto _L5
_L5:
        Constructor aconstructor[];
        int i;
        int j;
        aconstructor = class1.getConstructors();
        j = aconstructor.length;
        i = 0;
_L10:
        obj = settablebeanproperty;
        if (i >= j) goto _L2; else goto _L6
_L6:
        Class aclass[];
        obj = aconstructor[i];
        aclass = ((Constructor) (obj)).getParameterTypes();
        if (aclass.length != 1 || aclass[0] != obj1) goto _L8; else goto _L7
_L7:
        if (deserializationcontext.getConfig().canOverrideAccessModifiers())
        {
            ClassUtil.checkAndFixAccess(((java.lang.reflect.Member) (obj)));
        }
        obj = new InnerClassProperty(settablebeanproperty, ((Constructor) (obj)));
_L2:
        return ((SettableBeanProperty) (obj));
_L8:
        i++;
        if (true) goto _L10; else goto _L9
_L9:
    }

    protected SettableBeanProperty _resolveManagedReferenceProperty(DeserializationContext deserializationcontext, SettableBeanProperty settablebeanproperty)
    {
        deserializationcontext = settablebeanproperty.getManagedReferenceName();
        if (deserializationcontext == null)
        {
            return settablebeanproperty;
        }
        SettableBeanProperty settablebeanproperty1 = settablebeanproperty.getValueDeserializer().findBackReference(deserializationcontext);
        if (settablebeanproperty1 == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Can not handle managed/back reference '").append(deserializationcontext).append("': no back reference property found from type ").append(settablebeanproperty.getType()).toString());
        }
        JavaType javatype = _beanType;
        JavaType javatype1 = settablebeanproperty1.getType();
        boolean flag = settablebeanproperty.getType().isContainerType();
        if (!javatype1.getRawClass().isAssignableFrom(javatype.getRawClass()))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Can not handle managed/back reference '").append(deserializationcontext).append("': back reference type (").append(javatype1.getRawClass().getName()).append(") not compatible with managed type (").append(javatype.getRawClass().getName()).append(")").toString());
        } else
        {
            return new ManagedReferenceProperty(settablebeanproperty, deserializationcontext, settablebeanproperty1, _classAnnotations, flag);
        }
    }

    protected SettableBeanProperty _resolveUnwrappedProperty(DeserializationContext deserializationcontext, SettableBeanProperty settablebeanproperty)
    {
        Object obj = settablebeanproperty.getMember();
        if (obj != null)
        {
            obj = deserializationcontext.getAnnotationIntrospector().findUnwrappingNameTransformer(((com.fasterxml.jackson.databind.introspect.AnnotatedMember) (obj)));
            if (obj != null)
            {
                deserializationcontext = settablebeanproperty.getValueDeserializer();
                obj = deserializationcontext.unwrappingDeserializer(((NameTransformer) (obj)));
                if (obj != deserializationcontext && obj != null)
                {
                    return settablebeanproperty.withValueDeserializer(((JsonDeserializer) (obj)));
                }
            }
        }
        return null;
    }

    protected abstract BeanDeserializerBase asArrayDeserializer();

    public JsonDeserializer createContextual(DeserializationContext deserializationcontext, BeanProperty beanproperty)
        throws JsonMappingException
    {
        Object obj1 = _objectIdReader;
        AnnotationIntrospector annotationintrospector = deserializationcontext.getAnnotationIntrospector();
        Object obj;
        if (beanproperty == null || annotationintrospector == null)
        {
            obj = null;
        } else
        {
            obj = beanproperty.getMember();
        }
        if (beanproperty != null && annotationintrospector != null)
        {
            beanproperty = annotationintrospector.findPropertiesToIgnore(((com.fasterxml.jackson.databind.introspect.Annotated) (obj)));
            Object obj2 = annotationintrospector.findObjectIdInfo(((com.fasterxml.jackson.databind.introspect.Annotated) (obj)));
            if (obj2 != null)
            {
                ObjectIdInfo objectidinfo = annotationintrospector.findObjectReferenceInfo(((com.fasterxml.jackson.databind.introspect.Annotated) (obj)), ((ObjectIdInfo) (obj2)));
                obj1 = objectidinfo.getGeneratorType();
                JavaType javatype;
                if (obj1 == com/fasterxml/jackson/annotation/ObjectIdGenerators$PropertyGenerator)
                {
                    obj1 = objectidinfo.getPropertyName();
                    obj2 = findProperty(((PropertyName) (obj1)));
                    if (obj2 == null)
                    {
                        throw new IllegalArgumentException((new StringBuilder()).append("Invalid Object Id definition for ").append(handledType().getName()).append(": can not find property with name '").append(obj1).append("'").toString());
                    }
                    javatype = ((SettableBeanProperty) (obj2)).getType();
                    obj1 = new PropertyBasedObjectIdGenerator(objectidinfo.getScope());
                } else
                {
                    obj1 = deserializationcontext.constructType(((Class) (obj1)));
                    javatype = deserializationcontext.getTypeFactory().findTypeParameters(((JavaType) (obj1)), com/fasterxml/jackson/annotation/ObjectIdGenerator)[0];
                    obj1 = deserializationcontext.objectIdGeneratorInstance(((com.fasterxml.jackson.databind.introspect.Annotated) (obj)), objectidinfo);
                    obj2 = null;
                }
                deserializationcontext = deserializationcontext.findRootValueDeserializer(javatype);
                obj1 = ObjectIdReader.construct(javatype, objectidinfo.getPropertyName(), ((ObjectIdGenerator) (obj1)), deserializationcontext, ((SettableBeanProperty) (obj2)));
                deserializationcontext = beanproperty;
                beanproperty = ((BeanProperty) (obj1));
            } else
            {
                deserializationcontext = beanproperty;
                beanproperty = ((BeanProperty) (obj1));
            }
        } else
        {
            beanproperty = ((BeanProperty) (obj1));
            deserializationcontext = null;
        }
        if (beanproperty != null && beanproperty != _objectIdReader)
        {
            beanproperty = withObjectIdReader(beanproperty);
        } else
        {
            beanproperty = this;
        }
        obj1 = beanproperty;
        if (deserializationcontext != null)
        {
            obj1 = beanproperty;
            if (deserializationcontext.length != 0)
            {
                obj1 = beanproperty.withIgnorableProperties(ArrayBuilders.setAndArray(((BeanDeserializerBase) (beanproperty))._ignorableProps, deserializationcontext));
            }
        }
        if (obj == null) goto _L2; else goto _L1
_L1:
        deserializationcontext = annotationintrospector.findFormat(((com.fasterxml.jackson.databind.introspect.Annotated) (obj)));
        if (deserializationcontext == null) goto _L2; else goto _L3
_L3:
        deserializationcontext = deserializationcontext.getShape();
_L5:
        beanproperty = deserializationcontext;
        if (deserializationcontext == null)
        {
            beanproperty = _serializationShape;
        }
        if (beanproperty == com.fasterxml.jackson.annotation.JsonFormat.Shape.ARRAY)
        {
            return ((BeanDeserializerBase) (obj1)).asArrayDeserializer();
        } else
        {
            return ((JsonDeserializer) (obj1));
        }
_L2:
        deserializationcontext = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public Iterator creatorProperties()
    {
        if (_propertyBasedCreator == null)
        {
            return Collections.emptyList().iterator();
        } else
        {
            return _propertyBasedCreator.properties().iterator();
        }
    }

    public Object deserializeFromArray(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        if (_delegateDeserializer == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        jsonparser = ((JsonParser) (_valueInstantiator.createUsingDelegate(deserializationcontext, _delegateDeserializer.deserialize(jsonparser, deserializationcontext))));
        if (_injectables != null)
        {
            injectValues(deserializationcontext, jsonparser);
        }
        return jsonparser;
        jsonparser;
        wrapInstantiationProblem(jsonparser, deserializationcontext);
        throw deserializationcontext.mappingException(getBeanClass());
    }

    public Object deserializeFromBoolean(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        if (_delegateDeserializer != null && !_valueInstantiator.canCreateFromBoolean())
        {
            jsonparser = ((JsonParser) (_valueInstantiator.createUsingDelegate(deserializationcontext, _delegateDeserializer.deserialize(jsonparser, deserializationcontext))));
            if (_injectables != null)
            {
                injectValues(deserializationcontext, jsonparser);
            }
            return jsonparser;
        }
        boolean flag;
        if (jsonparser.getCurrentToken() == JsonToken.VALUE_TRUE)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return _valueInstantiator.createFromBoolean(deserializationcontext, flag);
    }

    public Object deserializeFromDouble(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        static class _cls1
        {

            static final int $SwitchMap$com$fasterxml$jackson$core$JsonParser$NumberType[];

            static 
            {
                $SwitchMap$com$fasterxml$jackson$core$JsonParser$NumberType = new int[com.fasterxml.jackson.core.JsonParser.NumberType.values().length];
                try
                {
                    $SwitchMap$com$fasterxml$jackson$core$JsonParser$NumberType[com.fasterxml.jackson.core.JsonParser.NumberType.INT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$fasterxml$jackson$core$JsonParser$NumberType[com.fasterxml.jackson.core.JsonParser.NumberType.LONG.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$fasterxml$jackson$core$JsonParser$NumberType[com.fasterxml.jackson.core.JsonParser.NumberType.FLOAT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$fasterxml$jackson$core$JsonParser$NumberType[com.fasterxml.jackson.core.JsonParser.NumberType.DOUBLE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.fasterxml.jackson.core.JsonParser.NumberType[jsonparser.getNumberType().ordinal()];
        JVM INSTR tableswitch 3 4: default 32
    //                   3 59
    //                   4 59;
           goto _L1 _L2 _L2
_L1:
        if (_delegateDeserializer == null) goto _L4; else goto _L3
_L3:
        jsonparser = ((JsonParser) (_valueInstantiator.createUsingDelegate(deserializationcontext, _delegateDeserializer.deserialize(jsonparser, deserializationcontext))));
_L5:
        return jsonparser;
_L2:
        if (_delegateDeserializer != null && !_valueInstantiator.canCreateFromDouble())
        {
            Object obj = _valueInstantiator.createUsingDelegate(deserializationcontext, _delegateDeserializer.deserialize(jsonparser, deserializationcontext));
            jsonparser = ((JsonParser) (obj));
            if (_injectables != null)
            {
                injectValues(deserializationcontext, obj);
                return obj;
            }
        } else
        {
            return _valueInstantiator.createFromDouble(deserializationcontext, jsonparser.getDoubleValue());
        }
        if (true) goto _L5; else goto _L4
_L4:
        throw deserializationcontext.instantiationException(getBeanClass(), "no suitable creator method found to deserialize from JSON floating-point number");
    }

    public Object deserializeFromNumber(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        if (_objectIdReader == null) goto _L2; else goto _L1
_L1:
        jsonparser = ((JsonParser) (deserializeFromObjectId(jsonparser, deserializationcontext)));
_L4:
        return jsonparser;
_L2:
        switch (_cls1..SwitchMap.com.fasterxml.jackson.core.JsonParser.NumberType[jsonparser.getNumberType().ordinal()])
        {
        default:
            Object obj1;
            if (_delegateDeserializer != null)
            {
                Object obj = _valueInstantiator.createUsingDelegate(deserializationcontext, _delegateDeserializer.deserialize(jsonparser, deserializationcontext));
                jsonparser = ((JsonParser) (obj));
                if (_injectables != null)
                {
                    injectValues(deserializationcontext, obj);
                    return obj;
                }
            } else
            {
                throw deserializationcontext.instantiationException(getBeanClass(), "no suitable creator method found to deserialize from JSON integer number");
            }
            break;

        case 2: // '\002'
            break; /* Loop/switch isn't completed */

        case 1: // '\001'
            if (_delegateDeserializer != null && !_valueInstantiator.canCreateFromInt())
            {
                obj1 = _valueInstantiator.createUsingDelegate(deserializationcontext, _delegateDeserializer.deserialize(jsonparser, deserializationcontext));
                jsonparser = ((JsonParser) (obj1));
                if (_injectables != null)
                {
                    injectValues(deserializationcontext, obj1);
                    return obj1;
                }
            } else
            {
                return _valueInstantiator.createFromInt(deserializationcontext, jsonparser.getIntValue());
            }
            break;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (_delegateDeserializer != null && !_valueInstantiator.canCreateFromInt())
        {
            obj1 = _valueInstantiator.createUsingDelegate(deserializationcontext, _delegateDeserializer.deserialize(jsonparser, deserializationcontext));
            jsonparser = ((JsonParser) (obj1));
            if (_injectables != null)
            {
                injectValues(deserializationcontext, obj1);
                return obj1;
            }
        } else
        {
            return _valueInstantiator.createFromLong(deserializationcontext, jsonparser.getLongValue());
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public abstract Object deserializeFromObject(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException;

    protected Object deserializeFromObjectId(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        jsonparser = ((JsonParser) (_objectIdReader.readObjectReference(jsonparser, deserializationcontext)));
        deserializationcontext = ((DeserializationContext) (deserializationcontext.findObjectId(jsonparser, _objectIdReader.generator).item));
        if (deserializationcontext == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("Could not resolve Object Id [").append(jsonparser).append("] (for ").append(_beanType).append(") -- unresolved forward-reference?").toString());
        } else
        {
            return deserializationcontext;
        }
    }

    protected Object deserializeFromObjectUsingNonDefault(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        if (_delegateDeserializer != null)
        {
            return _valueInstantiator.createUsingDelegate(deserializationcontext, _delegateDeserializer.deserialize(jsonparser, deserializationcontext));
        }
        if (_propertyBasedCreator != null)
        {
            return _deserializeUsingPropertyBased(jsonparser, deserializationcontext);
        }
        if (_beanType.isAbstract())
        {
            throw JsonMappingException.from(jsonparser, (new StringBuilder()).append("Can not instantiate abstract type ").append(_beanType).append(" (need to add/enable type information?)").toString());
        } else
        {
            throw JsonMappingException.from(jsonparser, (new StringBuilder()).append("No suitable constructor found for type ").append(_beanType).append(": can not instantiate from JSON object (need to add/enable type information?)").toString());
        }
    }

    public Object deserializeFromString(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        if (_objectIdReader != null)
        {
            jsonparser = ((JsonParser) (deserializeFromObjectId(jsonparser, deserializationcontext)));
        } else
        if (_delegateDeserializer != null && !_valueInstantiator.canCreateFromString())
        {
            Object obj = _valueInstantiator.createUsingDelegate(deserializationcontext, _delegateDeserializer.deserialize(jsonparser, deserializationcontext));
            jsonparser = ((JsonParser) (obj));
            if (_injectables != null)
            {
                injectValues(deserializationcontext, obj);
                return obj;
            }
        } else
        {
            return _valueInstantiator.createFromString(deserializationcontext, jsonparser.getText());
        }
        return jsonparser;
    }

    protected Object deserializeWithObjectId(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        String s = _objectIdReader.propertyName.getSimpleName();
        if (s.equals(jsonparser.getCurrentName()) || jsonparser.canReadObjectId())
        {
            return deserializeFromObject(jsonparser, deserializationcontext);
        }
        TokenBuffer tokenbuffer = new TokenBuffer(jsonparser);
        TokenBuffer tokenbuffer1 = null;
        while (jsonparser.getCurrentToken() != JsonToken.END_OBJECT) 
        {
            String s1 = jsonparser.getCurrentName();
            if (tokenbuffer1 == null)
            {
                if (s.equals(s1))
                {
                    tokenbuffer1 = new TokenBuffer(jsonparser);
                    tokenbuffer1.writeFieldName(s1);
                    jsonparser.nextToken();
                    tokenbuffer1.copyCurrentStructure(jsonparser);
                    tokenbuffer1.append(tokenbuffer);
                    tokenbuffer = null;
                } else
                {
                    tokenbuffer.writeFieldName(s1);
                    jsonparser.nextToken();
                    tokenbuffer.copyCurrentStructure(jsonparser);
                }
            } else
            {
                tokenbuffer1.writeFieldName(s1);
                jsonparser.nextToken();
                tokenbuffer1.copyCurrentStructure(jsonparser);
            }
            jsonparser.nextToken();
        }
        if (tokenbuffer1 != null)
        {
            tokenbuffer = tokenbuffer1;
        }
        tokenbuffer.writeEndObject();
        jsonparser = tokenbuffer.asParser();
        jsonparser.nextToken();
        return deserializeFromObject(jsonparser, deserializationcontext);
    }

    public Object deserializeWithType(JsonParser jsonparser, DeserializationContext deserializationcontext, TypeDeserializer typedeserializer)
        throws IOException, JsonProcessingException
    {
        if (_objectIdReader != null)
        {
            if (jsonparser.canReadObjectId())
            {
                Object obj = jsonparser.getObjectId();
                if (obj != null)
                {
                    return _handleTypedObjectId(jsonparser, deserializationcontext, typedeserializer.deserializeTypedFromObject(jsonparser, deserializationcontext), obj);
                }
            }
            JsonToken jsontoken = jsonparser.getCurrentToken();
            if (jsontoken != null && jsontoken.isScalarValue())
            {
                return deserializeFromObjectId(jsonparser, deserializationcontext);
            }
        }
        return typedeserializer.deserializeTypedFromObject(jsonparser, deserializationcontext);
    }

    public SettableBeanProperty findBackReference(String s)
    {
        if (_backRefs == null)
        {
            return null;
        } else
        {
            return (SettableBeanProperty)_backRefs.get(s);
        }
    }

    protected JsonDeserializer findConvertingDeserializer(DeserializationContext deserializationcontext, SettableBeanProperty settablebeanproperty)
        throws JsonMappingException
    {
        Object obj = deserializationcontext.getAnnotationIntrospector();
        if (obj != null)
        {
            obj = ((AnnotationIntrospector) (obj)).findDeserializationConverter(settablebeanproperty.getMember());
            if (obj != null)
            {
                obj = deserializationcontext.converterInstance(settablebeanproperty.getMember(), obj);
                JavaType javatype = ((Converter) (obj)).getInputType(deserializationcontext.getTypeFactory());
                return new StdDelegatingDeserializer(((Converter) (obj)), javatype, deserializationcontext.findContextualValueDeserializer(javatype, settablebeanproperty));
            }
        }
        return null;
    }

    public SettableBeanProperty findProperty(int i)
    {
        SettableBeanProperty settablebeanproperty;
        SettableBeanProperty settablebeanproperty1;
        if (_beanProperties == null)
        {
            settablebeanproperty = null;
        } else
        {
            settablebeanproperty = _beanProperties.find(i);
        }
        settablebeanproperty1 = settablebeanproperty;
        if (settablebeanproperty == null)
        {
            settablebeanproperty1 = settablebeanproperty;
            if (_propertyBasedCreator != null)
            {
                settablebeanproperty1 = _propertyBasedCreator.findCreatorProperty(i);
            }
        }
        return settablebeanproperty1;
    }

    public SettableBeanProperty findProperty(PropertyName propertyname)
    {
        return findProperty(propertyname.getSimpleName());
    }

    public SettableBeanProperty findProperty(String s)
    {
        SettableBeanProperty settablebeanproperty;
        SettableBeanProperty settablebeanproperty1;
        if (_beanProperties == null)
        {
            settablebeanproperty = null;
        } else
        {
            settablebeanproperty = _beanProperties.find(s);
        }
        settablebeanproperty1 = settablebeanproperty;
        if (settablebeanproperty == null)
        {
            settablebeanproperty1 = settablebeanproperty;
            if (_propertyBasedCreator != null)
            {
                settablebeanproperty1 = _propertyBasedCreator.findCreatorProperty(s);
            }
        }
        return settablebeanproperty1;
    }

    public final Class getBeanClass()
    {
        return _beanType.getRawClass();
    }

    public Collection getKnownPropertyNames()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = _beanProperties.iterator(); iterator.hasNext(); arraylist.add(((SettableBeanProperty)iterator.next()).getName())) { }
        return arraylist;
    }

    public ObjectIdReader getObjectIdReader()
    {
        return _objectIdReader;
    }

    public int getPropertyCount()
    {
        return _beanProperties.size();
    }

    public ValueInstantiator getValueInstantiator()
    {
        return _valueInstantiator;
    }

    public JavaType getValueType()
    {
        return _beanType;
    }

    protected void handleIgnoredProperty(JsonParser jsonparser, DeserializationContext deserializationcontext, Object obj, String s)
        throws IOException, JsonProcessingException
    {
        if (deserializationcontext.isEnabled(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES))
        {
            throw IgnoredPropertyException.from(jsonparser, obj, s, getKnownPropertyNames());
        } else
        {
            jsonparser.skipChildren();
            return;
        }
    }

    protected Object handlePolymorphic(JsonParser jsonparser, DeserializationContext deserializationcontext, Object obj, TokenBuffer tokenbuffer)
        throws IOException, JsonProcessingException
    {
        JsonDeserializer jsondeserializer = _findSubclassDeserializer(deserializationcontext, obj, tokenbuffer);
        if (jsondeserializer != null)
        {
            if (tokenbuffer != null)
            {
                tokenbuffer.writeEndObject();
                tokenbuffer = tokenbuffer.asParser();
                tokenbuffer.nextToken();
                tokenbuffer = ((TokenBuffer) (jsondeserializer.deserialize(tokenbuffer, deserializationcontext, obj)));
            } else
            {
                tokenbuffer = ((TokenBuffer) (obj));
            }
            obj = tokenbuffer;
            if (jsonparser != null)
            {
                obj = jsondeserializer.deserialize(jsonparser, deserializationcontext, tokenbuffer);
            }
        } else
        {
            if (tokenbuffer != null)
            {
                tokenbuffer = ((TokenBuffer) (handleUnknownProperties(deserializationcontext, obj, tokenbuffer)));
            } else
            {
                tokenbuffer = ((TokenBuffer) (obj));
            }
            obj = tokenbuffer;
            if (jsonparser != null)
            {
                return deserialize(jsonparser, deserializationcontext, tokenbuffer);
            }
        }
        return obj;
    }

    protected Object handleUnknownProperties(DeserializationContext deserializationcontext, Object obj, TokenBuffer tokenbuffer)
        throws IOException, JsonProcessingException
    {
        tokenbuffer.writeEndObject();
        String s;
        for (tokenbuffer = tokenbuffer.asParser(); tokenbuffer.nextToken() != JsonToken.END_OBJECT; handleUnknownProperty(tokenbuffer, deserializationcontext, obj, s))
        {
            s = tokenbuffer.getCurrentName();
            tokenbuffer.nextToken();
        }

        return obj;
    }

    protected void handleUnknownProperty(JsonParser jsonparser, DeserializationContext deserializationcontext, Object obj, String s)
        throws IOException, JsonProcessingException
    {
        if (_ignoreAllUnknown)
        {
            jsonparser.skipChildren();
            return;
        }
        if (_ignorableProps != null && _ignorableProps.contains(s))
        {
            handleIgnoredProperty(jsonparser, deserializationcontext, obj, s);
        }
        super.handleUnknownProperty(jsonparser, deserializationcontext, obj, s);
    }

    protected void handleUnknownVanilla(JsonParser jsonparser, DeserializationContext deserializationcontext, Object obj, String s)
        throws IOException, JsonProcessingException
    {
        if (_ignorableProps != null && _ignorableProps.contains(s))
        {
            handleIgnoredProperty(jsonparser, deserializationcontext, obj, s);
            return;
        }
        if (_anySetter != null)
        {
            try
            {
                _anySetter.deserializeAndSet(jsonparser, deserializationcontext, obj, s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (JsonParser jsonparser)
            {
                wrapAndThrow(jsonparser, obj, s, deserializationcontext);
            }
            return;
        } else
        {
            handleUnknownProperty(jsonparser, deserializationcontext, obj, s);
            return;
        }
    }

    public Class handledType()
    {
        return _beanType.getRawClass();
    }

    public boolean hasProperty(String s)
    {
        return _beanProperties.find(s) != null;
    }

    public boolean hasViews()
    {
        return _needViewProcesing;
    }

    protected void injectValues(DeserializationContext deserializationcontext, Object obj)
        throws IOException, JsonProcessingException
    {
        ValueInjector avalueinjector[] = _injectables;
        int j = avalueinjector.length;
        for (int i = 0; i < j; i++)
        {
            avalueinjector[i].inject(deserializationcontext, obj);
        }

    }

    public boolean isCachable()
    {
        return true;
    }

    public Iterator properties()
    {
        if (_beanProperties == null)
        {
            throw new IllegalStateException("Can only call after BeanDeserializer has been resolved");
        } else
        {
            return _beanProperties.iterator();
        }
    }

    public void replaceProperty(SettableBeanProperty settablebeanproperty, SettableBeanProperty settablebeanproperty1)
    {
        _beanProperties.replace(settablebeanproperty1);
    }

    public void resolve(DeserializationContext deserializationcontext)
        throws JsonMappingException
    {
        Object obj;
        if (_valueInstantiator.canCreateFromObjectWith())
        {
            SettableBeanProperty asettablebeanproperty[] = _valueInstantiator.getFromObjectArguments(deserializationcontext.getConfig());
            _propertyBasedCreator = PropertyBasedCreator.construct(deserializationcontext, _valueInstantiator, asettablebeanproperty);
            Iterator iterator = _propertyBasedCreator.properties().iterator();
            com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder builder = null;
            do
            {
                obj = builder;
                if (!iterator.hasNext())
                {
                    break;
                }
                SettableBeanProperty settablebeanproperty = (SettableBeanProperty)iterator.next();
                if (settablebeanproperty.hasValueTypeDeserializer())
                {
                    TypeDeserializer typedeserializer = settablebeanproperty.getValueTypeDeserializer();
                    if (typedeserializer.getTypeInclusion() == com.fasterxml.jackson.annotation.JsonTypeInfo.As.EXTERNAL_PROPERTY)
                    {
                        obj = builder;
                        if (builder == null)
                        {
                            obj = new com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder();
                        }
                        ((com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder) (obj)).addExternal(settablebeanproperty, typedeserializer);
                        builder = ((com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder) (obj));
                    }
                }
            } while (true);
        } else
        {
            obj = null;
        }
        Iterator iterator1 = _beanProperties.iterator();
        Object obj1 = null;
        com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder builder1 = ((com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder) (obj));
        obj = obj1;
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            Object obj3 = (SettableBeanProperty)iterator1.next();
            Object obj2;
            Object obj4;
            if (!((SettableBeanProperty) (obj3)).hasValueDeserializer())
            {
                JsonDeserializer jsondeserializer = findConvertingDeserializer(deserializationcontext, ((SettableBeanProperty) (obj3)));
                obj2 = jsondeserializer;
                if (jsondeserializer == null)
                {
                    obj2 = findDeserializer(deserializationcontext, ((SettableBeanProperty) (obj3)).getType(), ((BeanProperty) (obj3)));
                }
                obj2 = ((SettableBeanProperty) (obj3)).withValueDeserializer(((JsonDeserializer) (obj2)));
            } else
            {
                obj2 = ((SettableBeanProperty) (obj3)).getValueDeserializer();
                obj4 = deserializationcontext.handlePrimaryContextualization(((JsonDeserializer) (obj2)), ((BeanProperty) (obj3)));
                boolean flag;
                if (obj4 != obj2)
                {
                    obj2 = ((SettableBeanProperty) (obj3)).withValueDeserializer(((JsonDeserializer) (obj4)));
                } else
                {
                    obj2 = obj3;
                }
            }
            obj4 = _resolveManagedReferenceProperty(deserializationcontext, ((SettableBeanProperty) (obj2)));
            obj2 = _resolveUnwrappedProperty(deserializationcontext, ((SettableBeanProperty) (obj4)));
            if (obj2 != null)
            {
                if (obj == null)
                {
                    obj = new UnwrappedPropertyHandler();
                }
                ((UnwrappedPropertyHandler) (obj)).addProperty(((SettableBeanProperty) (obj2)));
            } else
            {
                obj2 = _resolveInnerClassValuedProperty(deserializationcontext, ((SettableBeanProperty) (obj4)));
                if (obj2 != obj3)
                {
                    _beanProperties.replace(((SettableBeanProperty) (obj2)));
                }
                if (((SettableBeanProperty) (obj2)).hasValueTypeDeserializer())
                {
                    obj3 = ((SettableBeanProperty) (obj2)).getValueTypeDeserializer();
                    if (((TypeDeserializer) (obj3)).getTypeInclusion() == com.fasterxml.jackson.annotation.JsonTypeInfo.As.EXTERNAL_PROPERTY)
                    {
                        if (builder1 == null)
                        {
                            builder1 = new com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder();
                        }
                        builder1.addExternal(((SettableBeanProperty) (obj2)), ((TypeDeserializer) (obj3)));
                        _beanProperties.remove(((SettableBeanProperty) (obj2)));
                    }
                }
            }
        } while (true);
        if (_anySetter != null && !_anySetter.hasValueDeserializer())
        {
            _anySetter = _anySetter.withValueDeserializer(findDeserializer(deserializationcontext, _anySetter.getType(), _anySetter.getProperty()));
        }
        if (_valueInstantiator.canCreateUsingDelegate())
        {
            obj2 = _valueInstantiator.getDelegateType(deserializationcontext.getConfig());
            if (obj2 == null)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid delegate-creator definition for ").append(_beanType).append(": value instantiator (").append(_valueInstantiator.getClass().getName()).append(") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'").toString());
            }
            obj3 = _valueInstantiator.getDelegateCreator();
            _delegateDeserializer = findDeserializer(deserializationcontext, ((JavaType) (obj2)), new com.fasterxml.jackson.databind.BeanProperty.Std(TEMP_PROPERTY_NAME, ((JavaType) (obj2)), null, _classAnnotations, ((com.fasterxml.jackson.databind.introspect.AnnotatedMember) (obj3)), PropertyMetadata.STD_OPTIONAL));
        }
        if (builder1 != null)
        {
            _externalTypeIdHandler = builder1.build();
            _nonStandardCreation = true;
        }
        _unwrappedPropertyHandler = ((UnwrappedPropertyHandler) (obj));
        if (obj != null)
        {
            _nonStandardCreation = true;
        }
        if (_vanillaProcessing && !_nonStandardCreation)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        _vanillaProcessing = flag;
    }

    public abstract JsonDeserializer unwrappingDeserializer(NameTransformer nametransformer);

    public abstract BeanDeserializerBase withIgnorableProperties(HashSet hashset);

    public abstract BeanDeserializerBase withObjectIdReader(ObjectIdReader objectidreader);

    public void wrapAndThrow(Throwable throwable, Object obj, int i, DeserializationContext deserializationcontext)
        throws IOException
    {
        throw JsonMappingException.wrapWithPath(throwOrReturnThrowable(throwable, deserializationcontext), obj, i);
    }

    public void wrapAndThrow(Throwable throwable, Object obj, String s, DeserializationContext deserializationcontext)
        throws IOException
    {
        throw JsonMappingException.wrapWithPath(throwOrReturnThrowable(throwable, deserializationcontext), obj, s);
    }

    protected void wrapInstantiationProblem(Throwable throwable, DeserializationContext deserializationcontext)
        throws IOException
    {
        for (; (throwable instanceof InvocationTargetException) && throwable.getCause() != null; throwable = throwable.getCause()) { }
        if (throwable instanceof Error)
        {
            throw (Error)throwable;
        }
        boolean flag;
        if (deserializationcontext == null || deserializationcontext.isEnabled(DeserializationFeature.WRAP_EXCEPTIONS))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (throwable instanceof IOException)
        {
            throw (IOException)throwable;
        }
        if (!flag && (throwable instanceof RuntimeException))
        {
            throw (RuntimeException)throwable;
        } else
        {
            throw deserializationcontext.instantiationException(_beanType.getRawClass(), throwable);
        }
    }

}
