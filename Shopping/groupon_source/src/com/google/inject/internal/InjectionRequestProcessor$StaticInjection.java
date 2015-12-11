// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.ConfigurationException;
import com.google.inject.Stage;
import com.google.inject.spi.InjectionPoint;
import com.google.inject.spi.StaticInjectionRequest;
import java.util.Iterator;
import java.util.Set;
import org.roboguice.shaded.goole.common.collect.ImmutableList;

// Referenced classes of package com.google.inject.internal:
//            InjectionRequestProcessor, ErrorsException, InjectorImpl, Errors, 
//            MembersInjectorStore, ContextualCallable, SingleMemberInjector, InternalContext

private class request
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

                final InjectionRequestProcessor.StaticInjection this$1;

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
                this$1 = InjectionRequestProcessor.StaticInjection.this;
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

    public _cls1.this._cls1(InjectorImpl injectorimpl, StaticInjectionRequest staticinjectionrequest)
    {
        this$0 = InjectionRequestProcessor.this;
        super();
        injector = injectorimpl;
        source = staticinjectionrequest.getSource();
        request = staticinjectionrequest;
    }
}
