// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

// Referenced classes of package org.simpleframework.xml.core:
//            Repeater, Variable, PersistenceException, Label, 
//            Converter

private static class label
    implements Repeater
{

    private final Label label;
    private final Converter reader;
    private final Object value;

    public Object read(InputNode inputnode)
        throws Exception
    {
        return read(inputnode, value);
    }

    public Object read(InputNode inputnode, Object obj)
        throws Exception
    {
        org.simpleframework.xml.stream.Position position = inputnode.getPosition();
        String s = inputnode.getName();
        if (reader instanceof Repeater)
        {
            return ((Repeater)reader).read(inputnode, obj);
        } else
        {
            throw new PersistenceException("Element '%s' is already used with %s at %s", new Object[] {
                s, label, position
            });
        }
    }

    public boolean validate(InputNode inputnode)
        throws Exception
    {
        org.simpleframework.xml.stream.Position position = inputnode.getPosition();
        String s = inputnode.getName();
        if (reader instanceof Repeater)
        {
            return ((Repeater)reader).validate(inputnode);
        } else
        {
            throw new PersistenceException("Element '%s' declared twice at %s", new Object[] {
                s, position
            });
        }
    }

    public void write(OutputNode outputnode, Object obj)
        throws Exception
    {
        write(outputnode, obj);
    }

    public ion(Converter converter, Label label1, Object obj)
    {
        reader = converter;
        value = obj;
        label = label1;
    }
}
