// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal.codegen;

import com.squareup.javawriter.JavaWriter;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.StaticInjection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.tools.JavaFileObject;

// Referenced classes of package dagger.internal.codegen:
//            Util, AdapterJavadocs, GeneratorKeys

public final class InjectAdapterProcessor extends AbstractProcessor
{
    static class InjectedClass
    {

        final ExecutableElement constructor;
        final List fields;
        final List staticFields;
        final TypeElement type;

        InjectedClass(TypeElement typeelement, List list, ExecutableElement executableelement, List list1)
        {
            type = typeelement;
            staticFields = list;
            constructor = executableelement;
            fields = list1;
        }
    }


    private final Set remainingTypeNames = new LinkedHashSet();

    public InjectAdapterProcessor()
    {
    }

    private boolean allTypesExist(Collection collection)
    {
        for (collection = collection.iterator(); collection.hasNext();)
        {
            if (((Element)collection.next()).asType().getKind() == TypeKind.ERROR)
            {
                return false;
            }
        }

        return true;
    }

    private InjectedClass createInjectedClass(String s)
    {
        TypeElement typeelement = processingEnv.getElementUtils().getTypeElement(s);
        boolean flag = typeelement.getModifiers().contains(Modifier.ABSTRACT);
        ArrayList arraylist = new ArrayList();
        s = null;
        ArrayList arraylist1 = new ArrayList();
label0:
        do
        {
            for (Iterator iterator = typeelement.getEnclosedElements().iterator(); iterator.hasNext();)
            {
                Element element = (Element)iterator.next();
                if (element.getAnnotation(javax/inject/Inject) != null)
                {
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

                    switch (_cls1..SwitchMap.javax.lang.model.element.ElementKind[element.getKind().ordinal()])
                    {
                    default:
                        error((new StringBuilder()).append("Cannot inject ").append(Util.elementToString(element)).toString(), element);
                        break;

                    case 1: // '\001'
                        if (element.getModifiers().contains(Modifier.STATIC))
                        {
                            arraylist.add(element);
                        } else
                        {
                            arraylist1.add(element);
                        }
                        break;

                    case 2: // '\002'
                        if (s != null)
                        {
                            error((new StringBuilder()).append("Too many injectable constructors on ").append(typeelement.getQualifiedName()).toString(), element);
                        } else
                        if (flag)
                        {
                            error((new StringBuilder()).append("Abstract class ").append(typeelement.getQualifiedName()).append(" must not have an @Inject-annotated constructor.").toString(), element);
                        }
                        s = (ExecutableElement)element;
                        break;
                    }
                    continue label0;
                }
            }

            String s1 = s;
            if (s == null)
            {
                s1 = s;
                if (!flag)
                {
                    s = Util.getNoArgsConstructor(typeelement);
                    s1 = s;
                    if (s != null)
                    {
                        s1 = s;
                        if (!Util.isCallableConstructor(s))
                        {
                            s1 = null;
                        }
                    }
                }
            }
            return new InjectedClass(typeelement, arraylist, s1, arraylist1);
        } while (true);
    }

    private void error(String s, Element element)
    {
        processingEnv.getMessager().printMessage(javax.tools.Diagnostic.Kind.ERROR, s, element);
    }

    private String fieldName(boolean flag, Element element)
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s;
        if (flag)
        {
            s = "field_";
        } else
        {
            s = "";
        }
        return stringbuilder.append(s).append(element.getSimpleName().toString()).toString();
    }

    private Set findImports(boolean flag, boolean flag1, boolean flag2)
    {
        LinkedHashSet linkedhashset = new LinkedHashSet();
        linkedhashset.add(dagger/internal/Binding.getCanonicalName());
        if (flag)
        {
            linkedhashset.add(dagger/internal/Linker.getCanonicalName());
            linkedhashset.add(java/util/Set.getCanonicalName());
        }
        if (flag1)
        {
            linkedhashset.add(dagger/MembersInjector.getCanonicalName());
        }
        if (flag2)
        {
            linkedhashset.add(javax/inject/Provider.getCanonicalName());
        }
        return linkedhashset;
    }

    private Set findInjectedClassNames(RoundEnvironment roundenvironment)
    {
        LinkedHashSet linkedhashset = new LinkedHashSet();
        roundenvironment = roundenvironment.getElementsAnnotatedWith(javax/inject/Inject).iterator();
        do
        {
            if (!roundenvironment.hasNext())
            {
                break;
            }
            Element element = (Element)roundenvironment.next();
            if (validateInjectable(element))
            {
                linkedhashset.add(Util.rawTypeToString(element.getEnclosingElement().asType(), '.'));
            }
        } while (true);
        return linkedhashset;
    }

    private void generateInjectAdapter(TypeElement typeelement, ExecutableElement executableelement, List list)
        throws IOException
    {
        Object obj = Util.getPackage(typeelement).getQualifiedName().toString();
        String s = strippedTypeName(typeelement.getQualifiedName().toString(), ((String) (obj)));
        TypeMirror typemirror = Util.getApplicationSupertype(typeelement);
        String s1 = Util.adapterName(typeelement, "$$InjectAdapter");
        JavaWriter javawriter = new JavaWriter(processingEnv.getFiler().createSourceFile(s1, new Element[] {
            typeelement
        }).openWriter());
        boolean flag4 = typeelement.getModifiers().contains(Modifier.ABSTRACT);
        String s2;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        if (!list.isEmpty() || typemirror != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!list.isEmpty() && executableelement != null && !executableelement.getParameters().isEmpty())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag || executableelement != null && !executableelement.getParameters().isEmpty())
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        javawriter.emitSingleLineComment("Code generated by dagger-compiler.  Do not edit.", new Object[0]);
        javawriter.emitPackage(((String) (obj)));
        if (executableelement != null)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        javawriter.emitImports(findImports(flag2, flag, flag3));
        javawriter.emitEmptyLine();
        javawriter.emitJavadoc(AdapterJavadocs.bindingTypeDocs(s, flag4, flag, flag2), new Object[0]);
        obj = EnumSet.of(Modifier.PUBLIC, Modifier.FINAL);
        s2 = JavaWriter.type(dagger/internal/Binding, new String[] {
            s
        });
        if (executableelement != null)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        javawriter.beginType(s1, "class", ((Set) (obj)), s2, implementedInterfaces(s, flag, flag3));
        writeMemberBindingsFields(javawriter, list, flag1);
        if (executableelement != null)
        {
            writeParameterBindingsFields(javawriter, executableelement, flag1);
        }
        if (typemirror != null)
        {
            writeSupertypeInjectorField(javawriter, typemirror);
        }
        javawriter.emitEmptyLine();
        writeInjectAdapterConstructor(javawriter, executableelement, typeelement, s, s1);
        if (flag2)
        {
            writeAttachMethod(javawriter, executableelement, list, flag1, s, typemirror, true);
            writeGetDependenciesMethod(javawriter, executableelement, list, flag1, typemirror, true);
        }
        if (executableelement != null)
        {
            writeGetMethod(javawriter, executableelement, flag1, flag, s);
        }
        if (flag)
        {
            writeMembersInjectMethod(javawriter, list, flag1, s, typemirror);
        }
        javawriter.endType();
        javawriter.close();
    }

    private void generateInjectionsForClass(InjectedClass injectedclass)
        throws IOException
    {
        if (injectedclass.constructor != null || !injectedclass.fields.isEmpty())
        {
            generateInjectAdapter(injectedclass.type, injectedclass.constructor, injectedclass.fields);
        }
        if (!injectedclass.staticFields.isEmpty())
        {
            generateStaticInjection(injectedclass.type, injectedclass.staticFields);
        }
    }

    private void generateStaticInjection(TypeElement typeelement, List list)
        throws IOException
    {
        String s = typeelement.getQualifiedName().toString();
        String s1 = Util.adapterName(typeelement, "$$StaticInjection");
        JavaWriter javawriter = new JavaWriter(processingEnv.getFiler().createSourceFile(s1, new Element[] {
            typeelement
        }).openWriter());
        javawriter.emitSingleLineComment("Code generated by dagger-compiler.  Do not edit.", new Object[0]);
        javawriter.emitPackage(Util.getPackage(typeelement).getQualifiedName().toString());
        javawriter.emitImports(Arrays.asList(new String[] {
            dagger/internal/StaticInjection.getName(), dagger/internal/Binding.getName(), dagger/internal/Linker.getName()
        }));
        javawriter.emitEmptyLine();
        javawriter.emitJavadoc("A manager for {@code %s}'s injections into static fields.", new Object[] {
            typeelement.getSimpleName()
        });
        javawriter.beginType(s1, "class", EnumSet.of(Modifier.PUBLIC, Modifier.FINAL), dagger/internal/StaticInjection.getSimpleName(), new String[0]);
        writeMemberBindingsFields(javawriter, list, false);
        javawriter.emitEmptyLine();
        writeAttachMethod(javawriter, null, list, false, s, null, true);
        writeStaticInjectMethod(javawriter, list, s);
        javawriter.endType();
        javawriter.close();
    }

    private String[] implementedInterfaces(String s, boolean flag, boolean flag1)
    {
        ArrayList arraylist = new ArrayList();
        if (flag1)
        {
            arraylist.add(JavaWriter.type(javax/inject/Provider, new String[] {
                s
            }));
        }
        if (flag)
        {
            arraylist.add(JavaWriter.type(dagger/MembersInjector, new String[] {
                s
            }));
        }
        return (String[])arraylist.toArray(new String[arraylist.size()]);
    }

    private String parameterName(boolean flag, Element element)
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s;
        if (flag)
        {
            s = "parameter_";
        } else
        {
            s = "";
        }
        return stringbuilder.append(s).append(element.getSimpleName().toString()).toString();
    }

    private String strippedTypeName(String s, String s1)
    {
        int i;
        if (s1.isEmpty())
        {
            i = 0;
        } else
        {
            i = s1.length() + 1;
        }
        return s.substring(i);
    }

    private boolean validateInjectable(Element element)
    {
        Element element1 = element.getEnclosingElement();
        if (element.getKind() == ElementKind.CLASS)
        {
            error((new StringBuilder()).append("@Inject is not valid on a class: ").append(Util.elementToString(element)).toString(), element);
            return false;
        }
        if (element.getKind() == ElementKind.METHOD)
        {
            error((new StringBuilder()).append("Method injection is not supported: ").append(Util.elementToString(element)).toString(), element);
            return false;
        }
        if (element.getKind() == ElementKind.FIELD && element.getModifiers().contains(Modifier.FINAL))
        {
            error((new StringBuilder()).append("Can't inject a final field: ").append(Util.elementToString(element)).toString(), element);
            return false;
        }
        if (element.getKind() == ElementKind.FIELD && element.getModifiers().contains(Modifier.PRIVATE))
        {
            error((new StringBuilder()).append("Can't inject a private field: ").append(Util.elementToString(element)).toString(), element);
            return false;
        }
        if (element.getKind() == ElementKind.CONSTRUCTOR && element.getModifiers().contains(Modifier.PRIVATE))
        {
            error((new StringBuilder()).append("Can't inject a private constructor: ").append(Util.elementToString(element)).toString(), element);
            return false;
        }
        ElementKind elementkind = element1.getEnclosingElement().getKind();
        boolean flag;
        boolean flag1;
        if (elementkind.isClass() || elementkind.isInterface())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = element1.getModifiers().contains(Modifier.STATIC);
        if (flag && !flag1)
        {
            error((new StringBuilder()).append("Can't inject a non-static inner class: ").append(Util.elementToString(element)).toString(), element1);
            return false;
        } else
        {
            return true;
        }
    }

    private void writeAttachMethod(JavaWriter javawriter, ExecutableElement executableelement, List list, boolean flag, String s, TypeMirror typemirror, boolean flag1)
        throws IOException
    {
        javawriter.emitJavadoc("Used internally to link bindings/providers together at run time\naccording to their dependency graph.", new Object[0]);
        if (flag1)
        {
            javawriter.emitAnnotation(java/lang/Override);
        }
        javawriter.emitAnnotation(java/lang/SuppressWarnings, JavaWriter.stringLiteral("unchecked"));
        javawriter.beginMethod("void", "attach", EnumSet.of(Modifier.PUBLIC), new String[] {
            dagger/internal/Linker.getCanonicalName(), "linker"
        });
        if (executableelement != null)
        {
            VariableElement variableelement;
            for (executableelement = executableelement.getParameters().iterator(); executableelement.hasNext(); javawriter.emitStatement("%s = (%s) linker.requestBinding(%s, %s.class, getClass().getClassLoader())", new Object[] {
    parameterName(flag, variableelement), javawriter.compressType(JavaWriter.type(dagger/internal/Binding, new String[] {
        Util.typeToString(variableelement.asType())
    })), JavaWriter.stringLiteral(GeneratorKeys.get(variableelement)), s
}))
            {
                variableelement = (VariableElement)executableelement.next();
            }

        }
        for (executableelement = list.iterator(); executableelement.hasNext(); javawriter.emitStatement("%s = (%s) linker.requestBinding(%s, %s.class, getClass().getClassLoader())", new Object[] {
    fieldName(flag, list), javawriter.compressType(JavaWriter.type(dagger/internal/Binding, new String[] {
        Util.typeToString(list.asType())
    })), JavaWriter.stringLiteral(GeneratorKeys.get((VariableElement)list)), s
}))
        {
            list = (Element)executableelement.next();
        }

        if (typemirror != null)
        {
            javawriter.emitStatement("%s = (%s) linker.requestBinding(%s, %s.class, getClass().getClassLoader(), false, true)", new Object[] {
                "supertype", javawriter.compressType(JavaWriter.type(dagger/internal/Binding, new String[] {
                    Util.rawTypeToString(typemirror, '.')
                })), JavaWriter.stringLiteral(GeneratorKeys.rawMembersKey(typemirror)), s
            });
        }
        javawriter.endMethod();
        javawriter.emitEmptyLine();
    }

    private void writeGetDependenciesMethod(JavaWriter javawriter, ExecutableElement executableelement, List list, boolean flag, TypeMirror typemirror, boolean flag1)
        throws IOException
    {
        javawriter.emitJavadoc("Used internally obtain dependency information, such as for cyclical\ngraph detection.", new Object[0]);
        if (flag1)
        {
            javawriter.emitAnnotation(java/lang/Override);
        }
        String s = JavaWriter.type(java/util/Set, new String[] {
            "Binding<?>"
        });
        javawriter.beginMethod("void", "getDependencies", EnumSet.of(Modifier.PUBLIC), new String[] {
            s, "getBindings", s, "injectMembersBindings"
        });
        if (executableelement != null)
        {
            for (executableelement = executableelement.getParameters().iterator(); executableelement.hasNext(); javawriter.emitStatement("getBindings.add(%s)", new Object[] {
    parameterName(flag, (Element)executableelement.next())
})) { }
        }
        for (executableelement = list.iterator(); executableelement.hasNext(); javawriter.emitStatement("injectMembersBindings.add(%s)", new Object[] {
    fieldName(flag, (Element)executableelement.next())
})) { }
        if (typemirror != null)
        {
            javawriter.emitStatement("injectMembersBindings.add(%s)", new Object[] {
                "supertype"
            });
        }
        javawriter.endMethod();
        javawriter.emitEmptyLine();
    }

    private void writeGetMethod(JavaWriter javawriter, ExecutableElement executableelement, boolean flag, boolean flag1, String s)
        throws IOException
    {
        javawriter.emitJavadoc("Returns the fully provisioned instance satisfying the contract for\n{@code Provider<%s>}.", new Object[] {
            s
        });
        javawriter.emitAnnotation(java/lang/Override);
        javawriter.beginMethod(s, "get", EnumSet.of(Modifier.PUBLIC), new String[0]);
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(s).append(" result = new ");
        stringbuilder.append(s).append('(');
        boolean flag2 = true;
        executableelement = executableelement.getParameters().iterator();
        while (executableelement.hasNext()) 
        {
            s = (VariableElement)executableelement.next();
            if (!flag2)
            {
                stringbuilder.append(", ");
            } else
            {
                flag2 = false;
            }
            stringbuilder.append(parameterName(flag, s)).append(".get()");
        }
        stringbuilder.append(')');
        javawriter.emitStatement(stringbuilder.toString(), new Object[0]);
        if (flag1)
        {
            javawriter.emitStatement("injectMembers(result)", new Object[0]);
        }
        javawriter.emitStatement("return result", new Object[0]);
        javawriter.endMethod();
        javawriter.emitEmptyLine();
    }

    private void writeInjectAdapterConstructor(JavaWriter javawriter, ExecutableElement executableelement, TypeElement typeelement, String s, String s1)
        throws IOException
    {
        String s2 = null;
        javawriter.beginMethod(null, s1, EnumSet.of(Modifier.PUBLIC), new String[0]);
        s1 = s2;
        if (executableelement != null)
        {
            s1 = JavaWriter.stringLiteral(GeneratorKeys.get(typeelement.asType()));
        }
        s2 = JavaWriter.stringLiteral(GeneratorKeys.rawMembersKey(typeelement.asType()));
        boolean flag;
        if (typeelement.getAnnotation(javax/inject/Singleton) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            executableelement = "IS_SINGLETON";
        } else
        {
            executableelement = "NOT_SINGLETON";
        }
        javawriter.emitStatement("super(%s, %s, %s, %s.class)", new Object[] {
            s1, s2, executableelement, s
        });
        javawriter.endMethod();
        javawriter.emitEmptyLine();
    }

    private void writeMemberBindingsFields(JavaWriter javawriter, List list, boolean flag)
        throws IOException
    {
        Element element;
        for (list = list.iterator(); list.hasNext(); javawriter.emitField(JavaWriter.type(dagger/internal/Binding, new String[] {
    Util.typeToString(element.asType())
}), fieldName(flag, element), EnumSet.of(Modifier.PRIVATE)))
        {
            element = (Element)list.next();
        }

    }

    private void writeMembersInjectMethod(JavaWriter javawriter, List list, boolean flag, String s, TypeMirror typemirror)
        throws IOException
    {
        javawriter.emitJavadoc("Injects any {@code @Inject} annotated fields in the given instance,\nsatisfying the contract for {@code Provider<%s>}.", new Object[] {
            s
        });
        javawriter.emitAnnotation(java/lang/Override);
        javawriter.beginMethod("void", "injectMembers", EnumSet.of(Modifier.PUBLIC), new String[] {
            s, "object"
        });
        for (list = list.iterator(); list.hasNext(); javawriter.emitStatement("object.%s = %s.get()", new Object[] {
    s.getSimpleName(), fieldName(flag, s)
}))
        {
            s = (Element)list.next();
        }

        if (typemirror != null)
        {
            javawriter.emitStatement("supertype.injectMembers(object)", new Object[0]);
        }
        javawriter.endMethod();
        javawriter.emitEmptyLine();
    }

    private void writeParameterBindingsFields(JavaWriter javawriter, ExecutableElement executableelement, boolean flag)
        throws IOException
    {
        VariableElement variableelement;
        for (executableelement = executableelement.getParameters().iterator(); executableelement.hasNext(); javawriter.emitField(JavaWriter.type(dagger/internal/Binding, new String[] {
    Util.typeToString(variableelement.asType())
}), parameterName(flag, variableelement), EnumSet.of(Modifier.PRIVATE)))
        {
            variableelement = (VariableElement)executableelement.next();
        }

    }

    private void writeStaticInjectMethod(JavaWriter javawriter, List list, String s)
        throws IOException
    {
        javawriter.emitEmptyLine();
        javawriter.emitJavadoc("Performs the injections of dependencies into static fields when requested by\nthe {@code dagger.ObjectGraph}.", new Object[0]);
        javawriter.emitAnnotation(java/lang/Override);
        javawriter.beginMethod("void", "inject", EnumSet.of(Modifier.PUBLIC), new String[0]);
        Element element;
        for (list = list.iterator(); list.hasNext(); javawriter.emitStatement("%s.%s = %s.get()", new Object[] {
    javawriter.compressType(s), element.getSimpleName().toString(), fieldName(false, element)
}))
        {
            element = (Element)list.next();
        }

        javawriter.endMethod();
        javawriter.emitEmptyLine();
    }

    private void writeSupertypeInjectorField(JavaWriter javawriter, TypeMirror typemirror)
        throws IOException
    {
        javawriter.emitField(JavaWriter.type(dagger/internal/Binding, new String[] {
            Util.rawTypeToString(typemirror, '.')
        }), "supertype", EnumSet.of(Modifier.PRIVATE));
    }

    public SourceVersion getSupportedSourceVersion()
    {
        return SourceVersion.latestSupported();
    }

    public boolean process(Set set, RoundEnvironment roundenvironment)
    {
        remainingTypeNames.addAll(findInjectedClassNames(roundenvironment));
        set = remainingTypeNames.iterator();
        do
        {
            if (!set.hasNext())
            {
                break;
            }
            InjectedClass injectedclass = createInjectedClass((String)set.next());
            boolean flag;
            if (!allTypesExist(injectedclass.fields) || injectedclass.constructor != null && !allTypesExist(injectedclass.constructor.getParameters()) || !allTypesExist(injectedclass.staticFields))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                try
                {
                    generateInjectionsForClass(injectedclass);
                }
                catch (IOException ioexception)
                {
                    error((new StringBuilder()).append("Code gen failed: ").append(ioexception).toString(), injectedclass.type);
                }
                set.remove();
            }
        } while (true);
        if (roundenvironment.processingOver() && !remainingTypeNames.isEmpty())
        {
            processingEnv.getMessager().printMessage(javax.tools.Diagnostic.Kind.ERROR, (new StringBuilder()).append("Could not find injection type required by ").append(remainingTypeNames).toString());
        }
        return false;
    }
}
