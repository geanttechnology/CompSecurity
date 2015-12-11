// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.dg;
import com.google.android.gms.internal.dt;
import com.google.android.gms.internal.eg;
import java.io.IOException;

// Referenced classes of package com.google.android.gms.cast:
//            ApplicationMetadata, CastDevice

public final class Cast
{
    public static interface ApplicationConnectionResult
        extends Result
    {

        public abstract ApplicationMetadata getApplicationMetadata();

        public abstract String getApplicationStatus();

        public abstract String getSessionId();

        public abstract boolean getWasLaunched();
    }

    public static interface CastApi
    {

        public abstract ApplicationMetadata getApplicationMetadata(GoogleApiClient googleapiclient)
            throws IllegalStateException;

        public abstract String getApplicationStatus(GoogleApiClient googleapiclient)
            throws IllegalStateException;

        public abstract double getVolume(GoogleApiClient googleapiclient)
            throws IllegalStateException;

        public abstract boolean isMute(GoogleApiClient googleapiclient)
            throws IllegalStateException;

        public abstract PendingResult joinApplication(GoogleApiClient googleapiclient);

        public abstract PendingResult joinApplication(GoogleApiClient googleapiclient, String s);

        public abstract PendingResult joinApplication(GoogleApiClient googleapiclient, String s, String s1);

        public abstract PendingResult launchApplication(GoogleApiClient googleapiclient, String s);

        public abstract PendingResult launchApplication(GoogleApiClient googleapiclient, String s, boolean flag);

        public abstract PendingResult leaveApplication(GoogleApiClient googleapiclient);

        public abstract void removeMessageReceivedCallbacks(GoogleApiClient googleapiclient, String s)
            throws IOException, IllegalStateException;

        public abstract void requestStatus(GoogleApiClient googleapiclient)
            throws IOException, IllegalStateException;

        public abstract PendingResult sendMessage(GoogleApiClient googleapiclient, String s, String s1);

        public abstract void setMessageReceivedCallbacks(GoogleApiClient googleapiclient, String s, MessageReceivedCallback messagereceivedcallback)
            throws IOException, IllegalStateException;

        public abstract void setMute(GoogleApiClient googleapiclient, boolean flag)
            throws IOException, IllegalStateException;

        public abstract void setVolume(GoogleApiClient googleapiclient, double d)
            throws IOException, IllegalArgumentException, IllegalStateException;

        public abstract PendingResult stopApplication(GoogleApiClient googleapiclient);

        public abstract PendingResult stopApplication(GoogleApiClient googleapiclient, String s);
    }

    public static final class CastApi.a
        implements CastApi
    {

        public ApplicationMetadata getApplicationMetadata(GoogleApiClient googleapiclient)
            throws IllegalStateException
        {
            return ((dg)googleapiclient.a(Cast.jO)).getApplicationMetadata();
        }

        public String getApplicationStatus(GoogleApiClient googleapiclient)
            throws IllegalStateException
        {
            return ((dg)googleapiclient.a(Cast.jO)).getApplicationStatus();
        }

        public double getVolume(GoogleApiClient googleapiclient)
            throws IllegalStateException
        {
            return ((dg)googleapiclient.a(Cast.jO)).aW();
        }

        public boolean isMute(GoogleApiClient googleapiclient)
            throws IllegalStateException
        {
            return ((dg)googleapiclient.a(Cast.jO)).isMute();
        }

        public PendingResult joinApplication(GoogleApiClient googleapiclient)
        {
            return googleapiclient.b(new c(this) {

                final CastApi.a ko;

                protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                {
                    a((dg)a1);
                }

                protected void a(dg dg1)
                {
                    try
                    {
                        dg1.b(null, null, this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (dg dg1)
                    {
                        r(2001);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (dg dg1)
                    {
                        r(8);
                    }
                }

            
            {
                ko = a1;
                super();
            }
            });
        }

        public PendingResult joinApplication(GoogleApiClient googleapiclient, String s)
        {
            return googleapiclient.b(new c(this, s) {

                final CastApi.a ko;
                final String kp;

                protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                {
                    a((dg)a1);
                }

                protected void a(dg dg1)
                {
                    try
                    {
                        dg1.b(kp, null, this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (dg dg1)
                    {
                        r(2001);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (dg dg1)
                    {
                        r(8);
                    }
                }

            
            {
                ko = a1;
                kp = s;
                super();
            }
            });
        }

        public PendingResult joinApplication(GoogleApiClient googleapiclient, String s, String s1)
        {
            return googleapiclient.b(new c(this, s, s1) {

                final CastApi.a ko;
                final String kp;
                final String kr;

                protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                {
                    a((dg)a1);
                }

                protected void a(dg dg1)
                {
                    try
                    {
                        dg1.b(kp, kr, this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (dg dg1)
                    {
                        r(2001);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (dg dg1)
                    {
                        r(8);
                    }
                }

            
            {
                ko = a1;
                kp = s;
                kr = s1;
                super();
            }
            });
        }

        public PendingResult launchApplication(GoogleApiClient googleapiclient, String s)
        {
            return googleapiclient.b(new c(this, s) {

                final CastApi.a ko;
                final String kp;

                protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                {
                    a((dg)a1);
                }

                protected void a(dg dg1)
                {
                    try
                    {
                        dg1.a(kp, false, this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (dg dg1)
                    {
                        r(2001);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (dg dg1)
                    {
                        r(8);
                    }
                }

            
            {
                ko = a1;
                kp = s;
                super();
            }
            });
        }

        public PendingResult launchApplication(GoogleApiClient googleapiclient, String s, boolean flag)
        {
            return googleapiclient.b(new c(this, s, flag) {

                final CastApi.a ko;
                final String kp;
                final boolean kq;

                protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                {
                    a((dg)a1);
                }

                protected void a(dg dg1)
                {
                    try
                    {
                        dg1.a(kp, kq, this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (dg dg1)
                    {
                        r(2001);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (dg dg1)
                    {
                        r(8);
                    }
                }

            
            {
                ko = a1;
                kp = s;
                kq = flag;
                super();
            }
            });
        }

        public PendingResult leaveApplication(GoogleApiClient googleapiclient)
        {
            return googleapiclient.b(new b(this) {

                final CastApi.a ko;

                protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                {
                    a((dg)a1);
                }

                protected void a(dg dg1)
                {
                    try
                    {
                        dg1.e(this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (dg dg1)
                    {
                        r(2001);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (dg dg1)
                    {
                        r(8);
                    }
                }

            
            {
                ko = a1;
                super();
            }
            });
        }

        public void removeMessageReceivedCallbacks(GoogleApiClient googleapiclient, String s)
            throws IOException, IllegalStateException
        {
            try
            {
                ((dg)googleapiclient.a(Cast.jO)).C(s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (GoogleApiClient googleapiclient)
            {
                throw new IOException("service error");
            }
        }

        public void requestStatus(GoogleApiClient googleapiclient)
            throws IOException, IllegalStateException
        {
            try
            {
                ((dg)googleapiclient.a(Cast.jO)).aV();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (GoogleApiClient googleapiclient)
            {
                throw new IOException("service error");
            }
        }

        public PendingResult sendMessage(GoogleApiClient googleapiclient, String s, String s1)
        {
            return googleapiclient.b(new b(this, s, s1) {

                final String km;
                final String kn;
                final CastApi.a ko;

                protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                {
                    a((dg)a1);
                }

                protected void a(dg dg1)
                {
                    try
                    {
                        dg1.a(km, kn, this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (dg dg1)
                    {
                        r(2001);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (dg dg1)
                    {
                        r(2001);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (dg dg1)
                    {
                        r(8);
                    }
                }

            
            {
                ko = a1;
                km = s;
                kn = s1;
                super();
            }
            });
        }

        public void setMessageReceivedCallbacks(GoogleApiClient googleapiclient, String s, MessageReceivedCallback messagereceivedcallback)
            throws IOException, IllegalStateException
        {
            try
            {
                ((dg)googleapiclient.a(Cast.jO)).a(s, messagereceivedcallback);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (GoogleApiClient googleapiclient)
            {
                throw new IOException("service error");
            }
        }

        public void setMute(GoogleApiClient googleapiclient, boolean flag)
            throws IOException, IllegalStateException
        {
            try
            {
                ((dg)googleapiclient.a(Cast.jO)).n(flag);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (GoogleApiClient googleapiclient)
            {
                throw new IOException("service error");
            }
        }

        public void setVolume(GoogleApiClient googleapiclient, double d)
            throws IOException, IllegalArgumentException, IllegalStateException
        {
            try
            {
                ((dg)googleapiclient.a(Cast.jO)).a(d);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (GoogleApiClient googleapiclient)
            {
                throw new IOException("service error");
            }
        }

        public PendingResult stopApplication(GoogleApiClient googleapiclient)
        {
            return googleapiclient.b(new b(this) {

                final CastApi.a ko;

                protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                {
                    a((dg)a1);
                }

                protected void a(dg dg1)
                {
                    try
                    {
                        dg1.a("", this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (dg dg1)
                    {
                        r(2001);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (dg dg1)
                    {
                        r(8);
                    }
                }

            
            {
                ko = a1;
                super();
            }
            });
        }

        public PendingResult stopApplication(GoogleApiClient googleapiclient, String s)
        {
            return googleapiclient.b(new b(this, s) {

                final CastApi.a ko;
                final String kr;

                protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                {
                    a((dg)a1);
                }

                protected void a(dg dg1)
                {
                    if (TextUtils.isEmpty(kr))
                    {
                        c(2001, "IllegalArgument: sessionId cannot be null or empty");
                        return;
                    }
                    try
                    {
                        dg1.a(kr, this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (dg dg1)
                    {
                        r(2001);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (dg dg1)
                    {
                        r(8);
                    }
                }

            
            {
                ko = a1;
                kr = s;
                super();
            }
            });
        }

        public CastApi.a()
        {
        }
    }

    public static final class CastOptions
        implements com.google.android.gms.common.api.GoogleApiClient.ApiOptions
    {

        final CastDevice ks;
        final Listener kt;
        private final int ku;

        static int a(CastOptions castoptions)
        {
            return castoptions.ku;
        }

        public static Builder builder(CastDevice castdevice, Listener listener)
        {
            return new Builder(castdevice, listener);
        }

        private CastOptions(Builder builder1)
        {
            ks = builder1.kv;
            kt = builder1.kw;
            ku = Builder.a(builder1);
        }

    }

    public static final class CastOptions.Builder
    {

        CastDevice kv;
        Listener kw;
        private int kx;

        static int a(CastOptions.Builder builder)
        {
            return builder.kx;
        }

        public CastOptions build()
        {
            return new CastOptions(this);
        }

        public CastOptions.Builder setDebuggingEnabled()
        {
            kx = kx | 1;
            return this;
        }

        private CastOptions.Builder(CastDevice castdevice, Listener listener)
        {
            kv = castdevice;
            kw = listener;
            kx = 0;
        }

    }

    public static abstract class Listener
    {

        public void onApplicationDisconnected(int i)
        {
        }

        public void onApplicationStatusChanged()
        {
        }

        public void onVolumeChanged()
        {
        }

        public Listener()
        {
        }
    }

    public static interface MessageReceivedCallback
    {

        public abstract void onMessageReceived(CastDevice castdevice, String s, String s1);
    }

    protected static abstract class a extends com.google.android.gms.common.api.a.a
        implements PendingResult
    {

        public void c(int i, String s)
        {
            a(e(new Status(i, s, null)));
        }

        public void r(int i)
        {
            a(e(new Status(i)));
        }

        public a()
        {
            super(Cast.jO);
        }
    }

    private static abstract class b extends a
    {

        public Result e(Status status)
        {
            return g(status);
        }

        public Status g(Status status)
        {
            return status;
        }

        private b()
        {
        }

    }

    private static abstract class c extends a
    {

        public Result e(Status status)
        {
            return i(status);
        }

        public ApplicationConnectionResult i(Status status)
        {
            return new ApplicationConnectionResult(this, status) {

                final Status jP;
                final c ky;

                public ApplicationMetadata getApplicationMetadata()
                {
                    return null;
                }

                public String getApplicationStatus()
                {
                    return null;
                }

                public String getSessionId()
                {
                    return null;
                }

                public Status getStatus()
                {
                    return jP;
                }

                public boolean getWasLaunched()
                {
                    return false;
                }

            
            {
                ky = c1;
                jP = status;
                super();
            }
            };
        }

        private c()
        {
        }

    }


    public static final Api API;
    public static final CastApi CastApi = new CastApi.a();
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 0x10000;
    public static final int MAX_NAMESPACE_LENGTH = 128;
    static final com.google.android.gms.common.api.Api.b jO;

    private Cast()
    {
    }

    static 
    {
        jO = new com.google.android.gms.common.api.Api.b() {

            public com.google.android.gms.common.api.Api.a b(Context context, dt dt, com.google.android.gms.common.api.GoogleApiClient.ApiOptions apioptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return c(context, dt, apioptions, connectioncallbacks, onconnectionfailedlistener);
            }

            public dg c(Context context, dt dt, com.google.android.gms.common.api.GoogleApiClient.ApiOptions apioptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                eg.b(apioptions, "Setting the API options is required.");
                eg.b(apioptions instanceof CastOptions, "Must provide valid CastOptions!");
                dt = (CastOptions)apioptions;
                return new dg(context, ((CastOptions) (dt)).ks, CastOptions.a(dt), ((CastOptions) (dt)).kt, connectioncallbacks, onconnectionfailedlistener);
            }

            public int getPriority()
            {
                return 0x7fffffff;
            }

        };
        API = new Api(jO, new Scope[0]);
    }
}
