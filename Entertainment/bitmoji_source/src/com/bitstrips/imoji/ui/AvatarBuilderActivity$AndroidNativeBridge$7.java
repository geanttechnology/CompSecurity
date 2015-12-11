// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.webkit.WebView;

// Referenced classes of package com.bitstrips.imoji.ui:
//            AvatarBuilderActivity

class val.negativeString
    implements Runnable
{

    final this._cls1 this$1;
    final Context val$context;
    final String val$message;
    final int val$negativeString;
    final int val$positiveString;
    final String val$title;

    public void run()
    {
        (new android.app.veBridge._cls7(val$context)).context(val$title).title(val$message).message(val$positiveString, new android.content.DialogInterface.OnClickListener() {

            final AvatarBuilderActivity.AndroidNativeBridge._cls7 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                AvatarBuilderActivity.AndroidNativeBridge.access$400(this$1).loadUrl("javascript:imoji_app.getValueCallback(true)");
            }

            
            {
                this$2 = AvatarBuilderActivity.AndroidNativeBridge._cls7.this;
                super();
            }
        })._mth7(val$negativeString, new android.content.DialogInterface.OnClickListener() {

            final AvatarBuilderActivity.AndroidNativeBridge._cls7 this$2;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                AvatarBuilderActivity.AndroidNativeBridge.access$400(this$1).loadUrl("javascript:imoji_app.getValueCallback(false)");
            }

            
            {
                this$2 = AvatarBuilderActivity.AndroidNativeBridge._cls7.this;
                super();
            }
        })._mth7();
    }

    _cls2.this._cls2()
    {
        this$1 = final__pcls2;
        val$context = context1;
        val$title = s;
        val$message = s1;
        val$positiveString = i;
        val$negativeString = I.this;
        super();
    }
}
