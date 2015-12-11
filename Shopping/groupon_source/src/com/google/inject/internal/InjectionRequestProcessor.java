// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.ConfigurationException;
import com.google.inject.Stage;
import com.google.inject.spi.InjectionPoint;
import com.google.inject.spi.InjectionRequest;
import com.google.inject.spi.StaticInjectionRequest;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.roboguice.shaded.goole.common.collect.ImmutableList;
import org.roboguice.shaded.goole.common.collect.Lists;

// Referenced classes of package com.google.inject.internal:
//            AbstractProcessor, Initializer, Errors, ErrorsException, 
//            InjectorImpl, MembersInjectorStore, ContextualCallable, SingleMemberInjector, 
//            InternalContext

final class InjectionRequestProcessor extends AbstractProcessor
{
    private class StaticInjection
    {

        final InjectorImpl injector;
        ImmutableList memberInjectors;
        final StaticInjectionRequest request;
        final Object source;
        final InjectionRequestProcessor this$0;

        void injectMembers()
        {
            try
            {
                injector.callInContext(new ContextualCallable() {

                    final StaticInjection this$1;

                    public volatile Object call(InternalContext internalcontext)
                        throws ErrorsException
                    {
                        return call(internalcontext);
                    }

                    public Void call(InternalContext internalcontext)
                    {
                        org.roboguice.shaded.goole.common.collect.UnmodifiableIterator unmodifiableiterator = memberInjectors.iterator();
                        do
                        {
                            if (!unmodifiableiterator.hasNext())
                            {
                                break;
                            }
                            SingleMemberInjector singlememberinjector = (SingleMemberInjector)unmodifiableiterator.next();
                            if (injector.options.stage != Stage.TOOL || singlememberinjector.getInjectionPoint().isToolable())
                            {
                                singlememberinjector.inject(errors, internalcontext, null);
                            }
                        } while (true);
                        return null;
                    }

            
            {
                this$1 = StaticInjection.this;
                super();
            }
                });
                return;
            }
            catch (ErrorsException errorsexception)
            {
                throw new AssertionError();
            }
        }

        void validate()
        {
            Errors errors = InjectionRequestProcessor.this.errors.withSource(source);
            Set set;
            try
            {
                set = request.getInjectionPoints();
            }
            catch (ConfigurationException configurationexception)
            {
                errors.merge(configurationexception.getErrorMessages());
                configurationexception = (Set)configurationexception.getPartialValue();
            }
            if (set != null)
            {
                memberInjectors = injector.membersInjectorStore.getInjectors(set, errors);
            } else
            {
                memberInjectors = ImmutableList.of();
            }
            InjectionRequestProcessor.this.errors.merge(errors);
        }

        public StaticInjection(InjectorImpl injectorimpl, StaticInjectionRequest staticinjectionrequest)
        {
            this$0 = InjectionRequestProcessor.this;
            super();
            injector = injectorimpl;
            source = staticinjectionrequest.getSource();
            request = staticinjectionrequest;
        }
    }


    private final Initializer initializer;
    private final List staticInjections = Lists.newArrayList();

    InjectionRequestProcessor(Errors errors, Initializer initializer1)
    {
        super(errors);
        initializer = initializer1;
    }

    void injectMembers()
    {
        for (Iterator iterator = staticInjections.iterator(); iterator.hasNext(); ((StaticInjection)iterator.next()).injectMembers()) { }
    }

    void validate()
    {
        for (Iterator iterator = staticInjections.iterator(); iterator.hasNext(); ((StaticInjection)iterator.next()).validate()) { }
    }

    public Boolean visit(InjectionRequest injectionrequest)
    {
        Set set;
        try
        {
            set = injectionrequest.getInjectionPoints();
        }
        catch (ConfigurationException configurationexception)
        {
            errors.merge(configurationexception.getErrorMessages());
            configurationexception = (Set)configurationexception.getPartialValue();
        }
        initializer.requestInjection(injector, injectionrequest.getInstance(), null, injectionrequest.getSource(), set);
        return Boolean.valueOf(true);
    }

    public Boolean visit(StaticInjectionRequest staticinjectionrequest)
    {
        staticInjections.add(new StaticInjection(injector, staticinjectionrequest));
        return Boolean.valueOf(true);
    }

    public volatile Object visit(InjectionRequest injectionrequest)
    {
        return visit(injectionrequest);
    }

    public volatile Object visit(StaticInjectionRequest staticinjectionrequest)
    {
        return visit(staticinjectionrequest);
    }
}
