// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzb;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.cast.internal.zzh;
import com.google.android.gms.cast.internal.zzk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import java.io.IOException;

// Referenced classes of package com.google.android.gms.cast:
//            ApplicationMetadata, LaunchOptions, JoinOptions, CastDevice

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

        public abstract void setMessageReceivedCallbacks(GoogleApiClient googleapiclient, String s, MessageReceivedCallback messagereceivedcallback)
            throws IOException, IllegalStateException;

        public abstract void setMute(GoogleApiClient googleapiclient, boolean flag)
            throws IOException, IllegalStateException;

        public abstract void setVolume(GoogleApiClient googleapiclient, double d)
            throws IOException, IllegalArgumentException, IllegalStateException;

        public abstract PendingResult stopApplication(GoogleApiClient googleapiclient);

        public abstract PendingResult stopApplication(GoogleApiClient googleapiclient, String s);
    }

    public static final class CastApi.zza
        implements CastApi
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
            return googleapiclient.zzb(new zza(this, googleapiclient, s) {

                final CastApi.zza zzUR;
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
            return googleapiclient.zzb(new zza(this, googleapiclient, s, launchoptions) {

                final CastApi.zza zzUR;
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

                final CastApi.zza zzUR;

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
                final CastApi.zza zzUR;
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

        public void setMessageReceivedCallbacks(GoogleApiClient googleapiclient, String s, MessageReceivedCallback messagereceivedcallback)
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

                final CastApi.zza zzUR;

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
                final CastApi.zza zzUR;

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
            return googleapiclient.zzb(new zza(googleapiclient, s, s1, joinoptions) {

                final String val$sessionId;
                final CastApi.zza zzUR;
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

        public CastApi.zza()
        {
        }
    }

    public static final class CastOptions
        implements com.google.android.gms.common.api.Api.ApiOptions.HasOptions
    {

        final CastDevice zzUV;
        final Listener zzUW;
        private final int zzUX;

        public static Builder builder(CastDevice castdevice, Listener listener)
        {
            return new Builder(castdevice, listener);
        }

        static int zza(CastOptions castoptions)
        {
            return castoptions.zzUX;
        }

        private CastOptions(Builder builder1)
        {
            zzUV = builder1.zzUY;
            zzUW = builder1.zzUZ;
            zzUX = Builder.zza(builder1);
        }

    }

    public static final class CastOptions.Builder
    {

        CastDevice zzUY;
        Listener zzUZ;
        private int zzVa;

        static int zza(CastOptions.Builder builder)
        {
            return builder.zzVa;
        }

        public CastOptions build()
        {
            return new CastOptions(this);
        }

        public CastOptions.Builder setVerboseLoggingEnabled(boolean flag)
        {
            if (flag)
            {
                zzVa = zzVa | 1;
                return this;
            } else
            {
                zzVa = zzVa & -2;
                return this;
            }
        }

        public CastOptions.Builder(CastDevice castdevice, Listener listener)
        {
            zzx.zzb(castdevice, "CastDevice parameter cannot be null");
            zzx.zzb(listener, "CastListener parameter cannot be null");
            zzUY = castdevice;
            zzUZ = listener;
            zzVa = 0;
        }
    }

    public static class Listener
    {

        public void onActiveInputStateChanged(int i)
        {
        }

        public void onApplicationDisconnected(int i)
        {
        }

        public void onApplicationMetadataChanged(ApplicationMetadata applicationmetadata)
        {
        }

        public void onApplicationStatusChanged()
        {
        }

        public void onStandbyStateChanged(int i)
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

    private static abstract class zza extends zzb
    {

        public Result zzb(Status status)
        {
            return zzn(status);
        }

        public ApplicationConnectionResult zzn(Status status)
        {
            return new ApplicationConnectionResult(this, status) {

                final Status zzVb;
                final zza zzVc;

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
                    return zzVb;
                }

                public boolean getWasLaunched()
                {
                    return false;
                }

            
            {
                zzVc = zza1;
                zzVb = status;
                super();
            }
            };
        }

        public zza(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }
    }


    public static final int ACTIVE_INPUT_STATE_NO = 0;
    public static final int ACTIVE_INPUT_STATE_UNKNOWN = -1;
    public static final int ACTIVE_INPUT_STATE_YES = 1;
    public static final Api API;
    public static final CastApi CastApi = new CastApi.zza();
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 0x10000;
    public static final int MAX_NAMESPACE_LENGTH = 128;
    public static final int STANDBY_STATE_NO = 0;
    public static final int STANDBY_STATE_UNKNOWN = -1;
    public static final int STANDBY_STATE_YES = 1;
    private static final com.google.android.gms.common.api.Api.zza zzRl;

    private Cast()
    {
    }

    static 
    {
        zzRl = new com.google.android.gms.common.api.Api.zza() {

            public zze zza(Context context, Looper looper, zzf zzf, CastOptions castoptions, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                zzx.zzb(castoptions, "Setting the API options is required.");
                return new zze(context, looper, zzf, castoptions.zzUV, CastOptions.zza(castoptions), castoptions.zzUW, connectioncallbacks, onconnectionfailedlistener);
            }

            public volatile com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf zzf, Object obj, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
            {
                return zza(context, looper, zzf, (CastOptions)obj, connectioncallbacks, onconnectionfailedlistener);
            }

        };
        API = new Api("Cast.API", zzRl, zzk.zzRk);
    }
}
