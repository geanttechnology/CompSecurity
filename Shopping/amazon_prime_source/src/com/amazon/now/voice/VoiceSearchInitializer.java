// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.voice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.now.AmazonActivity;
import com.amazon.now.account.SSO;
import com.amazon.now.account.User;
import com.amazon.now.platform.AndroidPlatform;
import com.amazon.now.search.SearchIntentBuilder;
import com.amazon.now.util.AppUtils;
import com.amazon.searchapp.retailsearch.client.SearchMethod;
import com.amazon.shopapp.voice.module.CustomerProvider;
import com.amazon.shopapp.voice.module.KeyboardModeListener;
import com.amazon.shopapp.voice.module.VoiceInitSettings;
import com.amazon.shopapp.voice.module.VoiceSearchActionListener;
import com.amazon.shopapp.voice.phone.PhoneVoiceModule;

public class VoiceSearchInitializer
{
    private static class CustomerHandler
        implements CustomerProvider
    {

        public String getDeviceId()
        {
            if (User.isSignedIn())
            {
                return AndroidPlatform.getInstance().getDeviceId();
            } else
            {
                return null;
            }
        }

        public String getDirectedId(Context context)
        {
            return SSO.getMAPAccountManager().getAccount();
        }

        public String getSessionId()
        {
            if (User.isSignedIn())
            {
                return AndroidPlatform.getInstance().getSessionId();
            } else
            {
                return null;
            }
        }

        private CustomerHandler()
        {
        }

    }

    private static class KeyboardListener
        implements KeyboardModeListener
    {

        public void search(Activity activity)
        {
            if (activity instanceof AmazonActivity)
            {
                ((AmazonActivity)activity).search(null, null);
            }
        }

        private KeyboardListener()
        {
        }

    }

    private static class VoiceSearchListener
        implements VoiceSearchActionListener
    {

        public void search(Context context, String s, String s1, String s2, int i, String s3, String s4)
        {
            if (TextUtils.isEmpty(s))
            {
                return;
            }
            s = (new SearchIntentBuilder(context)).query(s).build();
            s.putExtra("com.amazon.now.search.method", SearchMethod.VOICE.getName());
            s.putExtra("com.amazon.now.search.voice.asrRequestId", s1);
            s.putExtra("com.amazon.now.search.voice.utteranceId", s2);
            if (i >= 0)
            {
                i++;
            } else
            {
                i = 0;
            }
            s.putExtra("com.amazon.now.search.voice.interpretationNumber", i);
            context.startActivity(s);
        }

        private VoiceSearchListener()
        {
        }

    }


    private static final String TAG = com/amazon/now/voice/VoiceSearchInitializer.getSimpleName();
    private static boolean sHasInitialized = false;
    private final Context mContext;

    private VoiceSearchInitializer(Context context)
    {
        mContext = context;
    }

    public static boolean hasInitialized()
    {
        return sHasInitialized;
    }

    private void initialize()
    {
        VoiceInitSettings voiceinitsettings = new VoiceInitSettings(mContext);
        try
        {
            voiceinitsettings.setProgramName(mContext.getString(0x7f0700d4));
            voiceinitsettings.setBluefrontAccessId(mContext.getString(0x7f070097));
            voiceinitsettings.setBluefrontAccessKey(mContext.getString(0x7f070098));
        }
        catch (android.content.res.Resources.NotFoundException notfoundexception)
        {
            voiceinitsettings.setProgramName(null);
        }
        voiceinitsettings.setAudioDataSolicitor("PRIME_NOW_ANDROID_PRODUCTION_APP");
        voiceinitsettings.setCircularCloseButton(true);
        voiceinitsettings.setDebugMode(AppUtils.isAppDebuggable(mContext));
        voiceinitsettings.setVoiceSearchListener(new VoiceSearchListener());
        voiceinitsettings.setCustomerProvider(new CustomerHandler());
        voiceinitsettings.setKeyboardModeListener(new KeyboardListener());
        voiceinitsettings.setKindle(false);
        PhoneVoiceModule.initializeApp(voiceinitsettings);
        sHasInitialized = true;
    }

    public static void initialize(Context context)
    {
        try
        {
            (new VoiceSearchInitializer(context)).initialize();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e(TAG, context.toString(), context);
        }
        sHasInitialized = false;
    }

}
