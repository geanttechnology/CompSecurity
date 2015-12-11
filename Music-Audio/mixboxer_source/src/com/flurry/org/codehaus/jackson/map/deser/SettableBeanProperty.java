// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.deser;

import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.map.BeanProperty;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.map.JsonDeserializer;
import com.flurry.org.codehaus.jackson.map.JsonMappingException;
import com.flurry.org.codehaus.jackson.map.TypeDeserializer;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedField;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedMember;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedMethod;
import com.flurry.org.codehaus.jackson.map.util.Annotations;
import com.flurry.org.codehaus.jackson.map.util.ClassUtil;
import com.flurry.org.codehaus.jackson.type.JavaType;
import com.flurry.org.codehaus.jackson.util.InternCache;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public abstract class SettableBeanProperty
    implements BeanProperty
{
    public static final class FieldProperty extends SettableBeanProperty
    {

        protected final AnnotatedField _annotated;
        protected final Field _field;

        public void deserializeAndSet(JsonParser jsonparser, DeserializationContext deserializationcontext, Object obj)
            throws IOException, JsonProcessingException
        {
            set(obj, deserialize(jsonparser, deserializationcontext));
        }

        public Annotation getAnnotation(Class class1)
        {
            return _annotated.getAnnotation(class1);
        }

        public AnnotatedMember getMember()
        {
            return _annotated;
        }

        public final void set(Object obj, Object obj1)
            throws IOException
        {
            try
            {
                _field.set(obj, obj1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                _throwAsIOE(((Exception) (obj)), obj1);
            }
        }

        public FieldProperty withValueDeserializer(JsonDeserializer jsondeserializer)
        {
            return new FieldProperty(this, jsondeserializer);
        }

        public volatile SettableBeanProperty withValueDeserializer(JsonDeserializer jsondeserializer)
        {
            return withValueDeserializer(jsondeserializer);
        }

        protected FieldProperty(FieldProperty fieldproperty, JsonDeserializer jsondeserializer)
        {
            super(fieldproperty, jsondeserializer);
            _annotated = fieldproperty._annotated;
            _field = fieldproperty._field;
        }

        public FieldProperty(String s, JavaType javatype, TypeDeserializer typedeserializer, Annotations annotations, AnnotatedField annotatedfield)
        {
            super(s, javatype, typedeserializer, annotations);
            _annotated = annotatedfield;
            _field = annotatedfield.getAnnotated();
        }
    }

    public static final class InnerClassProperty extends SettableBeanProperty
    {

        protected final Constructor _creator;
        protected final SettableBeanProperty _delegate;

        public void deserializeAndSet(JsonParser jsonparser, DeserializationContext deserializationcontext, Object obj)
            throws IOException, JsonProcessingException
        {
            if (jsonparser.getCurrentToken() == JsonToken.VALUE_NULL)
            {
                if (_nullProvider == null)
                {
                    jsonparser = null;
                } else
                {
                    jsonparser = ((JsonParser) (_nullProvider.nullValue(deserializationcontext)));
                }
            } else
            if (_valueTypeDeserializer != null)
            {
                jsonparser = ((JsonParser) (_valueDeserializer.deserializeWithType(jsonparser, deserializationcontext, _valueTypeDeserializer)));
            } else
            {
                Object obj1;
                try
                {
                    obj1 = _creator.newInstance(new Object[] {
                        obj
                    });
                }
                catch (Exception exception)
                {
                    ClassUtil.unwrapAndThrowAsIAE(exception, (new StringBuilder()).append("Failed to instantiate class ").append(_creator.getDeclaringClass().getName()).append(", problem: ").append(exception.getMessage()).toString());
                    exception = null;
                }
                _valueDeserializer.deserialize(jsonparser, deserializationcontext, obj1);
                jsonparser = ((JsonParser) (obj1));
            }
            set(obj, jsonparser);
        }

        public Annotation getAnnotation(Class class1)
        {
            return _delegate.getAnnotation(class1);
        }

        public AnnotatedMember getMember()
        {
            return _delegate.getMember();
        }

        public final void set(Object obj, Object obj1)
            throws IOException
        {
            _delegate.set(obj, obj1);
        }

        public InnerClassProperty withValueDeserializer(JsonDeserializer jsondeserializer)
        {
            return new InnerClassProperty(this, jsondeserializer);
        }

        public volatile SettableBeanProperty withValueDeserializer(JsonDeserializer jsondeserializer)
        {
            return withValueDeserializer(jsondeserializer);
        }

        protected InnerClassProperty(InnerClassProperty innerclassproperty, JsonDeserializer jsondeserializer)
        {
            super(innerclassproperty, jsondeserializer);
            _delegate = innerclassproperty._delegate.withValueDeserializer(jsondeserializer);
            _creator = innerclassproperty._creator;
        }

        public InnerClassProperty(SettableBeanProperty settablebeanproperty, Constructor constructor)
        {
            super(settablebeanproperty);
            _delegate = settablebeanproperty;
            _creator = constructor;
        }
    }

    public static final class ManagedReferenceProperty extends SettableBeanProperty
    {

        protected final SettableBeanProperty _backProperty;
        protected final boolean _isContainer;
        protected final SettableBeanProperty _managedProperty;
        protected final String _referenceName;

        public void deserializeAndSet(JsonParser jsonparser, DeserializationContext deserializationcontext, Object obj)
            throws IOException, JsonProcessingException
        {
            set(obj, _managedProperty.deserialize(jsonparser, deserializationcontext));
        }

        public Annotation getAnnotation(Class class1)
        {
            return _managedProperty.getAnnotation(class1);
        }

        public AnnotatedMember getMember()
        {
            return _managedProperty.getMember();
        }

        public final void set(Object obj, Object obj1)
            throws IOException
        {
            _managedProperty.set(obj, obj1);
            if (obj1 != null)
            {
                if (_isContainer)
                {
                    if (obj1 instanceof Object[])
                    {
                        obj1 = ((Object) ((Object[])(Object[])obj1));
                        int j = obj1.length;
                        for (int i = 0; i < j; i++)
                        {
                            Object obj2 = obj1[i];
                            if (obj2 != null)
                            {
                                _backProperty.set(obj2, obj);
                            }
                        }

                    } else
                    if (obj1 instanceof Collection)
                    {
                        obj1 = ((Collection)obj1).iterator();
                        do
                        {
                            if (!((Iterator) (obj1)).hasNext())
                            {
                                break;
                            }
                            Object obj3 = ((Iterator) (obj1)).next();
                            if (obj3 != null)
                            {
                                _backProperty.set(obj3, obj);
                            }
                        } while (true);
                    } else
                    if (obj1 instanceof Map)
                    {
                        obj1 = ((Map)obj1).values().iterator();
                        do
                        {
                            if (!((Iterator) (obj1)).hasNext())
                            {
                                break;
                            }
                            Object obj4 = ((Iterator) (obj1)).next();
                            if (obj4 != null)
                            {
                                _backProperty.set(obj4, obj);
                            }
                        } while (true);
                    } else
                    {
                        throw new IllegalStateException((new StringBuilder()).append("Unsupported container type (").append(obj1.getClass().getName()).append(") when resolving reference '").append(_referenceName).append("'").toString());
                    }
                } else
                {
                    _backProperty.set(obj1, obj);
                }
            }
        }

        public ManagedReferenceProperty withValueDeserializer(JsonDeserializer jsondeserializer)
        {
            return new ManagedReferenceProperty(this, jsondeserializer);
        }

        public volatile SettableBeanProperty withValueDeserializer(JsonDeserializer jsondeserializer)
        {
            return withValueDeserializer(jsondeserializer);
        }

        protected ManagedReferenceProperty(ManagedReferenceProperty managedreferenceproperty, JsonDeserializer jsondeserializer)
        {
            super(managedreferenceproperty, jsondeserializer);
            _referenceName = managedreferenceproperty._referenceName;
            _isContainer = managedreferenceproperty._isContainer;
            _managedProperty = managedreferenceproperty._managedProperty;
            _backProperty = managedreferenceproperty._backProperty;
        }

        public ManagedReferenceProperty(String s, SettableBeanProperty settablebeanproperty, SettableBeanProperty settablebeanproperty1, Annotations annotations, boolean flag)
        {
            super(settablebeanproperty.getName(), settablebeanproperty.getType(), settablebeanproperty._valueTypeDeserializer, annotations);
            _referenceName = s;
            _managedProperty = settablebeanproperty;
            _backProperty = settablebeanproperty1;
            _isContainer = flag;
        }
    }

    public static final class MethodProperty extends SettableBeanProperty
    {

        protected final AnnotatedMethod _annotated;
        protected final Method _setter;

        public void deserializeAndSet(JsonParser jsonparser, DeserializationContext deserializationcontext, Object obj)
            throws IOException, JsonProcessingException
        {
            set(obj, deserialize(jsonparser, deserializationcontext));
        }

        public Annotation getAnnotation(Class class1)
        {
            return _annotated.getAnnotation(class1);
        }

        public AnnotatedMember getMember()
        {
            return _annotated;
        }

        public final void set(Object obj, Object obj1)
            throws IOException
        {
            try
            {
                _setter.invoke(obj, new Object[] {
                    obj1
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                _throwAsIOE(((Exception) (obj)), obj1);
            }
        }

        public MethodProperty withValueDeserializer(JsonDeserializer jsondeserializer)
        {
            return new MethodProperty(this, jsondeserializer);
        }

        public volatile SettableBeanProperty withValueDeserializer(JsonDeserializer jsondeserializer)
        {
            return withValueDeserializer(jsondeserializer);
        }

        protected MethodProperty(MethodProperty methodproperty, JsonDeserializer jsondeserializer)
        {
            super(methodproperty, jsondeserializer);
            _annotated = methodproperty._annotated;
            _setter = methodproperty._setter;
        }

        public MethodProperty(String s, JavaType javatype, TypeDeserializer typedeserializer, Annotations annotations, AnnotatedMethod annotatedmethod)
        {
            super(s, javatype, typedeserializer, annotations);
            _annotated = annotatedmethod;
            _setter = annotatedmethod.getAnnotated();
        }
    }

    protected static final class NullProvider
    {

        private final boolean _isPrimitive;
        private final Object _nullValue;
        private final Class _rawType;

        public Object nullValue(DeserializationContext deserializationcontext)
            throws JsonProcessingException
        {
            if (_isPrimitive && deserializationcontext.isEnabled(com.flurry.org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_NULL_FOR_PRIMITIVES))
            {
                throw deserializationcontext.mappingException((new StringBuilder()).append("Can not map JSON null into type ").append(_rawType.getName()).append(" (set DeserializationConfig.Feature.FAIL_ON_NULL_FOR_PRIMITIVES to 'false' to allow)").toString());
            } else
            {
                return _nullValue;
            }
        }

        protected NullProvider(JavaType javatype, Object obj)
        {
            _nullValue = obj;
            _isPrimitive = javatype.isPrimitive();
            _rawType = javatype.getRawClass();
        }
    }

    public static final class SetterlessProperty extends SettableBeanProperty
    {

        protected final AnnotatedMethod _annotated;
        protected final Method _getter;

        public final void deserializeAndSet(JsonParser jsonparser, DeserializationContext deserializationcontext, Object obj)
            throws IOException, JsonProcessingException
        {
            if (jsonparser.getCurrentToken() == JsonToken.VALUE_NULL)
            {
                return;
            }
            try
            {
                obj = _getter.invoke(obj, new Object[0]);
            }
            // Misplaced declaration of an exception variable
            catch (JsonParser jsonparser)
            {
                _throwAsIOE(jsonparser);
                return;
            }
            if (obj == null)
            {
                throw new JsonMappingException((new StringBuilder()).append("Problem deserializing 'setterless' property '").append(getName()).append("': get method returned null").toString());
            } else
            {
                _valueDeserializer.deserialize(jsonparser, deserializationcontext, obj);
                return;
            }
        }

        public Annotation getAnnotation(Class class1)
        {
            return _annotated.getAnnotation(class1);
        }

        public AnnotatedMember getMember()
        {
            return _annotated;
        }

        public final void set(Object obj, Object obj1)
            throws IOException
        {
            throw new UnsupportedOperationException("Should never call 'set' on setterless property");
        }

        public SetterlessProperty withValueDeserializer(JsonDeserializer jsondeserializer)
        {
            return new SetterlessProperty(this, jsondeserializer);
        }

        public volatile SettableBeanProperty withValueDeserializer(JsonDeserializer jsondeserializer)
        {
            return withValueDeserializer(jsondeserializer);
        }

        protected SetterlessProperty(SetterlessProperty setterlessproperty, JsonDeserializer jsondeserializer)
        {
            super(setterlessproperty, jsondeserializer);
            _annotated = setterlessproperty._annotated;
            _getter = setterlessproperty._getter;
        }

        public SetterlessProperty(String s, JavaType javatype, TypeDeserializer typedeserializer, Annotations annotations, AnnotatedMethod annotatedmethod)
        {
            super(s, javatype, typedeserializer, annotations);
            _annotated = annotatedmethod;
            _getter = annotatedmethod.getAnnotated();
        }
    }


    protected final Annotations _contextAnnotations;
    protected String _managedReferenceName;
    protected NullProvider _nullProvider;
    protected final String _propName;
    protected int _propertyIndex;
    protected final JavaType _type;
    protected JsonDeserializer _valueDeserializer;
    protected TypeDeserializer _valueTypeDeserializer;

    protected SettableBeanProperty(SettableBeanProperty settablebeanproperty)
    {
        _propertyIndex = -1;
        _propName = settablebeanproperty._propName;
        _type = settablebeanproperty._type;
        _contextAnnotations = settablebeanproperty._contextAnnotations;
        _valueDeserializer = settablebeanproperty._valueDeserializer;
        _valueTypeDeserializer = settablebeanproperty._valueTypeDeserializer;
        _nullProvider = settablebeanproperty._nullProvider;
        _managedReferenceName = settablebeanproperty._managedReferenceName;
        _propertyIndex = settablebeanproperty._propertyIndex;
    }

    protected SettableBeanProperty(SettableBeanProperty settablebeanproperty, JsonDeserializer jsondeserializer)
    {
        Object obj = null;
        super();
        _propertyIndex = -1;
        _propName = settablebeanproperty._propName;
        _type = settablebeanproperty._type;
        _contextAnnotations = settablebeanproperty._contextAnnotations;
        _valueTypeDeserializer = settablebeanproperty._valueTypeDeserializer;
        _managedReferenceName = settablebeanproperty._managedReferenceName;
        _propertyIndex = settablebeanproperty._propertyIndex;
        _valueDeserializer = jsondeserializer;
        if (jsondeserializer == null)
        {
            _nullProvider = null;
            return;
        }
        settablebeanproperty = ((SettableBeanProperty) (jsondeserializer.getNullValue()));
        if (settablebeanproperty == null)
        {
            settablebeanproperty = obj;
        } else
        {
            settablebeanproperty = new NullProvider(_type, settablebeanproperty);
        }
        _nullProvider = settablebeanproperty;
    }

    protected SettableBeanProperty(String s, JavaType javatype, TypeDeserializer typedeserializer, Annotations annotations)
    {
        _propertyIndex = -1;
        if (s == null || s.length() == 0)
        {
            _propName = "";
        } else
        {
            _propName = InternCache.instance.intern(s);
        }
        _type = javatype;
        _contextAnnotations = annotations;
        _valueTypeDeserializer = typedeserializer;
    }

    protected IOException _throwAsIOE(Exception exception)
        throws IOException
    {
        if (exception instanceof IOException)
        {
            throw (IOException)exception;
        }
        if (exception instanceof RuntimeException)
        {
            throw (RuntimeException)exception;
        }
        for (; exception.getCause() != null; exception = exception.getCause()) { }
        throw new JsonMappingException(exception.getMessage(), null, exception);
    }

    protected void _throwAsIOE(Exception exception, Object obj)
        throws IOException
    {
        if (exception instanceof IllegalArgumentException)
        {
            StringBuilder stringbuilder;
            if (obj == null)
            {
                obj = "[NULL]";
            } else
            {
                obj = obj.getClass().getName();
            }
            stringbuilder = (new StringBuilder("Problem deserializing property '")).append(getPropertyName());
            stringbuilder.append("' (expected type: ").append(getType());
            stringbuilder.append("; actual type: ").append(((String) (obj))).append(")");
            obj = exception.getMessage();
            if (obj != null)
            {
                stringbuilder.append(", problem: ").append(((String) (obj)));
            } else
            {
                stringbuilder.append(" (no error message provided)");
            }
            throw new JsonMappingException(stringbuilder.toString(), null, exception);
        } else
        {
            _throwAsIOE(exception);
            return;
        }
    }

    public void assignIndex(int i)
    {
        if (_propertyIndex != -1)
        {
            throw new IllegalStateException((new StringBuilder()).append("Property '").append(getName()).append("' already had index (").append(_propertyIndex).append("), trying to assign ").append(i).toString());
        } else
        {
            _propertyIndex = i;
            return;
        }
    }

    public final Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        if (jsonparser.getCurrentToken() == JsonToken.VALUE_NULL)
        {
            if (_nullProvider == null)
            {
                return null;
            } else
            {
                return _nullProvider.nullValue(deserializationcontext);
            }
        }
        if (_valueTypeDeserializer != null)
        {
            return _valueDeserializer.deserializeWithType(jsonparser, deserializationcontext, _valueTypeDeserializer);
        } else
        {
            return _valueDeserializer.deserialize(jsonparser, deserializationcontext);
        }
    }

    public abstract void deserializeAndSet(JsonParser jsonparser, DeserializationContext deserializationcontext, Object obj)
        throws IOException, JsonProcessingException;

    public abstract Annotation getAnnotation(Class class1);

    public Annotation getContextAnnotation(Class class1)
    {
        return _contextAnnotations.get(class1);
    }

    protected final Class getDeclaringClass()
    {
        return getMember().getDeclaringClass();
    }

    public Object getInjectableValueId()
    {
        return null;
    }

    public String getManagedReferenceName()
    {
        return _managedReferenceName;
    }

    public abstract AnnotatedMember getMember();

    public final String getName()
    {
        return _propName;
    }

    public int getPropertyIndex()
    {
        return _propertyIndex;
    }

    public String getPropertyName()
    {
        return _propName;
    }

    public int getProperytIndex()
    {
        return getPropertyIndex();
    }

    public JavaType getType()
    {
        return _type;
    }

    public JsonDeserializer getValueDeserializer()
    {
        return _valueDeserializer;
    }

    public TypeDeserializer getValueTypeDeserializer()
    {
        return _valueTypeDeserializer;
    }

    public boolean hasValueDeserializer()
    {
        return _valueDeserializer != null;
    }

    public boolean hasValueTypeDeserializer()
    {
        return _valueTypeDeserializer != null;
    }

    public abstract void set(Object obj, Object obj1)
        throws IOException;

    public void setManagedReferenceName(String s)
    {
        _managedReferenceName = s;
    }

    public void setValueDeserializer(JsonDeserializer jsondeserializer)
    {
        if (_valueDeserializer != null)
        {
            throw new IllegalStateException((new StringBuilder()).append("Already had assigned deserializer for property '").append(getName()).append("' (class ").append(getDeclaringClass().getName()).append(")").toString());
        }
        _valueDeserializer = jsondeserializer;
        jsondeserializer = ((JsonDeserializer) (_valueDeserializer.getNullValue()));
        if (jsondeserializer == null)
        {
            jsondeserializer = null;
        } else
        {
            jsondeserializer = new NullProvider(_type, jsondeserializer);
        }
        _nullProvider = jsondeserializer;
    }

    public String toString()
    {
        return (new StringBuilder()).append("[property '").append(getName()).append("']").toString();
    }

    public abstract SettableBeanProperty withValueDeserializer(JsonDeserializer jsondeserializer);
}
