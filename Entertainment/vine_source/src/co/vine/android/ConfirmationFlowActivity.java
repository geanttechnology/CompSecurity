// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import co.vine.android.client.AppController;

// Referenced classes of package co.vine.android:
//            BaseActionBarActivity, ConfirmationFlowVerificationFragment, BaseFragment, ConfirmationFlowEntryFragment

public class ConfirmationFlowActivity extends BaseActionBarActivity
{

    public static final int DIALOG_VERIFY_PHONE = 1;
    public static final String EXTRA_FROM_SIGN_UP = "from_sign_up";
    public static final String EXTRA_PHONE_NUMBER = "phone_number";
    public static final int RESULT_VERIFY_PHONE_FAILURE = 1528;
    public static final int RESULT_VERIFY_PHONE_SUCCESS = 1527;
    private static final String TAG = "confirmationFlow";

    public ConfirmationFlowActivity()
    {
    }

    public static Intent getIntent(Context context, String s, boolean flag)
    {
        context = new Intent(context, co/vine/android/ConfirmationFlowActivity);
        context.putExtra("phone_number", s);
        context.putExtra("from_sign_up", flag);
        return context;
    }

    public static void requestPhoneVerification(AppController appcontroller, String s)
    {
        appcontroller.requestPhoneVerification(appcontroller.getActiveSession(), s, appcontroller.getActiveId());
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f030045, true, true);
        Intent intent = getIntent();
        boolean flag = intent.getBooleanExtra("from_sign_up", false);
        if (flag)
        {
            setupActionBar(Boolean.valueOf(false), Boolean.valueOf(true), 0x7f0e0124, Boolean.valueOf(false));
        } else
        {
            setupActionBar(Boolean.valueOf(true), Boolean.valueOf(true), 0x7f0e008d, Boolean.valueOf(true));
        }
        if (bundle == null)
        {
            Bundle bundle1;
            if (flag)
            {
                bundle = new ConfirmationFlowVerificationFragment();
            } else
            {
                bundle = new ConfirmationFlowEntryFragment();
            }
            bundle1 = BaseFragment.prepareArguments(intent);
            bundle1.putString("phone_number", intent.getStringExtra("phone_number"));
            bundle.setArguments(bundle1);
            getSupportFragmentManager().beginTransaction().add(0x7f0a0102, bundle, "confirmationFlow").commit();
        }
    }
}
