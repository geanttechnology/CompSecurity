// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import com.cyberlink.you.utility.ULogUtility;
import com.cyberlink.you.utility.d;
import java.io.File;

// Referenced classes of package com.cyberlink.you.activity:
//            LogBrowserActivity

class a
    implements android.widget.ckListener
{

    final LogBrowserActivity a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        File file;
        view = new Intent("android.intent.action.VIEW");
        file = (File)adapterview.getItemAtPosition(i);
        if (a.a != com.cyberlink.you.utility.) goto _L2; else goto _L1
_L1:
        adapterview = ULogUtility.j(false);
_L3:
        adapterview = new File(adapterview, file.getName());
        d.a(file.toString(), adapterview.toString());
        MediaScannerConnection.scanFile(a.a(), new String[] {
            adapterview.toString()
        }, null, null);
        view.setDataAndType(Uri.fromFile(adapterview), "text/plain");
        a.startActivity(view);
        return;
_L2:
label0:
        {
            if (a.a != com.cyberlink.you.utility.)
            {
                break label0;
            }
            adapterview = ULogUtility.l(false);
        }
          goto _L3
label1:
        {
            if (a.a != com.cyberlink.you.utility.)
            {
                break label1;
            }
            adapterview = ULogUtility.m(false);
        }
          goto _L3
label2:
        {
            if (a.a != com.cyberlink.you.utility.)
            {
                break label2;
            }
            adapterview = ULogUtility.n(false);
        }
          goto _L3
label3:
        {
            if (a.a != com.cyberlink.you.utility.)
            {
                break label3;
            }
            adapterview = ULogUtility.o(false);
        }
          goto _L3
label4:
        {
            if (a.a != com.cyberlink.you.utility.)
            {
                break label4;
            }
            adapterview = ULogUtility.p(false);
        }
          goto _L3
label5:
        {
            if (a.a != com.cyberlink.you.utility.)
            {
                break label5;
            }
            adapterview = ULogUtility.r(false);
        }
          goto _L3
        try
        {
            adapterview = ULogUtility.k(false);
        }
        // Misplaced declaration of an exception variable
        catch (AdapterView adapterview)
        {
            if (adapterview != null)
            {
                d.a(a.a(), adapterview.toString());
                adapterview.printStackTrace();
            }
            return;
        }
          goto _L3
    }

    (LogBrowserActivity logbrowseractivity)
    {
        a = logbrowseractivity;
        super();
    }
}
