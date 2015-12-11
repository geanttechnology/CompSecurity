// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.net;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.amazon.now.util.AppUtils;

// Referenced classes of package com.amazon.now.net:
//            ConnectionLostDialogFragment

class val.alert
    implements android.content.._cls4
{

    final ConnectionLostDialogFragment this$0;
    final AlertDialog val$alert;

    public void onShow(DialogInterface dialoginterface)
    {
        val$alert.getButton(-1).setOnClickListener(new android.view.View.OnClickListener() {

            final ConnectionLostDialogFragment._cls4 this$1;

            public void onClick(View view)
            {
                startActivity(new Intent("android.settings.SETTINGS"));
            }

            
            {
                this$1 = ConnectionLostDialogFragment._cls4.this;
                super();
            }
        });
        val$alert.getButton(-2).setOnClickListener(new android.view.View.OnClickListener() {

            final ConnectionLostDialogFragment._cls4 this$1;

            public void onClick(View view)
            {
                dismiss();
                getActivity().recreate();
            }

            
            {
                this$1 = ConnectionLostDialogFragment._cls4.this;
                super();
            }
        });
        if (AppUtils.isAppDebuggable(getActivity()))
        {
            val$alert.getButton(-3).setOnClickListener(new android.view.View.OnClickListener() {

                final ConnectionLostDialogFragment._cls4 this$1;

                public void onClick(View view)
                {
                    dismiss();
                }

            
            {
                this$1 = ConnectionLostDialogFragment._cls4.this;
                super();
            }
            });
        }
    }

    _cls3.this._cls1()
    {
        this$0 = final_connectionlostdialogfragment;
        val$alert = AlertDialog.this;
        super();
    }
}
