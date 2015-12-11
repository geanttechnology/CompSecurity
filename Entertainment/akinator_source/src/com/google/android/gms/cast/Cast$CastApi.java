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
//            Cast, ApplicationMetadata, LaunchOptions, JoinOptions

public static interface zza
{
    public static final class zza
        implements Cast.CastApi
    {

        public int getActiveInputState(GoogleApiClient googleapiclient)
            throws IllegalStateException
        {
            return ((zze)googleapiclient.zza(zzk.zzRk)).zzmV();
        }

        public ApplicationMetadata getApplicationMetadata(GoogleApiClient googleapiclient)
            throws IllegalStateException
        {
            return ((zze)googleapiclient.zza(zzk.zzRk)).getApplicationMetadata();
        }

        public String getApplicationStatus(GoogleApiClient googleapiclient)
            throws IllegalStateException
        {
            return ((zze)googleapiclient.zza(zzk.zzRk)).getApplicationStatus();
        }

        public int getStandbyState(GoogleApiClient googleapiclient)
            throws IllegalStateException
        {
            return ((zze)googleapiclient.zza(zzk.zzRk)).zzmW();
        }

        public double getVolume(GoogleApiClient googleapiclient)
            throws IllegalStateException
        {
            return ((zze)googleapiclient.zza(zzk.zzRk)).zzmU();
        }

        public boolean isMute(GoogleApiClient googleapiclient)
            throws IllegalStateException
        {
            return ((zze)googleapiclient.zza(zzk.zzRk)).isMute();
        }

        public PendingResult joinApplication(GoogleApiClient googleapiclient)
        {
            return zza(googleapiclient, null, null, null);
        }

        public PendingResult joinApplication(GoogleApiClient googleapiclient, String s)
        {
            return zza(googleapiclient, s, null, null);
        }

        public PendingResult joinApplication(GoogleApiClient googleapiclient, String s, String s1)
        {
            return zza(googleapiclient, s, s1, null);
        }

        public PendingResult launchApplication(GoogleApiClient googleapiclient, String s)
        {
            return googleapiclient.zzb(new Cast.zza(this, googleapiclient, s) {

                final zza zzUR;
                final String zzUS;

                protected void zza(zze zze1)
                    throws RemoteException
                {
                    try
                    {
                        zze1.zza(zzUS, false, this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (zze zze1)
                    {
                        zzba(2001);
                    }
                }

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                    throws RemoteException
                {
                    zza((zze)zzb);
                }

            
            {
                zzUR = zza1;
                zzUS = s;
                super(googleapiclient);
            }
            });
        }

        public PendingResult launchApplication(GoogleApiClient googleapiclient, String s, LaunchOptions launchoptions)
        {
            return googleapiclient.zzb(new Cast.zza(this, googleapiclient, s, launchoptions) {

                final zza zzUR;
                final String zzUS;
                final LaunchOptions zzUT;

                protected void zza(zze zze1)
                    throws RemoteException
                {
                    try
                    {
                        zze1.zza(zzUS, zzUT, this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (zze zze1)
                    {
                        zzba(2001);
                    }
                }

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                    throws RemoteException
                {
                    zza((zze)zzb);
                }

            
            {
                zzUR = zza1;
                zzUS = s;
                zzUT = launchoptions;
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

                final zza zzUR;

                protected void zza(zze zze1)
                    throws RemoteException
                {
                    try
                    {
                        zze1.zzb(this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (zze zze1)
                    {
                        zzba(2001);
                    }
                }

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                    throws RemoteException
                {
                    zza((zze)zzb);
                }

            
            {
                zzUR = zza1;
                super(googleapiclient);
            }
            });
        }

        public void removeMessageReceivedCallbacks(GoogleApiClient googleapiclient, String s)
            throws IOException, IllegalArgumentException
        {
            try
            {
                ((zze)googleapiclient.zza(zzk.zzRk)).zzbL(s);
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
                ((zze)googleapiclient.zza(zzk.zzRk)).zzmT();
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

                final String zzUQ;
                final zza zzUR;
                final String zzyj;

                protected void zza(zze zze1)
                    throws RemoteException
                {
                    try
                    {
                        zze1.zza(zzUQ, zzyj, this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (zze zze1) { }
                    // Misplaced declaration of an exception variable
                    catch (zze zze1) { }
                    zzba(2001);
                }

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                    throws RemoteException
                {
                    zza((zze)zzb);
                }

            
            {
                zzUR = zza1;
                zzUQ = s;
                zzyj = s1;
                super(googleapiclient);
            }
            });
        }

        public void setMessageReceivedCallbacks(GoogleApiClient googleapiclient, String s, Cast.MessageReceivedCallback messagereceivedcallback)
            throws IOException, IllegalStateException
        {
            try
            {
                ((zze)googleapiclient.zza(zzk.zzRk)).zza(s, messagereceivedcallback);
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
                ((zze)googleapiclient.zza(zzk.zzRk)).zzW(flag);
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
                ((zze)googleapiclient.zza(zzk.zzRk)).zzf(d);
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

                final zza zzUR;

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
                        zzba(2001);
                    }
                }

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                    throws RemoteException
                {
                    zza((zze)zzb);
                }

            
            {
                zzUR = zza1;
                super(googleapiclient);
            }
            });
        }

        public PendingResult stopApplication(GoogleApiClient googleapiclient, String s)
        {
            return googleapiclient.zzb(new zzh(googleapiclient, s) {

                final String val$sessionId;
                final zza zzUR;

                protected void zza(zze zze1)
                    throws RemoteException
                {
                    if (TextUtils.isEmpty(sessionId))
                    {
                        zze(2001, "IllegalArgument: sessionId cannot be null or empty");
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
                        zzba(2001);
                    }
                }

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                    throws RemoteException
                {
                    zza((zze)zzb);
                }

            
            {
                zzUR = final_zza1;
                sessionId = s;
                super(googleapiclient);
            }
            });
        }

        public PendingResult zza(GoogleApiClient googleapiclient, String s, String s1, JoinOptions joinoptions)
        {
            return googleapiclient.zzb(new Cast.zza(googleapiclient, s, s1, joinoptions) {

                final String val$sessionId;
                final zza zzUR;
                final String zzUS;
                final JoinOptions zzUU;

                protected void zza(zze zze1)
                    throws RemoteException
                {
                    try
                    {
                        zze1.zza(zzUS, sessionId, zzUU, this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (zze zze1)
                    {
                        zzba(2001);
                    }
                }

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                    throws RemoteException
                {
                    zza((zze)zzb);
                }

            
            {
                zzUR = final_zza1;
                zzUS = s;
                sessionId = s1;
                zzUU = joinoptions;
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
