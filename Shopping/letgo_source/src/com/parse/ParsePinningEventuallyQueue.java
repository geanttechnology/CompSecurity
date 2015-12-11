// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import android.content.Intent;
import android.support.v7.ct;
import android.support.v7.cu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseEventuallyQueue, TaskQueue, ConnectivityNotifier, EventuallyPin, 
//            ParseException, ParseTaskUtils, Parse, ParseOperationSet, 
//            ParseRESTCommand, ParseObject, PLog

class ParsePinningEventuallyQueue extends ParseEventuallyQueue
{
    private static class PauseException extends Exception
    {

        private PauseException()
        {
        }

    }


    private static final String TAG = "ParsePinningEventuallyQueue";
    private final Object connectionLock = new Object();
    private android.support.v7.cu.a connectionTaskCompletionSource;
    private ArrayList eventuallyPinUUIDQueue;
    private ConnectivityNotifier.ConnectivityListener listener;
    private ConnectivityNotifier notifier;
    private TaskQueue operationSetTaskQueue;
    private HashMap pendingEventuallyTasks;
    private HashMap pendingOperationSetUUIDTasks;
    private TaskQueue taskQueue;
    private final Object taskQueueSyncLock = new Object();
    private HashMap uuidToEventuallyPin;
    private HashMap uuidToOperationSet;

    public ParsePinningEventuallyQueue(Context context)
    {
        pendingOperationSetUUIDTasks = new HashMap();
        taskQueue = new TaskQueue();
        operationSetTaskQueue = new TaskQueue();
        eventuallyPinUUIDQueue = new ArrayList();
        connectionTaskCompletionSource = cu.a();
        listener = new ConnectivityNotifier.ConnectivityListener() {

            final ParsePinningEventuallyQueue this$0;

            public void networkConnectivityStatusChanged(Context context1, Intent intent)
            {
                if (intent.getBooleanExtra("noConnectivity", false))
                {
                    setConnected(false);
                    return;
                } else
                {
                    setConnected(ConnectivityNotifier.isConnected(context1));
                    return;
                }
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                super();
            }
        };
        pendingEventuallyTasks = new HashMap();
        uuidToOperationSet = new HashMap();
        uuidToEventuallyPin = new HashMap();
        setConnected(ConnectivityNotifier.isConnected(context));
        notifier = ConnectivityNotifier.getNotifier(context);
        notifier.addListener(listener);
        resume();
    }

    private cu enqueueEventuallyAsync(final ParseRESTCommand command, final ParseObject object, cu cu1, final android.support.v7.cu.a tcs)
    {
        return cu1.b(new ct() {

            final ParsePinningEventuallyQueue this$0;
            final ParseRESTCommand val$command;
            final ParseObject val$object;
            final android.support.v7.cu.a val$tcs;

            public cu then(cu cu2)
                throws Exception
            {
                return EventuallyPin.pinEventuallyCommand(object, command).b(new ct() {

                    final _cls5 this$1;

                    public cu then(cu cu1)
                        throws Exception
                    {
                        EventuallyPin eventuallypin = (EventuallyPin)cu1.e();
                        Exception exception = cu1.f();
                        if (exception != null)
                        {
                            if (5 >= Parse.getLogLevel())
                            {
                                PLog.w("ParsePinningEventuallyQueue", "Unable to save command for later.", exception);
                            }
                            notifyTestHelper(4);
                            return cu.a(null);
                        } else
                        {
                            pendingOperationSetUUIDTasks.put(eventuallypin.getUUID(), tcs);
                            populateQueueAsync().b(new ct() {

                                final _cls1 this$2;

                                public cu then(cu cu1)
                                    throws Exception
                                {
                                    notifyTestHelper(3);
                                    return cu1;
                                }

                                public volatile Object then(cu cu1)
                                    throws Exception
                                {
                                    return then(cu1);
                                }

            
            {
                this$2 = _cls1.this;
                super();
            }
                            });
                            return cu1.j();
                        }
                    }

                    public volatile Object then(cu cu1)
                        throws Exception
                    {
                        return then(cu1);
                    }

            
            {
                this$1 = _cls5.this;
                super();
            }
                });
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                object = parseobject;
                command = parserestcommand;
                tcs = a;
                super();
            }
        });
    }

    private cu populateQueueAsync()
    {
        return taskQueue.enqueue(new ct() {

            final ParsePinningEventuallyQueue this$0;

            public cu then(cu cu1)
                throws Exception
            {
                return populateQueueAsync(cu1);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                super();
            }
        });
    }

    private cu populateQueueAsync(cu cu1)
    {
        return cu1.b(new ct() {

            final ParsePinningEventuallyQueue this$0;

            public cu then(cu cu2)
                throws Exception
            {
                return EventuallyPin.findAllPinned(eventuallyPinUUIDQueue);
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                super();
            }
        }).d(new ct() {

            final ParsePinningEventuallyQueue this$0;

            public cu then(cu cu2)
                throws Exception
            {
                EventuallyPin eventuallypin;
                for (Iterator iterator = ((List)cu2.e()).iterator(); iterator.hasNext(); runEventuallyAsync(eventuallypin))
                {
                    eventuallypin = (EventuallyPin)iterator.next();
                }

                return cu2.j();
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                super();
            }
        });
    }

    private cu process(final EventuallyPin eventuallyPin, final ParseOperationSet operationSet)
    {
        return waitForConnectionAsync().d(new ct() {

            final ParsePinningEventuallyQueue this$0;
            final EventuallyPin val$eventuallyPin;
            final ParseOperationSet val$operationSet;

            public cu then(cu cu1)
                throws Exception
            {
                final int type = eventuallyPin.getType();
                ParseObject parseobject = eventuallyPin.getObject();
                cu1 = eventuallyPin.getSessionToken();
                if (type == 1)
                {
                    cu1 = parseobject.saveAsync(operationSet, cu1);
                } else
                if (type == 2)
                {
                    cu1 = parseobject.deleteAsync(cu1).i();
                } else
                {
                    cu1 = eventuallyPin.getCommand();
                    if (cu1 == null)
                    {
                        cu1 = cu.a(null);
                        notifyTestHelper(8);
                    } else
                    {
                        cu1 = cu1.executeAsync();
                    }
                }
                return cu1.b(parseobject. new ct() {

                    final _cls13 this$1;
                    final ParseObject val$object;
                    final int val$type;

                    public cu then(cu cu1)
                        throws Exception
                    {
                        Exception exception = cu1.f();
                        if (exception != null && (exception instanceof ParseException) && ((ParseException)exception).getCode() == 100)
                        {
                            setConnected(false);
                            notifyTestHelper(7);
                            return process(eventuallyPin, operationSet);
                        } else
                        {
                            return eventuallyPin.unpinInBackground("_eventuallyPin").b(cu1. new ct() {

                                final _cls1 this$2;
                                final cu val$executeTask;

                                public cu then(cu cu1)
                                    throws Exception
                                {
                                    Object obj = (JSONObject)executeTask.e();
                                    if (type == 1)
                                    {
                                        obj = object.handleSaveEventuallyResultAsync(((JSONObject) (obj)), operationSet);
                                    } else
                                    {
                                        obj = cu1;
                                        if (type == 2)
                                        {
                                            obj = cu1;
                                            if (!executeTask.d())
                                            {
                                                return object.handleDeleteEventuallyResultAsync();
                                            }
                                        }
                                    }
                                    return ((cu) (obj));
                                }

                                public volatile Object then(cu cu1)
                                    throws Exception
                                {
                                    return then(cu1);
                                }

            
            {
                this$2 = final__pcls1;
                executeTask = cu.this;
                super();
            }
                            }).b(cu1. new ct() {

                                final _cls1 this$2;
                                final cu val$executeTask;

                                public cu then(cu cu1)
                                    throws Exception
                                {
                                    return executeTask;
                                }

                                public volatile Object then(cu cu1)
                                    throws Exception
                                {
                                    return then(cu1);
                                }

            
            {
                this$2 = final__pcls1;
                executeTask = cu.this;
                super();
            }
                            });
                        }
                    }

                    public volatile Object then(cu cu1)
                        throws Exception
                    {
                        return then(cu1);
                    }

            
            {
                this$1 = final__pcls13;
                type = i;
                object = ParseObject.this;
                super();
            }
                });
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                eventuallyPin = eventuallypin;
                operationSet = parseoperationset;
                super();
            }
        });
    }

    private cu runEventuallyAsync(final EventuallyPin eventuallyPin)
    {
        final String uuid = eventuallyPin.getUUID();
        if (eventuallyPinUUIDQueue.contains(uuid))
        {
            return cu.a(null);
        } else
        {
            eventuallyPinUUIDQueue.add(uuid);
            operationSetTaskQueue.enqueue(new ct() {

                final ParsePinningEventuallyQueue this$0;
                final EventuallyPin val$eventuallyPin;
                final String val$uuid;

                public cu then(cu cu1)
                    throws Exception
                {
                    return runEventuallyAsync(eventuallyPin, cu1).b(new ct() {

                        final _cls9 this$1;

                        public cu then(cu cu1)
                            throws Exception
                        {
                            eventuallyPinUUIDQueue.remove(uuid);
                            return cu1;
                        }

                        public volatile Object then(cu cu1)
                            throws Exception
                        {
                            return then(cu1);
                        }

            
            {
                this$1 = _cls9.this;
                super();
            }
                    });
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                eventuallyPin = eventuallypin;
                uuid = s;
                super();
            }
            });
            return cu.a(null);
        }
    }

    private cu runEventuallyAsync(final EventuallyPin eventuallyPin, cu cu1)
    {
        return cu1.b(new ct() {

            final ParsePinningEventuallyQueue this$0;

            public cu then(cu cu2)
                throws Exception
            {
                return waitForConnectionAsync();
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                super();
            }
        }).d(new ct() {

            final ParsePinningEventuallyQueue this$0;
            final EventuallyPin val$eventuallyPin;

            public cu then(cu cu2)
                throws Exception
            {
                return waitForOperationSetAndEventuallyPin(null, eventuallyPin).b(new ct() {

                    final _cls10 this$1;

                    public cu then(cu cu1)
                        throws Exception
                    {
                        Exception exception = cu1.f();
                        android.support.v7.cu.a a;
                        if (exception != null)
                        {
                            if (exception instanceof PauseException)
                            {
                                return cu1.j();
                            }
                            if (6 >= Parse.getLogLevel())
                            {
                                PLog.e("ParsePinningEventuallyQueue", "Failed to run command.", exception);
                            }
                            notifyTestHelper(2, exception);
                        } else
                        {
                            notifyTestHelper(1);
                        }
                        a = (android.support.v7.cu.a)pendingOperationSetUUIDTasks.remove(eventuallyPin.getUUID());
                        if (a != null)
                        {
                            if (exception != null)
                            {
                                a.b(exception);
                            } else
                            {
                                a.b(cu1.e());
                            }
                        }
                        return cu1.j();
                    }

                    public volatile Object then(cu cu1)
                        throws Exception
                    {
                        return then(cu1);
                    }

            
            {
                this$1 = _cls10.this;
                super();
            }
                });
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                eventuallyPin = eventuallypin;
                super();
            }
        });
    }

    private cu waitForConnectionAsync()
    {
        cu cu1;
        synchronized (connectionLock)
        {
            cu1 = connectionTaskCompletionSource.a();
        }
        return cu1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private cu whenAll(Collection collection)
    {
        ArrayList arraylist = new ArrayList();
        for (collection = collection.iterator(); collection.hasNext(); arraylist.add(((TaskQueue)collection.next()).enqueue(new ct() {

        final ParsePinningEventuallyQueue this$0;

        public cu then(cu cu1)
            throws Exception
        {
            return cu1;
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                super();
            }
    }))) { }
        return cu.a(arraylist);
    }

    public void clear()
    {
        pause();
        cu cu1 = taskQueue.enqueue(new ct() {

            final ParsePinningEventuallyQueue this$0;

            public cu then(cu cu2)
                throws Exception
            {
                return cu2.b(new ct() {

                    final _cls14 this$1;

                    public cu then(cu cu1)
                        throws Exception
                    {
                        return EventuallyPin.findAllPinned().d(new ct() {

                            final _cls1 this$2;

                            public cu then(cu cu1)
                                throws Exception
                            {
                                Object obj = (List)cu1.e();
                                cu1 = new ArrayList();
                                for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); cu1.add(((EventuallyPin)((Iterator) (obj)).next()).unpinInBackground("_eventuallyPin"))) { }
                                return cu.a(cu1);
                            }

                            public volatile Object then(cu cu1)
                                throws Exception
                            {
                                return then(cu1);
                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                        });
                    }

                    public volatile Object then(cu cu1)
                        throws Exception
                    {
                        return then(cu1);
                    }

            
            {
                this$1 = _cls14.this;
                super();
            }
                });
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                super();
            }
        });
        try
        {
            ParseTaskUtils.wait(cu1);
        }
        catch (ParseException parseexception)
        {
            throw new IllegalStateException(parseexception);
        }
        simulateReboot();
        resume();
    }

    public cu enqueueEventuallyAsync(final ParseRESTCommand command, final ParseObject object)
    {
        Parse.requirePermission("android.permission.ACCESS_NETWORK_STATE");
        final android.support.v7.cu.a tcs = cu.a();
        taskQueue.enqueue(new ct() {

            final ParsePinningEventuallyQueue this$0;
            final ParseRESTCommand val$command;
            final ParseObject val$object;
            final android.support.v7.cu.a val$tcs;

            public cu then(cu cu1)
                throws Exception
            {
                return enqueueEventuallyAsync(command, object, cu1, tcs);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                command = parserestcommand;
                object = parseobject;
                tcs = a;
                super();
            }
        });
        return tcs.a();
    }

    public void onDestroy()
    {
        notifier.removeListener(listener);
    }

    public void pause()
    {
        synchronized (connectionLock)
        {
            connectionTaskCompletionSource.a(new PauseException());
            connectionTaskCompletionSource = cu.a();
            connectionTaskCompletionSource.a(new PauseException());
        }
        obj = taskQueueSyncLock;
        obj;
        JVM INSTR monitorenter ;
        String s;
        for (Iterator iterator = pendingEventuallyTasks.keySet().iterator(); iterator.hasNext(); ((android.support.v7.cu.a)pendingEventuallyTasks.get(s)).a(new PauseException()))
        {
            s = (String)iterator.next();
        }

        break MISSING_BLOCK_LABEL_123;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        pendingEventuallyTasks.clear();
        uuidToOperationSet.clear();
        uuidToEventuallyPin.clear();
        obj;
        JVM INSTR monitorexit ;
        try
        {
            ParseTaskUtils.wait(whenAll(Arrays.asList(new TaskQueue[] {
                taskQueue, operationSetTaskQueue
            })));
            return;
        }
        catch (ParseException parseexception)
        {
            throw new IllegalStateException(parseexception);
        }
    }

    public int pendingCount()
    {
        int i;
        try
        {
            i = ((Integer)ParseTaskUtils.wait(pendingCountAsync())).intValue();
        }
        catch (ParseException parseexception)
        {
            throw new IllegalStateException(parseexception);
        }
        return i;
    }

    public cu pendingCountAsync()
    {
        final android.support.v7.cu.a tcs = cu.a();
        taskQueue.enqueue(new ct() {

            final ParsePinningEventuallyQueue this$0;
            final android.support.v7.cu.a val$tcs;

            public cu then(cu cu1)
                throws Exception
            {
                return pendingCountAsync(cu1).b(new ct() {

                    final _cls2 this$1;

                    public cu then(cu cu1)
                        throws Exception
                    {
                        int i = ((Integer)cu1.e()).intValue();
                        tcs.b(Integer.valueOf(i));
                        return cu.a(null);
                    }

                    public volatile Object then(cu cu1)
                        throws Exception
                    {
                        return then(cu1);
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                });
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                tcs = a;
                super();
            }
        });
        return tcs.a();
    }

    public cu pendingCountAsync(cu cu1)
    {
        return cu1.b(new ct() {

            final ParsePinningEventuallyQueue this$0;

            public cu then(cu cu2)
                throws Exception
            {
                return EventuallyPin.findAllPinned().b(new ct() {

                    final _cls3 this$1;

                    public cu then(cu cu1)
                        throws Exception
                    {
                        return cu.a(Integer.valueOf(((List)cu1.e()).size()));
                    }

                    public volatile Object then(cu cu1)
                        throws Exception
                    {
                        return then(cu1);
                    }

            
            {
                this$1 = _cls3.this;
                super();
            }
                });
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                super();
            }
        });
    }

    public void resume()
    {
        if (isConnected())
        {
            connectionTaskCompletionSource.a(null);
            connectionTaskCompletionSource = cu.a();
            connectionTaskCompletionSource.a(null);
        } else
        {
            connectionTaskCompletionSource = cu.a();
        }
        populateQueueAsync();
    }

    public void setConnected(boolean flag)
    {
        Object obj = connectionLock;
        obj;
        JVM INSTR monitorenter ;
        if (isConnected() == flag)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        super.setConnected(flag);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        connectionTaskCompletionSource.a(null);
        connectionTaskCompletionSource = cu.a();
        connectionTaskCompletionSource.a(null);
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        connectionTaskCompletionSource = cu.a();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void simulateReboot()
    {
        pause();
        pendingOperationSetUUIDTasks.clear();
        pendingEventuallyTasks.clear();
        uuidToOperationSet.clear();
        uuidToEventuallyPin.clear();
        resume();
    }

    cu waitForOperationSetAndEventuallyPin(final ParseOperationSet uuid, EventuallyPin eventuallypin)
    {
        if (eventuallypin != null && eventuallypin.getType() != 1)
        {
            return process(eventuallypin, null);
        }
        Object obj = taskQueueSyncLock;
        obj;
        JVM INSTR monitorenter ;
        if (uuid == null || eventuallypin != null) goto _L2; else goto _L1
_L1:
        eventuallypin = uuid.getUUID();
        uuidToOperationSet.put(eventuallypin, uuid);
        uuid = eventuallypin;
_L9:
        ParseOperationSet parseoperationset;
        eventuallypin = (EventuallyPin)uuidToEventuallyPin.get(uuid);
        parseoperationset = (ParseOperationSet)uuidToOperationSet.get(uuid);
        if (eventuallypin != null && parseoperationset != null) goto _L4; else goto _L3
_L3:
        if (!pendingEventuallyTasks.containsKey(uuid)) goto _L6; else goto _L5
_L5:
        uuid = (android.support.v7.cu.a)pendingEventuallyTasks.get(uuid);
_L7:
        uuid = uuid.a();
        obj;
        JVM INSTR monitorexit ;
        return uuid;
        uuid;
        obj;
        JVM INSTR monitorexit ;
        throw uuid;
_L2:
        if (uuid != null || eventuallypin == null)
        {
            break MISSING_BLOCK_LABEL_148;
        }
        uuid = eventuallypin.getOperationSetUUID();
        uuidToEventuallyPin.put(uuid, eventuallypin);
        continue; /* Loop/switch isn't completed */
        throw new IllegalStateException("Either operationSet or eventuallyPin must be set.");
_L6:
        eventuallypin = cu.a();
        pendingEventuallyTasks.put(uuid, eventuallypin);
        uuid = eventuallypin;
          goto _L7
_L4:
        final android.support.v7.cu.a tcs = (android.support.v7.cu.a)pendingEventuallyTasks.get(uuid);
        obj;
        JVM INSTR monitorexit ;
        return process(eventuallypin, parseoperationset).b(new ct() {

            final ParsePinningEventuallyQueue this$0;
            final android.support.v7.cu.a val$tcs;
            final String val$uuid;

            public cu then(cu cu1)
                throws Exception
            {
                synchronized (taskQueueSyncLock)
                {
                    pendingEventuallyTasks.remove(uuid);
                    uuidToOperationSet.remove(uuid);
                    uuidToEventuallyPin.remove(uuid);
                }
                obj1 = cu1.f();
                if (obj1 != null)
                {
                    tcs.a(((Exception) (obj1)));
                } else
                if (cu1.c())
                {
                    tcs.b();
                } else
                {
                    tcs.a(cu1.e());
                }
                return tcs.a();
                cu1;
                obj1;
                JVM INSTR monitorexit ;
                throw cu1;
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                uuid = s;
                tcs = a;
                super();
            }
        });
        if (true) goto _L9; else goto _L8
_L8:
    }













}
