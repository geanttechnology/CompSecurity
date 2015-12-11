// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal.codegen;

import dagger.Module;
import dagger.Provides;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.inject.Scope;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.type.DeclaredType;

// Referenced classes of package dagger.internal.codegen:
//            Util

public final class ValidationProcessor extends AbstractProcessor
{

    public ValidationProcessor()
    {
    }

    private void addAllEnclosed(Element element, List list, Map map)
    {
        list.add(element);
        element = element.getEnclosedElements().iterator();
        do
        {
            if (!element.hasNext())
            {
                break;
            }
            Element element1 = (Element)element.next();
            addAllEnclosed(element1, list, map);
            if (element1.getKind() == ElementKind.METHOD || element1.getKind() == ElementKind.CONSTRUCTOR)
            {
                Iterator iterator = ((ExecutableElement)element1).getParameters().iterator();
                while (iterator.hasNext()) 
                {
                    Element element2 = (Element)iterator.next();
                    list.add(element2);
                    map.put(element2, element1);
                }
            }
        } while (true);
    }

    private void error(String s, Element element)
    {
        processingEnv.getMessager().printMessage(javax.tools.Diagnostic.Kind.ERROR, s, element);
    }

    private void getAllElements(RoundEnvironment roundenvironment, List list, Map map)
    {
        for (roundenvironment = roundenvironment.getRootElements().iterator(); roundenvironment.hasNext(); addAllEnclosed((Element)roundenvironment.next(), list, map)) { }
    }

    private boolean isInjectableConstructorParameter(Element element, Map map)
    {
        return ((Element)map.get(element)).getKind() == ElementKind.CONSTRUCTOR && ((Element)map.get(element)).getAnnotation(javax/inject/Inject) != null;
    }

    private boolean isProvidesMethod(Element element)
    {
        return element.getKind() == ElementKind.METHOD && element.getAnnotation(dagger/Provides) != null;
    }

    private boolean isProvidesMethodParameter(Element element, Map map)
    {
        return ((Element)map.get(element)).getAnnotation(dagger/Provides) != null;
    }

    private void validateProvides(Element element)
    {
        if (element.getAnnotation(dagger/Provides) != null && Util.getAnnotation(dagger/Module, element.getEnclosingElement()) == null)
        {
            error((new StringBuilder()).append("@Provides methods must be declared in modules: ").append(Util.elementToString(element)).toString(), element);
        }
    }

    private void validateQualifiers(Element element, Map map)
    {
        Iterator iterator;
        int i;
        boolean flag;
        if (element.getAnnotation(java/lang/SuppressWarnings) != null && Arrays.asList(((SuppressWarnings)element.getAnnotation(java/lang/SuppressWarnings)).value()).contains("qualifiers"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = 0;
        iterator = element.getAnnotationMirrors().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            static class _cls1
            {

                static final int $SwitchMap$javax$lang$model$element$ElementKind[];

                static 
                {
                    $SwitchMap$javax$lang$model$element$ElementKind = new int[ElementKind.values().length];
                    try
                    {
                        $SwitchMap$javax$lang$model$element$ElementKind[ElementKind.FIELD.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$javax$lang$model$element$ElementKind[ElementKind.METHOD.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$javax$lang$model$element$ElementKind[ElementKind.PARAMETER.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$javax$lang$model$element$ElementKind[ElementKind.CLASS.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            if (((AnnotationMirror)iterator.next()).getAnnotationType().asElement().getAnnotation(javax/inject/Qualifier) != null)
            {
                switch (_cls1..SwitchMap.javax.lang.model.element.ElementKind[element.getKind().ordinal()])
                {
                default:
                    error((new StringBuilder()).append("Qualifier annotations are only allowed on fields, methods, and parameters: ").append(Util.elementToString(element)).toString(), element);
                    break;

                case 1: // '\001'
                    int j = i + 1;
                    i = j;
                    if (element.getAnnotation(javax/inject/Inject) != null)
                    {
                        break;
                    }
                    i = j;
                    if (!flag)
                    {
                        warning((new StringBuilder()).append("Dagger will ignore qualifier annotations on fields that are not annotated with @Inject: ").append(Util.elementToString(element)).toString(), element);
                        i = j;
                    }
                    break;

                case 2: // '\002'
                    int k = i + 1;
                    i = k;
                    if (isProvidesMethod(element))
                    {
                        break;
                    }
                    i = k;
                    if (!flag)
                    {
                        warning((new StringBuilder()).append("Dagger will ignore qualifier annotations on methods that are not @Provides methods: ").append(Util.elementToString(element)).toString(), element);
                        i = k;
                    }
                    break;

                case 3: // '\003'
                    int l = i + 1;
                    i = l;
                    if (isInjectableConstructorParameter(element, map))
                    {
                        break;
                    }
                    i = l;
                    if (isProvidesMethodParameter(element, map))
                    {
                        break;
                    }
                    i = l;
                    if (!flag)
                    {
                        warning((new StringBuilder()).append("Dagger will ignore qualifier annotations on parameters that are not @Inject constructor parameters or @Provides method parameters: ").append(Util.elementToString(element)).toString(), element);
                        i = l;
                    }
                    break;
                }
            }
        } while (true);
        if (i > 1)
        {
            error((new StringBuilder()).append("Only one qualifier annotation is allowed per element: ").append(Util.elementToString(element)).toString(), element);
        }
    }

    private void validateScoping(Element element)
    {
        int i;
        boolean flag;
        Iterator iterator;
        if (element.getAnnotation(java/lang/SuppressWarnings) != null && Arrays.asList(((SuppressWarnings)element.getAnnotation(java/lang/SuppressWarnings)).value()).contains("scoping"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = 0;
        iterator = element.getAnnotationMirrors().iterator();
_L6:
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        if (((AnnotationMirror)iterator.next()).getAnnotationType().asElement().getAnnotation(javax/inject/Scope) == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        _cls1..SwitchMap.javax.lang.model.element.ElementKind[element.getKind().ordinal()];
        JVM INSTR tableswitch 2 4: default 136
    //                   2 172
    //                   3 136
    //                   4 229;
           goto _L1 _L2 _L1 _L3
_L1:
        error((new StringBuilder()).append("Scoping annotations are only allowed on concrete types and @Provides methods: ").append(Util.elementToString(element)).toString(), element);
        break; /* Loop/switch isn't completed */
_L2:
        int j = i + 1;
        i = j;
        if (isProvidesMethod(element))
        {
            break; /* Loop/switch isn't completed */
        }
        i = j;
        if (!flag)
        {
            warning((new StringBuilder()).append("Dagger will ignore scoping annotations on methods that are not @Provides methods: ").append(Util.elementToString(element)).toString(), element);
            i = j;
        }
        break; /* Loop/switch isn't completed */
_L3:
        if (element.getModifiers().contains(Modifier.ABSTRACT)) goto _L1; else goto _L4
_L4:
        i++;
        if (true) goto _L6; else goto _L5
_L5:
        if (i > 1)
        {
            error((new StringBuilder()).append("Only one scoping annotation is allowed per element: ").append(Util.elementToString(element)).toString(), element);
        }
        return;
    }

    private void warning(String s, Element element)
    {
        processingEnv.getMessager().printMessage(javax.tools.Diagnostic.Kind.WARNING, s, element);
    }

    public SourceVersion getSupportedSourceVersion()
    {
        return SourceVersion.latestSupported();
    }

    public boolean process(Set set, RoundEnvironment roundenvironment)
    {
        ArrayList arraylist = new ArrayList();
        set = new LinkedHashMap();
        getAllElements(roundenvironment, arraylist, set);
        roundenvironment = arraylist.iterator();
_L2:
        Element element;
        if (!roundenvironment.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        element = (Element)roundenvironment.next();
        validateProvides(element);
        validateScoping(element);
        validateQualifiers(element, set);
        continue; /* Loop/switch isn't completed */
        Util.CodeGenerationIncompleteException codegenerationincompleteexception;
        codegenerationincompleteexception;
        if (true) goto _L2; else goto _L1
_L1:
        return false;
    }
}
