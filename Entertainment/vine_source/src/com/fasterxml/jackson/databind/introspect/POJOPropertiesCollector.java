// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// Referenced classes of package com.fasterxml.jackson.databind.introspect:
//            AnnotatedClass, AnnotatedConstructor, POJOPropertyBuilder, AnnotatedMethod, 
//            AnnotatedField, VisibilityChecker, AnnotatedMember, ObjectIdInfo

public class POJOPropertiesCollector
{

    protected final AnnotationIntrospector _annotationIntrospector;
    protected LinkedList _anyGetters;
    protected LinkedList _anySetters;
    protected final AnnotatedClass _classDef;
    protected final MapperConfig _config;
    protected LinkedList _creatorProperties;
    protected final boolean _forSerialization;
    protected HashSet _ignoredPropertyNames;
    protected LinkedHashMap _injectables;
    protected LinkedList _jsonValueGetters;
    protected final String _mutatorPrefix;
    protected final LinkedHashMap _properties = new LinkedHashMap();
    protected final JavaType _type;
    protected final VisibilityChecker _visibilityChecker;

    protected POJOPropertiesCollector(MapperConfig mapperconfig, boolean flag, JavaType javatype, AnnotatedClass annotatedclass, String s)
    {
        Object obj = null;
        super();
        _creatorProperties = null;
        _anyGetters = null;
        _anySetters = null;
        _jsonValueGetters = null;
        _config = mapperconfig;
        _forSerialization = flag;
        _type = javatype;
        _classDef = annotatedclass;
        javatype = s;
        if (s == null)
        {
            javatype = "set";
        }
        _mutatorPrefix = javatype;
        javatype = obj;
        if (mapperconfig.isAnnotationProcessingEnabled())
        {
            javatype = _config.getAnnotationIntrospector();
        }
        _annotationIntrospector = javatype;
        if (_annotationIntrospector == null)
        {
            _visibilityChecker = _config.getDefaultVisibilityChecker();
            return;
        } else
        {
            _visibilityChecker = _annotationIntrospector.findAutoDetectVisibility(annotatedclass, _config.getDefaultVisibilityChecker());
            return;
        }
    }

    private void _addIgnored(String s)
    {
        if (!_forSerialization)
        {
            if (_ignoredPropertyNames == null)
            {
                _ignoredPropertyNames = new HashSet();
            }
            _ignoredPropertyNames.add(s);
        }
    }

    private PropertyNamingStrategy _findNamingStrategy()
    {
        Object obj;
        if (_annotationIntrospector == null)
        {
            obj = null;
        } else
        {
            obj = _annotationIntrospector.findNamingStrategy(_classDef);
        }
        if (obj == null)
        {
            return _config.getPropertyNamingStrategy();
        }
        if (obj instanceof PropertyNamingStrategy)
        {
            return (PropertyNamingStrategy)obj;
        }
        if (!(obj instanceof Class))
        {
            throw new IllegalStateException((new StringBuilder()).append("AnnotationIntrospector returned PropertyNamingStrategy definition of type ").append(obj.getClass().getName()).append("; expected type PropertyNamingStrategy or Class<PropertyNamingStrategy> instead").toString());
        }
        obj = (Class)obj;
        if (!com/fasterxml/jackson/databind/PropertyNamingStrategy.isAssignableFrom(((Class) (obj))))
        {
            throw new IllegalStateException((new StringBuilder()).append("AnnotationIntrospector returned Class ").append(((Class) (obj)).getName()).append("; expected Class<PropertyNamingStrategy>").toString());
        }
        Object obj1 = _config.getHandlerInstantiator();
        if (obj1 != null)
        {
            obj1 = ((HandlerInstantiator) (obj1)).namingStrategyInstance(_config, _classDef, ((Class) (obj)));
            if (obj1 != null)
            {
                return ((PropertyNamingStrategy) (obj1));
            }
        }
        return (PropertyNamingStrategy)ClassUtil.createInstance(((Class) (obj)), _config.canOverrideAccessModifiers());
    }

    protected void _addCreators()
    {
        AnnotationIntrospector annotationintrospector = _annotationIntrospector;
        if (annotationintrospector != null)
        {
            for (Iterator iterator = _classDef.getConstructors().iterator(); iterator.hasNext();)
            {
                AnnotatedConstructor annotatedconstructor = (AnnotatedConstructor)iterator.next();
                if (_creatorProperties == null)
                {
                    _creatorProperties = new LinkedList();
                }
                int k = annotatedconstructor.getParameterCount();
                int i = 0;
                while (i < k) 
                {
                    AnnotatedParameter annotatedparameter = annotatedconstructor.getParameter(i);
                    Object obj = annotationintrospector.findNameForDeserialization(annotatedparameter);
                    if (obj == null)
                    {
                        obj = null;
                    } else
                    {
                        obj = ((PropertyName) (obj)).getSimpleName();
                    }
                    if (obj != null)
                    {
                        POJOPropertyBuilder pojopropertybuilder = _property(((String) (obj)));
                        pojopropertybuilder.addCtor(annotatedparameter, ((String) (obj)), true, false);
                        _creatorProperties.add(pojopropertybuilder);
                    }
                    i++;
                }
            }

            Iterator iterator1 = _classDef.getStaticMethods().iterator();
            while (iterator1.hasNext()) 
            {
                AnnotatedMethod annotatedmethod = (AnnotatedMethod)iterator1.next();
                if (_creatorProperties == null)
                {
                    _creatorProperties = new LinkedList();
                }
                int l = annotatedmethod.getParameterCount();
                int j = 0;
                while (j < l) 
                {
                    AnnotatedParameter annotatedparameter1 = annotatedmethod.getParameter(j);
                    Object obj1 = annotationintrospector.findNameForDeserialization(annotatedparameter1);
                    if (obj1 == null)
                    {
                        obj1 = null;
                    } else
                    {
                        obj1 = ((PropertyName) (obj1)).getSimpleName();
                    }
                    if (obj1 != null)
                    {
                        POJOPropertyBuilder pojopropertybuilder1 = _property(((String) (obj1)));
                        pojopropertybuilder1.addCtor(annotatedparameter1, ((String) (obj1)), true, false);
                        _creatorProperties.add(pojopropertybuilder1);
                    }
                    j++;
                }
            }
        }
    }

    protected void _addFields()
    {
        AnnotationIntrospector annotationintrospector = _annotationIntrospector;
        Iterator iterator;
        boolean flag;
        if (!_forSerialization && !_config.isEnabled(MapperFeature.ALLOW_FINAL_FIELDS_AS_MUTATORS))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        iterator = _classDef.fields().iterator();
        do
        {
            if (iterator.hasNext())
            {
                AnnotatedField annotatedfield = (AnnotatedField)iterator.next();
                String s = annotatedfield.getName();
                Object obj;
                boolean flag1;
                boolean flag2;
                if (annotationintrospector == null)
                {
                    obj = null;
                } else
                if (_forSerialization)
                {
                    obj = annotationintrospector.findNameForSerialization(annotatedfield);
                    if (obj == null)
                    {
                        obj = null;
                    } else
                    {
                        obj = ((PropertyName) (obj)).getSimpleName();
                    }
                } else
                {
                    obj = annotationintrospector.findNameForDeserialization(annotatedfield);
                    if (obj == null)
                    {
                        obj = null;
                    } else
                    {
                        obj = ((PropertyName) (obj)).getSimpleName();
                    }
                }
                if ("".equals(obj))
                {
                    obj = s;
                }
                if (obj != null)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (!flag1)
                {
                    flag1 = _visibilityChecker.isFieldVisible(annotatedfield);
                }
                if (annotationintrospector != null && annotationintrospector.hasIgnoreMarker(annotatedfield))
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                if (!flag || obj != null || flag2 || !Modifier.isFinal(annotatedfield.getModifiers()))
                {
                    _property(s).addField(annotatedfield, ((String) (obj)), flag1, flag2);
                }
            } else
            {
                return;
            }
        } while (true);
    }

    protected void _addGetterMethod(AnnotatedMethod annotatedmethod, AnnotationIntrospector annotationintrospector)
    {
        String s = null;
        if (annotationintrospector == null) goto _L2; else goto _L1
_L1:
        if (!annotationintrospector.hasAnyGetterAnnotation(annotatedmethod)) goto _L4; else goto _L3
_L3:
        if (_anyGetters == null)
        {
            _anyGetters = new LinkedList();
        }
        _anyGetters.add(annotatedmethod);
_L8:
        return;
_L4:
        if (annotationintrospector.hasAsValueAnnotation(annotatedmethod))
        {
            if (_jsonValueGetters == null)
            {
                _jsonValueGetters = new LinkedList();
            }
            _jsonValueGetters.add(annotatedmethod);
            return;
        }
_L2:
        Object obj;
        boolean flag;
        if (annotationintrospector == null)
        {
            obj = null;
        } else
        {
            obj = annotationintrospector.findNameForSerialization(annotatedmethod);
        }
        if (obj == null)
        {
            obj = s;
        } else
        {
            obj = ((PropertyName) (obj)).getSimpleName();
        }
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        s = BeanUtil.okNameForRegularGetter(annotatedmethod, annotatedmethod.getName());
        if (s != null) goto _L6; else goto _L5
_L5:
        s = BeanUtil.okNameForIsGetter(annotatedmethod, annotatedmethod.getName());
        if (s == null) goto _L8; else goto _L7
_L7:
        flag = _visibilityChecker.isIsGetterVisible(annotatedmethod);
_L9:
        Object obj1;
        boolean flag1;
        if (annotationintrospector == null)
        {
            flag1 = false;
        } else
        {
            flag1 = annotationintrospector.hasIgnoreMarker(annotatedmethod);
        }
        _property(s).addGetter(annotatedmethod, ((String) (obj)), flag, flag1);
        return;
_L6:
        flag = _visibilityChecker.isGetterVisible(annotatedmethod);
          goto _L9
        obj1 = BeanUtil.okNameForGetter(annotatedmethod);
        s = ((String) (obj1));
        if (obj1 == null)
        {
            s = annotatedmethod.getName();
        }
        obj1 = obj;
        if (((String) (obj)).length() == 0)
        {
            obj1 = s;
        }
        flag = true;
        obj = obj1;
          goto _L9
    }

    protected void _addInjectables()
    {
        AnnotationIntrospector annotationintrospector = _annotationIntrospector;
        if (annotationintrospector != null)
        {
            AnnotatedField annotatedfield;
            for (Iterator iterator = _classDef.fields().iterator(); iterator.hasNext(); _doAddInjectable(annotationintrospector.findInjectableValueId(annotatedfield), annotatedfield))
            {
                annotatedfield = (AnnotatedField)iterator.next();
            }

            Iterator iterator1 = _classDef.memberMethods().iterator();
            while (iterator1.hasNext()) 
            {
                AnnotatedMethod annotatedmethod = (AnnotatedMethod)iterator1.next();
                if (annotatedmethod.getParameterCount() == 1)
                {
                    _doAddInjectable(annotationintrospector.findInjectableValueId(annotatedmethod), annotatedmethod);
                }
            }
        }
    }

    protected void _addMethods()
    {
        AnnotationIntrospector annotationintrospector = _annotationIntrospector;
        Iterator iterator = _classDef.memberMethods().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            AnnotatedMethod annotatedmethod = (AnnotatedMethod)iterator.next();
            int i = annotatedmethod.getParameterCount();
            if (i == 0)
            {
                _addGetterMethod(annotatedmethod, annotationintrospector);
            } else
            if (i == 1)
            {
                _addSetterMethod(annotatedmethod, annotationintrospector);
            } else
            if (i == 2 && annotationintrospector != null && annotationintrospector.hasAnySetterAnnotation(annotatedmethod))
            {
                if (_anySetters == null)
                {
                    _anySetters = new LinkedList();
                }
                _anySetters.add(annotatedmethod);
            }
        } while (true);
    }

    protected void _addSetterMethod(AnnotatedMethod annotatedmethod, AnnotationIntrospector annotationintrospector)
    {
        String s = null;
        Object obj;
        if (annotationintrospector == null)
        {
            obj = null;
        } else
        {
            obj = annotationintrospector.findNameForDeserialization(annotatedmethod);
        }
        if (obj == null)
        {
            obj = s;
        } else
        {
            obj = ((PropertyName) (obj)).getSimpleName();
        }
        boolean flag;
        boolean flag1;
        if (obj == null)
        {
            s = BeanUtil.okNameForMutator(annotatedmethod, _mutatorPrefix);
            if (s == null)
            {
                return;
            }
            flag = _visibilityChecker.isSetterVisible(annotatedmethod);
        } else
        {
            Object obj1 = BeanUtil.okNameForMutator(annotatedmethod, _mutatorPrefix);
            s = ((String) (obj1));
            if (obj1 == null)
            {
                s = annotatedmethod.getName();
            }
            obj1 = obj;
            if (((String) (obj)).length() == 0)
            {
                obj1 = s;
            }
            flag = true;
            obj = obj1;
        }
        if (annotationintrospector == null)
        {
            flag1 = false;
        } else
        {
            flag1 = annotationintrospector.hasIgnoreMarker(annotatedmethod);
        }
        _property(s).addSetter(annotatedmethod, ((String) (obj)), flag, flag1);
    }

    protected void _doAddInjectable(Object obj, AnnotatedMember annotatedmember)
    {
        if (obj != null)
        {
            if (_injectables == null)
            {
                _injectables = new LinkedHashMap();
            }
            if ((AnnotatedMember)_injectables.put(obj, annotatedmember) != null)
            {
                annotatedmember = obj.getClass().getName();
                throw new IllegalArgumentException((new StringBuilder()).append("Duplicate injectable value with id '").append(String.valueOf(obj)).append("' (of type ").append(annotatedmember).append(")").toString());
            }
        }
    }

    protected POJOPropertyBuilder _property(String s)
    {
        POJOPropertyBuilder pojopropertybuilder1 = (POJOPropertyBuilder)_properties.get(s);
        POJOPropertyBuilder pojopropertybuilder = pojopropertybuilder1;
        if (pojopropertybuilder1 == null)
        {
            pojopropertybuilder = new POJOPropertyBuilder(new PropertyName(s), _annotationIntrospector, _forSerialization);
            _properties.put(s, pojopropertybuilder);
        }
        return pojopropertybuilder;
    }

    protected void _removeUnwantedProperties()
    {
        Iterator iterator = _properties.entrySet().iterator();
        boolean flag;
        if (!_config.isEnabled(MapperFeature.INFER_PROPERTY_MUTATORS))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            POJOPropertyBuilder pojopropertybuilder = (POJOPropertyBuilder)((java.util.Map.Entry)iterator.next()).getValue();
            if (!pojopropertybuilder.anyVisible())
            {
                iterator.remove();
                continue;
            }
            if (pojopropertybuilder.anyIgnorals())
            {
                if (!pojopropertybuilder.isExplicitlyIncluded())
                {
                    iterator.remove();
                    _addIgnored(pojopropertybuilder.getName());
                    continue;
                }
                pojopropertybuilder.removeIgnored();
                if (!_forSerialization && !pojopropertybuilder.couldDeserialize())
                {
                    _addIgnored(pojopropertybuilder.getName());
                }
            }
            pojopropertybuilder.removeNonVisible(flag);
        } while (true);
    }

    protected void _renameProperties()
    {
        Iterator iterator = _properties.entrySet().iterator();
        Object obj = null;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            POJOPropertyBuilder pojopropertybuilder1 = (POJOPropertyBuilder)((java.util.Map.Entry)iterator.next()).getValue();
            String s1 = pojopropertybuilder1.findNewName();
            if (s1 != null)
            {
                LinkedList linkedlist = ((LinkedList) (obj));
                if (obj == null)
                {
                    linkedlist = new LinkedList();
                }
                linkedlist.add(pojopropertybuilder1.withSimpleName(s1));
                iterator.remove();
                obj = linkedlist;
            }
        } while (true);
        if (obj != null)
        {
            obj = ((LinkedList) (obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                POJOPropertyBuilder pojopropertybuilder = (POJOPropertyBuilder)((Iterator) (obj)).next();
                String s = pojopropertybuilder.getName();
                POJOPropertyBuilder pojopropertybuilder2 = (POJOPropertyBuilder)_properties.get(s);
                if (pojopropertybuilder2 == null)
                {
                    _properties.put(s, pojopropertybuilder);
                } else
                {
                    pojopropertybuilder2.addAll(pojopropertybuilder);
                }
                _updateCreatorProperty(pojopropertybuilder, _creatorProperties);
            }
        }
    }

    protected void _renameUsing(PropertyNamingStrategy propertynamingstrategy)
    {
        POJOPropertyBuilder apojopropertybuilder[] = (POJOPropertyBuilder[])_properties.values().toArray(new POJOPropertyBuilder[_properties.size()]);
        _properties.clear();
        int j = apojopropertybuilder.length;
        int i = 0;
        while (i < j) 
        {
            POJOPropertyBuilder pojopropertybuilder = apojopropertybuilder[i];
            Object obj = pojopropertybuilder.getFullName();
            String s = null;
            if (_forSerialization)
            {
                if (pojopropertybuilder.hasGetter())
                {
                    s = propertynamingstrategy.nameForGetterMethod(_config, pojopropertybuilder.getGetter(), ((PropertyName) (obj)).getSimpleName());
                } else
                if (pojopropertybuilder.hasField())
                {
                    s = propertynamingstrategy.nameForField(_config, pojopropertybuilder.getField(), ((PropertyName) (obj)).getSimpleName());
                }
            } else
            if (pojopropertybuilder.hasSetter())
            {
                s = propertynamingstrategy.nameForSetterMethod(_config, pojopropertybuilder.getSetter(), ((PropertyName) (obj)).getSimpleName());
            } else
            if (pojopropertybuilder.hasConstructorParameter())
            {
                s = propertynamingstrategy.nameForConstructorParameter(_config, pojopropertybuilder.getConstructorParameter(), ((PropertyName) (obj)).getSimpleName());
            } else
            if (pojopropertybuilder.hasField())
            {
                s = propertynamingstrategy.nameForField(_config, pojopropertybuilder.getField(), ((PropertyName) (obj)).getSimpleName());
            } else
            if (pojopropertybuilder.hasGetter())
            {
                s = propertynamingstrategy.nameForGetterMethod(_config, pojopropertybuilder.getGetter(), ((PropertyName) (obj)).getSimpleName());
            }
            if (s != null && !((PropertyName) (obj)).hasSimpleName(s))
            {
                pojopropertybuilder = pojopropertybuilder.withSimpleName(s);
            } else
            {
                s = ((PropertyName) (obj)).getSimpleName();
            }
            obj = (POJOPropertyBuilder)_properties.get(s);
            if (obj == null)
            {
                _properties.put(s, pojopropertybuilder);
            } else
            {
                ((POJOPropertyBuilder) (obj)).addAll(pojopropertybuilder);
            }
            _updateCreatorProperty(pojopropertybuilder, _creatorProperties);
            i++;
        }
    }

    protected void _renameWithWrappers()
    {
        Iterator iterator = _properties.entrySet().iterator();
        Object obj = null;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            POJOPropertyBuilder pojopropertybuilder1 = (POJOPropertyBuilder)((java.util.Map.Entry)iterator.next()).getValue();
            AnnotatedMember annotatedmember = pojopropertybuilder1.getPrimaryMember();
            if (annotatedmember != null)
            {
                PropertyName propertyname = _annotationIntrospector.findWrapperName(annotatedmember);
                if (propertyname != null && propertyname.hasSimpleName() && !propertyname.equals(pojopropertybuilder1.getFullName()))
                {
                    LinkedList linkedlist = ((LinkedList) (obj));
                    if (obj == null)
                    {
                        linkedlist = new LinkedList();
                    }
                    linkedlist.add(pojopropertybuilder1.withName(propertyname));
                    iterator.remove();
                    obj = linkedlist;
                }
            }
        } while (true);
        if (obj != null)
        {
            for (obj = ((LinkedList) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
            {
                POJOPropertyBuilder pojopropertybuilder = (POJOPropertyBuilder)((Iterator) (obj)).next();
                String s = pojopropertybuilder.getName();
                POJOPropertyBuilder pojopropertybuilder2 = (POJOPropertyBuilder)_properties.get(s);
                if (pojopropertybuilder2 == null)
                {
                    _properties.put(s, pojopropertybuilder);
                } else
                {
                    pojopropertybuilder2.addAll(pojopropertybuilder);
                }
            }

        }
    }

    protected void _sortProperties()
    {
        Object obj;
        Object obj1;
        LinkedHashMap linkedhashmap;
        boolean flag;
        obj1 = _annotationIntrospector;
        if (obj1 == null)
        {
            obj = null;
        } else
        {
            obj = ((AnnotationIntrospector) (obj1)).findSerializationSortAlphabetically(_classDef);
        }
        if (obj == null)
        {
            flag = _config.shouldSortPropertiesAlphabetically();
        } else
        {
            flag = ((Boolean) (obj)).booleanValue();
        }
        if (obj1 == null)
        {
            obj1 = null;
        } else
        {
            obj1 = ((AnnotationIntrospector) (obj1)).findSerializationPropertyOrder(_classDef);
        }
        if (!flag && _creatorProperties == null && obj1 == null)
        {
            return;
        }
        int i = _properties.size();
        Iterator iterator;
        POJOPropertyBuilder pojopropertybuilder2;
        if (flag)
        {
            obj = new TreeMap();
        } else
        {
            obj = new LinkedHashMap(i + i);
        }
        for (iterator = _properties.values().iterator(); iterator.hasNext(); ((Map) (obj)).put(pojopropertybuilder2.getName(), pojopropertybuilder2))
        {
            pojopropertybuilder2 = (POJOPropertyBuilder)iterator.next();
        }

        linkedhashmap = new LinkedHashMap(i + i);
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        int j;
        int k;
        k = obj1.length;
        j = 0;
_L4:
        if (j >= k) goto _L2; else goto _L3
_L3:
        POJOPropertyBuilder pojopropertybuilder;
        Object obj3;
        String s;
        s = obj1[j];
        pojopropertybuilder = (POJOPropertyBuilder)((Map) (obj)).get(s);
        if (pojopropertybuilder != null)
        {
            break MISSING_BLOCK_LABEL_452;
        }
        Iterator iterator2 = _properties.values().iterator();
        do
        {
            if (!iterator2.hasNext())
            {
                break MISSING_BLOCK_LABEL_452;
            }
            obj3 = (POJOPropertyBuilder)iterator2.next();
        } while (!s.equals(((POJOPropertyBuilder) (obj3)).getInternalName()));
        s = ((POJOPropertyBuilder) (obj3)).getName();
        pojopropertybuilder = ((POJOPropertyBuilder) (obj3));
        obj3 = s;
_L5:
        if (pojopropertybuilder != null)
        {
            linkedhashmap.put(obj3, pojopropertybuilder);
        }
        j++;
          goto _L4
_L2:
        if (_creatorProperties != null)
        {
            Object obj2;
            POJOPropertyBuilder pojopropertybuilder1;
            if (flag)
            {
                obj2 = new TreeMap();
                for (Iterator iterator1 = _creatorProperties.iterator(); iterator1.hasNext(); ((TreeMap) (obj2)).put(((POJOPropertyBuilder) (obj3)).getName(), obj3))
                {
                    obj3 = (POJOPropertyBuilder)iterator1.next();
                }

                obj2 = ((TreeMap) (obj2)).values();
            } else
            {
                obj2 = _creatorProperties;
            }
            for (obj2 = ((Collection) (obj2)).iterator(); ((Iterator) (obj2)).hasNext(); linkedhashmap.put(pojopropertybuilder1.getName(), pojopropertybuilder1))
            {
                pojopropertybuilder1 = (POJOPropertyBuilder)((Iterator) (obj2)).next();
            }

        }
        linkedhashmap.putAll(((Map) (obj)));
        _properties.clear();
        _properties.putAll(linkedhashmap);
        return;
        obj3 = s;
          goto _L5
    }

    protected void _updateCreatorProperty(POJOPropertyBuilder pojopropertybuilder, List list)
    {
        if (list == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        j = list.size();
        i = 0;
_L7:
        if (i >= j) goto _L2; else goto _L3
_L3:
        if (!((POJOPropertyBuilder)list.get(i)).getInternalName().equals(pojopropertybuilder.getInternalName())) goto _L5; else goto _L4
_L4:
        list.set(i, pojopropertybuilder);
_L2:
        return;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public POJOPropertiesCollector collect()
    {
        _properties.clear();
        _addFields();
        _addMethods();
        _addCreators();
        _addInjectables();
        _removeUnwantedProperties();
        _renameProperties();
        PropertyNamingStrategy propertynamingstrategy = _findNamingStrategy();
        if (propertynamingstrategy != null)
        {
            _renameUsing(propertynamingstrategy);
        }
        for (Iterator iterator = _properties.values().iterator(); iterator.hasNext(); ((POJOPropertyBuilder)iterator.next()).trimByVisibility()) { }
        for (Iterator iterator1 = _properties.values().iterator(); iterator1.hasNext(); ((POJOPropertyBuilder)iterator1.next()).mergeAnnotations(_forSerialization)) { }
        if (_config.isEnabled(MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME))
        {
            _renameWithWrappers();
        }
        _sortProperties();
        return this;
    }

    public Class findPOJOBuilderClass()
    {
        return _annotationIntrospector.findPOJOBuilder(_classDef);
    }

    public AnnotationIntrospector getAnnotationIntrospector()
    {
        return _annotationIntrospector;
    }

    public AnnotatedMember getAnyGetter()
    {
        if (_anyGetters != null)
        {
            if (_anyGetters.size() > 1)
            {
                reportProblem((new StringBuilder()).append("Multiple 'any-getters' defined (").append(_anyGetters.get(0)).append(" vs ").append(_anyGetters.get(1)).append(")").toString());
            }
            return (AnnotatedMember)_anyGetters.getFirst();
        } else
        {
            return null;
        }
    }

    public AnnotatedMethod getAnySetterMethod()
    {
        if (_anySetters != null)
        {
            if (_anySetters.size() > 1)
            {
                reportProblem((new StringBuilder()).append("Multiple 'any-setters' defined (").append(_anySetters.get(0)).append(" vs ").append(_anySetters.get(1)).append(")").toString());
            }
            return (AnnotatedMethod)_anySetters.getFirst();
        } else
        {
            return null;
        }
    }

    public AnnotatedClass getClassDef()
    {
        return _classDef;
    }

    public MapperConfig getConfig()
    {
        return _config;
    }

    public Set getIgnoredPropertyNames()
    {
        return _ignoredPropertyNames;
    }

    public Map getInjectables()
    {
        return _injectables;
    }

    public AnnotatedMethod getJsonValueMethod()
    {
        if (_jsonValueGetters != null)
        {
            if (_jsonValueGetters.size() > 1)
            {
                reportProblem((new StringBuilder()).append("Multiple value properties defined (").append(_jsonValueGetters.get(0)).append(" vs ").append(_jsonValueGetters.get(1)).append(")").toString());
            }
            return (AnnotatedMethod)_jsonValueGetters.get(0);
        } else
        {
            return null;
        }
    }

    public ObjectIdInfo getObjectIdInfo()
    {
        ObjectIdInfo objectidinfo;
        if (_annotationIntrospector == null)
        {
            objectidinfo = null;
        } else
        {
            ObjectIdInfo objectidinfo1 = _annotationIntrospector.findObjectIdInfo(_classDef);
            objectidinfo = objectidinfo1;
            if (objectidinfo1 != null)
            {
                return _annotationIntrospector.findObjectReferenceInfo(_classDef, objectidinfo1);
            }
        }
        return objectidinfo;
    }

    public List getProperties()
    {
        return new ArrayList(_properties.values());
    }

    protected Map getPropertyMap()
    {
        return _properties;
    }

    public JavaType getType()
    {
        return _type;
    }

    protected void reportProblem(String s)
    {
        throw new IllegalArgumentException((new StringBuilder()).append("Problem with definition of ").append(_classDef).append(": ").append(s).toString());
    }
}
