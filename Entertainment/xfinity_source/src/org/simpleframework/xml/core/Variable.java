// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

// Referenced classes of package org.simpleframework.xml.core:
//            Label, Contact, Context, Converter, 
//            Decorator, Expression, Repeater, PersistenceException

class Variable
    implements Label
{
    private static class Adapter
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

        public Adapter(Converter converter, Label label1, Object obj)
        {
            reader = converter;
            value = obj;
            label = label1;
        }
    }


    private final Label label;
    private final Object value;

    public Variable(Label label1, Object obj)
    {
        label = label1;
        value = obj;
    }

    public Annotation getAnnotation()
    {
        return label.getAnnotation();
    }

    public Contact getContact()
    {
        return label.getContact();
    }

    public Converter getConverter(Context context)
        throws Exception
    {
        context = label.getConverter(context);
        if (context instanceof Adapter)
        {
            return context;
        } else
        {
            return new Adapter(context, label, value);
        }
    }

    public Decorator getDecorator()
        throws Exception
    {
        return label.getDecorator();
    }

    public Type getDependent()
        throws Exception
    {
        return label.getDependent();
    }

    public Object getEmpty(Context context)
        throws Exception
    {
        return label.getEmpty(context);
    }

    public String getEntry()
        throws Exception
    {
        return label.getEntry();
    }

    public Expression getExpression()
        throws Exception
    {
        return label.getExpression();
    }

    public Object getKey()
        throws Exception
    {
        return label.getKey();
    }

    public Label getLabel(Class class1)
    {
        return this;
    }

    public String getName()
        throws Exception
    {
        return label.getName();
    }

    public String[] getNames()
        throws Exception
    {
        return label.getNames();
    }

    public String getOverride()
    {
        return label.getOverride();
    }

    public String getPath()
        throws Exception
    {
        return label.getPath();
    }

    public String[] getPaths()
        throws Exception
    {
        return label.getPaths();
    }

    public Class getType()
    {
        return label.getType();
    }

    public Type getType(Class class1)
        throws Exception
    {
        return label.getType(class1);
    }

    public Object getValue()
    {
        return value;
    }

    public boolean isAttribute()
    {
        return label.isAttribute();
    }

    public boolean isCollection()
    {
        return label.isCollection();
    }

    public boolean isData()
    {
        return label.isData();
    }

    public boolean isInline()
    {
        return label.isInline();
    }

    public boolean isRequired()
    {
        return label.isRequired();
    }

    public boolean isText()
    {
        return label.isText();
    }

    public boolean isUnion()
    {
        return label.isUnion();
    }

    public String toString()
    {
        return label.toString();
    }
}
