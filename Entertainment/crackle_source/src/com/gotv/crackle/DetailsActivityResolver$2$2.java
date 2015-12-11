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

class this._cls1
    implements android.content.ner
{

    final is._cls0 this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        DetailsActivityResolver.access$600(_fld0);
    }

    l.Message()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/gotv/crackle/DetailsActivityResolver$2

/* anonymous class */
    class DetailsActivityResolver._cls2
        implements Runnable
    {

        final DetailsActivityResolver this$0;
        final String val$Message;

        public void run()
        {
            if (DetailsActivityResolver.access$500(DetailsActivityResolver.this) == DetailsActivityResolver.ActionType.NONE)
            {
                (new android.app.AlertDialog.Builder(DetailsActivityResolver.this)).setIcon(0x1080027).setMessage(Message).setNegativeButton(getResources().getString(0x7f0b00a5), new DetailsActivityResolver._cls2._cls2()).setPositiveButton(getResources().getString(0x7f0b00b5), new DetailsActivityResolver._cls2._cls1()).create().show();
                return;
            } else
            {
                (new android.app.AlertDialog.Builder(DetailsActivityResolver.this)).setIcon(0x1080027).setMessage(getResources().getString(0x7f0b0114)).setNegativeButton(getResources().getString(0x7f0b0115), new DetailsActivityResolver._cls2._cls4()).setPositiveButton(getResources().getString(0x7f0b0116), new DetailsActivityResolver._cls2._cls3()).create().show();
                return;
            }
        }

            
            {
                this$0 = final_detailsactivityresolver;
                Message = String.this;
                super();
            }

        // Unreferenced inner class com/gotv/crackle/DetailsActivityResolver$2$1

/* anonymous class */
        class DetailsActivityResolver._cls2._cls1
            implements android.content.DialogInterface.OnClickListener
        {

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
        }


        // Unreferenced inner class com/gotv/crackle/DetailsActivityResolver$2$3

/* anonymous class */
        class DetailsActivityResolver._cls2._cls3
            implements android.content.DialogInterface.OnClickListener
        {

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
        }


        // Unreferenced inner class com/gotv/crackle/DetailsActivityResolver$2$4

/* anonymous class */
        class DetailsActivityResolver._cls2._cls4
            implements android.content.DialogInterface.OnClickListener
        {

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
        }

    }

}
