// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.stream.Format;

// Referenced classes of package org.simpleframework.xml.core:
//            ParameterMap, ConstructorException, SignatureScanner, Signature

class ConstructorScanner
{

    private Format format;
    private Signature primary;
    private ParameterMap registry;
    private List signatures;

    public ConstructorScanner(Class class1, Format format1)
        throws Exception
    {
        signatures = new ArrayList();
        registry = new ParameterMap();
        format = format1;
        scan(class1);
    }

    private boolean isInstantiable(Class class1)
    {
        while (Modifier.isStatic(class1.getModifiers()) || !class1.isMemberClass()) 
        {
            return true;
        }
        return false;
    }

    private void scan(Class class1)
        throws Exception
    {
        Constructor aconstructor[] = class1.getDeclaredConstructors();
        if (!isInstantiable(class1))
        {
            throw new ConstructorException("Can not construct inner %s", new Object[] {
                class1
            });
        }
        int j = aconstructor.length;
        for (int i = 0; i < j; i++)
        {
            Constructor constructor = aconstructor[i];
            if (!class1.isPrimitive())
            {
                scan(constructor);
            }
        }

    }

    private void scan(Constructor constructor)
        throws Exception
    {
        constructor = new SignatureScanner(constructor, registry, format);
        if (constructor.isValid())
        {
            Signature signature;
            for (constructor = constructor.getSignatures().iterator(); constructor.hasNext(); signatures.add(signature))
            {
                signature = (Signature)constructor.next();
                if (signature.size() == 0)
                {
                    primary = signature;
                }
            }

        }
    }

    public ParameterMap getParameters()
    {
        return registry;
    }

    public Signature getSignature()
    {
        return primary;
    }

    public List getSignatures()
    {
        return new ArrayList(signatures);
    }
}
