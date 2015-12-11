// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview;

import android.view.View;

public class Compat
{

    private static final int SIXTY_FPS_INTERVAL = 16;

    public Compat()
    {
    }

    public static int getPointerIndex(int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            return getPointerIndexHoneyComb(i);
        } else
        {
            return getPointerIndexEclair(i);
        }
    }

    private static int getPointerIndexEclair(int i)
    {
        return i >> 8 & 0xff;
    }

    private static int getPointerIndexHoneyComb(int i)
    {
        return i >> 8 & 0xff;
    }

    public static void postOnAnimation(View view, Runnable runnable)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            postOnAnimationJellyBean(view, runnable);
            return;
        } else
        {
            view.postDelayed(runnable, 16L);
            return;
        }
    }

    private static void postOnAnimationJellyBean(View view, Runnable runnable)
    {
        view.postOnAnimation(runnable);
    }
}
