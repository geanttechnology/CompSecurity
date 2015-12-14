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
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

// Referenced classes of package com.google.android.gms.maps:
//            StreetViewPanorama, StreetViewPanoramaOptions, OnStreetViewPanoramaReadyCallback

public class StreetViewPanoramaView extends FrameLayout
{

    private StreetViewPanorama zzaJj;
    private final zzb zzaJv;

    public StreetViewPanoramaView(Context context)
    {
        super(context);
        zzaJv = new zzb(context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        zzaJv = new zzb(context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        zzaJv = new zzb(context, null);
    }

    public StreetViewPanoramaView(Context context, StreetViewPanoramaOptions streetviewpanoramaoptions)
    {
        super(context);
        zzaJv = new zzb(context, streetviewpanoramaoptions);
    }

    public final StreetViewPanorama getStreetViewPanorama()
    {
        if (zzaJj != null)
        {
            return zzaJj;
        }
        zzaJv.zzxL();
        if (zzaJv.zzrZ() == null)
        {
            return null;
        }
        try
        {
            zzaJj = new StreetViewPanorama(((zza)zzaJv.zzrZ()).zzxS().getStreetViewPanorama());
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return zzaJj;
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onstreetviewpanoramareadycallback)
    {
        zzx.zzci("getStreetViewPanoramaAsync() must be called on the main thread");
        zzaJv.getStreetViewPanoramaAsync(onstreetviewpanoramareadycallback);
    }

    public final void onCreate(Bundle bundle)
    {
        zzaJv.onCreate(bundle);
        if (zzaJv.zzrZ() == null)
        {
            com.google.android.gms.dynamic.zza.zzb(this);
        }
    }

    public final void onDestroy()
    {
        zzaJv.onDestroy();
    }

    public final void onLowMemory()
    {
        zzaJv.onLowMemory();
    }

    public final void onPause()
    {
        zzaJv.onPause();
    }

    public final void onResume()
    {
        zzaJv.onResume();
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        zzaJv.onSaveInstanceState(bundle);
    }

    /* member class not found */
    class zzb {}


    /* member class not found */
    class zza {}

}
