// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.util;

import android.content.res.Resources;
import b.a.a.a.f;
import b.a.a.ac;
import b.a.a.ad;
import b.a.a.b;
import b.a.a.k;
import b.a.a.s;

public final class e
{

    public static String a(Resources resources, b b1, b b2, b b3)
    {
        if (b2.a(b1) < 0)
        {
            int i = ((f) (k.a(b2.c_(), b1.c_()))).p;
            if (i > 7)
            {
                return resources.getString(0x7f0e013e, new Object[] {
                    b1.c(), b1.c()
                });
            }
            if (i > 1)
            {
                return resources.getString(0x7f0e013f, new Object[] {
                    b1.c()
                });
            }
            if (i > 0)
            {
                return resources.getString(0x7f0e0141);
            } else
            {
                return resources.getString(0x7f0e0140);
            }
        }
        if (b2.a(b3) >= 0)
        {
            return resources.getString(0x7f0e0095, new Object[] {
                b3.c(), b3.c()
            });
        }
        int j = ((f) (ad.a(b2, b3))).p;
        int l = ((f) (s.a(b2, b3))).p;
        int i1 = ((f) (ac.a(b2, b3))).p;
        int j1 = ((f) (k.a(b2.c_(), b3.c_()))).p;
        if (j > 0)
        {
            return resources.getQuantityString(0x7f0d000b, j, new Object[] {
                Integer.valueOf(j)
            });
        }
        if (l > 0)
        {
            return resources.getQuantityString(0x7f0d0005, l, new Object[] {
                Integer.valueOf(l)
            });
        }
        if (i1 > 0)
        {
            return resources.getQuantityString(0x7f0d000a, i1, new Object[] {
                Integer.valueOf(i1)
            });
        }
        if (j1 > 1)
        {
            return resources.getString(0x7f0e0159, new Object[] {
                b3.c()
            });
        }
        if (j1 > 0)
        {
            return resources.getString(0x7f0e015a);
        }
        if (j1 == 0)
        {
            return resources.getString(0x7f0e0096);
        } else
        {
            return resources.getString(0x7f0e0158, new Object[] {
                b3.c(), b3.c()
            });
        }
    }
}
