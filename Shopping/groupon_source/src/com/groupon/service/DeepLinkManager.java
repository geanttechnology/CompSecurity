// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.ParseException;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.appindexing.AndroidAppUri;
import com.groupon.activity.IntentFactory;
import com.groupon.activity.UrlIntentFactory;
import com.groupon.deeplink.DeepLinkData;
import com.groupon.deeplink.DeepLinkUtil;
import com.groupon.models.LoggingNSTExtras;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import org.codehaus.jackson.map.ObjectMapper;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.service:
//            AttributionService

public class DeepLinkManager
{

    public static final String ANDROID_APP = "android-app";
    public static final String APP_CRAWLER = "com.google.appcrawler";
    public static final String GOOGLE_QUICK_SEARCH_BOX = "com.google.android.googlequicksearchbox";
    public static final String REFERRER_APP_CRAWLER = "app_crawler";
    public static final String REFERRER_GOOGLE_APP = "google_app";
    public static final String REFERRER_IN_APP = "in_app";
    public static final String REFERRER_NAME = "android.intent.extra.REFERRER_NAME";
    public static final String REFERRER_OTHERS = "others";
    private Lazy attributionService;
    private Lazy currentCountryManager;
    private DeepLinkUtil deepLinkUtil;
    private Lazy intentFactory;
    private ObjectMapper objectMapper;
    private Lazy urlIntentFactory;

    public DeepLinkManager(Application application)
    {
        currentCountryManager = new Lazy(application) {

            final DeepLinkManager this$0;

            
            {
                this$0 = DeepLinkManager.this;
                super(context);
            }
        };
        intentFactory = new Lazy(application) {

            final DeepLinkManager this$0;

            
            {
                this$0 = DeepLinkManager.this;
                super(context);
            }
        };
        urlIntentFactory = new Lazy(application) {

            final DeepLinkManager this$0;

            
            {
                this$0 = DeepLinkManager.this;
                super(context);
            }
        };
        attributionService = new Lazy(application) {

            final DeepLinkManager this$0;

            
            {
                this$0 = DeepLinkManager.this;
                super(context);
            }
        };
    }

    private Uri getReferrerFromIntent(Intent intent)
    {
        Uri uri = (Uri)intent.getParcelableExtra("android.intent.extra.REFERRER");
        if (uri != null)
        {
            return uri;
        }
        intent = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (intent != null)
        {
            try
            {
                intent = Uri.parse(intent);
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                return null;
            }
            return intent;
        } else
        {
            return null;
        }
    }

    private void startNextActivity(Context context, Intent intent)
    {
        context.startActivity(intent);
    }

    private boolean willCountryChange(DeepLinkData deeplinkdata)
    {
        String s = ((CurrentCountryManager)currentCountryManager.get()).getCurrentCountry().isoName;
        return !deepLinkUtil.hasWildCardCountryCode(deeplinkdata) && s != null && !s.equalsIgnoreCase(deeplinkdata.getCountryCode());
    }

    public String constructDeepLinkNSTExtraString(String s, Intent intent)
    {
        Uri uri = getReferrerFromIntent(intent);
        intent = new LoggingNSTExtras();
        if (uri != null)
        {
            if (uri.getScheme().equals("android-app"))
            {
                s = AndroidAppUri.newAndroidAppUri(uri).getPackageName();
                if ("com.google.android.googlequicksearchbox".equals(s))
                {
                    intent.referrer = "google_app";
                } else
                if ("com.google.appcrawler".equals(s))
                {
                    intent.referrer = "app_crawler";
                }
            } else
            {
                intent.referrer = uri.toString();
            }
        } else
        if (s.startsWith("groupon:///dispatch"))
        {
            intent.referrer = "in_app";
        } else
        {
            intent.referrer = "others";
        }
        try
        {
            s = objectMapper.writeValueAsString(intent);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "";
        }
        return s;
    }

    public void followDeepLink(Context context, DeepLinkData deeplinkdata)
    {
        followDeepLink(context, deeplinkdata, null);
    }

    public void followDeepLink(Context context, DeepLinkData deeplinkdata, Bundle bundle)
    {
        followDeepLink(context, deeplinkdata, bundle, true);
    }

    public void followDeepLink(Context context, DeepLinkData deeplinkdata, Bundle bundle, boolean flag)
    {
        setDeepLinkAttribution(deeplinkdata);
        if (willCountryChange(deeplinkdata))
        {
            startNextActivity(context, ((IntentFactory)intentFactory.get()).newCarouselIntent());
            return;
        } else
        {
            startNextActivity(context, handleDeepLink(deeplinkdata, bundle, flag));
            return;
        }
    }

    public Intent getDestinationIntent(DeepLinkData deeplinkdata, boolean flag)
    {
        boolean flag1 = ((CurrentCountryManager)currentCountryManager.get()).getCurrentCountry().isUSACompatible();
        return ((UrlIntentFactory)urlIntentFactory.get()).getIntent(deeplinkdata, flag1, flag);
    }

    protected Intent handleDeepLink(DeepLinkData deeplinkdata, Bundle bundle, boolean flag)
    {
        Intent intent = getDestinationIntent(deeplinkdata, flag);
        if (intent == null)
        {
            intent = ((IntentFactory)intentFactory.get()).newCarouselIntent();
        }
        if (bundle != null)
        {
            intent.putExtras(bundle);
        }
        if (!deeplinkdata.toString().startsWith("groupon:///dispatch"))
        {
            intent.setFlags(0x10008000);
        }
        return intent;
    }

    public boolean isDirectlyFollowable(DeepLinkData deeplinkdata)
    {
        return getDestinationIntent(deeplinkdata, true) != null;
    }

    protected void setDeepLinkAttribution(DeepLinkData deeplinkdata)
    {
        ((AttributionService)attributionService.get()).setDeepLinkingAttribution(deeplinkdata.getAttributionCid(), deeplinkdata.getAttributionLinkId(), deeplinkdata.getUtmMediumAttribution(), Long.valueOf(System.currentTimeMillis()));
    }
}
