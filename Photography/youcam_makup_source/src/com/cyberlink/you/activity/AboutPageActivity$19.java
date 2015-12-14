// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.view.View;
import com.cyberlink.you.d;
import com.cyberlink.you.database.MessageObj;
import com.cyberlink.you.database.f;
import com.cyberlink.you.e;
import com.cyberlink.you.g;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;

// Referenced classes of package com.cyberlink.you.activity:
//            AboutPageActivity

class a
    implements android.view.geActivity._cls19
{

    final AboutPageActivity a;

    public void onClick(View view)
    {
        view = (new StringBuilder()).append(com.cyberlink.you.utility.d.d(d.a)).append("pht.sqlite").toString();
        String s = (new StringBuilder()).append("//data//data//").append(g.l()).append("//databases//").append("pht.sqlite").toString();
        try
        {
            FileUtils.copyFile(new File(view), new File(s));
            view = e.d().a();
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
            return;
        }
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        g.a().a(view.d().getTime());
        g.a().a(view.d().getTime(), true);
        com.cyberlink.you.utility.d.a(AboutPageActivity.c(a), "[Debug] Please restart U!!!");
        return;
    }

    (AboutPageActivity aboutpageactivity)
    {
        a = aboutpageactivity;
        super();
    }
}
