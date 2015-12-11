// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model.internal;

import android.os.IInterface;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public interface zzc
    extends IInterface
{

    public abstract float getBearing();

    public abstract LatLngBounds getBounds();

    public abstract float getHeight();

    public abstract String getId();

    public abstract LatLng getPosition();

    public abstract float getTransparency();

    public abstract float getWidth();

    public abstract float getZIndex();

    public abstract int hashCodeRemote();

    public abstract boolean isVisible();

    public abstract void remove();

    public abstract void setBearing(float f);

    public abstract void setDimensions(float f);

    public abstract void setPosition(LatLng latlng);

    public abstract void setPositionFromBounds(LatLngBounds latlngbounds);

    public abstract void setTransparency(float f);

    public abstract void setVisible(boolean flag);

    public abstract void setZIndex(float f);

    public abstract void zza(float f, float f1);

    public abstract boolean zza(zzc zzc1);

    public abstract void zzw(zzd zzd);
}
