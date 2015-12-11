// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import android.content.Context;
import android.content.Intent;
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
    private a.j.a connectionTaskCompletionSource;
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
        connectionTaskCompletionSource = j.a();
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

    private j enqueueEventuallyAsync(final ParseRESTCommand command, final ParseObject object, j j1, final a.j.a tcs)
    {
        return j1.b(new i() {

            final ParsePinningEventuallyQueue this$0;
            final ParseRESTCommand val$command;
            final ParseObject val$object;
            final a.j.a val$tcs;

            public j then(j j2)
                throws Exception
            {
                return EventuallyPin.pinEventuallyCommand(object, command).b(new i() {

                    final _cls5 this$1;

                    public j then(j j1)
                        throws Exception
                    {
                        EventuallyPin eventuallypin = (EventuallyPin)j1.e();
                        Exception exception = j1.f();
                        if (exception != null)
                        {
                            if (5 >= Parse.getLogLevel())
                            {
                                PLog.w("ParsePinningEventuallyQueue", "Unable to save command for later.", exception);
                            }
                            notifyTestHelper(4);
                            return j.a(null);
                        } else
                        {
                            pendingOperationSetUUIDTasks.put(eventuallypin.getUUID(), tcs);
                            populateQueueAsync().b(new i() {

                                final _cls1 this$2;

                                public j then(j j1)
                                    throws Exception
                                {
                                    notifyTestHelper(3);
                                    return j1;
                                }

                                public volatile Object then(j j1)
                                    throws Exception
                                {
                                    return then(j1);
                                }

            
            {
                this$2 = _cls1.this;
                super();
            }
                            });
                            return j1.j();
                        }
                    }

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

            
            {
                this$1 = _cls5.this;
                super();
            }
                });
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
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

    private j populateQueueAsync()
    {
        return taskQueue.enqueue(new i() {

            final ParsePinningEventuallyQueue this$0;

            public j then(j j1)
                throws Exception
            {
                return populateQueueAsync(j1);
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                super();
            }
        });
    }

    private j populateQueueAsync(j j1)
    {
        return j1.b(new i() {

            final ParsePinningEventuallyQueue this$0;

            public j then(j j2)
                throws Exception
            {
                return EventuallyPin.findAllPinned(eventuallyPinUUIDQueue);
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                super();
            }
        }).d(new i() {

            final ParsePinningEventuallyQueue this$0;

            public j then(j j2)
                throws Exception
            {
                EventuallyPin eventuallypin;
                for (Iterator iterator = ((List)j2.e()).iterator(); iterator.hasNext(); runEventuallyAsync(eventuallypin))
                {
                    eventuallypin = (EventuallyPin)iterator.next();
                }

                return j2.j();
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                super();
            }
        });
    }

    private j process(final EventuallyPin eventuallyPin, final ParseOperationSet operationSet)
    {
        return waitForConnectionAsync().d(new i() {

            final ParsePinningEventuallyQueue this$0;
            final EventuallyPin val$eventuallyPin;
            final ParseOperationSet val$operationSet;

            public j then(j j1)
                throws Exception
            {
                final int type = eventuallyPin.getType();
                ParseObject parseobject = eventuallyPin.getObject();
                j1 = eventuallyPin.getSessionToken();
                if (type == 1)
                {
                    j1 = parseobject.saveAsync(operationSet, j1);
                } else
                if (type == 2)
                {
                    j1 = parseobject.deleteAsync(j1).i();
                } else
                {
                    j1 = eventuallyPin.getCommand();
                    if (j1 == null)
                    {
                        j1 = j.a(null);
                        notifyTestHelper(8);
                    } else
                    {
                        j1 = j1.executeAsync();
                    }
                }
                return j1.b(parseobject. new i() {

                    final _cls13 this$1;
                    final ParseObject val$object;
                    final int val$type;

                    public j then(j j1)
                        throws Exception
                    {
                        Exception exception = j1.f();
                        if (exception != null && (exception instanceof ParseException) && ((ParseException)exception).getCode() == 100)
                        {
                            setConnected(false);
                            notifyTestHelper(7);
                            return process(eventuallyPin, operationSet);
                        } else
                        {
                            return eventuallyPin.unpinInBackground("_eventuallyPin").b(j1. new i() {

                                final _cls1 this$2;
                                final j val$executeTask;

                                public j then(j j1)
                                    throws Exception
                                {
                                    Object obj = (JSONObject)executeTask.e();
                                    if (type == 1)
                                    {
                                        obj = object.handleSaveEventuallyResultAsync(((JSONObject) (obj)), operationSet);
                                    } else
                                    {
                                        obj = j1;
                                        if (type == 2)
                                        {
                                            obj = j1;
                                            if (!executeTask.d())
                                            {
                                                return object.handleDeleteEventuallyResultAsync();
                                            }
                                        }
                                    }
                                    return ((j) (obj));
                                }

                                public volatile Object then(j j1)
                                    throws Exception
                                {
                                    return then(j1);
                                }

            
            {
                this$2 = final__pcls1;
                executeTask = j.this;
                super();
            }
                            }).b(j1. new i() {

                                final _cls1 this$2;
                                final j val$executeTask;

                                public j then(j j1)
                                    throws Exception
                                {
                                    return executeTask;
                                }

                                public volatile Object then(j j1)
                                    throws Exception
                                {
                                    return then(j1);
                                }

            
            {
                this$2 = final__pcls1;
                executeTask = j.this;
                super();
            }
                            });
                        }
                    }

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

            
            {
                this$1 = final__pcls13;
                type = k;
                object = ParseObject.this;
                super();
            }
                });
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                eventuallyPin = eventuallypin;
                operationSet = parseoperationset;
                super();
            }
        });
    }

    private j runEventuallyAsync(final EventuallyPin eventuallyPin)
    {
        final String uuid = eventuallyPin.getUUID();
        if (eventuallyPinUUIDQueue.contains(uuid))
        {
            return j.a(null);
        } else
        {
            eventuallyPinUUIDQueue.add(uuid);
            operationSetTaskQueue.enqueue(new i() {

                final ParsePinningEventuallyQueue this$0;
                final EventuallyPin val$eventuallyPin;
                final String val$uuid;

                public j then(j j1)
                    throws Exception
                {
                    return runEventuallyAsync(eventuallyPin, j1).b(new i() {

                        final _cls9 this$1;

                        public j then(j j1)
                            throws Exception
                        {
                            eventuallyPinUUIDQueue.remove(uuid);
                            return j1;
                        }

                        public volatile Object then(j j1)
                            throws Exception
                        {
                            return then(j1);
                        }

            
            {
                this$1 = _cls9.this;
                super();
            }
                    });
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                eventuallyPin = eventuallypin;
                uuid = s;
                super();
            }
            });
            return j.a(null);
        }
    }

    private j runEventuallyAsync(final EventuallyPin eventuallyPin, j j1)
    {
        return j1.b(new i() {

            final ParsePinningEventuallyQueue this$0;

            public j then(j j2)
                throws Exception
            {
                return waitForConnectionAsync();
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                super();
            }
        }).d(new i() {

            final ParsePinningEventuallyQueue this$0;
            final EventuallyPin val$eventuallyPin;

            public j then(j j2)
                throws Exception
            {
                return waitForOperationSetAndEventuallyPin(null, eventuallyPin).b(new i() {

                    final _cls10 this$1;

                    public j then(j j1)
                        throws Exception
                    {
                        Exception exception = j1.f();
                        a.j.a a;
                        if (exception != null)
                        {
                            if (exception instanceof PauseException)
                            {
                                return j1.j();
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
                        a = (a.j.a)pendingOperationSetUUIDTasks.remove(eventuallyPin.getUUID());
                        if (a != null)
                        {
                            if (exception != null)
                            {
                                a.b(exception);
                            } else
                            {
                                a.b(j1.e());
                            }
                        }
                        return j1.j();
                    }

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

            
            {
                this$1 = _cls10.this;
                super();
            }
                });
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                eventuallyPin = eventuallypin;
                super();
            }
        });
    }

    private j waitForConnectionAsync()
    {
        j j1;
        synchronized (connectionLock)
        {
            j1 = connectionTaskCompletionSource.a();
        }
        return j1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private j whenAll(Collection collection)
    {
        ArrayList arraylist = new ArrayList();
        for (collection = collection.iterator(); collection.hasNext(); arraylist.add(((TaskQueue)collection.next()).enqueue(new i() {

        final ParsePinningEventuallyQueue this$0;

        public j then(j j1)
            throws Exception
        {
            return j1;
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                super();
            }
    }))) { }
        return j.a(arraylist);
    }

    public void clear()
    {
        pause();
        j j1 = taskQueue.enqueue(new i() {

            final ParsePinningEventuallyQueue this$0;

            public j then(j j2)
                throws Exception
            {
                return j2.b(new i() {

                    final _cls14 this$1;

                    public j then(j j1)
                        throws Exception
                    {
                        return EventuallyPin.findAllPinned().d(new i() {

                            final _cls1 this$2;

                            public j then(j j1)
                                throws Exception
                            {
                                Object obj = (List)j1.e();
                                j1 = new ArrayList();
                                for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); j1.add(((EventuallyPin)((Iterator) (obj)).next()).unpinInBackground("_eventuallyPin"))) { }
                                return j.a(j1);
                            }

                            public volatile Object then(j j1)
                                throws Exception
                            {
                                return then(j1);
                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                        });
                    }

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

            
            {
                this$1 = _cls14.this;
                super();
            }
                });
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                super();
            }
        });
        try
        {
            ParseTaskUtils.wait(j1);
        }
        catch (ParseException parseexception)
        {
            throw new IllegalStateException(parseexception);
        }
        simulateReboot();
        resume();
    }

    public j enqueueEventuallyAsync(final ParseRESTCommand command, final ParseObject object)
    {
        Parse.requirePermission("android.permission.ACCESS_NETWORK_STATE");
        final a.j.a tcs = j.a();
        taskQueue.enqueue(new i() {

            final ParsePinningEventuallyQueue this$0;
            final ParseRESTCommand val$command;
            final ParseObject val$object;
            final a.j.a val$tcs;

            public j then(j j1)
                throws Exception
            {
                return enqueueEventuallyAsync(command, object, j1, tcs);
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
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
            connectionTaskCompletionSource = j.a();
            connectionTaskCompletionSource.a(new PauseException());
        }
        obj = taskQueueSyncLock;
        obj;
        JVM INSTR monitorenter ;
        String s;
        for (Iterator iterator = pendingEventuallyTasks.keySet().iterator(); iterator.hasNext(); ((a.j.a)pendingEventuallyTasks.get(s)).a(new PauseException()))
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

    public j pendingCountAsync()
    {
        final a.j.a tcs = j.a();
        taskQueue.enqueue(new i() {

            final ParsePinningEventuallyQueue this$0;
            final a.j.a val$tcs;

            public j then(j j1)
                throws Exception
            {
                return pendingCountAsync(j1).b(new i() {

                    final _cls2 this$1;

                    public j then(j j1)
                        throws Exception
                    {
                        int k = ((Integer)j1.e()).intValue();
                        tcs.b(Integer.valueOf(k));
                        return j.a(null);
                    }

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                });
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                tcs = a;
                super();
            }
        });
        return tcs.a();
    }

    public j pendingCountAsync(j j1)
    {
        return j1.b(new i() {

            final ParsePinningEventuallyQueue this$0;

            public j then(j j2)
                throws Exception
            {
                return EventuallyPin.findAllPinned().b(new i() {

                    final _cls3 this$1;

                    public j then(j j1)
                        throws Exception
                    {
                        return j.a(Integer.valueOf(((List)j1.e()).size()));
                    }

                    public volatile Object then(j j1)
                        throws Exception
                    {
                        return then(j1);
                    }

            
            {
                this$1 = _cls3.this;
                super();
            }
                });
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
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
            connectionTaskCompletionSource = j.a();
            connectionTaskCompletionSource.a(null);
        } else
        {
            connectionTaskCompletionSource = j.a();
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
        connectionTaskCompletionSource = j.a();
        connectionTaskCompletionSource.a(null);
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        connectionTaskCompletionSource = j.a();
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

    j waitForOperationSetAndEventuallyPin(final ParseOperationSet uuid, EventuallyPin eventuallypin)
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
        uuid = (a.j.a)pendingEventuallyTasks.get(uuid);
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
        eventuallypin = j.a();
        pendingEventuallyTasks.put(uuid, eventuallypin);
        uuid = eventuallypin;
          goto _L7
_L4:
        final a.j.a tcs = (a.j.a)pendingEventuallyTasks.get(uuid);
        obj;
        JVM INSTR monitorexit ;
        return process(eventuallypin, parseoperationset).b(new i() {

            final ParsePinningEventuallyQueue this$0;
            final a.j.a val$tcs;
            final String val$uuid;

            public j then(j j1)
                throws Exception
            {
                synchronized (taskQueueSyncLock)
                {
                    pendingEventuallyTasks.remove(uuid);
                    uuidToOperationSet.remove(uuid);
                    uuidToEventuallyPin.remove(uuid);
                }
                obj1 = j1.f();
                if (obj1 != null)
                {
                    tcs.a(((Exception) (obj1)));
                } else
                if (j1.c())
                {
                    tcs.b();
                } else
                {
                    tcs.a(j1.e());
                }
                return tcs.a();
                j1;
                obj1;
                JVM INSTR monitorexit ;
                throw j1;
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
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
