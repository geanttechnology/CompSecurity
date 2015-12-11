// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Key;
import com.google.inject.MembersInjector;
import com.google.inject.TypeLiteral;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.InjectionPoint;
import java.util.Iterator;
import org.roboguice.shaded.goole.common.collect.ImmutableList;
import org.roboguice.shaded.goole.common.collect.ImmutableSet;

// Referenced classes of package com.google.inject.internal:
//            EncounterImpl, SingleMemberInjector, ErrorsException, InjectorImpl, 
//            Errors, ProvisionListenerStackCallback, InternalContext, ContextualCallable

final class MembersInjectorImpl
    implements MembersInjector
{

    private final ImmutableSet injectionListeners;
    private final InjectorImpl injector;
    private final ImmutableList memberInjectors;
    private final TypeLiteral typeLiteral;
    private final ImmutableSet userMembersInjectors;

    MembersInjectorImpl(InjectorImpl injectorimpl, TypeLiteral typeliteral, EncounterImpl encounterimpl, ImmutableList immutablelist)
    {
        injector = injectorimpl;
        typeLiteral = typeliteral;
        memberInjectors = immutablelist;
        userMembersInjectors = encounterimpl.getMembersInjectors();
        injectionListeners = encounterimpl.getInjectionListeners();
    }

    public ImmutableSet getInjectionPoints()
    {
        org.roboguice.shaded.goole.common.collect.ImmutableSet.Builder builder = ImmutableSet.builder();
        for (org.roboguice.shaded.goole.common.collect.UnmodifiableIterator unmodifiableiterator = memberInjectors.iterator(); unmodifiableiterator.hasNext(); builder.add(((SingleMemberInjector)unmodifiableiterator.next()).getInjectionPoint())) { }
        return builder.build();
    }

    public ImmutableList getMemberInjectors()
    {
        return memberInjectors;
    }

    void injectAndNotify(final Object instance, final Errors errors, final Key key, final ProvisionListenerStackCallback provisionCallback, final Object source, final boolean toolableOnly)
        throws ErrorsException
    {
        if (instance != null)
        {
            injector.callInContext(new ContextualCallable() {

                final MembersInjectorImpl this$0;
                final Errors val$errors;
                final Object val$instance;
                final Key val$key;
                final ProvisionListenerStackCallback val$provisionCallback;
                final Object val$source;
                final boolean val$toolableOnly;

                public volatile Object call(InternalContext internalcontext)
                    throws ErrorsException
                {
                    return call(internalcontext);
                }

                public Void call(InternalContext internalcontext)
                    throws ErrorsException
                {
                    internalcontext.pushState(key, source);
                    if (provisionCallback == null || !provisionCallback.hasListeners()) goto _L2; else goto _L1
_L1:
                    provisionCallback.provision(errors, internalcontext, internalcontext. new ProvisionListenerStackCallback.ProvisionCallback() {

                        final _cls1 this$1;
                        final InternalContext val$context;

                        public Object call()
                        {
                            injectMembers(instance, errors, context, toolableOnly);
                            return instance;
                        }

            
            {
                this$1 = final__pcls1;
                context = InternalContext.this;
                super();
            }
                    });
_L4:
                    internalcontext.popState();
                    return null;
_L2:
                    injectMembers(instance, errors, internalcontext, toolableOnly);
                    if (true) goto _L4; else goto _L3
_L3:
                    Exception exception;
                    exception;
                    internalcontext.popState();
                    throw exception;
                }

            
            {
                this$0 = MembersInjectorImpl.this;
                key = key1;
                source = obj;
                provisionCallback = provisionlistenerstackcallback;
                errors = errors1;
                instance = obj1;
                toolableOnly = flag;
                super();
            }
            });
            if (!toolableOnly)
            {
                notifyListeners(instance, errors);
                return;
            }
        }
    }

    public void injectMembers(Object obj)
    {
        Errors errors = new Errors(typeLiteral);
        try
        {
            injectAndNotify(obj, errors, null, null, typeLiteral, false);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            errors.merge(((ErrorsException) (obj)).getErrors());
        }
        errors.throwProvisionExceptionIfErrorsExist();
    }

    void injectMembers(Object obj, Errors errors, InternalContext internalcontext, boolean flag)
    {
        int i = 0;
        for (int j = memberInjectors.size(); i < j; i++)
        {
            SingleMemberInjector singlememberinjector = (SingleMemberInjector)memberInjectors.get(i);
            if (!flag || singlememberinjector.getInjectionPoint().isToolable())
            {
                singlememberinjector.inject(errors, internalcontext, obj);
            }
        }

        if (!flag)
        {
            for (internalcontext = userMembersInjectors.iterator(); internalcontext.hasNext();)
            {
                MembersInjector membersinjector = (MembersInjector)internalcontext.next();
                try
                {
                    membersinjector.injectMembers(obj);
                }
                catch (RuntimeException runtimeexception)
                {
                    errors.errorInUserInjector(membersinjector, typeLiteral, runtimeexception);
                }
            }

        }
    }

    void notifyListeners(Object obj, Errors errors)
        throws ErrorsException
    {
        int i = errors.size();
        for (org.roboguice.shaded.goole.common.collect.UnmodifiableIterator unmodifiableiterator = injectionListeners.iterator(); unmodifiableiterator.hasNext();)
        {
            InjectionListener injectionlistener = (InjectionListener)unmodifiableiterator.next();
            try
            {
                injectionlistener.afterInjection(obj);
            }
            catch (RuntimeException runtimeexception)
            {
                errors.errorNotifyingInjectionListener(injectionlistener, typeLiteral, runtimeexception);
            }
        }

        errors.throwIfNewErrors(i);
    }

    public String toString()
    {
        return (new StringBuilder()).append("MembersInjector<").append(typeLiteral).append(">").toString();
    }
}
