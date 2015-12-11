// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.net;

import android.content.Context;
import android.util.Log;
import com.sessionm.c.c;
import com.sessionm.core.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.sessionm.net:
//            c, Request, d, a

public class RequestQueue extends com.sessionm.net.c
{
    public static final class RequestQueueNetworkState extends Enum
    {

        public static final RequestQueueNetworkState fQ;
        public static final RequestQueueNetworkState fR;
        public static final RequestQueueNetworkState fS;
        private static final RequestQueueNetworkState fT[];

        public static RequestQueueNetworkState valueOf(String s)
        {
            return (RequestQueueNetworkState)Enum.valueOf(com/sessionm/net/RequestQueue$RequestQueueNetworkState, s);
        }

        public static RequestQueueNetworkState[] values()
        {
            return (RequestQueueNetworkState[])fT.clone();
        }

        static 
        {
            fQ = new RequestQueueNetworkState("CONNECTED", 0);
            fR = new RequestQueueNetworkState("DISCONNECTED", 1);
            fS = new RequestQueueNetworkState("CONNECTING", 2);
            fT = (new RequestQueueNetworkState[] {
                fQ, fR, fS
            });
        }

        private RequestQueueNetworkState(String s, int k)
        {
            super(s, k);
        }
    }

    public static final class RequestQueueSendState extends Enum
    {

        public static final RequestQueueSendState fU;
        public static final RequestQueueSendState fV;
        private static final RequestQueueSendState fW[];

        public static RequestQueueSendState valueOf(String s)
        {
            return (RequestQueueSendState)Enum.valueOf(com/sessionm/net/RequestQueue$RequestQueueSendState, s);
        }

        public static RequestQueueSendState[] values()
        {
            return (RequestQueueSendState[])fW.clone();
        }

        static 
        {
            fU = new RequestQueueSendState("IDLE", 0);
            fV = new RequestQueueSendState("SENDING", 1);
            fW = (new RequestQueueSendState[] {
                fU, fV
            });
        }

        private RequestQueueSendState(String s, int k)
        {
            super(s, k);
        }
    }

    public static final class RequestQueueState extends Enum
    {

        public static final RequestQueueState fX;
        public static final RequestQueueState fY;
        private static final RequestQueueState fZ[];

        public static RequestQueueState valueOf(String s)
        {
            return (RequestQueueState)Enum.valueOf(com/sessionm/net/RequestQueue$RequestQueueState, s);
        }

        public static RequestQueueState[] values()
        {
            return (RequestQueueState[])fZ.clone();
        }

        static 
        {
            fX = new RequestQueueState("STOPPED", 0);
            fY = new RequestQueueState("STARTED", 1);
            fZ = (new RequestQueueState[] {
                fX, fY
            });
        }

        private RequestQueueState(String s, int k)
        {
            super(s, k);
        }
    }

    public static final class RequestQueueType extends Enum
    {

        public static final RequestQueueType ga;
        public static final RequestQueueType gb;
        private static final RequestQueueType gc[];

        public static RequestQueueType valueOf(String s)
        {
            return (RequestQueueType)Enum.valueOf(com/sessionm/net/RequestQueue$RequestQueueType, s);
        }

        public static RequestQueueType[] values()
        {
            return (RequestQueueType[])gc.clone();
        }

        static 
        {
            ga = new RequestQueueType("FAST_FAIL", 0);
            gb = new RequestQueueType("BEST_EFFORT", 1);
            gc = (new RequestQueueType[] {
                ga, gb
            });
        }

        private RequestQueueType(String s, int k)
        {
            super(s, k);
        }
    }

    class a extends TimerTask
    {

        final RequestQueue fP;

        public void run()
        {
            if (Log.isLoggable("SessionM.RequestQueue", 3))
            {
                Log.d("SessionM.RequestQueue", "Executing scheduled send task.");
            }
            RequestQueue.d(fP).execute(new Runnable(this) {

                final a gd;

                public void run()
                {
                    synchronized (com.sessionm.core.f.E())
                    {
                        RequestQueue.a(gd.fP, null, null, true);
                    }
                    return;
                    exception;
                    f1;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

            
            {
                gd = a1;
                super();
            }
            });
        }

        a()
        {
            fP = RequestQueue.this;
            super();
        }
    }


    public static final String TAG = "SessionM.RequestQueue";
    private static final int fA = 1000;
    private static final int fz = 10;
    private ExecutorService bl;
    private Request eI;
    private com.sessionm.net.a et;
    private Request fB;
    private Request fC;
    private int fD;
    private int fE;
    private boolean fF;
    private RequestQueueState fG;
    private int fH;
    private int fI;
    private RequestQueueSendState fJ;
    private RequestQueueType fK;
    private Timer fL;
    private boolean fM;
    private RequestQueueNetworkState fN;
    private long fO;
    private List fw;
    private final Map fx = new ConcurrentHashMap();
    private final List fy = new CopyOnWriteArrayList();

    public RequestQueue(Context context, List list, RequestQueueType requestqueuetype, ExecutorService executorservice, com.sessionm.net.a a1)
    {
        fw = new ArrayList();
        fw.addAll(list);
        fJ = RequestQueueSendState.fU;
        fN = RequestQueueNetworkState.fR;
        q(10);
        p(1000);
        fF = false;
        fK = requestqueuetype;
        bl = executorservice;
        et = a1;
    }

    private void a(Request request, c c1, boolean flag)
    {
        if (request != null)
        {
            if (request.aX() != null && Log.isLoggable("SessionM.RequestQueue", 6))
            {
                Log.e("SessionM.RequestQueue", "Request is already enqueued.");
            }
            c1.k(request);
        }
        if (fG != RequestQueueState.fX) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (Log.isLoggable("SessionM.RequestQueue", 3))
        {
            Log.d("SessionM.RequestQueue", String.format(Locale.US, "Attempt to immediately dispatch request %s", new Object[] {
                request
            }));
        }
        if (fB != null)
        {
            break; /* Loop/switch isn't completed */
        }
        request = f(request);
        if (request != null)
        {
            h(request);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (fC != null)
        {
            if (Log.isLoggable("SessionM.RequestQueue", 6))
            {
                Log.e("SessionM.RequestQueue", String.format("There already is a next request: %s", new Object[] {
                    fC
                }));
                return;
            }
        } else
        {
            if (Log.isLoggable("SessionM.RequestQueue", 3))
            {
                Log.d("SessionM.RequestQueue", String.format(Locale.US, "Setting request(%s) to nextRequest.", new Object[] {
                    request
                }));
            }
            fC = request;
            fM = true;
            return;
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (fE != 0 || fB != null) goto _L1; else goto _L4
_L4:
        request = f(null);
        if (request != null)
        {
            h(request);
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    private void a(RequestQueueSendState requestqueuesendstate)
    {
        if (fJ != requestqueuesendstate)
        {
            if (Log.isLoggable("SessionM.RequestQueue", 3))
            {
                String.format(Locale.US, "Queue: %s transitioning to state: %s", new Object[] {
                    this, requestqueuesendstate
                });
            }
            fJ = requestqueuesendstate;
            for (requestqueuesendstate = fy.iterator(); requestqueuesendstate.hasNext(); ((d)requestqueuesendstate.next()).a(this, fJ)) { }
        }
    }

    static void a(RequestQueue requestqueue, Request request, c c1, boolean flag)
    {
        requestqueue.a(request, c1, flag);
    }

    private void ap()
    {
        String s;
        if (fK != RequestQueueType.ga)
        {
            if (!(s = Thread.currentThread().getName()).startsWith("SessionM Session Thread") && Log.isLoggable("SessionM.RequestQueue", 3))
            {
                Log.d("SessionM.RequestQueue", String.format("RequestQueue method called from wrong thread: %s", new Object[] {
                    s
                }), new Throwable());
                return;
            }
        }
    }

    private void br()
    {
        if (fJ != RequestQueueSendState.fV)
        {
            Request request = fC;
            fC = null;
            request = f(request);
            if (request != null)
            {
                h(request);
                return;
            }
        }
    }

    private void bs()
    {
        if (fL != null)
        {
            fL.cancel();
            fL = null;
        }
        if (fF && bt() > 0)
        {
            fL = new Timer();
            fL.schedule(new a(), bt());
        }
    }

    private int bt()
    {
        return fE;
    }

    private Request bu()
    {
        return eI;
    }

    private void c(Request request)
    {
        if (eI != null && !eI.equals(request))
        {
            eI.reset();
        }
        eI = request;
    }

    static ExecutorService d(RequestQueue requestqueue)
    {
        return requestqueue.bl;
    }

    static void d(RequestQueue requestqueue, Request request)
    {
        requestqueue.i(request);
    }

    static void e(RequestQueue requestqueue, Request request)
    {
        requestqueue.g(request);
    }

    private Request f(Request request)
    {
        int k;
        if (Log.isLoggable("SessionM.RequestQueue", 3))
        {
            Log.d("SessionM.RequestQueue", String.format(Locale.US, "linking requests on queue:%s to request: %s", new Object[] {
                this, request
            }));
        }
        if (request != null)
        {
            k = fD - 1;
        } else
        {
            k = fD;
        }
        if (k == 0)
        {
            k = 1;
        }
        if (request == null || k != 1) goto _L2; else goto _L1
_L1:
        return request;
_L2:
        Object obj;
        Object obj1;
        obj = null;
        Iterator iterator = fw.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            obj1 = ((c)iterator.next()).s(k);
            obj = obj1;
        } while (((List) (obj1)).size() <= 0);
_L4:
        obj = request;
        if (obj1 != null)
        {
            obj = request;
            if (((List) (obj1)).size() > 0)
            {
                if (request != null)
                {
                    request.b(((List) (obj1)));
                    obj = request;
                } else
                {
                    obj = (Request)((List) (obj1)).get(0);
                    if (((List) (obj1)).size() > 1)
                    {
                        ((Request) (obj)).b(((List) (obj1)).subList(1, ((List) (obj1)).size()));
                    }
                }
            }
        }
        request = ((Request) (obj));
        if (Log.isLoggable("SessionM.RequestQueue", 3))
        {
            Log.d("SessionM.RequestQueue", String.format(Locale.US, "Request(%s) linked on queue: %s", new Object[] {
                obj, this
            }));
            return ((Request) (obj));
        }
        if (true) goto _L1; else goto _L3
_L3:
        obj1 = obj;
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    private void g(Request request)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        ap();
        obj = (List)fx.get(request.getID());
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((com.sessionm.net.c)((Iterator) (obj)).next()).onReplyReceived(request)) { }
        break MISSING_BLOCK_LABEL_64;
        request;
        throw request;
        obj = fy.iterator();
_L1:
        d d1;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_153;
            }
            d1 = (d)((Iterator) (obj)).next();
            if (request.aZ() != 1)
            {
                break MISSING_BLOCK_LABEL_112;
            }
            d1.b(this, request);
        } while (true);
        Iterator iterator = request.aY().iterator();
        while (iterator.hasNext()) 
        {
            d1.b(this, (Request)iterator.next());
        }
          goto _L1
        if (request.ba() != Request.State.fh && !request.bb()) goto _L3; else goto _L2
_L2:
        a(RequestQueueNetworkState.fR);
_L6:
        c(request);
        if (request.ba().be())
        {
            j(request);
            fB = null;
        }
        a(RequestQueueSendState.fU);
        boolean flag;
        if (fM || fF && bt() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        fM = false;
        if (!flag) goto _L5; else goto _L4
_L4:
        br();
_L8:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        a(RequestQueueNetworkState.fQ);
          goto _L6
_L5:
        if (!fF || fL == null) goto _L8; else goto _L7
_L7:
        fL.schedule(new a(), bt());
          goto _L8
    }

    private void h(Request request)
    {
        if (Log.isLoggable("SessionM.RequestQueue", 3))
        {
            Log.d("SessionM.RequestQueue", (new StringBuilder()).append("Start request: ").append(request).toString());
        }
        long l = fO - System.currentTimeMillis();
        boolean flag;
        if (l <= 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            if (Log.isLoggable("SessionM.RequestQueue", 3))
            {
                Log.d("SessionM.RequestQueue", (new StringBuilder()).append("Abort request dispatch. Send threshold time not exceeded. Remaining delay: ").append(l).append("ms").toString());
            }
            return;
        }
        fO = -1L;
        if (fB != null && Log.isLoggable("SessionM.RequestQueue", 6))
        {
            Log.e("SessionM.RequestQueue", (new StringBuilder()).append("current request ").append(fB).append(" was not null").toString());
        }
        if (fN == RequestQueueNetworkState.fR)
        {
            a(RequestQueueNetworkState.fS);
        }
        request.o(fH);
        request.a(this);
        request.c(bu());
        request.a(et);
        fB = request;
        request.send();
        fH = fH + 1;
        fI = fI + request.aZ();
    }

    private void i(Request request)
    {
        ap();
        a(RequestQueueSendState.fV);
        Object obj = (List)fx.get(request.getID());
        if (obj != null)
        {
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((com.sessionm.net.c)((Iterator) (obj)).next()).onRequestSent(request)) { }
        }
        for (Iterator iterator = fy.iterator(); iterator.hasNext();)
        {
            d d1 = (d)iterator.next();
            if (request.aZ() == 1)
            {
                d1.a(this, request);
            } else
            {
                Iterator iterator1 = request.aY().iterator();
                while (iterator1.hasNext()) 
                {
                    d1.a(this, (Request)iterator1.next());
                }
            }
        }

    }

    private void j(Request request)
    {
        if (Log.isLoggable("SessionM.RequestQueue", 3))
        {
            Log.d("SessionM.RequestQueue", (new StringBuilder()).append("Finish request: ").append(request).toString());
        }
        if (fG != RequestQueueState.fX && fB != request && Log.isLoggable("SessionM.RequestQueue", 6))
        {
            Log.e("SessionM.RequestQueue", (new StringBuilder()).append("Request finished ").append(request).append(" but it was not the current request ").append(fB).toString());
        }
        if (fK != RequestQueueType.ga && (fK != RequestQueueType.gb || request.ba() != Request.State.fg && !request.bb())) goto _L2; else goto _L1
_L1:
        c c1 = request.aX();
        if (c1 != null) goto _L4; else goto _L3
_L3:
        if (Log.isLoggable("SessionM.RequestQueue", 3))
        {
            Log.e("SessionM.RequestQueue", "Store is null for request. This should not happen.");
        }
_L6:
        fx.remove(request.getID());
_L2:
        return;
_L4:
        boolean flag;
        if (request.bd())
        {
            break; /* Loop/switch isn't completed */
        }
        Iterator iterator = fy.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
        } while (!((d)iterator.next()).c(this, request));
        flag = true;
_L7:
        if (!flag)
        {
            c1.l(request);
        }
        if (true) goto _L6; else goto _L5
_L5:
        flag = false;
          goto _L7
        if (true) goto _L6; else goto _L8
_L8:
    }

    public void a(Request request, c c1)
    {
        this;
        JVM INSTR monitorenter ;
        if (Log.isLoggable("SessionM.RequestQueue", 3))
        {
            Log.d("SessionM.RequestQueue", String.format(Locale.US, "Enqueueing request: %s on queue: %s", new Object[] {
                request, this
            }));
        }
        a(request, c1, false);
        this;
        JVM INSTR monitorexit ;
        return;
        request;
        throw request;
    }

    public void a(Request request, com.sessionm.net.c c1)
    {
        this;
        JVM INSTR monitorenter ;
        List list;
        ap();
        list = (List)fx.get(request.getID());
        Object obj;
        obj = list;
        if (list != null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        obj = new ArrayList();
        ((List) (obj)).add(c1);
        fx.put(request.getID(), obj);
        this;
        JVM INSTR monitorexit ;
        return;
        request;
        throw request;
    }

    public void a(RequestQueueNetworkState requestqueuenetworkstate)
    {
        this;
        JVM INSTR monitorenter ;
        ap();
        if (fN != requestqueuenetworkstate)
        {
            if (Log.isLoggable("SessionM.RequestQueue", 3))
            {
                String.format(Locale.US, "Queue: %s transitioning to network state: %s", new Object[] {
                    this, requestqueuenetworkstate
                });
            }
            fN = requestqueuenetworkstate;
            for (requestqueuenetworkstate = fy.iterator(); requestqueuenetworkstate.hasNext(); ((d)requestqueuenetworkstate.next()).a(this, fN)) { }
        }
        break MISSING_BLOCK_LABEL_96;
        requestqueuenetworkstate;
        throw requestqueuenetworkstate;
        this;
        JVM INSTR monitorexit ;
    }

    public void a(d d1)
    {
        this;
        JVM INSTR monitorenter ;
        ap();
        if (!fy.contains(d1))
        {
            fy.add(d1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        d1;
        throw d1;
    }

    public void b(d d1)
    {
        this;
        JVM INSTR monitorenter ;
        ap();
        fy.remove(d1);
        this;
        JVM INSTR monitorexit ;
        return;
        d1;
        throw d1;
    }

    public void bf()
    {
        this;
        JVM INSTR monitorenter ;
        ap();
        if (Log.isLoggable("SessionM.RequestQueue", 3))
        {
            Log.d("SessionM.RequestQueue", String.format(Locale.US, "Send next enqueued request on queue: %s", new Object[] {
                this
            }));
        }
        a(null, null, true);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void bg()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        ap();
        flag = fF;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        fF = true;
        if (bt() != 0)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        br();
          goto _L1
        Exception exception;
        exception;
        throw exception;
        bs();
          goto _L1
    }

    public void bh()
    {
        this;
        JVM INSTR monitorenter ;
        ap();
        if (Log.isLoggable("SessionM.RequestQueue", 3))
        {
            Log.d("SessionM.RequestQueue", String.format(Locale.US, "Stop autosend mode on queue: %s", new Object[] {
                this
            }));
        }
        fF = false;
        bs();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public long bi()
    {
        this;
        JVM INSTR monitorenter ;
        long l;
        ap();
        l = fO;
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public void bj()
    {
        this;
        JVM INSTR monitorenter ;
        fy.clear();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public List bk()
    {
        return fw;
    }

    public int bl()
    {
        return fD;
    }

    public int bm()
    {
        this;
        JVM INSTR monitorenter ;
        int k = fH;
        this;
        JVM INSTR monitorexit ;
        return k;
        Exception exception;
        exception;
        throw exception;
    }

    public int bn()
    {
        this;
        JVM INSTR monitorenter ;
        int k = fI;
        this;
        JVM INSTR monitorexit ;
        return k;
        Exception exception;
        exception;
        throw exception;
    }

    public RequestQueueSendState bo()
    {
        this;
        JVM INSTR monitorenter ;
        RequestQueueSendState requestqueuesendstate;
        ap();
        requestqueuesendstate = fJ;
        this;
        JVM INSTR monitorexit ;
        return requestqueuesendstate;
        Exception exception;
        exception;
        throw exception;
    }

    public RequestQueueNetworkState bp()
    {
        this;
        JVM INSTR monitorenter ;
        RequestQueueNetworkState requestqueuenetworkstate = fN;
        this;
        JVM INSTR monitorexit ;
        return requestqueuenetworkstate;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean bq()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = fF;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public void d(long l)
    {
        this;
        JVM INSTR monitorenter ;
        ap();
        fO = l;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void d(Request request)
    {
        this;
        JVM INSTR monitorenter ;
        ap();
        if (Log.isLoggable("SessionM.RequestQueue", 3))
        {
            Log.d("SessionM.RequestQueue", String.format(Locale.US, "Enqueueing (with immediate dispatch) request : %s on queue: %s", new Object[] {
                request, this
            }));
        }
        a(request, (c)fw.get(0), true);
        this;
        JVM INSTR monitorexit ;
        return;
        request;
        throw request;
    }

    public void e(Request request)
    {
        this;
        JVM INSTR monitorenter ;
        ap();
        a(request, (c)fw.get(0), false);
        this;
        JVM INSTR monitorexit ;
        return;
        request;
        throw request;
    }

    public int getSize()
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = fw.iterator();
        int k = 0;
_L2:
        c c1;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        c1 = (c)iterator.next();
        long l = k;
        long l1 = c1.getSize();
        k = (int)(l1 + l);
        if (true) goto _L2; else goto _L1
_L1:
        return k;
        Exception exception;
        exception;
        throw exception;
    }

    public void onReplyReceived(final Request request)
    {
        bl.execute(new Runnable() {

            final RequestQueue fP;
            final Request val$request;

            public void run()
            {
                synchronized (com.sessionm.core.f.E())
                {
                    RequestQueue.e(fP, request);
                }
                return;
                exception;
                f1;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                fP = RequestQueue.this;
                request = request1;
                super();
            }
        });
    }

    public void onRequestSent(final Request request)
    {
        bl.execute(new Runnable() {

            final RequestQueue fP;
            final Request val$request;

            public void run()
            {
                synchronized (com.sessionm.core.f.E())
                {
                    RequestQueue.d(fP, request);
                }
                return;
                exception;
                f1;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                fP = RequestQueue.this;
                request = request1;
                super();
            }
        });
    }

    public void p(int k)
    {
        this;
        JVM INSTR monitorenter ;
        int l;
        l = k;
        if (k == 0)
        {
            l = 1;
        }
        fD = l;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void q(int k)
    {
        this;
        JVM INSTR monitorenter ;
        fE = k;
        bs();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void reconnect()
    {
        this;
        JVM INSTR monitorenter ;
        ap();
        if (fN != RequestQueueNetworkState.fQ) goto _L2; else goto _L1
_L1:
        if (Log.isLoggable("SessionM.RequestQueue", 6))
        {
            Log.e("SessionM.RequestQueue", "Unexpected reconnect call in already connected state");
        }
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Iterator iterator = fy.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_145;
            }
        } while (((d)iterator.next()).a(this));
        boolean flag = false;
_L5:
        if (!flag) goto _L4; else goto _L3
_L3:
        d(0L);
        if (getSize() <= 0)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        br();
          goto _L4
        Exception exception;
        exception;
        throw exception;
        Iterator iterator1 = fy.iterator();
        while (iterator1.hasNext()) 
        {
            ((d)iterator1.next()).a(this, RequestQueueNetworkState.fQ);
        }
          goto _L4
        flag = true;
          goto _L5
    }

    public void reset()
    {
        this;
        JVM INSTR monitorenter ;
        for (Iterator iterator = fw.iterator(); iterator.hasNext(); ((c)iterator.next()).removeAll()) { }
        break MISSING_BLOCK_LABEL_44;
        Exception exception;
        exception;
        throw exception;
        if (fB != null)
        {
            fB.a(null);
            fB = null;
        }
        fJ = RequestQueueSendState.fU;
        fN = RequestQueueNetworkState.fQ;
        fO = 0L;
        fI = 0;
        this;
        JVM INSTR monitorexit ;
    }

    public void shutdown()
    {
        for (Iterator iterator = fw.iterator(); iterator.hasNext(); ((c)iterator.next()).close()) { }
    }

    public void start()
    {
        this;
        JVM INSTR monitorenter ;
        ap();
        fG = RequestQueueState.fY;
        if (Log.isLoggable("SessionM.RequestQueue", 3))
        {
            Log.d("SessionM.RequestQueue", String.format(Locale.US, "Request queue started. %s", new Object[] {
                this
            }));
        }
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
        ap();
        if (Log.isLoggable("SessionM.RequestQueue", 3))
        {
            Log.d("SessionM.RequestQueue", String.format(Locale.US, "Stopping request queue: %s", new Object[] {
                this
            }));
        }
        bh();
        if (fB != null)
        {
            if (bo() != RequestQueueSendState.fU && Log.isLoggable("SessionM.RequestQueue", 3))
            {
                Log.d("SessionM.RequestQueue", String.format(Locale.US, "Stopping non-idle request queue: %s", new Object[] {
                    this
                }));
            }
            fx.remove(fB.getID());
            a(RequestQueueSendState.fU);
            fB.a(null);
            fB = null;
        }
        fG = RequestQueueState.fX;
        if (Log.isLoggable("SessionM.RequestQueue", 3))
        {
            Log.d("SessionM.RequestQueue", String.format(Locale.US, "Request queue: %s stopped.", new Object[] {
                this
            }));
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public String toString()
    {
        return String.format(Locale.US, "<RequestQueue type: %s autoSendMode: %b batchSize: %d state: %s networkState: %s>", new Object[] {
            fK, Boolean.valueOf(fF), Integer.valueOf(fD), fJ, fN
        });
    }
}
