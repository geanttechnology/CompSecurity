// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.spi;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Binding;
import com.google.inject.Key;
import com.google.inject.MembersInjector;
import com.google.inject.Module;
import com.google.inject.PrivateBinder;
import com.google.inject.PrivateModule;
import com.google.inject.Provider;
import com.google.inject.Scope;
import com.google.inject.Stage;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.AnnotatedConstantBindingBuilder;
import com.google.inject.binder.AnnotatedElementBuilder;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.internal.AbstractBindingBuilder;
import com.google.inject.internal.BindingBuilder;
import com.google.inject.internal.ConstantBindingBuilderImpl;
import com.google.inject.internal.Errors;
import com.google.inject.internal.ExposureBuilder;
import com.google.inject.internal.InternalFlags;
import com.google.inject.internal.PrivateElementsImpl;
import com.google.inject.internal.ProviderMethodsModule;
import com.google.inject.internal.util.SourceProvider;
import com.google.inject.internal.util.StackTraceElements;
import com.google.inject.matcher.Matcher;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.roboguice.shaded.goole.common.base.Preconditions;
import org.roboguice.shaded.goole.common.collect.ImmutableList;
import org.roboguice.shaded.goole.common.collect.Lists;
import org.roboguice.shaded.goole.common.collect.Sets;

// Referenced classes of package com.google.inject.spi:
//            BindingTargetVisitor, Element, ElementSource, ModuleSource, 
//            Message, TypeListenerBinding, ProvisionListenerBinding, ScopeBinding, 
//            TypeConverterBinding, DisableCircularProxiesOption, MembersInjectorLookup, ProviderLookup, 
//            InjectionRequest, StaticInjectionRequest, RequireAtInjectOnConstructorsOption, RequireExactBindingAnnotationsOption, 
//            RequireExplicitBindingsOption, TypeListener, ProvisionListener, TypeConverter, 
//            DefaultBindingTargetVisitor, InstanceBinding

public final class Elements
{
    private static class ElementsAsModule
        implements Module
    {

        private final Iterable elements;

        public void configure(Binder binder)
        {
            for (Iterator iterator = elements.iterator(); iterator.hasNext(); ((Element)iterator.next()).applyTo(binder)) { }
        }

        ElementsAsModule(Iterable iterable)
        {
            elements = iterable;
        }
    }

    private static class RecordingBinder
        implements Binder, PrivateBinder
    {

        private final List elements;
        private ModuleSource moduleSource;
        private final Set modules;
        private final RecordingBinder parent;
        private final PrivateElementsImpl privateElements;
        private final Object source;
        private final SourceProvider sourceProvider;
        private final Stage stage;

        private AnnotatedElementBuilder exposeInternal(Key key)
        {
            if (privateElements == null)
            {
                addError("Cannot expose %s on a standard binder. Exposed bindings are only applicable to private binders.", new Object[] {
                    key
                });
                return new AnnotatedElementBuilder() {

                    final RecordingBinder this$0;

                    public void annotatedWith(Class class1)
                    {
                    }

                    public void annotatedWith(Annotation annotation)
                    {
                    }

            
            {
                this$0 = RecordingBinder.this;
                super();
            }
                };
            } else
            {
                key = new ExposureBuilder(this, getElementSource(), key);
                privateElements.addExposureBuilder(key);
                return key;
            }
        }

        private ElementSource getElementSource()
        {
            Object obj;
            ElementSource elementsource;
            StackTraceElement astacktraceelement[];
            StackTraceElement astacktraceelement1[];
            com.google.inject.internal.InternalFlags.IncludeStackTraceOption includestacktraceoption;
label0:
            {
                Object obj1 = null;
                astacktraceelement1 = new StackTraceElement[0];
                elementsource = null;
                Object obj3 = source;
                obj = obj3;
                if (obj3 instanceof ElementSource)
                {
                    elementsource = (ElementSource)obj3;
                    obj = elementsource.getDeclaringSource();
                }
                includestacktraceoption = InternalFlags.getIncludeStackTraceOption();
                if (includestacktraceoption != com.google.inject.internal.InternalFlags.IncludeStackTraceOption.COMPLETE)
                {
                    astacktraceelement = obj1;
                    if (includestacktraceoption != com.google.inject.internal.InternalFlags.IncludeStackTraceOption.ONLY_FOR_DECLARING_SOURCE)
                    {
                        break label0;
                    }
                    astacktraceelement = obj1;
                    if (obj != null)
                    {
                        break label0;
                    }
                }
                astacktraceelement = (new Throwable()).getStackTrace();
            }
            if (includestacktraceoption == com.google.inject.internal.InternalFlags.IncludeStackTraceOption.COMPLETE)
            {
                astacktraceelement1 = getPartialCallStack(astacktraceelement);
            }
            Object obj2 = obj;
            if (obj == null)
            {
                if (includestacktraceoption == com.google.inject.internal.InternalFlags.IncludeStackTraceOption.COMPLETE || includestacktraceoption == com.google.inject.internal.InternalFlags.IncludeStackTraceOption.ONLY_FOR_DECLARING_SOURCE)
                {
                    obj2 = sourceProvider.get(astacktraceelement);
                } else
                {
                    obj2 = sourceProvider.getFromClassNames(moduleSource.getModuleClassNames());
                }
            }
            return new ElementSource(elementsource, obj2, moduleSource, astacktraceelement1);
        }

        private ModuleSource getModuleSource(Module module)
        {
            StackTraceElement astacktraceelement[];
            if (InternalFlags.getIncludeStackTraceOption() == com.google.inject.internal.InternalFlags.IncludeStackTraceOption.COMPLETE)
            {
                astacktraceelement = getPartialCallStack((new Throwable()).getStackTrace());
            } else
            {
                astacktraceelement = new StackTraceElement[0];
            }
            if (moduleSource == null)
            {
                return new ModuleSource(module, astacktraceelement);
            } else
            {
                return moduleSource.createChild(module, astacktraceelement);
            }
        }

        private StackTraceElement[] getPartialCallStack(StackTraceElement astacktraceelement[])
        {
            int i = 0;
            if (moduleSource != null)
            {
                i = moduleSource.getStackTraceSize();
            }
            i = astacktraceelement.length - i - 1;
            StackTraceElement astacktraceelement1[] = new StackTraceElement[i];
            System.arraycopy(astacktraceelement, 1, astacktraceelement1, 0, i);
            return astacktraceelement1;
        }

        public void addError(Message message)
        {
            elements.add(message);
        }

        public transient void addError(String s, Object aobj[])
        {
            elements.add(new Message(getElementSource(), Errors.format(s, aobj)));
        }

        public void addError(Throwable throwable)
        {
            String s = (new StringBuilder()).append("An exception was caught and reported. Message: ").append(throwable.getMessage()).toString();
            elements.add(new Message(ImmutableList.of(getElementSource()), s, throwable));
        }

        public AnnotatedBindingBuilder bind(Key key)
        {
            return new BindingBuilder(this, elements, getElementSource(), key);
        }

        public AnnotatedBindingBuilder bind(TypeLiteral typeliteral)
        {
            return bind(Key.get(typeliteral));
        }

        public AnnotatedBindingBuilder bind(Class class1)
        {
            return bind(Key.get(class1));
        }

        public volatile LinkedBindingBuilder bind(Key key)
        {
            return bind(key);
        }

        public AnnotatedConstantBindingBuilder bindConstant()
        {
            return new ConstantBindingBuilderImpl(this, elements, getElementSource());
        }

        public void bindListener(Matcher matcher, TypeListener typelistener)
        {
            elements.add(new TypeListenerBinding(getElementSource(), typelistener, matcher));
        }

        public transient void bindListener(Matcher matcher, ProvisionListener aprovisionlistener[])
        {
            elements.add(new ProvisionListenerBinding(getElementSource(), matcher, aprovisionlistener));
        }

        public void bindScope(Class class1, Scope scope)
        {
            elements.add(new ScopeBinding(getElementSource(), class1, scope));
        }

        public void convertToTypes(Matcher matcher, TypeConverter typeconverter)
        {
            elements.add(new TypeConverterBinding(getElementSource(), matcher, typeconverter));
        }

        public Stage currentStage()
        {
            return stage;
        }

        public void disableCircularProxies()
        {
            elements.add(new DisableCircularProxiesOption(getElementSource()));
        }

        public AnnotatedElementBuilder expose(TypeLiteral typeliteral)
        {
            return exposeInternal(Key.get(typeliteral));
        }

        public AnnotatedElementBuilder expose(Class class1)
        {
            return exposeInternal(Key.get(class1));
        }

        public void expose(Key key)
        {
            exposeInternal(key);
        }

        public MembersInjector getMembersInjector(TypeLiteral typeliteral)
        {
            typeliteral = new MembersInjectorLookup(getElementSource(), typeliteral);
            elements.add(typeliteral);
            return typeliteral.getMembersInjector();
        }

        public MembersInjector getMembersInjector(Class class1)
        {
            return getMembersInjector(TypeLiteral.get(class1));
        }

        public Provider getProvider(Key key)
        {
            key = new ProviderLookup(getElementSource(), key);
            elements.add(key);
            return key.getProvider();
        }

        public Provider getProvider(Class class1)
        {
            return getProvider(Key.get(class1));
        }

        public void install(Module module)
        {
            if (modules.add(module))
            {
                RecordingBinder recordingbinder = this;
                if (!(module instanceof ProviderMethodsModule))
                {
                    moduleSource = getModuleSource(module);
                }
                Object obj = recordingbinder;
                if (module instanceof PrivateModule)
                {
                    obj = recordingbinder.newPrivateBinder();
                }
                try
                {
                    module.configure(((Binder) (obj)));
                }
                catch (RuntimeException runtimeexception)
                {
                    Collection collection = Errors.getMessagesFromThrowable(runtimeexception);
                    if (!collection.isEmpty())
                    {
                        elements.addAll(collection);
                    } else
                    {
                        addError(runtimeexception);
                    }
                }
                ((Binder) (obj)).install(ProviderMethodsModule.forModule(module));
                if (!(module instanceof ProviderMethodsModule))
                {
                    moduleSource = moduleSource.getParent();
                }
            }
        }

        public PrivateBinder newPrivateBinder()
        {
            PrivateElementsImpl privateelementsimpl = new PrivateElementsImpl(getElementSource());
            RecordingBinder recordingbinder = new RecordingBinder(this, privateelementsimpl);
            elements.add(privateelementsimpl);
            return recordingbinder;
        }

        public void requestInjection(TypeLiteral typeliteral, Object obj)
        {
            elements.add(new InjectionRequest(getElementSource(), typeliteral, obj));
        }

        public void requestInjection(Object obj)
        {
            requestInjection(TypeLiteral.get(obj.getClass()), obj);
        }

        public transient void requestStaticInjection(Class aclass[])
        {
            int j = aclass.length;
            for (int i = 0; i < j; i++)
            {
                Class class1 = aclass[i];
                elements.add(new StaticInjectionRequest(getElementSource(), class1));
            }

        }

        public void requireAtInjectOnConstructors()
        {
            elements.add(new RequireAtInjectOnConstructorsOption(getElementSource()));
        }

        public void requireExactBindingAnnotations()
        {
            elements.add(new RequireExactBindingAnnotationsOption(getElementSource()));
        }

        public void requireExplicitBindings()
        {
            elements.add(new RequireExplicitBindingsOption(getElementSource()));
        }

        public volatile Binder skipSources(Class aclass[])
        {
            return skipSources(aclass);
        }

        public volatile PrivateBinder skipSources(Class aclass[])
        {
            return skipSources(aclass);
        }

        public transient RecordingBinder skipSources(Class aclass[])
        {
            if (source != null)
            {
                return this;
            } else
            {
                return new RecordingBinder(this, null, sourceProvider.plusSkippedClasses(aclass));
            }
        }

        public String toString()
        {
            return "Binder";
        }

        public volatile Binder withSource(Object obj)
        {
            return withSource(obj);
        }

        public volatile PrivateBinder withSource(Object obj)
        {
            return withSource(obj);
        }

        public RecordingBinder withSource(Object obj)
        {
            if (obj == source)
            {
                return this;
            } else
            {
                return new RecordingBinder(this, obj, null);
            }
        }


        private RecordingBinder(Stage stage1)
        {
            moduleSource = null;
            stage = stage1;
            modules = Sets.newHashSet();
            elements = Lists.newArrayList();
            source = null;
            sourceProvider = SourceProvider.DEFAULT_INSTANCE.plusSkippedClasses(new Class[] {
                com/google/inject/spi/Elements, com/google/inject/spi/Elements$RecordingBinder, com/google/inject/AbstractModule, com/google/inject/internal/ConstantBindingBuilderImpl, com/google/inject/internal/AbstractBindingBuilder, com/google/inject/internal/BindingBuilder
            });
            parent = null;
            privateElements = null;
        }


        private RecordingBinder(RecordingBinder recordingbinder, PrivateElementsImpl privateelementsimpl)
        {
            moduleSource = null;
            stage = recordingbinder.stage;
            modules = Sets.newHashSet();
            elements = privateelementsimpl.getElementsMutable();
            source = recordingbinder.source;
            moduleSource = recordingbinder.moduleSource;
            sourceProvider = recordingbinder.sourceProvider;
            parent = recordingbinder;
            privateElements = privateelementsimpl;
        }

        private RecordingBinder(RecordingBinder recordingbinder, Object obj, SourceProvider sourceprovider)
        {
            boolean flag1 = true;
            super();
            moduleSource = null;
            boolean flag;
            if (obj == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (sourceprovider != null)
            {
                flag1 = false;
            }
            Preconditions.checkArgument(flag1 ^ flag);
            stage = recordingbinder.stage;
            modules = recordingbinder.modules;
            elements = recordingbinder.elements;
            source = obj;
            moduleSource = recordingbinder.moduleSource;
            sourceProvider = sourceprovider;
            parent = recordingbinder.parent;
            privateElements = recordingbinder.privateElements;
        }
    }


    private static final BindingTargetVisitor GET_INSTANCE_VISITOR = new DefaultBindingTargetVisitor() {

        public Object visit(InstanceBinding instancebinding)
        {
            return instancebinding.getInstance();
        }

        protected Object visitOther(Binding binding)
        {
            throw new IllegalArgumentException();
        }

    };

    public Elements()
    {
    }

    public static List getElements(Stage stage, Iterable iterable)
    {
        stage = new RecordingBinder(stage);
        for (iterable = iterable.iterator(); iterable.hasNext(); stage.install((Module)iterable.next())) { }
        StackTraceElements.clearCache();
        return Collections.unmodifiableList(((RecordingBinder) (stage)).elements);
    }

    public static transient List getElements(Stage stage, Module amodule[])
    {
        return getElements(stage, ((Iterable) (Arrays.asList(amodule))));
    }

    public static List getElements(Iterable iterable)
    {
        return getElements(Stage.DEVELOPMENT, iterable);
    }

    public static transient List getElements(Module amodule[])
    {
        return getElements(Stage.DEVELOPMENT, ((Iterable) (Arrays.asList(amodule))));
    }

    static BindingTargetVisitor getInstanceVisitor()
    {
        return GET_INSTANCE_VISITOR;
    }

    public static Module getModule(Iterable iterable)
    {
        return new ElementsAsModule(iterable);
    }

}
