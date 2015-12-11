// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api.common.io;

import java.io.InputStream;

public class Gunzipper
{

    private static final Gunzipper instance = new Gunzipper();
    private GunzipInterface implementation;

    private Gunzipper()
    {
    }

    public static InputStream gunzip(InputStream inputstream)
    {
        if (instance.implementation == null)
        {
            setImplementation(new _cls1());
        }
        return instance.implementation.gunzip(inputstream);
    }

    public static void setImplementation(GunzipInterface gunzipinterface)
    {
        instance.implementation = gunzipinterface;
    }


    private class _cls1
        implements GunzipInterface
    {

        public final InputStream gunzip(InputStream inputstream)
        {
            return new GZIPInputStream(inputstream);
        }

        _cls1()
        {
        }
    }


    private class GunzipInterface
    {

        public abstract InputStream gunzip(InputStream inputstream);
    }

}
