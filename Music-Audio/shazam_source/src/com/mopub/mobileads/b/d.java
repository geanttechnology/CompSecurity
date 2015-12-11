// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads.b;

import android.graphics.Color;
import android.graphics.Typeface;

public final class com.mopub.mobileads.b.d
{
    public static final class a
    {

        public static final android.graphics.Paint.Cap a;
        public static final Typeface b = Typeface.create("Helvetica", 0);

        static 
        {
            a = android.graphics.Paint.Cap.ROUND;
        }
    }

    public static final class b
    {

        public static final android.graphics.Paint.Style a;
        public static final android.graphics.Paint.Style b;
        public static final Typeface c = Typeface.create("Helvetica", 1);
        public static final android.graphics.Paint.Align d;

        static 
        {
            a = android.graphics.Paint.Style.FILL;
            b = android.graphics.Paint.Style.STROKE;
            d = android.graphics.Paint.Align.CENTER;
        }
    }

    public static final class c
    {

        public static final int a = Color.argb(102, 0, 0, 0);
        public static final int b = Color.argb(0, 255, 255, 255);

    }

    public static final class d
    {

        public static final android.graphics.Paint.Style a;
        public static final int b = Color.parseColor("#FFCC4D");
        public static final android.graphics.Paint.Style c;

        static 
        {
            a = android.graphics.Paint.Style.FILL;
            c = android.graphics.Paint.Style.FILL;
        }
    }

    public static final class e
    {

        public static final android.graphics.Paint.Style a;
        public static final android.graphics.Paint.Style b;
        public static final android.graphics.Paint.Align c;

        static 
        {
            a = android.graphics.Paint.Style.STROKE;
            b = android.graphics.Paint.Style.STROKE;
            c = android.graphics.Paint.Align.CENTER;
        }
    }

}
