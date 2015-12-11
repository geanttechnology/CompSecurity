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
import android.support.v7.ct;
import android.support.v7.cu;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

// Referenced classes of package com.parse:
//            PLog, PushRouter, Parse, ParseWakeLock, 
//            ParseRESTCommand, ConnectivityNotifier, ParseIOUtils

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
            Object obj = PushRouter.getPushRequestJSONAsync();
            try
            {
                ((cu) (obj)).g();
            }
            catch (InterruptedException interruptedexception)
            {
                PLog.e("com.parse.PushConnection", "Unexpected interruption when waiting for handshake to be sent", interruptedexception);
            }
            obj = (JSONObject)((cu) (obj)).e();
            if (obj != null)
            {
                if (!(obj instanceof JSONObject))
                {
                    obj = ((JSONObject) (obj)).toString();
                } else
                {
                    obj = JSONObjectInstrumentation.toString((JSONObject)obj);
                }
                return PushConnection.writeLine(socket, ((String) (obj)));
            } else
            {
                return false;
            }
        }

        public State runState()
        {
            Object obj1 = null;
            if ("push.parse.com".equals(host)) goto _L2; else goto _L1
_L1:
            Object obj = new Socket();
_L3:
            boolean flag;
            ((Socket) (obj)).connect(new InetSocketAddress(host, port), 40000);
            ((Socket) (obj)).setKeepAlive(true);
            ((Socket) (obj)).setTcpNoDelay(true);
            flag = sendHandshake(((Socket) (obj)));
            Object obj2 = null;
            obj1 = obj;
            obj = obj2;
_L4:
            Object obj3;
            if (obj != null)
            {
                PLog.i("com.parse.PushConnection", (new StringBuilder()).append("Failed to connect to push server due to ").append(obj).toString());
            }
            if (!flag)
            {
                PushConnection.closeSocket(((Socket) (obj1)));
                return new WaitRetryState(nextDelay());
            } else
            {
                return new ConnectedState(((Socket) (obj1)));
            }
_L2:
            obj = SSLSocketFactory.getDefault().createSocket();
              goto _L3
            obj;
_L6:
            flag = false;
              goto _L4
            obj3;
            obj1 = null;
_L5:
            flag = false;
            obj = obj3;
              goto _L4
            obj3;
            obj1 = obj;
              goto _L5
            obj3;
            obj1 = obj;
            obj = obj3;
              goto _L6
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

        private final Socket socket;
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
            Object obj = Collections.EMPTY_SET;
            obj = new HashSet(Arrays.asList(aevent));
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
_L3:
            l2 = SystemClock.elapsedRealtime() - l1;
            aevent = new HashSet(((java.util.Collection) (obj)));
            aevent.retainAll(signaledEvents);
            signaledEvents.removeAll(((java.util.Collection) (obj)));
            i = aevent.size();
            if (i == 0 && (flag || l2 < l)) goto _L2; else goto _L1
_L1:
            lock.unlock();
            return aevent;
_L2:
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_153;
            }
            condition.awaitUninterruptibly();
              goto _L3
            aevent;
            lock.unlock();
            throw aevent;
            condition.await(l - l2, TimeUnit.MILLISECONDS);
              goto _L3
            InterruptedException interruptedexception;
            interruptedexception;
              goto _L1
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
        private cu keepAliveTask;
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
            final Context appContext = Parse.getApplicationContext();
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
                PLog.e("com.parse.PushConnection", "oldReadBroadcast was null");
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
                        PLog.v("com.parse.PushConnection", (new StringBuilder()).append("Keep alive failure: last read was ").append(l).append(" ms ago.").toString());
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
                        keepAliveTask = cu.a(null).j();
                    }
                    keepAliveTask = keepAliveTask.a(context. new ct() {

                        final KeepAliveMonitor._cls2 this$2;
                        final ParseWakeLock val$wl;

                        public volatile Object then(cu cu)
                            throws Exception
                        {
                            return then(cu);
                        }

                        public Void then(cu cu)
                        {
                            boolean flag1 = false;
                            if (!PushConnection.writeLine(socket, "{}"))
                            {
                                signalKeepAliveFailure();
                            }
                            boolean flag = flag1;
                            if (PushConnection.ENABLE_QUICK_ACK_CHECK)
                            {
                                try
                                {
                                    Thread.sleep(2500L);
                                }
                                // Misplaced declaration of an exception variable
                                catch (cu cu) { }
                                flag = flag1;
                                if (SystemClock.elapsedRealtime() - lastReadTime.get() <= 2500L * 2L)
                                {
                                    flag = true;
                                }
                            }
                            if (!flag)
                            {
                                cu = PendingIntent.getBroadcast(appContext, System.identityHashCode(this), readIntent, 0x50000000);
                                manager.set(2, SystemClock.elapsedRealtime() + PushConnection.KEEP_ALIVE_ACK_INTERVAL, cu);
                            } else
                            {
                                PLog.v("com.parse.PushConnection", "Keep alive ack was received quickly.");
                            }
                            wl.release();
                            return null;
                        }

            
            {
                this$2 = final__pcls2;
                wl = ParseWakeLock.this;
                super();
            }
                    }, ParseRESTCommand.NETWORK_EXECUTOR);
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
            Context context = Parse.getApplicationContext();
            context.unregisterReceiver(readReceiver);
            context.unregisterReceiver(writeReceiver);
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
        static cu access$1302(KeepAliveMonitor keepalivemonitor, cu cu)
        {
            keepalivemonitor.keepAliveTask = cu;
            return cu;
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

                public void networkConnectivityStatusChanged(Context context, Intent intent)
                {
                    synchronized (ReachabilityMonitor.this)
                    {
                        if (!unregistered)
                        {
                            eventSet.signalEvent(Event.CONNECTIVITY_CHANGED);
                        }
                    }
                    return;
                    intent;
                    context;
                    JVM INSTR monitorexit ;
                    throw intent;
                }

            
            {
                this$1 = ReachabilityMonitor.this;
                super();
            }
            };
            ConnectivityNotifier.getNotifier(service).addListener(listener);
        }

        public void unregister()
        {
            ConnectivityNotifier.getNotifier(service).removeListener(listener);
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

        private final Socket socket;
        private boolean stopped;
        final PushConnection this$0;

        private void runReaderLoop(BufferedReader bufferedreader)
        {
_L5:
            Object obj = bufferedreader.readLine();
            Object obj1;
            JSONException jsonexception;
            try
            {
                lastReadTime.set(SystemClock.elapsedRealtime());
            }
            catch (IOException ioexception) { }
            if (obj == null)
            {
                return;
            }
            break; /* Loop/switch isn't completed */
            obj;
            obj = null;
            if (true) goto _L2; else goto _L1
_L2:
            break MISSING_BLOCK_LABEL_18;
_L1:
            obj1 = new JSONTokener(((String) (obj)));
            obj1 = new JSONObject(((JSONTokener) (obj1)));
            obj = obj1;
_L4:
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
            jsonexception;
            PLog.e("com.parse.PushConnection", (new StringBuilder()).append("bad json: ").append(((String) (obj))).toString(), jsonexception);
            obj = null;
            if (true) goto _L4; else goto _L3
_L3:
            this;
            JVM INSTR monitorexit ;
              goto _L5
        }

        public void run()
        {
            Object obj2;
            Object obj3;
            obj3 = null;
            obj2 = null;
            Object obj = socket.getInputStream();
            if (obj == null) goto _L2; else goto _L1
_L1:
            Object obj1 = new BufferedReader(new InputStreamReader(((java.io.InputStream) (obj))));
            runReaderLoop(((BufferedReader) (obj1)));
_L9:
            ParseIOUtils.closeQuietly(((java.io.Closeable) (obj1)));
            ParseIOUtils.closeQuietly(((java.io.InputStream) (obj)));
_L4:
            this;
            JVM INSTR monitorenter ;
            if (!stopped)
            {
                eventSet.signalEvent(Event.READ_ERROR);
            }
            this;
            JVM INSTR monitorexit ;
            return;
            obj;
            obj = null;
            obj1 = obj2;
_L7:
            ParseIOUtils.closeQuietly(((java.io.Closeable) (obj1)));
            ParseIOUtils.closeQuietly(((java.io.InputStream) (obj)));
            if (true) goto _L4; else goto _L3
_L3:
            obj1;
            obj = null;
            obj2 = obj3;
_L6:
            ParseIOUtils.closeQuietly(((java.io.Closeable) (obj2)));
            ParseIOUtils.closeQuietly(((java.io.InputStream) (obj)));
            throw obj1;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
            obj1;
            obj2 = obj3;
            continue; /* Loop/switch isn't completed */
            Exception exception1;
            exception1;
            obj2 = obj1;
            obj1 = exception1;
            if (true) goto _L6; else goto _L5
_L5:
            obj1;
            obj1 = obj2;
              goto _L7
            IOException ioexception;
            ioexception;
              goto _L7
_L2:
            obj1 = null;
            if (true) goto _L9; else goto _L8
_L8:
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
            State state = runState();
            PushConnection.dispatchOnStateChange(PushConnection.this, this, state);
            if (isTerminal())
            {
                PLog.i("com.parse.PushConnection", (new StringBuilder()).append(this).append(" finished and is the terminal state. Thread exiting.").toString());
                executor.shutdown();
                return;
            }
            if (state != null)
            {
                PLog.i("com.parse.PushConnection", (new StringBuilder()).append("PushConnection transitioning from ").append(this).append(" to ").append(state).toString());
                executor.execute(state);
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
    private static List stateTransitionListeners;
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
        service1 = new WaitStartState();
        dispatchOnStateChange(this, null, service1);
        executor.execute(service1);
    }

    private static void closeSocket(Socket socket)
    {
        try
        {
            if (!(socket instanceof SSLSocket))
            {
                socket.shutdownInput();
            }
            socket.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Socket socket)
        {
            return;
        }
    }

    private static void dispatchOnStateChange(PushConnection pushconnection, State state, State state1)
    {
        com/parse/PushConnection;
        JVM INSTR monitorenter ;
        if (stateTransitionListeners != null)
        {
            for (Iterator iterator = stateTransitionListeners.iterator(); iterator.hasNext(); ((StateTransitionListener)iterator.next()).onStateChange(pushconnection, state, state1)) { }
        }
        break MISSING_BLOCK_LABEL_53;
        pushconnection;
        com/parse/PushConnection;
        JVM INSTR monitorexit ;
        throw pushconnection;
        com/parse/PushConnection;
        JVM INSTR monitorexit ;
    }

    public static void registerStateTransitionListener(StateTransitionListener statetransitionlistener)
    {
        com/parse/PushConnection;
        JVM INSTR monitorenter ;
        if (stateTransitionListeners == null)
        {
            stateTransitionListeners = new ArrayList();
        }
        if (!stateTransitionListeners.contains(statetransitionlistener))
        {
            stateTransitionListeners.add(statetransitionlistener);
        }
        com/parse/PushConnection;
        JVM INSTR monitorexit ;
        return;
        statetransitionlistener;
        com/parse/PushConnection;
        JVM INSTR monitorexit ;
        throw statetransitionlistener;
    }

    public static void unregisterStateTransitionListener(StateTransitionListener statetransitionlistener)
    {
        com/parse/PushConnection;
        JVM INSTR monitorenter ;
        if (stateTransitionListeners != null)
        {
            break MISSING_BLOCK_LABEL_13;
        }
        com/parse/PushConnection;
        JVM INSTR monitorexit ;
        return;
        stateTransitionListeners.remove(statetransitionlistener);
        if (stateTransitionListeners.size() == 0)
        {
            stateTransitionListeners = null;
        }
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
            PLog.v("com.parse.PushConnection", (new StringBuilder()).append("PushConnection write failed: ").append(s).append(" due to exception: ").append(socket).toString());
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
