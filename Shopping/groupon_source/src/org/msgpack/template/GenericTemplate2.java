// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.template;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.msgpack.Template;

// Referenced classes of package org.msgpack.template:
//            GenericTemplate, AnyTemplate

public class GenericTemplate2
    implements GenericTemplate
{

    Constructor constructor;

    public GenericTemplate2(Class class1)
    {
        try
        {
            constructor = class1.getConstructor(new Class[] {
                org/msgpack/Template, org/msgpack/Template
            });
            constructor.newInstance(new Object[] {
                AnyTemplate.getInstance(), AnyTemplate.getInstance()
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new IllegalArgumentException(class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new IllegalArgumentException(class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new IllegalArgumentException(class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new IllegalArgumentException(class1);
        }
    }

    public Template build(Template atemplate[])
    {
        try
        {
            atemplate = (Template)constructor.newInstance(atemplate);
        }
        // Misplaced declaration of an exception variable
        catch (Template atemplate[])
        {
            throw new IllegalArgumentException(atemplate);
        }
        // Misplaced declaration of an exception variable
        catch (Template atemplate[])
        {
            throw new IllegalArgumentException(atemplate);
        }
        // Misplaced declaration of an exception variable
        catch (Template atemplate[])
        {
            throw new IllegalArgumentException(atemplate);
        }
        return atemplate;
    }
}
