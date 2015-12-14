// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.v7.media.MediaRouter;
import android.text.TextUtils;
import android.view.Display;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.google.android.gms.cast:
//            CastDevice, CastRemoteDisplay, CastMediaControlIntent, CastRemoteDisplayApi

public abstract class CastRemoteDisplayLocalService extends Service
{
    public static interface Callbacks
    {

        public abstract void onRemoteDisplaySessionError(Status status);

        public abstract void onRemoteDisplaySessionStarted(CastRemoteDisplayLocalService castremotedisplaylocalservice);
    }

    public static final class NotificationSettings
    {

        private Notification mNotification;
        private PendingIntent zzTX;
        private String zzTY;
        private String zzTZ;

        static Notification zza(NotificationSettings notificationsettings)
        {
            return notificationsettings.mNotification;
        }

        static Notification zza(NotificationSettings notificationsettings, Notification notification)
        {
            notificationsettings.mNotification = notification;
            return notification;
        }

        static PendingIntent zza(NotificationSettings notificationsettings, PendingIntent pendingintent)
        {
            notificationsettings.zzTX = pendingintent;
            return pendingintent;
        }

        static String zza(NotificationSettings notificationsettings, String s)
        {
            notificationsettings.zzTY = s;
            return s;
        }

        static String zzb(NotificationSettings notificationsettings)
        {
            return notificationsettings.zzTY;
        }

        static String zzb(NotificationSettings notificationsettings, String s)
        {
            notificationsettings.zzTZ = s;
            return s;
        }

        static String zzc(NotificationSettings notificationsettings)
        {
            return notificationsettings.zzTZ;
        }

        static PendingIntent zzd(NotificationSettings notificationsettings)
        {
            return notificationsettings.zzTX;
        }

        private NotificationSettings()
        {
        }


        private NotificationSettings(NotificationSettings notificationsettings)
        {
            mNotification = notificationsettings.mNotification;
            zzTX = notificationsettings.zzTX;
            zzTY = notificationsettings.zzTY;
            zzTZ = notificationsettings.zzTZ;
        }

    }

    public static final class NotificationSettings.Builder
    {

        private NotificationSettings zzUa;

        public NotificationSettings build()
        {
            if (NotificationSettings.zza(zzUa) != null)
            {
                if (!TextUtils.isEmpty(NotificationSettings.zzb(zzUa)))
                {
                    throw new IllegalArgumentException("notificationTitle requires using the default notification");
                }
                if (!TextUtils.isEmpty(NotificationSettings.zzc(zzUa)))
                {
                    throw new IllegalArgumentException("notificationText requires using the default notification");
                }
                if (NotificationSettings.zzd(zzUa) != null)
                {
                    throw new IllegalArgumentException("notificationPendingIntent requires using the default notification");
                }
            } else
            if (TextUtils.isEmpty(NotificationSettings.zzb(zzUa)) && TextUtils.isEmpty(NotificationSettings.zzc(zzUa)) && NotificationSettings.zzd(zzUa) == null)
            {
                throw new IllegalArgumentException("At least an argument must be provided");
            }
            return zzUa;
        }

        public NotificationSettings.Builder setNotification(Notification notification)
        {
            NotificationSettings.zza(zzUa, notification);
            return this;
        }

        public NotificationSettings.Builder setNotificationPendingIntent(PendingIntent pendingintent)
        {
            NotificationSettings.zza(zzUa, pendingintent);
            return this;
        }

        public NotificationSettings.Builder setNotificationText(String s)
        {
            NotificationSettings.zzb(zzUa, s);
            return this;
        }

        public NotificationSettings.Builder setNotificationTitle(String s)
        {
            NotificationSettings.zza(zzUa, s);
            return this;
        }

        public NotificationSettings.Builder()
        {
            zzUa = new NotificationSettings();
        }
    }

    private class zza extends Binder
    {

        final CastRemoteDisplayLocalService zzTR;

        CastRemoteDisplayLocalService zzlZ()
        {
            return zzTR;
        }

        private zza()
        {
            zzTR = CastRemoteDisplayLocalService.this;
            super();
        }

    }

    private static final class zzb extends BroadcastReceiver
    {

        public void onReceive(Context context, Intent intent)
        {
            if (intent.getAction().equals("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"))
            {
                CastRemoteDisplayLocalService.zzlV().zzb("disconnecting", new Object[0]);
                CastRemoteDisplayLocalService.stopService();
            }
        }

        private zzb()
        {
        }

    }


    private static final Object zzTA = new Object();
    private static AtomicBoolean zzTB = new AtomicBoolean(false);
    private static CastRemoteDisplayLocalService zzTP;
    private static final zzl zzTy = new zzl("CastRemoteDisplayLocalService");
    private static final int zzTz;
    private Handler mHandler;
    private Notification mNotification;
    private String zzSX;
    private GoogleApiClient zzTC;
    private CastRemoteDisplay.CastRemoteDisplaySessionCallbacks zzTD;
    private Callbacks zzTE;
    private zzb zzTF;
    private NotificationSettings zzTG;
    private Boolean zzTH;
    private PendingIntent zzTI;
    private CastDevice zzTJ;
    private Display zzTK;
    private Context zzTL;
    private ServiceConnection zzTM;
    private MediaRouter zzTN;
    private final android.support.v7.media.MediaRouter.Callback zzTO = new android.support.v7.media.MediaRouter.Callback() {

        final CastRemoteDisplayLocalService zzTR;

        public void onRouteUnselected(MediaRouter mediarouter, android.support.v7.media.MediaRouter.RouteInfo routeinfo)
        {
            CastRemoteDisplayLocalService.zza(zzTR, "onRouteUnselected");
            if (CastRemoteDisplayLocalService.zza(zzTR) == null)
            {
                CastRemoteDisplayLocalService.zza(zzTR, "onRouteUnselected, no device was selected");
                return;
            }
            if (!CastDevice.getFromBundle(routeinfo.getExtras()).getDeviceId().equals(CastRemoteDisplayLocalService.zza(zzTR).getDeviceId()))
            {
                CastRemoteDisplayLocalService.zza(zzTR, "onRouteUnselected, device does not match");
                return;
            } else
            {
                CastRemoteDisplayLocalService.stopService();
                return;
            }
        }

            
            {
                zzTR = CastRemoteDisplayLocalService.this;
                super();
            }
    };
    private final IBinder zzTQ = new zza();

    public CastRemoteDisplayLocalService()
    {
    }

    public static CastRemoteDisplayLocalService getInstance()
    {
        CastRemoteDisplayLocalService castremotedisplaylocalservice;
        synchronized (zzTA)
        {
            castremotedisplaylocalservice = zzTP;
        }
        return castremotedisplaylocalservice;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected static void setDebugEnabled()
    {
        zzTy.zzW(true);
    }

    public static void startService(Context context, Class class1, String s, CastDevice castdevice, NotificationSettings notificationsettings, Callbacks callbacks)
    {
        zzTy.zzb("Starting Service", new Object[0]);
        synchronized (zzTA)
        {
            if (zzTP != null)
            {
                zzTy.zzf("An existing service had not been stopped before starting one", new Object[0]);
                zzQ(true);
            }
        }
        zzb(context, class1);
        zzx.zzb(context, "activityContext is required.");
        zzx.zzb(class1, "serviceClass is required.");
        zzx.zzb(s, "applicationId is required.");
        zzx.zzb(castdevice, "device is required.");
        zzx.zzb(notificationsettings, "notificationSettings is required.");
        zzx.zzb(callbacks, "callbacks is required.");
        if (NotificationSettings.zza(notificationsettings) == null && NotificationSettings.zzd(notificationsettings) == null)
        {
            throw new IllegalArgumentException("notificationSettings: Either the notification or the notificationPendingIntent must be provided");
        }
        break MISSING_BLOCK_LABEL_126;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
        if (zzTB.getAndSet(true))
        {
            zzTy.zzc("Service is already being started, startService has been called twice", new Object[0]);
            return;
        } else
        {
            class1 = new Intent(context, class1);
            context.startService(class1);
            context.bindService(class1, new ServiceConnection(s, castdevice, notificationsettings, context, callbacks) {

                final CastDevice zzTS;
                final NotificationSettings zzTT;
                final Context zzTU;
                final Callbacks zzTV;
                final String zzTe;

                public void onServiceConnected(ComponentName componentname, IBinder ibinder)
                {
                    componentname = ((zza)ibinder).zzlZ();
                    if (componentname != null && CastRemoteDisplayLocalService.zza(componentname, zzTe, zzTS, zzTT, zzTU, this, zzTV))
                    {
                        break MISSING_BLOCK_LABEL_86;
                    }
                    CastRemoteDisplayLocalService.zzlV().zzc("Connected but unable to get the service instance", new Object[0]);
                    zzTV.onRemoteDisplaySessionError(new Status(2200));
                    CastRemoteDisplayLocalService.zzlW().set(false);
                    zzTU.unbindService(this);
                    return;
                    componentname;
                    CastRemoteDisplayLocalService.zzlV().zzb("No need to unbind service, already unbound", new Object[0]);
                    return;
                }

                public void onServiceDisconnected(ComponentName componentname)
                {
                    CastRemoteDisplayLocalService.zzlV().zzb("onServiceDisconnected", new Object[0]);
                    zzTV.onRemoteDisplaySessionError(new Status(2201, "Service Disconnected"));
                    CastRemoteDisplayLocalService.zzlW().set(false);
                    try
                    {
                        zzTU.unbindService(this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (ComponentName componentname)
                    {
                        CastRemoteDisplayLocalService.zzlV().zzb("No need to unbind service, already unbound", new Object[0]);
                    }
                }

            
            {
                zzTe = s;
                zzTS = castdevice;
                zzTT = notificationsettings;
                zzTU = context;
                zzTV = callbacks;
                super();
            }
            }, 64);
            return;
        }
    }

    public static void stopService()
    {
        zzQ(false);
    }

    private void zzP(boolean flag)
    {
        zzaZ("Stopping Service");
        if (!flag && zzTN != null)
        {
            zzaZ("Setting default route");
            zzTN.selectRoute(zzTN.getDefaultRoute());
        }
        if (zzTF != null)
        {
            zzaZ("Unregistering notification receiver");
            unregisterReceiver(zzTF);
        }
        zzlS();
        zzlT();
        zzlO();
        if (zzTC != null)
        {
            zzTC.disconnect();
            zzTC = null;
        }
        if (zzTL != null && zzTM != null)
        {
            try
            {
                zzTL.unbindService(zzTM);
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                zzaZ("No need to unbind service, already unbound");
            }
            zzTM = null;
            zzTL = null;
        }
        zzSX = null;
        zzTC = null;
        mNotification = null;
        zzTK = null;
    }

    private static void zzQ(boolean flag)
    {
label0:
        {
            zzTy.zzb("Stopping Service", new Object[0]);
            zzTB.set(false);
            synchronized (zzTA)
            {
                if (zzTP != null)
                {
                    break label0;
                }
                zzTy.zzc("Service is already being stopped", new Object[0]);
            }
            return;
        }
        CastRemoteDisplayLocalService castremotedisplaylocalservice;
        castremotedisplaylocalservice = zzTP;
        zzTP = null;
        obj;
        JVM INSTR monitorexit ;
        castremotedisplaylocalservice.zzP(flag);
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private Notification zzR(boolean flag)
    {
        zzaZ("createDefaultNotification");
        int k = getApplicationInfo().labelRes;
        String s2 = NotificationSettings.zzb(zzTG);
        String s1 = NotificationSettings.zzc(zzTG);
        String s;
        int i;
        int j;
        if (flag)
        {
            j = com.google.android.gms.R.string.cast_notification_connected_message;
            i = com.google.android.gms.R.drawable.cast_ic_notification_on;
        } else
        {
            j = com.google.android.gms.R.string.cast_notification_connecting_message;
            i = com.google.android.gms.R.drawable.cast_ic_notification_connecting;
        }
        s = s2;
        if (TextUtils.isEmpty(s2))
        {
            s = getString(k);
        }
        if (TextUtils.isEmpty(s1))
        {
            s1 = getString(j, new Object[] {
                zzTJ.getFriendlyName()
            });
        }
        return (new android.support.v4.app.NotificationCompat.Builder(this)).setContentTitle(s).setContentText(s1).setContentIntent(NotificationSettings.zzd(zzTG)).setSmallIcon(i).setOngoing(true).addAction(0x1080038, getString(com.google.android.gms.R.string.cast_notification_disconnect), zzlU()).build();
    }

    static void zzS(boolean flag)
    {
        zzQ(flag);
    }

    static Context zza(CastRemoteDisplayLocalService castremotedisplaylocalservice, Context context)
    {
        castremotedisplaylocalservice.zzTL = context;
        return context;
    }

    static ServiceConnection zza(CastRemoteDisplayLocalService castremotedisplaylocalservice, ServiceConnection serviceconnection)
    {
        castremotedisplaylocalservice.zzTM = serviceconnection;
        return serviceconnection;
    }

    static CastDevice zza(CastRemoteDisplayLocalService castremotedisplaylocalservice)
    {
        return castremotedisplaylocalservice.zzTJ;
    }

    private GoogleApiClient zza(CastDevice castdevice)
    {
        castdevice = new CastRemoteDisplay.CastRemoteDisplayOptions.Builder(castdevice, zzTD);
        return (new com.google.android.gms.common.api.GoogleApiClient.Builder(this, new com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks() {

            final CastRemoteDisplayLocalService zzTR;

            public void onConnected(Bundle bundle)
            {
                CastRemoteDisplayLocalService.zza(zzTR, "onConnected");
                CastRemoteDisplayLocalService.zzf(zzTR);
            }

            public void onConnectionSuspended(int i)
            {
                CastRemoteDisplayLocalService.zzlV().zzf(String.format("[Instance: %s] ConnectionSuspended %d", new Object[] {
                    this, Integer.valueOf(i)
                }), new Object[0]);
            }

            
            {
                zzTR = CastRemoteDisplayLocalService.this;
                super();
            }
        }, new com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener() {

            final CastRemoteDisplayLocalService zzTR;

            public void onConnectionFailed(ConnectionResult connectionresult)
            {
                CastRemoteDisplayLocalService.zzb(zzTR, (new StringBuilder()).append("Connection failed: ").append(connectionresult).toString());
                CastRemoteDisplayLocalService.zzc(zzTR);
            }

            
            {
                zzTR = CastRemoteDisplayLocalService.this;
                super();
            }
        })).addApi(CastRemoteDisplay.API, castdevice.build()).build();
    }

    private void zza(Display display)
    {
        zzTK = display;
        if (zzTH.booleanValue())
        {
            mNotification = zzR(true);
            startForeground(zzTz, mNotification);
        }
        if (zzTE != null)
        {
            zzTE.onRemoteDisplaySessionStarted(this);
            zzTE = null;
        }
        onCreatePresentation(zzTK);
    }

    static void zza(CastRemoteDisplayLocalService castremotedisplaylocalservice, Display display)
    {
        castremotedisplaylocalservice.zza(display);
    }

    static void zza(CastRemoteDisplayLocalService castremotedisplaylocalservice, String s)
    {
        castremotedisplaylocalservice.zzaZ(s);
    }

    static boolean zza(CastRemoteDisplayLocalService castremotedisplaylocalservice, String s, CastDevice castdevice, NotificationSettings notificationsettings, Context context, ServiceConnection serviceconnection, Callbacks callbacks)
    {
        return castremotedisplaylocalservice.zza(s, castdevice, notificationsettings, context, serviceconnection, callbacks);
    }

    private boolean zza(String s, CastDevice castdevice, NotificationSettings notificationsettings, Context context, ServiceConnection serviceconnection, Callbacks callbacks)
    {
label0:
        {
            zzaZ("startRemoteDisplaySession");
            zzx.zzch("Starting the Cast Remote Display must be done on the main thread");
            synchronized (zzTA)
            {
                if (zzTP == null)
                {
                    break label0;
                }
                zzTy.zzf("An existing service had not been stopped before starting one", new Object[0]);
            }
            return false;
        }
        zzTP = this;
        obj;
        JVM INSTR monitorexit ;
        zzTE = callbacks;
        zzSX = s;
        zzTJ = castdevice;
        zzTL = context;
        zzTM = serviceconnection;
        zzTN = MediaRouter.getInstance(getApplicationContext());
        s = (new android.support.v7.media.MediaRouteSelector.Builder()).addControlCategory(CastMediaControlIntent.categoryForCast(zzSX)).build();
        zzaZ("addMediaRouterCallback");
        zzTN.addCallback(s, zzTO, 4);
        mHandler = new Handler(getMainLooper());
        mNotification = NotificationSettings.zza(notificationsettings);
        zzTF = new zzb();
        registerReceiver(zzTF, new IntentFilter("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"));
        zzTG = new NotificationSettings(notificationsettings);
        if (NotificationSettings.zza(zzTG) == null)
        {
            zzTH = Boolean.valueOf(true);
            mNotification = zzR(false);
        } else
        {
            zzTH = Boolean.valueOf(false);
            mNotification = NotificationSettings.zza(zzTG);
        }
        startForeground(zzTz, mNotification);
        zzTC = zza(castdevice);
        zzTC.connect();
        return true;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    private void zzaZ(String s)
    {
        zzTy.zzb("[Instance: %s] %s", new Object[] {
            this, s
        });
    }

    static Handler zzb(CastRemoteDisplayLocalService castremotedisplaylocalservice)
    {
        return castremotedisplaylocalservice.mHandler;
    }

    static Display zzb(CastRemoteDisplayLocalService castremotedisplaylocalservice, Display display)
    {
        castremotedisplaylocalservice.zzTK = display;
        return display;
    }

    private static void zzb(Context context, Class class1)
    {
        try
        {
            class1 = new ComponentName(context, class1);
            context = context.getPackageManager().getServiceInfo(class1, 128);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalStateException("Service not found, did you forget to configure it in the manifest?");
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        if (((ServiceInfo) (context)).exported)
        {
            throw new IllegalStateException("The service must not be exported, verify the manifest configuration");
        }
    }

    static void zzb(CastRemoteDisplayLocalService castremotedisplaylocalservice, String s)
    {
        castremotedisplaylocalservice.zzbc(s);
    }

    private void zzbc(String s)
    {
        zzTy.zzc("[Instance: %s] %s", new Object[] {
            this, s
        });
    }

    static void zzc(CastRemoteDisplayLocalService castremotedisplaylocalservice)
    {
        castremotedisplaylocalservice.zzlR();
    }

    static Context zzd(CastRemoteDisplayLocalService castremotedisplaylocalservice)
    {
        return castremotedisplaylocalservice.zzTL;
    }

    static ServiceConnection zze(CastRemoteDisplayLocalService castremotedisplaylocalservice)
    {
        return castremotedisplaylocalservice.zzTM;
    }

    static void zzf(CastRemoteDisplayLocalService castremotedisplaylocalservice)
    {
        castremotedisplaylocalservice.zzlP();
    }

    private void zzlO()
    {
        if (zzTN != null)
        {
            zzx.zzch("CastRemoteDisplayLocalService calls must be done on the main thread");
            zzaZ("removeMediaRouterCallback");
            zzTN.removeCallback(zzTO);
        }
    }

    private void zzlP()
    {
        zzaZ("startRemoteDisplay");
        if (zzTC == null || !zzTC.isConnected())
        {
            zzTy.zzc("Unable to start the remote display as the API client is not ready", new Object[0]);
            return;
        } else
        {
            CastRemoteDisplay.CastRemoteDisplayApi.startRemoteDisplay(zzTC, zzSX).setResultCallback(new ResultCallback() {

                final CastRemoteDisplayLocalService zzTR;

                public void onResult(Result result)
                {
                    zza((CastRemoteDisplay.CastRemoteDisplaySessionResult)result);
                }

                public void zza(CastRemoteDisplay.CastRemoteDisplaySessionResult castremotedisplaysessionresult)
                {
                    if (castremotedisplaysessionresult.getStatus().isSuccess()) goto _L2; else goto _L1
_L1:
                    CastRemoteDisplayLocalService.zzlV().zzc("Connection was not successful", new Object[0]);
                    CastRemoteDisplayLocalService.zzc(zzTR);
_L4:
                    return;
_L2:
                    CastRemoteDisplayLocalService.zzlV().zzb("startRemoteDisplay successful", new Object[0]);
                    synchronized (CastRemoteDisplayLocalService.zzlX())
                    {
                        if (CastRemoteDisplayLocalService.zzlY() != null)
                        {
                            break MISSING_BLOCK_LABEL_83;
                        }
                        CastRemoteDisplayLocalService.zzlV().zzb("Remote Display started but session already cancelled", new Object[0]);
                        CastRemoteDisplayLocalService.zzc(zzTR);
                    }
                    return;
                    castremotedisplaysessionresult;
                    obj;
                    JVM INSTR monitorexit ;
                    throw castremotedisplaysessionresult;
                    obj;
                    JVM INSTR monitorexit ;
                    castremotedisplaysessionresult = castremotedisplaysessionresult.getPresentationDisplay();
                    if (castremotedisplaysessionresult != null)
                    {
                        CastRemoteDisplayLocalService.zza(zzTR, castremotedisplaysessionresult);
                    } else
                    {
                        CastRemoteDisplayLocalService.zzlV().zzc("Cast Remote Display session created without display", new Object[0]);
                    }
                    CastRemoteDisplayLocalService.zzlW().set(false);
                    if (CastRemoteDisplayLocalService.zzd(zzTR) != null && CastRemoteDisplayLocalService.zze(zzTR) != null)
                    {
                        try
                        {
                            CastRemoteDisplayLocalService.zzd(zzTR).unbindService(CastRemoteDisplayLocalService.zze(zzTR));
                        }
                        // Misplaced declaration of an exception variable
                        catch (CastRemoteDisplay.CastRemoteDisplaySessionResult castremotedisplaysessionresult)
                        {
                            CastRemoteDisplayLocalService.zzlV().zzb("No need to unbind service, already unbound", new Object[0]);
                        }
                        CastRemoteDisplayLocalService.zza(zzTR, null);
                        CastRemoteDisplayLocalService.zza(zzTR, null);
                        return;
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

            
            {
                zzTR = CastRemoteDisplayLocalService.this;
                super();
            }
            });
            return;
        }
    }

    private void zzlQ()
    {
        zzaZ("stopRemoteDisplay");
        if (zzTC == null || !zzTC.isConnected())
        {
            zzTy.zzc("Unable to stop the remote display as the API client is not ready", new Object[0]);
            return;
        } else
        {
            CastRemoteDisplay.CastRemoteDisplayApi.stopRemoteDisplay(zzTC).setResultCallback(new ResultCallback() {

                final CastRemoteDisplayLocalService zzTR;

                public void onResult(Result result)
                {
                    zza((CastRemoteDisplay.CastRemoteDisplaySessionResult)result);
                }

                public void zza(CastRemoteDisplay.CastRemoteDisplaySessionResult castremotedisplaysessionresult)
                {
                    if (!castremotedisplaysessionresult.getStatus().isSuccess())
                    {
                        CastRemoteDisplayLocalService.zza(zzTR, "Unable to stop the remote display, result unsuccessful");
                    } else
                    {
                        CastRemoteDisplayLocalService.zza(zzTR, "remote display stopped");
                    }
                    CastRemoteDisplayLocalService.zzb(zzTR, null);
                }

            
            {
                zzTR = CastRemoteDisplayLocalService.this;
                super();
            }
            });
            return;
        }
    }

    private void zzlR()
    {
        if (zzTE != null)
        {
            zzTE.onRemoteDisplaySessionError(new Status(2200));
            zzTE = null;
        }
        stopService();
    }

    private void zzlS()
    {
        zzaZ("stopRemoteDisplaySession");
        zzlQ();
        onDismissPresentation();
    }

    private void zzlT()
    {
        zzaZ("Stopping the remote display Service");
        stopForeground(true);
        stopSelf();
    }

    private PendingIntent zzlU()
    {
        if (zzTI == null)
        {
            zzTI = PendingIntent.getBroadcast(this, 0, new Intent("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"), 0x10000000);
        }
        return zzTI;
    }

    static zzl zzlV()
    {
        return zzTy;
    }

    static AtomicBoolean zzlW()
    {
        return zzTB;
    }

    static Object zzlX()
    {
        return zzTA;
    }

    static CastRemoteDisplayLocalService zzlY()
    {
        return zzTP;
    }

    protected Display getDisplay()
    {
        return zzTK;
    }

    public IBinder onBind(Intent intent)
    {
        zzaZ("onBind");
        return zzTQ;
    }

    public void onCreate()
    {
        super.onCreate();
        zzTD = new CastRemoteDisplay.CastRemoteDisplaySessionCallbacks() {

            final CastRemoteDisplayLocalService zzTR;

            public void onRemoteDisplayEnded(Status status)
            {
                CastRemoteDisplayLocalService.zzlV().zzb(String.format("Cast screen has ended: %d", new Object[] {
                    Integer.valueOf(status.getStatusCode())
                }), new Object[0]);
                if (CastRemoteDisplayLocalService.zzb(zzTR) != null)
                {
                    CastRemoteDisplayLocalService.zzb(zzTR).post(new Runnable(this) {

                        final _cls3 zzTW;

                        public void run()
                        {
                            CastRemoteDisplayLocalService.zzS(false);
                        }

            
            {
                zzTW = _pcls3;
                super();
            }
                    });
                }
            }

            
            {
                zzTR = CastRemoteDisplayLocalService.this;
                super();
            }
        };
    }

    public abstract void onCreatePresentation(Display display);

    public abstract void onDismissPresentation();

    public int onStartCommand(Intent intent, int i, int j)
    {
        zzaZ("onStartCommand");
        return 2;
    }

    public void updateNotificationSettings(NotificationSettings notificationsettings)
    {
        zzx.zzb(notificationsettings, "notificationSettings is required.");
        if (zzTG == null)
        {
            throw new IllegalStateException("No current notification settings to update");
        }
        if (zzTH.booleanValue())
        {
            if (NotificationSettings.zza(notificationsettings) != null)
            {
                throw new IllegalStateException("Current mode is default notification, notification attribute must not be provided");
            }
            if (NotificationSettings.zzd(notificationsettings) != null)
            {
                NotificationSettings.zza(zzTG, NotificationSettings.zzd(notificationsettings));
            }
            if (!TextUtils.isEmpty(NotificationSettings.zzb(notificationsettings)))
            {
                NotificationSettings.zza(zzTG, NotificationSettings.zzb(notificationsettings));
            }
            if (!TextUtils.isEmpty(NotificationSettings.zzc(notificationsettings)))
            {
                NotificationSettings.zzb(zzTG, NotificationSettings.zzc(notificationsettings));
            }
            mNotification = zzR(true);
        } else
        {
            zzx.zzb(NotificationSettings.zza(notificationsettings), "notification is required.");
            mNotification = NotificationSettings.zza(notificationsettings);
            NotificationSettings.zza(zzTG, mNotification);
        }
        startForeground(zzTz, mNotification);
    }

    static 
    {
        zzTz = com.google.android.gms.R.id.cast_notification_id;
    }
}
