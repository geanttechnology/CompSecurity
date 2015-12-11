// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.dialogs;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import com.gotv.crackle.VideoPlayerActivity;
import com.gotv.crackle.VideoPlayerActivityFlash;
import com.gotv.crackle.base.BaseActivity;
import com.gotv.crackle.helpers.MyCrackleViewHelper;

public class MainDialogFragment extends DialogFragment
{

    public static final int DIALOG_AUTHENTICATING = 0xceae7;
    public static final int DIALOG_FACEBOOK_ERROR = 0x20945f;
    public static final int DIALOG_LOADING = 42340;
    public static final int DIALOG_NO_WIFI = 0xcb51c;
    public static final int DIALOG_SIGN_IN = 0xa7b54;
    public static final int DIALOG_SIGN_IN_HISTORY = 0x2d7d7d;
    public static final int NETWORK_DIALOG_CANNOT_PLAY = 0x5a39fc;
    private android.content.DialogInterface.OnCancelListener mCancelledListener;

    public MainDialogFragment()
    {
    }

    public static MainDialogFragment newInstance(int i)
    {
        MainDialogFragment maindialogfragment = new MainDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("id", i);
        maindialogfragment.setArguments(bundle);
        return maindialogfragment;
    }

    public static MainDialogFragment newInstance(int i, String s)
    {
        MainDialogFragment maindialogfragment = new MainDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("id", i);
        bundle.putString("message", s);
        maindialogfragment.setArguments(bundle);
        return maindialogfragment;
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        int i = getArguments().getInt("id");
        String s = getArguments().getString("message");
        bundle = s;
        if (s == null)
        {
            bundle = "";
        }
        switch (i)
        {
        default:
            return null;

        case 832796: 
            return (new android.app.AlertDialog.Builder(getActivity())).setIcon(0x1080027).setTitle(getResources().getString(0x7f0b00f8)).setMessage(getResources().getString(0x7f0b00f7)).setNegativeButton(getResources().getString(0x7f0b00b1), new android.content.DialogInterface.OnClickListener() {

                final MainDialogFragment this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface.dismiss();
                    if ((getActivity() instanceof VideoPlayerActivity) || (getActivity() instanceof VideoPlayerActivityFlash))
                    {
                        getActivity().finish();
                    }
                }

            
            {
                this$0 = MainDialogFragment.this;
                super();
            }
            }).setPositiveButton(getResources().getString(0x7f0b00b0), new android.content.DialogInterface.OnClickListener() {

                final MainDialogFragment this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface.dismiss();
                    BaseActivity.getMyCrackleHelper().showSettings(getActivity());
                }

            
            {
                this$0 = MainDialogFragment.this;
                super();
            }
            }).create();

        case 42340: 
            bundle = new ProgressDialog(getActivity());
            bundle.setIndeterminate(true);
            bundle.setMessage(getResources().getString(0x7f0b0084));
            bundle.setCancelable(false);
            return bundle;

        case 5913084: 
            return (new android.app.AlertDialog.Builder(getActivity())).setIcon(0x1080027).setMessage(getResources().getString(0x7f0b00a4)).setNegativeButton(getResources().getString(0x7f0b00b2), new android.content.DialogInterface.OnClickListener() {

                final MainDialogFragment this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = MainDialogFragment.this;
                super();
            }
            }).create();

        case 2135135: 
            return (new android.app.AlertDialog.Builder(getActivity())).setIcon(0x1080027).setMessage(bundle).setNegativeButton("OK", new android.content.DialogInterface.OnClickListener() {

                final MainDialogFragment this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = MainDialogFragment.this;
                super();
            }
            }).create();

        case 686932: 
            bundle = new android.app.AlertDialog.Builder(getActivity());
            bundle.setMessage(getResources().getString(0x7f0b00cc));
            bundle.setPositiveButton(getResources().getString(0x7f0b0087), new android.content.DialogInterface.OnClickListener() {

                final MainDialogFragment this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    BaseActivity.getMyCrackleHelper().showSignInDialog((BaseActivity)getActivity());
                }

            
            {
                this$0 = MainDialogFragment.this;
                super();
            }
            });
            bundle.setNegativeButton(getResources().getString(0x7f0b00ce), new android.content.DialogInterface.OnClickListener() {

                final MainDialogFragment this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    if (mCancelledListener != null)
                    {
                        mCancelledListener.onCancel(dialoginterface);
                    }
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = MainDialogFragment.this;
                super();
            }
            });
            return bundle.create();

        case 2981245: 
            bundle = new android.app.AlertDialog.Builder(getActivity());
            break;
        }
        bundle.setMessage(getResources().getString(0x7f0b00cd));
        bundle.setPositiveButton(getResources().getString(0x7f0b0087), new android.content.DialogInterface.OnClickListener() {

            final MainDialogFragment this$0;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                BaseActivity.getMyCrackleHelper().showSignInDialog((BaseActivity)getActivity());
            }

            
            {
                this$0 = MainDialogFragment.this;
                super();
            }
        });
        bundle.setNegativeButton(getResources().getString(0x7f0b00ce), new android.content.DialogInterface.OnClickListener() {

            final MainDialogFragment this$0;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                if (mCancelledListener != null)
                {
                    mCancelledListener.onCancel(dialoginterface);
                }
                dialoginterface.dismiss();
            }

            
            {
                this$0 = MainDialogFragment.this;
                super();
            }
        });
        return bundle.create();
    }

    public void setOnCancelledListener(android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        mCancelledListener = oncancellistener;
    }

}
