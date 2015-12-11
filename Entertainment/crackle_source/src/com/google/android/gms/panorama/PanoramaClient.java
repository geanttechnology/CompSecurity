// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.panorama;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.hm;

public class PanoramaClient
    implements GooglePlayServicesClient
{
    public static interface OnPanoramaInfoLoadedListener
    {

        public abstract void onPanoramaInfoLoaded(ConnectionResult connectionresult, Intent intent);
    }


    private final hm Di;

    public PanoramaClient(Context context, com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        Di = new hm(context, connectioncallbacks, onconnectionfailedlistener);
    }

    public void connect()
    {
        Di.connect();
    }

    public void disconnect()
    {
        Di.disconnect();
    }

    public boolean isConnected()
    {
        return Di.isConnected();
    }

    public boolean isConnecting()
    {
        return Di.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
    {
        return Di.isConnectionCallbacksRegistered(connectioncallbacks);
    }

    public boolean isConnectionFailedListenerRegistered(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        return Di.isConnectionFailedListenerRegistered(onconnectionfailedlistener);
    }

    public void loadPanoramaInfo(OnPanoramaInfoLoadedListener onpanoramainfoloadedlistener, Uri uri)
    {
        Di.a(new com.google.android.gms.common.api.a.c(onpanoramainfoloadedlistener) {

            final OnPanoramaInfoLoadedListener Dj;
            final PanoramaClient Dk;

            public void a(Panorama.PanoramaResult panoramaresult)
            {
                Dj.onPanoramaInfoLoaded(panoramaresult.getStatus().bu(), panoramaresult.getViewerIntent());
            }

            public volatile void a(Object obj)
            {
                a((Panorama.PanoramaResult)obj);
            }

            
            {
                Dk = PanoramaClient.this;
                Dj = onpanoramainfoloadedlistener;
                super();
            }
        }, uri, false);
    }

    public void loadPanoramaInfoAndGrantAccess(OnPanoramaInfoLoadedListener onpanoramainfoloadedlistener, Uri uri)
    {
        Di.a(new com.google.android.gms.common.api.a.c(onpanoramainfoloadedlistener) {

            final OnPanoramaInfoLoadedListener Dj;
            final PanoramaClient Dk;

            public void a(Panorama.PanoramaResult panoramaresult)
            {
                Dj.onPanoramaInfoLoaded(panoramaresult.getStatus().bu(), panoramaresult.getViewerIntent());
            }

            public volatile void a(Object obj)
            {
                a((Panorama.PanoramaResult)obj);
            }

            
            {
                Dk = PanoramaClient.this;
                Dj = onpanoramainfoloadedlistener;
                super();
            }
        }, uri, true);
    }

    public void registerConnectionCallbacks(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
    {
        Di.registerConnectionCallbacks(connectioncallbacks);
    }

    public void registerConnectionFailedListener(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        Di.registerConnectionFailedListener(onconnectionfailedlistener);
    }

    public void unregisterConnectionCallbacks(com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks connectioncallbacks)
    {
        Di.unregisterConnectionCallbacks(connectioncallbacks);
    }

    public void unregisterConnectionFailedListener(com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        Di.unregisterConnectionFailedListener(onconnectionfailedlistener);
    }
}
