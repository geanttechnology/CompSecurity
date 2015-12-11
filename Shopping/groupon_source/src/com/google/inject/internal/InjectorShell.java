// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Binder;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.Provider;
import com.google.inject.Scopes;
import com.google.inject.Singleton;
import com.google.inject.Stage;
import com.google.inject.internal.util.SourceProvider;
import com.google.inject.internal.util.Stopwatch;
import com.google.inject.spi.Dependency;
import com.google.inject.spi.Elements;
import com.google.inject.spi.InjectionPoint;
import com.google.inject.spi.PrivateElements;
import java.lang.reflect.Member;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import org.roboguice.shaded.goole.common.base.Preconditions;
import org.roboguice.shaded.goole.common.collect.ImmutableSet;
import org.roboguice.shaded.goole.common.collect.Lists;

// Referenced classes of package com.google.inject.internal:
//            InjectorImpl, ProviderInstanceBindingImpl, Scoping, State, 
//            InstanceBindingImpl, ConstantFactory, Initializables, InheritingState, 
//            InjectorOptionsProcessor, PrivateElementsImpl, TypeConverterBindingProcessor, MessageProcessor, 
//            ListenerBindingProcessor, MembersInjectorStore, ProvisionListenerCallbackStore, ScopeBindingProcessor, 
//            BindingProcessor, UntargettedBindingProcessor, PrivateElementProcessor, Initializer, 
//            ProcessedBindingData, Errors, InternalFactory, ErrorsException, 
//            InternalContext

final class InjectorShell
{
    static class Builder
    {

        private final List elements = Lists.newArrayList();
        private final List modules = Lists.newArrayList();
        private InjectorImpl.InjectorOptions options;
        private InjectorImpl parent;
        private PrivateElementsImpl privateElements;
        private Stage stage;
        private State state;

        private State getState()
        {
            if (state == null)
            {
                state = new InheritingState(State.NONE);
            }
            return state;
        }

        void addModules(Iterable iterable)
        {
            Module module;
            for (iterable = iterable.iterator(); iterable.hasNext(); modules.add(module))
            {
                module = (Module)iterable.next();
            }

        }

        List build(Initializer initializer, ProcessedBindingData processedbindingdata, Stopwatch stopwatch, Errors errors)
        {
            Object obj;
            InjectorImpl injectorimpl;
            PrivateElementProcessor privateelementprocessor;
            boolean flag;
            if (stage != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkState(flag, "Stage not initialized");
            if (privateElements == null || parent != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkState(flag, "PrivateElements with no parent");
            if (state != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkState(flag, "no state. Did you remember to lock() ?");
            if (parent == null)
            {
                modules.add(0, new RootModule());
            }
            elements.addAll(Elements.getElements(stage, modules));
            obj = new InjectorOptionsProcessor(errors);
            ((InjectorOptionsProcessor) (obj)).process(null, elements);
            options = ((InjectorOptionsProcessor) (obj)).getOptions(stage, options);
            injectorimpl = new InjectorImpl(parent, state, options);
            if (privateElements != null)
            {
                privateElements.initInjector(injectorimpl);
            }
            if (parent == null)
            {
                TypeConverterBindingProcessor.prepareBuiltInConverters(injectorimpl);
            }
            stopwatch.resetAndLog("Module execution");
            (new MessageProcessor(errors)).process(injectorimpl, elements);
            (new ListenerBindingProcessor(errors)).process(injectorimpl, elements);
            injectorimpl.membersInjectorStore = new MembersInjectorStore(injectorimpl, injectorimpl.state.getTypeListenerBindings());
            injectorimpl.provisionListenerStore = new ProvisionListenerCallbackStore(injectorimpl.state.getProvisionListenerBindings());
            stopwatch.resetAndLog("TypeListeners & ProvisionListener creation");
            (new ScopeBindingProcessor(errors)).process(injectorimpl, elements);
            stopwatch.resetAndLog("Scopes creation");
            (new TypeConverterBindingProcessor(errors)).process(injectorimpl, elements);
            stopwatch.resetAndLog("Converters creation");
            InjectorShell.bindStage(injectorimpl, stage);
            InjectorShell.bindInjector(injectorimpl);
            InjectorShell.bindLogger(injectorimpl);
            (new BindingProcessor(errors, initializer, processedbindingdata)).process(injectorimpl, elements);
            (new UntargettedBindingProcessor(errors, processedbindingdata)).process(injectorimpl, elements);
            stopwatch.resetAndLog("Binding creation");
            obj = Lists.newArrayList();
            ((List) (obj)).add(new InjectorShell(this, elements, injectorimpl));
            privateelementprocessor = new PrivateElementProcessor(errors);
            privateelementprocessor.process(injectorimpl, elements);
            for (Iterator iterator = privateelementprocessor.getInjectorShellBuilders().iterator(); iterator.hasNext(); ((List) (obj)).addAll(((Builder)iterator.next()).build(initializer, processedbindingdata, stopwatch, errors))) { }
            stopwatch.resetAndLog("Private environment creation");
            return ((List) (obj));
        }

        Stage getStage()
        {
            return options.stage;
        }

        Object lock()
        {
            return getState().lock();
        }

        Builder parent(InjectorImpl injectorimpl)
        {
            parent = injectorimpl;
            state = new InheritingState(injectorimpl.state);
            options = injectorimpl.options;
            stage = options.stage;
            return this;
        }

        Builder privateElements(PrivateElements privateelements)
        {
            privateElements = (PrivateElementsImpl)privateelements;
            elements.addAll(privateelements.getElements());
            return this;
        }

        Builder stage(Stage stage1)
        {
            stage = stage1;
            return this;
        }

        Builder()
        {
        }
    }

    private static class InjectorFactory
        implements Provider, InternalFactory
    {

        private final Injector injector;

        public Injector get()
        {
            return injector;
        }

        public Injector get(Errors errors, InternalContext internalcontext, Dependency dependency, boolean flag)
            throws ErrorsException
        {
            return injector;
        }

        public volatile Object get()
        {
            return get();
        }

        public volatile Object get(Errors errors, InternalContext internalcontext, Dependency dependency, boolean flag)
            throws ErrorsException
        {
            return get(errors, internalcontext, dependency, flag);
        }

        public String toString()
        {
            return "Provider<Injector>";
        }

        private InjectorFactory(Injector injector1)
        {
            injector = injector1;
        }

    }

    private static class LoggerFactory
        implements Provider, InternalFactory
    {

        public volatile Object get()
        {
            return get();
        }

        public volatile Object get(Errors errors, InternalContext internalcontext, Dependency dependency, boolean flag)
            throws ErrorsException
        {
            return get(errors, internalcontext, dependency, flag);
        }

        public Logger get()
        {
            return Logger.getAnonymousLogger();
        }

        public Logger get(Errors errors, InternalContext internalcontext, Dependency dependency, boolean flag)
        {
            errors = dependency.getInjectionPoint();
            if (errors == null)
            {
                return Logger.getAnonymousLogger();
            } else
            {
                return Logger.getLogger(errors.getMember().getDeclaringClass().getName());
            }
        }

        public String toString()
        {
            return "Provider<Logger>";
        }

        private LoggerFactory()
        {
        }

    }

    private static class RootModule
        implements Module
    {

        public void configure(Binder binder)
        {
            binder = binder.withSource(SourceProvider.UNKNOWN_SOURCE);
            binder.bindScope(com/google/inject/Singleton, Scopes.SINGLETON);
            binder.bindScope(javax/inject/Singleton, Scopes.SINGLETON);
        }

        private RootModule()
        {
        }

    }


    private final List elements;
    private final InjectorImpl injector;

    private InjectorShell(Builder builder, List list, InjectorImpl injectorimpl)
    {
        elements = list;
        injector = injectorimpl;
    }


    private static void bindInjector(InjectorImpl injectorimpl)
    {
        Key key = Key.get(com/google/inject/Injector);
        InjectorFactory injectorfactory = new InjectorFactory(injectorimpl);
        injectorimpl.state.putBinding(key, new ProviderInstanceBindingImpl(injectorimpl, key, SourceProvider.UNKNOWN_SOURCE, injectorfactory, Scoping.UNSCOPED, injectorfactory, ImmutableSet.of()));
    }

    private static void bindLogger(InjectorImpl injectorimpl)
    {
        Key key = Key.get(java/util/logging/Logger);
        LoggerFactory loggerfactory = new LoggerFactory();
        injectorimpl.state.putBinding(key, new ProviderInstanceBindingImpl(injectorimpl, key, SourceProvider.UNKNOWN_SOURCE, loggerfactory, Scoping.UNSCOPED, loggerfactory, ImmutableSet.of()));
    }

    private static void bindStage(InjectorImpl injectorimpl, Stage stage)
    {
        Key key = Key.get(com/google/inject/Stage);
        stage = new InstanceBindingImpl(injectorimpl, key, SourceProvider.UNKNOWN_SOURCE, new ConstantFactory(Initializables.of(stage)), ImmutableSet.of(), stage);
        injectorimpl.state.putBinding(key, stage);
    }

    List getElements()
    {
        return elements;
    }

    InjectorImpl getInjector()
    {
        return injector;
    }



}
