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

class this._cls1
    implements android.view.t._cls4._cls3
{

    final iss this$1;

    public void onClick(View view)
    {
        dismiss();
    }

    l.alert()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/now/net/ConnectionLostDialogFragment$4

/* anonymous class */
    class ConnectionLostDialogFragment._cls4
        implements android.content.DialogInterface.OnShowListener
    {

        final ConnectionLostDialogFragment this$0;
        final AlertDialog val$alert;

        public void onShow(DialogInterface dialoginterface)
        {
            alert.getButton(-1).setOnClickListener(new ConnectionLostDialogFragment._cls4._cls1());
            alert.getButton(-2).setOnClickListener(new ConnectionLostDialogFragment._cls4._cls2());
            if (AppUtils.isAppDebuggable(getActivity()))
            {
                alert.getButton(-3).setOnClickListener(new ConnectionLostDialogFragment._cls4._cls3());
            }
        }

            
            {
                this$0 = final_connectionlostdialogfragment;
                alert = AlertDialog.this;
                super();
            }

        // Unreferenced inner class com/amazon/now/net/ConnectionLostDialogFragment$4$1

/* anonymous class */
        class ConnectionLostDialogFragment._cls4._cls1
            implements android.view.View.OnClickListener
        {

            final ConnectionLostDialogFragment._cls4 this$1;

            public void onClick(View view)
            {
                startActivity(new Intent("android.settings.SETTINGS"));
            }

                    
                    {
                        this$1 = ConnectionLostDialogFragment._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/amazon/now/net/ConnectionLostDialogFragment$4$2

/* anonymous class */
        class ConnectionLostDialogFragment._cls4._cls2
            implements android.view.View.OnClickListener
        {

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
        }

    }

}
