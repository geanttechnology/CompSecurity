// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comscore.analytics;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.comscore.applications.ApplicationMeasurement;
import com.comscore.applications.EventType;
import com.comscore.applications.KeepAliveAlarmReceiver;
import com.comscore.measurement.Measurement;
import com.comscore.measurement.MeasurementDispatcher;
import com.comscore.utils.CSLog;
import com.comscore.utils.CacheFlusher;
import com.comscore.utils.ConnectivityChangeReceiver;
import com.comscore.utils.Constants;
import com.comscore.utils.CustomExceptionHandler;
import com.comscore.utils.Date;
import com.comscore.utils.DispatchQueue;
import com.comscore.utils.OfflineMeasurementsCache;
import com.comscore.utils.Storage;
import com.comscore.utils.TransmissionMode;
import com.comscore.utils.Utils;
import com.comscore.utils.id.IdHelper;
import com.comscore.utils.task.TaskExecutor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.comscore.analytics:
//            ApplicationState, SessionState, z, u, 
//            ac, y, w, aa, 
//            ad, d, f, x

public class Core
{

    protected AtomicInteger A;
    protected AtomicInteger B;
    protected AtomicInteger C;
    protected long D;
    protected long E;
    protected long F;
    protected long G;
    protected long H;
    protected long I;
    protected long J;
    protected long K;
    protected long L;
    protected SessionState M;
    protected long N;
    protected long O;
    protected long P;
    protected int Q;
    protected int R;
    protected int S;
    protected long T;
    protected long U;
    protected long V;
    protected int W;
    protected long X;
    protected long Y;
    protected Timer Z;
    OfflineMeasurementsCache a;
    protected String aa;
    String ab;
    Context ac;
    protected final HashMap ad = new HashMap();
    protected final HashMap ae = new HashMap();
    boolean af;
    protected long ag;
    protected boolean ah;
    protected Thread.UncaughtExceptionHandler ai;
    boolean aj;
    TransmissionMode ak;
    TransmissionMode al;
    String am[];
    IdHelper an;
    Storage b;
    KeepAliveAlarmReceiver c;
    CacheFlusher d;
    DispatchQueue e;
    TaskExecutor f;
    MeasurementDispatcher g;
    ConnectivityChangeReceiver h;
    protected Timer i;
    protected Timer j;
    protected TimerTask k;
    protected long l;
    protected boolean m;
    protected boolean n;
    boolean o;
    AtomicInteger p;
    long q;
    AtomicInteger r;
    long s;
    long t;
    String u;
    String v;
    boolean w;
    String x;
    protected ApplicationState z;

    public Core()
    {
        m = true;
        n = true;
        o = false;
        w = true;
        z = ApplicationState.INACTIVE;
        M = SessionState.INACTIVE;
        ag = 0L;
        ah = false;
        r = new AtomicInteger(0);
        p = new AtomicInteger();
        C = new AtomicInteger(0);
        A = new AtomicInteger(0);
        B = new AtomicInteger(0);
        ai = Thread.getDefaultUncaughtExceptionHandler();
        af = true;
        reset();
    }

    private void A()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add("lastApplicationAccumulationTimestamp");
        arraylist.add("lastSessionAccumulationTimestamp");
        a("lastActivityTime", arraylist);
        a("ns_ap_fg", "foregroundTransitionsCount");
        a("installTime", "installId");
        a("ns_ap_ver", "previousVersion");
    }

    private String a(String s1, Properties properties, boolean flag)
    {
        if (properties != null)
        {
            properties = properties.getProperty(s1);
            if (properties != null)
            {
                b.set(s1, properties);
                return properties;
            }
        }
        if (flag && b.has(s1).booleanValue())
        {
            return b.get(s1);
        } else
        {
            return null;
        }
    }

    static void a(Core core, String s1, String s2)
    {
        core.b(s1, s2);
    }

    static void b(Core core, String s1)
    {
        core.c(s1);
    }

    private void b(String s1)
    {
        if (an == null)
        {
            return;
        } else
        {
            an.setPublisherSecret(s1);
            an.generateIds();
            return;
        }
    }

    private void b(String s1, String s2)
    {
        this;
        JVM INSTR monitorenter ;
        ad.put(s1, s2);
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    private void c(String s1)
    {
        ab = s1;
        if (b != null)
        {
            b.set("appName", ab);
        }
    }

    private void d(String s1)
    {
        String s2;
        if (isSecure())
        {
            s2 = "https://sb.scorecardresearch.com/p2?";
        } else
        {
            s2 = "http://b.scorecardresearch.com/p2?";
        }
        a(s2);
        b("c2", s1);
    }

    protected Measurement a(EventType eventtype, HashMap hashmap, String s1)
    {
        return ApplicationMeasurement.newApplicationMeasurement(this, eventtype, hashmap, s1);
    }

    protected IdHelper a(Context context, Storage storage)
    {
        return new IdHelper(context, storage);
    }

    protected void a()
    {
        b = b();
        g = e();
        a(b);
        e = c();
        c = f();
        a = g();
        d = h();
        h = i();
        j();
        an = a(ac, b);
    }

    void a(int i1, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        w();
        int j1;
        j1 = i1;
        if (i1 < 60)
        {
            j1 = 60;
        }
        m = flag;
        l = j1 * 1000;
        if (z != ApplicationState.FOREGROUND) goto _L2; else goto _L1
_L1:
        v();
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (z == ApplicationState.BACKGROUND_UX_ACTIVE && !m)
        {
            v();
        }
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    protected void a(ApplicationState applicationstate)
    {
        CSLog.d(this, (new StringBuilder()).append("Leaving application state: ").append(applicationstate).toString());
        switch (z.a[applicationstate.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            h.start();
            c.start(3000);
            ac.registerReceiver(h, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            d.start();
            return;

        case 2: // '\002'
            w();
            return;

        case 3: // '\003'
            setCurrentActivityName(null);
            break;
        }
        w();
    }

    protected void a(ApplicationState applicationstate, ApplicationState applicationstate1)
    {
        if (applicationstate1 != ApplicationState.INACTIVE && isAutoStartEnabled() && !o)
        {
            notify(EventType.START, ae, false);
        }
    }

    protected void a(SessionState sessionstate)
    {
        long l1;
        CSLog.d(this, (new StringBuilder()).append("Leaving session state: ").append(sessionstate).toString());
        l1 = Date.unixTime();
        z.b[sessionstate.ordinal()];
        JVM INSTR tableswitch 1 4: default 68
    //                   1 69
    //                   2 93
    //                   3 98
    //                   4 104;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        if (Z != null)
        {
            Z.cancel();
            Z = null;
        }
        V = l1;
_L3:
        U = l1;
_L4:
        T = l1;
        return;
_L5:
        if (!p())
        {
            long l2 = N;
            N = (l1 - Y) + l2;
            return;
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    protected void a(SessionState sessionstate, SessionState sessionstate1)
    {
    }

    void a(EventType eventtype, HashMap hashmap)
    {
        this;
        JVM INSTR monitorenter ;
        if (!z()) goto _L2; else goto _L1
_L1:
        x();
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        y();
        if (!o && eventtype != EventType.START)
        {
            g.sendMeasurmement(a(EventType.START, new HashMap(), aa), false);
        }
        if (eventtype != EventType.CLOSE)
        {
            g.sendMeasurmement(a(eventtype, hashmap, aa), false);
        }
        if (true) goto _L4; else goto _L3
_L3:
        eventtype;
        throw eventtype;
    }

    protected void a(Storage storage)
    {
        A();
        g.loadEventData();
    }

    void a(String s1)
    {
        int j1 = s1.indexOf('?');
        if (j1 < 0) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = s1;
        if (j1 < s1.length() - 1)
        {
            obj = s1.substring(j1 + 1).split("&");
            int k1 = obj.length;
            int i1 = 0;
            while (i1 < k1) 
            {
                String as[] = obj[i1].split("=");
                if (as.length == 2)
                {
                    setLabel(as[0], as[1], false);
                } else
                if (as.length == 1)
                {
                    setLabel("name", as[0], false);
                }
                i1++;
            }
            obj = s1.substring(0, j1 + 1);
        }
_L4:
        aa = ((String) (obj));
        return;
_L2:
        obj = (new StringBuilder()).append(s1).append('?').toString();
        if (true) goto _L4; else goto _L3
_L3:
    }

    void a(String s1, String s2)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(s2);
        a(s1, arraylist);
    }

    void a(String s1, ArrayList arraylist)
    {
        arraylist = arraylist.iterator();
        do
        {
            if (!arraylist.hasNext())
            {
                break;
            }
            String s2 = (String)arraylist.next();
            String s3 = b.get(s1);
            String s4 = b.get(s2);
            if (Utils.isNotEmpty(s3) && Utils.isEmpty(s4))
            {
                b.set(s2, s3);
            }
        } while (true);
        b.remove(s1);
    }

    protected void a(boolean flag)
    {
        long l1;
        long l2;
        l1 = Date.unixTime();
        l2 = l1 - L;
        z.a[z.ordinal()];
        JVM INSTR tableswitch 1 3: default 48
    //                   1 246
    //                   2 221
    //                   3 196;
           goto _L1 _L2 _L3 _L4
_L1:
        L = l1;
        if (flag)
        {
            b.set("lastApplicationAccumulationTimestamp", Long.toString(L));
            b.set("foregroundTransitionsCount", Long.toString(C.get()));
            b.set("accumulatedForegroundTime", Long.toString(H));
            b.set("accumulatedBackgroundTime", Long.toString(G));
            b.set("accumulatedInactiveTime", Long.toString(I));
            b.set("totalForegroundTime", Long.toString(D));
            b.set("totalBackgroundTime", Long.toString(E));
            b.set("totalInactiveTime", Long.toString(F));
        }
        return;
_L4:
        H = H + l2;
        D = l2 + D;
        continue; /* Loop/switch isn't completed */
_L3:
        G = G + l2;
        E = l2 + E;
        continue; /* Loop/switch isn't completed */
_L2:
        I = I + l2;
        F = l2 + F;
        if (true) goto _L1; else goto _L5
_L5:
    }

    protected Storage b()
    {
        return new Storage(ac);
    }

    protected void b(ApplicationState applicationstate)
    {
        CSLog.d(this, (new StringBuilder()).append("Entering application state: ").append(applicationstate).toString());
        z.a[applicationstate.ordinal()];
        JVM INSTR tableswitch 1 3: default 60
    //                   1 61
    //                   2 98
    //                   3 110;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        h.stop();
        c.stop();
        d.stop();
        ac.unregisterReceiver(h);
        w();
        return;
_L3:
        if (!m)
        {
            v();
            return;
        }
          goto _L1
_L4:
        v();
        C.getAndIncrement();
        return;
    }

    protected void b(SessionState sessionstate)
    {
        CSLog.d(this, (new StringBuilder()).append("Entering session state: ").append(sessionstate).toString());
        switch (z.b[sessionstate.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            q();
            o();
            // fall through

        case 2: // '\002'
            r();
            // fall through

        case 3: // '\003'
            p();
            break;
        }
    }

    protected void b(boolean flag)
    {
        long l1;
        long l2;
        l1 = Date.unixTime();
        l2 = l1 - Y;
        z.b[M.ordinal()];
        JVM INSTR tableswitch 1 3: default 48
    //                   1 297
    //                   2 313
    //                   3 329;
           goto _L1 _L2 _L3 _L4
_L1:
        Y = l1;
        if (flag)
        {
            b.set("lastSessionAccumulationTimestamp", Long.toString(Y));
            b.set("lastApplicationSessionTimestamp", Long.toString(T));
            b.set("lastUserSessionTimestamp", Long.toString(U));
            b.set("lastActiveUserSessionTimestamp", Long.toString(V));
            b.set("accumulatedApplicationSessionTime", Long.toString(N));
            b.set("accumulatedActiveUserSessionTime", Long.toString(P));
            b.set("accumulatedUserSessionTime", Long.toString(O));
            b.set("activeUserSessionCount", Long.toString(S));
            b.set("userSessionCount", Long.toString(R));
            b.set("lastUserInteractionTimestamp", Long.toString(X));
            b.set("userInteractionCount", Integer.toString(W));
            b.set("previousGenesis", Long.toString(K));
            b.set("genesis", Long.toString(J));
            b.set("applicationSessionCountKey", Integer.toString(Q));
        }
        return;
_L2:
        P = P + l2;
        V = l1;
_L3:
        O = O + l2;
        U = l1;
_L4:
        N = l2 + N;
        T = l1;
        if (true) goto _L1; else goto _L5
_L5:
    }

    protected DispatchQueue c()
    {
        return new DispatchQueue(this);
    }

    protected TaskExecutor d()
    {
        return new TaskExecutor(this);
    }

    public void disableAutoUpdate()
    {
        this;
        JVM INSTR monitorenter ;
        w();
        m = true;
        l = -1L;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected MeasurementDispatcher e()
    {
        return new MeasurementDispatcher(this);
    }

    protected KeepAliveAlarmReceiver f()
    {
        return new KeepAliveAlarmReceiver(this, 0x5265c00L);
    }

    public void flush(boolean flag)
    {
        if (f == null)
        {
            return;
        } else
        {
            f.execute(new u(this), flag);
            return;
        }
    }

    protected OfflineMeasurementsCache g()
    {
        return new OfflineMeasurementsCache(this);
    }

    public int getActiveUserSessionCountDelta(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = -1;
        int j1;
        if (S < 0)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        j1 = S;
        i1 = j1;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        S = 0;
        b.set("activeUserSessionCount", Integer.toString(S));
        i1 = j1;
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    public long getActiveUserSessionTimeDelta(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = P;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        P = 0L;
        b.set("accumulatedActiveUserSessionTime", Long.toString(P));
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    public Context getAppContext()
    {
        return ac;
    }

    public String getAppName()
    {
        Object obj;
        PackageManager packagemanager;
        if (ab != null && ab.length() != 0 || ac == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        obj = ac.getPackageName();
        packagemanager = ac.getPackageManager();
        obj = packagemanager.getApplicationLabel(packagemanager.getApplicationInfo(((String) (obj)), 0));
        if (obj != null)
        {
            try
            {
                setAppName(obj.toString(), false);
            }
            catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
            {
                ab = b.get("appName");
            }
        }
        return ab;
    }

    public int getApplicationSessionCountDelta(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = Q;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        Q = 0;
        b.set("applicationSessionCountKey", Integer.toString(Q));
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    public long getApplicationSessionTimeDelta(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = N;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        N = 0L;
        b.set("accumulatedApplicationSessionTime", Long.toString(N));
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    public ApplicationState getApplicationState()
    {
        return z;
    }

    public long getAutoUpdateInterval()
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = l;
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    public long getBackgroundTimeDelta(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = G;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        G = 0L;
        b.set("accumulatedBackgroundTime", Long.toString(G));
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    public long getBackgroundTotalTime(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = E;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        E = 0L;
        b.set("totalBackgroundTime", Long.toString(E));
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    public long getCacheFlushingInterval()
    {
        return ag;
    }

    public int getColdStartCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = r.get();
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    public long getColdStartId()
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = q;
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getCrossPublisherId()
    {
        if (an == null)
        {
            return null;
        } else
        {
            return an.getCrossPublisherId();
        }
    }

    public String getCurrentActivityName()
    {
        return x;
    }

    public String getCurrentVersion()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = u;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getCustomerC2()
    {
        return (String)getLabels().get("c2");
    }

    public long getFirstInstallId()
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = t;
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    public long getForegroundTimeDelta(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = H;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        H = 0L;
        b.set("accumulatedForegroundTime", Long.toString(H));
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    public long getForegroundTotalTime(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = D;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        D = 0L;
        b.set("totalForegroundTime", Long.toString(D));
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    public int getForegroundTransitionsCountDelta(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = C.get();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        C.set(0);
        b.set("foregroundTransitionsCount", Long.toString(C.get()));
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    public long getGenesis()
    {
        return J;
    }

    public long getInactiveTimeDelta(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = I;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        I = 0L;
        b.set("accumulatedInactiveTime", Long.toString(I));
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    public long getInactiveTotalTime(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = F;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        F = 0L;
        b.set("totalInactiveTime", Long.toString(F));
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    public long getInstallId()
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = s;
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    public KeepAliveAlarmReceiver getKeepAliveAlarmReceiver()
    {
        return c;
    }

    public HashMap getLabels()
    {
        return ad;
    }

    public TransmissionMode getLiveTransmissionMode()
    {
        return ak;
    }

    public MeasurementDispatcher getMeasurementDispatcher()
    {
        return g;
    }

    public String[] getMeasurementLabelOrder()
    {
        return am;
    }

    public OfflineMeasurementsCache getOfflineCache()
    {
        return a;
    }

    public TransmissionMode getOfflineTransmissionMode()
    {
        return al;
    }

    public String getPixelURL()
    {
        return aa;
    }

    public long getPreviousGenesis()
    {
        return K;
    }

    public String getPreviousVersion()
    {
        this;
        JVM INSTR monitorenter ;
        String s1;
        s1 = v;
        if (v != null && v.length() > 0)
        {
            b.remove("previousVersion");
            v = null;
        }
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getPublisherSecret()
    {
        if (an == null)
        {
            return "";
        } else
        {
            return an.getPublisherSecret();
        }
    }

    public int getRunsCount()
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = p.get();
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    public Storage getStorage()
    {
        return b;
    }

    public TaskExecutor getTaskExecutor()
    {
        return f;
    }

    public int getUserInteractionCount(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = W;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        W = 0;
        b.set("userInteractionCount", Integer.toString(W));
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    public int getUserSessionCountDelta(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = -1;
        int j1;
        if (R < 0)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        j1 = R;
        i1 = j1;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        R = 0;
        b.set("userSessionCount", Integer.toString(R));
        i1 = j1;
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    public long getUserSessionTimeDelta(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = O;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        O = 0L;
        b.set("accumulatedUserSessionTime", Long.toString(O));
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    public String getVersion()
    {
        return "2.1403.17";
    }

    public String getVisitorId()
    {
        if (an == null)
        {
            return null;
        } else
        {
            return an.getVisitorId();
        }
    }

    protected CacheFlusher h()
    {
        return new CacheFlusher(this);
    }

    public boolean handleColdStart()
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        if (o) goto _L2; else goto _L1
_L1:
        o = true;
        r.getAndIncrement();
        b.set("coldStartCount", String.valueOf(r));
        q = Date.unixTime();
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    protected ConnectivityChangeReceiver i()
    {
        return new ConnectivityChangeReceiver(this);
    }

    public void incrementRunsCount()
    {
        p.getAndIncrement();
        b.set("runs", Long.toString(p.get()));
    }

    public boolean isAutoStartEnabled()
    {
        return w;
    }

    public boolean isKeepAliveEnabled()
    {
        return af;
    }

    public boolean isSecure()
    {
        return aj;
    }

    protected void j()
    {
        L = Utils.getLong(b.get("lastApplicationAccumulationTimestamp"), -1L);
        Y = Utils.getLong(b.get("lastSessionAccumulationTimestamp"), -1L);
        T = Utils.getLong(b.get("lastApplicationSessionTimestamp"), -1L);
        U = Utils.getLong(b.get("lastUserSessionTimestamp"), -1L);
        V = Utils.getLong(b.get("lastActiveUserSessionTimestamp"), -1L);
        C.set(Utils.getInteger(b.get("foregroundTransitionsCount")));
        H = Utils.getLong(b.get("accumulatedForegroundTime"));
        G = Utils.getLong(b.get("accumulatedBackgroundTime"));
        I = Utils.getLong(b.get("accumulatedInactiveTime"));
        D = Utils.getLong(b.get("totalForegroundTime"));
        E = Utils.getLong(b.get("totalBackgroundTime"));
        F = Utils.getLong(b.get("totalInactiveTime"));
        N = Utils.getLong(b.get("accumulatedApplicationSessionTime"));
        P = Utils.getLong(b.get("accumulatedActiveUserSessionTime"));
        O = Utils.getLong(b.get("accumulatedUserSessionTime"));
        S = Utils.getInteger(b.get("activeUserSessionCount"), -1);
        R = Utils.getInteger(b.get("userSessionCount"), -1);
        X = Utils.getLong(b.get("lastUserInteractionTimestamp"), -1L);
        W = Utils.getInteger(b.get("userInteractionCount"), 0);
        Q = Utils.getInteger(b.get("applicationSessionCountKey"), 0);
        u = k();
        K = Utils.getLong(b.get("previousGenesis"), 0L);
        J = Utils.getLong(b.get("genesis"), -1L);
        long l1;
        if (J < 0L)
        {
            J = Date.unixTime();
            K = 0L;
            T = J;
            Q = Q + 1;
        } else
        {
            if (!p())
            {
                N = N + (Date.unixTime() - Y);
                b.set("accumulatedApplicationSessionTime", Long.toString(N));
            }
            T = J;
        }
        t = Utils.getLong(b.get("firstInstallId"), -1L);
        if (t < 0L)
        {
            t = J;
            s = J;
            b.set("currentVersion", u);
            b.set("firstInstallId", String.valueOf(t));
            b.set("installId", String.valueOf(s));
        } else
        {
            if (b.has("previousVersion").booleanValue())
            {
                v = b.get("previousVersion");
            }
            String s1 = b.get("currentVersion");
            if (!s1.equals(u))
            {
                v = s1;
                b.set("previousVersion", v);
                s = J;
                b.set("installId", String.valueOf(s));
            } else
            {
                s = Utils.getLong(b.get("installId"), -1L);
            }
            b.set("currentVersion", u);
        }
        b.set("genesis", Long.toString(J));
        b.set("previousGenesis", Long.toString(K));
        l1 = Date.unixTime();
        if (L >= 0L)
        {
            long l2 = l1 - L;
            I = I + l2;
            b.set("accumulatedInactiveTime", Long.toString(I));
            F = l2 + F;
            b.set("totalInactiveTime", Long.toString(F));
        }
        L = l1;
        Y = l1;
        b.set("lastApplicationAccumulationTimestamp", Long.toString(L));
        b.set("lastSessionAccumulationTimestamp", Long.toString(Y));
        b.set("lastApplicationSessionTimestamp", Long.toString(T));
        if (!b.has("runs").booleanValue())
        {
            b.set("runs", "0");
        }
        p.set(Utils.getInteger(b.get("runs")));
        r.set(Utils.getInteger(b.get("coldStartCount")));
    }

    protected String k()
    {
        String s1 = ac.getPackageName();
        try
        {
            s1 = ac.getPackageManager().getPackageInfo(s1, 0).versionName;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return "0";
        }
        return s1;
    }

    protected void l()
    {
        if (ac == null) goto _L2; else goto _L1
_L1:
        Object obj = ac.getResources().getAssets();
        Object obj1;
        obj1 = ((AssetManager) (obj)).open("comScore.properties");
        obj = new Properties();
        ((Properties) (obj)).load(((java.io.InputStream) (obj1)));
        Constants.DEBUG = Utils.getBoolean(a("Debug", ((Properties) (obj)), false));
        aj = Utils.getBoolean(a("Secure", ((Properties) (obj)), false));
        obj1 = a("PublisherSecret", ((Properties) (obj)), true);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        b(((String) (obj1)));
        obj1 = a("AppName", ((Properties) (obj)), true);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        c(((String) (obj1)));
        obj1 = a("CustomerC2", ((Properties) (obj)), false);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        d(((String) (obj1)));
        obj1 = a("PixelURL", ((Properties) (obj)), false);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        a(((String) (obj1)));
        obj1 = a("OfflineURL", ((Properties) (obj)), false);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_168;
        }
        a.setUrl(((String) (obj1)));
        obj1 = a("LiveTransmissionMode", ((Properties) (obj)), false);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_196;
        }
        ak = TransmissionMode.valueOf(((String) (obj1)).toUpperCase(Locale.getDefault()));
_L5:
        obj1 = a("OfflineTransmissionMode", ((Properties) (obj)), false);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_224;
        }
        al = TransmissionMode.valueOf(((String) (obj1)).toUpperCase(Locale.getDefault()));
_L3:
        int i1;
        af = Utils.getBoolean(a("KeepAliveEnabled", ((Properties) (obj)), false), true);
        i1 = Utils.getInteger(a("CacheMaxSize", ((Properties) (obj)), false), -1);
        if (i1 < 0)
        {
            break MISSING_BLOCK_LABEL_267;
        }
        a.setCacheMaxMeasurements(i1);
        i1 = Utils.getInteger(a("CacheMaxBatchSize", ((Properties) (obj)), false), -1);
        if (i1 < 0)
        {
            break MISSING_BLOCK_LABEL_293;
        }
        a.setCacheMaxBatchFiles(i1);
        i1 = Utils.getInteger(a("CacheMaxFlushesInARow", ((Properties) (obj)), false), -1);
        if (i1 < 0)
        {
            break MISSING_BLOCK_LABEL_319;
        }
        a.setCacheMaxPosts(i1);
        i1 = Utils.getInteger(a("CacheMinutesToRetry", ((Properties) (obj)), false), -1);
        if (i1 < 0)
        {
            break MISSING_BLOCK_LABEL_345;
        }
        a.setCacheWaitMinutes(i1);
        i1 = Utils.getInteger(a("CacheExpiryInDays", ((Properties) (obj)), false), -1);
        if (i1 < 0)
        {
            break MISSING_BLOCK_LABEL_371;
        }
        a.setCacheMeasurementExpiry(i1);
        long l1 = Utils.getLong(a("CacheFlushingInterval", ((Properties) (obj)), false), -1L);
        if (l1 < 0L)
        {
            break MISSING_BLOCK_LABEL_415;
        }
        ag = l1;
        if (d != null)
        {
            d.update();
        }
        boolean flag;
        setErrorHandlingEnabled(Utils.getBoolean(a("ErrorHandlingEnabled", ((Properties) (obj)), false)));
        w = Utils.getBoolean(a("AutoStartEnabled", ((Properties) (obj)), false), true);
        flag = Utils.getBoolean(a("AutoUpdateInForegroundOnly", ((Properties) (obj)), false), true);
        i1 = Utils.getInteger(a("AutoUpdateInterval", ((Properties) (obj)), false), -1);
        IllegalArgumentException illegalargumentexception;
        if (i1 >= 60)
        {
            try
            {
                a(i1, flag);
                return;
            }
            catch (IOException ioexception)
            {
                if (Constants.DEBUG)
                {
                    CSLog.printStackTrace(ioexception);
                    return;
                }
            }
        }
          goto _L2
        illegalargumentexception;
        ak = TransmissionMode.DEFAULT;
        continue; /* Loop/switch isn't completed */
        illegalargumentexception;
        al = TransmissionMode.DEFAULT;
          goto _L3
_L2:
        return;
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected void n()
    {
        this;
        JVM INSTR monitorenter ;
        long l1;
        if (j != null)
        {
            j.cancel();
            k = null;
            j = null;
        }
        l1 = Date.unixTime();
        if (A.get() <= 0) goto _L2; else goto _L1
_L1:
        ApplicationState applicationstate = ApplicationState.FOREGROUND;
_L9:
        if (l1 - X >= 0x493e0L) goto _L4; else goto _L3
_L3:
        SessionState sessionstate = SessionState.ACTIVE_USER;
_L10:
        ApplicationState applicationstate1;
        SessionState sessionstate1;
        applicationstate1 = z;
        sessionstate1 = M;
        if (applicationstate == applicationstate1 && sessionstate == sessionstate1) goto _L6; else goto _L5
_L5:
        k = new ac(this, applicationstate1, applicationstate, sessionstate1, sessionstate);
        if (!n || applicationstate == ApplicationState.FOREGROUND) goto _L8; else goto _L7
_L7:
        j = new Timer();
        j.schedule(k, 300L);
_L6:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
label0:
        {
            if (B.get() <= 0)
            {
                break label0;
            }
            applicationstate = ApplicationState.BACKGROUND_UX_ACTIVE;
        }
          goto _L9
        applicationstate = ApplicationState.INACTIVE;
          goto _L9
_L4:
label1:
        {
            if (B.get() <= 0)
            {
                break label1;
            }
            sessionstate = SessionState.USER;
        }
          goto _L10
label2:
        {
            if (A.get() <= 0)
            {
                break label2;
            }
            sessionstate = SessionState.APPLICATION;
        }
          goto _L10
        sessionstate = SessionState.INACTIVE;
          goto _L10
_L8:
        k.run();
        k = null;
          goto _L6
        Exception exception;
        exception;
        throw exception;
          goto _L9
    }

    public void notify(EventType eventtype, HashMap hashmap, boolean flag)
    {
        if (!flag)
        {
            a(eventtype, hashmap);
        } else
        if (f != null)
        {
            f.execute(new y(this, eventtype, hashmap), flag);
            return;
        }
    }

    protected void o()
    {
        if (Z != null)
        {
            Z.cancel();
            Z = null;
        }
        Z = new Timer();
        Z.schedule(new UserInteractionTask(), 0x493e0L);
    }

    public void onEnterForeground()
    {
        this;
        JVM INSTR monitorenter ;
        TaskExecutor taskexecutor = f;
        if (taskexecutor != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        f.execute(new w(this), true);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void onExitForeground()
    {
        this;
        JVM INSTR monitorenter ;
        TaskExecutor taskexecutor = f;
        if (taskexecutor != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        f.execute(new aa(this), true);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    protected boolean p()
    {
        long l1 = Date.unixTime();
        boolean flag = false;
        if (l1 - T > 0x124f80L)
        {
            K = J;
            J = l1;
            Q = Q + 1;
            flag = true;
        }
        T = l1;
        return flag;
    }

    protected void q()
    {
        long l1 = Date.unixTime();
        if (l1 - V >= 0x493e0L)
        {
            S = S + 1;
        }
        V = l1;
    }

    protected void r()
    {
        long l1 = Date.unixTime();
        if (l1 - U >= 0x493e0L)
        {
            R = R + 1;
        }
        U = l1;
    }

    public void reset()
    {
        this;
        JVM INSTR monitorenter ;
        ak = TransmissionMode.DEFAULT;
        al = TransmissionMode.DEFAULT;
        aj = false;
        am = Constants.LABELS_ORDER;
        z = ApplicationState.INACTIVE;
        M = SessionState.INACTIVE;
        o = false;
        p.set(0);
        q = -1L;
        r.set(0);
        t = -1L;
        s = -1L;
        u = null;
        v = null;
        A.set(0);
        B.set(0);
        D = 0L;
        E = 0L;
        F = 0L;
        G = 0L;
        H = 0L;
        I = 0L;
        N = 0L;
        P = 0L;
        O = 0L;
        J = -1L;
        K = 0L;
        S = -1;
        R = -1;
        W = 0;
        X = -1L;
        L = -1L;
        Y = -1L;
        T = -1L;
        U = -1L;
        V = -1L;
        s = -1L;
        t = -1L;
        disableAutoUpdate();
        if (j != null)
        {
            j.cancel();
            k = null;
            j = null;
        }
        if (Z != null)
        {
            Z.cancel();
            Z = null;
        }
        if (c != null)
        {
            c.cancel();
        }
        if (d != null)
        {
            d.stop();
        }
        if (f != null)
        {
            f.clear();
        }
        if (b != null)
        {
            b.close();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void s()
    {
        a(true);
    }

    public void setAppContext(Context context)
    {
        if (ac != null || context == null)
        {
            return;
        } else
        {
            ac = context;
            f = d();
            f.execute(new ad(this), true);
            return;
        }
    }

    public void setAppName(String s1, boolean flag)
    {
        if (!flag)
        {
            c(s1);
        } else
        if (f != null)
        {
            f.execute(new d(this, s1), flag);
            return;
        }
    }

    public void setCurrentActivityName(String s1)
    {
        x = s1;
    }

    public void setErrorHandlingEnabled(boolean flag)
    {
        ah = flag;
        if (ah)
        {
            Thread.setDefaultUncaughtExceptionHandler(new CustomExceptionHandler(this));
        } else
        if (Thread.getDefaultUncaughtExceptionHandler() != ai)
        {
            Thread.setDefaultUncaughtExceptionHandler(ai);
            return;
        }
    }

    public void setLabel(String s1, String s2, boolean flag)
    {
        if (!flag)
        {
            b(s1, s2);
        } else
        if (f != null)
        {
            f.execute(new f(this, s1, s2), flag);
            return;
        }
    }

    protected void t()
    {
        b(true);
    }

    public void update()
    {
        this;
        JVM INSTR monitorenter ;
        update(true);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void update(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (j != null)
        {
            j.cancel();
            j = null;
            k.run();
            k = null;
        }
        a(flag);
        b(flag);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void v()
    {
        this;
        JVM INSTR monitorenter ;
        w();
        if (l >= 60000L)
        {
            i = new Timer("AutoUpdateTimer");
            i.scheduleAtFixedRate(new x(this), new java.util.Date(Date.unixTime() + l), l);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void w()
    {
        this;
        JVM INSTR monitorenter ;
        if (i != null)
        {
            i.cancel();
            i = null;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void x()
    {
    }

    protected void y()
    {
    }

    boolean z()
    {
        return ac == null || an.isPublisherSecretEmpty() || aa == null || aa.length() == 0;
    }

    private class UserInteractionTask extends TimerTask
    {

        final Core a;

        public void run()
        {
            synchronized (a)
            {
                if (a.Z != null)
                {
                    a.Z.cancel();
                    a.Z = null;
                    a.n();
                }
            }
            return;
            exception;
            core;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public UserInteractionTask()
        {
            a = Core.this;
            super();
        }
    }

}
