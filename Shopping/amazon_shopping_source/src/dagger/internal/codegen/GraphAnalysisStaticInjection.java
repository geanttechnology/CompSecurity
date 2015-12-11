// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal.codegen;

import dagger.internal.Linker;
import dagger.internal.StaticInjection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;

// Referenced classes of package dagger.internal.codegen:
//            Util, GeneratorKeys

public final class GraphAnalysisStaticInjection extends StaticInjection
{

    private final Element enclosingClass;

    public GraphAnalysisStaticInjection(Element element)
    {
        enclosingClass = element;
    }

    public void attach(Linker linker)
    {
        Iterator iterator = enclosingClass.getEnclosedElements().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Element element = (Element)iterator.next();
            if (element.getKind().isField() && Util.isStatic(element) && (Inject)element.getAnnotation(javax/inject/Inject) != null)
            {
                linker.requestBinding(GeneratorKeys.get(element.asType()), enclosingClass.toString(), getClass().getClassLoader());
            }
        } while (true);
    }

    public void inject()
    {
        throw new UnsupportedOperationException();
    }
}
