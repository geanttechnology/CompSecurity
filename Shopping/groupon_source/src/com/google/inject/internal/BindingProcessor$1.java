// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Binding;
import com.google.inject.Key;
import com.google.inject.spi.ConstructorBinding;
import com.google.inject.spi.ConvertedConstantBinding;
import com.google.inject.spi.ExposedBinding;
import com.google.inject.spi.InstanceBinding;
import com.google.inject.spi.LinkedKeyBinding;
import com.google.inject.spi.ProviderBinding;
import com.google.inject.spi.ProviderInstanceBinding;
import com.google.inject.spi.ProviderKeyBinding;
import com.google.inject.spi.UntargettedBinding;

// Referenced classes of package com.google.inject.internal:
//            BindingProcessor, ErrorsException, ConstructorBindingImpl, Errors, 
//            ConstantFactory, Initializer, Scoping, InstanceBindingImpl, 
//            FactoryProxy, ProcessedBindingData, LinkedBindingImpl, InjectorImpl, 
//            InternalFactoryToInitializableAdapter, ProvisionListenerCallbackStore, ProviderInstanceBindingImpl, BoundProviderFactory, 
//            LinkedProviderBindingImpl, BindingImpl

class essor extends essor.Processor
{

    final BindingProcessor this$0;

    public Boolean visit(ConstructorBinding constructorbinding)
    {
        prepareBinding();
        try
        {
            constructorbinding = ConstructorBindingImpl.create(injector, key, constructorbinding.getConstructor(), source, scoping, errors, false, false);
            scheduleInitialization(constructorbinding);
            putBinding(constructorbinding);
        }
        // Misplaced declaration of an exception variable
        catch (ConstructorBinding constructorbinding)
        {
            errors.merge(constructorbinding.getErrors());
            putBinding(invalidBinding(injector, key, source));
        }
        return Boolean.valueOf(true);
    }

    public Boolean visit(ConvertedConstantBinding convertedconstantbinding)
    {
        throw new IllegalArgumentException("Cannot apply a non-module element");
    }

    public Boolean visit(ExposedBinding exposedbinding)
    {
        throw new IllegalArgumentException("Cannot apply a non-module element");
    }

    public Boolean visit(InstanceBinding instancebinding)
    {
        prepareBinding();
        java.util.Set set = instancebinding.getInjectionPoints();
        Object obj = instancebinding.getInstance();
        instancebinding = new ConstantFactory(BindingProcessor.access$000(BindingProcessor.this).requestInjection(injector, obj, instancebinding, source, set));
        instancebinding = Scoping.scope(key, injector, instancebinding, source, scoping);
        putBinding(new InstanceBindingImpl(injector, key, source, instancebinding, set, obj));
        return Boolean.valueOf(true);
    }

    public Boolean visit(LinkedKeyBinding linkedkeybinding)
    {
        prepareBinding();
        linkedkeybinding = linkedkeybinding.getLinkedKey();
        if (key.equals(linkedkeybinding))
        {
            errors.recursiveBinding();
        }
        Object obj = new FactoryProxy(injector, key, linkedkeybinding, source);
        bindingData.addCreationListener(((CreationListener) (obj)));
        obj = Scoping.scope(key, injector, ((InternalFactory) (obj)), source, scoping);
        putBinding(new LinkedBindingImpl(injector, key, source, ((InternalFactory) (obj)), scoping, linkedkeybinding));
        return Boolean.valueOf(true);
    }

    public Boolean visit(ProviderBinding providerbinding)
    {
        throw new IllegalArgumentException("Cannot apply a non-module element");
    }

    public Boolean visit(ProviderInstanceBinding providerinstancebinding)
    {
        prepareBinding();
        javax.inject.Provider provider = providerinstancebinding.getUserSuppliedProvider();
        java.util.Set set = providerinstancebinding.getInjectionPoints();
        Initializable initializable = BindingProcessor.access$000(BindingProcessor.this).requestInjection(injector, provider, null, source, set);
        Object obj = source;
        boolean flag;
        if (!injector.options.disableCircularProxies)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        providerinstancebinding = new InternalFactoryToInitializableAdapter(initializable, obj, flag, injector.provisionListenerStore.get(providerinstancebinding));
        providerinstancebinding = Scoping.scope(key, injector, providerinstancebinding, source, scoping);
        putBinding(new ProviderInstanceBindingImpl(injector, key, source, providerinstancebinding, scoping, provider, set));
        return Boolean.valueOf(true);
    }

    public Boolean visit(ProviderKeyBinding providerkeybinding)
    {
        prepareBinding();
        Key key = providerkeybinding.getProviderKey();
        InjectorImpl injectorimpl = injector;
        Object obj = source;
        boolean flag;
        if (!injector.options.disableCircularProxies)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        providerkeybinding = new BoundProviderFactory(injectorimpl, key, obj, flag, injector.provisionListenerStore.get(providerkeybinding));
        bindingData.addCreationListener(providerkeybinding);
        providerkeybinding = Scoping.scope(this.key, injector, providerkeybinding, source, scoping);
        putBinding(new LinkedProviderBindingImpl(injector, this.key, source, providerkeybinding, scoping, key));
        return Boolean.valueOf(true);
    }

    public Boolean visit(UntargettedBinding untargettedbinding)
    {
        return Boolean.valueOf(false);
    }

    public volatile Object visit(ConstructorBinding constructorbinding)
    {
        return visit(constructorbinding);
    }

    public volatile Object visit(ConvertedConstantBinding convertedconstantbinding)
    {
        return visit(convertedconstantbinding);
    }

    public volatile Object visit(ExposedBinding exposedbinding)
    {
        return visit(exposedbinding);
    }

    public volatile Object visit(InstanceBinding instancebinding)
    {
        return visit(instancebinding);
    }

    public volatile Object visit(LinkedKeyBinding linkedkeybinding)
    {
        return visit(linkedkeybinding);
    }

    public volatile Object visit(ProviderBinding providerbinding)
    {
        return visit(providerbinding);
    }

    public volatile Object visit(ProviderInstanceBinding providerinstancebinding)
    {
        return visit(providerinstancebinding);
    }

    public volatile Object visit(ProviderKeyBinding providerkeybinding)
    {
        return visit(providerkeybinding);
    }

    public volatile Object visit(UntargettedBinding untargettedbinding)
    {
        return visit(untargettedbinding);
    }

    protected Boolean visitOther(Binding binding)
    {
        throw new IllegalStateException("BindingProcessor should override all visitations");
    }

    protected volatile Object visitOther(Binding binding)
    {
        return visitOther(binding);
    }

    essor(BindingImpl bindingimpl)
    {
        this$0 = BindingProcessor.this;
        super(BindingProcessor.this, bindingimpl);
    }
}
