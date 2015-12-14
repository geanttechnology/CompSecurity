// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import com.cyberlink.you.utility.d;
import java.io.File;

// Referenced classes of package com.cyberlink.you.activity:
//            AboutPageActivity

class a
    implements android.view.geActivity._cls10
{

    final AboutPageActivity a;

    public void onClick(View view)
    {
        view = Toast.makeText(a.getBaseContext(), "Gathering data, please wait...", 1);
        view.show();
        d.d(a.getApplicationContext());
        view.cancel();
        view = new File(d.g());
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.SUBJECT", "U log data").putExtra("android.intent.extra.TEXT", "Collected U log data in a zip file.").setType("application/zip").putExtra("android.intent.extra.STREAM", Uri.fromFile(view));
        a.startActivityForResult(Intent.createChooser(intent, "Send Email"), 1);
    }

    (AboutPageActivity aboutpageactivity)
    {
        a = aboutpageactivity;
        super();
    }
}
