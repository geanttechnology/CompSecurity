// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.location.Location;
import java.util.List;
import java.util.Map;

final class eb
{

    private String fJ;
    private long fK;
    private long fL;
    private long fM;
    private String fN;
    private String fO;
    private int fP;
    private String fQ;
    private Location fR;
    private int fS;
    private byte fT;
    private Long fU;
    private List fV;
    private int fW;
    private List fX;
    private Map fY;
    private boolean fZ;

    eb()
    {
        fK = -1L;
        fL = -1L;
        fM = -1L;
        fP = -1;
        fS = -1;
        fT = -1;
        fW = -1;
        fZ = false;
    }

    final void a(Location location)
    {
        fR = location;
    }

    final void a(boolean flag)
    {
        fZ = flag;
    }

    final long aJ()
    {
        return fK;
    }

    final long aK()
    {
        return fL;
    }

    final long aL()
    {
        return fM;
    }

    final int aM()
    {
        return fP;
    }

    final String aN()
    {
        return fQ;
    }

    final int aO()
    {
        return fS;
    }

    final byte aP()
    {
        return fT;
    }

    final Long aQ()
    {
        return fU;
    }

    final int aR()
    {
        return fW;
    }

    final List aS()
    {
        return fV;
    }

    final Map aT()
    {
        return fY;
    }

    final boolean aU()
    {
        return fZ;
    }

    final void b(int i)
    {
        fP = i;
    }

    final void b(Map map)
    {
        fY = map;
    }

    final void c(int i)
    {
        fS = i;
    }

    final void c(Long long1)
    {
        fU = long1;
    }

    final void d(int i)
    {
        fW = i;
    }

    final void d(long l)
    {
        fK = l;
    }

    final void e(long l)
    {
        fL = l;
    }

    final void e(List list)
    {
        fV = list;
    }

    final void f(long l)
    {
        fM = 0L;
    }

    final void f(List list)
    {
        fX = list;
    }

    final List getErrors()
    {
        return fX;
    }

    final String getLocale()
    {
        return fN;
    }

    final Location getLocation()
    {
        return fR;
    }

    final String getTimeZone()
    {
        return fO;
    }

    final String getVersion()
    {
        return fJ;
    }

    final void setGender(byte byte0)
    {
        fT = byte0;
    }

    final void setTimeZone(String s)
    {
        fO = s;
    }

    final void setUserId(String s)
    {
        fQ = s;
    }

    final void setVersion(String s)
    {
        fJ = s;
    }

    final void y(String s)
    {
        fN = s;
    }
}
