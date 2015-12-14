// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal.plugins.loading;

import dagger.internal.Binding;
import dagger.internal.ModuleAdapter;
import dagger.internal.Plugin;
import java.lang.reflect.Constructor;

public final class ClassloadingPlugin
    implements Plugin
{

    public ClassloadingPlugin()
    {
    }

    private Object instantiate(String s, String s1)
    {
        s = (new StringBuilder()).append(s).append(s1).toString();
        try
        {
            s1 = Class.forName(s).getConstructor(new Class[0]);
            s1.setAccessible(true);
            s1 = ((String) (s1.newInstance(new Object[0])));
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            throw new RuntimeException((new StringBuilder()).append("Unexpected failure loading ").append(s).toString(), s1);
        }
        return s1;
    }

    public Binding getAtInjectBinding(String s, String s1, boolean flag)
    {
        return (Binding)instantiate(s1, "$InjectAdapter");
    }

    public ModuleAdapter getModuleAdapter(Class class1, Object obj)
    {
        return (ModuleAdapter)instantiate(class1.getName(), "$ModuleAdapter");
    }
}
