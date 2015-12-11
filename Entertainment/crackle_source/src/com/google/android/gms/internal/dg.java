// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.common.api.Status;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.google.android.gms.internal:
//            dw, dk, dh, di, 
//            dj, ec

public final class dg extends dw
{
    private static final class a
        implements com.google.android.gms.cast.Cast.ApplicationConnectionResult
    {

        private final Status jY;
        private final ApplicationMetadata lX;
        private final String lY;
        private final String lZ;
        private final boolean ma;

        public ApplicationMetadata getApplicationMetadata()
        {
            return lX;
        }

        public String getApplicationStatus()
        {
            return lY;
        }

        public String getSessionId()
        {
            return lZ;
        }

        public Status getStatus()
        {
            return jY;
        }

        public boolean getWasLaunched()
        {
            return ma;
        }

        public a(Status status)
        {
            this(status, null, null, null, false);
        }

        public a(Status status, ApplicationMetadata applicationmetadata, String s, String s1, boolean flag)
        {
            jY = status;
            lX = applicationmetadata;
            lY = s;
            lZ = s1;
            ma = flag;
        }
    }


    private static final dk lA = new dk("CastClientImpl");
    private static final Object lQ = new Object();
    private static final Object lR = new Object();
    private final com.google.android.gms.cast.Cast.Listener kw;
    private ApplicationMetadata lB;
    private final CastDevice lC;
    private final dj lD = new dj.a() {

        final dg lS;

        private void b(long l1, int i)
        {
            com.google.android.gms.common.api.a.c c1;
            synchronized (dg.g(lS))
            {
                c1 = (com.google.android.gms.common.api.a.c)dg.g(lS).remove(Long.valueOf(l1));
            }
            if (c1 != null)
            {
                c1.a(new Status(i));
            }
            return;
            exception;
            map;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private boolean x(int i)
        {
            Object obj = dg.ba();
            obj;
            JVM INSTR monitorenter ;
            if (dg.h(lS) == null)
            {
                break MISSING_BLOCK_LABEL_49;
            }
            dg.h(lS).a(new Status(i));
            dg.b(lS, null);
            return true;
            obj;
            JVM INSTR monitorexit ;
            return false;
            Exception exception;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void a(ApplicationMetadata applicationmetadata, String s, String s1, boolean flag)
        {
            dg.a(lS, applicationmetadata.getApplicationId());
            dg.b(lS, s1);
            synchronized (dg.aZ())
            {
                if (dg.b(lS) != null)
                {
                    dg.b(lS).a(new a(new Status(0), applicationmetadata, s, s1, flag));
                    dg.a(lS, null);
                }
            }
            return;
            applicationmetadata;
            obj;
            JVM INSTR monitorexit ;
            throw applicationmetadata;
        }

        public void a(String s, long l1)
        {
            b(l1, 0);
        }

        public void a(String s, long l1, int i)
        {
            b(l1, i);
        }

        public void a(String s, String s1)
        {
            dg.aY().b("Receive (type=text, ns=%s) %s", new Object[] {
                s, s1
            });
            dg.d(lS).post(new Runnable(this, s, s1) {

                final String km;
                final _cls1 lU;
                final String lW;

                public void run()
                {
                    com.google.android.gms.cast.Cast.MessageReceivedCallback messagereceivedcallback;
                    synchronized (dg.e(lU.lS))
                    {
                        messagereceivedcallback = (com.google.android.gms.cast.Cast.MessageReceivedCallback)dg.e(lU.lS).get(km);
                    }
                    if (messagereceivedcallback != null)
                    {
                        messagereceivedcallback.onMessageReceived(dg.f(lU.lS), km, lW);
                        return;
                    } else
                    {
                        dg.aY().b("Discarded message for unknown namespace '%s'", new Object[] {
                            km
                        });
                        return;
                    }
                    exception;
                    map;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

            
            {
                lU = _pcls1;
                km = s;
                lW = s1;
                super();
            }
            });
        }

        public void b(String s, double d1, boolean flag)
        {
            dg.d(lS).post(new Runnable(this, s, d1, flag) {

                final _cls1 lU;
                final String lV;
                final double lp;
                final boolean lq;

                public void run()
                {
                    dg.a(lU.lS, lV, lp, lq);
                }

            
            {
                lU = _pcls1;
                lV = s;
                lp = d1;
                lq = flag;
                super();
            }
            });
        }

        public void b(String s, byte abyte0[])
        {
            dg.aY().b("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", new Object[] {
                s, Integer.valueOf(abyte0.length)
            });
        }

        public void onApplicationDisconnected(int i)
        {
            dg.a(lS, null);
            dg.b(lS, null);
            while (x(i) || dg.c(lS) == null) 
            {
                return;
            }
            dg.d(lS).post(new Runnable(this, i) {

                final int lT;
                final _cls1 lU;

                public void run()
                {
                    if (dg.c(lU.lS) != null)
                    {
                        dg.c(lU.lS).onApplicationDisconnected(lT);
                    }
                }

            
            {
                lU = _pcls1;
                lT = i;
                super();
            }
            });
        }

        public void t(int i)
        {
            dg.aY().b("ICastDeviceControllerListener.onDisconnected", new Object[0]);
            dg.a(lS, false);
            dg.a(lS, null);
            if (i != 0)
            {
                lS.I(2);
            }
        }

        public void u(int i)
        {
            synchronized (dg.aZ())
            {
                if (dg.b(lS) != null)
                {
                    dg.b(lS).a(new a(new Status(i)));
                    dg.a(lS, null);
                }
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void v(int i)
        {
            x(i);
        }

        public void w(int i)
        {
            x(i);
        }

            
            {
                lS = dg.this;
                super();
            }
    };
    private final Map lE = new HashMap();
    private final long lF;
    private String lG;
    private boolean lH;
    private boolean lI;
    private final AtomicLong lJ = new AtomicLong(0L);
    private String lK;
    private String lL;
    private Bundle lM;
    private Map lN;
    private com.google.android.gms.common.api.a.c lO;
    private com.google.android.gms.common.api.a.c lP;
    private double lb;
    private boolean lc;
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    public dg(Context context, CastDevice castdevice, long l, com.google.android.gms.cast.Cast.Listener listener, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        super(context, connectioncallbacks, onconnectionfailedlistener, (String[])null);
        lC = castdevice;
        kw = listener;
        lF = l;
        lI = false;
        lB = null;
        lG = null;
        lb = 0.0D;
        lc = false;
        lN = new HashMap();
    }

    static ApplicationMetadata a(dg dg1, ApplicationMetadata applicationmetadata)
    {
        dg1.lB = applicationmetadata;
        return applicationmetadata;
    }

    static com.google.android.gms.common.api.a.c a(dg dg1, com.google.android.gms.common.api.a.c c1)
    {
        dg1.lO = c1;
        return c1;
    }

    static String a(dg dg1, String s)
    {
        dg1.lK = s;
        return s;
    }

    static void a(dg dg1, String s, double d1, boolean flag)
    {
        dg1.a(s, d1, flag);
    }

    private void a(String s, double d1, boolean flag)
    {
        boolean flag1;
        boolean flag2;
        if (!dh.a(s, lG))
        {
            lG = s;
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (kw != null && (flag1 || lH))
        {
            kw.onApplicationStatusChanged();
        }
        if (d1 != lb)
        {
            lb = d1;
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag != lc)
        {
            lc = flag;
            flag2 = true;
        }
        lA.b("hasChange=%b, mFirstStatusUpdate=%b", new Object[] {
            Boolean.valueOf(flag2), Boolean.valueOf(lH)
        });
        if (kw != null && (flag2 || lH))
        {
            kw.onVolumeChanged();
        }
        lH = false;
    }

    static boolean a(dg dg1, boolean flag)
    {
        dg1.lI = flag;
        return flag;
    }

    private void aX()
        throws IllegalStateException
    {
        if (!lI)
        {
            throw new IllegalStateException("not connected to a device");
        } else
        {
            return;
        }
    }

    static dk aY()
    {
        return lA;
    }

    static Object aZ()
    {
        return lQ;
    }

    static com.google.android.gms.common.api.a.c b(dg dg1)
    {
        return dg1.lO;
    }

    static com.google.android.gms.common.api.a.c b(dg dg1, com.google.android.gms.common.api.a.c c1)
    {
        dg1.lP = c1;
        return c1;
    }

    static String b(dg dg1, String s)
    {
        dg1.lL = s;
        return s;
    }

    static Object ba()
    {
        return lR;
    }

    static com.google.android.gms.cast.Cast.Listener c(dg dg1)
    {
        return dg1.kw;
    }

    static Handler d(dg dg1)
    {
        return dg1.mHandler;
    }

    private void d(com.google.android.gms.common.api.a.c c1)
    {
        synchronized (lQ)
        {
            if (lO != null)
            {
                lO.a(new a(new Status(2002)));
            }
            lO = c1;
        }
        return;
        c1;
        obj;
        JVM INSTR monitorexit ;
        throw c1;
    }

    static Map e(dg dg1)
    {
        return dg1.lE;
    }

    static CastDevice f(dg dg1)
    {
        return dg1.lC;
    }

    private void f(com.google.android.gms.common.api.a.c c1)
    {
label0:
        {
            synchronized (lR)
            {
                if (lP == null)
                {
                    break label0;
                }
                c1.a(new Status(2001));
            }
            return;
        }
        lP = c1;
        obj;
        JVM INSTR monitorexit ;
        return;
        c1;
        obj;
        JVM INSTR monitorexit ;
        throw c1;
    }

    static Map g(dg dg1)
    {
        return dg1.lN;
    }

    static com.google.android.gms.common.api.a.c h(dg dg1)
    {
        return dg1.lP;
    }

    public void C(String s)
        throws IllegalArgumentException, IllegalStateException, RemoteException
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        com.google.android.gms.cast.Cast.MessageReceivedCallback messagereceivedcallback;
        synchronized (lE)
        {
            messagereceivedcallback = (com.google.android.gms.cast.Cast.MessageReceivedCallback)lE.remove(s);
        }
        if (messagereceivedcallback != null)
        {
            ((di)bQ()).F(s);
        }
        return;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void a(double d1)
        throws IllegalArgumentException, IllegalStateException, RemoteException
    {
        if (Double.isInfinite(d1) || Double.isNaN(d1))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Volume cannot be ").append(d1).toString());
        } else
        {
            ((di)bQ()).a(d1, lb, lc);
            return;
        }
    }

    protected void a(int i, IBinder ibinder, Bundle bundle)
    {
        int j;
        if (i == 0 || i == 1001)
        {
            lI = true;
            lH = true;
        } else
        {
            lI = false;
        }
        j = i;
        if (i == 1001)
        {
            lM = new Bundle();
            lM.putBoolean("com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING", true);
            j = 0;
        }
        super.a(j, ibinder, bundle);
    }

    protected void a(ec ec1, dw.e e1)
        throws RemoteException
    {
        Bundle bundle = new Bundle();
        lA.b("getServiceFromBroker(): mLastApplicationId=%s, mLastSessionId=%s", new Object[] {
            lK, lL
        });
        lC.putInBundle(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", lF);
        if (lK != null)
        {
            bundle.putString("last_application_id", lK);
            if (lL != null)
            {
                bundle.putString("last_session_id", lL);
            }
        }
        ec1.a(e1, 0x40ba50, getContext().getPackageName(), lD.asBinder(), bundle);
    }

    public void a(String s, com.google.android.gms.cast.Cast.MessageReceivedCallback messagereceivedcallback)
        throws IllegalArgumentException, IllegalStateException, RemoteException
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        C(s);
        if (messagereceivedcallback != null)
        {
            synchronized (lE)
            {
                lE.put(s, messagereceivedcallback);
            }
            ((di)bQ()).E(s);
        }
        return;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void a(String s, com.google.android.gms.common.api.a.c c1)
        throws IllegalStateException, RemoteException
    {
        f(c1);
        ((di)bQ()).D(s);
    }

    public void a(String s, String s1, com.google.android.gms.common.api.a.c c1)
        throws IllegalArgumentException, IllegalStateException, RemoteException
    {
        if (TextUtils.isEmpty(s1))
        {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        }
        if (s == null || s.length() > 128)
        {
            throw new IllegalArgumentException("Invalid namespace length");
        }
        if (s1.length() > 0x10000)
        {
            throw new IllegalArgumentException("Message exceeds maximum size");
        } else
        {
            aX();
            long l = lJ.incrementAndGet();
            ((di)bQ()).a(s, s1, l);
            lN.put(Long.valueOf(l), c1);
            return;
        }
    }

    public void a(String s, boolean flag, com.google.android.gms.common.api.a.c c1)
        throws IllegalStateException, RemoteException
    {
        d(c1);
        ((di)bQ()).c(s, flag);
    }

    public Bundle aU()
    {
        if (lM != null)
        {
            Bundle bundle = lM;
            lM = null;
            return bundle;
        } else
        {
            return super.aU();
        }
    }

    public void aV()
        throws IllegalStateException, RemoteException
    {
        ((di)bQ()).aV();
    }

    public double aW()
        throws IllegalStateException
    {
        aX();
        return lb;
    }

    protected String am()
    {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    protected String an()
    {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    public void b(String s, String s1, com.google.android.gms.common.api.a.c c1)
        throws IllegalStateException, RemoteException
    {
        d(c1);
        ((di)bQ()).b(s, s1);
    }

    public void disconnect()
    {
        if (!isConnected())
        {
            break MISSING_BLOCK_LABEL_37;
        }
        synchronized (lE)
        {
            lE.clear();
        }
        ((di)bQ()).disconnect();
_L2:
        super.disconnect();
        return;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
        Object obj;
        obj;
        lA.b("Error while disconnecting the controller interface: %s", new Object[] {
            ((RemoteException) (obj)).getMessage()
        });
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        super.disconnect();
        throw obj;
    }

    public void e(com.google.android.gms.common.api.a.c c1)
        throws IllegalStateException, RemoteException
    {
        f(c1);
        ((di)bQ()).bb();
    }

    public ApplicationMetadata getApplicationMetadata()
        throws IllegalStateException
    {
        aX();
        return lB;
    }

    public String getApplicationStatus()
        throws IllegalStateException
    {
        aX();
        return lG;
    }

    public boolean isMute()
        throws IllegalStateException
    {
        aX();
        return lc;
    }

    public void n(boolean flag)
        throws IllegalStateException, RemoteException
    {
        ((di)bQ()).a(flag, lb, lc);
    }

    protected IInterface p(IBinder ibinder)
    {
        return u(ibinder);
    }

    protected di u(IBinder ibinder)
    {
        return di.a.v(ibinder);
    }

}
