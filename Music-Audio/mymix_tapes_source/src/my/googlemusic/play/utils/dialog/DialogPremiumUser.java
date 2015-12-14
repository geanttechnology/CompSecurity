// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils.dialog;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import my.googlemusic.play.activities.PremiumActivity;
import my.googlemusic.play.utils.views.RobotoTextView;

public class DialogPremiumUser extends DialogFragment
    implements android.view.View.OnClickListener
{

    private Dialog mDialog;
    private ViewHolderDialog mHolderDialog;

    public DialogPremiumUser()
    {
    }

    public void onClick(View view)
    {
    /* block-local class not found */
    class ViewHolderDialog {}

        if (view == ViewHolderDialog.access._mth100(mHolderDialog))
        {
            startActivity(new Intent(getActivity(), my/googlemusic/play/activities/PremiumActivity));
            mDialog.cancel();
        } else
        if (view == ViewHolderDialog.access._mth200(mHolderDialog))
        {
            mDialog.cancel();
            return;
        }
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = new android.app.AlertDialog.Builder(new ContextThemeWrapper(getActivity(), 0x7f0800e7));
        View view = getActivity().getLayoutInflater().inflate(0x7f030053, null);
        mHolderDialog = new ViewHolderDialog(null);
        ViewHolderDialog.access._mth102(mHolderDialog, (RobotoTextView)view.findViewById(0x7f0d01d0));
        ViewHolderDialog.access._mth202(mHolderDialog, (RobotoTextView)view.findViewById(0x7f0d01cf));
        ViewHolderDialog.access._mth100(mHolderDialog).setOnClickListener(this);
        ViewHolderDialog.access._mth200(mHolderDialog).setOnClickListener(this);
        bundle.setView(view);
        mDialog = bundle.create();
        return mDialog;
    }
}
