// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.jsontype.impl;

import com.flurry.org.codehaus.jackson.map.BeanProperty;
import com.flurry.org.codehaus.jackson.map.DeserializationConfig;
import com.flurry.org.codehaus.jackson.map.MapperConfig;
import com.flurry.org.codehaus.jackson.map.SerializationConfig;
import com.flurry.org.codehaus.jackson.map.TypeDeserializer;
import com.flurry.org.codehaus.jackson.map.TypeSerializer;
import com.flurry.org.codehaus.jackson.map.jsontype.TypeIdResolver;
import com.flurry.org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.util.Collection;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.jsontype.impl:
//            AsArrayTypeDeserializer, AsPropertyTypeDeserializer, AsWrapperTypeDeserializer, AsExternalTypeDeserializer, 
//            AsArrayTypeSerializer, AsPropertyTypeSerializer, AsWrapperTypeSerializer, AsExternalTypeSerializer, 
//            ClassNameIdResolver, MinimalClassNameIdResolver, TypeNameIdResolver

public class StdTypeResolverBuilder
    implements TypeResolverBuilder
{

    protected TypeIdResolver _customIdResolver;
    protected Class _defaultImpl;
    protected com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.Id _idType;
    protected com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.As _includeAs;
    protected String _typeProperty;

    public StdTypeResolverBuilder()
    {
    }

    public static StdTypeResolverBuilder noTypeInfoBuilder()
    {
        return (new StdTypeResolverBuilder()).init(com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.Id.NONE, null);
    }

    public TypeDeserializer buildTypeDeserializer(DeserializationConfig deserializationconfig, JavaType javatype, Collection collection, BeanProperty beanproperty)
    {
        if (_idType == com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.Id.NONE)
        {
            return null;
        }
        deserializationconfig = idResolver(deserializationconfig, javatype, collection, false, true);
        static class _cls1
        {

            static final int $SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$As[];
            static final int $SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$Id[];

            static 
            {
                $SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$Id = new int[com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.Id.values().length];
                try
                {
                    $SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$Id[com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.Id.CLASS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$Id[com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.Id.MINIMAL_CLASS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$Id[com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.Id.NAME.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$Id[com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.Id.NONE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$Id[com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.Id.CUSTOM.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                $SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$As = new int[com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.As.values().length];
                try
                {
                    $SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$As[com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.As.WRAPPER_ARRAY.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$As[com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.As.PROPERTY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$As[com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.As.WRAPPER_OBJECT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$As[com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.As.EXTERNAL_PROPERTY.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.org.codehaus.jackson.annotate.JsonTypeInfo.As[_includeAs.ordinal()])
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Do not know how to construct standard type serializer for inclusion type: ").append(_includeAs).toString());

        case 1: // '\001'
            return new AsArrayTypeDeserializer(javatype, deserializationconfig, beanproperty, _defaultImpl);

        case 2: // '\002'
            return new AsPropertyTypeDeserializer(javatype, deserializationconfig, beanproperty, _defaultImpl, _typeProperty);

        case 3: // '\003'
            return new AsWrapperTypeDeserializer(javatype, deserializationconfig, beanproperty, _defaultImpl);

        case 4: // '\004'
            return new AsExternalTypeDeserializer(javatype, deserializationconfig, beanproperty, _defaultImpl, _typeProperty);
        }
    }

    public TypeSerializer buildTypeSerializer(SerializationConfig serializationconfig, JavaType javatype, Collection collection, BeanProperty beanproperty)
    {
        if (_idType == com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.Id.NONE)
        {
            return null;
        }
        serializationconfig = idResolver(serializationconfig, javatype, collection, true, false);
        switch (_cls1..SwitchMap.org.codehaus.jackson.annotate.JsonTypeInfo.As[_includeAs.ordinal()])
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Do not know how to construct standard type serializer for inclusion type: ").append(_includeAs).toString());

        case 1: // '\001'
            return new AsArrayTypeSerializer(serializationconfig, beanproperty);

        case 2: // '\002'
            return new AsPropertyTypeSerializer(serializationconfig, beanproperty, _typeProperty);

        case 3: // '\003'
            return new AsWrapperTypeSerializer(serializationconfig, beanproperty);

        case 4: // '\004'
            return new AsExternalTypeSerializer(serializationconfig, beanproperty, _typeProperty);
        }
    }

    public volatile TypeResolverBuilder defaultImpl(Class class1)
    {
        return defaultImpl(class1);
    }

    public StdTypeResolverBuilder defaultImpl(Class class1)
    {
        _defaultImpl = class1;
        return this;
    }

    public Class getDefaultImpl()
    {
        return _defaultImpl;
    }

    public String getTypeProperty()
    {
        return _typeProperty;
    }

    protected TypeIdResolver idResolver(MapperConfig mapperconfig, JavaType javatype, Collection collection, boolean flag, boolean flag1)
    {
        if (_customIdResolver != null)
        {
            return _customIdResolver;
        }
        if (_idType == null)
        {
            throw new IllegalStateException("Can not build, 'init()' not yet called");
        }
        switch (_cls1..SwitchMap.org.codehaus.jackson.annotate.JsonTypeInfo.Id[_idType.ordinal()])
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Do not know how to construct standard type id resolver for idType: ").append(_idType).toString());

        case 1: // '\001'
            return new ClassNameIdResolver(javatype, mapperconfig.getTypeFactory());

        case 2: // '\002'
            return new MinimalClassNameIdResolver(javatype, mapperconfig.getTypeFactory());

        case 3: // '\003'
            return TypeNameIdResolver.construct(mapperconfig, javatype, collection, flag, flag1);

        case 4: // '\004'
            return null;
        }
    }

    public volatile TypeResolverBuilder inclusion(com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.As as)
    {
        return inclusion(as);
    }

    public StdTypeResolverBuilder inclusion(com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.As as)
    {
        if (as == null)
        {
            throw new IllegalArgumentException("includeAs can not be null");
        } else
        {
            _includeAs = as;
            return this;
        }
    }

    public volatile TypeResolverBuilder init(com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.Id id, TypeIdResolver typeidresolver)
    {
        return init(id, typeidresolver);
    }

    public StdTypeResolverBuilder init(com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.Id id, TypeIdResolver typeidresolver)
    {
        if (id == null)
        {
            throw new IllegalArgumentException("idType can not be null");
        } else
        {
            _idType = id;
            _customIdResolver = typeidresolver;
            _typeProperty = id.getDefaultPropertyName();
            return this;
        }
    }

    public volatile TypeResolverBuilder typeProperty(String s)
    {
        return typeProperty(s);
    }

    public StdTypeResolverBuilder typeProperty(String s)
    {
        String s1;
label0:
        {
            if (s != null)
            {
                s1 = s;
                if (s.length() != 0)
                {
                    break label0;
                }
            }
            s1 = _idType.getDefaultPropertyName();
        }
        _typeProperty = s1;
        return this;
    }
}
