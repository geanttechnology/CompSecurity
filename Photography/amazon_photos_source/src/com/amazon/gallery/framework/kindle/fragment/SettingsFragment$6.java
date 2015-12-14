// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.preference.Preference;
import android.widget.Toast;
import com.amazon.gallery.foundation.utils.di.BeanAwareApplication;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import com.amazon.gallery.framework.network.http.rest.account.EndpointManager;
import com.amazon.gallery.thor.app.SendFeedbackHelper;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            SettingsFragment

class this._cls0
    implements android.preference.enceClickListener
{

    final SettingsFragment this$0;

    public boolean onPreferenceClick(Preference preference)
    {
        Endpoint endpoint = ((RestClient)((BeanAwareApplication)getActivity().getApplication()).getBeanFactory().getBean(Keys.REST_CLIENT)).getEndpointManager().getCachedEndpoint();
        preference = null;
        if (endpoint != null)
        {
            preference = endpoint.getHttpHostString();
        }
        preference = SendFeedbackHelper.getIntentForSendFeedback(getActivity(), preference);
        try
        {
            startActivity(preference);
        }
        // Misplaced declaration of an exception variable
        catch (Preference preference)
        {
            Toast.makeText(getActivity(), getString(0x7f0e01dd), 1).show();
            return true;
        }
        return true;
    }

    anager()
    {
        this$0 = SettingsFragment.this;
        super();
    }
}
