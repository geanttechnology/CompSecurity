// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.impl.FilteredBeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.fasterxml.jackson.databind.ser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.fasterxml.jackson.databind.ser:
//            BasicSerializerFactory, PropertyBuilder, ResolvableSerializer, ContextualSerializer, 
//            BeanSerializerBuilder, BeanSerializerModifier, AnyGetterWriter, BeanPropertyWriter, 
//            Serializers, SerializerFactory

public class BeanSerializerFactory extends BasicSerializerFactory
    implements Serializable
{

    public static final BeanSerializerFactory instance = new BeanSerializerFactory(null);
    private static final long serialVersionUID = 1L;

    protected BeanSerializerFactory(SerializerFactoryConfig serializerfactoryconfig)
    {
        super(serializerfactoryconfig);
    }

    protected BeanPropertyWriter _constructWriter(SerializerProvider serializerprovider, BeanPropertyDefinition beanpropertydefinition, TypeBindings typebindings, PropertyBuilder propertybuilder, boolean flag, AnnotatedMember annotatedmember)
        throws JsonMappingException
    {
        Object obj = beanpropertydefinition.getName();
        if (serializerprovider.canOverrideAccessModifiers())
        {
            annotatedmember.fixAccess();
        }
        JavaType javatype = annotatedmember.getType(typebindings);
        com.fasterxml.jackson.databind.BeanProperty.Std std = new com.fasterxml.jackson.databind.BeanProperty.Std(((String) (obj)), javatype, propertybuilder.getClassAnnotations(), annotatedmember);
        obj = findSerializerFromAnnotation(serializerprovider, annotatedmember);
        if (obj instanceof ResolvableSerializer)
        {
            ((ResolvableSerializer)obj).resolve(serializerprovider);
        }
        typebindings = ((TypeBindings) (obj));
        if (obj instanceof ContextualSerializer)
        {
            typebindings = ((ContextualSerializer)obj).createContextual(serializerprovider, std);
        }
        obj = null;
        if (ClassUtil.isCollectionMapOrArray(javatype.getRawClass()))
        {
            obj = findPropertyContentTypeSerializer(javatype, serializerprovider.getConfig(), annotatedmember);
        }
        return propertybuilder.buildWriter(beanpropertydefinition, javatype, typebindings, findPropertyTypeSerializer(javatype, serializerprovider.getConfig(), annotatedmember), ((TypeSerializer) (obj)), annotatedmember, flag);
    }

    protected JsonSerializer constructBeanSerializer(SerializerProvider serializerprovider, BeanDescription beandescription)
        throws JsonMappingException
    {
        if (beandescription.getBeanClass() == java/lang/Object)
        {
            serializerprovider = serializerprovider.getUnknownTypeSerializer(java/lang/Object);
        } else
        {
            SerializationConfig serializationconfig = serializerprovider.getConfig();
            Object obj1 = constructBeanSerializerBuilder(beandescription);
            ((BeanSerializerBuilder) (obj1)).setConfig(serializationconfig);
            Object obj2 = findBeanProperties(serializerprovider, beandescription, ((BeanSerializerBuilder) (obj1)));
            Object obj = obj2;
            if (obj2 == null)
            {
                obj = new ArrayList();
            }
            obj2 = obj;
            if (_factoryConfig.hasSerializerModifiers())
            {
                Iterator iterator1 = _factoryConfig.serializerModifiers().iterator();
                do
                {
                    obj2 = obj;
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    obj = ((BeanSerializerModifier)iterator1.next()).changeProperties(serializationconfig, beandescription, ((List) (obj)));
                } while (true);
            }
            obj = filterBeanProperties(serializationconfig, beandescription, ((List) (obj2)));
            obj2 = obj;
            if (_factoryConfig.hasSerializerModifiers())
            {
                Iterator iterator2 = _factoryConfig.serializerModifiers().iterator();
                do
                {
                    obj2 = obj;
                    if (!iterator2.hasNext())
                    {
                        break;
                    }
                    obj = ((BeanSerializerModifier)iterator2.next()).orderProperties(serializationconfig, beandescription, ((List) (obj)));
                } while (true);
            }
            ((BeanSerializerBuilder) (obj1)).setObjectIdWriter(constructObjectIdHandler(serializerprovider, beandescription, ((List) (obj2))));
            ((BeanSerializerBuilder) (obj1)).setProperties(((List) (obj2)));
            ((BeanSerializerBuilder) (obj1)).setFilterId(findFilterId(serializationconfig, beandescription));
            serializerprovider = beandescription.findAnyGetter();
            if (serializerprovider != null)
            {
                if (serializationconfig.canOverrideAccessModifiers())
                {
                    serializerprovider.fixAccess();
                }
                Object obj3 = serializerprovider.getType(beandescription.bindingsForBeanType());
                boolean flag = serializationconfig.isEnabled(MapperFeature.USE_STATIC_TYPING);
                obj = ((JavaType) (obj3)).getContentType();
                obj3 = MapSerializer.construct(null, ((JavaType) (obj3)), flag, createTypeSerializer(serializationconfig, ((JavaType) (obj))), null, null);
                ((BeanSerializerBuilder) (obj1)).setAnyGetter(new AnyGetterWriter(new com.fasterxml.jackson.databind.BeanProperty.Std(serializerprovider.getName(), ((JavaType) (obj)), beandescription.getClassAnnotations(), serializerprovider), serializerprovider, ((MapSerializer) (obj3))));
            }
            processViews(serializationconfig, ((BeanSerializerBuilder) (obj1)));
            obj = obj1;
            if (_factoryConfig.hasSerializerModifiers())
            {
                Iterator iterator = _factoryConfig.serializerModifiers().iterator();
                serializerprovider = ((SerializerProvider) (obj1));
                do
                {
                    obj = serializerprovider;
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    serializerprovider = ((BeanSerializerModifier)iterator.next()).updateBuilder(serializationconfig, beandescription, serializerprovider);
                } while (true);
            }
            obj1 = ((BeanSerializerBuilder) (obj)).build();
            serializerprovider = ((SerializerProvider) (obj1));
            if (obj1 == null)
            {
                serializerprovider = ((SerializerProvider) (obj1));
                if (beandescription.hasKnownClassAnnotations())
                {
                    return ((BeanSerializerBuilder) (obj)).createDummy();
                }
            }
        }
        return serializerprovider;
    }

    protected final JsonSerializer constructBeanSerializer(SerializerProvider serializerprovider, BeanDescription beandescription, BeanProperty beanproperty)
        throws JsonMappingException
    {
        return constructBeanSerializer(serializerprovider, beandescription);
    }

    protected BeanSerializerBuilder constructBeanSerializerBuilder(BeanDescription beandescription)
    {
        return new BeanSerializerBuilder(beandescription);
    }

    protected BeanPropertyWriter constructFilteredBeanWriter(BeanPropertyWriter beanpropertywriter, Class aclass[])
    {
        return FilteredBeanPropertyWriter.constructViewBased(beanpropertywriter, aclass);
    }

    protected ObjectIdWriter constructObjectIdHandler(SerializerProvider serializerprovider, BeanDescription beandescription, List list)
        throws JsonMappingException
    {
        ObjectIdInfo objectidinfo = beandescription.getObjectIdInfo();
        if (objectidinfo == null)
        {
            return null;
        }
        Object obj = objectidinfo.getGeneratorType();
        if (obj == com/fasterxml/jackson/annotation/ObjectIdGenerators$PropertyGenerator)
        {
            serializerprovider = objectidinfo.getPropertyName();
            int i = 0;
            int j = list.size();
            do
            {
                if (i == j)
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("Invalid Object Id definition for ").append(beandescription.getBeanClass().getName()).append(": can not find property with name '").append(serializerprovider).append("'").toString());
                }
                obj = (BeanPropertyWriter)list.get(i);
                if (serializerprovider.equals(((BeanPropertyWriter) (obj)).getName()))
                {
                    if (i > 0)
                    {
                        list.remove(i);
                        list.add(0, obj);
                    }
                    return ObjectIdWriter.construct(((BeanPropertyWriter) (obj)).getType(), null, new PropertyBasedObjectIdGenerator(objectidinfo, ((BeanPropertyWriter) (obj))), objectidinfo.getAlwaysAsId());
                }
                i++;
            } while (true);
        } else
        {
            list = serializerprovider.constructType(((java.lang.reflect.Type) (obj)));
            list = serializerprovider.getTypeFactory().findTypeParameters(list, com/fasterxml/jackson/annotation/ObjectIdGenerator)[0];
            serializerprovider = serializerprovider.objectIdGeneratorInstance(beandescription.getClassInfo(), objectidinfo);
            return ObjectIdWriter.construct(list, objectidinfo.getPropertyName(), serializerprovider, objectidinfo.getAlwaysAsId());
        }
    }

    protected PropertyBuilder constructPropertyBuilder(SerializationConfig serializationconfig, BeanDescription beandescription)
    {
        return new PropertyBuilder(serializationconfig, beandescription);
    }

    public JsonSerializer createSerializer(SerializerProvider serializerprovider, JavaType javatype)
        throws JsonMappingException
    {
        BeanDescription beandescription;
        SerializationConfig serializationconfig;
        JavaType javatype1;
        serializationconfig = serializerprovider.getConfig();
        beandescription = serializationconfig.introspect(javatype);
        JsonSerializer jsonserializer = findSerializerFromAnnotation(serializerprovider, beandescription.getClassInfo());
        if (jsonserializer != null)
        {
            return jsonserializer;
        }
        javatype1 = modifyTypeByAnnotation(serializationconfig, beandescription.getClassInfo(), javatype);
        if (javatype1 != javatype) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        JsonSerializer jsonserializer1 = findSerializerByAnnotations(serializerprovider, javatype1, beandescription);
        if (jsonserializer1 != null)
        {
            return jsonserializer1;
        }
        break; /* Loop/switch isn't completed */
_L2:
        boolean flag1 = true;
        flag = flag1;
        if (javatype1.getRawClass() != javatype.getRawClass())
        {
            beandescription = serializationconfig.introspect(javatype1);
            flag = flag1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        boolean flag2;
label0:
        {
            if (javatype.isContainerType())
            {
                flag2 = flag;
                if (!flag)
                {
                    flag2 = usesStaticTyping(serializationconfig, beandescription, null);
                }
                javatype = buildContainerSerializer(serializerprovider, javatype1, beandescription, flag2);
                if (javatype != null)
                {
                    return javatype;
                }
                break label0;
            }
            javatype = customSerializers().iterator();
            JsonSerializer jsonserializer2;
            do
            {
                flag2 = flag;
                if (!javatype.hasNext())
                {
                    break label0;
                }
                jsonserializer2 = ((Serializers)javatype.next()).findSerializer(serializationconfig, javatype1, beandescription);
            } while (jsonserializer2 == null);
            return jsonserializer2;
        }
        JsonSerializer jsonserializer3 = findSerializerByLookup(javatype1, serializationconfig, beandescription, flag2);
        javatype = jsonserializer3;
        if (jsonserializer3 == null)
        {
            JsonSerializer jsonserializer4 = findSerializerByPrimaryType(serializerprovider, javatype1, beandescription, flag2);
            javatype = jsonserializer4;
            if (jsonserializer4 == null)
            {
                serializerprovider = findBeanSerializer(serializerprovider, javatype1, beandescription);
                javatype = serializerprovider;
                if (serializerprovider == null)
                {
                    javatype = findSerializerByAddonType(serializationconfig, javatype1, beandescription, flag2);
                }
            }
        }
        return javatype;
    }

    protected Iterable customSerializers()
    {
        return _factoryConfig.serializers();
    }

    protected List filterBeanProperties(SerializationConfig serializationconfig, BeanDescription beandescription, List list)
    {
        serializationconfig = serializationconfig.getAnnotationIntrospector().findPropertiesToIgnore(beandescription.getClassInfo());
        if (serializationconfig != null && serializationconfig.length > 0)
        {
            serializationconfig = ArrayBuilders.arrayToSet(serializationconfig);
            beandescription = list.iterator();
            do
            {
                if (!beandescription.hasNext())
                {
                    break;
                }
                if (serializationconfig.contains(((BeanPropertyWriter)beandescription.next()).getName()))
                {
                    beandescription.remove();
                }
            } while (true);
        }
        return list;
    }

    protected List findBeanProperties(SerializerProvider serializerprovider, BeanDescription beandescription, BeanSerializerBuilder beanserializerbuilder)
        throws JsonMappingException
    {
        SerializationConfig serializationconfig;
        Object obj;
        obj = beandescription.findProperties();
        serializationconfig = serializerprovider.getConfig();
        removeIgnorableTypes(serializationconfig, beandescription, ((List) (obj)));
        if (serializationconfig.isEnabled(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS))
        {
            removeSetterlessGetters(serializationconfig, beandescription, ((List) (obj)));
        }
        if (!((List) (obj)).isEmpty()) goto _L2; else goto _L1
_L1:
        beandescription = null;
_L4:
        return beandescription;
_L2:
        boolean flag = usesStaticTyping(serializationconfig, beandescription, null);
        PropertyBuilder propertybuilder = constructPropertyBuilder(serializationconfig, beandescription);
        ArrayList arraylist = new ArrayList(((List) (obj)).size());
        TypeBindings typebindings = beandescription.bindingsForBeanType();
        obj = ((List) (obj)).iterator();
        do
        {
            beandescription = arraylist;
            if (!((Iterator) (obj)).hasNext())
            {
                continue;
            }
            beandescription = (BeanPropertyDefinition)((Iterator) (obj)).next();
            AnnotatedMember annotatedmember = beandescription.getAccessor();
            if (beandescription.isTypeId())
            {
                if (annotatedmember != null)
                {
                    if (serializationconfig.canOverrideAccessModifiers())
                    {
                        annotatedmember.fixAccess();
                    }
                    beanserializerbuilder.setTypeId(annotatedmember);
                }
            } else
            {
                com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty referenceproperty = beandescription.findReferenceType();
                if (referenceproperty == null || !referenceproperty.isBackReference())
                {
                    if (annotatedmember instanceof AnnotatedMethod)
                    {
                        arraylist.add(_constructWriter(serializerprovider, beandescription, typebindings, propertybuilder, flag, (AnnotatedMethod)annotatedmember));
                    } else
                    {
                        arraylist.add(_constructWriter(serializerprovider, beandescription, typebindings, propertybuilder, flag, (AnnotatedField)annotatedmember));
                    }
                }
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public JsonSerializer findBeanSerializer(SerializerProvider serializerprovider, JavaType javatype, BeanDescription beandescription)
        throws JsonMappingException
    {
        if (isPotentialBeanType(javatype.getRawClass()) || javatype.isEnumType()) goto _L2; else goto _L1
_L1:
        javatype = null;
_L4:
        return javatype;
_L2:
        JsonSerializer jsonserializer = constructBeanSerializer(serializerprovider, beandescription);
        javatype = jsonserializer;
        if (!_factoryConfig.hasSerializerModifiers())
        {
            continue;
        }
        Iterator iterator = _factoryConfig.serializerModifiers().iterator();
        do
        {
            javatype = jsonserializer;
            if (!iterator.hasNext())
            {
                continue;
            }
            jsonserializer = ((BeanSerializerModifier)iterator.next()).modifySerializer(serializerprovider.getConfig(), beandescription, jsonserializer);
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final JsonSerializer findBeanSerializer(SerializerProvider serializerprovider, JavaType javatype, BeanDescription beandescription, BeanProperty beanproperty)
        throws JsonMappingException
    {
        return findBeanSerializer(serializerprovider, javatype, beandescription);
    }

    protected Object findFilterId(SerializationConfig serializationconfig, BeanDescription beandescription)
    {
        return serializationconfig.getAnnotationIntrospector().findFilterId(beandescription.getClassInfo());
    }

    public TypeSerializer findPropertyContentTypeSerializer(JavaType javatype, SerializationConfig serializationconfig, AnnotatedMember annotatedmember)
        throws JsonMappingException
    {
        JavaType javatype1 = javatype.getContentType();
        AnnotationIntrospector annotationintrospector = serializationconfig.getAnnotationIntrospector();
        javatype = annotationintrospector.findPropertyContentTypeResolver(serializationconfig, annotatedmember, javatype);
        if (javatype == null)
        {
            return createTypeSerializer(serializationconfig, javatype1);
        } else
        {
            return javatype.buildTypeSerializer(serializationconfig, javatype1, serializationconfig.getSubtypeResolver().collectAndResolveSubtypes(annotatedmember, serializationconfig, annotationintrospector, javatype1));
        }
    }

    public TypeSerializer findPropertyTypeSerializer(JavaType javatype, SerializationConfig serializationconfig, AnnotatedMember annotatedmember)
        throws JsonMappingException
    {
        AnnotationIntrospector annotationintrospector = serializationconfig.getAnnotationIntrospector();
        TypeResolverBuilder typeresolverbuilder = annotationintrospector.findPropertyTypeResolver(serializationconfig, annotatedmember, javatype);
        if (typeresolverbuilder == null)
        {
            return createTypeSerializer(serializationconfig, javatype);
        } else
        {
            return typeresolverbuilder.buildTypeSerializer(serializationconfig, javatype, serializationconfig.getSubtypeResolver().collectAndResolveSubtypes(annotatedmember, serializationconfig, annotationintrospector, javatype));
        }
    }

    public final TypeSerializer findPropertyTypeSerializer(JavaType javatype, SerializationConfig serializationconfig, AnnotatedMember annotatedmember, BeanProperty beanproperty)
        throws JsonMappingException
    {
        return findPropertyTypeSerializer(javatype, serializationconfig, annotatedmember);
    }

    protected boolean isPotentialBeanType(Class class1)
    {
        return ClassUtil.canBeABeanType(class1) == null && !ClassUtil.isProxyType(class1);
    }

    protected void processViews(SerializationConfig serializationconfig, BeanSerializerBuilder beanserializerbuilder)
    {
        List list = beanserializerbuilder.getProperties();
        boolean flag = serializationconfig.isEnabled(MapperFeature.DEFAULT_VIEW_INCLUSION);
        int l = list.size();
        int j = 0;
        serializationconfig = new BeanPropertyWriter[l];
        int i = 0;
        while (i < l) 
        {
            BeanPropertyWriter beanpropertywriter = (BeanPropertyWriter)list.get(i);
            Class aclass[] = beanpropertywriter.getViews();
            int k;
            if (aclass == null)
            {
                k = j;
                if (flag)
                {
                    serializationconfig[i] = beanpropertywriter;
                    k = j;
                }
            } else
            {
                k = j + 1;
                serializationconfig[i] = constructFilteredBeanWriter(beanpropertywriter, aclass);
            }
            i++;
            j = k;
        }
        if (flag && j == 0)
        {
            return;
        } else
        {
            beanserializerbuilder.setFilteredProperties(serializationconfig);
            return;
        }
    }

    protected void removeIgnorableTypes(SerializationConfig serializationconfig, BeanDescription beandescription, List list)
    {
        AnnotationIntrospector annotationintrospector = serializationconfig.getAnnotationIntrospector();
        HashMap hashmap = new HashMap();
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            beandescription = ((BeanPropertyDefinition)iterator.next()).getAccessor();
            if (beandescription == null)
            {
                iterator.remove();
            } else
            {
                Class class1 = beandescription.getRawType();
                list = (Boolean)hashmap.get(class1);
                beandescription = list;
                if (list == null)
                {
                    list = annotationintrospector.isIgnorableType(serializationconfig.introspectClassAnnotations(class1).getClassInfo());
                    beandescription = list;
                    if (list == null)
                    {
                        beandescription = Boolean.FALSE;
                    }
                    hashmap.put(class1, beandescription);
                }
                if (beandescription.booleanValue())
                {
                    iterator.remove();
                }
            }
        } while (true);
    }

    protected void removeSetterlessGetters(SerializationConfig serializationconfig, BeanDescription beandescription, List list)
    {
        serializationconfig = list.iterator();
        do
        {
            if (!serializationconfig.hasNext())
            {
                break;
            }
            beandescription = (BeanPropertyDefinition)serializationconfig.next();
            if (!beandescription.couldDeserialize() && !beandescription.isExplicitlyIncluded())
            {
                serializationconfig.remove();
            }
        } while (true);
    }

    public SerializerFactory withConfig(SerializerFactoryConfig serializerfactoryconfig)
    {
        if (_factoryConfig == serializerfactoryconfig)
        {
            return this;
        }
        if (getClass() != com/fasterxml/jackson/databind/ser/BeanSerializerFactory)
        {
            throw new IllegalStateException((new StringBuilder()).append("Subtype of BeanSerializerFactory (").append(getClass().getName()).append(") has not properly overridden method 'withAdditionalSerializers': can not instantiate subtype with ").append("additional serializer definitions").toString());
        } else
        {
            return new BeanSerializerFactory(serializerfactoryconfig);
        }
    }

}
