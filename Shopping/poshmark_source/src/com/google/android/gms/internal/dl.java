// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppState;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

// Referenced classes of package com.google.android.gms.internal:
//            eh, er, dn, en, 
//            dk

public final class dl extends eh
{
    final class a extends dk
    {

        private final com.google.android.gms.common.api.a.c vj;
        final dl vk;

        public void b(int i, int j)
        {
            Status status = new Status(i);
            vk.a(vk. new b(vj, status, j));
        }

        public a(com.google.android.gms.common.api.a.c c1)
        {
            vk = dl.this;
            super();
            vj = (com.google.android.gms.common.api.a.c)er.b(c1, "Result holder must not be null");
        }
    }

    final class b extends eh.b
        implements com.google.android.gms.appstate.AppStateManager.StateDeletedResult
    {

        final dl vk;
        private final Status vl;
        private final int vm;

        public void a(Object obj)
        {
            c((com.google.android.gms.common.api.a.c)obj);
        }

        public void c(com.google.android.gms.common.api.a.c c1)
        {
            c1.b(this);
        }

        protected void cP()
        {
        }

        public int getStateKey()
        {
            return vm;
        }

        public Status getStatus()
        {
            return vl;
        }

        public b(com.google.android.gms.common.api.a.c c1, Status status, int i)
        {
            vk = dl.this;
            super(dl.this, c1);
            vl = status;
            vm = i;
        }
    }

    final class c extends dk
    {

        private final com.google.android.gms.common.api.a.c vj;
        final dl vk;

        public void a(DataHolder dataholder)
        {
            Status status = new Status(dataholder.getStatusCode());
            vk.a(vk. new d(vj, status, dataholder));
        }

        public c(com.google.android.gms.common.api.a.c c1)
        {
            vk = dl.this;
            super();
            vj = (com.google.android.gms.common.api.a.c)er.b(c1, "Result holder must not be null");
        }
    }

    final class d extends eh.d
        implements com.google.android.gms.appstate.AppStateManager.StateListResult
    {

        final dl vk;
        private final Status vl;
        private final AppStateBuffer vn;

        public void a(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            c1.b(this);
        }

        public volatile void a(Object obj, DataHolder dataholder)
        {
            a((com.google.android.gms.common.api.a.c)obj, dataholder);
        }

        public AppStateBuffer getStateBuffer()
        {
            return vn;
        }

        public Status getStatus()
        {
            return vl;
        }

        public d(com.google.android.gms.common.api.a.c c1, Status status, DataHolder dataholder)
        {
            vk = dl.this;
            super(dl.this, c1, dataholder);
            vl = status;
            vn = new AppStateBuffer(dataholder);
        }
    }

    final class e extends dk
    {

        private final com.google.android.gms.common.api.a.c vj;
        final dl vk;

        public void a(int i, DataHolder dataholder)
        {
            vk.a(vk. new f(vj, i, dataholder));
        }

        public e(com.google.android.gms.common.api.a.c c1)
        {
            vk = dl.this;
            super();
            vj = (com.google.android.gms.common.api.a.c)er.b(c1, "Result holder must not be null");
        }
    }

    final class f extends eh.d
        implements com.google.android.gms.appstate.AppStateManager.StateConflictResult, com.google.android.gms.appstate.AppStateManager.StateLoadedResult, com.google.android.gms.appstate.AppStateManager.StateResult
    {

        final dl vk;
        private final Status vl;
        private final int vm;
        private final AppStateBuffer vn;

        private boolean cQ()
        {
            return vl.getStatusCode() == 2000;
        }

        public void a(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            c1.b(this);
        }

        public volatile void a(Object obj, DataHolder dataholder)
        {
            a((com.google.android.gms.common.api.a.c)obj, dataholder);
        }

        public com.google.android.gms.appstate.AppStateManager.StateConflictResult getConflictResult()
        {
            if (cQ())
            {
                return this;
            } else
            {
                return null;
            }
        }

        public com.google.android.gms.appstate.AppStateManager.StateLoadedResult getLoadedResult()
        {
            f f1 = this;
            if (cQ())
            {
                f1 = null;
            }
            return f1;
        }

        public byte[] getLocalData()
        {
            if (vn.getCount() == 0)
            {
                return null;
            } else
            {
                return vn.get(0).getLocalData();
            }
        }

        public String getResolvedVersion()
        {
            if (vn.getCount() == 0)
            {
                return null;
            } else
            {
                return vn.get(0).getConflictVersion();
            }
        }

        public byte[] getServerData()
        {
            if (vn.getCount() == 0)
            {
                return null;
            } else
            {
                return vn.get(0).getConflictData();
            }
        }

        public int getStateKey()
        {
            return vm;
        }

        public Status getStatus()
        {
            return vl;
        }

        public void release()
        {
            vn.close();
        }

        public f(com.google.android.gms.common.api.a.c c1, int i, DataHolder dataholder)
        {
            vk = dl.this;
            super(dl.this, c1, dataholder);
            vm = i;
            vl = new Status(dataholder.getStatusCode());
            vn = new AppStateBuffer(dataholder);
        }
    }

    final class g extends dk
    {

        com.google.android.gms.common.api.a.c vj;
        final dl vk;

        public void cM()
        {
            Status status = new Status(0);
            vk.a(vk. new h(vj, status));
        }

        public g(com.google.android.gms.common.api.a.c c1)
        {
            vk = dl.this;
            super();
            vj = (com.google.android.gms.common.api.a.c)er.b(c1, "Holder must not be null");
        }
    }

    final class h extends eh.b
    {

        final dl vk;
        private final Status vl;

        public void a(Object obj)
        {
            c((com.google.android.gms.common.api.a.c)obj);
        }

        public void c(com.google.android.gms.common.api.a.c c1)
        {
            c1.b(vl);
        }

        protected void cP()
        {
        }

        public h(com.google.android.gms.common.api.a.c c1, Status status)
        {
            vk = dl.this;
            super(dl.this, c1);
            vl = status;
        }
    }


    private final String vi;

    public dl(Context context, Looper looper, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, String s1, String as[])
    {
        super(context, looper, connectioncallbacks, onconnectionfailedlistener, as);
        vi = (String)er.f(s1);
    }

    public void a(com.google.android.gms.common.api.a.c c1)
    {
        try
        {
            ((dn)eb()).a(new c(c1));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            Log.w("AppStateClient", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.c c1, int i)
    {
        try
        {
            ((dn)eb()).b(new a(c1), i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            Log.w("AppStateClient", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.c c1, int i, String s1, byte abyte0[])
    {
        try
        {
            ((dn)eb()).a(new e(c1), i, s1, abyte0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            Log.w("AppStateClient", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.c c1, int i, byte abyte0[])
    {
        if (c1 != null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        c1 = null;
_L1:
        try
        {
            ((dn)eb()).a(c1, i, abyte0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            Log.w("AppStateClient", "service died");
        }
        break MISSING_BLOCK_LABEL_44;
        c1 = new e(c1);
          goto _L1
    }

    protected void a(en en1, eh.e e1)
        throws RemoteException
    {
        en1.a(e1, 0x41f6b8, getContext().getPackageName(), vi, ea());
    }

    protected String aF()
    {
        return "com.google.android.gms.appstate.service.START";
    }

    protected String aG()
    {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }

    public void b(com.google.android.gms.common.api.a.c c1)
    {
        try
        {
            ((dn)eb()).b(new g(c1));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            Log.w("AppStateClient", "service died");
        }
    }

    public void b(com.google.android.gms.common.api.a.c c1, int i)
    {
        try
        {
            ((dn)eb()).a(new e(c1), i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            Log.w("AppStateClient", "service died");
        }
    }

    protected transient void b(String as[])
    {
        int i = 0;
        boolean flag = false;
        for (; i < as.length; i++)
        {
            if (as[i].equals("https://www.googleapis.com/auth/appstate"))
            {
                flag = true;
            }
        }

        er.a(flag, String.format("App State APIs requires %s to function.", new Object[] {
            "https://www.googleapis.com/auth/appstate"
        }));
    }

    public int cN()
    {
        int i;
        try
        {
            i = ((dn)eb()).cN();
        }
        catch (RemoteException remoteexception)
        {
            Log.w("AppStateClient", "service died");
            return 2;
        }
        return i;
    }

    public int cO()
    {
        int i;
        try
        {
            i = ((dn)eb()).cO();
        }
        catch (RemoteException remoteexception)
        {
            Log.w("AppStateClient", "service died");
            return 2;
        }
        return i;
    }

    protected IInterface p(IBinder ibinder)
    {
        return s(ibinder);
    }

    protected dn s(IBinder ibinder)
    {
        return dn.a.u(ibinder);
    }
}
