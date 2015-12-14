// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.connectivity;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;

public class NetworkConnectivity
{
    public static final class ConnectionStatus extends Enum
    {

        private static final ConnectionStatus $VALUES[];
        public static final ConnectionStatus ETHERNET;
        public static final ConnectionStatus NONE;
        public static final ConnectionStatus WAN;
        public static final ConnectionStatus WIFI;

        public static ConnectionStatus valueOf(String s)
        {
            return (ConnectionStatus)Enum.valueOf(com/amazon/gallery/framework/network/connectivity/NetworkConnectivity$ConnectionStatus, s);
        }

        public static ConnectionStatus[] values()
        {
            return (ConnectionStatus[])$VALUES.clone();
        }

        static 
        {
            NONE = new ConnectionStatus("NONE", 0);
            WAN = new ConnectionStatus("WAN", 1);
            WIFI = new ConnectionStatus("WIFI", 2);
            ETHERNET = new ConnectionStatus("ETHERNET", 3);
            $VALUES = (new ConnectionStatus[] {
                NONE, WAN, WIFI, ETHERNET
            });
        }

        private ConnectionStatus(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class NetworkOperationType extends Enum
    {

        private static final NetworkOperationType $VALUES[];
        public static final NetworkOperationType CMS;
        public static final NetworkOperationType DOWNLOAD_FOREGROUND;
        public static final NetworkOperationType METRICS_UPLOAD;
        public static final NetworkOperationType MOBILE_UPLOAD;
        public static final NetworkOperationType POLLING_SYNC_FOREGROUND;
        public static final NetworkOperationType PREFETCH_BACKGROUND;
        public static final NetworkOperationType PREFETCH_FOREGROUND;
        public static final NetworkOperationType STATECHANGE_SYNC_FOREGROUND;
        public static final NetworkOperationType SYNC_BACKGROUND;
        public static final NetworkOperationType WIFI_ONLY_UPLOAD;

        public static NetworkOperationType valueOf(String s)
        {
            return (NetworkOperationType)Enum.valueOf(com/amazon/gallery/framework/network/connectivity/NetworkConnectivity$NetworkOperationType, s);
        }

        public static NetworkOperationType[] values()
        {
            return (NetworkOperationType[])$VALUES.clone();
        }

        static 
        {
            CMS = new NetworkOperationType("CMS", 0);
            PREFETCH_BACKGROUND = new NetworkOperationType("PREFETCH_BACKGROUND", 1);
            PREFETCH_FOREGROUND = new NetworkOperationType("PREFETCH_FOREGROUND", 2);
            DOWNLOAD_FOREGROUND = new NetworkOperationType("DOWNLOAD_FOREGROUND", 3);
            METRICS_UPLOAD = new NetworkOperationType("METRICS_UPLOAD", 4);
            SYNC_BACKGROUND = new NetworkOperationType("SYNC_BACKGROUND", 5);
            STATECHANGE_SYNC_FOREGROUND = new NetworkOperationType("STATECHANGE_SYNC_FOREGROUND", 6);
            POLLING_SYNC_FOREGROUND = new NetworkOperationType("POLLING_SYNC_FOREGROUND", 7);
            WIFI_ONLY_UPLOAD = new NetworkOperationType("WIFI_ONLY_UPLOAD", 8);
            MOBILE_UPLOAD = new NetworkOperationType("MOBILE_UPLOAD", 9);
            $VALUES = (new NetworkOperationType[] {
                CMS, PREFETCH_BACKGROUND, PREFETCH_FOREGROUND, DOWNLOAD_FOREGROUND, METRICS_UPLOAD, SYNC_BACKGROUND, STATECHANGE_SYNC_FOREGROUND, POLLING_SYNC_FOREGROUND, WIFI_ONLY_UPLOAD, MOBILE_UPLOAD
            });
        }

        private NetworkOperationType(String s, int i)
        {
            super(s, i);
        }
    }


    private final ConnectivityManager connectivityManager;
    protected final Context context;
    private boolean errorCountExceeded;

    public NetworkConnectivity(Context context1)
    {
        errorCountExceeded = false;
        context = context1;
        connectivityManager = (ConnectivityManager)context1.getSystemService("connectivity");
    }

    private boolean canSyncBackground()
    {
        for (NetworkInfo networkinfo = connectivityManager.getActiveNetworkInfo(); !isNetworkConnected() || networkinfo == null || getBuildVersionSdkInt() >= 14 && networkinfo.getDetailedState() == android.net.NetworkInfo.DetailedState.BLOCKED;)
        {
            return false;
        }

        return true;
    }

    private ConnectionStatus getActiveNetworkStatus()
    {
        NetworkInfo networkinfo = connectivityManager.getActiveNetworkInfo();
        if (networkinfo == null || !networkinfo.isConnected())
        {
            return ConnectionStatus.NONE;
        }
        switch (networkinfo.getType())
        {
        default:
            return ConnectionStatus.NONE;

        case 1: // '\001'
            return ConnectionStatus.WIFI;

        case 0: // '\0'
            return ConnectionStatus.WAN;

        case 9: // '\t'
            return ConnectionStatus.ETHERNET;
        }
    }

    protected AlertDialog createNoWifiAlertDialog(Context context1)
    {
        return (new android.support.v7.app.AlertDialog.Builder(context1)).setMessage("Implement a dialog to display when there is no wifi connectivity. I'm in gallery-network/com.amazon.gallery.framework.network.connectivity").setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {

            final NetworkConnectivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = NetworkConnectivity.this;
                super();
            }
        }).create();
    }

    protected int getBuildVersionSdkInt()
    {
        return android.os.Build.VERSION.SDK_INT;
    }

    public ConnectionStatus getConnectionStatus()
    {
        return getActiveNetworkStatus();
    }

    public boolean hasExceededErrorLimit()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = errorCountExceeded;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isNetworkAccessAllowed(NetworkOperationType networkoperationtype)
    {
        static class _cls2
        {

            static final int $SwitchMap$com$amazon$gallery$framework$network$connectivity$NetworkConnectivity$NetworkOperationType[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$network$connectivity$NetworkConnectivity$NetworkOperationType = new int[NetworkOperationType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$connectivity$NetworkConnectivity$NetworkOperationType[NetworkOperationType.CMS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$connectivity$NetworkConnectivity$NetworkOperationType[NetworkOperationType.PREFETCH_BACKGROUND.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$connectivity$NetworkConnectivity$NetworkOperationType[NetworkOperationType.PREFETCH_FOREGROUND.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$connectivity$NetworkConnectivity$NetworkOperationType[NetworkOperationType.POLLING_SYNC_FOREGROUND.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$connectivity$NetworkConnectivity$NetworkOperationType[NetworkOperationType.METRICS_UPLOAD.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$connectivity$NetworkConnectivity$NetworkOperationType[NetworkOperationType.WIFI_ONLY_UPLOAD.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$connectivity$NetworkConnectivity$NetworkOperationType[NetworkOperationType.SYNC_BACKGROUND.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$connectivity$NetworkConnectivity$NetworkOperationType[NetworkOperationType.DOWNLOAD_FOREGROUND.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$connectivity$NetworkConnectivity$NetworkOperationType[NetworkOperationType.STATECHANGE_SYNC_FOREGROUND.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$network$connectivity$NetworkConnectivity$NetworkOperationType[NetworkOperationType.MOBILE_UPLOAD.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2..SwitchMap.com.amazon.gallery.framework.network.connectivity.NetworkConnectivity.NetworkOperationType[networkoperationtype.ordinal()];
        JVM INSTR tableswitch 1 10: default 64
    //                   1 66
    //                   2 66
    //                   3 66
    //                   4 66
    //                   5 66
    //                   6 66
    //                   7 87
    //                   8 92
    //                   9 92
    //                   10 92;
           goto _L1 _L2 _L2 _L2 _L2 _L2 _L2 _L3 _L4 _L4 _L4
_L1:
        return false;
_L2:
        if ((networkoperationtype = getConnectionStatus()) == ConnectionStatus.WIFI || networkoperationtype == ConnectionStatus.ETHERNET)
        {
            return true;
        }
          goto _L1
_L3:
        return canSyncBackground();
_L4:
        return isNetworkConnected();
    }

    public boolean isNetworkConnected()
    {
        return getConnectionStatus() != ConnectionStatus.NONE;
    }

    public boolean promptIfOffline(Context context1)
    {
        if (getConnectionStatus() == ConnectionStatus.NONE)
        {
            promptNoWifi(context1);
            return true;
        } else
        {
            return false;
        }
    }

    public AlertDialog promptNoWifi(Context context1)
    {
        context1 = createNoWifiAlertDialog(context1);
        context1.show();
        return context1;
    }

    public void updateErrorCount(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        errorCountExceeded = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
