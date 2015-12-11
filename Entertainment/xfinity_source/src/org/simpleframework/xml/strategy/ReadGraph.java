// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.strategy;

import java.util.HashMap;
import org.simpleframework.xml.stream.Node;
import org.simpleframework.xml.stream.NodeMap;

// Referenced classes of package org.simpleframework.xml.strategy:
//            Contract, ArrayValue, CycleException, Reference, 
//            Type, ObjectValue, Allocate, Loader, 
//            Value

class ReadGraph extends HashMap
{

    private final String label;
    private final String length;
    private final Loader loader;
    private final String mark;
    private final String refer;

    public ReadGraph(Contract contract, Loader loader1)
    {
        refer = contract.getReference();
        mark = contract.getIdentity();
        length = contract.getLength();
        label = contract.getLabel();
        loader = loader1;
    }

    private Value readArray(Type type, Class class1, NodeMap nodemap)
        throws Exception
    {
        type = nodemap.remove(length);
        int i = 0;
        if (type != null)
        {
            i = Integer.parseInt(type.getValue());
        }
        return new ArrayValue(class1, i);
    }

    private Value readInstance(Type type, Class class1, NodeMap nodemap)
        throws Exception
    {
        Object obj = nodemap.remove(mark);
        if (obj == null)
        {
            return readReference(type, class1, nodemap);
        }
        obj = ((Node) (obj)).getValue();
        if (containsKey(obj))
        {
            throw new CycleException("Element '%s' already exists", new Object[] {
                obj
            });
        } else
        {
            return readValue(type, class1, nodemap, ((String) (obj)));
        }
    }

    private Value readReference(Type type, Class class1, NodeMap nodemap)
        throws Exception
    {
        Node node = nodemap.remove(refer);
        if (node == null)
        {
            return readValue(type, class1, nodemap);
        }
        type = node.getValue();
        nodemap = ((NodeMap) (get(type)));
        if (!containsKey(type))
        {
            throw new CycleException("Invalid reference '%s' found", new Object[] {
                type
            });
        } else
        {
            return new Reference(nodemap, class1);
        }
    }

    private Value readValue(Type type, Class class1, NodeMap nodemap)
        throws Exception
    {
        if (type.getType().isArray())
        {
            return readArray(type, class1, nodemap);
        } else
        {
            return new ObjectValue(class1);
        }
    }

    private Value readValue(Type type, Class class1, NodeMap nodemap, String s)
        throws Exception
    {
        class1 = readValue(type, class1, nodemap);
        type = class1;
        if (s != null)
        {
            type = new Allocate(class1, this, s);
        }
        return type;
    }

    public Value read(Type type, NodeMap nodemap)
        throws Exception
    {
        Node node = nodemap.remove(label);
        Class class1 = type.getType();
        Object obj = class1;
        if (class1.isArray())
        {
            obj = class1.getComponentType();
        }
        if (node != null)
        {
            obj = node.getValue();
            obj = loader.load(((String) (obj)));
        }
        return readInstance(type, ((Class) (obj)), nodemap);
    }
}
