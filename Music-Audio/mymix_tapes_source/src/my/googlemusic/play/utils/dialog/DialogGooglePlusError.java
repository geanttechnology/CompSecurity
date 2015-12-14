// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils.dialog;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;
import my.googlemusic.play.utils.views.RobotoTextView;

public class DialogGooglePlusError extends DialogFragment
    implements android.view.View.OnClickListener
{

    private Dialog mDialog;
    private ViewHolderDialog mHolderDialog;

    public DialogGooglePlusError()
    {
    }

    private void openApp()
    {
        try
        {
            Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage("com.google.android.apps.plus");
            intent.addCategory("android.intent.category.LAUNCHER");
            getActivity().startActivity(intent);
            return;
        }
        catch (Exception exception)
        {
            Toast.with(getActivity()).message("You don't have google plus installed, please install and finish set up.").show();
            exception.printStackTrace();
            return;
        }
    }

    public void onClick(View view)
    {
    /* block-local class not found */
    class ViewHolderDialog {}

        if (view == ViewHolderDialog.access._mth100(mHolderDialog))
        {
            openApp();
            mDialog.cancel();
            return;
        } else
        {
            mDialog.cancel();
            return;
        }
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = new android.app.AlertDialog.Builder(new ContextThemeWrapper(getActivity(), 0x7f0800e7));
        View view = getActivity().getLayoutInflater().inflate(0x7f030051, null);
        mHolderDialog = new ViewHolderDialog(null);
        ViewHolderDialog.access._mth102(mHolderDialog, (RobotoTextView)view.findViewById(0x7f0d01cc));
        ViewHolderDialog.access._mth202(mHolderDialog, (RobotoTextView)view.findViewById(0x7f0d01cd));
        ViewHolderDialog.access._mth100(mHolderDialog).setOnClickListener(this);
        ViewHolderDialog.access._mth200(mHolderDialog).setOnClickListener(this);
        bundle.setView(view);
        mDialog = bundle.create();
        mDialog.setCanceledOnTouchOutside(false);
        return mDialog;
    }
}
