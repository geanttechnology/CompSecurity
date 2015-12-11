// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.webkit.WebView;

// Referenced classes of package com.bitstrips.imoji.ui:
//            AvatarBuilderActivity

class this._cls2
    implements android.content.ge._cls7._cls2
{

    final is._cls1 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        ss._mth400(_fld1).loadUrl("javascript:imoji_app.getValueCallback(true)");
    }

    l.negativeString()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/bitstrips/imoji/ui/AvatarBuilderActivity$AndroidNativeBridge$7

/* anonymous class */
    class AvatarBuilderActivity.AndroidNativeBridge._cls7
        implements Runnable
    {

        final AvatarBuilderActivity.AndroidNativeBridge this$1;
        final Context val$context;
        final String val$message;
        final int val$negativeString;
        final int val$positiveString;
        final String val$title;

        public void run()
        {
            (new android.app.AlertDialog.Builder(context)).setTitle(title).setMessage(message).setPositiveButton(positiveString, new AvatarBuilderActivity.AndroidNativeBridge._cls7._cls2()).setNegativeButton(negativeString, new AvatarBuilderActivity.AndroidNativeBridge._cls7._cls1()).show();
        }

            
            {
                this$1 = final_androidnativebridge;
                context = context1;
                title = s;
                message = s1;
                positiveString = i;
                negativeString = I.this;
                super();
            }

        // Unreferenced inner class com/bitstrips/imoji/ui/AvatarBuilderActivity$AndroidNativeBridge$7$1

/* anonymous class */
        class AvatarBuilderActivity.AndroidNativeBridge._cls7._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final AvatarBuilderActivity.AndroidNativeBridge._cls7 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                AvatarBuilderActivity.AndroidNativeBridge.access$400(this$1).loadUrl("javascript:imoji_app.getValueCallback(false)");
            }

                    
                    {
                        this$2 = AvatarBuilderActivity.AndroidNativeBridge._cls7.this;
                        super();
                    }
        }

    }

}
