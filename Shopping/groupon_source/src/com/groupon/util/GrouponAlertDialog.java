// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.lang.ref.WeakReference;

public class GrouponAlertDialog extends AlertDialog
{
    public static class AlertController
    {

        private AlertParams alertParams;
        android.view.View.OnClickListener buttonHandler;
        private Message buttonNegativeMessage;
        private Message buttonPositiveMessage;
        private final DialogInterface dialogInterface;
        private Handler handler;

        protected void setButton(int i, android.content.DialogInterface.OnClickListener onclicklistener, Message message)
        {
            Message message1 = message;
            if (message == null)
            {
                message1 = message;
                if (onclicklistener != null)
                {
                    message1 = handler.obtainMessage(i, onclicklistener);
                }
            }
            switch (i)
            {
            default:
                throw new IllegalArgumentException("Button does not exist");

            case -1: 
                buttonPositiveMessage = message1;
                return;

            case -2: 
                buttonNegativeMessage = message1;
                return;
            }
        }

        public void setupViews(AlertParams alertparams)
        {
            alertParams = alertparams;
            if (alertParams.listViewContent != null)
            {
                alertParams.listViewContent.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                    final AlertController this$0;

                    public void onItemClick(AdapterView adapterview, View view, int i, long l)
                    {
                        if (alertParams.isMultiChoice)
                        {
                            alertParams.multiChoiceItemsListener.onClick(dialogInterface, i, alertParams.listViewContent.isItemChecked(i));
                            return;
                        }
                        if (alertParams.isSingleChoice)
                        {
                            alertParams.singleChoiceItemsListener.onClick(dialogInterface, i);
                            return;
                        } else
                        {
                            alertParams.singleChoiceItemsListener.onClick(dialogInterface, i);
                            dialogInterface.dismiss();
                            return;
                        }
                    }

            
            {
                this$0 = AlertController.this;
                super();
            }
                });
            }
            if (alertParams.positiveButton != null)
            {
                setButton(-1, alertParams.positiveButtonListener, null);
                alertParams.positiveButton.setText(alertParams.positiveButtonText);
                alertParams.positiveButton.setOnClickListener(buttonHandler);
            }
            if (alertParams.negativeButton != null)
            {
                setButton(-2, alertParams.negativeButtonListener, null);
                alertParams.negativeButton.setText(alertParams.negativeButtonText);
                alertParams.negativeButton.setOnClickListener(buttonHandler);
            }
        }






        public AlertController(DialogInterface dialoginterface)
        {
            buttonHandler = new _cls1();
            dialogInterface = dialoginterface;
            handler = new ButtonHandler(dialoginterface);
        }
    }

    public static class AlertController.AlertParams
    {

        private boolean autoDismissOnPositiveClick;
        public boolean isMultiChoice;
        public boolean isSingleChoice;
        public ListView listViewContent;
        public android.content.DialogInterface.OnMultiChoiceClickListener multiChoiceItemsListener;
        public Button negativeButton;
        public android.content.DialogInterface.OnClickListener negativeButtonListener;
        public CharSequence negativeButtonText;
        public Button positiveButton;
        public android.content.DialogInterface.OnClickListener positiveButtonListener;
        public CharSequence positiveButtonText;
        public android.content.DialogInterface.OnClickListener singleChoiceItemsListener;



/*
        static boolean access$002(AlertController.AlertParams alertparams, boolean flag)
        {
            alertparams.autoDismissOnPositiveClick = flag;
            return flag;
        }

*/

        public AlertController.AlertParams()
        {
            autoDismissOnPositiveClick = true;
        }
    }

    private static final class AlertController.ButtonHandler extends Handler
    {

        private static final int MSG_DISMISS_DIALOG = 1;
        private WeakReference mDialog;

        public void handleMessage(Message message)
        {
            message.what;
            JVM INSTR tableswitch -3 1: default 40
        //                       -3 41
        //                       -2 41
        //                       -1 41
        //                       0 40
        //                       1 74;
               goto _L1 _L2 _L2 _L2 _L1 _L3
_L1:
            DialogInterface dialoginterface;
            return;
_L2:
            if ((dialoginterface = (DialogInterface)mDialog.get()) != null)
            {
                ((android.content.DialogInterface.OnClickListener)message.obj).onClick(dialoginterface, message.what);
                return;
            }
              goto _L1
_L3:
            ((DialogInterface)message.obj).dismiss();
            return;
        }

        public AlertController.ButtonHandler(DialogInterface dialoginterface)
        {
            mDialog = new WeakReference(dialoginterface);
        }
    }

    public static class Builder extends android.app.AlertDialog.Builder
    {

        private AlertController alertController;
        private final AlertController.AlertParams alertParams = new AlertController.AlertParams();
        private View bottomContainer;
        private FrameLayout contentView;
        private Button negativeButton;
        private Button positiveButton;
        private View titleContainer;
        private TextView titleView;

        public AlertDialog create()
        {
            AlertDialog alertdialog = super.create();
            alertController = new AlertController(alertdialog);
            alertController.setupViews(alertParams);
            return alertdialog;
        }

        protected ListView getDialogListView()
        {
            ListView listview = new ListView(getContext());
            listview.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
            listview.setCacheColorHint(0);
            listview.setVerticalScrollBarEnabled(true);
            listview.setHorizontalScrollBarEnabled(false);
            listview.setOverScrollMode(1);
            return listview;
        }

        protected TextView getMessageTextView()
        {
            TextView textview = new TextView(getContext());
            textview.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -2));
            textview.setGravity(1);
            textview.setTextColor(getContext().getResources().getColor(0x7f0e00f4));
            textview.setTextSize(1, 18F);
            textview.setMovementMethod(LinkMovementMethod.getInstance());
            return textview;
        }

        public void setAutoDismissOnPositiveButtonClick(boolean flag)
        {
            alertParams.autoDismissOnPositiveClick = flag;
        }

        public android.app.AlertDialog.Builder setItems(CharSequence acharsequence[], android.content.DialogInterface.OnClickListener onclicklistener)
        {
            acharsequence = new ArrayAdapter(getContext(), 0x7f0301e6, acharsequence);
            ListView listview = getDialogListView();
            contentView.addView(listview);
            listview.setAdapter(acharsequence);
            alertParams.listViewContent = listview;
            alertParams.singleChoiceItemsListener = onclicklistener;
            return this;
        }

        public android.app.AlertDialog.Builder setMessage(int i)
        {
            TextView textview = getMessageTextView();
            textview.setText(i);
            i = getContext().getResources().getDimensionPixelSize(0x7f0b00ec);
            contentView.setPadding(i, i, i, i);
            contentView.addView(textview);
            return this;
        }

        public android.app.AlertDialog.Builder setMessage(CharSequence charsequence)
        {
            TextView textview = getMessageTextView();
            textview.setText(charsequence);
            int i = getContext().getResources().getDimensionPixelSize(0x7f0b00ec);
            contentView.setPadding(i, i, i, i);
            contentView.addView(textview);
            return this;
        }

        public android.app.AlertDialog.Builder setMultiChoiceItems(CharSequence acharsequence[], boolean aflag[], android.content.DialogInterface.OnMultiChoiceClickListener onmultichoiceclicklistener)
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
            alertParams.multiChoiceItemsListener = onmultichoiceclicklistener;
            return this;
        }

        public android.app.AlertDialog.Builder setNegativeButton(int i, android.content.DialogInterface.OnClickListener onclicklistener)
        {
            bottomContainer.setVisibility(0);
            negativeButton.setVisibility(0);
            alertParams.negativeButton = negativeButton;
            alertParams.negativeButtonText = getContext().getString(i);
            alertParams.negativeButtonListener = onclicklistener;
            return this;
        }

        public android.app.AlertDialog.Builder setNegativeButton(CharSequence charsequence, android.content.DialogInterface.OnClickListener onclicklistener)
        {
            bottomContainer.setVisibility(0);
            negativeButton.setVisibility(0);
            alertParams.negativeButton = negativeButton;
            alertParams.negativeButtonText = charsequence;
            alertParams.negativeButtonListener = onclicklistener;
            return this;
        }

        public android.app.AlertDialog.Builder setPositiveButton(int i, android.content.DialogInterface.OnClickListener onclicklistener)
        {
            bottomContainer.setVisibility(0);
            positiveButton.setVisibility(0);
            alertParams.positiveButton = positiveButton;
            alertParams.positiveButtonText = getContext().getString(i);
            alertParams.positiveButtonListener = onclicklistener;
            return this;
        }

        public android.app.AlertDialog.Builder setPositiveButton(CharSequence charsequence, android.content.DialogInterface.OnClickListener onclicklistener)
        {
            bottomContainer.setVisibility(0);
            positiveButton.setVisibility(0);
            alertParams.positiveButton = positiveButton;
            alertParams.positiveButtonText = charsequence;
            alertParams.positiveButtonListener = onclicklistener;
            return this;
        }

        public android.app.AlertDialog.Builder setSingleChoiceItems(ListAdapter listadapter, int i, android.content.DialogInterface.OnClickListener onclicklistener)
        {
            ListView listview = getDialogListView();
            contentView.addView(listview);
            listview.setAdapter(listadapter);
            listview.setChoiceMode(1);
            listview.setItemChecked(i, true);
            alertParams.isSingleChoice = true;
            alertParams.listViewContent = listview;
            alertParams.singleChoiceItemsListener = onclicklistener;
            return this;
        }

        public android.app.AlertDialog.Builder setSingleChoiceItems(CharSequence acharsequence[], int i, android.content.DialogInterface.OnClickListener onclicklistener)
        {
            acharsequence = new ArrayAdapter(getContext(), 0x7f0301e8, acharsequence);
            ListView listview = getDialogListView();
            contentView.addView(listview);
            listview.setAdapter(acharsequence);
            listview.setChoiceMode(1);
            listview.setItemChecked(i, true);
            alertParams.isSingleChoice = true;
            alertParams.listViewContent = listview;
            alertParams.singleChoiceItemsListener = onclicklistener;
            return this;
        }

        public android.app.AlertDialog.Builder setTitle(int i)
        {
            titleContainer.setVisibility(0);
            titleView.setText(i);
            return this;
        }

        public android.app.AlertDialog.Builder setTitle(CharSequence charsequence)
        {
            titleContainer.setVisibility(0);
            titleView.setText(charsequence);
            return this;
        }

        public android.app.AlertDialog.Builder setView(View view)
        {
            if (contentView != null)
            {
                int i = getContext().getResources().getDimensionPixelSize(0x7f0b00ec);
                contentView.setPadding(i, i, i, i);
                contentView.addView(view);
                return this;
            } else
            {
                return super.setView(view);
            }
        }

        public Builder(Context context)
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


    protected GrouponAlertDialog(Context context)
    {
        super(context);
    }

    protected GrouponAlertDialog(Context context, int i)
    {
        super(context, i);
    }

    protected GrouponAlertDialog(Context context, boolean flag, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        super(context, flag, oncancellistener);
    }

    // Unreferenced inner class com/groupon/util/GrouponAlertDialog$AlertController$1

/* anonymous class */
    class AlertController._cls1
        implements android.view.View.OnClickListener
    {

        final AlertController this$0;

        public void onClick(View view)
        {
            Object obj = null;
            Message message;
            if (view == alertParams.positiveButton && buttonPositiveMessage != null)
            {
                message = Message.obtain(buttonPositiveMessage);
            } else
            {
                message = obj;
                if (view == alertParams.negativeButton)
                {
                    message = obj;
                    if (buttonNegativeMessage != null)
                    {
                        message = Message.obtain(buttonNegativeMessage);
                    }
                }
            }
            if (message != null)
            {
                message.sendToTarget();
            }
            if (view == alertParams.positiveButton && !alertParams.autoDismissOnPositiveClick)
            {
                return;
            } else
            {
                handler.obtainMessage(1, dialogInterface).sendToTarget();
                return;
            }
        }

            
            {
                this$0 = AlertController.this;
                super();
            }
    }

}
