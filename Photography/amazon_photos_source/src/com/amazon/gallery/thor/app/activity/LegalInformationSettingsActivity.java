// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.amazon.gallery.foundation.utils.di.BeanAwareApplication;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.foundation.utils.featuremanager.FeatureManager;
import com.amazon.gallery.foundation.utils.featuremanager.Features;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import com.amazon.gallery.framework.network.http.rest.account.EndpointManager;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            AndroidSimpleToolbar, GallerySimpleToolbar, GalleryNavigationSetting, LegalInformationWebActivity

public class LegalInformationSettingsActivity extends PreferenceActivity
{

    public LegalInformationSettingsActivity()
    {
    }

    private void setupActionBar()
    {
        AndroidSimpleToolbar androidsimpletoolbar = new AndroidSimpleToolbar((Toolbar)findViewById(0x7f0c0086));
        androidsimpletoolbar.setTitle(getResources().getString(0x7f0e01c6));
        androidsimpletoolbar.setNavigationSetting(GalleryNavigationSetting.BACK);
        androidsimpletoolbar.setNavigationOnClickListener(new android.view.View.OnClickListener() {

            final LegalInformationSettingsActivity this$0;

            public void onClick(View view)
            {
                finish();
            }

            
            {
                this$0 = LegalInformationSettingsActivity.this;
                super();
            }
        });
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300a7);
        if (FeatureManager.isFeatureEnabled(Features.HEADER_ACTION_BAR))
        {
            setupActionBar();
        }
        addPreferencesFromResource(0x7f050001);
        bundle = ((RestClient)((BeanAwareApplication)getApplication()).getBeanFactory().getBean(Keys.REST_CLIENT)).getEndpointManager().getCachedEndpoint();
        if (bundle == null)
        {
            bundle = com.amazon.gallery.framework.network.http.rest.account.Endpoint.Marketplace.UNKNOWN;
        } else
        {
            bundle = bundle.getMarketplace();
        }
        if (bundle.equals(com.amazon.gallery.framework.network.http.rest.account.Endpoint.Marketplace.US) || bundle.equals(com.amazon.gallery.framework.network.http.rest.account.Endpoint.Marketplace.CHINA))
        {
            getPreferenceScreen().removePreference(findPreference("cookies_and_internet_policy"));
        }
    }

    public boolean onPreferenceTreeClick(PreferenceScreen preferencescreen, Preference preference)
    {
        Intent intent = new Intent(this, com/amazon/gallery/thor/app/activity/LegalInformationWebActivity);
        if (preference.getKey().equals("3p_license"))
        {
            intent.setAction("3p_license");
        } else
        if (preference.getKey().equals("terms_of_use"))
        {
            intent.setAction("terms_of_use");
        } else
        if (preference.getKey().equals("privacy_policy"))
        {
            intent.setAction("privacy_policy");
        } else
        if (preference.getKey().equals("cookies_and_internet_policy"))
        {
            intent.setAction("cookies_and_internet_policy");
        } else
        {
            return false;
        }
        startActivity(intent);
        return super.onPreferenceTreeClick(preferencescreen, preference);
    }
}
