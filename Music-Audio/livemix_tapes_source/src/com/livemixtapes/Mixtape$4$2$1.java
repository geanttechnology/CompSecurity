// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import com.livemixtapes.ui.BaseActivity;
import java.util.Map;

// Referenced classes of package com.livemixtapes:
//            Mixtape, App, User

class this._cls2
    implements android.content.e.OnClickListener
{

    final .dismiss this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    ._cls0()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/livemixtapes/Mixtape$4

/* anonymous class */
    class Mixtape._cls4
        implements android.view.View.OnClickListener
    {

        final Mixtape this$0;

        public void onClick(View view)
        {
            if (App.isUnzipping)
            {
                ((BaseActivity)mContext).runOnUiThread(new Mixtape._cls4._cls1());
                return;
            }
            if (User.isGuest().booleanValue())
            {
                Mixtape.access$0(Mixtape.this);
                return;
            } else
            {
                App.isUnzipping = true;
                view = ((LayoutInflater)App.context.getSystemService("layout_inflater")).inflate(0x7f03001f, null, false);
                Object obj = new android.app.AlertDialog.Builder(mContext);
                ((android.app.AlertDialog.Builder) (obj)).setMessage("").setCancelable(false).setView(view);
                obj = ((android.app.AlertDialog.Builder) (obj)).create();
                Mixtape.access$1(Mixtape.this, mixtape.get("id").toString(), view, ((android.app.AlertDialog) (obj)));
                ((BaseActivity)mContext).runOnUiThread(new Mixtape._cls4._cls2());
                return;
            }
        }


            
            {
                this$0 = Mixtape.this;
                super();
            }

        // Unreferenced inner class com/livemixtapes/Mixtape$4$1

/* anonymous class */
        class Mixtape._cls4._cls1
            implements Runnable
        {

            final Mixtape._cls4 this$1;

            public void run()
            {
                (new android.app.AlertDialog.Builder(mContext)).setTitle("Mixtape Downloading").setMessage("You already have a mixtape zip downloading...please wait for it to finish.").setPositiveButton("OK", new Mixtape._cls4._cls1._cls1()).setIcon(0x1080027).show();
            }

                    
                    {
                        this$1 = Mixtape._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/livemixtapes/Mixtape$4$1$1

/* anonymous class */
        class Mixtape._cls4._cls1._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final Mixtape._cls4._cls1 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$2 = Mixtape._cls4._cls1.this;
                        super();
                    }
        }

    }


    // Unreferenced inner class com/livemixtapes/Mixtape$4$2

/* anonymous class */
    class Mixtape._cls4._cls2
        implements Runnable
    {

        final Mixtape._cls4 this$1;

        public void run()
        {
            (new android.app.AlertDialog.Builder(mContext)).setTitle("Mixtape Downloading").setMessage("The mixtape zip has started downloading in the background.  Please wait.").setPositiveButton("OK", new Mixtape._cls4._cls2._cls1()).setIcon(0x1080027).show();
        }

            
            {
                this$1 = Mixtape._cls4.this;
                super();
            }
    }

}
