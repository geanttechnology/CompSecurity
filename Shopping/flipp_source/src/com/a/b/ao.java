// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import android.graphics.Bitmap;
import android.net.Uri;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class ao
{

    public final Uri a;
    public final int b;
    public final List c;
    public final int d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public final float h;
    public final float i;
    public final float j;
    public final boolean k;
    public final WeakReference l;
    public final WeakReference m;
    public final int n;
    public final AtomicInteger o;

    private ao(Uri uri, int i1, List list, int j1, int k1, boolean flag, boolean flag1, 
            float f1, float f2, float f3, boolean flag2, Bitmap bitmap, byte abyte0[], int l1, 
            AtomicInteger atomicinteger)
    {
        a = uri;
        b = i1;
        if (list == null)
        {
            c = null;
        } else
        {
            c = Collections.unmodifiableList(list);
        }
        d = j1;
        e = k1;
        f = flag;
        g = flag1;
        h = f1;
        i = f2;
        j = f3;
        k = flag2;
        l = new WeakReference(bitmap);
        m = new WeakReference(abyte0);
        n = l1;
        o = atomicinteger;
    }

    ao(Uri uri, int i1, List list, int j1, int k1, boolean flag, boolean flag1, 
            float f1, float f2, float f3, boolean flag2, Bitmap bitmap, byte abyte0[], int l1, 
            AtomicInteger atomicinteger, byte byte0)
    {
        this(uri, i1, list, j1, k1, flag, flag1, f1, f2, f3, flag2, bitmap, abyte0, l1, atomicinteger);
    }

    public final boolean a()
    {
        return d != 0;
    }

    final boolean b()
    {
        return d != 0 || h != 0.0F;
    }

    final boolean c()
    {
        return c != null;
    }
}
