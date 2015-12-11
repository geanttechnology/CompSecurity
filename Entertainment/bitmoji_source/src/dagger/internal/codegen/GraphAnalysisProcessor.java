// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal.codegen;

import dagger.Module;
import dagger.Provides;
import dagger.internal.Binding;
import dagger.internal.BindingsGroup;
import dagger.internal.Linker;
import dagger.internal.ProblemDetector;
import dagger.internal.ProvidesBinding;
import dagger.internal.SetBinding;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.inject.Singleton;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.FileObject;
import javax.tools.StandardLocation;

// Referenced classes of package dagger.internal.codegen:
//            GraphAnalysisLoader, Util, GeneratorKeys, GraphAnalysisErrorHandler, 
//            GraphAnalysisStaticInjection, GraphVizWriter, GraphVisualizer

public final class GraphAnalysisProcessor extends AbstractProcessor
{
    static class ModuleValidationException extends IllegalStateException
    {

        final Element source;

        public ModuleValidationException(String s, Element element)
        {
            super(s);
            source = element;
        }
    }

    static class ProviderMethodBinding extends ProvidesBinding
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

        protected ProviderMethodBinding(String s, ExecutableElement executableelement, boolean flag)
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


    private static final Set ERROR_NAMES_TO_PROPAGATE = new LinkedHashSet(Arrays.asList(new String[] {
        "com.sun.tools.javac.code.Symbol$CompletionFailure"
    }));
    private final Set delayedModuleNames = new LinkedHashSet();

    public GraphAnalysisProcessor()
    {
    }

    private Elements elements()
    {
        return processingEnv.getElementUtils();
    }

    private void error(String s, Element element)
    {
        processingEnv.getMessager().printMessage(javax.tools.Diagnostic.Kind.ERROR, s, element);
    }

    private Map processCompleteModule(TypeElement typeelement, boolean flag)
    {
        Object obj;
        BindingsGroup bindingsgroup;
        BindingsGroup bindingsgroup1;
        Object obj1;
        ArrayList arraylist;
        Linker linker;
        LinkedHashSet linkedhashset;
        Object obj2;
        Object obj3;
        boolean flag1;
        obj = new LinkedHashMap();
        collectIncludesRecursively(typeelement, ((Map) (obj)), new LinkedList());
        arraylist = new ArrayList();
        Iterator iterator;
        Object aobj1[];
        int i;
        int k;
        if (flag)
        {
            typeelement = dagger.internal.Linker.ErrorHandler.NULL;
        } else
        {
            typeelement = new GraphAnalysisErrorHandler(processingEnv, typeelement.getQualifiedName().toString());
        }
        linker = new Linker(null, new GraphAnalysisLoader(processingEnv), typeelement);
        linker;
        JVM INSTR monitorenter ;
        bindingsgroup = new BindingsGroup() {

            final GraphAnalysisProcessor this$0;

            public Binding contributeSetBinding(String s1, SetBinding setbinding)
            {
                return super.put(s1, setbinding);
            }

            
            {
                this$0 = GraphAnalysisProcessor.this;
                super();
            }
        };
        bindingsgroup1 = new BindingsGroup() {

            final GraphAnalysisProcessor this$0;

            public Binding contributeSetBinding(String s1, SetBinding setbinding)
            {
                throw new IllegalStateException("Module overrides cannot contribute set bindings.");
            }

            
            {
                this$0 = GraphAnalysisProcessor.this;
                super();
            }
        };
        iterator = ((Map) (obj)).values().iterator();
_L17:
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = (TypeElement)iterator.next();
        obj2 = Util.getAnnotation(dagger/Module, ((Element) (obj1)));
        flag = ((Boolean)((Map) (obj2)).get("overrides")).booleanValue();
        flag1 = ((Boolean)((Map) (obj2)).get("library")).booleanValue();
        if (flag)
        {
            typeelement = bindingsgroup1;
        } else
        {
            typeelement = bindingsgroup;
        }
        linkedhashset = new LinkedHashSet();
        aobj1 = (Object[])(Object[])((Map) (obj2)).get("injects");
        k = aobj1.length;
        i = 0;
_L1:
        if (i >= k)
        {
            break MISSING_BLOCK_LABEL_315;
        }
        obj3 = (TypeMirror)aobj1[i];
        obj = GeneratorKeys.get(((TypeMirror) (obj3)));
        linkedhashset.add(obj);
        if (!Util.isInterface(((TypeMirror) (obj3))))
        {
            break MISSING_BLOCK_LABEL_306;
        }
_L2:
        linker.requestBinding(((String) (obj)), ((TypeElement) (obj1)).getQualifiedName().toString(), getClass().getClassLoader(), false, true);
        i++;
          goto _L1
        obj = GeneratorKeys.rawMembersKey(((TypeMirror) (obj3)));
          goto _L2
        Object aobj[];
        int l;
        aobj = (Object[])(Object[])((Map) (obj2)).get("staticInjections");
        l = aobj.length;
        int j = 0;
_L4:
        if (j >= l)
        {
            break; /* Loop/switch isn't completed */
        }
        obj2 = (TypeMirror)aobj[j];
        arraylist.add(new GraphAnalysisStaticInjection(processingEnv.getTypeUtils().asElement(((TypeMirror) (obj2)))));
        j++;
        if (true) goto _L4; else goto _L3
_L3:
        obj2 = ((TypeElement) (obj1)).getEnclosedElements().iterator();
_L14:
        Provides provides;
        do
        {
            if (!((Iterator) (obj2)).hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            aobj = (Element)((Iterator) (obj2)).next();
            provides = (Provides)((Element) (aobj)).getAnnotation(dagger/Provides);
        } while (provides == null);
        String s;
        ProviderMethodBinding providermethodbinding;
        Binding binding;
        obj3 = (ExecutableElement)aobj;
        s = GeneratorKeys.get(((ExecutableElement) (obj3)));
        providermethodbinding = new ProviderMethodBinding(s, ((ExecutableElement) (obj3)), flag1);
        binding = typeelement.get(s);
        if (binding == null) goto _L6; else goto _L5
_L5:
        if (provides.type() != dagger.Provides.Type.SET && provides.type() != dagger.Provides.Type.SET_VALUES || !(binding instanceof SetBinding)) goto _L7; else goto _L6
_L6:
        static class _cls3
        {

            static final int $SwitchMap$dagger$Provides$Type[];

            static 
            {
                $SwitchMap$dagger$Provides$Type = new int[dagger.Provides.Type.values().length];
                try
                {
                    $SwitchMap$dagger$Provides$Type[dagger.Provides.Type.UNIQUE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$dagger$Provides$Type[dagger.Provides.Type.SET.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$dagger$Provides$Type[dagger.Provides.Type.SET_VALUES.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls3..SwitchMap.dagger.Provides.Type[provides.type().ordinal()];
        JVM INSTR tableswitch 1 3: default 833
    //                   1 703
    //                   2 751
    //                   3 765;
           goto _L8 _L9 _L10 _L11
_L8:
        throw new AssertionError((new StringBuilder()).append("Unknown @Provides type ").append(provides.type()).toString());
        typeelement;
        linker;
        JVM INSTR monitorexit ;
        throw typeelement;
_L7:
        obj1 = (new StringBuilder()).append("Duplicate bindings for ").append(s).toString();
        aobj = ((Object []) (obj1));
        if (!flag) goto _L13; else goto _L12
_L12:
        aobj = (new StringBuilder()).append(((String) (obj1))).append(" in override module(s) - cannot override an override").toString();
_L13:
        error((new StringBuilder()).append(((String) (aobj))).append(":\n    ").append(binding.requiredBy).append("\n    ").append(((ProvidesBinding) (providermethodbinding)).requiredBy).toString(), ((Element) (obj3)));
          goto _L6
_L9:
        if (linkedhashset.contains(((ProvidesBinding) (providermethodbinding)).provideKey))
        {
            providermethodbinding.setDependedOn(true);
        }
        typeelement.contributeProvidesBinding(s, providermethodbinding);
          goto _L14
        typeelement;
        throw new ModuleValidationException(typeelement.getMessage(), ((Element) (obj3)));
_L10:
        SetBinding.add(typeelement, GeneratorKeys.getSetKey(((ExecutableElement) (obj3))), providermethodbinding);
          goto _L14
_L11:
        SetBinding.add(typeelement, s, providermethodbinding);
        if (true) goto _L14; else goto _L15
_L15:
        if (true) goto _L17; else goto _L16
_L16:
        linker.installBindings(bindingsgroup);
        linker.installBindings(bindingsgroup1);
        for (typeelement = arraylist.iterator(); typeelement.hasNext(); ((GraphAnalysisStaticInjection)typeelement.next()).attach(linker)) { }
        typeelement = linker.linkAll();
        linker;
        JVM INSTR monitorexit ;
        return typeelement;
    }

    void collectIncludesRecursively(TypeElement typeelement, Map map, Deque deque)
    {
        Object obj = Util.getAnnotation(dagger/Module, typeelement);
        if (obj == null)
        {
            throw new ModuleValidationException((new StringBuilder()).append("No @Module on ").append(typeelement).toString(), typeelement);
        }
        String s = typeelement.getQualifiedName().toString();
        if (deque.contains(s))
        {
            obj = new StringBuilder("Module Inclusion Cycle: ");
            if (deque.size() == 1)
            {
                ((StringBuilder) (obj)).append(s).append(" includes itself directly.");
            } else
            {
                map = s;
                int i = 0;
                while (deque.size() > 0) 
                {
                    String s1 = (String)deque.pop();
                    ((StringBuilder) (obj)).append("\n").append(i).append(". ").append(map).append(" included by ").append(s1);
                    i++;
                    map = s1;
                }
                ((StringBuilder) (obj)).append("\n0. ").append(s);
            }
            throw new ModuleValidationException(((StringBuilder) (obj)).toString(), typeelement);
        }
        map.put(s, typeelement);
        Types types = processingEnv.getTypeUtils();
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(Arrays.asList((Object[])(Object[])((Map) (obj)).get("includes")));
        if (!((Map) (obj)).get("addsTo").equals(java/lang/Void))
        {
            arraylist.add(((Map) (obj)).get("addsTo"));
        }
        for (Iterator iterator = arraylist.iterator(); iterator.hasNext();)
        {
            Object obj1 = iterator.next();
            if (!(obj1 instanceof TypeMirror))
            {
                processingEnv.getMessager().printMessage(javax.tools.Diagnostic.Kind.WARNING, (new StringBuilder()).append("Unexpected value for include: ").append(obj1).append(" in ").append(typeelement).toString(), typeelement);
            } else
            {
                obj1 = (TypeElement)types.asElement((TypeMirror)obj1);
                deque.push(s);
                collectIncludesRecursively(((TypeElement) (obj1)), map, deque);
                deque.pop();
            }
        }

    }

    public SourceVersion getSupportedSourceVersion()
    {
        return SourceVersion.latestSupported();
    }

    public boolean process(Set set, RoundEnvironment roundenvironment)
    {
        if (!roundenvironment.processingOver())
        {
            for (set = roundenvironment.getElementsAnnotatedWith(dagger/Module).iterator(); set.hasNext();)
            {
                roundenvironment = (Element)set.next();
                if (!(roundenvironment instanceof TypeElement))
                {
                    error((new StringBuilder()).append("@Module applies to a type, ").append(roundenvironment.getSimpleName()).append(" is a ").append(roundenvironment.getKind()).toString(), roundenvironment);
                } else
                {
                    delayedModuleNames.add(((TypeElement)roundenvironment).getQualifiedName().toString());
                }
            }

            return false;
        }
        set = new LinkedHashSet();
        String s;
        for (roundenvironment = delayedModuleNames.iterator(); roundenvironment.hasNext(); set.add(elements().getTypeElement(s)))
        {
            s = (String)roundenvironment.next();
        }

        set = set.iterator();
        do
        {
            if (set.hasNext())
            {
                roundenvironment = (Element)set.next();
                Map map;
                try
                {
                    map = Util.getAnnotation(dagger/Module, roundenvironment);
                }
                // Misplaced declaration of an exception variable
                catch (RoundEnvironment roundenvironment)
                {
                    continue;
                }
                roundenvironment = (TypeElement)roundenvironment;
                if (map == null)
                {
                    error("Missing @Module annotation.", roundenvironment);
                    continue;
                }
                if (map.get("complete").equals(Boolean.TRUE))
                {
                    IllegalStateException illegalstateexception;
                    Map map1;
                    try
                    {
                        map1 = processCompleteModule(roundenvironment, false);
                        (new ProblemDetector()).detectCircularDependencies(map1.values());
                    }
                    // Misplaced declaration of an exception variable
                    catch (RoundEnvironment roundenvironment)
                    {
                        error((new StringBuilder()).append("Graph validation failed: ").append(roundenvironment.getMessage()).toString(), ((ModuleValidationException) (roundenvironment)).source);
                        continue;
                    }
                    // Misplaced declaration of an exception variable
                    catch (RoundEnvironment roundenvironment)
                    {
                        error((new StringBuilder()).append("Graph validation failed: ").append(roundenvironment.getMessage()).toString(), elements().getTypeElement(((dagger.internal.Binding.InvalidBindingException) (roundenvironment)).type));
                        continue;
                    }
                    catch (RuntimeException runtimeexception)
                    {
                        if (ERROR_NAMES_TO_PROPAGATE.contains(runtimeexception.getClass().getName()))
                        {
                            throw runtimeexception;
                        }
                        error((new StringBuilder()).append("Unknown error ").append(runtimeexception.getClass().getName()).append(" thrown by javac in graph validation: ").append(runtimeexception.getMessage()).toString(), roundenvironment);
                        continue;
                    }
                    try
                    {
                        writeDotFile(roundenvironment, map1);
                    }
                    catch (IOException ioexception)
                    {
                        StringWriter stringwriter = new StringWriter();
                        ioexception.printStackTrace(new PrintWriter(stringwriter));
                        processingEnv.getMessager().printMessage(javax.tools.Diagnostic.Kind.WARNING, (new StringBuilder()).append("Graph visualization failed. Please report this as a bug.\n\n").append(stringwriter).toString(), roundenvironment);
                    }
                }
                if (map.get("library").equals(Boolean.FALSE))
                {
                    map = processCompleteModule(roundenvironment, true);
                    try
                    {
                        (new ProblemDetector()).detectUnusedBinding(map.values());
                    }
                    // Misplaced declaration of an exception variable
                    catch (IllegalStateException illegalstateexception)
                    {
                        error((new StringBuilder()).append("Graph validation failed: ").append(illegalstateexception.getMessage()).toString(), roundenvironment);
                    }
                }
                continue;
            }
            return false;
        } while (true);
    }

    void writeDotFile(TypeElement typeelement, Map map)
        throws IOException
    {
        StandardLocation standardlocation = StandardLocation.SOURCE_OUTPUT;
        String s = Util.getPackage(typeelement).getQualifiedName().toString();
        String s1 = (new StringBuilder()).append(typeelement.getQualifiedName().toString().substring(s.length() + 1)).append(".dot").toString();
        typeelement = new GraphVizWriter(processingEnv.getFiler().createResource(standardlocation, s, s1, new Element[] {
            typeelement
        }).openWriter());
        (new GraphVisualizer()).write(map, typeelement);
        typeelement.close();
    }

}
