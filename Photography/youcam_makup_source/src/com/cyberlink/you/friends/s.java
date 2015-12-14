// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.friends;

import android.graphics.Bitmap;
import android.util.LruCache;

public class s
{

    private LruCache a;

    public Bitmap a(String s1)
    {
        if (a == null || s1 == null)
        {
            return null;
        } else
        {
            return (Bitmap)a.get(s1);
        }
    }

    public boolean a(String s1, Bitmap bitmap)
    {
        while (a == null || bitmap == null || a(s1) != null) 
        {
            return false;
        }
        a.put(s1, bitmap);
        return true;
    }
}
