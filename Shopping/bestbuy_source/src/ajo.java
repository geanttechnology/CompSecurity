// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.location.Location;
import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.c;
import com.google.android.gms.maps.model.internal.e;
import com.google.android.gms.maps.model.internal.p;

public interface ajo
    extends IInterface
{

    public abstract anx a(PolylineOptions polylineoptions);

    public abstract aog a(CircleOptions circleoptions);

    public abstract aoj a(GroundOverlayOptions groundoverlayoptions);

    public abstract aoj a(GroundOverlayOptions groundoverlayoptions, e e1);

    public abstract aop a(MarkerOptions markeroptions);

    public abstract aop a(MarkerOptions markeroptions, p p1);

    public abstract aos a(PolygonOptions polygonoptions);

    public abstract aov a(TileOverlayOptions tileoverlayoptions);

    public abstract CameraPosition a();

    public abstract void a(int i1);

    public abstract void a(int i1, int j1, int k1, int l1);

    public abstract void a(ajr ajr);

    public abstract void a(akz akz);

    public abstract void a(alc alc);

    public abstract void a(alf alf);

    public abstract void a(ali ali);

    public abstract void a(all all);

    public abstract void a(alr alr);

    public abstract void a(alu alu);

    public abstract void a(alx alx);

    public abstract void a(ama ama);

    public abstract void a(amd amd);

    public abstract void a(amg amg);

    public abstract void a(amj amj);

    public abstract void a(amm amm);

    public abstract void a(anb anb, ry ry);

    public abstract void a(Bundle bundle);

    public abstract void a(c c1);

    public abstract void a(c c1, int i1, akt akt);

    public abstract void a(c c1, akt akt);

    public abstract void a(String s1);

    public abstract void a(ry ry);

    public abstract void a(ry ry, int i1, akt akt);

    public abstract void a(ry ry, akt akt);

    public abstract void a(boolean flag);

    public abstract float b();

    public abstract void b(Bundle bundle);

    public abstract void b(c c1);

    public abstract void b(ry ry);

    public abstract boolean b(boolean flag);

    public abstract float c();

    public abstract void c(boolean flag);

    public abstract void d();

    public abstract void d(boolean flag);

    public abstract void e();

    public abstract int f();

    public abstract boolean g();

    public abstract boolean h();

    public abstract boolean i();

    public abstract Location j();

    public abstract akm k();

    public abstract aka l();

    public abstract boolean m();

    public abstract aom n();

    public abstract void o();

    public abstract void p();

    public abstract void q();

    public abstract void r();

    public abstract boolean s();
}
