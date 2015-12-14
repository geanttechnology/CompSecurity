// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.ndk;

import android.content.res.AssetManager;

// Referenced classes of package com.crashlytics.android.ndk:
//            NativeApi

class JniNativeApi
    implements NativeApi
{

    JniNativeApi()
    {
    }

    private native boolean nativeInit(String s, Object obj);

    public boolean initialize(String s, AssetManager assetmanager)
    {
        return nativeInit(s, assetmanager);
    }

    static 
    {
        System.loadLibrary("crashlytics");
    }
}
