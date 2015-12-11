// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map.module;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.Module;

// Referenced classes of package org.codehaus.jackson.map.module:
//            SimpleDeserializers, SimpleAbstractTypeResolver, SimpleKeyDeserializers, SimpleSerializers, 
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

    public SimpleModule addDeserializer(Class class1, JsonDeserializer jsondeserializer)
    {
        if (_deserializers == null)
        {
            _deserializers = new SimpleDeserializers();
        }
        _deserializers.addDeserializer(class1, jsondeserializer);
        return this;
    }

    public String getModuleName()
    {
        return _name;
    }

    public void setupModule(org.codehaus.jackson.map.Module.SetupContext setupcontext)
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
