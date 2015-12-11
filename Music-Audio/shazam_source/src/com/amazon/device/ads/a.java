// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class a extends Enum
{

    public static final a a;
    public static final a b;
    public static final a c;
    public static final a d;
    public static final a e;
    public static final a f;
    public static final a g;
    public static final a h;
    public static final a i;
    public static final a j;
    public static final a k;
    private static final HashSet m;
    private static final a n[];
    private final int l;

    private a(String s, int i1, int j1)
    {
        super(s, i1);
        l = j1;
    }

    public static a a(int i1)
    {
        switch (i1)
        {
        default:
            return null;

        case 1007: 
            return a;

        case 1016: 
            return b;

        case 1017: 
            return c;

        case 1008: 
            return d;

        case 1030: 
            return j;

        case 1003: 
            return g;

        case 1004: 
            return h;

        case 1001: 
            return e;

        case 1002: 
            return f;

        case 1014: 
            return i;

        case 1031: 
            return k;
        }
    }

    public static boolean a(Set set)
    {
        for (Iterator iterator = m.iterator(); iterator.hasNext();)
        {
            if (set.contains((a)iterator.next()))
            {
                return true;
            }
        }

        return false;
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/amazon/device/ads/a, s);
    }

    public static a[] values()
    {
        return (a[])n.clone();
    }

    static 
    {
        a = new a("HTML", 0, 1007);
        b = new a("MRAID1", 1, 1016);
        c = new a("MRAID2", 2, 1017);
        d = new a("INTERSTITIAL", 3, 1008);
        e = new a("CAN_PLAY_AUDIO1", 4, 1001);
        f = new a("CAN_PLAY_AUDIO2", 5, 1002);
        g = new a("CAN_EXPAND1", 6, 1003);
        h = new a("CAN_EXPAND2", 7, 1004);
        i = new a("CAN_PLAY_VIDEO", 8, 1014);
        j = new a("VIDEO_INTERSTITIAL", 9, 1030);
        k = new a("REQUIRES_TRANSPARENCY", 10, 1031);
        n = (new a[] {
            a, b, c, d, e, f, g, h, i, j, 
            k
        });
        HashSet hashset = new HashSet();
        m = hashset;
        hashset.add(a);
        m.add(b);
        m.add(c);
        m.add(d);
        m.add(j);
    }
}
