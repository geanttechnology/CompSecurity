// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.util.SparseArray;
import com.flurry.android.tumblr.Post;

public class me
{

    private static me b = null;
    private SparseArray a;

    private me()
    {
        a = new SparseArray();
    }

    public static me a()
    {
        if (b == null)
        {
            b = new me();
        }
        return b;
    }

    public void a(int i)
    {
        a.remove(i);
    }

    public void a(int i, Post post)
    {
        a.append(i, post);
    }

}
