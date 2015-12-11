// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.MapperConfigBase;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import java.io.Serializable;
import java.util.Map;

// Referenced classes of package com.fasterxml.jackson.databind:
//            SerializationFeature, MapperFeature, AnnotationIntrospector, JavaType, 
//            BeanDescription

public final class SerializationConfig extends MapperConfigBase
    implements Serializable
{

    protected final FilterProvider _filterProvider;
    protected final int _serFeatures;
    protected com.fasterxml.jackson.annotation.JsonInclude.Include _serializationInclusion;

    private SerializationConfig(SerializationConfig serializationconfig, int i, int j)
    {
        super(serializationconfig, i);
        _serializationInclusion = null;
        _serFeatures = j;
        _serializationInclusion = serializationconfig._serializationInclusion;
        _filterProvider = serializationconfig._filterProvider;
    }

    private SerializationConfig(SerializationConfig serializationconfig, BaseSettings basesettings)
    {
        super(serializationconfig, basesettings);
        _serializationInclusion = null;
        _serFeatures = serializationconfig._serFeatures;
        _serializationInclusion = serializationconfig._serializationInclusion;
        _filterProvider = serializationconfig._filterProvider;
    }

    public SerializationConfig(BaseSettings basesettings, SubtypeResolver subtyperesolver, Map map)
    {
        super(basesettings, subtyperesolver, map);
        _serializationInclusion = null;
        _serFeatures = collectFeatureDefaults(com/fasterxml/jackson/databind/SerializationFeature);
        _filterProvider = null;
    }

    private final SerializationConfig _withBase(BaseSettings basesettings)
    {
        if (_base == basesettings)
        {
            return this;
        } else
        {
            return new SerializationConfig(this, basesettings);
        }
    }

    public AnnotationIntrospector getAnnotationIntrospector()
    {
        if (isEnabled(MapperFeature.USE_ANNOTATIONS))
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
        if (!isEnabled(MapperFeature.AUTO_DETECT_GETTERS))
        {
            visibilitychecker = visibilitychecker1.withGetterVisibility(com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE);
        }
        visibilitychecker1 = visibilitychecker;
        if (!isEnabled(MapperFeature.AUTO_DETECT_IS_GETTERS))
        {
            visibilitychecker1 = visibilitychecker.withIsGetterVisibility(com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE);
        }
        visibilitychecker = visibilitychecker1;
        if (!isEnabled(MapperFeature.AUTO_DETECT_FIELDS))
        {
            visibilitychecker = visibilitychecker1.withFieldVisibility(com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE);
        }
        return visibilitychecker;
    }

    public FilterProvider getFilterProvider()
    {
        return _filterProvider;
    }

    public com.fasterxml.jackson.annotation.JsonInclude.Include getSerializationInclusion()
    {
        if (_serializationInclusion != null)
        {
            return _serializationInclusion;
        } else
        {
            return com.fasterxml.jackson.annotation.JsonInclude.Include.ALWAYS;
        }
    }

    public BeanDescription introspect(JavaType javatype)
    {
        return getClassIntrospector().forSerialization(this, javatype, this);
    }

    public BeanDescription introspectClassAnnotations(JavaType javatype)
    {
        return getClassIntrospector().forClassAnnotations(this, javatype, this);
    }

    public final boolean isEnabled(SerializationFeature serializationfeature)
    {
        return (_serFeatures & serializationfeature.getMask()) != 0;
    }

    public String toString()
    {
        return (new StringBuilder()).append("[SerializationConfig: flags=0x").append(Integer.toHexString(_serFeatures)).append("]").toString();
    }

    public SerializationConfig with(VisibilityChecker visibilitychecker)
    {
        return _withBase(_base.withVisibilityChecker(visibilitychecker));
    }

    public SerializationConfig without(SerializationFeature serializationfeature)
    {
        int i = _serFeatures & ~serializationfeature.getMask();
        if (i == _serFeatures)
        {
            return this;
        } else
        {
            return new SerializationConfig(this, _mapperFeatures, i);
        }
    }
}
