// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import com.ebay.common.net.api.usage.Usage;

// Referenced classes of package com.ebay.mobile.activities:
//            PreferencesActivity

class register extends register
{

    final PreferencesActivity this$0;

    public void onCheckedChanged(final CompoundButton usage, boolean flag)
    {
        if (Usage.isEnabled())
        {
            usage = Usage.getInst();
            if (flag)
            {
                View view = LayoutInflater.from(PreferencesActivity.this).inflate(0x7f0301a6, null);
                final EditText input = (EditText)view.findViewById(0x7f1004e7);
                final EditText input2 = usage.getSessionName();
                if (input2 != null && input2.length() > 0)
                {
                    input.setText(input2.toCharArray(), 0, input2.length());
                }
                input2 = (EditText)view.findViewById(0x7f1004e9);
                String s = usage.getDeviceName();
                if (s != null && s.length() > 0)
                {
                    input2.setText(s.toCharArray(), 0, s.length());
                }
                (new android.app.itchController.this._cls0(PreferencesActivity.this))._mth0("Usage Profiling")._mth0("Enter session and device names.")._mth0(view)._mth0(0x104000a, new android.content.DialogInterface.OnClickListener() {

                    final PreferencesActivity.UsageLoggingSwitchController this$1;
                    final EditText val$input;
                    final EditText val$input2;
                    final Usage val$usage;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface = input.getText().toString();
                        String s1 = input2.getText().toString();
                        usageLoggingHeader.summary = dialoginterface;
                        PreferencesActivity.HeaderAdapter headeradapter = (PreferencesActivity.HeaderAdapter)getListAdapter();
                        if (headeradapter != null)
                        {
                            headeradapter.notifyDataSetChanged();
                        }
                        usage.setSessionName(dialoginterface);
                        usage.setDeviceName(s1);
                        usage.startSession();
                    }

            
            {
                this$1 = PreferencesActivity.UsageLoggingSwitchController.this;
                input = edittext;
                input2 = edittext1;
                usage = usage1;
                super();
            }
                }).itchController(0x1040000, new android.content.DialogInterface.OnClickListener() {

                    final PreferencesActivity.UsageLoggingSwitchController this$1;
                    final Usage val$usage;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        usage.startSession();
                    }

            
            {
                this$1 = PreferencesActivity.UsageLoggingSwitchController.this;
                usage = usage1;
                super();
            }
                }).itchController().show();
            } else
            {
                (new android.app.itchController(PreferencesActivity.this))._mth0("Usage Profiling")._mth0("Save usage data?")._mth0(0x104000a, new android.content.DialogInterface.OnClickListener() {

                    final PreferencesActivity.UsageLoggingSwitchController this$1;
                    final Usage val$usage;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        usage.endSession();
                        usage.setSessionName("");
                        usage.setDeviceName("");
                    }

            
            {
                this$1 = PreferencesActivity.UsageLoggingSwitchController.this;
                usage = usage1;
                super();
            }
                }).itchController("Email", new android.content.DialogInterface.OnClickListener() {

                    final PreferencesActivity.UsageLoggingSwitchController this$1;
                    final Usage val$usage;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        usage.sendUsageEmail(this$0);
                        usage.endSession();
                        usage.setSessionName("");
                        usage.setDeviceName("");
                    }

            
            {
                this$1 = PreferencesActivity.UsageLoggingSwitchController.this;
                usage = usage1;
                super();
            }
                }).itchController("Delete", new android.content.DialogInterface.OnClickListener() {

                    final PreferencesActivity.UsageLoggingSwitchController this$1;
                    final Usage val$usage;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        usage.markForDeleteSession();
                        usage.deleteFile();
                        usage.endSession();
                        usage.setSessionName("");
                        usage.setDeviceName("");
                    }

            
            {
                this$1 = PreferencesActivity.UsageLoggingSwitchController.this;
                usage = usage1;
                super();
            }
                }).itchController().show();
                usageLoggingHeader.troller = null;
                usage = (_cls3.val.usage)getListAdapter();
                if (usage != null)
                {
                    usage.anged();
                    return;
                }
            }
        }
    }

    public _cls5.val.usage(Switch switch1)
    {
        this$0 = PreferencesActivity.this;
        super(switch1);
        switch1.setChecked(Usage.getInst().isSessionActive());
        switch1.setEnabled(true);
        register();
    }
}
