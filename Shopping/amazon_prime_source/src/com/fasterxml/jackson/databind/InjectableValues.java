// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.fasterxml.jackson.databind:
//            DeserializationContext, BeanProperty

public abstract class InjectableValues
{
    public static class Std extends InjectableValues
        implements Serializable
    {

        private static final long serialVersionUID = 1L;
        protected final Map _values;

        public Std addValue(Class class1, Object obj)
        {
            _values.put(class1.getName(), obj);
            return this;
        }

        public Std addValue(String s, Object obj)
        {
            _values.put(s, obj);
            return this;
        }

        public Object findInjectableValue(Object obj, DeserializationContext deserializationcontext, BeanProperty beanproperty, Object obj1)
        {
            if (!(obj instanceof String))
            {
                if (obj == null)
                {
                    obj = "[null]";
                } else
                {
                    obj = obj.getClass().getName();
                }
                throw new IllegalArgumentException((new StringBuilder()).append("Unrecognized inject value id type (").append(((String) (obj))).append("), expecting String").toString());
            }
            obj = (String)obj;
            deserializationcontext = ((DeserializationContext) (_values.get(obj)));
            if (deserializationcontext == null && !_values.containsKey(obj))
            {
                throw new IllegalArgumentException((new StringBuilder()).append("No injectable id with value '").append(((String) (obj))).append("' found (for property '").append(beanproperty.getName()).append("')").toString());
            } else
            {
                return deserializationcontext;
            }
        }

        public Std()
        {
            this(((Map) (new HashMap())));
        }

        public Std(Map map)
        {
            _values = map;
        }
    }


    public InjectableValues()
    {
    }

    public abstract Object findInjectableValue(Object obj, DeserializationContext deserializationcontext, BeanProperty beanproperty, Object obj1);
}
