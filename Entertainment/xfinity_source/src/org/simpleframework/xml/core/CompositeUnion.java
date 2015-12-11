// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

// Referenced classes of package org.simpleframework.xml.core:
//            Converter, Group, Label, Expression, 
//            LabelMap, UnionException, Context

class CompositeUnion
    implements Converter
{

    private final Context context;
    private final LabelMap elements;
    private final Group group;
    private final Expression path;
    private final Type type;

    public CompositeUnion(Context context1, Group group1, Expression expression, Type type1)
        throws Exception
    {
        elements = group1.getElements();
        context = context1;
        group = group1;
        type = type1;
        path = expression;
    }

    private void write(OutputNode outputnode, Object obj, Label label)
        throws Exception
    {
        label.getConverter(context).write(outputnode, obj);
    }

    public Object read(InputNode inputnode)
        throws Exception
    {
        String s = inputnode.getName();
        s = path.getElement(s);
        return ((Label)elements.get(s)).getConverter(context).read(inputnode);
    }

    public Object read(InputNode inputnode, Object obj)
        throws Exception
    {
        String s = inputnode.getName();
        s = path.getElement(s);
        return ((Label)elements.get(s)).getConverter(context).read(inputnode, obj);
    }

    public boolean validate(InputNode inputnode)
        throws Exception
    {
        String s = inputnode.getName();
        s = path.getElement(s);
        return ((Label)elements.get(s)).getConverter(context).validate(inputnode);
    }

    public void write(OutputNode outputnode, Object obj)
        throws Exception
    {
        Class class1 = obj.getClass();
        Label label = group.getLabel(class1);
        if (label == null)
        {
            throw new UnionException("Value of %s not declared in %s with annotation %s", new Object[] {
                class1, type, group
            });
        } else
        {
            write(outputnode, obj, label);
            return;
        }
    }
}
