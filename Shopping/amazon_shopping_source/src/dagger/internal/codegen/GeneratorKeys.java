// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal.codegen;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Qualifier;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;

// Referenced classes of package dagger.internal.codegen:
//            Util

final class GeneratorKeys
{

    private static final String SET_PREFIX = (new StringBuilder()).append(java/util/Set.getCanonicalName()).append("<").toString();

    private GeneratorKeys()
    {
    }

    public static String get(ExecutableElement executableelement)
    {
        StringBuilder stringbuilder = new StringBuilder();
        AnnotationMirror annotationmirror = getQualifier(executableelement.getAnnotationMirrors());
        if (annotationmirror != null)
        {
            qualifierToString(annotationmirror, stringbuilder);
        }
        Util.typeToString(executableelement.getReturnType(), stringbuilder, '$');
        return stringbuilder.toString();
    }

    public static String get(VariableElement variableelement)
    {
        StringBuilder stringbuilder = new StringBuilder();
        AnnotationMirror annotationmirror = getQualifier(variableelement.getAnnotationMirrors());
        if (annotationmirror != null)
        {
            qualifierToString(annotationmirror, stringbuilder);
        }
        Util.typeToString(variableelement.asType(), stringbuilder, '$');
        return stringbuilder.toString();
    }

    public static String get(TypeMirror typemirror)
    {
        StringBuilder stringbuilder = new StringBuilder();
        Util.typeToString(typemirror, stringbuilder, '$');
        return stringbuilder.toString();
    }

    private static AnnotationMirror getQualifier(List list)
    {
        Object obj = null;
        Iterator iterator = list.iterator();
        list = obj;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            AnnotationMirror annotationmirror = (AnnotationMirror)iterator.next();
            if (annotationmirror.getAnnotationType().asElement().getAnnotation(javax/inject/Qualifier) != null)
            {
                list = annotationmirror;
            }
        } while (true);
        return list;
    }

    public static String getSetKey(ExecutableElement executableelement)
    {
        StringBuilder stringbuilder = new StringBuilder();
        AnnotationMirror annotationmirror = getQualifier(executableelement.getAnnotationMirrors());
        if (annotationmirror != null)
        {
            qualifierToString(annotationmirror, stringbuilder);
        }
        stringbuilder.append(SET_PREFIX);
        Util.typeToString(executableelement.getReturnType(), stringbuilder, '$');
        stringbuilder.append(">");
        return stringbuilder.toString();
    }

    private static void qualifierToString(AnnotationMirror annotationmirror, StringBuilder stringbuilder)
    {
        stringbuilder.append('@');
        Util.typeToString(annotationmirror.getAnnotationType(), stringbuilder, '$');
        stringbuilder.append('(');
        java.util.Map.Entry entry;
        for (annotationmirror = annotationmirror.getElementValues().entrySet().iterator(); annotationmirror.hasNext(); stringbuilder.append(((AnnotationValue)entry.getValue()).getValue()))
        {
            entry = (java.util.Map.Entry)annotationmirror.next();
            stringbuilder.append(((ExecutableElement)entry.getKey()).getSimpleName());
            stringbuilder.append('=');
        }

        stringbuilder.append(")/");
    }

    public static String rawMembersKey(TypeMirror typemirror)
    {
        return (new StringBuilder()).append("members/").append(Util.rawTypeToString(typemirror, '$')).toString();
    }

}
