// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.text.TextUtils;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.util.Util;

// Referenced classes of package co.vine.android:
//            PrivacyControlsFragment

class this._cls0 extends AppSessionListener
{

    final PrivacyControlsFragment this$0;

    public void onUpdateAcceptOonComplete(String s, int i, String s1, boolean flag)
    {
        if (PrivacyControlsFragment.access$000(PrivacyControlsFragment.this) != null)
        {
            PrivacyControlsFragment.access$000(PrivacyControlsFragment.this).dismiss();
        }
        s = getActivity();
        if (i == 200)
        {
            s = Util.getDefaultSharedPrefs(s).edit();
            s._mth0("accept_out_of_network_messages", flag);
            s._mth0();
            return;
        }
        if (!TextUtils.isEmpty(s1))
        {
            Util.showCenteredToast(s, s1);
            return;
        } else
        {
            Util.showCenteredToast(s, 0x7f0e0189);
            return;
        }
    }

    public void onUpdateDiscoverability(String s, int i, String s1, int j, boolean flag)
    {
        if (PrivacyControlsFragment.access$000(PrivacyControlsFragment.this) != null)
        {
            PrivacyControlsFragment.access$000(PrivacyControlsFragment.this).dismiss();
        }
        s = getActivity();
        if (i == 200)
        {
            if (j == 0)
            {
                s = "email_discoverable";
            } else
            {
                s = "phone_discoverable";
            }
            s1 = Util.getDefaultSharedPrefs(getActivity()).edit();
            s1._mth0(s, flag);
            s1._mth0();
            return;
        }
        if (!TextUtils.isEmpty(s1))
        {
            Util.showCenteredToast(s, s1);
            return;
        } else
        {
            Util.showCenteredToast(s, 0x7f0e0189);
            return;
        }
    }

    public void onUpdateEnableAddressBookComplete(String s, int i, String s1, boolean flag)
    {
        if (PrivacyControlsFragment.access$000(PrivacyControlsFragment.this) != null)
        {
            PrivacyControlsFragment.access$000(PrivacyControlsFragment.this).dismiss();
        }
        s = getActivity();
        if (i == 200)
        {
            s = Util.getDefaultSharedPrefs(getActivity()).edit();
            s._mth0("enable_address_book", flag);
            s._mth0();
            if (flag)
            {
                mAppController.sendAddressBook();
            }
            return;
        }
        if (!TextUtils.isEmpty(s1))
        {
            Util.showCenteredToast(s, s1);
            return;
        } else
        {
            Util.showCenteredToast(s, 0x7f0e0189);
            return;
        }
    }

    ()
    {
        this$0 = PrivacyControlsFragment.this;
        super();
    }
}
