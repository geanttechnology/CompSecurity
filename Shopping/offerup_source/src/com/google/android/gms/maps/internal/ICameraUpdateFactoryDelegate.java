// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.internal;

import android.os.IInterface;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public interface ICameraUpdateFactoryDelegate
    extends IInterface
{

    public abstract zzd newCameraPosition(CameraPosition cameraposition);

    public abstract zzd newLatLng(LatLng latlng);

    public abstract zzd newLatLngBounds(LatLngBounds latlngbounds, int i);

    public abstract zzd newLatLngBoundsWithSize(LatLngBounds latlngbounds, int i, int j, int k);

    public abstract zzd newLatLngZoom(LatLng latlng, float f);

    public abstract zzd scrollBy(float f, float f1);

    public abstract zzd zoomBy(float f);

    public abstract zzd zoomByWithFocus(float f, int i, int j);

    public abstract zzd zoomIn();

    public abstract zzd zoomOut();

    public abstract zzd zoomTo(float f);
}
