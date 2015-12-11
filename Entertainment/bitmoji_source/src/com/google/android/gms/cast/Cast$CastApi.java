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

public static interface a
{
    public static final class a
        implements Cast.CastApi
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
            return googleapiclient.b(new Cast.c(this) {

                final a wr;

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
                wr = a1;
                super(null);
            }
            });
        }

        public PendingResult joinApplication(GoogleApiClient googleapiclient, String s)
        {
            return googleapiclient.b(new Cast.c(this, s) {

                final a wr;
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
                wr = a1;
                ws = s;
                super(null);
            }
            });
        }

        public PendingResult joinApplication(GoogleApiClient googleapiclient, String s, String s1)
        {
            return googleapiclient.b(new Cast.c(this, s, s1) {

                final a wr;
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
                wr = a1;
                ws = s;
                wu = s1;
                super(null);
            }
            });
        }

        public PendingResult launchApplication(GoogleApiClient googleapiclient, String s)
        {
            return googleapiclient.b(new Cast.c(this, s) {

                final a wr;
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
                wr = a1;
                ws = s;
                super(null);
            }
            });
        }

        public PendingResult launchApplication(GoogleApiClient googleapiclient, String s, boolean flag)
        {
            return googleapiclient.b(new Cast.c(this, s, flag) {

                final a wr;
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
                wr = a1;
                ws = s;
                wt = flag;
                super(null);
            }
            });
        }

        public PendingResult leaveApplication(GoogleApiClient googleapiclient)
        {
            return googleapiclient.b(new Cast.b(this) {

                final a wr;

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
                wr = a1;
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
            return googleapiclient.b(new Cast.b(this, s, s1) {

                final String wp;
                final String wq;
                final a wr;

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
                wr = a1;
                wp = s;
                wq = s1;
                super(null);
            }
            });
        }

        public void setMessageReceivedCallbacks(GoogleApiClient googleapiclient, String s, Cast.MessageReceivedCallback messagereceivedcallback)
            throws IOException, IllegalStateException
        {
            try
            {
                ((dq)googleapiclient.a(Cast.va)).a(s, messagereceivedcallback);
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
            return googleapiclient.b(new Cast.b(this) {

                final a wr;

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
                wr = a1;
                super(null);
            }
            });
        }

        public PendingResult stopApplication(GoogleApiClient googleapiclient, String s)
        {
            return googleapiclient.b(new Cast.b(this, s) {

                final a wr;
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
                wr = a1;
                wu = s;
                super(null);
            }
            });
        }

        public a()
        {
        }
    }


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
        throws IOException, IllegalArgumentException;

    public abstract void requestStatus(GoogleApiClient googleapiclient)
        throws IOException, IllegalStateException;

    public abstract PendingResult sendMessage(GoogleApiClient googleapiclient, String s, String s1);

    public abstract void setMessageReceivedCallbacks(GoogleApiClient googleapiclient, String s, eceivedCallback eceivedcallback)
        throws IOException, IllegalStateException;

    public abstract void setMute(GoogleApiClient googleapiclient, boolean flag)
        throws IOException, IllegalStateException;

    public abstract void setVolume(GoogleApiClient googleapiclient, double d)
        throws IOException, IllegalArgumentException, IllegalStateException;

    public abstract PendingResult stopApplication(GoogleApiClient googleapiclient);

    public abstract PendingResult stopApplication(GoogleApiClient googleapiclient, String s);
}
