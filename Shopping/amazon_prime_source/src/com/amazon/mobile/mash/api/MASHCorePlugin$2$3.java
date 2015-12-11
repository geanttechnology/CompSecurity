// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.api;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import com.amazon.mobile.mash.util.MASHDebug;
import com.amazon.mobile.mash.util.Util;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.mobile.mash.api:
//            MASHCorePlugin, MASHCordovaPlugin

class this._cls1
    implements android.content.lickListener
{

    final l.lenOfButtonTitles this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        callback.success(lenOfButtonTitles);
    }

    l.lenOfButtonTitles()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/mobile/mash/api/MASHCorePlugin$2

/* anonymous class */
    class MASHCorePlugin._cls2
        implements Runnable
    {

        final MASHCorePlugin this$0;
        final CallbackContext val$callback;
        final String val$cancelButtonTitle;
        final int val$lenOfButtonTitles;
        final String val$message;
        final String val$neutralButtonTitle;
        final String val$positiveButtonTitle;
        final String val$title;

        public void run()
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(cordova.getActivity());
            if (Util.isDefined(title))
            {
                builder.setTitle(title);
            }
            if (Util.isDefined(message))
            {
                builder.setMessage(message);
            }
            if (Util.isDefined(positiveButtonTitle))
            {
                builder.setPositiveButton(positiveButtonTitle, new MASHCorePlugin._cls2._cls1());
            }
            if (Util.isDefined(neutralButtonTitle))
            {
                builder.setNeutralButton(neutralButtonTitle, new MASHCorePlugin._cls2._cls2());
            }
            if (Util.isDefined(cancelButtonTitle))
            {
                builder.setNegativeButton(cancelButtonTitle, new MASHCorePlugin._cls2._cls3());
            }
            builder.setIcon(0);
            builder.create().show();
            if (MASHDebug.isEnabled())
            {
                Log.i(MASHCordovaPlugin.TAG, "ShowAlert is executed.");
            }
        }

            
            {
                this$0 = final_mashcoreplugin;
                title = s;
                message = s1;
                positiveButtonTitle = s2;
                callback = callbackcontext;
                neutralButtonTitle = s3;
                cancelButtonTitle = s4;
                lenOfButtonTitles = I.this;
                super();
            }

        // Unreferenced inner class com/amazon/mobile/mash/api/MASHCorePlugin$2$1

/* anonymous class */
        class MASHCorePlugin._cls2._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final MASHCorePlugin._cls2 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                callback.success(0);
            }

                    
                    {
                        this$1 = MASHCorePlugin._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/amazon/mobile/mash/api/MASHCorePlugin$2$2

/* anonymous class */
        class MASHCorePlugin._cls2._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final MASHCorePlugin._cls2 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                callback.success(1);
            }

                    
                    {
                        this$1 = MASHCorePlugin._cls2.this;
                        super();
                    }
        }

    }

}
