// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.cast.internal.zzh;
import com.google.android.gms.cast.internal.zzk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import java.io.IOException;

// Referenced classes of package com.google.android.gms.cast:
//            Cast, ApplicationMetadata, LaunchOptions

public static interface zza
{
    public static final class zza
        implements Cast.CastApi
    {

        public int getActiveInputState(GoogleApiClient googleapiclient)
            throws IllegalStateException
        {
            return ((zze)googleapiclient.zza(zzk.zzQf)).zzmz();
        }

        public ApplicationMetadata getApplicationMetadata(GoogleApiClient googleapiclient)
            throws IllegalStateException
        {
            return ((zze)googleapiclient.zza(zzk.zzQf)).getApplicationMetadata();
        }

        public String getApplicationStatus(GoogleApiClient googleapiclient)
            throws IllegalStateException
        {
            return ((zze)googleapiclient.zza(zzk.zzQf)).getApplicationStatus();
        }

        public int getStandbyState(GoogleApiClient googleapiclient)
            throws IllegalStateException
        {
            return ((zze)googleapiclient.zza(zzk.zzQf)).zzmA();
        }

        public double getVolume(GoogleApiClient googleapiclient)
            throws IllegalStateException
        {
            return ((zze)googleapiclient.zza(zzk.zzQf)).zzmy();
        }

        public boolean isMute(GoogleApiClient googleapiclient)
            throws IllegalStateException
        {
            return ((zze)googleapiclient.zza(zzk.zzQf)).isMute();
        }

        public PendingResult joinApplication(GoogleApiClient googleapiclient)
        {
            return googleapiclient.zzb(new Cast.zza(this, googleapiclient) {

                final zza zzTd;

                protected void zza(zze zze1)
                    throws RemoteException
                {
                    try
                    {
                        zze1.zzb(null, null, this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (zze zze1)
                    {
                        zzaT(2001);
                    }
                }

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                    throws RemoteException
                {
                    zza((zze)zzb);
                }

            
            {
                zzTd = zza1;
                super(googleapiclient);
            }
            });
        }

        public PendingResult joinApplication(GoogleApiClient googleapiclient, String s)
        {
            return googleapiclient.zzb(new Cast.zza(this, googleapiclient, s) {

                final zza zzTd;
                final String zzTe;

                protected void zza(zze zze1)
                    throws RemoteException
                {
                    try
                    {
                        zze1.zzb(zzTe, null, this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (zze zze1)
                    {
                        zzaT(2001);
                    }
                }

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                    throws RemoteException
                {
                    zza((zze)zzb);
                }

            
            {
                zzTd = zza1;
                zzTe = s;
                super(googleapiclient);
            }
            });
        }

        public PendingResult joinApplication(GoogleApiClient googleapiclient, String s, String s1)
        {
            return googleapiclient.zzb(new Cast.zza(googleapiclient, s, s1) {

                final String val$sessionId;
                final zza zzTd;
                final String zzTe;

                protected void zza(zze zze1)
                    throws RemoteException
                {
                    try
                    {
                        zze1.zzb(zzTe, sessionId, this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (zze zze1)
                    {
                        zzaT(2001);
                    }
                }

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                    throws RemoteException
                {
                    zza((zze)zzb);
                }

            
            {
                zzTd = final_zza1;
                zzTe = s;
                sessionId = s1;
                super(googleapiclient);
            }
            });
        }

        public PendingResult launchApplication(GoogleApiClient googleapiclient, String s)
        {
            return googleapiclient.zzb(new Cast.zza(this, googleapiclient, s) {

                final zza zzTd;
                final String zzTe;

                protected void zza(zze zze1)
                    throws RemoteException
                {
                    try
                    {
                        zze1.zza(zzTe, false, this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (zze zze1)
                    {
                        zzaT(2001);
                    }
                }

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                    throws RemoteException
                {
                    zza((zze)zzb);
                }

            
            {
                zzTd = zza1;
                zzTe = s;
                super(googleapiclient);
            }
            });
        }

        public PendingResult launchApplication(GoogleApiClient googleapiclient, String s, LaunchOptions launchoptions)
        {
            return googleapiclient.zzb(new Cast.zza(this, googleapiclient, s, launchoptions) {

                final zza zzTd;
                final String zzTe;
                final LaunchOptions zzTf;

                protected void zza(zze zze1)
                    throws RemoteException
                {
                    try
                    {
                        zze1.zza(zzTe, zzTf, this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (zze zze1)
                    {
                        zzaT(2001);
                    }
                }

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                    throws RemoteException
                {
                    zza((zze)zzb);
                }

            
            {
                zzTd = zza1;
                zzTe = s;
                zzTf = launchoptions;
                super(googleapiclient);
            }
            });
        }

        public PendingResult launchApplication(GoogleApiClient googleapiclient, String s, boolean flag)
        {
            return launchApplication(googleapiclient, s, (new LaunchOptions.Builder()).setRelaunchIfRunning(flag).build());
        }

        public PendingResult leaveApplication(GoogleApiClient googleapiclient)
        {
            return googleapiclient.zzb(new zzh(this, googleapiclient) {

                final zza zzTd;

                protected void zza(zze zze1)
                    throws RemoteException
                {
                    try
                    {
                        zze1.zzd(this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (zze zze1)
                    {
                        zzaT(2001);
                    }
                }

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                    throws RemoteException
                {
                    zza((zze)zzb);
                }

            
            {
                zzTd = zza1;
                super(googleapiclient);
            }
            });
        }

        public void removeMessageReceivedCallbacks(GoogleApiClient googleapiclient, String s)
            throws IOException, IllegalArgumentException
        {
            try
            {
                ((zze)googleapiclient.zza(zzk.zzQf)).zzbK(s);
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
                ((zze)googleapiclient.zza(zzk.zzQf)).zzmx();
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
            return googleapiclient.zzb(new zzh(this, googleapiclient, s, s1) {

                final String zzTb;
                final String zzTc;
                final zza zzTd;

                protected void zza(zze zze1)
                    throws RemoteException
                {
                    try
                    {
                        zze1.zza(zzTb, zzTc, this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (zze zze1) { }
                    // Misplaced declaration of an exception variable
                    catch (zze zze1) { }
                    zzaT(2001);
                }

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                    throws RemoteException
                {
                    zza((zze)zzb);
                }

            
            {
                zzTd = zza1;
                zzTb = s;
                zzTc = s1;
                super(googleapiclient);
            }
            });
        }

        public void setMessageReceivedCallbacks(GoogleApiClient googleapiclient, String s, Cast.MessageReceivedCallback messagereceivedcallback)
            throws IOException, IllegalStateException
        {
            try
            {
                ((zze)googleapiclient.zza(zzk.zzQf)).zza(s, messagereceivedcallback);
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
                ((zze)googleapiclient.zza(zzk.zzQf)).zzV(flag);
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
                ((zze)googleapiclient.zza(zzk.zzQf)).zze(d);
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
            return googleapiclient.zzb(new zzh(this, googleapiclient) {

                final zza zzTd;

                protected void zza(zze zze1)
                    throws RemoteException
                {
                    try
                    {
                        zze1.zza("", this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (zze zze1)
                    {
                        zzaT(2001);
                    }
                }

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                    throws RemoteException
                {
                    zza((zze)zzb);
                }

            
            {
                zzTd = zza1;
                super(googleapiclient);
            }
            });
        }

        public PendingResult stopApplication(GoogleApiClient googleapiclient, String s)
        {
            return googleapiclient.zzb(new zzh(googleapiclient, s) {

                final String val$sessionId;
                final zza zzTd;

                protected void zza(zze zze1)
                    throws RemoteException
                {
                    if (TextUtils.isEmpty(sessionId))
                    {
                        zzd(2001, "IllegalArgument: sessionId cannot be null or empty");
                        return;
                    }
                    try
                    {
                        zze1.zza(sessionId, this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (zze zze1)
                    {
                        zzaT(2001);
                    }
                }

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                    throws RemoteException
                {
                    zza((zze)zzb);
                }

            
            {
                zzTd = final_zza1;
                sessionId = s;
                super(googleapiclient);
            }
            });
        }

        public zza()
        {
        }
    }


    public abstract int getActiveInputState(GoogleApiClient googleapiclient)
        throws IllegalStateException;

    public abstract ApplicationMetadata getApplicationMetadata(GoogleApiClient googleapiclient)
        throws IllegalStateException;

    public abstract String getApplicationStatus(GoogleApiClient googleapiclient)
        throws IllegalStateException;

    public abstract int getStandbyState(GoogleApiClient googleapiclient)
        throws IllegalStateException;

    public abstract double getVolume(GoogleApiClient googleapiclient)
        throws IllegalStateException;

    public abstract boolean isMute(GoogleApiClient googleapiclient)
        throws IllegalStateException;

    public abstract PendingResult joinApplication(GoogleApiClient googleapiclient);

    public abstract PendingResult joinApplication(GoogleApiClient googleapiclient, String s);

    public abstract PendingResult joinApplication(GoogleApiClient googleapiclient, String s, String s1);

    public abstract PendingResult launchApplication(GoogleApiClient googleapiclient, String s);

    public abstract PendingResult launchApplication(GoogleApiClient googleapiclient, String s, LaunchOptions launchoptions);

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
