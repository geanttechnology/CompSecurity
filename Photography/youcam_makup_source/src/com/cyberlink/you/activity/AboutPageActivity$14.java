// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import java.io.File;

// Referenced classes of package com.cyberlink.you.activity:
//            AboutPageActivity

class a
    implements android.view.geActivity._cls14
{

    final AboutPageActivity a;

    public void onClick(View view)
    {
        try
        {
            view = new Intent("android.intent.action.VIEW");
            File file = new File(AboutPageActivity.e(a));
            if (file.exists())
            {
                view.setDataAndType(Uri.fromFile(file), "text/plain");
                a.startActivity(view);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
        }
    }

    (AboutPageActivity aboutpageactivity)
    {
        a = aboutpageactivity;
        super();
    }
}
