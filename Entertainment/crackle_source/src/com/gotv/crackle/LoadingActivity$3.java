// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;

// Referenced classes of package com.gotv.crackle:
//            LoadingActivity

class val.Message
    implements Runnable
{

    final LoadingActivity this$0;
    final String val$Message;
    final String val$tag;

    public void run()
    {
        if (val$tag.compareTo("GetAllowedLocations") == 0 || val$tag.compareTo("GetLocation") == 0)
        {
            android.app.r r = new android.app.r(LoadingActivity.this);
            r.setMessage(getResources().getString(0x7f0b00b4));
            r.setPositiveButton(getResources().getString(0x7f0b00b5), new android.content.DialogInterface.OnClickListener() {

                final LoadingActivity._cls3 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    finish();
                    dialoginterface = new Intent("android.intent.action.MAIN");
                    dialoginterface.addCategory("android.intent.category.HOME");
                    dialoginterface.setFlags(0x10000000);
                    startActivity(dialoginterface);
                }

            
            {
                this$1 = LoadingActivity._cls3.this;
                super();
            }
            });
            r.create().show();
            return;
        } else
        {
            mNetworkDialog.setMessage(val$Message);
            mNetworkDialog.show();
            return;
        }
    }

    _cls1.this._cls1()
    {
        this$0 = final_loadingactivity;
        val$tag = s;
        val$Message = String.this;
        super();
    }
}
