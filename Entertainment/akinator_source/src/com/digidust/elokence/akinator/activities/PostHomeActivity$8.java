// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            PostHomeActivity

class this._cls0
    implements android.content.lickListener
{

    final PostHomeActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        disableAdOneTime();
        dialoginterface.dismiss();
        BackgroundSoundsBinder.sharedInstance().playBip();
        dialoginterface = new Intent("android.intent.action.VIEW");
        dialoginterface.setData(Uri.parse("market://details?id=com.digidust.elokence.akinator.freemium"));
        startActivity(dialoginterface);
    }

    ndsBinder()
    {
        this$0 = PostHomeActivity.this;
        super();
    }
}
