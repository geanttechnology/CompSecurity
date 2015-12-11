// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IInterface;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.a;
import com.google.android.gms.location.d;
import com.google.android.gms.location.f;
import com.google.android.gms.location.j;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            il, gt, hi, jd, 
//            gv, gh, ii

public interface io
    extends IInterface
{

    public abstract Location a();

    public abstract Location a(String s);

    public abstract void a(long l, boolean flag, PendingIntent pendingintent);

    public abstract void a(PendingIntent pendingintent);

    public abstract void a(PendingIntent pendingintent, il il, String s);

    public abstract void a(Location location);

    public abstract void a(Location location, int i);

    public abstract void a(gt gt, hi hi, jd jd);

    public abstract void a(gv gv, hi hi, PendingIntent pendingintent);

    public abstract void a(hi hi, PendingIntent pendingintent);

    public abstract void a(il il, String s);

    public abstract void a(LocationRequest locationrequest, PendingIntent pendingintent);

    public abstract void a(LocationRequest locationrequest, j j);

    public abstract void a(LocationRequest locationrequest, j j, String s);

    public abstract void a(j j);

    public abstract void a(LatLng latlng, gt gt, hi hi, jd jd);

    public abstract void a(LatLngBounds latlngbounds, int i, gt gt, hi hi, jd jd);

    public abstract void a(String s, gh gh, ii ii);

    public abstract void a(String s, hi hi, jd jd);

    public abstract void a(String s, ii ii);

    public abstract void a(String s, a a1, ii ii);

    public abstract void a(String s, f f, ii ii);

    public abstract void a(String s, String s1, hi hi);

    public abstract void a(String s, boolean flag, ii ii);

    public abstract void a(List list);

    public abstract void a(List list, PendingIntent pendingintent, il il, String s);

    public abstract void a(boolean flag);

    public abstract void a(String as[], il il, String s);

    public abstract d b(String s);

    public abstract void b(PendingIntent pendingintent);

    public abstract void b(String s, ii ii);

    public abstract void b(String s, f f, ii ii);
}
