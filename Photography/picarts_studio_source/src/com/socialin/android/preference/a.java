// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.preference;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import com.firegnom.rat.util.DialogUtils;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.controllers.UpdateUserController;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.request.UpdateUserParams;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.dialog.g;
import com.socialin.android.picsart.profile.activity.UserPasswordConfirmActivity;
import com.socialin.android.picsart.profile.util.y;
import com.socialin.android.util.Utils;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.b;
import com.socialin.asyncnet.d;
import myobfuscated.f.m;

public final class a extends PreferenceFragment
{

    private SharedPreferences a;
    private Boolean b;
    private Boolean c;
    private UpdateUserController d;
    private UpdateUserParams e;
    private int f;
    private CheckBoxPreference g;
    private g h;

    public a()
    {
        d = new UpdateUserController();
        e = new UpdateUserParams();
        f = 0;
        h = null;
    }

    static g a(a a1)
    {
        return a1.h;
    }

    static CheckBoxPreference b(a a1)
    {
        return a1.g;
    }

    static int c(a a1)
    {
        a1.f = 15;
        return 15;
    }

    static int d(a a1)
    {
        return a1.f;
    }

    static UpdateUserController e(a a1)
    {
        return a1.d;
    }

    public final void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (j != -1) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR lookupswitch 2: default 40
    //                   15: 103
    //                   4538: 81;
           goto _L2 _L3 _L4
_L2:
        if (j != 0) goto _L6; else goto _L5
_L5:
        i;
        JVM INSTR lookupswitch 3: default 80
    //                   15: 260
    //                   16: 260
    //                   4538: 260;
           goto _L6 _L7 _L7 _L7
_L6:
        return;
_L4:
        startActivityForResult(new Intent(getActivity(), com/socialin/android/picsart/profile/activity/UserPasswordConfirmActivity), 15);
        continue; /* Loop/switch isn't completed */
_L3:
        if (intent != null && intent.hasExtra("passwordConfirm"))
        {
            intent = intent.getStringExtra("passwordConfirm");
        } else
        {
            intent = null;
        }
        if (intent == null || intent.equals(""))
        {
            g.setEnabled(true);
            Utils.b(getActivity(), 0x7f080237);
        } else
        {
            boolean flag = g.isChecked();
            UpdateUserParams updateuserparams = e;
            int k;
            if (flag)
            {
                k = 1;
            } else
            {
                k = 0;
            }
            updateuserparams.mature = k;
            e.passwordConfirm = intent;
            d.setRequestParams(e);
            d.setRequestCompleteListener(new d(flag) {

                private boolean a;
                private a b;

                public final volatile void onCancelRequest(Object obj, Request request)
                {
                }

                public final void onFailure(Exception exception, Request request)
                {
                    DialogUtils.dismissDialog(b.getActivity(), a.a(b));
                    com.socialin.android.preference.a.b(b).setEnabled(true);
                    if (exception.getLocalizedMessage() == null || exception.getLocalizedMessage().equals(""))
                    {
                        exception = b.getString(0x7f080237);
                    } else
                    {
                        exception = exception.getLocalizedMessage();
                    }
                    Utils.b(b.getActivity(), exception);
                }

                public final transient void onProgressUpdate(Integer ainteger[])
                {
                }

                public final void onSuccess(Object obj, Request request)
                {
                    boolean flag1 = true;
                    DialogUtils.dismissDialog(b.getActivity(), a.a(b));
                    SocialinV3.getInstance().getUser().mature = a;
                    com.socialin.android.preference.a.b(b).setEnabled(true);
                    obj = com.socialin.android.preference.a.b(b);
                    if (a)
                    {
                        flag1 = false;
                    }
                    ((CheckBoxPreference) (obj)).setChecked(flag1);
                }

            
            {
                b = a.this;
                a = flag;
                super();
            }
            });
            DialogUtils.showDialog(getActivity(), h);
            d.doRequest("updateUserSettings", e);
        }
        continue; /* Loop/switch isn't completed */
_L7:
        g.setEnabled(true);
        return;
        if (true) goto _L2; else goto _L8
_L8:
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        addPreferencesFromResource(0x7f060000);
        AnalyticUtils.getInstance(getActivity()).trackLocalAction("contentPref:onCreate");
        a = getActivity().getSharedPreferences((new StringBuilder("sinPref_")).append(getString(m.e(getActivity(), "app_name_short"))).toString(), 0);
        b = Boolean.valueOf(SocialinV3.getInstance().getUser().mature);
        c = Boolean.valueOf(a.getBoolean("enable_recent_photos_key", true));
        g = (CheckBoxPreference)findPreference("enable_safe_content");
        bundle = g;
        boolean flag;
        if (!b.booleanValue())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bundle.setChecked(flag);
        g.setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {

            private a a;

            public final boolean onPreferenceChange(Preference preference, Object obj)
            {
                a.c(a);
                com.socialin.android.preference.a.b(a).setEnabled(false);
                if (y.d(a.getActivity()))
                {
                    preference = new Intent(a.getActivity(), com/socialin/android/picsart/profile/activity/UserPasswordConfirmActivity);
                    a.startActivityForResult(preference, com.socialin.android.preference.a.d(a));
                }
                return false;
            }

            
            {
                a = a.this;
                super();
            }
        });
        h = new g(getActivity());
        h.setMessage(getString(0x7f0803d8));
        h.setCancelable(true);
        h.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            private a a;

            public final void onCancel(DialogInterface dialoginterface)
            {
                com.socialin.asyncnet.b.a().a(a.e(a).getRequestId());
                com.socialin.android.preference.a.b(a).setEnabled(true);
            }

            
            {
                a = a.this;
                super();
            }
        });
    }

    public final void onPause()
    {
        super.onPause();
        boolean flag = SocialinV3.getInstance().getUser().mature;
        boolean flag1 = a.getBoolean("enable_recent_photos_key", true);
        if (b.compareTo(Boolean.valueOf(flag)) != 0 || c.compareTo(Boolean.valueOf(flag1)) != 0)
        {
            getActivity().setResult(-1);
        }
    }
}
