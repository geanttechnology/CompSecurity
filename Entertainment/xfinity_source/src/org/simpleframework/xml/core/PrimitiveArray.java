// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.reflect.Array;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

// Referenced classes of package org.simpleframework.xml.core:
//            Converter, ArrayFactory, Primitive, Instance, 
//            ElementException, Context

class PrimitiveArray
    implements Converter
{

    private final Type entry;
    private final ArrayFactory factory;
    private final String parent;
    private final Primitive root;
    private final Type type;

    public PrimitiveArray(Context context, Type type1, Type type2, String s)
    {
        factory = new ArrayFactory(context, type1);
        root = new Primitive(context, type2);
        parent = s;
        entry = type2;
        type = type1;
    }

    private boolean isOverridden(OutputNode outputnode, Object obj)
        throws Exception
    {
        return factory.setOverride(entry, obj, outputnode);
    }

    private boolean validate(InputNode inputnode, Class class1)
        throws Exception
    {
        do
        {
            class1 = inputnode.getNext();
            if (class1 == null)
            {
                return true;
            }
            root.validate(class1);
        } while (true);
    }

    private void write(OutputNode outputnode, Object obj, int i)
        throws Exception
    {
        obj = Array.get(obj, i);
        if (obj != null && !isOverridden(outputnode, obj))
        {
            root.write(outputnode, obj);
        }
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
            Array.set(obj, i, root.read(inputnode1));
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
        int i = 0;
        do
        {
            OutputNode outputnode1;
label0:
            {
                if (i < j)
                {
                    outputnode1 = outputnode.getChild(parent);
                    if (outputnode1 != null)
                    {
                        break label0;
                    }
                }
                return;
            }
            write(outputnode1, obj, i);
            i++;
        } while (true);
    }
}
