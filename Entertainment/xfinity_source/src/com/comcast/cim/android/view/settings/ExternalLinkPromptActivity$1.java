// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.settings;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

// Referenced classes of package com.comcast.cim.android.view.settings:
//            ExternalLinkPromptActivity

class val.url
    implements android.content.er
{

    final ExternalLinkPromptActivity this$0;
    final String val$url;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        dialoginterface = new Intent("android.intent.action.VIEW", Uri.parse(val$url));
        startActivity(dialoginterface);
        finish();
    }

    ()
    {
        this$0 = final_externallinkpromptactivity;
        val$url = String.this;
        super();
    }
}
