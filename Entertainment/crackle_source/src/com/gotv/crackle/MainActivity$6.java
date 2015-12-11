// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;

// Referenced classes of package com.gotv.crackle:
//            MainActivity

class this._cls0
    implements Runnable
{

    final MainActivity this$0;

    public void run()
    {
        try
        {
            android.app.lder lder = new android.app.lder(MainActivity.this);
            lder.setMessage(getResources().getString(0x7f0b0146));
            lder.setPositiveButton(getResources().getString(0x7f0b00e0), new android.content.DialogInterface.OnClickListener() {

                final MainActivity._cls6 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface = getIntent();
                    finish();
                    startActivity(dialoginterface);
                }

            
            {
                this$1 = MainActivity._cls6.this;
                super();
            }
            });
            lder.create().show();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    _cls1.this._cls1()
    {
        this$0 = MainActivity.this;
        super();
    }
}
