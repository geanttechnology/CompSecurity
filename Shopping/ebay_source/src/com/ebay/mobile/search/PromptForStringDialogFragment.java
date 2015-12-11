// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.app.Dialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.ebay.mobile.activities.BaseDialogFragment;
import com.ebay.mobile.ui_stuff.Util;
import java.lang.ref.WeakReference;

public class PromptForStringDialogFragment extends BaseDialogFragment
    implements TextWatcher
{
    public static interface PromptForStringCompletedListener
    {

        public abstract void onPromptForStringCompleted(String s, boolean flag, String s1, Bundle bundle);
    }


    private static final String EXTRA_LABEL_ID = "label_id";
    private static final String EXTRA_PROMPT_ID = "prompt_id";
    private static final String EXTRA_REASON = "reason";
    private static final String EXTRA_TITLE_ID = "title_id";
    private static final String EXTRA_USER_EXTRAS = "extras";
    private static WeakReference activeInstance = null;
    private EditText stringValueField;

    public PromptForStringDialogFragment()
    {
    }

    public static void Show(FragmentManager fragmentmanager, int i, int j, int k, String s, Bundle bundle)
    {
        if (activeInstance != null && activeInstance.get() != null)
        {
            return;
        }
        Bundle bundle1 = new Bundle();
        bundle1.putInt("title_id", i);
        bundle1.putInt("prompt_id", j);
        bundle1.putInt("label_id", k);
        if (s != null)
        {
            bundle1.putString("reason", s);
        }
        if (bundle != null)
        {
            bundle1.putBundle("extras", bundle);
        }
        s = new PromptForStringDialogFragment();
        s.setArguments(bundle1);
        s.show(fragmentmanager, "dialog");
    }

    private PromptForStringCompletedListener getListener()
    {
        android.app.Activity activity = getActivity();
        if (activity instanceof PromptForStringCompletedListener)
        {
            return (PromptForStringCompletedListener)activity;
        } else
        {
            return null;
        }
    }

    private void updateVisibility()
    {
        boolean flag;
        if (!TextUtils.isEmpty(stringValueField.getText().toString()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((AlertDialog)getDialog()).getButton(-1).setEnabled(flag);
    }

    public void afterTextChanged(Editable editable)
    {
        updateVisibility();
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        PromptForStringCompletedListener promptforstringcompletedlistener = getListener();
        if (promptforstringcompletedlistener != null)
        {
            Bundle bundle = getArguments();
            promptforstringcompletedlistener.onPromptForStringCompleted("", true, bundle.getString("reason"), bundle.getBundle("extras"));
        }
        Util.hideSoftInput(getActivity(), stringValueField);
        super.onCancel(dialoginterface);
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = new com.ebay.common.view.util.DialogManager.AlertDialogBuilder(getActivity());
        bundle.setTitle(getArguments().getInt("title_id"));
        View view = LayoutInflater.from(new ContextThemeWrapper(getActivity(), 0x7f0a002b)).inflate(0x7f0301ae, null);
        stringValueField = (EditText)view.findViewById(0x7f1004fc);
        stringValueField.addTextChangedListener(this);
        bundle.setPositiveButton(0x7f070738, new android.content.DialogInterface.OnClickListener() {

            final PromptForStringDialogFragment this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                Object obj = stringValueField.getText();
                PromptForStringCompletedListener promptforstringcompletedlistener;
                if (obj != null)
                {
                    obj = ((CharSequence) (obj)).toString();
                } else
                {
                    obj = "";
                }
                promptforstringcompletedlistener = getListener();
                if (promptforstringcompletedlistener != null)
                {
                    Bundle bundle1 = getArguments();
                    promptforstringcompletedlistener.onPromptForStringCompleted(((String) (obj)), false, bundle1.getString("reason"), bundle1.getBundle("extras"));
                }
                Util.hideSoftInput(getActivity(), stringValueField);
                dialoginterface.dismiss();
            }

            
            {
                this$0 = PromptForStringDialogFragment.this;
                super();
            }
        });
        bundle.setNegativeButton(0x7f0701cc, null);
        ((TextView)view.findViewById(0x7f1004fb)).setText(getResources().getString(getArguments().getInt("label_id")));
        ((TextView)view.findViewById(0x7f1004f9)).setText(getResources().getString(getArguments().getInt("prompt_id")));
        bundle.setView(view);
        return bundle.create();
    }

    public void onPause()
    {
        activeInstance = null;
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        activeInstance = new WeakReference(this);
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }



}
