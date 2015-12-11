// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.module;

import android.content.Context;
import android.util.Log;
import com.amazon.client.metrics.AndroidMetricsFactoryImpl;
import com.amazon.client.metrics.MetricsFactory;

// Referenced classes of package com.amazon.shopapp.voice.module:
//            VoiceInitSettings, VoiceModule, FeatureConfiguration

public class VoiceContext
{

    private static final VoiceInitSettings DEFAULT_SETTINGS = new VoiceInitSettings(null);
    private static final String TAG = com/amazon/shopapp/voice/module/VoiceContext.getSimpleName();
    private static VoiceContext sInstance;
    private MetricsFactory mMetricsFactory;
    private boolean mMetricsFactoryInitialized;

    public VoiceContext()
    {
    }

    public static VoiceContext getInstance()
    {
        com/amazon/shopapp/voice/module/VoiceContext;
        JVM INSTR monitorenter ;
        VoiceContext voicecontext;
        if (sInstance == null)
        {
            sInstance = new VoiceContext();
        }
        voicecontext = sInstance;
        com/amazon/shopapp/voice/module/VoiceContext;
        JVM INSTR monitorexit ;
        return voicecontext;
        Exception exception;
        exception;
        throw exception;
    }

    public static VoiceInitSettings getSettings()
    {
        VoiceModule voicemodule = VoiceModule.getInstance();
        if (voicemodule != null && voicemodule.getInitSettings() != null)
        {
            return voicemodule.getInitSettings();
        } else
        {
            return DEFAULT_SETTINGS;
        }
    }

    public static boolean isDebug()
    {
        return getSettings().getDebugMode();
    }

    public MetricsFactory getMetricsFactory()
    {
        if (mMetricsFactoryInitialized)
        {
            return mMetricsFactory;
        }
        try
        {
            if (getSettings().isLoggingEnabled())
            {
                Context context = getSettings().getContext();
                mMetricsFactory = (MetricsFactory)context.getSystemService("com.amazon.client.metrics.api");
                if (mMetricsFactory == null)
                {
                    mMetricsFactory = AndroidMetricsFactoryImpl.getInstance(context);
                }
            }
        }
        catch (Throwable throwable)
        {
            Log.e(TAG, "Error", throwable);
        }
        mMetricsFactoryInitialized = true;
        return mMetricsFactory;
    }

    public boolean isFeatureActive(String s)
    {
        boolean flag1 = false;
        VoiceInitSettings voiceinitsettings;
        boolean flag;
        boolean flag2;
        try
        {
            voiceinitsettings = getSettings();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e(TAG, "Error", s);
            return false;
        }
        flag = flag1;
        if (voiceinitsettings == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        flag = flag1;
        if (voiceinitsettings.getFeatureConfiguration() == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        flag2 = voiceinitsettings.getFeatureConfiguration().isFeatureActivated(s);
        flag = flag1;
        if (flag2)
        {
            flag = true;
        }
        return flag;
    }

}
