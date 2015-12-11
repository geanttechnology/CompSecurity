// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.ebay.common.EbayTimer;
import java.util.Calendar;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseDialogFragment

public class UndoMessagesActionToastDialog extends BaseDialogFragment
    implements android.view.View.OnClickListener, com.ebay.common.EbayTimer.OnTimerEvent
{
    public static interface OnUndoMessagesActionDialogListener
    {

        public abstract void onUndoMessagesActionExpired(UndoMessagesActionToastDialog undomessagesactiontoastdialog, Bundle bundle);

        public abstract void onUndoMessagesActionSelected(UndoMessagesActionToastDialog undomessagesactiontoastdialog, Bundle bundle);
    }


    private static final int LONG_DELAY = 3500;
    private static final String PARAM_TEXT = "param_text";
    private EbayTimer timer;
    private boolean timerFired;

    public UndoMessagesActionToastDialog()
    {
        timerFired = false;
    }

    public static UndoMessagesActionToastDialog createInstance(Fragment fragment, String s, Bundle bundle)
    {
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        bundle.putString("param_text", s);
        s = new UndoMessagesActionToastDialog();
        s.setArguments(bundle);
        s.setTargetFragment(fragment, 0);
        return s;
    }

    public static UndoMessagesActionToastDialog createInstance(String s, Bundle bundle)
    {
        return createInstance(null, s, bundle);
    }

    private void expire()
    {
        if (timer != null)
        {
            timer.stop();
            timer = null;
            dismissAllowingStateLoss();
            OnUndoMessagesActionDialogListener onundomessagesactiondialoglistener = getTarget();
            if (onundomessagesactiondialoglistener != null)
            {
                onundomessagesactiondialoglistener.onUndoMessagesActionExpired(this, getCallerContext());
            }
        }
    }

    private OnUndoMessagesActionDialogListener getTarget()
    {
        if (getTargetFragment() instanceof OnUndoMessagesActionDialogListener)
        {
            return (OnUndoMessagesActionDialogListener)getTargetFragment();
        } else
        {
            return (OnUndoMessagesActionDialogListener)getActivity();
        }
    }

    private void logTimestamp(String s)
    {
        Calendar calendar = Calendar.getInstance();
        Log.d("Messages.Undo", (new StringBuilder()).append(s).append(" ").append(calendar.get(13)).append(".").append(calendar.get(14)).toString());
    }

    public void OnTimer()
    {
        if (!timerFired)
        {
            timerFired = true;
            return;
        } else
        {
            expire();
            return;
        }
    }

    public Bundle getCallerContext()
    {
        return getArguments();
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        expire();
        super.onCancel(dialoginterface);
    }

    public void onClick(View view)
    {
        timer.stop();
        timer = null;
        dismiss();
        view = getTarget();
        if (view != null)
        {
            view.onUndoMessagesActionSelected(this, getCallerContext());
        }
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        Object obj = getArguments().getString("param_text");
        Activity activity = getActivity();
        bundle = activity.getLayoutInflater().inflate(0x7f030276, null);
        ((TextView)bundle.findViewById(0x7f10083a)).setText(((CharSequence) (obj)));
        bundle.findViewById(0x7f10083b).setOnClickListener(this);
        obj = new com.ebay.common.view.util.DialogManager.AlertDialogBuilder(activity);
        ((com.ebay.common.view.util.DialogManager.AlertDialogBuilder) (obj)).setView(bundle);
        bundle = ((com.ebay.common.view.util.DialogManager.AlertDialogBuilder) (obj)).create();
        obj = bundle.getWindow();
        ((Window) (obj)).clearFlags(2);
        ((Window) (obj)).getAttributes().gravity = 81;
        return bundle;
    }

    public void onPause()
    {
        if (timer != null)
        {
            timer.stop();
        }
        timerFired = false;
        timer = null;
        dismiss();
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        if (timer == null)
        {
            timer = new EbayTimer(3500L);
            timer.setOnTimerEvent(this);
        }
        timer.start();
    }
}
