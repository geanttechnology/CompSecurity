// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.tablet;

import android.app.Activity;
import android.os.Build;
import android.util.Log;
import com.amazon.shopapp.voice.module.KindleFamily;
import com.amazon.shopapp.voice.module.VoiceInitSettings;
import com.amazon.shopapp.voice.module.VoiceModule;
import com.amazon.shopapp.voice.search.VoiceSearchController;

public class TabletVoiceModule extends VoiceModule
{

    private static final String KINDLE_AUDIO_DATA_SOLICITOR = "MSHOP_KINDLE_PROD_APP";
    private static final String KINDLE_PROGRAM_NAME = "KindleWindowshop";
    private static final String SATURN_WAN = "KFSAWA";
    private static final String SATURN_WIFI = "KFSAWI";
    private static final String TABLET_AUDIO_DATA_SOLICITOR = "MSHOP_ANDROID_TABLET_PROD_APP";
    private static final String TABLET_PROGRAM_NAME = "TabletWindowshop";
    private static final String TAG = com/amazon/shopapp/voice/tablet/TabletVoiceModule.getSimpleName();
    private static TabletVoiceModule sInstance;

    public TabletVoiceModule()
    {
    }

    public static TabletVoiceModule getInstance()
    {
        com/amazon/shopapp/voice/tablet/TabletVoiceModule;
        JVM INSTR monitorenter ;
        TabletVoiceModule tabletvoicemodule;
        if (sInstance == null)
        {
            sInstance = new TabletVoiceModule();
        }
        tabletvoicemodule = sInstance;
        com/amazon/shopapp/voice/tablet/TabletVoiceModule;
        JVM INSTR monitorexit ;
        return tabletvoicemodule;
        Exception exception;
        exception;
        throw exception;
    }

    public static TabletVoiceModule initializeApp(VoiceInitSettings voiceinitsettings)
    {
        TabletVoiceModule tabletvoicemodule;
        Object obj1;
        obj1 = null;
        tabletvoicemodule = obj1;
        if (voiceinitsettings.getProgramName() != null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        tabletvoicemodule = obj1;
        Object obj;
        if (voiceinitsettings.isKindle())
        {
            obj = "KindleWindowshop";
        } else
        {
            obj = "TabletWindowshop";
        }
        tabletvoicemodule = obj1;
        try
        {
            voiceinitsettings.setProgramName(((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (VoiceInitSettings voiceinitsettings)
        {
            Log.e(TAG, "Error", voiceinitsettings);
            return tabletvoicemodule;
        }
        tabletvoicemodule = obj1;
        if (voiceinitsettings.getAudioDataSolicitor() != null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        tabletvoicemodule = obj1;
        if (voiceinitsettings.isKindle())
        {
            obj = "MSHOP_KINDLE_PROD_APP";
        } else
        {
            obj = "MSHOP_ANDROID_TABLET_PROD_APP";
        }
        tabletvoicemodule = obj1;
        voiceinitsettings.setAudioDataSolicitor(((String) (obj)));
        tabletvoicemodule = obj1;
        voiceinitsettings.setMinDialogWidth(475);
        tabletvoicemodule = obj1;
        voiceinitsettings.setCircularCloseButton(true);
        tabletvoicemodule = obj1;
        voiceinitsettings.setUseRingAudioStream(false);
        tabletvoicemodule = obj1;
        voiceinitsettings.setListeningSoundEnabled(false);
        tabletvoicemodule = obj1;
        if (voiceinitsettings.getDeviceModel() != null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        tabletvoicemodule = obj1;
        voiceinitsettings.setDeviceModel(Build.MODEL);
        tabletvoicemodule = obj1;
        if (!isSaturn(voiceinitsettings.getDeviceModel())) goto _L2; else goto _L1
_L1:
        tabletvoicemodule = obj1;
        voiceinitsettings.setSoundFeature("SX_Windowshop_Saturn_Voice_Search_Notification_Sound");
        tabletvoicemodule = obj1;
        voiceinitsettings.setSoundClipVolume(0.5F);
_L4:
        tabletvoicemodule = obj1;
        obj = getInstance();
        tabletvoicemodule = ((TabletVoiceModule) (obj));
        VoiceModule.setInstance(((VoiceModule) (obj)));
        tabletvoicemodule = ((TabletVoiceModule) (obj));
        ((TabletVoiceModule) (obj)).initialize(voiceinitsettings);
        return ((TabletVoiceModule) (obj));
_L2:
        tabletvoicemodule = obj1;
        voiceinitsettings.setSoundFeature("SX_Windowshop_Android_Voice_Search_Notification_Sound");
        tabletvoicemodule = obj1;
        if (voiceinitsettings.getKindleFamily() != KindleFamily.GEN7) goto _L4; else goto _L3
_L3:
        tabletvoicemodule = obj1;
        voiceinitsettings.setSoundClipVolume(0.66F);
          goto _L4
    }

    private static boolean isSaturn(String s)
    {
        return "KFSAWA".equals(s) || "KFSAWI".equals(s);
    }

    public void openVoiceSearch(Activity activity, boolean flag)
    {
        try
        {
            VoiceSearchController.startVoiceSearch(activity, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            Log.e(TAG, "Error", activity);
        }
    }

    public boolean voiceSearchInNavEnabled()
    {
        if (!deviceSupported())
        {
            return false;
        }
        String s1 = "SX_Windowshop_Generic_Voice_Search_Nav";
        VoiceInitSettings voiceinitsettings = getInitSettings();
        String s = s1;
        if (voiceinitsettings != null)
        {
            s = s1;
            if (voiceinitsettings.isKindle())
            {
                if (isSaturn(voiceinitsettings.getDeviceModel()))
                {
                    s = "SX_Windowshop_Saturn_Voice_Search_Nav";
                } else
                {
                    s = "SX_Windowshop_Kindle_Voice_Search_Nav_2";
                }
            }
        }
        return isFeatureActive(s);
    }

}
