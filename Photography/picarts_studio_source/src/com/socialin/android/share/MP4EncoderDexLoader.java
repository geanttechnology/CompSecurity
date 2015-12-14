// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.share;

import android.content.Context;
import android.os.Bundle;
import com.flurry.android.FlurryAgent;
import com.picsart.studio.mp4encoder.MP4WriterFactory;
import com.socialin.android.NoProGuard;
import com.socialin.android.d;
import java.lang.reflect.Constructor;

public class MP4EncoderDexLoader
    implements NoProGuard
{

    public MP4EncoderDexLoader()
    {
    }

    public static MP4WriterFactory loadDexEncoder(Context context, Bundle bundle)
    {
        context = context.getClassLoader();
        context = context.loadClass("com.picsart.studio.mp4encoder.MP4Writer");
        d.a((new StringBuilder("VideoEncoderDexLoader libProviderClazz  = ")).append(context).toString());
        context = (MP4WriterFactory)context.getDeclaredConstructor(new Class[] {
            android/os/Bundle
        }).newInstance(new Object[] {
            bundle
        });
        d.a((new StringBuilder("VideoEncoderDexLoader encoderFactory  = ")).append(context).toString());
        return context;
        bundle;
        context = null;
_L2:
        bundle.printStackTrace();
        FlurryAgent.onError("dex_loader", bundle.getMessage(), bundle);
        return context;
        bundle;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
