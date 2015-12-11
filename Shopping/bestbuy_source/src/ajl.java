// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.IInterface;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public interface ajl
    extends IInterface
{

    public abstract ry a();

    public abstract ry a(float f);

    public abstract ry a(float f, float f1);

    public abstract ry a(float f, int i, int j);

    public abstract ry a(CameraPosition cameraposition);

    public abstract ry a(LatLng latlng);

    public abstract ry a(LatLng latlng, float f);

    public abstract ry a(LatLngBounds latlngbounds, int i);

    public abstract ry a(LatLngBounds latlngbounds, int i, int j, int k);

    public abstract ry b();

    public abstract ry b(float f);
}
