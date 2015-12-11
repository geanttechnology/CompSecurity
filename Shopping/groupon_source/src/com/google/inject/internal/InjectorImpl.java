// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Binder;
import com.google.inject.Binding;
import com.google.inject.ConfigurationException;
import com.google.inject.ImplementedBy;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.MembersInjector;
import com.google.inject.Module;
import com.google.inject.ProvidedBy;
import com.google.inject.Provider;
import com.google.inject.ProvisionException;
import com.google.inject.Stage;
import com.google.inject.TypeLiteral;
import com.google.inject.internal.util.SourceProvider;
import com.google.inject.spi.BindingTargetVisitor;
import com.google.inject.spi.ConvertedConstantBinding;
import com.google.inject.spi.Dependency;
import com.google.inject.spi.HasDependencies;
import com.google.inject.spi.InjectionPoint;
import com.google.inject.spi.ProviderBinding;
import com.google.inject.spi.TypeConverter;
import com.google.inject.spi.TypeConverterBinding;
import com.google.inject.util.Providers;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.roboguice.shaded.goole.common.base.Objects;
import org.roboguice.shaded.goole.common.collect.ImmutableList;
import org.roboguice.shaded.goole.common.collect.ImmutableMap;
import org.roboguice.shaded.goole.common.collect.ImmutableSet;
import org.roboguice.shaded.goole.common.collect.Lists;
import org.roboguice.shaded.goole.common.collect.Maps;
import org.roboguice.shaded.goole.common.collect.Sets;

// Referenced classes of package com.google.inject.internal:
//            Lookups, DeferredLookups, ConstructorInjectorStore, BindingImpl, 
//            ConstructorBindingImpl, State, ErrorsException, Errors, 
//            LinkedBindingImpl, Scoping, MembersInjectorStore, ConstantFactory, 
//            Initializables, InstanceBindingImpl, ProvisionListenerCallbackStore, InternalContext, 
//            ContextualCallable, InternalInjectorCreator, SingleParameterInjector, ProvidedByInternalFactory, 
//            LinkedProviderBindingImpl, Annotations, DelayedInitialize, InternalFactory

final class InjectorImpl
    implements Injector, Lookups
{
    private static class BindingsMultimap
    {

        final Map multimap;

        List getAll(TypeLiteral typeliteral)
        {
            if ((List)multimap.get(typeliteral) != null)
            {
                return Collections.unmodifiableList((List)multimap.get(typeliteral));
            } else
            {
                return ImmutableList.of();
            }
        }

        void put(TypeLiteral typeliteral, Binding binding)
        {
            List list = (List)multimap.get(typeliteral);
            Object obj = list;
            if (list == null)
            {
                obj = Lists.newArrayList();
                multimap.put(typeliteral, obj);
            }
            ((List) (obj)).add(binding);
        }

        private BindingsMultimap()
        {
            multimap = Maps.newHashMap();
        }

    }

    private static class ConvertedConstantBindingImpl extends BindingImpl
        implements ConvertedConstantBinding
    {

        final Binding originalBinding;
        final Provider provider;
        final TypeConverterBinding typeConverterBinding;
        final Object value;

        public Object acceptTargetVisitor(BindingTargetVisitor bindingtargetvisitor)
        {
            return bindingtargetvisitor.visit(this);
        }

        public void applyTo(Binder binder)
        {
            throw new UnsupportedOperationException("This element represents a synthetic binding.");
        }

        public boolean equals(Object obj)
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (obj instanceof ConvertedConstantBindingImpl)
            {
                obj = (ConvertedConstantBindingImpl)obj;
                flag = flag1;
                if (getKey().equals(((ConvertedConstantBindingImpl) (obj)).getKey()))
                {
                    flag = flag1;
                    if (getScoping().equals(((ConvertedConstantBindingImpl) (obj)).getScoping()))
                    {
                        flag = flag1;
                        if (Objects.equal(value, ((ConvertedConstantBindingImpl) (obj)).value))
                        {
                            flag = true;
                        }
                    }
                }
            }
            return flag;
        }

        public Set getDependencies()
        {
            return ImmutableSet.of(Dependency.get(getSourceKey()));
        }

        public Provider getProvider()
        {
            return provider;
        }

        public Key getSourceKey()
        {
            return originalBinding.getKey();
        }

        public TypeConverterBinding getTypeConverterBinding()
        {
            return typeConverterBinding;
        }

        public Object getValue()
        {
            return value;
        }

        public int hashCode()
        {
            return Objects.hashCode(new Object[] {
                getKey(), getScoping(), value
            });
        }

        public String toString()
        {
            return Objects.toStringHelper(com/google/inject/spi/ConvertedConstantBinding).add("key", getKey()).add("sourceKey", getSourceKey()).add("value", value).toString();
        }

        ConvertedConstantBindingImpl(InjectorImpl injectorimpl, Key key, Object obj, Binding binding, TypeConverterBinding typeconverterbinding)
        {
            super(injectorimpl, key, binding.getSource(), new ConstantFactory(Initializables.of(obj)), Scoping.UNSCOPED);
            value = obj;
            provider = Providers.of(obj);
            originalBinding = binding;
            typeConverterBinding = typeconverterbinding;
        }
    }

    static class InjectorOptions
    {

        final boolean atInjectRequired;
        final boolean disableCircularProxies;
        final boolean exactBindingAnnotationsRequired;
        final boolean jitDisabled;
        final Stage stage;

        public String toString()
        {
            return Objects.toStringHelper(getClass()).add("stage", stage).add("jitDisabled", jitDisabled).add("disableCircularProxies", disableCircularProxies).add("atInjectRequired", atInjectRequired).add("exactBindingAnnotationsRequired", exactBindingAnnotationsRequired).toString();
        }

        InjectorOptions(Stage stage1, boolean flag, boolean flag1, boolean flag2, boolean flag3)
        {
            stage = stage1;
            jitDisabled = flag;
            disableCircularProxies = flag1;
            atInjectRequired = flag2;
            exactBindingAnnotationsRequired = flag3;
        }
    }

    static final class JitLimitation extends Enum
    {

        private static final JitLimitation $VALUES[];
        public static final JitLimitation EXISTING_JIT;
        public static final JitLimitation NEW_OR_EXISTING_JIT;
        public static final JitLimitation NO_JIT;

        public static JitLimitation valueOf(String s)
        {
            return (JitLimitation)Enum.valueOf(com/google/inject/internal/InjectorImpl$JitLimitation, s);
        }

        public static JitLimitation[] values()
        {
            return (JitLimitation[])$VALUES.clone();
        }

        static 
        {
            NO_JIT = new JitLimitation("NO_JIT", 0);
            EXISTING_JIT = new JitLimitation("EXISTING_JIT", 1);
            NEW_OR_EXISTING_JIT = new JitLimitation("NEW_OR_EXISTING_JIT", 2);
            $VALUES = (new JitLimitation[] {
                NO_JIT, EXISTING_JIT, NEW_OR_EXISTING_JIT
            });
        }

        private JitLimitation(String s, int i)
        {
            super(s, i);
        }
    }

    static interface MethodInvoker
    {

        public transient abstract Object invoke(Object obj, Object aobj[])
            throws IllegalAccessException, InvocationTargetException;
    }

    private static class ProviderBindingImpl extends BindingImpl
        implements HasDependencies, ProviderBinding
    {

        final BindingImpl providedBinding;

        static InternalFactory createInternalFactory(Binding binding)
        {
            return new InternalFactory(binding.getProvider()) {

                final Provider val$provider;

                public Provider get(Errors errors, InternalContext internalcontext, Dependency dependency, boolean flag)
                {
                    return provider;
                }

                public volatile Object get(Errors errors, InternalContext internalcontext, Dependency dependency, boolean flag)
                    throws ErrorsException
                {
                    return get(errors, internalcontext, dependency, flag);
                }

            
            {
                provider = provider1;
                super();
            }
            };
        }

        public Object acceptTargetVisitor(BindingTargetVisitor bindingtargetvisitor)
        {
            return bindingtargetvisitor.visit(this);
        }

        public void applyTo(Binder binder)
        {
            throw new UnsupportedOperationException("This element represents a synthetic binding.");
        }

        public boolean equals(Object obj)
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (obj instanceof ProviderBindingImpl)
            {
                obj = (ProviderBindingImpl)obj;
                flag = flag1;
                if (getKey().equals(((ProviderBindingImpl) (obj)).getKey()))
                {
                    flag = flag1;
                    if (getScoping().equals(((ProviderBindingImpl) (obj)).getScoping()))
                    {
                        flag = flag1;
                        if (Objects.equal(providedBinding, ((ProviderBindingImpl) (obj)).providedBinding))
                        {
                            flag = true;
                        }
                    }
                }
            }
            return flag;
        }

        public Set getDependencies()
        {
            return ImmutableSet.of(Dependency.get(getProvidedKey()));
        }

        public Key getProvidedKey()
        {
            return providedBinding.getKey();
        }

        public int hashCode()
        {
            return Objects.hashCode(new Object[] {
                getKey(), getScoping(), providedBinding
            });
        }

        public String toString()
        {
            return Objects.toStringHelper(com/google/inject/spi/ProviderBinding).add("key", getKey()).add("providedKey", getProvidedKey()).toString();
        }

        ProviderBindingImpl(InjectorImpl injectorimpl, Key key, Binding binding)
        {
            super(injectorimpl, key, binding.getSource(), createInternalFactory(binding), Scoping.UNSCOPED);
            providedBinding = (BindingImpl)binding;
        }
    }


    public static final TypeLiteral STRING_TYPE = TypeLiteral.get(java/lang/String);
    final BindingsMultimap bindingsMultimap = new BindingsMultimap();
    final ConstructorInjectorStore constructors = new ConstructorInjectorStore(this);
    final Set failedJitBindings = Sets.newHashSet();
    final Map jitBindings = Maps.newHashMap();
    private final ThreadLocal localContext;
    Lookups lookups;
    MembersInjectorStore membersInjectorStore;
    final InjectorOptions options;
    final InjectorImpl parent;
    ProvisionListenerCallbackStore provisionListenerStore;
    final State state;

    InjectorImpl(InjectorImpl injectorimpl, State state1, InjectorOptions injectoroptions)
    {
        lookups = new DeferredLookups(this);
        parent = injectorimpl;
        state = state1;
        options = injectoroptions;
        if (injectorimpl != null)
        {
            localContext = injectorimpl.localContext;
            return;
        } else
        {
            localContext = new ThreadLocal();
            return;
        }
    }

    private boolean cleanup(BindingImpl bindingimpl, Set set)
    {
        boolean flag = false;
        Iterator iterator = getInternalDependencies(bindingimpl).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            bindingimpl = (Dependency)iterator.next();
            Object obj = bindingimpl.getKey();
            bindingimpl = bindingimpl.getInjectionPoint();
            if (set.add(obj))
            {
                BindingImpl bindingimpl1 = (BindingImpl)jitBindings.get(obj);
                if (bindingimpl1 != null)
                {
                    boolean flag2 = cleanup(bindingimpl1, set);
                    boolean flag1 = flag2;
                    if (bindingimpl1 instanceof ConstructorBindingImpl)
                    {
                        ConstructorBindingImpl constructorbindingimpl = (ConstructorBindingImpl)bindingimpl1;
                        obj = constructorbindingimpl.getInternalConstructor();
                        flag1 = flag2;
                        bindingimpl = ((BindingImpl) (obj));
                        if (!constructorbindingimpl.isInitialized())
                        {
                            flag1 = true;
                            bindingimpl = ((BindingImpl) (obj));
                        }
                    }
                    if (flag1)
                    {
                        removeFailedJitBinding(bindingimpl1, bindingimpl);
                        flag = true;
                    }
                } else
                if (state.getExplicitBinding(((Key) (obj))) == null)
                {
                    flag = true;
                }
            }
        } while (true);
        return flag;
    }

    private BindingImpl convertConstantStringBinding(Key key, Errors errors)
        throws ErrorsException
    {
        TypeConverterBinding typeconverterbinding;
        BindingImpl bindingimpl;
        Object obj2;
        Object obj = key.ofType(STRING_TYPE);
        bindingimpl = state.getExplicitBinding(((Key) (obj)));
        if (bindingimpl == null || !bindingimpl.isConstant())
        {
            return null;
        }
        obj = (String)bindingimpl.getProvider().get();
        Object obj1 = bindingimpl.getSource();
        TypeLiteral typeliteral = key.getTypeLiteral();
        typeconverterbinding = state.getConverter(((String) (obj)), typeliteral, errors, obj1);
        if (typeconverterbinding == null)
        {
            return null;
        }
        try
        {
            obj2 = typeconverterbinding.getTypeConverter().convert(((String) (obj)), typeliteral);
        }
        // Misplaced declaration of an exception variable
        catch (Key key)
        {
            throw key;
        }
        // Misplaced declaration of an exception variable
        catch (Key key)
        {
            throw errors.conversionError(((String) (obj)), obj1, typeliteral, typeconverterbinding, key).toException();
        }
        if (obj2 != null)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        throw errors.converterReturnedNull(((String) (obj)), obj1, typeliteral, typeconverterbinding).toException();
        if (!typeliteral.getRawType().isInstance(obj2))
        {
            throw errors.conversionTypeError(((String) (obj)), obj1, typeliteral, typeconverterbinding, obj2).toException();
        }
        key = new ConvertedConstantBindingImpl(this, key, obj2, bindingimpl, typeconverterbinding);
        return key;
    }

    private BindingImpl createImplementedByBinding(Key key, Scoping scoping, final ImplementedBy targetKey, Errors errors)
        throws ErrorsException
    {
        Class class1 = key.getTypeLiteral().getRawType();
        targetKey = targetKey.value();
        if (targetKey == class1)
        {
            throw errors.recursiveImplementationType().toException();
        }
        if (!class1.isAssignableFrom(targetKey))
        {
            throw errors.notASubtype(targetKey, class1).toException();
        } else
        {
            targetKey = Key.get(targetKey);
            return new LinkedBindingImpl(this, key, class1, Scoping.scope(key, this, new InternalFactory() {

                final InjectorImpl this$0;
                final BindingImpl val$targetBinding;
                final Key val$targetKey;

                public Object get(Errors errors1, InternalContext internalcontext, Dependency dependency, boolean flag)
                    throws ErrorsException
                {
                    internalcontext.pushState(targetKey, targetBinding.getSource());
                    errors1 = ((Errors) (targetBinding.getInternalFactory().get(errors1.withSource(targetKey), internalcontext, dependency, true)));
                    internalcontext.popState();
                    return errors1;
                    errors1;
                    internalcontext.popState();
                    throw errors1;
                }

            
            {
                this$0 = InjectorImpl.this;
                targetKey = key;
                targetBinding = bindingimpl;
                super();
            }
            }, class1, scoping), scoping, targetKey);
        }
    }

    private BindingImpl createJustInTimeBinding(Key key, Errors errors, boolean flag, JitLimitation jitlimitation)
        throws ErrorsException
    {
        int i;
        i = errors.size();
        Object obj = state.getSourcesForBlacklistedKey(key);
        if (state.isBlacklisted(key))
        {
            throw errors.childBindingAlreadySet(key, ((Set) (obj))).toException();
        }
        if (isProvider(key))
        {
            return createProviderBinding(key, errors);
        }
        if (isMembersInjector(key))
        {
            return createMembersInjectorBinding(key, errors);
        }
        obj = convertConstantStringBinding(key, errors);
        if (obj != null)
        {
            return ((BindingImpl) (obj));
        }
        if (!isTypeLiteral(key) && flag && jitlimitation != JitLimitation.NEW_OR_EXISTING_JIT)
        {
            throw errors.jitDisabled(key).toException();
        }
        if (key.getAnnotationType() == null)
        {
            break MISSING_BLOCK_LABEL_176;
        }
        if (!key.hasAttributes() || options.exactBindingAnnotationsRequired)
        {
            break MISSING_BLOCK_LABEL_167;
        }
        jitlimitation = new Errors();
        jitlimitation = getBindingOrThrow(key.withoutAttributes(), jitlimitation, JitLimitation.NO_JIT);
        return jitlimitation;
        jitlimitation;
        throw errors.missingImplementation(key).toException();
        jitlimitation = key.getTypeLiteral().getRawType();
        key = createUninitializedBinding(key, Scoping.UNSCOPED, jitlimitation, errors, true);
        errors.throwIfNewErrors(i);
        initializeJitBinding(key, errors);
        return key;
    }

    private BindingImpl createJustInTimeBindingRecursive(Key key, Errors errors, boolean flag, JitLimitation jitlimitation)
        throws ErrorsException
    {
        if (parent == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        Object obj;
        InjectorImpl injectorimpl;
        Errors errors1;
        injectorimpl = parent;
        errors1 = new Errors();
        if (!parent.options.jitDisabled)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        obj = JitLimitation.NO_JIT;
_L1:
        obj = injectorimpl.createJustInTimeBindingRecursive(key, errors1, flag, ((JitLimitation) (obj)));
        return ((BindingImpl) (obj));
        obj = jitlimitation;
          goto _L1
        ErrorsException errorsexception;
        errorsexception;
        Set set = state.getSourcesForBlacklistedKey(key);
        if (state.isBlacklisted(key))
        {
            throw errors.childBindingAlreadySet(key, set).toException();
        } else
        {
            errors = createJustInTimeBinding(key, errors, flag, jitlimitation);
            state.parent().blacklist(key, state, errors.getSource());
            jitBindings.put(key, errors);
            return errors;
        }
    }

    private BindingImpl createMembersInjectorBinding(Key key, Errors errors)
        throws ErrorsException
    {
        Object obj = key.getTypeLiteral().getType();
        if (!(obj instanceof ParameterizedType))
        {
            throw errors.cannotInjectRawMembersInjector().toException();
        } else
        {
            obj = TypeLiteral.get(((ParameterizedType)obj).getActualTypeArguments()[0]);
            errors = membersInjectorStore.get(((TypeLiteral) (obj)), errors);
            obj = new ConstantFactory(Initializables.of(errors));
            return new InstanceBindingImpl(this, key, SourceProvider.UNKNOWN_SOURCE, ((InternalFactory) (obj)), ImmutableSet.of(), errors);
        }
    }

    private BindingImpl createProviderBinding(Key key, Errors errors)
        throws ErrorsException
    {
        return new ProviderBindingImpl(this, key, getBindingOrThrow(getProvidedKey(key, errors), errors, JitLimitation.NO_JIT));
    }

    private BindingImpl createTypeLiteralBinding(Key key, Errors errors)
        throws ErrorsException
    {
        Object obj = key.getTypeLiteral().getType();
        if (!(obj instanceof ParameterizedType))
        {
            throw errors.cannotInjectRawTypeLiteral().toException();
        }
        obj = ((ParameterizedType)obj).getActualTypeArguments()[0];
        if (!(obj instanceof Class) && !(obj instanceof GenericArrayType) && !(obj instanceof ParameterizedType))
        {
            throw errors.cannotInjectTypeLiteralOf(((java.lang.reflect.Type) (obj))).toException();
        } else
        {
            errors = TypeLiteral.get(((java.lang.reflect.Type) (obj)));
            obj = new ConstantFactory(Initializables.of(errors));
            return new InstanceBindingImpl(this, key, SourceProvider.UNKNOWN_SOURCE, ((InternalFactory) (obj)), ImmutableSet.of(), errors);
        }
    }

    private Set getInternalDependencies(BindingImpl bindingimpl)
    {
        if (bindingimpl instanceof ConstructorBindingImpl)
        {
            return ((ConstructorBindingImpl)bindingimpl).getInternalDependencies();
        }
        if (bindingimpl instanceof HasDependencies)
        {
            return ((HasDependencies)bindingimpl).getDependencies();
        } else
        {
            return ImmutableSet.of();
        }
    }

    private BindingImpl getJustInTimeBinding(Key key, Errors errors, JitLimitation jitlimitation)
        throws ErrorsException
    {
        InjectorImpl injectorimpl;
        Object obj;
        BindingImpl bindingimpl;
        boolean flag;
        if (isProvider(key) || isTypeLiteral(key) || isMembersInjector(key))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = state.lock();
        obj;
        JVM INSTR monitorenter ;
        injectorimpl = this;
_L1:
        if (injectorimpl == null)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        bindingimpl = (BindingImpl)injectorimpl.jitBindings.get(key);
        if (bindingimpl == null)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        if (!options.jitDisabled || jitlimitation != JitLimitation.NO_JIT || flag)
        {
            break MISSING_BLOCK_LABEL_118;
        }
        if (!(bindingimpl instanceof ConvertedConstantBindingImpl))
        {
            throw errors.jitDisabled(key).toException();
        }
        break MISSING_BLOCK_LABEL_118;
        key;
        obj;
        JVM INSTR monitorexit ;
        throw key;
        obj;
        JVM INSTR monitorexit ;
        return bindingimpl;
        injectorimpl = injectorimpl.parent;
          goto _L1
        if (failedJitBindings.contains(key) && errors.hasErrors())
        {
            throw errors.toException();
        }
        key = createJustInTimeBindingRecursive(key, errors, options.jitDisabled, jitlimitation);
        obj;
        JVM INSTR monitorexit ;
        return key;
    }

    private static Key getProvidedKey(Key key, Errors errors)
        throws ErrorsException
    {
        java.lang.reflect.Type type = key.getTypeLiteral().getType();
        if (!(type instanceof ParameterizedType))
        {
            throw errors.cannotInjectRawProvider().toException();
        } else
        {
            return key.ofType(((ParameterizedType)type).getActualTypeArguments()[0]);
        }
    }

    private static boolean isMembersInjector(Key key)
    {
        return key.getTypeLiteral().getRawType().equals(com/google/inject/MembersInjector) && key.getAnnotationType() == null;
    }

    private static boolean isProvider(Key key)
    {
        return key.getTypeLiteral().getRawType().equals(com/google/inject/Provider);
    }

    private static boolean isTypeLiteral(Key key)
    {
        return key.getTypeLiteral().getRawType().equals(com/google/inject/TypeLiteral);
    }

    private void removeFailedJitBinding(Binding binding, InjectionPoint injectionpoint)
    {
        failedJitBindings.add(binding.getKey());
        jitBindings.remove(binding.getKey());
        membersInjectorStore.remove(binding.getKey().getTypeLiteral());
        provisionListenerStore.remove(binding);
        if (injectionpoint != null)
        {
            constructors.remove(injectionpoint);
        }
    }

    Object callInContext(ContextualCallable contextualcallable)
        throws ErrorsException
    {
        Object aobj[];
        Object aobj1[] = (Object[])localContext.get();
        aobj = aobj1;
        if (aobj1 == null)
        {
            aobj = new Object[1];
            localContext.set(((Object) (aobj)));
        }
        if (aobj[0] != null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        aobj[0] = new InternalContext();
        contextualcallable = ((ContextualCallable) (contextualcallable.call((InternalContext)aobj[0])));
        aobj[0] = null;
        return contextualcallable;
        contextualcallable;
        aobj[0] = null;
        throw contextualcallable;
        return contextualcallable.call((InternalContext)aobj[0]);
    }

    public Injector createChildInjector(Iterable iterable)
    {
        return (new InternalInjectorCreator()).parentInjector(this).addModules(iterable).build();
    }

    public transient Injector createChildInjector(Module amodule[])
    {
        return createChildInjector(((Iterable) (ImmutableList.copyOf(amodule))));
    }

    SingleParameterInjector createParameterInjector(Dependency dependency, Errors errors)
        throws ErrorsException
    {
        return new SingleParameterInjector(dependency, getBindingOrThrow(dependency.getKey(), errors, JitLimitation.NO_JIT));
    }

    BindingImpl createProvidedByBinding(Key key, Scoping scoping, ProvidedBy providedby, Errors errors)
        throws ErrorsException
    {
        Class class1 = key.getTypeLiteral().getRawType();
        providedby = providedby.value();
        if (providedby == class1)
        {
            throw errors.recursiveProviderType().toException();
        }
        errors = Key.get(providedby);
        boolean flag;
        if (!options.disableCircularProxies)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        providedby = new ProvidedByInternalFactory(class1, providedby, errors, flag);
        key = LinkedProviderBindingImpl.createWithInitializer(this, key, class1, Scoping.scope(key, this, providedby, class1, scoping), scoping, errors, providedby);
        providedby.setProvisionListenerCallback(provisionListenerStore.get(key));
        return key;
    }

    BindingImpl createUninitializedBinding(Key key, Scoping scoping, Object obj, Errors errors, boolean flag)
        throws ErrorsException
    {
        Class class1 = key.getTypeLiteral().getRawType();
        Object obj1 = (ImplementedBy)class1.getAnnotation(com/google/inject/ImplementedBy);
        if (class1.isArray() || class1.isEnum() && obj1 != null)
        {
            throw errors.missingImplementation(key).toException();
        }
        if (class1 == com/google/inject/TypeLiteral)
        {
            return createTypeLiteralBinding(key, errors);
        }
        if (obj1 != null)
        {
            Annotations.checkForMisplacedScopeAnnotations(class1, obj, errors);
            return createImplementedByBinding(key, scoping, ((ImplementedBy) (obj1)), errors);
        }
        obj1 = (ProvidedBy)class1.getAnnotation(com/google/inject/ProvidedBy);
        if (obj1 != null)
        {
            Annotations.checkForMisplacedScopeAnnotations(class1, obj, errors);
            return createProvidedByBinding(key, scoping, ((ProvidedBy) (obj1)), errors);
        }
        if (flag && options.jitDisabled)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return ConstructorBindingImpl.create(this, key, null, obj, scoping, errors, flag, options.atInjectRequired);
    }

    public List findBindingsByType(TypeLiteral typeliteral)
    {
        return bindingsMultimap.getAll(typeliteral);
    }

    public Map getAllBindings()
    {
        ImmutableMap immutablemap;
        synchronized (state.lock())
        {
            immutablemap = (new org.roboguice.shaded.goole.common.collect.ImmutableMap.Builder()).putAll(state.getExplicitBindingsThisLevel()).putAll(jitBindings).build();
        }
        return immutablemap;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public volatile Binding getBinding(Key key)
    {
        return getBinding(key);
    }

    public Binding getBinding(Class class1)
    {
        return getBinding(Key.get(class1));
    }

    public BindingImpl getBinding(Key key)
    {
        Errors errors = new Errors(key);
        try
        {
            key = getBindingOrThrow(key, errors, JitLimitation.EXISTING_JIT);
            errors.throwConfigurationExceptionIfErrorsExist();
        }
        // Misplaced declaration of an exception variable
        catch (Key key)
        {
            throw new ConfigurationException(errors.merge(key.getErrors()).getMessages());
        }
        return key;
    }

    BindingImpl getBindingOrThrow(Key key, Errors errors, JitLimitation jitlimitation)
        throws ErrorsException
    {
        BindingImpl bindingimpl = state.getExplicitBinding(key);
        if (bindingimpl != null)
        {
            return bindingimpl;
        } else
        {
            return getJustInTimeBinding(key, errors, jitlimitation);
        }
    }

    public Map getBindings()
    {
        return state.getExplicitBindingsThisLevel();
    }

    public volatile Binding getExistingBinding(Key key)
    {
        return getExistingBinding(key);
    }

    public BindingImpl getExistingBinding(Key key)
    {
        BindingImpl bindingimpl = state.getExplicitBinding(key);
        if (bindingimpl != null)
        {
            return bindingimpl;
        }
        Object obj = state.lock();
        obj;
        JVM INSTR monitorenter ;
        InjectorImpl injectorimpl = this;
_L1:
        if (injectorimpl == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        BindingImpl bindingimpl1 = (BindingImpl)injectorimpl.jitBindings.get(key);
        if (bindingimpl1 == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        obj;
        JVM INSTR monitorexit ;
        return bindingimpl1;
        injectorimpl = injectorimpl.parent;
          goto _L1
        obj;
        JVM INSTR monitorexit ;
        if (!isProvider(key))
        {
            break MISSING_BLOCK_LABEL_124;
        }
        try
        {
            if (getExistingBinding(getProvidedKey(key, new Errors())) == null)
            {
                break MISSING_BLOCK_LABEL_124;
            }
            key = getBinding(key);
        }
        // Misplaced declaration of an exception variable
        catch (Key key)
        {
            throw new ConfigurationException(key.getErrors().getMessages());
        }
        return key;
        key;
        obj;
        JVM INSTR monitorexit ;
        throw key;
        return null;
    }

    public Object getInstance(Key key)
    {
        return getProvider(key).get();
    }

    public Object getInstance(Class class1)
    {
        return getProvider(class1).get();
    }

    InternalFactory getInternalFactory(Key key, Errors errors, JitLimitation jitlimitation)
        throws ErrorsException
    {
        return getBindingOrThrow(key, errors, jitlimitation).getInternalFactory();
    }

    public MembersInjector getMembersInjector(TypeLiteral typeliteral)
    {
        Errors errors = new Errors(typeliteral);
        try
        {
            typeliteral = membersInjectorStore.get(typeliteral, errors);
        }
        // Misplaced declaration of an exception variable
        catch (TypeLiteral typeliteral)
        {
            throw new ConfigurationException(errors.merge(typeliteral.getErrors()).getMessages());
        }
        return typeliteral;
    }

    public MembersInjector getMembersInjector(Class class1)
    {
        return getMembersInjector(TypeLiteral.get(class1));
    }

    SingleParameterInjector[] getParametersInjectors(List list, Errors errors)
        throws ErrorsException
    {
        if (list.isEmpty())
        {
            return null;
        }
        int j = errors.size();
        SingleParameterInjector asingleparameterinjector[] = new SingleParameterInjector[list.size()];
        int i = 0;
        list = list.iterator();
        while (list.hasNext()) 
        {
            Dependency dependency = (Dependency)list.next();
            try
            {
                asingleparameterinjector[i] = createParameterInjector(dependency, errors.withSource(dependency));
            }
            catch (ErrorsException errorsexception) { }
            i++;
        }
        errors.throwIfNewErrors(j);
        return asingleparameterinjector;
    }

    public Injector getParent()
    {
        return parent;
    }

    public Provider getProvider(Key key)
    {
        Errors errors = new Errors(key);
        try
        {
            key = getProviderOrThrow(key, errors);
            errors.throwIfNewErrors(0);
        }
        // Misplaced declaration of an exception variable
        catch (Key key)
        {
            throw new ConfigurationException(errors.merge(key.getErrors()).getMessages());
        }
        return key;
    }

    public Provider getProvider(Class class1)
    {
        return getProvider(Key.get(class1));
    }

    Provider getProviderOrThrow(Key key, Errors errors)
        throws ErrorsException
    {
        errors = getBindingOrThrow(key, errors, JitLimitation.NO_JIT);
        return new Provider() {

            final InjectorImpl this$0;
            final BindingImpl val$binding;
            final Dependency val$dependency;

            public Object get()
            {
                Errors errors1 = new Errors(dependency);
                Object obj;
                try
                {
                    obj = callInContext(errors1. new ContextualCallable() {

                        final _cls2 this$1;
                        final Errors val$errors;

                        public Object call(InternalContext internalcontext)
                            throws ErrorsException
                        {
                            Dependency dependency = internalcontext.pushDependency(_cls2.this.dependency, binding.getSource());
                            Object obj = binding.getInternalFactory().get(errors, internalcontext, _cls2.this.dependency, false);
                            internalcontext.popStateAndSetDependency(dependency);
                            return obj;
                            Exception exception;
                            exception;
                            internalcontext.popStateAndSetDependency(dependency);
                            throw exception;
                        }

            
            {
                this$1 = final__pcls2;
                errors = Errors.this;
                super();
            }
                    });
                    errors1.throwIfNewErrors(0);
                }
                catch (ErrorsException errorsexception)
                {
                    throw new ProvisionException(errors1.merge(errorsexception.getErrors()).getMessages());
                }
                return obj;
            }

            public String toString()
            {
                return binding.getInternalFactory().toString();
            }

            
            {
                this$0 = InjectorImpl.this;
                dependency = dependency1;
                binding = bindingimpl;
                super();
            }
        };
    }

    public Map getScopeBindings()
    {
        return ImmutableMap.copyOf(state.getScopes());
    }

    public Set getTypeConverterBindings()
    {
        return ImmutableSet.copyOf(state.getConvertersThisLevel());
    }

    void index()
    {
        for (Iterator iterator = state.getExplicitBindingsThisLevel().values().iterator(); iterator.hasNext(); index((Binding)iterator.next())) { }
    }

    void index(Binding binding)
    {
        bindingsMultimap.put(binding.getKey().getTypeLiteral(), binding);
    }

    void initializeBinding(BindingImpl bindingimpl, Errors errors)
        throws ErrorsException
    {
        if (bindingimpl instanceof DelayedInitialize)
        {
            ((DelayedInitialize)bindingimpl).initialize(this, errors);
        }
    }

    void initializeJitBinding(BindingImpl bindingimpl, Errors errors)
        throws ErrorsException
    {
        Object obj;
        if (!(bindingimpl instanceof DelayedInitialize))
        {
            break MISSING_BLOCK_LABEL_60;
        }
        obj = bindingimpl.getKey();
        jitBindings.put(obj, bindingimpl);
        obj = (DelayedInitialize)bindingimpl;
        ((DelayedInitialize) (obj)).initialize(this, errors);
        if (false)
        {
            removeFailedJitBinding(bindingimpl, null);
            cleanup(bindingimpl, new HashSet());
        }
        return;
        errors;
        if (true)
        {
            removeFailedJitBinding(bindingimpl, null);
            cleanup(bindingimpl, new HashSet());
        }
        throw errors;
    }

    public void injectMembers(Object obj)
    {
        getMembersInjector(obj.getClass()).injectMembers(obj);
    }

    public String toString()
    {
        return Objects.toStringHelper(com/google/inject/Injector).add("bindings", state.getExplicitBindingsThisLevel().values()).toString();
    }

}
