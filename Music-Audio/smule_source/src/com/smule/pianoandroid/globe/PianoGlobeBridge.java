// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.globe;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.smule.android.f.n;

// Referenced classes of package com.smule.pianoandroid.globe:
//            a, b

public class PianoGlobeBridge
{

    public static String TAG = com/smule/pianoandroid/globe/PianoGlobeBridge.getName();
    public static b playbackEndedCallback = null;
    public static a sGlobeInitializedCallback = null;

    public PianoGlobeBridge()
    {
    }

    public static native double getPlaybackPercentageComplete();

    public static void globeInitialized()
    {
        if (sGlobeInitializedCallback != null)
        {
            sGlobeInitializedCallback.c();
        }
    }

    public static void globePlaybackEnded()
    {
        if (playbackEndedCallback != null)
        {
            playbackEndedCallback.d();
        }
    }

    public static void init(Context context, int i, int j)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        initNative(n.a(context), i, j, displaymetrics.xdpi, displaymetrics.ydpi);
    }

    public static native void initNative(String s, int i, int j, float f, float f1);

    public static native void onPause();

    public static native void onResume();

    public static native void playPerformanceFromFile(String s);

    public static native void render();

    public static native void setViewSize(int i, int j, int k, int l);

    public static native void visitLatLong(float f, float f1, float f2);

    static 
    {
        System.loadLibrary("magic_gfx");
        System.loadLibrary("magic_audio");
        System.loadLibrary("magic_core");
        System.loadLibrary("magic_globe");
    }
}
