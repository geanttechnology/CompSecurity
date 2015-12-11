// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Version;

// Referenced classes of package org.simpleframework.xml.core:
//            Scanner, Caller, ParameterMap, Section, 
//            Context, Function, Decorator, Instantiator, 
//            Signature, Label, LabelMap

class PrimitiveScanner
    implements Scanner
{
    private static class EmptySection
        implements Section
    {

        private final List list = new LinkedList();
        private final Scanner scanner;

        public String getAttribute(String s)
        {
            return null;
        }

        public LabelMap getAttributes()
        {
            return new LabelMap(scanner);
        }

        public Label getElement(String s)
        {
            return null;
        }

        public LabelMap getElements()
        {
            return new LabelMap(scanner);
        }

        public String getName()
        {
            return null;
        }

        public String getPath(String s)
        {
            return null;
        }

        public String getPrefix()
        {
            return null;
        }

        public Section getSection(String s)
        {
            return null;
        }

        public Label getText()
        {
            return null;
        }

        public boolean isSection(String s)
        {
            return false;
        }

        public Iterator iterator()
        {
            return list.iterator();
        }

        public EmptySection(Scanner scanner1)
        {
            scanner = scanner1;
        }
    }


    private final Section section = new EmptySection(this);
    private final Class type;

    public PrimitiveScanner(Class class1)
    {
        type = class1;
    }

    public Caller getCaller(Context context)
    {
        return new Caller(this, context);
    }

    public Function getCommit()
    {
        return null;
    }

    public Function getComplete()
    {
        return null;
    }

    public Decorator getDecorator()
    {
        return null;
    }

    public Instantiator getInstantiator()
    {
        return null;
    }

    public String getName()
    {
        return null;
    }

    public Order getOrder()
    {
        return null;
    }

    public ParameterMap getParameters()
    {
        return new ParameterMap();
    }

    public Function getPersist()
    {
        return null;
    }

    public Function getReplace()
    {
        return null;
    }

    public Function getResolve()
    {
        return null;
    }

    public Version getRevision()
    {
        return null;
    }

    public Section getSection()
    {
        return section;
    }

    public Signature getSignature()
    {
        return null;
    }

    public List getSignatures()
    {
        return new LinkedList();
    }

    public Label getText()
    {
        return null;
    }

    public Class getType()
    {
        return type;
    }

    public Function getValidate()
    {
        return null;
    }

    public Label getVersion()
    {
        return null;
    }

    public boolean isEmpty()
    {
        return true;
    }

    public boolean isPrimitive()
    {
        return true;
    }

    public boolean isStrict()
    {
        return true;
    }
}
