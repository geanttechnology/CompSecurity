// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal.codegen;

import com.squareup.javawriter.JavaWriter;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import dagger.internal.Binding;
import dagger.internal.BindingsGroup;
import dagger.internal.Linker;
import dagger.internal.ModuleAdapter;
import dagger.internal.ProvidesBinding;
import dagger.internal.SetBinding;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.JavaFileObject;

// Referenced classes of package dagger.internal.codegen:
//            Util, GeneratorKeys, AdapterJavadocs

public final class ModuleAdapterProcessor extends AbstractProcessor
{

    private static final String BINDINGS_MAP = JavaWriter.type(dagger/internal/BindingsGroup, new String[0]);
    private static final List INVALID_RETURN_TYPES = Arrays.asList(new String[] {
        javax/inject/Provider.getCanonicalName(), dagger/Lazy.getCanonicalName()
    });
    private final LinkedHashMap remainingTypes = new LinkedHashMap();

    public ModuleAdapterProcessor()
    {
    }

    private String bindingClassName(ExecutableElement executableelement, Map map, Map map1)
    {
        String s = (String)map.get(executableelement);
        if (s != null)
        {
            return s;
        }
        String s1 = executableelement.getSimpleName().toString();
        s = "";
        AtomicInteger atomicinteger = (AtomicInteger)map1.get(s1);
        if (atomicinteger == null)
        {
            map1.put(s1, new AtomicInteger(2));
            map1 = s;
        } else
        {
            map1 = atomicinteger.toString();
            atomicinteger.incrementAndGet();
        }
        s = (new StringBuilder()).append(Character.toUpperCase(s1.charAt(0))).append(s1.substring(1)).toString();
        map1 = (new StringBuilder()).append(s).append("ProvidesAdapter").append(map1).toString();
        map.put(executableelement, map1);
        return map1;
    }

    private boolean checkForDependencies(List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            if (!((ExecutableElement)list.next()).getParameters().isEmpty())
            {
                return true;
            }
        }

        return false;
    }

    private boolean checkForMultibindings(List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            dagger.Provides.Type type = ((Provides)((ExecutableElement)list.next()).getAnnotation(dagger/Provides)).type();
            if (type == dagger.Provides.Type.SET || type == dagger.Provides.Type.SET_VALUES)
            {
                return true;
            }
        }

        return false;
    }

    private void error(String s, Element element)
    {
        processingEnv.getMessager().printMessage(javax.tools.Diagnostic.Kind.ERROR, s, element);
    }

    private Set findImports(boolean flag, boolean flag1, boolean flag2)
    {
        LinkedHashSet linkedhashset = new LinkedHashSet();
        linkedhashset.add(dagger/internal/ModuleAdapter.getCanonicalName());
        if (flag1)
        {
            linkedhashset.add(dagger/internal/BindingsGroup.getCanonicalName());
            linkedhashset.add(javax/inject/Provider.getCanonicalName());
            linkedhashset.add(dagger/internal/ProvidesBinding.getCanonicalName());
        }
        if (flag2)
        {
            linkedhashset.add(dagger/internal/Linker.getCanonicalName());
            linkedhashset.add(java/util/Set.getCanonicalName());
            linkedhashset.add(dagger/internal/Binding.getCanonicalName());
        }
        if (flag)
        {
            linkedhashset.add(dagger/internal/SetBinding.getCanonicalName());
        }
        return linkedhashset;
    }

    private Set findProvidesMethods(RoundEnvironment roundenvironment)
    {
        LinkedHashSet linkedhashset = new LinkedHashSet();
        linkedhashset.addAll(roundenvironment.getElementsAnnotatedWith(dagger/Provides));
        return linkedhashset;
    }

    private void generateModuleAdapter(Writer writer, String s, TypeElement typeelement, Map map, List list)
        throws IOException
    {
        String s1;
        boolean flag3;
        if (map == null)
        {
            error((new StringBuilder()).append(typeelement).append(" has @Provides methods but no @Module annotation").toString(), typeelement);
            return;
        }
        Object aobj1[] = (Object[])(Object[])map.get("staticInjections");
        Object aobj2[] = (Object[])(Object[])map.get("injects");
        Object aobj[] = (Object[])(Object[])map.get("includes");
        boolean flag1 = ((Boolean)map.get("overrides")).booleanValue();
        boolean flag2 = ((Boolean)map.get("complete")).booleanValue();
        flag3 = ((Boolean)map.get("library")).booleanValue();
        map = new JavaWriter(writer);
        boolean flag4 = checkForMultibindings(list);
        boolean flag5 = checkForDependencies(list);
        map.emitSingleLineComment("Code generated by dagger-compiler.  Do not edit.", new Object[0]);
        map.emitPackage(Util.getPackage(typeelement).getQualifiedName().toString());
        StringBuilder stringbuilder;
        int i;
        int j;
        boolean flag;
        if (!list.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        map.emitImports(findImports(flag4, flag, flag5));
        s1 = typeelement.getQualifiedName().toString();
        map.emitEmptyLine();
        map.emitJavadoc("A manager of modules and provides adapters allowing for proper linking and\ninstance provision of types served by {@code @Provides} methods.", new Object[0]);
        map.beginType(s, "class", EnumSet.of(Modifier.PUBLIC, Modifier.FINAL), JavaWriter.type(dagger/internal/ModuleAdapter, new String[] {
            s1
        }), new String[0]);
        stringbuilder = (new StringBuilder()).append("{ ");
        j = aobj2.length;
        i = 0;
        while (i < j) 
        {
            writer = (TypeMirror)aobj2[i];
            if (Util.isInterface(writer))
            {
                writer = GeneratorKeys.get(writer);
            } else
            {
                writer = GeneratorKeys.rawMembersKey(writer);
            }
            stringbuilder.append(JavaWriter.stringLiteral(writer)).append(", ");
            i++;
        }
        stringbuilder.append("}");
        map.emitField("String[]", "INJECTS", EnumSet.of(Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL), stringbuilder.toString());
        writer = (new StringBuilder()).append("{ ");
        j = aobj1.length;
        for (i = 0; i < j; i++)
        {
            writer.append(Util.typeToString((TypeMirror)aobj1[i])).append(".class, ");
        }

        writer.append("}");
        map.emitField("Class<?>[]", "STATIC_INJECTIONS", EnumSet.of(Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL), writer.toString());
        writer = (new StringBuilder()).append("{ ");
        j = aobj.length;
        i = 0;
        while (i < j) 
        {
            Object obj = aobj[i];
            if (!(obj instanceof TypeMirror))
            {
                processingEnv.getMessager().printMessage(javax.tools.Diagnostic.Kind.WARNING, (new StringBuilder()).append("Unexpected value: ").append(obj).append(" in includes of ").append(typeelement).toString(), typeelement);
            } else
            {
                writer.append(Util.typeToString((TypeMirror)obj)).append(".class, ");
            }
            i++;
        }
        writer.append("}");
        map.emitField("Class<?>[]", "INCLUDES", EnumSet.of(Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL), writer.toString());
        map.emitEmptyLine();
        map.beginMethod(null, s, EnumSet.of(Modifier.PUBLIC), new String[0]);
        map.emitStatement("super(%s.class, INJECTS, STATIC_INJECTIONS, %s /*overrides*/, INCLUDES, %s /*complete*/, %s /*library*/)", new Object[] {
            s1, Boolean.valueOf(flag1), Boolean.valueOf(flag2), Boolean.valueOf(flag3)
        });
        map.endMethod();
        writer = Util.getNoArgsConstructor(typeelement);
        if (writer != null && Util.isCallableConstructor(writer))
        {
            map.emitEmptyLine();
            map.emitAnnotation(java/lang/Override);
            map.beginMethod(s1, "newModule", EnumSet.of(Modifier.PUBLIC), new String[0]);
            map.emitStatement("return new %s()", new Object[] {
                s1
            });
            map.endMethod();
        }
        writer = new LinkedHashMap();
        s = new LinkedHashMap();
        if (list.isEmpty()) goto _L2; else goto _L1
_L1:
        map.emitEmptyLine();
        map.emitJavadoc("Used internally obtain dependency information, such as for cyclical\ngraph detection.", new Object[0]);
        map.emitAnnotation(java/lang/Override);
        map.beginMethod("void", "getBindings", EnumSet.of(Modifier.PUBLIC), new String[] {
            BINDINGS_MAP, "bindings", s1, "module"
        });
        typeelement = list.iterator();
_L4:
        if (typeelement.hasNext())
        {
            ExecutableElement executableelement = (ExecutableElement)typeelement.next();
            Provides provides = (Provides)executableelement.getAnnotation(dagger/Provides);
            static class _cls1
            {

                static final int $SwitchMap$dagger$Provides$Type[];
                static final int $SwitchMap$javax$lang$model$element$ElementKind[];

                static 
                {
                    $SwitchMap$dagger$Provides$Type = new int[dagger.Provides.Type.values().length];
                    try
                    {
                        $SwitchMap$dagger$Provides$Type[dagger.Provides.Type.UNIQUE.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$dagger$Provides$Type[dagger.Provides.Type.SET.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$dagger$Provides$Type[dagger.Provides.Type.SET_VALUES.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    $SwitchMap$javax$lang$model$element$ElementKind = new int[ElementKind.values().length];
                    try
                    {
                        $SwitchMap$javax$lang$model$element$ElementKind[ElementKind.CLASS.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.dagger.Provides.Type[provides.type().ordinal()])
            {
            default:
                throw new AssertionError((new StringBuilder()).append("Unknown @Provides type ").append(provides.type()).toString());

            case 1: // '\001'
                map.emitStatement("bindings.contributeProvidesBinding(%s, new %s(module))", new Object[] {
                    JavaWriter.stringLiteral(GeneratorKeys.get(executableelement)), bindingClassName(executableelement, writer, s)
                });
                break;

            case 2: // '\002'
                map.emitStatement("SetBinding.add(bindings, %s, new %s(module))", new Object[] {
                    JavaWriter.stringLiteral(GeneratorKeys.getSetKey(executableelement)), bindingClassName(executableelement, writer, s)
                });
                break;

            case 3: // '\003'
                map.emitStatement("SetBinding.add(bindings, %s, new %s(module))", new Object[] {
                    JavaWriter.stringLiteral(GeneratorKeys.get(executableelement)), bindingClassName(executableelement, writer, s)
                });
                break;
            }
            continue; /* Loop/switch isn't completed */
        }
        map.endMethod();
_L2:
        for (typeelement = list.iterator(); typeelement.hasNext(); generateProvidesAdapter(map, (ExecutableElement)typeelement.next(), writer, s, flag3)) { }
        map.endType();
        map.close();
        break; /* Loop/switch isn't completed */
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void generateProvidesAdapter(JavaWriter javawriter, ExecutableElement executableelement, Map map, Map map1, boolean flag)
        throws IOException
    {
        String s = executableelement.getSimpleName().toString();
        String s1 = Util.typeToString(executableelement.getEnclosingElement().asType());
        String s2 = bindingClassName(executableelement, map, map1);
        map1 = Util.typeToString(executableelement.getReturnType());
        map = executableelement.getParameters();
        boolean flag2;
        if (!map.isEmpty())
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        javawriter.emitEmptyLine();
        javawriter.emitJavadoc(AdapterJavadocs.bindingTypeDocs(map1, false, false, flag2), new Object[0]);
        javawriter.beginType(s2, "class", EnumSet.of(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL), JavaWriter.type(dagger/internal/ProvidesBinding, new String[] {
            map1
        }), new String[] {
            JavaWriter.type(javax/inject/Provider, new String[] {
                map1
            })
        });
        javawriter.emitField(s1, "module", EnumSet.of(Modifier.PRIVATE, Modifier.FINAL));
        Element element;
        for (Iterator iterator = map.iterator(); iterator.hasNext(); javawriter.emitField(JavaWriter.type(dagger/internal/Binding, new String[] {
    Util.typeToString(element.asType())
}), parameterName(element), EnumSet.of(Modifier.PRIVATE)))
        {
            element = (Element)iterator.next();
        }

        javawriter.emitEmptyLine();
        javawriter.beginMethod(null, s2, EnumSet.of(Modifier.PUBLIC), new String[] {
            s1, "module"
        });
        boolean flag1;
        if (executableelement.getAnnotation(javax/inject/Singleton) != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        s2 = JavaWriter.stringLiteral(GeneratorKeys.get(executableelement));
        if (flag1)
        {
            executableelement = "IS_SINGLETON";
        } else
        {
            executableelement = "NOT_SINGLETON";
        }
        javawriter.emitStatement("super(%s, %s, %s, %s)", new Object[] {
            s2, executableelement, JavaWriter.stringLiteral(s1), JavaWriter.stringLiteral(s)
        });
        javawriter.emitStatement("this.module = module", new Object[0]);
        javawriter.emitStatement("setLibrary(%s)", new Object[] {
            Boolean.valueOf(flag)
        });
        javawriter.endMethod();
        if (flag2)
        {
            javawriter.emitEmptyLine();
            javawriter.emitJavadoc("Used internally to link bindings/providers together at run time\naccording to their dependency graph.", new Object[0]);
            javawriter.emitAnnotation(java/lang/Override);
            javawriter.emitAnnotation(java/lang/SuppressWarnings, JavaWriter.stringLiteral("unchecked"));
            javawriter.beginMethod("void", "attach", EnumSet.of(Modifier.PUBLIC), new String[] {
                dagger/internal/Linker.getCanonicalName(), "linker"
            });
            VariableElement variableelement;
            String s3;
            for (executableelement = map.iterator(); executableelement.hasNext(); javawriter.emitStatement("%s = (%s) linker.requestBinding(%s, %s.class, getClass().getClassLoader())", new Object[] {
    parameterName(variableelement), javawriter.compressType(JavaWriter.type(dagger/internal/Binding, new String[] {
        Util.typeToString(variableelement.asType())
    })), JavaWriter.stringLiteral(s3), javawriter.compressType(s1)
}))
            {
                variableelement = (VariableElement)executableelement.next();
                s3 = GeneratorKeys.get(variableelement);
            }

            javawriter.endMethod();
            javawriter.emitEmptyLine();
            javawriter.emitJavadoc("Used internally obtain dependency information, such as for cyclical\ngraph detection.", new Object[0]);
            javawriter.emitAnnotation(java/lang/Override);
            executableelement = JavaWriter.type(java/util/Set, new String[] {
                "Binding<?>"
            });
            javawriter.beginMethod("void", "getDependencies", EnumSet.of(Modifier.PUBLIC), new String[] {
                executableelement, "getBindings", executableelement, "injectMembersBindings"
            });
            for (executableelement = map.iterator(); executableelement.hasNext(); javawriter.emitStatement("getBindings.add(%s)", new Object[] {
    parameterName((Element)executableelement.next())
})) { }
            javawriter.endMethod();
        }
        javawriter.emitEmptyLine();
        javawriter.emitJavadoc("Returns the fully provisioned instance satisfying the contract for\n{@code Provider<%s>}.", new Object[] {
            map1
        });
        javawriter.emitAnnotation(java/lang/Override);
        javawriter.beginMethod(map1, "get", EnumSet.of(Modifier.PUBLIC), new String[0]);
        executableelement = new StringBuilder();
        flag1 = true;
        map = map.iterator();
        while (map.hasNext()) 
        {
            map1 = (Element)map.next();
            if (!flag1)
            {
                executableelement.append(", ");
            } else
            {
                flag1 = false;
            }
            executableelement.append(String.format("%s.get()", new Object[] {
                parameterName(map1)
            }));
        }
        javawriter.emitStatement("return module.%s(%s)", new Object[] {
            s, executableelement.toString()
        });
        javawriter.endMethod();
        javawriter.endType();
    }

    private String parameterName(Element element)
    {
        if (element.getSimpleName().contentEquals("module"))
        {
            return (new StringBuilder()).append("parameter_").append(element.getSimpleName().toString()).toString();
        } else
        {
            return element.getSimpleName().toString();
        }
    }

    private Map providerMethodsByClass(RoundEnvironment roundenvironment)
    {
        Elements elements = processingEnv.getElementUtils();
        Types types = processingEnv.getTypeUtils();
        HashMap hashmap = new HashMap();
        Iterator iterator = findProvidesMethods(roundenvironment).iterator();
label0:
        do
        {
            TypeElement typeelement1;
            ExecutableElement executableelement;
label1:
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                Element element = (Element)iterator.next();
                Object obj1;
                switch (_cls1..SwitchMap.javax.lang.model.element.ElementKind[element.getEnclosingElement().getKind().ordinal()])
                {
                default:
                    error((new StringBuilder()).append("Unexpected @Provides on ").append(Util.elementToString(element)).toString(), element);
                    continue;

                case 1: // '\001'
                    typeelement1 = (TypeElement)element.getEnclosingElement();
                    obj1 = typeelement1.getModifiers();
                    break;
                }
                if (((Set) (obj1)).contains(Modifier.PRIVATE) || ((Set) (obj1)).contains(Modifier.ABSTRACT))
                {
                    error((new StringBuilder()).append("Classes declaring @Provides methods must not be private or abstract: ").append(typeelement1.getQualifiedName()).toString(), typeelement1);
                    continue;
                }
                obj1 = element.getModifiers();
                if (((Set) (obj1)).contains(Modifier.PRIVATE) || ((Set) (obj1)).contains(Modifier.ABSTRACT) || ((Set) (obj1)).contains(Modifier.STATIC))
                {
                    error((new StringBuilder()).append("@Provides methods must not be private, abstract or static: ").append(typeelement1.getQualifiedName()).append(".").append(element).toString(), element);
                    continue;
                }
                executableelement = (ExecutableElement)element;
                if (!executableelement.getThrownTypes().isEmpty())
                {
                    error((new StringBuilder()).append("@Provides methods must not have a throws clause: ").append(typeelement1.getQualifiedName()).append(".").append(element).toString(), element);
                    continue;
                }
                obj1 = types.erasure(executableelement.getReturnType());
                if (((TypeMirror) (obj1)).getKind().equals(TypeKind.ERROR))
                {
                    break label1;
                }
                Iterator iterator1 = INVALID_RETURN_TYPES.iterator();
                TypeElement typeelement2;
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break label1;
                    }
                    typeelement2 = elements.getTypeElement((String)iterator1.next());
                } while (typeelement2 == null || !types.isSameType(((TypeMirror) (obj1)), types.erasure(typeelement2.asType())));
                error(String.format("@Provides method must not return %s directly: %s.%s", new Object[] {
                    typeelement2, typeelement1.getQualifiedName(), element
                }), element);
                continue;
            }
            List list = (List)hashmap.get(typeelement1.getQualifiedName().toString());
            Object obj = list;
            if (list == null)
            {
                obj = new ArrayList();
                hashmap.put(typeelement1.getQualifiedName().toString(), obj);
            }
            ((List) (obj)).add(executableelement);
        } while (true);
        TypeMirror typemirror = elements.getTypeElement("java.lang.Object").asType();
        roundenvironment = roundenvironment.getElementsAnnotatedWith(dagger/Module).iterator();
        do
        {
            if (!roundenvironment.hasNext())
            {
                break;
            }
            Object obj2 = (Element)roundenvironment.next();
            if (!((Element) (obj2)).getKind().equals(ElementKind.CLASS))
            {
                error((new StringBuilder()).append("Modules must be classes: ").append(Util.elementToString(((Element) (obj2)))).toString(), ((Element) (obj2)));
            } else
            {
                TypeElement typeelement = (TypeElement)obj2;
                if (!typeelement.getSuperclass().equals(typemirror))
                {
                    error((new StringBuilder()).append("Modules must not extend from other classes: ").append(Util.elementToString(((Element) (obj2)))).toString(), ((Element) (obj2)));
                }
                obj2 = typeelement.getQualifiedName().toString();
                if (!hashmap.containsKey(obj2))
                {
                    hashmap.put(obj2, new ArrayList());
                }
            }
        } while (true);
        return hashmap;
    }

    public SourceVersion getSupportedSourceVersion()
    {
        return SourceVersion.latestSupported();
    }

    public boolean process(Set set, RoundEnvironment roundenvironment)
    {
        remainingTypes.putAll(providerMethodsByClass(roundenvironment));
        set = remainingTypes.keySet().iterator();
_L5:
        if (!set.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        String s = (String)set.next();
        obj = processingEnv.getElementUtils().getTypeElement(s);
        obj1 = (List)remainingTypes.get(s);
        Map map = Util.getAnnotation(dagger/Module, ((Element) (obj)));
        StringWriter stringwriter = new StringWriter();
        String s1 = Util.adapterName(((TypeElement) (obj)), "$$ModuleAdapter");
        generateModuleAdapter(stringwriter, s1, ((TypeElement) (obj)), map, ((List) (obj1)));
        obj1 = processingEnv.getFiler().createSourceFile(s1, new Element[] {
            obj
        }).openWriter();
        ((Writer) (obj1)).append(stringwriter.getBuffer());
        ((Writer) (obj1)).close();
_L3:
        set.remove();
        continue; /* Loop/switch isn't completed */
        obj;
        continue; /* Loop/switch isn't completed */
        IOException ioexception;
        ioexception;
        error((new StringBuilder()).append("Code gen failed: ").append(ioexception).toString(), ((Element) (obj)));
        if (true) goto _L3; else goto _L2
_L2:
        if (roundenvironment.processingOver() && remainingTypes.size() > 0)
        {
            processingEnv.getMessager().printMessage(javax.tools.Diagnostic.Kind.ERROR, (new StringBuilder()).append("Could not find types required by provides methods for ").append(remainingTypes.keySet()).toString());
        }
        return false;
        if (true) goto _L5; else goto _L4
_L4:
    }

}
