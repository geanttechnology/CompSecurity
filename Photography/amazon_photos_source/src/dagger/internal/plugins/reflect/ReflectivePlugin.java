// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal.plugins.reflect;

import dagger.Module;
import dagger.internal.Binding;
import dagger.internal.ModuleAdapter;
import dagger.internal.Plugin;

// Referenced classes of package dagger.internal.plugins.reflect:
//            ReflectiveAtInjectBinding, ReflectiveModuleAdapter

public final class ReflectivePlugin
    implements Plugin
{

    public ReflectivePlugin()
    {
    }

    public Binding getAtInjectBinding(String s, String s1, boolean flag)
    {
        try
        {
            s = Class.forName(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        return ReflectiveAtInjectBinding.create(s, flag);
    }

    public ModuleAdapter getModuleAdapter(Class class1, Object obj)
    {
        obj = (Module)class1.getAnnotation(dagger/Module);
        if (obj == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("No @Module on ").append(class1.getName()).toString());
        } else
        {
            return new ReflectiveModuleAdapter(class1, ((Module) (obj)));
        }
    }
}
