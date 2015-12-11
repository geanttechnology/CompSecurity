// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;

// Referenced classes of package com.gotv.crackle:
//            MainActivity

class this._cls1
    implements android.content.nClickListener
{

    final tActivity this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = getIntent();
        finish();
        startActivity(dialoginterface);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/gotv/crackle/MainActivity$6

/* anonymous class */
    class MainActivity._cls6
        implements Runnable
    {

        final MainActivity this$0;

        public void run()
        {
            try
            {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MainActivity.this);
                builder.setMessage(getResources().getString(0x7f0b0146));
                builder.setPositiveButton(getResources().getString(0x7f0b00e0), new MainActivity._cls6._cls1());
                builder.create().show();
                return;
            }
            catch (Exception exception)
            {
                return;
            }
        }

            
            {
                this$0 = MainActivity.this;
                super();
            }
    }

}
