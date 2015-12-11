// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map.deser.impl;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.deser.SettableBeanProperty;
import org.codehaus.jackson.map.deser.ValueInstantiator;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;

// Referenced classes of package org.codehaus.jackson.map.deser.impl:
//            PropertyValueBuffer, PropertyValue

public final class PropertyBasedCreator
{

    protected final Object _defaultValues[];
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
