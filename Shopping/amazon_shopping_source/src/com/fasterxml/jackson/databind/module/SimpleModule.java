// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.module;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

// Referenced classes of package com.fasterxml.jackson.databind.module:
//            SimpleAbstractTypeResolver, SimpleDeserializers, SimpleKeyDeserializers, SimpleSerializers, 
//            SimpleValueInstantiators

public class SimpleModule extends Module
    implements Serializable
{

    protected SimpleAbstractTypeResolver _abstractTypes;
    protected SimpleDeserializers _deserializers;
    protected SimpleKeyDeserializers _keyDeserializers;
    protected SimpleSerializers _keySerializers;
    protected HashMap _mixins;
    protected final String _name;
    protected SimpleSerializers _serializers;
    protected LinkedHashSet _subtypes;
    protected SimpleValueInstantiators _valueInstantiators;
    protected final Version _version;

    public SimpleModule()
    {
        _serializers = null;
        _deserializers = null;
        _keySerializers = null;
        _keyDeserializers = null;
        _abstractTypes = null;
        _valueInstantiators = null;
        _mixins = null;
        _subtypes = null;
        _name = (new StringBuilder()).append("SimpleModule-").append(System.identityHashCode(this)).toString();
        _version = Version.unknownVersion();
    }

    public SimpleModule(String s, Version version1)
    {
        _serializers = null;
        _deserializers = null;
        _keySerializers = null;
        _keyDeserializers = null;
        _abstractTypes = null;
        _valueInstantiators = null;
        _mixins = null;
        _subtypes = null;
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

    public String getModuleName()
    {
        return _name;
    }

    public void setupModule(com.fasterxml.jackson.databind.Module.SetupContext setupcontext)
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
        if (_subtypes != null && _subtypes.size() > 0)
        {
            setupcontext.registerSubtypes((NamedType[])_subtypes.toArray(new NamedType[_subtypes.size()]));
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
