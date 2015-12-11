// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.resolver;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import com.digimarc.dms.DMSPayload;
import com.digimarc.dms.imagereader.Payload;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.digimarc.dms.resolver:
//            ResolverWorkerThread, AppMetricsWatcher, PayoffContainer, ResolveResult, 
//            ResolveItem, MessageID, ResolverServiceHandler

public class ResolverService extends Service
{
    public static interface OnReportActionListener
    {

        public abstract void onFailed(String s, int i);

        public abstract void onSuccess(String s);
    }

    public static interface OnResolvedListener
    {

        public abstract void onError(Payload payload);

        public abstract void onResolvedUnknown(ResolveResult resolveresult);

        public abstract void onResolvedWithPayoff(ResolveResult resolveresult);
    }

    private class PayloadContainer
    {

        private PayoffContainer mPayoff;
        private State mState;
        final ResolverService this$0;

        public PayoffContainer getPayoff()
        {
            return mPayoff;
        }

        public State getState()
        {
            return mState;
        }

        public void update(State state, PayoffContainer payoffcontainer)
        {
            mPayoff = payoffcontainer;
            mState = state;
        }

        public PayloadContainer(State state)
        {
            this$0 = ResolverService.this;
            super();
            mPayoff = null;
            mState = state;
        }
    }

    public class ResolverBinder extends Binder
    {

        final ResolverService this$0;

        public ResolverService getService()
        {
            return ResolverService.this;
        }

        public ResolverBinder()
        {
            this$0 = ResolverService.this;
            super();
        }
    }

    private static final class State extends Enum
    {

        private static final State $VALUES[];
        public static final State resolved;
        public static final State resolving;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/digimarc/dms/resolver/ResolverService$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            resolving = new State("resolving", 0);
            resolved = new State("resolved", 1);
            $VALUES = (new State[] {
                resolving, resolved
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String LabsService = "http://labs-resolver.digimarc.net";
    public static final String LabsServiceSSL = "https://labs-resolver.digimarc.net";
    public static final String ProductionService = "http://resolver.digimarc.net";
    public static final String ProductionServiceSSL = "https://resolver.digimarc.net";
    private static boolean mInitialized = false;
    private final int MAX_THREADS = 5;
    private final String TAG = "DiscoverResolverService";
    private final String VERSION = "MAJOR.MINOR.CHANGELIST";
    private final ResolverBinder mBinder = new ResolverBinder();
    private ResolverServiceHandler mHandler;
    private OnReportActionListener mReportActionListener;
    private ConcurrentHashMap mResolvedPayloadCache;
    private ArrayList mResolverThreadPool;
    private final List mServiceCallbackList = Collections.synchronizedList(new LinkedList());
    private ConcurrentHashMap mTemplateDownloadThreads;
    private ThreadGroup mTemplateThreadGroup;
    private int mThreadIndex;

    public ResolverService()
    {
        mThreadIndex = 0;
        mTemplateDownloadThreads = new ConcurrentHashMap();
        mTemplateThreadGroup = new ThreadGroup("Template Downloads");
        mResolvedPayloadCache = new ConcurrentHashMap();
    }

    private void doInit(String s, String s1, boolean flag, String s2)
    {
        if (mInitialized)
        {
            return;
        }
        mResolverThreadPool = new ArrayList();
        for (int i = 0; i < 5; i++)
        {
            ResolverWorkerThread resolverworkerthread = new ResolverWorkerThread(getApplicationContext(), s, s1, mHandler, flag, s2);
            mResolverThreadPool.add(resolverworkerthread);
            resolverworkerthread.start();
        }

        mInitialized = true;
    }

    private ResolverWorkerThread getFreeThread()
    {
        if (mResolverThreadPool == null)
        {
            return null;
        } else
        {
            mThreadIndex = (mThreadIndex + 1) % 5;
            return (ResolverWorkerThread)mResolverThreadPool.get(mThreadIndex);
        }
    }

    private void notifyListeners(PayoffContainer payoffcontainer)
    {
        ListIterator listiterator = mServiceCallbackList.listIterator();
        boolean flag = false;
        do
        {
            if (!listiterator.hasNext())
            {
                break;
            }
            OnResolvedListener onresolvedlistener = (OnResolvedListener)listiterator.next();
            boolean flag2 = onresolvedlistener.toString().contains(com/digimarc/dms/resolver/AppMetricsWatcher.getSimpleName());
            boolean flag1;
            if (!flag2)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (AppMetricsWatcher.isFakePayload(payoffcontainer.getPayload()))
            {
                flag1 = flag2;
            }
            if (flag1)
            {
                if (payoffcontainer.getStandardPayoff() == null)
                {
                    onresolvedlistener.onResolvedUnknown(ResolveResult.create(payoffcontainer));
                    flag = true;
                    continue;
                }
                onresolvedlistener.onResolvedWithPayoff(ResolveResult.create(payoffcontainer));
            }
            flag = true;
        } while (true);
        if (flag)
        {
            mTemplateDownloadThreads.remove(payoffcontainer.getPayload().getPayloadDataAsString());
            mResolvedPayloadCache.remove(payoffcontainer.getPayload().getPayloadDataAsString());
        }
    }

    private void notifyListenersOfError(Payload payload)
    {
        for (ListIterator listiterator = mServiceCallbackList.listIterator(); listiterator.hasNext(); ((OnResolvedListener)listiterator.next()).onError(payload)) { }
        mTemplateDownloadThreads.remove(payload.getPayloadDataAsString());
        mResolvedPayloadCache.remove(payload.getPayloadDataAsString());
    }

    private void resolve(ResolveItem resolveitem)
    {
        Payload payload = resolveitem.getPayload();
        if (!mInitialized)
        {
            notifyListenersOfError(payload);
        } else
        {
            if (!mResolvedPayloadCache.containsKey(payload.getPayloadDataAsString()))
            {
                mResolvedPayloadCache.put(payload.getPayloadDataAsString(), new PayloadContainer(State.resolving));
                sendResolveMessage(resolveitem);
                return;
            }
            resolveitem = (PayloadContainer)mResolvedPayloadCache.get(payload.getPayloadDataAsString());
            if (resolveitem.getState() == State.resolved)
            {
                notifyListeners(resolveitem.getPayoff());
                return;
            }
        }
    }

    private void sendResolveMessage(ResolveItem resolveitem)
    {
        int i = MessageID.resolverthreadhandler_resolve_message;
        ResolverWorkerThread resolverworkerthread = getFreeThread();
        if (resolverworkerthread == null)
        {
            Log.e("DiscoverResolverService", "getFreeThread returned null");
            return;
        } else
        {
            Message message = resolverworkerthread.getHandler().obtainMessage(i);
            message.obj = resolveitem;
            resolverworkerthread.getHandler().sendMessage(message);
            return;
        }
    }

    private void stopThreads()
    {
        if (mResolverThreadPool == null)
        {
            return;
        }
        Message message = Message.obtain(mHandler, MessageID.resolverthreadhandler_shutdown_requested);
        mHandler.sendMessage(message);
        for (Iterator iterator = mResolverThreadPool.iterator(); iterator.hasNext(); ((ResolverWorkerThread)iterator.next()).getHandler().sendEmptyMessage(MessageID.resolverthreadhandler_exit_thread_message)) { }
        mResolvedPayloadCache.clear();
        mInitialized = false;
    }

    public boolean cancelAllResolves()
    {
        mResolvedPayloadCache.clear();
        mTemplateThreadGroup.interrupt();
        mTemplateDownloadThreads.clear();
        return true;
    }

    public boolean cancelResolve(Payload payload)
    {
        mResolvedPayloadCache.remove(payload.getPayloadDataAsString());
        Thread thread = (Thread)mTemplateDownloadThreads.get(payload.getPayloadDataAsString());
        if (thread != null)
        {
            thread.interrupt();
        }
        mTemplateDownloadThreads.remove(payload.getPayloadDataAsString());
        return true;
    }

    public String getVersion()
    {
        return "MAJOR.MINOR.CHANGELIST";
    }

    public void init(String s, String s1)
    {
        doInit(s, s1, false, null);
    }

    public void init(String s, String s1, boolean flag, String s2)
    {
        doInit(s, s1, flag, s2);
    }

    public boolean isInitialized()
    {
        return mInitialized;
    }

    public IBinder onBind(Intent intent)
    {
        return mBinder;
    }

    public void onCreate()
    {
        super.onCreate();
        mHandler = new ResolverServiceHandler(this);
    }

    public void onDestroy()
    {
        super.onDestroy();
        stopThreads();
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        return 1;
    }

    public void onUpdateResolveProgress(float f)
    {
    }

    void payloadResolved(PayoffContainer payoffcontainer)
    {
        PayloadContainer payloadcontainer = (PayloadContainer)mResolvedPayloadCache.get(payoffcontainer.getPayload().getPayloadDataAsString());
        if (payloadcontainer != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (payoffcontainer.getResultEnum() != PayoffContainer.PayoffResult.NetworkError)
        {
            continue; /* Loop/switch isn't completed */
        }
        mResolvedPayloadCache.remove(payoffcontainer.getPayload().getPayloadDataAsString());
        payoffcontainer = payoffcontainer.getPayload();
        if (AppMetricsWatcher.isFakePayload(payoffcontainer)) goto _L1; else goto _L3
_L3:
        notifyListenersOfError(payoffcontainer);
        return;
        if (payloadcontainer.getState() != State.resolving || payoffcontainer.getResultEnum() != PayoffContainer.PayoffResult.Resolved && payoffcontainer.getResultEnum() != PayoffContainer.PayoffResult.DefaultPayoff && payoffcontainer.getResultEnum() != PayoffContainer.PayoffResult.Unresolved) goto _L1; else goto _L4
_L4:
        payloadcontainer.update(State.resolved, payoffcontainer);
        notifyListeners(payoffcontainer);
        return;
    }

    public void removeOnReportActionListener(OnReportActionListener onreportactionlistener)
    {
        mReportActionListener = null;
    }

    public void removeOnResolvedListener(OnResolvedListener onresolvedlistener)
    {
        mServiceCallbackList.remove(onresolvedlistener);
    }

    public void reportAction(String s)
    {
        if (!mInitialized)
        {
            return;
        }
        ResolverWorkerThread resolverworkerthread = getFreeThread();
        if (resolverworkerthread == null)
        {
            Log.e("DiscoverResolverService", "getFreeThread returned null");
            return;
        } else
        {
            Message message = resolverworkerthread.getHandler().obtainMessage(MessageID.resolverthreadhandler_reportaction_message);
            message.obj = s;
            resolverworkerthread.getHandler().sendMessage(message);
            return;
        }
    }

    void reportActionFailed(String s, int i)
    {
        if (mReportActionListener != null)
        {
            mReportActionListener.onFailed(s, i);
        }
    }

    void reportActionSuccess(String s)
    {
        if (mReportActionListener != null)
        {
            mReportActionListener.onSuccess(s);
        }
    }

    public void resolve(DMSPayload dmspayload)
    {
        resolve(new ResolveItem(new Payload(dmspayload.getPayloadId())));
    }

    public void resolve(Payload payload)
    {
        resolve(new ResolveItem(payload));
    }

    public void resolve(Payload payload, Location location)
    {
        resolve(new ResolveItem(payload));
    }

    public void setOnReportActionListener(OnReportActionListener onreportactionlistener)
    {
        mReportActionListener = onreportactionlistener;
    }

    public void setOnResolvedListener(OnResolvedListener onresolvedlistener)
    {
        if (!mServiceCallbackList.contains(onresolvedlistener))
        {
            mServiceCallbackList.add(onresolvedlistener);
        }
    }

}
