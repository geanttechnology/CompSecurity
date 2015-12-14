// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import android.content.Intent;
import bolts.Continuation;
import bolts.Task;
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
//            ParseException, Parse, ParseOperationSet, ParseCommand, 
//            ParseObject

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
    private bolts.Task.TaskCompletionSource connectionTaskCompletionSource;
    private ArrayList eventuallyPinUUIDQueue;
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
        connectionTaskCompletionSource = Task.create();
        pendingEventuallyTasks = new HashMap();
        uuidToOperationSet = new HashMap();
        uuidToEventuallyPin = new HashMap();
        setConnected(ConnectivityNotifier.getNotifier().isConnected());
        ConnectivityNotifier.getNotifier().addListener(new ConnectivityNotifier.ConnectivityListener() {

            final ParsePinningEventuallyQueue this$0;

            public void networkConnectivityStatusChanged(Intent intent)
            {
                if (intent.getBooleanExtra("noConnectivity", false))
                {
                    setConnected(false);
                    return;
                } else
                {
                    setConnected(ConnectivityNotifier.getNotifier().isConnected());
                    return;
                }
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                super();
            }
        }, context);
        resume();
    }

    private Task enqueueEventuallyAsync(final ParseCommand command, final ParseObject object, Task task, final bolts.Task.TaskCompletionSource tcs)
    {
        return task.continueWithTask(new Continuation() {

            final ParsePinningEventuallyQueue this$0;
            final ParseCommand val$command;
            final ParseObject val$object;
            final bolts.Task.TaskCompletionSource val$tcs;

            public Task then(Task task1)
                throws Exception
            {
                return EventuallyPin.pinEventuallyCommand(object, command).continueWithTask(new Continuation() {

                    final _cls5 this$1;

                    public Task then(Task task)
                        throws Exception
                    {
                        EventuallyPin eventuallypin = (EventuallyPin)task.getResult();
                        Exception exception = task.getError();
                        if (exception != null)
                        {
                            if (5 >= Parse.getLogLevel())
                            {
                                Parse.logW("ParsePinningEventuallyQueue", "Unable to save command for later.", exception);
                            }
                            notifyTestHelper(4);
                            return Task.forResult(null);
                        } else
                        {
                            pendingOperationSetUUIDTasks.put(eventuallypin.getUUID(), tcs);
                            populateQueueAsync().continueWithTask(new Continuation() {

                                final _cls1 this$2;

                                public Task then(Task task)
                                    throws Exception
                                {
                                    notifyTestHelper(3);
                                    return task;
                                }

                                public volatile Object then(Task task)
                                    throws Exception
                                {
                                    return then(task);
                                }

            
            {
                this$2 = _cls1.this;
                super();
            }
                            });
                            return task.makeVoid();
                        }
                    }

                    public volatile Object then(Task task)
                        throws Exception
                    {
                        return then(task);
                    }

            
            {
                this$1 = _cls5.this;
                super();
            }
                });
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                object = parseobject;
                command = parsecommand;
                tcs = taskcompletionsource;
                super();
            }
        });
    }

    private Task populateQueueAsync()
    {
        return taskQueue.enqueue(new Continuation() {

            final ParsePinningEventuallyQueue this$0;

            public Task then(Task task)
                throws Exception
            {
                return populateQueueAsync(task);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                super();
            }
        });
    }

    private Task populateQueueAsync(Task task)
    {
        return task.continueWithTask(new Continuation() {

            final ParsePinningEventuallyQueue this$0;

            public Task then(Task task1)
                throws Exception
            {
                return EventuallyPin.findAllPinned(eventuallyPinUUIDQueue);
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                super();
            }
        }).onSuccessTask(new Continuation() {

            final ParsePinningEventuallyQueue this$0;

            public Task then(Task task1)
                throws Exception
            {
                EventuallyPin eventuallypin;
                for (Iterator iterator = ((List)task1.getResult()).iterator(); iterator.hasNext(); runEventuallyAsync(eventuallypin))
                {
                    eventuallypin = (EventuallyPin)iterator.next();
                }

                return task1.makeVoid();
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                super();
            }
        });
    }

    private Task process(final EventuallyPin eventuallyPin, final ParseOperationSet operationSet)
    {
        return waitForConnectionAsync().onSuccessTask(new Continuation() {

            final ParsePinningEventuallyQueue this$0;
            final EventuallyPin val$eventuallyPin;
            final ParseOperationSet val$operationSet;

            public Task then(Task task)
                throws Exception
            {
                final int type = eventuallyPin.getType();
                ParseObject parseobject = eventuallyPin.getObject();
                task = eventuallyPin.getSessionToken();
                if (type == 1)
                {
                    task = parseobject.saveAsync(operationSet, task);
                } else
                if (type == 2)
                {
                    task = parseobject.deleteAsync(task);
                } else
                {
                    task = eventuallyPin.getCommand().executeAsync();
                }
                return task.continueWithTask(parseobject. new Continuation() {

                    final _cls13 this$1;
                    final ParseObject val$object;
                    final int val$type;

                    public Task then(Task task)
                        throws Exception
                    {
                        Exception exception = task.getError();
                        if (exception != null && (exception instanceof ParseException) && ((ParseException)exception).getCode() == 100)
                        {
                            setConnected(false);
                            notifyTestHelper(7);
                            return process(eventuallyPin, operationSet);
                        } else
                        {
                            return eventuallyPin.unpinInBackground("_eventuallyPin").continueWithTask(task. new Continuation() {

                                final _cls1 this$2;
                                final Task val$saveTask;

                                public Task then(Task task)
                                    throws Exception
                                {
                                    Object obj = saveTask.getResult();
                                    if (type == 1)
                                    {
                                        task = object.handleSaveEventuallyResultAsync((JSONObject)obj, operationSet);
                                    } else
                                    if (type == 2)
                                    {
                                        return object.handleDeleteEventuallyResultAsync(obj);
                                    }
                                    return task;
                                }

                                public volatile Object then(Task task)
                                    throws Exception
                                {
                                    return then(task);
                                }

            
            {
                this$2 = final__pcls1;
                saveTask = Task.this;
                super();
            }
                            }).continueWithTask(task. new Continuation() {

                                final _cls1 this$2;
                                final Task val$saveTask;

                                public Task then(Task task)
                                    throws Exception
                                {
                                    return saveTask;
                                }

                                public volatile Object then(Task task)
                                    throws Exception
                                {
                                    return then(task);
                                }

            
            {
                this$2 = final__pcls1;
                saveTask = Task.this;
                super();
            }
                            });
                        }
                    }

                    public volatile Object then(Task task)
                        throws Exception
                    {
                        return then(task);
                    }

            
            {
                this$1 = final__pcls13;
                type = i;
                object = ParseObject.this;
                super();
            }
                });
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                eventuallyPin = eventuallypin;
                operationSet = parseoperationset;
                super();
            }
        });
    }

    private Task runEventuallyAsync(final EventuallyPin eventuallyPin)
    {
        final String uuid = eventuallyPin.getUUID();
        if (eventuallyPinUUIDQueue.contains(uuid))
        {
            return Task.forResult(null);
        } else
        {
            eventuallyPinUUIDQueue.add(uuid);
            operationSetTaskQueue.enqueue(new Continuation() {

                final ParsePinningEventuallyQueue this$0;
                final EventuallyPin val$eventuallyPin;
                final String val$uuid;

                public Task then(Task task)
                    throws Exception
                {
                    return runEventuallyAsync(eventuallyPin, task).continueWithTask(new Continuation() {

                        final _cls9 this$1;

                        public Task then(Task task)
                            throws Exception
                        {
                            eventuallyPinUUIDQueue.remove(uuid);
                            return task;
                        }

                        public volatile Object then(Task task)
                            throws Exception
                        {
                            return then(task);
                        }

            
            {
                this$1 = _cls9.this;
                super();
            }
                    });
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                eventuallyPin = eventuallypin;
                uuid = s;
                super();
            }
            });
            return Task.forResult(null);
        }
    }

    private Task runEventuallyAsync(final EventuallyPin eventuallyPin, Task task)
    {
        return task.continueWithTask(new Continuation() {

            final ParsePinningEventuallyQueue this$0;

            public Task then(Task task1)
                throws Exception
            {
                return waitForConnectionAsync();
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                super();
            }
        }).onSuccessTask(new Continuation() {

            final ParsePinningEventuallyQueue this$0;
            final EventuallyPin val$eventuallyPin;

            public Task then(Task task1)
                throws Exception
            {
                return waitForOperationSetAndEventuallyPin(null, eventuallyPin).continueWithTask(new Continuation() {

                    final _cls10 this$1;

                    public Task then(Task task)
                        throws Exception
                    {
                        Exception exception = task.getError();
                        bolts.Task.TaskCompletionSource taskcompletionsource;
                        if (exception != null)
                        {
                            if (exception instanceof PauseException)
                            {
                                return task.makeVoid();
                            }
                            if (6 >= Parse.getLogLevel())
                            {
                                Parse.logE("ParsePinningEventuallyQueue", "Failed to run command.", exception);
                            }
                            notifyTestHelper(2);
                        } else
                        {
                            notifyTestHelper(1);
                        }
                        taskcompletionsource = (bolts.Task.TaskCompletionSource)pendingOperationSetUUIDTasks.remove(eventuallyPin.getUUID());
                        if (taskcompletionsource != null)
                        {
                            if (exception != null)
                            {
                                taskcompletionsource.setError(exception);
                            } else
                            {
                                taskcompletionsource.setResult(task.getResult());
                            }
                        }
                        return task.makeVoid();
                    }

                    public volatile Object then(Task task)
                        throws Exception
                    {
                        return then(task);
                    }

            
            {
                this$1 = _cls10.this;
                super();
            }
                });
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                eventuallyPin = eventuallypin;
                super();
            }
        });
    }

    private Task waitForConnectionAsync()
    {
        Task task;
        synchronized (connectionLock)
        {
            task = connectionTaskCompletionSource.getTask();
        }
        return task;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private Task whenAll(Collection collection)
    {
        ArrayList arraylist = new ArrayList();
        for (collection = collection.iterator(); collection.hasNext(); arraylist.add(((TaskQueue)collection.next()).enqueue(new Continuation() {

        final ParsePinningEventuallyQueue this$0;

        public Task then(Task task)
            throws Exception
        {
            return task;
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                super();
            }
    }))) { }
        return Task.whenAll(arraylist);
    }

    public void clear()
    {
        pause();
        Task task = taskQueue.enqueue(new Continuation() {

            final ParsePinningEventuallyQueue this$0;

            public Task then(Task task1)
                throws Exception
            {
                return task1.continueWithTask(new Continuation() {

                    final _cls14 this$1;

                    public Task then(Task task)
                        throws Exception
                    {
                        return EventuallyPin.findAllPinned().onSuccessTask(new Continuation() {

                            final _cls1 this$2;

                            public Task then(Task task)
                                throws Exception
                            {
                                Object obj = (List)task.getResult();
                                task = new ArrayList();
                                for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); task.add(((EventuallyPin)((Iterator) (obj)).next()).unpinInBackground("_eventuallyPin"))) { }
                                return Task.whenAll(task);
                            }

                            public volatile Object then(Task task)
                                throws Exception
                            {
                                return then(task);
                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                        });
                    }

                    public volatile Object then(Task task)
                        throws Exception
                    {
                        return then(task);
                    }

            
            {
                this$1 = _cls14.this;
                super();
            }
                });
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                super();
            }
        });
        try
        {
            Parse.waitForTask(task);
        }
        catch (ParseException parseexception)
        {
            throw new IllegalStateException(parseexception);
        }
        simulateReboot();
        resume();
    }

    public Task enqueueEventuallyAsync(final ParseCommand command, final ParseObject object)
    {
        Parse.requirePermission("android.permission.ACCESS_NETWORK_STATE");
        final bolts.Task.TaskCompletionSource tcs = Task.create();
        taskQueue.enqueue(new Continuation() {

            final ParsePinningEventuallyQueue this$0;
            final ParseCommand val$command;
            final ParseObject val$object;
            final bolts.Task.TaskCompletionSource val$tcs;

            public Task then(Task task)
                throws Exception
            {
                return enqueueEventuallyAsync(command, object, task, tcs);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                command = parsecommand;
                object = parseobject;
                tcs = taskcompletionsource;
                super();
            }
        });
        return tcs.getTask();
    }

    public void pause()
    {
        synchronized (connectionLock)
        {
            connectionTaskCompletionSource.trySetError(new PauseException());
            connectionTaskCompletionSource = Task.create();
            connectionTaskCompletionSource.trySetError(new PauseException());
        }
        obj = taskQueueSyncLock;
        obj;
        JVM INSTR monitorenter ;
        String s;
        for (Iterator iterator = pendingEventuallyTasks.keySet().iterator(); iterator.hasNext(); ((bolts.Task.TaskCompletionSource)pendingEventuallyTasks.get(s)).trySetError(new PauseException()))
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
            Parse.waitForTask(whenAll(Arrays.asList(new TaskQueue[] {
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
            i = ((Integer)Parse.waitForTask(pendingCountAsync())).intValue();
        }
        catch (ParseException parseexception)
        {
            throw new IllegalStateException(parseexception);
        }
        return i;
    }

    public Task pendingCountAsync()
    {
        final bolts.Task.TaskCompletionSource tcs = Task.create();
        taskQueue.enqueue(new Continuation() {

            final ParsePinningEventuallyQueue this$0;
            final bolts.Task.TaskCompletionSource val$tcs;

            public Task then(Task task)
                throws Exception
            {
                return pendingCountAsync(task).continueWithTask(new Continuation() {

                    final _cls2 this$1;

                    public Task then(Task task)
                        throws Exception
                    {
                        int i = ((Integer)task.getResult()).intValue();
                        tcs.setResult(Integer.valueOf(i));
                        return Task.forResult(null);
                    }

                    public volatile Object then(Task task)
                        throws Exception
                    {
                        return then(task);
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                });
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                tcs = taskcompletionsource;
                super();
            }
        });
        return tcs.getTask();
    }

    public Task pendingCountAsync(Task task)
    {
        return task.continueWithTask(new Continuation() {

            final ParsePinningEventuallyQueue this$0;

            public Task then(Task task1)
                throws Exception
            {
                return EventuallyPin.findAllPinned().continueWithTask(new Continuation() {

                    final _cls3 this$1;

                    public Task then(Task task)
                        throws Exception
                    {
                        return Task.forResult(Integer.valueOf(((List)task.getResult()).size()));
                    }

                    public volatile Object then(Task task)
                        throws Exception
                    {
                        return then(task);
                    }

            
            {
                this$1 = _cls3.this;
                super();
            }
                });
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                super();
            }
        });
    }

    public void resume()
    {
        setConnected(isConnected());
        populateQueueAsync();
    }

    public void setConnected(boolean flag)
    {
        Object obj = connectionLock;
        obj;
        JVM INSTR monitorenter ;
        super.setConnected(flag);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        connectionTaskCompletionSource.trySetResult(null);
        connectionTaskCompletionSource = Task.create();
        connectionTaskCompletionSource.trySetResult(null);
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        connectionTaskCompletionSource = Task.create();
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

    Task waitForOperationSetAndEventuallyPin(final ParseOperationSet uuid, EventuallyPin eventuallypin)
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
        uuid = (bolts.Task.TaskCompletionSource)pendingEventuallyTasks.get(uuid);
_L7:
        uuid = uuid.getTask();
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
        eventuallypin = Task.create();
        pendingEventuallyTasks.put(uuid, eventuallypin);
        uuid = eventuallypin;
          goto _L7
_L4:
        final bolts.Task.TaskCompletionSource tcs = (bolts.Task.TaskCompletionSource)pendingEventuallyTasks.get(uuid);
        obj;
        JVM INSTR monitorexit ;
        return process(eventuallypin, parseoperationset).continueWithTask(new Continuation() {

            final ParsePinningEventuallyQueue this$0;
            final bolts.Task.TaskCompletionSource val$tcs;
            final String val$uuid;

            public Task then(Task task)
                throws Exception
            {
                synchronized (taskQueueSyncLock)
                {
                    pendingEventuallyTasks.remove(uuid);
                    uuidToOperationSet.remove(uuid);
                    uuidToEventuallyPin.remove(uuid);
                }
                obj1 = task.getError();
                if (obj1 != null)
                {
                    tcs.trySetError(((Exception) (obj1)));
                } else
                if (task.isCancelled())
                {
                    tcs.trySetCancelled();
                } else
                {
                    tcs.trySetResult(task.getResult());
                }
                return tcs.getTask();
                task;
                obj1;
                JVM INSTR monitorexit ;
                throw task;
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParsePinningEventuallyQueue.this;
                uuid = s;
                tcs = taskcompletionsource;
                super();
            }
        });
        if (true) goto _L9; else goto _L8
_L8:
    }













}
