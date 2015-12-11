// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;

// Referenced classes of package com.gotv.crackle:
//            DetailsActivityResolver, LoadingActivity

class val.Message
    implements Runnable
{

    final DetailsActivityResolver this$0;
    final String val$Message;

    public void run()
    {
        if (DetailsActivityResolver.access$500(DetailsActivityResolver.this) == tionType.NONE)
        {
            (new android.app.(DetailsActivityResolver.this)).n(0x1080027).sage(val$Message).ativeButton(getResources().getString(0x7f0b00a5), new android.content.DialogInterface.OnClickListener() {

                final DetailsActivityResolver._cls2 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                    DetailsActivityResolver.access$600(this$0);
                }

            
            {
                this$1 = DetailsActivityResolver._cls2.this;
                super();
            }
            }).itiveButton(getResources().getString(0x7f0b00b5), new android.content.DialogInterface.OnClickListener() {

                final DetailsActivityResolver._cls2 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                    finish();
                }

            
            {
                this$1 = DetailsActivityResolver._cls2.this;
                super();
            }
            }).().show();
            return;
        } else
        {
            (new android.app.(DetailsActivityResolver.this)).n(0x1080027).sage(getResources().getString(0x7f0b0114)).ativeButton(getResources().getString(0x7f0b0115), new android.content.DialogInterface.OnClickListener() {

                final DetailsActivityResolver._cls2 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                    finish();
                }

            
            {
                this$1 = DetailsActivityResolver._cls2.this;
                super();
            }
            }).itiveButton(getResources().getString(0x7f0b0116), new android.content.DialogInterface.OnClickListener() {

                final DetailsActivityResolver._cls2 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                    dialoginterface = new Intent(this$0, com/gotv/crackle/LoadingActivity);
                    dialoginterface.setFlags(0x10000000);
                    startActivity(dialoginterface);
                    finish();
                }

            
            {
                this$1 = DetailsActivityResolver._cls2.this;
                super();
            }
            }).().show();
            return;
        }
    }

    _cls4.this._cls1()
    {
        this$0 = final_detailsactivityresolver;
        val$Message = String.this;
        super();
    }
}
