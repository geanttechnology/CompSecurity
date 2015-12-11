// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.google.android.gms.common.internal:
//            n, u, h, ValidateAccountRequest, 
//            r, GetServiceRequest, a

public abstract class l
    implements com.google.android.gms.common.api.b.b, m.a
{
    private abstract class a extends c
    {

        public final int a;
        public final Bundle b;
        final l c;

        protected abstract void a(ConnectionResult connectionresult);

        protected void a(Boolean boolean1)
        {
            Object obj = null;
            if (boolean1 != null) goto _L2; else goto _L1
_L1:
            l.a(c, 1, null);
_L4:
            return;
_L2:
            switch (a)
            {
            default:
                l.a(c, 1, null);
                boolean1 = obj;
                if (b != null)
                {
                    boolean1 = (PendingIntent)b.getParcelable("pendingIntent");
                }
                a(new ConnectionResult(a, boolean1));
                return;

            case 0: // '\0'
                if (!a())
                {
                    l.a(c, 1, null);
                    a(new ConnectionResult(8, null));
                    return;
                }
                break;

            case 10: // '\n'
                l.a(c, 1, null);
                throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        protected void a(Object obj)
        {
            a((Boolean)obj);
        }

        protected abstract boolean a();

        protected void b()
        {
        }

        protected a(int i1, Bundle bundle)
        {
            c = l.this;
            super(Boolean.valueOf(true));
            a = i1;
            b = bundle;
        }
    }

    final class b extends Handler
    {

        final l a;

        private void a(Message message)
        {
            message = (c)message.obj;
            message.b();
            message.d();
        }

        private boolean b(Message message)
        {
            return message.what == 2 || message.what == 1 || message.what == 5 || message.what == 6;
        }

        public void handleMessage(Message message)
        {
            if (a.b.get() != message.arg1)
            {
                if (b(message))
                {
                    a(message);
                }
                return;
            }
            if ((message.what == 1 || message.what == 5 || message.what == 6) && !a.h())
            {
                a(message);
                return;
            }
            if (message.what == 3)
            {
                message = new ConnectionResult(message.arg2, null);
                l.a(a).a(message);
                a.a(message);
                return;
            }
            if (message.what == 4)
            {
                l.a(a, 4, null);
                if (l.b(a) != null)
                {
                    l.b(a).a(message.arg2);
                }
                a.a(message.arg2);
                l.a(a, 4, 1, null);
                return;
            }
            if (message.what == 2 && !a.b())
            {
                a(message);
                return;
            }
            if (b(message))
            {
                ((c)message.obj).c();
                return;
            } else
            {
                Log.wtf("GmsClient", "Don't know how to handle this message.");
                return;
            }
        }

        public b(Looper looper)
        {
            a = l.this;
            super(looper);
        }
    }

    protected abstract class c
    {

        private Object a;
        private boolean b;
        final l d;

        protected abstract void a(Object obj);

        protected abstract void b();

        public void c()
        {
            this;
            JVM INSTR monitorenter ;
            Object obj;
            obj = a;
            if (b)
            {
                Log.w("GmsClient", (new StringBuilder()).append("Callback proxy ").append(this).append(" being reused. This is not safe.").toString());
            }
            this;
            JVM INSTR monitorexit ;
            Object obj1;
            if (obj != null)
            {
                try
                {
                    a(obj);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    b();
                    throw obj1;
                }
            } else
            {
                b();
            }
            this;
            JVM INSTR monitorenter ;
            b = true;
            this;
            JVM INSTR monitorexit ;
            d();
            return;
            obj1;
            this;
            JVM INSTR monitorexit ;
            throw obj1;
            obj1;
            this;
            JVM INSTR monitorexit ;
            throw obj1;
        }

        public void d()
        {
            e();
            synchronized (l.c(d))
            {
                l.c(d).remove(this);
            }
            return;
            exception;
            arraylist;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void e()
        {
            this;
            JVM INSTR monitorenter ;
            a = null;
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public c(Object obj)
        {
            d = l.this;
            super();
            a = obj;
            b = false;
        }
    }

    public static final class d extends q.a
    {

        private l a;
        private final int b;

        private void a()
        {
            a = null;
        }

        public void a(int i1, Bundle bundle)
        {
            u.a(a, "onAccountValidationComplete can be called only once per call to validateAccount");
            a.a(i1, bundle, b);
            a();
        }

        public void a(int i1, IBinder ibinder, Bundle bundle)
        {
            u.a(a, "onPostInitComplete can be called only once per call to getRemoteService");
            a.a(i1, ibinder, bundle, b);
            a();
        }

        public d(l l1, int i1)
        {
            a = l1;
            b = i1;
        }
    }

    public final class e
        implements ServiceConnection
    {

        final l a;
        private final int b;

        public void onServiceConnected(ComponentName componentname, IBinder ibinder)
        {
            u.a(ibinder, "Expecting a valid IBinder");
            l.a(a, com.google.android.gms.common.internal.r.a.a(ibinder));
            a.c(b);
        }

        public void onServiceDisconnected(ComponentName componentname)
        {
            a.a.sendMessage(a.a.obtainMessage(4, b, 1));
        }

        public e(int i1)
        {
            a = l.this;
            super();
            b = i1;
        }
    }

    protected class f
        implements com.google.android.gms.common.api.d.c
    {

        final l a;

        public void a(ConnectionResult connectionresult)
        {
            if (connectionresult.b())
            {
                a.a(null, l.d(a));
            } else
            if (l.e(a) != null)
            {
                l.e(a).a(connectionresult);
                return;
            }
        }

        public void b(ConnectionResult connectionresult)
        {
            throw new IllegalStateException("Legacy GmsClient received onReportAccountValidation callback.");
        }

        public f()
        {
            a = l.this;
            super();
        }
    }

    protected final class g extends a
    {

        public final IBinder e;
        final l f;

        protected void a(ConnectionResult connectionresult)
        {
            if (l.e(f) != null)
            {
                l.e(f).a(connectionresult);
            }
            f.a(connectionresult);
        }

        protected boolean a()
        {
            String s1;
            try
            {
                s1 = e.getInterfaceDescriptor();
            }
            catch (RemoteException remoteexception)
            {
                Log.w("GmsClient", "service probably died");
                return false;
            }
            if (!f.e().equals(s1))
            {
                Log.e("GmsClient", (new StringBuilder()).append("service descriptor mismatch: ").append(f.e()).append(" vs. ").append(s1).toString());
            } else
            {
                IInterface iinterface = f.a(e);
                if (iinterface != null && l.a(f, 2, 3, iinterface))
                {
                    Bundle bundle = f.c_();
                    if (l.b(f) != null)
                    {
                        l.b(f).a(bundle);
                    }
                    com.google.android.gms.common.e.c(l.f(f));
                    return true;
                }
            }
            return false;
        }

        public g(int i1, IBinder ibinder, Bundle bundle)
        {
            f = l.this;
            super(i1, bundle);
            e = ibinder;
        }
    }

    protected final class h extends a
    {

        final l e;

        protected void a(ConnectionResult connectionresult)
        {
            l.a(e).a(connectionresult);
            e.a(connectionresult);
        }

        protected boolean a()
        {
            l.a(e).a(ConnectionResult.a);
            return true;
        }

        public h()
        {
            e = l.this;
            super(0, null);
        }
    }

    protected final class i extends a
    {

        final l e;

        protected void a(ConnectionResult connectionresult)
        {
            l.a(e).b(connectionresult);
            e.a(connectionresult);
        }

        protected boolean a()
        {
            l.a(e).b(ConnectionResult.a);
            return true;
        }

        public i(int i1, Bundle bundle)
        {
            e = l.this;
            super(i1, bundle);
        }
    }


    public static final String c[] = {
        "service_esmobile", "service_googleme"
    };
    final Handler a;
    protected AtomicInteger b;
    private final Context d;
    private final com.google.android.gms.common.internal.h e;
    private final Looper f;
    private final n g;
    private final Object h;
    private r i;
    private com.google.android.gms.common.api.d.c j;
    private IInterface k;
    private final ArrayList l;
    private e m;
    private int n;
    private final Set o;
    private final Account p;
    private com.google.android.gms.common.api.d.b q;
    private com.google.android.gms.common.api.d.d r;
    private final int s;

    protected l(Context context, Looper looper, int i1, com.google.android.gms.common.api.d.b b1, com.google.android.gms.common.api.d.d d1, com.google.android.gms.common.internal.h h1)
    {
        this(context, looper, com.google.android.gms.common.internal.n.a(context), i1, h1, b1, d1);
    }

    protected l(Context context, Looper looper, n n1, int i1, com.google.android.gms.common.internal.h h1)
    {
        h = new Object();
        l = new ArrayList();
        n = 1;
        b = new AtomicInteger(0);
        d = (Context)u.a(context, "Context must not be null");
        f = (Looper)u.a(looper, "Looper must not be null");
        g = (n)u.a(n1, "Supervisor must not be null");
        a = new b(looper);
        s = i1;
        e = (com.google.android.gms.common.internal.h)u.a(h1);
        p = h1.b();
        o = b(h1.e());
    }

    protected l(Context context, Looper looper, n n1, int i1, com.google.android.gms.common.internal.h h1, com.google.android.gms.common.api.d.b b1, com.google.android.gms.common.api.d.d d1)
    {
        this(context, looper, n1, i1, h1);
        q = (com.google.android.gms.common.api.d.b)u.a(b1);
        r = (com.google.android.gms.common.api.d.d)u.a(d1);
    }

    static com.google.android.gms.common.api.d.c a(l l1)
    {
        return l1.j;
    }

    static r a(l l1, r r1)
    {
        l1.i = r1;
        return r1;
    }

    private void a(int i1, IInterface iinterface)
    {
        boolean flag2 = true;
        Object obj;
        boolean flag;
        boolean flag1;
        if (i1 == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (iinterface != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag != flag1)
        {
            flag2 = false;
        }
        u.b(flag2);
        obj = h;
        obj;
        JVM INSTR monitorenter ;
        n = i1;
        k = iinterface;
        i1;
        JVM INSTR tableswitch 1 3: default 105
    //                   1 98
    //                   2 79
    //                   3 91;
           goto _L1 _L2 _L3 _L4
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
_L3:
        p();
          goto _L1
        iinterface;
        obj;
        JVM INSTR monitorexit ;
        throw iinterface;
_L4:
        e_();
          goto _L1
_L2:
        q();
          goto _L1
    }

    static void a(l l1, int i1, IInterface iinterface)
    {
        l1.a(i1, iinterface);
    }

    private boolean a(int i1, int j1, IInterface iinterface)
    {
label0:
        {
            synchronized (h)
            {
                if (n == i1)
                {
                    break label0;
                }
            }
            return false;
        }
        a(j1, iinterface);
        obj;
        JVM INSTR monitorexit ;
        return true;
        iinterface;
        obj;
        JVM INSTR monitorexit ;
        throw iinterface;
    }

    static boolean a(l l1, int i1, int j1, IInterface iinterface)
    {
        return l1.a(i1, j1, iinterface);
    }

    static com.google.android.gms.common.api.d.b b(l l1)
    {
        return l1.q;
    }

    private Set b(Set set)
    {
        Set set1 = a(set);
        if (set1 == null)
        {
            return set1;
        }
        for (Iterator iterator = set1.iterator(); iterator.hasNext();)
        {
            if (!set.contains((Scope)iterator.next()))
            {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }

        return set1;
    }

    private void b(com.google.android.gms.common.api.d.c c1)
    {
        j = (com.google.android.gms.common.api.d.c)u.a(c1, "Connection progress callbacks cannot be null.");
    }

    static ArrayList c(l l1)
    {
        return l1.l;
    }

    static Set d(l l1)
    {
        return l1.o;
    }

    static com.google.android.gms.common.api.d.d e(l l1)
    {
        return l1.r;
    }

    static Context f(l l1)
    {
        return l1.d;
    }

    private void p()
    {
        if (m != null)
        {
            Log.e("GmsClient", (new StringBuilder()).append("Calling connect() while still connected, missing disconnect() for ").append(d()).toString());
            g.b(d(), m, f());
            b.incrementAndGet();
        }
        m = new e(b.get());
        if (!g.a(d(), m, f()))
        {
            Log.e("GmsClient", (new StringBuilder()).append("unable to connect to service: ").append(d()).toString());
            a.sendMessage(a.obtainMessage(3, b.get(), 9));
        }
    }

    private void q()
    {
        if (m != null)
        {
            g.b(d(), m, f());
            m = null;
        }
    }

    protected abstract IInterface a(IBinder ibinder);

    protected Set a(Set set)
    {
        return set;
    }

    public void a()
    {
        b.incrementAndGet();
        ArrayList arraylist = l;
        arraylist;
        JVM INSTR monitorenter ;
        int j1 = l.size();
        int i1 = 0;
_L2:
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        ((c)l.get(i1)).e();
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
        l.clear();
        arraylist;
        JVM INSTR monitorexit ;
        a(1, ((IInterface) (null)));
        return;
        Exception exception;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void a(int i1)
    {
    }

    protected void a(int i1, Bundle bundle, int j1)
    {
        a.sendMessage(a.obtainMessage(5, j1, -1, new i(i1, bundle)));
    }

    protected void a(int i1, IBinder ibinder, Bundle bundle, int j1)
    {
        a.sendMessage(a.obtainMessage(1, j1, -1, new g(i1, ibinder, bundle)));
    }

    protected void a(ConnectionResult connectionresult)
    {
    }

    public void a(com.google.android.gms.common.api.d.c c1)
    {
        b(c1);
        a(2, ((IInterface) (null)));
    }

    public void a(com.google.android.gms.common.internal.a a1)
    {
        Bundle bundle = n();
        a1 = new ValidateAccountRequest(a1, (Scope[])o.toArray(new Scope[o.size()]), d.getPackageName(), bundle);
        try
        {
            i.a(new d(this, b.get()), a1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.internal.a a1)
        {
            Log.w("GmsClient", "service died");
            b(1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.internal.a a1)
        {
            Log.w("GmsClient", "Remote exception occurred", a1);
        }
    }

    public void a(com.google.android.gms.common.internal.a a1, Set set)
    {
        Object obj;
        try
        {
            obj = k();
            obj = (new GetServiceRequest(s)).a(d.getPackageName()).a(((Bundle) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.internal.a a1)
        {
            Log.w("GmsClient", "service died");
            b(1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.internal.a a1)
        {
            Log.w("GmsClient", "Remote exception occurred", a1);
            return;
        }
        if (set == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        ((GetServiceRequest) (obj)).a(set);
        if (!c()) goto _L2; else goto _L1
_L1:
        ((GetServiceRequest) (obj)).a(j()).a(a1);
_L4:
        i.a(new d(this, b.get()), ((GetServiceRequest) (obj)));
        return;
_L2:
        if (o())
        {
            ((GetServiceRequest) (obj)).a(p);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(String s1, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        int i1;
        synchronized (h)
        {
            i1 = n;
            as = k;
        }
        printwriter.append(s1).append("mConnectState=");
        i1;
        JVM INSTR tableswitch 1 4: default 64
    //                   1 127
    //                   2 97
    //                   3 107
    //                   4 117;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break MISSING_BLOCK_LABEL_127;
_L1:
        printwriter.print("UNKNOWN");
_L6:
        printwriter.append(" mService=");
        if (as == null)
        {
            printwriter.println("null");
            return;
        } else
        {
            printwriter.append(e()).append("@").println(Integer.toHexString(System.identityHashCode(as.asBinder())));
            return;
        }
        s1;
        filedescriptor;
        JVM INSTR monitorexit ;
        throw s1;
_L3:
        printwriter.print("CONNECTING");
          goto _L6
_L4:
        printwriter.print("CONNECTED");
          goto _L6
_L5:
        printwriter.print("DISCONNECTING");
          goto _L6
        printwriter.print("DISCONNECTED");
          goto _L6
    }

    public void b(int i1)
    {
        a.sendMessage(a.obtainMessage(4, b.get(), i1));
    }

    public boolean b()
    {
        Object obj = h;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (n == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void c(int i1)
    {
        a.sendMessage(a.obtainMessage(6, i1, -1, new h()));
    }

    public boolean c()
    {
        return false;
    }

    public Bundle c_()
    {
        return null;
    }

    protected abstract String d();

    protected abstract String e();

    protected void e_()
    {
    }

    protected String f()
    {
        return e.h();
    }

    public boolean h()
    {
        Object obj = h;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (n == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final Context i()
    {
        return d;
    }

    public final Account j()
    {
        if (p != null)
        {
            return p;
        } else
        {
            return new Account("<<default account>>", "com.google");
        }
    }

    protected Bundle k()
    {
        return new Bundle();
    }

    protected final void l()
    {
        if (!b())
        {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        } else
        {
            return;
        }
    }

    public final IInterface m()
        throws DeadObjectException
    {
        Object obj = h;
        obj;
        JVM INSTR monitorenter ;
        if (n == 4)
        {
            throw new DeadObjectException();
        }
        break MISSING_BLOCK_LABEL_28;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        l();
        IInterface iinterface;
        boolean flag;
        if (k != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        u.a(flag, "Client is connected but service is null");
        iinterface = k;
        obj;
        JVM INSTR monitorexit ;
        return iinterface;
    }

    protected Bundle n()
    {
        return null;
    }

    public boolean o()
    {
        return false;
    }

}
