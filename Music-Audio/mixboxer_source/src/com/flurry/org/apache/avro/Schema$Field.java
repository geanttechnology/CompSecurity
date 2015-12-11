// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro;

import com.flurry.org.codehaus.jackson.JsonNode;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.flurry.org.apache.avro:
//            Schema

public static class order
{
    public static final class Order extends Enum
    {

        private static final Order $VALUES[];
        public static final Order ASCENDING;
        public static final Order DESCENDING;
        public static final Order IGNORE;
        private String name;

        public static Order valueOf(String s)
        {
            return (Order)Enum.valueOf(com/flurry/org/apache/avro/Schema$Field$Order, s);
        }

        public static Order[] values()
        {
            return (Order[])$VALUES.clone();
        }

        static 
        {
            ASCENDING = new Order("ASCENDING", 0);
            DESCENDING = new Order("DESCENDING", 1);
            IGNORE = new Order("IGNORE", 2);
            $VALUES = (new Order[] {
                ASCENDING, DESCENDING, IGNORE
            });
        }


        private Order(String s, int i)
        {
            super(s, i);
            name = name().toLowerCase();
        }
    }


    private Set aliases;
    private final JsonNode defaultValue;
    private final String doc;
    private final String name;
    private final Order order;
    private transient int position;
    private final Order props;
    private final Schema schema;

    private boolean defaultValueEquals(JsonNode jsonnode)
    {
        if (defaultValue == null)
        {
            return jsonnode == null;
        }
        if (Double.isNaN(defaultValue.getValueAsDouble()))
        {
            return Double.isNaN(jsonnode.getValueAsDouble());
        } else
        {
            return defaultValue.equals(jsonnode);
        }
    }

    public void addAlias(String s)
    {
        if (aliases == null)
        {
            aliases = new LinkedHashSet();
        }
        aliases.add(s);
    }

    public void addProp(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        props.add(s, s1);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public Set aliases()
    {
        if (aliases == null)
        {
            return Collections.emptySet();
        } else
        {
            return Collections.unmodifiableSet(aliases);
        }
    }

    public JsonNode defaultValue()
    {
        return defaultValue;
    }

    public String doc()
    {
        return doc;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof ))
            {
                return false;
            }
            obj = ()obj;
            if (!name.equals(((name) (obj)).name) || !schema.equals((() (obj)).schema) || !defaultValueEquals((() (obj)).defaultValue) || !props.equals(((equals) (obj)).props))
            {
                return false;
            }
        }
        return true;
    }

    public String getProp(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = (String)props.get(s);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public int hashCode()
    {
        return name.hashCode() + schema.computeHash();
    }

    public String name()
    {
        return name;
    }

    public Order order()
    {
        return order;
    }

    public int pos()
    {
        return position;
    }

    public Map props()
    {
        return Collections.unmodifiableMap(props);
    }

    public Schema schema()
    {
        return schema;
    }

    public String toString()
    {
        return (new StringBuilder()).append(name).append(" type:").append(Schema.access$300(schema)).append(" pos:").append(position).toString();
    }



/*
    static Set access$1302(Order order1, Set set)
    {
        order1.aliases = set;
        return set;
    }

*/









/*
    static int access$702(Order order1, int i)
    {
        order1.position = i;
        return i;
    }

*/

    public Order(String s, Schema schema1, String s1, JsonNode jsonnode)
    {
        this(s, schema1, s1, jsonnode, Order.ASCENDING);
    }

    public Order(String s, Schema schema1, String s1, JsonNode jsonnode, Order order1)
    {
        position = -1;
        props = new <init>(Schema.access$100());
        name = Schema.access$200(s);
        schema = schema1;
        doc = s1;
        defaultValue = jsonnode;
        order = order1;
    }
}
