// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

// Referenced classes of package com.groupon.util:
//            GrouponAlertDialog

public static class positiveButton extends android.app.lder
{

    private troller alertController;
    private final troller.AlertParams alertParams = new troller.AlertParams();
    private View bottomContainer;
    private FrameLayout contentView;
    private Button negativeButton;
    private Button positiveButton;
    private View titleContainer;
    private TextView titleView;

    public AlertDialog create()
    {
        AlertDialog alertdialog = super.AlertParams();
        alertController = new troller(alertdialog);
        alertController.setupViews(alertParams);
        return alertdialog;
    }

    protected ListView getDialogListView()
    {
        ListView listview = new ListView(getContext());
        listview.setLayoutParams(new android.view.t>(-1, -1));
        listview.setCacheColorHint(0);
        listview.setVerticalScrollBarEnabled(true);
        listview.setHorizontalScrollBarEnabled(false);
        listview.setOverScrollMode(1);
        return listview;
    }

    protected TextView getMessageTextView()
    {
        TextView textview = new TextView(getContext());
        textview.setLayoutParams(new android.view.t>(-1, -2));
        textview.setGravity(1);
        textview.setTextColor(getContext().getResources().getColor(0x7f0e00f4));
        textview.setTextSize(1, 18F);
        textview.setMovementMethod(LinkMovementMethod.getInstance());
        return textview;
    }

    public void setAutoDismissOnPositiveButtonClick(boolean flag)
    {
        troller.AlertParams.access._mth002(alertParams, flag);
    }

    public android.app.Listener setItems(CharSequence acharsequence[], android.content.ener ener)
    {
        acharsequence = new ArrayAdapter(getContext(), 0x7f0301e6, acharsequence);
        ListView listview = getDialogListView();
        contentView.addView(listview);
        listview.setAdapter(acharsequence);
        alertParams.listViewContent = listview;
        alertParams.singleChoiceItemsListener = ener;
        return this;
    }

    public android.app.lder setMessage(int i)
    {
        TextView textview = getMessageTextView();
        textview.setText(i);
        i = getContext().getResources().getDimensionPixelSize(0x7f0b00ec);
        contentView.setPadding(i, i, i, i);
        contentView.addView(textview);
        return this;
    }

    public android.app.lder setMessage(CharSequence charsequence)
    {
        TextView textview = getMessageTextView();
        textview.setText(charsequence);
        int i = getContext().getResources().getDimensionPixelSize(0x7f0b00ec);
        contentView.setPadding(i, i, i, i);
        contentView.addView(textview);
        return this;
    }

    public android.app.ChoiceClickListener setMultiChoiceItems(CharSequence acharsequence[], boolean aflag[], android.content.ceClickListener ceclicklistener)
    {
        acharsequence = new ArrayAdapter(getContext(), 0x7f0301e7, acharsequence);
        ListView listview = getDialogListView();
        contentView.addView(listview);
        listview.setAdapter(acharsequence);
        listview.setChoiceMode(2);
        for (int i = 0; i < aflag.length; i++)
        {
            listview.setItemChecked(i, aflag[i]);
        }

        alertParams.isMultiChoice = true;
        alertParams.listViewContent = listview;
        alertParams.multiChoiceItemsListener = ceclicklistener;
        return this;
    }

    public android.app.Listener setNegativeButton(int i, android.content.ener ener)
    {
        bottomContainer.setVisibility(0);
        negativeButton.setVisibility(0);
        alertParams.negativeButton = negativeButton;
        alertParams.negativeButtonText = getContext().getString(i);
        alertParams.negativeButtonListener = ener;
        return this;
    }

    public android.app.Listener setNegativeButton(CharSequence charsequence, android.content.ener ener)
    {
        bottomContainer.setVisibility(0);
        negativeButton.setVisibility(0);
        alertParams.negativeButton = negativeButton;
        alertParams.negativeButtonText = charsequence;
        alertParams.negativeButtonListener = ener;
        return this;
    }

    public android.app.Listener setPositiveButton(int i, android.content.ener ener)
    {
        bottomContainer.setVisibility(0);
        positiveButton.setVisibility(0);
        alertParams.positiveButton = positiveButton;
        alertParams.positiveButtonText = getContext().getString(i);
        alertParams.positiveButtonListener = ener;
        return this;
    }

    public android.app.Listener setPositiveButton(CharSequence charsequence, android.content.ener ener)
    {
        bottomContainer.setVisibility(0);
        positiveButton.setVisibility(0);
        alertParams.positiveButton = positiveButton;
        alertParams.positiveButtonText = charsequence;
        alertParams.positiveButtonListener = ener;
        return this;
    }

    public android.app.Listener setSingleChoiceItems(ListAdapter listadapter, int i, android.content.ener ener)
    {
        ListView listview = getDialogListView();
        contentView.addView(listview);
        listview.setAdapter(listadapter);
        listview.setChoiceMode(1);
        listview.setItemChecked(i, true);
        alertParams.isSingleChoice = true;
        alertParams.listViewContent = listview;
        alertParams.singleChoiceItemsListener = ener;
        return this;
    }

    public android.app.Listener setSingleChoiceItems(CharSequence acharsequence[], int i, android.content.ener ener)
    {
        acharsequence = new ArrayAdapter(getContext(), 0x7f0301e8, acharsequence);
        ListView listview = getDialogListView();
        contentView.addView(listview);
        listview.setAdapter(acharsequence);
        listview.setChoiceMode(1);
        listview.setItemChecked(i, true);
        alertParams.isSingleChoice = true;
        alertParams.listViewContent = listview;
        alertParams.singleChoiceItemsListener = ener;
        return this;
    }

    public android.app.lder setTitle(int i)
    {
        titleContainer.setVisibility(0);
        titleView.setText(i);
        return this;
    }

    public android.app.lder setTitle(CharSequence charsequence)
    {
        titleContainer.setVisibility(0);
        titleView.setText(charsequence);
        return this;
    }

    public android.app.lder setView(View view)
    {
        if (contentView != null)
        {
            int i = getContext().getResources().getDimensionPixelSize(0x7f0b00ec);
            contentView.setPadding(i, i, i, i);
            contentView.addView(view);
            return this;
        } else
        {
            return super.(view);
        }
    }

    public ner(Context context)
    {
        super(context);
        context = View.inflate(context, 0x7f030128, null);
        setView(context);
        titleContainer = context.findViewById(0x7f100364);
        titleView = (TextView)context.findViewById(0x7f10007a);
        contentView = (FrameLayout)context.findViewById(0x7f100132);
        bottomContainer = context.findViewById(0x7f100366);
        negativeButton = (Button)context.findViewById(0x7f100367);
        positiveButton = (Button)context.findViewById(0x7f100368);
    }
}
