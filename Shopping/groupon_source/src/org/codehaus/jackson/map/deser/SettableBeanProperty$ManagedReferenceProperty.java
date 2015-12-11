// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.util.Annotations;

// Referenced classes of package org.codehaus.jackson.map.deser:
//            SettableBeanProperty

public static final class _backProperty extends SettableBeanProperty
{

    protected final SettableBeanProperty _backProperty;
    protected final boolean _isContainer;
    protected final SettableBeanProperty _managedProperty;
    protected final String _referenceName;

    public void deserializeAndSet(JsonParser jsonparser, DeserializationContext deserializationcontext, Object obj)
        throws IOException, JsonProcessingException
    {
        set(obj, _managedProperty.deserialize(jsonparser, deserializationcontext));
    }

    public AnnotatedMember getMember()
    {
        return _managedProperty.getMember();
    }

    public final void set(Object obj, Object obj1)
        throws IOException
    {
        _managedProperty.set(obj, obj1);
        if (obj1 != null)
        {
            if (_isContainer)
            {
                if (obj1 instanceof Object[])
                {
                    obj1 = ((Object) ((Object[])(Object[])obj1));
                    int j = obj1.length;
                    for (int i = 0; i < j; i++)
                    {
                        Object obj2 = obj1[i];
                        if (obj2 != null)
                        {
                            _backProperty.set(obj2, obj);
                        }
                    }

                } else
                if (obj1 instanceof Collection)
                {
                    obj1 = ((Collection)obj1).iterator();
                    do
                    {
                        if (!((Iterator) (obj1)).hasNext())
                        {
                            break;
                        }
                        Object obj3 = ((Iterator) (obj1)).next();
                        if (obj3 != null)
                        {
                            _backProperty.set(obj3, obj);
                        }
                    } while (true);
                } else
                if (obj1 instanceof Map)
                {
                    obj1 = ((Map)obj1).values().iterator();
                    do
                    {
                        if (!((Iterator) (obj1)).hasNext())
                        {
                            break;
                        }
                        Object obj4 = ((Iterator) (obj1)).next();
                        if (obj4 != null)
                        {
                            _backProperty.set(obj4, obj);
                        }
                    } while (true);
                } else
                {
                    throw new IllegalStateException((new StringBuilder()).append("Unsupported container type (").append(obj1.getClass().getName()).append(") when resolving reference '").append(_referenceName).append("'").toString());
                }
            } else
            {
                _backProperty.set(obj1, obj);
            }
        }
    }

    public _backProperty withValueDeserializer(JsonDeserializer jsondeserializer)
    {
        return new <init>(this, jsondeserializer);
    }

    public volatile SettableBeanProperty withValueDeserializer(JsonDeserializer jsondeserializer)
    {
        return withValueDeserializer(jsondeserializer);
    }

    public (String s, SettableBeanProperty settablebeanproperty, SettableBeanProperty settablebeanproperty1, Annotations annotations, boolean flag)
    {
        super(settablebeanproperty.getName(), settablebeanproperty.getType(), settablebeanproperty._valueTypeDeserializer, annotations);
        _referenceName = s;
        _managedProperty = settablebeanproperty;
        _backProperty = settablebeanproperty1;
        _isContainer = flag;
    }

    protected _isContainer(_isContainer _piscontainer, JsonDeserializer jsondeserializer)
    {
        super(_piscontainer, jsondeserializer);
        _referenceName = _piscontainer._referenceName;
        _isContainer = _piscontainer._isContainer;
        _managedProperty = _piscontainer._managedProperty;
        _backProperty = _piscontainer._backProperty;
    }
}
