// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.PendingIntent;
import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.nl;
import com.google.android.gms.internal.nq;
import com.google.android.gms.internal.ns;
import com.google.android.gms.internal.nu;
import com.google.android.gms.internal.nw;
import com.google.android.gms.internal.ny;
import com.google.android.gms.internal.oc;
import com.google.android.gms.internal.oe;
import com.google.android.gms.internal.oh;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.e;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;

public interface aex
    extends IInterface
{

    public abstract Location a();

    public abstract Location a(String s);

    public abstract void a(long l, boolean flag, PendingIntent pendingintent);

    public abstract void a(aeu aeu, String s);

    public abstract void a(aic aic);

    public abstract void a(PendingIntent pendingintent);

    public abstract void a(PendingIntent pendingintent, aeu aeu, String s);

    public abstract void a(Location location);

    public abstract void a(Location location, int i);

    public abstract void a(nl nl, aic aic);

    public abstract void a(nl nl, PendingIntent pendingintent);

    public abstract void a(ns ns, oh oh, PendingIntent pendingintent);

    public abstract void a(nu nu, oh oh, afu afu);

    public abstract void a(nw nw, oh oh);

    public abstract void a(ny ny, oh oh, PendingIntent pendingintent);

    public abstract void a(oc oc, oh oh, afu afu);

    public abstract void a(oe oe, LatLngBounds latlngbounds, List list, oh oh, afu afu);

    public abstract void a(oh oh, PendingIntent pendingintent);

    public abstract void a(GeofencingRequest geofencingrequest, PendingIntent pendingintent, aeu aeu);

    public abstract void a(LocationRequest locationrequest, aic aic);

    public abstract void a(LocationRequest locationrequest, aic aic, String s);

    public abstract void a(LocationRequest locationrequest, PendingIntent pendingintent);

    public abstract void a(LatLng latlng, nu nu, oh oh, afu afu);

    public abstract void a(LatLngBounds latlngbounds, int i, nu nu, oh oh, afu afu);

    public abstract void a(LatLngBounds latlngbounds, int i, String s, nu nu, oh oh, afu afu);

    public abstract void a(String s, oh oh, afu afu);

    public abstract void a(String s, LatLngBounds latlngbounds, nq nq, oh oh, afu afu);

    public abstract void a(List list, PendingIntent pendingintent, aeu aeu, String s);

    public abstract void a(List list, oh oh, afu afu);

    public abstract void a(boolean flag);

    public abstract void a(String as[], aeu aeu, String s);

    public abstract IBinder b();

    public abstract e b(String s);

    public abstract void b(PendingIntent pendingintent);

    public abstract void b(oh oh, PendingIntent pendingintent);

    public abstract void b(String s, oh oh, afu afu);

    public abstract IBinder c();
}
