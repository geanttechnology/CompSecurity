// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.view.View;
import com.cyberlink.you.d;
import com.cyberlink.you.g;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.cyberlink.you.activity:
//            AboutPageActivity

class a
    implements android.view.ner
{

    final AboutPageActivity a;

    public boolean onLongClick(View view)
    {
        view = new File((new StringBuilder()).append(com.cyberlink.you.utility.d.d(d.a)).append("debug").toString());
        if (view.exists())
        {
            view.delete();
            com.cyberlink.you.utility.d.a(AboutPageActivity.c(a), "Disable Advance Debug Mode");
        } else
        {
            try
            {
                view.createNewFile();
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                view.printStackTrace();
            }
            com.cyberlink.you.utility.d.a(AboutPageActivity.c(a), "Enable Advance Debug Mode");
        }
        g.a().c();
        return true;
    }

    (AboutPageActivity aboutpageactivity)
    {
        a = aboutpageactivity;
        super();
    }
}
