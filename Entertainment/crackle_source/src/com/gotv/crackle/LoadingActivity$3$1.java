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

class this._cls1
    implements android.content.ickListener
{

    final tActivity this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        finish();
        dialoginterface = new Intent("android.intent.action.MAIN");
        dialoginterface.addCategory("android.intent.category.HOME");
        dialoginterface.setFlags(0x10000000);
        startActivity(dialoginterface);
    }

    l.Message()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/gotv/crackle/LoadingActivity$3

/* anonymous class */
    class LoadingActivity._cls3
        implements Runnable
    {

        final LoadingActivity this$0;
        final String val$Message;
        final String val$tag;

        public void run()
        {
            if (tag.compareTo("GetAllowedLocations") == 0 || tag.compareTo("GetLocation") == 0)
            {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(LoadingActivity.this);
                builder.setMessage(getResources().getString(0x7f0b00b4));
                builder.setPositiveButton(getResources().getString(0x7f0b00b5), new LoadingActivity._cls3._cls1());
                builder.create().show();
                return;
            } else
            {
                mNetworkDialog.setMessage(Message);
                mNetworkDialog.show();
                return;
            }
        }

            
            {
                this$0 = final_loadingactivity;
                tag = s;
                Message = String.this;
                super();
            }
    }

}
