// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.deser.impl;

import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.map.JsonDeserializer;
import com.flurry.org.codehaus.jackson.map.deser.SettableBeanProperty;
import com.flurry.org.codehaus.jackson.map.deser.ValueInstantiator;
import com.flurry.org.codehaus.jackson.map.util.ClassUtil;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.deser.impl:
//            PropertyValueBuffer, PropertyValue

public final class PropertyBasedCreator
{

    protected Object _defaultValues[];
    protected final HashMap _properties = new HashMap();
    protected final SettableBeanProperty _propertiesWithInjectables[];
    protected final ValueInstantiator _valueInstantiator;

    public PropertyBasedCreator(ValueInstantiator valueinstantiator)
    {
        _valueInstantiator = valueinstantiator;
        Object obj = null;
        SettableBeanProperty asettablebeanproperty[] = valueinstantiator.getFromObjectArguments();
        valueinstantiator = null;
        int i = 0;
        for (int j = asettablebeanproperty.length; i < j;)
        {
            SettableBeanProperty settablebeanproperty = asettablebeanproperty[i];
            _properties.put(settablebeanproperty.getName(), settablebeanproperty);
            Object aobj[] = ((Object []) (obj));
            if (settablebeanproperty.getType().isPrimitive())
            {
                aobj = ((Object []) (obj));
                if (obj == null)
                {
                    aobj = new Object[j];
                }
                aobj[i] = ClassUtil.defaultValue(settablebeanproperty.getType().getRawClass());
            }
            Object obj1 = valueinstantiator;
            if (settablebeanproperty.getInjectableValueId() != null)
            {
                obj = valueinstantiator;
                if (valueinstantiator == null)
                {
                    obj = new SettableBeanProperty[j];
                }
                obj[i] = settablebeanproperty;
                obj1 = obj;
            }
            i++;
            obj = ((Object) (aobj));
            valueinstantiator = ((ValueInstantiator) (obj1));
        }

        _defaultValues = ((Object []) (obj));
        _propertiesWithInjectables = valueinstantiator;
    }

    public void assignDeserializer(SettableBeanProperty settablebeanproperty, JsonDeserializer jsondeserializer)
    {
        settablebeanproperty = settablebeanproperty.withValueDeserializer(jsondeserializer);
        _properties.put(settablebeanproperty.getName(), settablebeanproperty);
        jsondeserializer = ((JsonDeserializer) (jsondeserializer.getNullValue()));
        if (jsondeserializer != null)
        {
            if (_defaultValues == null)
            {
                _defaultValues = new Object[_properties.size()];
            }
            _defaultValues[settablebeanproperty.getPropertyIndex()] = jsondeserializer;
        }
    }

    public Object build(PropertyValueBuffer propertyvaluebuffer)
        throws IOException
    {
        Object obj = _valueInstantiator.createFromObjectWith(propertyvaluebuffer.getParameters(_defaultValues));
        for (propertyvaluebuffer = propertyvaluebuffer.buffered(); propertyvaluebuffer != null; propertyvaluebuffer = ((PropertyValue) (propertyvaluebuffer)).next)
        {
            propertyvaluebuffer.assign(obj);
        }

        return obj;
    }

    public SettableBeanProperty findCreatorProperty(String s)
    {
        return (SettableBeanProperty)_properties.get(s);
    }

    public Collection getCreatorProperties()
    {
        return _properties.values();
    }

    public PropertyValueBuffer startBuilding(JsonParser jsonparser, DeserializationContext deserializationcontext)
    {
        jsonparser = new PropertyValueBuffer(jsonparser, deserializationcontext, _properties.size());
        if (_propertiesWithInjectables != null)
        {
            jsonparser.inject(_propertiesWithInjectables);
        }
        return jsonparser;
    }
}
