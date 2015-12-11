// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.graphics.Bitmap;

public interface al
{
    public static final class a
    {

        private final double a;
        private final double b;

        public a(double d, double d1)
        {
            a = d;
            b = d1;
        }
    }


    public abstract String a();

    public abstract void a(Bitmap bitmap);

    public abstract String b();

    public abstract void b(Bitmap bitmap);

    public abstract void c();
}
