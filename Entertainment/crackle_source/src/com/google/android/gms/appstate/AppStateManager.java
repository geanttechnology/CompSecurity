// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appstate;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.dc;
import com.google.android.gms.internal.dt;
import com.google.android.gms.internal.eg;
import java.util.List;

// Referenced classes of package com.google.android.gms.appstate:
//            AppStateBuffer

public final class AppStateManager
{
    public static interface StateConflictResult
        extends Result
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
        extends Result
    {

        public abstract byte[] getLocalData();

        public abstract int getStateKey();
    }

    public static interface StateResult
        extends Result
    {

        public abstract StateConflictResult getConflictResult();

        public abstract StateLoadedResult getLoadedResult();
    }

    public static abstract class a extends com.google.android.gms.common.api.a.a
        implements PendingResult
    {

        public a()
        {
            super(AppStateManager.jO);
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

        public Result e(Status status)
        {
            return f(status);
        }

        public StateListResult f(Status status)
        {
            return new StateListResult(this, status) {

                final Status jP;
                final c jV;

                public AppStateBuffer getStateBuffer()
                {
                    return new AppStateBuffer(null);
                }

                public Status getStatus()
                {
                    return jP;
                }

            
            {
                jV = c1;
                jP = status;
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

        public Result e(Status status)
        {
            return g(status);
        }

        public Status g(Status status)
        {
            return status;
        }

        private d()
        {
        }

    }

    private static abstract class e extends a
    {

        public Result e(Status status)
        {
            return h(status);
        }

        public StateResult h(Status status)
        {
            return AppStateManager.c(status);
        }

        private e()
        {
        }

    }


    public static final Api API;
    public static final Scope SCOPE_APP_STATE;
    static final com.google.android.gms.common.api.Api.b jO;

    private AppStateManager()
    {
    }

    public static dc a(GoogleApiClient googleapiclient)
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
        eg.b(flag, "GoogleApiClient parameter is required.");
        eg.a(googleapiclient.isConnected(), "GoogleApiClient must be connected.");
        googleapiclient = (dc)googleapiclient.a(jO);
        if (googleapiclient != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        eg.a(flag, "GoogleApiClient is not configured to use the AppState API. Pass AppStateManager.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return googleapiclient;
    }

    private static StateResult b(Status status)
    {
        return new StateResult(status) {

            final Status jP;

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
                return jP;
            }

            
            {
                jP = status;
                super();
            }
        };
    }

    static StateResult c(Status status)
    {
        return b(status);
    }

    public static PendingResult delete(GoogleApiClient googleapiclient, int i)
    {
        return googleapiclient.b(new b(i) {

            final int jQ;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((dc)a1);
            }

            protected void a(dc dc1)
            {
                dc1.a(this, jQ);
            }

            public StateDeletedResult d(Status status)
            {
                return new StateDeletedResult(this, status) {

                    final Status jP;
                    final _cls5 jS;

                    public int getStateKey()
                    {
                        return jS.jQ;
                    }

                    public Status getStatus()
                    {
                        return jP;
                    }

            
            {
                jS = _pcls5;
                jP = status;
                super();
            }
                };
            }

            public Result e(Status status)
            {
                return d(status);
            }

            
            {
                jQ = i;
                super();
            }
        });
    }

    public static int getMaxNumKeys(GoogleApiClient googleapiclient)
    {
        return a(googleapiclient).getMaxNumKeys();
    }

    public static int getMaxStateSize(GoogleApiClient googleapiclient)
    {
        return a(googleapiclient).getMaxStateSize();
    }

    public static PendingResult list(GoogleApiClient googleapiclient)
    {
        return googleapiclient.a(new c() {

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((dc)a1);
            }

            protected void a(dc dc1)
            {
                dc1.a(this);
            }

        });
    }

    public static PendingResult load(GoogleApiClient googleapiclient, int i)
    {
        return googleapiclient.a(new e(i) {

            final int jQ;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((dc)a1);
            }

            protected void a(dc dc1)
            {
                dc1.b(this, jQ);
            }

            
            {
                jQ = i;
                super();
            }
        });
    }

    public static PendingResult resolve(GoogleApiClient googleapiclient, int i, String s, byte abyte0[])
    {
        return googleapiclient.b(new e(i, s, abyte0) {

            final int jQ;
            final String jT;
            final byte jU[];

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((dc)a1);
            }

            protected void a(dc dc1)
            {
                dc1.a(this, jQ, jT, jU);
            }

            
            {
                jQ = i;
                jT = s;
                jU = abyte0;
                super();
            }
        });
    }

    public static PendingResult signOut(GoogleApiClient googleapiclient)
    {
        return googleapiclient.b(new d() {

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((dc)a1);
            }

            protected void a(dc dc1)
            {
                dc1.b(this);
            }

        });
    }

    public static void update(GoogleApiClient googleapiclient, int i, byte abyte0[])
    {
        googleapiclient.b(new e(i, abyte0) {

            final int jQ;
            final byte jR[];

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((dc)a1);
            }

            protected void a(dc dc1)
            {
                dc1.a(null, jQ, jR);
            }

            
            {
                jQ = i;
                jR = abyte0;
                super();
            }
        });
    }

    public static PendingResult updateImmediate(GoogleApiClient googleapiclient, int i, byte abyte0[])
    {
        return googleapiclient.b(new e(i, abyte0) {

            final int jQ;
            final byte jR[];

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((dc)a1);
            }

            protected void a(dc dc1)
            {
                dc1.a(this, jQ, jR);
            }

            
            {
                jQ = i;
                jR = abyte0;
                super();
            }
        });
    }

    static 
    {
        jO = new com.google.android.gms.common.api.Api.b() {

            public dc a(Context context, dt dt1, com.google.android.gms.common.api.GoogleApiClient.ApiOptions apioptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return new dc(context, connectioncallbacks, onconnectionfailedlistener, dt1.bF(), (String[])dt1.bH().toArray(new String[0]));
            }

            public com.google.android.gms.common.api.Api.a b(Context context, dt dt1, com.google.android.gms.common.api.GoogleApiClient.ApiOptions apioptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return a(context, dt1, apioptions, connectioncallbacks, onconnectionfailedlistener);
            }

            public int getPriority()
            {
                return 0x7fffffff;
            }

        };
        SCOPE_APP_STATE = new Scope("https://www.googleapis.com/auth/appstate");
        API = new Api(jO, new Scope[] {
            SCOPE_APP_STATE
        });
    }
}
