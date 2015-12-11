// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal.codegen;

import dagger.internal.Binding;
import dagger.internal.Loader;
import dagger.internal.ModuleAdapter;
import dagger.internal.StaticInjection;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

// Referenced classes of package dagger.internal.codegen:
//            GraphAnalysisInjectBinding

public final class GraphAnalysisLoader extends Loader
{

    private final ProcessingEnvironment processingEnv;

    public GraphAnalysisLoader(ProcessingEnvironment processingenvironment)
    {
        processingEnv = processingenvironment;
    }

    public Binding getAtInjectBinding(String s, String s1, ClassLoader classloader, boolean flag)
    {
        s = s1.replace('$', '.');
        for (s = processingEnv.getElementUtils().getTypeElement(s); s == null || s.getKind() == ElementKind.INTERFACE;)
        {
            return null;
        }

        return GraphAnalysisInjectBinding.create(s, flag);
    }

    public ModuleAdapter getModuleAdapter(Class class1)
    {
        throw new UnsupportedOperationException();
    }

    public StaticInjection getStaticInjection(Class class1)
    {
        throw new UnsupportedOperationException();
    }
}
