// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.internal;

import android.os.IInterface;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

// Referenced classes of package com.google.android.gms.maps.internal:
//            zzr, zzs, zzt, zzu

public interface IStreetViewPanoramaDelegate
    extends IInterface
{

    public abstract void animateTo(StreetViewPanoramaCamera streetviewpanoramacamera, long l);

    public abstract void enablePanning(boolean flag);

    public abstract void enableStreetNames(boolean flag);

    public abstract void enableUserNavigation(boolean flag);

    public abstract void enableZoom(boolean flag);

    public abstract StreetViewPanoramaCamera getPanoramaCamera();

    public abstract StreetViewPanoramaLocation getStreetViewPanoramaLocation();

    public abstract boolean isPanningGesturesEnabled();

    public abstract boolean isStreetNamesEnabled();

    public abstract boolean isUserNavigationEnabled();

    public abstract boolean isZoomGesturesEnabled();

    public abstract zzd orientationToPoint(StreetViewPanoramaOrientation streetviewpanoramaorientation);

    public abstract StreetViewPanoramaOrientation pointToOrientation(zzd zzd);

    public abstract void setOnStreetViewPanoramaCameraChangeListener(zzr zzr);

    public abstract void setOnStreetViewPanoramaChangeListener(zzs zzs);

    public abstract void setOnStreetViewPanoramaClickListener(zzt zzt);

    public abstract void setOnStreetViewPanoramaLongClickListener(zzu zzu);

    public abstract void setPosition(LatLng latlng);

    public abstract void setPositionWithID(String s);

    public abstract void setPositionWithRadius(LatLng latlng, int i);
}
