// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.gotv.crackle.util.Log;

// Referenced classes of package com.gotv.crackle:
//            LoadingActivity, Application

class this._cls0
    implements android.content.ClickListener
{

    final LoadingActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        try
        {
            finish();
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(Application.getInstance().getPackageName()).toString())));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (DialogInterface dialoginterface)
        {
            Log.e(TAG, dialoginterface.getMessage());
        }
        dialoginterface = new Intent("android.intent.action.MAIN");
        dialoginterface.addCategory("android.intent.category.HOME");
        startActivity(dialoginterface);
    }

    lickListener()
    {
        this$0 = LoadingActivity.this;
        super();
    }
}
