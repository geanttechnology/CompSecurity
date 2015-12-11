// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity;


public final class d extends Enum
{

    public static final d a;
    private static d d;
    private static d e;
    private static d f;
    private static d g;
    private static d h;
    private static d i;
    private static d j;
    private static d k;
    private static d l;
    private static d m;
    private static d n;
    private static d o;
    private static final d p[];
    public final int b;
    public final String c;

    private d(String s, int i1, int j1, String s1)
    {
        super(s, i1);
        b = j1;
        c = s1;
    }

    public static d valueOf(String s)
    {
        return (d)Enum.valueOf(com/gimbal/internal/proximity/d, s);
    }

    public static d[] values()
    {
        return (d[])p.clone();
    }

    public final String toString()
    {
        return (new StringBuilder()).append(b).append(": ").append(c).toString();
    }

    static 
    {
        a = new d("PROXIMITY_UNKNOWN_TYPE", 0, 0, "Unknown Type.");
        d = new d("PROXIMITY_API_LEVEL_NOT_SUPPORTED", 1, 2004, "Api level not Supported");
        e = new d("PROXIMITY_BLE_SUPPORT_NOT_AVAILABLE", 2, 2005, "BLE Support not available");
        f = new d("PROXIMITY_BLUETOOTH_IS_OFF", 3, 2006, "Bluetooth is off");
        g = new d("PROXIMITY_APP_NOT_INITIALIZED", 4, 2007, "App Not Initialized");
        h = new d("PROXIMITY_APP_NOT_REGISTERED", 5, 2008, "App Not Registered");
        i = new d("PROXIMITY_UNKNOWN_AUTH_FAILURE", 6, 2009, "Unknown Auth Failure");
        j = new d("PROXIMITY_NETWORK_AUTH_FAILURE", 7, 2010, "Network Auth Failure");
        k = new d("PROXIMITY_USER_CANCELLED_AUTH_FAILURE", 8, 2011, "User canceled Auth");
        l = new d("PROXIMITY_USER_DENIED_AUTH_FAILURE", 9, 2012, "User Denied Auth Failure");
        m = new d("PROXIMITY_RELEASE_VERSION_NOT_SUPPORTED", 10, 2013, "Release Version not Supported");
        n = new d("PROXIMITY_INITIALIZATION_FAILURE", 11, 2014, "Initialization Failure");
        o = new d("PROXIMITY_REQUIRES_AUTHORIZATION", 12, 1001, "API Requires Authorization");
        p = (new d[] {
            a, d, e, f, g, h, i, j, k, l, 
            m, n, o
        });
    }
}
