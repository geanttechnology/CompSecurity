// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package butterknife.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package butterknife.internal:
//            ViewBindings, FieldCollectionViewBinding, FieldResourceBinding, FieldViewBinding, 
//            ViewBinding, ListenerClass, ListenerMethod, MethodViewBinding, 
//            Parameter

final class BindingClass
{

    private final String className;
    private final String classPackage;
    private final Map collectionBindings = new LinkedHashMap();
    private String parentViewBinder;
    private final List resourceBindings = new ArrayList();
    private final String targetClass;
    private final Map viewIdMap = new LinkedHashMap();

    BindingClass(String s, String s1, String s2)
    {
        classPackage = s;
        className = s1;
        targetClass = s2;
    }

    private void emitBindMethod(StringBuilder stringbuilder)
    {
        stringbuilder.append("  @Override ").append("public void bind(final Finder finder, final T target, Object source) {\n");
        if (parentViewBinder != null)
        {
            stringbuilder.append("    super.bind(finder, target, source);\n\n");
        }
        if (!viewIdMap.isEmpty() || !collectionBindings.isEmpty())
        {
            stringbuilder.append("    View view;\n");
            for (Iterator iterator = viewIdMap.values().iterator(); iterator.hasNext(); emitViewBindings(stringbuilder, (ViewBindings)iterator.next())) { }
            java.util.Map.Entry entry;
            for (Iterator iterator1 = collectionBindings.entrySet().iterator(); iterator1.hasNext(); emitCollectionBinding(stringbuilder, (FieldCollectionViewBinding)entry.getKey(), (int[])entry.getValue()))
            {
                entry = (java.util.Map.Entry)iterator1.next();
            }

        }
        if (!resourceBindings.isEmpty())
        {
            stringbuilder.append("    Resources res = finder.getContext(source).getResources();\n");
            FieldResourceBinding fieldresourcebinding;
            for (Iterator iterator2 = resourceBindings.iterator(); iterator2.hasNext(); stringbuilder.append("    target.").append(fieldresourcebinding.getName()).append(" = res.").append(fieldresourcebinding.getMethod()).append('(').append(fieldresourcebinding.getId()).append(");\n"))
            {
                fieldresourcebinding = (FieldResourceBinding)iterator2.next();
            }

        }
        stringbuilder.append("  }\n");
    }

    private void emitCollectionBinding(StringBuilder stringbuilder, FieldCollectionViewBinding fieldcollectionviewbinding, int ai[])
    {
        stringbuilder.append("    target.").append(fieldcollectionviewbinding.getName()).append(" = ");
        static class _cls1
        {

            static final int $SwitchMap$butterknife$internal$FieldCollectionViewBinding$Kind[];

            static 
            {
                $SwitchMap$butterknife$internal$FieldCollectionViewBinding$Kind = new int[FieldCollectionViewBinding.Kind.values().length];
                try
                {
                    $SwitchMap$butterknife$internal$FieldCollectionViewBinding$Kind[FieldCollectionViewBinding.Kind.ARRAY.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$butterknife$internal$FieldCollectionViewBinding$Kind[FieldCollectionViewBinding.Kind.LIST.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.butterknife.internal.FieldCollectionViewBinding.Kind[fieldcollectionviewbinding.getKind().ordinal()])
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Unknown kind: ").append(fieldcollectionviewbinding.getKind()).toString());

        case 2: // '\002'
            break MISSING_BLOCK_LABEL_191;

        case 1: // '\001'
            stringbuilder.append("Finder.arrayOf(");
            break;
        }
_L1:
        int i = 0;
        while (i < ai.length) 
        {
            if (i > 0)
            {
                stringbuilder.append(',');
            }
            StringBuilder stringbuilder1 = stringbuilder.append("\n        finder.<").append(fieldcollectionviewbinding.getType()).append(">");
            String s;
            if (fieldcollectionviewbinding.isRequired())
            {
                s = "findRequiredView";
            } else
            {
                s = "findOptionalView";
            }
            stringbuilder1.append(s).append("(source, ").append(ai[i]).append(", \"");
            emitHumanDescription(stringbuilder, Collections.singleton(fieldcollectionviewbinding));
            stringbuilder.append("\")");
            i++;
        }
        break MISSING_BLOCK_LABEL_208;
        stringbuilder.append("Finder.listOf(");
          goto _L1
        stringbuilder.append("\n    );\n");
        return;
    }

    private void emitFieldBindings(StringBuilder stringbuilder, ViewBindings viewbindings)
    {
        Collection collection = viewbindings.getFieldBindings();
        if (!collection.isEmpty())
        {
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) 
            {
                FieldViewBinding fieldviewbinding = (FieldViewBinding)iterator.next();
                stringbuilder.append("    target.").append(fieldviewbinding.getName()).append(" = ");
                if (fieldviewbinding.requiresCast())
                {
                    stringbuilder.append("finder.castView(view").append(", ").append(viewbindings.getId()).append(", \"");
                    emitHumanDescription(stringbuilder, collection);
                    stringbuilder.append("\");\n");
                } else
                {
                    stringbuilder.append("view;\n");
                }
            }
        }
    }

    static void emitHumanDescription(StringBuilder stringbuilder, Collection collection)
    {
        Iterator iterator;
label0:
        {
            iterator = collection.iterator();
            switch (collection.size())
            {
            default:
                int j = collection.size();
                for (int i = 0; i < j; i++)
                {
                    if (i != 0)
                    {
                        stringbuilder.append(", ");
                    }
                    if (i == j - 1)
                    {
                        stringbuilder.append("and ");
                    }
                    stringbuilder.append(((ViewBinding)iterator.next()).getDescription());
                }

                break;

            case 2: // '\002'
                break label0;

            case 1: // '\001'
                stringbuilder.append(((ViewBinding)iterator.next()).getDescription());
                break;
            }
            return;
        }
        stringbuilder.append(((ViewBinding)iterator.next()).getDescription()).append(" and ").append(((ViewBinding)iterator.next()).getDescription());
    }

    private void emitMethodBindings(StringBuilder stringbuilder, ViewBindings viewbindings)
    {
        Object obj = viewbindings.getMethodBindings();
        if (!((Map) (obj)).isEmpty())
        {
            boolean flag1 = viewbindings.getRequiredBindings().isEmpty();
            if (flag1)
            {
                stringbuilder.append("    if (view != null) {\n");
                viewbindings = "  ";
            } else
            {
                viewbindings = "";
            }
            for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); stringbuilder.append(viewbindings).append("      });\n"))
            {
                Object obj1 = (java.util.Map.Entry)((Iterator) (obj)).next();
                Object obj2 = (ListenerClass)((java.util.Map.Entry) (obj1)).getKey();
                obj1 = (Map)((java.util.Map.Entry) (obj1)).getValue();
                boolean flag;
                if (!"android.view.View".equals(((ListenerClass) (obj2)).targetType()))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                stringbuilder.append(viewbindings).append("    ");
                if (flag)
                {
                    stringbuilder.append("((").append(((ListenerClass) (obj2)).targetType());
                    if (((ListenerClass) (obj2)).genericArguments() > 0)
                    {
                        stringbuilder.append('<');
                        for (int j = 0; j < ((ListenerClass) (obj2)).genericArguments(); j++)
                        {
                            if (j > 0)
                            {
                                stringbuilder.append(", ");
                            }
                            stringbuilder.append('?');
                        }

                        stringbuilder.append('>');
                    }
                    stringbuilder.append(") ");
                }
                stringbuilder.append("view");
                if (flag)
                {
                    stringbuilder.append(')');
                }
                stringbuilder.append('.').append(((ListenerClass) (obj2)).setter()).append("(\n");
                stringbuilder.append(viewbindings).append("      new ").append(((ListenerClass) (obj2)).type()).append("() {\n");
                for (obj2 = getListenerMethods(((ListenerClass) (obj2))).iterator(); ((Iterator) (obj2)).hasNext(); stringbuilder.append(viewbindings).append("        }\n"))
                {
                    ListenerMethod listenermethod = (ListenerMethod)((Iterator) (obj2)).next();
                    stringbuilder.append(viewbindings).append("        @Override public ").append(listenermethod.returnType()).append(' ').append(listenermethod.name()).append("(\n");
                    String as[] = listenermethod.parameters();
                    int i = 0;
                    for (int k = as.length; i < k; i++)
                    {
                        stringbuilder.append(viewbindings).append("          ").append(as[i]).append(" p").append(i);
                        if (i < k - 1)
                        {
                            stringbuilder.append(',');
                        }
                        stringbuilder.append('\n');
                    }

                    stringbuilder.append(viewbindings).append("        ) {\n");
                    stringbuilder.append(viewbindings).append("          ");
                    if (!"void".equals(listenermethod.returnType()))
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                    if (i != 0)
                    {
                        stringbuilder.append("return ");
                    }
                    if (((Map) (obj1)).containsKey(listenermethod))
                    {
                        Iterator iterator = ((Set)((Map) (obj1)).get(listenermethod)).iterator();
                        do
                        {
                            if (!iterator.hasNext())
                            {
                                break;
                            }
                            MethodViewBinding methodviewbinding = (MethodViewBinding)iterator.next();
                            stringbuilder.append("target.").append(methodviewbinding.getName()).append('(');
                            List list = methodviewbinding.getParameters();
                            String as1[] = listenermethod.parameters();
                            int l = list.size();
                            i = 0;
                            while (i < l) 
                            {
                                Parameter parameter = (Parameter)list.get(i);
                                int i1 = parameter.getListenerPosition();
                                if (parameter.requiresCast(as1[i1]))
                                {
                                    stringbuilder.append("finder.<").append(parameter.getType()).append(">castParam(p").append(i1).append(", \"").append(listenermethod.name()).append("\", ").append(i1).append(", \"").append(methodviewbinding.getName()).append("\", ").append(i).append(")");
                                } else
                                {
                                    stringbuilder.append('p').append(i1);
                                }
                                if (i < l - 1)
                                {
                                    stringbuilder.append(", ");
                                }
                                i++;
                            }
                            stringbuilder.append(");");
                            if (iterator.hasNext())
                            {
                                stringbuilder.append("\n").append("          ");
                            }
                        } while (true);
                    } else
                    if (i != 0)
                    {
                        stringbuilder.append(listenermethod.defaultReturn()).append(';');
                    }
                    stringbuilder.append('\n');
                }

            }

            if (flag1)
            {
                stringbuilder.append("    }\n");
                return;
            }
        }
    }

    private void emitUnbindMethod(StringBuilder stringbuilder)
    {
        stringbuilder.append("  @Override public void unbind(T target) {\n");
        if (parentViewBinder != null)
        {
            stringbuilder.append("    super.unbind(target);\n\n");
        }
        for (Iterator iterator = viewIdMap.values().iterator(); iterator.hasNext();)
        {
            Iterator iterator2 = ((ViewBindings)iterator.next()).getFieldBindings().iterator();
            while (iterator2.hasNext()) 
            {
                FieldViewBinding fieldviewbinding = (FieldViewBinding)iterator2.next();
                stringbuilder.append("    target.").append(fieldviewbinding.getName()).append(" = null;\n");
            }
        }

        FieldCollectionViewBinding fieldcollectionviewbinding;
        for (Iterator iterator1 = collectionBindings.keySet().iterator(); iterator1.hasNext(); stringbuilder.append("    target.").append(fieldcollectionviewbinding.getName()).append(" = null;\n"))
        {
            fieldcollectionviewbinding = (FieldCollectionViewBinding)iterator1.next();
        }

        stringbuilder.append("  }\n");
    }

    private void emitViewBindings(StringBuilder stringbuilder, ViewBindings viewbindings)
    {
        stringbuilder.append("    view = ");
        List list = viewbindings.getRequiredBindings();
        if (list.isEmpty())
        {
            stringbuilder.append("finder.findOptionalView(source, ").append(viewbindings.getId()).append(", null);\n");
        } else
        if (viewbindings.getId() == -1)
        {
            stringbuilder.append("target;\n");
        } else
        {
            stringbuilder.append("finder.findRequiredView(source, ").append(viewbindings.getId()).append(", \"");
            emitHumanDescription(stringbuilder, list);
            stringbuilder.append("\");\n");
        }
        emitFieldBindings(stringbuilder, viewbindings);
        emitMethodBindings(stringbuilder, viewbindings);
    }

    static List getListenerMethods(ListenerClass listenerclass)
    {
        ArrayList arraylist;
        ListenerMethod listenermethod;
        int i;
        if (listenerclass.method().length == 1)
        {
            return Arrays.asList(listenerclass.method());
        }
        Enum aenum[];
        Enum enum;
        int j;
        try
        {
            arraylist = new ArrayList();
            listenerclass = listenerclass.callbacks();
            aenum = (Enum[])listenerclass.getEnumConstants();
            j = aenum.length;
        }
        // Misplaced declaration of an exception variable
        catch (ListenerClass listenerclass)
        {
            throw new AssertionError(listenerclass);
        }
        i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        enum = aenum[i];
        listenermethod = (ListenerMethod)listenerclass.getField(enum.name()).getAnnotation(butterknife/internal/ListenerMethod);
        if (listenermethod != null)
        {
            break MISSING_BLOCK_LABEL_148;
        }
        throw new IllegalStateException(String.format("@%s's %s.%s missing @%s annotation.", new Object[] {
            listenerclass.getEnclosingClass().getSimpleName(), listenerclass.getSimpleName(), enum.name(), butterknife/internal/ListenerMethod.getSimpleName()
        }));
        arraylist.add(listenermethod);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return arraylist;
    }

    private ViewBindings getOrCreateViewBindings(int i)
    {
        ViewBindings viewbindings1 = (ViewBindings)viewIdMap.get(Integer.valueOf(i));
        ViewBindings viewbindings = viewbindings1;
        if (viewbindings1 == null)
        {
            viewbindings = new ViewBindings(i);
            viewIdMap.put(Integer.valueOf(i), viewbindings);
        }
        return viewbindings;
    }

    void addField(int i, FieldViewBinding fieldviewbinding)
    {
        getOrCreateViewBindings(i).addFieldBinding(fieldviewbinding);
    }

    void addFieldCollection(int ai[], FieldCollectionViewBinding fieldcollectionviewbinding)
    {
        collectionBindings.put(fieldcollectionviewbinding, ai);
    }

    boolean addMethod(int i, ListenerClass listenerclass, ListenerMethod listenermethod, MethodViewBinding methodviewbinding)
    {
        ViewBindings viewbindings = getOrCreateViewBindings(i);
        if (viewbindings.hasMethodBinding(listenerclass, listenermethod) && !"void".equals(listenermethod.returnType()))
        {
            return false;
        } else
        {
            viewbindings.addMethodBinding(listenerclass, listenermethod, methodviewbinding);
            return true;
        }
    }

    void addResource(FieldResourceBinding fieldresourcebinding)
    {
        resourceBindings.add(fieldresourcebinding);
    }

    String brewJava()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("// Generated code from Butter Knife. Do not modify!\n");
        stringbuilder.append("package ").append(classPackage).append(";\n\n");
        if (!resourceBindings.isEmpty())
        {
            stringbuilder.append("import android.content.res.Resources;\n");
        }
        if (!viewIdMap.isEmpty() || !collectionBindings.isEmpty())
        {
            stringbuilder.append("import android.view.View;\n");
        }
        stringbuilder.append("import butterknife.ButterKnife.Finder;\n");
        if (parentViewBinder == null)
        {
            stringbuilder.append("import butterknife.ButterKnife.ViewBinder;\n");
        }
        stringbuilder.append('\n');
        stringbuilder.append("public class ").append(className);
        stringbuilder.append("<T extends ").append(targetClass).append(">");
        if (parentViewBinder != null)
        {
            stringbuilder.append(" extends ").append(parentViewBinder).append("<T>");
        } else
        {
            stringbuilder.append(" implements ViewBinder<T>");
        }
        stringbuilder.append(" {\n");
        emitBindMethod(stringbuilder);
        stringbuilder.append('\n');
        emitUnbindMethod(stringbuilder);
        stringbuilder.append("}\n");
        return stringbuilder.toString();
    }

    String getFqcn()
    {
        return (new StringBuilder()).append(classPackage).append(".").append(className).toString();
    }

    ViewBindings getViewBinding(int i)
    {
        return (ViewBindings)viewIdMap.get(Integer.valueOf(i));
    }

    void setParentViewBinder(String s)
    {
        parentViewBinder = s;
    }
}
