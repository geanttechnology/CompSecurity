// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

// Referenced classes of package co.vine.android:
//            DebugHomeActivity

class val.debugInfo
    implements android.view.
{

    final DebugHomeActivity this$0;
    final StringBuilder val$debugInfo;

    public void onClick(View view)
    {
        view = new File(getExternalCacheDir(), "vine_log.txt");
        try
        {
            view = new OutputStreamWriter(new FileOutputStream(view));
            view.write(val$debugInfo.toString());
            view.flush();
            view.close();
            view = new Intent("co.vine.android.intent.action.SEND_LOGS");
            startActivity(view);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            Toast.makeText(DebugHomeActivity.this, "Failed to send log.", 0).show();
        }
    }

    ()
    {
        this$0 = final_debughomeactivity;
        val$debugInfo = StringBuilder.this;
        super();
    }
}
