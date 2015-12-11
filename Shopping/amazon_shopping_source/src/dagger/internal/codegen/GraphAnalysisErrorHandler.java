// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal.codegen;

import java.util.Iterator;
import java.util.List;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.util.Elements;

final class GraphAnalysisErrorHandler
    implements dagger.internal.Linker.ErrorHandler
{

    private final String moduleName;
    private final ProcessingEnvironment processingEnv;

    GraphAnalysisErrorHandler(ProcessingEnvironment processingenvironment, String s)
    {
        processingEnv = processingenvironment;
        moduleName = s;
    }

    public void handleErrors(List list)
    {
        javax.lang.model.element.TypeElement typeelement = processingEnv.getElementUtils().getTypeElement(moduleName);
        String s;
        for (list = list.iterator(); list.hasNext(); processingEnv.getMessager().printMessage(javax.tools.Diagnostic.Kind.ERROR, (new StringBuilder()).append(s).append(" for ").append(moduleName).toString(), typeelement))
        {
            s = (String)list.next();
        }

    }
}
