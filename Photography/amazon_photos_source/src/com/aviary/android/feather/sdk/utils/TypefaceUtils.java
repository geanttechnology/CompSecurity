// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.utils;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import java.lang.ref.SoftReference;
import java.util.HashMap;

public final class TypefaceUtils
{

    private static final HashMap S_TYPE_CACHE = new HashMap();

    private TypefaceUtils()
    {
    }

    public static Typeface createFromAsset(AssetManager assetmanager, String s)
    {
        SoftReference softreference = getFromCache(s);
        if (softreference != null && softreference.get() != null)
        {
            return (Typeface)softreference.get();
        } else
        {
            assetmanager = Typeface.createFromAsset(assetmanager, s);
            putIntoCache(s, assetmanager);
            return assetmanager;
        }
    }

    private static SoftReference getFromCache(String s)
    {
        synchronized (S_TYPE_CACHE)
        {
            s = (SoftReference)S_TYPE_CACHE.get(s);
        }
        return s;
        s;
        hashmap;
        JVM INSTR monitorexit ;
        throw s;
    }

    private static void putIntoCache(String s, Typeface typeface)
    {
        synchronized (S_TYPE_CACHE)
        {
            S_TYPE_CACHE.put(s, new SoftReference(typeface));
        }
        return;
        s;
        hashmap;
        JVM INSTR monitorexit ;
        throw s;
    }

}
