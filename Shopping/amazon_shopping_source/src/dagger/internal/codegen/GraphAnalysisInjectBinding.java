// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal.codegen;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;

// Referenced classes of package dagger.internal.codegen:
//            GeneratorKeys, Util

final class GraphAnalysisInjectBinding extends Binding
{

    private final Binding bindings[];
    private final List keys;
    private final String supertypeKey;
    private final TypeElement type;

    private GraphAnalysisInjectBinding(String s, String s1, TypeElement typeelement, List list, String s2)
    {
        boolean flag;
        if (typeelement.getAnnotation(javax/inject/Singleton) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        super(s, s1, flag, typeelement.getQualifiedName().toString());
        type = typeelement;
        keys = list;
        bindings = new Binding[list.size()];
        supertypeKey = s2;
    }

    static GraphAnalysisInjectBinding create(TypeElement typeelement, boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        boolean flag1 = false;
        boolean flag2 = false;
        Object obj = typeelement.getEnclosedElements().iterator();
label0:
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Object obj1 = (Element)((Iterator) (obj)).next();
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
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$javax$lang$model$element$ElementKind[ElementKind.CONSTRUCTOR.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            List list;
            switch (_cls1..SwitchMap.javax.lang.model.element.ElementKind[((Element) (obj1)).getKind().ordinal()])
            {
            default:
                if (hasAtInject(((Element) (obj1))))
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("Unexpected @Inject annotation on ").append(obj1).toString());
                }
                continue;

            case 1: // '\001'
                if (hasAtInject(((Element) (obj1))) && !((Element) (obj1)).getModifiers().contains(Modifier.STATIC))
                {
                    arraylist.add(GeneratorKeys.get((VariableElement)obj1));
                }
                continue;

            case 2: // '\002'
                list = ((ExecutableElement)obj1).getParameters();
                break;
            }
            if (hasAtInject(((Element) (obj1))))
            {
                if (hasAtSingleton(((Element) (obj1))))
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("Singleton annotations have no effect on constructors. Did you mean to annotate the class? ").append(typeelement.getQualifiedName().toString()).toString());
                }
                if (flag1)
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("Too many injectable constructors on ").append(typeelement.getQualifiedName().toString()).toString());
                }
                boolean flag3 = true;
                obj1 = list.iterator();
                do
                {
                    flag1 = flag3;
                    if (!((Iterator) (obj1)).hasNext())
                    {
                        continue label0;
                    }
                    arraylist.add(GeneratorKeys.get((VariableElement)((Iterator) (obj1)).next()));
                } while (true);
            }
            if (list.isEmpty())
            {
                flag2 = true;
            }
        } while (true);
        if (!flag1 && arraylist.isEmpty() && flag)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("No injectable members on ").append(typeelement.getQualifiedName().toString()).append(". Do you want to add an injectable constructor?").toString());
        }
        obj = Util.getApplicationSupertype(typeelement);
        String s;
        if (obj != null)
        {
            obj = GeneratorKeys.rawMembersKey(((javax.lang.model.type.TypeMirror) (obj)));
        } else
        {
            obj = null;
        }
        if (flag1 || flag2 && !arraylist.isEmpty())
        {
            s = GeneratorKeys.get(typeelement.asType());
        } else
        {
            s = null;
        }
        return new GraphAnalysisInjectBinding(s, GeneratorKeys.rawMembersKey(typeelement.asType()), typeelement, arraylist, ((String) (obj)));
    }

    private static boolean hasAtInject(Element element)
    {
        return element.getAnnotation(javax/inject/Inject) != null;
    }

    private static boolean hasAtSingleton(Element element)
    {
        return element.getAnnotation(javax/inject/Singleton) != null;
    }

    public void attach(Linker linker)
    {
        String s = type.getQualifiedName().toString();
        for (int i = 0; i < keys.size(); i++)
        {
            bindings[i] = linker.requestBinding((String)keys.get(i), s, getClass().getClassLoader());
        }

        if (supertypeKey != null)
        {
            linker.requestBinding(supertypeKey, s, getClass().getClassLoader(), false, true);
        }
    }

    public Object get()
    {
        throw new AssertionError("Compile-time binding should never be called to inject.");
    }

    public void getDependencies(Set set, Set set1)
    {
        Collections.addAll(set, bindings);
    }

    public void injectMembers(Object obj)
    {
        throw new AssertionError("Compile-time binding should never be called to inject.");
    }
}
