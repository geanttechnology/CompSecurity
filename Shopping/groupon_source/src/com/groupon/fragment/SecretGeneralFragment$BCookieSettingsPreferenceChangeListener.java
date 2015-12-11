// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.ListPreference;
import android.preference.Preference;
import android.widget.EditText;
import com.groupon.cookies.CookieFactory;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment:
//            SecretGeneralFragment

private class bCookieSettings
    implements android.preference.r
{

    private final String bCookieOptions[];
    private final ListPreference bCookieSettings;
    final SecretGeneralFragment this$0;

    public boolean onPreferenceChange(final Preference editor, final Object newValue)
    {
        editor = ((SharedPreferences)prefs.get()).edit();
        if (newValue.toString().equals(bCookieOptions[0]) && !((SharedPreferences)prefs.get()).getString("systemGeneratedBCookie", "").equals(((CookieFactory)SecretGeneralFragment.access$100(SecretGeneralFragment.this).get()).getBrowserCookie()))
        {
            ((CookieFactory)SecretGeneralFragment.access$100(SecretGeneralFragment.this).get()).refreshBrowserCookie(getActivity(), ((SharedPreferences)prefs.get()).getString("systemGeneratedBCookie", null));
            bCookieSettings.setSummary(newValue.toString());
            return true;
        }
        if (newValue.toString().equals(bCookieOptions[1]))
        {
            android.app.Listener listener = new android.app.Listener.bCookieOptions(getActivity());
            final EditText bCookieInput = new EditText(getActivity());
            listener.bCookieOptions(bCookieInput);
            if (!((SharedPreferences)prefs.get()).getBoolean("isSystemGeneratedBCookie", true))
            {
                bCookieInput.setText(((CookieFactory)SecretGeneralFragment.access$100(SecretGeneralFragment.this).get()).getBrowserCookie());
            }
            listener._mth0(0x7f0804fe, new android.content.DialogInterface.OnClickListener() {

                final SecretGeneralFragment.BCookieSettingsPreferenceChangeListener this$1;
                final EditText val$bCookieInput;
                final android.content.SharedPreferences.Editor val$editor;
                final Object val$newValue;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    if (((SharedPreferences)prefs.get()).getBoolean("isSystemGeneratedBCookie", true))
                    {
                        editor.putString("systemGeneratedBCookie", ((CookieFactory)SecretGeneralFragment.access$100(this$0).get()).getBrowserCookie());
                        editor.putBoolean("isSystemGeneratedBCookie", false);
                        editor.commit();
                    }
                    ((CookieFactory)SecretGeneralFragment.access$100(this$0).get()).refreshBrowserCookie(getActivity(), bCookieInput.getText().toString());
                    bCookieSettings.setSummary(newValue.toString());
                }

            
            {
                this$1 = SecretGeneralFragment.BCookieSettingsPreferenceChangeListener.this;
                editor = editor1;
                bCookieInput = edittext;
                newValue = obj;
                super();
            }
            });
            listener.Listener(0x7f080084, new android.content.DialogInterface.OnClickListener() {

                final SecretGeneralFragment.BCookieSettingsPreferenceChangeListener this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                }

            
            {
                this$1 = SecretGeneralFragment.BCookieSettingsPreferenceChangeListener.this;
                super();
            }
            });
            listener.Listener().show();
            return true;
        } else
        {
            ((CookieFactory)SecretGeneralFragment.access$100(SecretGeneralFragment.this).get()).refreshBrowserCookie(getActivity(), null);
            bCookieSettings.setSummary(newValue.toString());
            return true;
        }
    }


    public _cls2.this._cls1(String as[], ListPreference listpreference)
    {
        this$0 = SecretGeneralFragment.this;
        super();
        bCookieOptions = as;
        bCookieSettings = listpreference;
    }
}
