// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mash.api;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.amazon.now.util.AppUtils;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.amazon.now.mash.api:
//            MASHHoudiniPlugin

class mButtonIndex
    implements android.content.istener
{

    private int mButtonIndex;
    final mButtonIndex this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        this._cls1.this.mButtonIndex.success(mButtonIndex);
    }

    I(int j)
    {
        this$1 = this._cls1.this;
        super();
        mButtonIndex = j;
    }

    // Unreferenced inner class com/amazon/now/mash/api/MASHHoudiniPlugin$10

/* anonymous class */
    class MASHHoudiniPlugin._cls10
        implements Runnable
    {

        final MASHHoudiniPlugin this$0;
        final JSONObject val$args;
        final CallbackContext val$callbackContext;

        public void run()
        {
            Object obj = new android.app.AlertDialog.Builder(cordova.getActivity());
            Object obj1 = args.optString("title");
            if (AppUtils.isDefined(((String) (obj1))))
            {
                ((android.app.AlertDialog.Builder) (obj)).setTitle(((CharSequence) (obj1)));
            }
            obj1 = args.optString("message");
            if (AppUtils.isDefined(((String) (obj1))))
            {
                ((android.app.AlertDialog.Builder) (obj)).setMessage(((CharSequence) (obj1)));
            }
            int i = 0;
            obj1 = args.optJSONArray("buttonTitles");
            if (obj1 != null)
            {
                int j = ((JSONArray) (obj1)).length();
                i = j;
                if (j >= 1)
                {
                    String s = ((JSONArray) (obj1)).optString(0);
                    i = j;
                    if (AppUtils.isDefined(s))
                    {
                        ((android.app.AlertDialog.Builder) (obj)).setPositiveButton(s, new MASHHoudiniPlugin._cls10._cls1OnButtonClickListener(0));
                        i = j;
                        if (j >= 2)
                        {
                            obj1 = ((JSONArray) (obj1)).optString(1);
                            i = j;
                            if (AppUtils.isDefined(((String) (obj1))))
                            {
                                ((android.app.AlertDialog.Builder) (obj)).setNeutralButton(((CharSequence) (obj1)), new MASHHoudiniPlugin._cls10._cls1OnButtonClickListener(1));
                                i = j;
                            }
                        }
                    }
                }
            }
            obj1 = args.optString("cancelButtonTitle");
            if (AppUtils.isDefined(((String) (obj1))))
            {
                ((android.app.AlertDialog.Builder) (obj)).setNegativeButton(((CharSequence) (obj1)), new MASHHoudiniPlugin._cls10._cls1OnButtonClickListener(i));
            }
            ((android.app.AlertDialog.Builder) (obj)).setIcon(0);
            obj = ((android.app.AlertDialog.Builder) (obj)).create();
            if (!cordova.getActivity().isFinishing())
            {
                ((AlertDialog) (obj)).show();
            }
        }

            
            {
                this$0 = final_mashhoudiniplugin;
                args = jsonobject;
                callbackContext = CallbackContext.this;
                super();
            }
    }

}
