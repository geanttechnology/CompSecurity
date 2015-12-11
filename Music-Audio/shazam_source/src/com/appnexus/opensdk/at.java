// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.location.Location;
import java.util.ArrayList;

public final class at
{

    public String a;
    public ArrayList b;
    public k.c c;
    public Location d;

    at()
    {
        a = null;
        b = new ArrayList();
        c = k.c.a;
        d = null;
    }

    at(String s, k.c c1, ArrayList arraylist, Location location)
    {
        a = null;
        b = new ArrayList();
        c = k.c.a;
        d = null;
        a = s;
        c = c1;
        b = arraylist;
        d = location;
    }
}
