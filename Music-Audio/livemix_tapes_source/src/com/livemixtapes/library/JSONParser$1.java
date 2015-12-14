// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.library;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Process;

// Referenced classes of package com.livemixtapes.library:
//            JSONParser

class val.context
    implements Runnable
{

    final JSONParser this$0;
    private final Activity val$context;

    public void run()
    {
        (new android.app.uilder(val$context)).setTitle("App Disabled").setMessage("This BETA version of LiveMixtapes has been disabled!  Please update your app in the play store to continue to use this app.  You may need to uninstall the app first and then visit http://bit.ly/LMT-Android-BETA and install it again in order to get the latest version quickly.").setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {

            final JSONParser._cls1 this$1;
            private final Activity val$context;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                try
                {
                    dialoginterface = new Intent("android.intent.action.MAIN");
                    dialoginterface.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
                    dialoginterface.addCategory("android.intent.category.LAUNCHER");
                    dialoginterface.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.livemixtapes"));
                    context.startActivity(dialoginterface);
                }
                // Misplaced declaration of an exception variable
                catch (DialogInterface dialoginterface)
                {
                    dialoginterface = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.livemixtapes"));
                    context.startActivity(dialoginterface);
                }
                Process.killProcess(Process.myPid());
            }

            
            {
                this$1 = JSONParser._cls1.this;
                context = activity;
                super();
            }
        }).setIcon(0x1080027).show();
    }

    _cls1.val.context()
    {
        this$0 = final_jsonparser;
        val$context = Activity.this;
        super();
    }
}
