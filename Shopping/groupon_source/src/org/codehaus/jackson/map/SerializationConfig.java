// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map;

import java.text.DateFormat;
import java.util.HashMap;
import org.codehaus.jackson.map.introspect.Annotated;
import org.codehaus.jackson.map.introspect.VisibilityChecker;
import org.codehaus.jackson.map.jsontype.SubtypeResolver;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import org.codehaus.jackson.map.ser.FilterProvider;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;

// Referenced classes of package org.codehaus.jackson.map:
//            AnnotationIntrospector, ClassIntrospector, HandlerInstantiator, JsonSerializer, 
//            PropertyNamingStrategy, BeanDescription

public class SerializationConfig extends MapperConfig.Impl
{
    public static final class Feature extends Enum
        implements MapperConfig.ConfigFeature
    {

        private static final Feature $VALUES[];
        public static final Feature AUTO_DETECT_FIELDS;
        public static final Feature AUTO_DETECT_GETTERS;
        public static final Feature AUTO_DETECT_IS_GETTERS;
        public static final Feature CAN_OVERRIDE_ACCESS_MODIFIERS;
        public static final Feature CLOSE_CLOSEABLE;
        public static final Feature DEFAULT_VIEW_INCLUSION;
        public static final Feature FAIL_ON_EMPTY_BEANS;
        public static final Feature FLUSH_AFTER_WRITE_VALUE;
        public static final Feature INDENT_OUTPUT;
        public static final Feature REQUIRE_SETTERS_FOR_GETTERS;
        public static final Feature SORT_PROPERTIES_ALPHABETICALLY;
        public static final Feature USE_ANNOTATIONS;
        public static final Feature USE_STATIC_TYPING;
        public static final Feature WRAP_EXCEPTIONS;
        public static final Feature WRAP_ROOT_VALUE;
        public static final Feature WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS;
        public static final Feature WRITE_DATES_AS_TIMESTAMPS;
        public static final Feature WRITE_DATE_KEYS_AS_TIMESTAMPS;
        public static final Feature WRITE_EMPTY_JSON_ARRAYS;
        public static final Feature WRITE_ENUMS_USING_INDEX;
        public static final Feature WRITE_ENUMS_USING_TO_STRING;
        public static final Feature WRITE_NULL_MAP_VALUES;
        public static final Feature WRITE_NULL_PROPERTIES;
        final boolean _defaultState;

        public static Feature valueOf(String s)
        {
            return (Feature)Enum.valueOf(org/codehaus/jackson/map/SerializationConfig$Feature, s);
        }

        public static Feature[] values()
        {
            return (Feature[])$VALUES.clone();
        }

        public boolean enabledByDefault()
        {
            return _defaultState;
        }

        public int getMask()
        {
            return 1 << ordinal();
        }

        static 
        {
            USE_ANNOTATIONS = new Feature("USE_ANNOTATIONS", 0, true);
            AUTO_DETECT_GETTERS = new Feature("AUTO_DETECT_GETTERS", 1, true);
            AUTO_DETECT_IS_GETTERS = new Feature("AUTO_DETECT_IS_GETTERS", 2, true);
            AUTO_DETECT_FIELDS = new Feature("AUTO_DETECT_FIELDS", 3, true);
            CAN_OVERRIDE_ACCESS_MODIFIERS = new Feature("CAN_OVERRIDE_ACCESS_MODIFIERS", 4, true);
            REQUIRE_SETTERS_FOR_GETTERS = new Feature("REQUIRE_SETTERS_FOR_GETTERS", 5, false);
            WRITE_NULL_PROPERTIES = new Feature("WRITE_NULL_PROPERTIES", 6, true);
            USE_STATIC_TYPING = new Feature("USE_STATIC_TYPING", 7, false);
            DEFAULT_VIEW_INCLUSION = new Feature("DEFAULT_VIEW_INCLUSION", 8, true);
            WRAP_ROOT_VALUE = new Feature("WRAP_ROOT_VALUE", 9, false);
            INDENT_OUTPUT = new Feature("INDENT_OUTPUT", 10, false);
            SORT_PROPERTIES_ALPHABETICALLY = new Feature("SORT_PROPERTIES_ALPHABETICALLY", 11, false);
            FAIL_ON_EMPTY_BEANS = new Feature("FAIL_ON_EMPTY_BEANS", 12, true);
            WRAP_EXCEPTIONS = new Feature("WRAP_EXCEPTIONS", 13, true);
            CLOSE_CLOSEABLE = new Feature("CLOSE_CLOSEABLE", 14, false);
            FLUSH_AFTER_WRITE_VALUE = new Feature("FLUSH_AFTER_WRITE_VALUE", 15, true);
            WRITE_DATES_AS_TIMESTAMPS = new Feature("WRITE_DATES_AS_TIMESTAMPS", 16, true);
            WRITE_DATE_KEYS_AS_TIMESTAMPS = new Feature("WRITE_DATE_KEYS_AS_TIMESTAMPS", 17, false);
            WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS = new Feature("WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS", 18, false);
            WRITE_ENUMS_USING_TO_STRING = new Feature("WRITE_ENUMS_USING_TO_STRING", 19, false);
            WRITE_ENUMS_USING_INDEX = new Feature("WRITE_ENUMS_USING_INDEX", 20, false);
            WRITE_NULL_MAP_VALUES = new Feature("WRITE_NULL_MAP_VALUES", 21, true);
            WRITE_EMPTY_JSON_ARRAYS = new Feature("WRITE_EMPTY_JSON_ARRAYS", 22, true);
            $VALUES = (new Feature[] {
                USE_ANNOTATIONS, AUTO_DETECT_GETTERS, AUTO_DETECT_IS_GETTERS, AUTO_DETECT_FIELDS, CAN_OVERRIDE_ACCESS_MODIFIERS, REQUIRE_SETTERS_FOR_GETTERS, WRITE_NULL_PROPERTIES, USE_STATIC_TYPING, DEFAULT_VIEW_INCLUSION, WRAP_ROOT_VALUE, 
                INDENT_OUTPUT, SORT_PROPERTIES_ALPHABETICALLY, FAIL_ON_EMPTY_BEANS, WRAP_EXCEPTIONS, CLOSE_CLOSEABLE, FLUSH_AFTER_WRITE_VALUE, WRITE_DATES_AS_TIMESTAMPS, WRITE_DATE_KEYS_AS_TIMESTAMPS, WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS, WRITE_ENUMS_USING_TO_STRING, 
                WRITE_ENUMS_USING_INDEX, WRITE_NULL_MAP_VALUES, WRITE_EMPTY_JSON_ARRAYS
            });
        }

        private Feature(String s, int i, boolean flag)
        {
            super(s, i);
            _defaultState = flag;
        }
    }


    protected FilterProvider _filterProvider;
    protected org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion _serializationInclusion;
    protected Class _serializationView;

    public SerializationConfig(ClassIntrospector classintrospector, AnnotationIntrospector annotationintrospector, VisibilityChecker visibilitychecker, SubtypeResolver subtyperesolver, PropertyNamingStrategy propertynamingstrategy, TypeFactory typefactory, HandlerInstantiator handlerinstantiator)
    {
        super(classintrospector, annotationintrospector, visibilitychecker, subtyperesolver, propertynamingstrategy, typefactory, handlerinstantiator, collectFeatureDefaults(org/codehaus/jackson/map/SerializationConfig$Feature));
        _serializationInclusion = null;
        _filterProvider = null;
    }

    protected SerializationConfig(SerializationConfig serializationconfig, int i)
    {
        super(serializationconfig, i);
        _serializationInclusion = null;
        _serializationInclusion = serializationconfig._serializationInclusion;
        _serializationView = serializationconfig._serializationView;
        _filterProvider = serializationconfig._filterProvider;
    }

    protected SerializationConfig(SerializationConfig serializationconfig, HashMap hashmap, SubtypeResolver subtyperesolver)
    {
        this(serializationconfig, serializationconfig._base);
        _mixInAnnotations = hashmap;
        _subtypeResolver = subtyperesolver;
    }

    protected SerializationConfig(SerializationConfig serializationconfig, MapperConfig.Base base)
    {
        super(serializationconfig, base, serializationconfig._subtypeResolver);
        _serializationInclusion = null;
        _serializationInclusion = serializationconfig._serializationInclusion;
        _serializationView = serializationconfig._serializationView;
        _filterProvider = serializationconfig._filterProvider;
    }

    public boolean canOverrideAccessModifiers()
    {
        return isEnabled(Feature.CAN_OVERRIDE_ACCESS_MODIFIERS);
    }

    public SerializationConfig createUnshared(SubtypeResolver subtyperesolver)
    {
        HashMap hashmap = _mixInAnnotations;
        _mixInAnnotationsShared = true;
        return new SerializationConfig(this, hashmap, subtyperesolver);
    }

    public AnnotationIntrospector getAnnotationIntrospector()
    {
        if (isEnabled(Feature.USE_ANNOTATIONS))
        {
            return super.getAnnotationIntrospector();
        } else
        {
            return AnnotationIntrospector.nopInstance();
        }
    }

    public VisibilityChecker getDefaultVisibilityChecker()
    {
        VisibilityChecker visibilitychecker1 = super.getDefaultVisibilityChecker();
        VisibilityChecker visibilitychecker = visibilitychecker1;
        if (!isEnabled(Feature.AUTO_DETECT_GETTERS))
        {
            visibilitychecker = visibilitychecker1.withGetterVisibility(org.codehaus.jackson.annotate.JsonAutoDetect.Visibility.NONE);
        }
        visibilitychecker1 = visibilitychecker;
        if (!isEnabled(Feature.AUTO_DETECT_IS_GETTERS))
        {
            visibilitychecker1 = visibilitychecker.withIsGetterVisibility(org.codehaus.jackson.annotate.JsonAutoDetect.Visibility.NONE);
        }
        visibilitychecker = visibilitychecker1;
        if (!isEnabled(Feature.AUTO_DETECT_FIELDS))
        {
            visibilitychecker = visibilitychecker1.withFieldVisibility(org.codehaus.jackson.annotate.JsonAutoDetect.Visibility.NONE);
        }
        return visibilitychecker;
    }

    public FilterProvider getFilterProvider()
    {
        return _filterProvider;
    }

    public org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion getSerializationInclusion()
    {
        if (_serializationInclusion != null)
        {
            return _serializationInclusion;
        }
        if (isEnabled(Feature.WRITE_NULL_PROPERTIES))
        {
            return org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.ALWAYS;
        } else
        {
            return org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL;
        }
    }

    public Class getSerializationView()
    {
        return _serializationView;
    }

    public BeanDescription introspect(JavaType javatype)
    {
        return getClassIntrospector().forSerialization(this, javatype, this);
    }

    public BeanDescription introspectClassAnnotations(JavaType javatype)
    {
        return getClassIntrospector().forClassAnnotations(this, javatype, this);
    }

    public boolean isAnnotationProcessingEnabled()
    {
        return isEnabled(Feature.USE_ANNOTATIONS);
    }

    public volatile boolean isEnabled(MapperConfig.ConfigFeature configfeature)
    {
        return super.isEnabled(configfeature);
    }

    public JsonSerializer serializerInstance(Annotated annotated, Class class1)
    {
        HandlerInstantiator handlerinstantiator = getHandlerInstantiator();
        if (handlerinstantiator != null)
        {
            annotated = handlerinstantiator.serializerInstance(this, annotated, class1);
            if (annotated != null)
            {
                return annotated;
            }
        }
        return (JsonSerializer)ClassUtil.createInstance(class1, canOverrideAccessModifiers());
    }

    public boolean shouldSortPropertiesAlphabetically()
    {
        return isEnabled(Feature.SORT_PROPERTIES_ALPHABETICALLY);
    }

    public String toString()
    {
        return (new StringBuilder()).append("[SerializationConfig: flags=0x").append(Integer.toHexString(_featureFlags)).append("]").toString();
    }

    public transient SerializationConfig with(Feature afeature[])
    {
        int j = _featureFlags;
        int k = afeature.length;
        for (int i = 0; i < k; i++)
        {
            j |= afeature[i].getMask();
        }

        return new SerializationConfig(this, j);
    }

    public SerializationConfig withDateFormat(DateFormat dateformat)
    {
        SerializationConfig serializationconfig = new SerializationConfig(this, _base.withDateFormat(dateformat));
        if (dateformat == null)
        {
            return serializationconfig.with(new Feature[] {
                Feature.WRITE_DATES_AS_TIMESTAMPS
            });
        } else
        {
            return serializationconfig.without(new Feature[] {
                Feature.WRITE_DATES_AS_TIMESTAMPS
            });
        }
    }

    public SerializationConfig withTypeResolverBuilder(TypeResolverBuilder typeresolverbuilder)
    {
        return new SerializationConfig(this, _base.withTypeResolverBuilder(typeresolverbuilder));
    }

    public transient SerializationConfig without(Feature afeature[])
    {
        int j = _featureFlags;
        int k = afeature.length;
        for (int i = 0; i < k; i++)
        {
            j &= ~afeature[i].getMask();
        }

        return new SerializationConfig(this, j);
    }
}
