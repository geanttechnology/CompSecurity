// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widgets;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;

public class PromptDialogSupportFragment extends DialogFragment
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
    private static final String ARG_DIALOG_MESSAGE_STRING = "message_string";
    private static final String ARG_DIALOG_NEGATIVE_BUTTON = "negative_button";
    private static final String ARG_DIALOG_NEUTRAL_BUTTON = "neutral_button";
    private static final String ARG_DIALOG_POSITIVE_BUTTON = "positive_button";
    private static final String ARG_DIALOG_THEME = "theme";
    private static final String ARG_DIALOG_TITLE = "title";
    private OnDialogDoneListener mListener;

    public PromptDialogSupportFragment()
    {
    }

    public static PromptDialogSupportFragment newInstance(int i)
    {
        return newInstance(i, 0);
    }

    public static PromptDialogSupportFragment newInstance(int i, int j)
    {
        PromptDialogSupportFragment promptdialogsupportfragment = new PromptDialogSupportFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("id", i);
        bundle.putInt("theme", j);
        promptdialogsupportfragment.setArguments(bundle);
        return promptdialogsupportfragment;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        android.support.v4.app.Fragment fragment = getTargetFragment();
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
        Bundle bundle1 = getArguments();
        int i = bundle1.getInt("theme", 2);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            bundle = new android.app.AlertDialog.Builder(getActivity(), i);
        } else
        {
            bundle = new android.app.AlertDialog.Builder(getActivity());
        }
        if (bundle1.containsKey("icon"))
        {
            bundle.setIcon(bundle1.getInt("icon"));
        }
        if (bundle1.containsKey("title"))
        {
            bundle.setTitle(bundle1.getInt("title"));
        }
        if (bundle1.containsKey("message"))
        {
            bundle.setMessage(bundle1.getInt("message"));
        }
        if (bundle1.containsKey("message_string"))
        {
            bundle.setMessage(bundle1.getString("message_string"));
        }
        if (bundle1.containsKey("positive_button"))
        {
            bundle.setPositiveButton(bundle1.getInt("positive_button"), this);
        }
        if (bundle1.containsKey("neutral_button"))
        {
            bundle.setNeutralButton(bundle1.getInt("neutral_button"), this);
        }
        if (bundle1.containsKey("negative_button"))
        {
            bundle.setNegativeButton(bundle1.getInt("negative_button"), this);
        }
        if (bundle1.containsKey("items"))
        {
            bundle.setItems(getResources().getTextArray(bundle1.getInt("items")), this);
        }
        if (bundle1.containsKey("items_string"))
        {
            bundle.setItems(bundle1.getStringArray("items_string"), this);
        }
        return bundle.create();
    }

    public PromptDialogSupportFragment setIcon(int i)
    {
        getArguments().putInt("icon", i);
        return this;
    }

    public PromptDialogSupportFragment setItems(int i)
    {
        getArguments().putInt("items", i);
        return this;
    }

    public PromptDialogSupportFragment setItems(String as[])
    {
        getArguments().putStringArray("items_string", as);
        return this;
    }

    public void setListener(OnDialogDoneListener ondialogdonelistener)
    {
        mListener = ondialogdonelistener;
    }

    public PromptDialogSupportFragment setMessage(int i)
    {
        getArguments().putInt("message", i);
        return this;
    }

    public PromptDialogSupportFragment setMessage(String s)
    {
        getArguments().putString("message_string", s);
        return this;
    }

    public PromptDialogSupportFragment setNegativeButton(int i)
    {
        getArguments().putInt("negative_button", i);
        return this;
    }

    public PromptDialogSupportFragment setNeutralButton(int i)
    {
        getArguments().putInt("neutral_button", i);
        return this;
    }

    public PromptDialogSupportFragment setPositiveButton(int i)
    {
        getArguments().putInt("positive_button", i);
        return this;
    }

    public PromptDialogSupportFragment setTitle(int i)
    {
        getArguments().putInt("title", i);
        return this;
    }

    public void show(FragmentManager fragmentmanager)
    {
        show(fragmentmanager, null);
    }
}
