// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.formats;


public final class NativeAdOptions
{

    public static final int ORIENTATION_ANY = 0;
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_PORTRAIT = 1;
    private final boolean zznW;
    private final int zznX;
    private final boolean zznY;

    private NativeAdOptions(Builder builder)
    {
        zznW = Builder.zza(builder);
        zznX = Builder.zzb(builder);
        zznY = Builder.zzc(builder);
    }


    public final int getImageOrientation()
    {
        return zznX;
    }

    public final boolean shouldRequestMultipleImages()
    {
        return zznY;
    }

    public final boolean shouldReturnUrlsForImageAssets()
    {
        return zznW;
    }

    private class Builder
    {

        private boolean zznW;
        private int zznX;
        private boolean zznY;

        static boolean zza(Builder builder)
        {
            return builder.zznW;
        }

        static int zzb(Builder builder)
        {
            return builder.zznX;
        }

        static boolean zzc(Builder builder)
        {
            return builder.zznY;
        }

        public final NativeAdOptions build()
        {
            return new NativeAdOptions(this);
        }

        public final Builder setImageOrientation(int i)
        {
            zznX = i;
            return this;
        }

        public final Builder setRequestMultipleImages(boolean flag)
        {
            zznY = flag;
            return this;
        }

        public final Builder setReturnUrlsForImageAssets(boolean flag)
        {
            zznW = flag;
            return this;
        }

        public Builder()
        {
            zznW = false;
            zznX = 0;
            zznY = false;
        }
    }

}
