// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zza;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

// Referenced classes of package com.google.android.gms.maps:
//            GoogleMapOptions, GoogleMap, OnMapReadyCallback

public class MapView extends FrameLayout
{

    private GoogleMap zzaIO;
    private final zzb zzaIU;

    public MapView(Context context)
    {
        super(context);
    /* block-local class not found */
    class zzb {}

        zzaIU = new zzb(context, null);
        init();
    }

    public MapView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        zzaIU = new zzb(context, GoogleMapOptions.createFromAttributes(context, attributeset));
        init();
    }

    public MapView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        zzaIU = new zzb(context, GoogleMapOptions.createFromAttributes(context, attributeset));
        init();
    }

    public MapView(Context context, GoogleMapOptions googlemapoptions)
    {
        super(context);
        zzaIU = new zzb(context, googlemapoptions);
        init();
    }

    private void init()
    {
        setClickable(true);
    }

    public final GoogleMap getMap()
    {
        if (zzaIO != null)
        {
            return zzaIO;
        }
        zzaIU.zzxL();
        if (zzaIU.zzrZ() == null)
        {
            return null;
        }
    /* block-local class not found */
    class zza {}

        try
        {
            zzaIO = new GoogleMap(((zza)zzaIU.zzrZ()).zzxM().getMap());
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return zzaIO;
    }

    public void getMapAsync(OnMapReadyCallback onmapreadycallback)
    {
        zzx.zzci("getMapAsync() must be called on the main thread");
        zzaIU.getMapAsync(onmapreadycallback);
    }

    public final void onCreate(Bundle bundle)
    {
        zzaIU.onCreate(bundle);
        if (zzaIU.zzrZ() == null)
        {
            com.google.android.gms.dynamic.zza.zzb(this);
        }
    }

    public final void onDestroy()
    {
        zzaIU.onDestroy();
    }

    public final void onEnterAmbient(Bundle bundle)
    {
        zzx.zzci("onEnterAmbient() must be called on the main thread");
        zzaIU.onEnterAmbient(bundle);
    }

    public final void onExitAmbient()
    {
        zzx.zzci("onExitAmbient() must be called on the main thread");
        zzaIU.onExitAmbient();
    }

    public final void onLowMemory()
    {
        zzaIU.onLowMemory();
    }

    public final void onPause()
    {
        zzaIU.onPause();
    }

    public final void onResume()
    {
        zzaIU.onResume();
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        zzaIU.onSaveInstanceState(bundle);
    }
}
