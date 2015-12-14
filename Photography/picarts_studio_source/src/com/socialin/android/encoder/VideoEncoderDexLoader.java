// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.encoder;

import android.content.Context;
import com.flurry.android.FlurryAgent;
import com.socialin.android.d;
import com.socialin.android.encoder.factory.VideoEncoderFactory;

public class VideoEncoderDexLoader
{

    public VideoEncoderDexLoader()
    {
    }

    public static VideoEncoderFactory loadDexEncoder(Context context)
    {
        context = context.getClassLoader();
        context = context.loadClass("com.socialin.android.encoder.Encoder");
        d.a((new StringBuilder("VideoEncoderDexLoader libProviderClazz  = ")).append(context).toString());
        context = (VideoEncoderFactory)context.newInstance();
        d.a((new StringBuilder("VideoEncoderDexLoader encoderFactory  = ")).append(context).toString());
        return context;
        Exception exception;
        exception;
        context = null;
_L2:
        exception.printStackTrace();
        FlurryAgent.onError("dex_loader", exception.getMessage(), exception);
        return context;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
