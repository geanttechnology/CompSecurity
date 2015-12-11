// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.ListPreference;
import android.widget.EditText;
import com.groupon.cookies.CookieFactory;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment:
//            SecretGeneralFragment

class val.newValue
    implements android.content.er._cls1
{

    final val.newValue this$1;
    final EditText val$bCookieInput;
    final android.content.er val$editor;
    final Object val$newValue;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (((SharedPreferences)prefs.get()).getBoolean("isSystemGeneratedBCookie", true))
        {
            val$editor.editor("systemGeneratedBCookie", ((CookieFactory)SecretGeneralFragment.access$100(_fld0).get()).getBrowserCookie());
            val$editor.editor("isSystemGeneratedBCookie", false);
            val$editor.editor();
        }
        ((CookieFactory)SecretGeneralFragment.access$100(_fld0).get()).refreshBrowserCookie(getActivity(), val$bCookieInput.getText().toString());
        cess._mth200(this._cls1.this).setSummary(val$newValue.toString());
    }

    ()
    {
        this$1 = final_;
        val$editor = er;
        val$bCookieInput = edittext;
        val$newValue = Object.this;
        super();
    }
}
