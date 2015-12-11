// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Version;
import org.simpleframework.xml.stream.Format;

// Referenced classes of package org.simpleframework.xml.core:
//            Scanner, ClassScanner, StructureBuilder, FieldScanner, 
//            ContactList, Contact, MethodScanner, Reflector, 
//            Caller, Structure, Context, Function, 
//            Decorator, Instantiator, ParameterMap, Section, 
//            Signature, Label

class ObjectScanner
    implements Scanner
{

    private DefaultType access;
    private StructureBuilder builder;
    private String name;
    private boolean required;
    private ClassScanner scanner;
    private Structure structure;
    private Class type;

    public ObjectScanner(Class class1)
        throws Exception
    {
        this(class1, new Format());
    }

    public ObjectScanner(Class class1, Format format)
        throws Exception
    {
        scanner = new ClassScanner(class1, format);
        builder = new StructureBuilder(this, class1, format);
        type = class1;
        scan(class1);
    }

    private void access(Class class1)
    {
        class1 = scanner.getDefault();
        if (class1 != null)
        {
            required = class1.required();
            access = class1.value();
        }
    }

    private void commit(Class class1)
        throws Exception
    {
        if (structure == null)
        {
            structure = builder.build(class1);
        }
        builder = null;
    }

    private void field(Class class1)
        throws Exception
    {
        class1 = (new FieldScanner(class1, access, required)).iterator();
        do
        {
            if (!class1.hasNext())
            {
                break;
            }
            Contact contact = (Contact)class1.next();
            java.lang.annotation.Annotation annotation = contact.getAnnotation();
            if (annotation != null)
            {
                builder.process(contact, annotation);
            }
        } while (true);
    }

    private boolean isEmpty(String s)
    {
        return s.length() == 0;
    }

    private void method(Class class1)
        throws Exception
    {
        class1 = (new MethodScanner(class1, access, required)).iterator();
        do
        {
            if (!class1.hasNext())
            {
                break;
            }
            Contact contact = (Contact)class1.next();
            java.lang.annotation.Annotation annotation = contact.getAnnotation();
            if (annotation != null)
            {
                builder.process(contact, annotation);
            }
        } while (true);
    }

    private void order(Class class1)
        throws Exception
    {
        builder.assemble(class1);
    }

    private void root(Class class1)
    {
        String s1 = class1.getSimpleName();
        class1 = scanner.getRoot();
        if (class1 != null)
        {
            String s = class1.name();
            class1 = s;
            if (isEmpty(s))
            {
                class1 = Reflector.getName(s1);
            }
            name = class1.intern();
        }
    }

    private void scan(Class class1)
        throws Exception
    {
        root(class1);
        order(class1);
        access(class1);
        field(class1);
        method(class1);
        validate(class1);
        commit(class1);
    }

    private void validate(Class class1)
        throws Exception
    {
        builder.commit(class1);
        builder.validate(class1);
    }

    public Caller getCaller(Context context)
    {
        return new Caller(this, context);
    }

    public Function getCommit()
    {
        return scanner.getCommit();
    }

    public Function getComplete()
    {
        return scanner.getComplete();
    }

    public Decorator getDecorator()
    {
        return scanner.getDecorator();
    }

    public Instantiator getInstantiator()
    {
        return structure.getInstantiator();
    }

    public String getName()
    {
        return name;
    }

    public Order getOrder()
    {
        return scanner.getOrder();
    }

    public ParameterMap getParameters()
    {
        return scanner.getParameters();
    }

    public Function getPersist()
    {
        return scanner.getPersist();
    }

    public Function getReplace()
    {
        return scanner.getReplace();
    }

    public Function getResolve()
    {
        return scanner.getResolve();
    }

    public Version getRevision()
    {
        return structure.getRevision();
    }

    public Section getSection()
    {
        return structure.getSection();
    }

    public Signature getSignature()
    {
        return scanner.getSignature();
    }

    public List getSignatures()
    {
        return scanner.getSignatures();
    }

    public Label getText()
    {
        return structure.getText();
    }

    public Class getType()
    {
        return type;
    }

    public Function getValidate()
    {
        return scanner.getValidate();
    }

    public Label getVersion()
    {
        return structure.getVersion();
    }

    public boolean isEmpty()
    {
        return scanner.getRoot() == null;
    }

    public boolean isPrimitive()
    {
        return structure.isPrimitive();
    }

    public boolean isStrict()
    {
        return scanner.isStrict();
    }
}
