// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;

public final class d
{

    public static final SparseArray a = new _cls2();
    private static final SparseArray b;

    public static PorterDuffXfermode a(int i)
    {
        return (PorterDuffXfermode)b.get(i);
    }

    static 
    {
        SparseArray sparsearray = new SparseArray(8);
        b = sparsearray;
        sparsearray.append(0, new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SCREEN));
        b.append(1, new PorterDuffXfermode(android.graphics.PorterDuff.Mode.MULTIPLY));
        b.append(2, new PorterDuffXfermode(android.graphics.PorterDuff.Mode.OVERLAY));
        b.append(3, new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DARKEN));
        b.append(4, new PorterDuffXfermode(android.graphics.PorterDuff.Mode.LIGHTEN));
        b.append(5, new PorterDuffXfermode(android.graphics.PorterDuff.Mode.ADD));
        b.append(6, new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
        new _cls1();
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
