// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.internal.dq;
import java.io.IOException;

// Referenced classes of package com.google.android.gms.cast:
//            Cast, ApplicationMetadata

public static final class _cls9.wu
    implements _cls9.wu
{

    public ApplicationMetadata getApplicationMetadata(GoogleApiClient googleapiclient)
        throws IllegalStateException
    {
        return ((dq)googleapiclient.a(Cast.va)).getApplicationMetadata();
    }

    public String getApplicationStatus(GoogleApiClient googleapiclient)
        throws IllegalStateException
    {
        return ((dq)googleapiclient.a(Cast.va)).getApplicationStatus();
    }

    public double getVolume(GoogleApiClient googleapiclient)
        throws IllegalStateException
    {
        return ((dq)googleapiclient.a(Cast.va)).da();
    }

    public boolean isMute(GoogleApiClient googleapiclient)
        throws IllegalStateException
    {
        return ((dq)googleapiclient.a(Cast.va)).isMute();
    }

    public PendingResult joinApplication(GoogleApiClient googleapiclient)
    {
        return googleapiclient.b(new Cast.c() {

            final Cast.CastApi.a wr;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((dq)a1);
            }

            protected void a(dq dq1)
                throws RemoteException
            {
                try
                {
                    dq1.b(null, null, this);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (dq dq1)
                {
                    x(2001);
                }
            }

            
            {
                wr = Cast.CastApi.a.this;
                super(null);
            }
        });
    }

    public PendingResult joinApplication(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.b(new Cast.c(s) {

            final Cast.CastApi.a wr;
            final String ws;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((dq)a1);
            }

            protected void a(dq dq1)
                throws RemoteException
            {
                try
                {
                    dq1.b(ws, null, this);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (dq dq1)
                {
                    x(2001);
                }
            }

            
            {
                wr = Cast.CastApi.a.this;
                ws = s;
                super(null);
            }
        });
    }

    public PendingResult joinApplication(GoogleApiClient googleapiclient, String s, String s1)
    {
        return googleapiclient.b(new Cast.c(s, s1) {

            final Cast.CastApi.a wr;
            final String ws;
            final String wu;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((dq)a1);
            }

            protected void a(dq dq1)
                throws RemoteException
            {
                try
                {
                    dq1.b(ws, wu, this);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (dq dq1)
                {
                    x(2001);
                }
            }

            
            {
                wr = Cast.CastApi.a.this;
                ws = s;
                wu = s1;
                super(null);
            }
        });
    }

    public PendingResult launchApplication(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.b(new Cast.c(s) {

            final Cast.CastApi.a wr;
            final String ws;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((dq)a1);
            }

            protected void a(dq dq1)
                throws RemoteException
            {
                try
                {
                    dq1.a(ws, false, this);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (dq dq1)
                {
                    x(2001);
                }
            }

            
            {
                wr = Cast.CastApi.a.this;
                ws = s;
                super(null);
            }
        });
    }

    public PendingResult launchApplication(GoogleApiClient googleapiclient, String s, boolean flag)
    {
        return googleapiclient.b(new Cast.c(s, flag) {

            final Cast.CastApi.a wr;
            final String ws;
            final boolean wt;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((dq)a1);
            }

            protected void a(dq dq1)
                throws RemoteException
            {
                try
                {
                    dq1.a(ws, wt, this);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (dq dq1)
                {
                    x(2001);
                }
            }

            
            {
                wr = Cast.CastApi.a.this;
                ws = s;
                wt = flag;
                super(null);
            }
        });
    }

    public PendingResult leaveApplication(GoogleApiClient googleapiclient)
    {
        return googleapiclient.b(new Cast.b() {

            final Cast.CastApi.a wr;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((dq)a1);
            }

            protected void a(dq dq1)
                throws RemoteException
            {
                try
                {
                    dq1.e(this);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (dq dq1)
                {
                    x(2001);
                }
            }

            
            {
                wr = Cast.CastApi.a.this;
                super(null);
            }
        });
    }

    public void removeMessageReceivedCallbacks(GoogleApiClient googleapiclient, String s)
        throws IOException, IllegalArgumentException
    {
        try
        {
            ((dq)googleapiclient.a(Cast.va)).Q(s);
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
            ((dq)googleapiclient.a(Cast.va)).cZ();
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
        return googleapiclient.b(new Cast.b(s, s1) {

            final String wp;
            final String wq;
            final Cast.CastApi.a wr;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((dq)a1);
            }

            protected void a(dq dq1)
                throws RemoteException
            {
                try
                {
                    dq1.a(wp, wq, this);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (dq dq1)
                {
                    x(2001);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (dq dq1)
                {
                    x(2001);
                }
            }

            
            {
                wr = Cast.CastApi.a.this;
                wp = s;
                wq = s1;
                super(null);
            }
        });
    }

    public void setMessageReceivedCallbacks(GoogleApiClient googleapiclient, String s, eivedCallback eivedcallback)
        throws IOException, IllegalStateException
    {
        try
        {
            ((dq)googleapiclient.a(Cast.va)).a(s, eivedcallback);
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
            ((dq)googleapiclient.a(Cast.va)).t(flag);
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
            ((dq)googleapiclient.a(Cast.va)).a(d);
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
        return googleapiclient.b(new Cast.b() {

            final Cast.CastApi.a wr;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((dq)a1);
            }

            protected void a(dq dq1)
                throws RemoteException
            {
                try
                {
                    dq1.a("", this);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (dq dq1)
                {
                    x(2001);
                }
            }

            
            {
                wr = Cast.CastApi.a.this;
                super(null);
            }
        });
    }

    public PendingResult stopApplication(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.b(new Cast.b(s) {

            final Cast.CastApi.a wr;
            final String wu;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((dq)a1);
            }

            protected void a(dq dq1)
                throws RemoteException
            {
                if (TextUtils.isEmpty(wu))
                {
                    c(2001, "IllegalArgument: sessionId cannot be null or empty");
                    return;
                }
                try
                {
                    dq1.a(wu, this);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (dq dq1)
                {
                    x(2001);
                }
            }

            
            {
                wr = Cast.CastApi.a.this;
                wu = s;
                super(null);
            }
        });
    }

    public _cls9.wu()
    {
    }
}
