// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mash.api;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.amazon.mobile.mash.util.Util;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.now.mash.api:
//            MASHHoudiniCorePlugin

class val.destructiveButtonTitle
    implements Runnable
{

    final MASHHoudiniCorePlugin this$0;
    final String val$buttonTitlesArray[];
    final CallbackContext val$callback;
    final String val$cancelButtonTitle;
    final String val$destructiveButtonTitle;
    final int val$lenOfButtonTitles;
    final String val$title;

    public void run()
    {
        android.app.ickListener icklistener = new android.app.t>(cordova.getActivity());
        if (Util.isDefined(val$title))
        {
            icklistener.itle(val$title);
        }
        icklistener.tems(val$buttonTitlesArray, new android.content.DialogInterface.OnClickListener() {

            final MASHHoudiniCorePlugin._cls1 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                callback.success(i);
            }

            
            {
                this$1 = MASHHoudiniCorePlugin._cls1.this;
                super();
            }
        });
        if (Util.isDefined(val$cancelButtonTitle))
        {
            icklistener.egativeButton(val$cancelButtonTitle, new android.content.DialogInterface.OnClickListener() {

                final MASHHoudiniCorePlugin._cls1 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    callback.success(lenOfButtonTitles);
                }

            
            {
                this$1 = MASHHoudiniCorePlugin._cls1.this;
                super();
            }
            });
        }
        if (Util.isDefined(val$destructiveButtonTitle))
        {
            icklistener.ositiveButton(val$destructiveButtonTitle, new android.content.DialogInterface.OnClickListener() {

                final MASHHoudiniCorePlugin._cls1 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    callback.success(lenOfButtonTitles + 1);
                }

            
            {
                this$1 = MASHHoudiniCorePlugin._cls1.this;
                super();
            }
            });
        }
        icklistener.con(0);
        icklistener.te().show();
    }

    _cls3.this._cls1()
    {
        this$0 = final_mashhoudinicoreplugin;
        val$title = s;
        val$buttonTitlesArray = as;
        val$callback = callbackcontext;
        val$cancelButtonTitle = s1;
        val$lenOfButtonTitles = i;
        val$destructiveButtonTitle = String.this;
        super();
    }
}
