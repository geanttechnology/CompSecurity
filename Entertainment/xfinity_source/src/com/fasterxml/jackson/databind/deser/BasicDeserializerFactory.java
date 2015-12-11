// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.annotation.NoClass;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.deser.impl.CreatorCollector;
import com.fasterxml.jackson.databind.deser.std.CollectionDeserializer;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.deser.std.EnumDeserializer;
import com.fasterxml.jackson.databind.deser.std.EnumMapDeserializer;
import com.fasterxml.jackson.databind.deser.std.EnumSetDeserializer;
import com.fasterxml.jackson.databind.deser.std.JacksonDeserializers;
import com.fasterxml.jackson.databind.deser.std.JdkDeserializers;
import com.fasterxml.jackson.databind.deser.std.JsonNodeDeserializer;
import com.fasterxml.jackson.databind.deser.std.MapDeserializer;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import com.fasterxml.jackson.databind.deser.std.ObjectArrayDeserializer;
import com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers;
import com.fasterxml.jackson.databind.deser.std.StringCollectionDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer;
import com.fasterxml.jackson.databind.ext.OptionalHandlerFactory;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.EnumResolver;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// Referenced classes of package com.fasterxml.jackson.databind.deser:
//            DeserializerFactory, CreatorProperty, Deserializers, ValueInstantiator, 
//            KeyDeserializers, ValueInstantiators, BeanDeserializerModifier

public abstract class BasicDeserializerFactory extends DeserializerFactory
    implements Serializable
{

    protected static final HashMap _arrayDeserializers = PrimitiveArrayDeserializers.getAll();
    static final HashMap _collectionFallbacks;
    protected static final HashMap _keyDeserializers = StdKeyDeserializers.constructAll();
    static final HashMap _mapFallbacks;
    protected static final HashMap _simpleDeserializers;
    private static final long serialVersionUID = 1L;
    protected final DeserializerFactoryConfig _factoryConfig;
    protected OptionalHandlerFactory optionalHandlers;

    protected BasicDeserializerFactory(DeserializerFactoryConfig deserializerfactoryconfig)
    {
        optionalHandlers = OptionalHandlerFactory.instance;
        _factoryConfig = deserializerfactoryconfig;
    }

    private static void _add(Map map, Class class1, StdDeserializer stddeserializer)
    {
        map.put(new ClassKey(class1), stddeserializer);
    }

    private static void _add(Map map, StdDeserializer astddeserializer[])
    {
        int j = astddeserializer.length;
        for (int i = 0; i < j; i++)
        {
            StdDeserializer stddeserializer = astddeserializer[i];
            _add(map, stddeserializer.getValueClass(), stddeserializer);
        }

    }

    private KeyDeserializer _createEnumKeyDeserializer(DeserializationContext deserializationcontext, JavaType javatype)
        throws JsonMappingException
    {
        DeserializationConfig deserializationconfig = deserializationcontext.getConfig();
        Object obj = deserializationconfig.introspect(javatype);
        JsonDeserializer jsondeserializer = findDeserializerFromAnnotation(deserializationcontext, ((BeanDescription) (obj)).getClassInfo());
        if (jsondeserializer != null)
        {
            return StdKeyDeserializers.constructDelegatingKeyDeserializer(deserializationconfig, javatype, jsondeserializer);
        }
        deserializationcontext = javatype.getRawClass();
        if (_findCustomEnumDeserializer(deserializationcontext, deserializationconfig, ((BeanDescription) (obj))) != null)
        {
            return StdKeyDeserializers.constructDelegatingKeyDeserializer(deserializationconfig, javatype, jsondeserializer);
        }
        javatype = constructEnumResolver(deserializationcontext, deserializationconfig, ((BeanDescription) (obj)).findJsonValueMethod());
        for (obj = ((BeanDescription) (obj)).getFactoryMethods().iterator(); ((Iterator) (obj)).hasNext();)
        {
            AnnotatedMethod annotatedmethod = (AnnotatedMethod)((Iterator) (obj)).next();
            if (deserializationconfig.getAnnotationIntrospector().hasCreatorAnnotation(annotatedmethod))
            {
                if (annotatedmethod.getParameterCount() == 1 && annotatedmethod.getRawReturnType().isAssignableFrom(deserializationcontext))
                {
                    if (annotatedmethod.getGenericParameterType(0) != java/lang/String)
                    {
                        throw new IllegalArgumentException((new StringBuilder()).append("Parameter #0 type for factory method (").append(annotatedmethod).append(") not suitable, must be java.lang.String").toString());
                    }
                    if (deserializationconfig.canOverrideAccessModifiers())
                    {
                        ClassUtil.checkAndFixAccess(annotatedmethod.getMember());
                    }
                    return StdKeyDeserializers.constructEnumKeyDeserializer(javatype, annotatedmethod);
                } else
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("Unsuitable method (").append(annotatedmethod).append(") decorated with @JsonCreator (for Enum type ").append(deserializationcontext.getName()).append(")").toString());
                }
            }
        }

        return StdKeyDeserializers.constructEnumKeyDeserializer(javatype);
    }

    private ValueInstantiator _findStdValueInstantiator(DeserializationConfig deserializationconfig, BeanDescription beandescription)
        throws JsonMappingException
    {
        return JacksonDeserializers.findValueInstantiator(deserializationconfig, beandescription);
    }

    private JavaType _mapAbstractType2(DeserializationConfig deserializationconfig, JavaType javatype)
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

    protected void _addDeserializerConstructors(DeserializationContext deserializationcontext, BeanDescription beandescription, VisibilityChecker visibilitychecker, AnnotationIntrospector annotationintrospector, CreatorCollector creatorcollector)
        throws JsonMappingException
    {
        AnnotatedConstructor annotatedconstructor = beandescription.findDefaultConstructor();
        if (annotatedconstructor != null && (!creatorcollector.hasDefaultCreator() || annotationintrospector.hasCreatorAnnotation(annotatedconstructor)))
        {
            creatorcollector.setDefaultCreator(annotatedconstructor);
        }
        Iterator iterator = beandescription.getConstructors().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            AnnotatedConstructor annotatedconstructor1 = (AnnotatedConstructor)iterator.next();
            int j1 = annotatedconstructor1.getParameterCount();
            boolean flag = annotationintrospector.hasCreatorAnnotation(annotatedconstructor1);
            boolean flag1 = visibilitychecker.isCreatorVisible(annotatedconstructor1);
            if (j1 == 1)
            {
                _handleSingleArgumentConstructor(deserializationcontext, beandescription, visibilitychecker, annotationintrospector, creatorcollector, annotatedconstructor1, flag, flag1);
                continue;
            }
            if (!flag && !flag1)
            {
                continue;
            }
            Object obj = null;
            int i = 0;
            int k = 0;
            CreatorProperty acreatorproperty[] = new CreatorProperty[j1];
            int j = 0;
            while (j < j1) 
            {
                AnnotatedParameter annotatedparameter = annotatedconstructor1.getParameter(j);
                Object obj1;
                Object obj2;
                int l;
                int i1;
                if (annotatedparameter == null)
                {
                    obj1 = null;
                } else
                {
                    obj1 = annotationintrospector.findNameForDeserialization(annotatedparameter);
                }
                if (obj1 == null)
                {
                    obj1 = null;
                } else
                {
                    obj1 = ((PropertyName) (obj1)).getSimpleName();
                }
                obj2 = annotationintrospector.findInjectableValueId(annotatedparameter);
                if (obj1 != null && ((String) (obj1)).length() > 0)
                {
                    i1 = i + 1;
                    acreatorproperty[j] = constructCreatorProperty(deserializationcontext, beandescription, ((String) (obj1)), j, annotatedparameter, obj2);
                    obj1 = obj;
                    l = k;
                } else
                if (obj2 != null)
                {
                    l = k + 1;
                    acreatorproperty[j] = constructCreatorProperty(deserializationcontext, beandescription, ((String) (obj1)), j, annotatedparameter, obj2);
                    i1 = i;
                    obj1 = obj;
                } else
                {
                    l = k;
                    i1 = i;
                    obj1 = obj;
                    if (obj == null)
                    {
                        obj1 = annotatedparameter;
                        l = k;
                        i1 = i;
                    }
                }
                j++;
                k = l;
                i = i1;
                obj = obj1;
            }
            if (flag || i > 0 || k > 0)
            {
                if (i + k == j1)
                {
                    creatorcollector.addPropertyCreator(annotatedconstructor1, acreatorproperty);
                } else
                if (i == 0 && k + 1 == j1)
                {
                    creatorcollector.addDelegatingCreator(annotatedconstructor1, acreatorproperty);
                } else
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("Argument #").append(((AnnotatedParameter) (obj)).getIndex()).append(" of constructor ").append(annotatedconstructor1).append(" has no property name annotation; must have name when multiple-paramater constructor annotated as Creator").toString());
                }
            }
        } while (true);
    }

    protected void _addDeserializerFactoryMethods(DeserializationContext deserializationcontext, BeanDescription beandescription, VisibilityChecker visibilitychecker, AnnotationIntrospector annotationintrospector, CreatorCollector creatorcollector)
        throws JsonMappingException
    {
        DeserializationConfig deserializationconfig = deserializationcontext.getConfig();
        Iterator iterator = beandescription.getFactoryMethods().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            AnnotatedMethod annotatedmethod = (AnnotatedMethod)iterator.next();
            boolean flag = annotationintrospector.hasCreatorAnnotation(annotatedmethod);
            int j1 = annotatedmethod.getParameterCount();
            if (j1 == 0)
            {
                if (flag)
                {
                    creatorcollector.setDefaultCreator(annotatedmethod);
                }
                continue;
            }
            if (j1 == 1)
            {
                AnnotatedParameter annotatedparameter = annotatedmethod.getParameter(0);
                Object obj;
                if (annotatedparameter == null)
                {
                    obj = null;
                } else
                {
                    obj = annotationintrospector.findNameForDeserialization(annotatedparameter);
                }
                if (obj == null)
                {
                    obj = null;
                } else
                {
                    obj = ((PropertyName) (obj)).getSimpleName();
                }
                if (annotationintrospector.findInjectableValueId(annotatedparameter) == null && (obj == null || ((String) (obj)).length() == 0))
                {
                    _handleSingleArgumentFactory(deserializationconfig, beandescription, visibilitychecker, annotationintrospector, creatorcollector, annotatedmethod, flag);
                    continue;
                }
            } else
            if (!annotationintrospector.hasCreatorAnnotation(annotatedmethod))
            {
                continue;
            }
            Object obj1 = null;
            CreatorProperty acreatorproperty[] = new CreatorProperty[j1];
            int i = 0;
            int k = 0;
            int j = 0;
            while (j < j1) 
            {
                AnnotatedParameter annotatedparameter1 = annotatedmethod.getParameter(j);
                Object obj2;
                Object obj3;
                int l;
                int i1;
                if (annotatedparameter1 == null)
                {
                    obj2 = null;
                } else
                {
                    obj2 = annotationintrospector.findNameForDeserialization(annotatedparameter1);
                }
                if (obj2 == null)
                {
                    obj2 = null;
                } else
                {
                    obj2 = ((PropertyName) (obj2)).getSimpleName();
                }
                obj3 = annotationintrospector.findInjectableValueId(annotatedparameter1);
                if (obj2 != null && ((String) (obj2)).length() > 0)
                {
                    i1 = i + 1;
                    acreatorproperty[j] = constructCreatorProperty(deserializationcontext, beandescription, ((String) (obj2)), j, annotatedparameter1, obj3);
                    obj2 = obj1;
                    l = k;
                } else
                if (obj3 != null)
                {
                    l = k + 1;
                    acreatorproperty[j] = constructCreatorProperty(deserializationcontext, beandescription, ((String) (obj2)), j, annotatedparameter1, obj3);
                    i1 = i;
                    obj2 = obj1;
                } else
                {
                    l = k;
                    i1 = i;
                    obj2 = obj1;
                    if (obj1 == null)
                    {
                        obj2 = annotatedparameter1;
                        l = k;
                        i1 = i;
                    }
                }
                j++;
                k = l;
                i = i1;
                obj1 = obj2;
            }
            if (flag || i > 0 || k > 0)
            {
                if (i + k == j1)
                {
                    creatorcollector.addPropertyCreator(annotatedmethod, acreatorproperty);
                } else
                if (i == 0 && k + 1 == j1)
                {
                    creatorcollector.addDelegatingCreator(annotatedmethod, acreatorproperty);
                } else
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("Argument #").append(((AnnotatedParameter) (obj1)).getIndex()).append(" of factory method ").append(annotatedmethod).append(" has no property name annotation; must have name when multiple-paramater constructor annotated as Creator").toString());
                }
            }
        } while (true);
    }

    protected ValueInstantiator _constructDefaultValueInstantiator(DeserializationContext deserializationcontext, BeanDescription beandescription)
        throws JsonMappingException
    {
        CreatorCollector creatorcollector = new CreatorCollector(beandescription, deserializationcontext.canOverrideAccessModifiers());
        AnnotationIntrospector annotationintrospector = deserializationcontext.getAnnotationIntrospector();
        DeserializationConfig deserializationconfig = deserializationcontext.getConfig();
        VisibilityChecker visibilitychecker = deserializationconfig.getDefaultVisibilityChecker();
        visibilitychecker = annotationintrospector.findAutoDetectVisibility(beandescription.getClassInfo(), visibilitychecker);
        _addDeserializerFactoryMethods(deserializationcontext, beandescription, visibilitychecker, annotationintrospector, creatorcollector);
        if (beandescription.getType().isConcrete())
        {
            _addDeserializerConstructors(deserializationcontext, beandescription, visibilitychecker, annotationintrospector, creatorcollector);
        }
        return creatorcollector.constructValueInstantiator(deserializationconfig);
    }

    protected JsonDeserializer _findCustomArrayDeserializer(ArrayType arraytype, DeserializationConfig deserializationconfig, BeanDescription beandescription, TypeDeserializer typedeserializer, JsonDeserializer jsondeserializer)
        throws JsonMappingException
    {
        for (Iterator iterator = _factoryConfig.deserializers().iterator(); iterator.hasNext();)
        {
            JsonDeserializer jsondeserializer1 = ((Deserializers)iterator.next()).findArrayDeserializer(arraytype, deserializationconfig, beandescription, typedeserializer, jsondeserializer);
            if (jsondeserializer1 != null)
            {
                return jsondeserializer1;
            }
        }

        return null;
    }

    protected JsonDeserializer _findCustomCollectionDeserializer(CollectionType collectiontype, DeserializationConfig deserializationconfig, BeanDescription beandescription, TypeDeserializer typedeserializer, JsonDeserializer jsondeserializer)
        throws JsonMappingException
    {
        for (Iterator iterator = _factoryConfig.deserializers().iterator(); iterator.hasNext();)
        {
            JsonDeserializer jsondeserializer1 = ((Deserializers)iterator.next()).findCollectionDeserializer(collectiontype, deserializationconfig, beandescription, typedeserializer, jsondeserializer);
            if (jsondeserializer1 != null)
            {
                return jsondeserializer1;
            }
        }

        return null;
    }

    protected JsonDeserializer _findCustomCollectionLikeDeserializer(CollectionLikeType collectionliketype, DeserializationConfig deserializationconfig, BeanDescription beandescription, TypeDeserializer typedeserializer, JsonDeserializer jsondeserializer)
        throws JsonMappingException
    {
        for (Iterator iterator = _factoryConfig.deserializers().iterator(); iterator.hasNext();)
        {
            JsonDeserializer jsondeserializer1 = ((Deserializers)iterator.next()).findCollectionLikeDeserializer(collectionliketype, deserializationconfig, beandescription, typedeserializer, jsondeserializer);
            if (jsondeserializer1 != null)
            {
                return jsondeserializer1;
            }
        }

        return null;
    }

    protected JsonDeserializer _findCustomEnumDeserializer(Class class1, DeserializationConfig deserializationconfig, BeanDescription beandescription)
        throws JsonMappingException
    {
        for (Iterator iterator = _factoryConfig.deserializers().iterator(); iterator.hasNext();)
        {
            JsonDeserializer jsondeserializer = ((Deserializers)iterator.next()).findEnumDeserializer(class1, deserializationconfig, beandescription);
            if (jsondeserializer != null)
            {
                return jsondeserializer;
            }
        }

        return null;
    }

    protected JsonDeserializer _findCustomMapDeserializer(MapType maptype, DeserializationConfig deserializationconfig, BeanDescription beandescription, KeyDeserializer keydeserializer, TypeDeserializer typedeserializer, JsonDeserializer jsondeserializer)
        throws JsonMappingException
    {
        for (Iterator iterator = _factoryConfig.deserializers().iterator(); iterator.hasNext();)
        {
            JsonDeserializer jsondeserializer1 = ((Deserializers)iterator.next()).findMapDeserializer(maptype, deserializationconfig, beandescription, keydeserializer, typedeserializer, jsondeserializer);
            if (jsondeserializer1 != null)
            {
                return jsondeserializer1;
            }
        }

        return null;
    }

    protected JsonDeserializer _findCustomMapLikeDeserializer(MapLikeType mapliketype, DeserializationConfig deserializationconfig, BeanDescription beandescription, KeyDeserializer keydeserializer, TypeDeserializer typedeserializer, JsonDeserializer jsondeserializer)
        throws JsonMappingException
    {
        for (Iterator iterator = _factoryConfig.deserializers().iterator(); iterator.hasNext();)
        {
            JsonDeserializer jsondeserializer1 = ((Deserializers)iterator.next()).findMapLikeDeserializer(mapliketype, deserializationconfig, beandescription, keydeserializer, typedeserializer, jsondeserializer);
            if (jsondeserializer1 != null)
            {
                return jsondeserializer1;
            }
        }

        return null;
    }

    protected JsonDeserializer _findCustomTreeNodeDeserializer(Class class1, DeserializationConfig deserializationconfig, BeanDescription beandescription)
        throws JsonMappingException
    {
        for (Iterator iterator = _factoryConfig.deserializers().iterator(); iterator.hasNext();)
        {
            JsonDeserializer jsondeserializer = ((Deserializers)iterator.next()).findTreeNodeDeserializer(class1, deserializationconfig, beandescription);
            if (jsondeserializer != null)
            {
                return jsondeserializer;
            }
        }

        return null;
    }

    protected AnnotatedMethod _findJsonValueFor(DeserializationConfig deserializationconfig, JavaType javatype)
    {
        if (javatype == null)
        {
            return null;
        } else
        {
            return deserializationconfig.introspect(javatype).findJsonValueMethod();
        }
    }

    protected boolean _handleSingleArgumentConstructor(DeserializationContext deserializationcontext, BeanDescription beandescription, VisibilityChecker visibilitychecker, AnnotationIntrospector annotationintrospector, CreatorCollector creatorcollector, AnnotatedConstructor annotatedconstructor, boolean flag, 
            boolean flag1)
        throws JsonMappingException
    {
        AnnotatedParameter annotatedparameter = annotatedconstructor.getParameter(0);
        if (annotatedparameter == null)
        {
            visibilitychecker = null;
        } else
        {
            visibilitychecker = annotationintrospector.findNameForDeserialization(annotatedparameter);
        }
        if (visibilitychecker == null)
        {
            visibilitychecker = null;
        } else
        {
            visibilitychecker = visibilitychecker.getSimpleName();
        }
        annotationintrospector = ((AnnotationIntrospector) (annotationintrospector.findInjectableValueId(annotatedparameter)));
        if (annotationintrospector != null || visibilitychecker != null && visibilitychecker.length() > 0)
        {
            creatorcollector.addPropertyCreator(annotatedconstructor, new CreatorProperty[] {
                constructCreatorProperty(deserializationcontext, beandescription, visibilitychecker, 0, annotatedparameter, annotationintrospector)
            });
            return true;
        }
        deserializationcontext = annotatedconstructor.getRawParameterType(0);
        if (deserializationcontext == java/lang/String)
        {
            if (flag || flag1)
            {
                creatorcollector.addStringCreator(annotatedconstructor);
            }
            return true;
        }
        if (deserializationcontext == Integer.TYPE || deserializationcontext == java/lang/Integer)
        {
            if (flag || flag1)
            {
                creatorcollector.addIntCreator(annotatedconstructor);
            }
            return true;
        }
        if (deserializationcontext == Long.TYPE || deserializationcontext == java/lang/Long)
        {
            if (flag || flag1)
            {
                creatorcollector.addLongCreator(annotatedconstructor);
            }
            return true;
        }
        if (deserializationcontext == Double.TYPE || deserializationcontext == java/lang/Double)
        {
            if (flag || flag1)
            {
                creatorcollector.addDoubleCreator(annotatedconstructor);
            }
            return true;
        }
        if (flag)
        {
            creatorcollector.addDelegatingCreator(annotatedconstructor, null);
            return true;
        } else
        {
            return false;
        }
    }

    protected boolean _handleSingleArgumentFactory(DeserializationConfig deserializationconfig, BeanDescription beandescription, VisibilityChecker visibilitychecker, AnnotationIntrospector annotationintrospector, CreatorCollector creatorcollector, AnnotatedMethod annotatedmethod, boolean flag)
        throws JsonMappingException
    {
        deserializationconfig = annotatedmethod.getRawParameterType(0);
        if (deserializationconfig != java/lang/String) goto _L2; else goto _L1
_L1:
        if (flag || visibilitychecker.isCreatorVisible(annotatedmethod))
        {
            creatorcollector.addStringCreator(annotatedmethod);
        }
_L4:
        return true;
_L2:
        if (deserializationconfig != Integer.TYPE && deserializationconfig != java/lang/Integer)
        {
            break; /* Loop/switch isn't completed */
        }
        if (flag || visibilitychecker.isCreatorVisible(annotatedmethod))
        {
            creatorcollector.addIntCreator(annotatedmethod);
            return true;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (deserializationconfig != Long.TYPE && deserializationconfig != java/lang/Long)
        {
            break; /* Loop/switch isn't completed */
        }
        if (flag || visibilitychecker.isCreatorVisible(annotatedmethod))
        {
            creatorcollector.addLongCreator(annotatedmethod);
            return true;
        }
        if (true) goto _L4; else goto _L5
_L5:
        if (deserializationconfig != Double.TYPE && deserializationconfig != java/lang/Double)
        {
            break; /* Loop/switch isn't completed */
        }
        if (flag || visibilitychecker.isCreatorVisible(annotatedmethod))
        {
            creatorcollector.addDoubleCreator(annotatedmethod);
            return true;
        }
        if (true) goto _L4; else goto _L6
_L6:
        if (deserializationconfig == Boolean.TYPE || deserializationconfig == java/lang/Boolean)
        {
            if (flag || visibilitychecker.isCreatorVisible(annotatedmethod))
            {
                creatorcollector.addBooleanCreator(annotatedmethod);
                return true;
            }
        } else
        if (annotationintrospector.hasCreatorAnnotation(annotatedmethod))
        {
            creatorcollector.addDelegatingCreator(annotatedmethod, null);
            return true;
        } else
        {
            return false;
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    public ValueInstantiator _valueInstantiatorInstance(DeserializationConfig deserializationconfig, Annotated annotated, Object obj)
        throws JsonMappingException
    {
        if (obj != null)
        {
            if (obj instanceof ValueInstantiator)
            {
                return (ValueInstantiator)obj;
            }
            if (!(obj instanceof Class))
            {
                throw new IllegalStateException((new StringBuilder()).append("AnnotationIntrospector returned key deserializer definition of type ").append(obj.getClass().getName()).append("; expected type KeyDeserializer or Class<KeyDeserializer> instead").toString());
            }
            obj = (Class)obj;
            if (obj != com/fasterxml/jackson/databind/annotation/NoClass)
            {
                if (!com/fasterxml/jackson/databind/deser/ValueInstantiator.isAssignableFrom(((Class) (obj))))
                {
                    throw new IllegalStateException((new StringBuilder()).append("AnnotationIntrospector returned Class ").append(((Class) (obj)).getName()).append("; expected Class<ValueInstantiator>").toString());
                }
                HandlerInstantiator handlerinstantiator = deserializationconfig.getHandlerInstantiator();
                if (handlerinstantiator != null)
                {
                    return handlerinstantiator.valueInstantiatorInstance(deserializationconfig, annotated, ((Class) (obj)));
                } else
                {
                    return (ValueInstantiator)ClassUtil.createInstance(((Class) (obj)), deserializationconfig.canOverrideAccessModifiers());
                }
            }
        }
        return null;
    }

    protected CreatorProperty constructCreatorProperty(DeserializationContext deserializationcontext, BeanDescription beandescription, String s, int i, AnnotatedParameter annotatedparameter, Object obj)
        throws JsonMappingException
    {
        DeserializationConfig deserializationconfig = deserializationcontext.getConfig();
        Object obj2 = deserializationconfig.getTypeFactory().constructType(annotatedparameter.getParameterType(), beandescription.bindingsForBeanType());
        Object obj3 = new com.fasterxml.jackson.databind.BeanProperty.Std(s, ((JavaType) (obj2)), beandescription.getClassAnnotations(), annotatedparameter);
        Object obj1 = resolveType(deserializationcontext, beandescription, ((JavaType) (obj2)), annotatedparameter);
        if (obj1 != obj2)
        {
            ((com.fasterxml.jackson.databind.BeanProperty.Std) (obj3)).withType(((JavaType) (obj1)));
        }
        obj2 = findDeserializerFromAnnotation(deserializationcontext, annotatedparameter);
        obj3 = modifyTypeByAnnotation(deserializationcontext, annotatedparameter, ((JavaType) (obj1)));
        obj1 = (TypeDeserializer)((JavaType) (obj3)).getTypeHandler();
        deserializationcontext = ((DeserializationContext) (obj1));
        if (obj1 == null)
        {
            deserializationcontext = findTypeDeserializer(deserializationconfig, ((JavaType) (obj3)));
        }
        beandescription = new CreatorProperty(s, ((JavaType) (obj3)), deserializationcontext, beandescription.getClassAnnotations(), annotatedparameter, i, obj);
        deserializationcontext = beandescription;
        if (obj2 != null)
        {
            deserializationcontext = beandescription.withValueDeserializer(((JsonDeserializer) (obj2)));
        }
        return deserializationcontext;
    }

    protected EnumResolver constructEnumResolver(Class class1, DeserializationConfig deserializationconfig, AnnotatedMethod annotatedmethod)
    {
        if (annotatedmethod != null)
        {
            annotatedmethod = annotatedmethod.getAnnotated();
            if (deserializationconfig.canOverrideAccessModifiers())
            {
                ClassUtil.checkAndFixAccess(annotatedmethod);
            }
            return EnumResolver.constructUnsafeUsingMethod(class1, annotatedmethod);
        }
        if (deserializationconfig.isEnabled(DeserializationFeature.READ_ENUMS_USING_TO_STRING))
        {
            return EnumResolver.constructUnsafeUsingToString(class1);
        } else
        {
            return EnumResolver.constructUnsafe(class1, deserializationconfig.getAnnotationIntrospector());
        }
    }

    public JsonDeserializer createArrayDeserializer(DeserializationContext deserializationcontext, ArrayType arraytype, BeanDescription beandescription)
        throws JsonMappingException
    {
        JavaType javatype = arraytype.getContentType();
        JsonDeserializer jsondeserializer1 = (JsonDeserializer)javatype.getValueHandler();
        if (jsondeserializer1 == null)
        {
            JsonDeserializer jsondeserializer = (JsonDeserializer)_arrayDeserializers.get(javatype);
            if (jsondeserializer != null)
            {
                arraytype = _findCustomArrayDeserializer(arraytype, deserializationcontext.getConfig(), beandescription, null, jsondeserializer1);
                deserializationcontext = jsondeserializer;
                if (arraytype != null)
                {
                    deserializationcontext = arraytype;
                }
                return deserializationcontext;
            }
            if (javatype.isPrimitive())
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Internal error: primitive type (").append(arraytype).append(") passed, no array deserializer found").toString());
            }
        }
        TypeDeserializer typedeserializer1 = (TypeDeserializer)javatype.getTypeHandler();
        TypeDeserializer typedeserializer = typedeserializer1;
        if (typedeserializer1 == null)
        {
            typedeserializer = findTypeDeserializer(deserializationcontext.getConfig(), javatype);
        }
        deserializationcontext = _findCustomArrayDeserializer(arraytype, deserializationcontext.getConfig(), beandescription, typedeserializer, jsondeserializer1);
        if (deserializationcontext != null)
        {
            return deserializationcontext;
        } else
        {
            return new ObjectArrayDeserializer(arraytype, jsondeserializer1, typedeserializer);
        }
    }

    public JsonDeserializer createCollectionDeserializer(DeserializationContext deserializationcontext, CollectionType collectiontype, BeanDescription beandescription)
        throws JsonMappingException
    {
        TypeDeserializer typedeserializer;
        Object obj;
        JavaType javatype;
        JsonDeserializer jsondeserializer;
label0:
        {
            javatype = collectiontype.getContentType();
            jsondeserializer = (JsonDeserializer)javatype.getValueHandler();
            obj = (TypeDeserializer)javatype.getTypeHandler();
            typedeserializer = ((TypeDeserializer) (obj));
            if (obj == null)
            {
                typedeserializer = findTypeDeserializer(deserializationcontext.getConfig(), javatype);
            }
            obj = _findCustomCollectionDeserializer(collectiontype, deserializationcontext.getConfig(), beandescription, typedeserializer, jsondeserializer);
            if (obj != null)
            {
                return ((JsonDeserializer) (obj));
            }
            Class class1 = collectiontype.getRawClass();
            if (jsondeserializer == null && java/util/EnumSet.isAssignableFrom(class1))
            {
                return new EnumSetDeserializer(javatype, null);
            }
            if (!collectiontype.isInterface())
            {
                obj = collectiontype;
                if (!collectiontype.isAbstract())
                {
                    break label0;
                }
            }
            beandescription = (Class)_collectionFallbacks.get(class1.getName());
            if (beandescription == null)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Can not find a deserializer for non-concrete Collection type ").append(collectiontype).toString());
            }
            obj = (CollectionType)deserializationcontext.getConfig().constructSpecializedType(collectiontype, beandescription);
            beandescription = deserializationcontext.getConfig().introspectForCreation(((JavaType) (obj)));
        }
        deserializationcontext = findValueInstantiator(deserializationcontext, beandescription);
        if (javatype.getRawClass() == java/lang/String)
        {
            return new StringCollectionDeserializer(((JavaType) (obj)), jsondeserializer, deserializationcontext);
        } else
        {
            return new CollectionDeserializer(((JavaType) (obj)), jsondeserializer, typedeserializer, deserializationcontext);
        }
    }

    public JsonDeserializer createCollectionLikeDeserializer(DeserializationContext deserializationcontext, CollectionLikeType collectionliketype, BeanDescription beandescription)
        throws JsonMappingException
    {
        JavaType javatype = collectionliketype.getContentType();
        JsonDeserializer jsondeserializer = (JsonDeserializer)javatype.getValueHandler();
        TypeDeserializer typedeserializer1 = (TypeDeserializer)javatype.getTypeHandler();
        TypeDeserializer typedeserializer = typedeserializer1;
        if (typedeserializer1 == null)
        {
            typedeserializer = findTypeDeserializer(deserializationcontext.getConfig(), javatype);
        }
        return _findCustomCollectionLikeDeserializer(collectionliketype, deserializationcontext.getConfig(), beandescription, typedeserializer, jsondeserializer);
    }

    public JsonDeserializer createEnumDeserializer(DeserializationContext deserializationcontext, JavaType javatype, BeanDescription beandescription)
        throws JsonMappingException
    {
        javatype = javatype.getRawClass();
        JsonDeserializer jsondeserializer = _findCustomEnumDeserializer(javatype, deserializationcontext.getConfig(), beandescription);
        if (jsondeserializer != null)
        {
            return jsondeserializer;
        }
        for (Iterator iterator = beandescription.getFactoryMethods().iterator(); iterator.hasNext();)
        {
            AnnotatedMethod annotatedmethod = (AnnotatedMethod)iterator.next();
            if (deserializationcontext.getAnnotationIntrospector().hasCreatorAnnotation(annotatedmethod))
            {
                if (annotatedmethod.getParameterCount() == 1 && annotatedmethod.getRawReturnType().isAssignableFrom(javatype))
                {
                    return EnumDeserializer.deserializerForCreator(deserializationcontext.getConfig(), javatype, annotatedmethod);
                } else
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("Unsuitable method (").append(annotatedmethod).append(") decorated with @JsonCreator (for Enum type ").append(javatype.getName()).append(")").toString());
                }
            }
        }

        return new EnumDeserializer(constructEnumResolver(javatype, deserializationcontext.getConfig(), beandescription.findJsonValueMethod()));
    }

    public KeyDeserializer createKeyDeserializer(DeserializationContext deserializationcontext, JavaType javatype)
        throws JsonMappingException
    {
        DeserializationConfig deserializationconfig = deserializationcontext.getConfig();
        if (!_factoryConfig.hasKeyDeserializers()) goto _L2; else goto _L1
_L1:
        BeanDescription beandescription;
        Iterator iterator;
        beandescription = deserializationconfig.introspectClassAnnotations(javatype.getRawClass());
        iterator = _factoryConfig.keyDeserializers().iterator();
_L5:
        if (!iterator.hasNext()) goto _L2; else goto _L3
_L3:
        Object obj = ((KeyDeserializers)iterator.next()).findKeyDeserializer(javatype, deserializationconfig, beandescription);
        if (obj == null) goto _L5; else goto _L4
_L4:
        return ((KeyDeserializer) (obj));
_L2:
        obj = javatype.getRawClass();
        if (obj == java/lang/String || obj == java/lang/Object)
        {
            return StdKeyDeserializers.constructStringKeyDeserializer(deserializationconfig, javatype);
        }
        KeyDeserializer keydeserializer = (KeyDeserializer)_keyDeserializers.get(javatype);
        obj = keydeserializer;
        if (keydeserializer == null)
        {
            if (javatype.isEnumType())
            {
                return _createEnumKeyDeserializer(deserializationcontext, javatype);
            } else
            {
                return StdKeyDeserializers.findStringBasedKeyDeserializer(deserializationconfig, javatype);
            }
        }
        if (true) goto _L4; else goto _L6
_L6:
    }

    public JsonDeserializer createMapDeserializer(DeserializationContext deserializationcontext, MapType maptype, BeanDescription beandescription)
        throws JsonMappingException
    {
        TypeDeserializer typedeserializer;
        Object obj;
        DeserializationConfig deserializationconfig;
        JsonDeserializer jsondeserializer;
        KeyDeserializer keydeserializer;
label0:
        {
            deserializationconfig = deserializationcontext.getConfig();
            JavaType javatype = maptype.getKeyType();
            Object obj1 = maptype.getContentType();
            jsondeserializer = (JsonDeserializer)((JavaType) (obj1)).getValueHandler();
            keydeserializer = (KeyDeserializer)javatype.getValueHandler();
            obj = (TypeDeserializer)((JavaType) (obj1)).getTypeHandler();
            typedeserializer = ((TypeDeserializer) (obj));
            if (obj == null)
            {
                typedeserializer = findTypeDeserializer(deserializationconfig, ((JavaType) (obj1)));
            }
            obj = _findCustomMapDeserializer(maptype, deserializationconfig, beandescription, keydeserializer, typedeserializer, jsondeserializer);
            if (obj != null)
            {
                return ((JsonDeserializer) (obj));
            }
            obj1 = maptype.getRawClass();
            if (java/util/EnumMap.isAssignableFrom(((Class) (obj1))))
            {
                deserializationcontext = javatype.getRawClass();
                if (deserializationcontext == null || !deserializationcontext.isEnum())
                {
                    throw new IllegalArgumentException("Can not construct EnumMap; generic (key) type not available");
                } else
                {
                    return new EnumMapDeserializer(maptype, null, jsondeserializer);
                }
            }
            if (!maptype.isInterface())
            {
                obj = maptype;
                if (!maptype.isAbstract())
                {
                    break label0;
                }
            }
            beandescription = (Class)_mapFallbacks.get(((Class) (obj1)).getName());
            if (beandescription == null)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Can not find a deserializer for non-concrete Map type ").append(maptype).toString());
            }
            obj = (MapType)deserializationconfig.constructSpecializedType(maptype, beandescription);
            beandescription = deserializationconfig.introspectForCreation(((JavaType) (obj)));
        }
        deserializationcontext = new MapDeserializer(((JavaType) (obj)), findValueInstantiator(deserializationcontext, beandescription), keydeserializer, jsondeserializer, typedeserializer);
        deserializationcontext.setIgnorableProperties(deserializationconfig.getAnnotationIntrospector().findPropertiesToIgnore(beandescription.getClassInfo()));
        return deserializationcontext;
    }

    public JsonDeserializer createMapLikeDeserializer(DeserializationContext deserializationcontext, MapLikeType mapliketype, BeanDescription beandescription)
        throws JsonMappingException
    {
        Object obj = mapliketype.getKeyType();
        JavaType javatype = mapliketype.getContentType();
        JsonDeserializer jsondeserializer = (JsonDeserializer)javatype.getValueHandler();
        KeyDeserializer keydeserializer = (KeyDeserializer)((JavaType) (obj)).getValueHandler();
        TypeDeserializer typedeserializer = (TypeDeserializer)javatype.getTypeHandler();
        obj = typedeserializer;
        if (typedeserializer == null)
        {
            obj = findTypeDeserializer(deserializationcontext.getConfig(), javatype);
        }
        return _findCustomMapLikeDeserializer(mapliketype, deserializationcontext.getConfig(), beandescription, keydeserializer, ((TypeDeserializer) (obj)), jsondeserializer);
    }

    public JsonDeserializer createTreeDeserializer(DeserializationConfig deserializationconfig, JavaType javatype, BeanDescription beandescription)
        throws JsonMappingException
    {
        javatype = javatype.getRawClass();
        deserializationconfig = _findCustomTreeNodeDeserializer(javatype, deserializationconfig, beandescription);
        if (deserializationconfig != null)
        {
            return deserializationconfig;
        } else
        {
            return JsonNodeDeserializer.getDeserializer(javatype);
        }
    }

    protected JsonDeserializer findDeserializerFromAnnotation(DeserializationContext deserializationcontext, Annotated annotated)
        throws JsonMappingException
    {
        Object obj = deserializationcontext.getAnnotationIntrospector().findDeserializer(annotated);
        if (obj == null)
        {
            return null;
        } else
        {
            return deserializationcontext.deserializerInstance(annotated, obj);
        }
    }

    public TypeDeserializer findPropertyContentTypeDeserializer(DeserializationConfig deserializationconfig, JavaType javatype, AnnotatedMember annotatedmember)
        throws JsonMappingException
    {
        AnnotationIntrospector annotationintrospector = deserializationconfig.getAnnotationIntrospector();
        TypeResolverBuilder typeresolverbuilder = annotationintrospector.findPropertyContentTypeResolver(deserializationconfig, annotatedmember, javatype);
        javatype = javatype.getContentType();
        if (typeresolverbuilder == null)
        {
            return findTypeDeserializer(deserializationconfig, javatype);
        } else
        {
            return typeresolverbuilder.buildTypeDeserializer(deserializationconfig, javatype, deserializationconfig.getSubtypeResolver().collectAndResolveSubtypes(annotatedmember, deserializationconfig, annotationintrospector, javatype));
        }
    }

    public TypeDeserializer findPropertyTypeDeserializer(DeserializationConfig deserializationconfig, JavaType javatype, AnnotatedMember annotatedmember)
        throws JsonMappingException
    {
        AnnotationIntrospector annotationintrospector = deserializationconfig.getAnnotationIntrospector();
        TypeResolverBuilder typeresolverbuilder = annotationintrospector.findPropertyTypeResolver(deserializationconfig, annotatedmember, javatype);
        if (typeresolverbuilder == null)
        {
            return findTypeDeserializer(deserializationconfig, javatype);
        } else
        {
            return typeresolverbuilder.buildTypeDeserializer(deserializationconfig, javatype, deserializationconfig.getSubtypeResolver().collectAndResolveSubtypes(annotatedmember, deserializationconfig, annotationintrospector, javatype));
        }
    }

    public TypeDeserializer findTypeDeserializer(DeserializationConfig deserializationconfig, JavaType javatype)
        throws JsonMappingException
    {
        Object obj1 = deserializationconfig.introspectClassAnnotations(javatype.getRawClass()).getClassInfo();
        AnnotationIntrospector annotationintrospector = deserializationconfig.getAnnotationIntrospector();
        Object obj = annotationintrospector.findTypeResolver(deserializationconfig, ((com.fasterxml.jackson.databind.introspect.AnnotatedClass) (obj1)), javatype);
        Collection collection = null;
        if (obj == null)
        {
            obj1 = deserializationconfig.getDefaultTyper(javatype);
            obj = obj1;
            if (obj1 == null)
            {
                return null;
            }
        } else
        {
            collection = deserializationconfig.getSubtypeResolver().collectAndResolveSubtypes(((com.fasterxml.jackson.databind.introspect.AnnotatedClass) (obj1)), deserializationconfig, annotationintrospector);
        }
        obj1 = obj;
        if (((TypeResolverBuilder) (obj)).getDefaultImpl() == null)
        {
            obj1 = obj;
            if (javatype.isAbstract())
            {
                JavaType javatype1 = mapAbstractType(deserializationconfig, javatype);
                obj1 = obj;
                if (javatype1 != null)
                {
                    obj1 = obj;
                    if (javatype1.getRawClass() != javatype.getRawClass())
                    {
                        obj1 = ((TypeResolverBuilder) (obj)).defaultImpl(javatype1.getRawClass());
                    }
                }
            }
        }
        return ((TypeResolverBuilder) (obj1)).buildTypeDeserializer(deserializationconfig, javatype, collection);
    }

    public ValueInstantiator findValueInstantiator(DeserializationContext deserializationcontext, BeanDescription beandescription)
        throws JsonMappingException
    {
label0:
        {
            DeserializationConfig deserializationconfig = deserializationcontext.getConfig();
            Object obj1 = null;
            Object obj = beandescription.getClassInfo();
            Object obj2 = deserializationcontext.getAnnotationIntrospector().findValueInstantiator(((com.fasterxml.jackson.databind.introspect.AnnotatedClass) (obj)));
            if (obj2 != null)
            {
                obj1 = _valueInstantiatorInstance(deserializationconfig, ((Annotated) (obj)), obj2);
            }
            obj = obj1;
            if (obj1 == null)
            {
                obj1 = _findStdValueInstantiator(deserializationconfig, beandescription);
                obj = obj1;
                if (obj1 == null)
                {
                    obj = _constructDefaultValueInstantiator(deserializationcontext, beandescription);
                }
            }
            deserializationcontext = ((DeserializationContext) (obj));
            if (!_factoryConfig.hasValueInstantiators())
            {
                break label0;
            }
            obj1 = _factoryConfig.valueInstantiators().iterator();
            do
            {
                deserializationcontext = ((DeserializationContext) (obj));
                if (!((Iterator) (obj1)).hasNext())
                {
                    break label0;
                }
                obj2 = (ValueInstantiators)((Iterator) (obj1)).next();
                deserializationcontext = ((ValueInstantiators) (obj2)).findValueInstantiator(deserializationconfig, beandescription, ((ValueInstantiator) (obj)));
                obj = deserializationcontext;
            } while (deserializationcontext != null);
            throw new JsonMappingException((new StringBuilder()).append("Broken registered ValueInstantiators (of type ").append(obj2.getClass().getName()).append("): returned null ValueInstantiator").toString());
        }
        return deserializationcontext;
    }

    public DeserializerFactoryConfig getFactoryConfig()
    {
        return _factoryConfig;
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

    protected JavaType modifyTypeByAnnotation(DeserializationContext deserializationcontext, Annotated annotated, JavaType javatype)
        throws JsonMappingException
    {
        AnnotationIntrospector annotationintrospector = deserializationcontext.getAnnotationIntrospector();
        Object obj1 = annotationintrospector.findDeserializationType(annotated, javatype);
        Object obj = javatype;
        if (obj1 != null)
        {
            try
            {
                obj = javatype.narrowBy(((Class) (obj1)));
            }
            // Misplaced declaration of an exception variable
            catch (DeserializationContext deserializationcontext)
            {
                throw new JsonMappingException((new StringBuilder()).append("Failed to narrow type ").append(javatype).append(" with concrete-type annotation (value ").append(((Class) (obj1)).getName()).append("), method '").append(annotated.getName()).append("': ").append(deserializationcontext.getMessage()).toString(), null, deserializationcontext);
            }
        }
        javatype = ((JavaType) (obj));
        if (((JavaType) (obj)).isContainerType())
        {
            javatype = annotationintrospector.findDeserializationKeyType(annotated, ((JavaType) (obj)).getKeyType());
            obj1 = obj;
            if (javatype != null)
            {
                if (!(obj instanceof MapLikeType))
                {
                    throw new JsonMappingException((new StringBuilder()).append("Illegal key-type annotation: type ").append(obj).append(" is not a Map(-like) type").toString());
                }
                try
                {
                    obj1 = ((MapLikeType)obj).narrowKey(javatype);
                }
                // Misplaced declaration of an exception variable
                catch (DeserializationContext deserializationcontext)
                {
                    throw new JsonMappingException((new StringBuilder()).append("Failed to narrow key type ").append(obj).append(" with key-type annotation (").append(javatype.getName()).append("): ").append(deserializationcontext.getMessage()).toString(), null, deserializationcontext);
                }
            }
            obj = ((JavaType) (obj1)).getKeyType();
            javatype = ((JavaType) (obj1));
            if (obj != null)
            {
                javatype = ((JavaType) (obj1));
                if (((JavaType) (obj)).getValueHandler() == null)
                {
                    obj = deserializationcontext.keyDeserializerInstance(annotated, annotationintrospector.findKeyDeserializer(annotated));
                    javatype = ((JavaType) (obj1));
                    if (obj != null)
                    {
                        javatype = ((MapLikeType)obj1).withKeyValueHandler(obj);
                        javatype.getKeyType();
                    }
                }
            }
            obj1 = annotationintrospector.findDeserializationContentType(annotated, javatype.getContentType());
            obj = javatype;
            if (obj1 != null)
            {
                try
                {
                    obj = javatype.narrowContentsBy(((Class) (obj1)));
                }
                // Misplaced declaration of an exception variable
                catch (DeserializationContext deserializationcontext)
                {
                    throw new JsonMappingException((new StringBuilder()).append("Failed to narrow content type ").append(javatype).append(" with content-type annotation (").append(((Class) (obj1)).getName()).append("): ").append(deserializationcontext.getMessage()).toString(), null, deserializationcontext);
                }
            }
            javatype = ((JavaType) (obj));
            if (((JavaType) (obj)).getContentType().getValueHandler() == null)
            {
                deserializationcontext = deserializationcontext.deserializerInstance(annotated, annotationintrospector.findContentDeserializer(annotated));
                javatype = ((JavaType) (obj));
                if (deserializationcontext != null)
                {
                    javatype = ((JavaType) (obj)).withContentValueHandler(deserializationcontext);
                }
            }
        }
        return javatype;
    }

    protected JavaType resolveType(DeserializationContext deserializationcontext, BeanDescription beandescription, JavaType javatype, AnnotatedMember annotatedmember)
        throws JsonMappingException
    {
        beandescription = javatype;
        if (javatype.isContainerType())
        {
            Object obj = deserializationcontext.getAnnotationIntrospector();
            beandescription = javatype;
            if (javatype.getKeyType() != null)
            {
                KeyDeserializer keydeserializer = deserializationcontext.keyDeserializerInstance(annotatedmember, ((AnnotationIntrospector) (obj)).findKeyDeserializer(annotatedmember));
                beandescription = javatype;
                if (keydeserializer != null)
                {
                    beandescription = ((MapLikeType)javatype).withKeyValueHandler(keydeserializer);
                    beandescription.getKeyType();
                }
            }
            obj = deserializationcontext.deserializerInstance(annotatedmember, ((AnnotationIntrospector) (obj)).findContentDeserializer(annotatedmember));
            javatype = beandescription;
            if (obj != null)
            {
                javatype = beandescription.withContentValueHandler(obj);
            }
            beandescription = javatype;
            if (annotatedmember instanceof AnnotatedMember)
            {
                TypeDeserializer typedeserializer = findPropertyContentTypeDeserializer(deserializationcontext.getConfig(), javatype, annotatedmember);
                beandescription = javatype;
                if (typedeserializer != null)
                {
                    beandescription = javatype.withContentTypeHandler(typedeserializer);
                }
            }
        }
        if (annotatedmember instanceof AnnotatedMember)
        {
            deserializationcontext = findPropertyTypeDeserializer(deserializationcontext.getConfig(), beandescription, annotatedmember);
        } else
        {
            deserializationcontext = findTypeDeserializer(deserializationcontext.getConfig(), beandescription);
        }
        javatype = beandescription;
        if (deserializationcontext != null)
        {
            javatype = beandescription.withTypeHandler(deserializationcontext);
        }
        return javatype;
    }

    public final DeserializerFactory withAbstractTypeResolver(AbstractTypeResolver abstracttyperesolver)
    {
        return withConfig(_factoryConfig.withAbstractTypeResolver(abstracttyperesolver));
    }

    public final DeserializerFactory withAdditionalDeserializers(Deserializers deserializers)
    {
        return withConfig(_factoryConfig.withAdditionalDeserializers(deserializers));
    }

    public final DeserializerFactory withAdditionalKeyDeserializers(KeyDeserializers keydeserializers)
    {
        return withConfig(_factoryConfig.withAdditionalKeyDeserializers(keydeserializers));
    }

    protected abstract DeserializerFactory withConfig(DeserializerFactoryConfig deserializerfactoryconfig);

    public final DeserializerFactory withDeserializerModifier(BeanDeserializerModifier beandeserializermodifier)
    {
        return withConfig(_factoryConfig.withDeserializerModifier(beandeserializermodifier));
    }

    public final DeserializerFactory withValueInstantiators(ValueInstantiators valueinstantiators)
    {
        return withConfig(_factoryConfig.withValueInstantiators(valueinstantiators));
    }

    static 
    {
        _simpleDeserializers = new HashMap();
        _add(_simpleDeserializers, java/lang/Object, new UntypedObjectDeserializer());
        StringDeserializer stringdeserializer = new StringDeserializer();
        _add(_simpleDeserializers, java/lang/String, stringdeserializer);
        _add(_simpleDeserializers, java/lang/CharSequence, stringdeserializer);
        _add(_simpleDeserializers, NumberDeserializers.all());
        _add(_simpleDeserializers, DateDeserializers.all());
        _add(_simpleDeserializers, JdkDeserializers.all());
        _add(_simpleDeserializers, JacksonDeserializers.all());
        _mapFallbacks = new HashMap();
        _mapFallbacks.put(java/util/Map.getName(), java/util/LinkedHashMap);
        _mapFallbacks.put(java/util/concurrent/ConcurrentMap.getName(), java/util/concurrent/ConcurrentHashMap);
        _mapFallbacks.put(java/util/SortedMap.getName(), java/util/TreeMap);
        _mapFallbacks.put("java.util.NavigableMap", java/util/TreeMap);
        try
        {
            Class class1 = Class.forName("java.util.concurrent.ConcurrentNavigableMap");
            Class class2 = Class.forName("java.util.concurrent.ConcurrentSkipListMap");
            _mapFallbacks.put(class1.getName(), class2);
        }
        catch (ClassNotFoundException classnotfoundexception) { }
        catch (SecurityException securityexception) { }
        _collectionFallbacks = new HashMap();
        _collectionFallbacks.put(java/util/Collection.getName(), java/util/ArrayList);
        _collectionFallbacks.put(java/util/List.getName(), java/util/ArrayList);
        _collectionFallbacks.put(java/util/Set.getName(), java/util/HashSet);
        _collectionFallbacks.put(java/util/SortedSet.getName(), java/util/TreeSet);
        _collectionFallbacks.put(java/util/Queue.getName(), java/util/LinkedList);
        _collectionFallbacks.put("java.util.Deque", java/util/LinkedList);
        _collectionFallbacks.put("java.util.NavigableSet", java/util/TreeSet);
    }
}
