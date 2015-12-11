// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.MapperConfigBase;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.util.LinkedNode;
import java.io.Serializable;
import java.util.Map;

// Referenced classes of package com.fasterxml.jackson.databind:
//            DeserializationFeature, MapperFeature, AnnotationIntrospector, JavaType, 
//            BeanDescription

public final class DeserializationConfig extends MapperConfigBase
    implements Serializable
{

    protected final int _deserFeatures;
    protected final JsonNodeFactory _nodeFactory;
    protected final LinkedNode _problemHandlers;

    private DeserializationConfig(DeserializationConfig deserializationconfig, int i, int j)
    {
        super(deserializationconfig, i);
        _deserFeatures = j;
        _nodeFactory = deserializationconfig._nodeFactory;
        _problemHandlers = deserializationconfig._problemHandlers;
    }

    private DeserializationConfig(DeserializationConfig deserializationconfig, BaseSettings basesettings)
    {
        super(deserializationconfig, basesettings);
        _deserFeatures = deserializationconfig._deserFeatures;
        _nodeFactory = deserializationconfig._nodeFactory;
        _problemHandlers = deserializationconfig._problemHandlers;
    }

    public DeserializationConfig(BaseSettings basesettings, SubtypeResolver subtyperesolver, Map map)
    {
        super(basesettings, subtyperesolver, map);
        _deserFeatures = collectFeatureDefaults(com/fasterxml/jackson/databind/DeserializationFeature);
        _nodeFactory = JsonNodeFactory.instance;
        _problemHandlers = null;
    }

    private final DeserializationConfig _withBase(BaseSettings basesettings)
    {
        if (_base == basesettings)
        {
            return this;
        } else
        {
            return new DeserializationConfig(this, basesettings);
        }
    }

    public AnnotationIntrospector getAnnotationIntrospector()
    {
        if (isEnabled(MapperFeature.USE_ANNOTATIONS))
        {
            return super.getAnnotationIntrospector();
        } else
        {
            return NopAnnotationIntrospector.instance;
        }
    }

    public VisibilityChecker getDefaultVisibilityChecker()
    {
        VisibilityChecker visibilitychecker1 = super.getDefaultVisibilityChecker();
        VisibilityChecker visibilitychecker = visibilitychecker1;
        if (!isEnabled(MapperFeature.AUTO_DETECT_SETTERS))
        {
            visibilitychecker = visibilitychecker1.withSetterVisibility(com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE);
        }
        visibilitychecker1 = visibilitychecker;
        if (!isEnabled(MapperFeature.AUTO_DETECT_CREATORS))
        {
            visibilitychecker1 = visibilitychecker.withCreatorVisibility(com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE);
        }
        visibilitychecker = visibilitychecker1;
        if (!isEnabled(MapperFeature.AUTO_DETECT_FIELDS))
        {
            visibilitychecker = visibilitychecker1.withFieldVisibility(com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE);
        }
        return visibilitychecker;
    }

    public final int getDeserializationFeatures()
    {
        return _deserFeatures;
    }

    public final JsonNodeFactory getNodeFactory()
    {
        return _nodeFactory;
    }

    public LinkedNode getProblemHandlers()
    {
        return _problemHandlers;
    }

    public BeanDescription introspect(JavaType javatype)
    {
        return getClassIntrospector().forDeserialization(this, javatype, this);
    }

    public BeanDescription introspectClassAnnotations(JavaType javatype)
    {
        return getClassIntrospector().forClassAnnotations(this, javatype, this);
    }

    public BeanDescription introspectForBuilder(JavaType javatype)
    {
        return getClassIntrospector().forDeserializationWithBuilder(this, javatype, this);
    }

    public BeanDescription introspectForCreation(JavaType javatype)
    {
        return getClassIntrospector().forCreation(this, javatype, this);
    }

    public final boolean isEnabled(DeserializationFeature deserializationfeature)
    {
        return (_deserFeatures & deserializationfeature.getMask()) != 0;
    }

    public boolean useRootWrapping()
    {
        if (_rootName != null)
        {
            return _rootName.length() > 0;
        } else
        {
            return isEnabled(DeserializationFeature.UNWRAP_ROOT_VALUE);
        }
    }

    public DeserializationConfig with(VisibilityChecker visibilitychecker)
    {
        return _withBase(_base.withVisibilityChecker(visibilitychecker));
    }

    public DeserializationConfig without(DeserializationFeature deserializationfeature)
    {
        int i = _deserFeatures & ~deserializationfeature.getMask();
        if (i == _deserFeatures)
        {
            return this;
        } else
        {
            return new DeserializationConfig(this, _mapperFeatures, i);
        }
    }
}
