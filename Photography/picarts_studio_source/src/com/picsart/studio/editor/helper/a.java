// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.helper;

import android.graphics.Bitmap;
import android.util.SparseArray;

public final class a
{

    private static final a a = new a();
    private final SparseArray b = new SparseArray(1);

    private a()
    {
    }

    public static a a()
    {
        return a;
    }

    public final int a(Bitmap bitmap)
    {
        int i = bitmap.hashCode();
        b.put(i, bitmap);
        return i;
    }

    public final Bitmap a(int i)
    {
        Bitmap bitmap = (Bitmap)b.get(i);
        b.remove(i);
        return bitmap;
    }

}
