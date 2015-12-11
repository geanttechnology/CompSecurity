// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appstate;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.dl;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.er;
import java.util.List;

// Referenced classes of package com.google.android.gms.appstate:
//            AppStateBuffer

public final class AppStateManager
{
    public static interface StateConflictResult
        extends Releasable, Result
    {

        public abstract byte[] getLocalData();

        public abstract String getResolvedVersion();

        public abstract byte[] getServerData();

        public abstract int getStateKey();
    }

    public static interface StateDeletedResult
        extends Result
    {

        public abstract int getStateKey();
    }

    public static interface StateListResult
        extends Result
    {

        public abstract AppStateBuffer getStateBuffer();
    }

    public static interface StateLoadedResult
        extends Releasable, Result
    {

        public abstract byte[] getLocalData();

        public abstract int getStateKey();
    }

    public static interface StateResult
        extends Releasable, Result
    {

        public abstract StateConflictResult getConflictResult();

        public abstract StateLoadedResult getLoadedResult();
    }

    public static abstract class a extends com.google.android.gms.common.api.a.a
        implements PendingResult
    {

        public a()
        {
            super(AppStateManager.va);
        }
    }

    private static abstract class b extends a
    {

        private b()
        {
        }

    }

    private static abstract class c extends a
    {

        public Result d(Status status)
        {
            return e(status);
        }

        public StateListResult e(Status status)
        {
            return new StateListResult(this, status) {

                final Status vb;
                final c vh;

                public AppStateBuffer getStateBuffer()
                {
                    return new AppStateBuffer(null);
                }

                public Status getStatus()
                {
                    return vb;
                }

            
            {
                vh = c1;
                vb = status;
                super();
            }
            };
        }

        private c()
        {
        }

    }

    private static abstract class d extends a
    {

        public Result d(Status status)
        {
            return f(status);
        }

        public Status f(Status status)
        {
            return status;
        }

        private d()
        {
        }

    }

    private static abstract class e extends a
    {

        public Result d(Status status)
        {
            return g(status);
        }

        public StateResult g(Status status)
        {
            return AppStateManager.b(status);
        }

        private e()
        {
        }

    }


    public static final Api API;
    public static final Scope SCOPE_APP_STATE;
    static final com.google.android.gms.common.api.Api.b va;

    private AppStateManager()
    {
    }

    private static StateResult a(Status status)
    {
        return new StateResult(status) {

            final Status vb;

            public StateConflictResult getConflictResult()
            {
                return null;
            }

            public StateLoadedResult getLoadedResult()
            {
                return null;
            }

            public Status getStatus()
            {
                return vb;
            }

            public void release()
            {
            }

            
            {
                vb = status;
                super();
            }
        };
    }

    public static dl a(GoogleApiClient googleapiclient)
    {
        boolean flag1 = true;
        boolean flag;
        if (googleapiclient != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        er.b(flag, "GoogleApiClient parameter is required.");
        er.a(googleapiclient.isConnected(), "GoogleApiClient must be connected.");
        googleapiclient = (dl)googleapiclient.a(va);
        if (googleapiclient != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        er.a(flag, "GoogleApiClient is not configured to use the AppState API. Pass AppStateManager.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return googleapiclient;
    }

    static StateResult b(Status status)
    {
        return a(status);
    }

    public static PendingResult delete(GoogleApiClient googleapiclient, int i)
    {
        return googleapiclient.b(new b(i) {

            final int vc;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((dl)a1);
            }

            protected void a(dl dl1)
            {
                dl1.a(this, vc);
            }

            public StateDeletedResult c(Status status)
            {
                return new StateDeletedResult(this, status) {

                    final Status vb;
                    final _cls5 ve;

                    public int getStateKey()
                    {
                        return ve.vc;
                    }

                    public Status getStatus()
                    {
                        return vb;
                    }

            
            {
                ve = _pcls5;
                vb = status;
                super();
            }
                };
            }

            public Result d(Status status)
            {
                return c(status);
            }

            
            {
                vc = i;
                super();
            }
        });
    }

    public static int getMaxNumKeys(GoogleApiClient googleapiclient)
    {
        return a(googleapiclient).cO();
    }

    public static int getMaxStateSize(GoogleApiClient googleapiclient)
    {
        return a(googleapiclient).cN();
    }

    public static PendingResult list(GoogleApiClient googleapiclient)
    {
        return googleapiclient.a(new c() {

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((dl)a1);
            }

            protected void a(dl dl1)
            {
                dl1.a(this);
            }

        });
    }

    public static PendingResult load(GoogleApiClient googleapiclient, int i)
    {
        return googleapiclient.a(new e(i) {

            final int vc;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((dl)a1);
            }

            protected void a(dl dl1)
            {
                dl1.b(this, vc);
            }

            
            {
                vc = i;
                super();
            }
        });
    }

    public static PendingResult resolve(GoogleApiClient googleapiclient, int i, String s, byte abyte0[])
    {
        return googleapiclient.b(new e(i, s, abyte0) {

            final int vc;
            final String vf;
            final byte vg[];

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((dl)a1);
            }

            protected void a(dl dl1)
            {
                dl1.a(this, vc, vf, vg);
            }

            
            {
                vc = i;
                vf = s;
                vg = abyte0;
                super();
            }
        });
    }

    public static PendingResult signOut(GoogleApiClient googleapiclient)
    {
        return googleapiclient.b(new d() {

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((dl)a1);
            }

            protected void a(dl dl1)
            {
                dl1.b(this);
            }

        });
    }

    public static void update(GoogleApiClient googleapiclient, int i, byte abyte0[])
    {
        googleapiclient.b(new e(i, abyte0) {

            final int vc;
            final byte vd[];

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((dl)a1);
            }

            protected void a(dl dl1)
            {
                dl1.a(null, vc, vd);
            }

            
            {
                vc = i;
                vd = abyte0;
                super();
            }
        });
    }

    public static PendingResult updateImmediate(GoogleApiClient googleapiclient, int i, byte abyte0[])
    {
        return googleapiclient.b(new e(i, abyte0) {

            final int vc;
            final byte vd[];

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((dl)a1);
            }

            protected void a(dl dl1)
            {
                dl1.a(this, vc, vd);
            }

            
            {
                vc = i;
                vd = abyte0;
                super();
            }
        });
    }

    static 
    {
        va = new com.google.android.gms.common.api.Api.b() {

            public dl a(Context context, Looper looper, ee ee1, com.google.android.gms.common.api.GoogleApiClient.ApiOptions apioptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return new dl(context, looper, connectioncallbacks, onconnectionfailedlistener, ee1.dR(), (String[])ee1.dT().toArray(new String[0]));
            }

            public com.google.android.gms.common.api.Api.a b(Context context, Looper looper, ee ee1, com.google.android.gms.common.api.GoogleApiClient.ApiOptions apioptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return a(context, looper, ee1, apioptions, connectioncallbacks, onconnectionfailedlistener);
            }

            public int getPriority()
            {
                return 0x7fffffff;
            }

        };
        SCOPE_APP_STATE = new Scope("https://www.googleapis.com/auth/appstate");
        API = new Api(va, new Scope[] {
            SCOPE_APP_STATE
        });
    }
}
