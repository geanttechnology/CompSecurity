// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;
import com.google.android.gms.maps.model.internal.zzb;
import com.google.android.gms.maps.model.internal.zzc;
import com.google.android.gms.maps.model.internal.zzf;
import com.google.android.gms.maps.model.internal.zzg;
import com.google.android.gms.maps.model.internal.zzh;

// Referenced classes of package com.google.android.gms.maps.internal:
//            zzb, zzl, IProjectionDelegate, IUiSettingsDelegate, 
//            zzd, ILocationSourceDelegate, zze, zzf, 
//            zzg, zzi, zzj, zzk, 
//            zzm, zzn, zzo, zzp, 
//            zzq, zzw

public interface IGoogleMapDelegate
    extends IInterface
{

    public abstract zzb addCircle(CircleOptions circleoptions);

    public abstract zzc addGroundOverlay(GroundOverlayOptions groundoverlayoptions);

    public abstract zzf addMarker(MarkerOptions markeroptions);

    public abstract zzg addPolygon(PolygonOptions polygonoptions);

    public abstract IPolylineDelegate addPolyline(PolylineOptions polylineoptions);

    public abstract zzh addTileOverlay(TileOverlayOptions tileoverlayoptions);

    public abstract void animateCamera(zzd zzd);

    public abstract void animateCameraWithCallback(zzd zzd, com.google.android.gms.maps.internal.zzb zzb);

    public abstract void animateCameraWithDurationAndCallback(zzd zzd, int i, com.google.android.gms.maps.internal.zzb zzb);

    public abstract void clear();

    public abstract CameraPosition getCameraPosition();

    public abstract com.google.android.gms.maps.model.internal.zzd getFocusedBuilding();

    public abstract void getMapAsync(zzl zzl);

    public abstract int getMapType();

    public abstract float getMaxZoomLevel();

    public abstract float getMinZoomLevel();

    public abstract Location getMyLocation();

    public abstract IProjectionDelegate getProjection();

    public abstract IUiSettingsDelegate getUiSettings();

    public abstract boolean isBuildingsEnabled();

    public abstract boolean isIndoorEnabled();

    public abstract boolean isMyLocationEnabled();

    public abstract boolean isTrafficEnabled();

    public abstract void moveCamera(zzd zzd);

    public abstract void onCreate(Bundle bundle);

    public abstract void onDestroy();

    public abstract void onEnterAmbient(Bundle bundle);

    public abstract void onExitAmbient();

    public abstract void onLowMemory();

    public abstract void onPause();

    public abstract void onResume();

    public abstract void onSaveInstanceState(Bundle bundle);

    public abstract void setBuildingsEnabled(boolean flag);

    public abstract void setContentDescription(String s);

    public abstract boolean setIndoorEnabled(boolean flag);

    public abstract void setInfoWindowAdapter(com.google.android.gms.maps.internal.zzd zzd);

    public abstract void setLocationSource(ILocationSourceDelegate ilocationsourcedelegate);

    public abstract void setMapType(int i);

    public abstract void setMyLocationEnabled(boolean flag);

    public abstract void setOnCameraChangeListener(zze zze);

    public abstract void setOnIndoorStateChangeListener(com.google.android.gms.maps.internal.zzf zzf);

    public abstract void setOnInfoWindowClickListener(com.google.android.gms.maps.internal.zzg zzg);

    public abstract void setOnMapClickListener(zzi zzi);

    public abstract void setOnMapLoadedCallback(zzj zzj);

    public abstract void setOnMapLongClickListener(zzk zzk);

    public abstract void setOnMarkerClickListener(zzm zzm);

    public abstract void setOnMarkerDragListener(zzn zzn);

    public abstract void setOnMyLocationButtonClickListener(zzo zzo);

    public abstract void setOnMyLocationChangeListener(zzp zzp);

    public abstract void setOnPoiClickListener(zzq zzq);

    public abstract void setPadding(int i, int j, int k, int l);

    public abstract void setTrafficEnabled(boolean flag);

    public abstract void snapshot(zzw zzw, zzd zzd);

    public abstract void stopAnimation();

    public abstract boolean useViewLifecycleWhenInFragment();
}
