// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.target.ui.view.a;

// Referenced classes of package com.target.ui.fragment.account:
//            BaseAccountDialog

public class AccountLockedDialog extends BaseAccountDialog
{
    static class Views extends a
    {

        Button ok;

        Views(View view)
        {
            super(view);
        }
    }


    private BaseAccountDialog.e mListener;
    private final android.view.View.OnClickListener mOkButtonListener = new android.view.View.OnClickListener() {

        final AccountLockedDialog this$0;

        public void onClick(View view)
        {
            dismiss();
        }

            
            {
                this$0 = AccountLockedDialog.this;
                super();
            }
    };
    private Views mViews;

    public AccountLockedDialog()
    {
    }

    public static AccountLockedDialog a(Fragment fragment)
    {
        AccountLockedDialog accountlockeddialog = new AccountLockedDialog();
        if (fragment == null)
        {
            return accountlockeddialog;
        } else
        {
            accountlockeddialog.setTargetFragment(fragment, 0);
            return accountlockeddialog;
        }
    }

    public void onAttach(Activity activity)
    {
        Fragment fragment = getTargetFragment();
        if (fragment != null)
        {
            mListener = ((BaseAccountDialog.f)fragment).n();
        } else
        {
            mListener = null;
        }
        super.onAttach(activity);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030042, viewgroup, false);
        mViews = new Views(layoutinflater);
        mViews.ok.setOnClickListener(mOkButtonListener);
        return layoutinflater;
    }

    public void onDetach()
    {
        mListener = null;
        super.onDetach();
    }

    public void onStop()
    {
        super.onStop();
        if (mListener == null)
        {
            return;
        } else
        {
            mListener.c();
            return;
        }
    }
}
