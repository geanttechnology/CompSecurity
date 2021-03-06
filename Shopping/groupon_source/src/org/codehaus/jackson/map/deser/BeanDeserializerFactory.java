// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map.deser;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.codehaus.jackson.map.AbstractTypeResolver;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.BeanPropertyDefinition;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializerFactory;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.Deserializers;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.KeyDeserializer;
import org.codehaus.jackson.map.KeyDeserializers;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.deser.impl.CreatorCollector;
import org.codehaus.jackson.map.deser.impl.CreatorProperty;
import org.codehaus.jackson.map.deser.std.ThrowableDeserializer;
import org.codehaus.jackson.map.introspect.AnnotatedConstructor;
import org.codehaus.jackson.map.introspect.AnnotatedField;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.introspect.AnnotatedParameter;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;
import org.codehaus.jackson.map.introspect.VisibilityChecker;
import org.codehaus.jackson.map.type.ArrayType;
import org.codehaus.jackson.map.type.CollectionLikeType;
import org.codehaus.jackson.map.type.CollectionType;
import org.codehaus.jackson.map.type.MapLikeType;
import org.codehaus.jackson.map.type.MapType;
import org.codehaus.jackson.map.type.TypeBindings;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.map.util.ArrayBuilders;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;

// Referenced classes of package org.codehaus.jackson.map.deser:
//            BasicDeserializerFactory, BeanDeserializerBuilder, ValueInstantiator, AbstractDeserializer, 
//            BeanDeserializerModifier, BeanDeserializer, SettableAnyProperty, SettableBeanProperty, 
//            ValueInstantiators

public class BeanDeserializerFactory extends BasicDeserializerFactory
{
    public static class ConfigImpl extends org.codehaus.jackson.map.DeserializerFactory.Config
    {

        protected static final AbstractTypeResolver NO_ABSTRACT_TYPE_RESOLVERS[] = new AbstractTypeResolver[0];
        protected static final KeyDeserializers NO_KEY_DESERIALIZERS[] = new KeyDeserializers[0];
        protected static final BeanDeserializerModifier NO_MODIFIERS[] = new BeanDeserializerModifier[0];
        protected static final ValueInstantiators NO_VALUE_INSTANTIATORS[] = new ValueInstantiators[0];
        protected final AbstractTypeResolver _abstractTypeResolvers[];
        protected final Deserializers _additionalDeserializers[];
        protected final KeyDeserializers _additionalKeyDeserializers[];
        protected final BeanDeserializerModifier _modifiers[];
        protected final ValueInstantiators _valueInstantiators[];

        public Iterable abstractTypeResolvers()
        {
            return ArrayBuilders.arrayAsIterable(_abstractTypeResolvers);
        }

        public Iterable deserializerModifiers()
        {
            return ArrayBuilders.arrayAsIterable(_modifiers);
        }

        public Iterable deserializers()
        {
            return ArrayBuilders.arrayAsIterable(_additionalDeserializers);
        }

        public boolean hasAbstractTypeResolvers()
        {
            return _abstractTypeResolvers.length > 0;
        }

        public boolean hasDeserializerModifiers()
        {
            return _modifiers.length > 0;
        }

        public boolean hasKeyDeserializers()
        {
            return _additionalKeyDeserializers.length > 0;
        }

        public boolean hasValueInstantiators()
        {
            return _valueInstantiators.length > 0;
        }

        public Iterable keyDeserializers()
        {
            return ArrayBuilders.arrayAsIterable(_additionalKeyDeserializers);
        }

        public Iterable valueInstantiators()
        {
            return ArrayBuilders.arrayAsIterable(_valueInstantiators);
        }

        public org.codehaus.jackson.map.DeserializerFactory.Config withAbstractTypeResolver(AbstractTypeResolver abstracttyperesolver)
        {
            if (abstracttyperesolver == null)
            {
                throw new IllegalArgumentException("Can not pass null resolver");
            } else
            {
                abstracttyperesolver = (AbstractTypeResolver[])ArrayBuilders.insertInListNoDup(_abstractTypeResolvers, abstracttyperesolver);
                return new ConfigImpl(_additionalDeserializers, _additionalKeyDeserializers, _modifiers, abstracttyperesolver, _valueInstantiators);
            }
        }

        public org.codehaus.jackson.map.DeserializerFactory.Config withAdditionalDeserializers(Deserializers deserializers1)
        {
            if (deserializers1 == null)
            {
                throw new IllegalArgumentException("Can not pass null Deserializers");
            } else
            {
                return new ConfigImpl((Deserializers[])ArrayBuilders.insertInListNoDup(_additionalDeserializers, deserializers1), _additionalKeyDeserializers, _modifiers, _abstractTypeResolvers, _valueInstantiators);
            }
        }

        public org.codehaus.jackson.map.DeserializerFactory.Config withAdditionalKeyDeserializers(KeyDeserializers keydeserializers)
        {
            if (keydeserializers == null)
            {
                throw new IllegalArgumentException("Can not pass null KeyDeserializers");
            } else
            {
                keydeserializers = (KeyDeserializers[])ArrayBuilders.insertInListNoDup(_additionalKeyDeserializers, keydeserializers);
                return new ConfigImpl(_additionalDeserializers, keydeserializers, _modifiers, _abstractTypeResolvers, _valueInstantiators);
            }
        }

        public org.codehaus.jackson.map.DeserializerFactory.Config withValueInstantiators(ValueInstantiators valueinstantiators)
        {
            if (valueinstantiators == null)
            {
                throw new IllegalArgumentException("Can not pass null resolver");
            } else
            {
                valueinstantiators = (ValueInstantiators[])ArrayBuilders.insertInListNoDup(_valueInstantiators, valueinstantiators);
                return new ConfigImpl(_additionalDeserializers, _additionalKeyDeserializers, _modifiers, _abstractTypeResolvers, valueinstantiators);
            }
        }


        public ConfigImpl()
        {
            this(null, null, null, null, null);
        }

        protected ConfigImpl(Deserializers adeserializers[], KeyDeserializers akeydeserializers[], BeanDeserializerModifier abeandeserializermodifier[], AbstractTypeResolver aabstracttyperesolver[], ValueInstantiators avalueinstantiators[])
        {
            Deserializers adeserializers1[] = adeserializers;
            if (adeserializers == null)
            {
                adeserializers1 = 
// JavaClassFileOutputException: get_constant: invalid tag
    }


    private static final Class INIT_CAUSE_PARAMS[] = {
        java/lang/Throwable
    };
    public static final BeanDeserializerFactory instance = new BeanDeserializerFactory(null);
    protected final org.codehaus.jackson.map.DeserializerFactory.Config _factoryConfig;

    public BeanDeserializerFactory()
    {
        BeanDeserializerFactory(null);
    }

    public BeanDeserializerFactory(org.codehaus.jackson.map.DeserializerFactory.Config config)
    {
        Object obj = config;
        if (config == null)
        {
            obj = new ConfigImpl();
        }
        _factoryConfig = ((org.codehaus.jackson.map.DeserializerFactory.Config) (obj));
    }

    protected void _addDeserializerConstructors(DeserializationConfig deserializationconfig, BasicBeanDescription basicbeandescription, VisibilityChecker visibilitychecker, AnnotationIntrospector annotationintrospector, CreatorCollector creatorcollector)
        throws JsonMappingException
    {
        Iterator iterator = basicbeandescription.getConstructors().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            AnnotatedConstructor annotatedconstructor = (AnnotatedConstructor)iterator.next();
            int j = annotatedconstructor.getParameterCount();
            if (j >= 1)
            {
                boolean flag4 = annotationintrospector.hasCreatorAnnotation(annotatedconstructor);
                boolean flag5 = visibilitychecker.isCreatorVisible(annotatedconstructor);
                if (j == 1)
                {
                    AnnotatedParameter annotatedparameter = annotatedconstructor.getParameter(0);
                    String s1 = annotationintrospector.findPropertyNameForParam(annotatedparameter);
                    Object obj = annotationintrospector.findInjectableValueId(annotatedparameter);
                    if (obj != null || s1 != null && s1.length() > 0)
                    {
                        creatorcollector.addPropertyCreator(annotatedconstructor, new CreatorProperty[] {
                            constructCreatorProperty(deserializationconfig, basicbeandescription, s1, 0, annotatedparameter, obj)
                        });
                    } else
                    {
                        Class class1 = annotatedconstructor.getParameterClass(0);
                        if (class1 == java/lang/String)
                        {
                            if (flag4 || flag5)
                            {
                                creatorcollector.addStringCreator(annotatedconstructor);
                            }
                        } else
                        if (class1 == Integer.TYPE || class1 == java/lang/Integer)
                        {
                            if (flag4 || flag5)
                            {
                                creatorcollector.addIntCreator(annotatedconstructor);
                            }
                        } else
                        if (class1 == Long.TYPE || class1 == java/lang/Long)
                        {
                            if (flag4 || flag5)
                            {
                                creatorcollector.addLongCreator(annotatedconstructor);
                            }
                        } else
                        if (class1 == Double.TYPE || class1 == java/lang/Double)
                        {
                            if (flag4 || flag5)
                            {
                                creatorcollector.addDoubleCreator(annotatedconstructor);
                            }
                        } else
                        if (flag4)
                        {
                            creatorcollector.addDelegatingCreator(annotatedconstructor);
                        }
                    }
                } else
                if (flag4 || flag5)
                {
                    boolean flag = false;
                    boolean flag1 = false;
                    CreatorProperty acreatorproperty[] = new CreatorProperty[j];
                    for (int i = 0; i < j;)
                    {
                        AnnotatedParameter annotatedparameter1 = annotatedconstructor.getParameter(i);
                        String s;
                        Object obj1;
                        boolean flag2;
                        boolean flag3;
                        if (annotatedparameter1 == null)
                        {
                            s = null;
                        } else
                        {
                            s = annotationintrospector.findPropertyNameForParam(annotatedparameter1);
                        }
                        obj1 = annotationintrospector.findInjectableValueId(annotatedparameter1);
                        if (s != null && s.length() > 0)
                        {
                            flag2 = true;
                        } else
                        {
                            flag2 = false;
                        }
                        if (obj1 != null)
                        {
                            flag3 = true;
                        } else
                        {
                            flag3 = false;
                        }
                        if (!flag2 && !flag3)
                        {
                            flag2 = true;
                        } else
                        {
                            flag2 = false;
                        }
                        flag2 = flag1 | flag2;
                        if (!flag2)
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        flag |= flag1;
                        if (flag2 && (flag || flag4))
                        {
                            throw new IllegalArgumentException((new StringBuilder()).append("Argument #").append(i).append(" of constructor ").append(annotatedconstructor).append(" has no property name annotation; must have name when multiple-paramater constructor annotated as Creator").toString());
                        }
                        if (!flag2)
                        {
                            acreatorproperty[i] = constructCreatorProperty(deserializationconfig, basicbeandescription, s, i, annotatedparameter1, obj1);
                        }
                        i++;
                        flag1 = flag2;
                    }

                    if (flag)
                    {
                        creatorcollector.addPropertyCreator(annotatedconstructor, acreatorproperty);
                    }
                }
            }
        } while (true);
    }

    protected void _addDeserializerFactoryMethods(DeserializationConfig deserializationconfig, BasicBeanDescription basicbeandescription, VisibilityChecker visibilitychecker, AnnotationIntrospector annotationintrospector, CreatorCollector creatorcollector)
        throws JsonMappingException
    {
        Iterator iterator = basicbeandescription.getFactoryMethods().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            AnnotatedMethod annotatedmethod = (AnnotatedMethod)iterator.next();
            int j = annotatedmethod.getParameterCount();
            if (j < 1)
            {
                continue;
            }
            boolean flag = annotationintrospector.hasCreatorAnnotation(annotatedmethod);
            if (j == 1)
            {
                AnnotatedParameter annotatedparameter = annotatedmethod.getParameter(0);
                String s = annotationintrospector.findPropertyNameForParam(annotatedparameter);
                if (annotationintrospector.findInjectableValueId(annotatedparameter) == null && (s == null || s.length() == 0))
                {
                    Class class1 = annotatedmethod.getParameterClass(0);
                    if (class1 == java/lang/String)
                    {
                        if (flag || visibilitychecker.isCreatorVisible(annotatedmethod))
                        {
                            creatorcollector.addStringCreator(annotatedmethod);
                        }
                    } else
                    if (class1 == Integer.TYPE || class1 == java/lang/Integer)
                    {
                        if (flag || visibilitychecker.isCreatorVisible(annotatedmethod))
                        {
                            creatorcollector.addIntCreator(annotatedmethod);
                        }
                    } else
                    if (class1 == Long.TYPE || class1 == java/lang/Long)
                    {
                        if (flag || visibilitychecker.isCreatorVisible(annotatedmethod))
                        {
                            creatorcollector.addLongCreator(annotatedmethod);
                        }
                    } else
                    if (class1 == Double.TYPE || class1 == java/lang/Double)
                    {
                        if (flag || visibilitychecker.isCreatorVisible(annotatedmethod))
                        {
                            creatorcollector.addDoubleCreator(annotatedmethod);
                        }
                    } else
                    if (class1 == Boolean.TYPE || class1 == java/lang/Boolean)
                    {
                        if (flag || visibilitychecker.isCreatorVisible(annotatedmethod))
                        {
                            creatorcollector.addBooleanCreator(annotatedmethod);
                        }
                    } else
                    if (annotationintrospector.hasCreatorAnnotation(annotatedmethod))
                    {
                        creatorcollector.addDelegatingCreator(annotatedmethod);
                    }
                    continue;
                }
            } else
            if (!annotationintrospector.hasCreatorAnnotation(annotatedmethod))
            {
                continue;
            }
            CreatorProperty acreatorproperty[] = new CreatorProperty[j];
            for (int i = 0; i < j; i++)
            {
                AnnotatedParameter annotatedparameter1 = annotatedmethod.getParameter(i);
                String s1 = annotationintrospector.findPropertyNameForParam(annotatedparameter1);
                Object obj = annotationintrospector.findInjectableValueId(annotatedparameter1);
                if ((s1 == null || s1.length() == 0) && obj == null)
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("Argument #").append(i).append(" of factory method ").append(annotatedmethod).append(" has no property name annotation; must have when multiple-paramater static method annotated as Creator").toString());
                }
                acreatorproperty[i] = constructCreatorProperty(deserializationconfig, basicbeandescription, s1, i, annotatedparameter1, obj);
            }

            creatorcollector.addPropertyCreator(annotatedmethod, acreatorproperty);
        } while (true);
    }

    protected JsonDeserializer _findCustomArrayDeserializer(ArrayType arraytype, DeserializationConfig deserializationconfig, DeserializerProvider deserializerprovider, BeanProperty beanproperty, TypeDeserializer typedeserializer, JsonDeserializer jsondeserializer)
        throws JsonMappingException
    {
        for (Iterator iterator = _factoryConfig.deserializers().iterator(); iterator.hasNext();)
        {
            JsonDeserializer jsondeserializer1 = ((Deserializers)iterator.next()).findArrayDeserializer(arraytype, deserializationconfig, deserializerprovider, beanproperty, typedeserializer, jsondeserializer);
            if (jsondeserializer1 != null)
            {
                return jsondeserializer1;
            }
        }

        return null;
    }

    protected JsonDeserializer _findCustomBeanDeserializer(JavaType javatype, DeserializationConfig deserializationconfig, DeserializerProvider deserializerprovider, BasicBeanDescription basicbeandescription, BeanProperty beanproperty)
        throws JsonMappingException
    {
        for (Iterator iterator = _factoryConfig.deserializers().iterator(); iterator.hasNext();)
        {
            JsonDeserializer jsondeserializer = ((Deserializers)iterator.next()).findBeanDeserializer(javatype, deserializationconfig, deserializerprovider, basicbeandescription, beanproperty);
            if (jsondeserializer != null)
            {
                return jsondeserializer;
            }
        }

        return null;
    }

    protected JsonDeserializer _findCustomCollectionDeserializer(CollectionType collectiontype, DeserializationConfig deserializationconfig, DeserializerProvider deserializerprovider, BasicBeanDescription basicbeandescription, BeanProperty beanproperty, TypeDeserializer typedeserializer, JsonDeserializer jsondeserializer)
        throws JsonMappingException
    {
        for (Iterator iterator = _factoryConfig.deserializers().iterator(); iterator.hasNext();)
        {
            JsonDeserializer jsondeserializer1 = ((Deserializers)iterator.next()).findCollectionDeserializer(collectiontype, deserializationconfig, deserializerprovider, basicbeandescription, beanproperty, typedeserializer, jsondeserializer);
            if (jsondeserializer1 != null)
            {
                return jsondeserializer1;
            }
        }

        return null;
    }

    protected JsonDeserializer _findCustomCollectionLikeDeserializer(CollectionLikeType collectionliketype, DeserializationConfig deserializationconfig, DeserializerProvider deserializerprovider, BasicBeanDescription basicbeandescription, BeanProperty beanproperty, TypeDeserializer typedeserializer, JsonDeserializer jsondeserializer)
        throws JsonMappingException
    {
        for (Iterator iterator = _factoryConfig.deserializers().iterator(); iterator.hasNext();)
        {
            JsonDeserializer jsondeserializer1 = ((Deserializers)iterator.next()).findCollectionLikeDeserializer(collectionliketype, deserializationconfig, deserializerprovider, basicbeandescription, beanproperty, typedeserializer, jsondeserializer);
            if (jsondeserializer1 != null)
            {
                return jsondeserializer1;
            }
        }

        return null;
    }

    protected JsonDeserializer _findCustomEnumDeserializer(Class class1, DeserializationConfig deserializationconfig, BasicBeanDescription basicbeandescription, BeanProperty beanproperty)
        throws JsonMappingException
    {
        for (Iterator iterator = _factoryConfig.deserializers().iterator(); iterator.hasNext();)
        {
            JsonDeserializer jsondeserializer = ((Deserializers)iterator.next()).findEnumDeserializer(class1, deserializationconfig, basicbeandescription, beanproperty);
            if (jsondeserializer != null)
            {
                return jsondeserializer;
            }
        }

        return null;
    }

    protected JsonDeserializer _findCustomMapDeserializer(MapType maptype, DeserializationConfig deserializationconfig, DeserializerProvider deserializerprovider, BasicBeanDescription basicbeandescription, BeanProperty beanproperty, KeyDeserializer keydeserializer, TypeDeserializer typedeserializer, 
            JsonDeserializer jsondeserializer)
        throws JsonMappingException
    {
        for (Iterator iterator = _factoryConfig.deserializers().iterator(); iterator.hasNext();)
        {
            JsonDeserializer jsondeserializer1 = ((Deserializers)iterator.next()).findMapDeserializer(maptype, deserializationconfig, deserializerprovider, basicbeandescription, beanproperty, keydeserializer, typedeserializer, jsondeserializer);
            if (jsondeserializer1 != null)
            {
                return jsondeserializer1;
            }
        }

        return null;
    }

    protected JsonDeserializer _findCustomMapLikeDeserializer(MapLikeType mapliketype, DeserializationConfig deserializationconfig, DeserializerProvider deserializerprovider, BasicBeanDescription basicbeandescription, BeanProperty beanproperty, KeyDeserializer keydeserializer, TypeDeserializer typedeserializer, 
            JsonDeserializer jsondeserializer)
        throws JsonMappingException
    {
        for (Iterator iterator = _factoryConfig.deserializers().iterator(); iterator.hasNext();)
        {
            JsonDeserializer jsondeserializer1 = ((Deserializers)iterator.next()).findMapLikeDeserializer(mapliketype, deserializationconfig, deserializerprovider, basicbeandescription, beanproperty, keydeserializer, typedeserializer, jsondeserializer);
            if (jsondeserializer1 != null)
            {
                return jsondeserializer1;
            }
        }

        return null;
    }

    protected JsonDeserializer _findCustomTreeNodeDeserializer(Class class1, DeserializationConfig deserializationconfig, BeanProperty beanproperty)
        throws JsonMappingException
    {
        for (Iterator iterator = _factoryConfig.deserializers().iterator(); iterator.hasNext();)
        {
            JsonDeserializer jsondeserializer = ((Deserializers)iterator.next()).findTreeNodeDeserializer(class1, deserializationconfig, beanproperty);
            if (jsondeserializer != null)
            {
                return jsondeserializer;
            }
        }

        return null;
    }

    protected JavaType _mapAbstractType2(DeserializationConfig deserializationconfig, JavaType javatype)
        throws JsonMappingException
    {
label0:
        {
            Class class1 = javatype.getRawClass();
            if (!_factoryConfig.hasAbstractTypeResolvers())
            {
                break label0;
            }
            Iterator iterator = _factoryConfig.abstractTypeResolvers().iterator();
            JavaType javatype1;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                javatype1 = ((AbstractTypeResolver)iterator.next()).findTypeMapping(deserializationconfig, javatype);
            } while (javatype1 == null || javatype1.getRawClass() == class1);
            return javatype1;
        }
        return null;
    }

    protected void addBeanProps(DeserializationConfig deserializationconfig, BasicBeanDescription basicbeandescription, BeanDeserializerBuilder beandeserializerbuilder)
        throws JsonMappingException
    {
        Object obj1 = basicbeandescription.findProperties();
        Object obj = deserializationconfig.getAnnotationIntrospector();
        Object obj2 = ((AnnotationIntrospector) (obj)).findIgnoreUnknownProperties(basicbeandescription.getClassInfo());
        if (obj2 != null)
        {
            beandeserializerbuilder.setIgnoreUnknownProperties(((Boolean) (obj2)).booleanValue());
        }
        obj = ArrayBuilders.arrayToSet(((AnnotationIntrospector) (obj)).findPropertiesToIgnore(basicbeandescription.getClassInfo()));
        for (obj2 = ((Set) (obj)).iterator(); ((Iterator) (obj2)).hasNext(); beandeserializerbuilder.addIgnorable((String)((Iterator) (obj2)).next())) { }
        obj2 = basicbeandescription.getIgnoredPropertyNames();
        if (obj2 != null)
        {
            for (obj2 = ((Collection) (obj2)).iterator(); ((Iterator) (obj2)).hasNext(); beandeserializerbuilder.addIgnorable((String)((Iterator) (obj2)).next())) { }
        }
        obj2 = new HashMap();
        Iterator iterator = ((List) (obj1)).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj5 = (BeanPropertyDefinition)iterator.next();
            Object obj4 = ((BeanPropertyDefinition) (obj5)).getName();
            if (!((Set) (obj)).contains(obj4))
            {
                if (((BeanPropertyDefinition) (obj5)).hasSetter())
                {
                    obj5 = ((BeanPropertyDefinition) (obj5)).getSetter();
                    if (isIgnorableType(deserializationconfig, basicbeandescription, ((AnnotatedMethod) (obj5)).getParameterClass(0), ((Map) (obj2))))
                    {
                        beandeserializerbuilder.addIgnorable(((String) (obj4)));
                    } else
                    {
                        obj4 = constructSettableProperty(deserializationconfig, basicbeandescription, ((String) (obj4)), ((AnnotatedMethod) (obj5)));
                        if (obj4 != null)
                        {
                            beandeserializerbuilder.addProperty(((SettableBeanProperty) (obj4)));
                        }
                    }
                } else
                if (((BeanPropertyDefinition) (obj5)).hasField())
                {
                    obj5 = ((BeanPropertyDefinition) (obj5)).getField();
                    if (isIgnorableType(deserializationconfig, basicbeandescription, ((AnnotatedField) (obj5)).getRawType(), ((Map) (obj2))))
                    {
                        beandeserializerbuilder.addIgnorable(((String) (obj4)));
                    } else
                    {
                        obj4 = constructSettableProperty(deserializationconfig, basicbeandescription, ((String) (obj4)), ((AnnotatedField) (obj5)));
                        if (obj4 != null)
                        {
                            beandeserializerbuilder.addProperty(((SettableBeanProperty) (obj4)));
                        }
                    }
                }
            }
        } while (true);
        obj2 = basicbeandescription.findAnySetter();
        if (obj2 != null)
        {
            beandeserializerbuilder.setAnySetter(constructAnySetter(deserializationconfig, basicbeandescription, ((AnnotatedMethod) (obj2))));
        }
        if (deserializationconfig.isEnabled(org.codehaus.jackson.map.DeserializationConfig.Feature.USE_GETTERS_AS_SETTERS))
        {
            obj1 = ((List) (obj1)).iterator();
            do
            {
                if (!((Iterator) (obj1)).hasNext())
                {
                    break;
                }
                Object obj3 = (BeanPropertyDefinition)((Iterator) (obj1)).next();
                if (((BeanPropertyDefinition) (obj3)).hasGetter())
                {
                    String s = ((BeanPropertyDefinition) (obj3)).getName();
                    if (!beandeserializerbuilder.hasProperty(s) && !((Set) (obj)).contains(s))
                    {
                        obj3 = ((BeanPropertyDefinition) (obj3)).getGetter();
                        Class class1 = ((AnnotatedMethod) (obj3)).getRawType();
                        if ((java/util/Collection.isAssignableFrom(class1) || java/util/Map.isAssignableFrom(class1)) && !((Set) (obj)).contains(s) && !beandeserializerbuilder.hasProperty(s))
                        {
                            beandeserializerbuilder.addProperty(constructSetterlessProperty(deserializationconfig, basicbeandescription, s, ((AnnotatedMethod) (obj3))));
                        }
                    }
                }
            } while (true);
        }
    }

    protected void addInjectables(DeserializationConfig deserializationconfig, BasicBeanDescription basicbeandescription, BeanDeserializerBuilder beandeserializerbuilder)
        throws JsonMappingException
    {
        Object obj = basicbeandescription.findInjectables();
        if (obj != null)
        {
            boolean flag = deserializationconfig.isEnabled(org.codehaus.jackson.map.DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS);
            AnnotatedMember annotatedmember;
            for (deserializationconfig = ((Map) (obj)).entrySet().iterator(); deserializationconfig.hasNext(); beandeserializerbuilder.addInjectable(annotatedmember.getName(), basicbeandescription.resolveType(annotatedmember.getGenericType()), basicbeandescription.getClassAnnotations(), annotatedmember, ((java.util.Map.Entry) (obj)).getKey()))
            {
                obj = (java.util.Map.Entry)deserializationconfig.next();
                annotatedmember = (AnnotatedMember)((java.util.Map.Entry) (obj)).getValue();
                if (flag)
                {
                    annotatedmember.fixAccess();
                }
            }

        }
    }

    protected void addReferenceProperties(DeserializationConfig deserializationconfig, BasicBeanDescription basicbeandescription, BeanDeserializerBuilder beandeserializerbuilder)
        throws JsonMappingException
    {
        Object obj = basicbeandescription.findBackReferenceProperties();
        if (obj != null)
        {
            for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext();)
            {
                Object obj1 = (java.util.Map.Entry)((Iterator) (obj)).next();
                String s = (String)((java.util.Map.Entry) (obj1)).getKey();
                obj1 = (AnnotatedMember)((java.util.Map.Entry) (obj1)).getValue();
                if (obj1 instanceof AnnotatedMethod)
                {
                    beandeserializerbuilder.addBackReferenceProperty(s, constructSettableProperty(deserializationconfig, basicbeandescription, ((AnnotatedMember) (obj1)).getName(), (AnnotatedMethod)obj1));
                } else
                {
                    beandeserializerbuilder.addBackReferenceProperty(s, constructSettableProperty(deserializationconfig, basicbeandescription, ((AnnotatedMember) (obj1)).getName(), (AnnotatedField)obj1));
                }
            }

        }
    }

    public JsonDeserializer buildBeanDeserializer(DeserializationConfig deserializationconfig, JavaType javatype, BasicBeanDescription basicbeandescription, BeanProperty beanproperty)
        throws JsonMappingException
    {
        Object obj = findValueInstantiator(deserializationconfig, basicbeandescription);
        if (!javatype.isAbstract() || ((ValueInstantiator) (obj)).canInstantiate()) goto _L2; else goto _L1
_L1:
        javatype = new AbstractDeserializer(javatype);
_L4:
        return javatype;
_L2:
        javatype = constructBeanDeserializerBuilder(basicbeandescription);
        javatype.setValueInstantiator(((ValueInstantiator) (obj)));
        addBeanProps(deserializationconfig, basicbeandescription, javatype);
        addReferenceProperties(deserializationconfig, basicbeandescription, javatype);
        addInjectables(deserializationconfig, basicbeandescription, javatype);
        obj = javatype;
        if (_factoryConfig.hasDeserializerModifiers())
        {
            Iterator iterator = _factoryConfig.deserializerModifiers().iterator();
            do
            {
                obj = javatype;
                if (!iterator.hasNext())
                {
                    break;
                }
                javatype = ((BeanDeserializerModifier)iterator.next()).updateBuilder(deserializationconfig, basicbeandescription, javatype);
            } while (true);
        }
        beanproperty = ((BeanDeserializerBuilder) (obj)).build(beanproperty);
        javatype = beanproperty;
        if (!_factoryConfig.hasDeserializerModifiers())
        {
            continue;
        }
        obj = _factoryConfig.deserializerModifiers().iterator();
        do
        {
            javatype = beanproperty;
            if (!((Iterator) (obj)).hasNext())
            {
                continue;
            }
            beanproperty = ((BeanDeserializerModifier)((Iterator) (obj)).next()).modifyDeserializer(deserializationconfig, basicbeandescription, beanproperty);
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public JsonDeserializer buildThrowableDeserializer(DeserializationConfig deserializationconfig, JavaType javatype, BasicBeanDescription basicbeandescription, BeanProperty beanproperty)
        throws JsonMappingException
    {
        javatype = constructBeanDeserializerBuilder(basicbeandescription);
        javatype.setValueInstantiator(findValueInstantiator(deserializationconfig, basicbeandescription));
        addBeanProps(deserializationconfig, basicbeandescription, javatype);
        Object obj = basicbeandescription.findMethod("initCause", INIT_CAUSE_PARAMS);
        if (obj != null)
        {
            obj = constructSettableProperty(deserializationconfig, basicbeandescription, "cause", ((AnnotatedMethod) (obj)));
            if (obj != null)
            {
                javatype.addOrReplaceProperty(((SettableBeanProperty) (obj)), true);
            }
        }
        javatype.addIgnorable("localizedMessage");
        javatype.addIgnorable("message");
        obj = javatype;
        if (_factoryConfig.hasDeserializerModifiers())
        {
            Iterator iterator1 = _factoryConfig.deserializerModifiers().iterator();
            do
            {
                obj = javatype;
                if (!iterator1.hasNext())
                {
                    break;
                }
                javatype = ((BeanDeserializerModifier)iterator1.next()).updateBuilder(deserializationconfig, basicbeandescription, javatype);
            } while (true);
        }
        beanproperty = ((BeanDeserializerBuilder) (obj)).build(beanproperty);
        javatype = beanproperty;
        if (beanproperty instanceof BeanDeserializer)
        {
            javatype = new ThrowableDeserializer((BeanDeserializer)beanproperty);
        }
        beanproperty = javatype;
        if (_factoryConfig.hasDeserializerModifiers())
        {
            Iterator iterator = _factoryConfig.deserializerModifiers().iterator();
            do
            {
                beanproperty = javatype;
                if (!iterator.hasNext())
                {
                    break;
                }
                javatype = ((BeanDeserializerModifier)iterator.next()).modifyDeserializer(deserializationconfig, basicbeandescription, javatype);
            } while (true);
        }
        return beanproperty;
    }

    protected SettableAnyProperty constructAnySetter(DeserializationConfig deserializationconfig, BasicBeanDescription basicbeandescription, AnnotatedMethod annotatedmethod)
        throws JsonMappingException
    {
        if (deserializationconfig.isEnabled(org.codehaus.jackson.map.DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS))
        {
            annotatedmethod.fixAccess();
        }
        Object obj = basicbeandescription.bindingsForBeanType().resolveType(annotatedmethod.getParameterType(1));
        org.codehaus.jackson.map.BeanProperty.Std std = new Std(annotatedmethod.getName(), ((JavaType) (obj)), basicbeandescription.getClassAnnotations(), annotatedmethod);
        basicbeandescription = resolveType(deserializationconfig, basicbeandescription, ((JavaType) (obj)), annotatedmethod, std);
        obj = findDeserializerFromAnnotation(deserializationconfig, annotatedmethod, std);
        if (obj != null)
        {
            return new SettableAnyProperty(std, annotatedmethod, basicbeandescription, ((JsonDeserializer) (obj)));
        } else
        {
            return new SettableAnyProperty(std, annotatedmethod, modifyTypeByAnnotation(deserializationconfig, annotatedmethod, basicbeandescription, std.getName()), null);
        }
    }

    protected BeanDeserializerBuilder constructBeanDeserializerBuilder(BasicBeanDescription basicbeandescription)
    {
        return new BeanDeserializerBuilder(basicbeandescription);
    }

    protected CreatorProperty constructCreatorProperty(DeserializationConfig deserializationconfig, BasicBeanDescription basicbeandescription, String s, int i, AnnotatedParameter annotatedparameter, Object obj)
        throws JsonMappingException
    {
        Object obj3 = deserializationconfig.getTypeFactory().constructType(annotatedparameter.getParameterType(), basicbeandescription.bindingsForBeanType());
        Object obj1 = new Std(s, ((JavaType) (obj3)), basicbeandescription.getClassAnnotations(), annotatedparameter);
        Object obj2 = resolveType(deserializationconfig, basicbeandescription, ((JavaType) (obj3)), annotatedparameter, ((BeanProperty) (obj1)));
        org.codehaus.jackson.map.BeanProperty.Std std = ((org.codehaus.jackson.map.BeanProperty.Std) (obj1));
        if (obj2 != obj3)
        {
            std = ((org.codehaus.jackson.map.BeanProperty.Std) (obj1)).withType(((JavaType) (obj2)));
        }
        obj3 = findDeserializerFromAnnotation(deserializationconfig, annotatedparameter, std);
        JavaType javatype = modifyTypeByAnnotation(deserializationconfig, annotatedparameter, ((JavaType) (obj2)), s);
        obj2 = (TypeDeserializer)javatype.getTypeHandler();
        obj1 = obj2;
        if (obj2 == null)
        {
            obj1 = findTypeDeserializer(deserializationconfig, javatype, std);
        }
        basicbeandescription = new CreatorProperty(s, javatype, ((TypeDeserializer) (obj1)), basicbeandescription.getClassAnnotations(), annotatedparameter, i, obj);
        deserializationconfig = basicbeandescription;
        if (obj3 != null)
        {
            deserializationconfig = basicbeandescription.withValueDeserializer(((JsonDeserializer) (obj3)));
        }
        return deserializationconfig;
    }

    protected ValueInstantiator constructDefaultValueInstantiator(DeserializationConfig deserializationconfig, BasicBeanDescription basicbeandescription)
        throws JsonMappingException
    {
        boolean flag = deserializationconfig.isEnabled(org.codehaus.jackson.map.DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS);
        CreatorCollector creatorcollector = new CreatorCollector(basicbeandescription, flag);
        AnnotationIntrospector annotationintrospector = deserializationconfig.getAnnotationIntrospector();
        if (basicbeandescription.getType().isConcrete())
        {
            AnnotatedConstructor annotatedconstructor = basicbeandescription.findDefaultConstructor();
            if (annotatedconstructor != null)
            {
                if (flag)
                {
                    ClassUtil.checkAndFixAccess(annotatedconstructor.getAnnotated());
                }
                creatorcollector.setDefaultConstructor(annotatedconstructor);
            }
        }
        VisibilityChecker visibilitychecker = deserializationconfig.getDefaultVisibilityChecker();
        visibilitychecker = deserializationconfig.getAnnotationIntrospector().findAutoDetectVisibility(basicbeandescription.getClassInfo(), visibilitychecker);
        _addDeserializerFactoryMethods(deserializationconfig, basicbeandescription, visibilitychecker, annotationintrospector, creatorcollector);
        _addDeserializerConstructors(deserializationconfig, basicbeandescription, visibilitychecker, annotationintrospector, creatorcollector);
        return creatorcollector.constructValueInstantiator(deserializationconfig);
    }

    protected SettableBeanProperty constructSettableProperty(DeserializationConfig deserializationconfig, BasicBeanDescription basicbeandescription, String s, AnnotatedField annotatedfield)
        throws JsonMappingException
    {
        if (deserializationconfig.isEnabled(org.codehaus.jackson.map.DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS))
        {
            annotatedfield.fixAccess();
        }
        JavaType javatype1 = basicbeandescription.bindingsForBeanType().resolveType(annotatedfield.getGenericType());
        Object obj1 = new Std(s, javatype1, basicbeandescription.getClassAnnotations(), annotatedfield);
        JavaType javatype = resolveType(deserializationconfig, basicbeandescription, javatype1, annotatedfield, ((BeanProperty) (obj1)));
        Object obj = obj1;
        if (javatype != javatype1)
        {
            obj = ((org.codehaus.jackson.map.BeanProperty.Std) (obj1)).withType(javatype);
        }
        obj = findDeserializerFromAnnotation(deserializationconfig, annotatedfield, ((BeanProperty) (obj)));
        obj1 = modifyTypeByAnnotation(deserializationconfig, annotatedfield, javatype, s);
        s = new FieldProperty(s, ((JavaType) (obj1)), (TypeDeserializer)((JavaType) (obj1)).getTypeHandler(), basicbeandescription.getClassAnnotations(), annotatedfield);
        basicbeandescription = s;
        if (obj != null)
        {
            basicbeandescription = s.withValueDeserializer(((JsonDeserializer) (obj)));
        }
        deserializationconfig = deserializationconfig.getAnnotationIntrospector().findReferenceType(annotatedfield);
        if (deserializationconfig != null && deserializationconfig.isManagedReference())
        {
            basicbeandescription.setManagedReferenceName(deserializationconfig.getName());
        }
        return basicbeandescription;
    }

    protected SettableBeanProperty constructSettableProperty(DeserializationConfig deserializationconfig, BasicBeanDescription basicbeandescription, String s, AnnotatedMethod annotatedmethod)
        throws JsonMappingException
    {
        if (deserializationconfig.isEnabled(org.codehaus.jackson.map.DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS))
        {
            annotatedmethod.fixAccess();
        }
        JavaType javatype1 = basicbeandescription.bindingsForBeanType().resolveType(annotatedmethod.getParameterType(0));
        Object obj1 = new Std(s, javatype1, basicbeandescription.getClassAnnotations(), annotatedmethod);
        JavaType javatype = resolveType(deserializationconfig, basicbeandescription, javatype1, annotatedmethod, ((BeanProperty) (obj1)));
        Object obj = obj1;
        if (javatype != javatype1)
        {
            obj = ((org.codehaus.jackson.map.BeanProperty.Std) (obj1)).withType(javatype);
        }
        obj = findDeserializerFromAnnotation(deserializationconfig, annotatedmethod, ((BeanProperty) (obj)));
        obj1 = modifyTypeByAnnotation(deserializationconfig, annotatedmethod, javatype, s);
        s = new MethodProperty(s, ((JavaType) (obj1)), (TypeDeserializer)((JavaType) (obj1)).getTypeHandler(), basicbeandescription.getClassAnnotations(), annotatedmethod);
        basicbeandescription = s;
        if (obj != null)
        {
            basicbeandescription = s.withValueDeserializer(((JsonDeserializer) (obj)));
        }
        deserializationconfig = deserializationconfig.getAnnotationIntrospector().findReferenceType(annotatedmethod);
        if (deserializationconfig != null && deserializationconfig.isManagedReference())
        {
            basicbeandescription.setManagedReferenceName(deserializationconfig.getName());
        }
        return basicbeandescription;
    }

    protected SettableBeanProperty constructSetterlessProperty(DeserializationConfig deserializationconfig, BasicBeanDescription basicbeandescription, String s, AnnotatedMethod annotatedmethod)
        throws JsonMappingException
    {
        if (deserializationconfig.isEnabled(org.codehaus.jackson.map.DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS))
        {
            annotatedmethod.fixAccess();
        }
        JavaType javatype = annotatedmethod.getType(basicbeandescription.bindingsForBeanType());
        JsonDeserializer jsondeserializer = findDeserializerFromAnnotation(deserializationconfig, annotatedmethod, new Std(s, javatype, basicbeandescription.getClassAnnotations(), annotatedmethod));
        deserializationconfig = modifyTypeByAnnotation(deserializationconfig, annotatedmethod, javatype, s);
        basicbeandescription = new SetterlessProperty(s, deserializationconfig, (TypeDeserializer)deserializationconfig.getTypeHandler(), basicbeandescription.getClassAnnotations(), annotatedmethod);
        deserializationconfig = basicbeandescription;
        if (jsondeserializer != null)
        {
            deserializationconfig = basicbeandescription.withValueDeserializer(jsondeserializer);
        }
        return deserializationconfig;
    }

    public JsonDeserializer createBeanDeserializer(DeserializationConfig deserializationconfig, DeserializerProvider deserializerprovider, JavaType javatype, BeanProperty beanproperty)
        throws JsonMappingException
    {
        Object obj = javatype;
        if (javatype.isAbstract())
        {
            obj = mapAbstractType(deserializationconfig, javatype);
        }
        BasicBeanDescription basicbeandescription = (BasicBeanDescription)deserializationconfig.introspect(((JavaType) (obj)));
        javatype = findDeserializerFromAnnotation(deserializationconfig, basicbeandescription.getClassInfo(), beanproperty);
        if (javatype != null)
        {
            return javatype;
        }
        JavaType javatype2 = modifyTypeByAnnotation(deserializationconfig, basicbeandescription.getClassInfo(), ((JavaType) (obj)), null);
        javatype = ((JavaType) (obj));
        if (javatype2.getRawClass() != ((JavaType) (obj)).getRawClass())
        {
            javatype = javatype2;
            basicbeandescription = (BasicBeanDescription)deserializationconfig.introspect(javatype);
        }
        obj = _findCustomBeanDeserializer(javatype, deserializationconfig, deserializerprovider, basicbeandescription, beanproperty);
        if (obj != null)
        {
            return ((JsonDeserializer) (obj));
        }
        if (javatype.isThrowable())
        {
            return buildThrowableDeserializer(deserializationconfig, javatype, basicbeandescription, beanproperty);
        }
        if (javatype.isAbstract())
        {
            JavaType javatype1 = materializeAbstractType(deserializationconfig, basicbeandescription);
            if (javatype1 != null)
            {
                return buildBeanDeserializer(deserializationconfig, javatype1, (BasicBeanDescription)deserializationconfig.introspect(javatype1), beanproperty);
            }
        }
        deserializerprovider = findStdBeanDeserializer(deserializationconfig, deserializerprovider, javatype, beanproperty);
        if (deserializerprovider != null)
        {
            return deserializerprovider;
        }
        if (!isPotentialBeanType(javatype.getRawClass()))
        {
            return null;
        } else
        {
            return buildBeanDeserializer(deserializationconfig, javatype, basicbeandescription, beanproperty);
        }
    }

    public KeyDeserializer createKeyDeserializer(DeserializationConfig deserializationconfig, JavaType javatype, BeanProperty beanproperty)
        throws JsonMappingException
    {
label0:
        {
            if (!_factoryConfig.hasKeyDeserializers())
            {
                break label0;
            }
            BasicBeanDescription basicbeandescription = (BasicBeanDescription)deserializationconfig.introspectClassAnnotations(javatype.getRawClass());
            Iterator iterator = _factoryConfig.keyDeserializers().iterator();
            KeyDeserializer keydeserializer;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                keydeserializer = ((KeyDeserializers)iterator.next()).findKeyDeserializer(javatype, deserializationconfig, basicbeandescription, beanproperty);
            } while (keydeserializer == null);
            return keydeserializer;
        }
        return null;
    }

    public ValueInstantiator findValueInstantiator(DeserializationConfig deserializationconfig, BasicBeanDescription basicbeandescription)
        throws JsonMappingException
    {
        Object obj1;
label0:
        {
            Object obj = basicbeandescription.getClassInfo();
            obj1 = deserializationconfig.getAnnotationIntrospector().findValueInstantiator(((org.codehaus.jackson.map.introspect.AnnotatedClass) (obj)));
            Iterator iterator;
            ValueInstantiators valueinstantiators;
            if (obj1 != null)
            {
                if (obj1 instanceof ValueInstantiator)
                {
                    obj = (ValueInstantiator)obj1;
                } else
                {
                    if (!(obj1 instanceof Class))
                    {
                        throw new IllegalStateException((new StringBuilder()).append("Invalid value instantiator returned for type ").append(basicbeandescription).append(": neither a Class nor ValueInstantiator").toString());
                    }
                    obj1 = (Class)obj1;
                    if (!org/codehaus/jackson/map/deser/ValueInstantiator.isAssignableFrom(((Class) (obj1))))
                    {
                        throw new IllegalStateException((new StringBuilder()).append("Invalid instantiator Class<?> returned for type ").append(basicbeandescription).append(": ").append(((Class) (obj1)).getName()).append(" not a ValueInstantiator").toString());
                    }
                    obj = deserializationconfig.valueInstantiatorInstance(((org.codehaus.jackson.map.introspect.Annotated) (obj)), ((Class) (obj1)));
                }
            } else
            {
                obj = constructDefaultValueInstantiator(deserializationconfig, basicbeandescription);
            }
            obj1 = obj;
            if (!_factoryConfig.hasValueInstantiators())
            {
                break label0;
            }
            iterator = _factoryConfig.valueInstantiators().iterator();
            do
            {
                obj1 = obj;
                if (!iterator.hasNext())
                {
                    break label0;
                }
                valueinstantiators = (ValueInstantiators)iterator.next();
                obj1 = valueinstantiators.findValueInstantiator(deserializationconfig, basicbeandescription, ((ValueInstantiator) (obj)));
                obj = obj1;
            } while (obj1 != null);
            throw new JsonMappingException((new StringBuilder()).append("Broken registered ValueInstantiators (of type ").append(valueinstantiators.getClass().getName()).append("): returned null ValueInstantiator").toString());
        }
        return ((ValueInstantiator) (obj1));
    }

    public final org.codehaus.jackson.map.DeserializerFactory.Config getConfig()
    {
        return _factoryConfig;
    }

    protected boolean isIgnorableType(DeserializationConfig deserializationconfig, BasicBeanDescription basicbeandescription, Class class1, Map map)
    {
        map = (Boolean)map.get(class1);
        basicbeandescription = map;
        if (map == null)
        {
            basicbeandescription = (BasicBeanDescription)deserializationconfig.introspectClassAnnotations(class1);
            deserializationconfig = deserializationconfig.getAnnotationIntrospector().isIgnorableType(basicbeandescription.getClassInfo());
            basicbeandescription = deserializationconfig;
            if (deserializationconfig == null)
            {
                basicbeandescription = Boolean.FALSE;
            }
        }
        return basicbeandescription.booleanValue();
    }

    protected boolean isPotentialBeanType(Class class1)
    {
        String s = ClassUtil.canBeABeanType(class1);
        if (s != null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Can not deserialize Class ").append(class1.getName()).append(" (of type ").append(s).append(") as a Bean").toString());
        }
        if (ClassUtil.isProxyType(class1))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Can not deserialize Proxy class ").append(class1.getName()).append(" as a Bean").toString());
        }
        s = ClassUtil.isLocalType(class1, true);
        if (s != null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Can not deserialize Class ").append(class1.getName()).append(" (of type ").append(s).append(") as a Bean").toString());
        } else
        {
            return true;
        }
    }

    public JavaType mapAbstractType(DeserializationConfig deserializationconfig, JavaType javatype)
        throws JsonMappingException
    {
        do
        {
            JavaType javatype1 = _mapAbstractType2(deserializationconfig, javatype);
            if (javatype1 == null)
            {
                return javatype;
            }
            Class class1 = javatype.getRawClass();
            Class class2 = javatype1.getRawClass();
            if (class1 == class2 || !class1.isAssignableFrom(class2))
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid abstract type resolution from ").append(javatype).append(" to ").append(javatype1).append(": latter is not a subtype of former").toString());
            }
            javatype = javatype1;
        } while (true);
    }

    protected JavaType materializeAbstractType(DeserializationConfig deserializationconfig, BasicBeanDescription basicbeandescription)
        throws JsonMappingException
    {
        basicbeandescription = basicbeandescription.getType();
        for (Iterator iterator = _factoryConfig.abstractTypeResolvers().iterator(); iterator.hasNext();)
        {
            JavaType javatype = ((AbstractTypeResolver)iterator.next()).resolveAbstractType(deserializationconfig, basicbeandescription);
            if (javatype != null)
            {
                return javatype;
            }
        }

        return null;
    }

    public DeserializerFactory withConfig(org.codehaus.jackson.map.DeserializerFactory.Config config)
    {
        if (_factoryConfig == config)
        {
            return this;
        }
        if (getClass() != org/codehaus/jackson/map/deser/BeanDeserializerFactory)
        {
            throw new IllegalStateException((new StringBuilder()).append("Subtype of BeanDeserializerFactory (").append(getClass().getName()).append(") has not properly overridden method 'withAdditionalDeserializers': can not instantiate subtype with ").append("additional deserializer definitions").toString());
        } else
        {
            return new BeanDeserializerFactory(config);
        }
    }


}
