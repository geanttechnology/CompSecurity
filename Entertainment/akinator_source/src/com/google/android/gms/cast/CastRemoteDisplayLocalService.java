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
        private PendingIntent zzVN;
        private String zzVO;
        private String zzVP;

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
            notificationsettings.zzVN = pendingintent;
            return pendingintent;
        }

        static String zza(NotificationSettings notificationsettings, String s)
        {
            notificationsettings.zzVO = s;
            return s;
        }

        static String zzb(NotificationSettings notificationsettings)
        {
            return notificationsettings.zzVO;
        }

        static String zzb(NotificationSettings notificationsettings, String s)
        {
            notificationsettings.zzVP = s;
            return s;
        }

        static String zzc(NotificationSettings notificationsettings)
        {
            return notificationsettings.zzVP;
        }

        static PendingIntent zzd(NotificationSettings notificationsettings)
        {
            return notificationsettings.zzVN;
        }

        private NotificationSettings()
        {
        }


        private NotificationSettings(NotificationSettings notificationsettings)
        {
            mNotification = notificationsettings.mNotification;
            zzVN = notificationsettings.zzVN;
            zzVO = notificationsettings.zzVO;
            zzVP = notificationsettings.zzVP;
        }

    }

    public static final class NotificationSettings.Builder
    {

        private NotificationSettings zzVQ;

        public NotificationSettings build()
        {
            if (NotificationSettings.zza(zzVQ) != null)
            {
                if (!TextUtils.isEmpty(NotificationSettings.zzb(zzVQ)))
                {
                    throw new IllegalArgumentException("notificationTitle requires using the default notification");
                }
                if (!TextUtils.isEmpty(NotificationSettings.zzc(zzVQ)))
                {
                    throw new IllegalArgumentException("notificationText requires using the default notification");
                }
                if (NotificationSettings.zzd(zzVQ) != null)
                {
                    throw new IllegalArgumentException("notificationPendingIntent requires using the default notification");
                }
            } else
            if (TextUtils.isEmpty(NotificationSettings.zzb(zzVQ)) && TextUtils.isEmpty(NotificationSettings.zzc(zzVQ)) && NotificationSettings.zzd(zzVQ) == null)
            {
                throw new IllegalArgumentException("At least an argument must be provided");
            }
            return zzVQ;
        }

        public NotificationSettings.Builder setNotification(Notification notification)
        {
            NotificationSettings.zza(zzVQ, notification);
            return this;
        }

        public NotificationSettings.Builder setNotificationPendingIntent(PendingIntent pendingintent)
        {
            NotificationSettings.zza(zzVQ, pendingintent);
            return this;
        }

        public NotificationSettings.Builder setNotificationText(String s)
        {
            NotificationSettings.zzb(zzVQ, s);
            return this;
        }

        public NotificationSettings.Builder setNotificationTitle(String s)
        {
            NotificationSettings.zza(zzVQ, s);
            return this;
        }

        public NotificationSettings.Builder()
        {
            zzVQ = new NotificationSettings();
        }
    }

    private class zza extends Binder
    {

        final CastRemoteDisplayLocalService zzVH;

        CastRemoteDisplayLocalService zzmw()
        {
            return zzVH;
        }

        private zza()
        {
            zzVH = CastRemoteDisplayLocalService.this;
            super();
        }

    }

    private static final class zzb extends BroadcastReceiver
    {

        public void onReceive(Context context, Intent intent)
        {
            if (intent.getAction().equals("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"))
            {
                CastRemoteDisplayLocalService.zzms().zzb("disconnecting", new Object[0]);
                CastRemoteDisplayLocalService.stopService();
            }
        }

        private zzb()
        {
        }

    }


    private static CastRemoteDisplayLocalService zzVF;
    private static final zzl zzVo = new zzl("CastRemoteDisplayLocalService");
    private static final int zzVp;
    private static final Object zzVq = new Object();
    private static AtomicBoolean zzVr = new AtomicBoolean(false);
    private Handler mHandler;
    private Notification mNotification;
    private String zzUM;
    private Display zzVA;
    private Context zzVB;
    private ServiceConnection zzVC;
    private MediaRouter zzVD;
    private final android.support.v7.media.MediaRouter.Callback zzVE = new android.support.v7.media.MediaRouter.Callback() {

        final CastRemoteDisplayLocalService zzVH;

        public void onRouteUnselected(MediaRouter mediarouter, android.support.v7.media.MediaRouter.RouteInfo routeinfo)
        {
            CastRemoteDisplayLocalService.zza(zzVH, "onRouteUnselected");
            if (CastRemoteDisplayLocalService.zza(zzVH) == null)
            {
                CastRemoteDisplayLocalService.zza(zzVH, "onRouteUnselected, no device was selected");
                return;
            }
            if (!CastDevice.getFromBundle(routeinfo.getExtras()).getDeviceId().equals(CastRemoteDisplayLocalService.zza(zzVH).getDeviceId()))
            {
                CastRemoteDisplayLocalService.zza(zzVH, "onRouteUnselected, device does not match");
                return;
            } else
            {
                CastRemoteDisplayLocalService.stopService();
                return;
            }
        }

            
            {
                zzVH = CastRemoteDisplayLocalService.this;
                super();
            }
    };
    private final IBinder zzVG = new zza();
    private GoogleApiClient zzVs;
    private CastRemoteDisplay.CastRemoteDisplaySessionCallbacks zzVt;
    private Callbacks zzVu;
    private zzb zzVv;
    private NotificationSettings zzVw;
    private Boolean zzVx;
    private PendingIntent zzVy;
    private CastDevice zzVz;

    public CastRemoteDisplayLocalService()
    {
    }

    public static CastRemoteDisplayLocalService getInstance()
    {
        CastRemoteDisplayLocalService castremotedisplaylocalservice;
        synchronized (zzVq)
        {
            castremotedisplaylocalservice = zzVF;
        }
        return castremotedisplaylocalservice;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected static void setDebugEnabled()
    {
        zzVo.zzX(true);
    }

    public static void startService(Context context, Class class1, String s, CastDevice castdevice, NotificationSettings notificationsettings, Callbacks callbacks)
    {
        zzVo.zzb("Starting Service", new Object[0]);
        synchronized (zzVq)
        {
            if (zzVF != null)
            {
                zzVo.zzf("An existing service had not been stopped before starting one", new Object[0]);
                zzR(true);
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
        if (zzVr.getAndSet(true))
        {
            zzVo.zzc("Service is already being started, startService has been called twice", new Object[0]);
            return;
        } else
        {
            class1 = new Intent(context, class1);
            context.startService(class1);
            context.bindService(class1, new ServiceConnection(s, castdevice, notificationsettings, context, callbacks) {

                final String zzUS;
                final CastDevice zzVI;
                final NotificationSettings zzVJ;
                final Context zzVK;
                final Callbacks zzVL;

                public void onServiceConnected(ComponentName componentname, IBinder ibinder)
                {
                    componentname = ((zza)ibinder).zzmw();
                    if (componentname != null && CastRemoteDisplayLocalService.zza(componentname, zzUS, zzVI, zzVJ, zzVK, this, zzVL))
                    {
                        break MISSING_BLOCK_LABEL_86;
                    }
                    CastRemoteDisplayLocalService.zzms().zzc("Connected but unable to get the service instance", new Object[0]);
                    zzVL.onRemoteDisplaySessionError(new Status(2200));
                    CastRemoteDisplayLocalService.zzmt().set(false);
                    zzVK.unbindService(this);
                    return;
                    componentname;
                    CastRemoteDisplayLocalService.zzms().zzb("No need to unbind service, already unbound", new Object[0]);
                    return;
                }

                public void onServiceDisconnected(ComponentName componentname)
                {
                    CastRemoteDisplayLocalService.zzms().zzb("onServiceDisconnected", new Object[0]);
                    zzVL.onRemoteDisplaySessionError(new Status(2201, "Service Disconnected"));
                    CastRemoteDisplayLocalService.zzmt().set(false);
                    try
                    {
                        zzVK.unbindService(this);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (ComponentName componentname)
                    {
                        CastRemoteDisplayLocalService.zzms().zzb("No need to unbind service, already unbound", new Object[0]);
                    }
                }

            
            {
                zzUS = s;
                zzVI = castdevice;
                zzVJ = notificationsettings;
                zzVK = context;
                zzVL = callbacks;
                super();
            }
            }, 64);
            return;
        }
    }

    public static void stopService()
    {
        zzR(false);
    }

    private void zzQ(boolean flag)
    {
        zzbb("Stopping Service");
        if (!flag && zzVD != null)
        {
            zzbb("Setting default route");
            zzVD.selectRoute(zzVD.getDefaultRoute());
        }
        if (zzVv != null)
        {
            zzbb("Unregistering notification receiver");
            unregisterReceiver(zzVv);
        }
        zzmp();
        zzmq();
        zzml();
        if (zzVs != null)
        {
            zzVs.disconnect();
            zzVs = null;
        }
        if (zzVB != null && zzVC != null)
        {
            try
            {
                zzVB.unbindService(zzVC);
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                zzbb("No need to unbind service, already unbound");
            }
            zzVC = null;
            zzVB = null;
        }
        zzUM = null;
        zzVs = null;
        mNotification = null;
        zzVA = null;
    }

    private static void zzR(boolean flag)
    {
label0:
        {
            zzVo.zzb("Stopping Service", new Object[0]);
            zzVr.set(false);
            synchronized (zzVq)
            {
                if (zzVF != null)
                {
                    break label0;
                }
                zzVo.zzc("Service is already being stopped", new Object[0]);
            }
            return;
        }
        CastRemoteDisplayLocalService castremotedisplaylocalservice;
        castremotedisplaylocalservice = zzVF;
        zzVF = null;
        obj;
        JVM INSTR monitorexit ;
        castremotedisplaylocalservice.zzQ(flag);
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private Notification zzS(boolean flag)
    {
        zzbb("createDefaultNotification");
        int k = getApplicationInfo().labelRes;
        String s2 = NotificationSettings.zzb(zzVw);
        String s1 = NotificationSettings.zzc(zzVw);
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
                zzVz.getFriendlyName()
            });
        }
        return (new android.support.v4.app.NotificationCompat.Builder(this)).setContentTitle(s).setContentText(s1).setContentIntent(NotificationSettings.zzd(zzVw)).setSmallIcon(i).setOngoing(true).addAction(0x1080038, getString(com.google.android.gms.R.string.cast_notification_disconnect), zzmr()).build();
    }

    static void zzT(boolean flag)
    {
        zzR(flag);
    }

    static Context zza(CastRemoteDisplayLocalService castremotedisplaylocalservice, Context context)
    {
        castremotedisplaylocalservice.zzVB = context;
        return context;
    }

    static ServiceConnection zza(CastRemoteDisplayLocalService castremotedisplaylocalservice, ServiceConnection serviceconnection)
    {
        castremotedisplaylocalservice.zzVC = serviceconnection;
        return serviceconnection;
    }

    static CastDevice zza(CastRemoteDisplayLocalService castremotedisplaylocalservice)
    {
        return castremotedisplaylocalservice.zzVz;
    }

    private GoogleApiClient zza(CastDevice castdevice)
    {
        castdevice = new CastRemoteDisplay.CastRemoteDisplayOptions.Builder(castdevice, zzVt);
        return (new com.google.android.gms.common.api.GoogleApiClient.Builder(this, new com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks() {

            final CastRemoteDisplayLocalService zzVH;

            public void onConnected(Bundle bundle)
            {
                CastRemoteDisplayLocalService.zza(zzVH, "onConnected");
                CastRemoteDisplayLocalService.zzf(zzVH);
            }

            public void onConnectionSuspended(int i)
            {
                CastRemoteDisplayLocalService.zzms().zzf(String.format("[Instance: %s] ConnectionSuspended %d", new Object[] {
                    this, Integer.valueOf(i)
                }), new Object[0]);
            }

            
            {
                zzVH = CastRemoteDisplayLocalService.this;
                super();
            }
        }, new com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener() {

            final CastRemoteDisplayLocalService zzVH;

            public void onConnectionFailed(ConnectionResult connectionresult)
            {
                CastRemoteDisplayLocalService.zzb(zzVH, (new StringBuilder()).append("Connection failed: ").append(connectionresult).toString());
                CastRemoteDisplayLocalService.zzc(zzVH);
            }

            
            {
                zzVH = CastRemoteDisplayLocalService.this;
                super();
            }
        })).addApi(CastRemoteDisplay.API, castdevice.build()).build();
    }

    private void zza(Display display)
    {
        zzVA = display;
        if (zzVx.booleanValue())
        {
            mNotification = zzS(true);
            startForeground(zzVp, mNotification);
        }
        if (zzVu != null)
        {
            zzVu.onRemoteDisplaySessionStarted(this);
            zzVu = null;
        }
        onCreatePresentation(zzVA);
    }

    static void zza(CastRemoteDisplayLocalService castremotedisplaylocalservice, Display display)
    {
        castremotedisplaylocalservice.zza(display);
    }

    static void zza(CastRemoteDisplayLocalService castremotedisplaylocalservice, String s)
    {
        castremotedisplaylocalservice.zzbb(s);
    }

    static boolean zza(CastRemoteDisplayLocalService castremotedisplaylocalservice, String s, CastDevice castdevice, NotificationSettings notificationsettings, Context context, ServiceConnection serviceconnection, Callbacks callbacks)
    {
        return castremotedisplaylocalservice.zza(s, castdevice, notificationsettings, context, serviceconnection, callbacks);
    }

    private boolean zza(String s, CastDevice castdevice, NotificationSettings notificationsettings, Context context, ServiceConnection serviceconnection, Callbacks callbacks)
    {
label0:
        {
            zzbb("startRemoteDisplaySession");
            zzx.zzci("Starting the Cast Remote Display must be done on the main thread");
            synchronized (zzVq)
            {
                if (zzVF == null)
                {
                    break label0;
                }
                zzVo.zzf("An existing service had not been stopped before starting one", new Object[0]);
            }
            return false;
        }
        zzVF = this;
        obj;
        JVM INSTR monitorexit ;
        zzVu = callbacks;
        zzUM = s;
        zzVz = castdevice;
        zzVB = context;
        zzVC = serviceconnection;
        zzVD = MediaRouter.getInstance(getApplicationContext());
        s = (new android.support.v7.media.MediaRouteSelector.Builder()).addControlCategory(CastMediaControlIntent.categoryForCast(zzUM)).build();
        zzbb("addMediaRouterCallback");
        zzVD.addCallback(s, zzVE, 4);
        mHandler = new Handler(getMainLooper());
        mNotification = NotificationSettings.zza(notificationsettings);
        zzVv = new zzb();
        registerReceiver(zzVv, new IntentFilter("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"));
        zzVw = new NotificationSettings(notificationsettings);
        if (NotificationSettings.zza(zzVw) == null)
        {
            zzVx = Boolean.valueOf(true);
            mNotification = zzS(false);
        } else
        {
            zzVx = Boolean.valueOf(false);
            mNotification = NotificationSettings.zza(zzVw);
        }
        startForeground(zzVp, mNotification);
        zzVs = zza(castdevice);
        zzVs.connect();
        return true;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    static Handler zzb(CastRemoteDisplayLocalService castremotedisplaylocalservice)
    {
        return castremotedisplaylocalservice.mHandler;
    }

    static Display zzb(CastRemoteDisplayLocalService castremotedisplaylocalservice, Display display)
    {
        castremotedisplaylocalservice.zzVA = display;
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
        castremotedisplaylocalservice.zzbe(s);
    }

    private void zzbb(String s)
    {
        zzVo.zzb("[Instance: %s] %s", new Object[] {
            this, s
        });
    }

    private void zzbe(String s)
    {
        zzVo.zzc("[Instance: %s] %s", new Object[] {
            this, s
        });
    }

    static void zzc(CastRemoteDisplayLocalService castremotedisplaylocalservice)
    {
        castremotedisplaylocalservice.zzmo();
    }

    static Context zzd(CastRemoteDisplayLocalService castremotedisplaylocalservice)
    {
        return castremotedisplaylocalservice.zzVB;
    }

    static ServiceConnection zze(CastRemoteDisplayLocalService castremotedisplaylocalservice)
    {
        return castremotedisplaylocalservice.zzVC;
    }

    static void zzf(CastRemoteDisplayLocalService castremotedisplaylocalservice)
    {
        castremotedisplaylocalservice.zzmm();
    }

    private void zzml()
    {
        if (zzVD != null)
        {
            zzx.zzci("CastRemoteDisplayLocalService calls must be done on the main thread");
            zzbb("removeMediaRouterCallback");
            zzVD.removeCallback(zzVE);
        }
    }

    private void zzmm()
    {
        zzbb("startRemoteDisplay");
        if (zzVs == null || !zzVs.isConnected())
        {
            zzVo.zzc("Unable to start the remote display as the API client is not ready", new Object[0]);
            return;
        } else
        {
            CastRemoteDisplay.CastRemoteDisplayApi.startRemoteDisplay(zzVs, zzUM).setResultCallback(new ResultCallback() {

                final CastRemoteDisplayLocalService zzVH;

                public void onResult(Result result)
                {
                    zza((CastRemoteDisplay.CastRemoteDisplaySessionResult)result);
                }

                public void zza(CastRemoteDisplay.CastRemoteDisplaySessionResult castremotedisplaysessionresult)
                {
                    if (castremotedisplaysessionresult.getStatus().isSuccess()) goto _L2; else goto _L1
_L1:
                    CastRemoteDisplayLocalService.zzms().zzc("Connection was not successful", new Object[0]);
                    CastRemoteDisplayLocalService.zzc(zzVH);
_L4:
                    return;
_L2:
                    CastRemoteDisplayLocalService.zzms().zzb("startRemoteDisplay successful", new Object[0]);
                    synchronized (CastRemoteDisplayLocalService.zzmu())
                    {
                        if (CastRemoteDisplayLocalService.zzmv() != null)
                        {
                            break MISSING_BLOCK_LABEL_83;
                        }
                        CastRemoteDisplayLocalService.zzms().zzb("Remote Display started but session already cancelled", new Object[0]);
                        CastRemoteDisplayLocalService.zzc(zzVH);
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
                        CastRemoteDisplayLocalService.zza(zzVH, castremotedisplaysessionresult);
                    } else
                    {
                        CastRemoteDisplayLocalService.zzms().zzc("Cast Remote Display session created without display", new Object[0]);
                    }
                    CastRemoteDisplayLocalService.zzmt().set(false);
                    if (CastRemoteDisplayLocalService.zzd(zzVH) != null && CastRemoteDisplayLocalService.zze(zzVH) != null)
                    {
                        try
                        {
                            CastRemoteDisplayLocalService.zzd(zzVH).unbindService(CastRemoteDisplayLocalService.zze(zzVH));
                        }
                        // Misplaced declaration of an exception variable
                        catch (CastRemoteDisplay.CastRemoteDisplaySessionResult castremotedisplaysessionresult)
                        {
                            CastRemoteDisplayLocalService.zzms().zzb("No need to unbind service, already unbound", new Object[0]);
                        }
                        CastRemoteDisplayLocalService.zza(zzVH, null);
                        CastRemoteDisplayLocalService.zza(zzVH, null);
                        return;
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

            
            {
                zzVH = CastRemoteDisplayLocalService.this;
                super();
            }
            });
            return;
        }
    }

    private void zzmn()
    {
        zzbb("stopRemoteDisplay");
        if (zzVs == null || !zzVs.isConnected())
        {
            zzVo.zzc("Unable to stop the remote display as the API client is not ready", new Object[0]);
            return;
        } else
        {
            CastRemoteDisplay.CastRemoteDisplayApi.stopRemoteDisplay(zzVs).setResultCallback(new ResultCallback() {

                final CastRemoteDisplayLocalService zzVH;

                public void onResult(Result result)
                {
                    zza((CastRemoteDisplay.CastRemoteDisplaySessionResult)result);
                }

                public void zza(CastRemoteDisplay.CastRemoteDisplaySessionResult castremotedisplaysessionresult)
                {
                    if (!castremotedisplaysessionresult.getStatus().isSuccess())
                    {
                        CastRemoteDisplayLocalService.zza(zzVH, "Unable to stop the remote display, result unsuccessful");
                    } else
                    {
                        CastRemoteDisplayLocalService.zza(zzVH, "remote display stopped");
                    }
                    CastRemoteDisplayLocalService.zzb(zzVH, null);
                }

            
            {
                zzVH = CastRemoteDisplayLocalService.this;
                super();
            }
            });
            return;
        }
    }

    private void zzmo()
    {
        if (zzVu != null)
        {
            zzVu.onRemoteDisplaySessionError(new Status(2200));
            zzVu = null;
        }
        stopService();
    }

    private void zzmp()
    {
        zzbb("stopRemoteDisplaySession");
        zzmn();
        onDismissPresentation();
    }

    private void zzmq()
    {
        zzbb("Stopping the remote display Service");
        stopForeground(true);
        stopSelf();
    }

    private PendingIntent zzmr()
    {
        if (zzVy == null)
        {
            zzVy = PendingIntent.getBroadcast(this, 0, new Intent("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"), 0x10000000);
        }
        return zzVy;
    }

    static zzl zzms()
    {
        return zzVo;
    }

    static AtomicBoolean zzmt()
    {
        return zzVr;
    }

    static Object zzmu()
    {
        return zzVq;
    }

    static CastRemoteDisplayLocalService zzmv()
    {
        return zzVF;
    }

    protected Display getDisplay()
    {
        return zzVA;
    }

    public IBinder onBind(Intent intent)
    {
        zzbb("onBind");
        return zzVG;
    }

    public void onCreate()
    {
        super.onCreate();
        zzVt = new CastRemoteDisplay.CastRemoteDisplaySessionCallbacks() {

            final CastRemoteDisplayLocalService zzVH;

            public void onRemoteDisplayEnded(Status status)
            {
                CastRemoteDisplayLocalService.zzms().zzb(String.format("Cast screen has ended: %d", new Object[] {
                    Integer.valueOf(status.getStatusCode())
                }), new Object[0]);
                if (CastRemoteDisplayLocalService.zzb(zzVH) != null)
                {
                    CastRemoteDisplayLocalService.zzb(zzVH).post(new Runnable(this) {

                        final _cls3 zzVM;

                        public void run()
                        {
                            CastRemoteDisplayLocalService.zzT(false);
                        }

            
            {
                zzVM = _pcls3;
                super();
            }
                    });
                }
            }

            
            {
                zzVH = CastRemoteDisplayLocalService.this;
                super();
            }
        };
    }

    public abstract void onCreatePresentation(Display display);

    public abstract void onDismissPresentation();

    public int onStartCommand(Intent intent, int i, int j)
    {
        zzbb("onStartCommand");
        return 2;
    }

    public void updateNotificationSettings(NotificationSettings notificationsettings)
    {
        zzx.zzb(notificationsettings, "notificationSettings is required.");
        if (zzVw == null)
        {
            throw new IllegalStateException("No current notification settings to update");
        }
        if (zzVx.booleanValue())
        {
            if (NotificationSettings.zza(notificationsettings) != null)
            {
                throw new IllegalStateException("Current mode is default notification, notification attribute must not be provided");
            }
            if (NotificationSettings.zzd(notificationsettings) != null)
            {
                NotificationSettings.zza(zzVw, NotificationSettings.zzd(notificationsettings));
            }
            if (!TextUtils.isEmpty(NotificationSettings.zzb(notificationsettings)))
            {
                NotificationSettings.zza(zzVw, NotificationSettings.zzb(notificationsettings));
            }
            if (!TextUtils.isEmpty(NotificationSettings.zzc(notificationsettings)))
            {
                NotificationSettings.zzb(zzVw, NotificationSettings.zzc(notificationsettings));
            }
            mNotification = zzS(true);
        } else
        {
            zzx.zzb(NotificationSettings.zza(notificationsettings), "notification is required.");
            mNotification = NotificationSettings.zza(notificationsettings);
            NotificationSettings.zza(zzVw, mNotification);
        }
        startForeground(zzVp, mNotification);
    }

    static 
    {
        zzVp = com.google.android.gms.R.id.cast_notification_id;
    }
}
