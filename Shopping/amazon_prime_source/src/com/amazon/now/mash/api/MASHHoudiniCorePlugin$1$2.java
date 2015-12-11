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

class this._cls1
    implements android.content.tener
{

    final l.lenOfButtonTitles this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        callback.success(lenOfButtonTitles);
    }

    l.destructiveButtonTitle()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/now/mash/api/MASHHoudiniCorePlugin$1

/* anonymous class */
    class MASHHoudiniCorePlugin._cls1
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
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(cordova.getActivity());
            if (Util.isDefined(title))
            {
                builder.setTitle(title);
            }
            builder.setItems(buttonTitlesArray, new MASHHoudiniCorePlugin._cls1._cls1());
            if (Util.isDefined(cancelButtonTitle))
            {
                builder.setNegativeButton(cancelButtonTitle, new MASHHoudiniCorePlugin._cls1._cls2());
            }
            if (Util.isDefined(destructiveButtonTitle))
            {
                builder.setPositiveButton(destructiveButtonTitle, new MASHHoudiniCorePlugin._cls1._cls3());
            }
            builder.setIcon(0);
            builder.create().show();
        }

            
            {
                this$0 = final_mashhoudinicoreplugin;
                title = s;
                buttonTitlesArray = as;
                callback = callbackcontext;
                cancelButtonTitle = s1;
                lenOfButtonTitles = i;
                destructiveButtonTitle = String.this;
                super();
            }

        // Unreferenced inner class com/amazon/now/mash/api/MASHHoudiniCorePlugin$1$1

/* anonymous class */
        class MASHHoudiniCorePlugin._cls1._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final MASHHoudiniCorePlugin._cls1 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                callback.success(i);
            }

                    
                    {
                        this$1 = MASHHoudiniCorePlugin._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/amazon/now/mash/api/MASHHoudiniCorePlugin$1$3

/* anonymous class */
        class MASHHoudiniCorePlugin._cls1._cls3
            implements android.content.DialogInterface.OnClickListener
        {

            final MASHHoudiniCorePlugin._cls1 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                callback.success(lenOfButtonTitles + 1);
            }

                    
                    {
                        this$1 = MASHHoudiniCorePlugin._cls1.this;
                        super();
                    }
        }

    }

}
