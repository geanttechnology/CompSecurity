// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.zzi;

// Referenced classes of package com.google.android.gms.maps:
//            CameraUpdate, UiSettings

public final class GoogleMap
{
    public static interface CancelableCallback
    {

        public abstract void onCancel();

        public abstract void onFinish();
    }

    public static interface InfoWindowAdapter
    {

        public abstract View getInfoContents(Marker marker);

        public abstract View getInfoWindow(Marker marker);
    }

    public static interface OnMarkerClickListener
    {

        public abstract boolean onMarkerClick(Marker marker);
    }

    public static interface OnMyLocationButtonClickListener
    {

        public abstract boolean onMyLocationButtonClick();
    }

    private static final class zza extends com.google.android.gms.maps.internal.zzb.zza
    {

        private final CancelableCallback zzaBH;

        public void onCancel()
        {
            zzaBH.onCancel();
        }

        public void onFinish()
        {
            zzaBH.onFinish();
        }

        zza(CancelableCallback cancelablecallback)
        {
            zzaBH = cancelablecallback;
        }
    }


    private final IGoogleMapDelegate zzaBp;
    private UiSettings zzaBq;

    protected GoogleMap(IGoogleMapDelegate igooglemapdelegate)
    {
        zzaBp = (IGoogleMapDelegate)zzu.zzu(igooglemapdelegate);
    }

    public final Marker addMarker(MarkerOptions markeroptions)
    {
        try
        {
            markeroptions = zzaBp.addMarker(markeroptions);
        }
        // Misplaced declaration of an exception variable
        catch (MarkerOptions markeroptions)
        {
            throw new RuntimeRemoteException(markeroptions);
        }
        if (markeroptions == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        markeroptions = new Marker(markeroptions);
        return markeroptions;
        return null;
    }

    public final void animateCamera(CameraUpdate cameraupdate, int i, CancelableCallback cancelablecallback)
    {
        IGoogleMapDelegate igooglemapdelegate;
        zzd zzd;
        try
        {
            igooglemapdelegate = zzaBp;
            zzd = cameraupdate.zzvg();
        }
        // Misplaced declaration of an exception variable
        catch (CameraUpdate cameraupdate)
        {
            throw new RuntimeRemoteException(cameraupdate);
        }
        if (cancelablecallback != null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        cameraupdate = null;
        igooglemapdelegate.animateCameraWithDurationAndCallback(zzd, i, cameraupdate);
        return;
        cameraupdate = new zza(cancelablecallback);
        break MISSING_BLOCK_LABEL_18;
    }

    public final void clear()
    {
        try
        {
            zzaBp.clear();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final CameraPosition getCameraPosition()
    {
        CameraPosition cameraposition;
        try
        {
            cameraposition = zzaBp.getCameraPosition();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return cameraposition;
    }

    public final UiSettings getUiSettings()
    {
        UiSettings uisettings;
        try
        {
            if (zzaBq == null)
            {
                zzaBq = new UiSettings(zzaBp.getUiSettings());
            }
            uisettings = zzaBq;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return uisettings;
    }

    public final void moveCamera(CameraUpdate cameraupdate)
    {
        try
        {
            zzaBp.moveCamera(cameraupdate.zzvg());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (CameraUpdate cameraupdate)
        {
            throw new RuntimeRemoteException(cameraupdate);
        }
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter infowindowadapter)
    {
        if (infowindowadapter == null)
        {
            try
            {
                zzaBp.setInfoWindowAdapter(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (InfoWindowAdapter infowindowadapter)
            {
                throw new RuntimeRemoteException(infowindowadapter);
            }
        }
        zzaBp.setInfoWindowAdapter(new com.google.android.gms.maps.internal.zzd.zza(infowindowadapter) {

            final InfoWindowAdapter zzaBG;
            final GoogleMap zzaBs;

            public zzd zzf(zzi zzi)
            {
                return zze.zzw(zzaBG.getInfoWindow(new Marker(zzi)));
            }

            public zzd zzg(zzi zzi)
            {
                return zze.zzw(zzaBG.getInfoContents(new Marker(zzi)));
            }

            
            {
                zzaBs = GoogleMap.this;
                zzaBG = infowindowadapter;
                super();
            }
        });
        return;
    }

    public final void setMapType(int i)
    {
        try
        {
            zzaBp.setMapType(i);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setMyLocationEnabled(boolean flag)
    {
        try
        {
            zzaBp.setMyLocationEnabled(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener onmarkerclicklistener)
    {
        if (onmarkerclicklistener == null)
        {
            try
            {
                zzaBp.setOnMarkerClickListener(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnMarkerClickListener onmarkerclicklistener)
            {
                throw new RuntimeRemoteException(onmarkerclicklistener);
            }
        }
        zzaBp.setOnMarkerClickListener(new com.google.android.gms.maps.internal.zzn.zza(onmarkerclicklistener) {

            final OnMarkerClickListener zzaBD;
            final GoogleMap zzaBs;

            public boolean zza(zzi zzi)
            {
                return zzaBD.onMarkerClick(new Marker(zzi));
            }

            
            {
                zzaBs = GoogleMap.this;
                zzaBD = onmarkerclicklistener;
                super();
            }
        });
        return;
    }

    public final void setOnMyLocationButtonClickListener(OnMyLocationButtonClickListener onmylocationbuttonclicklistener)
    {
        if (onmylocationbuttonclicklistener == null)
        {
            try
            {
                zzaBp.setOnMyLocationButtonClickListener(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnMyLocationButtonClickListener onmylocationbuttonclicklistener)
            {
                throw new RuntimeRemoteException(onmylocationbuttonclicklistener);
            }
        }
        zzaBp.setOnMyLocationButtonClickListener(new com.google.android.gms.maps.internal.zzp.zza(onmylocationbuttonclicklistener) {

            final GoogleMap zzaBs;
            final OnMyLocationButtonClickListener zzaBu;

            public boolean onMyLocationButtonClick()
                throws RemoteException
            {
                return zzaBu.onMyLocationButtonClick();
            }

            
            {
                zzaBs = GoogleMap.this;
                zzaBu = onmylocationbuttonclicklistener;
                super();
            }
        });
        return;
    }

    IGoogleMapDelegate zzvi()
    {
        return zzaBp;
    }
}
