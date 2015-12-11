// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import com.bitstrips.imoji.util.PreferenceUtils;

public class AvatarChangeRegister
{
    static interface AvatarChangeListener
    {

        public abstract void onChanged();
    }


    private Activity activity;
    private android.content.SharedPreferences.OnSharedPreferenceChangeListener listener;
    PreferenceUtils preferenceUtils;

    public AvatarChangeRegister()
    {
    }

    private String getResource(int i)
    {
        return activity.getResources().getString(i);
    }

    public void registerAvatarIdChangeListener(Activity activity1, final AvatarChangeListener avatarChangeListener)
    {
        activity = activity1;
        listener = new android.content.SharedPreferences.OnSharedPreferenceChangeListener() {

            final AvatarChangeRegister this$0;
            final AvatarChangeListener val$avatarChangeListener;

            public void onSharedPreferenceChanged(SharedPreferences sharedpreferences, String s)
            {
                if (getResource(0x7f06002a).equals(s))
                {
                    avatarChangeListener.onChanged();
                }
            }

            
            {
                this$0 = AvatarChangeRegister.this;
                avatarChangeListener = avatarchangelistener;
                super();
            }
        };
        preferenceUtils.registerOnSharedPreferenceChangeListener(listener);
    }

    public void unregister()
    {
        preferenceUtils.unregisterOnSharedPreferenceChangeListener(listener);
        listener = null;
        activity = null;
    }

}
