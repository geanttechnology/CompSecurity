// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.mixerbox.mixerbox3b.LoginBridge;
import com.mixerbox.mixerbox3b.classes.MixerBoxAsyncHttpResponseHandler;
import com.mixerbox.mixerbox3b.utils.MixerBoxSharedPreferences;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            SettingsFragment

class nseHandler extends MixerBoxAsyncHttpResponseHandler
{

    final SettingsFragment this$0;

    public void onFailure(Throwable throwable, String s)
    {
        throwable = new Intent();
        s = new Bundle();
        s.putBoolean("islogin", false);
        throwable.putExtras(s);
        throwable.setClass(getActivity(), com/mixerbox/mixerbox3b/LoginBridge);
        startActivity(throwable);
        getActivity().finish();
    }

    public void onSuccess(String s)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        s = new JSONObject(s);
        if (!s.isNull("sysinfo"))
        {
            s = s.getJSONObject("sysinfo");
            if (!s.isNull("showAd"))
            {
                MixerBoxSharedPreferences.putShouldShowAd(getActivity(), s.getBoolean("showAd"));
            }
            s = new Intent();
            Bundle bundle = new Bundle();
            bundle.putBoolean("islogin", false);
            s.putExtras(bundle);
            s.setClass(getActivity(), com/mixerbox/mixerbox3b/LoginBridge);
            startActivity(s);
            getActivity().finish();
            return;
        }
        break MISSING_BLOCK_LABEL_240;
        try
        {
            s = new Intent();
            Bundle bundle1 = new Bundle();
            bundle1.putBoolean("islogin", false);
            s.putExtras(bundle1);
            s.setClass(getActivity(), com/mixerbox/mixerbox3b/LoginBridge);
            startActivity(s);
            getActivity().finish();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = new Intent();
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("islogin", false);
        s.putExtras(bundle2);
        s.setClass(getActivity(), com/mixerbox/mixerbox3b/LoginBridge);
        startActivity(s);
        getActivity().finish();
    }

    s(Context context)
    {
        this$0 = SettingsFragment.this;
        super(context);
    }
}
