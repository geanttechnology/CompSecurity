// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.app.Dialog;
import android.app.FragmentManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.ebay.mobile.activities.BaseDialogFragment;

public class PromptDialogFragment extends BaseDialogFragment
{

    private static final String EXTRA_PROMPT_ID = "prompt_id";
    private static final String EXTRA_TITLE_ID = "title_id";

    public PromptDialogFragment()
    {
    }

    public static void Show(FragmentManager fragmentmanager, int i, int j)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("title_id", i);
        bundle.putInt("prompt_id", j);
        PromptDialogFragment promptdialogfragment = new PromptDialogFragment();
        promptdialogfragment.setArguments(bundle);
        promptdialogfragment.show(fragmentmanager, "dialog");
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = new com.ebay.common.view.util.DialogManager.AlertDialogBuilder(getActivity());
        bundle.setTitle(getArguments().getInt("title_id"));
        View view = LayoutInflater.from(new ContextThemeWrapper(getActivity(), 0x7f0a002b)).inflate(0x7f0301ad, null);
        bundle.setNegativeButton(0x7f070738, null);
        ((TextView)view.findViewById(0x7f1004f9)).setText(getResources().getString(getArguments().getInt("prompt_id")));
        bundle.setView(view);
        return bundle.create();
    }
}
