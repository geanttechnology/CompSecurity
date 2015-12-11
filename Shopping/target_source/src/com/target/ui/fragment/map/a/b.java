// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.map.a;

import com.pointinside.maps.Location;
import com.pointinside.model.Venue;
import com.pointinside.model.Zone;
import com.target.ui.model.MapDisplayableItem;

public interface com.target.ui.fragment.map.a.b
{
    public static interface a
    {

        public abstract void C();
    }

    public static interface b
    {
    }

    public static interface c
    {

        public abstract void G();
    }

    public static interface d
    {

        public abstract void H();
    }

    public static interface e
    {

        public abstract void E();
    }

    public static interface f
    {

        public abstract void F();

        public abstract void c(int i);
    }

    public static interface g
    {

        public abstract void D();
    }

    public static interface h
    {

        public abstract void a();
    }


    public static final int DOWN = 3;
    public static final int LEFT = 0;
    public static final int NONE = 4;
    public static final int RIGHT = 1;
    public static final int UP = 2;

    public abstract void A();

    public abstract void a(float f1);

    public abstract void a(Location location, MapDisplayableItem mapdisplayableitem, boolean flag);

    public abstract void a(Location location, com.target.ui.view.DepartmentBadgeView.a a1, MapDisplayableItem mapdisplayableitem, boolean flag);

    public abstract void a(Location location, String s, MapDisplayableItem mapdisplayableitem, boolean flag);

    public abstract void a(Venue venue, Zone zone);

    public abstract void a(Venue venue, Zone zone, b b1);

    public abstract void a(Zone zone, float f1);

    public abstract void a(Zone zone, h h1);

    public abstract void a(MapDisplayableItem mapdisplayableitem);

    public abstract void a(String s, String s1, float f1, float f2, float f3, float f4, float f5, 
            boolean flag, float f6);

    public abstract void b(float f1);

    public abstract void b(Location location, MapDisplayableItem mapdisplayableitem, boolean flag);

    public abstract void b(MapDisplayableItem mapdisplayableitem);

    public abstract void d(boolean flag);

    public abstract void f(String s);

    public abstract void j(boolean flag);

    public abstract void q();

    public abstract void setMarkersSelectable(boolean flag);

    public abstract void setSelectedMarker(MapDisplayableItem mapdisplayableitem);

    public abstract void u();

    public abstract void x();

    public abstract void y();

    public abstract void z();
}
