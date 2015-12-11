// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.internal.dg;
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
            return googleapiclient.b(new Cast.c(this) {

                final a ko;

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
                super(null);
            }
            });
        }

        public PendingResult joinApplication(GoogleApiClient googleapiclient, String s)
        {
            return googleapiclient.b(new Cast.c(this, s) {

                final a ko;
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
                super(null);
            }
            });
        }

        public PendingResult joinApplication(GoogleApiClient googleapiclient, String s, String s1)
        {
            return googleapiclient.b(new Cast.c(this, s, s1) {

                final a ko;
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
                super(null);
            }
            });
        }

        public PendingResult launchApplication(GoogleApiClient googleapiclient, String s)
        {
            return googleapiclient.b(new Cast.c(this, s) {

                final a ko;
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
                super(null);
            }
            });
        }

        public PendingResult launchApplication(GoogleApiClient googleapiclient, String s, boolean flag)
        {
            return googleapiclient.b(new Cast.c(this, s, flag) {

                final a ko;
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
                super(null);
            }
            });
        }

        public PendingResult leaveApplication(GoogleApiClient googleapiclient)
        {
            return googleapiclient.b(new Cast.b(this) {

                final a ko;

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
                super(null);
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
            return googleapiclient.b(new Cast.b(this, s, s1) {

                final String km;
                final String kn;
                final a ko;

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
                super(null);
            }
            });
        }

        public void setMessageReceivedCallbacks(GoogleApiClient googleapiclient, String s, Cast.MessageReceivedCallback messagereceivedcallback)
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
            return googleapiclient.b(new Cast.b(this) {

                final a ko;

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
                super(null);
            }
            });
        }

        public PendingResult stopApplication(GoogleApiClient googleapiclient, String s)
        {
            return googleapiclient.b(new Cast.b(this, s) {

                final a ko;
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
        throws IOException, IllegalStateException;

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
