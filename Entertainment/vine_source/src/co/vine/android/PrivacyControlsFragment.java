// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.util.Util;
import co.vine.android.views.SwitchInterface;

// Referenced classes of package co.vine.android:
//            BaseControllerFragment

public class PrivacyControlsFragment extends BaseControllerFragment
    implements android.widget.CompoundButton.OnCheckedChangeListener
{
    class ContentControlsListener extends AppSessionListener
    {

        final PrivacyControlsFragment this$0;

        public void onUpdateAcceptOonComplete(String s, int i, String s1, boolean flag)
        {
            if (mProgress != null)
            {
                mProgress.dismiss();
            }
            s = getActivity();
            if (i == 200)
            {
                s = Util.getDefaultSharedPrefs(s).edit();
                s.putBoolean("accept_out_of_network_messages", flag);
                s.apply();
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
            if (mProgress != null)
            {
                mProgress.dismiss();
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
                s1.putBoolean(s, flag);
                s1.apply();
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
            if (mProgress != null)
            {
                mProgress.dismiss();
            }
            s = getActivity();
            if (i == 200)
            {
                s = Util.getDefaultSharedPrefs(getActivity()).edit();
                s.putBoolean("enable_address_book", flag);
                s.apply();
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

        ContentControlsListener()
        {
            this$0 = PrivacyControlsFragment.this;
            super();
        }
    }


    private static final String STATE_ACCEPT_OON = "state_accept_oon";
    private static final String STATE_ALLOW_ADDRESS_BOOK = "state_address_book";
    private static final String STATE_EMAIL_DISCOVERABLE = "state_email_discoverable";
    private static final String STATE_PHONE_DISCOVERABLE = "state_phone_discoverable";
    public static final int TYPE_EMAIL = 0;
    public static final int TYPE_PHONE = 1;
    private boolean mAcceptOon;
    private boolean mAllowAddressBook;
    private boolean mEmailDiscoverable;
    private boolean mPhoneDiscoverable;
    private ProgressDialog mProgress;

    public PrivacyControlsFragment()
    {
    }

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        mProgress.show();
        switch (compoundbutton.getId())
        {
        case 2131362180: 
        default:
            return;

        case 2131362179: 
            mAcceptOon = flag;
            mAppController.updateAcceptOon(mAcceptOon);
            return;

        case 2131362181: 
            mAllowAddressBook = flag;
            break;
        }
        mAppController.updateEnableAddressBook(mAllowAddressBook);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mAppSessionListener = new ContentControlsListener();
        if (bundle != null)
        {
            mAcceptOon = bundle.getBoolean("state_accept_oon", false);
            mAllowAddressBook = bundle.getBoolean("state_address_book", false);
            mEmailDiscoverable = bundle.getBoolean("state_email_discoverable", true);
            mPhoneDiscoverable = bundle.getBoolean("state_phone_discoverable", true);
        } else
        {
            bundle = Util.getDefaultSharedPrefs(getActivity());
            mAcceptOon = bundle.getBoolean("accept_out_of_network_messages", true);
            mAllowAddressBook = bundle.getBoolean("enable_address_book", false);
            mEmailDiscoverable = bundle.getBoolean("email_discoverable", true);
            mPhoneDiscoverable = bundle.getBoolean("phone_discoverable", true);
        }
        bundle = new ProgressDialog(getActivity(), 0x7f0f0037);
        bundle.setMessage(getString(0x7f0e018a));
        bundle.setProgressStyle(0);
        mProgress = bundle;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030073, viewgroup, false);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("state_accept_oon", mAcceptOon);
        bundle.putBoolean("state_address_book", mAllowAddressBook);
        bundle.putBoolean("state_email_discoverable", mEmailDiscoverable);
        bundle.putBoolean("state_phone_discoverable", mPhoneDiscoverable);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        bundle = (SwitchInterface)view.findViewById(0x7f0a0183);
        view = (SwitchInterface)view.findViewById(0x7f0a0185);
        if (mAcceptOon)
        {
            bundle.setChecked(true);
        }
        if (mAllowAddressBook)
        {
            view.setChecked(true);
        }
        if (!mEmailDiscoverable);
        if (!mPhoneDiscoverable);
        bundle.setOnCheckedChangeListener(this);
        view.setOnCheckedChangeListener(this);
    }

}
