// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.net;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.amazon.now.util.AppUtils;

public class ConnectionLostDialogFragment extends DialogFragment
{

    public ConnectionLostDialogFragment()
    {
    }

    public static boolean isShowing(FragmentManager fragmentmanager)
    {
        return fragmentmanager.findFragmentByTag(com/amazon/now/net/ConnectionLostDialogFragment.getName()) != null;
    }

    public static void show(FragmentManager fragmentmanager)
    {
        fragmentmanager;
        JVM INSTR monitorenter ;
        if (!isShowing(fragmentmanager))
        {
            ConnectionLostDialogFragment connectionlostdialogfragment = new ConnectionLostDialogFragment();
            fragmentmanager.beginTransaction().add(connectionlostdialogfragment, com/amazon/now/net/ConnectionLostDialogFragment.getName()).commitAllowingStateLoss();
        }
        fragmentmanager;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        fragmentmanager;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        super.onCancel(dialoginterface);
        getActivity().finish();
    }

    public Dialog onCreateDialog(final Bundle alert)
    {
        alert = (new android.app.AlertDialog.Builder(getActivity())).create();
        setCancelable(false);
        alert.setTitle(getActivity().getString(0x7f070077));
        alert.setMessage(getActivity().getString(0x7f070074));
        alert.setButton(-2, getActivity().getString(0x7f070075), new android.content.DialogInterface.OnClickListener() {

            final ConnectionLostDialogFragment this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }

            
            {
                this$0 = ConnectionLostDialogFragment.this;
                super();
            }
        });
        alert.setButton(-1, getActivity().getString(0x7f070076), new android.content.DialogInterface.OnClickListener() {

            final ConnectionLostDialogFragment this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }

            
            {
                this$0 = ConnectionLostDialogFragment.this;
                super();
            }
        });
        if (AppUtils.isAppDebuggable(getActivity()))
        {
            alert.setButton(-3, "Ignore (Debug)", new android.content.DialogInterface.OnClickListener() {

                final ConnectionLostDialogFragment this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                }

            
            {
                this$0 = ConnectionLostDialogFragment.this;
                super();
            }
            });
        }
        alert.setOnShowListener(new android.content.DialogInterface.OnShowListener() {

            final ConnectionLostDialogFragment this$0;
            final AlertDialog val$alert;

            public void onShow(DialogInterface dialoginterface)
            {
                alert.getButton(-1).setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls4 this$1;

                    public void onClick(View view)
                    {
                        startActivity(new Intent("android.settings.SETTINGS"));
                    }

            
            {
                this$1 = _cls4.this;
                super();
            }
                });
                alert.getButton(-2).setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls4 this$1;

                    public void onClick(View view)
                    {
                        dismiss();
                        getActivity().recreate();
                    }

            
            {
                this$1 = _cls4.this;
                super();
            }
                });
                if (AppUtils.isAppDebuggable(getActivity()))
                {
                    alert.getButton(-3).setOnClickListener(new android.view.View.OnClickListener() {

                        final _cls4 this$1;

                        public void onClick(View view)
                        {
                            dismiss();
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    });
                }
            }

            
            {
                this$0 = ConnectionLostDialogFragment.this;
                alert = alertdialog;
                super();
            }
        });
        return alert;
    }
}
