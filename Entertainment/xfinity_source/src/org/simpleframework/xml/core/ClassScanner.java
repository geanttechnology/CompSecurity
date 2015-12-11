// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import org.simpleframework.xml.Default;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.stream.Format;

// Referenced classes of package org.simpleframework.xml.core:
//            ConstructorScanner, NamespaceDecorator, Function, Commit, 
//            Validate, Persist, Complete, Replace, 
//            Resolve, Decorator, ParameterMap, Signature

class ClassScanner
{

    private Default access;
    private Function commit;
    private Function complete;
    private NamespaceDecorator decorator;
    private Namespace namespace;
    private Order order;
    private Function persist;
    private Function replace;
    private Function resolve;
    private Root root;
    private ConstructorScanner scanner;
    private Function validate;

    public ClassScanner(Class class1, Format format)
        throws Exception
    {
        scanner = new ConstructorScanner(class1, format);
        decorator = new NamespaceDecorator();
        scan(class1);
    }

    private void access(Annotation annotation)
    {
        if (access == null)
        {
            access = (Default)annotation;
        }
    }

    private void commit(Method method)
    {
        if (commit == null)
        {
            commit = getFunction(method);
        }
    }

    private void complete(Method method)
    {
        if (complete == null)
        {
            complete = getFunction(method);
        }
    }

    private Function getFunction(Method method)
    {
        boolean flag = isContextual(method);
        if (!method.isAccessible())
        {
            method.setAccessible(true);
        }
        return new Function(method, flag);
    }

    private void global(Class class1)
        throws Exception
    {
        class1 = class1.getDeclaredAnnotations();
        int j = class1.length;
        for (int i = 0; i < j; i++)
        {
            Annotation annotation = class1[i];
            if (annotation instanceof Namespace)
            {
                namespace(annotation);
            }
            if (annotation instanceof NamespaceList)
            {
                scope(annotation);
            }
            if (annotation instanceof Root)
            {
                root(annotation);
            }
            if (annotation instanceof Order)
            {
                order(annotation);
            }
            if (annotation instanceof Default)
            {
                access(annotation);
            }
        }

    }

    private boolean isContextual(Method method)
    {
        boolean flag = false;
        method = method.getParameterTypes();
        if (method.length == 1)
        {
            flag = java/util/Map.equals(method[0]);
        }
        return flag;
    }

    private void namespace(Annotation annotation)
    {
        if (annotation != null)
        {
            namespace = (Namespace)annotation;
            if (namespace != null)
            {
                decorator.add(namespace);
            }
        }
    }

    private void order(Annotation annotation)
    {
        if (order == null)
        {
            order = (Order)annotation;
        }
    }

    private void persist(Method method)
    {
        if (persist == null)
        {
            persist = getFunction(method);
        }
    }

    private void process(Class class1)
    {
        if (namespace != null)
        {
            decorator.set(namespace);
        }
    }

    private void replace(Method method)
    {
        if (replace == null)
        {
            replace = getFunction(method);
        }
    }

    private void resolve(Method method)
    {
        if (resolve == null)
        {
            resolve = getFunction(method);
        }
    }

    private void root(Annotation annotation)
    {
        if (root == null)
        {
            root = (Root)annotation;
        }
    }

    private void scan(Class class1)
        throws Exception
    {
        for (Class class2 = class1; class2 != null; class2 = class2.getSuperclass())
        {
            global(class2);
            scan(class1, class2);
        }

        process(class1);
    }

    private void scan(Class class1, Class class2)
        throws Exception
    {
        class1 = class2.getDeclaredMethods();
        for (int i = 0; i < class1.length; i++)
        {
            scan(class1[i]);
        }

    }

    private void scan(Method method)
    {
        Annotation aannotation[] = method.getDeclaredAnnotations();
        int j = aannotation.length;
        for (int i = 0; i < j; i++)
        {
            Annotation annotation = aannotation[i];
            if (annotation instanceof Commit)
            {
                commit(method);
            }
            if (annotation instanceof Validate)
            {
                validate(method);
            }
            if (annotation instanceof Persist)
            {
                persist(method);
            }
            if (annotation instanceof Complete)
            {
                complete(method);
            }
            if (annotation instanceof Replace)
            {
                replace(method);
            }
            if (annotation instanceof Resolve)
            {
                resolve(method);
            }
        }

    }

    private void scope(Annotation annotation)
    {
        if (annotation != null)
        {
            annotation = ((NamespaceList)annotation).value();
            int j = annotation.length;
            for (int i = 0; i < j; i++)
            {
                Namespace namespace1 = annotation[i];
                decorator.add(namespace1);
            }

        }
    }

    private void validate(Method method)
    {
        if (validate == null)
        {
            validate = getFunction(method);
        }
    }

    public Function getCommit()
    {
        return commit;
    }

    public Function getComplete()
    {
        return complete;
    }

    public Decorator getDecorator()
    {
        return decorator;
    }

    public Default getDefault()
    {
        return access;
    }

    public Order getOrder()
    {
        return order;
    }

    public ParameterMap getParameters()
    {
        return scanner.getParameters();
    }

    public Function getPersist()
    {
        return persist;
    }

    public Function getReplace()
    {
        return replace;
    }

    public Function getResolve()
    {
        return resolve;
    }

    public Root getRoot()
    {
        return root;
    }

    public Signature getSignature()
    {
        return scanner.getSignature();
    }

    public List getSignatures()
    {
        return scanner.getSignatures();
    }

    public Function getValidate()
    {
        return validate;
    }

    public boolean isStrict()
    {
        if (root != null)
        {
            return root.strict();
        } else
        {
            return true;
        }
    }
}
