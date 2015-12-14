// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import android.os.SystemClock;
import bolts.Continuation;
import bolts.Task;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

// Referenced classes of package com.parse:
//            Parse, PushRouter, ParseWakeLock, ParseCommand, 
//            ConnectivityNotifier

class PushConnection
{
    public class ConnectState extends State
    {

        private long lastDelay;
        final PushConnection this$0;

        private long nextDelay()
        {
            return Math.min(Math.max(15000L, (long)((double)lastDelay * (1.5D + Math.random() * 0.5D))), 0x493e0L);
        }

        private boolean sendHandshake(Socket socket)
        {
            boolean flag = false;
            Object obj = PushRouter.getPushRequestJSONAsync();
            try
            {
                ((Task) (obj)).waitForCompletion();
            }
            catch (InterruptedException interruptedexception)
            {
                Parse.logE("com.parse.PushConnection", "Unexpected interruption when waiting for handshake to be sent", interruptedexception);
            }
            obj = (JSONObject)((Task) (obj)).getResult();
            if (obj != null)
            {
                flag = PushConnection.writeLine(socket, ((JSONObject) (obj)).toString());
            }
            return flag;
        }

        public State runState()
        {
            Object obj1;
            Socket socket;
            boolean flag1;
            flag1 = false;
            socket = new Socket();
            obj1 = null;
            InetSocketAddress inetsocketaddress = new InetSocketAddress(host, port);
            Object obj;
            boolean flag;
            flag = flag1;
            obj = obj1;
            if (inetsocketaddress == null)
            {
                break MISSING_BLOCK_LABEL_74;
            }
            socket.connect(inetsocketaddress, 40000);
            socket.setKeepAlive(true);
            socket.setTcpNoDelay(true);
            flag = sendHandshake(socket);
            obj = obj1;
_L1:
            if (obj != null)
            {
                Parse.logI("com.parse.PushConnection", (new StringBuilder()).append("Failed to connect to push server due to ").append(obj).toString());
            }
            if (!flag)
            {
                PushConnection.closeSocket(socket);
                return new WaitRetryState(nextDelay());
            } else
            {
                return new ConnectedState(socket);
            }
            obj;
            flag = flag1;
              goto _L1
            obj;
            flag = flag1;
              goto _L1
        }

        public ConnectState(long l)
        {
            this$0 = PushConnection.this;
            super();
            lastDelay = l;
        }
    }

    public class ConnectedState extends State
    {

        private Socket socket;
        final PushConnection this$0;

        public State runState()
        {
            Object obj = null;
            ReachabilityMonitor reachabilitymonitor = new ReachabilityMonitor();
            KeepAliveMonitor keepalivemonitor = new KeepAliveMonitor(socket, PushConnection.KEEP_ALIVE_INTERVAL);
            ReaderThread readerthread = new ReaderThread(socket);
            reachabilitymonitor.register();
            keepalivemonitor.register();
            readerthread.start();
            do
            {
                if (obj != null)
                {
                    break;
                }
                Set set = eventSet.await(new Event[] {
                    Event.STOP, Event.CONNECTIVITY_CHANGED, Event.KEEP_ALIVE_ERROR, Event.READ_ERROR
                });
                if (set.contains(Event.STOP))
                {
                    obj = new StoppedState();
                } else
                if (set.contains(Event.READ_ERROR) || set.contains(Event.KEEP_ALIVE_ERROR) || set.contains(Event.CONNECTIVITY_CHANGED))
                {
                    obj = new WaitRetryState(0L);
                }
            } while (true);
            reachabilitymonitor.unregister();
            keepalivemonitor.unregister();
            readerthread.stopReading();
            PushConnection.closeSocket(socket);
            eventSet.removeEvents(new Event[] {
                Event.CONNECTIVITY_CHANGED, Event.KEEP_ALIVE_ERROR, Event.READ_ERROR
            });
            return ((State) (obj));
        }

        public ConnectedState(Socket socket1)
        {
            this$0 = PushConnection.this;
            super();
            socket = socket1;
        }
    }

    private static final class Event extends Enum
    {

        private static final Event $VALUES[];
        public static final Event CONNECTIVITY_CHANGED;
        public static final Event KEEP_ALIVE_ERROR;
        public static final Event READ_ERROR;
        public static final Event START;
        public static final Event STOP;

        public static Event valueOf(String s)
        {
            return (Event)Enum.valueOf(com/parse/PushConnection$Event, s);
        }

        public static Event[] values()
        {
            return (Event[])$VALUES.clone();
        }

        static 
        {
            START = new Event("START", 0);
            STOP = new Event("STOP", 1);
            CONNECTIVITY_CHANGED = new Event("CONNECTIVITY_CHANGED", 2);
            KEEP_ALIVE_ERROR = new Event("KEEP_ALIVE_ERROR", 3);
            READ_ERROR = new Event("READ_ERROR", 4);
            $VALUES = (new Event[] {
                START, STOP, CONNECTIVITY_CHANGED, KEEP_ALIVE_ERROR, READ_ERROR
            });
        }

        private Event(String s, int i)
        {
            super(s, i);
        }
    }

    private static class EventSet
    {

        private final Condition condition;
        private final Lock lock;
        private final HashSet signaledEvents;

        public transient Set await(Event aevent[])
        {
            return timedAwait(0x7fffffffffffffffL, aevent);
        }

        public transient void removeEvents(Event aevent[])
        {
            lock.lock();
            int j = aevent.length;
            int i = 0;
_L2:
            Event event;
            if (i >= j)
            {
                break; /* Loop/switch isn't completed */
            }
            event = aevent[i];
            signaledEvents.remove(event);
            i++;
            if (true) goto _L2; else goto _L1
_L1:
            lock.unlock();
            return;
            aevent;
            lock.unlock();
            throw aevent;
        }

        public void signalEvent(Event event)
        {
            lock.lock();
            signaledEvents.add(event);
            condition.signalAll();
            lock.unlock();
            return;
            event;
            lock.unlock();
            throw event;
        }

        public transient Set timedAwait(long l, Event aevent[])
        {
            boolean flag;
            long l2;
            Set set = Collections.EMPTY_SET;
            HashSet hashset = new HashSet(Arrays.asList(aevent));
            long l1 = SystemClock.elapsedRealtime();
            int i;
            if (l == 0x7fffffffffffffffL)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            lock.lock();
            aevent = set;
_L5:
            l2 = SystemClock.elapsedRealtime() - l1;
            aevent = new HashSet(hashset);
            aevent.retainAll(signaledEvents);
            signaledEvents.removeAll(hashset);
            i = aevent.size();
            if (i == 0 && (flag || l2 < l)) goto _L2; else goto _L1
_L1:
            lock.unlock();
            return aevent;
_L2:
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_144;
            }
            condition.awaitUninterruptibly();
            continue; /* Loop/switch isn't completed */
            try
            {
                condition.await(l - l2, TimeUnit.MILLISECONDS);
                continue; /* Loop/switch isn't completed */
            }
            catch (InterruptedException interruptedexception) { }
            finally
            {
                if (true) goto _L0; else goto _L0
            }
            if (true) goto _L1; else goto _L3
_L3:
            aevent;
            lock.unlock();
            throw aevent;
            if (true) goto _L5; else goto _L4
_L4:
        }

        private EventSet()
        {
            lock = new ReentrantLock();
            condition = lock.newCondition();
            signaledEvents = new HashSet();
        }

    }

    private class KeepAliveMonitor
    {

        private PendingIntent broadcast;
        private final long interval;
        private Task keepAliveTask;
        private AlarmManager manager;
        private BroadcastReceiver readReceiver;
        private final Socket socket;
        final PushConnection this$0;
        private boolean unregistered;
        private BroadcastReceiver writeReceiver;

        private void signalKeepAliveFailure()
        {
            this;
            JVM INSTR monitorenter ;
            if (!unregistered)
            {
                eventSet.signalEvent(Event.KEEP_ALIVE_ERROR);
            }
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public void register()
        {
            final Context appContext = Parse.applicationContext;
            String s = appContext.getPackageName();
            Object obj = new Intent("com.parse.PushConnection.readKeepAlive");
            ((Intent) (obj)).setPackage(s);
            ((Intent) (obj)).addCategory(s);
            Intent intent = new Intent("com.parse.PushConnection.writeKeepAlive");
            intent.setPackage(s);
            intent.addCategory(s);
            manager = (AlarmManager)appContext.getSystemService("alarm");
            PendingIntent pendingintent = PendingIntent.getBroadcast(appContext, 0, ((Intent) (obj)), 0);
            long l;
            if (pendingintent != null)
            {
                manager.cancel(pendingintent);
                pendingintent.cancel();
            } else
            {
                Parse.logE("com.parse.PushConnection", "oldReadBroadcast was null");
            }
            broadcast = PendingIntent.getBroadcast(appContext, 0, intent, 0);
            manager.cancel(broadcast);
            l = SystemClock.elapsedRealtime();
            manager.setInexactRepeating(2, l, interval, broadcast);
            readReceiver = new BroadcastReceiver() {

                final KeepAliveMonitor this$1;

                public void onReceive(Context context, Intent intent)
                {
                    long l = SystemClock.elapsedRealtime() - lastReadTime.get();
                    if (l > PushConnection.KEEP_ALIVE_ACK_INTERVAL * 2L)
                    {
                        Parse.logV("com.parse.PushConnection", (new StringBuilder()).append("Keep alive failure: last read was ").append(l).append(" ms ago.").toString());
                        signalKeepAliveFailure();
                    }
                }

            
            {
                this$1 = KeepAliveMonitor.this;
                super();
            }
            };
            writeReceiver = ((_cls2) (obj)). new BroadcastReceiver() {

                final KeepAliveMonitor this$1;
                final Context val$appContext;
                final Intent val$readIntent;

                public void onReceive(Context context, Intent intent)
                {
                    context = ParseWakeLock.acquireNewWakeLock(service, 1, "push-keep-alive", 20000L);
                    if (keepAliveTask == null)
                    {
                        keepAliveTask = Task.forResult(null).makeVoid();
                    }
                    keepAliveTask = keepAliveTask.continueWith(context. new Continuation() {

                        final KeepAliveMonitor._cls2 this$2;
                        final ParseWakeLock val$wl;

                        public volatile Object then(Task task)
                            throws Exception
                        {
                            return then(task);
                        }

                        public Void then(Task task)
                        {
                            if (!PushConnection.writeLine(socket, "{}"))
                            {
                                signalKeepAliveFailure();
                            }
                            boolean flag = false;
                            if (PushConnection.ENABLE_QUICK_ACK_CHECK)
                            {
                                try
                                {
                                    Thread.sleep(2500L);
                                }
                                // Misplaced declaration of an exception variable
                                catch (Task task) { }
                                if (SystemClock.elapsedRealtime() - lastReadTime.get() <= 2L * 2500L)
                                {
                                    flag = true;
                                } else
                                {
                                    flag = false;
                                }
                            }
                            if (!flag)
                            {
                                task = PendingIntent.getBroadcast(appContext, System.identityHashCode(this), readIntent, 0x50000000);
                                manager.set(2, SystemClock.elapsedRealtime() + PushConnection.KEEP_ALIVE_ACK_INTERVAL, task);
                            } else
                            {
                                Parse.logV("com.parse.PushConnection", "Keep alive ack was received quickly.");
                            }
                            wl.release();
                            return null;
                        }

            
            {
                this$2 = final__pcls2;
                wl = ParseWakeLock.this;
                super();
            }
                    }, ParseCommand.NETWORK_EXECUTOR);
                }

            
            {
                this$1 = final_keepalivemonitor;
                appContext = context;
                readIntent = Intent.this;
                super();
            }
            };
            obj = new IntentFilter("com.parse.PushConnection.readKeepAlive");
            ((IntentFilter) (obj)).addCategory(s);
            appContext.registerReceiver(readReceiver, ((IntentFilter) (obj)));
            obj = new IntentFilter("com.parse.PushConnection.writeKeepAlive");
            ((IntentFilter) (obj)).addCategory(s);
            appContext.registerReceiver(writeReceiver, ((IntentFilter) (obj)));
        }

        public void unregister()
        {
            Parse.applicationContext.unregisterReceiver(readReceiver);
            Parse.applicationContext.unregisterReceiver(writeReceiver);
            manager.cancel(broadcast);
            broadcast.cancel();
            this;
            JVM INSTR monitorenter ;
            unregistered = true;
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }




/*
        static Task access$1302(KeepAliveMonitor keepalivemonitor, Task task)
        {
            keepalivemonitor.keepAliveTask = task;
            return task;
        }

*/



        public KeepAliveMonitor(Socket socket1, long l)
        {
            this$0 = PushConnection.this;
            super();
            socket = socket1;
            interval = l;
        }
    }

    private class ReachabilityMonitor
    {

        private ConnectivityNotifier.ConnectivityListener listener;
        final PushConnection this$0;
        private boolean unregistered;

        public void register()
        {
            listener = new ConnectivityNotifier.ConnectivityListener() {

                final ReachabilityMonitor this$1;

                public void networkConnectivityStatusChanged(Intent intent)
                {
                    synchronized (ReachabilityMonitor.this)
                    {
                        if (!unregistered)
                        {
                            eventSet.signalEvent(Event.CONNECTIVITY_CHANGED);
                        }
                    }
                    return;
                    exception;
                    intent;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

            
            {
                this$1 = ReachabilityMonitor.this;
                super();
            }
            };
            ConnectivityNotifier.getNotifier().addListener(listener, service);
        }

        public void unregister()
        {
            ConnectivityNotifier.getNotifier().removeListener(listener);
            this;
            JVM INSTR monitorenter ;
            unregistered = true;
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }


        private ReachabilityMonitor()
        {
            this$0 = PushConnection.this;
            super();
        }

    }

    private class ReaderThread extends Thread
    {

        private Socket socket;
        private boolean stopped;
        final PushConnection this$0;

        private void runReaderLoop(BufferedReader bufferedreader)
        {
_L3:
            Object obj = null;
            String s = bufferedreader.readLine();
            obj = s;
            lastReadTime.set(SystemClock.elapsedRealtime());
            obj = s;
_L4:
            Object obj1;
            if (obj == null)
            {
                return;
            }
            obj1 = new JSONTokener(((String) (obj)));
            s = null;
            obj1 = new JSONObject(((JSONTokener) (obj1)));
            obj = obj1;
_L2:
            if (obj != null)
            {
                PushRouter.handlePpnsPushAsync(((JSONObject) (obj)));
            }
            this;
            JVM INSTR monitorenter ;
            if (!stopped)
            {
                break; /* Loop/switch isn't completed */
            }
            this;
            JVM INSTR monitorexit ;
            return;
            bufferedreader;
            this;
            JVM INSTR monitorexit ;
            throw bufferedreader;
            JSONException jsonexception;
            jsonexception;
            Parse.logE("com.parse.PushConnection", (new StringBuilder()).append("bad json: ").append(((String) (obj))).toString(), jsonexception);
            obj = s;
            if (true) goto _L2; else goto _L1
_L1:
            this;
            JVM INSTR monitorexit ;
              goto _L3
            IOException ioexception;
            ioexception;
              goto _L4
        }

        public void run()
        {
            BufferedReader bufferedreader = null;
            BufferedReader bufferedreader1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedreader = bufferedreader1;
_L2:
            if (bufferedreader != null)
            {
                runReaderLoop(bufferedreader);
                Exception exception;
                try
                {
                    bufferedreader.close();
                }
                catch (IOException ioexception) { }
            }
            this;
            JVM INSTR monitorenter ;
            if (!stopped)
            {
                eventSet.signalEvent(Event.READ_ERROR);
            }
            this;
            JVM INSTR monitorexit ;
            return;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
            IOException ioexception1;
            ioexception1;
            if (true) goto _L2; else goto _L1
_L1:
        }

        public void stopReading()
        {
            this;
            JVM INSTR monitorenter ;
            stopped = true;
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public ReaderThread(Socket socket1)
        {
            this$0 = PushConnection.this;
            super();
            socket = socket1;
            stopped = false;
        }
    }

    public abstract class State
        implements Runnable
    {

        final PushConnection this$0;

        public boolean isTerminal()
        {
            return false;
        }

        public void run()
        {
            Object obj = runState();
            com/parse/PushConnection;
            JVM INSTR monitorenter ;
            if (PushConnection.stateTransitionListener != null)
            {
                PushConnection.stateTransitionListener.onStateChange(PushConnection.this, this, ((State) (obj)));
            }
            com/parse/PushConnection;
            JVM INSTR monitorexit ;
            if (isTerminal())
            {
                Parse.logI("com.parse.PushConnection", (new StringBuilder()).append(this).append(" finished and is the terminal state. Thread exiting.").toString());
                executor.shutdown();
                return;
            }
            break MISSING_BLOCK_LABEL_81;
            obj;
            com/parse/PushConnection;
            JVM INSTR monitorexit ;
            throw obj;
            if (obj != null)
            {
                Parse.logI("com.parse.PushConnection", (new StringBuilder()).append("PushConnection transitioning from ").append(this).append(" to ").append(obj).toString());
                executor.execute(((Runnable) (obj)));
                return;
            } else
            {
                throw new NullPointerException((new StringBuilder()).append(this).append(" tried to transition to null state.").toString());
            }
        }

        public abstract State runState();

        public State()
        {
            this$0 = PushConnection.this;
            super();
        }
    }

    public static interface StateTransitionListener
    {

        public abstract void onStateChange(PushConnection pushconnection, State state, State state1);
    }

    public class StoppedState extends State
    {

        final PushConnection this$0;

        public boolean isTerminal()
        {
            return true;
        }

        public State runState()
        {
            return null;
        }

        public StoppedState()
        {
            this$0 = PushConnection.this;
            super();
        }
    }

    public class WaitRetryState extends State
    {

        private long delay;
        final PushConnection this$0;

        public long getDelay()
        {
            return delay;
        }

        public State runState()
        {
            eventSet.removeEvents(new Event[] {
                Event.START
            });
            long l = delay;
            if (!PushConnection.ENABLE_RETRY_DELAY)
            {
                l = 0L;
            }
            Set set = eventSet.timedAwait(l, new Event[] {
                Event.STOP, Event.START
            });
            if (set.contains(Event.STOP))
            {
                return new StoppedState();
            }
            if (set.contains(Event.START))
            {
                return new ConnectState(0L);
            } else
            {
                return new ConnectState(delay);
            }
        }

        public WaitRetryState(long l)
        {
            this$0 = PushConnection.this;
            super();
            delay = l;
        }
    }

    public class WaitStartState extends State
    {

        final PushConnection this$0;

        public State runState()
        {
            StoppedState stoppedstate = null;
            Set set = eventSet.await(new Event[] {
                Event.START, Event.STOP
            });
            if (set.contains(Event.STOP))
            {
                stoppedstate = new StoppedState();
            } else
            if (set.contains(Event.START))
            {
                return new ConnectState(0L);
            }
            return stoppedstate;
        }

        public WaitStartState()
        {
            this$0 = PushConnection.this;
            super();
        }
    }


    private static final int CONNECT_TIMEOUT_MS = 40000;
    static boolean ENABLE_QUICK_ACK_CHECK = false;
    static boolean ENABLE_RETRY_DELAY = false;
    static long KEEP_ALIVE_ACK_INTERVAL = 0L;
    static long KEEP_ALIVE_INTERVAL = 0L;
    private static final long MAX_RETRY_DELAY_MS = 0x493e0L;
    private static final long MIN_RETRY_DELAY_MS = 15000L;
    private static final double RETRY_MULT_FACTOR_MAX = 2D;
    private static final double RETRY_MULT_FACTOR_MIN = 1.5D;
    private static final String TAG = "com.parse.PushConnection";
    private static StateTransitionListener stateTransitionListener;
    private final EventSet eventSet = new EventSet();
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final String host;
    private final AtomicLong lastReadTime = new AtomicLong();
    private final int port;
    private final Service service;

    public PushConnection(Service service1, String s, int i)
    {
        service = service1;
        host = s;
        port = i;
        executor.execute(new WaitStartState());
    }

    private static void closeSocket(Socket socket)
    {
        try
        {
            socket.shutdownInput();
            socket.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Socket socket)
        {
            return;
        }
    }

    public static void setStateTransitionListener(StateTransitionListener statetransitionlistener)
    {
        com/parse/PushConnection;
        JVM INSTR monitorenter ;
        stateTransitionListener = statetransitionlistener;
        com/parse/PushConnection;
        JVM INSTR monitorexit ;
        return;
        statetransitionlistener;
        com/parse/PushConnection;
        JVM INSTR monitorexit ;
        throw statetransitionlistener;
    }

    private static boolean writeLine(Socket socket, String s)
    {
        if (Thread.currentThread() == Looper.getMainLooper().getThread())
        {
            throw new Error("Wrote to push socket on main thread.");
        }
        try
        {
            socket = socket.getOutputStream();
            socket.write((new StringBuilder()).append(s).append("\n").toString().getBytes("UTF-8"));
            socket.flush();
        }
        // Misplaced declaration of an exception variable
        catch (Socket socket)
        {
            Parse.logV("com.parse.PushConnection", (new StringBuilder()).append("PushConnection write failed: ").append(s).append(" due to exception: ").append(socket).toString());
            return false;
        }
        return true;
    }

    public void start()
    {
        this;
        JVM INSTR monitorenter ;
        eventSet.signalEvent(Event.START);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void stop()
    {
        this;
        JVM INSTR monitorenter ;
        eventSet.signalEvent(Event.STOP);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static 
    {
        KEEP_ALIVE_INTERVAL = 0xdbba0L;
        KEEP_ALIVE_ACK_INTERVAL = 60000L;
        ENABLE_QUICK_ACK_CHECK = true;
        ENABLE_RETRY_DELAY = true;
    }









}
