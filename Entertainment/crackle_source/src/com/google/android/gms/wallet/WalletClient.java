// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.app.Activity;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.internal.iu;

// Referenced classes of package com.google.android.gms.wallet:
//            FullWalletRequest, MaskedWalletRequest, NotifyTransactionStatusRequest

public class WalletClient
    implements GooglePlayServicesClient
{

    private final iu Hj;

    public WalletClient(Activity activity, int i, String s, int j, com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        Hj = new iu(activity, connectioncallbacks, onconnectionfailedlistener, i, s, j);
    }

    public WalletClient(Activity activity, int i, String s, com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        this(activity, i, s, 0, connectioncallbacks, onconnectionfailedlistener);
    }

    public void changeMaskedWallet(String s, String s1, int i)
    {
        Hj.changeMaskedWallet(s, s1, i);
    }

    public void checkForPreAuthorization(int i)
    {
        Hj.checkForPreAuthorization(i);
    }

    public void connect()
    {
        Hj.connect();
    }

    public void disconnect()
    {
        Hj.disconnect();
    }

    public boolean isConnected()
    {
        return Hj.isConnected();
    }

    public boolean isConnecting()
    {
        return Hj.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
    {
        return Hj.isConnectionCallbacksRegistered(connectioncallbacks);
    }

    public boolean isConnectionFailedListenerRegistered(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        return Hj.isConnectionFailedListenerRegistered(onconnectionfailedlistener);
    }

    public void loadFullWallet(FullWalletRequest fullwalletrequest, int i)
    {
        Hj.loadFullWallet(fullwalletrequest, i);
    }

    public void loadMaskedWallet(MaskedWalletRequest maskedwalletrequest, int i)
    {
        Hj.loadMaskedWallet(maskedwalletrequest, i);
    }

    public void notifyTransactionStatus(NotifyTransactionStatusRequest notifytransactionstatusrequest)
    {
        Hj.notifyTransactionStatus(notifytransactionstatusrequest);
    }

    public void registerConnectionCallbacks(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
    {
        Hj.registerConnectionCallbacks(connectioncallbacks);
    }

    public void registerConnectionFailedListener(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        Hj.registerConnectionFailedListener(onconnectionfailedlistener);
    }

    public void unregisterConnectionCallbacks(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
    {
        Hj.unregisterConnectionCallbacks(connectioncallbacks);
    }

    public void unregisterConnectionFailedListener(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        Hj.unregisterConnectionFailedListener(onconnectionfailedlistener);
    }
}
