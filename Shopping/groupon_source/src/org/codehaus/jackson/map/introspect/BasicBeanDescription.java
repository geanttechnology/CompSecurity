// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map.introspect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.BeanDescription;
import org.codehaus.jackson.map.BeanPropertyDefinition;
import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.type.TypeBindings;
import org.codehaus.jackson.map.util.Annotations;
import org.codehaus.jackson.type.JavaType;

// Referenced classes of package org.codehaus.jackson.map.introspect:
//            POJOPropertiesCollector, AnnotatedMethod, AnnotatedClass, AnnotatedConstructor

public class BasicBeanDescription extends BeanDescription
{

    protected final AnnotationIntrospector _annotationIntrospector;
    protected AnnotatedMethod _anyGetterMethod;
    protected AnnotatedMethod _anySetterMethod;
    protected TypeBindings _bindings;
    protected final AnnotatedClass _classInfo;
    protected final MapperConfig _config;
    protected Set _ignoredPropertyNames;
    protected Map _injectables;
    protected AnnotatedMethod _jsonValueMethod;
    protected final List _properties;

    protected BasicBeanDescription(MapperConfig mapperconfig, JavaType javatype, AnnotatedClass annotatedclass, List list)
    {
        super(javatype);
        _config = mapperconfig;
        if (mapperconfig == null)
        {
            mapperconfig = null;
        } else
        {
            mapperconfig = mapperconfig.getAnnotationIntrospector();
        }
        _annotationIntrospector = mapperconfig;
        _classInfo = annotatedclass;
        _properties = list;
    }

    public static BasicBeanDescription forDeserialization(POJOPropertiesCollector pojopropertiescollector)
    {
        BasicBeanDescription basicbeandescription = new BasicBeanDescription(pojopropertiescollector.getConfig(), pojopropertiescollector.getType(), pojopropertiescollector.getClassDef(), pojopropertiescollector.getProperties());
        basicbeandescription._anySetterMethod = pojopropertiescollector.getAnySetterMethod();
        basicbeandescription._ignoredPropertyNames = pojopropertiescollector.getIgnoredPropertyNames();
        basicbeandescription._injectables = pojopropertiescollector.getInjectables();
        return basicbeandescription;
    }

    public static BasicBeanDescription forOtherUse(MapperConfig mapperconfig, JavaType javatype, AnnotatedClass annotatedclass)
    {
        return new BasicBeanDescription(mapperconfig, javatype, annotatedclass, Collections.emptyList());
    }

    public static BasicBeanDescription forSerialization(POJOPropertiesCollector pojopropertiescollector)
    {
        BasicBeanDescription basicbeandescription = new BasicBeanDescription(pojopropertiescollector.getConfig(), pojopropertiescollector.getType(), pojopropertiescollector.getClassDef(), pojopropertiescollector.getProperties());
        basicbeandescription._jsonValueMethod = pojopropertiescollector.getJsonValueMethod();
        basicbeandescription._anyGetterMethod = pojopropertiescollector.getAnyGetterMethod();
        return basicbeandescription;
    }

    public TypeBindings bindingsForBeanType()
    {
        if (_bindings == null)
        {
            _bindings = new TypeBindings(_config.getTypeFactory(), _type);
        }
        return _bindings;
    }

    public AnnotatedMethod findAnyGetter()
        throws IllegalArgumentException
    {
        if (_anyGetterMethod != null && !java/util/Map.isAssignableFrom(_anyGetterMethod.getRawType()))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid 'any-getter' annotation on method ").append(_anyGetterMethod.getName()).append("(): return type is not instance of java.util.Map").toString());
        } else
        {
            return _anyGetterMethod;
        }
    }

    public AnnotatedMethod findAnySetter()
        throws IllegalArgumentException
    {
        if (_anySetterMethod != null)
        {
            Class class1 = _anySetterMethod.getParameterClass(0);
            if (class1 != java/lang/String && class1 != java/lang/Object)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid 'any-setter' annotation on method ").append(_anySetterMethod.getName()).append("(): first argument not of type String or Object, but ").append(class1.getName()).toString());
            }
        }
        return _anySetterMethod;
    }

    public Map findBackReferenceProperties()
    {
        HashMap hashmap = null;
        for (Iterator iterator = _properties.iterator(); iterator.hasNext();)
        {
            AnnotatedMember annotatedmember = ((BeanPropertyDefinition)iterator.next()).getMutator();
            if (annotatedmember != null)
            {
                Object obj = _annotationIntrospector.findReferenceType(annotatedmember);
                if (obj != null && ((org.codehaus.jackson.map.AnnotationIntrospector.ReferenceProperty) (obj)).isBackReference())
                {
                    HashMap hashmap1 = hashmap;
                    if (hashmap == null)
                    {
                        hashmap1 = new HashMap();
                    }
                    obj = ((org.codehaus.jackson.map.AnnotationIntrospector.ReferenceProperty) (obj)).getName();
                    hashmap = hashmap1;
                    if (hashmap1.put(obj, annotatedmember) != null)
                    {
                        throw new IllegalArgumentException((new StringBuilder()).append("Multiple back-reference properties with name '").append(((String) (obj))).append("'").toString());
                    }
                }
            }
        }

        return hashmap;
    }

    public AnnotatedConstructor findDefaultConstructor()
    {
        return _classInfo.getDefaultConstructor();
    }

    public transient Method findFactoryMethod(Class aclass[])
    {
        Iterator iterator = _classInfo.getStaticMethods().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            AnnotatedMethod annotatedmethod = (AnnotatedMethod)iterator.next();
            if (isFactoryMethod(annotatedmethod))
            {
                Class class1 = annotatedmethod.getParameterClass(0);
                int j = aclass.length;
                int i = 0;
                while (i < j) 
                {
                    if (class1.isAssignableFrom(aclass[i]))
                    {
                        return annotatedmethod.getAnnotated();
                    }
                    i++;
                }
            }
        } while (true);
        return null;
    }

    public Map findInjectables()
    {
        return _injectables;
    }

    public AnnotatedMethod findJsonValueMethod()
    {
        return _jsonValueMethod;
    }

    public AnnotatedMethod findMethod(String s, Class aclass[])
    {
        return _classInfo.findMethod(s, aclass);
    }

    public List findProperties()
    {
        return _properties;
    }

    public org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion findSerializationInclusion(org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion inclusion)
    {
        if (_annotationIntrospector == null)
        {
            return inclusion;
        } else
        {
            return _annotationIntrospector.findSerializationInclusion(_classInfo, inclusion);
        }
    }

    public transient Constructor findSingleArgConstructor(Class aclass[])
    {
        Iterator iterator = _classInfo.getConstructors().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            AnnotatedConstructor annotatedconstructor = (AnnotatedConstructor)iterator.next();
            if (annotatedconstructor.getParameterCount() == 1)
            {
                Class class1 = annotatedconstructor.getParameterClass(0);
                int j = aclass.length;
                int i = 0;
                while (i < j) 
                {
                    if (aclass[i] == class1)
                    {
                        return annotatedconstructor.getAnnotated();
                    }
                    i++;
                }
            }
        } while (true);
        return null;
    }

    public Annotations getClassAnnotations()
    {
        return _classInfo.getAnnotations();
    }

    public AnnotatedClass getClassInfo()
    {
        return _classInfo;
    }

    public List getConstructors()
    {
        return _classInfo.getConstructors();
    }

    public List getFactoryMethods()
    {
        Object obj = _classInfo.getStaticMethods();
        if (((List) (obj)).isEmpty())
        {
            return ((List) (obj));
        }
        ArrayList arraylist = new ArrayList();
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            AnnotatedMethod annotatedmethod = (AnnotatedMethod)((Iterator) (obj)).next();
            if (isFactoryMethod(annotatedmethod))
            {
                arraylist.add(annotatedmethod);
            }
        } while (true);
        return arraylist;
    }

    public Set getIgnoredPropertyNames()
    {
        if (_ignoredPropertyNames == null)
        {
            return Collections.emptySet();
        } else
        {
            return _ignoredPropertyNames;
        }
    }

    public boolean hasKnownClassAnnotations()
    {
        return _classInfo.hasAnnotations();
    }

    public Object instantiateBean(boolean flag)
    {
        Object obj = _classInfo.getDefaultConstructor();
        if (obj == null)
        {
            return null;
        }
        if (flag)
        {
            ((AnnotatedConstructor) (obj)).fixAccess();
        }
        try
        {
            obj = ((AnnotatedConstructor) (obj)).getAnnotated().newInstance(new Object[0]);
        }
        catch (Object obj1)
        {
            for (; ((Throwable) (obj1)).getCause() != null; obj1 = ((Throwable) (obj1)).getCause()) { }
            if (obj1 instanceof Error)
            {
                throw (Error)obj1;
            }
            if (obj1 instanceof RuntimeException)
            {
                throw (RuntimeException)obj1;
            } else
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Failed to instantiate bean of type ").append(_classInfo.getAnnotated().getName()).append(": (").append(obj1.getClass().getName()).append(") ").append(((Throwable) (obj1)).getMessage()).toString(), ((Throwable) (obj1)));
            }
        }
        return obj;
    }

    protected boolean isFactoryMethod(AnnotatedMethod annotatedmethod)
    {
        Class class1 = annotatedmethod.getRawType();
        if (getBeanClass().isAssignableFrom(class1))
        {
            if (_annotationIntrospector.hasCreatorAnnotation(annotatedmethod))
            {
                return true;
            }
            if ("valueOf".equals(annotatedmethod.getName()))
            {
                return true;
            }
        }
        return false;
    }

    public JavaType resolveType(Type type)
    {
        if (type == null)
        {
            return null;
        } else
        {
            return bindingsForBeanType().resolveType(type);
        }
    }
}
