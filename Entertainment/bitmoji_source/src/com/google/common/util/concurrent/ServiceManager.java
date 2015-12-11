// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.SetMultimap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.google.common.util.concurrent:
//            Service, MoreExecutors, AbstractService, Monitor, 
//            ListenerCallQueue

public final class ServiceManager
{
    private static final class EmptyServiceManagerWarning extends Throwable
    {

        private EmptyServiceManagerWarning()
        {
        }

    }

    public static abstract class Listener
    {

        public void failure(Service service)
        {
        }

        public void healthy()
        {
        }

        public void stopped()
        {
        }

        public Listener()
        {
        }
    }

    private static final class NoOpService extends AbstractService
    {

        protected void doStart()
        {
            notifyStarted();
        }

        protected void doStop()
        {
            notifyStopped();
        }

        private NoOpService()
        {
        }

    }

    private static final class ServiceListener extends Service.Listener
    {

        final Service service;
        final WeakReference state;

        public void failed(Service.State state1, Throwable throwable)
        {
            ServiceManagerState servicemanagerstate = (ServiceManagerState)state.get();
            if (servicemanagerstate != null)
            {
                if (!(service instanceof NoOpService))
                {
                    Logger logger1 = ServiceManager.logger;
                    Level level = Level.SEVERE;
                    String s = String.valueOf(service);
                    String s1 = String.valueOf(state1);
                    logger1.log(level, (new StringBuilder(String.valueOf(s).length() + 34 + String.valueOf(s1).length())).append("Service ").append(s).append(" has failed in the ").append(s1).append(" state.").toString(), throwable);
                }
                servicemanagerstate.transitionService(service, state1, Service.State.FAILED);
            }
        }

        public void running()
        {
            ServiceManagerState servicemanagerstate = (ServiceManagerState)state.get();
            if (servicemanagerstate != null)
            {
                servicemanagerstate.transitionService(service, Service.State.STARTING, Service.State.RUNNING);
            }
        }

        public void starting()
        {
            ServiceManagerState servicemanagerstate = (ServiceManagerState)state.get();
            if (servicemanagerstate != null)
            {
                servicemanagerstate.transitionService(service, Service.State.NEW, Service.State.STARTING);
                if (!(service instanceof NoOpService))
                {
                    ServiceManager.logger.log(Level.FINE, "Starting {0}.", service);
                }
            }
        }

        public void stopping(Service.State state1)
        {
            ServiceManagerState servicemanagerstate = (ServiceManagerState)state.get();
            if (servicemanagerstate != null)
            {
                servicemanagerstate.transitionService(service, state1, Service.State.STOPPING);
            }
        }

        public void terminated(Service.State state1)
        {
            ServiceManagerState servicemanagerstate = (ServiceManagerState)state.get();
            if (servicemanagerstate != null)
            {
                if (!(service instanceof NoOpService))
                {
                    ServiceManager.logger.log(Level.FINE, "Service {0} has terminated. Previous state was: {1}", new Object[] {
                        service, state1
                    });
                }
                servicemanagerstate.transitionService(service, state1, Service.State.TERMINATED);
            }
        }

        ServiceListener(Service service1, WeakReference weakreference)
        {
            service = service1;
            state = weakreference;
        }
    }

    private static final class ServiceManagerState
    {

        final Monitor.Guard awaitHealthGuard = new AwaitHealthGuard();
        final List listeners = Collections.synchronizedList(new ArrayList());
        final Monitor monitor = new Monitor();
        final int numberOfServices;
        boolean ready;
        final SetMultimap servicesByState = MultimapBuilder.enumKeys(com/google/common/util/concurrent/Service$State).linkedHashSetValues().build();
        final Map startupTimers = Maps.newIdentityHashMap();
        final Multiset states;
        final Monitor.Guard stoppedGuard = new StoppedGuard();
        boolean transitioned;

        void addListener(Listener listener, Executor executor)
        {
            Preconditions.checkNotNull(listener, "listener");
            Preconditions.checkNotNull(executor, "executor");
            monitor.enter();
            if (!stoppedGuard.isSatisfied())
            {
                listeners.add(new ListenerCallQueue(listener, executor));
            }
            monitor.leave();
            return;
            listener;
            monitor.leave();
            throw listener;
        }

        void awaitHealthy()
        {
            monitor.enterWhenUninterruptibly(awaitHealthGuard);
            checkHealthy();
            monitor.leave();
            return;
            Exception exception;
            exception;
            monitor.leave();
            throw exception;
        }

        void awaitHealthy(long l, TimeUnit timeunit)
            throws TimeoutException
        {
            monitor.enter();
            if (!monitor.waitForUninterruptibly(awaitHealthGuard, l, timeunit))
            {
                timeunit = String.valueOf("Timeout waiting for the services to become healthy. The following services have not started: ");
                String s = String.valueOf(Multimaps.filterKeys(servicesByState, Predicates.in(ImmutableSet.of(Service.State.NEW, Service.State.STARTING))));
                throw new TimeoutException((new StringBuilder(String.valueOf(timeunit).length() + 0 + String.valueOf(s).length())).append(timeunit).append(s).toString());
            }
            break MISSING_BLOCK_LABEL_108;
            timeunit;
            monitor.leave();
            throw timeunit;
            checkHealthy();
            monitor.leave();
            return;
        }

        void awaitStopped()
        {
            monitor.enterWhenUninterruptibly(stoppedGuard);
            monitor.leave();
        }

        void awaitStopped(long l, TimeUnit timeunit)
            throws TimeoutException
        {
            monitor.enter();
            if (!monitor.waitForUninterruptibly(stoppedGuard, l, timeunit))
            {
                timeunit = String.valueOf("Timeout waiting for the services to stop. The following services have not stopped: ");
                String s = String.valueOf(Multimaps.filterKeys(servicesByState, Predicates.not(Predicates.in(EnumSet.of(Service.State.TERMINATED, Service.State.FAILED)))));
                throw new TimeoutException((new StringBuilder(String.valueOf(timeunit).length() + 0 + String.valueOf(s).length())).append(timeunit).append(s).toString());
            }
            break MISSING_BLOCK_LABEL_111;
            timeunit;
            monitor.leave();
            throw timeunit;
            monitor.leave();
            return;
        }

        void checkHealthy()
        {
            if (states.count(Service.State.RUNNING) != numberOfServices)
            {
                String s = String.valueOf(Multimaps.filterKeys(servicesByState, Predicates.not(Predicates.equalTo(Service.State.RUNNING))));
                throw new IllegalStateException((new StringBuilder(String.valueOf(s).length() + 79)).append("Expected to be healthy after starting. The following services are not running: ").append(s).toString());
            } else
            {
                return;
            }
        }

        void executeListeners()
        {
            boolean flag;
            if (!monitor.isOccupiedByCurrentThread())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkState(flag, "It is incorrect to execute listeners with the monitor held.");
            for (int i = 0; i < listeners.size(); i++)
            {
                ((ListenerCallQueue)listeners.get(i)).execute();
            }

        }

        void fireFailedListeners(Service service)
        {
            String s = String.valueOf(service);
            ((new StringBuilder(String.valueOf(s).length() + 18)).append("failed({service=").append(s).append("})").toString(). new ListenerCallQueue.Callback(service) {

                final ServiceManagerState this$0;
                final Service val$service;

                void call(Listener listener)
                {
                    listener.failure(service);
                }

                volatile void call(Object obj)
                {
                    call((Listener)obj);
                }

            
            {
                this$0 = final_servicemanagerstate;
                service = service1;
                super(String.this);
            }
            }).enqueueOn(listeners);
        }

        void fireHealthyListeners()
        {
            ServiceManager.HEALTHY_CALLBACK.enqueueOn(listeners);
        }

        void fireStoppedListeners()
        {
            ServiceManager.STOPPED_CALLBACK.enqueueOn(listeners);
        }

        void markReady()
        {
            monitor.enter();
            if (transitioned)
            {
                break MISSING_BLOCK_LABEL_27;
            }
            ready = true;
            monitor.leave();
            return;
            Object obj;
            obj = Lists.newArrayList();
            com.google.common.collect.UnmodifiableIterator unmodifiableiterator = servicesByState().values().iterator();
            do
            {
                if (!unmodifiableiterator.hasNext())
                {
                    break;
                }
                Service service = (Service)unmodifiableiterator.next();
                if (service.state() != Service.State.NEW)
                {
                    ((List) (obj)).add(service);
                }
            } while (true);
            break MISSING_BLOCK_LABEL_94;
            obj;
            monitor.leave();
            throw obj;
            String s = String.valueOf("Services started transitioning asynchronously before the ServiceManager was constructed: ");
            obj = String.valueOf(obj);
            throw new IllegalArgumentException((new StringBuilder(String.valueOf(s).length() + 0 + String.valueOf(obj).length())).append(s).append(((String) (obj))).toString());
        }

        ImmutableMultimap servicesByState()
        {
            Object obj;
            obj = ImmutableSetMultimap.builder();
            monitor.enter();
            Iterator iterator = servicesByState.entries().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                if (!(entry.getValue() instanceof NoOpService))
                {
                    ((com.google.common.collect.ImmutableSetMultimap.Builder) (obj)).put(entry);
                }
            } while (true);
            break MISSING_BLOCK_LABEL_76;
            obj;
            monitor.leave();
            throw obj;
            monitor.leave();
            return ((com.google.common.collect.ImmutableSetMultimap.Builder) (obj)).build();
        }

        ImmutableMap startupTimes()
        {
            monitor.enter();
            Object obj;
            obj = Lists.newArrayListWithCapacity(startupTimers.size());
            Iterator iterator = startupTimers.entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj1 = (java.util.Map.Entry)iterator.next();
                Service service = (Service)((java.util.Map.Entry) (obj1)).getKey();
                obj1 = (Stopwatch)((java.util.Map.Entry) (obj1)).getValue();
                if (!((Stopwatch) (obj1)).isRunning() && !(service instanceof NoOpService))
                {
                    ((List) (obj)).add(Maps.immutableEntry(service, Long.valueOf(((Stopwatch) (obj1)).elapsed(TimeUnit.MILLISECONDS))));
                }
            } while (true);
            break MISSING_BLOCK_LABEL_128;
            obj;
            monitor.leave();
            throw obj;
            monitor.leave();
            Collections.sort(((List) (obj)), Ordering.natural().onResultOf(new Function() {

                final ServiceManagerState this$0;

                public Long apply(java.util.Map.Entry entry)
                {
                    return (Long)entry.getValue();
                }

                public volatile Object apply(Object obj)
                {
                    return apply((java.util.Map.Entry)obj);
                }

            
            {
                this$0 = ServiceManagerState.this;
                super();
            }
            }));
            return ImmutableMap.copyOf(((Iterable) (obj)));
        }

        void transitionService(Service service, Service.State state1, Service.State state2)
        {
            boolean flag = true;
            Preconditions.checkNotNull(service);
            if (state1 == state2)
            {
                flag = false;
            }
            Preconditions.checkArgument(flag);
            monitor.enter();
            transitioned = true;
            flag = ready;
            if (!flag)
            {
                monitor.leave();
                executeListeners();
                return;
            }
            Stopwatch stopwatch;
            Preconditions.checkState(servicesByState.remove(state1, service), "Service %s not at the expected location in the state map %s", new Object[] {
                service, state1
            });
            Preconditions.checkState(servicesByState.put(state2, service), "Service %s in the state map unexpectedly at %s", new Object[] {
                service, state2
            });
            stopwatch = (Stopwatch)startupTimers.get(service);
            state1 = stopwatch;
            if (stopwatch != null)
            {
                break MISSING_BLOCK_LABEL_156;
            }
            state1 = Stopwatch.createStarted();
            startupTimers.put(service, state1);
            if (state2.compareTo(Service.State.RUNNING) >= 0 && state1.isRunning())
            {
                state1.stop();
                if (!(service instanceof NoOpService))
                {
                    ServiceManager.logger.log(Level.FINE, "Started {0} in {1}.", new Object[] {
                        service, state1
                    });
                }
            }
            if (state2 == Service.State.FAILED)
            {
                fireFailedListeners(service);
            }
            if (states.count(Service.State.RUNNING) != numberOfServices) goto _L2; else goto _L1
_L1:
            fireHealthyListeners();
_L4:
            monitor.leave();
            executeListeners();
            return;
_L2:
            if (states.count(Service.State.TERMINATED) + states.count(Service.State.FAILED) != numberOfServices) goto _L4; else goto _L3
_L3:
            fireStoppedListeners();
              goto _L4
            service;
            monitor.leave();
            executeListeners();
            throw service;
        }

        void tryStartTiming(Service service)
        {
            monitor.enter();
            if ((Stopwatch)startupTimers.get(service) == null)
            {
                startupTimers.put(service, Stopwatch.createStarted());
            }
            monitor.leave();
            return;
            service;
            monitor.leave();
            throw service;
        }

        ServiceManagerState(ImmutableCollection immutablecollection)
        {
            states = servicesByState.keys();
            numberOfServices = immutablecollection.size();
            servicesByState.putAll(Service.State.NEW, immutablecollection);
        }
    }

    final class ServiceManagerState.AwaitHealthGuard extends Monitor.Guard
    {

        final ServiceManagerState this$0;

        public boolean isSatisfied()
        {
            return states.count(Service.State.RUNNING) == numberOfServices || states.contains(Service.State.STOPPING) || states.contains(Service.State.TERMINATED) || states.contains(Service.State.FAILED);
        }

        ServiceManagerState.AwaitHealthGuard()
        {
            this$0 = ServiceManagerState.this;
            super(monitor);
        }
    }

    final class ServiceManagerState.StoppedGuard extends Monitor.Guard
    {

        final ServiceManagerState this$0;

        public boolean isSatisfied()
        {
            return states.count(Service.State.TERMINATED) + states.count(Service.State.FAILED) == numberOfServices;
        }

        ServiceManagerState.StoppedGuard()
        {
            this$0 = ServiceManagerState.this;
            super(monitor);
        }
    }


    private static final ListenerCallQueue.Callback HEALTHY_CALLBACK = new ListenerCallQueue.Callback("healthy()") {

        void call(Listener listener)
        {
            listener.healthy();
        }

        volatile void call(Object obj)
        {
            call((Listener)obj);
        }

    };
    private static final ListenerCallQueue.Callback STOPPED_CALLBACK = new ListenerCallQueue.Callback("stopped()") {

        void call(Listener listener)
        {
            listener.stopped();
        }

        volatile void call(Object obj)
        {
            call((Listener)obj);
        }

    };
    private static final Logger logger = Logger.getLogger(com/google/common/util/concurrent/ServiceManager.getName());
    private final ImmutableList services;
    private final ServiceManagerState state;

    public ServiceManager(Iterable iterable)
    {
        Object obj = ImmutableList.copyOf(iterable);
        iterable = ((Iterable) (obj));
        if (((ImmutableList) (obj)).isEmpty())
        {
            logger.log(Level.WARNING, "ServiceManager configured with no services.  Is your application configured properly?", new EmptyServiceManagerWarning());
            iterable = ImmutableList.of(new NoOpService());
        }
        state = new ServiceManagerState(iterable);
        services = iterable;
        obj = new WeakReference(state);
        iterable = iterable.iterator();
        while (iterable.hasNext()) 
        {
            Service service = (Service)iterable.next();
            service.addListener(new ServiceListener(service, ((WeakReference) (obj))), MoreExecutors.directExecutor());
            boolean flag;
            if (service.state() == Service.State.NEW)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "Can only manage NEW services, %s", new Object[] {
                service
            });
        }
        state.markReady();
    }

    public void addListener(Listener listener)
    {
        state.addListener(listener, MoreExecutors.directExecutor());
    }

    public void addListener(Listener listener, Executor executor)
    {
        state.addListener(listener, executor);
    }

    public void awaitHealthy()
    {
        state.awaitHealthy();
    }

    public void awaitHealthy(long l, TimeUnit timeunit)
        throws TimeoutException
    {
        state.awaitHealthy(l, timeunit);
    }

    public void awaitStopped()
    {
        state.awaitStopped();
    }

    public void awaitStopped(long l, TimeUnit timeunit)
        throws TimeoutException
    {
        state.awaitStopped(l, timeunit);
    }

    public boolean isHealthy()
    {
        for (com.google.common.collect.UnmodifiableIterator unmodifiableiterator = services.iterator(); unmodifiableiterator.hasNext();)
        {
            if (!((Service)unmodifiableiterator.next()).isRunning())
            {
                return false;
            }
        }

        return true;
    }

    public ImmutableMultimap servicesByState()
    {
        return state.servicesByState();
    }

    public ServiceManager startAsync()
    {
        com.google.common.collect.UnmodifiableIterator unmodifiableiterator = services.iterator();
        while (unmodifiableiterator.hasNext()) 
        {
            Service service = (Service)unmodifiableiterator.next();
            Service.State state1 = service.state();
            boolean flag;
            if (state1 == Service.State.NEW)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkState(flag, "Service %s is %s, cannot start it.", new Object[] {
                service, state1
            });
        }
        for (com.google.common.collect.UnmodifiableIterator unmodifiableiterator1 = services.iterator(); unmodifiableiterator1.hasNext();)
        {
            Object obj = (Service)unmodifiableiterator1.next();
            try
            {
                state.tryStartTiming(((Service) (obj)));
                ((Service) (obj)).startAsync();
            }
            catch (IllegalStateException illegalstateexception)
            {
                Logger logger1 = logger;
                Level level = Level.WARNING;
                obj = String.valueOf(obj);
                logger1.log(level, (new StringBuilder(String.valueOf(obj).length() + 24)).append("Unable to start Service ").append(((String) (obj))).toString(), illegalstateexception);
            }
        }

        return this;
    }

    public ImmutableMap startupTimes()
    {
        return state.startupTimes();
    }

    public ServiceManager stopAsync()
    {
        for (com.google.common.collect.UnmodifiableIterator unmodifiableiterator = services.iterator(); unmodifiableiterator.hasNext(); ((Service)unmodifiableiterator.next()).stopAsync()) { }
        return this;
    }

    public String toString()
    {
        return MoreObjects.toStringHelper(com/google/common/util/concurrent/ServiceManager).add("services", Collections2.filter(services, Predicates.not(Predicates.instanceOf(com/google/common/util/concurrent/ServiceManager$NoOpService)))).toString();
    }




}
