// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media;

import android.media.VolumeProvider;

class VolumeProviderCompatApi21
{

    VolumeProviderCompatApi21()
    {
    }

    public static Object createVolumeProvider(final int final_i, int i, int j, Delegate delegate1)
    {
        return new VolumeProvider(i, j, delegate1) {

            final Delegate val$delegate;

            public void onAdjustVolume(int k)
            {
                delegate.onAdjustVolume(k);
            }

            public void onSetVolumeTo(int k)
            {
                delegate.onSetVolumeTo(k);
            }

            
            {
                delegate = delegate1;
                super(final_i, j, k);
            }

            private class Delegate
            {

                public abstract void onAdjustVolume(int i);

                public abstract void onSetVolumeTo(int i);
            }

        };
    }

    public static void setCurrentVolume(Object obj, int i)
    {
        ((VolumeProvider)obj).setCurrentVolume(i);
    }
}
