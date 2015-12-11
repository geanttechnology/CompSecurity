// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal.codegen;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.inject.Singleton;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;

// Referenced classes of package dagger.internal.codegen:
//            GraphAnalysisProcessor, Util, GeneratorKeys

static class setLibrary extends ProvidesBinding
{

    private final ExecutableElement method;
    private final Binding parameters[];

    public void attach(Linker linker)
    {
        for (int i = 0; i < method.getParameters().size(); i++)
        {
            String s = GeneratorKeys.get((VariableElement)method.getParameters().get(i));
            parameters[i] = linker.requestBinding(s, method.toString(), getClass().getClassLoader());
        }

    }

    public Object get()
    {
        throw new AssertionError("Compile-time binding should never be called to inject.");
    }

    public void getDependencies(Set set, Set set1)
    {
        Collections.addAll(set, parameters);
    }

    public void injectMembers(Object obj)
    {
        throw new AssertionError("Compile-time binding should never be called to inject.");
    }

    public String toString()
    {
        return (new StringBuilder()).append("ProvidesBinding[key=").append(provideKey).append(" method=").append(moduleClass).append(".").append(method.getSimpleName()).append("()").toString();
    }

    protected (String s, ExecutableElement executableelement, boolean flag)
    {
        boolean flag1;
        if (executableelement.getAnnotation(javax/inject/Singleton) != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        super(s, flag1, Util.className(executableelement), executableelement.getSimpleName().toString());
        method = executableelement;
        parameters = new Binding[executableelement.getParameters().size()];
        setLibrary(flag);
    }
}
