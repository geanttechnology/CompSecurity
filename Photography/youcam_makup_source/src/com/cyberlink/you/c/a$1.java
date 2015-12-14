// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.c;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.cyberlink.you.g;
import com.cyberlink.you.utility.d;
import java.io.File;

// Referenced classes of package com.cyberlink.you.c:
//            a

class a
    implements android.view..OnClickListener
{

    final a a;

    public void onClick(View view)
    {
        while (a.getActivity() == null || com.cyberlink.you.c.a.a(a)) 
        {
            return;
        }
        com.cyberlink.you.c.a.a(a, true);
        view = new Intent("android.media.action.IMAGE_CAPTURE");
        if (view.resolveActivity(a.getActivity().getPackageManager()) != null)
        {
            com.cyberlink.you.c.a.a(d.e());
            view.putExtra("output", Uri.fromFile(new File(com.cyberlink.you.c.a.a())));
            a.startActivityForResult(view, 1);
            g.a().f(true);
            com.cyberlink.you.c.a.b(a);
            return;
        } else
        {
            com.cyberlink.you.c.a.a(a, false);
            return;
        }
    }

    y.d(a a1)
    {
        a = a1;
        super();
    }
}
