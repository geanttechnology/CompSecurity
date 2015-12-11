// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media;

import android.media.VolumeProvider;

class VolumeProviderCompatApi21
{
    public static interface Delegate
    {

        public abstract void onAdjustVolume(int i);

        public abstract void onSetVolumeTo(int i);
    }


    VolumeProviderCompatApi21()
    {
    }

    public static Object createVolumeProvider(int i, int j, int k, Delegate delegate1)
    {
        return new _cls1(i, j, k, delegate1);
    }

    public static void setCurrentVolume(Object obj, int i)
    {
        ((VolumeProvider)obj).setCurrentVolume(i);
    }

    /* member class not found */
    class _cls1 {}

}
