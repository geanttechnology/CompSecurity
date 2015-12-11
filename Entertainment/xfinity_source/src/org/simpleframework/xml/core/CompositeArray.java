// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.reflect.Array;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

// Referenced classes of package org.simpleframework.xml.core:
//            Converter, ArrayFactory, Traverser, Instance, 
//            ElementException, Context

class CompositeArray
    implements Converter
{

    private final Type entry;
    private final ArrayFactory factory;
    private final String parent;
    private final Traverser root;
    private final Type type;

    public CompositeArray(Context context, Type type1, Type type2, String s)
    {
        factory = new ArrayFactory(context, type1);
        root = new Traverser(context);
        parent = s;
        entry = type2;
        type = type1;
    }

    private void read(InputNode inputnode, Object obj, int i)
        throws Exception
    {
        Class class1 = entry.getType();
        Object obj1 = null;
        if (!inputnode.isEmpty())
        {
            obj1 = root.read(inputnode, class1);
        }
        Array.set(obj, i, obj1);
    }

    private boolean validate(InputNode inputnode, Class class1)
        throws Exception
    {
        do
        {
            InputNode inputnode1;
            do
            {
                inputnode1 = inputnode.getNext();
                if (inputnode1 == null)
                {
                    return true;
                }
            } while (inputnode1.isEmpty());
            root.validate(inputnode1, class1);
        } while (true);
    }

    public Object read(InputNode inputnode)
        throws Exception
    {
        Instance instance = factory.getInstance(inputnode);
        Object obj1 = instance.getInstance();
        Object obj = obj1;
        if (!instance.isReference())
        {
            obj = read(inputnode, obj1);
        }
        return obj;
    }

    public Object read(InputNode inputnode, Object obj)
        throws Exception
    {
        int j = Array.getLength(obj);
        int i = 0;
        do
        {
            org.simpleframework.xml.stream.Position position = inputnode.getPosition();
            InputNode inputnode1 = inputnode.getNext();
            if (inputnode1 == null)
            {
                return obj;
            }
            if (i >= j)
            {
                throw new ElementException("Array length missing or incorrect for %s at %s", new Object[] {
                    type, position
                });
            }
            read(inputnode1, obj, i);
            i++;
        } while (true);
    }

    public boolean validate(InputNode inputnode)
        throws Exception
    {
        Instance instance = factory.getInstance(inputnode);
        if (!instance.isReference())
        {
            instance.setInstance(null);
            return validate(inputnode, instance.getType());
        } else
        {
            return true;
        }
    }

    public void write(OutputNode outputnode, Object obj)
        throws Exception
    {
        int j = Array.getLength(obj);
        for (int i = 0; i < j; i++)
        {
            Object obj1 = Array.get(obj, i);
            Class class1 = entry.getType();
            root.write(outputnode, obj1, class1, parent);
        }

        outputnode.commit();
    }
}
