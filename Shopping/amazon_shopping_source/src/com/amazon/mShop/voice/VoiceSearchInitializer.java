// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.voice;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.feature.ExperimentRecorder;
import com.amazon.mShop.feature.Features;
import com.amazon.mShop.net.CookieBridge;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.search.SearchActivity;
import com.amazon.mShop.search.SearchIntentBuilder;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.searchapp.retailsearch.client.SearchMethod;
import com.amazon.shopapp.voice.module.CustomerProvider;
import com.amazon.shopapp.voice.module.ExperimentProvider;
import com.amazon.shopapp.voice.module.FeatureConfiguration;
import com.amazon.shopapp.voice.module.KeyboardModeListener;
import com.amazon.shopapp.voice.module.VoiceInitSettings;
import com.amazon.shopapp.voice.module.VoiceSearchActionListener;
import com.amazon.shopapp.voice.mshop.MShopVoiceModule;

// Referenced classes of package com.amazon.mShop.voice:
//            MShopVoicePackageProxy

public class VoiceSearchInitializer
{
    public class AppExperimentProvider
        implements ExperimentProvider
    {

        final VoiceSearchInitializer this$0;

        public String getTreatment(String s)
        {
            return ExperimentRecorder.getInstance().getTreatment(s);
        }

        public AppExperimentProvider()
        {
            this$0 = VoiceSearchInitializer.this;
            super();
        }
    }

    public class AppFeatureConfiguration
        implements FeatureConfiguration
    {

        final VoiceSearchInitializer this$0;

        public String getFeatureState(String s)
        {
            return Features.getInstance().getFeatureState(s);
        }

        public boolean isFeatureActivated(String s)
        {
            return Features.getInstance().isFeatureActivated(s);
        }

        public AppFeatureConfiguration()
        {
            this$0 = VoiceSearchInitializer.this;
            super();
        }
    }

    public class CustomerHandler
        implements CustomerProvider
    {

        final VoiceSearchInitializer this$0;

        public String getDeviceId()
        {
            return AndroidPlatform.getInstance().getDeviceId();
        }

        public String getDirectedId(Context context)
        {
            return SSOUtil.getCurrentAccount(context);
        }

        public String getSessionId()
        {
            return CookieBridge.getCurrentSessionId();
        }

        public CustomerHandler()
        {
            this$0 = VoiceSearchInitializer.this;
            super();
        }
    }

    public class KeyboardListener
        implements KeyboardModeListener
    {

        final VoiceSearchInitializer this$0;

        public void search(Activity activity)
        {
            if (!(activity instanceof AmazonActivity))
            {
                return;
            }
            try
            {
                ((AmazonActivity)activity).onSearchRequested();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Activity activity)
            {
                Log.e(VoiceSearchInitializer.TAG, "Failed to open search", activity);
            }
            return;
        }

        public KeyboardListener()
        {
            this$0 = VoiceSearchInitializer.this;
            super();
        }
    }

    public class VoiceSearchListener
        implements VoiceSearchActionListener
    {

        final VoiceSearchInitializer this$0;

        public void search(Context context, String s, String s1, String s2, int i, String s3, String s4)
        {
            if (TextUtils.isEmpty(s))
            {
                break MISSING_BLOCK_LABEL_163;
            }
            if (!(context instanceof AmazonActivity))
            {
                return;
            }
            String s5 = s3;
            if (TextUtils.isEmpty(s3))
            {
                s5 = "vos_search_query";
            }
            s3 = s4;
            try
            {
                if (TextUtils.isEmpty(s4))
                {
                    s3 = ClickStreamTag.ORIGIN_SEARCH_VOICE.getTag();
                }
                s = (new SearchIntentBuilder((AmazonActivity)context)).query(s).searchMethod(SearchMethod.VOICE).showSearchEntryView(false).clickStreamOrigin(s3).asrRequestId(s1).utteranceId(s2);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.e(VoiceSearchInitializer.TAG, "Failed to execute search", context);
                return;
            }
            if (i >= 0)
            {
                i++;
            } else
            {
                i = 0;
            }
            s = s.interpretationNum(i).build();
            if (!(context instanceof SearchActivity))
            {
                break MISSING_BLOCK_LABEL_151;
            }
            ((SearchActivity)context).doSearch(s);
_L1:
            RefMarkerObserver.logRefMarker(s5);
            return;
            ActivityUtils.startSearchActivity((AmazonActivity)context, s);
              goto _L1
        }

        public VoiceSearchListener()
        {
            this$0 = VoiceSearchInitializer.this;
            super();
        }
    }


    private static final String TAG = com/amazon/mShop/voice/VoiceSearchInitializer.getSimpleName();
    private static VoiceSearchInitializer mInstance;

    public VoiceSearchInitializer()
    {
    }

    public static VoiceSearchInitializer getInstance()
    {
        if (mInstance == null)
        {
            mInstance = new VoiceSearchInitializer();
        }
        return mInstance;
    }

    public void initialize(Context context)
    {
        try
        {
            context = new VoiceInitSettings(context);
            context.setDebugMode(DebugSettings.isDebugEnabled());
            context.setVoiceSearchListener(new VoiceSearchListener());
            context.setCustomerProvider(new CustomerHandler());
            context.setKeyboardModeListener(new KeyboardListener());
            context.setFeatureConfiguration(new AppFeatureConfiguration());
            context.setExperimentProvider(new AppExperimentProvider());
            MShopVoiceModule.initializeApp(context);
            MShopVoicePackageProxy.getInstance().initializeMShopVoiceModule();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e(TAG, "Failed to initialize voice search", context);
        }
    }


}
