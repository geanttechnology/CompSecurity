// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.module;

import com.flurry.org.codehaus.jackson.Version;
import com.flurry.org.codehaus.jackson.map.JsonDeserializer;
import com.flurry.org.codehaus.jackson.map.JsonSerializer;
import com.flurry.org.codehaus.jackson.map.KeyDeserializer;
import com.flurry.org.codehaus.jackson.map.Module;
import com.flurry.org.codehaus.jackson.map.deser.ValueInstantiator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.module:
//            SimpleAbstractTypeResolver, SimpleDeserializers, SimpleKeyDeserializers, SimpleSerializers, 
//            SimpleValueInstantiators

public class SimpleModule extends Module
{

    protected SimpleAbstractTypeResolver _abstractTypes;
    protected SimpleDeserializers _deserializers;
    protected SimpleKeyDeserializers _keyDeserializers;
    protected SimpleSerializers _keySerializers;
    protected HashMap _mixins;
    protected final String _name;
    protected SimpleSerializers _serializers;
    protected SimpleValueInstantiators _valueInstantiators;
    protected final Version _version;

    public SimpleModule(String s, Version version1)
    {
        _serializers = null;
        _deserializers = null;
        _keySerializers = null;
        _keyDeserializers = null;
        _abstractTypes = null;
        _valueInstantiators = null;
        _mixins = null;
        _name = s;
        _version = version1;
    }

    public SimpleModule addAbstractTypeMapping(Class class1, Class class2)
    {
        if (_abstractTypes == null)
        {
            _abstractTypes = new SimpleAbstractTypeResolver();
        }
        _abstractTypes = _abstractTypes.addMapping(class1, class2);
        return this;
    }

    public SimpleModule addDeserializer(Class class1, JsonDeserializer jsondeserializer)
    {
        if (_deserializers == null)
        {
            _deserializers = new SimpleDeserializers();
        }
        _deserializers.addDeserializer(class1, jsondeserializer);
        return this;
    }

    public SimpleModule addKeyDeserializer(Class class1, KeyDeserializer keydeserializer)
    {
        if (_keyDeserializers == null)
        {
            _keyDeserializers = new SimpleKeyDeserializers();
        }
        _keyDeserializers.addDeserializer(class1, keydeserializer);
        return this;
    }

    public SimpleModule addKeySerializer(Class class1, JsonSerializer jsonserializer)
    {
        if (_keySerializers == null)
        {
            _keySerializers = new SimpleSerializers();
        }
        _keySerializers.addSerializer(class1, jsonserializer);
        return this;
    }

    public SimpleModule addSerializer(JsonSerializer jsonserializer)
    {
        if (_serializers == null)
        {
            _serializers = new SimpleSerializers();
        }
        _serializers.addSerializer(jsonserializer);
        return this;
    }

    public SimpleModule addSerializer(Class class1, JsonSerializer jsonserializer)
    {
        if (_serializers == null)
        {
            _serializers = new SimpleSerializers();
        }
        _serializers.addSerializer(class1, jsonserializer);
        return this;
    }

    public SimpleModule addValueInstantiator(Class class1, ValueInstantiator valueinstantiator)
    {
        if (_valueInstantiators == null)
        {
            _valueInstantiators = new SimpleValueInstantiators();
        }
        _valueInstantiators = _valueInstantiators.addValueInstantiator(class1, valueinstantiator);
        return this;
    }

    public String getModuleName()
    {
        return _name;
    }

    public void setAbstractTypes(SimpleAbstractTypeResolver simpleabstracttyperesolver)
    {
        _abstractTypes = simpleabstracttyperesolver;
    }

    public void setDeserializers(SimpleDeserializers simpledeserializers)
    {
        _deserializers = simpledeserializers;
    }

    public void setKeyDeserializers(SimpleKeyDeserializers simplekeydeserializers)
    {
        _keyDeserializers = simplekeydeserializers;
    }

    public void setKeySerializers(SimpleSerializers simpleserializers)
    {
        _keySerializers = simpleserializers;
    }

    public SimpleModule setMixInAnnotation(Class class1, Class class2)
    {
        if (_mixins == null)
        {
            _mixins = new HashMap();
        }
        _mixins.put(class1, class2);
        return this;
    }

    public void setSerializers(SimpleSerializers simpleserializers)
    {
        _serializers = simpleserializers;
    }

    public void setValueInstantiators(SimpleValueInstantiators simplevalueinstantiators)
    {
        _valueInstantiators = simplevalueinstantiators;
    }

    public void setupModule(com.flurry.org.codehaus.jackson.map.Module.SetupContext setupcontext)
    {
        if (_serializers != null)
        {
            setupcontext.addSerializers(_serializers);
        }
        if (_deserializers != null)
        {
            setupcontext.addDeserializers(_deserializers);
        }
        if (_keySerializers != null)
        {
            setupcontext.addKeySerializers(_keySerializers);
        }
        if (_keyDeserializers != null)
        {
            setupcontext.addKeyDeserializers(_keyDeserializers);
        }
        if (_abstractTypes != null)
        {
            setupcontext.addAbstractTypeResolver(_abstractTypes);
        }
        if (_valueInstantiators != null)
        {
            setupcontext.addValueInstantiators(_valueInstantiators);
        }
        if (_mixins != null)
        {
            java.util.Map.Entry entry;
            for (Iterator iterator = _mixins.entrySet().iterator(); iterator.hasNext(); setupcontext.setMixInAnnotations((Class)entry.getKey(), (Class)entry.getValue()))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

        }
    }

    public Version version()
    {
        return _version;
    }
}
