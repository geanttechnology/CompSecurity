// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppState;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

// Referenced classes of package com.google.android.gms.internal:
//            dw, eg, de, ec, 
//            db

public final class dc extends dw
{
    final class a extends db
    {

        private final com.google.android.gms.common.api.a.c jW;
        final dc jX;

        public void onStateDeleted(int i, int j)
        {
            Status status = new Status(i);
            jX.a(jX. new b(jW, status, j));
        }

        public a(com.google.android.gms.common.api.a.c c1)
        {
            jX = dc.this;
            super();
            jW = (com.google.android.gms.common.api.a.c)eg.b(c1, "Result holder must not be null");
        }
    }

    final class b extends dw.b
        implements com.google.android.gms.appstate.AppStateManager.StateDeletedResult
    {

        final dc jX;
        private final Status jY;
        private final int jZ;

        protected void aL()
        {
        }

        public void b(Object obj)
        {
            c((com.google.android.gms.common.api.a.c)obj);
        }

        public void c(com.google.android.gms.common.api.a.c c1)
        {
            c1.a(this);
        }

        public int getStateKey()
        {
            return jZ;
        }

        public Status getStatus()
        {
            return jY;
        }

        public b(com.google.android.gms.common.api.a.c c1, Status status, int i)
        {
            jX = dc.this;
            super(dc.this, c1);
            jY = status;
            jZ = i;
        }
    }

    final class c extends db
    {

        private final com.google.android.gms.common.api.a.c jW;
        final dc jX;

        public void a(DataHolder dataholder)
        {
            Status status = new Status(dataholder.getStatusCode());
            jX.a(jX. new d(jW, status, dataholder));
        }

        public c(com.google.android.gms.common.api.a.c c1)
        {
            jX = dc.this;
            super();
            jW = (com.google.android.gms.common.api.a.c)eg.b(c1, "Result holder must not be null");
        }
    }

    final class d extends dw.d
        implements com.google.android.gms.appstate.AppStateManager.StateListResult
    {

        final dc jX;
        private final Status jY;
        private final AppStateBuffer ka;

        public void a(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            c1.a(this);
        }

        public volatile void a(Object obj, DataHolder dataholder)
        {
            a((com.google.android.gms.common.api.a.c)obj, dataholder);
        }

        public AppStateBuffer getStateBuffer()
        {
            return ka;
        }

        public Status getStatus()
        {
            return jY;
        }

        public d(com.google.android.gms.common.api.a.c c1, Status status, DataHolder dataholder)
        {
            jX = dc.this;
            super(dc.this, c1, dataholder);
            jY = status;
            ka = new AppStateBuffer(dataholder);
        }
    }

    final class e extends db
    {

        private final com.google.android.gms.common.api.a.c jW;
        final dc jX;

        public void a(int i, DataHolder dataholder)
        {
            jX.a(jX. new f(jW, i, dataholder));
        }

        public e(com.google.android.gms.common.api.a.c c1)
        {
            jX = dc.this;
            super();
            jW = (com.google.android.gms.common.api.a.c)eg.b(c1, "Result holder must not be null");
        }
    }

    final class f extends dw.d
        implements com.google.android.gms.appstate.AppStateManager.StateConflictResult, com.google.android.gms.appstate.AppStateManager.StateLoadedResult, com.google.android.gms.appstate.AppStateManager.StateResult
    {

        final dc jX;
        private final Status jY;
        private final int jZ;
        private final AppStateBuffer ka;

        private boolean aM()
        {
            return jY.getStatusCode() == 2000;
        }

        public void a(com.google.android.gms.common.api.a.c c1, DataHolder dataholder)
        {
            c1.a(this);
        }

        public volatile void a(Object obj, DataHolder dataholder)
        {
            a((com.google.android.gms.common.api.a.c)obj, dataholder);
        }

        public com.google.android.gms.appstate.AppStateManager.StateConflictResult getConflictResult()
        {
            if (aM())
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
            if (aM())
            {
                f1 = null;
            }
            return f1;
        }

        public byte[] getLocalData()
        {
            if (ka.getCount() == 0)
            {
                return null;
            } else
            {
                return ka.get(0).getLocalData();
            }
        }

        public String getResolvedVersion()
        {
            if (ka.getCount() == 0)
            {
                return null;
            } else
            {
                return ka.get(0).getConflictVersion();
            }
        }

        public byte[] getServerData()
        {
            if (ka.getCount() == 0)
            {
                return null;
            } else
            {
                return ka.get(0).getConflictData();
            }
        }

        public int getStateKey()
        {
            return jZ;
        }

        public Status getStatus()
        {
            return jY;
        }

        public f(com.google.android.gms.common.api.a.c c1, int i, DataHolder dataholder)
        {
            jX = dc.this;
            super(dc.this, c1, dataholder);
            jZ = i;
            jY = new Status(dataholder.getStatusCode());
            ka = new AppStateBuffer(dataholder);
        }
    }

    final class g extends db
    {

        com.google.android.gms.common.api.a.c jW;
        final dc jX;

        public void onSignOutComplete()
        {
            Status status = new Status(0);
            jX.a(jX. new h(jW, status));
        }

        public g(com.google.android.gms.common.api.a.c c1)
        {
            jX = dc.this;
            super();
            jW = (com.google.android.gms.common.api.a.c)eg.b(c1, "Holder must not be null");
        }
    }

    final class h extends dw.b
    {

        final dc jX;
        private final Status jY;

        protected void aL()
        {
        }

        public void b(Object obj)
        {
            c((com.google.android.gms.common.api.a.c)obj);
        }

        public void c(com.google.android.gms.common.api.a.c c1)
        {
            c1.a(jY);
        }

        public h(com.google.android.gms.common.api.a.c c1, Status status)
        {
            jX = dc.this;
            super(dc.this, c1);
            jY = status;
        }
    }


    private final String jG;

    public dc(Context context, com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener, String s, String as[])
    {
        this(context, ((com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks) (new dw.c(connectioncallbacks))), ((com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener) (new dw.g(onconnectionfailedlistener))), s, as);
    }

    public dc(Context context, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, String s, String as[])
    {
        super(context, connectioncallbacks, onconnectionfailedlistener, as);
        jG = (String)eg.f(s);
    }

    public void a(com.google.android.gms.common.api.a.c c1)
    {
        try
        {
            ((de)bQ()).a(new c(c1));
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
            ((de)bQ()).b(new a(c1), i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            Log.w("AppStateClient", "service died");
        }
    }

    public void a(com.google.android.gms.common.api.a.c c1, int i, String s, byte abyte0[])
    {
        try
        {
            ((de)bQ()).a(new e(c1), i, s, abyte0);
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
            ((de)bQ()).a(c1, i, abyte0);
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

    protected void a(ec ec1, dw.e e1)
        throws RemoteException
    {
        ec1.a(e1, 0x40ba50, getContext().getPackageName(), jG, bO());
    }

    protected transient void a(String as[])
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

        eg.a(flag, String.format("App State APIs requires %s to function.", new Object[] {
            "https://www.googleapis.com/auth/appstate"
        }));
    }

    protected String am()
    {
        return "com.google.android.gms.appstate.service.START";
    }

    protected String an()
    {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }

    public void b(com.google.android.gms.common.api.a.c c1)
    {
        try
        {
            ((de)bQ()).b(new g(c1));
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
            ((de)bQ()).a(new e(c1), i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.common.api.a.c c1)
        {
            Log.w("AppStateClient", "service died");
        }
    }

    public int getMaxNumKeys()
    {
        int i;
        try
        {
            i = ((de)bQ()).getMaxNumKeys();
        }
        catch (RemoteException remoteexception)
        {
            Log.w("AppStateClient", "service died");
            return 2;
        }
        return i;
    }

    public int getMaxStateSize()
    {
        int i;
        try
        {
            i = ((de)bQ()).getMaxStateSize();
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
        return r(ibinder);
    }

    protected de r(IBinder ibinder)
    {
        return de.a.t(ibinder);
    }
}
