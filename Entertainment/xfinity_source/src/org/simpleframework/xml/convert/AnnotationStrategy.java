// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.convert;

import java.util.Map;
import org.simpleframework.xml.strategy.Strategy;
import org.simpleframework.xml.strategy.TreeStrategy;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NodeMap;
import org.simpleframework.xml.stream.OutputNode;

// Referenced classes of package org.simpleframework.xml.convert:
//            ConverterScanner, Converter, Reference

public class AnnotationStrategy
    implements Strategy
{

    private final ConverterScanner scanner;
    private final Strategy strategy;

    public AnnotationStrategy()
    {
        this(((Strategy) (new TreeStrategy())));
    }

    public AnnotationStrategy(Strategy strategy1)
    {
        scanner = new ConverterScanner();
        strategy = strategy1;
    }

    private boolean isReference(Value value)
    {
        return value != null && value.isReference();
    }

    private Value read(Type type, NodeMap nodemap, Value value)
        throws Exception
    {
        Converter converter = scanner.getConverter(type, value);
        nodemap = (InputNode)nodemap.getNode();
        type = value;
        if (converter != null)
        {
            type = ((Type) (converter.read(nodemap)));
            if (value != null)
            {
                value.setValue(type);
            }
            type = new Reference(value, type);
        }
        return type;
    }

    private boolean write(Type type, Object obj, NodeMap nodemap)
        throws Exception
    {
        type = scanner.getConverter(type, obj);
        nodemap = (OutputNode)nodemap.getNode();
        if (type != null)
        {
            type.write(nodemap, obj);
            return true;
        } else
        {
            return false;
        }
    }

    public Value read(Type type, NodeMap nodemap, Map map)
        throws Exception
    {
        map = strategy.read(type, nodemap, map);
        if (isReference(map))
        {
            return map;
        } else
        {
            return read(type, nodemap, ((Value) (map)));
        }
    }

    public boolean write(Type type, Object obj, NodeMap nodemap, Map map)
        throws Exception
    {
        boolean flag1 = strategy.write(type, obj, nodemap, map);
        boolean flag = flag1;
        if (!flag1)
        {
            flag = write(type, obj, nodemap);
        }
        return flag;
    }
}
