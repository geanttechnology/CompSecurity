// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widgets;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;

public class PromptDialogFragment extends DialogFragment
    implements android.content.DialogInterface.OnClickListener
{
    public static interface OnDialogDoneListener
    {

        public abstract void onDialogDone(DialogInterface dialoginterface, int i, int j);
    }


    private static final String ARG_DIALOG_ICON = "icon";
    private static final String ARG_DIALOG_ID = "id";
    private static final String ARG_DIALOG_ITEMS = "items";
    private static final String ARG_DIALOG_ITEMS_STRING = "items_string";
    private static final String ARG_DIALOG_MESSAGE = "message";
    private static final String ARG_DIALOG_NEGATIVE_BUTTON = "negative_button";
    private static final String ARG_DIALOG_NEUTRAL_BUTTON = "neutral_button";
    private static final String ARG_DIALOG_POSITIVE_BUTTON = "positive_button";
    private static final String ARG_DIALOG_TITLE = "title";
    private OnDialogDoneListener mListener;

    public PromptDialogFragment()
    {
    }

    public static PromptDialogFragment newInstance(int i)
    {
        PromptDialogFragment promptdialogfragment = new PromptDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("id", i);
        promptdialogfragment.setArguments(bundle);
        return promptdialogfragment;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        android.app.Fragment fragment = getTargetFragment();
        if (fragment != null)
        {
            if (fragment instanceof OnDialogDoneListener)
            {
                mListener = (OnDialogDoneListener)fragment;
            }
        } else
        if (activity instanceof OnDialogDoneListener)
        {
            mListener = (OnDialogDoneListener)activity;
            return;
        }
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (mListener != null)
        {
            mListener.onDialogDone(dialoginterface, getArguments().getInt("id"), i);
        }
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        super.onCreateDialog(bundle);
        bundle = getArguments();
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity(), 2);
        if (bundle.containsKey("icon"))
        {
            builder.setIcon(bundle.getInt("icon"));
        }
        if (bundle.containsKey("title"))
        {
            builder.setTitle(bundle.getInt("title"));
        }
        if (bundle.containsKey("message"))
        {
            builder.setMessage(bundle.getInt("message"));
        }
        if (bundle.containsKey("positive_button"))
        {
            builder.setPositiveButton(bundle.getInt("positive_button"), this);
        }
        if (bundle.containsKey("neutral_button"))
        {
            builder.setNeutralButton(bundle.getInt("neutral_button"), this);
        }
        if (bundle.containsKey("negative_button"))
        {
            builder.setNegativeButton(bundle.getInt("negative_button"), this);
        }
        if (bundle.containsKey("items"))
        {
            builder.setItems(getResources().getTextArray(bundle.getInt("items")), this);
        }
        if (bundle.containsKey("items_string"))
        {
            builder.setItems(bundle.getStringArray("items_string"), this);
        }
        return builder.create();
    }

    public PromptDialogFragment setIcon(int i)
    {
        getArguments().putInt("icon", i);
        return this;
    }

    public PromptDialogFragment setItems(int i)
    {
        getArguments().putInt("items", i);
        return this;
    }

    public PromptDialogFragment setItems(String as[])
    {
        getArguments().putStringArray("items_string", as);
        return this;
    }

    public void setListener(OnDialogDoneListener ondialogdonelistener)
    {
        mListener = ondialogdonelistener;
    }

    public PromptDialogFragment setMessage(int i)
    {
        getArguments().putInt("message", i);
        return this;
    }

    public PromptDialogFragment setNegativeButton(int i)
    {
        getArguments().putInt("negative_button", i);
        return this;
    }

    public PromptDialogFragment setNeutralButton(int i)
    {
        getArguments().putInt("neutral_button", i);
        return this;
    }

    public PromptDialogFragment setPositiveButton(int i)
    {
        getArguments().putInt("positive_button", i);
        return this;
    }

    public PromptDialogFragment setTitle(int i)
    {
        getArguments().putInt("title", i);
        return this;
    }

    public void show(FragmentManager fragmentmanager)
    {
        show(fragmentmanager, null);
    }
}
