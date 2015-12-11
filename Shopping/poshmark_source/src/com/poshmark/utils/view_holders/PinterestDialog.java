// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.view_holders;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.customviews.PMTextView;

public class PinterestDialog extends DialogFragment
    implements TraceFieldInterface
{
    public static final class PINTEREST_DIALOG_MODE extends Enum
    {

        private static final PINTEREST_DIALOG_MODE $VALUES[];
        public static final PINTEREST_DIALOG_MODE POST_CONN;
        public static final PINTEREST_DIALOG_MODE PRE_CONN;

        public static PINTEREST_DIALOG_MODE valueOf(String s)
        {
            return (PINTEREST_DIALOG_MODE)Enum.valueOf(com/poshmark/utils/view_holders/PinterestDialog$PINTEREST_DIALOG_MODE, s);
        }

        public static PINTEREST_DIALOG_MODE[] values()
        {
            return (PINTEREST_DIALOG_MODE[])$VALUES.clone();
        }

        static 
        {
            PRE_CONN = new PINTEREST_DIALOG_MODE("PRE_CONN", 0);
            POST_CONN = new PINTEREST_DIALOG_MODE("POST_CONN", 1);
            $VALUES = (new PINTEREST_DIALOG_MODE[] {
                PRE_CONN, POST_CONN
            });
        }

        private PINTEREST_DIALOG_MODE(String s, int i)
        {
            super(s, i);
        }
    }


    android.view.View.OnClickListener clickListener;
    PINTEREST_DIALOG_MODE current_mode;

    public PinterestDialog()
    {
        clickListener = new android.view.View.OnClickListener() {

            final PinterestDialog this$0;

            public void onClick(View view)
            {
                dismiss();
            }

            
            {
                this$0 = PinterestDialog.this;
                super();
            }
        };
    }

    private void setupView(View view)
    {
        static class _cls2
        {

            static final int $SwitchMap$com$poshmark$utils$view_holders$PinterestDialog$PINTEREST_DIALOG_MODE[];

            static 
            {
                $SwitchMap$com$poshmark$utils$view_holders$PinterestDialog$PINTEREST_DIALOG_MODE = new int[PINTEREST_DIALOG_MODE.values().length];
                try
                {
                    $SwitchMap$com$poshmark$utils$view_holders$PinterestDialog$PINTEREST_DIALOG_MODE[PINTEREST_DIALOG_MODE.PRE_CONN.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$utils$view_holders$PinterestDialog$PINTEREST_DIALOG_MODE[PINTEREST_DIALOG_MODE.POST_CONN.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2..SwitchMap.com.poshmark.utils.view_holders.PinterestDialog.PINTEREST_DIALOG_MODE[current_mode.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            Button button = (Button)view.findViewById(0x7f0c0262);
            view = (PMTextView)view.findViewById(0x7f0c0263);
            button.setOnClickListener(clickListener);
            view.setOnClickListener(clickListener);
            return;

        case 2: // '\002'
            ((Button)view.findViewById(0x7f0c0260)).setOnClickListener(clickListener);
            break;
        }
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        super.onCancel(dialoginterface);
        PMNotificationManager.fireNotification("com.poshmark.intents.PINTEREST_FIRST_TIME_DIALOG_BACK");
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        Object obj = new android.app.AlertDialog.Builder(getActivity());
        bundle = getActivity().getLayoutInflater();
        if (current_mode == PINTEREST_DIALOG_MODE.POST_CONN)
        {
            bundle = bundle.inflate(0x7f0300a0, null);
        } else
        {
            bundle = bundle.inflate(0x7f0300a1, null);
        }
        ((android.app.AlertDialog.Builder) (obj)).setView(bundle);
        obj = ((android.app.AlertDialog.Builder) (obj)).create();
        setupView(bundle);
        return ((Dialog) (obj));
    }

    protected void onStart()
    {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    protected void onStop()
    {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    public void setClickListener(android.view.View.OnClickListener onclicklistener)
    {
        clickListener = onclicklistener;
    }

    public void setCurrent_mode(PINTEREST_DIALOG_MODE pinterest_dialog_mode)
    {
        current_mode = pinterest_dialog_mode;
    }
}
