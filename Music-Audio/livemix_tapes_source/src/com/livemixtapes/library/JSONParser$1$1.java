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
    implements android.content..OnClickListener
{

    final val.context this$1;
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
            val$context.startActivity(dialoginterface);
        }
        // Misplaced declaration of an exception variable
        catch (DialogInterface dialoginterface)
        {
            dialoginterface = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.livemixtapes"));
            val$context.startActivity(dialoginterface);
        }
        Process.killProcess(Process.myPid());
    }

    l.context()
    {
        this$1 = final_context1;
        val$context = Activity.this;
        super();
    }

    // Unreferenced inner class com/livemixtapes/library/JSONParser$1

/* anonymous class */
    class JSONParser._cls1
        implements Runnable
    {

        final JSONParser this$0;
        private final Activity val$context;

        public void run()
        {
            (new android.app.AlertDialog.Builder(context)).setTitle("App Disabled").setMessage("This BETA version of LiveMixtapes has been disabled!  Please update your app in the play store to continue to use this app.  You may need to uninstall the app first and then visit http://bit.ly/LMT-Android-BETA and install it again in order to get the latest version quickly.").setPositiveButton("OK", context. new JSONParser._cls1._cls1()).setIcon(0x1080027).show();
        }

            
            {
                this$0 = final_jsonparser;
                context = Activity.this;
                super();
            }
    }

}
