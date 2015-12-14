// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.view.View;
import android.widget.Toast;
import com.cyberlink.you.d;
import com.cyberlink.you.g;
import java.io.File;
import org.apache.commons.io.FileUtils;

// Referenced classes of package com.cyberlink.you.activity:
//            AboutPageActivity

class a
    implements android.view.
{

    final AboutPageActivity a;

    public void onClick(View view)
    {
        view = (new StringBuilder()).append("//data//data//").append(g.l()).append("//shared_prefs//").toString();
        String s = com.cyberlink.you.utility.d.d(d.a);
        try
        {
            FileUtils.copyDirectoryToDirectory(new File(view), new File(s));
            Toast.makeText(a.getBaseContext(), (new StringBuilder()).append(view).append(" to ").append(s).toString(), 1).show();
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
